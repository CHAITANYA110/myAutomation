package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class FormFieldsPage{
	
	WebDriver driver;
	
	@FindBy(xpath="//a[@class='wp-block-button__link wp-element-button' and text()='Form Fields']")
	private WebElement formFieldsTab;
	@FindBy(id="name-input")
	private WebElement name;
	@FindBy(id="submit-btn")
	private WebElement submitBtn;
	@FindBy(id="to-top")
	private WebElement upArrow;
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy(id="drink1")
	private WebElement drink1;
	@FindBy(id="drink2")
	private WebElement drink2;
	@FindBy(id="color4")
	private WebElement color;
	@FindBy(id="automation")
	private WebElement automationLikness;
	@FindBy(id="email")
	private WebElement email;
	@FindBy(id="message")
	private WebElement message;
	@FindBy(xpath="//*[contains(text(),'* Required')]")
	private WebElement required;
	@FindBy(xpath="//*[@class='attachment-full size-full']")
	private WebElement home;
	
	
	
	//CONSTRUCTOR
	public FormFieldsPage(WebDriver driver)
	{
		this.driver= driver;	
		PageFactory.initElements(driver, this);
	}
	
	public FormFieldsPage navigateFormFieldxxx()
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
	
	public FormFieldsPage clickSubmit() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", submitBtn);
		/*
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(driver -> {
	        Long scrollPosition = (Long) js.executeScript("return window.scrollY;");
	        return scrollPosition != null; // This ensures scroll is completed
	    });
	    wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
	    wait.until(ExpectedConditions.visibilityOf(submitBtn)).click();*/
		Thread.sleep(2000);
		submitBtn.click();
	    return this;
	}
	public String getSuccessMsg()
	{
		Alert al =driver.switchTo().alert();
		String alertText = al.getText();
		return alertText;
	}
	public void clickOkonAlertPopup()
	{
		Alert al = driver.switchTo().alert();
		al.accept();
	}
	
	public FormFieldsPage clickUpArrow()
	{
		upArrow.click();
		return this;
	}
	
	public FormFieldsPage enterPassword()
	{
		password.sendKeys("abc@234");
		return this;
	}
	
	public FormFieldsPage selectDrink()
	{
		drink1.click();
		drink2.click();
		return this;
	}
	public FormFieldsPage selectColor()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", color);
		return this;
	}
	public FormFieldsPage selectAutomationLikness()
	{
		Select sel = new Select(automationLikness);
		sel.selectByValue("yes");
		return this;
	}
	public FormFieldsPage enterEmail()
	{
		email.sendKeys("anand@gmail.com");
		return this;
	}
	public FormFieldsPage navigateHome()
	{
		home.click();
		return this;
	}
	public FormFieldsPage enterMassage()
	{
		message.sendKeys("Our platform streamlines workflow automation, enhancing efficiency and productivity. With a user-friendly interface and robust integration capabilities, it simplifies complex processes, reduces manual effort, and ensures seamless collaboration. Designed for scalability, it adapts to evolving business needs while maintaining security and compliance. Experience a smarter way to manage tasks with our innovative solution.");
		return this;
	}
	public boolean requiredAlert()
	{
		boolean mandatoryCheck = required.isDisplayed();
		return mandatoryCheck;
	}
	

}
