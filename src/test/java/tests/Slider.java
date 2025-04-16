package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.SliderPage;

public class Slider extends BaseClass{
	
	@Test(priority=1, description = "TC_AN_S_01")
	public void slideUsingHover() throws InterruptedException
	{
		log.info("[TEST STARTED : slideUsingHover]");
		
		int xAxis = 400;
		SliderPage sp = new HomePage(driver).clickHome().navigateSliderPage();
		int currentVal = sp.slideIt(xAxis,0);
		int expectedVal = sp.calculateOffsetValue(xAxis);
		System.out.println(expectedVal);
		Assert.assertEquals(currentVal, expectedVal);
		
		log.info("[TEST SUCCESS : slideUsingHover]");
	}
	
	@Test(priority=2, description = "TC_AN_S_02")
	public void slideUsingDragDrop() throws InterruptedException
	{
		log.info("[TEST STARTED : slideUsingDragDrop]");
		
		int xAxis = 400;
		SliderPage sp = new HomePage(driver).clickHome().navigateSliderPage();
		int currentVal = sp.slideDnD(xAxis,0);
		int expectedVal = sp.calculateOffsetValue(xAxis);
		System.out.println(expectedVal);
		Assert.assertEquals(currentVal, expectedVal);
		
		log.info("[TEST SUCCESS : slideUsingDragDrop]");
	}
}
