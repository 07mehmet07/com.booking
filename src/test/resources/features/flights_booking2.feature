@flight-booking
Feature: Verification Flight booking process

  Background:
    Given the user is on the Inar Academy homepage and clicks on the Booking link

  Scenario Outline: This Test Case  validates  the functionality of flight booking  process.

    When the user clicks on the flights tab
    When the user clicks on the "Round Way" radio
    And the user selects "<departure country>" as departure country
    And the user selects "<destination caountry>" as destination country
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

    When the user on the flights page
    And the user clicks on the round trip radio
    And the user clicks on business class
    And the user selects "<departure country>" as departure country
    And the user selects "<destination country>" as destination country
    And the user selects departure date as 02-07-2024 and return date as 02-13-2024
    And the user selects 2 adults and 1 child
    And the user clicks on the search flights button
    And the user clicks on the cheapest tab
    And the user selects the cheapest ticket
    And the user selects the cheapest return ticket
    And the user selects Refundable Main option for both ways
    And the user clicks on Select Who's Flying button
    And the user enters "<Contact Email>" to Contact Email input area
    And the user enters "<Phone Number>" to Phone Number input area
    And the user enters First Name and Last Name for first Traveler
    And the user selects male as gender
    And the user enter birthdate as "2002" year and "10" month and "11" day
    And the user enters First Name and Last Name for second Traveler
    And the user selects female as gender
    And the user enter birthdate as "2001" year and "10" month and "11" day
    And the user enters First Name and Last Name for third Traveler
    And the user selects male as gender
    And the user enter birthdate as "2020" year and "10" month and "11" day
    And The user clicks on select extras button
    And the user select Standart Meal $15 from the select meal dropdown menu
    And the user select Add Extra Legroom Seat for extra
    And The user click on go to checkout button
    And The user enter "<Card Holder's Name>" as cardholder's name
    And The user enter "1234567891234567" as card number
    And The user enter "12/25" as expiration date
    And The user enter "123" as cvv code
    And The user clicks on complete booking button
    Then verify "<Message Text>" text message that under Thank you for your booking message
    And The user clicks on close button
    Examples:
      | departure country | destination country | Contact Email     | Phone Number | Card Holder's Name | Message Text |
      |USA                |Germany              |dsfad@gmail.com    |5413816363    |Fatih Satan         |dsfad@gmail.com|
      |Japan              |Italy                |ddfshdfhd@gmail.com|5413815463    |Mehmet Aykut        |ddfshdfhd@gmail.com|
      |China              |France               |testtest@gmail.com |5413811144    |Besim Ka            |testtest@gmail.com |
      |USA                |Italy                |tete@gmail.com     |5332543214    |Sefa At             |tete@gmail.com     |