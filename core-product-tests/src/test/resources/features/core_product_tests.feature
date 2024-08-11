Feature: Core Product Test

  @smoke
  Scenario: Test 1
    Given User opens the core product url
    When User navigates to the Shop And men section
    And Searches for "Jackets"
    Then store all the results into a text file "<results.txt>"


  @smoke
  Scenario: Test 2
    Given User opens the core product url
    When User navigates to News and features
    Then Go to Each page
    And Count the total number of videos