@mybasket @answerdigital
Feature: My Basket

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

