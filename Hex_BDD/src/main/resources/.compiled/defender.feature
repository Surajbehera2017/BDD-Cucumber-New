Feature: New Contact
Scenario Outline: Navigate to Contacts page and create new contact
Given user is logged in
When user opens Contacts from Service
Then user is navigated to Contacts page
When user clicks on NEW
Then a new Contact page is opened
When user fills the required contact information
|fName|lName|jobTitle|businessPhone|mobilePhone|street1|city|zip|country|
|Mamta|Somani|Sr. Tester|123456789|987654321|Da Vincilaan 1001|Zaventem|B-0001|Belgium|
And clicks on SAVE
Then the Contact page of the new user is displayed
Examples:
|street2|
|St. 1002|
Scenario Outline: Search for existing contact
Given user is logged in
When user opens Contacts from Service
Then user is navigated to Contacts page
When user searches for the contact "<contact_first_name>"
Then the Contact page of the contact is displayed
Examples:
|contact_first_name|
|Mamta|
