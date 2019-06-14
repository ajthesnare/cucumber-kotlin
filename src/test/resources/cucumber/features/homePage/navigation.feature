Feature: Home Page - Navigation
  Click the links on the homepage to navigate
  throughout the website.

  Scenario Outline: Navigate to the <page> page
    Given I am on the home page
    When I click the "<page>" link
    Then the "<page>" page should display
    Examples:
      | page                |
      | A/B Testing         |
      | Add/Remove Elements |
