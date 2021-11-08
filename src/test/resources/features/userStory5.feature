Feature: As a user, I should be able to able to access to Files module.


  Background:
    Given  user on the login page
    When user provides valid credentials
    And user click the "Files" module

#NOT DONE
  Scenario: verify users can remove a file from favorites.

  And user Click action-icon from any favorite file on the page
  And Choose "Remove from favorites" option
Then Verify that the file is removed from "Favorites" sub-module’s table.
#(Pre-condition: there should be at least 1 file is added to favorites table)


Scenario: verify users can upload a file directly to the homepage (File-Uploading)

And Click the “+” icon on top
Then Click an "Upload file"
Then Verify the file is displayed on the page