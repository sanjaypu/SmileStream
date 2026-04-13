package com.orthofx.smilestream.tests.Doctor;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orthofx.smilestream.base.BaseTest;
import com.orthofx.smilestream.flows.Doctor.ProductSelectionFlow;



public class ProductSelectionTest extends BaseTest {
	ProductSelectionFlow pf;
	@BeforeMethod(alwaysRun=true)

	public void setUpobject() {
        pf=new ProductSelectionFlow(driver,excel,excelPath);

	}
	@Test
	//verify the user is able to select bright as product
	public void brightProductSucessFull() throws Exception {
		pf.SelectProduct("Bright");
		Thread.sleep(10000);
	}
	@Test
	//verify the user is able to select airflex as product
	public void AirFlexProductSucessFull() throws Exception {
		pf.SelectProduct("AirFlex");
		Thread.sleep(10000);
	}
	@Test
	//verify the user is able to select FxClear as product
		public void FxClearProductSucessFull() throws Exception {
			pf.SelectProduct("FXClear™");
			Thread.sleep(10000);
		}

	

}
