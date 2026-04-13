package com.orthofx.smilestream.tests.Doctor;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orthofx.smilestream.base.BaseTest;
import com.orthofx.smilestream.flows.Doctor.TreatmentAddOnsFlow;
import com.orthofx.smilestream.flows.Doctor.UploasScanFlow;
import com.orthofx.smilestream.pages.doctor.UploadScanPage;

public class UploadScanTest extends BaseTest {
	TreatmentAddOnsFlow tf;
	UploadScanPage up;
	
	@BeforeMethod(alwaysRun=true)
	public void setupObject() {
		tf=new TreatmentAddOnsFlow(driver,excel,excelPath);
		up=new UploadScanPage(driver);
		
	}
	//@Test
	//verify the user  is able to select the Send scan from scanner
	public void verifySendScanFromScannerIsSelected() throws Exception {
		tf.selectTreatmentAddOn();
		up.SendScanFromscannerSelect();
		Assert.assertTrue(up.isSendScanFromscannerSelected(),"Send scan from scanner is not selected");
		up.clickcontinue();
		Assert.assertTrue(up.uploadScanIsChecked(),"Upload scanner is not checked");

		
	}
	//@Test
	//verify the user is able to select all the scanners
	public void verifyAllScannersCanBeSelected() throws Exception {
		tf.selectTreatmentAddOn();
		up.SendScanFromscannerSelect();
        up.selectAndVerifyAllScanners();
	}
	//@Test
	//Verify the user is able to enter the scanner name
	public void verifyScannerNameCanBeEntered() throws Exception {
		tf.selectTreatmentAddOn();

		up.enterScannerName();
		Assert.assertTrue(up.uploadScanIsChecked(),"Upload scanner is not checked");
	}
	//verify the use is able to select the Direct upload
	//@Test
	public void verifyDirectUploadIsSelected() throws Exception {
		tf.selectTreatmentAddOn();
		up.directUploadSelect();
		Assert.assertTrue(up.isdirectUploadSelected(),"direct upload is not selected");
		
	}
	//@Test
	//verify the user is able to upload the upper scan
	public void verifyUpperscanCanBeUploaded() throws Exception {
		tf.selectTreatmentAddOn();
		up.directUploadSelect();
		String photoPath = System.getProperty("user.dir") + "/src/test/java/resources/images/new1 2.zip";
		up.uploadUpperScan(photoPath);
		

	}
	//@Test

	//verify the user is able to delete the upper scan
	public void verifyUpperScanIsDeleted() throws Exception {
		tf.selectTreatmentAddOn();
		up.directUploadSelect();
		String photoPath = System.getProperty("user.dir") + "/src/test/java/resources/images/new1 2.zip";
		up.uploadUpperScan(photoPath);
		up.removeUploadUpperScan();

	}
	//@Test
		//verify the user is able to upload the lower scan
		public void verifyLowerscanCanBeUploaded() throws Exception {
			tf.selectTreatmentAddOn();
			up.directUploadSelect();
			String photoPath = System.getProperty("user.dir") + "/src/test/java/resources/images/new1 2.zip";
			up.uploadLowerScan(photoPath);
			

		}
		//@Test
		//verify the user is able to delete the Lower scan
		public void verifyLowerScanIsDeleted() throws Exception {
			tf.selectTreatmentAddOn();
			up.directUploadSelect();
			String photoPath = System.getProperty("user.dir") + "/src/test/java/resources/images/new1 2.zip";
			up.uploadLowerScan(photoPath);
			up.removeUploadLowerScan();

		}
		//@Test
		//verify the user  is able to select ship impression
		public void verifyShipImpressionIsSelected() throws Exception {
			tf.selectTreatmentAddOn();
			up.shipImpressioSelect();
			Assert.assertTrue(up.isShipImpressionSelected(),"Send scan from scanner is not selected");
			up.clickcontinue();
			Assert.assertTrue(up.uploadScanIsChecked(),"Upload scanner is not checked");

			
		}
		//@Test
		//verify the user is able to upload the upper and lower together and proceed
		public void verifyuploadUpperandLowerTogether() throws Exception {
			UploasScanFlow uf=new UploasScanFlow(driver, excel, excelPath);
			uf.upperAndLowerScanUpload();
			
		}
	
	
	
	
	

}
