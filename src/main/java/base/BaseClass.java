package base;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	protected WebDriver driver;
	
	@BeforeTest
	public void start() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://practice-automation.com/");
		driver.manage().window().maximize();
		

		//naviateURL(); //[class of befTest & naviateURL is same, thus when befTest is called, naviateURL can be call without object]
	}
	
	 @AfterTest
	public void end()
	{
		driver.quit();
	}


}
