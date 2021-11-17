@CrealogixScenarioData
Feature: Data validation testing

  @pr1
  Scenario: Assert that the latest version of the package is the same
    Given I get the data value
    And I get the latest version
    Then I compare both values

  @pr2
  Scenario: Assert that the keywords for each package are the same
    Given I get the data value
    Then I check packages match

  @pr3
  Scenario: Print all the packages of the keywords
    Given I get the data value
    Then I extract all the keywords