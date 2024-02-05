@endToEndTests @all
Feature: Verification Flight booking process as end to end test

  Background:
    Given the user is on the Inar Academy homepage and clicks on the Booking link

  Scenario Outline: This Test Case validates the functionality of flight booking  process.

    When the user clicks on the flights tab
    When the user clicks on the "Round Trip" radio
    And the user selects "Business" flight class
    And the user selects "<departure country>" as departure country
    And the user selects "<destination country>" as destination country
    And The user selects #5 as departure date and #15 as return date
    And the user clicks on the search flights button
    And the user clicks on the "Fastest" tab on filtering page
    And the user click on #1 see availability button of the fastest flight
    And the user click on #2 select return ticket button of the fastest flight
    And the user select "Main" tab and click on Select Who ‘ s flying
    And the user enter "<email>" to the contact email input area
    And the user enters phone number as "<phone number>"
    And the user enters as "Inar" first name and as "Academy" last name for #1 passenger
    And the user select "Male" as gender for #1 passenger
    And the user select birthdate as "1990.12.12" for #1 passenger
    And the user clicks on select extras button
    And the user select Add Extra Legroom Seat for extra
    And The user click on go to checkout button
    And The user enter "<cardholder name>" as cardholder's name
    And The user enter "1234567891234567" as card number
    And The user enter "12/27" as expiration date
    And The user enter "234" as cvv code
    And The user clicks on complete booking button
    Then verify "<email test>" text message that under Thank you for your booking message
    And The user clicks on close button
    Examples:
      | departure country | destination country | email           | phone number | cardholder name | email test      |
      | USA               | Italy               | 123@gmail.com   | 0542789974   | besimkara       | 123@gmail.com   |
      | France            | United Kingdom      | 1233@gmail.com  | 0542788974   | sefa            | 1233@gmail.com  |
      | Germany           | Spain               | 1235@gmail.com  | 0542781974   | emre            | 1235@gmail.com  |
      | China             | USA                 | 12351@gmail.com | 0542784974   | selcuk          | 12351@gmail.com |


