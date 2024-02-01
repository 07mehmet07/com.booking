@smokeTests2
Feature: Verify that Car Rentals Checkout Page functions properly.
  As a user, I want to enter all the required information correctly so that I can rent a car.

  Background:
    Given the user navigates to the inarbooking Home Page
    When the user clicks on the Car rentals tab
    And the user clicks on the Search Cars button
    And the user clicks on the View Deal button of the Selected Car
    And the user clicks on the Go to book button

  Scenario: Validate the information that is related to what we have chosen on previous pages.
    Then the user should see the Trade of car is correct as "Volkswagen Polo or similar small car"
    And the user should see the location of Pickup and Drop-off is correct as "United Kingdom - Heathrow Airport"

  @smokeTests3
  Scenario: Validate the user navigates the payment page after enters information for Billing Address and Card Credentials.
    When the user enters First Name as "Inar"
    And the user enters Last Name as "Academy"
    And the user enters Code of Phone Number as "UK"
    And the user enters Phone Number as "555 444 22 33"
    And the user enters Country as "Cibuti"
    And the user enters Address as "aaa ccc ddd sss"
    And the user enters City as "Kyoto"
    And the user enters Postal Code as "66781"
    And the user selects whether this booking is for a business
    And the user enters Cardholder's Name as "Holder"
    And the user enters Card Number as "1234567891471231"
    And the user enters Expiration Date as "12/34"
    And the user enters CVV (CVC) Code as "333"
    And the user selects to get emails from Booking.com
    And the user selects to get emails from Booking Transport Limited
    And the user click on the Book Now button
    Then the user validate confirmation message with correct user name as "Inar Academy"