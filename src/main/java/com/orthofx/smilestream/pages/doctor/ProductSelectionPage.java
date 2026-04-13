package com.orthofx.smilestream.pages.doctor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.orthofx.smilestream.base.BasePage;
import com.orthofx.smilestream.base.BaseTest;

import utils.ExcelUtils;

public class ProductSelectionPage extends BasePage {
	
	public ProductSelectionPage(WebDriver driver) {
		super(driver);
		//super(driver);

		PageFactory.initElements(driver, this);
	}
	public By Product(String productName) {
		return By.xpath("//h3[contains(normalize-space(),'" + productName + "')]");
		
	}
	
	public ProductSelectionPage selectProduct(String productName) throws InterruptedException {
		waitForLoader();
		By locator=Product(productName);
		WebElement product=waitForElementToBeVisible(locator);
		product.click();
		ProductSelectionPage pp=new ProductSelectionPage(driver);
		clickContinue();
		
		return this;

	}

}
