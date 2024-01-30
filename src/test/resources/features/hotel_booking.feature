@smokeTests
Feature: Displays a sample feature file
#
#  Background:
#    Given I navigate to the baseURL
#    And I click on the Booking Link

#This name must be the same as the tags in the CukesRunner class
  Scenario: As a user i should be able to book a hotel room and see successful checkout page
    Given user is in the booking.com page
    And types New York in the search bar
    And chooses next month’s 8'th day to 10'th day
    And chooses one adult
    And clicks search hotels button
    When user navigated to hotel search page
    And user chooses first hotel
    And in the mentioned hotel’s description page user clicks reserve or book now
    And user sees checkout process’ first page
    And user selects the work selection
    And user fills first name, last name, email fields
    And user selects the Who are you booking for
    And  user click to the next page button
    And in the final details page user fills phone number, card holders name, card number, cvc afterwards clicks complete booking button
    Then user should see checkout dialogue and click close button properly
    And verify user sees booking.com homepage
