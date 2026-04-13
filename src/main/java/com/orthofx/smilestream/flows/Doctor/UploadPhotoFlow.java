package com.orthofx.smilestream.flows.Doctor;

import org.openqa.selenium.WebDriver;

import com.orthofx.smilestream.base.BaseTest;
import com.orthofx.smilestream.pages.doctor.PhotoUploadPage;

import utils.ExcelUtils;

public class UploadPhotoFlow extends BaseTest {
	public UploadPhotoFlow(WebDriver driver, ExcelUtils excel, String excelPath) {
        this.driver = driver;
        this.excel = excel;
        this.excelPath = excelPath;
    }
	
	public void photoUpload() throws Exception {
	UploasScanFlow uf=new UploasScanFlow(driver, excel, excelPath);
	uf.upperAndLowerScanUpload();
	PhotoUploadPage pp=new PhotoUploadPage(driver);
	String photoPath = System.getProperty("user.dir") + "/src/test/java/resources/images/1.jpg";
	pp.uploadPhoto(photoPath);
	pp.clickcontinue();
	
	}

}
