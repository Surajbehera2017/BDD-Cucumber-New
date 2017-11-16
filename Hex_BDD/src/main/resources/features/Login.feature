Feature: MS Dynamics 365

@Login
Scenario Outline: Login To MS Dynamice 365
Given user is on Login page
When user logs in with "<username>" and "<password>"
Then user is logged in successfully
Examples:
|username|password|
|use@onlyfor.onmicrosoft.com|Madhavan17|



