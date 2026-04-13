package com.orthofx.smilestream.pages.doctor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orthofx.smilestream.base.BasePage;

import utils.PropertyReader;

public class TreatmentAddOnPage extends BasePage {
	//WebDriver driver;
	
	public TreatmentAddOnPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (xpath="//h3[text()=\"Rescue Aligner\"]/..//input")
	WebElement rescueAligner;

	@FindBy (xpath="//h3[text()=\"Services\"]/..//input")
	WebElement Services;
	@FindBy (xpath="//input[@aria-label=\"Phone Number\"]")
	WebElement phoneNumber;
	@FindBy (xpath="//input[@aria-label=\"Email\"]")
	WebElement email;
	@FindBy(xpath="//input[@aria-label=\"Enter Custom Price\"]")
	WebElement customPrice;
	@FindBy (xpath="//h2[text()=\" Order Summary \"]/..")
	WebElement orderSummary;
	@FindBy (xpath="//mat-error[text()=\" *Enter a valid phone number \"]/..")
	WebElement invalidPhoneNumberMessage;
	@FindBy (xpath="//mat-error[text()=\" *Enter a valid email \"]/..")
	WebElement invalidemailMessage;
	//@FindBy(xpath="//a[@class=\"customize-link\"]")
	@FindBy(xpath="//a[text()=\"Customize price buttons\"]")
    WebElement customPriceButton;
	
	 public void selectRescueAligner() throws InterruptedException {
		 waitForLoader();
          Thread.sleep(8000);	
           rescueAligner.click();
		}
	 
	 public boolean rescueAlignerChecked() {
		 String attribute=rescueAligner.getAttribute("class");
		 return attribute.contains("selected");
	 }
	 
	 public void selectServices() throws InterruptedException {
		 waitForLoader();
		 if(!isServicesChecked()) {
			 Services.click();
}
		
	 }
	 public boolean isServicesChecked() {
		 String attribute=Services.getAttribute("class");
		 return attribute.contains("selected");
	 }
	 public void eneterPhoneNumeber(String PhoneNumber) {
		 phoneNumber.sendKeys(PhoneNumber);
	 }
	 public void enetervalidEmail() {
		 String randomemail=generateEmail();
		 email.sendKeys(randomemail);
	 }
		 public String generateInvalidEmail() {
			    return "testuser" + System.currentTimeMillis(); // no @domain
			}
	 
	 public void eneterCustomPrice(String price) {
		 customPrice.sendKeys(price);
	 }
	 public void clickcontinue() throws InterruptedException {
		 waitForLoader();

		Thread.sleep(3000);
		clickContinue();
      }
	 public boolean orderSummaryDisplayed() throws InterruptedException {
		 waitForLoader();

		return orderSummary.isDisplayed();
	
	 }
	 public boolean invalidPhoneNumberDisplayed() throws InterruptedException {
		 waitForLoader();
		 scrollToElement(invalidPhoneNumberMessage);
         return invalidPhoneNumberMessage.isDisplayed();
		
		 }
	 public boolean invalidemailDisplayed() throws InterruptedException {
		 waitForLoader();
        return invalidemailMessage.isDisplayed();
		
		 }
	 public boolean isValidationMessageDisplayed(String fieldName) {

		    String template = PropertyReader.get("error.message");

		    if (template == null) {
		        throw new RuntimeException("Missing locator: error.message");
		    }

		    String xpath = String.format(template, fieldName);

		    WebElement errorElement = driver.findElement(By.xpath(xpath));
		    return errorElement.isDisplayed();
		}
	 public void clickCustomPriceButton() throws InterruptedException {
		 waitForLoader();
		 Thread.sleep(3000);
		 scrollToElement(customPriceButton);
         customPriceButton.click();
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.urlContains("https://s2pro.orthofx.com/professional/org-management/practices/"));

 }
	 public void clickAcceptAndContinue() throws InterruptedException {
		 clickAcceptandContinue();
		 Thread.sleep(10000);
		 waitForLoader();

		}



	 
	 
	 

}
