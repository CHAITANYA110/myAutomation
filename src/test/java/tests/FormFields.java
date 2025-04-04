package tests;

import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.FormFieldsPage;




public class FormFields extends BaseClass{
    
    public FormFields() {
        super();
    }
    
    @Test(description="TC_AN_FF_01", priority = 1)
    public void submitFormOnlyMandatory() throws InterruptedException
    {
    	FormFieldsPage ffp = new FormFieldsPage(driver);
    	ffp.navigateFormField().enterName().clickSubmit();
    	String successMsg = ffp.getSuccessMsg();
    	Assert.assertEquals(successMsg, "Message received!");
    	ffp.clickOkonAlertPopup();
    }
    
    @Test(description="TC_AN_FF_02", priority =2)
    public void submitFormAllFields() throws InterruptedException
    {
    	
    	FormFieldsPage ffp = new FormFieldsPage(driver);
    	ffp.navigateHome().navigateFormField().enterName().enterPassword()
    	.selectDrink().selectAutomationLikness().enterEmail()
    	.selectColor().enterMassage().clickSubmit();
    	String successMsg = ffp.getSuccessMsg();
    	Assert.assertEquals(successMsg, "Message received!");
    	ffp.clickOkonAlertPopup();
    }
    
    @Test(description="TC_AN_FF_03", priority =3)
    public void submitFormWithoutMandatory() throws InterruptedException
    {
    	FormFieldsPage ffp = new FormFieldsPage(driver);
    	ffp.navigateHome().navigateFormField().enterPassword()
    	.selectDrink().selectAutomationLikness().enterEmail()
    	.selectColor().enterMassage().clickSubmit();
    	boolean mandatoryCheck = ffp.requiredAlert();
    	Assert.assertTrue(mandatoryCheck);
    }
    
    @Test(description="TC_AN_FF_03.2", priority =4)
    public void skippedTest() {
        System.out.println("Skipping this test intentionally...");
        throw new SkipException("Skipping this test case because of some condition.");
    }

    @Test(description="TC_AN_FF_03.3", priority =5)
    public void myFail() throws InterruptedException, IOException
    {
    	Assert.fail();
    }
}
