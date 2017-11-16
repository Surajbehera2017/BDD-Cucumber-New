Feature: New Contact

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