package com.orthofx.smilestream.flows.Doctor;

import org.openqa.selenium.WebDriver;

import com.orthofx.smilestream.base.BaseTest;
import com.orthofx.smilestream.pages.doctor.TreatmentAddOnPage;

import utils.ExcelUtils;

public class TreatmentAddOnsFlow extends BaseTest {

	public TreatmentAddOnsFlow(WebDriver driver, ExcelUtils excel, String excelPath) {
        this.driver = driver;
        this.excel = excel;
        this.excelPath = excelPath;
    }
	public void selectTreatmentAddOn() throws Exception {
		
		PlanTypeFlow pf=new PlanTypeFlow(driver,excel,excelPath);
		pf.selectPlanType("AirFlex","FX10");
		TreatmentAddOnPage tp=new TreatmentAddOnPage(driver);
		tp.selectServices();
		tp.eneterPhoneNumeber("1111111111");
		tp.enetervalidEmail();
		tp.eneterCustomPrice("4000");
		tp.clickcontinue();
		Thread.sleep(5000);
		tp.clickAcceptAndContinue();
		
		
		
		
	}
	
}
