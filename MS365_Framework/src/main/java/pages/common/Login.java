package pages.common;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.Base;

public class Login {
	
	static{ 
	PageFactory.initElements(Base.getDriver(), Login.class);
	}
	@FindBy(xpath="//div[@id='true_inner']//img[@id='login_workload_logo_image'][@alt='Dynamics CRM Online']")
	public static WebElement LblAppName;
	
	@FindBy(id="cred_userid_inputtext")
	public static WebElement TxtEmail;
	
	@FindBy(id="redirect_dots_animation")
	public static WebElement AnmDots;
	
	@FindBy(id="cred_password_inputtext")
	public static WebElement TxtPassword;
	
	@FindBy(id="cred_sign_in_button")
	public static WebElement BtnSignIn;

	
	public static void loginToMSDynamics(String username,String password){
		
		try { TxtEmail.sendKeys(username, Keys.TAB); }
		catch(Exception e)
		{
			LoginExisting.lblAccountName.click();
		}
		waitForRedirection();
		TxtPassword.sendKeys(password);
		BtnSignIn.click();
	}

	public static void waitForRedirection(){
		Base.waitfor(ExpectedConditions.invisibilityOf(AnmDots));		
	}



}