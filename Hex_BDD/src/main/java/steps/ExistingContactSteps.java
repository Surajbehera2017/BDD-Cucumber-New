package steps;

import static org.testng.Assert.assertTrue;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.common.Dashboard;
import pages.contact.Search;

public class ExistingContactSteps {


@When("^user searches for the contact \"([^\"]*)\"$")
public void user_searches_for_the_contact(String arg1) {
	Search.TxtboxSearch.sendKeys(arg1);
	Search.BtnSearch.click();
	Search.TxtExistingContact.click();
}

@Then("^the Contact page of the contact is displayed$")
public void the_contact_page_of_existing_conatct_is_displayed() {
	assertTrue(Dashboard.LblCurrentSubEntity.getText().toUpperCase().contains("MAMTA"),"Contact page is not displayed");
}

}
