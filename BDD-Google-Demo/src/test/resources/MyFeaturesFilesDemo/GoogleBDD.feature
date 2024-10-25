#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@Google
Feature: Google Search
  I want to use this template for my feature file

  #@GoogleSearch
  #Scenario: Search on Google
  #Given Google HomePage is Open
  #When I Type SearchKey
  #And Click GoogleSearch
  #Then SearchPage Opens
  #Then I click on FirstSuggested Link
  @GoogleSearch
  Scenario Outline: Search Tool on Google
    Given Google HomePage is Open
    When I Type SearchKey as "<SearchKey>"
    And Click GoogleSearch
    Then I click on FirstSuggested Link
    Then SearchPage Opens with expURL "<ExpURL>"
    And print the pageTitle

    Examples: 
      | SearchKey    | ExpURL       |
      | Selenium     | selenium     |
      | TestComplete | testcomplete |
      | jMeter       | jmeter       |