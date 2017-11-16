Feature: New Contact

@Contact_Creation
Scenario Outline: Navigate to Contacts page and create new contact
Given user is logged in

When user opens Contacts from Service
Then user is navigated to Contacts page 

When user clicks on NEW
Then a new Contact page is opened

When user fills the required contact information
|fName|lName|jobTitle|businessPhone|mobilePhone|street1|city|zip|country|
And clicks on SAVE
Then the Contact page of the new user is displayed

Examples:
|id|
|NW-CT-01|

@Existing_Contact
Scenario Outline: Search for existing contact
Given user is logged in

When user opens Contacts from Service
Then user is navigated to Contacts page 

When user searches for the contact "<contact_first_name>"
Then the Contact page of the contact is displayed

Examples:
|contact_first_name|
|Mamta|