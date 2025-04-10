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
		log.info("[TEST STARTED : verifyAlertPopupText]");
		
		PopupsPage pp = new HomePage(driver).clickHome().navigatePopupPage();
		
		String alertText = pp.clickAlertPopup().verifyAlertPopupText();
		Assert.assertEquals(alertText, "Hi there, pal!");
		
		log.info("[TEST SUCCESS : verifyAlertPopupText]");
	}
	
	@Test(description = "TC_AN_PP_02", priority = 2)
	public void verifyConfirmPopupOkText()
	{
		log.info("[TEST STARTED : verifyConfirmPopupOkText]");
		
		PopupsPage pp = new HomePage(driver).clickHome().navigatePopupPage();
		
		String message = pp.clickConfirmPopup().confirmPopupGetOkMessage();
		Assert.assertEquals(message, "OK it is!");
		
		log.info("[TEST SUCCESS : verifyConfirmPopupOkText]");
	}
	
	@Test(description = "TC_AN_PP_03", priority = 3)
	public void verifyConfirmPopupCancelText()
	{
		log.info("[TEST STARTED : verifyConfirmPopupOkText]");
		
		PopupsPage pp = new HomePage(driver).clickHome().navigatePopupPage();
		
		String message = pp.clickConfirmPopup().confirmPopupGetCancelMessage();
		System.out.println(message);
		Assert.assertEquals(message, "Cancel it is!");
		
		log.info("[TEST SUCCESS : verifyConfirmPopupOkText]");
	}
	
	@Test(description = "TC_AN_PP_04", priority = 4)
	public void verifyPromptPopupNoValueText()
	{
		log.info("[TEST STARTED : verifyConfirmPopupOkText]");
		
		PopupsPage pp = new HomePage(driver).clickHome().navigatePopupPage();
		
		String message = pp.clickPromptPopup().promptPopupGetMessageBlankEntry();
		System.out.println(message);
		Assert.assertEquals(message, "Fine, be that way...");
		
		log.info("[TEST SUCCESS : verifyConfirmPopupOkText]");
	}
	
	@Test(description = "TC_AN_PP_05", priority = 5)
	public void verifyPromptPopupValueText()
	{
		log.info("[TEST STARTED : verifyConfirmPopupOkText]");
		
		String myVal = "NMDP";
		PopupsPage pp = new HomePage(driver).clickHome().navigatePopupPage();
		
		String message = pp.clickPromptPopup().promptPopupGetMessageTextEntry(myVal);
		System.out.println(message);
		Assert.assertEquals(message, "Nice to meet you, "+myVal+"!");
		
		log.info("[TEST SUCCESS : verifyConfirmPopupOkText]");
	}
	
	@Test(description = "TC_AN_PP_06", priority = 6)
	public void verifyTooltipText()
	{
		log.info("[TEST STARTED : verifyConfirmPopupOkText]");
		
		PopupsPage pp = new HomePage(driver).clickHome().navigatePopupPage();
		
		String message = pp.clickTooltipField().getTooltipText();
		System.out.println(message);
		Assert.assertEquals(message, "Cool text");
		
		log.info("[TEST SUCCESS : verifyConfirmPopupOkText]");
	}
	
}

