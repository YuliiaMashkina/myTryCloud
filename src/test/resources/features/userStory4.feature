Feature: As a user, I should be able to access to Files module.

Scenario: users can add a file to favorites.

Given  user on the login page
  When user provides valid credentials
  And user click the "Files" module
And user Click action-icon from any file on the page
And Choose "Add to favorites" option
And  Click "Favorites" sub-module on the lest side
Then Verify the chosen file is listed on the table
# (Pre-condition: there should be at least 1 file is uploaded)