Feature: Home Page - Navigation
  Click the links on the homepage to navigate
  throughout the website.

  Scenario Outline: Navigate to the <page> page
    Given I am on the home page
    When I click the "<link>" link
    Then the "<page>" page should display
    Examples:
      | link                 | page                |
      | abtest               | A/B Testing         |
      | add_remove_elements/ | Add/Remove Elements |
