@ui
Feature:  As a user, I should be able to access to Contacts module.

  Background:
    Given  user on the login page
    When user provides valid credentials
    And user click the "Contacts" module

Scenario: - verify users can see all the contact names on the contact list
Then Verify the contact names are in the list
#(Pre-condition: there should be at least 2 contact names are displayed On the contact list)