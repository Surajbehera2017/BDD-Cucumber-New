package core;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static base.Base.*;
import pages.misc.MS365TrialPopup;

public class IElement implements WebElement
{
	By locator=null;
	IElement context=null;
	long timeout=15;
	
	static final int MAX_TRIES=3;
	
	WebElement e=null;
	
	public IElement() {}
	public IElement(By locator,IElement context,long timeout)
	{ this.locator=locator; this.context=context; this.timeout=timeout; }
	public IElement(By locator,IElement context)
	{ this.locator=locator; this.context=context; }
	public IElement(By locator,long timeout)
	{ this.locator=locator; this.timeout=timeout; }
	public IElement(By locator)
	{ this.locator=locator; }
	
	public static void checkNDismissPopup()
	{
		try {
			WebElement el=getDriver().findElement(MS365TrialPopup.popWelcomeTrial);
			if(el!=null && el.isDisplayed())
				getDriver().findElement(MS365TrialPopup.icnPopClose).click();
		}catch(NoSuchElementException nse) {}
	}

	void init()
	{
		//System.out.println("Finding element : "+locator);
		log.info("Finding element : "+locator);
		//Base.wait.until(Base.popWait)
		//checkNDismissPopup();
		
		if(e!=null)
		{
			scrollIntoView();
			return;
		}		
		try {
			WebDriverWait w=new WebDriverWait(getDriver(),timeout);
			w.ignoring(NoSuchElementException.class,StaleElementReferenceException.class)
			.until(ExpectedConditions.elementToBeClickable(locator));
			if(context!=null)
				e=context.findElement(locator);
			else
				e=getDriver().findElement(locator);
			//System.out.println("Element found : "+locator);
			
			//checkNDismissPopup();
			
			scrollIntoView();
		} catch(Exception e)
		{
			e.printStackTrace();
			//System.out.println("Element not found.");
			log.error("Element not found.");
			e=null;
		}
	}
	void refresh()
	{
		try {
			WebDriverWait w=new WebDriverWait(getDriver(),timeout);
			w.ignoring(NoSuchElementException.class,StaleElementReferenceException.class)
			.until(ExpectedConditions.elementToBeClickable(locator));
			if(context!=null)
				e=context.findElement(locator);
			else
				e=getDriver().findElement(locator);
			//System.out.println("Element found : "+locator);
			scrollIntoView();
		} catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Element not found.");
			e=null;
		}
	}
	
	public void switchToIFrame()
	{
		init();
		getDriver().switchTo().frame(e);
	}	
	public void switchBack() { getDriver().switchTo().defaultContent(); }
	public void scrollIntoView()
	{
		String js="arguments[0].scrollIntoViewIfNeeded()";
		for(int i=0;i<3;++i)
		{
			try {
				evaluate(js,e);
				return;
			} catch(StaleElementReferenceException sere) { refresh(); }
		}
	}
	public WebElement element() { return e; }
	
	@Override
	public <X> X getScreenshotAs(OutputType<X> arg0) throws WebDriverException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void click()
	{
		init();
		sleep(500);
		for(int i=0;i<MAX_TRIES;++i)
		{
			try {
				e.click();
				sleep(500);
				return;
			} catch(StaleElementReferenceException sere) { refresh(); }
			catch(WebDriverException wde) { checkNDismissPopup(); }
		}
	}

	@Override
	public WebElement findElement(By locator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WebElement> findElements(By arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAttribute(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCssValue(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle getRect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension getSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTagName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getText() {
		init();
		for(int i=0;i<3;++i)
		{
			try {
				return e.getText();
			} catch(StaleElementReferenceException sere) { refresh(); }
		}
		return null;
	}

	@Override
	public boolean isDisplayed() {
		init();		
		return e.isDisplayed();
	}
	@Override
	public void sendKeys(CharSequence... text) {
		init();
		sleep(300);
		e.click();
		sleep(300);
		e.sendKeys(text);
		sleep(300);
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSelected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void submit() {
		// TODO Auto-generated method stub
		
	}
	public void moveToElement() {
		Actions action = new Actions(getDriver());
		init();
		sleep(100);
		action.moveToElement(e).build().perform();
		sleep(100);
	}
	

}
