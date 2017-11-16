package steps;

import static common.Base.getS;
import static common.Base.map;
import static common.Base.set;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import base.Base;
import common.JSONObject;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.common.Dashboard;
import pages.contact.NewContact;
import pages.contact.Summary;

public class NewContactSteps {

	@When("^user opens Contacts from Service$")
	public void user_opens_Contacts_from_Service() {
		Dashboard.IcnDomainArrowDown.click();
		Dashboard.LblService.click();
		Base.sleep(2000);
		Dashboard.Service.Customers.LnkContacts.click();
		Base.sleep(2000);
	}

	@Then("^user is navigated to Contacts page$")
	public void user_is_navigated_to_Contacts_page() {
		assertTrue(Dashboard.LblCurrentEntity.getText().equalsIgnoreCase(Dashboard.Service.Customers.CONTACTS),"user is not on coctacts page");
	}

	@When("^user clicks on NEW$")
	public void user_clicks_on_NEW() {
		NewContact.LnkNew.click();
	}

	@Then("^a new Contact page is opened$")
	public void a_new_Contact_page_is_opened() {
		assertEquals(Dashboard.LblCurrentSubEntity.getText().toUpperCase(),Dashboard.Service.Customers.NEW_CONTACT.toUpperCase(),"user is not on New Contact page");
	}

	@When("^user fills the required contact information$")
	public void user_fills_the_required_contact_information(DataTable data) {
		JSONObject details=map(data).get(0);
		
		String fName=details.getS("fName"),lName=details.getS("lName");
		NewContact.TxtAFullName.click();
		NewContact.TxtFirstName.sendKeys(fName);
		NewContact.TxtLastName.sendKeys(lName);
		NewContact.BtnFullNameDone.click();
		NewContact.TxtJobTitle.sendKeys(details.getS("jobTitle"));
		NewContact.MoveToAccountName.moveToElement();
		NewContact.SelectAccountName.click();
		NewContact.TxtBusinessPhone.sendKeys(details.getS("businessPhone"));
		NewContact.TxtMobilePhone.sendKeys(details.getS("mobilePhone"));
		NewContact.TxtAAddress.click();
		NewContact.TxtStreet1.sendKeys(details.getS("street1"));
		NewContact.TxtCity.sendKeys(details.getS("city"));
		NewContact.TxtZip.sendKeys(details.getS("zip"));
		NewContact.TxtCountry.sendKeys(details.getS("country"));
		NewContact.BtnAddressDone.click();
		
		set("firstName",fName,"lastName",lName);
	}

	@When("^clicks on SAVE$")
	public void clicks_on_SAVE() {
		//Base.sleep(2000);
		NewContact.BtnSave.click();
	}

	@Then("^the Contact page of the new user is displayed$")
	public void the_Contact_page_of_the_new_user_is_displayed(){
		String fName=getS("firstName");
		String lName=getS("lastName");
		String name=fName+" "+lName;
		assertEquals(Dashboard.LblCurrentSubEntity.getText().toUpperCase(),name.toUpperCase(),"Contact Name is not disaplyed on Dashboard");
		assertEquals(Summary.lblContactName.getText().toUpperCase(),name.toUpperCase(),"Contact Summary screen not displayed");
	}


}
