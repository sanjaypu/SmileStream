package com.orthofx.smilestream.pages.doctor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import com.orthofx.smilestream.base.BasePage;
import com.orthofx.smilestream.base.BaseTest;

public class PatientCreationPage extends BasePage {
	WebDriver driver;

	public PatientCreationPage(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@aria-label=\"First Name\"]")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@aria-label=\"First Name\"]/ancestor::mat-form-field/descendant::mat-error")
	WebElement firstNameValidation;

	@FindBy(xpath = "//input[@aria-label=\"Last Name\"]")
	WebElement lastName;

	@FindBy(xpath = "//input[@aria-label=\"Last Name\"]/ancestor::mat-form-field/descendant::mat-error")
	WebElement lastNameValidation;
	
	@FindBy(xpath = "//input[@aria-label=\"Date of Birth\"]")
	WebElement DOB;

	@FindBy(xpath = "//input[@aria-label=\"Date of Birth\"]/ancestor::mat-form-field/descendant::mat-error")
	WebElement dobValidation;
	
	@FindBy(xpath = "//input[@aria-label=\"Zip Code\"]")
	WebElement zipCode;

	@FindBy(xpath = "//input[@aria-label=\"Zip Code\"]/ancestor::mat-form-field/descendant::mat-error")
	WebElement zipcodeValidation;
	
	@FindBy(xpath = "//span[text()=\"I have obtained Patient Consent for  \"]/../..//input")
	WebElement patientconsent;

	@FindBy(xpath = "//span[text()=\"I have obtained Patient Consent for  \"]/./../../../../following-sibling::div[1]")
	WebElement patinetconsentValidation;

	@FindBy(xpath = "//div[text()=' Please complete all required information above to add a new patient. ']")
	WebElement footerValidation;

	@FindBy(xpath = "//div[@class=\"footer-buttons\"]//ofx-button[@variant=\"primary\"]")
	WebElement continu;


	@FindBy(xpath = "//input[@type=\"file\"]")
	WebElement uploadButton;

	@FindBy(xpath = "//button[@class=\"img-remove\"]")
	WebElement imgRemove;
	
	@FindBy(xpath="//a[@class=\"t-and-c\"]")
	WebElement termsAndCondition;
	
	//@FindBy(xpath="//p[text()=\"Create New Patient Record?\"]/../following-sibling::mat-dialog-actions//button")
	@FindBy(xpath="//mat-dialog-actions//ofx-button[@class=\"ofx-btn ng-star-inserted\"]")
	WebElement continueInConfirmation;
	
	@FindBy(xpath="//label[text()=\"Patient has a guardian\"]/..//input")
	WebElement guardianCheckbox;
	
	
	@FindBy(xpath="//input[@aria-label=\"Guardian's Full Name\"]")
	WebElement guardianTextField;
	
	//@FindBy(xpath="//span[text()=\"Select Treatment Type\"]")
	@FindBy(xpath="//span[normalize-space()='Select Treatment Type']")
	WebElement selectTreatmentType;
	
	
	

	public void enterPateientDetails(String firstname, String lastname, String dob, String zipcode ) throws InterruptedException {
		waitForElement(firstName);
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		DOB.sendKeys(dob);
		zipCode.sendKeys(zipcode);
		scrollToElement(patientconsent);
		patientconsent.click();
		//continu.click();
		clickContinue();
		waitForElement(continueInConfirmation);
        continueInConfirmation.click();
		waitForLoader();

        
		
}

	public boolean errorMessageDisplayed() {
		return isElementDisplayed(firstNameValidation) && isElementDisplayed(lastNameValidation)
				&& isElementDisplayed(dobValidation) && isElementDisplayed(zipcodeValidation)
				&& isElementDisplayed(patinetconsentValidation) && isElementDisplayed(footerValidation);
	}

	public void clickContinue() throws InterruptedException {
		waitForLoader();
		scrollToElement(patientconsent);
		continu.click();

		
	}

	public void uploadPhoto(String filePath) {
		uploadButton.sendKeys(filePath);
		waitForElement(imgRemove);
	}
		
	public boolean imgRemoveIsDisplayed() {
		return imgRemove.isDisplayed();
	}
	
	public void termsandCondition() throws InterruptedException {
		waitForLoader();
		scrollToElement(termsAndCondition);
        switchToNewTab(termsAndCondition);
       
		
	}
	
	public boolean selectTreatmmentTypeVisible() throws InterruptedException {
		waitForLoader();
		waitForElement(selectTreatmentType);
        return selectTreatmentType.isDisplayed();
		
	}
	
	public boolean guardianTextFieldIsDisplayed() throws InterruptedException {
		waitForLoader();
        guardianCheckbox.click();
		return guardianTextField.isDisplayed();
		
	}

}
