package com.orthofx.smilestream.tests.Doctor;
import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orthofx.smilestream.base.BaseTest;
import com.orthofx.smilestream.flows.Doctor.PlanTypeFlow;
import com.orthofx.smilestream.pages.doctor.PlanTypePage;

public class PlanTypeTest extends BaseTest {
	PlanTypeFlow pf;
	PlanTypePage pp;
	@BeforeMethod(alwaysRun=true)

	public void setupObject() {
		pf=new PlanTypeFlow(driver,excel,excelPath);
		pp=new PlanTypePage(driver);
	}
	
	@Test
	//verify the user is able to select the Clear with FX10
	public void verifyFx10ClearPlanSelection() throws Exception {
		pf.selectPlanType("Clear","FX10");
		Assert.assertTrue(pp.selectPlanChecked(),"step is not completed");;
	}
	//verify the user is able to select Clear with FX Full
	@Test
	public void verifyFxFullClearPlanSelection() throws Exception {
		pf.selectPlanType("Clear","FXFull");
		Assert.assertTrue(pp.selectPlanChecked(),"step is not completed");;

	}
	@Test
	//verify the user is able to select the Bright with FX10
	public void verifyFx10BrightPlanSelection() throws Exception {
		pf.selectPlanType("Bright","FX10");
		Assert.assertTrue(pp.selectPlanChecked(),"step is not completed");;

	}
	//verify the user is able to select Bright with FX Full
	@Test
	public void verifyFxFullBrightPlanSelection() throws Exception {
		pf.selectPlanType("Bright","FXFull");
		Assert.assertTrue(pp.selectPlanChecked(),"step is not completed");;

	}
	@Test
	//verify the user is able to select the AirFlex with FX10
	public void verifyFx10AirFlexPlanSelection() throws Exception {
		pf.selectPlanType("AirFlex","FX10");
		Assert.assertTrue(pp.selectPlanChecked(),"step is not completed");;

	}
	//verify the user is able to select AirFlex with FX Full
	@Test
	public void verifyFxFullAirFlexPlanSelection() throws Exception {
		pf.selectPlanType("AirFlex","FXFull");
		Assert.assertTrue(pp.selectPlanChecked(),"step is not completed");;

	}


	

}
