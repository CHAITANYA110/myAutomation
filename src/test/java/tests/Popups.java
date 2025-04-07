package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.PopupsPage;

public class Popups extends BaseClass{
	
	@Test(description = "TC_AN_PP_01", priority = 1)
	public void verifyAlertPopupText()
	{
		PopupsPage pp = new HomePage(driver).clickHome().navigatePopupPage();
		
		String alertText = pp.clickAlertPopup().verifyAlertPopupText();
		Assert.assertEquals(alertText, "Hi there, pal!");
	}
	
	@Test(description = "TC_AN_PP_02", priority = 2)
	public void verifyConfirmPopupOkText()
	{
		PopupsPage pp = new HomePage(driver).clickHome().navigatePopupPage();
		
		String message = pp.clickConfirmPopup().confirmPopupGetOkMessage();
		Assert.assertEquals(message, "OK it is!");
	}
	
	@Test(description = "TC_AN_PP_03", priority = 3)
	public void verifyConfirmPopupCancelText()
	{
		PopupsPage pp = new HomePage(driver).clickHome().navigatePopupPage();
		
		String message = pp.clickConfirmPopup().confirmPopupGetCancelMessage();
		System.out.println(message);
		Assert.assertEquals(message, "Cancel it is!");
	}
	
	@Test(description = "TC_AN_PP_04", priority = 4)
	public void verifyPromptPopupNoValueText()
	{
		PopupsPage pp = new HomePage(driver).clickHome().navigatePopupPage();
		
		String message = pp.clickPromptPopup().promptPopupGetMessageBlankEntry();
		System.out.println(message);
		Assert.assertEquals(message, "Fine, be that way...");
	}
	
	@Test(description = "TC_AN_PP_05", priority = 5)
	public void verifyPromptPopupValueText()
	{
		String myVal = "NMDP";
		PopupsPage pp = new HomePage(driver).clickHome().navigatePopupPage();
		
		String message = pp.clickPromptPopup().promptPopupGetMessageTextEntry(myVal);
		System.out.println(message);
		Assert.assertEquals(message, "Nice to meet you, "+myVal+"!");
	}
	
	@Test(description = "TC_AN_PP_06", priority = 6)
	public void verifyTooltipText()
	{
		PopupsPage pp = new HomePage(driver).clickHome().navigatePopupPage();
		
		String message = pp.clickTooltipField().getTooltipText();
		System.out.println(message);
		Assert.assertEquals(message, "Cool text");
	}
	
}

