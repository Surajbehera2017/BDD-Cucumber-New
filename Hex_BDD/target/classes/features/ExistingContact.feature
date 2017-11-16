Feature: MS Dynamics 365

@Existing_Contact @run_Existing
Scenario Outline: Search for existing contact
Given user is logged in

When user opens Contacts from Service
Then user is navigated to Contacts page 

When user searches for the contact "<contact_first_name>"
Then the Contact page of the contact is displayed

Examples:
|contact_first_name|
|Mamta|