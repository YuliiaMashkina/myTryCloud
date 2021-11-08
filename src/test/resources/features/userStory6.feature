Feature: As a user, I should be able to access to Files module.

  Background:
    Given  user on the login page
    When user provides valid credentials
    And user click the "Files" module

Scenario: verify users can create a folder

Then Click the “+” icon on top
And Click "New folder"
And Write a folder name
Then Click submit icon
Then Verify the folder is displayed on the page

Scenario: verify users can upload a file inside a folder

Then Choose a folder from the page
And  Click the “+” icon on top
Then Click an "Upload file"
Then Verify the file is displayed on the page
#(Pre-condition: there should be at least 1 folder is created on the filers page)