package com.orthofx.smilestream.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.epam.healenium.SelfHealingDriver;
import com.epam.healenium.exception.HealeniumException;
import com.orthofx.smilestream.pages.doctor.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExcelUtils;

public class BaseTest {
	protected TestContext context;

	protected ExcelUtils excel;
	protected String excelPath;
	public WebDriver driver;
	public WebDriverWait wait;

	public BaseTest(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	
	public BaseTest() {
	}

// to initialize the driver	
	public WebDriver initaializeDriver() {

		WebDriverManager.chromedriver().setup();
		WebDriver delegate = new ChromeDriver();
		try {
			driver = SelfHealingDriver.create(delegate);
		} catch (HealeniumException e) {
			// If hlm-backend is down/misconfigured, keep tests runnable without healing.
			driver = delegate;
		}
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.manage().window().maximize();
		return driver;
	}

// to open the url
	/*@BeforeMethod
	public void openUrl() {
		driver = initaializeDriver();
		driver.get("https://s2pro.orthofx.com/");
	}*/

// to close the browser
	@AfterMethod(alwaysRun = true)
	public void tearDown() {

		if (driver != null) {
			driver.quit();
		}
	}

	// Common function to wait for visibility
	/*public void waitForElement(WebElement element) {
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


	// Common function to click after waiting
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



	
	//common function to take the screenshot
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
    
	//Common function to set up the excel
	//@BeforeMethod
	/*public void setupTestData() {

		excel = new ExcelUtils();

		excelPath = System.getProperty("user.dir") + "/src/test/java/resources/data/Test.xlsx";
	}
  
	// window handle
	 public void switchToNewTab(WebElement element) {
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
	 public void waitForElementFluent(WebElement element) {
		    Wait<WebDriver> fluentWait = new FluentWait<>(driver)
		            .withTimeout(Duration.ofSeconds(20))       // Total time to wait
		            .pollingEvery(Duration.ofMillis(500))      // Check every half second
		            .ignoring(NoSuchElementException.class)    // Ignore if not found yet
		            .ignoring(StaleElementReferenceException.class); // Ignore if DOM refreshes

		    fluentWait.until(ExpectedConditions.visibilityOf(element));
		}
	 
	 public void waitForElementBy(By locator) {
		    // 1. Using a local wait to ensure we have enough time for Angular transitions
		    WebDriverWait localWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    
		    // 2. Ignore Stale and NoSuchElement to give Healenium time to trigger
		    localWait.ignoring(StaleElementReferenceException.class)
		             .ignoring(NoSuchElementException.class)
		             .until(ExpectedConditions.visibilityOfElementLocated(locator));
		}*/
	 //@BeforeClass(alwaysRun = true)

	 @BeforeMethod(alwaysRun=true)

	 public void setup() {

	     // Initialize driver
	     driver = initaializeDriver();
	     driver.get("https://s2pro.orthofx.com/");


	     // Initialize test data
	     excel = new ExcelUtils();
	     excelPath = System.getProperty("user.dir") + "/src/test/java/resources/data/Test.xlsx";
	     context = new TestContext();
	     context.driver = driver;
	     context.wait = wait;
	     context.excel = excel;
	     context.excelPath = excelPath;
	 }
	 
		 
		
	 
	 

	 
	 
	 
	 
	 
	
}
