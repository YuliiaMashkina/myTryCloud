@ui
Feature: As a user, I should be able to access to Talks module.

  Background:
    Given  user on the login page
    When user provides valid credentials
    And user click the "Talk" module

Scenario: - verify users can access to Talks module
  Then verify the page tile is "Talk - Trycloud QA"

Scenario: - verify users can send message

And Search a user from search box on the left
Then Write a message
And Click submit button
Then Verify the message is displayed on the conversation log