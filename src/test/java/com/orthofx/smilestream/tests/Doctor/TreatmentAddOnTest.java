package com.orthofx.smilestream.tests.Doctor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orthofx.smilestream.base.BaseTest;
import com.orthofx.smilestream.flows.Doctor.PlanTypeFlow;
import com.orthofx.smilestream.flows.Doctor.TreatmentAddOnsFlow;
import com.orthofx.smilestream.pages.doctor.TreatmentAddOnPage;

import utils.PropertyReader;

public class TreatmentAddOnTest extends BaseTest {
	TreatmentAddOnPage tp;
	TreatmentAddOnsFlow tf;
	PlanTypeFlow pf;
	
	@BeforeMethod(alwaysRun=true)
	public void setupObject() {
		tp= new TreatmentAddOnPage(driver);
		tf=new TreatmentAddOnsFlow(driver,excel,excelPath);
		pf=new PlanTypeFlow(driver,excel,excelPath);
		
	}
	
	//verify the user is able to add the treatment add ons and continue
	//@Test
	public void treatmentAddOnComplete() throws Exception {
		tf.selectTreatmentAddOn();
		Assert.assertTrue(tp.orderSummaryDisplayed(),"order summary pop up is displayed");
		

	}
	
	//@Test
	//verify the user is able to select Rescue Aligner
	public void verifyRescueAlignerSelection() throws Exception {
		pf.selectPlanTypeWithData();
		tp.selectRescueAligner();
		Assert.assertTrue(tp.rescueAlignerChecked(),"rescue Aligner is not checked");
		
	}
	//@Test
	//verify the user is able to select Services
	public void verifyServicesSelection() throws Exception {
		pf.selectPlanTypeWithData();
        tp.selectServices();
		Assert.assertTrue(tp.isServicesChecked(),"service is not checked");

}
	//@Test
	//verify the user is able to get the enter valid phone number message
	 public void verifyInvalidPhoneNumberMessage() throws Exception {
			pf.selectPlanTypeWithData();
			tp.eneterPhoneNumeber("12345");
			tp.invalidPhoneNumberDisplayed();
			

	 }
	//@Test(groups="run")
	//verify the user is able to get the enter valid email message displayed
		 public void verifyInvalidemailMessage() throws Exception {
				pf.selectPlanTypeWithData();
				tp.generateInvalidEmail();
				tp.invalidemailDisplayed();

				

		 }
	//@Test
	//verify validation message is there for the custom price,email and phonenumber
	public void validationMessageDisplayed() throws Exception {
		pf.selectPlanTypeWithData();
		tp.clickcontinue();
		Assert.assertTrue(tp.isValidationMessageDisplayed("Phone Number"));
	    Assert.assertTrue(tp.isValidationMessageDisplayed("Email"));
	    Assert.assertTrue(tp.isValidationMessageDisplayed("Enter Custom Price"));
		 
	}
	
	@Test
	//verify the user is able to redirect to the custom price page
	public void customPricePage() throws Exception {
		pf.selectPlanTypeWithData();
		tp.clickCustomPriceButton();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://s2pro.orthofx.com/professional/org-management/practices/"),"Custom price page not displayed");
		Thread.sleep(10000);
	}
	
		 
	 
	
	
	

}
