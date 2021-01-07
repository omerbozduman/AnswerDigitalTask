@answerdigital
Feature: My Account Module

  @myaccount @positive
  Scenario: verify my account page with valid creditials
    Given the user is on "My Store" homepage
    When the user navigate to "My account" page
    Then verify that page subtitle is "Authentication"
    And the user click the create an account button with valid email address
    Then the user fills the form with valid personal information
    And the user clicks the register button
    Then verify that page subtitle is "My account"
    And the user should see account name on top right


  @myaccount @negative
  Scenario: verify my account page create an account module with invalid email address
    Given the user is on "My Store" homepage
    When the user navigate to "My account" page
    Then verify that page subtitle is "Authentication"
    And the user click the create an account button with invalid email address
    |answerdigital.com|
    Then verify error message is "Invalid email address."


  @myaccount @negative
  Scenario Outline: verify my account page registration form  <type>
    Given the user is on "My Store" homepage
    When the user navigate to "My account" page
    Then verify that page subtitle is "Authentication"
    And the user click the create an account button with valid email address
    And the user fills the form with "<data>" and "<field>"
    And the user clicks the register button
    Then verify that related "<error message>" is displayed


    Examples:
      | type                      | data              | field        | error message                                                                     |
      | with invalid first name   | Tom12             | first name   | firstname is invalid.                                                             |
      | with invalid first name   |                   | first name   | firstname is required.                                                            |
      | with invalid first name   | Tom_+1            | first name   | firstname is invalid.                                                             |
      | with invalid last name    | Jackson12         | last name    | lastname is invalid.                                                              |
      | with invalid last name    |                   | last name    | lastname is required.                                                             |
      | with invalid last name    | __Jackson_@££$@£$ | last name    | lastname is invalid.                                                              |
      | with invalid password     |                   | password     | passwd is required.                                                               |
      | with invalid password     | 123_              | password     | passwd is invalid.                                                                |
      | with invalid address      |                   | address      | address1 is required.                                                             |
      | with invalid address      | {}{1234&&&^street | address      | address1 is invalid.                                                              |
      | with invalid city         |                   | city         | city is required.                                                                 |
      | with invalid city         | 12%^%             | city         | city is invalid.                                                                  |
      | with invalid state        |                   | state        | This country requires you to choose a State.                                      |
      | with invalid postcode     |                   | postcode     | The Zip/Postal code you've entered is invalid. It must follow this format: 00000 |
      | with invalid postcode     | M14 5TK           | postcode     | The Zip/Postal code you've entered is invalid. It must follow this format: 00000  |
      | with invalid mobile phone | _+123456          | mobile phone | phone_mobile is invalid.                                                                 |
      | with invalid mobile phone |                   | mobile phone | You must register at least one phone number.                                                               |
