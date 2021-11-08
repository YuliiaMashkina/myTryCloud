@ui
Feature: As a user, I should be able to access to Files module.

  Background:
    Given user on the login page

  Scenario: verify users can access to Files module

    When user provides valid credentials
    And user click the "Files" module
  Then verify the page tile is "Files - Trycloud"

  Scenario: verify users can select all the uploaded files from the page

    When user provides valid credentials
    And user click the "Files" module
    And user click the top left checkbox of the table
  Then verify all the files are selected
#Pre-condition: there should be at least 2 files are uploaded the page

