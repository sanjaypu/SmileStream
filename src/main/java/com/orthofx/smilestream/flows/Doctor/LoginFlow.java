package com.orthofx.smilestream.flows.Doctor;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.orthofx.smilestream.base.BaseTest;
import com.orthofx.smilestream.base.TestContext;
import com.orthofx.smilestream.pages.doctor.LoginPage;

import utils.ExcelUtils;

public class LoginFlow {
	 WebDriver driver;
     ExcelUtils excel;
     String excelPath;

    // Use a constructor to "receive" the data
    public LoginFlow(WebDriver driver, ExcelUtils excel, String excelPath) {
        this.driver = driver;
        this.excel = excel;
        this.excelPath = excelPath;
    }
    /*public void setData(WebDriver driver, ExcelUtils excel, String excelPath) {
        this.driver = driver;
        this.excel = excel;
        this.excelPath = excelPath;
    }*/

   
	
	
	public void login(int row) throws Exception {
        LoginPage lp = new LoginPage(driver);
        
        // This will now use 'excel' from BaseTest which is NOT null
        Map<String, String> data = excel.getSpecificRowData(excelPath, "Sheet1", row);

        lp.loginToApplication(data.get("Username"), data.get("Password"));
        
    }
	
	

}
