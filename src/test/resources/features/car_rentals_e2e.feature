@endToEndTests
Feature: Verify that all processes of the car rental pages function properly.
  As a user, I want to enter all the required information correctly so that I can rent a car.

  Scenario: Verify Booking Car Rentals Functions End to End.
    Given the user navigates to the inarbooking Home Page
    When the user clicks on the Car rentals tab
    Then the user should see the welcome heading message
    When the user enters Pickup Location as "Heathrow Airport"
    And the user enters Pickup Date as "03/07/2034"
    And the user enters Drop-off Date as "09/10/2038"
    And the user clicks on the Search Cars button
    Then the user confirms the accuracy of the information of Pickup Location as "Heathrow Airport" and Dates
    When the user selects the size of the car as "large"
    And the user clicks on the Search button
    And the user clicks on the view deal button belonging to the car shown at the top
    Then the user validates the size of the car as "large" which is selected at the previous page
    When the user clicks on the Go to book button
    And the user enters First Name as "Inar"
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


