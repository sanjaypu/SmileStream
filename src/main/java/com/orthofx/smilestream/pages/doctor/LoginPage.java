package com.orthofx.smilestream.pages.doctor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orthofx.smilestream.base.BasePage;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//input[@aria-label=\"Email\"]")
	private WebElement emailField;

	@FindBy(xpath = "//input[@aria-label=\"Password\"]")
	private WebElement passwordField;

	@FindBy(xpath = "//span[text()=\" Login  \"]/../..")
	private WebElement loginButton;

	@FindBy(xpath = "//p[text()='User does not exist.']/ancestor::ofx-popup")
	private WebElement userDoesNotExistPopUP;

	@FindBy(id = "mat-mdc-error-0")
	private WebElement errorMessageEmail;

	@FindBy(id = "mat-mdc-error-1")
	private WebElement errorMessagePassword;

	@FindBy(xpath = "//ofx-button[contains(concat(' ', normalize-space(@class), ' '), ' view-all-btn ')]")
	private WebElement viewAll;


	
	public void enterEmail(String email) {
		waitForElement(emailField);
		emailField.clear();
		emailField.sendKeys(email);
	}

	public void enterPassword(String password) {

		passwordField.clear();
		passwordField.sendKeys(password);

	}

	public void clickLogin() {
		loginButton.click();
	}

	public void loginToApplication(String email, String password) throws InterruptedException {

		enterEmail(email);
		enterPassword(password);
		clickLogin();
		
		//waitForElement(viewAll);
	}

	public boolean isUserNotFoundErrorDisplayed() {
		try {
			waitForElement(userDoesNotExistPopUP);
			return userDoesNotExistPopUP.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isErrorMessageDisplayed() {
		try {
			waitForElement(errorMessageEmail);
			return errorMessageEmail.isDisplayed() && errorMessagePassword.isDisplayed();

		} catch (Exception e) {
			return false;
		}
	}

	public boolean viewAllDisplayed() {
		try {
			//waitForElementToBeVisible(viewAll);
			waitForElement(viewAll);
			//waitForElementFluent(viewAll);
			return ((WebElement) viewAll).isDisplayed();
		} catch (Exception e) {
			return false;
		}

	}

}
