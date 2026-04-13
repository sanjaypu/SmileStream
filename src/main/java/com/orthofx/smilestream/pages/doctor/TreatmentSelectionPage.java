package com.orthofx.smilestream.pages.doctor;

import org.openqa.selenium.By;
import utils.PropertyReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orthofx.smilestream.base.BasePage;
import com.orthofx.smilestream.base.BaseTest;

public class TreatmentSelectionPage extends BasePage {

	public TreatmentSelectionPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public By treatment(String treatmentName) {
		return By.xpath("//span[normalize-space(text())='" + treatmentName + "']/../following-sibling::ofx-button");

	}

	public void selectTreatment(String treatmentName) throws InterruptedException {
		waitForLoader();
		By locator = treatment(treatmentName);
		WebElement treatmentElement = waitForElementToBeVisible(locator);
		waitForLoader();
		//treatmentElement.click();
		clickContinue();
	}

	public void clickContinue() throws InterruptedException {
		WebElement Continue = driver.findElement(By.xpath(PropertyReader.get("continue.button")));
		scrollToElement(Continue);
		Continue.click();

	}

}
