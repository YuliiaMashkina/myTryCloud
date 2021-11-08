@ui
Feature: As a user, I should be access all the main modules of the app

  Scenario: verify that users can access to the main modules

  Given  user on the login page
    When user provides valid credentials
  Then Verify the user see the following modules:
    | Dashboard |
    | Files     |
    | Photos    |
    | Activity  |
    | Talk      |
    | Contacts  |
    | Circles   |
    | Calendar  |
    | Desk      |