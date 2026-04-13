package com.orthofx.smilestream.tests.Doctor;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.orthofx.smilestream.base.BaseTest;
import com.orthofx.smilestream.flows.Doctor.AddPatientClickFlow;
import com.orthofx.smilestream.flows.Doctor.LoginFlow;
import com.orthofx.smilestream.pages.doctor.LoginPage;
import com.orthofx.smilestream.pages.doctor.PatientListingPage;

import utils.ExcelUtils;

public class PatientListingTest extends BaseTest {
// verify the user is able to click on add patient button

	@Test
	public void addPatient() throws Exception {
		
		
		AddPatientClickFlow ap=new AddPatientClickFlow(driver,excel,excelPath);

		ap.clickAddPatient();
	}
	

}
