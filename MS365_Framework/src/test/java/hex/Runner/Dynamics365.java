package hex.Runner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;


public class Dynamics365 {

	private static WebDriver driver = null;
	public static void main(String[] args) throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://onlyfor0.crm.dynamics.com/main.aspx#538494558");
		driver.findElement(By.id("cred_userid_inputtext")).sendKeys("use@onlyfor.onmicrosoft.com",Keys.TAB);
		Thread.sleep(3000);
		driver.findElement(By.id("cred_password_inputtext")).sendKeys("Madhavan17");
		driver.findElement(By.id("cred_sign_in_button")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("(//span[@class='navTabButtonArrowDown'])[2]")).click();
		driver.findElement(By.xpath("//a[@id='CS']/span[2]")).click();
		driver.findElement(By.xpath("//a[@id='nav_conts']/span[2]")).click();
		driver.findElement(By.xpath("//span[text()=' New ']")).click();
		driver.findElement(By.xpath("//div[@id='fullname']/div[1]")).click();
		driver.findElement(By.id("fullname_compositionLinkControl_firstname")).click();
		driver.findElement(By.id("fullname_compositionLinkControl_firstname")).sendKeys("abc");
		driver.findElement(By.id("fullname_compositionLinkControl_lastname")).click();
		driver.findElement(By.id("fullname_compositionLinkControl_lastname")).sendKeys("xyz");
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		driver.findElement(By.id("jobtitle")).sendKeys("Sr Tester");
		
		
		Thread.sleep(5000);
		
		//driver.quit();
		

		/*
		@FindBy(id="parentcustomerid")
		private WebElement txtAccountName;
		
		@FindBy(id="telephone1")
		private WebElement txtBusinessPhone;
		
		@FindBy(id="mobilephone")
		private WebElement txtMobilePhone;
		
		@FindBy(id="address1_composite")
		private WebElement txtAAddress;
		
		@FindBy(id="address1_composite_compositionLinkControl_address1_line1_i")
		private WebElement txtStreet1;
		
		@FindBy(id="address1_composite_compositionLinkControl_address1_line2")
		private WebElement txtStreet2;
		
		@FindBy(id="address1_composite_compositionLinkControl_address1_line3")
		private WebElement txtStreet3;
		
		@FindBy(id="address1_composite_compositionLinkControl_address1_city")
		private WebElement txtCity;
		
		@FindBy(id="address1_composite_compositionLinkControl_address1_postalcode")
		private WebElement txtZip;
		
		@FindBy(id="address1_composite_compositionLinkControl_address1_country")
		private WebElement txtCountry;
		
		*/
		
	}

}
