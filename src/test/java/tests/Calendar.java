package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.CalendarPage;
import pages.HomePage;

public class Calendar extends BaseClass{
	
	int dateNum;
	String month;
	int yearNum;
	
	@Test(priority =1, description = "TC_AN_CF_01")
	public void futureYearPrevMonth() throws InterruptedException
	{
		log.info("[TEST STARTED : futureYearPrevMonth]");
		dateNum = 11;
		month = "January";
		yearNum = 2028;
		calendarTest();
		log.info("[TEST SUCCESS : futureYearPrevMonth]");
	}
	
	@Test(priority =2, description = "TC_AN_CF_02")
	public void futureYearNextMonth() throws InterruptedException
	{
		log.info("[TEST STARTED : futureYearNextMonth]");
		dateNum = 11;
		month = "July";
		yearNum = 2028;
		calendarTest();
		log.info("[TEST SUCCESS : futureYearNextMonth]");
	}
	
	@Test(priority =3, description = "TC_AN_CF_03")
	public void previousYearPrevMonth() throws InterruptedException
	{
		log.info("[TEST STARTED : previousYearPrevMonth]");
		dateNum = 11;
		month = "January";
		yearNum = 2022;
		calendarTest();
		log.info("[TEST SUCCESS : previousYearPrevMonth]");
	}
	
	@Test(priority =4, description = "TC_AN_CF_04")
	public void previousYearNextMonth() throws InterruptedException
	{
		log.info("[TEST STARTED : previousYearNextMonth]");
		dateNum = 11;
		month = "July";
		yearNum = 2022;
		calendarTest();
		log.info("[TEST SUCCESS : previousYearNextMonth]");
	}
	
	@Test(priority =5, description = "TC_AN_CF_05")
	public void currentYearPrevMonth() throws InterruptedException
	{
		log.info("[TEST STARTED : currentYearPrevMonth]");
		dateNum = 11;
		month = "January";
		yearNum = 2025;
		calendarTest();
		log.info("[TEST SUCCESS : currentYearPrevMonth]");
	}
	
	@Test(priority =6, description = "TC_AN_CF_06")
	public void currentYearNextMonth() throws InterruptedException
	{
		log.info("[TEST STARTED : currentYearNextMonth]");
		dateNum = 11;
		month = "July";
		yearNum = 2025;
		calendarTest();
		log.info("[TEST SUCCESS : currentYearNextMonth]");
	}
	
	@Test(priority =7, description = "TC_AN_CF_07")
	public void currentYearCurrentMonth() throws InterruptedException
	{
		log.info("[TEST STARTED : currentYearCurrentMonth]");
		dateNum = 11;
		month = "April";
		yearNum = 2025;
		calendarTest();
		log.info("[TEST SUCCESS : currentYearCurrentMonth]");
	}
	
	
	public void calendarTest() throws InterruptedException
	{
		CalendarPage cp = new HomePage(driver).clickHome().navigateCalendarPage();
		cp.clickCalendar();
		String monthNum =  cp.selectDate(dateNum, month, yearNum);
		String actDate = cp.getDate();
		String expDate = yearNum+"-"+monthNum+"-"+dateNum;
		Assert.assertEquals(actDate, expDate);

	}

}
