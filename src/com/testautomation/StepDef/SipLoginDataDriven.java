//package com.testautomation.StepDef;
//
//import java.util.Properties;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.GherkinKeyword;
//import com.aventstack.extentreports.gherkin.model.Feature;
//import com.aventstack.extentreports.gherkin.model.Scenario;
//import com.testautomatiom.Listeners.ExtentReportListner;
//import com.testautomation.PageObjects.SipApplicationLandingPage;
//import com.testautomation.Utility.BrowserUtility;
//import com.testautomation.Utility.PropertiesFileReader;
//
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//
//public class SipLoginDataDriven extends ExtentReportListner {
//	
//	PropertiesFileReader obj = new PropertiesFileReader();
//	private WebDriver driver;
//	
//	@Given("^Open the Chrome and launch the SipApplication \"([^\"]*)\"$")
//	public void open_the_Chrome_and_launch_the_SipApplication(String ApplicationURL) throws Throwable {
//	   
////			ExtentTest logInfo = null;
////			try {
////				test = extent.createTest(Feature.class,"Study link functionality on login page of Application");
////				test = test.createNode(Scenario.class,"Verification of Study link");
////				logInfo = test.createNode(new GherkinKeyword("Given"),"Given step name");
////				
////				
////			} catch (AssertionError | Exception e){
////				testStepHandle("FAIL",driver,logInfo,e);
////			}
//		
//			Properties properties= obj.getProperty();
//			driver = BrowserUtility.OpenBrowser(driver, properties.getProperty("browser.name"), ApplicationURL);
//    	
//		
//	}
//
//	@When("^Application landingPage is open$")
//	public void application_landingPage_is_open() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//		System.out.println("You are in the application Landing Page.");
//	   
//	}
//
//	@Then("^Enter the \"([^\"]*)\" and Click on login Button$")
//	public void enter_the_and_Click_on_login_Button(String username) throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//		
//		new SipApplicationLandingPage(driver).NavigateToHomePageBypass(username);
//	}
//
//	
//	@Then("^Close the application page$")
//	public void close_the_application_page() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    driver.close();
//	}
//
//}
