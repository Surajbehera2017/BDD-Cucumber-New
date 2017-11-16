package core;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import base.Base;

public class BrowserFactory
{
	private static DesiredCapabilities caps;
	
	public static final String CHROME="Chrome";
	public static final String INTERNET_EXPLORER="IE";
	public static final String FIREFOX="Firefox";
	
	private static void initDriver(String driverName)
	{
		System.out.println("Checking for Driver Resource...!!!");
		//File f=null;
		String driverPath=null;
		String driverProperty=null;
		switch(driverName)
		{
		case CHROME:
			driverPath="chromedriver.exe";
			driverProperty="webdriver.chrome.driver";
			break;
		}
		
		try {
			File f=new File("tmp"+File.separator+driverPath);
			System.out.println("driver : "+f.exists());
            if(!f.exists())
            {
                  System.out.println("Creating new Driver Resource...");
                  InputStream is=Base.class.getResourceAsStream("/drivers"+File.separator+driverPath);                      
                  f.getParentFile().mkdirs();
                  System.out.println("Driver Resource size : "+is.available());
                  Files.copy(is, f.toPath());
            }
            else
                  System.out.println("Driver resource already exists...");
            String path=f.getPath();
            System.setProperty(driverProperty,path);
		} catch (Exception e){e.printStackTrace();}
	}
	
	private static ChromeOptions initChrome()
	{
		initDriver(CHROME);
		
		ChromeOptions opts=new ChromeOptions();
		opts.addArguments("disable-infobars");
		Map<String, Object> prefs = new HashMap<String, Object>();
	    prefs.put("credentials_enable_service", false);
	    prefs.put("profile.password_manager_enabled", false);
	    opts.setExperimentalOption("prefs", prefs);	    
	    return opts;
	}
	
	public static WebDriver chrome()
	{
		ChromeOptions opts=initChrome();
		WebDriver d=new ChromeDriver(opts);
		return d;
	}
	
	public static WebDriver chrome(String URL)
	{
		ChromeOptions opts=initChrome();
		//opts.addArguments("--app="+URL);
		WebDriver d=new ChromeDriver(opts);
		return d;
	}
	
	public static WebDriver ie()
	{
		WebDriver d=new InternetExplorerDriver(caps);
		return d;
	}
}