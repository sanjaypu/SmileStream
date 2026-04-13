package com.orthofx.smilestream.pages.doctor;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orthofx.smilestream.base.BasePage;

public class PhotoUploadPage extends BasePage {
	public PhotoUploadPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
}
	@FindBy (xpath="//h3[text()=\"Upload Photos\"]/parent::div/following-sibling::input")
	WebElement UploadPhoto;
	@FindBy (xpath="//h3[text()=\"Upload Photos\"]/ancestor::ofx-file-uploader//mat-icon[@svgicon=\"close\"]")
	WebElement UploadPhotoClose;
	@FindBy (xpath="//span[normalize-space(text())=\"Arrange Composite (Optional)\"]/ancestor::button")
	WebElement arrangeComposite;
	@FindBy (xpath="//h2[normalize-space(text())=\"Arrange Photos to a Composite\"]/ancestor::ofx-popup")
	WebElement arrangeCompositePopup;
	@FindBy(xpath="//a[text()=\"View Photo Guide\"]")
	WebElement viewPhotoGuideButton;
	@FindBy(xpath="//p[text()=\"Invalid file type - please upload a .jpeg,.jpg,.png file\"]")
	WebElement invalidFileType;
	

	
	
	public void uploadPhoto(String photoPath) {
		UploadPhoto.sendKeys(photoPath);
	}
	public boolean removeIconAppears() {
	try {
		return UploadPhotoClose.isDisplayed();
		
	}catch (Exception e) {
		return false;
	}
		
	}
	
	public void clickArrangeComposite() {
		arrangeComposite.click();
		Assert.assertTrue(arrangeCompositePopup.isDisplayed());
	}
	public void deletePhoto() {
		UploadPhotoClose.click();
		clickconfirm();
		waitForElementToDisappear(UploadPhotoClose);

	}
	public void openPhotoGuide()throws InterruptedException {
		switchToNewTab(viewPhotoGuideButton);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://static.orthofx.com/training/1620425234/Photo%20Guide%20-%20Steps%20to%20Success.pdf"));
}
	public boolean invalidMessageIsDisplayed() {
		return invalidFileType.isDisplayed();
	}
	public void clickcontinue() throws InterruptedException {
		 waitForLoader();

		Thread.sleep(3000);
		clickContinue();
		 waitForLoader();

    }
	

}
