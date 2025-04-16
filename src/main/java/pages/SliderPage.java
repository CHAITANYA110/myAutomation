package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SliderPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='slideMe']")
	WebElement slider;
	
	@FindBy(id="value")
	WebElement currentVal;
	
	public SliderPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public int calculateOffsetValue(int x)
	{
		double m = 0.073;
        double c = 50;
        int offset = x;
        
        int value =  (int) ((m * offset) + c);
        return value;
	}
	
	public int slideIt(int x, int y)
	{
		Actions act = new Actions(driver);
		act.moveToElement(slider, x, y).click().perform();
		String val = currentVal.getText();
		int intVal = Integer.parseInt(val);
		return intVal;
	}
	
	public int slideDnD(int x, int y)
	{
		Actions act = new Actions(driver);
		act.dragAndDropBy(slider, x, y).perform();
		String val = currentVal.getText();
		int intVal = Integer.parseInt(val);
		return intVal;
	}
}
