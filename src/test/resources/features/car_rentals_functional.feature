Feature: Car Rentals Functional Test
  As a user, I want to enter all the required information correctly so that I can rent a car.

  Background:
    Given the user navigates to the inarbooking Home Page
    When the user clicks on the Car rentals tab

  @functional
  Scenario: Validate whether the selected options admitted correctly.
    When the user enters Pickup Location as "Golden Gate Bridge"
    And the user enters Pickup Date as "03/08/2029"
    And the user enters Drop-off Date as "01/01/2035"
    And the user enters Pickup Hour as "03:00" and Drop Hour as "04:00"
    And the user clicks the Search Cars button
    Then the user confirms the accuracy of the information entered

  @functional
  Scenario: Searching a large car in Great Wall of China.
    When types "Great Wall of China" in the pickup location
    And the user clicks the Search Cars button
    Then the user confirms the accuracy of the information entered
    When the user selects the size of the car as "large"
    And clicks search button
    Then the user should see the "Great Wall of China" as the pickup location

  @functional
  Scenario: The rental price of an insured car is being investigated.
    When types "Grand Bazaar" in the pickup location
    And the user clicks the Search Cars button
    And the user selects the size of the car as "minivan"
    And clicks search button
    And the user clicks on the view deal button belonging to the car shown at the top
    Then the user navigates to the dealing page
    When clicks What is covered button
    Then verify that the total price is correct


  @functional
  Scenario: Validate the information that is related to what we have chosen on previous pages.
    When the user clicks on the Search Cars button
    And the user clicks on the View Deal button of the Selected Car
    And the user clicks on the Go to book button
    Then the user should see the Trade of car is correct as "Volkswagen Polo or similar small car"
    And the user should see the location of Pickup and Drop-off is correct as "United Kingdom - Heathrow Airport"

  @functional
  Scenario: Validate that the back button which is located on the Checkout Page moves the user to the previous page.
    When the user clicks on the Search Cars button
    And the user clicks on the View Deal button of the Selected Car
    And the user clicks on the Go to book button
    And the user enters the Card Credentials as "Tod Dot", "1231231231231236", "04/28", "4421"
    And the user clicks on the back button
    Then the user navigates to the previous page

  @functional
  Scenario: Validate that the violation message is displayed when the user enters invalid card number into the related input field.
    When the user clicks on the Search Cars button
    And the user clicks on the View Deal button of the Selected Car
    And the user clicks on the Go to book button
    And the user enters the Card Credentials as "Tod Dot", "Invalid Card Number", "04/28", "4421"
    Then the user should see the violation message at the bottom of the box
