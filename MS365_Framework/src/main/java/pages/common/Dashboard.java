package pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import core.IElement;


public class Dashboard {
	
	static{
		//PageFactory.initElements(Base.driver, DashboardsObj.class);
		//PageFactory.initElements(Base.driver, _Customers.class);
		}
	
	public static IElement ImgProfile = new IElement(By.id("navTabButtonChangeProfileImageLink"));
	public static IElement LblSignOut = new IElement(By.id("navTabButtonUserInfoSignOutId"));
	
	public static IElement TabDashboards = new IElement(By.xpath("//span[text()='Dashboards']"));
	public static IElement IcnDomainArrowDown = new IElement(By.xpath("(//span[@class='navTabButtonArrowDown'])[2]"));
	public static IElement LblCurrentDomain = new IElement(By.xpath("//span[contains(@class,'navTabButtonAreaText')]"));
	public static IElement LblCurrentEntity = new IElement(By.xpath("//span[contains(@class,'navTabButtonSubAreaText')]"));
	public static IElement LblCurrentSubEntity = new IElement(By.xpath("//span[@id='TabNode_tab0Tab-main']//span[contains(@class,'navTabButtonSubAreaText')]"),10);
	public static IElement LblSales = new IElement(By.xpath("//span[@class='navActionButtonLabel'][text()='Sales']"));
	public static IElement LblService = new IElement(By.xpath("//span[@class='navActionButtonLabel'][text()='Service']"));
	public static class Service
	{
		public static class Customers
		{
			public static final String CONTACTS="Contacts"; 
			public static final String NEW_CONTACT="New Contact";
			
			public static IElement LnkContacts = new IElement(By.xpath("//span[contains(@class,'nav-rowLabel')][.='Contacts']"));
		}		
	}
	
	public static IElement LnkServiceContacts = new IElement(By.xpath("//a[@id='nav_conts']/span[2]"));
	

	
	
	public static boolean isUserLoggedIn(){
		try{
		return ImgProfile.isDisplayed();
		}catch(NoSuchElementException nse){
			nse.printStackTrace();			
			return false;
		}
	}
	
	public static void signOut()
	{
		ImgProfile.click();
		LblSignOut.click();
	}
		
}
