@ui
Feature: As a user, I should be able to access search any item/ users from the homepage.

  Background:
    Given  user on the login page
    When user provides valid credentials

Scenario: - Verify users can search any files/folder/users from the search box.

And Click magnifier icon on the right top
And  Search any existing file or folder or user name
Then Verify the app displays the expected result option