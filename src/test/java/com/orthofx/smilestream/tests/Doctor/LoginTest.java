package com.orthofx.smilestream.tests.Doctor;

import java.util.Map;

import org.testng.annotations.Listeners;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.orthofx.smilestream.base.BaseTest;
import com.orthofx.smilestream.flows.Doctor.LoginFlow;
import com.orthofx.smilestream.pages.doctor.LoginPage;

import utils.ExcelUtils;

@Listeners(com.orthofx.smilestream.base.Listeners.class)
public class LoginTest extends BaseTest {
	LoginPage lp;
	LoginFlow lf;
	
	@BeforeMethod(alwaysRun = true)
    public void setupObjects() {
		
        lp = new LoginPage(driver);
        lf = new LoginFlow(driver, excel, excelPath);
       

        
    }

	// TC_AUTH_01:verify user is able to login successfully
	@Test (groups= {"login","regression"})

	public void verifyDashboardDisplayed() throws Exception {
		lf.login(2);
		//lp.loginToApplication(excelPath, excelPath);
		//waitForLoader();
        Assert.assertTrue(lp.viewAllDisplayed());

	}

	// TC_AUTH_02:verify user is getting incorrect username when username is givenm,
	// incorrect
	@Test(groups= {"login","regression"})
	public void unsucessfulllogin() throws Exception {
		lf.login(3);
		lp.isUserNotFoundErrorDisplayed();

	}

	// TC_AUTH_03:Verify the user is able to get the validation message when email
	// and password is not entered
	@Test(groups= {"login","regression"})
	public void validationMessage() throws Exception {
		lp.loginToApplication("", "");
		lp.isErrorMessageDisplayed();

	}

}