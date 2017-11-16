package ms365elements;

import org.openqa.selenium.By;

import base.Base;
import core.FormElement;
import core.IElement;

public class FormTextBox extends FormElement
{
	FormElement label=null;
	FormElement input=null;

	public FormTextBox(By lblLocator, By txtLocator, IElement context, long timeout, IElement iframe) {
		super(iframe);
		label=new FormElement(lblLocator,context,timeout,iframe);
		input=new FormElement(txtLocator,context,timeout,iframe);
	}
	public FormTextBox(By lblLocator, By txtLocator, long timeout, IElement iframe) {
		super(iframe);
		label=new FormElement(lblLocator,timeout,iframe);
		input=new FormElement(txtLocator,timeout,iframe);
	}
	public FormTextBox(By lblLocator, By txtLocator, IElement iframe) {
		super(iframe);
		label=new FormElement(lblLocator,iframe);
		input=new FormElement(txtLocator,iframe);
	}
	
	@Override
	public void sendKeys(CharSequence... text)
	{
		label.click();
		Base.sleep(100);
		input.sendKeys(text);
	}
	@Override
	public void click()
	{
		label.click();
		Base.sleep(500);
		input.click();
	}
}
