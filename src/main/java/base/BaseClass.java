package base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	protected static WebDriver driver;
	//Making the WebDriver static in the BaseClass ensures that a single instance of the driver is shared across all test classes.
	
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
	 
	 public static String screenCapture(String testName) throws IOException
	 {
		 
		 String timeStamp = new SimpleDateFormat("yyyy_MM_ddd_hh_mm_ss").format(new Date());
		 
		 TakesScreenshot tss = (TakesScreenshot)driver;
		 File src = tss.getScreenshotAs(OutputType.FILE);
		 
		 String trgFilepath = System.getProperty("user.dir")+"/screenshots/"+testName+"_"+timeStamp+".png";
		 File trg = new File(trgFilepath);
		 
		 FileUtils.copyFile(src, trg);
		 
		 return trgFilepath;

		 
	 }


}
