package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
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

   
}
