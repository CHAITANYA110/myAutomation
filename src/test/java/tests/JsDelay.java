package tests;



import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.JsDelayPage;

public class JsDelay extends BaseClass{
	
	
	@Test(priority=1)
	public void verifyJsDelay()
	{
		JsDelayPage jdp = new HomePage(driver).clickHome().navigateJsDelayPage();
		
		jdp.clickStartBtn().verifyTextPostDelay();
		
	}

}
