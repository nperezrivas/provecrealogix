@CrealogixScenario
Feature: Appium test Crealogix Technical prove

 @prove0
 Scenario: Offer search by map with 50km proximity
  Given I am in the "Login" screen
  When I tap on the offers menu
  Then I select the tab offers
  And I Set search on the map
  Then I set the proximity on 50km


  @prove1
  Scenario Outline: Set the language "<language2>"
    Given I am in the "Login" screen
    And I have "<language1>" language selected
    When I click on Language button
    Then I should see Language correctly for "<language2>"
    Examples:
      | language1| language2 |
      | English | Arabic     |
      | Arabic | English     |