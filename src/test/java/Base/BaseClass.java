package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	WebDriver driver;
	
	@BeforeTest
	public void start() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	@Test
	public void myTest()
	{
		System.out.println("My Test Pass");
	}
	
	@AfterTest
	public void end()
	{
		driver.quit();
	}

}
