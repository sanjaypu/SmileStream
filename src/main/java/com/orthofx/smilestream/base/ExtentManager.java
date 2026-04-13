package com.orthofx.smilestream.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports createInstance() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("reports/TestReport.html");
            spark.config().setReportName("Automation Results");
            spark.config().setDocumentTitle("Test Report");
            
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}