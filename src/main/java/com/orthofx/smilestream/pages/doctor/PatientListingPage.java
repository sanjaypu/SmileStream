package com.orthofx.smilestream.pages.doctor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orthofx.smilestream.base.BasePage;
import com.orthofx.smilestream.base.BaseTest;

public class PatientListingPage extends BasePage {
	WebDriver driver;
	
	@FindBy(xpath="//span[text()=' Add Patient ']/../..")
	WebElement addPatient;
	@FindBy(xpath="//mat-label[text()=' First Name ']")
	WebElement firstName;
	
	public PatientListingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickAddPatient() {
		waitForElement(addPatient);
		addPatient.click();
	}
	
	public void firstNameTestVisible() {
		waitForElement(firstName);
	}
	
	public void addPatientIsVisible() {
		waitForElement(addPatient);
	}

}
