package com.orthofx.smilestream.flows.Doctor;

import org.openqa.selenium.WebDriver;

import com.orthofx.smilestream.base.BaseTest;
import com.orthofx.smilestream.pages.doctor.ProductSelectionPage;

import utils.ExcelUtils;

public class ProductSelectionFlow extends BaseTest {
	public ProductSelectionFlow(WebDriver driver, ExcelUtils excel, String excelPath) {
        this.driver = driver;
        this.excel = excel;
        this.excelPath = excelPath;
    }
	
	
	
	public void SelectProduct(String productName) throws Exception {
		TreatmentSelectionFlow tf=new TreatmentSelectionFlow(driver,excel,excelPath);
		tf.selectTreatmentAligner();
		ProductSelectionPage pp=new ProductSelectionPage(driver);
		pp.selectProduct(productName);
	
	}

}
