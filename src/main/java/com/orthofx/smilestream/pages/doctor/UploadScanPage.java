package com.orthofx.smilestream.pages.doctor;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orthofx.smilestream.base.BasePage;

public class UploadScanPage extends BasePage {
	
	public UploadScanPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	@FindBy (xpath="//span[text()=\"Send from Scanner\"]/ancestor::ofx-option-card//button")
	WebElement sendScanFromScanner;
	@FindBy (xpath="//span[text()=\"Direct Upload\"]/ancestor::ofx-option-card//button")
	WebElement directupload;
	@FindBy (xpath="//span[text()=\"Ship Impressions\"]/ancestor::ofx-option-card//button")
	WebElement shipImpression;
	@FindBy (xpath="//img[@alt=\"3 DISC\"]/parent::div")
	WebElement disc;
	@FindBy (xpath="//img[@alt=\"3shape\"]/parent::div")
	WebElement shape;
	@FindBy (xpath="//img[@alt=\"Carestream\"]/parent::div")
	WebElement carestream;
	@FindBy (xpath="//img[@alt=\"MEDIT\"]/parent::div")
	WebElement medit;
	@FindBy (xpath="//img[@alt=\"PLANMECA\"]/parent::div")
	WebElement PLANMECA ;
	@FindBy (xpath="//input[@aria-label=\"Enter scanner name\"]")
	WebElement EnterScannerName ;
	@FindBy (xpath="//span[text()=\"Upload Scans\"]/../span[contains(@class, 'ofx-step-dot')]")
	WebElement uploadScanCheck ;
	@FindBy (xpath="//h3[text()=\"Upload Upper Scan\"]/parent::div/following-sibling::input")
	WebElement uploadUpperScan ;
	@FindBy (xpath="//h3[text()=\"Upload Upper Scan\"]/ancestor::ofx-file-uploader//mat-icon[@svgicon=\"close\"]")
	WebElement uploadUpperScanClose ;
	
	@FindBy (xpath="//h3[text()=\"Upload Lower Scan\"]/parent::div/following-sibling::input")
	WebElement uploadLowerScan ;
	@FindBy (xpath="//h3[text()=\"Upload Lower Scan\"]/ancestor::ofx-file-uploader//mat-icon[@svgicon=\"close\"]")
	WebElement uploadLowerScanClose ;
	
	
	
	
	
	
	 
	public boolean isSendScanFromscannerSelected() {
		String attribute=sendScanFromScanner.getAttribute("class");
		return attribute.contains("selected");
		
	}
	public void SendScanFromscannerSelect() {
		if(!isSendScanFromscannerSelected()) {
			sendScanFromScanner.click();
		}
		
	}
	
	public void selectAndVerifyAllScanners() throws InterruptedException {
		scrollToElement(PLANMECA);
	    List<WebElement> scanners = Arrays.asList(
	        disc, shape, carestream, medit, PLANMECA
	    );

	    for (WebElement scanner : scanners) {
	        scanner.click();
	        waitForLoader();

	        String classValue = scanner.getAttribute("class");

	        if (!classValue.contains("selected")) {
	            throw new AssertionError("Scanner not selected: " + scanner);
	        }
	    }
	}
	public void enterScannerName() throws InterruptedException {
		EnterScannerName.sendKeys("orthofx");
		clickContinue();
	}
	public boolean uploadScanIsChecked() throws InterruptedException {
       waitForLoader();
       
        
    	String attribute=uploadScanCheck.getAttribute("class");
    	return attribute.contains("completed");
		
	}
	public void clickcontinue() throws InterruptedException {
		 waitForLoader();

		Thread.sleep(3000);
		clickContinue();
     }
	public boolean isdirectUploadSelected() {
		String attribute=directupload.getAttribute("class");
		return attribute.contains("selected");
		
	}
	public void directUploadSelect() {
		if(!isSendScanFromscannerSelected()) {
			directupload.click();
		}
		
	}
	
	public void uploadUpperScan(String filePath) throws InterruptedException {
		 waitForLoader();

		scrollToElement(uploadUpperScan);

		uploadUpperScan.sendKeys(filePath);
		waitForElement(uploadUpperScanClose);
		 Assert.assertTrue(uploadUpperScanClose.isDisplayed());
		
	}
	public void removeUploadUpperScan() throws InterruptedException {
		scrollToElement(uploadUpperScanClose);
		//waitForLoader();
		waitForElement(uploadUpperScanClose);

		uploadUpperScanClose.click();
		clickconfirm();


		Thread.sleep(10000);
		waitForElementToDisappear(uploadUpperScanClose);




	}
	public void uploadLowerScan(String filePath) throws InterruptedException {
		 waitForLoader();

		scrollToElement(uploadLowerScan);

		uploadLowerScan.sendKeys(filePath);
		waitForElement(uploadLowerScanClose);
		 Assert.assertTrue(uploadLowerScanClose.isDisplayed());
		
	}
	public void removeUploadLowerScan() throws InterruptedException {
		scrollToElement(uploadLowerScanClose);
		//waitForLoader();
		waitForElement(uploadLowerScanClose);

		uploadLowerScanClose.click();
		clickconfirm();


		waitForElementToDisappear(uploadLowerScanClose);




	}
	public boolean isShipImpressionSelected() {
		String attribute=shipImpression.getAttribute("class");
		return attribute.contains("selected");
		
	}
	public void shipImpressioSelect() {
		if(!isSendScanFromscannerSelected()) {
			shipImpression.click();
		}
		
	}
	
	
	
	

	

}
