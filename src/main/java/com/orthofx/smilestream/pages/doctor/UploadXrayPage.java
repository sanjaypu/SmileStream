package com.orthofx.smilestream.pages.doctor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orthofx.smilestream.base.BasePage;

public class UploadXrayPage extends BasePage {
	public UploadXrayPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
}
	@FindBy (xpath="//h3[text()=\"Upload X-Rays\"]/parent::div/following-sibling::input")
	WebElement uploadXray;
	@FindBy (xpath="//h3[text()=\"Upload X-Rays\"]/ancestor::ofx-file-uploader//mat-icon[@svgicon=\"close\"]")
	WebElement uploadXrayClose;
	@FindBy(xpath="//p[text()=\"Invalid file type - please upload a .jpeg,.jpg,.png file\"]")
	WebElement invalidFileType;
	
 public void uploadXray(String photoPath ) throws InterruptedException {
	 uploadXray.sendKeys(photoPath);
	//waitForElement(uploadXrayClose);

		}
 public boolean IsXrayCloseAppers() {
	 
	 return uploadXrayClose.isDisplayed();
	 
 }
 
 public void deleteXrayImage() {
	 uploadXrayClose.click();
	 clickconfirm();
		waitForElementToDisappear(uploadXrayClose);

 }
 public boolean removeIconAppears() {
		try {
			return uploadXrayClose.isDisplayed();
			
		}catch (Exception e) {
			return false;
		}
			
		}
 public boolean invalidMessageIsDisplayed() {
		waitForElement(invalidFileType);
       return invalidFileType.isDisplayed();
	}
 public void clickcontinue() throws InterruptedException {
	 waitForLoader();

	Thread.sleep(3000);
	clickContinue();
	 waitForLoader();

}

 
 }
	


