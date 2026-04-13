package com.orthofx.smilestream.flows.Doctor;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import com.orthofx.smilestream.pages.doctor.PatientCreationPage;

import utils.ExcelUtils;

public class PatientCreationFlow {
	

private WebDriver driver;
private ExcelUtils excel;
private String excelPath;	

public PatientCreationFlow(WebDriver driver, ExcelUtils excel, String excelPath) {
    this.driver = driver;
    this.excel = excel;
    this.excelPath = excelPath;
}
	
	public void PatientCreation(String firstname,String lastname,String dob,String zipCode) throws Exception {
		AddPatientClickFlow ap=new AddPatientClickFlow(driver, excel, excelPath);

		ap.clickAddPatient();
		PatientCreationPage pc=new PatientCreationPage(driver);
		pc.enterPateientDetails(firstname,lastname,dob,zipCode);
		
	}

}
