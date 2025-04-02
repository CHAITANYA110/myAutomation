package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.FormFieldsPage;




public class FormFields extends BaseClass{
    
    public FormFields() {
        super();
    }
    
    @Test(description="TC_AN_FF_01", priority = 1)
    public void submitFormOnlyMandatory()
    {
    	FormFieldsPage ffp = new FormFieldsPage(driver);
    	ffp.navigateFormField().enterName().clickSubmit();
    }

   
}
