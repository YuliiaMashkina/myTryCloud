Feature: As a user, I should be able to access to Files module.

  Background:
    Given  user on the login page
    When user provides valid credentials
    And user click the "Files" module

Scenario:verify users can write comments to files/folders.

  When user Click action-icon from any file on the page
  And Choose "Details" option
Then Write a comment inside to the input box
And Click the submit button to post it
Then Verify the comment is displayed in the comment section.
#(Pre-condition: there should be at least 1 file/foler is uploaded inside files page)