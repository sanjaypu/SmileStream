package com.orthofx.smilestream.pages.doctor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orthofx.smilestream.base.BasePage;

public class PlanTypePage extends BasePage {
	WebDriver driver;
	public PlanTypePage (WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
@FindBy (xpath="//span[text()=\"Select Plan Type\"]/../span[contains(@class, 'ofx-step-dot')]")
WebElement selectPlanCheck;


	public By plan(String Plantype) {
		return By.xpath("//span[contains(normalize-space(),\'"+Plantype+"')]");
		
	}
	
    public void selectPlanType(String Plantype) throws InterruptedException {
		waitForLoader();
		By locator=plan(Plantype);
		WebElement planType=waitForElementToBeVisible(locator);
		planType.click();
		clickContinue();
		 waitForLoader();

}
    public boolean selectPlanChecked() throws InterruptedException {
		waitForLoader();
        
    	String attribute=selectPlanCheck.getAttribute("class");
    	return attribute.contains("completed");
    	
    	
    	
    }
	
	

}
