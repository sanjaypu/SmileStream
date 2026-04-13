package com.orthofx.smilestream.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.ScreenshotUtil;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
    

	ExtentReports extent = ExtentManager.createInstance();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
    }

   /* @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
        try {
            // This pulls the driver from your BaseTest to take the screenshot
            String path = takeScreenshot(result.getMethod().getMethodName());
            test.addScreenCaptureFromPath(path);
        } catch (Exception e) {
            test.fail("Failed to attach screenshot: " + e.getMessage());
        }
    }*/
    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());

        try {
            Object testClass = result.getInstance();

            WebDriver driver = (WebDriver) result.getTestClass()
                    .getRealClass()
                    .getField("driver")
                    .get(testClass);

            String path = ScreenshotUtil.takeScreenshot(result.getMethod().getMethodName(), driver);
            test.addScreenCaptureFromPath(path);

        } catch (Exception e) {
            test.fail("Screenshot failed: " + e.getMessage());
        }
    }

    

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    // --- MUST ADD THESE TO FIX THE VERSION 6.14.3 ERROR ---

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Leave empty - required by your TestNG version
    }

    @Override
    public void onStart(ITestContext context) {
        // Leave empty - required by your TestNG version
    }
}