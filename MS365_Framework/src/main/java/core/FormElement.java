package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FormElement extends IElement
{
	protected IElement iframe=null;
	
	public FormElement(IElement iframe) { this.iframe=iframe; }
	public FormElement(By locator, IElement context, long timeout, IElement iframe)
	{
		super(locator, context, timeout);
		this.iframe=iframe;
	}
	public FormElement(By locator, long timeout, IElement iframe)
	{
		super(locator, timeout);
		this.iframe=iframe;
	}
	public FormElement(By locator, IElement iframe)
	{
		super(locator);
		this.iframe=iframe;
	}
	
	/*@Override
	public WebElement element(){ return e; }*/
	
	@Override
	public void click()
	{
		iframe.switchToIFrame();
		try { super.click(); } catch(Exception e){ throw e; } 
		finally { iframe.switchBack(); }
	}
	@Override
	public void sendKeys(CharSequence... text) {
		iframe.switchToIFrame();
		super.sendKeys(text);
		iframe.switchBack();
	}
	@Override
	public String getText() {
		iframe.switchToIFrame();
		String t=super.getText();
		iframe.switchBack();
		return t;
	}
	@Override
	public void moveToElement()
	{
		iframe.switchToIFrame();
		super.click();
		iframe.switchBack();
	}
}