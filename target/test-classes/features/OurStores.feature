@answerdigital
Feature: Our Stores Module

  @ourstores
  Scenario: verify our stores module
    Given the user is on "My Store" homepage
    When the user navigate to "Our stores" page
    Then verify that page subtitle is "Our store(s)!"
    And the user checks the "Pembroke Pines" store is on the map
    And take screenshot of "PembrokePinesStore" address
