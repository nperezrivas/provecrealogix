@CrealogixScenarioData
Feature: Data validation testing

  @Extra1
  Scenario: Assert that the latest version of the package is the same
    Given I get the data value
    And I get the latest version
    Then I compare both values