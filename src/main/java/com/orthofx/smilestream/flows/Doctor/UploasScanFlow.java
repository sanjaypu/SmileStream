package com.orthofx.smilestream.flows.Doctor;

import org.openqa.selenium.WebDriver;

import com.orthofx.smilestream.base.BaseTest;
import com.orthofx.smilestream.pages.doctor.UploadScanPage;

import utils.ExcelUtils;

public class UploasScanFlow extends BaseTest{
	public UploasScanFlow(WebDriver driver, ExcelUtils excel, String excelPath) {
        this.driver = driver;
        this.excel = excel;
        this.excelPath = excelPath;
    }
	public void upperAndLowerScanUpload() throws Exception {
		TreatmentAddOnsFlow tf=new TreatmentAddOnsFlow(driver, excel, excelPath);
		tf.selectTreatmentAddOn();
		UploadScanPage up=new UploadScanPage(driver);
		up.directUploadSelect();
		String photoPath = System.getProperty("user.dir") + "/src/test/java/resources/images/new1 2.zip";
		up.uploadUpperScan(photoPath);
		up.uploadLowerScan(photoPath);
		up.clickcontinue();		

	}

}
