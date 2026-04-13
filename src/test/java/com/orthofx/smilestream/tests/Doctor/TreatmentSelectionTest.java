package com.orthofx.smilestream.tests.Doctor;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orthofx.smilestream.base.BaseTest;
import com.orthofx.smilestream.flows.Doctor.TreatmentSelectionFlow;

public class TreatmentSelectionTest extends BaseTest {
	TreatmentSelectionFlow pf;
	
	@BeforeMethod(alwaysRun=true)
        public void setupObject(){
		pf=new TreatmentSelectionFlow(driver,excel,excelPath);
	}
	@Test
	//verify the user is able to select aligner as product
	public void alignerTreatmentSucessfull() throws Exception {
		pf.selectTreatmentAligner();
	}
	@Test
	//verify the user is able to select retainer as product
	public void retianerTreatmentSucessfull() throws Exception {
		pf.selectTreatmentRetainer();
	} 
	@Test
	//verify the user is able to select relapse correction as product
	public void relapseTreatmentSucessfull() throws Exception {
		pf.selectTreatmentRelapse();
	} 

	
}
