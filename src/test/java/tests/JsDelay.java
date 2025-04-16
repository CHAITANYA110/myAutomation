package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


import base.BaseClass;
import pages.HomePage;
import pages.JsDelayPage;
import pages.SliderPage;

public class JsDelay extends BaseClass{
	
	
	@Test(priority=1)
	public void verifyJsDelay()
	{
		log.info("[TEST STARTED : verifyJsDelay]");
		
		JsDelayPage jdp = new HomePage(driver).clickHome().navigateJsDelayPage();
		jdp.clickStartBtn().verifyTextPostDelay();
		
		log.info("[TEST SUCCESS : verifyJsDelay]");
	}
	

}
