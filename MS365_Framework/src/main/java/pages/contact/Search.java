package pages.contact;

import org.openqa.selenium.By;

import core.FormElement;
import core.IElement;

/**
 * This class represnts the 
 */
public class Search {

	public static IElement IframeExistingContact=new IElement(By.id("contentIFrame0"));
	
	/**
	 * This IElement represents the Search box
	 */
	public static FormElement TxtboxSearch = new FormElement(By.xpath("//input[@id='crmGrid_findCriteria']"),IframeExistingContact);
	public static FormElement BtnSearch = new FormElement(By.xpath("//a[@id='crmGrid_findCriteriaButton']/span"),IframeExistingContact);
	public static FormElement TxtExistingContact = new FormElement(By.id("gridBodyTable_primaryField_{AB042CB2-E5B7-E711-A950-000D3A3702CA}_0"),IframeExistingContact);
	
	
}
