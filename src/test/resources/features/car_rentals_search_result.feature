Feature: Car Rental

  Scenario: Searching a large car in Great Wall of China
    Given a user is on the inarbooking homepage
    And user navigate to the car rentals section
    When types Great Wall of China in the pickup location
    And clicks search cars button
    And user navigated to car search page
    And user choose large size
    And clicks search button
    Then The user should see the Great Wall of China as the pickup location and cars that are large in size.

  Scenario: The rental price of an insured car is being investigated
    Given a user is on the inarbooking homepage
    And user navigate to the car rentals section
    When types Grand Bazaar in the pickup location
    And clicks search cars button
    And user navigated to car search page
    And user choose minivan size
    And clicks search button
    And click on the view deal button in first car shown in the list
    And user navigated to car dealing page
    And clicks What is covered button
    Then verify that the total price is correct

  Scenario: Searching for a rental car for the desired dates
    Given a user is on the inarbooking homepage
    And user navigate to the car rentals section
    When types Golden Gate Bridge in the pickup location
    And enter a pickup date of 30/01/2024
    And enter a dropoff date of 31/01/2024
    And clicks search cars button
    And user navigated to car search page
    And user choose all size
    And clicks search button
    And click on the view deal button in first car shown in the list
    When verify pickup and dropoff information