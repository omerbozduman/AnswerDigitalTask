@answerdigital
Feature: Women Module

  @summerdresses
  Scenario: verify summer sub module of women module
    Given the user is on "My Store" homepage
    When the user navigate to "Women" module
    And the user navigate to "Summer Dresses" sub module
    Then verify the "Summer Dresses" is displayed
    And verify that "There are 3 products." is displayed
