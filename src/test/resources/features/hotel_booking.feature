Feature: Booking.com hotels tab tests

  Background:
    Given user is in the booking.com page

#This name must be the same as the tags in the CukesRunner class
  @smokeTest @endToEndTests
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
    And in the final details page user selects US and fill the phone number
    And user change selection to Fr
    Then user shows the invalid phone number message

  @functionalityTests
  Scenario: User should see no hotel duplicate
    And clicks search hotels button
    When user navigated to hotel search page
    And automation collects all hotel names by passing through pages
    Then an assertion is made to check whether there are any duplicate

  @functionalityTests
  Scenario: user clicks hotel brand checkboxes should see only mentioned brand
    When clicks search hotels button
    And user clicks a random brand name button
    And clicks search button
    Then user should see only same brand hotels as the checkbox

  @functionalityTests
  Scenario: user should see the numbers of Hotels,Resorts,Luxery and Cabins in Stays Page
    And automation collects the numbers of Hotels Resorts Luxery and Cabins and Checks the numbers validation
    And click to the Hotels cabins tab
    When user navigated to hotel search page
    Then user should see the Cabin Hotels in new page

  @functionalityTests
  Scenario: Validate that the user can make booking for one room for twenty person
    And types New York in the search bar
    And chooses next month's 8'th day to 10'th day
    And choose the adult option for twenty times
    And clicks search hotels button
    When user navigated to hotel search page
    And user chooses first hotel

  @functionalityTests
  Scenario: user try to reach the Hotels from Offer part of HomePage
    And user click to the find a stay button
    Then user have to reach Offering hotels

  @functionalityTests
  Scenario: User tries min price function
    And clicks search hotels button
    And user increase min price to fifty dollars
    When clicks search button
    Then user should see only hotels with min fifty dollars price

  @functionalityTests
  Scenario: User tries max price function
    And clicks search hotels button
    And user increase max price to fifty dollars
    When clicks search button
    Then user should see only hotels with max fifty dollars price

  @functionalityTests
  Scenario:Validation of searchBox field
    And types numbers in the search bar
    And chooses next month's 8'th day to 10'th day
    And chooses one adult
    And clicks search hotels button
    When user navigated to hotel search page

  @functionalityTests
  Scenario Outline: User tries invalid credentials
    And types <city> in the search bar
    And chooses next month's 8'th day to 10'th day
    And chooses one adult
    And clicks search hotels button
    When user navigated to hotel search page
    And user chooses first hotel
    And in the mentioned hotel's description page user clicks reserve or book now
    And user sees checkout process' first page
    And user selects the work selection
    And user fills <first name>, <last name>, <email> fields
    And user selects the Who are you booking for
    And  user click to the next page button
    And in the final details page user fills <phone number>, <card holders name>, <card number>, <cvc> afterwards clicks complete booking button
    Then user should not see checkout dialogue and so will not be able to click close button properly
    Examples:
      | city       | first name | last name | email            | phone number | card holders name | card number        | cvc   |
      | "New York" | "123"      | "Comeon"  | "nana@gmail.com" | "5555551234" | "Nana Comeon"     | "1234123412341234" | "123" |
      | "Istanbul" | "Nana"     | "123"     | "nana@gmail.com" | "5555551234" | "Nana Comeon"     | "1234123412341234" | "123" |
      | "New York" | "Nana"     | "Comeon"  | "nananacmon.com" | "5555551234" | "Nana Comeon"     | "1234123412341234" | "123" |
      | "Istanbul" | "Nana"     | "Comeon"  | "nana@gmail.com" | "5551234"    | "Nana Comeon"     | "1234123412341234" | "123" |
      | "New York" | "Nana"     | "Comeon"  | "nana@gmail.com" | "5555551234" | "123"             | "1234123412341234" | "123" |
      | "Istanbul" | "Nana"     | "Comeon"  | "nana@gmail.com" | "5555551234" | "Nana Comeon"     | "123412341234"     | "123" |
      | "New York" | "Nana"     | "Comeon"  | "nana@gmail.com" | "5555551234" | "Nana Comeon"     | "1234123412341234" | "23"  |
      | "Istanbul" | "*?\&"     | "Comeon"  | "nana@gmail.com" | "5555551234" | "Nana Comeon"     | "1234123412341234" | "123" |
      | "New York" | "Nana"     | "*?\&"    | "nana@gmail.com" | "5555551234" | "Nana Comeon"     | "1234123412341234" | "123" |
      | "Istanbul" | "Nana"     | "Comeon"  | "*\}@[].com"     | "5555551234" | "Nana Comeon"     | "1234123412341234" | "123" |
      | "New York" | "Nana"     | "Comeon"  | "nana@gmail.com" | "&%+%&/"     | "Nana Comeon"     | "1234123412341234" | "123" |
      | "Istanbul" | "Nana"     | "Comeon"  | "nana@gmail.com" | "5555551234" | "+%&/()"          | "1234123412341234" | "123" |
      | "New York" | "Nana"     | "Comeon"  | "nana@gmail.com" | "5555551234" | "Nana Comeon"     | "1234123412341234" | "123" |