package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class JsDelayPage{
	
	WebDriver driver;
	
	@FindBy(id="start")
	private WebElement startBtn;
	
	@FindBy(id="delay")
	private WebElement verificationText;
	
	public JsDelayPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public JsDelayPage clickStartBtn()
	{
		startBtn.click();
		return this;
	}
	
	public void verifyTextPostDelay()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(verificationText, "Liftoff!"));
		// Explicit wait and string assertion, both works here
		
	}
	
	

}
