Feature: Core Product Test

  @smoke
  Scenario: Test 1
    Given User opens the core product url
    When User navigates to the Shop And men section
    And Searches for "Jackets"
    Then store all the results into a text file


  @smoke
  Scenario: Test 2
    Given User opens the core product url
    When User navigates to News and features
    Then Count the total number of feeds in page
    And Count the feeds older than 3 days