package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


import org.apache.logging.log4j.LogManager; //log
import org.apache.logging.log4j.Logger;     //log

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	//Making the WebDriver static in the BaseClass ensures that a single instance of the driver is shared across all test classes.
	public Logger log;
	public Properties prop;
	
	
	@BeforeClass
	@Parameters({"browser"})
	public void start(@Optional("chrome")String browserName) throws IOException
	{
		//@Optional("chrome") -> when no browser val is passed(when running test directly)
		prop = new Properties();
		FileInputStream fs = new FileInputStream("Resources/config.properties");
		prop.load(fs);
		
		if(browserName.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();}
		
		else if(browserName.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();}
		
		else if(browserName.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		String appUrl = prop.getProperty("url");
		driver.get(appUrl);
		
		
		log = LogManager.getLogger(this.getClass());
		log.info("=================== TEST CLASS STARTED ===================");
	}
	
	 @AfterClass
	public void end()
	{
		driver.quit();
		log.info("=================== TEST CLASS ENDED ===================");
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
