Feature: Car Rentals Smoke Test
  Background:
    Given the user navigates to the inarbooking Home Page
    When the user clicks on the Car rentals tab
  @smokeTest
  Scenario: Verify that a user can get through all Car Rentals pages smoothly
    Then the user should see the welcome heading message
    When the user clicks on the Search Cars button
    Then the user confirms the accuracy of the information entered
    When the user clicks on the View Deal button of the Selected Car
    Then the user navigates to the dealing page
    When the user clicks on the Go to Book button which is at the bottom
    Then the user validates whether at the Car Rentals Checkout Page