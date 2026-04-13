package com.orthofx.smilestream.tests.Doctor;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orthofx.smilestream.base.BaseTest;
import com.orthofx.smilestream.flows.Doctor.TreatmentAddOnsFlow;
import com.orthofx.smilestream.flows.Doctor.UploadPhotoFlow;
import com.orthofx.smilestream.flows.Doctor.UploasScanFlow;
import com.orthofx.smilestream.pages.doctor.PhotoUploadPage;
import com.orthofx.smilestream.pages.doctor.UploadScanPage;

public class UploadPhotoTest extends BaseTest {
	UploasScanFlow pf;
	PhotoUploadPage pp;
	@BeforeMethod(alwaysRun=true)
	public void setupObject() throws Exception {
		pf= new UploasScanFlow(driver,excel,excelPath);
		pp=new PhotoUploadPage(driver);

	}
	//@Test
	
	//verify the user is able to upload the photo
	public void verifyPhotoCanBeUploaded() throws Exception {
		pf.upperAndLowerScanUpload();
		String photoPath = System.getProperty("user.dir") + "/src/test/java/resources/images/1.jpg";
		pp.uploadPhoto(photoPath);
		Assert.assertTrue(pp.removeIconAppears(),"photo is not uploaded");
	}
	//@Test
	//verify the user is able to see the arrange composite pop up
	public void verifyArrangeCompoistePopUpIsdisplayed() throws Exception {
        verifyPhotoCanBeUploaded();
		pp.clickArrangeComposite();
	}
	//@Test
	
	//verify the user is able to delete the image
	public void verifyPhotoCanBeDeleted() throws Exception {
		verifyPhotoCanBeUploaded();
		pp.deletePhoto();
		Assert.assertFalse(pp.removeIconAppears(),"Photo is not deleted");

		
	}
	//@Test
	//verify the user is able to open the photo guide
	public void openPhotoGuide() throws Exception {
		pf.upperAndLowerScanUpload();
		pp.openPhotoGuide();

}
	//@Test
	//verify the user is getting the invalid file type message when invalid photo is uploaded
	public void invalidPhotoAppears() throws Exception {
		pf.upperAndLowerScanUpload();
		String photoPath = System.getProperty("user.dir") + "/src/test/java/resources/images/new1 2.zip";
		pp.uploadPhoto(photoPath);
		Assert.assertTrue(pp.invalidMessageIsDisplayed(),"invalid messge is not displayed");		

	}
	
	
	
	
	
	

}
