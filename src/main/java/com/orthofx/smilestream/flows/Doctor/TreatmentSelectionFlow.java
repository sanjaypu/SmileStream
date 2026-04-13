package com.orthofx.smilestream.flows.Doctor;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import com.orthofx.smilestream.base.BaseTest;
import com.orthofx.smilestream.pages.doctor.TreatmentSelectionPage;

import utils.ExcelUtils;

public class TreatmentSelectionFlow extends BaseTest {
	
	public TreatmentSelectionFlow(WebDriver driver, ExcelUtils excel, String excelPath) {
        this.driver = driver;
        this.excel = excel;
        this.excelPath = excelPath;
    }
	
	public void selectTreatmentAligner() throws Exception {
		PatientCreationFlow pf = new PatientCreationFlow(driver, excel, excelPath);
        pf.PatientCreation("Sanjay","Test","03292000","11111");
		TreatmentSelectionPage pp=new TreatmentSelectionPage(driver);
        pp.selectTreatment("Aligner");
	}
	public void selectTreatmentRetainer() throws Exception {
		PatientCreationFlow pf = new PatientCreationFlow(driver, excel, excelPath);
        pf.PatientCreation("Sanjay","Test","03292000","11111");
		TreatmentSelectionPage pp=new TreatmentSelectionPage(driver);
        pp.selectTreatment("Retainer");
	}
	public void selectTreatmentRelapse() throws Exception {
		PatientCreationFlow pf = new PatientCreationFlow(driver, excel, excelPath);
        pf.PatientCreation("Sanjay","Test","03292000","11111");
		TreatmentSelectionPage pp=new TreatmentSelectionPage(driver);
        pp.selectTreatment("Relapse Correction");
	}

}
