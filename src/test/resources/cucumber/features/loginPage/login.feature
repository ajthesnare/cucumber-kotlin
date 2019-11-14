Feature: Login Page - Login
  Validate login flow

  Background:
    Given I am on the "Login" page

  Scenario: Log in with valid credentials
    When I log in
    Then the "Secure" page should display

  Scenario: Log in with invalid credentials
    When I log in:
      | username | password |
      | invalid  | invalid  |
    Then the following text should display:
      | Your username is invalid! |
