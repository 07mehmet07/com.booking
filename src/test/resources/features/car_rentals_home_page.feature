@smokeTests1
Feature: Verify that Car Rentals Home Page functions properly.
  As a user, I want to enter all the required information correctly so that I can rent a car.

  Background:
    Given the user navigates to the inarbooking Home Page
    When the user clicks on the Car rentals tab

  Scenario: Validate whether the user navigates to the Car Rentals Home Page.
    Then the user should see the welcome heading message

  Scenario: Validate whether the selected options admitted correctly.
    When the user enters Pickup Location as "Golden Gate Bridge"
    And the user enters Pickup Date as "2025-08-03"
    And the user enters Drop-off Date as "2025-10-18"
#    And the user enters Pickup Hour as "03:30" and Drop Hour as "05:00"
    And the user clicks the Search Cars button
    Then the user confirms the accuracy of the information entered


  Scenario: Searching a large car in Great Wall of China
    When types "Great Wall of China" in the pickup location
    And clicks search cars button
    Then user navigated to car search page
    When user choose "large" size
    And clicks search button
    Then The user should see the "Great Wall of China" as the pickup location and cars that are "large" in size.

  Scenario: The rental price of an insured car is being investigated
    When types "Grand Bazaar" in the pickup location
    And clicks search cars button
    And user choose "minivan" size
    And clicks search button
    And click on the view deal button in first car shown in the list
    Then user navigated to car dealing page
    When clicks What is covered button
    Then verify that the total price is correct