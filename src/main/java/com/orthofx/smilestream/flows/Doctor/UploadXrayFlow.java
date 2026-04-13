package com.orthofx.smilestream.flows.Doctor;

import org.openqa.selenium.WebDriver;

import com.orthofx.smilestream.base.BaseTest;
import com.orthofx.smilestream.pages.doctor.UploadXrayPage;

import utils.ExcelUtils;

public class UploadXrayFlow extends BaseTest {
	public UploadXrayFlow(WebDriver driver, ExcelUtils excel, String excelPath) {
        this.driver = driver;
        this.excel = excel;
        this.excelPath = excelPath;
    }
	public void uploadXray() throws Exception {
		UploadPhotoFlow uf=new UploadPhotoFlow(driver, excel, excelPath);
		uf.photoUpload();
		UploadXrayPage up=new UploadXrayPage(driver);
        String photoPath =System.getProperty("user.dir") + "/src/test/java/resources/images/1.jpg";
        up.uploadXray(photoPath);
        up.clickcontinue();
	}


}
