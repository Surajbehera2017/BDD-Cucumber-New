package base;

import java.util.function.Function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BrowserFactory;
import core.IElement;
import core.Logger;



public final class Base {
	
	protected static WebDriver driver = null;
	public static WebDriverWait wait = null;
	public static final int TIMEOUT = 60;
	public static Logger log;
	
	public static final class DRIVER
	{
		public static final String CHROME="Chrome";
		public static final String INTERNET_EXPLORER="IE";
		public static final String FIREFOX="Firefox";
	}
	
/****************** Driver Initialization *********************/
	
	public static void openBrowser(String browser)
	{
		switch (browser) {
		case DRIVER.CHROME: driver=BrowserFactory.chrome(); break;
		default:
			break;
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		wait=new WebDriverWait(driver, TIMEOUT);
	}
	
	public static void closeBrowser()
	{
		try { driver.quit(); }
		catch (Exception e)
		{
			System.out.println("Exception occured while closing the browser :");
			e.printStackTrace();
			driver=null;
		}
		
	}
	
	public static boolean isBrowserUsable() { return driver!=null; }
	
	public static void navigateToUrl(String url) {
		try {
			driver.get(url);
			//logStep(LogStatus.PASS, "Launching browser & navigating to url", "Browser has been launched successfully",false);
		} catch (Exception e) {
			//logStep(LogStatus.FAIL, "Launching browser & navigating to url", "Not able to launch ", true);

		}
	}
	
	public static WebDriver getDriver() { return driver; }
	
	public static <T> void waitfor(int timeout,Function<WebDriver, T> f)
	{
		try {
			new WebDriverWait(driver,timeout).until(f);
		} catch (Exception e) { System.out.println("Error occured while waiting for : "+f); }
	}
	public static <T> void waitfor(Function<WebDriver, T> f)
	{
		try {
			wait.until(f);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void setLogger(Logger logger) { log=logger; }
	//***********************************************************************
	public static void sleep(long millis) { try { Thread.sleep(millis); } catch(InterruptedException ie){} }
	
	public static String getTxtValue(IElement el){ return el.getAttribute("value"); }
	
	public static Object evaluate(String jsExpr,WebElement context)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		return js.executeScript(jsExpr,context);
	}
	
	public static Object evaluate(String jsExpr,IElement context)
	{ return evaluate(jsExpr,context.element()); }
	
	public static Object evaluate(String jsExpr)
	{ return evaluate(jsExpr,null); }
}
