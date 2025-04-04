
package utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BaseClass;

public class Report implements ITestListener{
	
	public ExtentSparkReporter esr;
	public ExtentReports er;
	public ExtentTest et;
	
	String reportPath;
	
	public void onStart(ITestContext context)
	{
		
		String timeStamp = new SimpleDateFormat("yyyy_MM_ddd_hh_mm_ss").format(new Date());
		String reportName= "AutomationReport-"+timeStamp+".html";
		
		
		//String reportPath = System.getProperty("user.dir") + "/reports/myReport.html";
		reportPath = System.getProperty("user.dir") + "/reports/" + reportName;
		
		esr = new ExtentSparkReporter(reportPath);
		esr.config().setDocumentTitle("My Extent Report");
		esr.config().setReportName("Automation Test Report");
		esr.config().setTheme(Theme.DARK);
		
		er = new ExtentReports();
		er.attachReporter(esr);
		
		er.setSystemInfo("Computer Name", "localHost");
		er.setSystemInfo("Environment", "QA");
		er.setSystemInfo("ABCD", "1234");
		
		
	}
	
	public void onTestSuccess(ITestResult result)
	{
		et = er.createTest(result.getName());
		et.log(Status.PASS, "Test Case PASSED: "+result.getName());
	}
	
	public void onTestFailure(ITestResult result)
	{
		String testName = result.getName();
		
		et = er.createTest(testName);
		et.log(Status.FAIL, "Test Case FAILED: "+testName);
		//et.log(Status.INFO, "Failure Description: "+result.getThrowable());
		
		try {
			String imagePath = BaseClass.screenCapture(testName);
			//not using new BaseClass().screenCapture() because it creates new instance and webdiver flow breaks
			//captureScreen() method in BaseClass is code to take screenshot and return imagePath
			//captureScreen is kept static because we are not creating new object of baseClass and static method can be called without creating objecting
			et.addScreenCaptureFromPath(imagePath);
			// it fetched the screenshot from the given path and add to report
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public void onTestSkipped(ITestResult result)
	{
		et = er.createTest(result.getName());
		et.log(Status.SKIP, "Test Case SKIPPED: "+result.getName());
	}
	
	public void onFinish(ITestContext context)
	{
		er.flush();
		Email.sendEmailWithReport(reportPath);  // Send Report via Email
	}
}

