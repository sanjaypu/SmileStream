package com.orthofx.smilestream.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ExcelUtils;

public class TestContext {
	 public WebDriver driver;
	    public WebDriverWait wait;
	    public ExcelUtils excel;
	    public String excelPath;
	}

