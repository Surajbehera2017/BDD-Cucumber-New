package pages.misc;

import org.openqa.selenium.By;

import core.IElement;

public class MS365TrialPopup {
	public static By popWelcomeTrial=By.id("stepBubbleContainer");
	public static By icnPopClose=By.id("xbutton");
	public static IElement PopWelcomeTrial=new IElement(popWelcomeTrial);
	public static IElement IcnPopClose=new IElement(icnPopClose,PopWelcomeTrial);
}
