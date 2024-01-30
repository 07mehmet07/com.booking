Feature: Displays a sample feature file
#
#  Background:
#    Given I navigate to the baseURL
#    And I click on the Booking Link

#This name must be the same as the tags in the CukesRunner class
  @smokeTests
  Scenario: As a user i should be able to book a hotel room and see successful checkout page
    Given user is in the booking.com page
    And types New York in the search bar
    And chooses next month’s #8 day to #10 day
    And chooses one adult
    And clicks search hotels button
    When user navigated to hotel search page
    And user chooses first hotel
    And in the mentioned hotel’s description page user clicks reserve or book now
    And user sees checkout process’ first page
    And user fills first name, last name, email fields and clicks Next Final Details Button
    And in the final details page user fills phone number, card holders name, card number, cvc afterwards clicks complete booking button
    Then user should see checkout dialogue and click close button properly
    And verify user sees booking.com homepage
