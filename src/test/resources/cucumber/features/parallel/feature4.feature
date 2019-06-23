@parallel
Feature: Feature 4
  Attempt to prove this form of parallel
  testing does not cause data to bleed from
  feature to feature or scenario to scenario.

  Scenario: Set variable
    When I set dynamic var to 4
    Then dynamic var should be 4

  Scenario: Set variable
    When I set dynamic var to 4
    Then dynamic var should be 4

  Scenario: Set variable
    When I set dynamic var to 4
    Then dynamic var should be 4

  Scenario: Set variable
    When I set dynamic var to 4
    Then dynamic var should be 4

  Scenario: Set variable
    When I set dynamic var to 4
    Then dynamic var should be 4

  Scenario: Set variable
    When I set dynamic var to 4
    Then dynamic var should be 4

  Scenario: Set variable
    When I set dynamic var to 4
    Then dynamic var should be 4

  Scenario: Set variable
    When I set dynamic var to 4
    Then dynamic var should be 4
