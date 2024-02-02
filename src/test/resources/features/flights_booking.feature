@example
Feature: Verification Flight booking process

  Background:
    Given the user is on the Inar Academy homepage and clicks on the Booking link

  @mehmet
  Scenario: This Test Case  validates  the functionality of flight booking  process.
    When the user clicks on the flights tab
    When the user clicks on the "One Way" radio
    And the user selects "USA" as departure country
    And the user selects "United Kingdom" as destination country
    And the user selects "21-02-2024" for date
    And the user clicks on the search flights button


    And the user clicks on the "Fastest" tab on filtering page
    And the user click on #1 see availability button of the fastest flight

    And the user select "Main" tab and click on Select Who ‘ s flying


    And the user enter "Inar@gmail.com" to the contact email input area
    And the user enters phone number as "1234567890"
    And the user enters as "Inar" first name and as "Academy" last name for #1 passenger
    And the user select "Male" as gender for #1 passenger
    And the user select birthdate as "2000-12-12" for #1 passenger
    And the user clicks on select extras button

    And the user select "Vegan Meal - $14" from the select meal dropdown menu
    And the user select Add Extra Legroom Seat for extra
    And The user click on go to checkout button


    And The user enter "Inar Academy" as cardholder's name
    And The user enter "1234567891234567" as card number
    And The user enter "12/25" as expiration date
    And The user enter "123" as cvv code
    And The user clicks on complete booking button
    Then verify "Inar@gmail.com" text message that under Thank you for your booking message
    And The user clicks on close button
#

#






