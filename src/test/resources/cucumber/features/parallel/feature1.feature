@parallel
Feature: Feature 1
  Attempt to prove this form of parallel
  testing does not cause data to bleed
  from scenario to scenario.

  Scenario: Set variable
    When I set dynamic var to 1
    Then dynamic var should be 1

  Scenario: Set variable
    When I set dynamic var to 1
    Then dynamic var should be 1

  Scenario: Set variable
    When I set dynamic var to 1
    Then dynamic var should be 1

  Scenario: Set variable
    When I set dynamic var to 1
    Then dynamic var should be 1

  Scenario: Set variable
    When I set dynamic var to 1
    Then dynamic var should be 1

  Scenario: Set variable
    When I set dynamic var to 1
    Then dynamic var should be 1

  Scenario: Set variable
    When I set dynamic var to 1
    Then dynamic var should be 1

  Scenario: Set variable
    When I set dynamic var to 1
    Then dynamic var should be 1
