Feature: As a user, I should be able to access to Files module.

  Background:
    Given  user on the login page
    When user provides valid credentials
    And user click the "Files" module

Scenario:  verify users can change the app Settings.

When Click "Settings" button on the left bottom corner
Then Verify user can click any buttons.


Scenario: verify users see the app storage usage

When Check the current storage usage
  And Click the “+” icon on top
  Then Click an "Upload file"
Then Refresh the page
Then Verify the storage usage is increased