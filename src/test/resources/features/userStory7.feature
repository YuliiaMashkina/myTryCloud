@ui7 @ui
Feature: As a user, I should be able to access to Files module.

  Background:
    Given  user on the login page
    When user provides valid credentials
    And user click the "Files" module

Scenario: verify users can delete a file/folder.

  And user Click action-icon from any file on the page
  And Choose "Delete" option
  And Click "Deleted files" on the left bottom corner
  Then Verify the deleted file is displayed no the page.

#(Pre-condition: there should be at least 1 file is uploaded inside files page)