package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class FormFieldsPage extends BaseClass{
	
	WebDriver driver;
	
	@FindBy(xpath="//a[@class='wp-block-button__link wp-element-button' and text()='Form Fields']")
	WebElement formFieldsTab;
	@FindBy(id="name-input")
	WebElement name;
	
	
	
	@FindBy(id="submit-btn")
	WebElement submitBtn;
	
	//CONSTRUCTOR
	public FormFieldsPage(WebDriver driver)
	{
		this.driver= driver;	
		PageFactory.initElements(driver, this);
	}
	
	
	public FormFieldsPage navigateFormField()
	{
		formFieldsTab.click();
		return this;
	}
	
	public FormFieldsPage enterName()
	{
		//name.click();
		name.sendKeys("Chaitanya");
		return this;
	}
	
	public FormFieldsPage clickSubmit()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", submitBtn);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(driver -> {
	        Long scrollPosition = (Long) js.executeScript("return window.scrollY;");
	        return scrollPosition != null; // This ensures scroll is completed
	    });
	    
	    wait.until(ExpectedConditions.visibilityOf(submitBtn));
	    
	    wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
	    return this;
	}

}
