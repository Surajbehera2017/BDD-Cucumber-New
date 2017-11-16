package hex.Runner;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import core.BrowserFactory;
import pages.common.Dashboard;
import pages.common.Login;
import pages.contact.NewContact;


public class NewTestTestNG {
	
  @Test
  public void test() {
	 
	  Login.loginToMSDynamics("use@onlyfor.onmicrosoft.com","Madhavan17");
	  //Base.alertDismiss();
	  Dashboard.IcnDomainArrowDown.click();
	  Dashboard.LblService.click();
	  Base.waitfor(ExpectedConditions.visibilityOf(Dashboard.Service.Customers.LnkContacts));
	  Dashboard.Service.Customers.LnkContacts.click();
	  Base.waitfor(ExpectedConditions.elementToBeClickable(NewContact.LnkNew));
	  //assertTrue(NewContactCreation.isUserOnContactPage());
	  NewContact.LnkNew.click();
	  assertTrue(NewContact.isUserOnNewContactPage());
	  NewContact.TxtAFullName.click();
	  NewContact.TxtFirstName.sendKeys("Mamta");
	  NewContact.TxtLastName.sendKeys("Somani");
	  NewContact.BtnFullNameDone.click();
			  
  }
  @BeforeTest
  public void beforeTest() {
	  
	  //Base.driverInit("chrome");
	  Base.openBrowser(BrowserFactory.CHROME);
	  Base.navigateToUrl("https://onlyfor0.crm.dynamics.com/main.aspx#538494558");
	  
	  
	  
  }

  @AfterTest
  public void afterTest() {
  }

}
