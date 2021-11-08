@ui
Feature: As a user, I should be able to login.Scenario Outline: Login with valid credentials

  Background:
  Given user on the login page

  Scenario Outline: Login with valid credentials

    When user use username "<username>" and passcode "<password>"
    And user click login button
    Then user should be at dashboard page
    Examples:
      | username | password    |
      | user7    | Userpass123 |
      | user34   | Userpass123 |
      | user99   | Userpass123 |


  Scenario: verify user login fail with invalid credentials

    When user enter invalid credentials
    And user click login button
    Then "<Wrong username or password.>" message should be displayed