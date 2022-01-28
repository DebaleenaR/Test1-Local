package com.testautomation.TestRunner;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import org.testng.annotations.*;

//import com.testautomation.PageObjects.BaseTest;
//import com.testautomation.Utility.ExcelUtil;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./features/GENERAL/",
		glue = {"com.testautomation.StepDef"},
		tags = {"@19328"},
		plugin = {"pretty","html:target/site/cucumber-pretty",
				"json:target/cucumber.json"},
		monochrome = true,
		dryRun = false
		)

public class TestRunner  {
	private TestNGCucumberRunner testNGCucumberRunner;
	
	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception
	{
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		
	}

	
	@Test(dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) 
	{
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}
	
	@DataProvider
	public Object[][] features()
	{
		return testNGCucumberRunner.provideFeatures();
		//return testNGCucumberRunner.provideScenarios();
	}
	
	@AfterClass(alwaysRun = true)
	public void teardown() throws Exception
	{
		testNGCucumberRunner.finish();
	}

}
