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
	public void start()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
	}
	
	@Test
	public void myTest() throws InterruptedException
	{
		driver.get("https://www.flipkart.com/");
		Thread.sleep(2000);
		System.out.println("My Test Pass");
	}
	
	@Test
	public void myTest2() throws InterruptedException
	{
		driver.manage().window().maximize();
		Thread.sleep(3000);
		System.out.println("Flipkart opened up");
	}
	
	@AfterTest
	public void end()
	{
		driver.quit();
	}

}
