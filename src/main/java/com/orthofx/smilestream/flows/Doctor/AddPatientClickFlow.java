package com.orthofx.smilestream.flows.Doctor;

import org.openqa.selenium.WebDriver;

import com.orthofx.smilestream.base.BaseTest;
import com.orthofx.smilestream.base.TestContext;
import com.orthofx.smilestream.pages.doctor.PatientListingPage;

import utils.ExcelUtils;

public class AddPatientClickFlow extends BaseTest{
	
	WebDriver driver;
    ExcelUtils excel;
    String excelPath;

    // Use a constructor to "receive" the data
    public AddPatientClickFlow(WebDriver driver, ExcelUtils excel, String excelPath) {
        this.driver = driver;
        this.excel = excel;
        this.excelPath = excelPath;
    }
    
	private TestContext context;

   /* public AddPatientClickFlow(TestContext context) {
        this.context = context;
    }*/
    

	
	
	
	public void clickAddPatient() throws Exception {
		LoginFlow lf = new LoginFlow(driver, excel, excelPath);

		lf.login(2);
		PatientListingPage pl = new PatientListingPage(driver);
		Thread.sleep(10000);
		pl.addPatientIsVisible();
		pl.clickAddPatient();
		pl.firstNameTestVisible();

	}
}
