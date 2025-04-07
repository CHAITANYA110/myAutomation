package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage{
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@data-image-title='automateNow Logo']")
	private WebElement homeIcon;
	
	@FindBy(xpath="//a[contains(text(),'JavaScript Delays')]")
	private WebElement javaScriptDelay;
	
	@FindBy(xpath="//a[contains(text(),'Form Fields')]")
	private WebElement formFields;
	
	@FindBy(xpath="//a[contains(text(),'Popups')]")
	private WebElement popups;
	
	public HomePage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public HomePage clickHome()
	{
		homeIcon.click();
		return this;
	}
	
	public FormFieldsPage navigateFormFieldsPage()
	{
		formFields.click();
		return new FormFieldsPage(driver);
		// Returning object of FormFieldsPage
	}	
	
	public JsDelayPage navigateJsDelayPage()
	{
		javaScriptDelay.click();
		return new JsDelayPage(driver);
	}
	
	public PopupsPage navigatePopupPage()
	{
		popups.click();
		return new PopupsPage(driver);
	}
	

}
