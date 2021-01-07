Answer Digital Automation Testing Exercise / Instructions
Codes and Tests Prepared by:
Omer BOZDUMAN

Software Development in Test / Electrical&Electronic Engineer

omer.bozduman@yahoo.com

https://www.linkedin.com/in/omer-bozduman/

- Build Tool: Maven 
- Dependencies : WebDriverManager-bonigarcia , Cucumber J-Unit, Cucumber Java ,JavaFaker, Selenium
- Plugins : maven-cucumber-reporting , maven-surefire-plugin

- Test Framework: Cucumber BBD (with Junit Assertions)


WebPage uri :
http://automationpractice.com/index.php

browser : chrome

User Stories:

Task-1- As a user if there is an item already inside my basket, I want to be able to delete the item from
the basket page, so that I can see the basket is empty.
   
Acceptance Criteria:
● Shooping cart has Delete button
● Item is removed from basket/cart
● Banner must display "Your shopping cart is empty."

Task-2- As a user I want to select the "Summer Dresses" option from the navigation menu, so that I can 
view from the summer collection.

Acceptance Criteria:
● On mouse-hover button "WOMEN", sub navigation options will appear
● Summer items only display inside the search results

Taks-3- As a user I want to create a new account so that I can start buying items using my personal account.

Acceptance Criteria:
● Form can only accept valid informations
● Invalid information will give an error message
● Completing registration will take user take to "My Account" page
● User can see account name on top right

Task-4- As a user when browsing the "Our Stores" page, I want to drag the map to see a store from "Pembroke Pines",
so that I can take a screenshot for future reference.

Acceptance Criteria:
● User can scroll through the map
● Pembroke Pines must be within screenshot

System Requirements:
Java 8 + SDK
Test RUN

Notes: To run all Scenarios, use @answerdigital ,
to run task-1's all scenarios use @mybasket ,
to run task-1 cart is not empty scenario use @cartisnotempty, to run task-1 cart is empty scenario use @cartisempty,
to run task-2 use @summerdresses, to run task-3's all scenarios use @myaccount ,
to run task-3 positive scenario use @myaccount , @positive , to run task-3 negative scenarios use @myaccount , @negative,
to run taks-4 use @ourstores tags in the CukesRunner class/Cucumber Options.

Cucumber Test Feature Scenarios:
Task-1 : My Basket
@cartisnotempty
Scenario: Verify my basket functions
Given the user is on "My Store" homepage
When the user select 3 random product
Then the user checks the shopping cart
Then verify that shopping cart is not empty
Then the user check the shopping cart has "Delete" button
And the user remove the items from the shopping cart
Then verify banner should display "Your shopping cart is empty."

@cartisempty
Scenario: verify my basket is empty
Given the user is on "My Store" homepage
When the user checks the shopping cart
Then verify that shopping cart is empty
Then verify banner should display "Your shopping cart is empty."

Task-2 : Women page / Summer Dresses
@summerdresses
Scenario: verify summer sub module of women module
Given the user is on "My Store" homepage
When the user navigate to "Women" module
And the user navigate to "Summer Dresses" sub module
Then verify the "Summer Dresses" is displayed
And verify that "There are 3 products." is displayed

Task-3 : My Account
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
      | with invalid mobile phone |                   | mobile phone | You must register at least one phone number. 

Task-4 : Our Stores
@ourstores
Scenario: verify our stores module
Given the user is on "My Store" homepage
When the user navigate to "Our stores" page
Then verify that page subtitle is "Our store(s)!"
And the user checks the "Pembroke Pines" store is on the map
And take screenshot of "PembrokePinesStore" address

Note-1: I execute and assert my test cases by using JUnit. I use @Before tag for access the webpage and
I use @After tag close the session in Hooks class.  

Note-2: I use Scenario for positive scnarios because the positive scenarios dont need to run with different datas.
I use Scenario-Outline for one of the negative scenario because the some scenario needs to execute with several datas,
so I use Scenario-Outline and Examples(TDD) for define my test case.

Note-3: I use maven-cucumber-reporting plugin for Cucumber reports. To generate Cucumber report, execute related task's tag 
by using maven verify.
