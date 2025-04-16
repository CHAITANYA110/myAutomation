package pages;

import java.util.LinkedHashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.WebElement;


public class CalendarPage {

	WebDriver driver;

	@FindBy(xpath = "//input[contains(@id,'selectorenteradate')]")
	WebElement calendarField;
	@FindBy(xpath = "//span[@class='ui-datepicker-month']")
	WebElement month;
	@FindBy(xpath = "//span[@class='ui-datepicker-year']")
	WebElement year;
	@FindBy(xpath = "//a[@title = 'Next']")
	WebElement nextArrow;
	@FindBy(xpath = "//a[@title = 'Prev']")
	WebElement prevArrow;
	

	public LinkedHashMap<String, Integer> monthMap = new LinkedHashMap<>();

	public CalendarPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public CalendarPage clickCalendar() {
		calendarField.click();
		loadHashMap();
		return this;
	}

	public void loadHashMap() {
		monthMap.put("January", 1);
		monthMap.put("February", 2);
		monthMap.put("March", 3);
		monthMap.put("April", 4);
		monthMap.put("May", 5);
		monthMap.put("June", 6);
		monthMap.put("July", 7);
		monthMap.put("August", 8);
		monthMap.put("September", 9);
		monthMap.put("October", 10);
		monthMap.put("November", 11);
		monthMap.put("December", 12);
	}

	public String selectDate(int myDate, String myPassedMonth, int myYear) {
		String myStringMonth;
		String yearDisplayed = year.getText();
		int yearDisplayedInNum = Integer.parseInt(yearDisplayed);
		
		// 2023 < 2025
				if (myYear < yearDisplayedInNum) {
					int iteration = 12*(yearDisplayedInNum - myYear);
					for (int i = 0; i < iteration; i++) {
						prevArrow.click();
					}
				}
				// 2028 > 2025
				else if (myYear > yearDisplayedInNum) {
					int iteration2 = 12*(myYear - yearDisplayedInNum);
					for (int i = 0; i < iteration2; i++) {
						nextArrow.click();
					}
				}
				
				
				int myMonth = monthMap.get(myPassedMonth);
				int monthDisplayed = monthMap.get(month.getText());

				// 4 < 7
				if (myMonth < monthDisplayed) {
					int iteration3 = monthDisplayed - myMonth;
					for (int i = 0; i < iteration3; i++) {
						prevArrow.click();
					}
				}
				// 7 > 4
				else if (myMonth > monthDisplayed) {
					int iteration4 = myMonth - monthDisplayed;
					for (int i = 0; i < iteration4; i++) {
						nextArrow.click();
					}
				}

				// Clicking the date as per value passed by method
				driver.findElement(By.xpath("//a[@data-date='"+myDate+"']")).click();
				
				// '09' is needed for assertion instead '9'
				if(myMonth<10)
				{
					myStringMonth = "0"+myMonth;
				}
				else
				{
					myStringMonth = String.valueOf(myMonth);
				}
				
				return myStringMonth;
	}
	
	public String getDate()
	{
		// getText() won’t work on <input> elements — it returns an empty string.
		String dateString = calendarField.getAttribute("value");
		return dateString;
	}
}
					
					
	