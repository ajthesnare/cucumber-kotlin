Feature: Login Page - Login

  Scenario: Login
    Given I am on the "Login" page
    When I log in
    Then I am on the "Secure" page
