package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PopupsPage {
	
	WebDriver driver;
	
	@FindBy(id="alert")
	private WebElement alertPopup;
	@FindBy(id="confirm")
	private WebElement confirmPopup;
	@FindBy(id="prompt")
	private WebElement promptPopup;
	
	@FindBy(id="confirmResult")
	private WebElement confirmPopupMessage;
	@FindBy(id="promptResult")
	private WebElement promptPopupMessage;
	
	@FindBy(xpath="//div[@class='tooltip_1']")
	private WebElement getTooltipField;
	@FindBy(id="myTooltip")
	private WebElement tooltipDisplayed;
	
	public PopupsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public PopupsPage clickAlertPopup()
	{
		alertPopup.click();
		return this;
	}
	
	public PopupsPage clickConfirmPopup()
	{
		confirmPopup.click();
		return this;
	}
	
	public PopupsPage clickPromptPopup()
	{
		promptPopup.click();
		return this;
	}
	
	public PopupsPage clickTooltipField()
	{
		getTooltipField.click();
		return this;
	}
	
	public String getTooltipText()
	{
		String val =tooltipDisplayed.getText();
		return val;
	}
	
	public String verifyAlertPopupText()
	{
		Alert al =  driver.switchTo().alert();
		String alertText =al.getText();
		al.accept();
		return alertText;
	}
	public String confirmPopupGetOkMessage()
	{
		driver.switchTo().alert().accept();
		String msg = confirmPopupMessage.getText();
		return msg;
	}
	
	public String confirmPopupGetCancelMessage()
	{
		driver.switchTo().alert().dismiss();
		String msg = confirmPopupMessage.getText();
		return msg;
	}
	
	public String promptPopupGetMessageBlankEntry()
	{
		driver.switchTo().alert().accept();
		String msg = promptPopupMessage.getText();
		return msg;
	}
	
	public String promptPopupGetMessageTextEntry(String val)
	{
		Alert al = driver.switchTo().alert();
		al.sendKeys(val);
		al.accept();
		String msg = promptPopupMessage.getText();
		return msg;
	}
	
	

}
