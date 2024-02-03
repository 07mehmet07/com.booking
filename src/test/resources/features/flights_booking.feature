@flight
Feature: Verification Flight booking process

  Background:
    Given the user is on the Inar Academy homepage and clicks on the Booking link

  @smokeTest
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
    And the user select birthdate as "2000.12.12" for #1 passenger
    And the user clicks on select extras button
    And the user select Add Extra Legroom Seat for extra
    And The user click on go to checkout button
    And The user enter "Inar Academy" as cardholder's name
    And The user enter "1234567891234567" as card number
    And The user enter "12/25" as expiration date
    And The user enter "123" as cvv code
    And The user clicks on complete booking button
    Then verify "Inar@gmail.com" text message that under Thank you for your booking message
    And The user clicks on close button


  @functionalityTests
  Scenario: This test Case verify that adults and children numbers are 26 adult and 12 children as expected
    When the user clicks on the flights tab
    When the user clicks on the "Round Trip" radio
    And the user selects "Business" flight class
    And the user selects "France" as departure country
    And the user selects "China" as destination country
    And The user selects #2 as departure date and #12 as return date
    And the user select #26 adults and #12 children
    And the user clicks on the search flights button
    Then verify that adults and children numbers are "26" adult and "12" children as expected


  @functionalityTests
  Scenario: This test Case verify that all the return tickets dates are 12 February 2024
    When the user clicks on the flights tab
    When the user clicks on the "Round Trip" radio
    And the user selects "First Class" flight class
    And the user selects "USA" as departure country
    And the user selects "China" as destination country
    And The user selects #2 as departure date and #12 as return date
    And the user select #2 adults and #2 children
    And the user clicks on the search flights button
    And the user click on #1 see availability button of the fastest flight
    Then verify that all the return tickets dates are "12" February


  @functionalityTests
  Scenario: This test Case Verify that total price is correct
    When the user clicks on the flights tab
    When the user clicks on the "Round Trip" radio
    And the user selects "Economy" flight class
    And the user selects "Canada" as departure country
    And the user selects "Germany" as destination country
    And The user selects #7 as departure date and #17 as return date
    And the user select #3 adults and #3 children
    And the user clicks on the search flights button
    Then Verify that origin main "Canada" as expected


  @functionalityTests
  Scenario: This Test Case  validates  the functionality of flight booking  process.
    When the user clicks on the flights tab
    When the user clicks on the "Round Trip" radio
    And the user selects "France" as departure country
    And the user selects "China" as destination country
    And The user selects #6 as departure date and #10 as return date
    And the user clicks on the search flights button
    Then verify that all the tickets dates are "06"


  @functionalityTests
  Scenario: This Test Case  validates  the functionality of flight booking  process.
    When the user clicks on the flights tab
    When the user clicks on the "Round Trip" radio
    And the user selects "Business" flight class
    And the user selects "France" as departure country
    And the user selects "China" as destination country
    And The user selects #6 as departure date and #10 as return date
    And the user clicks on the search flights button
    Then verify that all the tickets types are "Business"