@flight-booking
Feature: Verification Flight booking process

  Background:
    Given the user is on the Inar Academy homepage
    And clicks on the Booking link

  Scenario Outline: This Test Case  validates  the functionality of flight booking  process.

    Given the user on the flights page
    When the user clicks on the round way radio
    And the user selects "<departure country>" as departure country
    And the user selects "<destination country>" as destination country
    And the user selects departure date as "<departure date>" and return date as "<destination date>"
    And the user clicks on the search flights button
    And the user clicks on the cheapest tab


Examples:

    When the user clicks on the one way radio
    And the user selects "USA" as departure country
    And the user selects "United Kingdom" as destination country
    And the user selects 01-02-2024 for date
    And the user clicks on the search flights button
    And the user clicks on the fastest tab
    And the user click on first see availability button of the fastest flight
    And the user select main tab and click on Select Who ‘ s flying
    And the user enter Inar@gmail.com to the contact email input area
    And the user enters as "Inar" first name and as "Academy" last name
    And the user select male as gender
    And the user select birthdate as "2000" year and "10" month and "11" day
    And The user clicks on select extras button
    And the user select Vegan Meal $14 from the select meal dropdown menu
    And the user select Add Extra Legroom Seat for extra
    And The user click on go to checkout button
    And The user enter "Inar Academy" as cardholder's name
    And The user enter "1234567891234567" as card number
    And The user enter "12/25" as expiration date
    And The user enter "123" as cvv code
    And The user clicks on complete booking button
    Then verify "Inar@gmail.com" text message that under Thank you for your booking message
    And The user clicks on close button

