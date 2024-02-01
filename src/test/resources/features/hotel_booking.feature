Feature: Booking.com hotels tab tests

  Background:
    Given user is in the booking.com page

#This name must be the same as the tags in the CukesRunner class
  @smokeTests
  Scenario: As a user i should be able to book a hotel room and see successful checkout page
    And types New York in the search bar
    And chooses next month's 8'th day to 10'th day
    And chooses one adult
    And clicks search hotels button
    When user navigated to hotel search page
    And user chooses first hotel
    And in the mentioned hotel's description page user clicks reserve or book now
    And user sees checkout process' first page
    And user selects the work selection
    And user fills first name, last name, email fields
    And user selects the Who are you booking for
    And  user click to the next page button
    And in the final details page user fills phone number, card holders name, card number, cvc afterwards clicks complete booking button
    Then user should see checkout dialogue and click close button properly
    And verify user sees booking.com homepage
  @functionalityTests
  Scenario: User should see no hotel duplicate
    And clicks search hotels button
    When user navigated to hotel search page
    And automation collects all hotel names by passing through pages
    Then an assertion is made to check whether there are any duplicate
  @brandNewTest
  Scenario: user clicks hotel brand checkboxes should see only mentioned brand
    When clicks search hotels button
    And user clicks a random brand name button
    And clicks search button
    Then user should see only same brand hotels as the checkbox

  @QuickAndEasyTripPlannerTest
  Scenario: user should see the numbers of Hotels,Resorts,Luxery and Cabins in Stays Page
    And automation collects the numbers of Hotels Resorts Luxery and Cabins and Checks the numbers validation
    And click to the Hotels cabins tab
    When user navigated to hotel search page
    Then user should see the Cabin Hotels in new page

  @ValidationOfAdultField
  Scenario: Validate that the user can make booking for one room for twenty person
    And types New York in the search bar
    And chooses next month's 8'th day to 10'th day
    And choose the adult option for twenty times
    And clicks search hotels button
    When user navigated to hotel search page
    And user chooses first hotel