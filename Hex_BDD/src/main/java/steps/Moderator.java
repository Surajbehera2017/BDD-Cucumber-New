package steps;

import static org.testng.Assert.assertTrue;

import common.Base;
import common.Log;
import common.PasswordEncryptor;
import common.Utils;
import core.BrowserFactory;
import core.Logger;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import pages.common.Dashboard;
import pages.common.Login;

public class Moderator
{
	public static Scenario sce;
	private boolean initialized=false;
	
	static Logger log;
	
	protected static String URL;


	@Before
	public void setUp(Scenario s) throws Exception
	{
	   if (!initialized)
	   {
	      // Global Before All
	      beforeStories();
	      initialized = true;
	   }
	   // Before Scenario
	   sce=s;
	   beforeScenario(s);
	}

	private static void beforeStories()
	{
	   URL = Base.config.getS("URL");
	   System.out.println("using URL : " + URL);

	   Base.initGlobalStore();
	   log=new Log();
	   base.Base.setLogger(log);

	   Runtime.getRuntime().addShutdownHook(new Thread() {
	      @Override
	      public void run() {
	         // Global After All
	         afterStories();
	      }
	   });
	}
	private static void afterStories() { /*base.Base.getDriver().quit();*/ }

	private static void beforeScenario(Scenario s)
	{
		if(!base.Base.isBrowserUsable())
		{
			base.Base.openBrowser(BrowserFactory.CHROME);
			base.Base.navigateToUrl(URL);
		}
		
		login();
		common.Base.initStore();

		String name = s.getName();
		System.out.println("******************************************************************************");
		System.out.println("*                                                                            *");
		System.out.println("\tSCENARIO : "+name);
		System.out.println("*                                                                            *");
		System.out.println("******************************************************************************");
		name = name.replaceAll("/\\:*?\"<>", "_");

		if(Base.config.getB("recordScreenCast"))
		   Utils.startScreenRecording(name);
	}

	@After
	public void afterScenario(Scenario scenario) {
	   try {
	      if (scenario.isFailed()) {
	         System.out.println("********************************FAILED************************************");
	         try {
	            // cucumber report screen capture
	            byte[] screenshot = Utils.ccAsArray();
	            scenario.embed(screenshot, "image/png");
	         } catch (Exception e) {
	            System.err.println(e.getMessage());
	         }
	      } else
	         System.out.println("***********************************PASSED**********************************");

	      System.out.println("logging out..");
	      Dashboard.signOut();
	      
	   } catch (Exception e){  }
	   finally { if(Base.config.getB("recordScreenCast")) Utils.stopScreenRecording(); }
	}

	private static void login()
	{
	   
		String username=Base.config.getS("username");
		String password=Base.config.getS("password");
		password=PasswordEncryptor.decrypt(password);
		
		Login.loginToMSDynamics(username,password);
	}
	
	@Given("^user is logged in$")
	public void user_is_on_Dashboard_page() {
		assertTrue(Dashboard.TabDashboards.isDisplayed(),"User is not on Dashboard page");
	}
}
