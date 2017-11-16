$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("defender.feature");
formatter.feature({
  "line": 1,
  "name": "New Contact",
  "description": "",
  "id": "new-contact",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 2,
  "name": "Navigate to Contacts page and create new contact",
  "description": "",
  "id": "new-contact;navigate-to-contacts-page-and-create-new-contact",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 3,
  "name": "user is logged in",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "user opens Contacts from Service",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "user is navigated to Contacts page",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "user clicks on NEW",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "a new Contact page is opened",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "user fills the required contact information",
  "rows": [
    {
      "cells": [
        "fName",
        "lName",
        "jobTitle",
        "businessPhone",
        "mobilePhone",
        "street1",
        "city",
        "zip",
        "country"
      ],
      "line": 9
    },
    {
      "cells": [
        "Mamta",
        "Somani",
        "Sr. Tester",
        "123456789",
        "987654321",
        "Da Vincilaan 1001",
        "Zaventem",
        "B-0001",
        "Belgium"
      ],
      "line": 10
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "clicks on SAVE",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "the Contact page of the new user is displayed",
  "keyword": "Then "
});
formatter.examples({
  "line": 13,
  "name": "",
  "description": "",
  "id": "new-contact;navigate-to-contacts-page-and-create-new-contact;",
  "rows": [
    {
      "cells": [
        "street2"
      ],
      "line": 14,
      "id": "new-contact;navigate-to-contacts-page-and-create-new-contact;;1"
    },
    {
      "cells": [
        "St. 1002"
      ],
      "line": 15,
      "id": "new-contact;navigate-to-contacts-page-and-create-new-contact;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 80058559215,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Navigate to Contacts page and create new contact",
  "description": "",
  "id": "new-contact;navigate-to-contacts-page-and-create-new-contact;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 3,
  "name": "user is logged in",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "user opens Contacts from Service",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "user is navigated to Contacts page",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "user clicks on NEW",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "a new Contact page is opened",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "user fills the required contact information",
  "rows": [
    {
      "cells": [
        "fName",
        "lName",
        "jobTitle",
        "businessPhone",
        "mobilePhone",
        "street1",
        "city",
        "zip",
        "country"
      ],
      "line": 9
    },
    {
      "cells": [
        "Mamta",
        "Somani",
        "Sr. Tester",
        "123456789",
        "987654321",
        "Da Vincilaan 1001",
        "Zaventem",
        "B-0001",
        "Belgium"
      ],
      "line": 10
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "clicks on SAVE",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "the Contact page of the new user is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "Moderator.user_is_on_Dashboard_page()"
});
formatter.write("INFO : [ Finding element : By.xpath: //span[text()\u003d\u0027Dashboards\u0027] ]");
formatter.result({
  "duration": 1220903649,
  "status": "passed"
});
formatter.match({
  "location": "NewContactSteps.user_opens_Contacts_from_Service()"
});
formatter.write("INFO : [ Finding element : By.xpath: (//span[@class\u003d\u0027navTabButtonArrowDown\u0027])[2] ]");
formatter.write("INFO : [ Finding element : By.xpath: //span[@class\u003d\u0027navActionButtonLabel\u0027][text()\u003d\u0027Service\u0027] ]");
formatter.write("INFO : [ Finding element : By.xpath: //span[contains(@class,\u0027nav-rowLabel\u0027)][.\u003d\u0027Contacts\u0027] ]");
formatter.result({
  "duration": 28116568583,
  "status": "passed"
});
formatter.match({
  "location": "NewContactSteps.user_is_navigated_to_Contacts_page()"
});
formatter.write("INFO : [ Finding element : By.xpath: //span[contains(@class,\u0027navTabButtonSubAreaText\u0027)] ]");
formatter.result({
  "duration": 640919765,
  "status": "passed"
});
formatter.match({
  "location": "NewContactSteps.user_clicks_on_NEW()"
});
formatter.write("INFO : [ Finding element : By.xpath: //span[text()\u003d\u0027 New \u0027] ]");
formatter.result({
  "duration": 39739359196,
  "status": "passed"
});
formatter.match({
  "location": "NewContactSteps.a_new_Contact_page_is_opened()"
});
formatter.write("INFO : [ Finding element : By.xpath: //span[@id\u003d\u0027TabNode_tab0Tab-main\u0027]//span[contains(@class,\u0027navTabButtonSubAreaText\u0027)] ]");
formatter.result({
  "duration": 120863810,
  "status": "passed"
});
formatter.match({
  "location": "NewContactSteps.user_fills_the_required_contact_information(DataTable)"
});
formatter.write("INFO : [ Finding element : By.id: contentIFrame1 ]");
formatter.write("INFO : [ Finding element : By.xpath: //div[@id\u003d\u0027fullname\u0027]/div[1] ]");
formatter.write("INFO : [ Finding element : By.id: contentIFrame1 ]");
formatter.write("INFO : [ Finding element : By.id: fullname_compositionLinkControl_firstname ]");
formatter.write("INFO : [ Finding element : By.id: contentIFrame1 ]");
formatter.write("INFO : [ Finding element : By.id: fullname_compositionLinkControl_firstname_i ]");
formatter.write("INFO : [ Finding element : By.id: contentIFrame1 ]");
formatter.write("INFO : [ Finding element : By.id: fullname_compositionLinkControl_lastname ]");
formatter.write("INFO : [ Finding element : By.id: contentIFrame1 ]");
formatter.write("INFO : [ Finding element : By.id: fullname_compositionLinkControl_lastname_i ]");
formatter.write("INFO : [ Finding element : By.id: contentIFrame1 ]");
formatter.write("INFO : [ Finding element : By.xpath: //button[@id\u003d\u0027fullname_compositionLinkControl_flyoutLoadingArea-confirm\u0027]//span[text()\u003d\u0027Done\u0027] ]");
formatter.write("INFO : [ Finding element : By.id: contentIFrame1 ]");
formatter.write("INFO : [ Finding element : By.id: jobtitle ]");
formatter.write("INFO : [ Finding element : By.id: contentIFrame1 ]");
formatter.write("INFO : [ Finding element : By.id: jobtitle_i ]");
formatter.write("INFO : [ Finding element : By.id: contentIFrame1 ]");
formatter.write("INFO : [ Finding element : By.id: parentcustomerid ]");
formatter.write("INFO : [ Finding element : By.id: contentIFrame1 ]");
formatter.write("INFO : [ Finding element : By.id: parentcustomerid_i ]");
formatter.write("INFO : [ Finding element : By.id: contentIFrame1 ]");
formatter.write("INFO : [ Finding element : By.xpath: //span[@class\u003d\u0027ms-crm-IL-MenuItem-Title ms-crm-IL-MenuItem-Title-Rest\u0027 and @title\u003d\u0027Defender\u0027] ]");
formatter.write("INFO : [ Finding element : By.id: contentIFrame1 ]");
formatter.write("INFO : [ Finding element : By.id: telephone1 ]");
formatter.write("INFO : [ Finding element : By.id: contentIFrame1 ]");
formatter.write("INFO : [ Finding element : By.id: telephone1_i ]");
formatter.write("INFO : [ Finding element : By.id: contentIFrame1 ]");
formatter.write("INFO : [ Finding element : By.id: mobilephone ]");
formatter.write("INFO : [ Finding element : By.id: contentIFrame1 ]");
formatter.write("INFO : [ Finding element : By.id: mobilephone_i ]");
formatter.write("INFO : [ Finding element : By.id: contentIFrame1 ]");
formatter.write("INFO : [ Finding element : By.id: address1_composite ]");
formatter.write("INFO : [ Finding element : By.id: contentIFrame1 ]");
formatter.write("INFO : [ Finding element : By.id: address1_composite_compositionLinkControl_address1_line1 ]");
formatter.write("INFO : [ Finding element : By.id: contentIFrame1 ]");
formatter.write("INFO : [ Finding element : By.id: address1_composite_compositionLinkControl_address1_line1_i ]");
formatter.write("INFO : [ Finding element : By.id: contentIFrame1 ]");
formatter.write("INFO : [ Finding element : By.id: address1_composite_compositionLinkControl_address1_city ]");
formatter.write("INFO : [ Finding element : By.id: contentIFrame1 ]");
formatter.write("INFO : [ Finding element : By.id: address1_composite_compositionLinkControl_address1_city_i ]");
formatter.write("INFO : [ Finding element : By.id: contentIFrame1 ]");
formatter.write("INFO : [ Finding element : By.id: address1_composite_compositionLinkControl_address1_postalcode ]");
formatter.write("INFO : [ Finding element : By.id: contentIFrame1 ]");
formatter.write("INFO : [ Finding element : By.id: address1_composite_compositionLinkControl_address1_postalcode_i ]");
formatter.write("INFO : [ Finding element : By.id: contentIFrame1 ]");
formatter.write("INFO : [ Finding element : By.id: address1_composite_compositionLinkControl_address1_country ]");
formatter.write("INFO : [ Finding element : By.id: contentIFrame1 ]");
formatter.write("INFO : [ Finding element : By.id: address1_composite_compositionLinkControl_address1_country_i ]");
formatter.write("INFO : [ Finding element : By.id: contentIFrame1 ]");
formatter.write("INFO : [ Finding element : By.xpath: //button[@id\u003d\u0027address1_composite_compositionLinkControl_flyoutLoadingArea-confirm\u0027]//span[text()\u003d\u0027Done\u0027] ]");
formatter.result({
  "duration": 35286785372,
  "status": "passed"
});
formatter.match({
  "location": "NewContactSteps.clicks_on_SAVE()"
});
formatter.write("INFO : [ Finding element : By.xpath: //span[text()\u003d\u0027 Save \u0027] ]");
formatter.result({
  "duration": 5761296237,
  "status": "passed"
});
formatter.match({
  "location": "NewContactSteps.the_Contact_page_of_the_new_user_is_displayed()"
});
formatter.write("INFO : [ Finding element : By.xpath: //span[@id\u003d\u0027TabNode_tab0Tab-main\u0027]//span[contains(@class,\u0027navTabButtonSubAreaText\u0027)] ]");
formatter.write("INFO : [ Finding element : By.id: contentIFrame1 ]");
formatter.write("INFO : [ Finding element : By.id: FormTitle ]");
formatter.result({
  "duration": 289273998,
  "status": "passed"
});
formatter.write("INFO : [ Finding element : By.id: navTabButtonChangeProfileImageLink ]");
formatter.write("INFO : [ Finding element : By.id: navTabButtonUserInfoSignOutId ]");
formatter.after({
  "duration": 6599063453,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 16,
  "name": "Search for existing contact",
  "description": "",
  "id": "new-contact;search-for-existing-contact",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 17,
  "name": "user is logged in",
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "user opens Contacts from Service",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "user is navigated to Contacts page",
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "user searches for the contact \"\u003ccontact_first_name\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "the Contact page of the contact is displayed",
  "keyword": "Then "
});
formatter.examples({
  "line": 22,
  "name": "",
  "description": "",
  "id": "new-contact;search-for-existing-contact;",
  "rows": [
    {
      "cells": [
        "contact_first_name"
      ],
      "line": 23,
      "id": "new-contact;search-for-existing-contact;;1"
    },
    {
      "cells": [
        "Mamta"
      ],
      "line": 24,
      "id": "new-contact;search-for-existing-contact;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.write("INFO : [ Finding element : By.xpath: (//div[contains(@class,\u0027tile_primary_name\u0027)])[1] ]");
formatter.before({
  "duration": 42049192191,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "Search for existing contact",
  "description": "",
  "id": "new-contact;search-for-existing-contact;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 17,
  "name": "user is logged in",
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "user opens Contacts from Service",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "user is navigated to Contacts page",
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "user searches for the contact \"Mamta\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "the Contact page of the contact is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "Moderator.user_is_on_Dashboard_page()"
});
formatter.write("INFO : [ Finding element : By.xpath: //span[text()\u003d\u0027Dashboards\u0027] ]");
formatter.result({
  "duration": 1119907794,
  "status": "passed"
});
formatter.match({
  "location": "NewContactSteps.user_opens_Contacts_from_Service()"
});
formatter.write("INFO : [ Finding element : By.xpath: (//span[@class\u003d\u0027navTabButtonArrowDown\u0027])[2] ]");
formatter.write("INFO : [ Finding element : By.xpath: //span[@class\u003d\u0027navActionButtonLabel\u0027][text()\u003d\u0027Service\u0027] ]");
formatter.write("INFO : [ Finding element : By.xpath: //span[contains(@class,\u0027nav-rowLabel\u0027)][.\u003d\u0027Contacts\u0027] ]");
formatter.result({
  "duration": 8185584568,
  "status": "passed"
});
formatter.match({
  "location": "NewContactSteps.user_is_navigated_to_Contacts_page()"
});
formatter.write("INFO : [ Finding element : By.xpath: //span[contains(@class,\u0027navTabButtonSubAreaText\u0027)] ]");
formatter.result({
  "duration": 170509129,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Mamta",
      "offset": 31
    }
  ],
  "location": "ExistingContactSteps.user_searches_for_the_contact(String)"
});
formatter.write("INFO : [ Finding element : By.id: contentIFrame0 ]");
formatter.write("INFO : [ Finding element : By.xpath: //input[@id\u003d\u0027crmGrid_findCriteria\u0027] ]");
formatter.write("INFO : [ Finding element : By.id: contentIFrame0 ]");
formatter.write("INFO : [ Finding element : By.xpath: //a[@id\u003d\u0027crmGrid_findCriteriaButton\u0027]/span ]");
formatter.write("INFO : [ Finding element : By.id: contentIFrame0 ]");
formatter.write("INFO : [ Finding element : By.id: gridBodyTable_primaryField_{AB042CB2-E5B7-E711-A950-000D3A3702CA}_0 ]");
formatter.result({
  "duration": 12514502420,
  "status": "passed"
});
formatter.match({
  "location": "ExistingContactSteps.the_contact_page_of_existing_conatct_is_displayed()"
});
formatter.write("INFO : [ Finding element : By.xpath: //span[@id\u003d\u0027TabNode_tab0Tab-main\u0027]//span[contains(@class,\u0027navTabButtonSubAreaText\u0027)] ]");
formatter.result({
  "duration": 186055422,
  "status": "passed"
});
formatter.write("INFO : [ Finding element : By.id: navTabButtonChangeProfileImageLink ]");
formatter.write("INFO : [ Finding element : By.id: navTabButtonUserInfoSignOutId ]");
formatter.after({
  "duration": 8042490131,
  "status": "passed"
});
});