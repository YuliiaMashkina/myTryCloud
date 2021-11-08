@ui
Feature:  As a user, I should be able to access to Contacts module.

  Background:
    Given  user on the login page
    When user provides valid credentials
    And user click the "Contacts" module

Scenario: - verify users can access to Talks module
Then verify the page tile is "Contacts - Trycloud QA"

Scenario: - verify users can add contacts
When Click "New Contact" button
And Fill out the contact info like : Title, Phone, email, address , etc
Then Verify the contact name is added to the contact list