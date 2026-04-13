package com.orthofx.smilestream.flows.Doctor;

import org.openqa.selenium.WebDriver;

import com.orthofx.smilestream.base.BaseTest;
import com.orthofx.smilestream.pages.doctor.PlanTypePage;

import utils.ExcelUtils;

public class PlanTypeFlow extends BaseTest {
	public PlanTypeFlow(WebDriver driver, ExcelUtils excel, String excelPath) {
        this.driver = driver;
        this.excel = excel;
        this.excelPath = excelPath;
    }
	 public void selectPlanType(String ProductName,String Plantype) throws Exception {
		 ProductSelectionFlow pf=new ProductSelectionFlow(driver, excel, excelPath);
		 pf.SelectProduct(ProductName);
		PlanTypePage pp=new PlanTypePage(driver);
		pp.selectPlanType(Plantype);
}
	 public void selectPlanTypeWithData() throws Exception {
		 ProductSelectionFlow pf=new ProductSelectionFlow(driver, excel, excelPath);
		 pf.SelectProduct("AirFlex");
		PlanTypePage pp=new PlanTypePage(driver);
		pp.selectPlanType("FXFull");
}
	
		
	}


