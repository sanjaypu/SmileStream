package com.orthofx.smilestream.tests.Doctor;
import org.testng.annotations.BeforeMethod;  


import static org.testng.Assert.assertTrue;

import org.junit.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orthofx.smilestream.base.BaseTest;
import com.orthofx.smilestream.flows.Doctor.AddPatientClickFlow;
import com.orthofx.smilestream.flows.Doctor.PatientCreationFlow;
import com.orthofx.smilestream.pages.doctor.PatientCreationPage;

public class PatientCreationTest extends BaseTest {
	PatientCreationFlow pc;
	PatientCreationPage pp;
	AddPatientClickFlow ap;
	protected String photoPath;

@BeforeMethod(alwaysRun=true)
	public void setupObject() {
		pc = new PatientCreationFlow(driver, excel, excelPath);
		pp = new PatientCreationPage(driver);
		ap = new AddPatientClickFlow(driver, excel, excelPath);

	}

	// verify the user is able create the patient
	@Test(groups= {"patient_creation","regression"})
	public void patientCreation() throws Exception {
		pc.PatientCreation("sanjay", "Test","03292000","11111");
		Assert.assertTrue(pp.selectTreatmmentTypeVisible());
	}

	// verify the user is able to see the validation message
	@Test(groups= {"patient_creation","regression"})
	public void validationMessage() throws Exception {

		ap.clickAddPatient();
		pp.clickContinue();
		Assert.assertTrue(pp.errorMessageDisplayed());
	}

	// verify the user is able to upload the phot
	@Test(groups= {"patient_creation","regression"})

	public void uploadPhoto() throws Exception {
		ap.clickAddPatient();
		photoPath = System.getProperty("user.dir") + "/src/test/java/resources/images/1.jpg";
		pp.uploadPhoto(photoPath);
		Assert.assertTrue(pp.imgRemoveIsDisplayed());

	}
	
	//verify the user is able to open the terms and condition
	@Test(groups= {"patient_creation","regression"})
	public void termsAndCondition() throws Exception {
		ap.clickAddPatient();
		pp.termsandCondition();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.orthofx.com/terms"),"Terms and condition not opened");
		
	}
	
	@Test(groups= {"patient_creation","regression"})
	
	// verify the user is able to see the patient has a guardian textfield
	public void guardianCheckBoxDisplayed() throws Exception {
		ap.clickAddPatient();
		pp.guardianTextFieldIsDisplayed();
	}
	
	
	
}
