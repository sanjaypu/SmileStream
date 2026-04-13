package com.orthofx.smilestream.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.PropertyReader;

public class BasePage {
	public WebDriver driver;
	public WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
	 this.driver=driver;
	  this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	}
	public void waitForElement(WebElement element) {
	    // We add a retry loop to catch the "Stale" error if the page shifts 
	    // while the element is loading
	    wait.ignoring(StaleElementReferenceException.class)
	        .until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementy(By locator) {
	    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public WebElement waitForElementToBeVisible(By locator) {
	    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public void clickElement(WebElement element) {
		waitForElement(element);
		element.click();
	}
	public void waitForLoader() throws InterruptedException {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(
	     By.xpath("//div[contains(@class,'loader-container') and contains(@style,'display: block')]")));
	   
	    
	    
	}
	public boolean isElementDisplayed(WebElement element) {
	    try {
	        return element.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}
	public void scrollToElement(WebElement element) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		//element.click();
		}
	public String takeScreenshot(String testName) {
		String path = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	 public void switchToNewTab(WebElement element) throws InterruptedException {
		 Set<String> oldHandles=driver.getWindowHandles();
		 element.click();
		 wait.until(ExpectedConditions.numberOfWindowsToBe(oldHandles.size()+1));
		 Set<String>newHandles=driver.getWindowHandles();
		 for(String handle:newHandles) {
			 if(!oldHandles.contains(handle)) {
				 driver.switchTo().window(handle);
				 break;
			 }
			 }
		 }
		 public void waitForElementBy(By locator) {
			    // 1. Using a local wait to ensure we have enough time for Angular transitions
			    WebDriverWait localWait = new WebDriverWait(driver, Duration.ofSeconds(30));
			    
			    // 2. Ignore Stale and NoSuchElement to give Healenium time to trigger
			    localWait.ignoring(StaleElementReferenceException.class)
			             .ignoring(NoSuchElementException.class)
			             .until(ExpectedConditions.visibilityOfElementLocated(locator));
			}
		 public  WebElement waitForElementVisible(WebDriver driver, By locator) {
			 
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 
		        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		    }
		 public void clickContinue() throws InterruptedException {
				WebElement Continue = driver.findElement(By.xpath(PropertyReader.get("continue.button")));
				scrollToElement(Continue);
				Continue.click();

			}
		 public WebElement waitForElementToBeClickable(WebElement element) {
			    return wait.until(ExpectedConditions.elementToBeClickable(element));
			}
		 public void clickAcceptandContinue() throws InterruptedException {
				WebElement AcceptContinue = driver.findElement(By.xpath(PropertyReader.get("acceptandcontinue.button")));
				scrollToElement(AcceptContinue);
				AcceptContinue.click();

			}
		 public String generateEmail() {
			    long timestamp = System.currentTimeMillis();
			    return "testuser" + timestamp + "@gmail.com";
			}
		 public void clickconfirm() {
			 driver.findElement(By.xpath("//span[normalize-space()=\"Confirm\"]/..")).click();
		 }
		 public boolean waitForElementToDisappear(WebElement element) {
			    try {
			        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			        return wait.until(ExpectedConditions.invisibilityOf(element));
			    } catch (Exception e) {
			        return true; // if element not found → already gone
			    }
			}





		
	 	
	

}
