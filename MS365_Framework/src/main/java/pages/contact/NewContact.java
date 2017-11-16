package pages.contact;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.Base;
import core.FormElement;
import core.IElement;
import ms365elements.FormTextBox;
import pages.common.Dashboard;

public class NewContact {
	
	public static IElement LnkNew = new IElement(By.xpath("//span[text()=' New ']"),10);
	
	public static IElement IframeNewContact=new IElement(By.id("contentIFrame1"));
	
	public static FormElement TxtAFullName = new FormElement(By.xpath("//div[@id='fullname']/div[1]"),30,IframeNewContact);
	
	public static FormTextBox TxtFirstName = new FormTextBox(
			By.id("fullname_compositionLinkControl_firstname"),
			By.id("fullname_compositionLinkControl_firstname_i"),IframeNewContact);
	public static FormTextBox TxtLastName = new FormTextBox(
			By.id("fullname_compositionLinkControl_lastname"),
			By.id("fullname_compositionLinkControl_lastname_i"),
			IframeNewContact);
	
	public static FormElement BtnFullNameDone = new FormElement(By.xpath("//button[@id='fullname_compositionLinkControl_flyoutLoadingArea-confirm']//span[text()='Done']"),IframeNewContact);
	
	public static FormTextBox TxtJobTitle = new FormTextBox(
			By.id("jobtitle"),
			By.id("jobtitle_i"),
			IframeNewContact);
	
	public static FormElement MoveToAccountName = new FormElement(By.id("parentcustomerid"),IframeNewContact);
	
	public static FormTextBox SelectAccountName = new FormTextBox(
			By.id("parentcustomerid_i"),
			By.xpath("//span[@class='ms-crm-IL-MenuItem-Title ms-crm-IL-MenuItem-Title-Rest' and @title='Defender']"),
			IframeNewContact);
	public static FormTextBox TxtBusinessPhone = new FormTextBox(
			By.id("telephone1"),
			By.id("telephone1_i"),
			IframeNewContact);
	public static FormTextBox TxtMobilePhone = new FormTextBox(
			By.id("mobilephone"),
			By.id("mobilephone_i"),
			IframeNewContact);
	
	public static FormElement TxtAAddress = new FormElement(By.id("address1_composite"),IframeNewContact);
	
	public static FormTextBox TxtStreet1 = new FormTextBox(
			By.id("address1_composite_compositionLinkControl_address1_line1"),
			By.id("address1_composite_compositionLinkControl_address1_line1_i"),
			IframeNewContact);
	//public static FormElement TxtStreet2 = new FormElement(By.id("address1_composite_compositionLinkControl_address1_line2"),IframeNewContact);
	//public static FormElement TxtStreet3 = new FormElement(By.id("address1_composite_compositionLinkControl_address1_line3"),IframeNewContact);
	public static FormTextBox TxtCity = new FormTextBox(
			By.id("address1_composite_compositionLinkControl_address1_city"),
			By.id("address1_composite_compositionLinkControl_address1_city_i"),
			IframeNewContact);
	public static FormTextBox TxtZip = new FormTextBox(
			By.id("address1_composite_compositionLinkControl_address1_postalcode"),
			By.id("address1_composite_compositionLinkControl_address1_postalcode_i"),
			IframeNewContact);
	public static FormTextBox TxtCountry = new FormTextBox(
			By.id("address1_composite_compositionLinkControl_address1_country"),
			By.id("address1_composite_compositionLinkControl_address1_country_i"),
			IframeNewContact);
	
	public static FormElement BtnAddressDone = new FormElement(By.xpath("//button[@id='address1_composite_compositionLinkControl_flyoutLoadingArea-confirm']//span[text()='Done']"),IframeNewContact);
	
	//public static IElement BtnSave = new IElement(By.xpath("//span[text()=' Save ']"));
	//public static FormElement IcnSaving = new FormElement(By.xpath("//span[@id='titlefooter_statuscontrol'][contains(text(),'saving')]"),IframeNewContact);
	
	public static class _BtnSave extends IElement
	{
		public _BtnSave(By locator) { super(locator); }
		@Override
		public void click()
		{
			super.click();
			Base.getDriver().switchTo().frame("contentIFrame1");
			By loc=By.xpath("//span[@id='titlefooter_statuscontrol'][contains(text(),'saving')]");
			try {
				Base.waitfor(1,ExpectedConditions.visibilityOfElementLocated(loc));
			} catch(Exception e){  }
			try {
				Base.waitfor(10,ExpectedConditions.invisibilityOfElementLocated(loc));
			} catch(Exception e){ System.out.println("Error occured while saving contact."); }
			finally{ Base.getDriver().switchTo().defaultContent(); }
		}
	}
	public static _BtnSave BtnSave=new _BtnSave(By.xpath("//span[text()=' Save ']"));
	
	
	public static boolean isUserOnContactPage(){
		try{
		return LnkNew.isDisplayed();
		}catch(NoSuchElementException nse){
			nse.printStackTrace();			
			return false;
		}
	}
	public static boolean isUserOnNewContactPage(){
		try{
		return Dashboard.LblCurrentSubEntity.isDisplayed();
		}catch(NoSuchElementException nse){
			nse.printStackTrace();			
			return false;
		}
	}
	
	
	
	/*
	@FindBy(xpath="//span[text()=' New ']")
	public static WebElement LnkNew;
	
	@FindBy(xpath="//div[@id='fullname']/div[1]")
	public static WebElement TxtAFullName;
	
	@FindBy(id="fullname_compositionLinkControl_firstname")
	public static WebElement TxtFirstName;
	
	@FindBy(id="fullname_compositionLinkControl_lastname")
	public static WebElement TxtLastName;
	
	@FindBy(xpath="//span[text()='Done']")
	public static WebElement BtnDone;
	
	@FindBy(id="jobtitle")
	public static WebElement TxtJobTitle;
	
	@FindBy(id="parentcustomerid")
	public static WebElement TxtAccountName;
	
	@FindBy(id="telephone1")
	public static WebElement TxtBusinessPhone;
	
	@FindBy(id="mobilephone")
	public static WebElement TxtMobilePhone;
	
	@FindBy(id="address1_composite")
	public static WebElement TxtAAddress;
	
	@FindBy(id="address1_composite_compositionLinkControl_address1_line1_i")
	public static WebElement TxtStreet1;
	
	@FindBy(id="address1_composite_compositionLinkControl_address1_line2")
	public static WebElement TxtStreet2;
	
	@FindBy(id="address1_composite_compositionLinkControl_address1_line3")
	public static WebElement TxtStreet3;
	
	@FindBy(id="address1_composite_compositionLinkControl_address1_city")
	public static WebElement TxtCity;
	
	@FindBy(id="address1_composite_compositionLinkControl_address1_postalcode")
	public static WebElement TxtZip;
	
	@FindBy(id="address1_composite_compositionLinkControl_address1_country")
	public static WebElement TxtCountry;
	
	@FindBy(xpath="//span[text()=' Save ']")
	public static WebElement BtnSave;
	*/
	
}
