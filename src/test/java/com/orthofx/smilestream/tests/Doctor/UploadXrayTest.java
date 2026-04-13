package com.orthofx.smilestream.tests.Doctor;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orthofx.smilestream.base.BaseTest;
import com.orthofx.smilestream.flows.Doctor.UploadPhotoFlow;
import com.orthofx.smilestream.flows.Doctor.UploasScanFlow;
import com.orthofx.smilestream.pages.doctor.PhotoUploadPage;
import com.orthofx.smilestream.pages.doctor.UploadXrayPage;

public class UploadXrayTest extends BaseTest {
     UploadXrayPage up;
     UploadPhotoFlow pf;
	@BeforeMethod(alwaysRun=true)
	public void setupObject() throws Exception {
		up=new UploadXrayPage(driver);
		pf =new UploadPhotoFlow(driver, excel, excelPath);
	}
	//@Test
	
	//verify the user is able to upload the xray
	public void uploadXray() throws Exception {
		pf.photoUpload();
		String photoPath =System.getProperty("user.dir") + "/src/test/java/resources/images/1.jpg";
        up.uploadXray(photoPath);
        Assert .assertTrue(up.IsXrayCloseAppers(),"Xray close icon is not displayed");
}
	//@Test
	//verify the xray can be deleted
	
	public void deleteXray() throws Exception {
		//pf.photoUpload();
		uploadXray();
		up.deleteXrayImage();
		Assert.assertFalse(up.removeIconAppears(),"xay is not deleted");

		
	}
	@Test
	//verify invalid messge is displayed
	public void inValidMessageDispalyed() throws Exception {
		pf.photoUpload();
		String photoPath =System.getProperty("user.dir") + "/src/test/java/resources/images/new1 2.zip";
        up.uploadXray(photoPath);
       Assert.assertTrue(up.invalidMessageIsDisplayed(),"invalid messge is not displayed");

	}

}
