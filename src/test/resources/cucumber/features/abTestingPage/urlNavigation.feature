Feature: A/B Testing Page - Url Navigation
  Navigate to the A/B Testing Page via url

  Scenario: Navigate to the "A/B Testing" page via url
    When I navigate to "/abtest"
    Then the "A/B Testing" page should display
