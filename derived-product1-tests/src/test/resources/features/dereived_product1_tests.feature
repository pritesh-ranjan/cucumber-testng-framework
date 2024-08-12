Feature: Derived 1 product tests

  @smoke
  Scenario: Test 1
    Given User opens dp home page
    When user validates the page has loaded
    Then count the number of slides
    And Count how much duration each slide is playing and validate with the expected duration of 11 seconds