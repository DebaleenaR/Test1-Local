package com.testautomation.StepDef;

import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.testautomatiom.Listeners.ExtentReportListner;

import com.testautomation.PageObjects.*;

import com.testautomation.Utility.BrowserUtility;
import com.testautomation.Utility.PropertiesFileReader;
import com.testautomation.Utility.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import com.testautomation.Utility.ExcelHandler;
import com.testautomation.Utility.PropertiesFileReader;
import com.testautomation.Utility.TestDataHandler;



public class StepRepository extends ExtentReportListner {
	
	PropertiesFileReader obj = new PropertiesFileReader();
	//TestDataHandler testData = new TestDataHandler();
	public static WebDriver driver;

	TestDataHandler testData = new TestDataHandler();
	
	@Given("^File Is Availabe$")
	public void file_Is_Availabe() throws Throwable {
	   
	}

	@When("^File is Open$")
	public void file_is_Open() throws Throwable {
	  
	}
	
	@Given("^Open browser and launch SIPUrl$")
	public  void open_browser_and_launch_SIPUrl() throws Throwable 
	{		
		Properties properties= obj.getProperty();
		
		ExtentTest logInfo = null;
		try {
			
			String testname = properties.getProperty("TestCaseId");
			String scenario = properties.getProperty("ScenarioName");		
			
		
			test = extent.createTest(Feature.class,testname);
			test = test.createNode(Scenario.class,scenario);
			
			
			logInfo = test.createNode(new GherkinKeyword("Given"),"Open browser and launch SIPUrl");
			
			driver = BrowserUtility.OpenBrowser(driver, properties.getProperty("browser.name"), properties.getProperty("browser.baseURL"));
			logInfo.pass("Open browser and launch SIPUrl");
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}

	}
	
	@Then("^Complete Properlogin For Site User (\\d+)$")
	public void complete_Properlogin_For_Site_User(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			logInfo = test.createNode(new GherkinKeyword("Then"),
					"Complete Properlogin For Site User");

			new SipApplicationLandingPage(driver).NavigateToHomePageSiteUser(arg1);
			Thread.sleep(15000);

			logInfo.pass("Complete Properlogin For Site User");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}
	    
	}
	
	
	
	@When("^Application homepage is open$")
	public void application_homepage_is_open() throws Throwable 
	{   
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("When"),"Application homepage is open");
			System.out.println("You are into the Application Landing Page");
			
			
			logInfo.pass("Application homepage is open");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
			System.out.println(driver);
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	    
	}

	@Then("^Enter the username and click on login$")
	public void enter_the_username_and_click_on_login() throws Throwable 
	
	{	
		
		ExtentTest logInfo = null;
		try {
			
			System.out.println("Username should be provided");
			logInfo = test.createNode(new GherkinKeyword("Then"),"Enter the username and click on login");
			
			new SipApplicationLandingPage(driver).NavigateToHomePageProperLogin();
			
			logInfo.pass("Enter the username and click on login");
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	
	}

	
	
	
	
	@Then("^Validate the title of sip homepage$")
	public void validate_the_title_of_sip_homepage() throws Throwable 
	{  
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Validate the title of sip homepage");
			 String expectedtitle = "Test";
			   
			logInfo.pass("Validate the title of sip homepage");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			testStepHandle("FAIL",driver,logInfo,e);
		}
		
}

	@Then("^Close the browser$")
	public void close_the_browser() throws Throwable 
	{	
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Close the browser");
			
			String originalHandle = driver.getWindowHandle();
		    for(String handle : driver.getWindowHandles()) {
		        if (!handle.equals(originalHandle)) {
		            driver.switchTo().window(handle);
		            driver.close();
		        }
		    }
		    driver.switchTo().window(originalHandle);
			Thread.sleep(1000);
			driver.close();
			
			logInfo.pass("Close the browser");
			
		} 
		catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}


	@Then("^Navigate to Search Facility page$")
	public void navigate_to_Search_Facility_page() throws Throwable {
	    
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Navigate to Search Facility page");
			
			new SipSponsorLandingPage(driver).navigatetoFacilitySearch();
			
			logInfo.pass("Navigate to Search Facility page");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
		
	    
	}
	
	@Then("^Navigate To Admin > View and Manage Delegation of Site Users$")
	public void navigateToViewandManageDelegationofSiteUsers() throws Throwable {
	    
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Navigate To Admin > View and Manage Delegation of Site Users");
			
			new SiteUser_LandingPage(driver).navigateToViewandManageDelegationofSiteUsers();
			Thread.sleep(5000);
			
			logInfo.pass("Navigate To Admin > View and Manage Delegation of Site Users");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Navigate To Admin > Manage Delegate$")
	public void navigate_To_Admin_Manage_Delegate() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Navigate To Admin > Manage Delegate");
			
			new SiteUser_LandingPage(driver).navigate_To_Admin_Manage_Delegate();
			Thread.sleep(15000);
			
			logInfo.pass("Navigate To Admin > Manage Delegate");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Navigate To Admin > Manage News/Links/FAQ$")
	public void navigate_To_Admin_Manage_News_Links_FAQ() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Navigate To Admin > Manage News/Links/FAQ");
			
			new SiteUser_LandingPage(driver).navigate_To_Admin_Manage_News_Links_FAQ();
			Thread.sleep(5000);
			
			logInfo.pass("Navigate To Admin > Manage News/Links/FAQ");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Admin > Manage News/Links/FAQ Breadcrumb$")
	public void verify_Admin_Manage_News_Links_FAQ_Breadcrumb() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Admin > Manage News/Links/FAQ Breadcrumb");
			
			new AdminPage(driver).verify_Admin_Manage_News_Links_FAQ_Breadcrumb();
			Thread.sleep(1000);
			
			logInfo.pass("Verify Admin > Manage News/Links/FAQ Breadcrumb");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify User Navigated To Manage News/Links/FAQ Screen$")
	public void verify_User_Navigated_To_Manage_News_Links_FAQ_Screen() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify User Navigated To Manage News/Links/FAQ Screen");
			
			new AdminPage(driver).verify_User_Navigated_To_Manage_News_Links_FAQ_Screen();
			Thread.sleep(1000);
			
			logInfo.pass("Verify User Navigated To Manage News/Links/FAQ Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Print Icon In Manage News/Links/FAQ Screen$")
	public void verify_Print_Icon_In_Manage_News_Links_FAQ_Screen() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Print Icon In Manage News/Links/FAQ Screen");
			
			new AdminPage(driver).verify_Print_Icon_In_Manage_News_Links_FAQ_Screen();
			Thread.sleep(1000);
			
			logInfo.pass("Verify Print Icon In Manage News/Links/FAQ Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Export Icon In Manage News/Links/FAQ Screen$")
	public void verify_Export_Icon_In_Manage_News_Links_FAQ_Screen() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Export Icon In Manage News/Links/FAQ Screen");
			
			new AdminPage(driver).verify_Export_Icon_In_Manage_News_Links_FAQ_Screen();
			Thread.sleep(1000);
			
			logInfo.pass("Verify Export Icon In Manage News/Links/FAQ Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Select \"([^\"]*)\" From Show Dropdown In View and Manage Delegation on behalf of Site Users Screen$")
	public void select_From_Show_Dropdown_In_View_and_Manage_Delegation_on_behalf_of_Site_Users_Screen(String arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select "+arg1+" From Show Dropdown In View and Manage Delegation on behalf of Site Users Screen");
			
			new AdminPage(driver).select_From_Show_Dropdown_In_View_and_Manage_Delegation_on_behalf_of_Site_Users_Screen(arg1);
			Thread.sleep(5000);
			
			logInfo.pass("Select "+arg1+" From Show Dropdown In View and Manage Delegation on behalf of Site Users Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify View and Manage Delegation on behalf of Site Users Screen Displayed$")
	public void verify_View_and_Manage_Delegation_on_behalf_of_Site_Users_Screen_Displayed() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify View and Manage Delegation on behalf of Site Users Screen Displayed");
			
			new AdminPage(driver).verify_View_and_Manage_Delegation_on_behalf_of_Site_Users_Screen_Displayed();
			Thread.sleep(1000);
			
			logInfo.pass("Verify View and Manage Delegation on behalf of Site Users Screen Displayed");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Select (\\d+) From Show Rows Dropdown In View and Manage Delegation Screen$")
	public void select_From_Show_Rows_Dropdown_In_View_and_Manage_Delegation_Screen(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select "+arg1+" From Show Rows Dropdown In View and Manage Delegation Screen");
			
			new AdminPage(driver).select_From_Show_Rows_Dropdown_In_View_and_Manage_Delegation_Screen(arg1);
			Thread.sleep(1000);
			
			logInfo.pass("Select "+arg1+" From Show Rows Dropdown In View and Manage Delegation Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Site User (\\d+) Displayed In View and Manage Delegation of Site Users Screen$")
	public void verify_Site_User_Displayed_In_View_and_Manage_Delegation_of_Site_Users_Screen(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" Displayed In View and Manage Delegation of Site Users Screen");
			
			new AdminPage(driver).verify_Site_User_Displayed_In_View_and_Manage_Delegation_of_Site_Users_Screen(arg1);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Site User "+arg1+" Displayed In View and Manage Delegation of Site Users Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Site User (\\d+) Not Displayed In View and Manage Delegation of Site Users Screen$")
	public void verify_Site_User_Not_Displayed_In_View_and_Manage_Delegation_of_Site_Users_Screen(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" Not Displayed In View and Manage Delegation of Site Users Screen");
			
			new AdminPage(driver).verify_Site_User_Not_Displayed_In_View_and_Manage_Delegation_of_Site_Users_Screen(arg1);
			Thread.sleep(1000);
			
			logInfo.pass("Site User "+arg1+" Not Displayed In View and Manage Delegation of Site Users Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Add News/Links/FAQ Icon In Manage News/Links/FAQ Screen$")
	public void verify_Add_News_Links_FAQ_Icon_In_Manage_News_Links_FAQ_Screen() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Add News/Links/FAQ Icon In Manage News/Links/FAQ Screen");
			
			new AdminPage(driver).verify_Add_News_Links_FAQ_Icon_In_Manage_News_Links_FAQ_Screen();
			Thread.sleep(1000);
			
			logInfo.pass("Verify Add News/Links/FAQ Icon In Manage News/Links/FAQ Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Show/Hide Column Dropdown In Manage News/Links/FAQ Screen$")
	public void verify_Show_Hide_Column_Dropdown_In_Manage_News_Links_FAQ_Screen() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Show/Hide Column Dropdown In Manage News/Links/FAQ Screen");
			
			new AdminPage(driver).verify_Show_Hide_Column_Dropdown_In_Manage_News_Links_FAQ_Screen();
			Thread.sleep(1000);
			
			logInfo.pass("Verify Show/Hide Column Dropdown In Manage News/Links/FAQ Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Pagination In Manage News/Links/FAQ Screen$")
	public void verify_Pagination_In_Manage_News_Links_FAQ_Screen() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Pagination In Manage News/Links/FAQ Screen");
			
			new AdminPage(driver).verify_Pagination_In_Manage_News_Links_FAQ_Screen();
			Thread.sleep(1000);
			
			logInfo.pass("Verify Pagination In Manage News/Links/FAQ Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On Add News/Links/FAQ Button In Manage News/Links/FAQ Screen$")
	public void click_On_Add_News_Links_FAQ_Button_In_Manage_News_Links_FAQ_Screen() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Add News/Links/FAQ Button In Manage News/Links/FAQ Screen");
			
			new AdminPage(driver).click_On_Add_News_Links_FAQ_Button_In_Manage_News_Links_FAQ_Screen();
			Thread.sleep(10000);
			
			logInfo.pass("Click On Add News/Links/FAQ Button In Manage News/Links/FAQ Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Add News/Links/FAQ Screen Is Displayed$")
	public void verify_Add_News_Links_FAQ_Screen_Is_Displayed() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Add News/Links/FAQ Screen Is Displayed");
			
			new AdminPage(driver).verify_Add_News_Links_FAQ_Screen_Is_Displayed();
			Thread.sleep(1000);
			
			logInfo.pass("Verify Add News/Links/FAQ Screen Is Displayed");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Admin > Manage News/Links/FAQ > Add News/Links/FAQ Breadcrumb$")
	public void verify_Admin_Manage_News_Links_FAQ_Add_News_Links_FAQ_Breadcrumb() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Admin > Manage News/Links/FAQ > Add News/Links/FAQ Breadcrumb");
			
			new AdminPage(driver).verify_Admin_Manage_News_Links_FAQ_Add_News_Links_FAQ_Breadcrumb();
			Thread.sleep(1000);
			
			logInfo.pass("Verify Admin > Manage News/Links/FAQ > Add News/Links/FAQ Breadcrumb");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify OnScreen Text For Add News/Links/FAQ Section$")
	public void verify_OnScreen_Text_For_Add_News_Links_FAQ_Section() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify OnScreen Text For Add News/Links/FAQ Section");
			
			new AdminPage(driver).verify_OnScreen_Text_For_Add_News_Links_FAQ_Section();
			Thread.sleep(1000);
			
			logInfo.pass("Verify OnScreen Text For Add News/Links/FAQ Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify POSTING DETAILS Header In Add News/Links/FAQ Screen$")
	public void verify_POSTING_DETAILS_Header_In_Add_News_Links_FAQ_Screen() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify POSTING DETAILS Header In Add News/Links/FAQ Screen");
			
			new AdminPage(driver).verify_POSTING_DETAILS_Header_In_Add_News_Links_FAQ_Screen();
			Thread.sleep(1000);
			
			logInfo.pass("Verify POSTING DETAILS Header In Add News/Links/FAQ Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify POSTING DETAILS Section In Add News/Links/FAQ Screen$")
	public void verify_POSTING_DETAILS_Section_In_Add_News_Links_FAQ_Screen() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify POSTING DETAILS Section In Add News/Links/FAQ Screen");
			
			new AdminPage(driver).verify_POSTING_DETAILS_Section_In_Add_News_Links_FAQ_Screen();
			Thread.sleep(1000);
			
			logInfo.pass("Verify POSTING DETAILS Section In Add News/Links/FAQ Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify DISPLAY NEWS/LINKS/FAQ TO Header In Add News/Links/FAQ Screen$")
	public void verify_DISPLAY_NEWS_LINKS_FAQ_TO_Header_In_Add_News_Links_FAQ_Screen() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify DISPLAY NEWS/LINKS/FAQ TO Header In Add News/Links/FAQ Screen");
			
			new AdminPage(driver).verify_DISPLAY_NEWS_LINKS_FAQ_TO_Header_In_Add_News_Links_FAQ_Screen();
			Thread.sleep(1000);
			
			logInfo.pass("Verify DISPLAY NEWS/LINKS/FAQ TO Header In Add News/Links/FAQ Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}

	@Then("^Verify DISPLAY NEWS/LINKS/FAQ TO Input Section In Add News/Links/FAQ Screen$")
	public void verify_DISPLAY_NEWS_LINKS_FAQ_TO_Input_Section_In_Add_News_Links_FAQ_Screen() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify DISPLAY NEWS/LINKS/FAQ TO Input Section In Add News/Links/FAQ Screen");
			
			new AdminPage(driver).verify_DISPLAY_NEWS_LINKS_FAQ_TO_Input_Section_In_Add_News_Links_FAQ_Screen();
			Thread.sleep(1000);
			
			logInfo.pass("Verify DISPLAY NEWS/LINKS/FAQ TO Input Section In Add News/Links/FAQ Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Details Section In Add News/Links/FAQ Screen$")
	public void verify_Details_Section_In_Add_News_Links_FAQ_Screen() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Details Section In Add News/Links/FAQ Screen");
			
			new AdminPage(driver).verify_Details_Section_In_Add_News_Links_FAQ_Screen();
			Thread.sleep(1000);
			
			logInfo.pass("Verify Details Section In Add News/Links/FAQ Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Select Study Links From Content Type Dropdown$")
	public void select_Study_Links_From_Content_Type_Dropdown() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select Study Links From Content Type Dropdown");
			
			new AdminPage(driver).select_Study_Links_From_Content_Type_Dropdown();
			Thread.sleep(3000);
			
			logInfo.pass("Select Study Links From Content Type Dropdown");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Select Sponsor Links From Content Type Dropdown$")
	public void select_Sponsor_Links_From_Content_Type_Dropdown() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select Sponsor Links From Content Type Dropdown");
			
			new AdminPage(driver).select_Sponsor_Links_From_Content_Type_Dropdown();
			Thread.sleep(3000);
			
			logInfo.pass("Select Sponsor Links From Content Type Dropdown");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Select Sponsor News From Content Type Dropdown$")
	public void select_Sponsor_News_From_Content_Type_Dropdown() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select Sponsor News From Content Type Dropdown");
			
			new AdminPage(driver).select_Sponsor_News_From_Content_Type_Dropdown();
			Thread.sleep(3000);
			
			logInfo.pass("Select Sponsor News From Content Type Dropdown");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Select Study FAQs From Content Type Dropdown$")
	public void select_Study_FAQs_From_Content_Type_Dropdown() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select Study FAQs From Content Type Dropdown");
			
			new AdminPage(driver).select_Study_FAQs_From_Content_Type_Dropdown();
			Thread.sleep(3000);
			
			logInfo.pass("Study FAQs Selected From Content Type Dropdown");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Select Study News From Content Type Dropdown$")
	public void select_Study_News_From_Content_Type_Dropdown() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select Study News From Content Type Dropdown");
			
			new AdminPage(driver).select_Study_News_From_Content_Type_Dropdown();
			Thread.sleep(3000);
			
			logInfo.pass("Select Study News From Content Type Dropdown");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On Upload New Document Button Under DETAILS OF THE FAQ Section$")
	public void click_On_Upload_New_Document_Button_Under_DETAILS_OF_THE_FAQ_Section() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Upload New Document Button Under DETAILS OF THE FAQ Section");
			
			new AdminPage(driver).click_On_Upload_New_Document_Button_Under_DETAILS_OF_THE_FAQ_Section();
			Thread.sleep(3000);
			
			logInfo.pass("Click On Upload New Document Button Under DETAILS OF THE FAQ Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Upload New Document From Local Machine$")
	public void upload_New_Document_From_Local_Machine() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Upload New Document From Local Machine");
			
			new AdminPage(driver).upload_New_Document_From_Local_Machine();
			Thread.sleep(2000);
			
			logInfo.pass("Upload New Document From Local Machine");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Set Document Description In Upload New Document PopUp$")
	public void set_Document_Description_In_Upload_New_Document_PopUp() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Set Document Description In Upload New Document PopUp");
			
			new AdminPage(driver).set_Document_Description_In_Upload_New_Document_PopUp();
			Thread.sleep(2000);
			
			logInfo.pass("Set Document Description In Upload New Document PopUp");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On Upload Button In Upload New Document PopUp$")
	public void click_On_Upload_Button_In_Upload_New_Document_PopUp() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Upload Button In Upload New Document PopUp");
			
			new AdminPage(driver).click_On_Upload_Button_In_Upload_New_Document_PopUp();
			Thread.sleep(10000);
			
			logInfo.pass("Click On Upload Button In Upload New Document PopUp");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	
	@Then("^Verify Details Header In Add News/Links/FAQ Screen$")
	public void verify_Details_Header_In_Add_News_Links_FAQ_Screen() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Details Header In Add News/Links/FAQ Screen");
			
			new AdminPage(driver).verify_Details_Header_In_Add_News_Links_FAQ_Screen();
			Thread.sleep(1000);
			
			logInfo.pass("Verify Details Header In Add News/Links/FAQ Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Displayed$")
	public void verify_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section_Displayed() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Displayed");
			
			new AdminPage(driver).verify_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section_Displayed();
			Thread.sleep(1000);
			
			logInfo.pass("Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Displayed");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	
	
	@Then("^Click On Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Displayed$")
	public void click_On_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section_Displayed() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Displayed");
			
			new AdminPage(driver).click_On_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section_Displayed();
			Thread.sleep(1000);
			
			logInfo.pass("Click On Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Displayed");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Displayed For Edit$")
	public void click_On_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section_Displayed_For_Edit() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Displayed For Edit");
			
			new AdminPage(driver).click_On_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section_Displayed_For_Edit();
			Thread.sleep(1000);
			
			logInfo.pass("Click On Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Displayed For Edit");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On Close Icon In Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Displayed$")
	public void click_On_Close_Icon_In_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section_Displayed() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Close Icon In Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Displayed");
			
			new AdminPage(driver).click_On_Close_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section_Displayed();
			Thread.sleep(3000);
			
			logInfo.pass("Click On Close Icon In Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Displayed");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Select Compound (\\d+) For StudyId (\\d+) In Compound Dropdown$")
	public void select_Compound_For_StudyId_In_Compound_Dropdown(int arg1, int arg2) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select Compound "+arg1+" For StudyId "+arg2+" In Compound Dropdown");
			
			new AdminPage(driver).select_Compound_For_StudyId_In_Compound_Dropdown(arg1,arg2);
			Thread.sleep(3000);
			
			logInfo.pass("Select Compound "+arg1+" For StudyId "+arg2+" In Compound Dropdown");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Enter Text In Subject Textbox Under DETAILS Section$")
	public void enter_Text_In_Subject_Textbox_Under_DETAILS_Section() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Enter Text In Subject Textbox Under DETAILS Section");
			
			new AdminPage(driver).enter_Text_In_Subject_Textbox_Under_DETAILS_Section();
			Thread.sleep(3000);
			
			logInfo.pass("Enter Text In Subject Textbox Under DETAILS Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Enter Text In Subject Textbox Under DETAILS Section For Study News$")
	public void enter_Text_In_Subject_Textbox_Under_DETAILS_Section_For_Study_News() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Enter Text In Subject Textbox Under DETAILS Section For Study News");
			
			new AdminPage(driver).enter_Text_In_Subject_Textbox_Under_DETAILS_Section_For_Study_News();
			Thread.sleep(3000);
			
			logInfo.pass("Enter Text In Subject Textbox Under DETAILS Section For Study News");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Enter Description In Subject Textbox Under DETAILS Section For Study News$")
	public void enter_Description_In_Subject_Textbox_Under_DETAILS_Section_For_Study_News() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Enter Description In Subject Textbox Under DETAILS Section For Study News");
			
			new AdminPage(driver).enter_Description_In_Subject_Textbox_Under_DETAILS_Section_For_Study_News();
			Thread.sleep(3000);
			
			logInfo.pass("Enter Description In Subject Textbox Under DETAILS Section For Study News");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Select Program (\\d+) For StudyId (\\d+) In Program Dropdown$")
	public void select_Program_For_StudyId_In_Compound_Dropdown(int arg1, int arg2) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select Program "+arg1+" For StudyId "+arg2+" In Program Dropdown");
			
			new AdminPage(driver).select_Program_For_StudyId_In_Compound_Dropdown(arg1,arg2);
			Thread.sleep(3000);
			
			logInfo.pass("Select Program "+arg1+" For StudyId "+arg2+" In Program Dropdown");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Select Current Date In Expiration Date Under DETAILS Section$")
	public void select_Current_Date_In_Expiration_Date_Under_DETAILS_Section() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select Current Date In Expiration Date Under DETAILS Section");
			
			new AdminPage(driver).select_Current_Date_In_Expiration_Date_Under_DETAILS_Section();
			Thread.sleep(3000);
			
			logInfo.pass("Select Current Date In Expiration Date Under DETAILS Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Select Display Date In Expiration Date Under DETAILS Section$")
	public void select_Display_Date_In_Expiration_Date_Under_DETAILS_Section() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select Display Date In Expiration Date Under DETAILS Section");
			
			new AdminPage(driver).select_Display_Date_In_Expiration_Date_Under_DETAILS_Section();
			Thread.sleep(3000);
			
			logInfo.pass("Select Display Date In Expiration Date Under DETAILS Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Select Display Date In Display Date Under DETAILS OF THE FAQ Section$")
	public void select_Display_Date_In_Display_Date_Under_DETAILS_OF_THE_FAQ_Section() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select Display Date In Display Date Under DETAILS OF THE FAQ Section");
			
			new AdminPage(driver).select_Display_Date_In_Display_Date_Under_DETAILS_OF_THE_FAQ_Section();
			Thread.sleep(3000);
			
			logInfo.pass("Select Display Date In Display Date Under DETAILS OF THE FAQ Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Select Current Date In Expiration Date Under DETAILS OF THE FAQ Section$")
	public void select_Current_Date_In_Expiration_Date_Under_DETAILS_OF_THE_FAQ_Section() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select Current Date In Expiration Date Under DETAILS OF THE FAQ Section");
			
			new AdminPage(driver).select_Current_Date_In_Expiration_Date_Under_DETAILS_OF_THE_FAQ_Section();
			Thread.sleep(3000);
			
			logInfo.pass("Select Current Date In Expiration Date Under DETAILS OF THE FAQ Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On PROCEED Button Under DETAILS Section$")
	public void click_On_PROCEED_Button_Under_DETAILS_Section() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On PROCEED Button Under DETAILS Section");
			
			new AdminPage(driver).click_On_PROCEED_Button_Under_DETAILS_Section();
			Thread.sleep(3000);
			
			logInfo.pass("Click On PROCEED Button Under DETAILS Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On PROCEED Button Under DETAILS OF THE FAQ Section$")
	public void click_On_PROCEED_Button_Under_DETAILS_OF_THE_FAQ_Section() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On PROCEED Button Under DETAILS OF THE FAQ Section");
			
			new AdminPage(driver).click_On_PROCEED_Button_Under_DETAILS_Section();
			Thread.sleep(3000);
			
			logInfo.pass("Click On PROCEED Button Under DETAILS OF THE FAQ Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Enter URL In URL TextBox Under DETAILS Section$")
	public void enter_URL_In_URL_TextBox_Under_DETAILS_Section() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Enter URL In URL TextBox Under DETAILS Section");
			
			new AdminPage(driver).enter_URL_In_URL_TextBox_Under_DETAILS_Section();
			Thread.sleep(3000);
			
			logInfo.pass("Enter URL In URL TextBox Under DETAILS Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Enter URL In Subject Textbox Under DETAILS Section For Study News$")
	public void enter_URL_In_Subject_Textbox_Under_DETAILS_Section_For_Study_News() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Enter URL In Subject Textbox Under DETAILS Section For Study News");
			
			new AdminPage(driver).enter_URL_In_URL_TextBox_Under_DETAILS_Section();
			Thread.sleep(3000);
			
			logInfo.pass("Enter URL In Subject Textbox Under DETAILS Section For Study News");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Country (\\d+) Displayed In Study Link PopUp$")
	public void verify_Country_Displayed_In_Study_Link_PopUp(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Country "+arg1+" Displayed In Study Link PopUp");
			
			new AdminPage(driver).verify_Country_Displayed_In_Study_Link_PopUp(arg1);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Country "+arg1+" Displayed In Study Link PopUp");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Study (\\d+) Country (\\d+) Displayed In Study Link PopUp$")
	public void verify_Study_Country_Displayed_In_Study_Link_PopUp(int arg1, int arg2) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Study "+arg1+" Country "+arg2+" Displayed In Study Link PopUp");
			
			new AdminPage(driver).verify_Study_Country_Displayed_In_Study_Link_PopUp(arg1,arg2);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Study "+arg1+" Country "+arg2+" Displayed In Study Link PopUp");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Study (\\d+) Displayed In Study Link PopUp$")
	public void verify_Study_Displayed_In_Study_Link_PopUp(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Study "+arg1+" Displayed In Study Link PopUp");
			
			new AdminPage(driver).verify_Study_Displayed_In_Study_Link_PopUp(arg1);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Study "+arg1+" Displayed In Study Link PopUp");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Country (\\d+) Displayed Under Study Country In Study FAQs PopUp$")
	public void verify_Country_Displayed_Under_Study_Country_In_Study_FAQs_PopUp(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Country "+arg1+" Displayed Under Study Country In Study FAQs PopUp");
			
			new AdminPage(driver).verify_Country_Displayed_Under_Study_Country_In_Study_FAQs_PopUp(arg1);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Country "+arg1+" Displayed Under Study Country In Study FAQs PopUp");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On Publish Button In Study Link PopUp$")
	public void click_On_Publish_Button_In_Study_Link_PopUp() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Publish Button In Study Link PopUp");
			
			new AdminPage(driver).click_On_Publish_Button_In_Study_Link_PopUp();
			Thread.sleep(10000);
			
			logInfo.pass("Click On Publish Button In Study Link PopUp");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify News/Link/FAQ has been successfully published PopUp$")
	public void verify_News_Link_FAQ_has_been_successfully_published_PopUp() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify News/Link/FAQ has been successfully published PopUp");
			
			new AdminPage(driver).verify_News_Link_FAQ_has_been_successfully_published_PopUp();
			Thread.sleep(1000);
			
			logInfo.pass("Verify News/Link/FAQ has been successfully published PopUp");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify News/Link/FAQ has been successfully Updated PopUp$")
	public void verify_News_Link_FAQ_has_been_successfully_Updated_PopUp() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify News/Link/FAQ has been successfully Updated PopUp");
			
			new AdminPage(driver).verify_News_Link_FAQ_has_been_successfully_Updated_PopUp();
			Thread.sleep(1000);
			
			logInfo.pass("Verify News/Link/FAQ has been successfully Updated PopUp");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On OK Button In News/Link/FAQ has been successfully published PopUp$")
	public void click_On_OK_Button_In_News_Link_FAQ_has_been_successfully_published_PopUp() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On OK Button In News/Link/FAQ has been successfully published PopUp");
			
			new AdminPage(driver).click_On_OK_Button_In_News_Link_FAQ_has_been_successfully_published_PopUp();
			Thread.sleep(10000);
			
			logInfo.pass("Click On OK Button In News/Link/FAQ has been successfully published PopUp");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Select Study Links From Content Type Dropdown Under Manage News/Links/FAQ Screen$")
	public void select_Study_Links_From_Content_Type_Dropdown_Under_Manage_News_Links_FAQ_Screen() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select Study Links From Content Type Dropdown Under Manage News/Links/FAQ Screen");
			
			new AdminPage(driver).select_Study_Links_From_Content_Type_Dropdown_Under_Manage_News_Links_FAQ_Screen();
			Thread.sleep(3000);
			
			logInfo.pass("Select Study Links From Content Type Dropdown Under Manage News/Links/FAQ Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Content Type Dropdown In Manage News/Links/FAQ section$")
	public void verify_Content_Type_Dropdown_In_Manage_News_Links_FAQ_section() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Content Type Dropdown In Manage News/Links/FAQ section");
			
			new AdminPage(driver).verify_Content_Type_Dropdown_In_Manage_News_Links_FAQ_section();
			Thread.sleep(1000);
			
			logInfo.pass("Verify Content Type Dropdown In Manage News/Links/FAQ section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Target Audience Dropdown In Manage News/Links/FAQ section$")
	public void verify_Target_Audience_Dropdown_In_Manage_News_Links_FAQ_section() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Target Audience Dropdown In Manage News/Links/FAQ section");
			
			new AdminPage(driver).verify_Target_Audience_Dropdown_In_Manage_News_Links_FAQ_section();
			Thread.sleep(1000);
			
			logInfo.pass("Verify Target Audience Dropdown In Manage News/Links/FAQ section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify All Option Of Target Audience In Manage News/Links/FAQ section$")
	public void verify_All_Option_Of_Target_Audience_In_Manage_News_Links_FAQ_section() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify All Option Of Target Audience In Manage News/Links/FAQ section");
			
			new AdminPage(driver).verify_All_Option_Of_Target_Audience_In_Manage_News_Links_FAQ_section();
			Thread.sleep(1000);
			
			logInfo.pass("Verify All Option Of Target Audience In Manage News/Links/FAQ section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On Cancel Button In Add News/Links/FAQ Screen$")
	public void click_On_Cancel_Button_In_Add_News_Links_FAQ_Screen() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Cancel Button In Add News/Links/FAQ Screen");
			
			new AdminPage(driver).Cancel_btn.click();
			Thread.sleep(10000);
			
			logInfo.pass("Click On Cancel Button In Add News/Links/FAQ Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Manage News/Links/FAQ Link Screen Is Displayed$")
	public void verify_Manage_News_Links_FAQ_Link_Screen_Is_Displayed() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Manage News/Links/FAQ Link Screen Is Displayed");
			
			new AdminPage(driver).verify_Manage_News_Links_FAQ_Link_Screen_Is_Displayed();
			Thread.sleep(1000);
			
			logInfo.pass("Verify Manage News/Links/FAQ Link Screen Is Displayed");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	
	@Then("^Verify Expiration Date Range In Manage News/Links/FAQ section$")
	public void verify_Expiration_Date_Range_In_Manage_News_Links_FAQ_section() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Expiration Date Range In Manage News/Links/FAQ section");
			
			new AdminPage(driver).verify_Expiration_Date_Range_In_Manage_News_Links_FAQ_section();
			Thread.sleep(1000);
			
			logInfo.pass("Verify Expiration Date Range In Manage News/Links/FAQ section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Compound In Manage News/Links/FAQ section$")
	public void verify_Compound_In_Manage_News_Links_FAQ_section() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Compound In Manage News/Links/FAQ section");
			
			new AdminPage(driver).verify_Compound_In_Manage_News_Links_FAQ_section();
			Thread.sleep(1000);
			
			logInfo.pass("Verify Compound In Manage News/Links/FAQ section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Program In Manage News/Links/FAQ section$")
	public void verify_Program_In_Manage_News_Links_FAQ_section() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Program In Manage News/Links/FAQ section");
			
			new AdminPage(driver).verify_Program_In_Manage_News_Links_FAQ_section();
			Thread.sleep(1000);
			
			logInfo.pass("Verify Program In Manage News/Links/FAQ section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Study ID Dropdown In Manage News/Links/FAQ section$")
	public void verify_Study_ID_Dropdown_In_Manage_News_Links_FAQ_section() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Study ID Dropdown In Manage News/Links/FAQ section");
			
			new AdminPage(driver).verify_Study_ID_Dropdown_In_Manage_News_Links_FAQ_section();
			Thread.sleep(1000);
			
			logInfo.pass("Verify Study ID Dropdown In Manage News/Links/FAQ section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify All Options Of Content Type Dropdown In Manage News/Links/FAQ section$")
	public void verify_All_Options_Of_Content_Type_Dropdown_In_Manage_News_Links_FAQ_section() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify All Options Of Content Type Dropdown In Manage News/Links/FAQ section");
			
			new AdminPage(driver).verify_All_Options_Of_Content_Type_Dropdown_In_Manage_News_Links_FAQ_section();
			Thread.sleep(1000);
			
			logInfo.pass("Verify All Options Of Content Type Dropdown In Manage News/Links/FAQ section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Select Study News From Content Type Dropdown Under Manage News/Links/FAQ Screen$")
	public void select_Study_News_From_Content_Type_Dropdown_Under_Manage_News_Links_FAQ_Screen() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select Study News From Content Type Dropdown Under Manage News/Links/FAQ Screen");
			
			new AdminPage(driver).select_Study_News_From_Content_Type_Dropdown_Under_Manage_News_Links_FAQ_Screen();
			Thread.sleep(3000);
			
			logInfo.pass("Select Study News From Content Type Dropdown Under Manage News/Links/FAQ Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Select Study FAQs From Content Type Dropdown Under Manage News/Links/FAQ Screen$")
	public void select_Study_FAQs_From_Content_Type_Dropdown_Under_Manage_News_Links_FAQ_Screen() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select Study FAQs From Content Type Dropdown Under Manage News/Links/FAQ Screen");
			
			new AdminPage(driver).select_Study_FAQs_From_Content_Type_Dropdown_Under_Manage_News_Links_FAQ_Screen();
			Thread.sleep(3000);
			
			logInfo.pass("Select Study FAQs From Content Type Dropdown Under Manage News/Links/FAQ Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Newly Created Study FAQs Displayed Under Manage News/Links/FAQ Table For Study (\\d+)$")
	public void verify_Newly_Created_Study_FAQs_Displayed_Under_Manage_News_Links_FAQ_Table_For_Study(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Newly Created Study FAQs Displayed Under Manage News/Links/FAQ Table For Study "+arg1);
			
			new AdminPage(driver).verify_Newly_Created_Study_FAQs_Displayed_Under_Manage_News_Links_FAQ_Table_For_Study(arg1);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Newly Created Study FAQs Displayed Under Manage News/Links/FAQ Table For Study "+arg1);
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Select (\\d+) From Show Row Under Manage News/Links/FAQ Screen$")
	public void select_From_Show_Row_Under_Manage_News_Links_FAQ_Screen(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select "+arg1+" From Show Row Under Manage News/Links/FAQ Screen");
			
			new AdminPage(driver).select_From_Show_Row_Under_Manage_News_Links_FAQ_Screen(arg1);
			Thread.sleep(15000);
			
			logInfo.pass("Select "+arg1+" From Show Row Under Manage News/Links/FAQ Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On SEARCH Button Under Manage News/Links/FAQ Screen$")
	public void click_On_SEARCH_Button_Under_Manage_News_Links_FAQ_Screen() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On SEARCH Button Under Manage News/Links/FAQ Screen");
			
			new AdminPage(driver).click_On_SEARCH_Button_Under_Manage_News_Links_FAQ_Screen();
			Thread.sleep(15000);
			
			logInfo.pass("Click On SEARCH Button Under Manage News/Links/FAQ Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Newly Created Study Link Displayed Under Manage News/Links/FAQ Table$")
	public void verify_Newly_Created_Study_Link_Displayed_Under_Manage_News_Links_FAQ_Table() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Newly Created Study Link Displayed Under Manage News/Links/FAQ Table");
			
			new AdminPage(driver).verify_Newly_Created_Study_Link_Displayed_Under_Manage_News_Links_FAQ_Table();
			Thread.sleep(1000);
			
			logInfo.pass("Verify Newly Created Study Link Displayed Under Manage News/Links/FAQ Table");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Newly Created Study News Displayed Under Manage News/Links/FAQ Table$")
	public void verify_Newly_Created_Study_News_Displayed_Under_Manage_News_Links_FAQ_Table() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Newly Created Study News Displayed Under Manage News/Links/FAQ Table");
			
			new AdminPage(driver).verify_Newly_Created_Study_News_Displayed_Under_Manage_News_Links_FAQ_Table();
			Thread.sleep(1000);
			
			logInfo.pass("Verify Newly Created Study News Displayed Under Manage News/Links/FAQ Table");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Newly Created Study News Not Displayed Under Manage News/Links/FAQ Table$")
	public void verify_Newly_Created_Study_News_Not_Displayed_Under_Manage_News_Links_FAQ_Table() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Newly Created Study News Not Displayed Under Manage News/Links/FAQ Table");
			
			new AdminPage(driver).verify_Newly_Created_Study_News_Not_Displayed_Under_Manage_News_Links_FAQ_Table();
			Thread.sleep(1000);
			
			logInfo.pass("Verify Newly Created Study News Not Displayed Under Manage News/Links/FAQ Table");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Columns Of Manage News/Links/FAQ Table$")
	public void verify_Columns_Of_Manage_News_Links_FAQ_Table() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Columns Of Manage News/Links/FAQ Table");
			
			new AdminPage(driver).verify_Columns_Of_Manage_News_Links_FAQ_Table();
			Thread.sleep(1000);
			
			logInfo.pass("Verify Columns Of Manage News/Links/FAQ Table");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Select \"([^\"]*)\" Option From Show/Hide Columns Dropdown$")
	public void select_Option_From_Show_Hide_Columns_Dropdown(String arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select "+arg1+" Option From Show/Hide Columns Dropdown");
			
			new AdminPage(driver).select_Option_From_Show_Hide_Columns_Dropdown(arg1);
			Thread.sleep(4000);
			
			logInfo.pass("Select "+arg1+" Option From Show/Hide Columns Dropdown");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Country (\\d+) Displayed Under Study Country Column For Newly Created Study Link$")
	public void verify_Country_Displayed_Under_Study_Country_Column_For_Newly_Created_Study_Link(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Country "+arg1+" Displayed Under Study Country Column For Newly Created Study Link");
			
			new AdminPage(driver).verify_Country_Displayed_Under_Study_Country_Column_For_Newly_Created_Study_Link(arg1);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Country "+arg1+" Displayed Under Study Country Column For Newly Created Study Link");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Country (\\d+) Displayed Under Study Country Column For Newly Created Study News$")
	public void verify_Country_Displayed_Under_Study_Country_Column_For_Newly_Created_Study_News(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Country "+arg1+" Displayed Under Study Country Column For Newly Created Study News");
			
			new AdminPage(driver).verify_Country_Displayed_Under_Study_Country_Column_For_Newly_Created_Study_News(arg1);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Country "+arg1+" Displayed Under Study Country Column For Newly Created Study News");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On CLEAR ALL Icon Under Study Country dropdown To Edit$")
	public void click_On_CLEAR_ALL_Icon_Under_Study_Country_dropdown_To_Edit() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On CLEAR ALL Icon Under Study Country dropdown To Edit");
			
			new AdminPage(driver).click_On_CLEAR_ALL_Icon_Under_Study_Country_dropdown_To_Edit();
			Thread.sleep(5000);
			
			logInfo.pass("Click On CLEAR ALL Icon Under Study Country dropdown To Edit");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Country (\\d+) Displayed Under Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section$")
	public void verify_Country_Displayed_Under_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Country "+arg1+" Displayed Under Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section");
			
			new AdminPage(driver).verify_Country_Displayed_Under_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section(arg1);
			Thread.sleep(1000);
			
			logInfo.pass("Study Country "+arg1+" Displayed Under Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Study (\\d+) Country (\\d+) Displayed Under Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section$")
	public void verify_Study_Country_Displayed_Under_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section(int arg1, int arg2) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Study "+arg1+" Country "+arg2+" Displayed Under Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section");
			
			new AdminPage(driver).verify_Study_Country_Displayed_Under_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section(arg1,arg2);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Study "+arg1+" Country "+arg2+" Displayed Under Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify That All Country Displayed Under Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section$")
	public void verify_That_All_Country_Displayed_Under_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify That All Country Displayed Under Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section");
			
			new AdminPage(driver).verify_That_All_Country_Displayed_Under_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section();
			Thread.sleep(1000);
			
			logInfo.pass("Verify That All Country Displayed Under Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Select Country (\\d+) Displayed Under Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section$")
	public void select_Country_Displayed_Under_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select Country "+arg1+" Displayed Under Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section");
			
			new AdminPage(driver).select_Country_Displayed_Under_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section(arg1);
			Thread.sleep(1000);
			
			logInfo.pass("Select Country "+arg1+" Displayed Under Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Select Country (\\d+) Displayed Under The Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section$")
	public void select_Country_Displayed_Under_The_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select Country "+arg1+" Displayed Under The Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section");
			
			new AdminPage(driver).select_Country_Displayed_Under_The_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section(arg1);
			Thread.sleep(5000);
			
			logInfo.pass("Select Country "+arg1+" Displayed Under The Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Select Country (\\d+) Displayed Under Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section For Study FAQs$")
	public void select_Country_Displayed_Under_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section_For_Study_FAQs(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select Country "+arg1+" Displayed Under Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section For Study FAQs");
			
			new AdminPage(driver).select_Country_Displayed_Under_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section_For_Study_FAQs(arg1);
			Thread.sleep(1000);
			
			logInfo.pass("Select Country "+arg1+" Displayed Under Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section For Study FAQs");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	@Then("^Verify Newly Created FAQs Displayed Under Study FAQ$")
	public void verify_Newly_Created_FAQs_Displayed_Under_Study_FAQ() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Newly Created FAQs Displayed Under Study FAQ");
			
			new AdminPage(driver).verify_Newly_Created_FAQs_Displayed_Under_Study_FAQ();
			Thread.sleep(1000);
			
			logInfo.pass("Verify Newly Created FAQs Displayed Under Study FAQ");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Select Study ID (\\d+) From Study ID Dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section$")
	public void select_Study_ID_From_Study_ID_Dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select Study ID "+arg1+" From Study ID Dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section");
			
			new AdminPage(driver).select_Study_ID_From_Study_ID_Dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section(arg1);
			Thread.sleep(1000);
			
			logInfo.pass("Select Study ID "+arg1+" From Study ID Dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Country (\\d+) Not Displayed Under Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section$")
	public void verify_Country_Not_Displayed_Under_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Country "+arg1+" Not Displayed Under Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section");
			
			new AdminPage(driver).verify_Country_Not_Displayed_Under_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section(arg1);
			Thread.sleep(1000);
			
			logInfo.pass("Study Country "+arg1+" Is Not Displayed Under Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify That Country (\\d+) Displayed Under Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section$")
	public void verify_That_Country_Displayed_Under_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify That Country "+arg1+" Displayed Under Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section");
			
			new AdminPage(driver).verify_Country_Set_And_Displayed_Under_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section(arg1);
			Thread.sleep(1000);
			
			logInfo.pass("Study Country "+arg1+" Is Not Displayed Under Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Select Study (\\d+) Country (\\d+) Displayed Under Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section$")
	public void select_Study_Country_Displayed_Under_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section(int arg1, int arg2) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select Study "+arg1+" Country "+arg2+" Displayed Under Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section");
			
			new AdminPage(driver).select_Study_Country_Displayed_Under_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section(arg1,arg2);
			Thread.sleep(1000);
			
			logInfo.pass("Select Study "+arg1+" Country "+arg2+" Displayed Under Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On CLEAR ALL Icon Under Study Country dropdown$")
	public void click_On_CLEAR_ALL_Icon_Under_Study_Country_dropdown() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On CLEAR ALL Icon Under Study Country dropdown");
			
			new AdminPage(driver).click_On_CLEAR_ALL_Icon_Under_Study_Country_dropdown();
			Thread.sleep(3000);
			
			logInfo.pass("Click On CLEAR ALL Icon Under Study Country dropdown");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On Checkbox against Send Notification Email will be sent as per users email preference$")
	public void click_On_Checkbox_against_Send_Notification_Email_will_be_sent_as_per_users_email_preference() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Checkbox against Send Notification Email will be sent as per users email preference");
			
			new AdminPage(driver).click_On_Checkbox_against_Send_Notification_Email_will_be_sent_as_per_users_email_preference();
			Thread.sleep(3000);
			
			logInfo.pass("Click On Checkbox against Send Notification Email will be sent as per users email preference");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Select Site and Sponsor User Radio Button Under POSTING DETAILS Section$")
	public void select_Site_and_Sponsor_User_Radio_Button_Under_POSTING_DETAILS_Section() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select Site and Sponsor User Radio Button Under POSTING DETAILS Section");
			
			new AdminPage(driver).select_Site_and_Sponsor_User_Radio_Button_Under_POSTING_DETAILS_Section();
			Thread.sleep(3000);
			
			logInfo.pass("Select Site and Sponsor User Radio Button Under POSTING DETAILS Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Select Sponsor User Radio Button Under POSTING DETAILS Section$")
	public void select_Sponsor_User_Radio_Button_Under_POSTING_DETAILS_Section() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select Sponsor User Radio Button Under POSTING DETAILS Section");
			
			new AdminPage(driver).select_Sponsor_User_Radio_Button_Under_POSTING_DETAILS_Section();
			Thread.sleep(3000);
			
			logInfo.pass("Select Sponsor User Radio Button Under POSTING DETAILS Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Study Country is required Error Message$")
	public void verify_Study_Country_is_required_Error_Message() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Study Country is required Error Message");
			
			new AdminPage(driver).verify_Study_Country_is_required_Error_Message();
			Thread.sleep(1000);
			
			logInfo.pass("Study Country is required Error Message Displayed");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Sponsor User Role Dropdown Displayed Under POSTING DETAILS Section$")
	public void verify_Sponsor_User_Role_Dropdown_Displayed_Under_POSTING_DETAILS_Section() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Sponsor User Role Dropdown Displayed Under POSTING DETAILS Section");
			
			new AdminPage(driver).verify_Sponsor_User_Role_Dropdown_Displayed_Under_POSTING_DETAILS_Section();
			Thread.sleep(1000);
			
			logInfo.pass("Verify Sponsor User Role Dropdown Displayed Under POSTING DETAILS Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Site User Role Dropdown Displayed Under POSTING DETAILS Section$")
	public void verify_Site_User_Role_Dropdown_Displayed_Under_POSTING_DETAILS_Section() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User Role Dropdown Displayed Under POSTING DETAILS Section");
			
			new AdminPage(driver).verify_Site_User_Role_Dropdown_Displayed_Under_POSTING_DETAILS_Section();
			Thread.sleep(1000);
			
			logInfo.pass("Verify Site User Role Dropdown Displayed Under POSTING DETAILS Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On Clear All Option From Sponsor User Role Dropdown$")
	public void click_On_Clear_All_Option_From_Sponsor_User_Role_Dropdown() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Clear All Option From Sponsor User Role Dropdown");
			
			new AdminPage(driver).click_On_Clear_All_Option_From_Sponsor_User_Role_Dropdown();
			Thread.sleep(3000);
			
			logInfo.pass("Click On Clear All Option From Sponsor User Role Dropdown");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	@Then("^Verify \"([^\"]*)\" Role From Sponsor User Role Dropdown$")
	public void verify_Role_From_Sponsor_User_Role_Dropdown(String arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify "+arg1+" Role From Sponsor User Role Dropdown");
			
			new AdminPage(driver).verify_Role_From_Sponsor_User_Role_Dropdown(arg1);
			Thread.sleep(1000);
			
			logInfo.pass("Verify "+arg1+" Role From Sponsor User Role Dropdown");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify \"([^\"]*)\" Role From Sponsor User Role Dropdown For Study News/Links$")
	public void verify_Role_From_Sponsor_User_Role_Dropdown_For_Study_News_Links(String arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify "+arg1+" Role From Sponsor User Role Dropdown For Study News/Links");
			
			new AdminPage(driver).verify_Role_From_Sponsor_User_Role_Dropdown_For_Study_News_Links(arg1);
			Thread.sleep(1000);
			
			logInfo.pass("Verify "+arg1+" Role From Sponsor User Role Dropdown For Study News/Links");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Select \"([^\"]*)\" Role From Sponsor User Role Dropdown$")
	public void select_Role_From_Sponsor_User_Role_Dropdown(String arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select "+arg1+" Role From Sponsor User Role Dropdown");
			
			new AdminPage(driver).select_Role_From_Sponsor_User_Role_Dropdown(arg1);
			Thread.sleep(1000);
			
			logInfo.pass("Select "+arg1+" Role From Sponsor User Role Dropdown");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On Clear All Option From Site User Role Dropdown$")
	public void click_On_Clear_All_Option_From_Site_User_Role_Dropdown() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Clear All Option From Site User Role Dropdown");
			
			new AdminPage(driver).click_On_Clear_All_Option_From_Site_User_Role_Dropdown();
			Thread.sleep(3000);
			
			logInfo.pass("Click On Clear All Option From Site User Role Dropdown");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Newly Created Study News Displayed Under Subject/Document Column$")
	public void verify_Newly_Created_Study_News_Displayed_Under_Subject_Document_Column() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Newly Created Study News Displayed Under Subject/Document Column");
			
			new AdminPage(driver).verify_Newly_Created_Study_News_Displayed_Under_Subject_Document_Column();
			Thread.sleep(1000);
			
			logInfo.pass("Verify Newly Created Study News Displayed Under Subject/Document Column");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Scroll ManageSponsorStudyNewsLinksTable To View Actions Dropdown$")
	public void scroll_ManageSponsorStudyNewsLinksTable_To_View_Actions_Dropdown() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Scroll ManageSponsorStudyNewsLinksTable To View Actions Dropdown");
			
			new AdminPage(driver).scroll_ManageSponsorStudyNewsLinksTable_To_View_Actions_Dropdown();
			Thread.sleep(4000);
			
			logInfo.pass("Scroll ManageSponsorStudyNewsLinksTable To View Actions Dropdown");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On Edit Button Against Newly Created Study News Displayed Under Actions Column$")
	public void click_On_Edit_Button_Against_Newly_Created_Study_News_Displayed_Under_Actions_Column() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Edit Button Against Newly Created Study News Displayed Under Actions Column");
			
			new AdminPage(driver).click_On_Edit_Button_Against_Newly_Created_Study_News_Displayed_Under_Actions_Column();
			Thread.sleep(10000);
			
			logInfo.pass("Click On Edit Button Against Newly Created Study News Displayed Under Actions Column");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify \"([^\"]*)\" Role From Site User Role Dropdown$")
	public void verify_Role_From_Site_User_Role_Dropdown(String arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify "+arg1+" Role From Site User Role Dropdown");
			
			new AdminPage(driver).verify_Role_From_Site_User_Role_Dropdown(arg1);
			Thread.sleep(3000);
			
			logInfo.pass("Verify "+arg1+" Role From Site User Role Dropdown");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify \"([^\"]*)\" Role From Site User Role Dropdown For Study News/Links$")
	public void verify_Role_From_Site_User_Role_Dropdown_For_Study_News_Links(String arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify "+arg1+" Role From Site User Role Dropdown For Study News/Links");
			
			new AdminPage(driver).verify_Role_From_Site_User_Role_Dropdown_For_Study_News_Links(arg1);
			Thread.sleep(3000);
			
			logInfo.pass("Verify "+arg1+" Role From Site User Role Dropdown For Study News/Links");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	
	@Then("^Select \"([^\"]*)\" Role From Site User Role Dropdown$")
	public void select_Role_From_Site_User_Role_Dropdown(String arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select "+arg1+" Role From Site User Role Dropdown");
			
			new AdminPage(driver).select_Role_From_Site_User_Role_Dropdown(arg1);
			Thread.sleep(3000);
			
			logInfo.pass("Select "+arg1+" Role From Site User Role Dropdown");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Compound Dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Is Visible$")
	public void verify_Compound_Dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section_Is_Visible() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Compound Dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Is Visible");
			
			new AdminPage(driver).verify_Compound_Dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section_Is_Visible();
			Thread.sleep(1000);
			
			logInfo.pass("Verify Compound Dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Is Visible");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Program Dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Is Visible$")
	public void verify_Program_Dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section_Is_Visible() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Program Dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Is Visible");
			
			new AdminPage(driver).verify_Program_Dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section_Is_Visible();
			Thread.sleep(1000);
			
			logInfo.pass("Verify Program Dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Is Visible");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Study ID Dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Is Visible$")
	public void verify_Study_ID_Dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section_Is_Visible() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Study ID Dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Is Visible");
			
			new AdminPage(driver).verify_Study_ID_Dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section_Is_Visible();
			Thread.sleep(1000);
			
			logInfo.pass("Verify Study ID Dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Is Visible");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On DELEGATED TO ME Tab$")
	public void click_On_DELEGATED_TO_ME_Tab() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On DELEGATED TO ME Tab");
			
			new AdminPage(driver).DELEGATE_TO_ME_Tab.click();
			Thread.sleep(10000);
			
			logInfo.pass("Click On DELEGATED TO ME Tab");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Site User (\\d+) For Facility (\\d+) Is Displayed Under DELEGATE FOR CURRENT AND FUTURE STUDIES/ FACILITY Table As Active$")
	public void verify_Site_User_For_Facility_Is_Displayed_Under_DELEGATE_FOR_CURRENT_AND_FUTURE_STUDIES_FACILITY_Table_As_Active(int arg1, int arg2) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" For Facility "+arg2+" Is Displayed Under DELEGATE FOR CURRENT AND FUTURE STUDIES/ FACILITY Table As Active");
			
			new AdminPage(driver).verify_Site_User_For_Facility_Is_Displayed_Under_DELEGATE_FOR_CURRENT_AND_FUTURE_STUDIES_FACILITY_Table_As_Active(arg1,arg2);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Site User "+arg1+" For Facility "+arg2+" Is Displayed Under DELEGATE FOR CURRENT AND FUTURE STUDIES/ FACILITY Table As Active");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On Study Site Profile Maintenance Section Displayed Under Manage Delegation on behalf of Site User Screen$")
	public void click_On_Study_Site_Profile_Maintenance_Section_Displayed_Under_Manage_Delegation_on_behalf_of_Site_User_Screen() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Study Site Profile Maintenance Section Displayed Under Manage Delegation on behalf of Site User Screen");
			
			new AdminPage(driver).click_On_Study_Site_Profile_Maintenance_Section_Displayed_Under_Manage_Delegation_on_behalf_of_Site_User_Screen();
			Thread.sleep(10000);
			
			logInfo.pass("Click On Study Site Profile Maintenance Section Displayed Under Manage Delegation on behalf of Site User Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Site User (\\d+) From Facility (\\d+) Associated with Department (\\d+) Displayed as \"([^\"]*)\"$")
	public void verify_Site_User_From_Facility_Associated_with_Department_Displayed_as(int arg1, int arg2, int arg3, String arg4) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" From Facility "+arg2+" Associated with Department "+arg3+" Displayed as "+arg4);
			
			new AdminPage(driver).verify_Site_User_From_Facility_Associated_with_Department_Displayed_as(arg1,arg2,arg3,arg4);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Site User "+arg1+" From Facility "+arg2+" Associated with Department "+arg3+" Displayed as "+arg4);
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On Study Site Profile Maintenance Section Under Manage Delegation Screen$")
	public void click_On_Study_Site_Profile_Maintenance_Section_Under_Manage_Delegation_Screen() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Study Site Profile Maintenance Section Under Manage Delegation Screen");
			
			new AdminPage(driver).click_On_Study_Site_Profile_Maintenance_Section_Displayed_Under_Manage_Delegation_on_behalf_of_Site_User_Screen();
			Thread.sleep(30000);
			
			logInfo.pass("Click On Study Site Profile Maintenance Section Under Manage Delegation Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Site User (\\d+) With Facility (\\d+) Displayed Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen$")
	public void verify_Site_User_With_Facility_Displayed_Under_STUDY_SITE_MAINTENANCE_DELEGATES_In_Delegate_Study_Sites_Screen(int arg1, int arg2) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" With Facility "+arg2+" Displayed Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen");
			
			new AdminPage(driver).verify_Site_User_With_Facility_Displayed_Under_STUDY_SITE_MAINTENANCE_DELEGATES_In_Delegate_Study_Sites_Screen(arg1,arg2);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Site User "+arg1+" With Facility "+arg2+" Displayed Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Site User (\\d+) With Facility (\\d+) Not Displayed Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen$")
	public void verify_Site_User_With_Facility_Not_Displayed_Under_STUDY_SITE_MAINTENANCE_DELEGATES_In_Delegate_Study_Sites_Screen(int arg1, int arg2) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" With Facility "+arg2+" Not Displayed Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen");
			
			new AdminPage(driver).verify_Site_User_With_Facility_Not_Displayed_Under_STUDY_SITE_MAINTENANCE_DELEGATES_In_Delegate_Study_Sites_Screen(arg1,arg2);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Site User "+arg1+" With Facility "+arg2+" Not Displayed Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On Remove Button Against Site User (\\d+) With Facility (\\d+) Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen$")
	public void click_On_Remove_Button_Against_Site_User_With_Facility_Under_STUDY_SITE_MAINTENANCE_DELEGATES_In_Delegate_Study_Sites_Screen(int arg1, int arg2) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Remove Button Against Site User "+arg1+" With Facility "+arg2+" Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen");
			
			new AdminPage(driver).click_On_Remove_Button_Against_Site_User_With_Facility_Under_STUDY_SITE_MAINTENANCE_DELEGATES_In_Delegate_Study_Sites_Screen(arg1,arg2);
			Thread.sleep(1000);
			
			logInfo.pass("Click On Remove Button Against Site User "+arg1+" With Facility "+arg2+" Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify No Delegate Message Displayed Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen$")
	public void verify_No_Delegate_Message_Displayed_Under_STUDY_SITE_MAINTENANCE_DELEGATES_In_Delegate_Study_Sites_Screen() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify No Delegate Message Displayed Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen");
			
			new AdminPage(driver).verify_No_Delegate_Message_Displayed_Under_STUDY_SITE_MAINTENANCE_DELEGATES_In_Delegate_Study_Sites_Screen();
			Thread.sleep(1000);
			
			logInfo.pass("Verify No Delegate Message Displayed Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On Yes Button In Remove Study Delegate PopUp Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen$")
	public void click_On_Yes_Button_In_Remove_Study_Delegate_PopUp_Under_STUDY_SITE_MAINTENANCE_DELEGATES_In_Delegate_Study_Sites_Screen() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Yes Button In Remove Study Delegate PopUp Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen");
			
			new AdminPage(driver).RemoveDelegate_ConfirmButton.click();
			Thread.sleep(1000);
			
			logInfo.pass("Click On Yes Button In Remove Study Delegate PopUp Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	
	
	@Then("^Verify CURRENT STUDY SITE DELEGATES Table In Delegate Study Sites Screen$")
	public void verify_CURRENT_STUDY_SITE_DELEGATES_Table_In_Delegate_Study_Sites_Screen() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify CURRENT STUDY SITE DELEGATES Table In Delegate Study Sites Screen");
			
			new AdminPage(driver).verify_CURRENT_STUDY_SITE_DELEGATES_Table_In_Delegate_Study_Sites_Screen();
			Thread.sleep(1000);
			
			logInfo.pass("Verify CURRENT STUDY SITE DELEGATES Table In Delegate Study Sites Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Site User (\\d+) For Study (\\d+) Is Displayed In CURRENT STUDY SITE DELEGATES Table$")
	public void verify_Site_User_For_Study_Is_Displayed_In_CURRENT_STUDY_SITE_DELEGATES_Table(int arg1, int arg2) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" For Study "+arg2+" Is Displayed In CURRENT STUDY SITE DELEGATES Table");
			
			new AdminPage(driver).verify_Site_User_For_Study_Is_Displayed_In_CURRENT_STUDY_SITE_DELEGATES_Table(arg1,arg2);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Site User "+arg1+" For Study "+arg2+" Is Displayed In CURRENT STUDY SITE DELEGATES Table");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Site User (\\d+) For Study (\\d+) Is Not Displayed In CURRENT STUDY SITE DELEGATES Table$")
	public void verify_Site_User_For_Study_Is_Not_Displayed_In_CURRENT_STUDY_SITE_DELEGATES_Table(int arg1, int arg2) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" For Study "+arg2+" Is Not Displayed In CURRENT STUDY SITE DELEGATES Table");
			
			new AdminPage(driver).verify_Site_User_For_Study_Is_Not_Displayed_In_CURRENT_STUDY_SITE_DELEGATES_Table(arg1,arg2);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Site User "+arg1+" For Study "+arg2+" Is Not Displayed In CURRENT STUDY SITE DELEGATES Table");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click Edit Under Site User (\\d+) For Study (\\d+) Is Displayed In CURRENT STUDY SITE DELEGATES Table$")
	public void click_Edit_Under_Site_User_For_Study_Is_Displayed_In_CURRENT_STUDY_SITE_DELEGATES_Table(int arg1, int arg2) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click Edit Under Site User "+arg1+" For Study "+arg2+" Is Displayed In CURRENT STUDY SITE DELEGATES Table");
			
			new AdminPage(driver).click_Edit_Under_Site_User_For_Study_Is_Displayed_In_CURRENT_STUDY_SITE_DELEGATES_Table(arg1,arg2);
			Thread.sleep(1000);
			
			logInfo.pass("Click Edit Under Site User "+arg1+" For Study "+arg2+" Is Displayed In CURRENT STUDY SITE DELEGATES Table");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify And Click On DatePicker of End Date In CURRENT STUDY SITE DELEGATES Table For Site User (\\d+) For Study (\\d+)$")
	public void verify_And_Click_On_DatePicker_of_End_Date_In_CURRENT_STUDY_SITE_DELEGATES_Table_For_Site_User_For_Study(int arg1, int arg2) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify And Click On DatePicker of End Date In CURRENT STUDY SITE DELEGATES Table For Site User "+arg1+" For Study "+arg2);
			
			new AdminPage(driver).verify_And_Click_On_DatePicker_of_End_Date_In_CURRENT_STUDY_SITE_DELEGATES_Table_For_Site_User_For_Study(arg1,arg2);
			Thread.sleep(1000);
			
			logInfo.pass("Verify And Click On DatePicker of End Date In CURRENT STUDY SITE DELEGATES Table For Site User "+arg1+" For Study "+arg2);
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Select Current Date In End Date In CURRENT STUDY SITE DELEGATES Table For Site User (\\d+) For Study (\\d+)$")
	public void select_Currect_Date_End_Date_In_CURRENT_STUDY_SITE_DELEGATES_Table_For_Site_User_For_Study(int arg1, int arg2) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select Current Date In End Date In CURRENT STUDY SITE DELEGATES Table For Site User "+arg1+" For Study "+arg2);
			
			new AdminPage(driver).select_Current_Date_End_Date_In_CURRENT_STUDY_SITE_DELEGATES_Table_For_Site_User_For_Study();
			Thread.sleep(4000);
			
			logInfo.pass("Select Current Date In End Date In CURRENT STUDY SITE DELEGATES Table For Site User "+arg1+" For Study "+arg2);
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Select Future Date In End Date In CURRENT STUDY SITE DELEGATES Table For Site User (\\d+) For Study (\\d+)$")
	public void select_Future_Date_In_End_Date_In_CURRENT_STUDY_SITE_DELEGATES_Table_For_Site_User_For_Study(int arg1, int arg2) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select Future Date In End Date In CURRENT STUDY SITE DELEGATES Table For Site User "+arg1+" For Study "+arg2);
			
			new AdminPage(driver).select_Future_Date_In_End_Date_In_CURRENT_STUDY_SITE_DELEGATES_Table_For_Site_User_For_Study();
			Thread.sleep(4000);
			
			logInfo.pass("Select Future Date In End Date In CURRENT STUDY SITE DELEGATES Table For Site User "+arg1+" For Study "+arg2);
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click Save For Site User (\\d+) For Study (\\d+) Is Displayed In CURRENT STUDY SITE DELEGATES Table$")
	public void click_Save_For_Site_User_For_Study_Is_Displayed_In_CURRENT_STUDY_SITE_DELEGATES_Table(int arg1, int arg2) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click Save For Site User "+arg1+" For Study "+arg2+" Is Displayed In CURRENT STUDY SITE DELEGATES Table");
			
			new AdminPage(driver).click_Save_For_Site_User_For_Study_Is_Displayed_In_CURRENT_STUDY_SITE_DELEGATES_Table(arg1,arg2);
			Thread.sleep(7000);
			
			logInfo.pass("Click Save For Site User "+arg1+" For Study "+arg2+" Is Displayed In CURRENT STUDY SITE DELEGATES Table");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify End Study Site Delegation PopUp$")
	public void verify_End_Study_Site_Delegation_PopUp() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify End Study Site Delegation PopUp");
			
			new AdminPage(driver).verify_End_Study_Site_Delegation_PopUp();
			Thread.sleep(1000);
			
			logInfo.pass("Verify End Study Site Delegation PopUp");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On END THIS STUDY SITE DELEGATION Button In End Study Site Delegation PopUp$")
	public void click_On_END_THIS_STUDY_SITE_DELEGATION_Button_In_End_Study_Site_Delegation_PopUp() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On END THIS STUDY SITE DELEGATION Button In End Study Site Delegation PopUp");
			
			new AdminPage(driver).click_On_END_THIS_STUDY_SITE_DELEGATION_Button_In_End_Study_Site_Delegation_PopUp();
			Thread.sleep(10000);
			
			logInfo.pass("Click On END THIS STUDY SITE DELEGATION Button In End Study Site Delegation PopUp");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	
	@Then("^Verify Site User (\\d+) For Study (\\d+) Has Start Date As Future Date In CURRENT STUDY SITE DELEGATES Table$")
	public void verify_Site_User_For_Study_Has_Start_Date_As_Future_Date_In_CURRENT_STUDY_SITE_DELEGATES_Table(int arg1, int arg2) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" For Study "+arg2+" Has Start Date As Future Date In CURRENT STUDY SITE DELEGATES Table");
			
			new AdminPage(driver).verify_Site_User_For_Study_Has_Start_Date_As_Future_Date_In_CURRENT_STUDY_SITE_DELEGATES_Table(arg1,arg2);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Site User "+arg1+" For Study "+arg2+" Has Start Date As Future Date In CURRENT STUDY SITE DELEGATES Table");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Site User (\\d+) For Study (\\d+) Has End Date As Future Date In CURRENT STUDY SITE DELEGATES Table$")
	public void verify_Site_User_For_Study_Has_End_Date_As_Future_Date_In_CURRENT_STUDY_SITE_DELEGATES_Table(int arg1, int arg2) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" For Study "+arg2+" Has End Date As Future Date In CURRENT STUDY SITE DELEGATES Table");
			
			new AdminPage(driver).verify_Site_User_For_Study_Has_End_Date_As_Future_Date_In_CURRENT_STUDY_SITE_DELEGATES_Table(arg1,arg2);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Site User "+arg1+" For Study "+arg2+" Has End Date As Future Date In CURRENT STUDY SITE DELEGATES Table");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Site User (\\d+) For Study (\\d+) Has Start Date As Current Date In CURRENT STUDY SITE DELEGATES Table$")
	public void verify_Site_User_For_Study_Has_Start_Date_As_Current_Date_In_CURRENT_STUDY_SITE_DELEGATES_Table(int arg1, int arg2) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" For Study "+arg2+" Has Start Date As Current Date In CURRENT STUDY SITE DELEGATES Table");
			
			new AdminPage(driver).verify_Site_User_For_Study_Has_Start_Date_As_Current_Date_In_CURRENT_STUDY_SITE_DELEGATES_Table(arg1,arg2);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Site User "+arg1+" For Study "+arg2+" Has Start Date As Current Date In CURRENT STUDY SITE DELEGATES Table");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	
	@Then("^Verify Site User (\\d+) For Study (\\d+) Has End Date As Blank In CURRENT STUDY SITE DELEGATES Table$")
	public void verify_Site_User_For_Study_Has_End_Date_As_Blank_In_CURRENT_STUDY_SITE_DELEGATES_Table(int arg1, int arg2) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" For Study "+arg2+" Has End Date As Blank In CURRENT STUDY SITE DELEGATES Table");
			
			new AdminPage(driver).verify_Site_User_For_Study_Has_End_Date_As_Blank_In_CURRENT_STUDY_SITE_DELEGATES_Table(arg1,arg2);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Site User "+arg1+" For Study "+arg2+" Has End Date As Blank In CURRENT STUDY SITE DELEGATES Table");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Site User (\\d+) For Study (\\d+) Has Start Date As Past Date In CURRENT STUDY SITE DELEGATES Table$")
	public void verify_Site_User_For_Study_Has_Start_Date_As_Past_Date_In_CURRENT_STUDY_SITE_DELEGATES_Table(int arg1, int arg2) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" For Study "+arg2+" Has Start Date As Past Date In CURRENT STUDY SITE DELEGATES Table");
			
			new AdminPage(driver).verify_Site_User_For_Study_Has_Start_Date_As_Past_Date_In_CURRENT_STUDY_SITE_DELEGATES_Table(arg1,arg2);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Site User "+arg1+" For Study "+arg2+" Has Start Date As Past Date In CURRENT STUDY SITE DELEGATES Table");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Site User (\\d+) With Facility (\\d+) and Department (\\d+) Not Displayed Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen$")
	public void verify_Site_User_With_Facility_and_Department_Not_Displayed_Under_STUDY_SITE_MAINTENANCE_DELEGATES_In_Delegate_Study_Sites_Screen(int arg1, int arg2, int arg3) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" With Facility "+arg2+" and Department "+arg3+" Not Displayed Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen");
			
			new AdminPage(driver).verify_Site_User_With_Facility_and_Department_Not_Displayed_Under_STUDY_SITE_MAINTENANCE_DELEGATES_In_Delegate_Study_Sites_Screen(arg1,arg2,arg3);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Site User "+arg1+" With Facility "+arg2+" and Department "+arg3+" Not Displayed Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Site User (\\d+) With Facility (\\d+) and Department (\\d+) Displayed Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen$")
	public void verify_Site_User_With_Facility_and_Department_Displayed_Under_STUDY_SITE_MAINTENANCE_DELEGATES_In_Delegate_Study_Sites_Screen(int arg1, int arg2, int arg3) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" With Facility "+arg2+" and Department "+arg3+" Displayed Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen");
			
			new AdminPage(driver).verify_Site_User_With_Facility_and_Department_Displayed_Under_STUDY_SITE_MAINTENANCE_DELEGATES_In_Delegate_Study_Sites_Screen(arg1,arg2,arg3);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Site User "+arg1+" With Facility "+arg2+" and Department "+arg3+" Displayed Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}

	
	@Then("^Click On Add Delegate Button Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen$")
	public void click_On_Add_Delegate_Button_Under_STUDY_SITE_MAINTENANCE_DELEGATES_In_Delegate_Study_Sites_Screen() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Add Delegate Button Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen");
			
			new AdminPage(driver).click_On_Add_Delegate_Button_Under_STUDY_SITE_MAINTENANCE_DELEGATES_In_Delegate_Study_Sites_Screen();
			Thread.sleep(10000);
			
			logInfo.pass("Click On Add Delegate Button Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Facility (\\d+) In Add Facilities/Departments for PopUp Not Displayed$")
	public void verify_Facility_In_Add_Facilities_Departments_for_PopUp_Not_Displayed(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility "+arg1+" In Add Facilities/Departments for PopUp Not Displayed");
			
			new AdminPage(driver).verify_Facility_In_Add_Facilities_Departments_for_PopUp_Not_Displayed(arg1);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Facility "+arg1+" In Add Facilities/Departments for PopUp Not Displayed");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On SEARCH Button In By Facility/Department Section$")
	public void click_On_SEARCH_Button_In_By_Facility_Department_Section() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On SEARCH Button In By Facility/Department Section");
			
			new AdminPage(driver).SiteUserSearchBtn.click();
			Thread.sleep(10000);
			
			logInfo.pass("Click On SEARCH Button In By Facility/Department Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Site User (\\d+) Displayed Under Search Study Site Maintenance Delegate Table$")
	public void verify_Site_User_Displayed_Under_Search_Study_Site_Maintenance_Delegate_Table(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" Displayed Under Search Study Site Maintenance Delegate Table");
			
			new AdminPage(driver).verify_Site_User_Displayed_Under_Search_Study_Site_Maintenance_Delegate_Table(arg1);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Site User "+arg1+" Displayed Under Search Study Site Maintenance Delegate Table");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Select Site User (\\d+) Displayed Under Search Study Site Maintenance Delegate Table$")
	public void select_Site_User_Displayed_Under_Search_Study_Site_Maintenance_Delegate_Table(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select Site User "+arg1+" Displayed Under Search Study Site Maintenance Delegate Table");
			
			new AdminPage(driver).select_Site_User_Displayed_Under_Search_Study_Site_Maintenance_Delegate_Table(arg1);
			Thread.sleep(3000);
			
			logInfo.pass("Select Site User "+arg1+" Displayed Under Search Study Site Maintenance Delegate Table");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Study Site Profile Maintenance Tab Not Displayed$")
	public void verify_Study_Site_Profile_Maintenance_Tab_Not_Displayed() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Study Site Profile Maintenance Tab Not Displayed");
			
			new AdminPage(driver).verify_Study_Site_Profile_Maintenance_Tab_Not_Displayed();
			Thread.sleep(1000);
			
			logInfo.pass("Verify Study Site Profile Maintenance Tab Not Displayed");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Safety Contact & Regulatory Contact \\(PI Delegate\\) Not Displayed$")
	public void verify_Safety_Contact_Regulatory_Contact_PI_Delegate_Not_Displayed() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Safety Contact & Regulatory Contact \\(PI Delegate\\) Not Displayed");
			
			new AdminPage(driver).verify_Safety_Contact_Regulatory_Contact_PI_Delegate_Not_Displayed();
			Thread.sleep(1000);
			
			logInfo.pass("Verify Safety Contact & Regulatory Contact \\(PI Delegate\\) Not Displayed");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Set Site User (\\d+) First Name In First Name TextBox In By Facility/Department Section$")
	public void set_Site_User_First_Name_In_First_Name_TextBox_In_By_Facility_Department_Section(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Set Site User "+arg1+" First Name In First Name TextBox In By Facility/Department Section");
			
			new AdminPage(driver).set_Site_User_First_Name_In_First_Name_TextBox_In_By_Facility_Department_Section(arg1);
			Thread.sleep(2000);
			
			logInfo.pass("Set Site User "+arg1+" First Name In First Name TextBox In By Facility/Department Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Set Site User (\\d+) Last Name In Last Name TextBox In By Facility/Department Section$")
	public void set_Site_User_Last_Name_In_Last_Name_TextBox_In_By_Facility_Department_Section(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Set Site User "+arg1+" Last Name In Last Name TextBox In By Facility/Department Section");
			
			new AdminPage(driver).set_Site_User_Last_Name_In_Last_Name_TextBox_In_By_Facility_Department_Section(arg1);
			Thread.sleep(2000);
			
			logInfo.pass("Set Site User "+arg1+" Last Name In Last Name TextBox In By Facility/Department Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On Search Study Site Maintenance Delegate Section Expand Button$")
	public void click_On_Search_Study_Site_Maintenance_Delegate_Section_Expand_Button() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Search Study Site Maintenance Delegate Section Expand Button");
			
			new AdminPage(driver).SearchStudySiteMaintenanceDelegate_ExpandBtn.click();
			Thread.sleep(5000);
			
			logInfo.pass("Click On Search Study Site Maintenance Delegate Section Expand Button");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On CLEAR SEARCH Button In By Facility/Department Section$")
	public void click_On_CLEAR_SEARCH_Button_In_By_Facility_Department_Section() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On CLEAR SEARCH Button In By Facility/Department Section");
			
			new AdminPage(driver).SearchStudySiteMaintenanceDelegate_ClearSearchBtn.click();
			Thread.sleep(5000);
			
			logInfo.pass("Click On CLEAR SEARCH Button In By Facility/Department Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On SELECT STUDY DELEGATE Button$")
	public void click_On_SELECT_STUDY_DELEGATE_Button() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On SELECT STUDY DELEGATE Button");
			
			new AdminPage(driver).SELECTSTUDYDELEGATEBtn.click();
			Thread.sleep(5000);
			
			logInfo.pass("Click On SELECT STUDY DELEGATE Button");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On SAVE button In Add Facilities/Departments for PopUp$")
	public void click_On_SAVE_button_In_Add_Facilities_Departments_for_PopUp() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On SAVE button In Add Facilities/Departments for PopUp");
			
			new AdminPage(driver).AssignFacDeptDelegateSave.click();
			Thread.sleep(15000);
			
			logInfo.pass("Click On SAVE button In Add Facilities/Departments for PopUp");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Select Facility (\\d+) In Add Facilities/Departments for PopUp$")
	public void select_Facility_In_Add_Facilities_Departments_for_PopUp(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select Facility "+arg1+" In Add Facilities/Departments for PopUp");
			
			new AdminPage(driver).select_Facility_In_Add_Facilities_Departments_for_PopUp(arg1);
			Thread.sleep(5000);
			
			logInfo.pass("Select Facility "+arg1+" In Add Facilities/Departments for PopUp");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Facility (\\d+) In Add Facilities/Departments for PopUp$")
	public void verify_Facility_In_Add_Facilities_Departments_for_PopUp(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility "+arg1+" In Add Facilities/Departments for PopUp");
			
			new AdminPage(driver).verify_Facility_In_Add_Facilities_Departments_for_PopUp(arg1);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Facility "+arg1+" In Add Facilities/Departments for PopUp");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On Facility Dropdown Under Search Study Site Maintenance Delegate Section For Manage Delegation on behalf of Screen$")
	public void click_On_Facility_Dropdown_Under_Search_Study_Site_Maintenance_Delegate_Section_For_Manage_Delegation_on_behalf_of_Screen() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Facility Dropdown Under Search Study Site Maintenance Delegate Section For Manage Delegation on behalf of Screen");
			
			new AdminPage(driver).click_On_Facility_Dropdown_Under_Search_Study_Site_Maintenance_Delegate_Section_For_Manage_Delegation_on_behalf_of_Screen();
			Thread.sleep(5000);
			
			logInfo.pass("Click On Facility Dropdown Under Search Study Site Maintenance Delegate Section For Manage Delegation on behalf of Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Facility (\\d+) Displayed Under Facility Dropdown Under Search Study Site Maintenance Delegate Section$")
	public void verify_Facility_Displayed_Under_Facility_Dropdown_Under_Search_Study_Site_Maintenance_Delegate_Section(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility "+arg1+" Displayed Under Facility Dropdown Under Search Study Site Maintenance Delegate Section");
			
			new AdminPage(driver).verify_Facility_Displayed_Under_Facility_Dropdown_Under_Search_Study_Site_Maintenance_Delegate_Section(arg1);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Facility "+arg1+" Displayed Under Facility Dropdown Under Search Study Site Maintenance Delegate Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Facility (\\d+) Not Displayed Under Facility Dropdown Under Search Study Site Maintenance Delegate Section$")
	public void verify_Facility_Not_Displayed_Under_Facility_Dropdown_Under_Search_Study_Site_Maintenance_Delegate_Section(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility "+arg1+" Not Displayed Under Facility Dropdown Under Search Study Site Maintenance Delegate Section");
			
			new AdminPage(driver).verify_Facility_Not_Displayed_Under_Facility_Dropdown_Under_Search_Study_Site_Maintenance_Delegate_Section(arg1);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Facility "+arg1+" Not Displayed Under Facility Dropdown Under Search Study Site Maintenance Delegate Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Close Facility Dropdown Under Search Study Site Maintenance Delegate Section$")
	public void close_Facility_Dropdown_Under_Search_Study_Site_Maintenance_Delegate_Section() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Close Facility Dropdown Under Search Study Site Maintenance Delegate Section");
			
			new AdminPage(driver).close_Facility_Dropdown_Under_Search_Study_Site_Maintenance_Delegate_Section();
			Thread.sleep(5000);
			
			logInfo.pass("Close Facility Dropdown Under Search Study Site Maintenance Delegate Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Select Facility (\\d+) Displayed Under Facility Dropdown Under Search Study Site Maintenance Delegate Section$")
	public void select_Facility_Displayed_Under_Facility_Dropdown_Under_Search_Study_Site_Maintenance_Delegate_Section(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select Facility "+arg1+" Displayed Under Facility Dropdown Under Search Study Site Maintenance Delegate Section");
			
			new AdminPage(driver).select_Facility_Displayed_Under_Facility_Dropdown_Under_Search_Study_Site_Maintenance_Delegate_Section(arg1);
			Thread.sleep(5000);
			
			logInfo.pass("Select Facility "+arg1+" Displayed Under Facility Dropdown Under Search Study Site Maintenance Delegate Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On Department Dropdown Under Search Study Site Maintenance Delegate Section For Manage Delegation on behalf of Screen$")
	public void click_On_Department_Dropdown_Under_Search_Study_Site_Maintenance_Delegate_Section_For_Manage_Delegation_on_behalf_of_Screen() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Department Dropdown Under Search Study Site Maintenance Delegate Section For Manage Delegation on behalf of Screen");
			
			new AdminPage(driver).click_On_Department_Dropdown_Under_Search_Study_Site_Maintenance_Delegate_Section_For_Manage_Delegation_on_behalf_of_Screen();
			Thread.sleep(5000);
			
			logInfo.pass("Click On Department Dropdown Under Search Study Site Maintenance Delegate Section For Manage Delegation on behalf of Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Facility (\\d+) Department (\\d+) Not Displayed Under Facility Dropdown Under Search Study Site Maintenance Delegate Section$")
	public void verify_Facility_Department_Not_Displayed_Under_Facility_Dropdown_Under_Search_Study_Site_Maintenance_Delegate_Section(int arg1, int arg2) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility "+arg1+" Department "+arg2+" Not Displayed Under Facility Dropdown Under Search Study Site Maintenance Delegate Section");
			
			new AdminPage(driver).verify_Facility_Department_Not_Displayed_Under_Facility_Dropdown_Under_Search_Study_Site_Maintenance_Delegate_Section(arg1,arg2);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Facility "+arg1+" Department "+arg2+" Not Displayed Under Facility Dropdown Under Search Study Site Maintenance Delegate Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On SEARCH Button Under Search Study Site Maintenance Delegate Section$")
	public void click_On_SEARCH_Button_Under_Search_Study_Site_Maintenance_Delegate_Section() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On SEARCH Button Under Search Study Site Maintenance Delegate Section");
			
			new AdminPage(driver).click_On_SEARCH_Button_Under_Search_Study_Site_Maintenance_Delegate_Section();
			Thread.sleep(5000);
			
			logInfo.pass("Click On SEARCH Button Under Search Study Site Maintenance Delegate Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Site User (\\d+) Is Displayed In Search Study Site Maintenance Delegate Table$")
	public void verify_Site_User_Is_Displayed_In_Search_Study_Site_Maintenance_Delegate_Table(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" Is Displayed In Search Study Site Maintenance Delegate Table");
			
			new AdminPage(driver).verify_Site_User_Is_Displayed_In_Search_Study_Site_Maintenance_Delegate_Table(arg1);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Site User "+arg1+" Is Displayed In Search Study Site Maintenance Delegate Table");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Site User (\\d+) Is Not Displayed In Search Study Site Maintenance Delegate Table$")
	public void verify_Site_User_Is_Not_Displayed_In_Search_Study_Site_Maintenance_Delegate_Table(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" Is Not Displayed In Search Study Site Maintenance Delegate Table");
			
			new AdminPage(driver).verify_Site_User_Is_Not_Displayed_In_Search_Study_Site_Maintenance_Delegate_Table(arg1);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Site User "+arg1+" Is Not Displayed In Search Study Site Maintenance Delegate Table");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}

	
	@Then("^Select (\\d+) From Show Rows In Search Study Site Maintenance Delegate Table$")
	public void select_From_Show_Rows_In_Search_Study_Site_Maintenance_Delegate_Table(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select "+arg1+" From Show Rows In Search Study Site Maintenance Delegate Table");
			
			new AdminPage(driver).select_From_Show_Rows_In_Search_Study_Site_Maintenance_Delegate_Table(arg1);
			Thread.sleep(1000);
			
			logInfo.pass("Select "+arg1+" From Show Rows In Search Study Site Maintenance Delegate Table");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Select Site User (\\d+) Is Displayed In Search Study Site Maintenance Delegate Table$")
	public void select_Site_User_Is_Displayed_In_Search_Study_Site_Maintenance_Delegate_Table(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select Site User "+arg1+" Is Displayed In Search Study Site Maintenance Delegate Table");
			
			new AdminPage(driver).select_Site_User_Is_Displayed_In_Search_Study_Site_Maintenance_Delegate_Table(arg1);
			Thread.sleep(5000);
			
			logInfo.pass("Select Site User "+arg1+" Is Displayed In Search Study Site Maintenance Delegate Table");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On SELECT STUDY DELEGATE Button In Manage Delegation on behalf of Screen$")
	public void click_On_SELECT_STUDY_DELEGATE_Button_In_Manage_Delegation_on_behalf_of_Screen() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On SELECT STUDY DELEGATE Button In Manage Delegation on behalf of Screen");
			
			new AdminPage(driver).click_On_SELECT_STUDY_DELEGATE_Button_In_Manage_Delegation_on_behalf_of_Screen();
			Thread.sleep(15000);
			
			logInfo.pass("Click On SELECT STUDY DELEGATE Button In Manage Delegation on behalf of Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Facility (\\d+) Is displayed In Add Facilities/Departments for Site User PopUp Displayed$")
	public void verify_Facility_Is_displayed_In_Add_Facilities_Departments_for_Site_User_PopUp_Displayed(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility "+arg1+" Is displayed In Add Facilities/Departments for Site User PopUp Displayed");
			
			new AdminPage(driver).verify_Facility_Is_displayed_In_Add_Facilities_Departments_for_Site_User_PopUp_Displayed(arg1);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Facility "+arg1+" Is displayed In Add Facilities/Departments for Site User PopUp Displayed");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Facility (\\d+) Not displayed In Add Facilities/Departments for Site User PopUp Displayed$")
	public void verify_Facility_Not_displayed_In_Add_Facilities_Departments_for_Site_User_PopUp_Displayed(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility "+arg1+" Not displayed In Add Facilities/Departments for Site User PopUp Displayed");
			
			new AdminPage(driver).verify_Facility_Not_displayed_In_Add_Facilities_Departments_for_Site_User_PopUp_Displayed(arg1);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Facility "+arg1+" Not displayed In Add Facilities/Departments for Site User PopUp Displayed");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Select Facility (\\d+) In Add Facilities/Departments for Site User PopUp Displayed$")
	public void select_Facility_In_Add_Facilities_Departments_for_Site_User_PopUp_Displayed(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select Facility "+arg1+" In Add Facilities/Departments for Site User PopUp Displayed");
			
			new AdminPage(driver).select_Facility_In_Add_Facilities_Departments_for_Site_User_PopUp_Displayed(arg1);
			Thread.sleep(4000);
			
			logInfo.pass("Select Facility "+arg1+" In Add Facilities/Departments for Site User PopUp Displayed");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On SAVE button In Add Facilities/Departments for Site User PopUp$")
	public void click_On_SAVE_button_In_Add_Facilities_Departments_for_Site_User_PopUp() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On SAVE button In Add Facilities/Departments for Site User PopUp");
			
			new AdminPage(driver).click_On_SAVE_button_In_Add_Facilities_Departments_for_Site_User_PopUp();
			Thread.sleep(15000);
			
			logInfo.pass("Click On SAVE button In Add Facilities/Departments for Site User PopUp");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Add Facilities/Departments for Site User (\\d+) PopUp Displayed$")
	public void verify_Add_Facilities_Departments_for_Site_User_PopUp_Displayed(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Add Facilities/Departments for Site User "+arg1+" PopUp Displayed");
			
			new AdminPage(driver).verify_Add_Facilities_Departments_for_Site_User_PopUp_Displayed(arg1);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Add Facilities/Departments for Site User "+arg1+" PopUp Displayed");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Close Department Dropdown Under Search Study Site Maintenance Delegate Section$")
	public void close_Department_Dropdown_Under_Search_Study_Site_Maintenance_Delegate_Section() throws Throwable {
		ExtentTest logInfo = null;
		try {
			logInfo = test.createNode(new GherkinKeyword("Then"),"Close Department Dropdown Under Search Study Site Maintenance Delegate Section");
			
			Robot r1 = new Robot();
			r1.keyPress(KeyEvent.VK_ESCAPE);
			r1.keyRelease(KeyEvent.VK_ESCAPE);
			
			logInfo.pass("Close Department Dropdown Under Search Study Site Maintenance Delegate Section");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On View/Manage Delegation For Site User (\\d+)$")
	public void click_On_View_Manage_Delegation_For_Site_User(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On View/Manage Delegation For Site User "+arg1);
			
			new AdminPage(driver).click_ViewManageDelegation_Against_site_User(arg1);
			Thread.sleep(15000);
			
			logInfo.pass("Click On View/Manage Delegation For Site User "+arg1);
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
		
	    
	}
	
	@Then("^Click On Add Delegate Button In User Profile Section$")
	public void click_On_View_Manage_Delegation_For_Site_User() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Add Delegate Button In User Profile Section");
			
			new AdminPage(driver).ClickOnAddDelegateButtonInUserProfileSection();
			Thread.sleep(5000);
			
			logInfo.pass("Click On Add Delegate Button In User Profile Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
		
	    
	}
	
	@Then("^Verify SAFETY CONTACT AND REGULATORY CONTACT \\(PI DELEGATE\\) Table Columns$")
	public void verify_SAFETY_CONTACT_AND_REGULATORY_CONTACT_PI_DELEGATE_Table_Columns() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify SAFETY CONTACT AND REGULATORY CONTACT \\(PI DELEGATE\\) Table Columns");
			
			new AdminPage(driver).verify_SAFETY_CONTACT_AND_REGULATORY_CONTACT_PI_DELEGATE_Table_Columns();
			Thread.sleep(1000);
			
			logInfo.pass("Verify SAFETY CONTACT AND REGULATORY CONTACT \\(PI DELEGATE\\) Table Columns");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
		
	    
	}
	
	@Then("^Click On Organization Radio Button In Delegate User Profile Screen$")
	public void click_On_Orgainzation_Radio_btn() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Organization Radio Button In Delegate User Profile Screen");
			
			new AdminPage(driver).click_On_Orgainzation_Radio_btn();
			Thread.sleep(3000);
			
			logInfo.pass("Click On Organization Radio Button In Delegate User Profile Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
		
	    
	}
	@Then("^Click On Remove For Site User (\\d+) From Facility (\\d+) Associated with Department (\\d+) Displayed as \"([^\"]*)\"$")
	public void click_On_Remove_For_Site_User_From_Facility_Associated_with_Department_Displayed_as(int arg1, int arg2, int arg3, String arg4) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Remove For Site User "+arg1+" From Facility "+arg2+" Associated with Department "+arg3+" Displayed as "+arg4);
			
			new AdminPage(driver).click_On_Remove_For_Site_User_From_Facility_Associated_with_Department_Displayed_as(arg1,arg2,arg3,arg4);
			Thread.sleep(3000);
			
			logInfo.pass("Click On Remove For Site User "+arg1+" From Facility "+arg2+" Associated with Department "+arg3+" Displayed as "+arg4);
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On YES Remove Delegate PopUp$")
	public void click_On_YES_Remove_Delegate_PopUp() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On YES Remove Delegate PopUp");
			
			new AdminPage(driver).ModalRemoveDelegateConfirmation_Yes.click();
			Thread.sleep(3000);
			
			logInfo.pass("Click On YES Remove Delegate PopUp");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Add Delegate Button In User Profile Section$")
	public void VerifyAddDelegateButtonInUserProfileSection() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Add Delegate Button In User Profile Section");
			
			new AdminPage(driver).VerifyAddDelegateButtonInUserProfileSection();
			Thread.sleep(1000);
			
			logInfo.pass("Add Delegate Button In User Profile Section Is Displayed");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
		
	    
	}
	
	@Then("^Verify Site User (\\d+) From Facility (\\d+) Associated with Department (\\d+) Not Displayed as \"([^\"]*)\"$")
	public void verify_Site_User_From_Facility_Associated_with_Department_Not_Displayed_as(int arg1, int arg2, int arg3, String arg4) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" From Facility "+arg2+" Associated with Department "+arg3+" Not Displayed as "+arg4);
			
			new AdminPage(driver).verify_Site_User_From_Facility_Associated_with_Department_Not_Displayed_as(arg1,arg2,arg3,arg4);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Site User "+arg1+" From Facility "+arg2+" Associated with Department "+arg3+" Not Displayed as "+arg4);
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
		
	    
	}
	
	@Then("^Enter Email ID In Enter Delegate E-mail Address of Site User (\\d+)$")
	public void enter_Email_ID_In_Enter_Delegate_E_mail_Address_of_Site_User(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Enter Email ID In Enter Delegate E-mail Address of Site User "+arg1);
			
			new AdminPage(driver).enter_Email_ID_In_Enter_Delegate_E_mail_Address_of_Site_User(arg1);
			Thread.sleep(2000);
			
			logInfo.pass("Enter Email ID In Enter Delegate E-mail Address of Site User "+arg1);
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
		
	    
	}
	
	@Then("^Click On Delegate Button In User Profile Section$")
	public void click_On_Delegate_Button_In_User_Profile_Section() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Delegate Button In User Profile Section");
			
			new AdminPage(driver).click_On_Delegate_Button_In_User_Profile_Section();
			Thread.sleep(10000);
			
			logInfo.pass("Click On Delegate Button In User Profile Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
		
	    
	}
	
	@Then("^Click On Ok Button In User Profile Delegation Complete PopUp$")
	public void ClickOnOkButtonInUserProfileDelegationCompletePopUp() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Ok Button In User Profile Delegation Complete PopUp");
			
			new AdminPage(driver).ClickOnOkButtonInUserProfileDelegationCompletePopUp();
			Thread.sleep(3000);
			
			logInfo.pass("Click On Ok Button In User Profile Delegation Complete PopUp");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Site User (\\d+) Displayed In User Profile Section$")
	public void verify_Site_User_Displayed_In_User_Profile_Section(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" Displayed In User Profile Section");
			
			new AdminPage(driver).verify_Site_User_Displayed_In_User_Profile_Section(arg1);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Site User "+arg1+" Displayed In User Profile Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Site User (\\d+) Is Not Displayed In User Profile Section$")
	public void verify_Site_User_Not_Displayed_In_User_Profile_Section(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" Is Not Displayed In User Profile Section");
			
			new AdminPage(driver).verify_Site_User_Not_Displayed_In_User_Profile_Section(arg1);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Site User "+arg1+" Is Not Displayed In User Profile Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Navigate To Admin > Manage Delegation$")
	public void navigateToManageDelegationSiteUsers() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Navigate To Admin > Manage Delegation");
			
			new SiteUser_LandingPage(driver).navigateToManageDelegationSiteUsers();
			Thread.sleep(10000);
			
			logInfo.pass("Navigate To Admin > Manage Delegation");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Navigate To Reports > General Reports$")
	public void navigate_To_Reports_General_Reports() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Navigate To Reports > General Reports");
			
			new SiteUser_LandingPage(driver).navigate_To_Reports_General_Reports();
			Thread.sleep(1000);
			
			logInfo.pass("Navigate To Reports > General Reports");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Navigate To User Profile > Delegated Profiles$")
	public void navigate_To_User_Profile_Delegated_Profiles() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Navigate To User Profile > Delegated Profiles");
			
			new SiteUser_LandingPage(driver).navigate_To_User_Profile_Delegated_Profiles();
			Thread.sleep(10000);
			
			logInfo.pass("Navigate To User Profile > Delegated Profiles");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Navigate To User Profile > Approve/Reject Update$")
	public void navigate_To_User_Profile_Approve_Reject_Update() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Navigate To User Profile > Approve/Reject Update");
			
			new SiteUser_LandingPage(driver).navigate_To_User_Profile_Approve_Reject_Update();
			Thread.sleep(10000);
			
			logInfo.pass("Navigate To User Profile > Approve/Reject Update");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On SIP User ID Of Site User (\\d+) In Delegated Profiles Screen$")
	public void click_On_SIP_User_ID_Of_Site_User_In_Delegated_Profiles_Screen(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On SIP User ID Of Site User "+arg1+" In Delegated Profiles Screen");
			
			new SiteUser_UserProfile(driver).click_On_SIP_User_ID_Of_Site_User_In_Delegated_Profiles_Screen(arg1);
			Thread.sleep(10000);
			
			logInfo.pass("Click On SIP User ID Of Site User "+arg1+" In Delegated Profiles Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Site User (\\d+) Displayed In User Profile Section For Site User$")
	public void verify_Site_User_Displayed_In_User_Profile_Section_For_Site_User(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Navigate To Admin > Manage Delegation");
			
			new AdminPage(driver).verify_Site_User_Displayed_In_User_Profile_Section_For_Site_User(arg1);
			Thread.sleep(10000);
			
			logInfo.pass("Navigate To Admin > Manage Delegation");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On UnDelegate Button In User Profile Section$")
	public void click_On_UnDelegate_Button_In_User_Profile_Section() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On UnDelegate Button In User Profile Section");
			
			new AdminPage(driver).click_On_UnDelegate_Button_In_User_Profile_Section();
			Thread.sleep(10000);
			
			logInfo.pass("Click On UnDelegate Button In User Profile Section");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On Remove Delegate In Remove User Profile Delegate PopUp$")
	public void click_Remove_Delegate_UnDelegate_Button_In_User_Profile_Section() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Remove Delegate In Remove User Profile Delegate PopUp");
			
			new AdminPage(driver).click_Remove_Delegate_UnDelegate_Button_In_User_Profile_Section();
			Thread.sleep(7000);
			
			logInfo.pass("Click On Remove Delegate In Remove User Profile Delegate PopUp");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On OK Button In User Profile Delegate Removed PopUp$")
	public void click_On_OK_Button_In_User_Profile_Delegate_Removed_PopUp() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Click On OK Button In User Profile Delegate Removed PopUp");
			
			new AdminPage(driver).click_On_OK_Button_In_User_Profile_Delegate_Removed_PopUp();
			Thread.sleep(7000);
			
			logInfo.pass("Click On OK Button In User Profile Delegate Removed PopUp");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify No Delegate Message Is Displayed In STUDY SITE MAINTENANCE DELEGATES Table$")
	public void verify_No_Delegate_Message_Is_Displayed_In_STUDY_SITE_MAINTENANCE_DELEGATES_Table() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify No Delegate Message Is Displayed In STUDY SITE MAINTENANCE DELEGATES Table");
			
			CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id=\"centralDelegatesTable\"]//td[text()[normalize-space() = 'No Delegate']]")));
			Thread.sleep(1000);
			
			logInfo.pass("Verify No Delegate Message Is Displayed In STUDY SITE MAINTENANCE DELEGATES Table");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On Facility Name Dropdown In Search Study Site Maintenance Delegate Screen$")
	public void click_On_Facility_Name_Dropdown_In_Search_Study_Site_Maintenance_Delegate_Screen() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify No Delegate Message Is Displayed In STUDY SITE MAINTENANCE DELEGATES Table");
			
			new AdminPage(driver).byFDFacName.click();
			Thread.sleep(1500);
			
			logInfo.pass("Verify No Delegate Message Is Displayed In STUDY SITE MAINTENANCE DELEGATES Table");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Facility (\\d+) Is Displayed In Facility Name Dropdown In Search Study Site Maintenance Delegate Screen$")
	public void verify_Facility_Is_Displayed_In_Facility_Name_Dropdown_In_Search_Study_Site_Maintenance_Delegate_Screen(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility "+arg1+" Is Displayed In Facility Name Dropdown In Search Study Site Maintenance Delegate Screen");
			
			new AdminPage(driver).verify_Facility_Is_Displayed_In_Facility_Name_Dropdown_In_Search_Study_Site_Maintenance_Delegate_Screen(arg1);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Facility "+arg1+" Is Displayed In Facility Name Dropdown In Search Study Site Maintenance Delegate Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
		
	    
	}
	
	
	@Then("^Verify Manage Delegation on behalf of Site User (\\d+) Screen Displayed$")
	public void verify_Manage_Delegation_On_Behalf_Of_Screen_displayed(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Manage Delegation on behalf of Site User "+arg1+" Screen Displayed");
			
			new AdminPage(driver).verify_Manage_Delegation_On_Behalf_Of_Screen_displayed(arg1);
			Thread.sleep(1000);
			
			logInfo.pass("Verify Manage Delegation on behalf of Site User "+arg1+" Screen Displayed");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
		
	    
	}
	
	@Then("^Verify User Profile Section Displayed Under Manage Delegation on behalf of Site User Screen$")
	public void verify_User_Profile_Section_Displayed_Under_Manage_Delegation_on_behalf_of_Site_User_Screen() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify User Profile Section Displayed Under Manage Delegation on behalf of Site User Screen");
			
			new AdminPage(driver).verify_User_Profile_Section_Displayed_Under_Manage_Delegation_on_behalf_of_Site_User_Screen();
			Thread.sleep(1000);
			
			logInfo.pass("Verify User Profile Section Displayed Under Manage Delegation on behalf of Site User Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Survey Section Displayed Under Manage Delegation on behalf of Site User Screen$")
	public void verify_Survey_Section_Displayed_Under_Manage_Delegation_on_behalf_of_Site_User_Screen() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Survey Section Displayed Under Manage Delegation on behalf of Site User Screen");
			
			new AdminPage(driver).verify_Survey_Section_Displayed_Under_Manage_Delegation_on_behalf_of_Site_User_Screen();
			Thread.sleep(1000);
			
			logInfo.pass("Verify Survey Section Displayed Under Manage Delegation on behalf of Site User Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Study Site Profile Maintenance Section Displayed Under Manage Delegation on behalf of Site User Screen$")
	public void verify_Study_Site_Profile_Maintenance_Section_Displayed_Under_Manage_Delegation_on_behalf_of_Site_User_Screen() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Study Site Profile Maintenance Section Displayed Under Manage Delegation on behalf of Site User Screen");
			
			new AdminPage(driver).verify_Study_Site_Profile_Maintenance_Section_Displayed_Under_Manage_Delegation_on_behalf_of_Site_User_Screen();
			Thread.sleep(1000);
			
			logInfo.pass("Verify Study Site Profile Maintenance Section Displayed Under Manage Delegation on behalf of Site User Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Verify Safety Contact & Regulatory Contact \\(PI Delegate\\) Section Displayed Under Manage Delegation on behalf of Site User Screen$")
	public void verify_Safety_Contact_Regulatory_Contact_PI_Delegate_Section_Displayed_Under_Manage_Delegation_on_behalf_of_Site_User_Screen() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Safety Contact & Regulatory Contact \\(PI Delegate\\) Section Displayed Under Manage Delegation on behalf of Site User Screen");
			
			new AdminPage(driver).verify_Safety_Contact_Regulatory_Contact_PI_Delegate_Section_Displayed_Under_Manage_Delegation_on_behalf_of_Site_User_Screen();
			Thread.sleep(1000);
			
			logInfo.pass("Verify Safety Contact & Regulatory Contact \\(PI Delegate\\) Section Displayed Under Manage Delegation on behalf of Site User Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Click On Safety Contact & Regulatory Contact \\(PI Delegate\\) Under Manage Delegation on behalf of Site User Screen$")
	public void click_On_Safety_Contact_Regulatory_Contact_PI_Delegate_Under_Manage_Delegation_on_behalf_of_Site_User_Screen() throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Safety Contact & Regulatory Contact \\(PI Delegate\\) Section Displayed Under Manage Delegation on behalf of Site User Screen");
			
			new AdminPage(driver).click_On_Safety_Contact_Regulatory_Contact_PI_Delegate_Under_Manage_Delegation_on_behalf_of_Site_User_Screen();
			Thread.sleep(7000);
			
			logInfo.pass("Verify Safety Contact & Regulatory Contact \\(PI Delegate\\) Section Displayed Under Manage Delegation on behalf of Site User Screen");
		   logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^Check whether the given facility is present$")
	public void check_whether_the_given_facility_is_present() throws Throwable {
	    
	  
	}
	
		
	 @Then("^enter_to_the_application_with_proper_login$")
	 public void enter_to_the_application_with_proper_login() throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
		 
			ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"enter_to_the_application_with_proper_login");
				System.out.println("proper login");
				new SipApplicationLandingPage(driver).NavigateToHomePageProperLogin();
				Thread.sleep(20000);
				logInfo.pass("Enter to the application with proper login");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 
			
	 }
	 
	 @Then("^enter_to_the_application_with_bypaas_loginone$")
	 public void enter_to_the_application_with_bypaas_login() throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
		 
			ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"enter_to_the_application_with_bypaas_login");
				System.out.println("proper login");
				Properties properties;
			    PropertiesFileReader obj = new PropertiesFileReader();
			    properties= obj.getProperty();
			    TestDataHandler testData = new TestDataHandler();
				Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
	            testData.setTestDatainMap(TestDataInMap);
	            String user = TestDataInMap.get("BypassUserid");
				new SipApplicationLandingPage(driver).ByPasslogin(user);
				Thread.sleep(20000);
				logInfo.pass("Enter to the application with bypaas login");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 
			
	 }
	 
	 @Then("^enter_to_the_application_with_bypaas_logintwo$")
	 public void enter_to_the_application_with_bypaas_logintwo() throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
		 
			ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"enter_to_the_application_with_bypaas_login");
				System.out.println("proper login");
				Properties properties;
			    PropertiesFileReader obj = new PropertiesFileReader();
			    properties= obj.getProperty();
			    TestDataHandler testData = new TestDataHandler();
				Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
	            testData.setTestDatainMap(TestDataInMap);
	            String user = TestDataInMap.get("BypassUserid1");
				new SipApplicationLandingPage(driver).ByPasslogin(user);
				Thread.sleep(20000);
				logInfo.pass("Enter to the application with bypaas login");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 
			
	 }
	 
	 @Then("^enter_to_the_application_with_bypaas_loginthree$")
	 public void enter_to_the_application_with_bypaas_loginthree() throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
		 
			ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"enter_to_the_application_with_bypaas_login");
				System.out.println("proper login");
				Properties properties;
			    PropertiesFileReader obj = new PropertiesFileReader();
			    properties= obj.getProperty();
			    TestDataHandler testData = new TestDataHandler();
				Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
	            testData.setTestDatainMap(TestDataInMap);
	            String user = TestDataInMap.get("BypassUserid2");
				new SipApplicationLandingPage(driver).ByPasslogin(user);
				Thread.sleep(20000);
				logInfo.pass("Enter to the application with bypaas login");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 
			
	 }
	 @Then("^enter_to_the_application_with_bypaas_loginfour$")
	 public void enter_to_the_application_with_bypaas_loginfour() throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
		 
			ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"enter_to_the_application_with_bypaas_login");
				System.out.println("proper login");
				Properties properties;
			    PropertiesFileReader obj = new PropertiesFileReader();
			    properties= obj.getProperty();
			    TestDataHandler testData = new TestDataHandler();
				Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
	            testData.setTestDatainMap(TestDataInMap);
	            String user = TestDataInMap.get("BypassUserid3");
				new SipApplicationLandingPage(driver).ByPasslogin(user);
				Thread.sleep(20000);
				logInfo.pass("Enter to the application with bypaas login");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 
			
	 }

	 @Then("^Enter to the application with proper login1$")
	 public void enter_to_the_application_with_proper_login1() throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
		 
			ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Enter to the application with proper login1");
				System.out.println("proper login");
				new SipApplicationLandingPage(driver).NavigateToHomePageProperLogin1();
				Thread.sleep(20000);
				logInfo.pass("Enter to the application with proper login");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 
			
	 }


	 
	 @Then("^Navigate to Create Study Workspaces$")
	 public void navigate_to_Create_Study_Workspaces() throws Throwable {
					
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Navigate to Create Study Workspaces");
				
				new SipSponsorLandingPage(driver).navigatetocreateStudyWorkspace();
				Thread.sleep(20000);
				logInfo.pass("Navigate to Create Study Workspaces");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	 
	 @Then("^Enter_Application_With_Bypass_Login_Siteuser (\\d+)$")
	 public void enter_application_with_bypass_login_siteuser(int arg1) throws Throwable {
			
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Enter_Application_With_Bypass_Login_Siteuser "+arg1);
				
				new SipSponsorLandingPage(driver).Enter_to_the_application_with_newbypass_with_Id_and_pass_and_Company(arg1);
				Thread.sleep(20000);
				logInfo.pass("Siteuser "+arg1+" Bypass Login Successful");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	 
	 
	 @Then("^Site User Navigate To View All Workspaces$")
	 public void site_User_Navigate_To_View_All_Workspaces() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Site User Navigate To View All Workspaces");
				
				new SipSponsorLandingPage(driver).site_User_Navigate_To_View_All_Workspaces();
				Thread.sleep(15000);
				logInfo.pass("Site User Navigate To View All Workspaces");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	 
	 @Then("^Sponsor User Navigate To View All Workspaces$")
	 public void sponsor_User_Navigate_To_View_All_Workspaces() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Sponsor User Navigate To View All Workspaces");
				
				new SipSponsorLandingPage(driver).sponsor_User_Navigate_To_View_All_Workspaces();
				Thread.sleep(15000);
				logInfo.pass("Sponsor User Navigate To View All Workspaces");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	 
	 @Then("^Site User Navigate To Study (\\d+)$")
	 public void site_User_Navigate_To_Study(int arg1) throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Site User Navigate To Study");
				
				new SipSponsorLandingPage(driver).site_User_Navigate_To_Study(arg1);
				Thread.sleep(12000);
				logInfo.pass("Site User Navigate To Study");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	 
	 @Then("^Sponsor User Navigate To Study (\\d+)$")
	 public void sponsor_User_Navigate_To_Study(int arg1) throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Sponsor User Navigate To Study");
				
				new SipSponsorLandingPage(driver).sponsor_User_Navigate_To_Study(arg1);
				Thread.sleep(12000);
				logInfo.pass("Sponsor User Navigate To Study");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	 
	 @Then("^Verify Newly Created Study Link Displayed Under Study Links$")
	 public void verify_Newly_Created_Study_Link_Displayed_Under_Study_Links() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Newly Created Study Link Displayed Under Study Links");
				
				new AdminPage(driver).verify_Newly_Created_Study_Link_Displayed_Under_Study_Links();
				Thread.sleep(1000);
				logInfo.pass("Verify Newly Created Study Link Displayed Under Study Links");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	 
	 @Then("^Verify Newly Created Study Link Displayed Under Study News$")
	 public void verify_Newly_Created_Study_Link_Displayed_Under_Study_News() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Newly Created Study Link Displayed Under Study News");
				
				new AdminPage(driver).verify_Newly_Created_Study_Link_Displayed_Under_Study_Links();
				Thread.sleep(1000);
				logInfo.pass("Verify Newly Created Study Link Displayed Under Study News");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	 
	 @Then("^Verify Newly Created Study Link Not Displayed Under Study News$")
	 public void verify_Newly_Created_Study_Link_Not_Displayed_Under_Study_News() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Newly Created Study Link Not Displayed Under Study News");
				
				new AdminPage(driver).verify_Newly_Created_Study_Link_Not_Displayed_Under_Study_News();
				Thread.sleep(1000);
				logInfo.pass("Verify Newly Created Study Link Not Displayed Under Study News");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	 
	 @Then("^Click Expiration Date Range Manage News/Links/FAQ As Current Date$")
	 public void click_Expiration_Date_Range_Manage_News_Links_FAQ_As_Current_Date() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Click Expiration Date Range Manage News/Links/FAQ As Current Date");
				
				new AdminPage(driver).click_Expiration_Date_Range_Manage_News_Links_FAQ_As_Current_Date();
				Thread.sleep(5000);
				logInfo.pass("Click Expiration Date Range Manage News/Links/FAQ As Current Date");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	 
	 @Then("^Verify Newly Created Study Link Not Displayed Under Study Links$")
	 public void verify_Newly_Created_Study_Link_Not_Displayed_Under_Study_Links() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Newly Created Study Link Not Displayed Under Study Links");
				
				new AdminPage(driver).verify_Newly_Created_Study_Link_Not_Displayed_Under_Study_Links();
				Thread.sleep(1000);
				logInfo.pass("Verify Newly Created Study Link Not Displayed Under Study Links");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	 
	 
	 @Then("^Enter_Application_With_Bypass_Login_SponsorUser (\\d+)$")
	 public void enter_application_with_bypass_login_sponsoruser(int arg1) throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Enter_Application_With_Bypass_Login_SponsorUser "+arg1);
				
				new SipSponsorLandingPage(driver).Enter_to_the_application_Sponsor_bypass(arg1);
				Thread.sleep(15000);
				logInfo.pass("Sponsor User "+arg1+" Bypass Login Successful");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	 
	 @Then("^Verify Sponsor Logo Is Displayed$")
	 public void verify_Sponsor_Logo_Is_Displayed() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Sponsor Logo Is Displayed");
				
				new SipSponsorLandingPage(driver).verify_Sponsor_Logo_Is_Displayed();
				Thread.sleep(1000);
				logInfo.pass("Sponsor Logo Is Displayed");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	 
	 @Then("^Click On Facility/Department Option From SEARCH BY Dropdown$")
	 public void click_On_Facility_Department_Option_From_SEARCH_BY_Dropdown() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Facility/Department Option From SEARCH BY Dropdown");
				
				new SipSponsorLandingPage(driver).click_On_Facility_Department_Option_From_SEARCH_BY_Dropdown();
				Thread.sleep(6000);
				logInfo.pass("Facility/Department Option From SEARCH BY Dropdown Is Clicked");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	 
	 @Then("^Verify Facility/Department Search Screen Is Displayed$")
	 public void verify_Facility_Department_Search_Screen_Is_Displayed() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility/Department Search Screen Is Displayed");
				
				new SipSponsorLandingPage(driver).verify_Facility_Department_Search_Screen_Is_Displayed();
				Thread.sleep(1000);
				logInfo.pass("Facility/Department Search Screen Is Displayed");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	 
	 @Then("^Click On SEARCH BY Dropdown$")
	 public void click_On_SEARCH_BY_Dropdown() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Click On SEARCH BY Dropdown");
				
				new SipSponsorLandingPage(driver).click_On_SEARCH_BY_Dropdown();
				Thread.sleep(3000);
				logInfo.pass("Click On SEARCH BY Dropdown");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	 
	 @Then("^Click On PRINCIPAL INVESTIGATOR Option From SEARCH BY Dropdown$")
	 public void click_On_PRINCIPAL_INVESTIGATOR_Option_From_SEARCH_BY_Dropdown() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Click On PRINCIPAL INVESTIGATOR Option From SEARCH BY Dropdown");
				
				new SipSponsorLandingPage(driver).click_On_PRINCIPAL_INVESTIGATOR_Option_From_SEARCH_BY_Dropdown();
				Thread.sleep(3000);
				logInfo.pass("PRINCIPAL INVESTIGATOR Option From SEARCH BY Dropdown Clicked");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	 
	 @Then("^Verify PRINCIPAL INVESTIGATOR Screen Is Displayed$")
	 public void verify_PRINCIPAL_INVESTIGATOR_Screen_Is_Displayed() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify PRINCIPAL INVESTIGATOR Screen Is Displayed");
				
				new SipSponsorLandingPage(driver).verify_PRINCIPAL_INVESTIGATOR_Screen_Is_Displayed();
				Thread.sleep(1000);
				logInfo.pass("PRINCIPAL INVESTIGATOR Screen Is Displayed");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	 
	 @Then("^Click On User/Facility Option From SEARCH BY Dropdown$")
	 public void click_On_User_Facility_Option_From_SEARCH_BY_Dropdown() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Click On User/Facility Option From SEARCH BY Dropdown");
				
				new SipSponsorLandingPage(driver).click_On_User_Facility_Option_From_SEARCH_BY_Dropdown();
				Thread.sleep(1000);
				logInfo.pass("Click On User/Facility Option From SEARCH BY Dropdown");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	 
	 @Then("^Verify User/Facility Search Screen Is Displayed$")
	 public void verify_User_Facility_Search_Screen_Is_Displayed() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify User/Facility Search Screen Is Displayed");
				
				new SipSponsorLandingPage(driver).verify_User_Facility_Search_Screen_Is_Displayed();
				Thread.sleep(1000);
				logInfo.pass("User/Facility Search Screen Is Displayed");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	 
	 @Then("^Click On SIP Logo$")
	 public void click_On_SIP_Logo() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Click On SIP Logo");
				
				new SipSponsorLandingPage(driver).click_On_SIP_Logo();
				Thread.sleep(10000);
				logInfo.pass("Click On SIP Logo - Navigated To Home Screen");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	 
	 @Then("^Verify VIEW ALL Options Under RECENT STUDIES Section$")
	 public void verify_VIEW_ALL_Options_Under_RECENT_STUDIES_Section() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify VIEW ALL Options Under RECENT STUDIES Section");
				
				new SipSponsorLandingPage(driver).verify_VIEW_ALL_Options_Under_RECENT_STUDIES_Section();
				Thread.sleep(1000);
				logInfo.pass("VIEW ALL Options Under RECENT STUDIES Section Is Displayed");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	 
	 @Then("^Verify SET FAVOURITES Options Under FAVORITES Section$")
	 public void verify_SET_FAVOURITES_Options_Under_FAVORITES_Section() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify SET FAVOURITES Options Under FAVORITES Section");
				
				new SipSponsorLandingPage(driver).verify_SET_FAVOURITES_Options_Under_FAVORITES_Section();
				Thread.sleep(1000);
				logInfo.pass("SET FAVOURITES Options Under FAVORITES Section Is Displayed");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	 
	 @Then("^Click On SET FAVOURITES Options Under FAVORITES Section$")
	 public void click_On_SET_FAVOURITES_Options_Under_FAVORITES_Section() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Click On SET FAVOURITES Options Under FAVORITES Section");
				
				new SipSponsorLandingPage(driver).click_On_SET_FAVOURITES_Options_Under_FAVORITES_Section();
				Thread.sleep(10000);
				logInfo.pass("Click On SET FAVOURITES Options Under FAVORITES Section");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	 
	 @Then("^Verify Favourite Marked Studies Are Displayed$")
	 public void verify_Favourite_Marked_Studies_Are_Displayed() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Favourite Marked Studies Are Displayed");
				
				new SipSponsorLandingPage(driver).verify_Favourite_Marked_Studies_Are_Displayed();
				Thread.sleep(1000);
				logInfo.pass("Favourite Marked Studies Are Displayed");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	 
	 @Then("^Verify Favourite Studies Under FAVORITES Section$")
	 public void verify_Favourite_Studies_Under_FAVORITES_Section() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Favourite Studies Under FAVORITES Section");
				
				new SipSponsorLandingPage(driver).verify_Favourite_Studies_Under_FAVORITES_Section();
				Thread.sleep(1000);
				logInfo.pass("Favourite Studies Under FAVORITES Section Displayed");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	 
	 @Then("^Verify Recently Viewed Studies Displayed Under RECENT STUDIES Section$")
	 public void verify_Recently_Viewed_Studies_Displayed_Under_RECENT_STUDIES_Section() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Recently Viewed Studies Displayed Under RECENT STUDIES Section");
				
				new SipSponsorLandingPage(driver).verify_Recently_Viewed_Studies_Displayed_Under_RECENT_STUDIES_Section();
				Thread.sleep(1000);
				logInfo.pass("Verify Recently Viewed Studies Displayed Under RECENT STUDIES Section");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	 
	 @Then("^Verify View All Workspaces Screen Is Displayed$")
	 public void verify_View_All_Workspaces_Screen_Is_Displayed() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify View All Workspaces Screen Is Displayed");
				
				new SipSponsorLandingPage(driver).verify_View_All_Workspaces_Screen_Is_Displayed();
				Thread.sleep(1000);
				logInfo.pass("Verify View All Workspaces Screen Is Displayed");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	 
	 @Then("^Click On VIEW ALL Options Under RECENT STUDIES Section$")
	 public void click_On_VIEW_ALL_Options_Under_RECENT_STUDIES_Section() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Click On VIEW ALL Options Under RECENT STUDIES Section");
				
				new SipSponsorLandingPage(driver).click_On_VIEW_ALL_Options_Under_RECENT_STUDIES_Section();
				Thread.sleep(10000);
				logInfo.pass("Click On VIEW ALL Options Under RECENT STUDIES Section");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	 
	 @Then("^Verify LINKS Section In Sponsor Home Screen$")
	 public void verify_LINKS_Section_In_Sponaor_Home_Screen() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify LINKS Section In Sponsor Home Screen");
				
				new SipSponsorLandingPage(driver).verify_LINKS_Section_In_Sponaor_Home_Screen();
				Thread.sleep(1000);
				logInfo.pass("Verify LINKS Section In Sponsor Home Screen");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	 
	 @Then("^Verify Links Under LINKS Section In Sponsor Home Screen$")
	 public void verify_Links_Under_LINKS_Section_In_Sponsor_Home_Screen() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Links Under LINKS Section In Sponsor Home Screen");
				
				new SipSponsorLandingPage(driver).verify_Links_Under_LINKS_Section_In_Sponsor_Home_Screen();
				Thread.sleep(1000);
				logInfo.pass("Verify Links Under LINKS Section In Sponsor Home Screen");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	 
	 
	 @Then("^Click On Any Links Under LINKS Section In Sponsor Home Screen$")
	 public void click_On_Any_Links_Under_LINKS_Section_In_Sponsor_Home_Screen() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Any Links Under LINKS Section In Sponsor Home Screen");
				
				new SipSponsorLandingPage(driver).click_On_Any_Links_Under_LINKS_Section_In_Sponsor_Home_Screen();
				Thread.sleep(1000);
				logInfo.pass("Clicked On Any Links Under LINKS Section In Sponsor Home Screen");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	 
	 @Then("^Verify Link URL Is Displayed$")
	 public void verify_Link_URL_Is_Displayed() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Any Links Under LINKS Section In Sponsor Home Screen");
				
				new SipSponsorLandingPage(driver).verify_Link_URL_Is_Displayed();
				Thread.sleep(1000);
				logInfo.pass("Clicked On Any Links Under LINKS Section In Sponsor Home Screen");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	 
	 @Then("^Verify SEARCH BY Dropdown Is Displayed With Option$")
	 public void verify_SEARCH_BY_Dropdown_Is_Displayed_With_Option() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify SEARCH BY Dropdown Is Displayed With Option");
				
				new SipSponsorLandingPage(driver).verify_SEARCH_BY_Dropdown_Is_Displayed_With_Option();
				Thread.sleep(1000);
				logInfo.pass("SEARCH BY Dropdown Is Displayed With Option Are Displayed");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	 
	 @Then("^Enter_Application_With_Proper_Login_Siteuser (\\d+)$")
	 public void Enter_Application_With_Proper_Login_Siteuser(int arg1) throws Throwable {
					
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Enter_Application_With_Proper_Login_Siteuser "+arg1);
				
				new SipSponsorLandingPage(driver).Enter_Application_With_Proper_Login_Siteuser(arg1);
				Thread.sleep(20000);
				logInfo.pass("Siteuser "+arg1+" Proper Login Successful");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	
	 @Then("^If Urgent Tasks - Action Required! PopUp Displayed Click On Ok$")
	 public void ClickOkOnUrgentTasksActionRequiredPopUp() throws Throwable {
					
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"If Urgent Tasks - Action Required! PopUp Displayed Click On Ok");
				
				new SipSponsorLandingPage(driver).ClickOkOnUrgentTasksActionRequiredPopUp();
				Thread.sleep(4000);
				logInfo.pass("If Urgent Tasks - Action Required! PopUp Displayed Click On Ok");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}		 			
	 }
	  
	 @Then("^Navigate to View All Workspaces$")
	 public void navigate_to_View_All_Workspaces() throws Throwable {
		 
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Navigate to View All Workspaces");
				
				new SipSponsorLandingPage(driver).navigatetoviewAllWorkspace(); 				
				Thread.sleep(20000);
				logInfo.pass("Navigate to View All Workspaces");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}	
	     
	 }
	 
	 	 
	 @Then("^Select Organization (\\d+) From Organization Name In Search Organization Section$")
	 public void select_Organization_From_Organization_Name_In_Search_Organization_Section(int arg1) throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Select Organization "+arg1+" From Organization Name In Search Organization Section");
				
				new AdminPage(driver).select_Organization_From_Organization_Name_In_Search_Organization_Section(arg1); 				
				Thread.sleep(4000);
				logInfo.pass("Select Organization "+arg1+" From Organization Name In Search Organization Section");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}	
	     
	 }
	 	 
	
	 @Then("^Click On search Button In Search Organization Section$")
	 public void Click_On_search_Button_In_Search_Organization_Section() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Click On search Button In Search Organization Section");
				
				new AdminPage(driver).Click_On_search_Button_In_Search_Organization_Section(); 				
				Thread.sleep(7000);
				logInfo.pass("Click On search Button In Search Organization Section");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}	
	     
	 }
	 
	@Then("^Click Radio Button Against Organization (\\d+) In Search Organization Section$")
	 public void click_Radio_Button_Against_Organization_In_Search_Organization_Section(int arg1) throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Click Radio Button Against Organization "+arg1+" In Search Organization Section");
				
				new AdminPage(driver).click_Radio_Button_Against_Organization_In_Search_Organization_Section(arg1); 				
				Thread.sleep(7000);
				logInfo.pass("Click Radio Button Against Organization "+arg1+" In Search Organization Section");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}	
	     
	 }
	
	 
	 @Then("^Click Delegate Button For Organization In Search Organization Section$")
	 public void Click_Delegate_Button_For_Organization_In_Search_Organization_Section() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Click Delegate Button For Organization In Search Organization Section");
				
				new AdminPage(driver).Click_Delegate_Button_For_Organization_In_Search_Organization_Section(); 				
				Thread.sleep(8000);
				logInfo.pass("Click Delegate Button For Organization In Search Organization Section");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}	
	     
	 }
	 
	 @Then("^Click On Ok Button For Organization In User Profile Delegation Complete PopUp$")
	 public void Click_On_Ok_Button_In_User_Profile_Delegation_Complete_PopUp() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Ok Button For Organization In User Profile Delegation Complete PopUp");
				
				new AdminPage(driver).Click_On_Ok_Button_In_User_Profile_Delegation_Complete_PopUp(); 				
				Thread.sleep(8000);
				logInfo.pass("Click On Ok Button For Organization In User Profile Delegation Complete PopUp");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}	
	     
	 }
	 
	 @Then("^Verify Organization (\\d+) Displayed In Delegate User Profile Screen$")
	 public void verify_Organization_Displayed_In_Delegate_User_Profile_Screen(int arg1) throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Organization "+arg1+" Displayed In Delegate User Profile Screen");
				
				new AdminPage(driver).verify_Organization_Displayed_In_Delegate_User_Profile_Screen(arg1); 				
				Thread.sleep(1000);
				logInfo.pass("Verify Organization "+arg1+" Displayed In Delegate User Profile Screen");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
				
			}	
	     
	 }  
		 
		 @Then("^Login to aaplication with user$")
	 public void login_to_aaplication_with_user() throws Throwable {
		 
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Login to aaplication with user");
				 Properties properties= obj.getProperty();

					Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
					testData.setTestDatainMap(TestDataInMap);
							
					Map<String,String> testDataInMap = testData.getTestDatainMap();
					String username = testDataInMap.get("user2");
					System.out.println(username);
					new SipApplicationLandingPage(driver).NavigateToHomePage(username);
					Thread.sleep(20000);		 
				    logInfo.pass("Login to aaplication with user");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
		
			}		
		 
		 
				
	 }
	 
	 
		 
	 
	 @Then("^Update profile phone number$")
	 public void update_profile_phone_number() throws Throwable {
	     
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Update profile phone number");
				new SipSponsorLandingPage(driver).navigatetoMyProfile();
				Thread.sleep(1000);
				new MyProfilePage(driver).updatePhoneNumber();
				 Thread.sleep(1000);
								 
				logInfo.pass("Update profile phone number");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
		
			}			 
	 
	 }
	 
	 
	 
	 
		 
	 
	 
	 @Then("^Login to aaplication with Siteuser$")
	 public void login_to_aaplication_with_Siteuser() throws Throwable {
		 
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Login to aaplication with Siteuser");
				 
				 Properties properties= obj.getProperty();

					Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
					testData.setTestDatainMap(TestDataInMap);
							
					Map<String,String> testDataInMap = testData.getTestDatainMap();
					String username = testDataInMap.get("siteUserId");
					String password = testDataInMap.get("password");
					String ans1 = testDataInMap.get("Ans1");
					String ans2 = testDataInMap.get("Ans2");
					
					
					new SipApplicationLandingPage(driver).NavigateToHomePageSite(username, password, ans1, ans2);
					Thread.sleep(1000);			 
				
				logInfo.pass("Login to aaplication with Siteuser");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
		
			}	
		 
		 
			    
	 }
	 
	 @Then("^Navigate to potetial Study$")
	 public void navigate_to_potetial_Study() throws Throwable {
		 
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Navigate to potetial Study");
				 new SiteUser_LandingPage(driver).navigateToPotentialStudies();
				 Thread.sleep(5000);
								 
				logInfo.pass("Navigate to potetial Study");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
		
			}	
 
	    
	 }
	 
	 @Then("^Click On Potential Investigator Tab$")
	 public void click_On_Potential_Investigator_Tab() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Potential Investigator Tab");
				CommonClass.highLightElement(driver, new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).PotentialInvestigator_Tab);
				new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).PotentialInvestigator_Tab.click();
				Thread.sleep(10000);
								 
				logInfo.pass("Click On Potential Investigator Tab");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
		
			}	
 }
	 @Then("^Verify Site User (\\d+) Is Displayed Under Delegate for SIP Study Site Maintenance Column$")
	 public void verify_Site_User_Is_Displayed_Under_Delegate_for_SIP_Study_Site_Maintenance_Column(int arg1) throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" Is Displayed Under Delegate for SIP Study Site Maintenance Column");
				new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).verify_Site_User_Is_Displayed_Under_Delegate_for_SIP_Study_Site_Maintenance_Column(arg1);
				Thread.sleep(1000);
								 
				logInfo.pass("Verify Site User "+arg1+" Is Displayed Under Delegate for SIP Study Site Maintenance Column");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
		
			}	
}
	 @Then("^Verify Site User (\\d+) Is Displayed Under Potential Investigator Column$")
	 public void verify_Site_User_Is_Displayed_Under_Potential_Investigator_Column(int arg1) throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" Is Displayed Under Potential Investigator Column");
				new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).verify_Site_User_Is_Displayed_Under_Potential_Investigator_Column(arg1);
				Thread.sleep(1000);
								 
				logInfo.pass("Verify Site User "+arg1+" Is Displayed Under Potential Investigator Column");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
		
			}	
}
	 
	 @Then("^again open the browser and launch url$")
	 public void again_open_the_browser_and_launch_url() throws Throwable {
		 
		 
		 Properties properties= obj.getProperty();
			
			ExtentTest logInfo = null;
			try {
				
			
				logInfo = test.createNode(new GherkinKeyword("Given"),"Open browser and launch SIPUrl");
			
				driver = BrowserUtility.OpenBrowser(driver, properties.getProperty("browser.name"), properties.getProperty("browser.baseURL"));
				logInfo.pass("Open browser and launch SIPUrl");
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
		 
	     
	 }
	 @Then("^ByPasslogin$")
	    public void ByPasslogin() throws Throwable
	   
	    {   
	       
	        ExtentTest logInfo = null;
	       
	        try {
	           
	            System.out.println("Username should be provided");
	            logInfo = test.createNode(new GherkinKeyword("Then"),"Enter the username and click on login");
	           
	            Properties properties;
			    PropertiesFileReader obj = new PropertiesFileReader();
			    properties= obj.getProperty();
			    TestDataHandler testData = new TestDataHandler();
				Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
	            testData.setTestDatainMap(TestDataInMap);
	            String user = TestDataInMap.get("BypassUserid");
				new SipApplicationLandingPage(driver).ByPasslogin(user);
				Thread.sleep(20000);
		
	            logInfo.pass("Enter the username and click on login");
	            logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
	           
	        } catch (AssertionError | Exception e){
	            testStepHandle("FAIL",driver,logInfo,e);
	        }
	       
	    }
	
	 
	 
	

	 
	 
	 @Then("^Navigate to View All Workspaces Site User$")
	 public void navigate_to_View_All_Workspaces_Site_User() throws Throwable {
		 
		 ExtentTest logInfo = null;
			try {
				
			
				logInfo = test.createNode(new GherkinKeyword("Then"),"Navigate to View All Workspaces Site User");
				 new SiteUser_LandingPage(driver).navigatetoviewAllWorkspace();
				 Thread.sleep(1000);
				
				logInfo.pass("Navigate to View All Workspaces Site User");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
				 
	    
	 }

	 
	 
	
	 
	 @Then("^navigate to MySafetyNotification$")
	 public void navigate_to_MySafetyNotification() throws Throwable {
		 
		 new SipSponsorLandingPage(driver).navigatetoMySafetyNotification();
	     
	 }

	 @Then("^navigate to Distribute Upload Safety Notifications$")
	 public void navigate_to_Distribute_Upload_Safety_Notifications() throws Throwable {
		 
		 new SipSponsorLandingPage(driver).navigatetoDistributeUploadSafetyNotifications();
	     
	 }

	 @Then("^navigate to Upload Safety Notifications$")
	 public void navigate_to_Upload_Safety_Notifications() throws Throwable {
		 
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Navigate to Upload Safety Notifications");
				 new SipSponsorLandingPage(driver).navigatetoUploadSafetyNotifications();
				 Thread.sleep(5000);
								 
				logInfo.pass("Navigate to Upload Safety Notifications");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
		
			}	
	   
	 }
	 
	
	 @Then("^navigate to Bulk Upload Safety Notifications$")
	 public void nevigate_to_Bulk_Upload_Safety_Notifications() throws Throwable {
	     
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Navigate to Bulk Upload Safety Notifications");
				new SipSponsorLandingPage(driver).navigatetoBulkUploadSafetyNotifications();
				 Thread.sleep(5000);
								 
				logInfo.pass("Navigate to Bulk Upload Safety Notifications");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
		
			}
		 
		 
	 }
	 
	 
	 
	 @Then("^navigate to SetUp Safety Distribution Rules$")
	 public void navigate_to_SetUp_Safety_Distribution_Rules() throws Throwable {
		 
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Navigate to SetUp Safety Distribution Rules");
				 new SipSponsorLandingPage(driver).navigatetoSetUpSafetyDistributionRules();
				 Thread.sleep(5000);
								 
				logInfo.pass("Navigate to SetUp Safety Distribution Rules");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
		
			}
		 
		
	 }

	 
	 @Then("^navigate to SetUpTaskNotificationTemplates$")
	 public void navigate_to_SetUpTaskNotificationTemplates() throws Throwable {
		 
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"navigate to SetUpTaskNotificationTemplates");
				new SipSponsorLandingPage(driver).navigatetoSetUpTaskNotificationTemplates();
				 Thread.sleep(5000);
								 
				logInfo.pass("navigate to SetUpTaskNotificationTemplates");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
		
			}
		 
	 }

	
	 @Then("^navigate to Distribution via Alternative Means$")
	 public void navigate_to_Distribution_via_Alternative_Means() throws Throwable {
		
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"navigate to Distribution via Alternative Means");
				 new SipSponsorLandingPage(driver).navigatetoDistributionviaAlternativeMeans();
				 Thread.sleep(5000);
								 
				logInfo.pass("navigate to Distribution via Alternative Means");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
		
			}
		
	 }
	 
	 
	 
	  
	 
	 @Then("^open task notification for site user$")
	 public void open_task_notification_for_site_user() throws Throwable {
	    
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Open task notification for site user");
				 
				new SiteUser_LandingPage(driver).viewNotification();
				
				
				 Thread.sleep(5000);
								 
				logInfo.pass("Open task notification for site user");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
		
			}
		 
	 }
	 
	 
	 	 
	 @Then("^navigate to home for Site User$")
	 public void navigate_to_home_for_Site_User() throws Throwable {
		 
		 new SiteUser_LandingPage(driver).home.click();
		 Thread.sleep(6000);
		 
		 try{  
				
			 new SipApplicationLandingPage(driver).okButtonPopUp.click();
			 Thread.sleep(5000);
			   
		 }
			
		 catch(Exception e) {
			    	
			    System.out.print("No Alert");
			    
		    }
		 
		 
	     
	 }

	 @Then("^navigate to My Tasks$")
	 public void navigate_to_My_Tasks() throws Throwable {
		 
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Navigate to My Tasks");
				 
				new SiteUser_LandingPage(driver).myTaskButton.click();
				 Thread.sleep(7000);
				
				
				 Thread.sleep(5000);
								 
				logInfo.pass("Navigate to My Tasks");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
		
			}
		 
		    
	 }
	 
	 @Then("^Site User Navigate to My Tasks$")
	 public void Site_User_Navigate_To_My_Tasks() throws Throwable {
		 
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Site User Navigate to My Tasks");
				 
				new SiteUser_LandingPage(driver).SiteUser_My_TaskButton.click();
				 Thread.sleep(7000);
				
				
				 Thread.sleep(5000);
								 
				logInfo.pass("Site User Navigate to My Tasks");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
		
			}
		 
		    
	 }
	 
	 @Then("^Select Task Description Option From Show/Hide Dropdown In My Task Screen$")
	 public void select_Task_Description_Option_From_Show_Hide_Dropdown_In_My_Task_Screen() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Select Task Description Option From Show/Hide Dropdown In My Task Screen");
				 
				new SiteUser_MyTaskScreen(driver).select_Task_Description_Option_From_Show_Hide_Dropdown_In_My_Task_Screen();
				Thread.sleep(2000);
											 
				logInfo.pass("Select Task Description Option From Show/Hide Dropdown In My Task Screen");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
		
			}
		 
		    
	 }
	 
	 @Then("^Sort Task Received Date In Ascending Order$")
	 public void sort_Task_Received_Date_In_Ascending_Order() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Sort Task Received Date In Ascending Order");
				 
				new SiteUser_MyTaskScreen(driver).sort_Task_Received_Date_In_Ascending_Order();
				Thread.sleep(5000);
											 
				logInfo.pass("Sort Task Received Date In Ascending Order");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
		
			}
		 
		    
	 }
	 
	 
	 @Then("^Verify User Profile Management Tasks For Organization Association Task$")
	 public void verify_User_Profile_Management_Tasks_For_Organization_Association_Task() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify User Profile Management Tasks For Organization Association Task");
				 
				new SiteUser_MyTaskScreen(driver).verify_User_Profile_Management_Tasks_For_Organization_Association_Task();
				Thread.sleep(5000);
											 
				logInfo.pass("Verify User Profile Management Tasks For Organization Association Task");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
		
			}
		 
		    
	 }
	 
	 @Then("^Click On User Profile Management Tasks For Organization Association Task$")
	 public void click_On_User_Profile_Management_Tasks_For_Organization_Association_Task() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Click On User Profile Management Tasks For Organization Association Task");
				 
				new SiteUser_MyTaskScreen(driver).click_On_User_Profile_Management_Tasks_For_Organization_Association_Task();
				Thread.sleep(5000);
											 
				logInfo.pass("Click On User Profile Management Tasks For Organization Association Task");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
		
			}
		 
		    
	 }
	
	 @Then("^Click On Accept Task Button In User Profile Task PopUp$")
	 public void click_On_Accept_Task_Button_In_User_Profile_Task_PopUp() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Accept Task Button In User Profile Task PopUp");
				 
				new SiteUser_MyTaskScreen(driver).click_On_Accept_Task_Button_In_User_Profile_Task_PopUp();
				Thread.sleep(15000);
											 
				logInfo.pass("Click On Accept Task Button In User Profile Task PopUp");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
		
			}
		 
		    
	 }
	 	 
	 
	 
	 @Then("^Navigate to My Safety Notification$")
	 public void navigate_to_My_Safety_Notification() throws Throwable {
		
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Navigate to My Safety Notification");
				 
				 new SiteUser_LandingPage(driver).navigatetoMySN();
				
				
				 Thread.sleep(5000);
								 
				logInfo.pass("Navigate to My Safety Notification");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
		
			}
		 
		    
	 }

	  
	 
	 
		 
	 
	 
	 @Then("^Enter to the application with site user details \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\"$")
	 public void enter_to_the_application_with_site_user_details_and(String username, String password, String ans1, String ans2) throws Throwable {
	    
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Login to aaplication with Siteuser");
				 
						
					
					new SipApplicationLandingPage(driver).NavigateToHomePageSite(username, password, ans1, ans2);
					Thread.sleep(1000);			 
				
				logInfo.pass("Login to aaplication with Siteuser");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
		
			}	
		 
		 
	 }
	 
	 @Then("^Verify Organization Contact Details Report For PDF Extension$")
	 public void verify_Organization_Contact_Details_Report_For_PDF_Extension() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Organization Contact Details Report For PDF Extension");
				new GeneralReportPage(driver).verify_Organization_Contact_Details_Report_For_PDF_Extension();
				Thread.sleep(1000);
				logInfo.pass("Verify Organization Contact Details Report For PDF Extension");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Facility/Department Contact Details Report For PDF Extension$")
	 public void verify_Facility_Department_Contact_Details_Report_For_PDF_Extension() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility/Department Contact Details Report For PDF Extension");
				new GeneralReportPage(driver).verify_Facility_Department_Contact_Details_Report_For_PDF_Extension();
				Thread.sleep(1000);
				logInfo.pass("Verify Facility/Department Contact Details Report For PDF Extension");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Facility/Department Contact Details Report For XLS Extension$")
	 public void verify_Facility_Department_Contact_Details_Report_For_XLS_Extension() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility/Department Contact Details Report For XLS Extension");
				new GeneralReportPage(driver).verify_Facility_Department_Contact_Details_Report_For_XLS_Extension();
				Thread.sleep(1000);
				logInfo.pass("Verify Facility/Department Contact Details Report For XLS Extension");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Facility/Department Contact Details Report For CSV Extension$")
	 public void verify_Facility_Department_Contact_Details_Report_For_CSV_Extension() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility/Department Contact Details Report For CSV Extension");
				new GeneralReportPage(driver).verify_Facility_Department_Contact_Details_Report_For_CSV_Extension();
				Thread.sleep(1000);
				logInfo.pass("Verify Facility/Department Contact Details Report For CSV Extension");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}

	 @Then("^Verify Organization Contact Details Report For XLSX Extension$")
	 public void verify_Organization_Contact_Details_Report_For_XLSX_Extension() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Organization Contact Details Report For XLSX Extension");
				new GeneralReportPage(driver).verify_Organization_Contact_Details_Report_For_XLSX_Extension();
				Thread.sleep(1000);
				logInfo.pass("Verify Organization Contact Details Report For XLSX Extension");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Organization Contact Details Report For CSV Extension$")
	 public void verify_Organization_Contact_Details_Report_For_CSV_Extension() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Organization Contact Details Report For CSV Extension");
				new GeneralReportPage(driver).verify_Organization_Contact_Details_Report_For_CSV_Extension();
				Thread.sleep(1000);
				logInfo.pass("Verify Organization Contact Details Report For CSV Extension");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}

	 @Then("^Verify Onscreen For Facility/Department Contact Details Report$")
	 public void verify_Onscreen_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Onscreen For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).verify_Onscreen_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(1000);
				logInfo.pass("Verify Onscreen For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}

	 @Then("^Verify Facility Therapeutic Area Field Displayed$")
	 public void verify_Facility_Therapeutic_Area_Field_Displayed() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility Therapeutic Area Field Displayed");
				new GeneralReportPage(driver).verify_Facility_Therapeutic_Area_Field_Displayed();
				Thread.sleep(1000);
				logInfo.pass("Verify Facility Therapeutic Area Field Displayed");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Facility Sub-Therapeutic Area Field Displayed$")
	 public void verify_Facility_Sub_Therapeutic_Area_Field_Displayed() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility Sub-Therapeutic Area Field Displayed");
				new GeneralReportPage(driver).verify_Facility_Sub_Therapeutic_Area_Field_Displayed();
				Thread.sleep(1000);
				logInfo.pass("Verify Facility Sub-Therapeutic Area Field Displayed");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Facility Sub-Therapeutic Area Field Is Disabled$")
	 public void verify_Facility_Sub_Therapeutic_Area_Field_Is_Disabled() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility Sub-Therapeutic Area Field Is Disabled");
				new GeneralReportPage(driver).verify_Facility_Sub_Therapeutic_Area_Field_Is_Disabled();
				Thread.sleep(1000);
				logInfo.pass("Verify Facility Sub-Therapeutic Area Field Is Disabled");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}

	 @Then("^Verify Facility Country Field Displayed$")
	 public void verify_Facility_Country_Field_Displayed() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility Country Field Displayed");
				new GeneralReportPage(driver).verify_Facility_Country_Field_Displayed();
				Thread.sleep(1000);
				logInfo.pass("Verify Facility Country Field Displayed");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify All Countries Displayed Under Facility Country Field$")
	 public void verify_All_Countries_Displayed_Under_Facility_Country_Field() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify All Countries Displayed Under Facility Country Field");
				new GeneralReportPage(driver).verify_All_Countries_Displayed_Under_Facility_Country_Field();
				Thread.sleep(1000);
				logInfo.pass("Verify All Countries Displayed Under Facility Country Field");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Facility State/Province/Region Field Displayed$")
	 public void verify_Facility_State_Province_Region_Field_Displayed() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility State/Province/Region Field Displayed");
				new GeneralReportPage(driver).verify_Facility_State_Province_Region_Field_Displayed();
				Thread.sleep(1000);
				logInfo.pass("Verify Facility State/Province/Region Field Displayed");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 @Then("^Verify Facility Name Field Displayed$")
	 public void verify_Facility_Name_Field_Displayed() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility Name Field Displayed");
				new GeneralReportPage(driver).verify_Facility_Name_Field_Displayed();
				Thread.sleep(1000);
				logInfo.pass("Verify Facility Name Field Displayed");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 @Then("^Verify Department Type Field Displayed$")
	 public void verify_Department_Type_Field_Displayed() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Department Type Field Displayed");
				new GeneralReportPage(driver).verify_Department_Type_Field_Displayed();
				Thread.sleep(1000);
				logInfo.pass("Verify Department Type Field Displayed");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 @Then("^Verify Generate Reports Button Under Facility/Department Contact Details Section$")
	 public void verify_Generate_Reports_Button_Under_Facility_Department_Contact_Details_Section() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Generate Reports Button Under Facility/Department Contact Details Section");
				new GeneralReportPage(driver).verify_Generate_Reports_Button_Under_Facility_Department_Contact_Details_Section();
				Thread.sleep(1000);
				logInfo.pass("Verify Generate Reports Button Under Facility/Department Contact Details Section");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Facility State/Province/Region Field Disabled$")
	 public void verify_Facility_State_Province_Region_Field_Disabled() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility State/Province/Region Field Disabled");
				new GeneralReportPage(driver).verify_Facility_State_Province_Region_Field_Disabled();
				Thread.sleep(1000);
				logInfo.pass("Verify Facility State/Province/Region Field Disabled");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Set Facility (\\d+) In Facility Name Field Under Facility/Department Contact Details Section$")
	 public void set_Facility_In_Facility_Name_Field_Under_Facility_Department_Contact_Details_Section(int arg1) throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Set Facility "+arg1+" In Facility Name Field Under Facility/Department Contact Details Section");
				new GeneralReportPage(driver).set_Facility_In_Facility_Name_Field_Under_Facility_Department_Contact_Details_Section(arg1);
				Thread.sleep(5000);
				logInfo.pass("Set Facility "+arg1+" In Facility Name Field Under Facility/Department Contact Details Section");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Select Department Type (\\d+) For Department (\\d+) For Facility (\\d+)$")
	 public void select_Department_Type_For_Department_For_Facility(int arg1, int arg2, int arg3) throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Select Department Type "+arg1+" For Department "+arg2+" For Facility "+arg3);
				new GeneralReportPage(driver).select_Department_Type_For_Department_For_Facility(arg1,arg2,arg3);
				Thread.sleep(5000);
				logInfo.pass("Select Department Type "+arg1+" For Department "+arg2+" For Facility "+arg3);
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Select Facility Country (\\d+) From Facility Country Dropdown$")
	 public void select_Facility_Country_From_Facility_Country_Dropdown(int arg1) throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Select Facility Country "+arg1+" From Facility Country Dropdown");
				new GeneralReportPage(driver).select_Facility_Country_From_Facility_Country_Dropdown(arg1);
				Thread.sleep(5000);
				logInfo.pass("Select Facility Country "+arg1+" From Facility Country Dropdown");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 @Then("^Select Country As \"([^\"]*)\" From Facility Country Dropdown$")
	 public void select_Country_As_From_Facility_Country_Dropdown(String arg1) throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Select Country As "+arg1+" From Facility Country Dropdown");
				new GeneralReportPage(driver).select_Country_As_From_Facility_Country_Dropdown(arg1);
				Thread.sleep(5000);
				logInfo.pass("Select Country As "+arg1+" From Facility Country Dropdown");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Click On GENERATE REPORTS button For Facility/Department Contact Details Report$")
	 public void click_On_GENERATE_REPORTS_button_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Click On GENERATE REPORTS button For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).click_On_GENERATE_REPORTS_button_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(10000);
				logInfo.pass("Click On GENERATE REPORTS button For Facility/Department Contact Details Report$");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Facility/Department Contact Details Report Is Displayed In A Tabular Format$")
	 public void verify_Facility_Department_Contact_Details_Report_Is_Displayed_In_A_Tabular_Format() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility/Department Contact Details Report Is Displayed In A Tabular Format");
				new GeneralReportPage(driver).verify_Facility_Department_Contact_Details_Report_Is_Displayed_In_A_Tabular_Format();
				Thread.sleep(1000);
				logInfo.pass("Verify Facility/Department Contact Details Report Is Displayed In A Tabular Format");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Show/Hide Column Dropdown For Facility/Department Contact Details Report$")
	 public void verify_Show_Hide_Column_Dropdown_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Show/Hide Column Dropdown For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).verify_Show_Hide_Column_Dropdown_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(1000);
				logInfo.pass("Verify Show/Hide Column Dropdown For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Cancel Button Under Facility/Department Contact Details Section$")
	 public void verify_Cancel_Button_Under_Facility_Department_Contact_Details_Section() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Cancel Button Under Facility/Department Contact Details Section");
				new GeneralReportPage(driver).verify_Cancel_Button_Under_Facility_Department_Contact_Details_Section();
				Thread.sleep(1000);
				logInfo.pass("Verify Cancel Button Under Facility/Department Contact Details Section");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Click On CLEAR SEARCH Button For Facility/Department Contact Details Report$")
	 public void click_On_CLEAR_SEARCH_Button_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Click On CLEAR SEARCH Button For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).click_On_CLEAR_SEARCH_Button_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(1000);
				logInfo.pass("Click On CLEAR SEARCH Button For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Print Button For Facility/Department Contact Details Report$")
	 public void verify_Print_Button_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Print Button For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).verify_Print_Button_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(1000);
				logInfo.pass("Verify Print Button For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Export Button For Facility/Department Contact Details Report$")
	 public void verify_Export_Button_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Export Button For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).verify_Export_Button_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(1000);
				logInfo.pass("Verify Export Button For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Click On Export Button For Facility/Department Contact Details Report$")
	 public void click_On_Export_Button_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Export Button For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).click_On_Export_Button_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(3000);
				logInfo.pass("Click On Export Button For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify \"([^\"]*)\" Option Is Displayed For Facility/Department Contact Details Report$")
	 public void verify_Option_Is_Displayed_For_Facility_Department_Contact_Details_Report(String arg1) throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify "+arg1+" Option Is Displayed For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).verify_Option_Is_Displayed_For_Facility_Department_Contact_Details_Report(arg1);
				Thread.sleep(1000);
				logInfo.pass("Verify "+arg1+" Option Is Displayed For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Click On \"([^\"]*)\" Option Is Displayed For Facility/Department Contact Details Report$")
	 public void click_On_Option_Is_Displayed_For_Facility_Department_Contact_Details_Report(String arg1) throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Click On "+arg1+" Option Is Displayed For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).click_On_Option_Is_Displayed_For_Facility_Department_Contact_Details_Report(arg1);
				Thread.sleep(10000);
				logInfo.pass("Click On "+arg1+" Option Is Displayed For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}

	 
	 @Then("^Verify Pagination Section For Facility/Department Contact Details Report$")
	 public void verify_Pagination_Section_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Pagination Section For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).verify_Pagination_Section_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(1000);
				logInfo.pass("Verify Pagination Section For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Total Record Count Displayed For Facility/Department Contact Details Report$")
	 public void verify_Total_Record_Count_Displayed_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Total Record Count Displayed For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).verify_Total_Record_Count_Displayed_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(1000);
				logInfo.pass("Verify Total Record Count Displayed For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Vertical Scroll Bar For Facility/Department Contact Details Report$")
	 public void verify_Vertical_Scroll_Bar_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Vertical Scroll Bar For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).verify_Vertical_Scroll_Bar_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(1000);
				logInfo.pass("Verify Vertical Scroll Bar For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 
	 @Then("^Verify Horizantal Scroll Bar For Facility/Department Contact Details Report$")
	 public void verify_Horizantal_Scroll_Bar_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Horizantal Scroll Bar For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).verify_Horizantal_Scroll_Bar_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(1000);
				logInfo.pass("Verify Horizantal Scroll Bar For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Facility Name Column Is Displayed For Facility/Department Contact Details Report$")
	 public void verify_Facility_Name_Column_Is_Displayed_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility Name Column Is Displayed For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).verify_Facility_Name_Column_Is_Displayed_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(1000);
				logInfo.pass("Verify Facility Name Column Is Displayed For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}

	 @Then("^Verify Facility Name Column Is Sortable For Facility/Department Contact Details Report$")
	 public void verify_Facility_Name_Column_Is_Sortable_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility Name Column Is Sortable For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).verify_Facility_Name_Column_Is_Sortable_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(1000);
				logInfo.pass("Verify Facility Name Column Is Sortable For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 @Then("^Verify All Facilities Under Facility Name Column Is Hyperlinked For Facility/Department Contact Details Report$")
	 public void verify_All_Facilities_Under_Facility_Name_Column_Is_Hyperlinked_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify All Facilities Under Facility Name Column Is Hyperlinked For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).verify_All_Facilities_Under_Facility_Name_Column_Is_Hyperlinked_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(1000);
				logInfo.pass("Verify All Facilities Under Facility Name Column Is Hyperlinked For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Facility Address Columns Are Displayed For Facility/Department Contact Details Report$")
	 public void verify_Facility_Address_Columns_Are_Displayed_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility Address Columns Are Displayed For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).verify_Facility_Address_Columns_Are_Displayed_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(1000);
				logInfo.pass("Verify Facility Address Columns Are Displayed For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Facility Address Columns Are Sortable For Facility/Department Contact Details Report$")
	 public void verify_Facility_Address_Columns_Are_Sortable_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility Address Columns Are Sortable For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).verify_Facility_Address_Columns_Are_Sortable_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(1000);
				logInfo.pass("Verify Facility Address Columns Are Sortable For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Verify Department Name Column Is Displayed For Facility/Department Contact Details Report$")
	 public void verify_Verify_Department_Name_Column_Is_Displayed_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Verify Department Name Column Is Displayed For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).verify_Verify_Department_Name_Column_Is_Displayed_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(1000);
				logInfo.pass("Verify Verify Department Name Column Is Displayed For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Department Name Column Is Sortable For Facility/Department Contact Details Report$")
	 public void verify_Department_Name_Column_Is_Sortable_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Department Name Column Is Sortable For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).verify_Department_Name_Column_Is_Sortable_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(1000);
				logInfo.pass("Verify Department Name Column Is Sortable For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify All Department Under Department Name Column Is Hyperlinked For Facility/Department Contact Details Report$")
	 public void verify_All_Department_Under_Department_Name_Column_Is_Hyperlinked_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify All Department Under Department Name Column Is Hyperlinked For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).verify_All_Department_Under_Department_Name_Column_Is_Hyperlinked_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(1000);
				logInfo.pass("Verify All Department Under Department Name Column Is Hyperlinked For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Department Type Column Is Displayed For Facility/Department Contact Details Report$")
	 public void verify_Department_Type_Column_Is_Displayed_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Department Type Column Is Displayed For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).verify_Department_Type_Column_Is_Displayed_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(1000);
				logInfo.pass("Verify Department Type Column Is Displayed For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Department Type Column Is Sortable For Facility/Department Contact Details Report$")
	 public void verify_Department_Type_Column_Is_Sortable_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Department Type Column Is Sortable For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).verify_Department_Type_Column_Is_Sortable_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(1000);
				logInfo.pass("Verify Department Type Column Is Sortable For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Department Address Columns Displayed For Facility/Department Contact Details Report$")
	 public void verify_Department_Address_Columns_Displayed_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Department Address Columns Displayed For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).verify_Department_Address_Columns_Displayed_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(1000);
				logInfo.pass("Verify Department Address Columns Displayed For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 @Then("^Verify Department Address Column Is Sortable For Facility/Department Contact Details Report$")
	 public void verify_Department_Address_Column_Is_Sortable_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Department Address Column Is Sortable For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).verify_Department_Address_Column_Is_Sortable_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(1000);
				logInfo.pass("Verify Department Address Column Is Sortable For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 @Then("^Verify Facility/Department Role Column Displayed For Facility/Department Contact Details Report$")
	 public void verify_Facility_Department_Role_Column_Displayed_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility/Department Role Column Displayed For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).verify_Facility_Department_Role_Column_Displayed_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(1000);
				logInfo.pass("Verify Facility/Department Role Column Displayed For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Facility/Department Role Column Is Sortable For Facility/Department Contact Details Report$")
	 public void verify_Facility_Department_Role_Column_Is_Sortable_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility/Department Role Column Is Sortable For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).verify_Facility_Department_Role_Column_Is_Sortable_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(1000);
				logInfo.pass("Verify Facility/Department Role Column Is Sortable For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Contact Name Column Displayed For Facility/Department Contact Details Report$")
	 public void verify_Contact_Name_Column_Displayed_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Contact Name Column Displayed For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).verify_Contact_Name_Column_Displayed_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(1000);
				logInfo.pass("Verify Contact Name Column Displayed For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Contact Name Column Is Sortable For Facility/Department Contact Details Report$")
	 public void verify_Contact_Name_Column_Is_Sortable_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Contact Name Column Is Sortable For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).verify_Contact_Name_Column_Is_Sortable_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(1000);
				logInfo.pass("Verify Contact Name Column Is Sortable For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Contact Email Address Column Displayed For Facility/Department Contact Details Report$")
	 public void verify_Contact_Email_Address_Column_Displayed_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Contact Email Address Column Displayed For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).verify_Contact_Email_Address_Column_Displayed_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(1000);
				logInfo.pass("Verify Contact Email Address Column Displayed For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Contact Email Address Column Is Sortable For Facility/Department Contact Details Report$")
	 public void verify_Contact_Email_Address_Column_Is_Sortable_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Contact Email Address Column Is Sortable For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).verify_Contact_Email_Address_Column_Is_Sortable_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(1000);
				logInfo.pass("Verify Contact Email Address Column Is Sortable For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Main/Daytime Phone Column Displayed For Facility/Department Contact Details Report$")
	 public void verify_Main_Daytime_Phone_Column_Displayed_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Main/Daytime Phone Column Displayed For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).verify_Main_Daytime_Phone_Column_Displayed_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(1000);
				logInfo.pass("Verify Main/Daytime Phone Column Displayed For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Main/Daytime Phone Column Is Sortable For Facility/Department Contact Details Report$")
	 public void verify_Main_Daytime_Phone_Column_Is_Sortable_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Main/Daytime Phone Column Is Sortable For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).verify_Main_Daytime_Phone_Column_Is_Sortable_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(1000);
				logInfo.pass("Verify Main/Daytime Phone Column Is Sortable For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Fax Number Column Displayed For Facility/Department Contact Details Report$")
	 public void verify_Fax_Number_Column_Displayed_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Fax Number Column Displayed For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).verify_Fax_Number_Column_Displayed_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(1000);
				logInfo.pass("Verify Fax Number Column Displayed For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Fax Number Column Is Sortable For Facility/Department Contact Details Report$")
	 public void verify_Fax_Number_Column_Is_Sortable_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Fax Number Column Is Sortable For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).verify_Fax_Number_Column_Is_Sortable_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(1000);
				logInfo.pass("Verify Fax Number Column Is Sortable For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify SIP User ID Column Displayed For Facility/Department Contact Details Report$")
	 public void verify_SIP_User_ID_Column_Displayed_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify SIP User ID Column Displayed For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).verify_SIP_User_ID_Column_Displayed_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(1000);
				logInfo.pass("Verify SIP User ID Column Displayed For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify SIP User ID Column Is Sortable For Facility/Department Contact Details Report$")
	 public void verify_SIP_User_ID_Column_Is_Sortable_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify SIP User ID Column Is Sortable For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).verify_SIP_User_ID_Column_Is_Sortable_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(1000);
				logInfo.pass("Verify SIP User ID Column Is Sortable For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Department Type (\\d+) Is Under Department Type Column For Facility/Department Contact Details Report$")
	 public void verify_Department_Type_Is_Under_Department_Type_Column_For_Facility_Department_Contact_Details_Report(int arg1) throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Department Type "+arg1+" Is Under Department Type Column For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).verify_Department_Type_Is_Under_Department_Type_Column_For_Facility_Department_Contact_Details_Report(arg1);
				Thread.sleep(1000);
				logInfo.pass("Verify Department Type "+arg1+" Is Under Department Type Column For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Click On Facility (\\d+) Displayed Inder Facility Name Column For Facility/Department Contact Details Report$")
	 public void click_On_Facility_Displayed_Inder_Facility_Name_Column_For_Facility_Department_Contact_Details_Report(int arg1) throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Facility "+arg1+" Displayed Inder Facility Name Column For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).click_On_Facility_Displayed_Inder_Facility_Name_Column_For_Facility_Department_Contact_Details_Report(arg1);
				Thread.sleep(10000);
				logInfo.pass("Click On Facility "+arg1+" Displayed Inder Facility Name Column For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 @Then("^Verify Facility Name & Address Screen Displayed With Facility (\\d+) As Header$")
	 public void verify_Facility_Name_Address_Screen_Displayed_With_Facility_As_Header(int arg1) throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility Name & Address Screen Displayed With Facility "+arg1+" As Header");
				new GeneralReportPage(driver).verify_Facility_Name_Address_Screen_Displayed_With_Facility_As_Header(arg1);
				Thread.sleep(3000);
				logInfo.pass("Verify Facility Name & Address Screen Displayed With Facility "+arg1+" As Header");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Click On Department (\\d+) Of Facility (\\d+) Under Facility Name Column For Facility/Department Contact Details Report$")
	 public void click_On_Department_Of_Facility_Under_Facility_Name_Column_For_Facility_Department_Contact_Details_Report(int arg1, int arg2) throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Department "+arg1+" Of Facility "+arg2+" Under Facility Name Column For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).click_On_Department_Of_Facility_Under_Facility_Name_Column_For_Facility_Department_Contact_Details_Report(arg1,arg2);
				Thread.sleep(10000);
				logInfo.pass("Click On Department "+arg1+" Of Facility "+arg2+" Under Facility Name Column For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify (\\d+)/(\\d+)/(\\d+)/(\\d+)/(\\d+) Option For Show Rows Dropdown$")
	 public void verify_Option_For_Show_Rows_Dropdown(int arg1, int arg2, int arg3, int arg4, int arg5) throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify "+arg1+"/"+arg2+"/"+arg3+"/"+arg4+"/"+arg5+" Option For Show Rows Dropdown");
				new GeneralReportPage(driver).verify_Option_For_Show_Rows_Dropdown(arg1,arg2,arg3,arg4,arg5);
				Thread.sleep(1000);
				logInfo.pass("Verify "+arg1+"/"+arg2+"/"+arg3+"/"+arg4+"/"+arg5+" Option For Show Rows Dropdown");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Click Expand General Reports Section For Facility/Department Contact Details Report$")
	 public void click_Expand_General_Reports_Section_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Click Expand General Reports Section For Facility/Department Contact Details Report");
				new GeneralReportPage(driver).click_Expand_General_Reports_Section_For_Facility_Department_Contact_Details_Report();
				Thread.sleep(1000);
				logInfo.pass("Click Expand General Reports Section For Facility/Department Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Department Name & Address Screen Displayed With Department (\\d+) of Facility (\\d+) As Header$")
	 public void verify_Department_Name_Address_Screen_Displayed_With_Department_of_Facility_As_Header(int arg1, int arg2) throws Throwable {
		 ExtentTest logInfo = null;
			try 
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Department Name & Address Screen Displayed With Department "+arg1+" of Facility "+arg2+" As Header");
				new GeneralReportPage(driver).verify_Department_Name_Address_Screen_Displayed_With_Department_of_Facility_As_Header(arg1,arg2);
				Thread.sleep(3000);
				logInfo.pass("Verify Department Name & Address Screen Displayed With Department "+arg1+" of Facility "+arg2+" As Header");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Generate Safety Acknowledgement Status Tracking Report for SUSAR$")
	 public void generate_Safety_Acknowledgement_Status_Tracking_Report_for_SUSAR() throws Throwable {
	     
		 
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Generate Safety Acknowledgement Status Tracking Report for SUSAR");
				 
				new GeneralReportPage(driver).GenerateSNAcknowledgementStatus();
				
				
				 Thread.sleep(5000);
								 
				logInfo.pass("Generate Safety Acknowledgement Status Tracking Report for SUSAR");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
		
			}
		 
		 
		 
	 }
	 
	 @Then("^Click On GENERATE REPORTS Button$")
	 public void click_On_GENERATE_REPORTS_Button() throws Throwable {
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Click On GENERATE REPORTS Button");
				 
				new GeneralReportPage(driver).click_On_GENERATE_REPORTS_Button();
				
				
				 Thread.sleep(10000);
								 
				logInfo.pass("Click On GENERATE REPORTS Button");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
		
			}
	}
	 
	 @Then("^Verify Organization Contact Details Report Generated$")
	 public void verify_Organization_Contact_Details_Report_Generated() throws Throwable {
		 ExtentTest logInfo = null;
			try
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Organization Contact Details Report Generated");
				new GeneralReportPage(driver).verify_Organization_Contact_Details_Report_Generated();
				Thread.sleep(1000);
				logInfo.pass("Verify Organization Contact Details Report Generated");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e)
			{
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Organization Contact Details Report Table Headers$")
	 public void verify_Organization_Contact_Details_Report_Table_Headers() throws Throwable {
		 ExtentTest logInfo = null;
			try
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Organization Contact Details Report Table Headers");
				new GeneralReportPage(driver).verify_Organization_Contact_Details_Report_Table_Headers();
				Thread.sleep(1000);
				logInfo.pass("Verify Organization Contact Details Report Table Headers");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e)
			{
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Click On Export Icon For Organization Contact Details Report$")
	 public void click_On_Export_Icon_For_Organization_Contact_Details_Report() throws Throwable {
		 ExtentTest logInfo = null;
			try
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Export Icon For Organization Contact Details Report");
				new GeneralReportPage(driver).click_On_Export_Icon_For_Organization_Contact_Details_Report();
				Thread.sleep(3000);
				logInfo.pass("Click On Export Icon For Organization Contact Details Report");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e)
			{
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Export As PDF option Under Export Icon In Organization Contact Details Report Screen$")
	 public void verify_Export_As_PDF_option_Under_Export_Icon_In_Organization_Contact_Details_Report_Screen() throws Throwable {
		 ExtentTest logInfo = null;
			try
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Export As PDF option Under Export Icon In Organization Contact Details Report Screen");
				new GeneralReportPage(driver).verify_Export_As_PDF_option_Under_Export_Icon_In_Organization_Contact_Details_Report_Screen();
				Thread.sleep(1000);
				logInfo.pass("Verify Export As PDF option Under Export Icon In Organization Contact Details Report Screen");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e)
			{
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Export As XLS option Under Export Icon In Organization Contact Details Report Screen$")
	 public void verify_Export_As_XLS_option_Under_Export_Icon_In_Organization_Contact_Details_Report_Screen() throws Throwable {
		 ExtentTest logInfo = null;
			try
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Export As XLS option Under Export Icon In Organization Contact Details Report Screen");
				new GeneralReportPage(driver).verify_Export_As_XLS_option_Under_Export_Icon_In_Organization_Contact_Details_Report_Screen();
				Thread.sleep(1000);
				logInfo.pass("Verify Export As XLS option Under Export Icon In Organization Contact Details Report Screen");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e)
			{
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 @Then("^Verify Export As CSV option Under Export Icon In Organization Contact Details Report Screen$")
	 public void verify_Export_As_CSV_option_Under_Export_Icon_In_Organization_Contact_Details_Report_Screen() throws Throwable {
		 ExtentTest logInfo = null;
			try
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Export As CSV option Under Export Icon In Organization Contact Details Report Screen");
				new GeneralReportPage(driver).verify_Export_As_CSV_option_Under_Export_Icon_In_Organization_Contact_Details_Report_Screen();
				Thread.sleep(1000);
				logInfo.pass("Verify Export As CSV option Under Export Icon In Organization Contact Details Report Screen");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e)
			{
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 
	 @Then("^Click On Export As PDF option Under Export Icon In Organization Contact Details Report Screen$")
	 public void click_On_Export_As_PDF_option_Under_Export_Icon_In_Organization_Contact_Details_Report_Screen() throws Throwable {
		 ExtentTest logInfo = null;
			try
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Export As PDF option Under Export Icon In Organization Contact Details Report Screen");
				new GeneralReportPage(driver).click_On_Export_As_PDF_option_Under_Export_Icon_In_Organization_Contact_Details_Report_Screen();
				Thread.sleep(10000);
				logInfo.pass("Click On Export As PDF option Under Export Icon In Organization Contact Details Report Screen");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e)
			{
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}

	 @Then("^Click On Export As XLS option Under Export Icon In Organization Contact Details Report Screen$")
	 public void click_On_Export_As_XLS_option_Under_Export_Icon_In_Organization_Contact_Details_Report_Screen() throws Throwable {
		 ExtentTest logInfo = null;
			try
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Export As XLS option Under Export Icon In Organization Contact Details Report Screen");
				new GeneralReportPage(driver).click_On_Export_As_XLS_option_Under_Export_Icon_In_Organization_Contact_Details_Report_Screen();
				Thread.sleep(10000);
				logInfo.pass("Click On Export As XLS option Under Export Icon In Organization Contact Details Report Screen");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e)
			{
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}

	 @Then("^Click On Export As CSV option Under Export Icon In Organization Contact Details Report Screen$")
	 public void click_On_Export_As_CSV_option_Under_Export_Icon_In_Organization_Contact_Details_Report_Screen() throws Throwable {
		 ExtentTest logInfo = null;
			try
			{
				logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Export As CSV option Under Export Icon In Organization Contact Details Report Screen");
				new GeneralReportPage(driver).click_On_Export_As_CSV_option_Under_Export_Icon_In_Organization_Contact_Details_Report_Screen();
				Thread.sleep(10000);
				logInfo.pass("Click On Export As CSV option Under Export Icon In Organization Contact Details Report Screen");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			} 
			catch (AssertionError | Exception e)
			{
				testStepHandle("FAIL",driver,logInfo,e);
			}
	}
	 
	 
	 @Then("^Verify Safety Acknowledgement Status Tracking Report for SUSAR$")
	 public void verify_Safety_Acknowledgement_Status_Tracking_Report_for_SUSAR() throws Throwable {
	    
		  
		 ExtentTest logInfo = null;
			try {
				
				logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Safety Acknowledgement Status Tracking Report for SUSAR");
				 
				 new GeneralReportPage(driver).VerifySNAcknowledgementStatus();
				
				
				 Thread.sleep(5000);
								 
				logInfo.pass("Verify Safety Acknowledgement Status Tracking Report for SUSAR");
				logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
				
			} catch (AssertionError | Exception e){
				testStepHandle("FAIL",driver,logInfo,e);
		
			}
				 
	 }
	 
	 

@Then("^Generate_Safety_Acknowledgement_Status_Tracking_Report$")
public void Generate_Safety_Acknowledgement_Status_Tracking_Report() throws Throwable {
    
	 
	 ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Generate_Safety_Acknowledgement_Status_Tracking_Report");
			 
			new GeneralReportPage(driver).Generate_Safety_Acknowledgement_Status_Tracking_Report();
			
			
			 Thread.sleep(5000);
							 
			logInfo.pass("Sponsor Acknoledge Status Training Report is Displayed");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
	
		}
	 
	 
	 
}

@Then("^Verify_Fields$")
public void Verify_Fields() throws Throwable {
    
	 
	 ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify_Fields");
			 
			new GeneralReportPage(driver).Verify_Fields();
			
			
			 Thread.sleep(5000);
							 
			logInfo.pass("Mentioned fields are displayed Displayed");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
	
		}
	 
	 
	 
}



@Then("^Verify_Thereputicarea_Column$")
public void Verify_Thereputicarea_Column() throws Throwable {
    
	 
	 ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify_Thereputicarea_Column");
			 
			new GeneralReportPage(driver).Verify_Thereputicarea_Column();
			
			
			 Thread.sleep(5000);
							 
			logInfo.pass("Theraputic Area column data showing properly");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
	
		}
	 
	 
	 
}


@Then("^Verify_compound_Column$")
public void Verify_compound_Column() throws Throwable {
    
	 
	 ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify_compound_Column");
			 
			new GeneralReportPage(driver).Verify_compound_Column();
			
			
			 Thread.sleep(5000);
							 
			logInfo.pass("Compound column data showing properly");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
	
		}
	 
	 
	 
}


@Then("^Verify_studyid_Column$")
public void Verify_studyid_Column() throws Throwable {
    
	 
	 ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify_studyid_Column");
			 
			new GeneralReportPage(driver).Verify_studyid_Column();
			
			
			 Thread.sleep(5000);
							 
			logInfo.pass("study id column data showing properly");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
	
		}
	 
	 
	 
}


@Then("^Verify_country_Column$")
public void Verify_country_Column() throws Throwable {
    
	 
	 ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify_country_Column");
			 
			new GeneralReportPage(driver).Verify_country_Column();
			
			
			 Thread.sleep(5000);
							 
			logInfo.pass("country column data showing properly");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
	
		}
	 
	 
	 
}


@Then("^Verify_studysite_Column$")
public void Verify_studysite_Column() throws Throwable {
    
	 
	 ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify_studysite_Column");
			 
			new GeneralReportPage(driver).Verify_studysite_Column();
			
			
			 Thread.sleep(5000);
							 
			logInfo.pass("Study Site column data showing properly");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
	
		}
	 
	 
	 
}


@Then("^Verify_documentname_Column$")
public void Verify_documentname_Column() throws Throwable {
    
	 
	 ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify_documentname_Column");
			 
			new GeneralReportPage(driver).Verify_documentname_Column();
			
			
			 Thread.sleep(5000);
							 
			logInfo.pass("documentname column data showing properly");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
	
		}
	 
	 
	 
}

@Then("^Verify_acknowledgementstatus_Column$")
public void Verify_acknowledgementstatus_Column() throws Throwable {
    
	 
	 ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify_acknowledgementstatus_Column");
			 
			new GeneralReportPage(driver).Verify_acknowledgementstatus_Column();
			
			
			 Thread.sleep(5000);
							 
			logInfo.pass("Verify_acknowledgementstatus_Column");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
	
		}
	 
	 
	 
}



@Then("^Verify_acknowledgementmode_Column$")
public void Verify_acknowledgementmode_Column() throws Throwable {
    
	 
	 ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify_acknowledgementmode_Column");
			 
			new GeneralReportPage(driver).Verify_acknowledgementmode_Column();
			
			
			 Thread.sleep(5000);
							 
			logInfo.pass("Verify_acknowledgementmode_Column");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
	
		}
	 
	 
	 
}


@Then("^Verify_dataacknowledgement_Column$")
public void Verify_dataacknowledgement_Column() throws Throwable {
    
	 
	 ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify_dataacknowledgement_Column");
			 
			new GeneralReportPage(driver).Verify_dataacknowledgement_Column();
			
			
			 Thread.sleep(5000);
							 
			logInfo.pass("Verify dataacknowledgement Column");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
	
		}
	 
	 
	 
}


@Then("^Verify_acknowlededgebysiteuserrole_Column$")
public void Verify_acknowlededgebysiteuserrole_Column() throws Throwable {
    
	 
	 ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify_acknowlededgebysiteuserrole_Column");
			 
			new GeneralReportPage(driver).Verify_acknowlededgebysiteuserrole_Column();
			
			
			 Thread.sleep(5000);
							 
			logInfo.pass("Verify acknowledgementsiteuserrole Column");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
	
		}
	 
	 
	 
}


@Then("^Verify_acknowlededgebysiteusername_Column$")
public void Verify_acknowlededgebysiteusername_Column() throws Throwable {
    
	 
	 ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify_acknowlededgebysiteusername_Column");
			 
			new GeneralReportPage(driver).Verify_acknowlededgebysiteusername_Column();
			
			
			 Thread.sleep(5000);
							 
			logInfo.pass("Verify acknowledgementsiteusername Column");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
	
		}
	 
	 
	 
}


@Then("^Verify_facilityname_Column$")
public void Verify_facilityname_Column() throws Throwable {
    
	 
	 ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify_facilityname_Column");
			 
			new GeneralReportPage(driver).Verify_facilityname_Column();
			
			
			 Thread.sleep(5000);
							 
			logInfo.pass("Verify facility Column");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
	
		}
	 
	 
	 
}


@Then("^Verify_daterecievedbysiteA_Column$")
public void Verify_daterecievedbysiteA_Column() throws Throwable {
    
	 
	 ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify_daterecievedbysiteA_Column");
			 
			new GeneralReportPage(driver).Verify_daterecievedbysiteA_Column();
			
			
			 Thread.sleep(5000);
							 
			logInfo.pass("Verify data recieve by site A Column");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
	
		}
	 
	 
	 
}


@Then("^Verify_daterecievedbysiteB_Column$")
public void Verify_daterecievedbysiteB_Column() throws Throwable {
    
	 
	 ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify_daterecievedbysiteB_Column");
			 
			new GeneralReportPage(driver).Verify_daterecievedbysiteB_Column();
			
			
			 Thread.sleep(5000);
							 
			logInfo.pass("Verify data recieve by site B Column");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
	
		}
	 
	 
	 
}



@Then("^Verify_Duration$")
public void Verify_Duration() throws Throwable {
    
	 
	 ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify_Duration");
			 
			new GeneralReportPage(driver).Verify_Duration();
			
			
			 Thread.sleep(5000);
							 
			logInfo.pass("Verify duration Column");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
	
		}
	 
	 
	 
}


@Then("^Verify_safety_notification_reportdate$")
public void Verify_safety_notification_reportdate() throws Throwable {
    
	 
	 ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify_safety_notification_reportdate");
			 
			new GeneralReportPage(driver).Verify_safety_notification_reportdate();
			
			
			 Thread.sleep(5000);
							 
			logInfo.pass("Verify safety notification report date Column");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
	
		}
	 
	 
	 
}


@Then("^Verify_susar_subtype$")
public void Verify_susar_subtype() throws Throwable {
    
	 
	 ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify_susar_subtype");
			 
			new GeneralReportPage(driver).Verify_susar_subtype();
			
			
			 Thread.sleep(5000);
							 
			logInfo.pass("Verify susar subtype Column");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
	
		}
	 
	 
	 
}


@Then("^Verify_Initial_SUSAR_distributed_outside_system$")
public void Verify_Initial_SUSAR_distributed_outside_system() throws Throwable {
    
	 
	 ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify_Initial_SUSAR_distributed_outside_system");
			 
			new GeneralReportPage(driver).Verify_Initial_SUSAR_distributed_outside_system();
			
			
			 Thread.sleep(5000);
							 
			logInfo.pass("Verify initial susar Column");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
	
		}
	 
	 
	 
}



@Then("^Verify_Reporting_Timeline$")
public void Verify_Reporting_Timeline() throws Throwable {
    
	 
	 ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify_Reporting_Timeline");
			 
			new GeneralReportPage(driver).Verify_Reporting_Timeline();
			
			
			 Thread.sleep(5000);
							 
			logInfo.pass("Verify Reporting Timeline Column");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
	
		}
	 
	 
	 
}

@Then("^Verify_manufracture_report_number$")
public void Verify_manufracture_report_number() throws Throwable {
    
	 
	 ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify_manufracture_report_number");
			 
			new GeneralReportPage(driver).Verify_manufracture_report_number();
			
			
			 Thread.sleep(5000);
							 
			logInfo.pass("Verify manufracture report bumber Column");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
	
		}
	 
	 
	 
}



@Then("^Verify_sposor_version_number$")
public void Verify_sposor_version_number() throws Throwable {
    
	 
	 ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify_sposor_version_number");
			 
			new GeneralReportPage(driver).Verify_sposor_version_number();
			
			
			 Thread.sleep(5000);
							 
			logInfo.pass("Verify sposor version number Column");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
	
		}
	 
	 
	 
}


@Then("^Verify_fields_sortable$")
public void Verify_fields_sortable() throws Throwable {
    
	 
	 ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify_fields_sortable");
			 
			new GeneralReportPage(driver).Verify_fields_sortable();
			
			
			 Thread.sleep(5000);
							 
			logInfo.pass("Table is sortable");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
	
		}
	 
	 
	 
}


@Then("^Logout$")
public void Logout() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	 
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("Then"),"logout");
			System.out.println("Logout");
			new SipApplicationLandingPage(driver).logout();
			Thread.sleep(20000);
			logInfo.pass("User successfully logout from the application");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
			
		}		 
		
}

@Then("^Logout from SipApplication$")
public void logout_from_SipApplication() throws Throwable {

	ExtentTest logInfo = null;
	try {
		
		logInfo = test.createNode(new GherkinKeyword("Then"),"logout");
		System.out.println("Logout");
		new SipApplicationLandingPage(driver).logoutFromSIP();
		Thread.sleep(10000);
		logInfo.pass("User successfully logout from the application");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
		
	}
}

@Then("^Switch To Parent Window And Logout from SipApplication$")
public void switch_To_Parent_Window_And_Logout_from_SipApplication() throws Throwable {
	ExtentTest logInfo = null;
	try {
		
		logInfo = test.createNode(new GherkinKeyword("Then"),"logout");
		System.out.println("Logout");
		new SipApplicationLandingPage(driver).switch_To_Parent_Window_And_Logout_from_SipApplication();
		Thread.sleep(10000);
		logInfo.pass("Switch To Parent Window And Logout from SipApplication");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
		
	}
}

@Then("^Site User Click On Study Site Profile Tab$")
public void site_User_Click_On_Study_Site_Profile_Tab() throws Throwable {
	ExtentTest logInfo = null;
	try {
		
		logInfo = test.createNode(new GherkinKeyword("Then"),"Site User Click On Study Site Profile Tab");
				
		CommonClass.highLightElement(driver, new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).study_site_tab);
		new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).study_site_tab.click();
		Thread.sleep(10000);
		
		logInfo.pass("Site User Click On Study Site Profile Tab");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
		
	}
}

@Then("^Site User Click On Site Staff$")
public void site_User_Click_On_Site_Staff() throws Throwable {
	ExtentTest logInfo = null;
	try {
		
		logInfo = test.createNode(new GherkinKeyword("Then"),"Site User Click On Site Staff");
				
		CommonClass.highLightElement(driver, new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).SiteStaff_Section);
		new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).SiteStaff_Section.click();
		Thread.sleep(10000);
		
		logInfo.pass("Site User Click On Site Staff");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
		
	}
}

@Then("^Verify Study Site Staff Screen Is Displayed For Site User$")
public void verify_Study_Site_Staff_Screen_Is_Displayed_For_Site_User() throws Throwable {
	ExtentTest logInfo = null;
	try {
		
		logInfo = test.createNode(new GherkinKeyword("Then"),"Site User Click On Site Staff");
				
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='siteStaffSectionContents']//h2[text()[normalize-space() = 'Site Staff']]")));
		Thread.sleep(1000);
		
		logInfo.pass("Site User Click On Site Staff");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
		
	}
}

@Then("^Verify Site User (\\d+) Is Displayed As \"([^\"]*)\"$")
public void verify_Site_User_Is_Displayed_As(int arg1, String arg2) throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" Is Displayed As "+arg2);
		
		new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).verify_Site_User_Is_Displayed_As(arg1,arg2);
		 Thread.sleep(1000);
		
		logInfo.pass("Verify Site User "+arg1+" Is Displayed As "+arg2);
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}

}

@Then("^Verify Site User (\\d+) With Role As \"([^\"]*)\" Is Not Displayed Under Site Staff Table$")
public void verify_Site_User_With_Role_As_Is_Not_Displayed_Under_Site_Staff_Table(int arg1, String arg2) throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" With Role As "+arg2+" Is Not Displayed Under Site Staff Table");
		
		new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).verify_Site_User_With_Role_As_Is_Not_Displayed_Under_Site_Staff_Table(arg1,arg2);
		 Thread.sleep(1000);
		
		logInfo.pass("Verify Site User "+arg1+" With Role As "+arg2+" Is Not Displayed Under Site Staff Table");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}

}

@Then("^Verify Site User (\\d+) Is Displayed As \"([^\"]*)\" With Current Date$")
public void verify_Site_User_Is_Displayed_As_With_Current_Date(int arg1, String arg2) throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" Is Displayed As "+arg2+" With Current Date");
		
		new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).verify_Site_User_Is_Displayed_As_With_Current_Date(arg1,arg2);
		 Thread.sleep(1000);
		
		logInfo.pass("Verify Site User "+arg1+" Is Displayed As "+arg2+" With Current Date");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}

}
@Then("^Select Checkbox Against Site User (\\d+) Is Displayed As \"([^\"]*)\"$")
public void select_Checkbox_Against_Site_User_Is_Displayed_As(int arg1, String arg2) throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Select Checkbox Against Site User "+arg1+" Is Displayed As "+arg2);
		
		new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).select_Checkbox_Against_Site_User_Is_Displayed_As(arg1,arg2);
		 Thread.sleep(1000);
		
		logInfo.pass("Select Checkbox Against Site User "+arg1+" Is Displayed As "+arg2);
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}

}

@Then("^Verify Remove Selected Site Staff Button Disabled$")
public void verify_Remove_Selected_Site_Staff_Button_Disabled() throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Remove Selected Site Staff Button Disabled");
		
		new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).verify_Remove_Selected_Site_Staff_Button_Disabled();
		 Thread.sleep(1000);
		
		logInfo.pass("Verify Remove Selected Site Staff Button Disabled");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}

}

@Then("^Verify Remove Selected Site Staff Button Enabled$")
public void verify_Remove_Selected_Site_Staff_Button_Enabled() throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Remove Selected Site Staff Button Enabled");
		
		new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).verify_Remove_Selected_Site_Staff_Button_Enabled();
		 Thread.sleep(1000);
		
		logInfo.pass("Verify Remove Selected Site Staff Button Enabled");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}

}

@Then("^Verify Proceed Button In Remove Site Staff PopUp Is Disabled$")
public void verify_Proceed_Button_In_Remove_Site_Staff_PopUp_Is_Disabled() throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Proceed Button In Remove Site Staff PopUp Is Disabled");
		
		new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).verify_Proceed_Button_In_Remove_Site_Staff_PopUp_Is_Disabled();
		 Thread.sleep(1000);
		
		logInfo.pass("Verify Proceed Button In Remove Site Staff PopUp Is Disabled");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}

}

@Then("^Verify Proceed Button In Remove Site Staff PopUp Is Enabled$")
public void verify_Proceed_Button_In_Remove_Site_Staff_PopUp_Is_Enabled() throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Proceed Button In Remove Site Staff PopUp Is Enabled");
		
		new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).verify_Proceed_Button_In_Remove_Site_Staff_PopUp_Is_Enabled();
		 Thread.sleep(1000);
		
		logInfo.pass("Verify Proceed Button In Remove Site Staff PopUp Is Enabled");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}

}


@Then("^Click On Remove Selected Site Staff Button$")
public void click_On_Remove_Selected_Site_Staff_Button() throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Remove Selected Site Staff Button Enabled");
		
		new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).RemoveSiteStaffBtn.click();;
		Thread.sleep(10000);
		
		logInfo.pass("Verify Remove Selected Site Staff Button Enabled");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}

}

@Then("^Verify Remove Site Staff PopUp Displayed With Proceed And Cancel Button$")
public void verify_Remove_Site_Staff_PopUp_Displayed_With_Proceed_And_Cancel_Button() throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Remove Site Staff PopUp Displayed With Proceed And Cancel Button");
		
		new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).verify_Remove_Site_Staff_PopUp_Displayed_With_Proceed_And_Cancel_Button();
		Thread.sleep(1000);
		
		logInfo.pass("Verify Remove Site Staff PopUp Displayed With Proceed And Cancel Button");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}

}

@Then("^Select Current Date In Date role ended in SIP$")
public void select_Current_Date_In_Date_role_ended_in_SIP() throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Select Current Date In Date role ended in SIP");
		
		new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).select_Current_Date_In_Date_role_ended_in_SIP();
		Thread.sleep(1000);
		
		logInfo.pass("Select Current Date In Date role ended in SIP");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}

}

@Then("^Verify Confirm Selected Site Staff for study access removal PopUp Displayed$")
public void verify_Confirm_Selected_Site_Staff_for_study_access_removal_PopUp_Displayed() throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Confirm Selected Site Staff for study access removal PopUp Displayed");
		
		new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).verify_Confirm_Selected_Site_Staff_for_study_access_removal_PopUp_Displayed();
		Thread.sleep(1000);
		
		logInfo.pass("Verify Confirm Selected Site Staff for study access removal PopUp Displayed");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}

}

@Then("^Click On Proceed Button In Remove Site Staff PopUp$")
public void click_On_Proceed_Button_In_Remove_Site_Staff_PopUp() throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Proceed Button In Remove Site Staff PopUp");
		
		new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).RemoveSiteStaff_ProceedBtn.click();
		Thread.sleep(5000);
		
		logInfo.pass("Click On Proceed Button In Remove Site Staff PopUp");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}

}

@Then("^Click On Submit Button In Confirm Selected Site Staff for study access removal PopUp$")
public void click_On_Submit_Button_In_Confirm_Selected_Site_Staff_for_study_access_removal_PopUp() throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Submit Button In Confirm Selected Site Staff for study access removal PopUp");
		
		CommonClass.highLightElement(driver, new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).ConfirmSiteStaffRemovalSubmit);
		new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).ConfirmSiteStaffRemovalSubmit.click();
		Thread.sleep(15000);
		
		logInfo.pass("Click On Submit Button In Confirm Selected Site Staff for study access removal PopUp");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}

}

@Then("^Verify Site User (\\d+) Having Role As \"([^\"]*)\" Is Role Ended$")
public void verify_Site_User_Having_Role_As_Is_Role_Ended(int arg1, String arg2) throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" Having Role As "+arg2+" Is Role Ended");
		
		new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).verify_Site_User_Having_Role_As_Is_Role_Ended(arg1,arg2);
		Thread.sleep(1000);
		
		logInfo.pass("Verify Site User "+arg1+" Having Role As "+arg2+" Is Role Ended");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}

}

@Then("^Verify Site User (\\d+) Having Role As \"([^\"]*)\" CheckBox Disabled$")
public void verify_Site_User_Having_Role_As_CheckBox_Disabled(int arg1, String arg2) throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" Having Role As "+arg2+" CheckBox Disabled");
		
		new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).verify_Site_User_Having_Role_As_CheckBox_Disabled(arg1,arg2);
		Thread.sleep(1000);
		
		logInfo.pass("Verify Site User "+arg1+" Having Role As "+arg2+" CheckBox Disabled");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}

}

@Then("^Click On Copy Site Staff Button In Study Site Staff Screen for Site User$")
public void click_On_Copy_Site_Staff_Button_In_Study_Site_Staff_Screen_for_Site_User() throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Copy Site Staff Button In Study Site Staff Screen for Site User");
		
		new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).CopySiteStaff.click();
		Thread.sleep(10000);
		
		logInfo.pass("Click On Copy Site Staff Button In Study Site Staff Screen for Site User");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}

}

@Then("^Verify Copy Study Site Profile Screen In Study Site Staff Screen for Site User$")
public void verify_Copy_Study_Site_Profile_Screen_In_Study_Site_Staff_Screen_for_Site_User() throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Copy Study Site Profile Screen In Study Site Staff Screen for Site User");
		
		new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).verify_Copy_Study_Site_Profile_Screen_In_Study_Site_Staff_Screen_for_Site_User();
		Thread.sleep(1000);
		
		logInfo.pass("Verify Copy Study Site Profile Screen In Study Site Staff Screen for Site User");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}

}

@Then("^Verify Search Study Site Profiles In Study Site Staff Screen for Site User$")
public void verify_Search_Study_Site_Profiles_In_Study_Site_Staff_Screen_for_Site_User() throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Search Study Site Profiles In Study Site Staff Screen for Site User");
		
		new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).verify_Search_Study_Site_Profiles_In_Study_Site_Staff_Screen_for_Site_User();
		Thread.sleep(1000);
		
		logInfo.pass("Verify Search Study Site Profiles In Study Site Staff Screen for Site User");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}

}

@Then("^Select Sponsor (\\d+) From Sponsor/CRO Dropdown$")
public void select_Sponsor_From_Sponsor_CRO_Dropdown(int arg1) throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Select Sponsor "+arg1+" From Sponsor/CRO Dropdown");
		
		new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).select_Sponsor_From_Sponsor_CRO_Dropdown(arg1);
		Thread.sleep(1000);
		
		logInfo.pass("Select Sponsor "+arg1+" From Sponsor/CRO Dropdown");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}

}


@Then("^Select Study Type For Study (\\d+) From Study Type Dropdown$")
public void select_Study_Type_For_Study_From_Study_Type_Dropdown(int arg1) throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Select Study Type For Study "+arg1+" From Study Type Dropdown");
		
		new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).select_Study_Type_For_Study_From_Study_Type_Dropdown(arg1);
		Thread.sleep(10000);
		
		logInfo.pass("Select Study Type For Study "+arg1+" From Study Type Dropdown");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}

}

@Then("^Select Study (\\d+) From Study ID Dropdown$")
public void select_Study_From_Study_ID_Dropdown(int arg1) throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Select Study "+arg1+" From Study ID Dropdown");
		
		new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).select_Study_From_Study_ID_Dropdown(arg1);
		Thread.sleep(5000);
		
		logInfo.pass("Select Study "+arg1+" From Study ID Dropdown");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}

}


@Then("^Click On Search Button Under Search Study Site Profiles Section$")
public void click_On_Search_Button_Under_Search_Study_Site_Profiles_Section() throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Search Button Under Search Study Site Profiles Section");
		
		new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).SearchBtn.click();
		Thread.sleep(10000);
		
		logInfo.pass("Click On Search Button Under Search Study Site Profiles Section");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}

}

@Then("^Verify Study (\\d+) Is Displayed Under Search Study Site Profiles Section$")
public void verify_Study_Is_Displayed_Under_Search_Study_Site_Profiles_Section(int arg1) throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Study "+arg1+" Is Displayed Under Search Study Site Profiles Section");
		
		new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).verify_Study_Is_Displayed_Under_Search_Study_Site_Profiles_Section(arg1);
		Thread.sleep(1000);
		
		logInfo.pass("Verify Study "+arg1+" Is Displayed Under Search Study Site Profiles Section");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}

}


@Then("^Verify Site User (\\d+) Is Displayed Under Search Study Site Profiles Section$")
public void verify_Site_User_Is_Displayed_Under_Search_Study_Site_Profiles_Section(int arg1) throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" Is Displayed Under Search Study Site Profiles Section");
		
		new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).verify_Site_User_Is_Displayed_Under_Search_Study_Site_Profiles_Section(arg1);
		Thread.sleep(1000);
		
		logInfo.pass("Verify Site User "+arg1+" Is Displayed Under Search Study Site Profiles Section");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}

}

@Then("^Select Site User (\\d+) From Search Study Site Profiles Section$")
public void select_Site_User_From_Search_Study_Site_Profiles_Section(int arg1) throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Select Site User "+arg1+" From Search Study Site Profiles Section");
		
		new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).select_Site_User_From_Search_Study_Site_Profiles_Section(arg1);
		Thread.sleep(1000);
		
		logInfo.pass("Select Site User "+arg1+" From Search Study Site Profiles Section");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}

}
@Then("^Select Site User (\\d+) From Select Site Staff To Copy Table$")
public void select_Site_User_From_Select_Site_Staff_To_Copy_Table(int arg1) throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Select Site User "+arg1+" From Select Site Staff To Copy Table");
		
		new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).select_Site_User_From_Select_Site_Staff_To_Copy_Table(arg1);
		Thread.sleep(5000);
		
		logInfo.pass("Select Site User "+arg1+" From Select Site Staff To Copy Table");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}

}


@Then("^Click On SELECT STUDY SITE PROFILE Button$")
public void click_On_SELECT_STUDY_SITE_PROFILE_Button() throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Click On SELECT STUDY SITE PROFILE Button");
		
		new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).SelectStudySiteBtn.click();
		Thread.sleep(10000);
		
		logInfo.pass("Click On SELECT STUDY SITE PROFILE Button");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}

}

@Then("^Click On COPY SELECTED RECORD_S Button In Select Site Staff To Copy Section$")
public void click_On_COPY_SELECTED_RECORD_S_Button_In_Select_Site_Staff_To_Copy_Section() throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Click On COPY SELECTED RECORD_S Button In Select Site Staff To Copy Section");
		
		new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).SelectStudySiteStaffBtn.click();
		Thread.sleep(10000);
		
		logInfo.pass("Click On COPY SELECTED RECORD_S Button In Select Site Staff To Copy Section");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}

}

@Then("^Click On OK Button In Study Site Staff Copied Successfully PopUp$")
public void click_On_OK_Button_In_Study_Site_Staff_Copied_Successfully_PopUp() throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Click On OK Button In Study Site Staff Copied Successfully PopUp");
		CommonClass.highLightElement(driver, new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).StaffsCopiedConfirmationPopup_OK_Btn);
		new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).StaffsCopiedConfirmationPopup_OK_Btn.click();
		Thread.sleep(10000);
		
		logInfo.pass("Click On OK Button In Study Site Staff Copied Successfully PopUp");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}

}


@Then("^Verify Site User (\\d+) Name Is Displayed In Confirm Selected Site Staff for study access removal PopUp$")
public void verify_Site_User_Is_Displayed_In_Confirm_Selected_Site_Staff_for_study_access_removal_PopUp(int arg1) throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" Name Is Displayed In Confirm Selected Site Staff for study access removal PopUp");
		
		new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).verify_Site_User_Is_Displayed_In_Confirm_Selected_Site_Staff_for_study_access_removal_PopUp(arg1);
		Thread.sleep(1000);
		
		logInfo.pass("Verify Site User "+arg1+" Name Is Displayed In Confirm Selected Site Staff for study access removal PopUp");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}

}

@Then("^Verify Site User (\\d+) Email Is Displayed In Confirm Selected Site Staff for study access removal PopUp$")
public void verify_Site_User_Email_Is_Displayed_In_Confirm_Selected_Site_Staff_for_study_access_removal_PopUp(int arg1) throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" Email Is Displayed In Confirm Selected Site Staff for study access removal PopUp");
		
		new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).verify_Site_User_Email_Is_Displayed_In_Confirm_Selected_Site_Staff_for_study_access_removal_PopUp(arg1);
		Thread.sleep(1000);
		
		logInfo.pass("Verify Site User "+arg1+" Email Is Displayed In Confirm Selected Site Staff for study access removal PopUp");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}

}

@Then("^Select Reason For Role End As \"([^\"]*)\" In Remove Site Staff PopUp$")
public void select_Reason_For_Role_End_As_In_Remove_Site_Staff_PopUp(String arg1) throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Select Reason For Role End As \""+arg1+"\" In Remove Site Staff PopUp");
		
		new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).select_Reason_For_Role_End_As_In_Remove_Site_Staff_PopUp(arg1);
		Thread.sleep(1000);
		
		logInfo.pass("Select Reason For Role End As \""+arg1+"\" In Remove Site Staff PopUp");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}

}

	@Then("^Navigate_userprofile_MyProfile_AbbrieviatedCV$")
public void Navigate_userprofile_MyProfile_AbbrieviatedCV() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Navigate_userprofile_MyProfile_AbbrieviatedCV");
			
			new MyProfilePage(driver).NavigateAbbrieviatedCV();
			 Thread.sleep(1000);
			
			logInfo.pass("User navigated to Abbriviated CV and verify details");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
 
}

@Then("^Navigateandverify_pullcv$")
public void Navigateandverify_pullcv() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Navigateandverify_pullcv");
			 new MyProfilePage(driver).Navigateandverify_pullcv();
			 Thread.sleep(1000);
			
			logInfo.pass("User navigated to pull CV and verify details");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
 
}

@Then("^Verify_PullCVhistory1$")
public void Verify_PullCVhistory1() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify_PullCVhistory1");
			 new MyProfilePage(driver).Verify_PullCVhistory1();
			 Thread.sleep(1000);
			
			logInfo.pass("cv pulled history details displayed");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
 
}

@Then("^Verify_PullCVhistory$")
public void Verify_PullCVhistory() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify_PullCVhistory");
			 new MyProfilePage(driver).Verify_PullCVhistory();
			 Thread.sleep(1000);
			
			logInfo.pass("cv pulled history details displayed");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
 
}

@Then("^Verify_PullCv_table$")
public void Verify_PullCv_table() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify_PullCv_table");
			 new MyProfilePage(driver).Verify_PullCv_table();
			 Thread.sleep(1000);
			
			logInfo.pass("Pull cv table data are displayed");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
 
}
@Then("^again Open browser and launch SIPUrl$")
public  void again_open_browser_and_launch_SIPUrl() throws Throwable 
{		
	Properties properties= obj.getProperty();
	
	ExtentTest logInfo = null;
	try {
		
		
		
		logInfo = test.createNode(new GherkinKeyword("Given"),"Open browser and launch SIPUrl");
		
		
		driver = BrowserUtility.OpenBrowser(driver, properties.getProperty("browser.name"), properties.getProperty("browser.baseURL"));
		logInfo.pass("Open browser and launch SIPUrl");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}

}



@Then("^Verify_doanload_generatedcv$")
public void Verify_doanload_generatedcv() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify_doanload_generatedcv");
			 new MyProfilePage(driver).Verify_doanload_generatedcv();
			 Thread.sleep(1000);
			
			logInfo.pass("Pull cv table data are displayed");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
 
}

@Then("^Verify_Workspace_tab$")
public void Verify_Workspace_tab() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify_Workspace_tab");
			 new SipApplicationLandingPage(driver).Verify_Workspace_tab();
			 Thread.sleep(1000);
			
			logInfo.pass("Following menus are displayed");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
 
}
@Then("^Verify_Workspace_tab1$")
public void Verify_Workspace_tab1() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify_Workspace_tab1");
			 new SipApplicationLandingPage(driver).Verify_Workspace_tab1();
			 Thread.sleep(1000);
			
			logInfo.pass("Following menus are displayed");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
 
}



@Then("^Clickandverify_Potentialsites$")
public void Clickandverify_Potentialsites() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Clickandverify_Potentialsites");
			 new SipApplicationLandingPage(driver).Clickandverify_Potentialsites();
			 Thread.sleep(1000);
			
			logInfo.pass("Sposor user 1 is navigated to list of petential study sites.");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
 
}

@Then("^Clickandverify_Documents$")
public void Clickandverify_Documents() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Clickandverify_Documents");
			 new SipApplicationLandingPage(driver).Clickandverify_Documents();
			 Thread.sleep(1000);
			
			logInfo.pass("following menus are displayed.");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
 
}

@Then("^Select_FacilityDepartment_From_SearchBy$")
public void select_facilitydepartment_from_searchby() throws Throwable {
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Select_FacilityDepartment_From_SearchBy");
			 new SipApplicationLandingPage(driver).Select_FacilityDepartment_From_SearchBy();
			 Thread.sleep(1000);
			
			logInfo.pass("Select_FacilityDepartment_From_SearchBy");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
}


@Then("^Clickandverify_studydocument$")
public void Clickandverify_studydocument() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Clickandverify_studydocument");
			 new SipApplicationLandingPage(driver).Clickandverify_studydocument();
			 Thread.sleep(1000);
			
			 
			logInfo.pass("Sposor user 1 able to navigate to the safedx homepage.");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
 
}


@Then("^Navigate_Document_safetydocument$")
public void Navigate_Document_safetydocument() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Navigate_Document_safetydocument");
			 new SipApplicationLandingPage(driver).Navigate_Document_safetydocument();
			 Thread.sleep(1000);
			
			logInfo.pass("Sposor user 1 able to navigate to the safety document.");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
 
}


@Then("^Navigate_reports$")
public void Navigate_reports() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Navigate_reports");
			 new SipApplicationLandingPage(driver).Navigate_reports();
			 Thread.sleep(1000);
			
			logInfo.pass("Sposor user 1 able to navigate to the reports.");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
 
}


@Then("^Navigate_Adminmenu$")
public void Navigate_Adminmenu() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Navigate_Adminmenu");
			 new SipApplicationLandingPage(driver).Navigate_Adminmenu();
			 Thread.sleep(1000);
			
			logInfo.pass("Sposor user 1 able to navigate to the Admin.");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
 
}

@Then("^Clickandverify_documentmenu$")
public void Clickandverify_documentmenu() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Clickandverify_documentmenu");
			 new SipApplicationLandingPage(driver).Clickandverify_documentmenu();
			 Thread.sleep(1000);
			
			logInfo.pass("Following menus are displayed");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
 
}


@Then("^Clickandverify_adminmenu$")
public void Clickandverify_adminmenu() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Clickandverify_documentmenu");
			 new SipApplicationLandingPage(driver).Clickandverify_adminmenu();
			 Thread.sleep(1000);
			
			logInfo.pass("Following menus are displayed");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
 
}


@Then("^Navigateuserprofile_MyProfile_Validate$")
public void Navigateuserprofile_MyProfile_Validate() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Navigateuserprofile_MyProfile_Validate");
			 new MyProfilePage(driver).Navigateuserprofile_MyProfile_Validate();
			 Thread.sleep(1000);
			
			logInfo.pass("Following details are displayed");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
 
}

@Then("^HoverOverUserProfile$")
public void hoveroveruserprofile() throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"HoverOverUserProfile");
		 new MyProfilePage(driver).HoverOverUserProfile();
		 Thread.sleep(1000);
		
		logInfo.pass("HoverOverUserProfile");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}
}


@Then("^Click_On_Edit_PhoneNumber$")
public void click_on_edit_phonenumber() throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Click_On_Edit_PhoneNumber");
		 new MyProfilePage(driver).Click_On_Edit_PhoneNumber();
		 Thread.sleep(1000);
		
		logInfo.pass("Click_On_Edit_PhoneNumber");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}
}

@Then("^UpdatePhoneNumber$")
public void updatephonenumber() throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"UpdatePhoneNumber");
		 new MyProfilePage(driver).UpdatePhoneNumber();
		 Thread.sleep(1000);
		
		logInfo.pass("UpdatePhoneNumber");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}
}
@Then("^VerifyRolesInTable$")
public void verifyrolesintable() throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"VerifyRolesInTable");
		 new MyProfilePage(driver).VerifyRolesInTable();
		 Thread.sleep(1000);
		
		logInfo.pass("VerifyRolesInTable");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}
}

@Then("^VerifyEndDatedByColumnInTable$")
public void verifyenddatecolumnintable() throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"VerifyEndDateColumnInTable");
		 new MyProfilePage(driver).VerifyEndDateColumnInTable();
		 Thread.sleep(1000);
		
		logInfo.pass("VerifyEndDateColumnInTable");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}
}

@Then("^VerifyStatusColumnInTable$")
public void verifystatuscolumnintable() throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"VerifyStatusColumnInTable");
		 new MyProfilePage(driver).VerifyStatusColumnInTable();
		 Thread.sleep(1000);
		
		logInfo.pass("VerifyStatusColumnInTable");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}
}


@Then("^Click On Role Status DropDown$")
public void click_On_Role_Status_DropDown() throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Click_On_Role_Status_DropDown");
		 new MyProfilePage(driver).click_On_Role_Status_DropDown();
		 Thread.sleep(1000);
		
		logInfo.pass("Click_On_Role_Status_DropDown");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}
}

@Then("^SelectAllStatusUnderRoleDrowpDown$")
public void SelectAllStatusUnderRoleDrowpDown() throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"SelectAllStatusUnderRoleDrowpDown");
		 new MyProfilePage(driver).SelectAllStatusUnderRoleDrowpDown();
		 Thread.sleep(1000);
		
		logInfo.pass("SelectAllStatusUnderRoleDrowpDown");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}
}

@Then("^ClickCross$")
public void ClickCross() throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"ClickCross");
		 new MyProfilePage(driver).ClickCross();
		 Thread.sleep(1000);
		
		logInfo.pass("ClickCross");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}
}

@Then("^SelectRoleStatus as \"([^\"]*)\"$")
public void selectrolestatus_as(String arg1) throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"SelectRoleStatus");
		 new MyProfilePage(driver).SelectRoleStatus(arg1);
		 Thread.sleep(1000);
		
		logInfo.pass("SelectRoleStatus");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}
}


@Then("^CLick_edit_verify_fields$")
public void CLick_edit_verify_fields() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"CLick_edit_verify_fields");
			 new MyProfilePage(driver).CLick_edit_verify_fields();
			 Thread.sleep(1000);
			
			logInfo.pass("Update phone screen displayed with follwoing details");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
 
}


@Then("^Enterphonenumber_save$")
public void Enterphonenumber_save() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Enterphonenumber_save");
			 new MyProfilePage(driver).Enterphonenumber_save();
			 Thread.sleep(1000);
			
			logInfo.pass("enter phone number and able to save the data");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
		
		
 
}


@Then("^Selectstudydropdownandverify$")
public void Selectstudydropdownandverify() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Selectstudydropdownandverify");
			 new MyProfilePage(driver).Selectstudydropdownandverify();
			 Thread.sleep(1000);
			
			logInfo.pass("in the study dropdown the values are displayed");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
		
		
 
}



@Then("^Enterinvalidphonenumber_save$")
public void Enterinvalidphonenumber_save() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Enterinvalidphonenumber_save");
			 new MyProfilePage(driver).Enterinvalidphonenumber_save();
			 Thread.sleep(1000);
			
			logInfo.pass("enter invalid phone number and verify msg");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
		
		
 
}


@Then("^closeandverify$")
public void closeandverify() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"closeandverify");
			 new MyProfilePage(driver).closeandverify();
			 Thread.sleep(1000);
			
			logInfo.pass("User navigated to User profile screen.");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
		
		
 
}

@Then("^Editandverifys$")
public void Editandverifys() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Editandverifys");
			 new MyProfilePage(driver).Editandverifys();
			 Thread.sleep(1000);
			
			logInfo.pass("User navigated back to User profile screen.");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
		
		
 
}


@Then("^Okandnavigatetobasicdetails$")
public void Okandnavigatetobasicdetails() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Okandnavigatetobasicdetails");
			 new MyProfilePage(driver).Okandnavigatetobasicdetails();
			 Thread.sleep(1000);
			
			logInfo.pass("Basic Detail screen is displayed.");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
		
		
 
}


@Then("^Navigateandverifytosposoraccessrepor$")
public void Navigateandverifytosposoraccessrepor() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Navigateandverifytosposoraccessrepor");
			 new SipApplicationLandingPage(driver).Navigateandverifytosposoraccessrepor();
			 Thread.sleep(1000);
			
			logInfo.pass("Navigate to sponsor access report and verify.");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
		
		
 
}

@Then("^Mytaskandverify$")
public void Mytaskandverify() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Mytaskandverify");
			 new SipApplicationLandingPage(driver).Mytaskandverify();
			 Thread.sleep(1000);
			
			logInfo.pass("My task screen is displayed and verify.");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
		
		
 
}

@Then("^verifydownloadsposoraccessreport$")
public void verifydownloadsposoraccessreport() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"verifydownloadsposoraccessreport");
			 new SipApplicationLandingPage(driver).verifydownloadsposoraccessreport();
			 Thread.sleep(1000);
			
			logInfo.pass("user able to download the pdf.");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
		
		
 
}


@Then("^Pullcv_countryverifycation$")
public void Pullcv_countryverifycation() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Pullcv_countryverifycation");
			 new MyProfilePage(driver).Pullcv_countryverifycation();
			 Thread.sleep(1000);
			
			logInfo.pass("In pullcv country dropdown all the countries are displayed.");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
		
		
 
}



@Then("^selectcountryandverify$")
public void selectcountryandverify() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"selectcountryandverify");
			 new MyProfilePage(driver).selectcountryandverify();
			 Thread.sleep(1000);
			
			logInfo.pass("Country 3 selected and following details are displayed.");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
		
		
 
}

@Then("^NavigateandverifyFacilitycontactdetailreport$")
public void NavigateandverifyFacilitycontactdetailreport() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"NavigateandverifyFacilitycontactdetailreport");
			 new SipApplicationLandingPage(driver).NavigateandverifyFacilitycontactdetailreport();
			 Thread.sleep(1000);
			
			logInfo.pass("Verify the countries are displayed in Facility country list.");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
		
		
 
}


@Then("^Generatereportandverify$")
public void Generatereportandverify() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Generatereportandverify");
			 new SipApplicationLandingPage(driver).Generatereportandverify();
			 Thread.sleep(1000);
			
			logInfo.pass("Generated report displays with country 3 data.");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
		
		
 
}

@Then("^ClickOnViewAllTask$")
public void ClickOnViewAllTask() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnViewAllTask");
			 new SipApplicationLandingPage(driver).ClickOnViewAllTask();
			 Thread.sleep(1000);
			
			logInfo.pass("ClickOnViewAllTask");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
		
		
 
}

@Then("^Navigateandverifyfacilitydepartmentaudittrailreport$")
public void Navigateandverifyfacilitydepartmentaudittrailreport() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Navigateandverifyfacilitydepartmentaudittrailreport");
			 new SipApplicationLandingPage(driver).Navigateandverifyfacilitydepartmentaudittrailreport();
			 Thread.sleep(1000);
			
			logInfo.pass("Facility/ Department Profile Audit Trail are selected.");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
		
}

@Then("^NavigateToAuditTrail$")
public void navigatetoaudittrail() throws Throwable {
	 ExtentTest logInfo = null;
		try {
			logInfo = test.createNode(new GherkinKeyword("Then"),"NavigateToAuditTrail");
			 new SipApplicationLandingPage(driver).NavigateToAuditTrail();
			 Thread.sleep(1000);
			
			logInfo.pass("NavigateToAuditTrail");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
}
@Then("^SelectUserAndFacilityDocumentUnderAuditTrail$")
public void selectuserandfacilitydocumentunderaudittrail() throws Throwable {
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"SelectUserAndFacilityDocumentUnderAuditTrail");
			 new SipApplicationLandingPage(driver).SelectUserAndFacilityUnderAuditTrail();
			 Thread.sleep(1000);
			
			logInfo.pass("SelectUserAndFacilityDocumentUnderAuditTrail");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
}



//@Then("^Filldataandgeneratereport$")
//public void Filldataandgeneratereport() throws Throwable {
//	 
//	 ExtentTest logInfo = null;
//		try {
//			
//		
//			logInfo = test.createNode(new GherkinKeyword("Then"),"Filldataandgeneratereport");
//			 new SipApplicationLandingPage(driver).Filldataandgeneratereport();
//			 Thread.sleep(1000);
//			
//			logInfo.pass("Facility ID and Department ID are displayed.");
//			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
//			
//		} catch (AssertionError | Exception e){
//			testStepHandle("FAIL",driver,logInfo,e);
//		}
//}

@Then("^Filldataandgeneratereport as \"([^\"]*)\" And \"([^\"]*)\"$")
public void filldataandgeneratereport_as_And(String arg1, String arg2) throws Throwable {
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Filldataandgeneratereport");
			 new SipApplicationLandingPage(driver).FillDatesAndgenerateReportAs(arg1,arg2);
			 Thread.sleep(1000);
			
			logInfo.pass("Facility ID and Department ID are displayed.");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
}

@Then("^FillDetailsUnderAudittrail$")
public void filldetailsunderaudittrail() throws Throwable {
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"FillDetailsUnderAudittrail");
			 new SipApplicationLandingPage(driver).FillDetailsUnderAuditTrail();
			 Thread.sleep(1000);
			
			logInfo.pass("FillDetailsUnderAudittrail");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
}

@Then("^FillDetailsForFacilityDepartmentAuditTrail With Faciliy as \"([^\"]*)\"$")
public void filldetailsforfacilitydepartmentaudittrail_With_Faciliy_as(String arg1) throws Throwable {
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"FillDetailsUnderAudittrail");
			 new SipApplicationLandingPage(driver).FillDetailsForFacilityDepartmentAuditTrail(arg1);
			 Thread.sleep(1000);
			
			logInfo.pass("FillDetailsUnderAudittrail");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
}

@Then("^GenerateReport$")
public void Generatereport() throws Throwable {
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"GenerateRepor");
			 new SipApplicationLandingPage(driver).GenerateReport();
			 Thread.sleep(1000);
			
			logInfo.pass("GenerateReport");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
}

@Then("^ClickOn \\+ buttonForSponser$")
public void clickon_buttonForSponser() throws Throwable {
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"clickOnAddButton");
			 new SipApplicationLandingPage(driver).clickOnAddButtonForSponser();
			 Thread.sleep(1000);
			
			logInfo.pass("clickOnAddButton");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
}
@Then("^ClickOn \\+ buttonForSite$")
public void clickon_buttonForSite() throws Throwable {
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"clickOnAddButton");
			 new SipApplicationLandingPage(driver).clickOnAddButtonForSite();
			 Thread.sleep(1000);
			
			logInfo.pass("clickOnAddButton");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
}


@Then("^Exportasxls$")
public void Exportasxls() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Exportasxls");
			 new SipApplicationLandingPage(driver).Exportasxls();
			 Thread.sleep(1000);
			
			logInfo.pass("User able to export in xls.");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
		
		
 
}
@Then("^ExportPDF$")
public void ExportPDF() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"ExportPDF");
			 new SipApplicationLandingPage(driver).ExportPDF();
			 Thread.sleep(1000);
			
			logInfo.pass("User able to export in pdf.");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}

}



@Then("^ExportPDFinGeneralReports$")
public void exportpdfingeneralreports() throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"ExportPDF");
		 new SipApplicationLandingPage(driver).ExportPDFInGeneralReport();
		 Thread.sleep(1000);
		
		logInfo.pass("User able to export in pdf.");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}
}

@Then("^ClickOnprint$")
public void ClickOnprint() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnprint");
			 new GeneralReportPage(driver).ClickOnprint();
			 Thread.sleep(1000);
			
			logInfo.pass("ClickOnprint");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
		
		
 
}

@Then("^Select \"([^\"]*)\" Option From General Reports Dropdown$")
public void select_Option_From_General_Reports_Dropdown(String arg1) throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"Select "+arg1+" Option From General Reports Dropdown");
		 new GeneralReportPage(driver).select_Option_From_General_Reports_Dropdown(arg1);
		 Thread.sleep(15000);
		
		logInfo.pass("Select "+arg1+" Option From General Reports Dropdown");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}
	
	

}



@Then("^ValidatePDFFile By Name as \"([^\"]*)\"$")
public void validatepdffile_By_Name_as(String arg1) throws Throwable {
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"ValidatePdf");
			 new GeneralReportPage(driver).validatepdffile_By_Name_as(arg1);
			 Thread.sleep(1000);
			
			logInfo.pass("VAlidatePdf");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
}

@Then("^ValidatePDFFile By FilePath$")
public void ValidatePDFFile_By_FilePath(String arg1) throws Throwable {
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"ValidatePDF");
			 new GeneralReportPage(driver).ValidatePDFFile_By_FilePath();
			 Thread.sleep(1000);
			
			logInfo.pass("ValidatePDF");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
}
@Then("^ExportCSV$")
public void ExportCSV() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Exportasxls");
			 new GeneralReportPage(driver).ExportCSV();
			 Thread.sleep(1000);
			
			logInfo.pass("User able to export in CSV.");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
		
		
 
}



@Then("^Navigatetofacilities$")
public void Navigatetofacilities() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Navigatetofacilities");
			 new SipApplicationLandingPage(driver).Navigatetofacilities();
			 Thread.sleep(1000);
			
			logInfo.pass("Navigated to Facilities screen.");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}

}

@Then("^Navigatetofacilitys$")
public void Navigatetofacilitys() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Navigatetofacilitys");
			 new SipApplicationLandingPage(driver).Navigatetofacilitys();
			 Thread.sleep(1000);
			
			logInfo.pass("Navigated to Facilities screen.");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}

}


@Then("^clickprimarychechbox$")
public void clickprimarychechbox() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"clickprimarychechbox");
			 new SipApplicationLandingPage(driver).clickprimarychechbox();
			 Thread.sleep(1000);
			
			logInfo.pass("User able to select primary checkbox .");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}

}


@Then("^Previewcvbutton$")
public void Previewcvbutton() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Previewcvbutton");
			 new SipApplicationLandingPage(driver).Previewcvbutton();
			 Thread.sleep(1000);
			
			logInfo.pass("User able to view popup .");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}

}


@Then("^Verifyonscreentext$")
public void Verifyonscreentext() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verifyonscreentext");
			 new MyFacilityPage(driver).Verifyonscreentext();
			 Thread.sleep(1000);
			
			logInfo.pass("Facility Onscreen Text is displayed .");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}

}

@Then("^Verify Facility/Department Fields$")
public void verify_Facility_Department_Fields() throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"verify_Facility_Department_Fields");
		 new MyFacilityPage(driver).Verify_Facility_Department_Fields();
		 Thread.sleep(1000);
		
		logInfo.pass("verify_Facility_Department_Fields");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}
}

@Then("^Update Department Details$")
public void update_Department_Details() throws Throwable {
	ExtentTest logInfo = null;
	try {
		
	
		logInfo = test.createNode(new GherkinKeyword("Then"),"update_Department_Details");
		 new MyFacilityPage(driver).Update_Department_Detailst();
		 Thread.sleep(1000);
		
		logInfo.pass("update_Department_Details");
		logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		
	} catch (AssertionError | Exception e){
		testStepHandle("FAIL",driver,logInfo,e);
	}
}

@Then("^Verifyfacilitytable$")
public void Verifyfacilitytable() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verifyfacilitytable");
			 new MyFacilityPage(driver).Verifyfacilitytable();
			 Thread.sleep(1000);
			
			logInfo.pass("Display in CV column is displayed");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
}




@Then("^Verifyunchecked$")
public void Verifyunchecked() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verifyunchecked");
			 new MyFacilityPage(driver).Verifyunchecked();
			 Thread.sleep(1000);
			
			logInfo.pass("Chck box is showing unchecked by default.");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
}



@Then("^verifyfacilitycoulumn$")
public void verifyfacilitycoulumn() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"verifyfacilitycoulumn");
			 new MyFacilityPage(driver).verifyfacilitycoulumn();
			 Thread.sleep(1000);
			
			logInfo.pass("mentioned columns are displayed in the facility table .");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
}




@Then("^Verifyfacility1$")
public void Verifyfacility1() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verifyfacility1");
			 new MyFacilityPage(driver).Verifyfacility1();
			 Thread.sleep(1000);
			
			logInfo.pass("Facility name ,ID and address are displayed.");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
}


@Then("^Verifydepartmentid$")
public void Verifydepartmentid() throws Throwable {
	 
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verifydepartmentid");
			 new MyFacilityPage(driver).Verifydepartmentid();
			 Thread.sleep(1000);
			
			logInfo.pass("Departent name ,ID and address are displayed.");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
}


@Then("^Enter to the application with \"([^\"]*)\" bypass login$")
public void enter_to_the_application_with_bypass_login(String user) throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Enter to the application with Site User Bypass Login");
            new SipApplicationLandingPage(driver).NavigateToHomePageBypass(user);
            Thread.sleep(1000);
          
           logInfo.pass("Enter to the application with Site User Bypass Login");
          
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}


@Then("^Generatecvbutton$")
public void Generatecvbutton() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Generatecvbutton");
            new MyProfilePage(driver).Generatecvbutton();
            Thread.sleep(1000);
          
           logInfo.pass("Generate cv pop up is displayed with yes and cancel buttons");
          
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}


@Then("^Userabletoesign$")
public void Userabletoesign() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Userabletoesign");
            new MyProfilePage(driver).Userabletoesign();
            Thread.sleep(1000);
          
           logInfo.pass("User able to esign the page ");
          
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}


@Then("^Navigatedtodelegatedprofile$")
public void Navigatedtodelegatedprofile() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Navigatedtodelegatedprofile");
            new MyProfilePage(driver).Navigatedtodelegatedprofile();
            Thread.sleep(1000);
          
           logInfo.pass("Site user 2 navigated to delegated profile screen of Site user 1 ");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}


@Then("^Verifysiteuser1details$")
public void Verifysiteuser1details() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verifysiteuser1details");
            new MyProfilePage(driver).Verifysiteuser1details();
            Thread.sleep(1000);
          
           logInfo.pass("Follwoing details are displayed for Site user 2.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}


@Then("^Verifybasicdetail$")
public void Verifybasicdetail() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verifybasicdetail");
            new MyProfilePage(driver).Verifybasicdetail();
            Thread.sleep(1000);
          
           logInfo.pass("Basic details of site user 1 is diaplyed read more and radio button appears as selected.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}



@Then("^Updateprofessionalexpandsendallchangesforapproval$")
public void Updateprofessionalexpandsendallchangesforapproval() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Updateprofessionalexpandsendallchangesforapproval");
            new MyProfilePage(driver).Updateprofessionalexpandsendallchangesforapproval();
            Thread.sleep(1000);
          
           logInfo.pass("Professional experience section filled and sent for approval.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}


@Then("^Navigatedtoapproverejectupdate$")
public void Navigatedtoapproverejectupdate() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Navigatedtoapproverejectupdate");
            new MyProfilePage(driver).Navigatedtoapproverejectupdate();
            Thread.sleep(1000);
          
           logInfo.pass("Professional experience section filled and sent for approval.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}


@Then("^Navigatetosearchfacilityandverify$")
public void Navigatetosearchfacilityandverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Navigatetosearchfacilityandverify");
            new MyFacilityPage(driver).NevigateToSearchFacility();
            Thread.sleep(1000);
            new MyFacilityPage(driver).verifyFecilitySearch();
          
           logInfo.pass("Navigatetosearchfacilityandverify");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^NavigatetoSponserSearchfacility$")
public void navigatetosponsersearchfacility() throws Throwable {
	 ExtentTest logInfo = null;
     try {
        
    
         logInfo = test.createNode(new GherkinKeyword("Then"),"NavigatetoSponserSearchfacility$");
          new MyFacilityPage(driver).NevigateToSearchFacility();
          Thread.sleep(1000);
          new MyFacilityPage(driver).VerifySponserSearchFacility();
        
         logInfo.pass("Navigatetosearchfacilityandverify");
         logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
     } catch (AssertionError | Exception e){
         testStepHandle("FAIL",driver,logInfo,e);
     }
}

@Then("^EnterSponserCountryStateAndCity$")
public void entersponsercountrystateandcity() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"EnterCountryStateAndCity");
         new MyFacilityPage(driver).EnterSponserCountryStateAndCity();
         Thread.sleep(1000);
         
       
        logInfo.pass("EnterCountryStateAndCity");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^NevigateToSponserSearchFacility$")
public void nevigatetosponsersearchfacility() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"NevigateToSponserSearchFacility");
         new MyFacilityPage(driver).NevigateToSponserSearchFacility();
         Thread.sleep(1000);
         
       
        logInfo.pass("NevigateToSponserSearchFacility");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^EnterSponserCountryAndFacilityName$")
public void entersponsercountryandfacilityname() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"EnterSponserCountryAndFacilityName");
         new MyFacilityPage(driver).EnterSponserCountryAndFacilitySearch();
         Thread.sleep(1000);
         
       
        logInfo.pass("EnterSponserCountryAndFacilityName");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickOnFacilityLink$")
public void clickonfacilitylink() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnFacilityLink");
         new MyFacilityPage(driver).clickonTheFacilityLink();
         Thread.sleep(1000);
         
       
        logInfo.pass("ClickOnFacilityLink");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickOnDepartmentLink$")
public void clickonDepartmentlink() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnDepartmentLink");
         new MyFacilityPage(driver).ClickOnDepartmentLink();
         Thread.sleep(1000);
         
       
        logInfo.pass("ClickOnDepartmentLink");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}



@Then("^EnterSponserCountry$")
public void entersponsercountry() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"EnterSponserCountry");
         new MyFacilityPage(driver).EnterSponserCountry();
         Thread.sleep(1000);
         
       
        logInfo.pass("EnterSponserCountry");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^EnterSponserCountry as \"([^\"]*)\"$")
public void entersponsercountry_as(String arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"EnterSponserCountry");
         new MyFacilityPage(driver).EnterSponserCountryNew(arg1);
         Thread.sleep(1000);
         
       
        logInfo.pass("EnterSponserCountry");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickPlusIcon$")
public void ClickPlusIcon() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickPlusIcon");
         new MyFacilityPage(driver).ClickPlusIcon();
         Thread.sleep(1000);
         
       
        logInfo.pass("ClickPlusIcon");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}


@Then("^EnterSponserCountryAndState as \"([^\"]*)\" and \"([^\"]*)\"$")
public void entersponsercountryandstate_as_and(String arg1, String arg2) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"EnterSponserCountryState");
         new MyFacilityPage(driver).EnterSponserCountryAndState(arg1,arg2);
         Thread.sleep(1000);
         
       
        logInfo.pass("EnterSponserCountryState");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^EnterSponserCountryAndFacility as \"([^\"]*)\" and \"([^\"]*)\"$")
public void entersponsercountryandFacility_as_and(String arg1, String arg2) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"EnterSponserCountryFacility");
         new MyFacilityPage(driver).EnterSponserCountryAndFacility(arg1,arg2);
         Thread.sleep(1000);
         
       
        logInfo.pass("EnterSponserCountryFacility");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^EnterSponserCountryAndDepartmentType \"([^\"]*)\" and \"([^\"]*)\"$")
public void entersponsercountryanddepartmenttype_and(String arg1, String arg2) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"EnterSponserCountryAndDepartmentType");
         new MyFacilityPage(driver).EnterSponserCountryAndDepartmentType(arg1,arg2);
         Thread.sleep(1000);
         
       
        logInfo.pass("EnterSponserCountryAndDepartmentType");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^EnterSponserCountryStateCityAndDepartmentType$")
public void EnterSponserCountryStateCityAndDepartmentType() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"EnterSponserCountryStateCityAndDepartmentType");
         new MyFacilityPage(driver).EnterSponserCountryStateCityAndDepartmentType();
         Thread.sleep(1000);
         
       
        logInfo.pass("EnterSponserCountryStateCityAndDepartmentType");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^EnterSponserCountryTA_SubTA_Phase_StydyType$")
public void entersponsercountryta_subta_phase_stydytype() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"EnterSponserCountryTA_SubTA_Phase_StydyType");
         new MyFacilityPage(driver).EnterSponserCountryTA_SubTA_Phase_StydyType();
         Thread.sleep(1000);
         
       
        logInfo.pass("EnterSponserCountryTA_SubTA_Phase_StydyType");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^EnterSponserCountryAndSIPID$")
public void entersponsercountryandsipid() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"EnterSponserCountryAndSIPID");
         new MyFacilityPage(driver).EnterSponserCountryAndSIPID();
         Thread.sleep(1000);
         
       
        logInfo.pass("EnterSponserCountryAndSIPID");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^EnterSponserCountryStateFacilityNameAndSIPID$")
public void entersponsercountrystatefacilitynameandsipid() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"EnterSponserCountryStateFacilityNameAndSIPID");
         new MyFacilityPage(driver).EnterSponserCountryStateFacilityNameAndSIPID();
         Thread.sleep(1000);
         
       
        logInfo.pass("EnterSponserCountryStateFacilityNameAndSIPID");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^EntersponsercountryfacilitynameDepartmentType$")
public void EntersponserCountryFacilitynameDepartmentType() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"EntersponsercountryfacilitynameDepartmentType");
         new MyFacilityPage(driver).EntersponserCountryFacilitynameDepartmentType();
         Thread.sleep(1000);
         
       
        logInfo.pass("EntersponserCountryFacilitynameDepartmentType");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^VerifyFacilitySearch$")
public void verifyfacilitysearch() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"VerifyFacilitySearch");
         new MyFacilityPage(driver).VerifyFacilitySearch();
         Thread.sleep(1000);
         
       
        logInfo.pass("VerifyFacilitySearch");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickOnViewDepartmentAndVerify$")
public void clickonviewdepartmentandverify() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnViewDepartmentAndVerify");
         new MyFacilityPage(driver).ClickOnViewDepartmentAndVerify();
         Thread.sleep(1000);
         
       
        logInfo.pass("ClickOnViewDepartmentAndVerify");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^CheckFacility as \"([^\"]*)\" and ClickViewDepartment$")
public void checkfacility_as_and_ClickViewDepartment(String arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"CheckFacilityClickOnViewDepartment");
         new MyFacilityPage(driver).CheckFacilityClickOnViewDepartment(arg1);
         Thread.sleep(1000);
         
       
        logInfo.pass("CheckFacilityClickOnViewDepartment");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^CheckFacility as \"([^\"]*)\"$")
public void checkfacility_as(String arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"CheckFacility");
         new MyFacilityPage(driver).CheckFacility(arg1);
         Thread.sleep(1000);
         
       
        logInfo.pass("CheckFacilityClickOnViewDepartment");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ExportFacilitySearchIntoPDF$")
public void exportfacilitysearchintopdf() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ExportFacilitySearchIntoPDF");
         new MyFacilityPage(driver).ExportFacilitySearchIntoPDF();
         Thread.sleep(1000);
         logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       new MyFacilityPage(driver).ClickExportFacilitySearchPDF();  
       Thread.sleep(1000);
       logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       
       new MyFacilityPage(driver).ClickExportFacilitySearchOK(); 
       Thread.sleep(1000);
       logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       
        logInfo.pass("ExportFacilitySearchIntoPDF");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ExportDepartmentSearchIntoPDF$")
public void exportDepartmentsearchintopdf() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ExportFacilitySearchIntoPDF");
         new MyFacilityPage(driver).ExportDepartmentSearchIntoPDF();
         Thread.sleep(1000);
         logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       new MyFacilityPage(driver).ClickExportFacilitySearchPDF();  
       Thread.sleep(1000);
       logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       
       new MyFacilityPage(driver).ClickExportFacilitySearchOK(); 
       Thread.sleep(1000);
       logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       
        logInfo.pass("ExportFacilitySearchIntoPDF");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ExportDepartmentSearchIntoWord$")
public void ExportDepartmentSearchIntoWord() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ExportFacilitySearchIntoPDF");
         new MyFacilityPage(driver).ExportDepartmentSearchIntoWord();
         Thread.sleep(1000);
         logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       new MyFacilityPage(driver).ClickExportDepartmentSearchPDF();  
       Thread.sleep(1000);
       logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       
       new MyFacilityPage(driver).ClickExportDepartmentSearchOK(); 
       Thread.sleep(1000);
       logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       
        logInfo.pass("ExportFacilitySearchIntoPDF");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}
@Then("^ClickOnFacilityHyperlinkOnSearch as \"([^\"]*)\"$")
public void clickonfacilityhyperlinkonsearch_as(String arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnFacilityHyperlinkOnSearch");
         new MyFacilityPage(driver).ClickOnFacilityHyperlinkOnSearch(arg1);
         Thread.sleep(1000);
         
       
        logInfo.pass("ClickOnFacilityHyperlinkOnSearch");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^EnterCountryStateAndCity$")
public void entercountrystateandcity() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"EnterCountryStateAndCity");
         new MyFacilityPage(driver).EnterCountryStateAndCity();
         Thread.sleep(1000);
         
       
        logInfo.pass("EnterCountryStateAndCity");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^clickOnSearchAndVerifyErrorsAndFields$")
public void clickonsearchandverifyerrorsandfields() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"clickOnSearchAndVerifyErrorsAndFields");
         new MyFacilityPage(driver).ClickOnSearchAndVery();
         Thread.sleep(1000);
         new MyFacilityPage(driver).verifyFecilitySearchForfields();
       
        logInfo.pass("clickOnSearchAndVerifyErrorsAndFields");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^EnterSiteUserCountryStateCityFacility$")
public void entersiteusercountrystatecityfacility() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"EnterSiteUserCountryStateCityFacility");
         new MyFacilityPage(driver).EnterSiteUserCountryStateCityFacility();
         Thread.sleep(1000);
         
       
        logInfo.pass("EnterSiteUserCountryStateCityFacility");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^EnterSiteUserCountryStateCity$")
public void entersiteusercountrystatecity() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"EnterSiteUserCountryStateCity");
         new MyFacilityPage(driver).EnterSiteUserCountryStateCity();
         Thread.sleep(1000);
         
       
        logInfo.pass("EnterSiteUserCountryStateCity");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^EnterCountry as \"([^\"]*)\" and Facility as \"([^\"]*)\" and Search$")
public void entercountry_as_and_Facility_as_and_Search(String arg1, String arg2) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"EnterDetailsandSearch");
         new MyFacilityPage(driver).EnterCountryAndFacility(arg1,arg2);
         Thread.sleep(1000);
         
       
        logInfo.pass("EnterDetailsandSearchlickOnSearchAndVerifyErrorsAndFields");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^EnterCountry as \"([^\"]*)\" and State as \"([^\"]*)\" and Search$")
public void entercountry_as_and_State_as_and_Search(String arg1, String arg2) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"EnterDetailsandSearch");
         new MyFacilityPage(driver).EnterCountryAndState(arg1,arg2);
         Thread.sleep(1000);
         
       
        logInfo.pass("EnterCountryAndState");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^VerifyFacilityOrDepartmentColumnForSorting$")
public void verifyfacilityOrDepartmentcolumnforsorting() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"VerifyFacilityOrDepartmentColumnForSorting");
         new MyFacilityPage(driver).VerifyFacilityColumnForSorting();
         Thread.sleep(1000);
         
       
        logInfo.pass("VerifyFacilityOrDepartmentColumnForSorting");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^VerifySponserFacilityOrDepartmentColumnForSorting$")
public void verifysponserfacilityordepartmentcolumnforsorting() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"VerifySponserFacilityOrDepartmentColumnForSorting");
         new MyFacilityPage(driver).VerifySponserFacilityColumnForSorting();
         Thread.sleep(1000);
         
       
        logInfo.pass("VerifySponserFacilityOrDepartmentColumnForSorting");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickonCitySort$")
public void ClickonCitySort() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickonCitySort");
         new MyFacilityPage(driver).ClickonCitySort();
         Thread.sleep(1000);
         
       
        logInfo.pass("ClickonCitySort");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickOnStateSort$")
public void clickonstatesort() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnStateSort");
         new MyFacilityPage(driver).ClickOnStateSort();
         Thread.sleep(1000);
         
       
        logInfo.pass("ClickOnStateSort");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickonFacilitySort$")
public void clickonfacilitysort() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickonFacilitySort");
         new MyFacilityPage(driver).ClickonFacilitySort();
         Thread.sleep(1000);
         
       
        logInfo.pass("ClickonFacilitySort");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickOnDepartmentSort$")
public void clickondepartmentsort() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnDepartmentSort");
         new MyFacilityPage(driver).ClickOnDepartmentSort();
         Thread.sleep(1000);
         
       
        logInfo.pass("ClickOnDepartmentSort");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickOnDepartmentCitySort$")
public void clickondepartmentcitysort() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnDepartmentCitySort");
         new MyFacilityPage(driver).ClickOnDepartmentCitySort();
         Thread.sleep(1000);
         
       
        logInfo.pass("ClickOnDepartmentCitySort");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickOnDepartmentStateSort$")
public void clickondepartmentstatesort() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnDepartmentStateSort");
         new MyFacilityPage(driver).ClickOnDepartmentStateSort();
         Thread.sleep(1000);
         
       
        logInfo.pass("ClickOnDepartmentStateSort");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}
@Then("^ClickOnCancelButtonToNevigateBackAfterVerifyErrorMsg$")
public void clickoncancelbuttontonevigatebackafterverifyerrormsg() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnCancelButtonToNevigateBackAfterVerifyErrorMsg");
         new MyFacilityPage(driver).ClickOnCancelButtonAfterVerifyErrorMsg();
         Thread.sleep(1000);
         
       
        logInfo.pass("ClickOnCancelButtonToNevigateBackAfterVerifyErrorMsg");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickOnCancelButtonToNevigateBackAndVerify$")
public void clickoncancelbuttontonevigatebackandverify() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnCancelButtonToNevigateBackAndVerify");
         new MyFacilityPage(driver).NevigateBackToSearchfacility();
         Thread.sleep(1000);
         
       
        logInfo.pass("ClickOnCancelButtonToNevigateBackAndVerify");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Select Facility as \"([^\"]*)\" and ClickAddFacilityToYourUser$")
public void select_Facility_as_and_ClickAddFacilityToYourUser(String arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"SelectFacility");
         new MyFacilityPage(driver).selectFacilityCheckBoxAndAdd(arg1);
         Thread.sleep(1000);
         
       
        logInfo.pass("SelectFacility");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Select Department as \"([^\"]*)\" and ClickAddDeparmentToYourUser$")
public void select_Department_as_and_ClickAddDeparmentToYourUser(String arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"SelectDepartment");
         new MyFacilityPage(driver).SelectDepartmentCheckBoxAndAdd(arg1);
         Thread.sleep(1000);
         
       
        logInfo.pass("SelectDepartment");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}
@Then("^Click IWillMaintainTheFacilityProfile And VerifyPage$")
public void click_IWillMaintainTheFacilityProfile_And_VerifyPage() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Click IWillMaintainTheFacilityProfile And VerifyPage");
         new MyFacilityPage(driver).ClickOnIWillMaintainTheFacilityProfile();
         Thread.sleep(1000);
         
       
        logInfo.pass("SelectFacility");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}


@Then("^ClickOnOkForFacilityAlreadyAdded$")
public void ClickOnOkForFacilityAlreadyAdded() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnOkForFacilityAlreadyAdded");
         new MyFacilityPage(driver).ClickOnOkForFacilityAlreadyAdded();
         Thread.sleep(1000);
         
       
        logInfo.pass("ClickOnOkForFacilityAlreadyAdded");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Click On FacilityHyperlink$")
public void click_On_FacilityHyperlink() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Click On FacilityHyperlink$");
         new MyFacilityPage(driver).ClickOnHyperLink();
         Thread.sleep(1000);
         
       
        logInfo.pass("SelectFacility");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Click On EnterFacilityProfileManually And Verify Green FacilityContact$")
public void click_On_EnterFacilityProfileManually_And_Verify_Green_FacilityContact() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Click On EnterFacilityProfileManually And Verify Green FacilityContact$");
         new MyFacilityPage(driver).ClickOn_EnterFacilityProfileManuallyAndVerifyPage();
         Thread.sleep(1000);
         
       
        logInfo.pass("SelectFacility");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^NevigateToFacilityContact$")
public void nevigatetofacilitycontact() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"NevigateToFacilityContact$");
         new MyFacilityPage(driver).NevigateToFacilityContact();
         Thread.sleep(1000);
         
       
        logInfo.pass("NevigateToFacilityContact");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}



@Then("^Add Site User as \"([^\"]*)\"$")
public void add_Site_User_as(String arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"add_Site_User_as$");
         new MyFacilityPage(driver).add_Site_User_as(arg1);
         Thread.sleep(1000);
         
       
        logInfo.pass("add_Site_User_as");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Select contact type as FPM$")
public void select_contact_type_as_FPM() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"select_contact_type_as_FPM$");
         new MyFacilityPage(driver).select_contact_type_as_FPM();
         Thread.sleep(1000);
         
       
        logInfo.pass("select_contact_type_as_FPM");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^VerifyFacilityContactFPM$")
public void verifyfacilitycontactfpm() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"VerifyFacilityContactFPM");
         new MyFacilityPage(driver).VerifyFacilityContactFPM();
         Thread.sleep(1000);
         
       
        logInfo.pass("VerifyFacilityContactFPM");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}


@Then("^VerifyAddDeparmentPage$")
public void verifyadddeparmentpage() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"VerifyAddDeparmentPage");
         new MyFacilityPage(driver).VerifyAddDepartment();
         Thread.sleep(1000);
         
       
        logInfo.pass("VerifyAddDeparmentPage");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}
@Then("^ClickOnCreatNewDepartment$")
public void clickoncreatnewdepartment() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnCreatNewDepartment");
         new MyFacilityPage(driver).ClickOnCreatNewDepartment();
         Thread.sleep(1000);
         
       
        logInfo.pass("ClickOnCreatNewDepartment");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^EnterDepartmentTypeAndNameUnderCreatNewDepartment$")
public void enterdepartmenttypeandnameundercreatnewdepartment() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"EnterDepartmentTypeAndNameUnderCreatNewDepartment");
         new MyFacilityPage(driver).EnterDepartmentTypeAndNameUnderCreatNewDepartment();
         Thread.sleep(1000);
         
       
        logInfo.pass("EnterDepartmentTypeAndNameUnderCreatNewDepartment");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickOnIwillAssignSomeOneElse$")
public void clickoniwillassignsomeoneelse() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnIwillAssignSomeOneElse");
        
         
         new MyFacilityPage(driver).ClickOnIwillAssignSomeOneElse();
         Thread.sleep(1000);
         
        logInfo.pass("ClickOnIwillAssignSomeOneElse");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}
@Then("^ClickI_WIL_MAINTAIN_THE_DEPARTMENT_PROFILE And Countinue Updates$")
public void clicki_wil_maintain_the_department_profile_And_Countinue_Updates() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickI_WIL_MAINTAIN_THE_DEPARTMENT_PROFILE And Countinue Updates");
         new MyFacilityPage(driver).ClickI_WIL_MAINTAIN_THE_DEPARTMENT_PROFILE();
         Thread.sleep(1000);
         new MyFacilityPage(driver).ClickOnCountinue_Updates();
       
        logInfo.pass("ClickI_WIL_MAINTAIN_THE_DEPARTMENT_PROFILE And Countinue Updates");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickI_WIL_MAINTAIN_THE_DEPARTMENT_PROFILE$")
public void clicki_wil_maintain_the_department_profile() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickI_WIL_MAINTAIN_THE_DEPARTMENT_PROFILE And Countinue Updates");
         new MyFacilityPage(driver).ClickI_WIL_MAINTAIN_THE_DEPARTMENT_PROFILE();
         
        logInfo.pass("ClickI_WIL_MAINTAIN_THE_DEPARTMENT_PROFILE And Countinue Updates");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Go To myUserProfile$")
public void go_To_myUserProfile() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"go_To_myUserProfile");
         
         
         new MyFacilityPage(driver).go_To_myUserProfile();
       
        logInfo.pass("go_To_myUserProfile");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickOnRadiobuttonAndSelectDepartmentContact$")
public void clickonradiobuttonandselectdepartmentcontact() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnRadiobuttonAndSelectDepartmentContact");
         new MyFacilityPage(driver).ClickOnRadiobuttonAndSelectDepartmentContact();
         Thread.sleep(1000);
       
       
        logInfo.pass("ClickOnRadiobuttonAndSelectDepartmentContact");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickOnCountinueUpdating$")
public void clickoncountinueupdating() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnCountinueUpdating");
         
        
         new MyFacilityPage(driver).ClickOnCountinue_Updates();
         Thread.sleep(1000);
        logInfo.pass("ClickOnCountinueUpdating");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^VerifyPopulatedDepartmentProfile$")
public void verifypopulateddepartmentprofile() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"VerifyPopulatedDepartmentProfile");
         
         new MyFacilityPage(driver).Verifypopulateddepartmentprofile();
         Thread.sleep(1000);
        logInfo.pass("VerifyPopulatedDepartmentProfile");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickOnUploadSIPDocument$")
public void clickonuploadsipdocument() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnUploadSIPDocument");
         
         new MyFacilityPage(driver).ClickOnUploadSIPDocument();
         Thread.sleep(1000);
        logInfo.pass("ClickOnUploadSIPDocument");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickOnCancelOfSIPdocument$")
public void clickoncancelofsipdocument() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnCancelOfSIPdocument");
         
         new MyFacilityPage(driver).ClickOnCancelOfSIPdocument();
         Thread.sleep(1000);
        logInfo.pass("ClickOnCancelOfSIPdocument");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickOnDownloadLink$")
public void clickondownloadlink() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnDownloadLink");
         
         new MyFacilityPage(driver).ClickOnDownloadLink();
         Thread.sleep(1000);
        logInfo.pass("ClickOnDownloadLink");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^BrowseFile and VerifyUploadButton as \"([^\"]*)\"$")
public void browsefile_and_VerifyUploadButton_as(String arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"BrowseFile and VerifyUploadButton");
         
         new MyFacilityPage(driver).BrowseFileandVerifyUploadButton(arg1);
         Thread.sleep(1000);
        logInfo.pass("BrowseFile and VerifyUploadButton");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickOKOnErrormsg$")
public void ClickOKOnErrormsg() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOKOnErrormsg");
         new MyFacilityPage(driver).ClickOKOnErrormsg();
         Thread.sleep(1000);
       
       
        logInfo.pass("ClickOKOnErrormsg");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickOnUploadButtonandVerify$")
public void ClickOnUploadButtonandVerify() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnUploadButtonandVerify");
         new MyFacilityPage(driver).ClickOnUploadButtonandVerify();
         Thread.sleep(1000);
       
       
        logInfo.pass("ClickOnUploadButtonandVerify");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Click EnterDepartmentManually$")
public void click_EnterDepartmentManually() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Click EnterDepartmentManually");
         new MyFacilityPage(driver).EnterDepartmentManually();
         Thread.sleep(1000);
       
       
        logInfo.pass("Click EnterDepartmentManually");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}


@Then("^Click OnAddDepartmentContact$")
public void click_OnAddDepartmentContact() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Click OnAddDepartmentContact");
         new MyFacilityPage(driver).ClickOnaddDepatmentContact();
         Thread.sleep(1000);
       
       
        logInfo.pass("Click OnAddDepartmentContact");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickOnAddFacilityContact$")
public void clickonaddfacilitycontact() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnAddFacilityContact");
         new MyFacilityPage(driver).ClickOnAddFacilityContact();
         Thread.sleep(1000);
       
       
        logInfo.pass("ClickOnAddFacilityContact");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^SelectFacilityandsearch as \"([^\"]*)\"$")
public void selectfacilityandsearch_as(String arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"SelectFacilityandsearch");
         new MyFacilityPage(driver).SelectFacilityandsearch(arg1);
         Thread.sleep(1000);
       
       
        logInfo.pass("SelectFacilityandsearch");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickOnRadiobuttonAndSelectFacilityContact$")
public void clickonradiobuttonandselectfacilitycontact() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnRadiobuttonAndSelectFacilityContact");
         new MyFacilityPage(driver).ClickOnRadiobuttonAndSelectFacilityContact();
         Thread.sleep(1000);
       
       
        logInfo.pass("ClickOnRadiobuttonAndSelectFacilityContact");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^SelectRoleFromFacilityContact$")
public void selectrolefromfacilitycontact() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"SelectRoleFromFacilityContact");
         new MyFacilityPage(driver).SelectRoleFromFacilityContact();
         Thread.sleep(1000);
       
       
        logInfo.pass("SelectRoleFromFacilityContact");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^SelectSaveUnderFacilityContact$")
public void selectsaveunderfacilitycontact() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"SelectSaveUnderFacilityContact");
         new MyFacilityPage(driver).SelectSaveUnderFacilityContact();
         Thread.sleep(1000);
       
       
        logInfo.pass("SelectSaveUnderFacilityContact");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^EnterEmailAddressToSearch as \"([^\"]*)\"$")
public void enteremailaddresstosearch_as(String arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"EnterEmailAddressToSearch");
         new MyFacilityPage(driver).EnterEmailAddressToSearch(arg1);
         Thread.sleep(1000);
       
       
        logInfo.pass("EnterEmailAddressToSearch");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickOnClearSearch$")
public void clickonclearsearch() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnClearSearch");
         new MyFacilityPage(driver).ClickOnClearSearch();
         Thread.sleep(1000);
       
       
        logInfo.pass("ClickOnClearSearch");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickOnDepartmentContactSearch$")
public void clickondepartmentcontactsearch() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnDepartmentContactSearch");
         new MyFacilityPage(driver).ClickOnDepartmentContactSearch();
         Thread.sleep(1000);
       
       
        logInfo.pass("ClickOnDepartmentContactSearch");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}


@Then("^SelectSiteUserForDepartmentContact With \"([^\"]*)\"$")
public void selectsiteuserfordepartmentcontact_With(String arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"SelectSiteUserForDepartmentContact With");
         new MyFacilityPage(driver).SelectSiteUserForDepartmentContact(arg1);
         Thread.sleep(1000);
       
       
        logInfo.pass("SelectSiteUserForDepartmentContact With");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}
//@Then("^ClickOnEditOfSiteUser(\\d+)$")
//public void clickoneditofsiteuser(int arg1) throws Throwable {
//	ExtentTest logInfo = null;
//    try {
//       
//   
//        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnEditOfSiteUser");
//         new MyFacilityPage(driver).ClickOnEditOfSiteUser(arg1);
//         Thread.sleep(1000);
//       
//       
//        logInfo.pass("ClickOnEditOfSiteUser");
//        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
//    } catch (AssertionError | Exception e){
//        testStepHandle("FAIL",driver,logInfo,e);
//    }
//}
@Then("^ClickOnEditOfSiteUser with \"([^\"]*)\" Email Id$")
public void clickoneditofsiteuser_with_Email_Id(String arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnEditOfSiteUser");
         new MyFacilityPage(driver).ClickOnEditOfSiteUser(arg1);
         Thread.sleep(1000);
       
       
        logInfo.pass("ClickOnEditOfSiteUser");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}
@Then("^VerifyFacilityDepartmentContact with \"([^\"]*)\"$")
public void verifyfacilitydepartmentcontact_with(String arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"VerifyFacilityDepartmentContact");
         new MyFacilityPage(driver).VerifyFacilityDepartmentContact(arg1);
         Thread.sleep(1000);
       
       
        logInfo.pass("VerifyFacilityDepartmentContact");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickOnCancelUnderEditDepartmentRole$")
public void clickoncancelundereditdepartmentrole() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnCancelUnderEditDepartmentRole");
         new MyFacilityPage(driver).ClickOnCancelUnderEditDepartmentRole();
         Thread.sleep(1000);
       
       
        logInfo.pass("ClickOnCancelUnderEditDepartmentRole");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickonSaveUnderEditDepartmentRole$")
public void clickonsaveundereditdepartmentrole() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickonSaveUnderEditDepartmentRole");
         new MyFacilityPage(driver).ClickonSaveUnderEditDepartmentRole();
         Thread.sleep(1000);
       
       
        logInfo.pass("ClickonSaveUnderEditDepartmentRole");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}
@Then("^selectDPMrole$")
public void selectDPMrolerole() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"selectDPMrole");
         new MyFacilityPage(driver).selectDPMrole();
         Thread.sleep(1000);
       
       
        logInfo.pass("selectDPMrole");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^SelectBudget/FinancialContact$")
public void selectbudget_FinancialContact() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"SelectBudget/FinancialContact");
         new MyFacilityPage(driver).SelectBudgetFinancialContact();
         Thread.sleep(1000);
       
       
        logInfo.pass("SelectBudget/FinancialContact");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^DeselectDPMroleAndSelectContractManager$")
public void DeselectDPMroleAndSelectContractManager() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"DeselectDPMroleAndSelectContractManager");
         new MyFacilityPage(driver).DeselectDPMroleAndSelectContractManager();
         Thread.sleep(1000);
       
       
        logInfo.pass("DeselectDPMroleAndSelectContractManager");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickOnFlagOfSiteUserThree$")
public void ClickOnFlagOfSiteUserThree() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnFlagOfSiteUserThree");
         new MyFacilityPage(driver).ClickOnFlagOfSiteUserThree();
         Thread.sleep(1000);
       
       
        logInfo.pass("ClickOnFlagOfSiteUserThree");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}
@Then("^VerifyTherapeuticAreasAndClickDepartmentContact$")
public void verifytherapeuticareasandclickdepartmentcontact() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"VerifyTherapeuticAreasAndClickDepartmentContact");
         new MyFacilityPage(driver).VerifyTherapeuticAreasAndClickDepartmentContact();
         Thread.sleep(1000);
       
       
        logInfo.pass("VerifyTherapeuticAreasAndClickDepartmentContact");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }  
}

@Then("^ClickOnSendRegistrationInvite$")
public void clickonsendregistrationinvite() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnSendRegistrationInvite");
         new MyFacilityPage(driver).ClickOnSendRegistrationInvite();
         Thread.sleep(1000);
       
       
        logInfo.pass("ClickOnSendRegistrationInvite");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickOKForConfirmation$")
public void clickokforconfirmation() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOKForConfirmation");
         new MyFacilityPage(driver).ClickOKForConfirmation();
         Thread.sleep(1000);
       
       
        logInfo.pass("ClickOKForConfirmation");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClicKOKonWarning$")
public void ClicKOKonWarning() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClicKOKonWarning");
         new MyFacilityPage(driver).ClicKOKonWarning();
         Thread.sleep(1000);
       
       
        logInfo.pass("ClicKOKonWarning");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClicKOK$")
public void ClicKOK() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClicKOK");
         new MyFacilityPage(driver).ClicKOK();
         Thread.sleep(1000);
       
       
        logInfo.pass("ClicKOK");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}


@Then("^VerifySendRegistrationInvite$")
public void verifysendregistrationinvite() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"VerifySendRegistrationInvite");
         new MyFacilityPage(driver).VerifySendRegistrationInvite();
         Thread.sleep(1000);
       
       
        logInfo.pass("VerifySendRegistrationInvite");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickOnCancelNewRegistration$")
public void clickoncancelnewregistration() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnCancelNewRegistration");
         new MyFacilityPage(driver).ClickOnCancelNewRegistration();
         Thread.sleep(1000);
       
       
        logInfo.pass("ClickOnCancelNewRegistration");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickOnCancelFordepartmentContact$")
public void clickoncancelfordepartmentcontact() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnCancelFordepartmentContact");
         new MyFacilityPage(driver).ClickOnCancelFordepartmentContact();
         Thread.sleep(1000);
       
       
        logInfo.pass("ClickOnCancelFordepartmentContact");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}


@Then("^NavigatetoIRBLocalIRBandverify$")
public void NavigatetoIRBLocalIRBandverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"NavigatetoIRBLocalIRBandverify");
            new MyFacilityPage(driver).NavigatetoIRBLocalIRBandverify();
            Thread.sleep(1000);
          
           logInfo.pass("Fields are displayed in non editable mode.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}



@Then("^NavigatetoMyfacility$")
public void NavigatetoMyfacility() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"NavigatetoMyfacility");
            new MyFacilityPage(driver).NavigatetoMyfacility();
            Thread.sleep(1000);
          
           logInfo.pass("User navigated to My Facility.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^Switch Frame And Navigate To Facility Contacts$")
public void SwitchFrameAndNavigateToFacilityContacts() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Switch Frame And Navigate To Facility Contacts");
            new MyOrganizationPage(driver).SwitchFrameAndNavigateToFacilityContacts();
            Thread.sleep(5000);
          
           logInfo.pass("Switch Frame And Navigate To Facility Contacts");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^Switch Frame And Navigate To Department Contacts$")
public void SwitchFrameAndNavigateToDepartment_Contact() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Switch Frame And Navigate To Department Contacts");
            new MyOrganizationPage(driver).SwitchFrameAndNavigateToDepartment_Contact();
            Thread.sleep(5000);
          
           logInfo.pass("Switch Frame And Navigate To Department Contacts");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}


@Then("^Click On Facility Contact Tab$")
public void NavigateToFacilityContacts() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Facility Contact Tab");
            new MyOrganizationPage(driver).NavigateToFacilityContacts();
            Thread.sleep(5000);
          
           logInfo.pass("Click On Facility Contact Tab");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^Verify Department Contacts Screen Is Displayed$")
public void Verify_Department_Contact_Screen_Displayed() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Department Contacts Screen Is Displayed");
            new MyOrganizationPage(driver).Verify_Department_Contact_Screen_Displayed();
            Thread.sleep(1000);
          
           logInfo.pass("Verify Department Contacts Screen Is Displayed");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^Click On Department Contact Tab$")
public void NavigateTodepartmentContacts() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Department Contact Tab");
            new MyOrganizationPage(driver).NavigateTodepartmentContacts();
            Thread.sleep(5000);
          
           logInfo.pass("Click On Department Contact Tab");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^Verify Facility Contacts Screen Is Displayed$")
public void Verify_Facility_Contact_Screen_Displayed() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility Contacts Screen Is Displayed");
            new MyOrganizationPage(driver).Verify_Facility_Contact_Screen_Displayed();
            Thread.sleep(1000);
          
           logInfo.pass("Verify Facility Contacts Screen Is Displayed");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^Click On Organization Contacts Tab$")
public void ClickOnOrganization_Contacts() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Organization Contacts Tab");
            new MyOrganizationPage(driver).ClickOnOrganization_Contacts();
            Thread.sleep(10000);
          
           logInfo.pass("Click On Organization Contacts Tab");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^Click On Add Organization Contacts Button In Organization Contacts Screen$")
public void ClickOnAddOrgContactBtn() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Add Organization Contacts Button In Organization Contacts Screen");
            new MyOrganizationPage(driver).ClickOnAddOrgContactBtn();
            Thread.sleep(10000);
          
           logInfo.pass("Click On Add Organization Contacts Button In Organization Contacts Screen");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^Set Site User (\\d+) Email ID In Organization Contact Email Address Section$")
public void set_Site_User_Email_ID_In_Organization_Contact_Email_Address_Section(int arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Set Site User "+arg1+" Email ID In Organization Contact Email Address Section");
         new MyOrganizationPage(driver).SetEmailInOrgEmailAddress(arg1);
         Thread.sleep(4000);
       
        logInfo.pass("Set Site User "+arg1+" Email ID In Organization Contact Email Address Section");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }

}

@Then("^Select ORGANIZATION CONTACT ROLES As \"([^\"]*)\"$")
public void select_ORGANIZATION_CONTACT_ROLES_As(String arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Select ORGANIZATION CONTACT ROLES As "+arg1);
         new MyOrganizationPage(driver).select_ORGANIZATION_CONTACT_ROLES_As(arg1);
         Thread.sleep(4000);
       
        logInfo.pass("Select ORGANIZATION CONTACT ROLES As "+arg1);
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }

}

@Then("^Click On Add Button In Add Organization Contact Screen$")
public void ClickOnAddOrgContactInnerButton() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Add Button In Add Organization Contact Screen");
            new MyOrganizationPage(driver).ClickOnAddOrgContactInnerButton();
            Thread.sleep(10000);
          
           logInfo.pass("Click On Add Button In Add Organization Contact Screen");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^Verify Site User (\\d+) Is added as \"([^\"]*)\"$")
public void verify_Site_User_Is_added_as(int arg1, String arg2) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" Is added as "+arg2);
         new MyOrganizationPage(driver).verify_Site_User_Is_added_as(arg1,arg2);
         Thread.sleep(1000);
       
        logInfo.pass("Verify Site User "+arg1+" Is added as "+arg2);
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }

}

@Then("^Click On Remove icon Against Site User (\\d+) having Role as \"([^\"]*)\"$")
public void click_On_Remove_icon_Against_Site_User_having_Role_as(int arg1, String arg2) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Remove icon Against Site User "+arg1+" having Role as "+arg2);
         new MyOrganizationPage(driver).click_On_Remove_icon_Against_Site_User_having_Role_as(arg1,arg2);
         Thread.sleep(10000);
       
        logInfo.pass("Click On Remove icon Against Site User "+arg1+" having Role as "+arg2);
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }

}

@Then("^Click On OK button In Remove Organization Contact PopUp$")
public void ClickOnRemoveOrgContactBtn() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Click On OK button In Remove Organization Contact PopUp");
            new MyOrganizationPage(driver).ClickOnRemoveOrgContactBtn();
            Thread.sleep(10000);
          
           logInfo.pass("Click On OK button In Remove Organization Contact PopUp");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^Verify Site User (\\d+) Is Not Added As \"([^\"]*)\"$")
public void verify_Site_User_Is_Not_Added_As(int arg1, String arg2) throws Throwable {

    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" Is Not Added As "+arg2);
            new MyOrganizationPage(driver).verify_Site_User_Is_Not_Displayed_(arg1,arg2);
            Thread.sleep(10000);
          
           logInfo.pass("Verify Site User "+arg1+" Is Not Added As "+arg2);
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}


@Then("^Update Role Of Site User (\\d+) From \"([^\"]*)\" To \"([^\"]*)\" Keeping Previous Role$")
public void update_Role_Of_Site_User_From_To_Keeping_Previous_Role(int arg1, String arg2, String arg3) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Update Role Of Site User "+arg1+" From "+arg2+" To "+arg3+" Keeping Previous Role");
         new MyOrganizationPage(driver).update_Role_Of_Site_User_From_To_Keeping_Previous_Role(arg1,arg2,arg3);
         Thread.sleep(10000);
       
        logInfo.pass("Update Role Of Site User "+arg1+" From "+arg2+" To "+arg3+" Keeping Previous Role");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }

}

@Then("^Select Role As \"([^\"]*)\" From Add Facility Roles PopUp$")
public void select_Role_As_From_Add_Facility_Roles_PopUp(String arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Select Role As "+arg1+" From Add Facility Roles PopUp");
         new MyOrganizationPage(driver).select_Role_As_From_Add_Facility_Roles_PopUp(arg1);
         Thread.sleep(10000);
       
        logInfo.pass("Select Role As "+arg1+" From Add Facility Roles PopUp");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }

}

@Then("^Click On OK Button In Remove Facility Contact PopUp$")
public void ClickOnOKButtonInRemoveFacilityContactPopUp() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Click On OK Button In Remove Facility Contact PopUp");
            new MyOrganizationPage(driver).ClickOnOKButtonInRemoveFacilityContactPopUp();
            Thread.sleep(6000);
          
           logInfo.pass("Click On OK Button In Remove Facility Contact PopUp");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^Verify Site (\\d+) Is Not Present In Facility Contacts Screen$")
public void verify_Site_Is_Not_Present_In_Facility_Contacts_Screen(int arg1) throws Throwable {

    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site "+arg1+" Is Not Present In Facility Contacts Screen");
            new MyOrganizationPage(driver).verify_Site_Is_Not_Present_In_Facility_Contacts_Screen(arg1);
            Thread.sleep(2000);
          
           logInfo.pass("Verify Site "+arg1+" Is Not Present In Facility Contacts Screen");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^Verify Site User (\\d+) Is Added As \"([^\"]*)\" In Facility Contacts Screen$")
public void verify_Site_User_Is_Added_As_In_Facility_Contacts_Sreen(int arg1, String arg2) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" Is Added As "+arg2+" In Facility Contacts Sreen");
         new MyOrganizationPage(driver).verify_Site_User_Is_Added_As_In_Facility_Contacts_Sreen(arg1,arg2);
         Thread.sleep(10000);
       
        logInfo.pass("Verify Site User "+arg1+" Is Added As "+arg2+" In Facility Contacts Sreen");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }

}

@Then("^Click On Remove Against Site User (\\d+) In Facility Contacts Screen$")
public void click_On_Remove_Against_Site_User_In_Facility_Contacts_Sreen(int arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Remove Against Site User "+arg1+" In Facility Contacts Screen");
         new MyOrganizationPage(driver).click_On_Remove_Against_Site_User_In_Facility_Contacts_Sreen(arg1);
         Thread.sleep(10000);
       
        logInfo.pass("Click On Remove Against Site User "+arg1+" In Facility Contacts Screen");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }

}

@Then("^Verify Site User (\\d+) Role Has been Updated To \"([^\"]*)\" And \"([^\"]*)\"$")
public void verify_Site_User_Role_Has_been_Updated_To_And(int SU_No, String Role1, String Role2) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+SU_No+" Role Has been Updated To "+Role1+" And "+Role2);
         new MyOrganizationPage(driver).verify_Site_User_Role_Has_been_Updated_To_And(SU_No,Role1,Role2);
         Thread.sleep(1000);
       
        logInfo.pass("Verify Site User "+SU_No+" Role Has been Updated To "+Role1+" And "+Role2);
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }

}
@Then("^Verify Add Department Contact Button Is Displayed$")
public void Verify_AddDepartmentContact_button() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Add Department Contact Button Is Displayed");
            new MyOrganizationPage(driver).Verify_AddDepartmentContact_button();
            Thread.sleep(1000);
          
           logInfo.pass("Verify Add Department Contact Button Is Displayed");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^Click On Add Department Contact Button Is Displayed In Department Contacts$")
public void Click_AddDepartmentContact_button() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Add Department Contact Button Is Displayed In Department Contacts");
            new MyOrganizationPage(driver).Click_AddDepartmentContact_button();
            Thread.sleep(10000);
          
           logInfo.pass("Click On Add Department Contact Button Is Displayed In Department Contacts");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^Verify Add Facility Contact Button Is Displayed In Facility Contacts$")
public void Verify_Add_Facility_Contact_button() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Add Facility Contact Button Is Displayed In Facility Contacts");
            new MyOrganizationPage(driver).Verify_Add_Facility_Contact_button();
            Thread.sleep(1000);
          
           logInfo.pass("Verify Add Facility Contact Button Is Displayed In Facility Contacts");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^Click On Add Facility Contact Button Is Displayed In Facility Contacts$")
public void Click_Add_Facility_Contact_button() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Add Facility Contact Button Is Displayed In Facility Contacts");
            new MyOrganizationPage(driver).Click_Add_Facility_Contact_button();
            Thread.sleep(10000);
          
           logInfo.pass("Click On Add Facility Contact Button Is Displayed In Facility Contacts");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^Select Facility (\\d+) In Facility Name In Search For Facility/Department Contact Section$")
public void select_Facility_In_Facility_Name_In_Search_For_Facility_Department_Contact_Section(int arg1) throws Throwable {

    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Select Facility "+arg1+" In Facility Name In Search For Facility/Department Contact Section");
            new MyOrganizationPage(driver).select_Facility_In_Facility_Name_In_Search_For_Facility_Department_Contact_Section(arg1);
            Thread.sleep(4000);
          
           logInfo.pass("Select Facility "+arg1+" In Facility Name In Search For Facility/Department Contact Section");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^Select Department (\\d+) of Facility (\\d+) In Department Name In Search For Facility/Department Contact Section$")
public void select_Department_of_Facility_In_Department_Name_In_Search_For_Facility_Department_Contact_Section(int dept, int fac) throws Throwable {
	  ExtentTest logInfo = null;
      try {
         
     
          logInfo = test.createNode(new GherkinKeyword("Then"),"Select Department "+dept+" of Facility "+fac+" In Department Name In Search For Facility/Department Contact Section");
           new MyOrganizationPage(driver).select_Department_of_Facility_In_Department_Name_In_Search_For_Facility_Department_Contact_Section(dept,fac);
           Thread.sleep(4000);
         
          logInfo.pass("Select Department "+dept+" of Facility "+fac+" In Department Name In Search For Facility/Department Contact Section");
          logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
      } catch (AssertionError | Exception e){
          testStepHandle("FAIL",driver,logInfo,e);
      }

}

@Then("^Click On SEARCH button In Search For Facility/Department Contact Section$")
public void ClickOnSEARCHbuttonInSearchForFacilityDepartmentContactSection() throws Throwable {

    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Click On SEARCH button In Search For Facility/Department Contact Section");
            new MyOrganizationPage(driver).ClickOnSEARCHbuttonInSearchForFacilityDepartmentContactSection();
            Thread.sleep(10000);
          
           logInfo.pass("Click On SEARCH button In Search For Facility/Department Contact Section");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}


@Then("^Verify Site User (\\d+) Displayed In Site User Search Results Table$")
public void verify_Site_User_Displayed_In_Site_User_Search_Results_Table(int arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" Displayed In Site User Search Results Table");
         new MyOrganizationPage(driver).verify_Site_User_Displayed_In_Site_User_Search_Results_Table(arg1);
         Thread.sleep(1000);
       
        logInfo.pass("Verify Site User "+arg1+" Displayed In Site User Search Results Table");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }

}

@Then("^Select Site User (\\d+) From Site User Search Results Table$")
public void Click_Site_User_Displayed_In_Site_User_Search_Results_Table(int arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Select Site User "+arg1+" From Site User Search Results Table");
         new MyOrganizationPage(driver).Click_Site_User_Displayed_In_Site_User_Search_Results_Table(arg1);
         Thread.sleep(1000);
       
        logInfo.pass("Select Site User "+arg1+" From Site User Search Results Table");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }

}

@Then("^Click On Select Facility Contact Button$")
public void click_On_Select_Facility_Contact_Button() throws Throwable {
	    ExtentTest logInfo = null;
	       try {
	          
	      
	           logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Select Facility Contact Button");
	            new MyOrganizationPage(driver).Click_Select_Facility_Contact_Btn();
	            Thread.sleep(10000);
	          
	           logInfo.pass("Click On Select Facility Contact Button");
	           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
	       } catch (AssertionError | Exception e){
	           testStepHandle("FAIL",driver,logInfo,e);
	       }

	}

@Then("^Click On Select Department Contact Button$")
public void Click_Select_Department_Contact_Btn() throws Throwable {
	    ExtentTest logInfo = null;
	       try {
	          
	      
	           logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Select Department Contact Button");
	            new MyOrganizationPage(driver).Click_Select_Department_Contact_Btn();
	            Thread.sleep(10000);
	          
	           logInfo.pass("Click On Select Department Contact Button");
	           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
	       } catch (AssertionError | Exception e){
	           testStepHandle("FAIL",driver,logInfo,e);
	       }

	}

@Then("^Set Site User (\\d+) In Email Address Text Field$")
public void set_Site_User_In_Email_Address_Text_Field(int arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Set Site User "+arg1+" In Email Address Text Field");
         new MyOrganizationPage(driver).set_Site_User_In_Email_Address_Text_Field(arg1);
         Thread.sleep(1000);
       
        logInfo.pass("Set Site User "+arg1+" In Email Address Text Field");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }

}

@Then("^Click On \"([^\"]*)\" Role In Add Department Roles For PopUp$")
public void click_On_Role_In_Add_Department_Roles_For_PopUp(String arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Click On "+arg1+" Role In Add Department Roles For PopUp");
         new MyOrganizationPage(driver).click_On_Role_In_Add_Department_Roles_For_PopUp(arg1);
         Thread.sleep(1000);
       
        logInfo.pass("Click On "+arg1+" Role In Add Department Roles For PopUp");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }

}

@Then("^Click On Search Button For Facility Contact$")
public void click() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Search Button For Facility Contact");
         new MyOrganizationPage(driver).click_facSearch();
         Thread.sleep(5000);
       
        logInfo.pass("Click On Search Button For Facility Contact");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }

}

@Then("^Click On Expand Button For Search For Facility/Department Contact Section$")
public void ClickOnExpandButtonForSearchForFacilityDepartmentContactSection() throws Throwable {

    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Expand Button For Search For Facility/Department Contact Section");
            new MyOrganizationPage(driver).ClickOnExpandButtonForSearchForFacilityDepartmentContactSection();
            Thread.sleep(5000);
          
           logInfo.pass("Click On Expand Button For Search For Facility/Department Contact Section");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^Click On Clear Search Button In Search For Facility/Department Contact Section$")
public void ClickOnClearSearchButtonInSearchForFacilityDepartmentContactSection() throws Throwable {

    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Clear Search Button In Search For Facility/Department Contact Section");
            new MyOrganizationPage(driver).ClickOnClearSearchButtonInSearchForFacilityDepartmentContactSection();
            Thread.sleep(3000);
          
           logInfo.pass("Click On Clear Search Button In Search For Facility/Department Contact Section");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^Verify Site User Is Not Able to Remove Delegation Manager$")
public void VerifySiteUserIsNotAbleToRemoveDelegationManager() throws Throwable {

    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User Is Not Able to Remove Delegation Manager");
            new MyOrganizationPage(driver).VerifySiteUserIsNotAbleToRemoveDelegationManager();
            Thread.sleep(5000);
          
           logInfo.pass("Verify Site User Is Not Able to Remove Delegation Manager");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}


@Then("^NavigateToParentWindowCloseChildWindow$")
public void NavigateToParentWindowAndCloseChildWindow() throws Throwable {

    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"NavigateToParentWindowCloseChildWindow");
            new MyOrganizationPage(driver).NavigateToParentWindowAndCloseChildWindow();
            Thread.sleep(5000);
          
           logInfo.pass("NavigateToParentWindowCloseChildWindow");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^Verify Facility (\\d+) Is Displayed In Facilities Screen$")
public void verify_Facility_Is_Displayed_In_Facilities_Screen(int arg1) throws Throwable {

    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility "+arg1+" Is Displayed In Facilities Screen");
            new MyOrganizationPage(driver).verify_Facility_Is_Displayed_In_Facilities_Screen(arg1);
            Thread.sleep(1000);
          
           logInfo.pass("Verify Facility "+arg1+" Is Displayed In Facilities Screen");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^Click On Facility (\\d+) Displayed In Facilities Screen$")
public void click_On_Facility_Displayed_In_Facilities_Screen(int arg1) throws Throwable {

    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Facility "+arg1+" Displayed In Facilities Screen");
            new MyOrganizationPage(driver).click_On_facility_Displayed_In_Facilities_Screen(arg1);
            Thread.sleep(10000);
          
           logInfo.pass("Click On Facility "+arg1+" Displayed In Facilities Screen");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^Click On Add Department Option From Action icon For Facility (\\d+)$")
public void click_On_Add_Department_Option_From_Action_icon_For_Facility(int arg1) throws Throwable {

    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Add Department Option From Action icon For Facility "+arg1);
            new MyOrganizationPage(driver).ClickOnAddDepartmentOptionFromActionIconForFacility(arg1);
            Thread.sleep(15000);
          
           logInfo.pass("Click On Add Department Option From Action icon For Facility "+arg1);
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^Verify CREATE NEW DEPARTMENT Button Is Disabled$")
public void VerifyCREATENEWDEPARTMENTButtonIsDisabled() throws Throwable {

    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verify CREATE NEW DEPARTMENT Button Is Disabled");
            new MyOrganizationPage(driver).VerifyCREATENEWDEPARTMENTButtonIsDisabled();
            Thread.sleep(1000);
          
           logInfo.pass("Verify CREATE NEW DEPARTMENT Button Is Disabled");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^Verify CREATE NEW DEPARTMENT Button Is Enabled$")
public void VerifyCREATENEWDEPARTMENTButtonIsEnabled() throws Throwable {

    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verify CREATE NEW DEPARTMENT Button Is Enabled");
            new MyOrganizationPage(driver).VerifyCREATENEWDEPARTMENTButtonIsEnabled();
            Thread.sleep(1000);
          
           logInfo.pass("Verify CREATE NEW DEPARTMENT Button Is Enabled");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^Click On CREATE NEW DEPARTMENT Button$")
public void ClickOnCREATENEWDEPARTMENTButton() throws Throwable {

    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Click On CREATE NEW DEPARTMENT Button");
            new MyOrganizationPage(driver).ClickOnCREATENEWDEPARTMENTButton();
            Thread.sleep(10000);
          
           logInfo.pass("Click On CREATE NEW DEPARTMENT Button");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^ClickOnAddFacilityAndVerifyFacility$")
public void clickonaddfacilityandverifyfacility() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnAddFacilityAndVerifyFacility");
         new MyFacilityPage(driver).ClickOnAddFacilityandVerify();
         Thread.sleep(1000);
       
        logInfo.pass("ClickOnAddFacilityAndVerifyFacility");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}


@Then("^NavigatetoIRBERB$")
public void NavigatetoIRBERB() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"NavigatetoIRBERB");
            new MyFacilityPage(driver).NavigatetoIRBERB();
            Thread.sleep(1000);
          
           logInfo.pass("User navigated to Local IRB/ERB/Ethics screen.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}
@Then("^NavigatetoLocalIRBCommitte$")
public void navigatetolocalirbcommitte() throws Throwable {
	 ExtentTest logInfo = null;
     try {
        
    
         logInfo = test.createNode(new GherkinKeyword("Then"),"NavigatetoIRBERB");
          new MyFacilityPage(driver).NevigateToLocalIRB();
          Thread.sleep(1000);
        
         logInfo.pass("User navigated to Local IRB/ERB/Ethics screen.");
         logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
     } catch (AssertionError | Exception e){
         testStepHandle("FAIL",driver,logInfo,e);
     }
}

@Then("^EnterLocalIRBCommitteWithoutName$")
public void enterlocalirbcommittewithoutname() throws Throwable {
	 ExtentTest logInfo = null;
     try {
        
    
         logInfo = test.createNode(new GherkinKeyword("Then"),"EnterLocalIRBCommitteWithoutName");
          new MyFacilityPage(driver).EnterLocalIRBdetailsWithoutName();
          Thread.sleep(1000);
        
         logInfo.pass("EnterLocalIRBCommitteWithoutName.");
         logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
     } catch (AssertionError | Exception e){
         testStepHandle("FAIL",driver,logInfo,e);
     }
}

@Then("^Click On \"([^\"]*)\" Role In Add Facility Roles For PopUp$")
public void click_On_Role_In_Add_Facility_Roles_For_PopUp(String arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Click On "+arg1+" Role In Add Facility Roles For PopUp");
         new MyOrganizationPage(driver).click_On_Role_In_Add_Facility_Roles_For_PopUp(arg1);
         Thread.sleep(1000);
       
        logInfo.pass("Click On "+arg1+" Role In Add Facility Roles For PopUp");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Click On Save Button In Add Facility Roles For PopUp$")
public void click_SaveButtonInAddFacilityRolesForPopUp() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Save Button In Add Facility Roles For PopUp");
         new MyOrganizationPage(driver).click_SaveButtonInAddFacilityRolesForPopUp();
         Thread.sleep(1000);
       
        logInfo.pass("Click On Save Button In Add Facility Roles For PopUp");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Click_Site_Administrator_Popup_action_confirm_Button$")
public void Click_Site_Administrator_Popup_action_confirm_Button() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Click_Site_Administrator_Popup_action_confirm_Button");
         new MyOrganizationPage(driver).Click_Site_Administrator_Popup_action_confirm_Button();
         Thread.sleep(10000);
       
        logInfo.pass("Click_Site_Administrator_Popup_action_confirm_Button");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Verify Site User (\\d+) Is Added In Facility Contacts Table$")
public void verify_Site_User_Is_Added_In_Facility_Contacts_Table(int arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" Is Added In Facility Contacts Table");
         new MyOrganizationPage(driver).verify_Site_User_Is_Added_In_Facility_Contacts_Table(arg1);
         Thread.sleep(1000);
       
        logInfo.pass("Verify Site User "+arg1+" Is Added In Facility Contacts Table");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Verify Site User (\\d+) Is Added In Department Contacts Table$")
public void verify_Site_User_Is_Added_In_Department_Contacts_Table(int arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" Is Added In Department Contacts Table");
         new MyOrganizationPage(driver).verify_Site_User_Is_Added_In_Department_Contacts_Table(arg1);
         Thread.sleep(1000);
       
        logInfo.pass("Verify Site User "+arg1+" Is Added In Department Contacts Table");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^EnterLocalIRBCommitteDetails$")
public void enterlocalirbcommittedetails() throws Throwable {
	 ExtentTest logInfo = null;
     try {
        
    
         logInfo = test.createNode(new GherkinKeyword("Then"),"EnterLocalIRBCommitteDetails");
          new MyFacilityPage(driver).EnterLocalIRBdetailsWithName();
          Thread.sleep(1000);
         logInfo.pass("EnterLocalIRBCommitteDetails");
         logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
         new MyFacilityPage(driver).ReturntoPreviousPage();
     } catch (AssertionError | Exception e){
         testStepHandle("FAIL",driver,logInfo,e);
     }
}


@Then("^Enterrestinfo$")
public void Enterrestinfo() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Enterrestinfo");
            new MyFacilityPage(driver).Enterrestinfo();
            Thread.sleep(1000);
          
           logInfo.pass("Verify help text option available.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}


@Then("^Enterregistrationnamesave$")
public void Enterregistrationnamesave() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Enterregistrationnamesave");
            new MyFacilityPage(driver).Enterregistrationnamesave();
            Thread.sleep(1000);
          
           logInfo.pass("pop up is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}


@Then("^Enternameandsave$")
public void Enternameandsave() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Enternameandsave");
            new MyFacilityPage(driver).Enternameandsave();
            Thread.sleep(1000);
          
           logInfo.pass("Local IRB saved successfulyy.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}




@Then("^Generatereportverify$")
public void Generatereportverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Generatereportverify");
            new MyFacilityPage(driver).Generatereportverify();
            Thread.sleep(1000);
          
           logInfo.pass("Details of Site user 2 and 3 are displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}



@Then("^removeedelegation$")
public void removeedelegation() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"removeedelegation");
            new MyFacilityPage(driver).removeedelegation();
            Thread.sleep(1000);
          
           logInfo.pass("Delegation of site user 2 is removed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}



@Then("^Generatereportverify1$")
public void Generatereportverify1() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Generatereportverify1");
            new MyFacilityPage(driver).Generatereportverify1();
            Thread.sleep(1000);
          
           logInfo.pass("Site user 3 generated but site user 2 details not displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^Verifysubmenus$")
public void Verifysubmenus() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verifysubmenus");
            new MyProfilePage(driver).Verifysubmenus();
            Thread.sleep(1000);
          
           logInfo.pass("My Profile & Pull cv submenus are displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^Navigatetomyprofileandverify$")
public void Navigatetomyprofileandverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Navigatetomyprofileandverify");
            new MyProfilePage(driver).Navigatetomyprofileandverify();
            Thread.sleep(1000);
          
           logInfo.pass("Profile page is displayed with mentiond details.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}


@Then("^clickonprofileplaceholderverify$")
public void clickonprofileplaceholderverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickonprofileplaceholderverify");
            new MyProfilePage(driver).clickonprofileplaceholderverify();
            Thread.sleep(1000);
          
           logInfo.pass("upload profile photo displayed with mentiond details.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}


@Then("^selectexceedingimageverify$")
public void selectexceedingimageverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"selectexceedingimageverify");
            new MyProfilePage(driver).selectexceedingimageverify();
            Thread.sleep(1000);
          
           logInfo.pass("picture not uploaded and displayed in profile placeholder.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}


@Then("^clickprofileplaceholderandverify$")
public void clickprofileplaceholderandverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickprofileplaceholderandverify");
            new MyProfilePage(driver).clickprofileplaceholderandverify();
            Thread.sleep(1000);
          
           logInfo.pass("picture uploaded and mentioned fields are displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}


@Then("^verifyroleassignedtocro1$")
public void verifyroleassignedtocro1() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyroleassignedtocro1");
            new MyProfilePage(driver).verifyroleassignedtocro1();
            Thread.sleep(1000);
          
           logInfo.pass("CRO 1 user with role is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}


@Then("^verifyshowrowdropdown$")
public void verifyshowrowdropdown() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyshowrowdropdown");
            new MyProfilePage(driver).verifyshowrowdropdown();
            Thread.sleep(1000);
          
           logInfo.pass("user is able to select 10/20/30/40/50 row per page.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}


@Then("^verifystandardpagination$")
public void verifystandardpagination() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifystandardpagination");
            new MyProfilePage(driver).verifystandardpagination();
            Thread.sleep(1000);
          
           logInfo.pass("Standard pagination features available.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^enterpagenumberverify$")
public void enterpagenumberverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"enterpagenumberverify");
            new MyProfilePage(driver).enterpagenumberverify();
            Thread.sleep(1000);
          
           logInfo.pass("enter page numnber and check data.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}



@Then("^verifypages$")
public void verifypages() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifypages");
            new MyProfilePage(driver).verifypages();
            Thread.sleep(1000);
          
           logInfo.pass("Next page,previous page,first page and last page displayed");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^Navigatetomyfacilityandverify$")
public void Navigatetomyfacilityandverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Navigatetomyfacilityandverify");
            new MyFacilityPage(driver).Navigatetomyfacilityandverify();
            Thread.sleep(1000);
          
           logInfo.pass("Facility 1 is displayed under facility name and address section.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}
@Then("^Edit Building Address By Special Character$")
public void edit_Building_Address_By_Special_Character() throws Throwable {
	  ExtentTest logInfo = null;
      try {
         
     
          logInfo = test.createNode(new GherkinKeyword("Then"),"Edit_Building_Address_By_Special_Character");
           new MyFacilityPage(driver).Edit_Building_Address_By_Special_Character();
           Thread.sleep(1000);
         
          logInfo.pass("Edit_Building_Address_By_Special_Character");
          logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
      } catch (AssertionError | Exception e){
          testStepHandle("FAIL",driver,logInfo,e);
      }
}


@Then("^PDFExport$")
public void PDFExport() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"PDFExport");
            new MyFacilityPage(driver).PDFExport();
            Thread.sleep(1000);
          
           logInfo.pass("User able to reciev a task of Department 1 in PDF format.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^verifytaskreceived$")
public void verifytaskreceived() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifytaskreceived");
            new MyFacilityPage(driver).verifytaskreceived();
            Thread.sleep(1000);
          
           logInfo.pass("Task received as department profile available for download.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}


@Then("^Clickondepartmentprofle$")
public void Clickondepartmentprofle() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Clickondepartmentprofle");
            new MyFacilityPage(driver).Clickondepartmentprofle();
            Thread.sleep(1000);
          
           logInfo.pass("download file field unded department contact.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^docExport$")
public void docExport() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"docExport");
            new MyFacilityPage(driver).docExport();
            Thread.sleep(1000);
          
           logInfo.pass("User able to reciev a task of Department 1 in Doc format.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^verifytaskreceived1$")
public void verifytaskreceived1() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifytaskreceived1");
            new MyFacilityPage(driver).verifytaskreceived1();
            Thread.sleep(1000);
          
           logInfo.pass("Task received as department profile available for download.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}


@Then("^NavigattoFacilities$")
public void NavigattoFacilities() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"NavigattoFacilities");
            new MyFacilityPage(driver).NavigattoFacilities();
            Thread.sleep(1000);
          
           logInfo.pass("User is navigated to facility screen.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}


@Then("^Previewabbriviatedcv$")
public void Previewabbriviatedcv() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Previewabbriviatedcv");
            new MyFacilityPage(driver).Previewabbriviatedcv();
            Thread.sleep(1000);
          
           logInfo.pass("User able to see the preview cv.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}
@Then("^Generatecv$")
public void Generatecv() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Generatecv");
            new MyFacilityPage(driver).Generatecv();
            Thread.sleep(1000);
          
           logInfo.pass("user able to view pop up with msg.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}


@Then("^Verifycvgenerated$")
public void Verifycvgenerated() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verifycvgenerated");
            new MyFacilityPage(driver).Verifycvgenerated();
            Thread.sleep(1000);
          
           logInfo.pass("User is able to view the generated cv containing the details.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^VerifyFacilityIdAndDepartmentId$")
public void verifyfacilityidanddepartmentid() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"VerifyFacilityIdAndDepartmentId");
         new MyFacilityPage(driver).VerifyFacilityIdAndDepartmentId();
         Thread.sleep(1000);
       
        logInfo.pass("VerifyFacilityIdAndDepartmentId");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }

}

@Then("^VerifyFacilityIdAndDepartmentId(\\d+)$")
public void verifyfacilityidanddepartmentid(int arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"VerifyFacility2IdAndDepartmentId");
         new MyFacilityPage(driver).VerifyFacility2IdAndDepartment2Id(arg1);
         Thread.sleep(1000);
       
        logInfo.pass("VerifyFacility2IdAndDepartmentId");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickOnAddfacility$")
public void ClickOnAddfacility() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Addfacility");
            new MyFacilityPage(driver).ClickOnAddfacility();
            Thread.sleep(1000);
          
           logInfo.pass("User is able to add facility");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^Addfacility$")
public void Addfacility() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Addfacility");
            new MyFacilityPage(driver).Addfacility();
            Thread.sleep(1000);
          
           logInfo.pass("User is able to add facility");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}



@Then("^Navigatetogeneratereportandverify$")
public void Navigatetogeneratereportandverify() throws Throwable {
   
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Navigatetogeneratereportandverify");
			 new SipApplicationLandingPage(driver).NevigateToGeneralReport();
			 Thread.sleep(1000);
			
			logInfo.pass("Navigatetogeneratereportandverify");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}

}

@Then("^NavigatetogeneratereportforSiteUserandverify$")
public void navigatetogeneratereportforsiteuserandverify() throws Throwable {
	 ExtentTest logInfo = null;
		try {
			
		
			logInfo = test.createNode(new GherkinKeyword("Then"),"Navigatetogeneratereportandverify");
			 new SipApplicationLandingPage(driver).NevigateToGeneralReportForSiteUser();
			 Thread.sleep(1000);
			
			logInfo.pass("Navigatetogeneratereportandverify");
			logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
			
		} catch (AssertionError | Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
}

@Then("^SelectFacility/Department Contact DetailsReport$")
public void selectfacility_Department_Contact_DetailsReport() throws Throwable {

    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"SelectFacility/Department Contact DetailsReport");
            new GeneralReportPage(driver).FacilityDepartment_Contact_Details_Report();
            Thread.sleep(1000);
          
           logInfo.pass("SelectFacility/Department Contact DetailsReport");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^EnterFacilityDepartmentCountryUnder_FacilityDepartment_Contact_Details$")
public void enterfacilitydepartmentcountryunder_facilitydepartment_contact_details() throws Throwable {
	 ExtentTest logInfo = null;
     try {
        
    
         logInfo = test.createNode(new GherkinKeyword("Then"),"EnterFacilityDepartmentCountryUnder_FacilityDepartment_Contact_Details");
          new GeneralReportPage(driver).EnterFacilityDepartmentCountryUnder_FacilityDepartment_Contact_Details();
          Thread.sleep(1000);
        
         logInfo.pass("EnterFacilityDepartmentCountryUnder_FacilityDepartment_Contact_Details");
         logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
     } catch (AssertionError | Exception e){
         testStepHandle("FAIL",driver,logInfo,e);
     }
}

@Then("^VerifydetailsReportRecordsInTabularForm$")
public void verifydetailsreportrecordsintabularform() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"VerifydetailsReportRecordsInTabularForm");
         new GeneralReportPage(driver).VerifydetailsReportRecordsInTabularForm();
         Thread.sleep(1000);
       
        logInfo.pass("VerifydetailsReportRecordsInTabularForm");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^VerifyRecordsofAssociatedDepartment$")
public void verifyrecordsofassociateddepartment() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"VerifyRecordsofAssociatedDepartment");
         new GeneralReportPage(driver).VerifyRecordsofAssociatedDepartment();
         Thread.sleep(1000);
       
        logInfo.pass("VerifyRecordsofAssociatedDepartment");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^VerifyRecordsofAssociatedSiteUsers$")
public void verifyrecordsofassociatedsiteusers() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"VerifyRecordsofAssociatedSiteUsers");
         new GeneralReportPage(driver).VerifyRecordsofAssociatedSiteUsers();
         Thread.sleep(1000);
       
        logInfo.pass("VerifyRecordsofAssociatedSiteUsers");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^NevigateToAssociatedSiteUserSection$")
public void nevigatetoassociatedsiteusersection() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"nevigatetoassociatedsiteusersection");
         new MyFacilityPage(driver).nevigatetoassociatedsiteusersection();
         Thread.sleep(1000);
       
        logInfo.pass("nevigatetoassociatedsiteusersection");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^VerifyAssociatedSiteUserTables$")
public void verifyassociatedsiteusertables() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"verifyassociatedsiteusertables");
         new MyFacilityPage(driver).verifyassociatedsiteusertables();
         Thread.sleep(1000);
       
        logInfo.pass("verifyassociatedsiteusertables");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^VerifyTable(\\d+)$")
public void verifytable(int arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"verifytable");
         new MyFacilityPage(driver).verifytable(arg1);
         Thread.sleep(1000);
       
        logInfo.pass("verifytable");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ViewAssociatedDepartment$")
public void viewassociateddepartment() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"viewassociateddepartment");
         new MyFacilityPage(driver).viewassociateddepartment();
         Thread.sleep(1000);
       
        logInfo.pass("viewassociateddepartment");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^VerifyRemoveUserBtn$")
public void verifyremoveuserbtn() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"verifyremoveuserbtn");
         new MyFacilityPage(driver).verifyremoveuserbtn();
         Thread.sleep(1000);
       
        logInfo.pass("verifyremoveuserbtn");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^RemoveSiteUser$")
public void removesiteuser() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"removesiteuser");
         new MyFacilityPage(driver).removesiteuser();
         Thread.sleep(1000);
       
        logInfo.pass("removesiteuser");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^EnterDetailsUnder Facility/Department Contact DetailsReport$")
public void enterdetailsunder_Facility_Department_Contact_DetailsReport() throws Throwable {
	 ExtentTest logInfo = null;
     try {
        
    
         logInfo = test.createNode(new GherkinKeyword("Then"),"EnterDetailsUnder Facility/Department Contact DetailsReport");
          new GeneralReportPage(driver).EnterDetailsUnder_FacilityDepartment_Contact_DetailsReport();
          Thread.sleep(1000);
        
         logInfo.pass("EnterDetailsUnder Facility/Department Contact DetailsReport");
         logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
     } catch (AssertionError | Exception e){
         testStepHandle("FAIL",driver,logInfo,e);
     }
}

@Then("^facilitydepartmentcapabilitycomparisonreport$")
public void facilitydepartmentcapabilitycomparisonreport() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"facilitydepartmentcapabilitycomparisonreport");
            new GeneralReportPage(driver).facilitydepartmentcapabilitycomparisonreport();
            Thread.sleep(1000);
          
           logInfo.pass("User should able to select capability comparison report ");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}



@Then("^Verifymentionedfields$")
public void Verifymentionedfields() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verifymentionedfields");
            new GeneralReportPage(driver).Verifymentionedfields();
            Thread.sleep(1000);
          
           logInfo.pass("Site user 1 is able to see the mentioned fields.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^verifyfacilitycountrydropdown$")
public void verifyfacilitycountrydropdown() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verifymentionedfields");
            new GeneralReportPage(driver).verifyfacilitycountrydropdown();
            Thread.sleep(1000);
          
           logInfo.pass("All countries are displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}


@Then("^verifyerrormsg$")
public void verifyerrormsg() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyerrormsg");
            new GeneralReportPage(driver).verifyerrormsg();
            Thread.sleep(1000);
          
           logInfo.pass("Verify error msg is displayed .");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^verifyfacilityname$")
public void verifyfacilityname() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyfacilityname");
            new GeneralReportPage(driver).verifyfacilityname();
            Thread.sleep(1000);
          
           logInfo.pass("Facility 1 is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^verifydepartment$")
public void verifydepartment() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifydepartment");
            new GeneralReportPage(driver).verifydepartment();
            Thread.sleep(1000);
          
           logInfo.pass("Department name displayed as blank.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}


@Then("^verifysiteuserrole$")
public void verifysiteuserrole() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifysiteuserrole");
            new GeneralReportPage(driver).verifysiteuserrole();
            Thread.sleep(1000);
          
           logInfo.pass("Site User Role Dropdown is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^verifysiteuserdropdown$")
public void verifysiteuserdropdown() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifysiteuserdropdown");
            new GeneralReportPage(driver).verifysiteuserdropdown();
            Thread.sleep(1000);
          
           logInfo.pass("Site User 2  is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}


@Then("^verifydelegationtypedropdown$")
public void verifydelegationtypedropdown() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifydelegationtypedropdown");
            new GeneralReportPage(driver).verifydelegationtypedropdown();
            Thread.sleep(1000);
          
           logInfo.pass("Site User 1 able to type or select mentioned fields.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^verifybuttons$")
public void verifybuttons() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifybuttons");
            new GeneralReportPage(driver).verifybuttons();
            Thread.sleep(1000);
          
           logInfo.pass("Generate reports and clear search buttons are displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}


@Then("^Navigatetosearchfacility$")
public void Navigatetosearchfacility() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Navigatetosearchfacility");
            new MyFacilityPage(driver).Navigatetosearchfacility();
            Thread.sleep(1000);
          
           logInfo.pass("Site User 1 navigated to search facility screen.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^Entercountry1andverify$")
public void Entercountry1andverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Entercountry1andverify");
            new MyFacilityPage(driver).Entercountry1andverify();
            Thread.sleep(1000);
          
           logInfo.pass("For country 1 state/province/region fields blank and enable.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^Entercountry2andverify$")
public void Entercountry2andverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Entercountry2andverify");
            new MyFacilityPage(driver).Entercountry2andverify();
            Thread.sleep(1000);
          
           logInfo.pass("For country 2 state/province/region fields blank and enable.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}


@Then("^Entercountry3andverify$")
public void Entercountry3andverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Entercountry3andverify");
            new MyFacilityPage(driver).Entercountry3andverify();
            Thread.sleep(1000);
          
           logInfo.pass("For country 3 state/province/region fields blank and enable.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}


@Then("^Entercountry4andverify$")
public void Entercountry4andverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Entercountry4andverify");
            new MyFacilityPage(driver).Entercountry4andverify();
            Thread.sleep(1000);
          
           logInfo.pass("For country 4 state/province/region fields blank and enable.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^sponEntercountry1andverify$")
public void sponEntercountry1andverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"sponEntercountry1andverify");
            new MyFacilityPage(driver).sponEntercountry1andverify();
            Thread.sleep(1000);
          
           logInfo.pass("For country 1 state/province/region fields blank and enable.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^sponEntercountry2andverify$")
public void sponEntercountry2andverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"sponEntercountry2andverify");
            new MyFacilityPage(driver).sponEntercountry2andverify();
            Thread.sleep(1000);
          
           logInfo.pass("For country 2 state/province/region fields blank and enable.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}


@Then("^sponEntercountry3andverify$")
public void sponEntercountry3andverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"sponEntercountry3andverify");
            new MyFacilityPage(driver).sponEntercountry3andverify();
            Thread.sleep(1000);
          
           logInfo.pass("For country 3 state/province/region fields blank and enable.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}


@Then("^sponEntercountry4andverify$")
public void sponEntercountry4andverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"sponEntercountry4andverify");
            new MyFacilityPage(driver).sponEntercountry4andverify();
            Thread.sleep(1000);
          
           logInfo.pass("For country 4 state/province/region fields blank and enable.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^Navigategeneratereportandverify$")
public void Navigategeneratereportandverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Navigategeneratereportandverify");
            new GeneralReportPage(driver).Navigategeneratereportandverify();
            Thread.sleep(1000);
          
           logInfo.pass("Report is displayed with mentioned details.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^Verifystatedropdowndisable$")
public void Verifystatedropdowndisable() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verifystatedropdowndisable");
            new GeneralReportPage(driver).Verifystatedropdowndisable();
            Thread.sleep(1000);
          
           logInfo.pass("Facility State/Province/Region dropdown is disabled.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}


@Then("^Enterdetailsgeneratereportverify$")
public void Enterdetailsgeneratereportverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Enterdetailsgeneratereportverify");
            new GeneralReportPage(driver).Enterdetailsgeneratereportverify();
            Thread.sleep(1000);
          
           logInfo.pass("In reports mentioned details are displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^Verifyfacilitydepartmentreportclumns$")
public void Verifyfacilitydepartmentreportclumns() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verifyfacilitydepartmentreportclumns");
            new GeneralReportPage(driver).Verifyfacilitydepartmentreportclumns();
            Thread.sleep(1000);
          
           logInfo.pass("All the coulmns are displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}


@Then("^Verifygeneratereport$")
public void Verifygeneratereport() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verifygeneratereport");
            new GeneralReportPage(driver).Verifygeneratereport();
            Thread.sleep(1000);
          
           logInfo.pass("unique facility id and department id displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^Verifynavigatedtofacilityname$")
public void Verifynavigatedtofacilityname() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verifynavigatedtofacilityname");
            new GeneralReportPage(driver).Verifynavigatedtofacilityname();
            Thread.sleep(1000);
          
           logInfo.pass("unique facility id and department id displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}


@Then("^verifynavigatedtodepartmentname$")
public void verifynavigatedtodepartmentname() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifynavigatedtodepartmentname");
            new GeneralReportPage(driver).verifynavigatedtodepartmentname();
            Thread.sleep(1000);
          
           logInfo.pass("Department name and address section is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}

@Then("^print$")
public void print() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"print");
            new GeneralReportPage(driver).print();
            Thread.sleep(1000);
          
           logInfo.pass("User clicked on prit button.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}


@Then("^Export$")
public void Export() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Export");
            new GeneralReportPage(driver).Export();
            Thread.sleep(1000);
          
           logInfo.pass("Dropdown is displayed with all the export option.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }

}
@Then("^ExportPDF1$")
public void ExportPDF1() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"ExportPDF1");
            new GeneralReportPage(driver).ExportPDF1();
            Thread.sleep(1000);
          
           logInfo.pass("Export PDF downloaded successfully.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^ExportXLS$")
public void ExportXLS() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"ExportXLS");
            new GeneralReportPage(driver).ExportXLS();
            Thread.sleep(1000);
          
           logInfo.pass("Export XLS downloaded successfully.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^Navigatetomyprofileandverifies$")
public void Navigatetomyprofileandverifies() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Navigatetomyprofileandverifies");
            new MyProfilePage(driver).Navigatetomyprofileandverifies();
            Thread.sleep(1000);
          
           logInfo.pass("Organization Radio button is selected and searchbox for organization is displayed..");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^Selectsitestaffandverify$")
public void Selectsitestaffandverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Selectsitestaffandverify");
            new MyProfilePage(driver).Selectsitestaffandverify();
            Thread.sleep(1000);
          
           logInfo.pass("A free textbox with delegate's email is displayed and delegate button is disabled.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^selectorgradioandverify$")
public void selectorgradioandverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"selectorgradioandverify");
            new MyProfilePage(driver).selectorgradioandverify();
            Thread.sleep(1000);
          
           logInfo.pass("search box for organization is displayed with mentioned details.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^org1andverify$")
public void org1andverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"org1andverify");
            new MyProfilePage(driver).org1andverify();
            Thread.sleep(1000);
          
           logInfo.pass("Organization 1 is not displayed in the dropdown.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^NavigateToMyProfileFacilitiesAndVerify$")
public void navigatetomyprofilefacilitiesandverify() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"NavigateToMyProfileFacilitiesAndVerify");
         new MyProfilePage(driver).NevigateToMyProfileAndFacilitiesAndVerify();
         Thread.sleep(1000);
       
        logInfo.pass("NavigateToMyProfileFacilitiesAndVerify");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}



@Then("^Navigate To MyProfile$")
public void navigate_To_MyProfile() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"NavigateToMyProfile");
         new MyProfilePage(driver).NevigateToMyProfile();
         Thread.sleep(1000);
       
        logInfo.pass("NavigateToMyProfile");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Click On Edit Button To Update Name$")
public void click_On_Edit_Button_To_Update_Name() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"click_On_Edit_Button_To_Update_Name");
         new MyProfilePage(driver).Click_On_Edit_Button_To_Update_Name();
         Thread.sleep(1000);
       
        logInfo.pass("click_On_Edit_Button_To_Update_Name");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Click On Save$")
public void click_On_Save() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"click_On_Save");
         new MyProfilePage(driver).Click_On_Save();
         Thread.sleep(1000);
       
        logInfo.pass("click_On_Save");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^VerifyName$")
public void verifyname() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"VerifyName");
         new MyProfilePage(driver).VerifyName();
         Thread.sleep(1000);
       
        logInfo.pass("VerifyName");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Hover Over the action with facilities as \"([^\"]*)\"$")
public void hover_Over_the_action_with_facilities_as(String arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Hover Over the action with facilities as");
         new MyProfilePage(driver).HoverOverFacilityActionbtn(arg1);
         Thread.sleep(1000);
       
        logInfo.pass("Hover Over the action with facilities as");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickOn Action with facilities as \"([^\"]*)\"$")
public void clickon_Action_with_facilities_as(String arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOn Action with facilities as");
         new MyProfilePage(driver).ClickOnActionWithFacility(arg1);
         Thread.sleep(1000);
       
        logInfo.pass("ClickOn Action with facilities as");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^ClickOn ExportFacilityProfileUnderActionPDFForm$")
public void clickon_ExportFacilityProfileUnderAction() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOn ExportFacilityProfileUnderAction");
         new MyProfilePage(driver).ExportFacilityProfilePDF();
         Thread.sleep(1000);
       
        logInfo.pass("ClickOn ExportFacilityProfileUnderAction");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
        new MyProfilePage(driver).ClickOnExportOK();
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^ClickOn ExportDepartmentProfileUnderActionPDFForm$")
public void clickon_ExportDepartmentProfileUnderAction() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOn ExportDepartmentProfileUnderAction");
         new MyProfilePage(driver).ExportDepartmentProfilePDF();
         Thread.sleep(1000);
       
        logInfo.pass("ClickOn ExportDepartmentProfileUnderAction");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
        new MyProfilePage(driver).ClickOnExportDepOK();
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}



@Then("^ClickOn ExportFacilityProfileUnderActionDocForm$")
public void clickon_ExportFacilityProfileUnderActionDocForm() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOn ExportFacilityProfileUnderAction");
         new MyProfilePage(driver).ExportFacilityProfileDOC();
         Thread.sleep(1000);
       
        logInfo.pass("ClickOn ExportFacilityProfileUnderAction");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
        new MyProfilePage(driver).ClickOnExportOK();
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^AddDepartment$")
public void adddepartment() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"AddDepartment");
         new MyProfilePage(driver).AddDepartmentFromAction();
         Thread.sleep(1000);
        logInfo.pass("AddDepartment");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^Verify AddDepartment Page$")
public void verify_AddDepartment_Page() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Verify_AddDepartment_Page");
         new MyProfilePage(driver).Verify_AddDepartment_Page();
         Thread.sleep(1000);
        logInfo.pass("verify_AddDepartment_Page");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Click on Contact DPM link of Department as \"([^\"]*)\"$")
public void click_on_Contact_DPM_link_of_Department_as(String arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Click_on_Contact_DPM_link_of_Department");
         new MyProfilePage(driver).Click_on_Contact_DPM_link_of_Department(arg1);
         Thread.sleep(1000);
        logInfo.pass("Click_on_Contact_DPM_link_of_Department");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Click on SendMessage$")
public void click_on_SendMessage() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Click_on_SendMessage");
         new MyProfilePage(driver).Click_on_SendMessage();
         Thread.sleep(1000);
        logInfo.pass("Click_on_SendMessage");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Write Message$")
public void write_Message() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"write_Message");
         new MyProfilePage(driver).Write_Message();
         Thread.sleep(1000);
        logInfo.pass("Write_Message");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}


@Then("^Verify SendMessage PopUp$")
public void verify_SendMessage_PopUp() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Verify_SendMessage_PopUp");
         new MyProfilePage(driver).Verify_SendMessage_PopUp();
         logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
         Thread.sleep(1000);
         new MyProfilePage(driver).ClickOKSendMessage_PopUp();
        logInfo.pass("Verify_SendMessage_PopUp");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}
@Then("^AddDepartmentFromActionOnly$")
public void adddepartmentfromactiononly() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"AddDepartment");
         new MyProfilePage(driver).AddDepartmentFromActionOnly();
         Thread.sleep(1000);
        logInfo.pass("AddDepartment");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^AddExisting Department as \"([^\"]*)\"$")
public void addexisting_Department_as(String arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"AddExisting Department");
         new MyProfilePage(driver).AddExisting_Department(arg1);
         Thread.sleep(1000);
        logInfo.pass("");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickOnAdoptFacility$")
public void clickonadoptfacility() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnAdoptFacility");
         new MyProfilePage(driver).ClickAdoptProfileAndVerify();
         Thread.sleep(1000);
       
        logInfo.pass("ClickOnAdoptFacility");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^ClickAdoptFacilityAndDepartment$")
public void clickadoptfacilityanddepartment() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnAdoptFacility");
         new MyProfilePage(driver).ClickAdoptFacilityAndDepartment();
         Thread.sleep(1000);
       
        logInfo.pass("ClickOnAdoptFacility");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^SelectAdoptfacilityAndClickAdoptprofile as \"([^\"]*)\"$")
public void selectadoptfacilityandclickadoptprofile_as(String arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"SelectAdoptfacilityAndClickAdoptprofile");
         new MyProfilePage(driver).SelectAdoptfacilityAndClickAdoptprofile(arg1);
         Thread.sleep(1000);
       
        logInfo.pass("SelectAdoptfacilityAndClickAdoptprofiles");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^clickOkandVerify$")
public void clickOkandverify() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOk");
         new MyProfilePage(driver).ClickOk();
         Thread.sleep(1000);
       
        logInfo.pass("ClickOk");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}


@Then("^NevigateToConsentTraining$")
public void nevigatetoconsenttraining() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"NevigateToConsentTraining");
         new MyProfilePage(driver).NevigateToConsentTraining();
         Thread.sleep(1000);
       
        logInfo.pass("NevigateToConsentTraining");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^NevigateToConsentTrainingOnly$")
public void nevigatetoconsenttrainingonly() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"NevigateToConsentTraining");
         new MyProfilePage(driver).NevigateToConsentTrainingOnly();
         Thread.sleep(1000);
       
        logInfo.pass("NevigateToConsentTraining");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^AnswerAllConsentTrainingquestion$")
public void answerallconsenttrainingquestion() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"AnswerAllConsentTrainingquestion");
         new MyProfilePage(driver).AnswerAllConsentTrainingQuestion();
         Thread.sleep(1000);
       
        logInfo.pass("AnswerAllConsentTrainingquestion");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}
@Then("^NevigateToDepartmentContact$")
public void nevigatetodepartmentcontact() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"NevigateToDepartmentContact");
         new MyProfilePage(driver).NevigateToDepartmentContact();
         Thread.sleep(1000);
       
        logInfo.pass("NevigateToDepartmentContact");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^Change The Primary DPM as \"([^\"]*)\"$")
public void change_The_Primary_DPM_as(String arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Change_The_Primary_DPM");
         new MyProfilePage(driver).Change_The_Primary_DPM(arg1);
         Thread.sleep(1000);
       
        logInfo.pass("Change_The_Primary_DPM");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^NevigateToTherapeuticAreasPatientPopulation$")
public void nevigatetotherapeuticareaspatientpopulation() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"NevigateToTherapeuticAreasPatientPopulation");
         new MyProfilePage(driver).NevigateToTherapeuticAreasPatientPopulation();
         Thread.sleep(1000);
       
        logInfo.pass("NevigateToTherapeuticAreasPatientPopulation");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^EnterLocalLabFewMendatoryFields$")
public void EnterLocalLabFewMendatoryFields() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"EnterLocalLabFewMendatoryFields");
         new MyProfilePage(driver).EnterLocalLabFewMendatoryFields();
         Thread.sleep(1000);
       
        logInfo.pass("EnterLocalLabFewMendatoryFields");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^EnterLocalLabMendatoryFields$")
public void EnterLocalLabMendatoryFields() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"EnterLocalLabFewMendatoryFields");
         new MyProfilePage(driver).EnterLocalLabMendatoryFields();
         Thread.sleep(1000);
       
        logInfo.pass("EnterLocalLabMendatoryFields");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}


@Then("^NevigateToIRBEthics$")
public void nevigatetoirbethics() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"NevigateToIRBEthics");
         new MyProfilePage(driver).NevigateToIRBEthics();
         Thread.sleep(1000);
       
        logInfo.pass("NevigateToIRBEthics");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^ThenVerifyIRBEthics$")
public void ThenVerifyIRBEthics() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ThenVerifyIRBEthics");
         new MyProfilePage(driver).ThenVerifyIRBEthics();
         Thread.sleep(1000);
       
        logInfo.pass("ThenVerifyIRBEthics");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^VerifyConsentTraining$")
public void VerifyConsentTraining() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"VerifyConsentTraining");
         new MyProfilePage(driver).VerifyConsentTraining();
         Thread.sleep(1000);
       
        logInfo.pass("VerifyConsentTraining");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^NevigateToLocalLab$")
public void nevigatetolocallab() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"NevigateToLocalLab");
         new MyProfilePage(driver).NevigateToLocalLab();
         Thread.sleep(1000);
       
        logInfo.pass("NevigateToLocalLab");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^ClickOnYesUnderLocalLab$")
public void clickonyesunderlocallab() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnYesUnderLocalLab");
         new MyProfilePage(driver).ClickOnYesUnderLocalLab();
         Thread.sleep(1000);
       
        logInfo.pass("ClickOnYesUnderLocalLab");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^ScrolldownToClickonButton$")
public void scrolldowntoclickonbutton() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ScrolldownToClickonButton");
         new MyProfilePage(driver).ScrolldownToClickonButton();
         Thread.sleep(1000);
       
        logInfo.pass("ScrolldownToClickonButton");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^ScrolldownForVerify$")
public void ScrolldownForVerify() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"vScrolldownForVerify");
         new MyProfilePage(driver).ScrolldownForVerify();
         logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
         new MyProfilePage(driver).ScrollUpForVerify();
         Thread.sleep(1000);  
        logInfo.pass("ScrolldownForVerify");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^ScrolldeepdownAndVerify$")
public void ScrolldeepdownAndVerify() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ScrolldownForVerify");
         new MyProfilePage(driver).ScrolldownToClickonButton();
         logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
         new MyProfilePage(driver).ScrollUpToClickonButton();
         Thread.sleep(1000);  
        logInfo.pass("ScrolldownForVerify");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^VerifyvalidationMessage$")
public void VerifyvalidationMessage() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"VerifyvalidationMessage");
         new MyProfilePage(driver).VerifyvalidationMessage();
         Thread.sleep(1000);
       
        logInfo.pass("VerifyvalidationMessage");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^ClickOnX$")
public void ClickOnX() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnX");
         new MyProfilePage(driver).ClickOnX();
         Thread.sleep(1000);
       
        logInfo.pass("ClickOnX");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^ClickOnSaty$")
public void ClickOnSaty() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnSaty");
         new MyProfilePage(driver).ClickOnSaty();
         Thread.sleep(1000);
       
        logInfo.pass("ClickOnSaty");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^ClickOnLeave$")
public void ClickOnLeave() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnLeave");
         new MyProfilePage(driver).ClickOnLeave();
         Thread.sleep(1000);
       
        logInfo.pass("ClickOnLeave");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^NevigteTo<IRBEthicsCommitteAndverify$")
public void nevigteto_IRBEthicsCommitteAndverify() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"NevigteTo<IRBEthicsCommitteAndverify");
         new MyProfilePage(driver).NevigteToIRBEthicsCommitteAndverify();
         Thread.sleep(1000);
       
        logInfo.pass("NevigteTo<IRBEthicsCommitteAndverify");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^NevigateToConsentTraing>Andverify$")
public void nevigatetoconsenttraing_Andverify() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"NevigateToConsentTraing>Andverify");
         new MyProfilePage(driver).NevigateToConsentTraingAndverify();
         Thread.sleep(1000);
       
        logInfo.pass("NevigateToConsentTraing>Andverify");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^NevigateToInvestigationalProduct$")
public void nevigatetoinvestigationalproduct() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"NevigateToInvestigationalProduct");
         new MyProfilePage(driver).NevigateToInvestigationalProduct();
         Thread.sleep(1000);
       
        logInfo.pass("NevigateToInvestigationalProduct");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^Click On PlusTcon To Verify Name$")
public void click_On_PlusTcon_To_Verify_Name() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Click_On_PlusTcon_To_Verify_Name");
         new MyProfilePage(driver).Click_On_PlusTcon_To_Verify_Name();
         Thread.sleep(1000);
       
        logInfo.pass("Click_On_PlusTcon_To_Verify_Name");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}


@Then("^Click_On_ADDSHIPPINGLOCATIONButton$")
public void Click_On_ADDSHIPPINGLOCATIONButton() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Click_On_ADDSHIPPINGLOCATIONButton()");
         new MyProfilePage(driver).Click_On_ADDSHIPPINGLOCATIONButton();
         Thread.sleep(1000);
       
        logInfo.pass("Click_On_ADDSHIPPINGLOCATIONButton()");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Save Shipping Address$")
public void save_Shipping_Address() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"save_Shipping_Address");
         new MyProfilePage(driver).save_Shipping_Address();
         Thread.sleep(1000);
       
        logInfo.pass("save_Shipping_Address");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Save Investigational Product Storage Location$")
public void save_Investigational_Product_Storage_Location() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"save_Investigational_Product_Storage_Location");
         new MyProfilePage(driver).save_Investigational_Product_Storage_Location();
         Thread.sleep(1000);
       
        logInfo.pass("save_Investigational_Product_Storage_Location");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Click OK for Shipping Address PopUp$")
public void click_OK_for_Shipping_Address_PopUp() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"click_OK_for_Shipping_Address_PopUp");
         new MyProfilePage(driver).click_OK_for_Shipping_Address_PopUp();
         Thread.sleep(1000);
       
        logInfo.pass("click_OK_for_Shipping_Address_PopUp");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Click_On_PlusTcon_To_Verify_Details(\\d+)$")
public void click_on_plustcon_to_verify_details(int arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"click_on_plustcon_to_verify_details");
         new MyProfilePage(driver).Click_On_PlusTcon_To_Verify_Details(arg1);
         Thread.sleep(1000);
       
        logInfo.pass("click_on_plustcon_to_verify_details");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickOnRemoveShippingAddress(\\d+)$")
public void clickonremoveshippingaddress(int arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnRemoveShippingAddress");
         new MyProfilePage(driver).ClickOnRemoveShippingAddress(arg1);
         Thread.sleep(1000);
       
        logInfo.pass("ClickOnRemoveShippingAddress");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickOnCancelOfRemoveShippingAddress(\\d+)$")
public void clickoncancelofremoveshippingaddress(int arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnCancelOfRemoveShippingAddress");
         new MyProfilePage(driver).ClickOnCancelOfRemoveShippingAddress(arg1);
         Thread.sleep(1000);
       
        logInfo.pass("ClickOnCancelOfRemoveShippingAddress");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickOnOKOfRemoveShippingAddress(\\d+)$")
public void clickonOKofremoveshippingaddress(int arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnOKOfRemoveShippingAddress");
         new MyProfilePage(driver).ClickOnOKOfRemoveShippingAddress(arg1);
         Thread.sleep(1000);
       
        logInfo.pass("ClickOnOKOfRemoveShippingAddress");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Click On Country DropDown Under INVESTIGATIONAL PRODUCT SHIPPING DETAILS$")
public void click_On_Country_DropDown_Under_INVESTIGATIONAL_PRODUCT_SHIPPING_DETAILS() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Click_On_Country_DropDown_Under_INVESTIGATIONAL_PRODUCT_SHIPPING_DETAILS");
         new MyProfilePage(driver).Click_On_Country_DropDown_Under_INVESTIGATIONAL_PRODUCT_SHIPPING_DETAILS();
         logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
         Thread.sleep(1000);
         new MyProfilePage(driver).Select_Country_Under_INVESTIGATIONAL_PRODUCT_SHIPPING_DETAILS();
        logInfo.pass("Click_On_Country_DropDown_Under_INVESTIGATIONAL_PRODUCT_SHIPPING_DETAILS");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Click On State DropDown Under INVESTIGATIONAL PRODUCT SHIPPING DETAILS$")
public void click_On_State_DropDown_Under_INVESTIGATIONAL_PRODUCT_SHIPPING_DETAILS() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Click_On_state_DropDown_Under_INVESTIGATIONAL_PRODUCT_SHIPPING_DETAILS");
         new MyProfilePage(driver).Click_On_State_DropDown_Under_INVESTIGATIONAL_PRODUCT_SHIPPING_DETAILS();
         logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
         Thread.sleep(1000);
         new MyProfilePage(driver).Select_State_Under_INVESTIGATIONAL_PRODUCT_SHIPPING_DETAILS();
        logInfo.pass("Click_On_State_DropDown_Under_INVESTIGATIONAL_PRODUCT_SHIPPING_DETAILS");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Enter Invalid Email$")
public void enter_Invalid_Email() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"enter_Invalid_Email");
         new MyProfilePage(driver).Enter_Invalid_Email();
        
         Thread.sleep(1000);
       
        logInfo.pass("enter_Invalid_Email");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Enter Valid Email$")
public void enter_Valid_Email() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"enter_Valid_Email");
         new MyProfilePage(driver).Enter_Valid_Email();
       
         Thread.sleep(1000);
       
        logInfo.pass("enter_Valid_Email");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Enter Data in Remaining Fields$")
public void enter_Data_in_Remaining_Fields() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"enter_Data_in_Remaining_Fields");
         new MyProfilePage(driver).Enter_Data_in_Remaining_Fields();
     
         Thread.sleep(1000);
       
        logInfo.pass("Enter_Data_in_Remaining_Fields");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Verify Add Shipping Location Button is disable$")
public void verify_Add_Shipping_Location_Button_is_disable() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"verify_Add_Shipping_Location_Button_is_disable");
         new MyProfilePage(driver).Verify_Add_Shipping_Location_Button_is_disable();
        
         Thread.sleep(1000);
    
        logInfo.pass("verify_Add_Shipping_Location_Button_is_disable");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}



@Then("^EnterIPRecipientName as \"([^\"]*)\"$")
public void enteriprecipientname_as(String arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"EnterIPRecipientName");
         new MyProfilePage(driver).EnterIPRecipientName(arg1);
        
         Thread.sleep(1000);
    
        logInfo.pass("EnterIPRecipientName");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}



@Then("^Enter Invalid Special Character In Describe additional Investigational Product Storage Field$")
public void enter_Invalid_Special_Character_In_Describe_additional_Investigational_Product_Storage_Field() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"enter_Invalid_Special_Character_In_Describe_additional_Investigational_Product_Storage_Field");
         new MyProfilePage(driver).enter_Invalid_Special_Character_In_Describe_additional_Investigational_Product_Storage_Field();
         Thread.sleep(1000);
       
        logInfo.pass("enter_Invalid_Special_Character_In_Describe_additional_Investigational_Product_Storage_Field");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Click OK For Special Character PopUp$")
public void click_OK_For_Special_Character_PopUp() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Click OK For Special Character PopUp");
         new MyProfilePage(driver).Click_OK_For_Special_Character_PopUp();
         Thread.sleep(1000);
       
        logInfo.pass("Click OK For Special Character PopUp");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Click OK for Product Storage Location PopUp$")
public void click_OK_for_Product_Storage_Location_PopUp() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"click_OK_for_Product_Storage_Location_PopUp");
         new MyProfilePage(driver).click_OK_for_Product_Storage_Location_PopUp();
         Thread.sleep(1000);
       
        logInfo.pass("click_OK_for_Product_Storage_Location_PopUp");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickOnInvestigationalProduct>$")
public void clickoninvestigationalproduct() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnInvestigationalProduct>");
         new MyProfilePage(driver).ClickOnInvestigationalProduct();
         Thread.sleep(1000);
       
        logInfo.pass("ClickOnInvestigationalProduct>");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^RemoveOneIPshippingLocation$")
public void removeoneipshippinglocation() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"RemoveOneIPshippingLocation");
         new MyFacilityPage(driver).RemoveOneIPshippingLocation();
         Thread.sleep(1000);
       
        logInfo.pass("RemoveOneIPshippingLocation");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^SaveAndVerify$")
public void Saveandverify() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"SaveAndVerify");
         new MyFacilityPage(driver).SaveAndVerify();
         Thread.sleep(1000);
       
        logInfo.pass("SaveAndVerify");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^ClickOn<Facility&Equipment$")
public void clickon_Facility_Equipment() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOn<Facility&Equipment");
         new MyProfilePage(driver).ClickOnFacilityEquipment();
         Thread.sleep(1000);
       
        logInfo.pass("ClickOn<Facility&Equipment");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^NevigateToSourceDocumentation$")
public void nevigatetosourcedocumentation() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"NevigateToSourceDocumentation");
         new MyProfilePage(driver).NevigateToSourceDocumentation();
         Thread.sleep(1000);
       
        logInfo.pass("NevigateToSourceDocumentation");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^NevigateToAdditionalLocations$")
public void nevigatetoadditionallocations() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"NevigateToAdditionalLocations");
         new MyProfilePage(driver).NevigateToAdditionalLocations();
         Thread.sleep(1000);
       
        logInfo.pass("NevigateToAdditionalLocations");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^NevigateToAdditionalInformation$")
public void nevigatetoadditionalinformation() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"NevigateToAdditionalInformation");
         new MyProfilePage(driver).NevigateToAdditionalInformation();
         Thread.sleep(1000);
       
        logInfo.pass("NevigateToAdditionalInformation");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^OrganizationAffiliations$")
public void organizationaffiliations() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"OrganizationAffiliations");
         new MyProfilePage(driver).OrganizationAffiliations();
         Thread.sleep(1000);
       
        logInfo.pass("OrganizationAffiliations");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^Verify All Section Of Facility/Department$")
public void verify_All_Section_Of_Facility_Department() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Verify_All_Section_Of_Facility_Department");
         new MyProfilePage(driver).Verify_All_Section_Of_Facility_Department();
         Thread.sleep(1000);
       
        logInfo.pass("Verify_All_Section_Of_Facility_Department");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}




@Then("^SelectThreeLanguage$")
public void selectthreelanguage() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"SelectThreeLanguage");
         new MyProfilePage(driver).select3Language();
         Thread.sleep(1000);
       
        logInfo.pass("SelectThreeLanguage");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^SelectYesForQuestionPKPD$")
public void SelectYesForQuestionPKPD() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"SelectYesForQuestionPKPD");
         new MyProfilePage(driver).SelectYesForQuestionPKPD();
         Thread.sleep(1000);
       
        logInfo.pass("SelectYesForQuestionPKPD");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}
@Then("^SelectThreeInternet$")
public void selectthreeinternet() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"SelectThreeInternet");
         new MyProfilePage(driver).SelectThreeInternet();
         Thread.sleep(1000);
       
        logInfo.pass("SelectThreeInternet");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^AnswerAllFacilityAndEquipment$")
public void answerallfacilityandequipment() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"AnswerAllFacilityAndEquipment");
         new MyProfilePage(driver).AnswerAllFacilityEquipmentquestion();
         Thread.sleep(1000);
       
        logInfo.pass("AnswerAllFacilityAndEquipment");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}
@Then("^VerifySubSectionFacilityCapability$")
public void verifysubsectionfacilitycapability() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"VerifySubSectionFacilityCapability");
         new MyProfilePage(driver).VerifySubSectionFacilityCapability();
         Thread.sleep(1000);
       
        logInfo.pass("VerifySubSectionFacilityCapability");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^VerifySubsectionEquipment$")
public void verifysubsectionequipment() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"VerifySubsectionEquipment");
         new MyProfilePage(driver).VerifySubsectionEquipment();
         Thread.sleep(1000);
       
        logInfo.pass("VerifySubsectionEquipment");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^VerifySubsectionGeneralEquipment$")
public void verifysubsectiongeneralequipment() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"VerifySubsectionGeneralEquipment");
         new MyProfilePage(driver).VerifySubsectionGeneralEquipment();
         Thread.sleep(1000);
       
        logInfo.pass("VerifySubsectionGeneralEquipment");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^VerifySubsectionComputerCapabilities$")
public void verifysubsectioncomputercapabilities() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"VerifySubsectionComputerCapabilities");
         new MyProfilePage(driver).VerifySubsectionComputerCapabilities();
         Thread.sleep(1000);
       
        logInfo.pass("VerifySubsectionComputerCapabilities");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^NevigateToFacilityAndEquipmentOnly$")
public void nevigatetofacilityandequipmentonly() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"FacilityAndEquipment");
         new MyProfilePage(driver).NevigateToFacilityEquipmentOnly();
         Thread.sleep(1000);
       
        logInfo.pass("FacilityAndEquipment");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^EditStateProvinceRegion$")
public void EditStateProvinceRegion() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"EditStateProvinceRegion");
         new MyFacilityPage(driver).EditStateProvinceRegion();
         Thread.sleep(1000);
       
        logInfo.pass("EditStateProvinceRegion");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^FacilityAndEquipment$")
public void facilityandequipment() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"FacilityAndEquipment");
         new MyProfilePage(driver).NevigateToFacilityEquipment();
         Thread.sleep(1000);
       
        logInfo.pass("FacilityAndEquipment");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    } 
}

@Then("^ClickOnHyperlink as \"([^\"]*)\"$")
public void clickonhyperlink_as(String arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnHyperlink as");
         new MyProfilePage(driver).ClickOnFacilityHyperLink(arg1);
         Thread.sleep(1000);
       
        logInfo.pass("ClickOnHyperlink as");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Verify Affiliation Status$")
public void verify_Affiliation_Status() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"verify_Affiliation_Status");
         new MyProfilePage(driver).verify_Affiliation_Status();
         Thread.sleep(1000);
       
        logInfo.pass("verify_Affiliation_Status");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickHyperLink as \"([^\"]*)\"$")
public void clickhyperlink_as(String arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"clickhyperlink_as");
         new MyProfilePage(driver).Clickhyperlink_as(arg1);
         Thread.sleep(1000);
       
        logInfo.pass("clickhyperlink_as");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}


@Then("^HoverOverTheHyperLink as \"([^\"]*)\"$")
public void hoveroverthehyperlink_as(String arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"hoveroverthehyperlink_as");
         new MyProfilePage(driver).HoverOverTheHyperLink(arg1);
         Thread.sleep(1000);
       
        logInfo.pass("hoveroverthehyperlink_as");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickOnSIPFacilityProfileButton$")
public void clickonsipfacilityprofilebutton() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnUploadFacilityProfile");
         new MyProfilePage(driver).ClickOnUploadFacilityProfile();
         Thread.sleep(1000);
       
        logInfo.pass("ClickOnUploadFacilityProfile");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^SwitchTab And ClickOn OrganizationAffiliations$")
public void switchtab_And_ClickOn_OrganizationAffiliations() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"SwitchTab And ClickOn OrganizationAffiliations");
       
        new MyProfilePage(driver).SwitchTabAndClickOnOrganizationAffiliations();
         Thread.sleep(1000);
       
        logInfo.pass("SwitchTab And ClickOn OrganizationAffiliations");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^SwitchTab$")
public void switchtab() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"SwitchTab");
       
        new MyProfilePage(driver).switchTab();
         Thread.sleep(1000);
       
        logInfo.pass("SwitchTab");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^SwitchToParantTab$")
public void SwitchToParantTab() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"SwitchToParantTab");
       
        new MyProfilePage(driver).SwitchToParantTab();
         Thread.sleep(1000);
       
        logInfo.pass("SwitchToParantTab");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}
@Then("^SwitchTabandCloseNewtab$")
public void switchtabandclosenewtab() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"SwitchTab");
       
        new MyProfilePage(driver).SwitchTabAndCloseNewTab();
         Thread.sleep(1000);
       
        logInfo.pass("SwitchTab");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^ClickOnDepartment(\\d+)$")
public void clickondepartment(int arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"clickondepartment");
       
        new MyProfilePage(driver).clickondepartment(arg1);
         Thread.sleep(1000);
       
        logInfo.pass("clickondepartment");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^switchTab_Verify_CloseNewTab$")
public void switchtab_verify_closenewtab() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"switchtab_verify_closenewtab");
       
        new MyProfilePage(driver).switchtab_verify_closenewtab();
         Thread.sleep(1000);
       
        logInfo.pass("switchtab_verify_closenewtab");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^SwitchToPreviousTab$")
public void switchtoprevioustab() throws Throwable {
//	ExtentTest logInfo = null;
//    try {
//       
//   
//        logInfo = test.createNode(new GherkinKeyword("Then"),"SwitchTab And ClickOn OrganizationAffiliations");
//       
//        new MyProfilePage(driver).SwitchTabAndClickOnOrganizationAffiliations();
//         Thread.sleep(1000);
//       
//        logInfo.pass("SwitchTab And ClickOn OrganizationAffiliations");
//        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
//    } catch (AssertionError | Exception e){
//        testStepHandle("FAIL",driver,logInfo,e);
//    }
}



@Then("^selectanyvalueverify$")
public void selectanyvalueverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"selectanyvalueverify");
            new MyProfilePage(driver).selectanyvalueverify();
            Thread.sleep(1000);
          
           logInfo.pass("Select any value and click on clear search button.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^clickcancelandverify$")
public void clickcancelandverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickcancelandverify");
            new MyProfilePage(driver).clickcancelandverify();
            Thread.sleep(1000);
          
           logInfo.pass("Verify basic details is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^clickdelegateandverify$")
public void clickdelegateandverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickdelegateandverify");
            new MyProfilePage(driver).clickdelegateandverify();
            Thread.sleep(1000);
          
           logInfo.pass("Mentioned msg is diplayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^selectcountry1andverify$")
public void selectcountry1andverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"selectcountry1andverify");
            new MyProfilePage(driver).selectcountry1andverify();
            Thread.sleep(1000);
          
           logInfo.pass("State field is enabled.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^entervalidsearchcriteria$")
public void entervalidsearchcriteria() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"entervalidsearchcriteria");
            new MyProfilePage(driver).entervalidsearchcriteria();
            Thread.sleep(1000);
          
           logInfo.pass("Verify search results are dispayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^clickonplusiconandverify$")
public void clickonplusiconandverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickonplusiconandverify");
            new MyProfilePage(driver).clickonplusiconandverify();
            Thread.sleep(1000);
          
           logInfo.pass("Verify search results are dispayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^clickonminusiconandverify$")
public void clickonminusiconandverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickonminusiconandverify");
            new MyProfilePage(driver).clickonminusiconandverify();
            Thread.sleep(1000);
          
           logInfo.pass("search results are dispayed in tabular format.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}




@Then("^organizationnamesortable$")
public void organizationnamesortable() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"organizationnamesortable");
            new MyProfilePage(driver).organizationnamesortable();
            Thread.sleep(1000);
          
           logInfo.pass("It sorted alphabetically by default.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifybelowdetails$")
public void verifybelowdetails() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifybelowdetails");
            new MyProfilePage(driver).verifybelowdetails();
            Thread.sleep(1000);
          
           logInfo.pass("Mentioned details are displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^verifypagination$")
public void verifypagination() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifypagination");
            new MyProfilePage(driver).verifypagination();
            Thread.sleep(1000);
          
           logInfo.pass("ability for user to see the row per page.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^Navigatemyprofileandverify$")
public void Navigatemyprofileandverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Navigatemyprofileandverify");
            new MyProfilePage(driver).Navigatemyprofileandverify();
            Thread.sleep(1000);
          
           logInfo.pass("Basic section is displayed with pre-populated data.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^Verifybasicdetails$")
public void Verifybasicdetails() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
    	   logInfo = test.createNode(new GherkinKeyword("Then"),"Verifybasicdetails");
           new MyProfilePage(driver).Verifybasicdetails();
           Thread.sleep(1000);
          
           logInfo.pass("Basic detail section is displayed with mentioned sub sections.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^Verifyerrormsgs$")
public void Verifyerrormsgs() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verifyerrormsgs");
            new MyProfilePage(driver).Verifyerrormsgs();
            Thread.sleep(1000);
          
           logInfo.pass("Error msg is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^enterinvaliddataandsave$")
public void enterinvaliddataandsave() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"enterinvaliddataandsave");
            new MyProfilePage(driver).enterinvaliddataandsave();
            Thread.sleep(1000);
          
           logInfo.pass("Error msg is displayed with all mentioned fields.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^enterdatacombinationofalphabet$")
public void enterdatacombinationofalphabet() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"enterdatacombinationofalphabet");
            new MyProfilePage(driver).enterdatacombinationofalphabet();
            Thread.sleep(1000);
          
           logInfo.pass("Error msg is displayed for mobile.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^clickcancels$")
public void clickcancels() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickcancels");
            new MyProfilePage(driver).clickcancels();
            Thread.sleep(1000);
          
           logInfo.pass("Basic details screen is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^Verifyroles$")
public void Verifyroles() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verifyroles");
            new MyProfilePage(driver).Verifyroles();
            Thread.sleep(1000);
          
           logInfo.pass("Mentioned roles are  displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^Enterinvaliddata$")
public void Enterinvaliddata() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Enterinvaliddata");
            new MyProfilePage(driver).Enterinvaliddata();
            Thread.sleep(1000);
          
           logInfo.pass("The error msg  displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^Verifyprimarybusinessaddress$")
public void Verifyprimarybusinessaddress() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verifyprimarybusinessaddress");
            new MyProfilePage(driver).Verifyprimarybusinessaddress();
            Thread.sleep(1000);
          
           logInfo.pass("The error msg  displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^enterinvaliddataandverifyerror$")
public void enterinvaliddataandverifyerror() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"enterinvaliddataandverifyerror");
            new MyProfilePage(driver).enterinvaliddataandverifyerror();
            Thread.sleep(1000);
          
           logInfo.pass("error msg is displayed for invalid data.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^Verifyothercontactdetails$")
public void Verifyothercontactdetails() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verifyothercontactdetails");
            new MyProfilePage(driver).Verifyothercontactdetails();
            Thread.sleep(1000);
          
           logInfo.pass("Other contact details subsections displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^updateallfields$")
public void updateallfields() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"updateallfields");
            new MyProfilePage(driver).updateallfields();
            Thread.sleep(1000);
          
           logInfo.pass("Details are saved successfuly.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^clickonhome$")
public void clickonhome() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickonhome");
            new MyProfilePage(driver).clickonhome();
            Thread.sleep(1000);
          
           logInfo.pass("clickonhome");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^enterdatainbasicdetails$")
public void enterdatainbasicdetails() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"enterdatainbasicdetails");
            new MyProfilePage(driver).enterdatainbasicdetails();
            Thread.sleep(1000);
          
           logInfo.pass("Basic details is marked as marked.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^Verifytworaio$")
public void Verifytworaio() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verifytworaio");
            new MyProfilePage(driver).Verifytworaio();
            Thread.sleep(1000);
          
           logInfo.pass("Role fields displayed wih two rario buttons.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^Verifydropdownvalue$")
public void Verifydropdownvalue() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verifydropdownvalue");
            new MyProfilePage(driver).Verifydropdownvalue();
            Thread.sleep(1000);
          
           logInfo.pass("A new dropdown with place holder text is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^Verifydropdownvalues$")
public void Verifydropdownvalues() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verifydropdownvalues");
            new MyProfilePage(driver).Verifydropdownvalues();
            Thread.sleep(1000);
          
           logInfo.pass("Dropdown values are displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^Verifyfacilitysection$")
public void Verifyfacilitysection() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verifyfacilitysection");
            new MyProfilePage(driver).Verifyfacilitysection();
            Thread.sleep(1000);
          
           logInfo.pass("Facility section is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^Verifybasics$")
public void Verifybasics() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verifybasics");
            new MyProfilePage(driver).Verifybasics();
            Thread.sleep(1000);
          
           logInfo.pass("Basic details section is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^selectrolesave$")
public void selectrolesave() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"selectrolesave");
            new MyProfilePage(driver).selectrolesave();
            Thread.sleep(1000);
          
           logInfo.pass("confirmation popup displayed with ok button.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^clickokandverifysubrole$")
public void clickokandverifysubrole() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickokandverifysubrole");
            new MyProfilePage(driver).clickokandverifysubrole();
            Thread.sleep(1000);
          
           logInfo.pass("Updated subrole is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^Navigatetofacilityandverifydepartment1$")
public void Navigatetofacilityandverifydepartment1() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Navigatetofacilityandverifydepartment1");
            new MyFacilityPage(driver).Navigatetofacilityandverifydepartment1();
            Thread.sleep(1000);
          
           logInfo.pass("Department 1 is displayed in facilities section.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^Verifypopulateddepartmentprofile$")
public void Verifypopulateddepartmentprofile() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verifypopulateddepartmentprofile");
            new MyFacilityPage(driver).Verifypopulateddepartmentprofile();
            Thread.sleep(1000);
          
           logInfo.pass("Populated dept profile screen is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^Navigateandverifysameasshipping$")
public void Navigateandverifysameasshipping() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Navigateandverifysameasshipping");
            new MyFacilityPage(driver).Navigateandverifysameasshipping();
            Thread.sleep(1000);
          
           logInfo.pass("user not able to select any option without completing shipping.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^clicksaveandverify$")
public void clicksaveandverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clicksaveandverify");
            new MyFacilityPage(driver).clicksaveandverify();
            Thread.sleep(1000);
          
           logInfo.pass("pop up is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^clickokandverify$")
public void clickokandverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickokandverify");
            new MyFacilityPage(driver).clickokandverify();
            Thread.sleep(1000);
          
           logInfo.pass("validation error is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^clickoncountrydropdownandverify$")
public void clickoncountrydropdownandverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickoncountrydropdownandverify");
            new MyFacilityPage(driver).clickoncountrydropdownandverify();
            Thread.sleep(1000);
          
           logInfo.pass("contry dropdown value are fetched.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^selectcountrystateandverify$")
public void selectcountrystateandverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"selectcountrystateandverify");
            new MyFacilityPage(driver).selectcountrystateandverify();
            Thread.sleep(1000);
          
           logInfo.pass("state dropdown value are fetched.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^selectstateinvalidemailandverify$")
public void selectstateinvalidemailandverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"selectstateinvalidemailandverify");
            new MyFacilityPage(driver).selectstateinvalidemailandverify();
            Thread.sleep(1000);
          
           logInfo.pass("error msg is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^entervalidemailandverify$")
public void entervalidemailandverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"entervalidemailandverify");
            new MyFacilityPage(driver).entervalidemailandverify();
            Thread.sleep(1000);
          
           logInfo.pass("Add IP shipping location button disable.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^enterdataremainingfieldandsave$")
public void enterdataremainingfieldandsave() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"enterdataremainingfieldandsave");
            new MyFacilityPage(driver).enterdataremainingfieldandsave();
            Thread.sleep(1000);
          
           logInfo.pass("Add IP shipping location button enable.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^addipshippingandverify$")
public void addipshippingandverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"addipshippingandverify");
            new MyFacilityPage(driver).addipshippingandverify();
            Thread.sleep(1000);
          
           logInfo.pass("Add IP shipping location button enable.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^donotenterandsave$")
public void donotenterandsave() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"donotenterandsave");
            new MyFacilityPage(driver).donotenterandsave();
            Thread.sleep(1000);
          
           logInfo.pass("error poupu is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^clickokcountryverify$")
public void clickokcountryverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickokcountryverify");
            new MyFacilityPage(driver).clickokcountryverify();
            Thread.sleep(1000);
          
           logInfo.pass("verify country value fetch.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^enteripshippinglocationsaveduplicatewarning$")
public void enteripshippinglocationsaveduplicatewarning() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"enteripshippinglocationsaveduplicatewarning");
            new MyFacilityPage(driver).enteripshippinglocationsaveduplicatewarning();
            Thread.sleep(1000);
          
           logInfo.pass("Duplicate data is displayed with ok button.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^clickoksaveverify$")
public void clickoksaveverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickoksaveverify");
            new MyFacilityPage(driver).clickoksaveverify();
            Thread.sleep(1000);
          
           logInfo.pass("Data saved successfully.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyalldataunderproductshippingdetail$")
public void verifyalldataunderproductshippingdetail() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyalldataunderproductshippingdetail");
            new MyFacilityPage(driver).verifyalldataunderproductshippingdetail();
            Thread.sleep(1000);
          
           logInfo.pass("Mentioned fields displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyplusicon$")
public void verifyplusicon() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyplusicon");
            new MyFacilityPage(driver).verifyplusicon();
            Thread.sleep(1000);
          
           logInfo.pass("plus button is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^clickonplusiconandverifies$")
public void clickonplusiconandverifies() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickonplusiconandverifies");
            new MyFacilityPage(driver).clickonplusiconandverifies();
            Thread.sleep(1000);
          
           logInfo.pass("All details are displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^clickonremoveverifypopup$")
public void clickonremoveverifypopup() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickonremoveverifypopup");
            new MyFacilityPage(driver).clickonremoveverifypopup();
            Thread.sleep(1000);
          
           logInfo.pass("warning msg displays with ok and cancel buttons.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^clickcancelbuttonandverify$")
public void clickcancelbuttonandverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickcancelbuttonandverify");
            new MyFacilityPage(driver).clickcancelbuttonandverify();
            Thread.sleep(1000);
          
           logInfo.pass("IP shipping location not deleted.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^expandseconipshippinglacationandverify$")
public void expandseconipshippinglacationandverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"expandseconipshippinglacationandverify");
            new MyFacilityPage(driver).expandseconipshippinglacationandverify();
            Thread.sleep(1000);
          
           logInfo.pass("IP shipping all the fields are displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^clickonrevoveandverifywarning$")
public void clickonrevoveandverifywarning() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickonrevoveandverifywarning");
            new MyFacilityPage(driver).clickonrevoveandverifywarning();
            Thread.sleep(1000);
          
           logInfo.pass("IP shipping record deleted successfully.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^addiplocation2andverify$")
public void addiplocation2andverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"addiplocation2andverify");
            new MyFacilityPage(driver).addiplocation2andverify();
            Thread.sleep(1000);
          
           logInfo.pass("IP shipping record deleted successfully.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^Navigatetoorganizationandverify$")
public void Navigatetoorganization1andverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Navigatetoorganization1andverify");
            new MyOrganizationPage(driver).Navigatetoorganization1andverify();
            Thread.sleep(1000);
          
           logInfo.pass("Verify navigated to Organization 1 and Organization Contact section displayed in the left panel.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^Click On Hyperlink of organization as \"([^\"]*)\"$")
public void click_On_Hyperlink_of_organization_as(String arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Hyperlink of organization");
         new MyOrganizationPage(driver).click_On_Hyperlink_of_organization(arg1);
         Thread.sleep(5000);
       
        logInfo.pass("click_On_Action_Under_OrganizationAffiliation_as");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}


@Then("^Click Facility/Department Affiliations Section$")
public void Click_Facility_Department_Affiliations_Tab() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Click_Facility_Department_Affiliations_Tab");
         new MyOrganizationPage(driver).Click_Facility_Department_Affiliations_Tab();
         Thread.sleep(5000);
       
        logInfo.pass("Click_Facility_Department_Affiliations_Tab");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Click On Hyperlink of Organization (\\d+)$")
public void click_On_Hyperlink_of_Organization(int arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Hyperlink of organization "+arg1);
         new MyOrganizationPage(driver).click_On_Hyperlink_of_organization(arg1);
         Thread.sleep(5000);
       
        logInfo.pass("Click On Hyperlink of organization "+arg1);
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}




@Then("^Click On Add Affiliated Facilty/Department Button$")
public void Click_AddAffiliatedFaciltyDepartment_Button() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Add Affiliated Facilty/Department Button");
         new MyOrganizationPage(driver).Click_AddAffiliatedFaciltyDepartment_Button();
         Thread.sleep(5000);
       
        logInfo.pass("Click On Add Affiliated Facilty/Department Button");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Verify Add Affiliated Facilty/Department Button Not Displayed$")
public void Verify_AddAffiliatedFaciltyDepartment_Button_Not_Displayed() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Add Affiliated Facilty/Department Button Not Displayed");
         new MyOrganizationPage(driver).Verify_AddAffiliatedFaciltyDepartment_Button_Not_Displayed();
         Thread.sleep(5000);
       
        logInfo.pass("Verify Add Affiliated Facilty/Department Button Not Displayed");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Click On Action Under OrganizationAffiliation as \"([^\"]*)\"$")
public void click_On_Action_Under_OrganizationAffiliation_as(String arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"click_On_Action_Under_OrganizationAffiliation_as");
         new MyOrganizationPage(driver).Click_On_Action_Under_OrganizationAffiliation_as(arg1);
         Thread.sleep(1000);
       
        logInfo.pass("click_On_Action_Under_OrganizationAffiliation_as");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Select Facility (\\d+) Country From Country Dropdown$")
public void select_Facility_Country_From_Country_Dropdown(int arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Select Facility "+arg1+" Country From Country Dropdown");
         new MyOrganizationPage(driver).select_Facility_Country_From_Country_Dropdown(arg1);
         Thread.sleep(3000);
       
        logInfo.pass("Select Facility "+arg1+" Country From Country Dropdown");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Set Facility (\\d+) In Facility Name TextBox$")
public void set_Facility_In_Facility_Name_TextBox(int arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Set Facility "+arg1+" In Facility Name TextBox");
         new MyOrganizationPage(driver).set_Facility_In_Facility_Name_TextBox(arg1);
         Thread.sleep(3000);
       
        logInfo.pass("Set Facility "+arg1+" In Facility Name TextBox");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Set Department (\\d+) In Department Name Text box$")
public void SetDepartmentInDepartmentNameTextbox(int arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Set Department "+arg1+" In Department Name Text box");
         new MyOrganizationPage(driver).SetDepartmentInDepartmentNameTextbox(arg1);
         Thread.sleep(3000);
       
        logInfo.pass("Set Department "+arg1+" In Department Name Text box");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Select Department Type Of Department (\\d+) In Department Name & Address Screen$")
public void select_Department_Type_Of_Department_In_Department_Name_Address_Screen(int arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Select Department Type Of Department "+arg1+" In Department Name & Address Screen");
         new MyOrganizationPage(driver).select_Department_Type_Of_Department_In_Department_Name_Address_Screen(arg1);
         Thread.sleep(3000);
       
        logInfo.pass("Select Department Type Of Department "+arg1+" In Department Name & Address Screen");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Click On save Button In Department Name & Address Screen$")
public void click_On_save_Button_In_Department_Name_Address_Screen() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Click On save Button In Department Name & Address Screen");
         new MyOrganizationPage(driver).click_On_save_Button_In_Department_Name_Address_Screen();
         Thread.sleep(10000);
       
        logInfo.pass("Click On save Button In Department Name & Address Screen");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Verify New Department Created/ Identify Contact PopUp Displayed$")
public void VerifyNewDepartmentCreatedIdentifyContactPopUpDisplayed() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Verify New Department Created/ Identify Contact PopUp Displayed");
         new MyOrganizationPage(driver).VerifyNewDepartmentCreatedIdentifyContactPopUpDisplayed();
         Thread.sleep(1000);
       
        logInfo.pass("Verify New Department Created/ Identify Contact PopUp Displayed");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}


@Then("^Click On Option I_WILL_CREATE_MAINTAIN_THE_DEPARTMENT_PROFILE$")
public void ClickOnOption_I_WILL_CREATE_MAINTAIN_THE_DEPARTMENT_PROFILE() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Option I_WILL_CREATE_MAINTAIN_THE_DEPARTMENT_PROFILE");
         new MyOrganizationPage(driver).ClickOnOption_I_WILL_CREATE_MAINTAIN_THE_DEPARTMENT_PROFILE();
         Thread.sleep(15000);
       
        logInfo.pass("Click On Option I_WILL_CREATE_MAINTAIN_THE_DEPARTMENT_PROFILE");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}


@Then("^Click On GO TO MY USER PROFILE Button$")
public void ClickOnGOTOMYUSERPROFILEButton() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Click On GO TO MY USER PROFILE Button");
         new MyOrganizationPage(driver).ClickOnGOTOMYUSERPROFILEButton();
         Thread.sleep(15000);
       
        logInfo.pass("Click On GO TO MY USER PROFILE Button");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Verify Facility (\\d+) And Department (\\d+) Is Displayed In Facilities Screen$")
public void verify_Facility_And_Department_Is_Displayed_In_Facilities_Screen(int arg1, int arg2) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility "+arg1+" And Department "+arg2+" Is Displayed In Facilities Screen");
         new MyOrganizationPage(driver).verify_Facility_And_Department_Is_Displayed_In_Facilities_Screen(arg1,arg2);
         Thread.sleep(2000);
       
        logInfo.pass("Verify Facility "+arg1+" And Department "+arg2+" Is Displayed In Facilities Screen");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Click Department (\\d+) Of Facility (\\d+) Is Displayed In Facilities Screen$")
public void click_Department_Of_Facility_Is_Displayed_In_Facilities_Screen(int dept, int fac) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Click Deparment "+dept+" of Facility "+fac+" In Facilities Screen");
         new MyOrganizationPage(driver).click_Department_Of_Facility_Is_Displayed_In_Facilities_Screen(dept,fac);
         Thread.sleep(10000);
       
        logInfo.pass("Click Deparment "+dept+" of Facility "+fac+" In Facilities Screen");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Click Deparment (\\d+) of Facility (\\d+) In Facilities Screen$")
public void click_On_Facility_Displayed_In_Facilities_Screen(int arg2, int arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Click Deparment "+arg2+" of Facility "+arg1+" In Facilities Screen");
         new MyOrganizationPage(driver).click_On_Department_Displayed_In_Facilities_Screen(arg2,arg1);
         Thread.sleep(10000);
       
        logInfo.pass("Click Deparment "+arg2+" of Facility "+arg1+" In Facilities Screen");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Click On ADD Department Icon Against Facility (\\d+) In Search Facility/Department Affiliations Screen$")
public void Click_On_ADD_Department_Icon_Against_Facility_In_Search_FacilityDepartment_Affiliations_Screen(int arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Click On ADD Department Icon Against Facility "+arg1+" In Search Facility/Department Affiliations Screen");
         new MyOrganizationPage(driver).Click_On_ADD_Department_Icon_Against_Facility_In_Search_FacilityDepartment_Affiliations_Screen(arg1);
         Thread.sleep(10000);
       
        logInfo.pass("Click On ADD Department Icon Against Facility "+arg1+" In Search Facility/Department Affiliations Screen");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Verify ADD Department Icon Against Facility (\\d+) In Search Facility/Department Affiliations Screen$")
public void verify_ADD_Department_Icon_Against_Facility_In_Search_Facility_Department_Affiliations_Screen(int arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Verify ADD Department Icon Against Facility "+arg1+" In Search Facility/Department Affiliations Screen");
         new MyOrganizationPage(driver).Verify_ADD_Department_Icon_Against_Facility_In_Search_FacilityDepartment_Affiliations_Screen(arg1);
         Thread.sleep(1000);
       
        logInfo.pass("Verify ADD Department Icon Against Facility "+arg1+" In Search Facility/Department Affiliations Screen");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Verify ADD Department Icon Not Displayed Against Facility (\\d+) In Search Facility/Department Affiliations Screen$")
public void verify_ADD_Department_Icon_Not_Displayed_Against_Facility_In_Search_Facility_Department_Affiliations_Screen(int arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Verify ADD Department Icon Not Displayed Against Facility "+arg1+" In Search Facility/Department Affiliations Screen");
         new MyOrganizationPage(driver).Verify_ADD_Department_Icon_Not_Displayed_Against_Facility_In_Search_FacilityDepartment_Affiliations_Screen(arg1);
         Thread.sleep(1000);
       
        logInfo.pass("Verify ADD Department Icon Not Displayed Against Facility "+arg1+" In Search Facility/Department Affiliations Screen");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Verify ADD Department Icon Against Facility (\\d+) And Department (\\d+) In Search Facility/Department Affiliations Screen Is Not Displayed$")
public void verify_ADD_Department_Icon_Against_Facility_And_Department_In_Search_Facility_Department_Affiliations_Screen_Is_Not_Displayed(int arg1, int arg2) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Verify ADD Department Icon Against Facility "+arg1+" And Department "+arg2+" In Search Facility/Department Affiliations Screen Is Not Displayed");
         new MyOrganizationPage(driver).Verify_ADD_Department_Icon_Against_Facility_Department_NotPresent(arg1,arg2);
         Thread.sleep(1000);
       
        logInfo.pass("Verify ADD Department Icon Against Facility "+arg1+" And Department "+arg2+" In Search Facility/Department Affiliations Screen Is Not Displayed");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Verify Department Name & Address Screen Is Displayed$")
public void verify_Department_Name_Address_Screen_Is_Displayed() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Department Name & Address Screen Is Displayed");
         new MyOrganizationPage(driver).verify_Department_Name_Address_Screen_Is_Displayed();
         Thread.sleep(1000);
       
        logInfo.pass("Verify Department Name & Address Screen Is Displayed");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}


@Then("^Click On Search button In Search Facility/Department Affiliations Section$")
public void click_On_Search_button_In_Search_Facility_Department_Affiliations_Section() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Search button In Search Facility/Department Affiliations Section");
         new MyOrganizationPage(driver).click_On_Search_button_In_Search_Facility_Department_Affiliations_Section();
         Thread.sleep(8000);
       
        logInfo.pass("Click On Search button In Search Facility/Department Affiliations Section");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Click On Send Msg To OPM Under Action$")
public void click_On_Send_Msg_To_OPM_Under_Action() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"click_On_Action_Under_OrganizationAffiliation_as");
         new MyOrganizationPage(driver).Click_On_Send_Msg_To_OPM_Under_Action();
         logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
         Thread.sleep(1000);
       new MyOrganizationPage(driver).Click_Send_On_Send_Msg_To_OPM_Under_Action();
        logInfo.pass("click_On_Send_Msg_To_OPM_Under_Action");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Nevigate Facility/Department Affiliations section$")
public void nevigate_Facility_Department_Affiliations_section() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"nevigate_Facility_Department_Affiliations_section");
         new MyOrganizationPage(driver).nevigate_Facility_Department_Affiliations_section();
         Thread.sleep(1000);
       
        logInfo.pass("nevigate_Facility_Department_Affiliations_section");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^verify Facility$")
public void verify_Facility() throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"verify_Facility");
         new MyOrganizationPage(driver).verify_Facility();
         Thread.sleep(3000);
       
        logInfo.pass("verify_Facility");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}


@Then("^Navigatetoorganizationcontact$")
public void Navigatetoorganizationcontact() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Navigatetoorganizationcontact");
            new MyOrganizationPage(driver).Navigatetoorganizationcontact();
            Thread.sleep(1000);
          
           logInfo.pass("Site user 1 is able to navgate to organization contact page");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^Navigatetobulkuploadcontactandverify$")
public void Navigatetobulkuploadcontactandverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Navigatetobulkuploadcontactandverify");
            new MyOrganizationPage(driver).Navigatetobulkuploadcontactandverify();
            Thread.sleep(1000);
          
           logInfo.pass("Site user 1 navigated to Send Site User registration invitation page and able to view the breadcrubs");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyradiobuttoninviteorganizationcontact$")
public void verifyradiobuttoninviteorganizationcontact() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyradiobuttoninviteorganizationcontact");
            new MyOrganizationPage(driver).verifyradiobuttoninviteorganizationcontact();
            Thread.sleep(1000);
          
           logInfo.pass("Invite Organization contact is preselected");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}




@Then("^verifyendregistrationinvitation$")
public void verifyendregistrationinvitation() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyendregistrationinvitation");
            new MyOrganizationPage(driver).verifyendregistrationinvitation();
            Thread.sleep(1000);
          
           logInfo.pass("Site user registration page displayed with below components");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^downloadtemplate$")
public void downloadtemplate() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"downloadtemplate");
            new MyOrganizationPage(driver).downloadtemplate();
            Thread.sleep(1000);
          
           logInfo.pass("Sip invitation template is downloaded successfully.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifybuttondisable$")
public void verifybuttondisable() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifybuttondisable");
            new MyOrganizationPage(driver).verifybuttondisable();
            Thread.sleep(1000);
          
           logInfo.pass("Upload and add contact button is disable");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^choosefileselectfile$")
public void choosefileselectfile() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"choosefileselectfile");
            new MyOrganizationPage(driver).choosefileselectfile();
            Thread.sleep(1000);
          
           logInfo.pass("Site user able to choose teplate 1 from local machine");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^clickuploadandaddcontactbutton$")
public void clickuploadandaddcontactbutton() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickuploadandaddcontactbutton");
            new MyOrganizationPage(driver).clickuploadandaddcontactbutton();
            Thread.sleep(1000);
          
           logInfo.pass("Site user able to upload the template and success pop up msg is displayed with ok button");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^clickonokbutton$")
public void clickonokbutton() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickonokbutton");
            new MyOrganizationPage(driver).clickonokbutton();
            Thread.sleep(1000);
          
           logInfo.pass("User click on Ok button");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^Navigateandverifytouserprofileabbriviatedcv$")
public void Navigateandverifytouserprofileabbriviatedcv() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Navigateandverifytouserprofileabbriviatedcv");
            new MyProfilePage(driver).Navigateandverifytouserprofileabbriviatedcv();
            Thread.sleep(1000);
          
           logInfo.pass("Verify already downloaded cv is displayed with member company logo and ID");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^Navigateandverifypullcv$")
public void Navigateandverifypullcv() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Navigateandverifypullcv");
            new MyProfilePage(driver).Navigateandverifypullcv();
            Thread.sleep(1000);
          
           logInfo.pass("Verify that searched user is diaplayed in Search Result with mentioned columns");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^Verifypullcvhistoryno$")
public void Verifypullcvhistoryno() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verifypullcvhistoryno");
            new MyProfilePage(driver).Verifypullcvhistoryno();
            Thread.sleep(1000);
          
           logInfo.pass("Verify no is displayed");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^Verifycheckboxpullcv$")
public void Verifycheckboxpullcv() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verifycheckboxpullcv");
            new MyProfilePage(driver).Verifycheckboxpullcv();
            Thread.sleep(1000);
          
           logInfo.pass("Verify list of cvs displayed with mentioned fields");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^Verifydownloadgeneratedcv$")
public void Verifydownloadgeneratedcv() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verifydownloadgeneratedcv");
            new MyProfilePage(driver).Verifydownloadgeneratedcv();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user able to download the generated cv.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^clickok$")
public void clickok() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickok");
            new MyProfilePage(driver).clickok();
            Thread.sleep(1000);
          
           logInfo.pass("click on ok.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^Navigateandverifytouserprofileabbriviatedcv1$")
public void Navigateandverifytouserprofileabbriviatedcv1() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Navigateandverifytouserprofileabbriviatedcv1");
            new MyProfilePage(driver).Navigateandverifytouserprofileabbriviatedcv1();
            Thread.sleep(1000);
          
           logInfo.pass("Verify member company logo and ID are displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifypullhistory$")
public void verifypullhistory() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifypullhistory");
            new MyProfilePage(driver).verifypullhistory();
            Thread.sleep(1000);
          
           logInfo.pass("Verify member company and sposo comp id is diaplyed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^NavigateandverifyMyorganization$")
public void NavigateandverifyMyorganization() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"NavigateandverifyMyorganization");
            new MyProfilePage(driver).NavigateandverifyMyorganization();
            Thread.sleep(1000);
          
           logInfo.pass("Verify organization contact section in the left panel available.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^clickandverifyorganizationcontact$")
public void clickandverifyorganizationcontact() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickandverifyorganizationcontact");
            new MyProfilePage(driver).clickandverifyorganizationcontact();
            Thread.sleep(1000);
          
           logInfo.pass("Verify Site user 1 is able to navigate organization contact page.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyorganizationcontactintable$")
public void verifyorganizationcontactintable() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyorganizationcontactintable");
            new MyProfilePage(driver).verifyorganizationcontactintable();
            Thread.sleep(1000);
          
           logInfo.pass("Verify Site user 2 role is diplayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^clickandverifyremoveicon$")
public void clickandverifyremoveicon() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickandverifyremoveicon");
            new MyProfilePage(driver).clickandverifyremoveicon();
            Thread.sleep(1000);
          
           logInfo.pass("Verify Site user 1 is able to view a pop up msg.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}




@Then("^clickandverifyokbutton$")
public void clickandverifyokbutton() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickandverifyokbutton");
            new MyProfilePage(driver).clickandverifyokbutton();
            Thread.sleep(1000);
          
           logInfo.pass("Verify pop up is closed and navigated to the table");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifyroleintable$")
public void verifyroleintable() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyroleintable");
            new MyProfilePage(driver).verifyroleintable();
            Thread.sleep(1000);
          
           logInfo.pass("Verify site user 2 is showing with role ");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^Navigatandverifyoworkspace$")
public void Navigatandverifyoworkspace() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Navigatandverifyoworkspace");
            new MyOrganizationPage(driver).Navigatandverifyoworkspace();
            Thread.sleep(1000);
          
           logInfo.pass("Verify upload new document is displayed with mentioned fields ");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^uploaddocumententerfieldsandverify$")
public void uploaddocumententerfieldsandverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"uploaddocumententerfieldsandverify");
            new MyOrganizationPage(driver).uploaddocumententerfieldsandverify();
            Thread.sleep(1000);
          
           logInfo.pass("Verify Site user is not displayed ");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^selectPIandverify$")
public void selectPIandverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"selectPIandverify");
            new MyOrganizationPage(driver).selectPIandverify();
            Thread.sleep(1000);
          
           logInfo.pass("Verify Site user is not displayed ");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^PIselectionandsubmit$")
public void PIselectionandsubmit() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"PIselectionandsubmit");
            new MyProfilePage(driver).PIselectionandsubmit();
            Thread.sleep(1000);
          
           logInfo.pass("Verify Site user able to and submit PI ");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifysiteuser2$")
public void verifysiteuser2() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifysiteuser2");
            new MyOrganizationPage(driver).verifysiteuser2();
            Thread.sleep(1000);
          
           logInfo.pass("Verify Site user2 is diaplayed ");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^selectsiteuser2upload$")
public void selectsiteuser2upload() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"selectsiteuser2upload");
            new MyOrganizationPage(driver).selectsiteuser2upload();
            Thread.sleep(1000);
          
           logInfo.pass("Verify pop up msg with ok button ");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifydocumentsearch$")
public void verifydocumentsearch() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifydocumentsearch");
            new MyOrganizationPage(driver).verifydocumentsearch();
            Thread.sleep(1000);
          
           logInfo.pass("Verify documnet search screen displayed ");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verfiydocument1searchresult$")
public void verfiydocument1searchresult() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verfiydocument1searchresult");
            new MyOrganizationPage(driver).verfiydocument1searchresult();
            Thread.sleep(1000);
          
           logInfo.pass("Verify documnet1 is diaplayed ");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^Navigatetocommondocument$")
public void Navigatetocommondocument() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Navigatetocommondocument");
            new MyOrganizationPage(driver).Navigatetocommondocument();
            Thread.sleep(1000);
          
           logInfo.pass("Verify documnet search screen is displayed ");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}





@Then("^Navigatetopublicationpresentation$")
public void Navigatetopublicationpresentation() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Navigatetopublicationpresentation");
            new MyProfilePage(driver).Navigatetopublicationpresentation();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user is navigated to Publication & presentation section ");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^verifyaddrecordpublication$")
public void verifyaddrecordpublication() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyaddrecordpublication");
            new MyProfilePage(driver).verifyaddrecordpublication();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user is able to add records to journal/Abstract field ");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyerrormsg1$")
public void verifyerrormsg1() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyerrormsg1");
            new MyProfilePage(driver).verifyerrormsg1();
            Thread.sleep(1000);
          
           logInfo.pass("Verify error msg is displayed with ok button ");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifypublicationpopup$")
public void verifypublicationpopup() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifypublicationpopup");
            new MyProfilePage(driver).verifypublicationpopup();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user navigate back to publication pop up ");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^presentationsubsection$")
public void presentationsubsection() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"presentationsubsection");
            new MyProfilePage(driver).presentationsubsection();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user is able to add records tp presentation ,title,location ");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyerrormsg2$")
public void verifyerrormsg2() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyerrormsg2");
            new MyProfilePage(driver).verifyerrormsg2();
            Thread.sleep(1000);
          
           logInfo.pass("Verify error msg is displayed ");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifypresentationpopup$")
public void verifypresentationpopup() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifypresentationpopup");
            new MyProfilePage(driver).verifypresentationpopup();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user navigated back to Prsentation pop up ");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^Verifyprofessionalexpsection$")
public void Verifyprofessionalexpsection() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verifyprofessionalexpsection");
            new MyProfilePage(driver).Verifyprofessionalexpsection();
            Thread.sleep(1000);
          
           logInfo.pass("Verify professional exp with on sceen text displayed. ");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^Verifyaddprofessionalexp$")
public void Verifyaddprofessionalexp() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verifyaddprofessionalexp");
            new MyProfilePage(driver).Verifyaddprofessionalexp();
            Thread.sleep(1000);
          
           logInfo.pass("Verify following fields are displayed. ");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}




@Then("^Verifyclickingcurrentposition$")
public void Verifyclickingcurrentposition() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verifyclickingcurrentposition");
            new MyProfilePage(driver).Verifyclickingcurrentposition();
            Thread.sleep(1000);
          
           logInfo.pass("Enter all the details . ");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^verifyperviousenterdrecord$")
public void verifyperviousenterdrecord() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyperviousenterdrecord");
            new MyProfilePage(driver).verifyperviousenterdrecord();
            Thread.sleep(1000);
          
           logInfo.pass("Verify recod 1 is displayed. ");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyyearcompletedfielddisplayed$")
public void verifyyearcompletedfielddisplayed() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyyearcompletedfielddisplayed");
            new MyProfilePage(driver).verifyyearcompletedfielddisplayed();
            Thread.sleep(1000);
          
           logInfo.pass("Verify year completed displayed as present. ");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^Verifyprofessionalsectioncompleted$")
public void Verifyprofessionalsectioncompleted() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verifyprofessionalsectioncompleted");
            new MyProfilePage(driver).Verifyprofessionalsectioncompleted();
            Thread.sleep(1000);
          
           logInfo.pass("Verify year completed displayed as present. ");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyrecord2$")
public void verifyrecord2() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyrecord2");
            new MyProfilePage(driver).verifyrecord2();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user redirected to record 2 ");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyyearcompletedblank$")
public void verifyyearcompletedblank() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyyearcompletedblank");
            new MyProfilePage(driver).verifyyearcompletedblank();
            Thread.sleep(1000);
          
           logInfo.pass("Verify remove icon displayed ");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyprofessionscreenwitheditandremove$")
public void verifyprofessionscreenwitheditandremove() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyprofessionscreenwitheditandremove");
            new MyProfilePage(driver).verifyprofessionscreenwitheditandremove();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user able to add record 3");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^verifyrecord3$")
public void verifyrecord3() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyrecord3");
            new MyProfilePage(driver).verifyrecord3();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user able to see completed and remove button");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifyresearchexp$")
public void verifyresearchexp() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyresearchexp");
            new MyProfilePage(driver).verifyresearchexp();
            Thread.sleep(1000);
          
           logInfo.pass("Verify Record 3 is saved and displayed under professional exp.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyeditremoveicons$")
public void verifyeditremoveicons() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyeditremoveicons");
            new MyProfilePage(driver).verifyeditremoveicons();
            Thread.sleep(1000);
          
           logInfo.pass("Verify edit remove icons are displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^clickonmytaskandverify$")
public void clickonmytaskandverify() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickonmytaskandverify");
            new MyProfilePage(driver).clickonmytaskandverify();
            Thread.sleep(1000);
          
           logInfo.pass("Verify the task title and description.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^NevigateToMyTaskAndVerify$")
public void nevigatetomytaskandverify() throws Throwable {
	 ExtentTest logInfo = null;
     try {
        
    
         logInfo = test.createNode(new GherkinKeyword("Then"),"clickonmytaskandverify");
          new MyProfilePage(driver).clickonmytaskSiteUser();
          Thread.sleep(1000);
        
         logInfo.pass("Verify the task title and description.");
         logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
     } catch (AssertionError | Exception e){
         testStepHandle("FAIL",driver,logInfo,e);
     }
}

@Then("^NevigateToMyTaskPageAndVerify as \"([^\"]*)\"$")
public void nevigatetomytaskpageandverify_as(String arg1) throws Throwable {
	 ExtentTest logInfo = null;
     try {
        
    
         logInfo = test.createNode(new GherkinKeyword("Then"),"NevigateToMyTaskPageAndVerify");
          new SipApplicationLandingPage(driver).NavigateToMyTaskPage(arg1);
          Thread.sleep(1000);
        
         logInfo.pass("Verify the task title and description.");
         logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
     } catch (AssertionError | Exception e){
         testStepHandle("FAIL",driver,logInfo,e);
     }
}

@Then("^ClickOnUserProfileTaskTitle as \"([^\"]*)\"$")
public void clickonuserprofiletasktitle_as(String arg1) throws Throwable {
	 ExtentTest logInfo = null;
     try {
        
    
         logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnUserProfileTaskTitle");
          new SipApplicationLandingPage(driver).ClickOnUserProfileTaskTitle(arg1);
          Thread.sleep(1000);
        
         logInfo.pass("ClickOnUserProfileTaskTitle");
         logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
     } catch (AssertionError | Exception e){
         testStepHandle("FAIL",driver,logInfo,e);
     }
}

@Then("^ClickOnRelaseTask$")
public void clickonrelasetask() throws Throwable {
	 ExtentTest logInfo = null;
     try {
        
    
         logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnRelaseTask");
          new SipApplicationLandingPage(driver).ClickOnRelaseTask();
          logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
          Thread.sleep(1000);
        new SipApplicationLandingPage(driver).ClickOnRelaseOK();
         logInfo.pass("ClickOnRelaseTask");
         logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
     } catch (AssertionError | Exception e){
         testStepHandle("FAIL",driver,logInfo,e);
     }
}
@Then("^ClickOnTaskTitle as \"([^\"]*)\"$")
public void clickontasktitle_as(String arg1) throws Throwable {
	 ExtentTest logInfo = null;
     try {
        
    
         logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnTaskTitle");
          new SipApplicationLandingPage(driver).ClickOnTaskTitle(arg1);
          Thread.sleep(1000);
        
         logInfo.pass("ClickOnTaskTitle.");
         logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
     } catch (AssertionError | Exception e){
         testStepHandle("FAIL",driver,logInfo,e);
     }
}

@Then("^ClickTheLinkForDownload$")
public void clickthelinkfordownload() throws Throwable {
	 ExtentTest logInfo = null;
     try {
        
    
         logInfo = test.createNode(new GherkinKeyword("Then"),"ClickTheLinkForDownload");
          new MyProfilePage(driver).ClickTheLinkForDownload();
          Thread.sleep(1000);
        
         logInfo.pass("ClickTheLinkForDownload");
         logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
     } catch (AssertionError | Exception e){
         testStepHandle("FAIL",driver,logInfo,e);
     }
}


@Then("^verifysendforapprovalenable$")
public void verifysendforapprovalenable() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifysendforapprovalenable");
            new MyProfilePage(driver).verifysendforapprovalenable();
            Thread.sleep(1000);
          
           logInfo.pass("Verify the task title and description.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^ClickOnSendAllChangesForApprovelButton$")
public void clickonsendallchangesforapprovelbutton() throws Throwable {
	 ExtentTest logInfo = null;
     try {
        
    
         logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnSendAllChangesForApprovelButton");
          new MyProfilePage(driver).ClickOnSendAllChangesForApprovelButton();
          Thread.sleep(1000);
        
         logInfo.pass("ClickOnSendAllChangesForApprovelButton");
         logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
     } catch (AssertionError | Exception e){
         testStepHandle("FAIL",driver,logInfo,e);
     }
}


@Then("^verifyredirecttotodelegatedprofile$")
public void verifyredirecttotodelegatedprofile() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyredirecttotodelegatedprofile");
            new MyProfilePage(driver).verifyredirecttotodelegatedprofile();
            Thread.sleep(1000);
          
           logInfo.pass("Verify site user 2 redirected to delegated profile screen.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^clickonmytaskandverify1$")
public void clickonmytaskandverify1() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickonmytaskandverify1");
            new MyProfilePage(driver).clickonmytaskandverify();
            Thread.sleep(1000);
          
           logInfo.pass("Verify the task title and description.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyapproverejectbuttons$")
public void verifyapproverejectbuttons() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyapproverejectbuttons");
            new MyProfilePage(driver).verifyapproverejectbuttons();
            Thread.sleep(1000);
          
           logInfo.pass("Verify ApproveAll & Reject all buttons are displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifynavigateeachsections$")
public void verifynavigateeachsections() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifynavigateeachsections");
            new MyProfilePage(driver).verifynavigateeachsections();
            Thread.sleep(1000);
          
           logInfo.pass("Verify successfull msg displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^profiledelegationtaskstill$")
public void profiledelegationtaskstill() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"profiledelegationtaskstill");
            new MyProfilePage(driver).profiledelegationtaskstill();
            Thread.sleep(1000);
          
           logInfo.pass("Verify profile delegation task still present.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyuserprofilemenu$")
public void verifyuserprofilemenu() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyuserprofilemenu");
            new MyProfilePage(driver).verifyuserprofilemenu();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user able to see mentioned attaibute.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyprofilesummary$")
public void verifyprofilesummary() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyprofilesummary");
            new MyProfilePage(driver).verifyprofilesummary();
            Thread.sleep(1000);
          
           logInfo.pass("Verify ste user is able to redirect to user profile summary section.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifymentionedtab$")
public void verifymentionedtab() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifymentionedtab");
            new MyProfilePage(driver).verifymentionedtab();
            Thread.sleep(1000);
          
           logInfo.pass("Verify mentioned fields are displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifyfollowingattribute$")
public void verifyfollowingattribute() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyfollowingattribute");
            new MyProfilePage(driver).verifyfollowingattribute();
            Thread.sleep(1000);
          
           logInfo.pass("Verify following attributes are displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyprofilephoto$")
public void verifyprofilephoto() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyprofilephoto");
            new MyProfilePage(driver).verifyprofilephoto();
            Thread.sleep(1000);
          
           logInfo.pass("Verify pop up mshg is displayed with following details.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyuserprofilesummarysection$")
public void verifyuserprofilesummarysection() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyuserprofilesummarysection");
            new MyProfilePage(driver).verifyuserprofilesummarysection();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user redirected to user profile summary screen.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^verifyerrormsg12$")
public void verifyerrormsg12() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyerrormsg12");
            new MyProfilePage(driver).verifyerrormsg12();
            Thread.sleep(1000);
          
           logInfo.pass("Verify error msg is displayed..");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^uploadimage$")
public void uploadimage() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"uploadimage");
            new MyProfilePage(driver).uploadimage();
            Thread.sleep(1000);
          
           logInfo.pass("Verify upload image is displayed as profile picture.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifysipuserprofile$")
public void verifysipuserprofile() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifysipuserprofile");
            new MyProfilePage(driver).verifysipuserprofile();
            Thread.sleep(1000);
          
           logInfo.pass("Verify profile form button is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^Verifysuccessulmsg$")
public void Verifysuccessulmsg() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verifysuccessulmsg");
            new MyProfilePage(driver).Verifysuccessulmsg();
            Thread.sleep(1000);
          
           logInfo.pass("Verify successful msg is displayed with ok buton.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifyupdates$")
public void verifyupdates() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyupdates");
            new MyProfilePage(driver).verifyupdates();
            Thread.sleep(1000);
          
           logInfo.pass("Verify updates are refelcted.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^Verifynonotification$")
public void Verifynonotification() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verifynonotification");
            new MyProfilePage(driver).Verifynonotification();
            Thread.sleep(1000);
          
           logInfo.pass("Verify no notification present.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifytablenorecord$")
public void verifytablenorecord() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifytablenorecord");
            new MyProfilePage(driver).verifytablenorecord();
            Thread.sleep(1000);
          
           logInfo.pass("Verify that the table displays value as 'No Records.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyexportprofile$")
public void verifyexportprofile() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyexportprofile");
            new MyProfilePage(driver).verifyexportprofile();
            Thread.sleep(1000);
          
           logInfo.pass("Verify that Export User Profile button is visible.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^clickandverifyexportprofile$")
public void clickandverifyexportprofile() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickandverifyexportprofile");
            new MyProfilePage(driver).clickandverifyexportprofile();
            Thread.sleep(1000);
          
           logInfo.pass("Verify msg is displayed with export and cancel .");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^clickexport$")
public void clickexport() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickexport");
            new MyProfilePage(driver).clickexport();
            Thread.sleep(1000);
          
           logInfo.pass("Verify msg2 is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^Site User Navigate To Notification Screen$")
public void NavigateToNotification() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Site User Navigate To Notification Screen");
            new MyProfilePage(driver).NavigateToNotification();
            Thread.sleep(10000);
          
           logInfo.pass("Site User Navigate To Notification Screen");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^Verify Facility Contacts Role Added Notification For Site User For Facility (\\d+)$")
public void verify_Facility_Contacts_Role_Added_Notification_For_Site_User(int arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility Contacts Role Added Notification For Site User For Facility "+arg1);
         new MyProfilePage(driver).verify_Facility_Profile_Management_Notifications_Assignment_Of_Facility_Role(arg1);
         Thread.sleep(1000);
       
        logInfo.pass("Verify Facility Contacts Role Added Notification For Site User For Facility "+arg1);
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Verify Facility Contacts Role Added Notification For Site User For Facility (\\d+) and Department (\\d+)$")
public void verify_Facility_Contacts_Role_Added_Notification_For_Site_User_For_Facility_and_Department(int arg1, int arg2) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility Contacts Role Added Notification For Site User For Facility "+arg1+" and Department "+arg2);
         new MyProfilePage(driver).verify_Facility_Profile_Management_Notifications_Assignment_Of_Department_Role(arg1,arg2);
         Thread.sleep(1000);
       
        logInfo.pass("Verify Facility Contacts Role Added Notification For Site User For Facility "+arg1+" and Department "+arg2);
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Verify Facility Contacts Role Added Notification For Site User For Facility (\\d+) Not Displayed$")
public void verify_Facility_Profile_Management_Notifications_Assignment_Of_Facility_Role_Not_Displayed(int arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility Contacts Role Added Notification For Site User For Facility "+arg1+" Not Displayed");
         new MyProfilePage(driver).verify_Facility_Profile_Management_Notifications_Assignment_Of_Facility_Role_Not_Displayed(arg1);
         Thread.sleep(1000);
       
        logInfo.pass("Verify Facility Contacts Role Added Notification For Site User For Facility "+arg1+" Not Displayed");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Verify Facility Profile Management Notifications For Facility (\\d+) and Department (\\d+) In Notification Screen$")
public void verify_Facility_Profile_Management_Notifications_For_Facility_and_Department_In_Notification_Screen(int arg1, int arg2) throws Throwable {

    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility Profile Management Notifications For Facility "+arg1+" and Department "+arg2+" In Notification Screen");
            new MyProfilePage(driver).verify_Facility_Profile_Management_Notifications_In_Notification_Screen(arg1,arg2);
            Thread.sleep(10000);
          
           logInfo.pass("Verify Facility Profile Management Notifications For Facility "+arg1+" and Department "+arg2+" In Notification Screen");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^Verify Facility Profile Management Notifications For Facility (\\d+) In Notification Screen$")
public void verify_Facility_Profile_Management_Notifications_For_Facility_In_Notification_Screen(int arg1) throws Throwable {

    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility Profile Management Notifications For Facility "+arg1+" In Notification Screen");
            new MyProfilePage(driver).verify_Facility_Profile_Management_Notifications_In_Notification_Screen(arg1);
            Thread.sleep(10000);
          
           logInfo.pass("Verify Facility Profile Management Notifications For Facility "+arg1+" In Notification Screen");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^Verify Facility Profile Management Notifications Not Displayed For Facility (\\d+) In Notification Screen$")
public void verify_Facility_Profile_Management_Notifications_Not_Displayed_In_Notification_Screen(int arg1) throws Throwable {

    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility Profile Management Notifications For Facility "+arg1+" In Notification Screen");
            new MyProfilePage(driver).verify_Facility_Profile_Management_Notifications_Not_Displayed_In_Notification_Screen(arg1);
            Thread.sleep(10000);
          
           logInfo.pass("Verify Facility Profile Management Notifications For Facility "+arg1+" In Notification Screen");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^verifyeducationsectiondisplayed$")
public void verifyeducationsectiondisplayed() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyeducationsectiondisplayed");
            new MyProfilePage(driver).verifyeducationsectiondisplayed();
            Thread.sleep(1000);
          
           logInfo.pass("Verify education section is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyfacilitysection$")
public void verifyfacilitysection() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyfacilitysection");
           new MyProfilePage(driver).verifyfacilitysection();
            Thread.sleep(1000);
          
           logInfo.pass("Verify it navigated to facility section.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifysearchfacilityscreen$")
public void verifysearchfacilityscreen() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifysearchfacilityscreen");
           new MyProfilePage(driver).verifysearchfacilityscreen();
            Thread.sleep(1000);
          
           logInfo.pass("Verify search facility fields are displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifysearchresult$")
public void verifysearchresult() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifysearchresult");
           new MyProfilePage(driver).verifysearchresult();
            Thread.sleep(1000);
          
           logInfo.pass("Verify search result is displayed with list of facility.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifymarkedascompleted$")
public void verifymarkedascompleted() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifymarkedascompleted");
           new MyProfilePage(driver).verifymarkedascompleted();
            Thread.sleep(1000);
          
           logInfo.pass("Verify facioity is showing as completed");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifybasicdetailsection$")
public void verifybasicdetailsection() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifybasicdetailsection");
           new MyProfilePage(driver).verifybasicdetailsection();
            Thread.sleep(1000);
          
           logInfo.pass("Verify navigated to basic details");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifygeneratecv$")
public void verifygeneratecv() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifygeneratecv");
           new MyProfilePage(driver). verifygeneratecv();
            Thread.sleep(1000);
          
           logInfo.pass("Verify that user is redirected to My Profile screen and below button are disabled.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifyfacilitymentionedfields$")
public void verifyfacilitymentionedfields() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyfacilitymentionedfields");
           new MyProfilePage(driver). verifyfacilitymentionedfields();
            Thread.sleep(1000);
          
           logInfo.pass("Verify facility is displayed with all the columns.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyeducationdetails$")
public void verifyeducationdetails() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyeducationdetails");
           new MyProfilePage(driver). verifyeducationdetails();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user is navigated to education details.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifynotapplicableineducation$")
public void verifynotapplicableineducation() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifynotapplicableineducation");
           new MyProfilePage(driver). verifynotapplicableineducation();
            Thread.sleep(1000);
          
           logInfo.pass("Verify that user is navigated to Education Details section.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifynotapplicableinmedical$")
public void verifynotapplicableinmedical() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifynotapplicableinmedical");
           new MyProfilePage(driver). verifynotapplicableinmedical();
            Thread.sleep(1000);
          
           logInfo.pass("Verify that user is navigated to Education Details section.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifynotapplicableprofessionalexp$")
public void verifynotapplicableprofessionalexp() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifynotapplicableprofessionalexp");
           new MyProfilePage(driver).verifynotapplicableprofessionalexp();
            Thread.sleep(1000);
          
           logInfo.pass("Verify that user is navigated to professional exp section.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifyprofessionalexpgreen$")
public void verifyprofessionalexpgreen() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyprofessionalexpgreen");
           new MyProfilePage(driver).verifynotapplicableprofessionalexp();
            Thread.sleep(1000);
          
           logInfo.pass("Verify that user is navigated to professional exp section.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifyresearchexp1$")
public void verifyresearchexp1() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyresearchexp1");
           new MyProfilePage(driver).verifyresearchexp1();
            Thread.sleep(1000);
          
           logInfo.pass("Verify that user is navigated to research exp section.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifynotdisappear$")
public void verifynotdisappear() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifynotdisappear");
           new MyProfilePage(driver).verifynotdisappear();
            Thread.sleep(1000);
          
           logInfo.pass("Verify that mentioned fields are not displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifyresearchgreentick$")
public void verifyresearchgreentick() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyresearchgreentick");
           new MyProfilePage(driver).verifyresearchgreentick();
            Thread.sleep(1000);
          
           logInfo.pass("Verify that mentioned fields are not displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^verifygcpgreentick$")
public void verifygcpgreentick() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifygcpgreentick");
           new MyProfilePage(driver).verifygcpgreentick();
            Thread.sleep(1000);
          
           logInfo.pass("Verify in gcp green tick displayed");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyliceseddetails$")
public void verifyliceseddetails() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyliceseddetails");
           new MyProfilePage(driver).verifyliceseddetails();
            Thread.sleep(1000);
          
           logInfo.pass("Verify in license details green tick displayed");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifylicesedetailspopup$")
public void verifylicesedetailspopup() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifylicesedetailspopup");
           new MyProfilePage(driver).verifylicesedetailspopup();
            Thread.sleep(1000);
          
           logInfo.pass("Verify in license details green tick displayed");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifygeneratecvenable$")
public void verifygeneratecvenable() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifygeneratecvenable");
           new MyProfilePage(driver).verifygeneratecvenable();
            Thread.sleep(1000);
          
           logInfo.pass("Verify generate cv is displayed");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifyprofileattchement$")
public void verifyprofileattchement() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyprofileattchement");
           new MyProfilePage(driver).verifyprofileattchement();
            Thread.sleep(1000);
          
           logInfo.pass("Verify profile attachment is displayed");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifypublicationpresentation$")
public void verifypublicationpresentation() throws Throwable {
   
    ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifypublicationpresentation");
           new MyProfilePage(driver).verifypublicationpresentation();
            Thread.sleep(1000);
          
           logInfo.pass("Verify presentation and publication is displayed");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyleftpanelincomplete$")
public void verifyleftpanelincomplete() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyleftpanelincomplete");
           new MyProfilePage(driver).verifyleftpanelincomplete();
            Thread.sleep(1000);
          
           logInfo.pass("Verify left panel displayed");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifypreviewcvnotdisplayed$")
public void verifypreviewcvnotdisplayed() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifypreviewcvnotdisplayed");
           new MyProfilePage(driver).verifypreviewcvnotdisplayed();
            Thread.sleep(1000);
          
           logInfo.pass("Verify preview cv is not displayed on sreen");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^Navigateanderfyfacility$")
public void Navigateanderfyfacility() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Navigateanderfyfacility");
           new MyProfilePage(driver).Navigateanderfyfacility();
            Thread.sleep(1000);
          
           logInfo.pass("Verify value entered section is displayed");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^Navigateandverifyeducation$")
public void Navigateandverifyeducation() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Navigateandverifyeducation");
           new MyProfilePage(driver).Navigateandverifyeducation();
            Thread.sleep(1000);
          
           logInfo.pass("Verify education value entered section is displayed");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^Navigateandverifyprofessional$")
public void Navigateandverifyprofessional() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Navigateandverifyprofessional");
           new MyProfilePage(driver).Navigateandverifyprofessional();
            Thread.sleep(1000);
          
           logInfo.pass("Verify professional value entered section is displayed");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^Navigateandverifyreseach1$")
public void Navigateandverifyreseach1() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Navigateandverifyreseach1");
           new MyProfilePage(driver).Navigateandverifyreseach1();
            Thread.sleep(1000);
          
           logInfo.pass("Verify research value entered section is displayed");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^Addlicenseanddenforapproval$")
public void Addlicenseanddenforapproval() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Addlicenseanddenforapproval");
           new MyProfilePage(driver).Addlicenseanddenforapproval();
            Thread.sleep(1000);
          
           logInfo.pass("Verify licese details added");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^navigatetoapprovereject$")
public void navigatetoapprovereject() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"navigatetoapprovereject");
           new MyProfilePage(driver).navigatetoapprovereject();
            Thread.sleep(1000);
          
           logInfo.pass("Approve reject screen displayed");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^Verifyapproverejectfields$")
public void Verifyapproverejectfields() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verifyapproverejectfields");
           new MyProfilePage(driver).Verifyapproverejectfields();
            Thread.sleep(1000);
          
           logInfo.pass("navigate screen displayed");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^approveall$")
public void approveall() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"approveall");
           new MyProfilePage(driver).approveall();
            Thread.sleep(1000);
          
           logInfo.pass("Allapprove screen displayed");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyfacilitysectionn$")
public void verifyfacilitysectionn() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyfacilitysectionn");
           new MyProfilePage(driver).verifyfacilitysectionn();
            Thread.sleep(1000);
          
           logInfo.pass("Verify Facility section of User profile is displayed");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyfacilities$")
public void verifyfacilities() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyfacilities");
           new MyProfilePage(driver).verifyfacilities();
            Thread.sleep(1000);
          
           logInfo.pass("Verify Facility and department are displayed");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifyprimaryfacility$")
public void verifyprimaryfacility() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyprimaryfacility");
           new MyProfilePage(driver).verifyprimaryfacility();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user is able to select primary facility");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifyfacility1primary$")
public void verifyfacility1primary() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyfacility1primary");
           new MyProfilePage(driver).verifyfacility1primary();
            Thread.sleep(1000);
          
           logInfo.pass("Verify facility 1 marked as primary facility.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyfacility2primary$")
public void verifyfacility2primary() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyfacility2primary");
           new MyProfilePage(driver).verifyfacility2primary();
            Thread.sleep(1000);
          
           logInfo.pass("Verify facility 2 marked as primary facility.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^Navigatetomyprofileverifynotapplicable$")
public void Navigatetomyprofileverifynotapplicable() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Navigatetomyprofileverifynotapplicable");
           new MyProfilePage(driver).Navigatetomyprofileverifynotapplicable();
            Thread.sleep(1000);
          
           logInfo.pass("Verify not applicable checkbox is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifypopup1mentionedfields$")
public void verifypopup1mentionedfields() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifypopup1mentionedfields");
           new MyProfilePage(driver).verifypopup1mentionedfields();
            Thread.sleep(1000);
          
           logInfo.pass("Verify sysstem displays pop up with mentioned fields .");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^verifyresearchexpsection$")
public void verifyresearchexpsection() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyresearchexpsection");
           new MyProfilePage(driver).verifyresearchexpsection();
            Thread.sleep(1000);
          
           logInfo.pass("Verify research experience section is displayed .");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^verifyRecord1addedintototalclinicalexp$")
public void verifyRecord1addedintototalclinicalexp() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyRecord1addedintototalclinicalexp");
           new MyProfilePage(driver).verifyRecord1addedintototalclinicalexp();
            Thread.sleep(1000);
          
           logInfo.pass("Verify record 1 is added.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifymsg1withokbutton$")
public void verifymsg1withokbutton() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifymsg1withokbutton");
           new MyProfilePage(driver).verifymsg1withokbutton();
            Thread.sleep(1000);
          
           logInfo.pass("Verify msg displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^verifyrecord2clinicalresearchexp$")
public void verifyrecord2clinicalresearchexp() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyrecord2clinicalresearchexp");
           new MyProfilePage(driver).verifyrecord2clinicalresearchexp();
            Thread.sleep(1000);
          
           logInfo.pass("Verify record 2 is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifytotalclinicalresearchexp$")
public void verifytotalclinicalresearchexp() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifytotalclinicalresearchexp");
           new MyProfilePage(driver).verifytotalclinicalresearchexp();
            Thread.sleep(1000);
          
           logInfo.pass("Verify added records are displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifypopupsaveandcancel$")
public void verifypopupsaveandcancel() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifypopupsaveandcancel");
           new MyProfilePage(driver).verifypopupsaveandcancel();
            Thread.sleep(1000);
          
           logInfo.pass("Verify system displays the slected record in pop up edit the value with save and cancel buttons.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifymsg1withokbutton1$")
public void verifymsg1withokbutton1() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifymsg1withokbutton1");
           new MyProfilePage(driver).verifymsg1withokbutton1();
            Thread.sleep(1000);
          
           logInfo.pass("Verify pop up msg is displayed with ok button.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyrecord2totalclinalexp$")
public void verifyrecord2totalclinalexp() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyrecord2totalclinalexp");
           new MyProfilePage(driver).verifyrecord2totalclinalexp();
            Thread.sleep(1000);
          
           logInfo.pass("Verify record 2 is dsiplayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyreord2removed$")
public void verifyreord2removed() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyreord2removed");
           new MyProfilePage(driver).verifyreord2removed();
            Thread.sleep(1000);
          
           logInfo.pass("Verify record 2 is removed from Research exp.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifymessage2withokbutton$")
public void verifymessage2withokbutton() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifymessage2withokbutton");
           new MyProfilePage(driver).verifymessage2withokbutton();
            Thread.sleep(1000);
          
           logInfo.pass("Verify msg 2 is displayed with ok button.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^navigatetogcp$")
public void navigatetogcp() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"navigatetogcp");
           new MyProfilePage(driver).navigatetogcp();
            Thread.sleep(1000);
          
           logInfo.pass("Verify navigated to GCP training.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifybasicdetailssection$")
public void verifybasicdetailssection() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifybasicdetailssection");
           new MyProfilePage(driver).verifybasicdetailssection();
            Thread.sleep(1000);
          
           logInfo.pass("Verify basic details section is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyuploadform$")
public void verifyuploadform() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyuploadform");
           new MyProfilePage(driver).verifyuploadform();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user is able to upload form successfully.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^navigateandverifyeachsection$")
public void navigateandverifyeachsection() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"navigateandverifyeachsection");
           new MyProfilePage(driver).navigateandverifyeachsection();
            Thread.sleep(1000);
          
           logInfo.pass("Verify no data is available for above section.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifybasicdetailsupdate$")
public void verifybasicdetailsupdate() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifybasicdetailsupdate");
           new MyProfilePage(driver).verifybasicdetailsupdate();
            Thread.sleep(1000);
          
           logInfo.pass("Verify basic details section is updated.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyoverwritten$")
public void verifyoverwritten() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyoverwritten");
           new MyProfilePage(driver).verifyoverwritten();
            Thread.sleep(1000);
          
           logInfo.pass("Verify data is not overwriten.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifypublicationpresentationoverwritten$")
public void verifypublicationpresentationoverwritten() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifypublicationpresentationoverwritten");
           new MyProfilePage(driver).verifypublicationpresentationoverwritten();
            Thread.sleep(1000);
          
           logInfo.pass("Verify data is overwitten for publication presentation section.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifysiteuser1delattetosite2$")
public void verifysiteuser1delattetosite2() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifysiteuser1delattetosite2");
           new MyProfilePage(driver).verifysiteuser1delattetosite2();
            Thread.sleep(1000);
          
           logInfo.pass("Verify site user 1 details are displayed under delegated profile.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^navigatetodelegatedprofiles$")
public void navigatetodelegatedprofiles() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"navigatetodelegatedprofiles");
           new MyProfilePage(driver).navigatetodelegatedprofiles();
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
            Thread.sleep(1000);
           new MyProfilePage(driver).ClickOnSiteUserHyperlink();
           logInfo.pass("Verify site user 1 is displayed under delgated profile table.");
           
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^NevigateToApproveRejectUpdates$")
public void nevigatetoapproverejectupdates() throws Throwable {

	   ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"NevigateToApproveRejectUpdates");
        new MyProfilePage(driver).NevigateToApproveRejectUpdates();
        
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
         Thread.sleep(1000);
        logInfo.pass("NevigateToApproveRejectUpdates");
        
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}



@Then("^navigatedtositeuser1$")
public void navigatedtositeuser1() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"navigatedtositeuser1");
           new MyProfilePage(driver).navigatedtositeuser1();
            Thread.sleep(1000);
          
           logInfo.pass("Verify site user 2 is navigated to site user 1.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^clickonokbuttonwithconfirmation$")
public void clickonokbuttonwithconfirmation() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickonokbuttonwithconfirmation");
           new MyProfilePage(driver).clickonokbuttonwithconfirmation();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user is able to click on ok button the confirmation pop up.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifypullcvsearchscreen$")
public void verifypullcvsearchscreen() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifypullcvsearchscreen");
           new MyProfilePage(driver).verifypullcvsearchscreen();
            Thread.sleep(1000);
          
           logInfo.pass("Verify search result screen is displayed with mentioned data.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifylastgeneratedcvdate$")
public void verifylastgeneratedcvdate() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifylastgeneratedcvdate");
           new MyProfilePage(driver).verifylastgeneratedcvdate();
            Thread.sleep(1000);
          
           logInfo.pass("Verify all record for Last generated cv date is displayed in decending order.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verify10recordsinsearchresult$")
public void verify10recordsinsearchresult() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verify10recordsinsearchresult");
           new MyProfilePage(driver).verify10recordsinsearchresult();
            Thread.sleep(1000);
          
           logInfo.pass("Verify checkboxes are displayed for 10 records .");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verify10recordsinmentionedformat$")
public void verify10recordsinmentionedformat() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verify10recordsinmentionedformat");
           new MyProfilePage(driver).verify10recordsinmentionedformat();
            Thread.sleep(1000);
          
           logInfo.pass("Verify columns name are displayed .");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifywordpdf$")
public void verifywordpdf() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifywordpdf");
           new MyProfilePage(driver).verifywordpdf();
            Thread.sleep(1000);
          
           logInfo.pass("Verify word and pdf documents are displayed .");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^downloadzip$")
public void downloadzip() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"downloadzip");
           new MyProfilePage(driver).downloadzip();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user is able to download the zip .");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifysections$")
public void verifysections() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifysections");
           new MyProfilePage(driver).verifysections();
            Thread.sleep(1000);
          
           logInfo.pass("Verify mentioned section are displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyfacilitysections$")
public void verifyfacilitysections() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyfacilitysections");
           new MyProfilePage(driver).verifyfacilitysections();
            Thread.sleep(1000);
          
           logInfo.pass("Verify facility section 3 facilities are displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^ClickOnApproveTheChange$")
public void clickonapprovethechange() throws Throwable {
	 ExtentTest logInfo = null;
     try {
        
    
         logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnApproveTheChange");
         new MyFacilityPage(driver).ClickOnApproveTheChange();
         Thread.sleep(5000);
         logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
         new MyFacilityPage(driver).ClickOnOk();
          Thread.sleep(1000);
        
         logInfo.pass("ClickOnApproveTheChange");
        
     } catch (AssertionError | Exception e){
         testStepHandle("FAIL",driver,logInfo,e);
     }
}



@Then("^verifyfirstfaciloty$")
public void verifyfirstfaciloty() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyfirstfaciloty");
           new MyProfilePage(driver).verifyfirstfaciloty();
            Thread.sleep(1000);
          
           logInfo.pass("Verify facility name is showing in decending order");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^verifysecondfacility$")
public void verifysecondfacility() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifysecondfacility");
           new MyProfilePage(driver).verifysecondfacility();
            Thread.sleep(1000);
          
           logInfo.pass("Verify facility second facility is displayed");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^verifythirdfacility$")
public void verifythirdfacility() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifythirdfacility");
           new MyProfilePage(driver).verifythirdfacility();
            Thread.sleep(1000);
          
           logInfo.pass("Verify facility third facility is displayed");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


public void verifyeducationyearcompletedcolumn() throws Throwable {
    
	   ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"verifyeducationyearcompletedcolumn");
        new MyProfilePage(driver).verifyeducationyearcompletedcolumn();
         Thread.sleep(1000);
       
        logInfo.pass("Verify facility third facility is displayed");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}


public void verifyaddcompleted() throws Throwable {
    
	   ExtentTest logInfo = null;
 try {
    

     logInfo = test.createNode(new GherkinKeyword("Then"),"verifyaddcompleted");
     new MyProfilePage(driver).verifyaddcompleted();
      Thread.sleep(1000);
    
     logInfo.pass("Verify added data is displayed in the education section");
     logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
 } catch (AssertionError | Exception e){
     testStepHandle("FAIL",driver,logInfo,e);
 }
}


public void verifyprofessionalexpyearstrted() throws Throwable {
    
	   ExtentTest logInfo = null;
try {
 

  logInfo = test.createNode(new GherkinKeyword("Then"),"verifyprofessionalexpyearstrted");
  new MyProfilePage(driver).verifyprofessionalexpyearstrted();
   Thread.sleep(1000);
 
  logInfo.pass("Verify professional exp is displayed .");
  logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
} catch (AssertionError | Exception e){
  testStepHandle("FAIL",driver,logInfo,e);
}
}


public void verifyaddprofessionalexpyearstrted() throws Throwable {
    
	   ExtentTest logInfo = null;
try {


logInfo = test.createNode(new GherkinKeyword("Then"),"verifyaddprofessionalexpyearstrted");
new MyProfilePage(driver).verifyaddprofessionalexpyearstrted();
Thread.sleep(1000);

logInfo.pass("Verify professional exp sort displayed .");
logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
} catch (AssertionError | Exception e){
testStepHandle("FAIL",driver,logInfo,e);
}
}


public void verifyresearchexp2() throws Throwable {
    
	   ExtentTest logInfo = null;
try {


logInfo = test.createNode(new GherkinKeyword("Then"),"verifyresearchexp2");
new MyProfilePage(driver).verifyresearchexp2();
Thread.sleep(1000);

logInfo.pass("Verify research exp sort displayed .");
logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
} catch (AssertionError | Exception e){
testStepHandle("FAIL",driver,logInfo,e);
}
}


public void verifyaddtheraputic() throws Throwable {
    
	   ExtentTest logInfo = null;
try {


logInfo = test.createNode(new GherkinKeyword("Then"),"verifyaddtheraputic");
new MyProfilePage(driver).verifyaddtheraputic();
Thread.sleep(1000);

logInfo.pass("Verify theraputic area is displayed in sorting order.");
logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
} catch (AssertionError | Exception e){
testStepHandle("FAIL",driver,logInfo,e);
}
}


public void verifysubtheraputicarea() throws Throwable {
    
	   ExtentTest logInfo = null;
try {


logInfo = test.createNode(new GherkinKeyword("Then"),"verifysubtheraputicarea");
new MyProfilePage(driver).verifysubtheraputicarea();
Thread.sleep(1000);

logInfo.pass("Verify sub theraputic area is displayed in sorting order.");
logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
} catch (AssertionError | Exception e){
testStepHandle("FAIL",driver,logInfo,e);
}
}


public void saveandverify() throws Throwable {
    
	   ExtentTest logInfo = null;
try {


logInfo = test.createNode(new GherkinKeyword("Then"),"saveandverify");
new MyProfilePage(driver).saveandverify();
Thread.sleep(1000);

logInfo.pass("Verify research exp saved successfully.");
logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
} catch (AssertionError | Exception e){
testStepHandle("FAIL",driver,logInfo,e);
}
}


public void verifygcp() throws Throwable {
    
	   ExtentTest logInfo = null;
try {


logInfo = test.createNode(new GherkinKeyword("Then"),"verifygcp");
new MyProfilePage(driver).verifygcp();
Thread.sleep(1000);

logInfo.pass("Verify GCP displayed successfully.");
logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
} catch (AssertionError | Exception e){
testStepHandle("FAIL",driver,logInfo,e);
}
}


public void verifygcpdatecompleted() throws Throwable {
    
	   ExtentTest logInfo = null;
try {


logInfo = test.createNode(new GherkinKeyword("Then"),"verifygcpdatecompleted");
new MyProfilePage(driver).verifygcpdatecompleted();
Thread.sleep(1000);

logInfo.pass("Verify GCP saved successfully.");
logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
} catch (AssertionError | Exception e){
testStepHandle("FAIL",driver,logInfo,e);
}
}


public void verifylicensedetailissuedate() throws Throwable {
    
	   ExtentTest logInfo = null;
try {


logInfo = test.createNode(new GherkinKeyword("Then"),"verifylicensedetailissuedate");
new MyProfilePage(driver).verifylicensedetailissuedate();
Thread.sleep(1000);

logInfo.pass("Verify license details section is displayed.");
logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
} catch (AssertionError | Exception e){
testStepHandle("FAIL",driver,logInfo,e);
}
}


public void verifylicesedetailssorting() throws Throwable {
    
	   ExtentTest logInfo = null;
try {


logInfo = test.createNode(new GherkinKeyword("Then"),"verifylicesedetailssorting");
new MyProfilePage(driver).verifylicesedetailssorting();
Thread.sleep(1000);

logInfo.pass("Verify license details section is displayed.");
logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
} catch (AssertionError | Exception e){
testStepHandle("FAIL",driver,logInfo,e);
}
}


public void verifyprofileattahments() throws Throwable {
    
	   ExtentTest logInfo = null;
try {


logInfo = test.createNode(new GherkinKeyword("Then"),"verifyprofileattahments");
new MyProfilePage(driver).verifyprofileattahments();
Thread.sleep(1000);

logInfo.pass("Verify profile attachment details section is displayed.");
logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
} catch (AssertionError | Exception e){
testStepHandle("FAIL",driver,logInfo,e);
}
}


public void verifysorteddocumentname() throws Throwable {
    
	   ExtentTest logInfo = null;
try {


logInfo = test.createNode(new GherkinKeyword("Then"),"verifysorteddocumentname");
new MyProfilePage(driver).verifysorteddocumentname();
Thread.sleep(1000);

logInfo.pass("Verify profile attachment savedsuccessfully.");
logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
} catch (AssertionError | Exception e){
testStepHandle("FAIL",driver,logInfo,e);
}
}


public void verifypublicatonpresentationsort() throws Throwable {
    
	   ExtentTest logInfo = null;
try {


logInfo = test.createNode(new GherkinKeyword("Then"),"verifypublicatonpresentationsort");
new MyProfilePage(driver).verifypublicatonpresentationsort();
Thread.sleep(1000);

logInfo.pass("Verify publication is displayed.");
logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
} catch (AssertionError | Exception e){
testStepHandle("FAIL",driver,logInfo,e);
}
}


public void verifypublicationsort() throws Throwable {
    
	   ExtentTest logInfo = null;
try {


logInfo = test.createNode(new GherkinKeyword("Then"),"verifypublicationsort");
new MyProfilePage(driver).verifypublicationsort();
Thread.sleep(1000);

logInfo.pass("Verify publication is displayed.");
logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
} catch (AssertionError | Exception e){
testStepHandle("FAIL",driver,logInfo,e);
}
}



public void savepublicationandpresentation() throws Throwable {
    
	   ExtentTest logInfo = null;
try {


logInfo = test.createNode(new GherkinKeyword("Then"),"savepublicationandpresentation");
new MyProfilePage(driver).savepublicationandpresentation();
Thread.sleep(1000);

logInfo.pass("Verify publication prsentation is saved.");
logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
} catch (AssertionError | Exception e){
testStepHandle("FAIL",driver,logInfo,e);
}
}



public void verifyplaceholdertext() throws Throwable {
    
	   ExtentTest logInfo = null;
try {


logInfo = test.createNode(new GherkinKeyword("Then"),"verifyplaceholdertext");
new MyProfilePage(driver).verifyplaceholdertext();
Thread.sleep(1000);

logInfo.pass("Verify the placeholder text is displayed.");
logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
} catch (AssertionError | Exception e){
testStepHandle("FAIL",driver,logInfo,e);
}
}


public void selectallacheckboxdownloadcvenable() throws Throwable {
    
	   ExtentTest logInfo = null;
try {


logInfo = test.createNode(new GherkinKeyword("Then"),"selectallacheckboxdownloadcvenable");
new MyProfilePage(driver).selectallacheckboxdownloadcvenable();
Thread.sleep(1000);

logInfo.pass("Verify Download CV button is displayed.");
logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
} catch (AssertionError | Exception e){
testStepHandle("FAIL",driver,logInfo,e);
}
}


public void novaluesaredisplayedinlist() throws Throwable {
    
	   ExtentTest logInfo = null;
try {


logInfo = test.createNode(new GherkinKeyword("Then"),"novaluesaredisplayedinlist");
new MyProfilePage(driver).novaluesaredisplayedinlist();
Thread.sleep(1000);

logInfo.pass("Verify no values are displayed in the list.");
logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
} catch (AssertionError | Exception e){
testStepHandle("FAIL",driver,logInfo,e);
}
}


public void searchscreendisplayed() throws Throwable {
    
	   ExtentTest logInfo = null;
try {


logInfo = test.createNode(new GherkinKeyword("Then"),"searchscreendisplayed");
new MyProfilePage(driver).searchscreendisplayed();
Thread.sleep(1000);

logInfo.pass("Verify search result is displayed with pull cv disable.");
logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
} catch (AssertionError | Exception e){
testStepHandle("FAIL",driver,logInfo,e);
}
}


public void verify2ndpage() throws Throwable {
    
	   ExtentTest logInfo = null;
try {


logInfo = test.createNode(new GherkinKeyword("Then"),"verify2ndpage");
new MyProfilePage(driver).verify2ndpage();
Thread.sleep(1000);

logInfo.pass("Verify 2nd page site users.");
logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
} catch (AssertionError | Exception e){
testStepHandle("FAIL",driver,logInfo,e);
}
}


public void noprevpaginationdisplayed() throws Throwable {
    
	   ExtentTest logInfo = null;
try {


logInfo = test.createNode(new GherkinKeyword("Then"),"noprevpaginationdisplayed");
new MyProfilePage(driver).noprevpaginationdisplayed();
Thread.sleep(1000);

logInfo.pass("Verify user able to go to the first page.");
logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
} catch (AssertionError | Exception e){
testStepHandle("FAIL",driver,logInfo,e);
}
}


public void Verifylastpage() throws Throwable {
    
	   ExtentTest logInfo = null;
try {


logInfo = test.createNode(new GherkinKeyword("Then"),"Verifylastpage");
new MyProfilePage(driver).Verifylastpage();
Thread.sleep(1000);

logInfo.pass("Verify user able to go to the last page.");
logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
} catch (AssertionError | Exception e){
testStepHandle("FAIL",driver,logInfo,e);
}
}


public void verifyprevpage() throws Throwable {
    
	   ExtentTest logInfo = null;
try {


logInfo = test.createNode(new GherkinKeyword("Then"),"verifyprevpage");
new MyProfilePage(driver).verifyprevpage();
Thread.sleep(1000);

logInfo.pass("Verify user able to go to the previous pagination.");
logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
} catch (AssertionError | Exception e){
testStepHandle("FAIL",driver,logInfo,e);
}
}



public void verrifyenteredpageno() throws Throwable {
    
	   ExtentTest logInfo = null;
try {


logInfo = test.createNode(new GherkinKeyword("Then"),"verrifyenteredpageno");
new MyProfilePage(driver).verrifyenteredpageno();
Thread.sleep(1000);

logInfo.pass("Verify the entered page no is displayed with records.");
logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
} catch (AssertionError | Exception e){
testStepHandle("FAIL",driver,logInfo,e);
}
}



public void clickonlastnameandverify() throws Throwable {
    
	   ExtentTest logInfo = null;
try {


logInfo = test.createNode(new GherkinKeyword("Then"),"clickonlastnameandverify");
new MyProfilePage(driver).clickonlastnameandverify();
Thread.sleep(1000);

logInfo.pass("Verify mentioned data is displayed.");
logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
} catch (AssertionError | Exception e){
testStepHandle("FAIL",driver,logInfo,e);
}
}


public void abbrivatedcvhistory() throws Throwable {
    
	   ExtentTest logInfo = null;
try {


logInfo = test.createNode(new GherkinKeyword("Then"),"abbrivatedcvhistory");
new MyProfilePage(driver).abbrivatedcvhistory();
Thread.sleep(1000);

logInfo.pass("Verify no abbrivitaed cv button displayed.");
logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
} catch (AssertionError | Exception e){
testStepHandle("FAIL",driver,logInfo,e);
}
}

@Then("^navigateandverifyeachsection1$")
public void navigateandverifyeachsection1() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"navigateandverifyeachsection1");
           new MyProfilePage(driver).navigateandverifyeachsection1();
            Thread.sleep(1000);
          
           logInfo.pass("Verify each sections.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifylicense$")
public void verifylicense() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifylicense");
           new MyProfilePage(driver).verifylicense();
            Thread.sleep(1000);
          
           logInfo.pass("Verify professional license numbers.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^profileatachment$")
public void profileatachment() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"profileatachment");
           new MyProfilePage(driver).profileatachment();
            Thread.sleep(1000);
          
           logInfo.pass("Verify sposor 1 is ablet o download profile attachment.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyPIstudyhistorynotdiaplayed$")
public void verifyPIstudyhistorynotdiaplayed() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyPIstudyhistorynotdiaplayed");
           new MyProfilePage(driver).verifyPIstudyhistorynotdiaplayed();
            Thread.sleep(1000);
          
           logInfo.pass("Verify User is navigated to basic details and PI history button is not displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^verifyPIstudyhistorynotdiaplayed1$")
public void verifyPIstudyhistorynotdiaplayed1() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyPIstudyhistorynotdiaplayed1");
           new MyProfilePage(driver).verifyPIstudyhistorynotdiaplayed1();
            Thread.sleep(1000);
          
           logInfo.pass("Verify PI history button is nt displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifypullcvsearchresult$")
public void verifypullcvsearchresult() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifypullcvsearchresult");
           new MyProfilePage(driver).verifypullcvsearchresult();
            Thread.sleep(1000);
          
           logInfo.pass("Verify search result displayed site user 2 details.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^clickverifylastname$")
public void clickverifylastname() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickverifylastname");
           new MyProfilePage(driver).clickverifylastname();
            Thread.sleep(1000);
          
           logInfo.pass("Verify Sposor 1 is navigated to basic details of user profile od Site user 2.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifygcpsection$")
public void verifygcpsection() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifygcpsection");
           new MyProfilePage(driver).verifygcpsection();
            Thread.sleep(1000);
          
           logInfo.pass("Verify Site user 1 is navigated to GCP training section");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifygcponscreenwithyesno$")
public void verifygcponscreenwithyesno() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifygcponscreenwithyesno");
           new MyProfilePage(driver).verifygcponscreenwithyesno();
            Thread.sleep(1000);
          
           logInfo.pass("Verify onscreen text with ys no radio button present.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyradio$")
public void verifyradio() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyradio");
           new MyProfilePage(driver).verifyradio();
            Thread.sleep(1000);
          
           logInfo.pass("Verify no radio button selected by default.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^selectradiono$")
public void selectradiono() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"selectradiono");
           new MyProfilePage(driver).selectradiono();
            Thread.sleep(1000);
          
           logInfo.pass("Verify no radio button selected and find a couse button is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifynotifications$")
public void verifynotifications() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifynotifications");
           new MyProfilePage(driver).verifynotifications();
            Thread.sleep(1000);
          
           logInfo.pass("Verify Site user 1 not recieved the notification.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^navgatetomyprofile$")
public void navgatetomyprofile() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"navgatetomyprofile");
           new MyProfilePage(driver).navgatetomyprofile();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user able to navigate to My profile section.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^generateCVButton1$")
public void generateCVButton1() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"generateCVButton");
           new MyProfilePage(driver).generateCVButton1();
            Thread.sleep(1000);
          
           logInfo.pass("Verify cv is generated successfully.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifymentionedtabsdisplayed$")
public void verifymentionedtabsdisplayed() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifymentionedtabsdisplayed");
           new MyProfilePage(driver).verifymentionedtabsdisplayed();
            Thread.sleep(1000);
          
           logInfo.pass("Verify below mentioned tabs are displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^Navigatetoeducation$")
public void Navigatetoeducation() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Navigatetoeducation");
           new MyProfilePage(driver).Navigatetoeducation();
            Thread.sleep(1000);
          
           logInfo.pass("Verify value enteres are displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^NavigatetoProfessionalexp$")
public void NavigatetoProfessionalexp() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"NavigatetoProfessionalexp");
           new MyProfilePage(driver).NavigatetoProfessionalexp();
            Thread.sleep(1000);
          
           logInfo.pass("Verify professional values enteres are displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^Navigatetoreseachexp$")
public void Navigatetoreseachexp() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Navigatetoreseachexp");
           new MyProfilePage(driver).Navigatetoreseachexp();
            Thread.sleep(1000);
          
           logInfo.pass("Verify reearch values enteres are displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^Navigatetolicensedetail$")
public void Navigatetolicensedetail() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Navigatetolicensedetail");
           new MyProfilePage(driver).Navigatetolicensedetail();
            Thread.sleep(1000);
          
           logInfo.pass("Verify license values enteres are displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}




@Then("^Navigatetoprofileattachment$")
public void Navigatetoprofileattachment() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Navigatetoprofileattachment");
           new MyProfilePage(driver).Navigatetoprofileattachment();
            Thread.sleep(1000);
          
           logInfo.pass("Verify profile attachment values enteres are displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^Navigattopublicationpresentation$")
public void Navigattopublicationpresentation() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Navigattopublicationpresentation");
           new MyProfilePage(driver).Navigattopublicationpresentation();
            Thread.sleep(1000);
          
           logInfo.pass("Verify presentation attachment values enteres are displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}




@Then("^delegateduser$")
public void delegateduser() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"delegateduser");
           new MyProfilePage(driver).delegateduser();
            Thread.sleep(1000);
          
           logInfo.pass("Verify delageted user are displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^userprofilemyprofile$")
public void userprofilemyprofile() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"userprofilemyprofile");
           new MyProfilePage(driver).userprofilemyprofile();
            Thread.sleep(1000);
          
           logInfo.pass("Verify delageted user are displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^downloadprofiletemplate$")
public void downloadprofiletemplate() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"downloadprofiletemplate");
           new MyProfilePage(driver).downloadprofiletemplate();
            Thread.sleep(1000);
          
           logInfo.pass("Verify site usert able to download the profile form.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifybasicdetailPIhistory$")
public void verifybasicdetailPIhistory() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifybasicdetailPIhistory");
           new MyProfilePage(driver).verifybasicdetailPIhistory();
            Thread.sleep(1000);
          
           logInfo.pass("Verify history botton is displayed at bottom left corner.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifyokcancel$")
public void verifyokcancel() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyokcancel");
           new MyProfilePage(driver).verifyokcancel();
            Thread.sleep(1000);
          
           logInfo.pass("Verify ok and cancel button are displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^navigatetobasicdetailss$")
public void navigatetobasicdetailss() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"navigatetobasicdetailss");
           new MyProfilePage(driver).navigatetobasicdetailss();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user redircted to basic details.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifyhistoricalstudyinfo$")
public void verifyhistoricalstudyinfo() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyhistoricalstudyinfo");
           new MyProfilePage(driver).verifyhistoricalstudyinfo();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user able to review his own study and historical study info.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^clickmyprofile$")
public void clickmyprofile() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickmyprofile");
           new MyProfilePage(driver).clickmyprofile();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user navigate to my profile and help text is displayed with delegate button.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifymentionscreendisplayed$")
public void verifymentionscreendisplayed() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifymentionscreendisplayed");
           new MyProfilePage(driver).verifymentionscreendisplayed();
            Thread.sleep(1000);
          
           logInfo.pass("Verify mentiond screen is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifyemailwithdelegate$")
public void verifyemailwithdelegate() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyemailwithdelegate");
           new MyProfilePage(driver).verifyemailwithdelegate();
            Thread.sleep(1000);
          
           logInfo.pass("Verify mentiond screen is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^delagetesuccessfull$")
public void delagetesuccessfull() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"delagetesuccessfull");
           new MyProfilePage(driver).delagetesuccessfull();
            Thread.sleep(1000);
          
           logInfo.pass("Verify Site user 2 delageted succefully.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^undelagetdsucceful$")
public void undelagetdsucceful() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"undelagetdsucceful");
           new MyProfilePage(driver).undelagetdsucceful();
            Thread.sleep(1000);
          
           logInfo.pass("Verify Site user 2 undelagted successfully");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifyorganzation$")
public void verifyorganzation() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyorganzation");
           new MyProfilePage(driver).verifyorganzation();
            Thread.sleep(1000);
          
           logInfo.pass("Verify organization is displayed");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifysearchreult$")
public void verifysearchreult() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifysearchreult");
           new MyProfilePage(driver).verifysearchreult();
            Thread.sleep(1000);
          
           logInfo.pass("Verify search result displayed");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}




@Then("^organizationdelagettion$")
public void organizationdelagettion() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"organizationdelagettion");
           new MyProfilePage(driver).organizationdelagettion();
            Thread.sleep(1000);
          
           logInfo.pass("Verify org delagetion successful");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}




@Then("^verifydelegatedtome$")
public void verifydelegatedtome() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifydelegatedtome");
           new MyProfilePage(driver).verifydelegatedtome();
            Thread.sleep(1000);
          
           logInfo.pass("Verify elagted to me section org name is diaplayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifyprofileoptions$")
public void verifyprofileoptions() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyprofileoptions");
           new MyProfilePage(driver).verifyprofileoptions();
            Thread.sleep(1000);
          
           logInfo.pass("Verify My profile and pull cv buttons are displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifypullcvfields$")
public void verifypullcvfields() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifypullcvfields");
           new MyProfilePage(driver).verifypullcvfields();
            Thread.sleep(1000);
          
           logInfo.pass("Verify pull cv fields are displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}




@Then("^verifypullcvtable$")
public void verifypullcvtable() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifypullcvtable");
           new MyProfilePage(driver).verifypullcvtable();
            Thread.sleep(1000);
          
           logInfo.pass("Verify pull cv table attaributes are displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^clickonpullcvyes$")
public void clickonpullcvyes() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickonpullcvyes");
           new MyProfilePage(driver).clickonpullcvyes();
            Thread.sleep(1000);
          
           logInfo.pass("Verify pull cv history is displayed with mentioned attribute.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^enterpagezero$")
public void enterpagezero() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"enterpagezero");
           new MyProfilePage(driver).enterpagezero();
            Thread.sleep(1000);
          
           logInfo.pass("Verify error msg is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}




@Then("^enterpagemorethan$")
public void enterpagemorethan() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"enterpagemorethan");
           new MyProfilePage(driver).enterpagemorethan();
            Thread.sleep(1000);
          
           logInfo.pass("Verify error msg 2 is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^enterpagedecimal$")
public void enterpagedecimal() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"enterpagedecimal");
           new MyProfilePage(driver).enterpagedecimal();
            Thread.sleep(1000);
          
           logInfo.pass("Verify error msg 3 is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^clickoncancelbutton$")
public void clickoncancelbutton() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickoncancelbutton");
           new MyProfilePage(driver).clickoncancelbutton();
            Thread.sleep(1000);
          
           logInfo.pass("Verify pop up closed and user navigated to search screen.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}





@Then("^clickonbell$")
public void clickonbell() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickonbell");
           new MyProfilePage(driver).clickonbell();
            Thread.sleep(1000);
          
           logInfo.pass("clickonbell");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^Verify Study New Notification Is Displayed For Study (\\d+)$")
public void verify_Study_New_Notification_Is_Displayed_For_Study(int arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Study New Notification Is Displayed For Study "+arg1);
        new MyProfilePage(driver).verify_Study_New_Notification_Is_Displayed_For_Study(arg1);
         Thread.sleep(1000);
       
        logInfo.pass("Verify Study New Notification Is Displayed For Study "+arg1);
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Verify Site User (\\d+) Site Role Removed From Study (\\d+) By Delegation Manager Notification1$")
public void verify_Site_User_Site_Role_Removed_From_Study_By_Delegation_Manager_Notification1(int arg1, int arg2) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" Site Role Removed From Study "+arg1+" By Delegation Manager Notification1");
        new MyProfilePage(driver).verify_Site_User_Site_Role_Removed_From_Study_By_Delegation_Manager_Notification(arg1,arg2);
         Thread.sleep(1000);
       
        logInfo.pass("Verify Site User "+arg1+" Site Role Removed From Study "+arg1+" By Delegation Manager Notification1");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Verify Site User (\\d+) Site Role Removed From Study (\\d+) By Delegation Manager Notification2$")
public void verify_Site_User_Site_Role_Removed_From_Study_By_Delegation_Manager_Notification2(int arg1, int arg2) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" Site Role Removed From Study "+arg2+" By Delegation Manager Notification 2");
        new MyProfilePage(driver).verify_Site_User_Site_Role_Removed_From_Study_By_Delegation_Manager_Notification2(arg1,arg2);
         Thread.sleep(1000);
       
        logInfo.pass("Verify Site User "+arg1+" Site Role Removed From Study "+arg2+" By Delegation Manager Notification 2");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Verify Study New Notification Is Not Displayed For Study (\\d+)$")
public void verify_Study_New_Notification_Is_Not_Displayed_For_Study(int arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Study New Notification Is Not Displayed For Study "+arg1);
        new MyProfilePage(driver).verify_Study_New_Notification_Is_Not_Displayed_For_Study(arg1);
         Thread.sleep(1000);
       
        logInfo.pass("Verify Study New Notification Is Not Displayed For Study "+arg1);
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^VerifyNotification$")
public void verifynotification() throws Throwable {
	 ExtentTest logInfo = null;
     try {
        
    
         logInfo = test.createNode(new GherkinKeyword("Then"),"VerifyNotification");
         new MyProfilePage(driver).VerifyNotification();
          Thread.sleep(1000);
        
         logInfo.pass("VerifyNotification");
         logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
     } catch (AssertionError | Exception e){
         testStepHandle("FAIL",driver,logInfo,e);
     }
}

@Then("^RemoveSiteUserFromeDepartmentContact with \"([^\"]*)\" Email Id$")
public void removesiteuserfromedepartmentcontact_with_Email_Id(String arg1) throws Throwable {
	ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"RemoveSiteUserFromeDepartmentContact");
         new MyFacilityPage(driver).RemoveSiteUserFromeDepartmentContact(arg1);
         Thread.sleep(1000);
       
       
        logInfo.pass("RemoveSiteUserFromeDepartmentContact");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}


@Then("^navgateabbriviatedcv$")
public void navgateabbriviatedcv() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"navgateabbriviatedcv");
           new MyProfilePage(driver).navgateabbriviatedcv();
            Thread.sleep(1000);
          
           logInfo.pass("Verify abbrivated cv is displayed with download enties");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifysposordownloadcv$")
public void verifysposordownloadcv() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifysposordownloadcv");
           new MyProfilePage(driver).verifysposordownloadcv();
            Thread.sleep(1000);
          
           logInfo.pass("Verify mentioned fields are dipslayed");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^Verifyundelegatedbuttondisplayed$")
public void Verifyundelegatedbuttondisplayed() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Verifyundelegatedbuttondisplayed");
           new MyProfilePage(driver).Verifyundelegatedbuttondisplayed();
            Thread.sleep(1000);
          
           logInfo.pass("Verify undelegated button is displayed ");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^ClickOnUndelegateButton$")
public void clickonundelegatebutton() throws Throwable {
	 ExtentTest logInfo = null;
     try {
        
    
         logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnUndelegateButton");
         new MyProfilePage(driver).ClickOnUndelegateButton();
          Thread.sleep(1000);
        
         logInfo.pass("ClickOnUndelegateButton");
         logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
     } catch (AssertionError | Exception e){
         testStepHandle("FAIL",driver,logInfo,e);
     }
}

@Then("^ClickOnUnDelegateCancel$")
public void ClickOnUnDelegateCancel() throws Throwable {
	 ExtentTest logInfo = null;
     try {
        
    
         logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnUnDelegateCancel");
         new MyProfilePage(driver).ClickOnUnDelegateCancel();
          Thread.sleep(1000);
        
         logInfo.pass("ClickOnUnDelegateCancel");
         logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
     } catch (AssertionError | Exception e){
         testStepHandle("FAIL",driver,logInfo,e);
     }
}

@Then("^ClickOnUnDelegateCancelFirst$")
public void ClickOnUnDelegateCancelFirst() throws Throwable {
	 ExtentTest logInfo = null;
     try {
        
    
         logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnUnDelegateCancelFirst");
         new MyProfilePage(driver).ClickOnUnDelegateCancelFirst();
          Thread.sleep(1000);
        
         logInfo.pass("ClickOnUnDelegateCancelFirst");
         logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
     } catch (AssertionError | Exception e){
         testStepHandle("FAIL",driver,logInfo,e);
     }
}

@Then("^RemoveDelegate$")
public void RemoveDelegate() throws Throwable {
	 ExtentTest logInfo = null;
     try {
        
    
         logInfo = test.createNode(new GherkinKeyword("Then"),"RemoveDelegate");
         new MyProfilePage(driver).RemoveDelegate();
         logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
          Thread.sleep(1000);
        new MyProfilePage(driver).RemoveDelegateOK();
         logInfo.pass("RemoveDelegate");
         logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
     } catch (AssertionError | Exception e){
         testStepHandle("FAIL",driver,logInfo,e);
     }
}

@Then("^VerifyOrganizationName$")
public void verifyorganizationname() throws Throwable {
	 ExtentTest logInfo = null;
     try {
        
    
         logInfo = test.createNode(new GherkinKeyword("Then"),"VerifyOrganizationName");
         new MyProfilePage(driver).VerifyOrganizationName();
         
          Thread.sleep(1000);
        
         logInfo.pass("VerifyOrganizationName");
         logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
     } catch (AssertionError | Exception e){
         testStepHandle("FAIL",driver,logInfo,e);
     }
}


@Then("^ClickOnUndelegatedApproveRejectChange$")
public void ClickOnUndelegatedApproveRejectChange() throws Throwable {
	 ExtentTest logInfo = null;
     try {
        
    
         logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnUndelegatedApproveRejectChange");
         new MyProfilePage(driver).ClickOnUndelegatedApproveRejectChange();
          Thread.sleep(1000);
        
         logInfo.pass("ClickOnUndelegatedApproveRejectChange");
         logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
     } catch (AssertionError | Exception e){
         testStepHandle("FAIL",driver,logInfo,e);
     }
}

@Then("^ClickOnRejectAll$")
public void clickonrejectall() throws Throwable {
	 ExtentTest logInfo = null;
     try {
        
    
         logInfo = test.createNode(new GherkinKeyword("Then"),"ClickOnRejectAll");
         new MyProfilePage(driver).ClickOnRejectAll();
          Thread.sleep(1000);
        
         logInfo.pass("ClickOnRejectAll");
         logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
     } catch (AssertionError | Exception e){
         testStepHandle("FAIL",driver,logInfo,e);
     }
}

@Then("^verifysearchscreenresult$")
public void verifysearchscreenresult() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifysearchscreenresult");
           new MyProfilePage(driver).verifysearchscreenresult();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user navigate to search screen result");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^yesradioselected$")
public void yesradioselected() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"yesradioselected");
           new MyProfilePage(driver).yesradioselected();
            Thread.sleep(1000);
          
           logInfo.pass("Verify radio button selected successsfully.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^noradioselected$")
public void noradioselected() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"noradioselected");
           new MyProfilePage(driver).noradioselected();
            Thread.sleep(1000);
          
           logInfo.pass("Verify radio button selected successsfully.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^navigatesiteuserresitrationreport$")
public void navigatesiteuserresitrationreport() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"navigatesiteuserresitrationreport");
           new GeneralReportPage(driver).navigatesiteuserresitrationreport();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user navigate to site user registration report.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifysubmittrainingcreditrequest$")
public void verifysubmittrainingcreditrequest() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifysubmittrainingcreditrequest");
           new MyProfilePage(driver).verifysubmittrainingcreditrequest();
            Thread.sleep(1000);
          
           logInfo.pass("Verify submit training credit request button is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^clickontraing$")
public void clickontraing() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickontraing");
           new MyProfilePage(driver).clickontraing();
            Thread.sleep(1000);
          
           logInfo.pass("Verify my training  displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^email2norecord$")
public void email2norecord() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"email2norecord");
           new MyProfilePage(driver).email2norecord();
            Thread.sleep(1000);
          
           logInfo.pass("Verify no records found msg is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^email3norecord$")
public void email3norecord() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"email3orecord");
           new MyProfilePage(driver).email3norecord();
            Thread.sleep(1000);
          
           logInfo.pass("Verify no records found msg is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^email4norecord$")
public void email4norecord() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"email4norecord");
           new MyProfilePage(driver).email4norecord();
            Thread.sleep(1000);
          
           logInfo.pass("Verify no records found msg is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^enterproperemailanddelegate$")
public void enterproperemailanddelegate() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"enterproperemailanddelegate");
           new MyProfilePage(driver).enterproperemailanddelegate();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user successully delegated the profile.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^clickdisplayoncv$")
public void clickdisplayoncv() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickdisplayoncv");
           new MyProfilePage(driver).clickdisplayoncv();
            Thread.sleep(1000);
          
            
           logInfo.pass("Verify F1D12 and F1D14 are not selected.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^clickpublicationsave$")
public void clickpublicationsave() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickpublicationsave");
           new MyProfilePage(driver).clickpublicationsave();
            Thread.sleep(1000);
          
           logInfo.pass("Verify entered details are saved in publication presentation section.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}




@Then("^verifymanagedelegationpage$")
public void verifymanagedelegationpage() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifymanagedelegationpage");
           new MyProfilePage(driver).verifymanagedelegationpage();
            Thread.sleep(1000);
          
           logInfo.pass("Verify manage delegation page is displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyuserabletodelegate$")
public void verifyuserabletodelegate() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyuserabletodelegate");
           new MyProfilePage(driver).verifyuserabletodelegate();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user will be able to delegate.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^pooltaskwillnotrecieve$")
public void pooltaskwillnotrecieve() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"pooltaskwillnotrecieve");
           new MyProfilePage(driver).pooltaskwillnotrecieve();
            Thread.sleep(1000);
          
           logInfo.pass("Verify the pool task will not receieve.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^pooltaskwillrecieve$")
public void pooltaskwillrecieve() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"pooltaskwillrecieve");
           new MyProfilePage(driver).pooltaskwillrecieve();
            Thread.sleep(1000);
          
           logInfo.pass("Verify the pool task will  receieve.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^selectuserprofileauditrailreport$")
public void selectuserprofileauditrailreport() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"selectuserprofileauditrailreport");
           new MyProfilePage(driver).selectuserprofileauditrailreport();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user profile audit trail is selected.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^selectuserfacilitydocumentauditrailreport$")
public void selectuserfacilitydocumentauditrailreport() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"selectuserfacilitydocumentauditrailreport");
           new MyProfilePage(driver).selectuserfacilitydocumentauditrailreport();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user & facility document Auditrail is selected.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^verifyreportfields$")
public void verifyreportfields() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyreportfields");
           new MyProfilePage(driver).verifyreportfields();
            Thread.sleep(1000);
          
           logInfo.pass("Verify required fields are dispalayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}





@Then("^generatereport$")
public void generatereport() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"generatereport");
           new MyProfilePage(driver).generatereport();
            Thread.sleep(1000);
          
           logInfo.pass("Verify fill destails and click on generate report.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifypagination1$")
public void verifypagination1() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifypagination1");
           new MyProfilePage(driver).verifypagination1();
            Thread.sleep(1000);
          
           logInfo.pass("Verify pagination working.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyexport$")
public void verifyexport() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyexport");
           new MyProfilePage(driver).verifyexport();
            Thread.sleep(1000);
          
           logInfo.pass("Verify export button pdf & xls.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifyprint$")
public void verifyprint() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyprint");
           new MyProfilePage(driver).verifyprint();
            Thread.sleep(1000);
          
           logInfo.pass("Verify print is available.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}




@Then("^reportcolumnverification$")
public void reportcolumnverification() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"reportcolumnverification");
           new MyProfilePage(driver).reportcolumnverification();
            Thread.sleep(1000);
          
           logInfo.pass("Verify report columns are displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^Addlicenseanduploaddoc$")
public void Addlicenseanduploaddoc() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Addlicenseanduploaddoc");
           new MyProfilePage(driver).Addlicenseanduploaddoc();
            Thread.sleep(1000);
          
           logInfo.pass("Verify msg 1 is displayed with upload licence and cancel buttons.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^clickoncancel$")
public void clickoncancel() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickoncancel");
           new MyProfilePage(driver).clickoncancel();
            Thread.sleep(1000);
          
           logInfo.pass("Verify expiry pop up gets closed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^filldetailandupload$")
public void filldetailandupload() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"filldetailandupload");
           new MyProfilePage(driver).filldetailandupload();
            Thread.sleep(1000);
          
           logInfo.pass("Verify fill details and upload.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^filldetailandupload255$")
public void filldetailandupload255() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"close");
           new MyProfilePage(driver).filldetailandupload255();
            Thread.sleep(1000);
          
           logInfo.pass("Verify 255 character file is uploaded successfuly.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}
@Then("^filldetailandupload256$")
public void filldetailandupload256() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"close");
           new MyProfilePage(driver).filldetailandupload256();
            Thread.sleep(1000);
          
           logInfo.pass("Verify 256 character file is not uploaded successfuly.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^uploaddownloadedcv$")
public void uploaddownloadedcv() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"uploaddownloadedcv");
           new MyProfilePage(driver).uploaddownloadedcv();
            Thread.sleep(1000);
          
           logInfo.pass("Veify user able to upload profile form.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifysumbittrainingrequestdiaplayed$")
public void verifysumbittrainingrequestdiaplayed() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifysumbittrainingrequestdiaplayed");
           new MyProfilePage(driver).verifysumbittrainingrequestdiaplayed();
            Thread.sleep(1000);
          
           logInfo.pass("Veify sumit training credit request button is diaplayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifystatus$")
public void verifystatus() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifystatus");
           new MyProfilePage(driver).verifystatus();
            Thread.sleep(1000);
          
           logInfo.pass("Veify training status are displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^clickanaccept$")
public void clickanaccept() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickanaccept");
           new MyProfilePage(driver).clickanaccept();
            Thread.sleep(1000);
          
           logInfo.pass("Veify user profile displayed with updated data.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^clickanareject$")
public void clickanareject() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickanareject");
           new MyProfilePage(driver).clickanareject();
            Thread.sleep(1000);
          
           logInfo.pass("Veify user profile displayed with updated data.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifybreadcrumb$")
public void verifybreadcrumb() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifybreadcrumb");
           new MyFacilityPage(driver).verifybreadcrumb();
            Thread.sleep(1000);
          
           logInfo.pass("Veify facility breadcrumb.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifyfacilitycontact$")
public void verifyfacilitycontact() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyfacilitycontact");
           new MyFacilityPage(driver).verifyfacilitycontact();
            Thread.sleep(1000);
          
           logInfo.pass("Veify verifyfacilitycontact.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^removedepartment$")
public void removedepartment() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"removedepartment");
           new MyFacilityPage(driver).removedepartment();
            Thread.sleep(1000);
          
           logInfo.pass("Veify removed department error msg displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^removedepartment1$")
public void removedepartment1() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"removedepartment1");
           new MyFacilityPage(driver).removedepartment1();
            Thread.sleep(1000);
          
           logInfo.pass("Veify removed department successfully.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifyresearchsubsections$")
public void verifyresearchsubsections() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyresearchsubsections");
           new MyProfilePage(driver).verifyresearchsubsections();
            Thread.sleep(1000);
          
           logInfo.pass("Veify removed department successfully.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^verifyscreentext2$")
public void verifyscreentext2() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyscreentext2");
           new MyProfilePage(driver).verifyscreentext2();
            Thread.sleep(1000);
          
           logInfo.pass("Veify screen 2 displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyscreentext3$")
public void verifyscreentext3() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyscreentext3");
           new MyProfilePage(driver).verifyscreentext3();
            Thread.sleep(1000);
          
           logInfo.pass("Veify screen 3 displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyscreentext4$")
public void verifyscreentext4() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyscreentext4");
           new MyProfilePage(driver).verifyscreentext4();
            Thread.sleep(1000);
          
           logInfo.pass("Veify screen 4 displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifyscreentext5$")
public void verifyscreentext5() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifyscreentext5");
           new MyProfilePage(driver).verifyscreentext5();
            Thread.sleep(1000);
          
           logInfo.pass("Veify screen 5 displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^studytypeverification$")
public void studytypeverification() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"studytypeverification");
           new MyProfilePage(driver).studytypeverification();
            Thread.sleep(1000);
          
           logInfo.pass("Veify study type displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^othercheckbox$")
public void othercheckbox() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"othercheckbox");
           new MyProfilePage(driver).othercheckbox();
            Thread.sleep(1000);
          
           logInfo.pass("Veify other checkbox is clicked.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^phaseverification$")
public void phaseverification() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"phaseverification");
           new MyProfilePage(driver).phaseverification();
            Thread.sleep(1000);
          
           logInfo.pass("Veify all the phases.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^clickonsubmitcreditrequest$")
public void clickonsubmitcreditrequest() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickonsubmitcreditrequest");
           new MyProfilePage(driver).clickonsubmitcreditrequest();
            Thread.sleep(1000);
          
           logInfo.pass("Veify submit training credit request window opens.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^AddCompletionDate \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
public void AddCompletionDate(String TrainingType, String ProviderType, String CourseName) throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"AddCompletionDate");
           new MyProfilePage(driver).AddCompletionDate(TrainingType,ProviderType,CourseName);
            Thread.sleep(1000);
          
           logInfo.pass("Veify submit training credit request window opens.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^AddCompletionPage$")
public void AddCompletionPage() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"AddCompletionPage");
           new MyProfilePage(driver).AddCompletionPage();
            Thread.sleep(1000);
          
           logInfo.pass("Veify submit training credit request window opens.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^ChooseFileold$")
public void ChooseFileold() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"ChooseFileold");
           new MyProfilePage(driver).ChooseFileold();
            Thread.sleep(1000);
          
           logInfo.pass("Veify submit training credit request window opens.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^ReviewAndSubmit$")
public void ReviewAndSubmit() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"ReviewAndSubmit");
           new MyProfilePage(driver).ReviewAndSubmit();
            Thread.sleep(1000);
          
           logInfo.pass("Veify submit training credit request window opens.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^SubmitCredits$")
public void SubmitCredits() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"SubmitCredits");
           new MyProfilePage(driver).SubmitCredits();
            Thread.sleep(1000);
          
           logInfo.pass("Veify submit training credit request window opens.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^GoToMyCreditPage$")
public void GoToMyCreditPage() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"GoToMyCreditPage");
           new MyProfilePage(driver).GoToMyCreditPage();
            Thread.sleep(1000);
          
           logInfo.pass("Veify submit training credit request window opens.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^Close$")
public void Close() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Close");
           new MyProfilePage(driver).Close();
            Thread.sleep(1000);
          
           logInfo.pass("Veify closed the window.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^SelectSomeoneElse$")
public void SelectSomeoneElse() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"SelectSomeoneElse");
           new MyProfilePage(driver).SelectSomeoneElse();
            Thread.sleep(1000);
          
           logInfo.pass("Select someone else.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^CourseNotListedbutton$")
public void CourseNotListedbutton() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"CourseNotListedbutton");
           new MyProfilePage(driver).CourseNotListedbutton();
            Thread.sleep(1000);
          
           logInfo.pass("Verify course not selected.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^CourseNotListedpopup$")
public void CourseNotListedpopup() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"CourseNotListedpopup");
           new MyProfilePage(driver).CourseNotListedpopup();
            Thread.sleep(1000);
          
           logInfo.pass("Verify couse not listed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^EnterCourseNotListedPage$")
public void EnterCourseNotListedPage() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"EnterCourseNotListedPage");
           new MyProfilePage(driver).EnterCourseNotListedPage();
            Thread.sleep(1000);
          
           logInfo.pass("Verify couse not listed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^TrainingTypeStudyNotPresent$")
public void TrainingTypeStudyNotPresent() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"TrainingTypeStudyNotPresent");
           new MyProfilePage(driver).TrainingTypeStudyNotPresent();
            Thread.sleep(1000);
          
           logInfo.pass("Verify training type study not present.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^TrainingTypeCROPresent$")
public void TrainingTypeCROPresent() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"TrainingTypeCROPresent");
           new MyProfilePage(driver).TrainingTypeCROPresent();
            Thread.sleep(1000);
          
           logInfo.pass("Verify training type cro present.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^TrainingTypeSelet$")
public void TrainingTypeSelet() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"TrainingTypeSelet");
           new MyProfilePage(driver).TrainingTypeSelet();
            Thread.sleep(1000);
          
           logInfo.pass("Select training type.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^SponsorCROSelect$")
public void SponsorCROSelect() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"SponsorCROSelect");
           new MyProfilePage(driver).SponsorCROSelect();
            Thread.sleep(1000);
          
           logInfo.pass("Select CRO.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^CRODisplay$")
public void CRODisplay() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"CRODisplay");
           new MyProfilePage(driver).CRODisplay();
            Thread.sleep(1000);
          
           logInfo.pass("Verify CRO displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^SubmitCourses$")
public void SubmitCourses() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"SubmitCourses");
           new MyProfilePage(driver).SubmitCourses();
            Thread.sleep(1000);
          
           logInfo.pass("Verify Submit course.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^AddCompletionDateUpdate$")
public void AddCompletionDateUpdate() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"AddCompletionDateUpdate");
           new MyProfilePage(driver).AddCompletionDateUpdate();
            Thread.sleep(1000);
          
           logInfo.pass("Verify AddcompletionDateupdate.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^ChooseFileUpdated$")
public void ChooseFileUpdated() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"ChooseFileUpdated");
           new MyProfilePage(driver).ChooseFileUpdated();
            Thread.sleep(1000);
          
           logInfo.pass("Verify ChooseFileUpdated.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^ReviewandSubmitScreenVerification$")
public void ReviewandSubmitScreenVerification() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"ReviewandSubmitScreenVerification");
           new MyProfilePage(driver).ReviewandSubmitScreenVerification();
            Thread.sleep(1000);
          
           logInfo.pass("Verify ReviewandSubmitScreenVerification.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^VerifytheRequestDisplayed$")
public void VerifytheRequestDisplayed() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"VerifytheRequestDisplayed");
           new MyProfilePage(driver).VerifytheRequestDisplayed();
            Thread.sleep(1000);
          
           logInfo.pass("Verify VerifytheRequestDisplayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^selectexceedingimageverify255$")
public void selectexceedingimageverify255() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"selectexceedingimageverify255");
           new MyProfilePage(driver).selectexceedingimageverify255();
            Thread.sleep(1000);
          
           logInfo.pass("Verify 255 character file uploaded successfully.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^selectexceedingimageverify256$")
public void selectexceedingimageverify256() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"selectexceedingimageverify256");
           new MyProfilePage(driver).selectexceedingimageverify256();
            Thread.sleep(1000);
          
           logInfo.pass("Verify 256 character  file not uploaded successfully.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^uploaddownloadedcv255$")
public void uploaddownloadedcv255() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"uploaddownloadedcv255");
           new MyProfilePage(driver).uploaddownloadedcv255();
            Thread.sleep(1000);
          
           logInfo.pass("Verify 255 character file uploaded successfully.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^uploaddownloadedcv256$")
public void uploaddownloadedcv256() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"uploaddownloadedcv256");
           new MyProfilePage(driver).uploaddownloadedcv256();
            Thread.sleep(1000);
          
           logInfo.pass("Verify 256 character  file not uploaded successfully.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^uploadprofileattachment$")
public void 
attachment() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"uploadprofileattachment");
           new MyProfilePage(driver).uploadprofileattachment();
            Thread.sleep(1000);
          
           logInfo.pass("Verify less than 255 character  file not uploaded successfully.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^uploadprofileattachment255$")
public void uploadprofileattachment255() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"uploadprofileattachment255");
           new MyProfilePage(driver).uploadprofileattachment255();
            Thread.sleep(1000);
          
           logInfo.pass("Verify 255 character file uploaded successfully.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^uploadprofileattachment256$")
public void uploadprofileattachment256() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"uploadprofileattachment256");
           new MyProfilePage(driver).uploadprofileattachment256();
            Thread.sleep(1000);
          
           logInfo.pass("Verify 256 character  file not uploaded successfully.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verificationsent$")
public void verificationsent() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verificationsent");
           new MyProfilePage(driver).verificationsent();
            Thread.sleep(1000);
          
           logInfo.pass("Verify registration invite sent pop up displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verificationsent1$")
public void verificationsent1() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verificationsent1");
           new MyProfilePage(driver).verificationsent1();
            Thread.sleep(1000);
          
           logInfo.pass("Verify registration invite1 sent pop up displayed.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^deleted1recordeducation$")
public void deleted1recordeducation() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"deleted1recordeducation");
           new MyProfilePage(driver).deleted1recordeducation();
            Thread.sleep(1000);
          
           logInfo.pass("Verify 1 education record deleted.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^clickonprint$")
public void clickonprint() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickonprint");
           new MyProfilePage(driver).clickonprint();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user able to click on print.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^clearsearchreport$")
public void clearsearchreport() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clearsearchreport");
           new MyProfilePage(driver).clearsearchreport();
            Thread.sleep(1000);
          
           logInfo.pass("click on clear search button .");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^changedatetimestamp$")
public void changedatetimestamp() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"changedatetimestamp");
           new MyProfilePage(driver).changedatetimestamp();
            Thread.sleep(1000);
          
           logInfo.pass("Time stamp is showing in DD-MMM-YYYY HH:MM:SS format.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^checkutctime$")
public void checkutctime() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"checkutctime");
           new MyProfilePage(driver).checkutctime();
            Thread.sleep(1000);
          
           logInfo.pass("check its showing in UTC time.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^verifychangeby$")
public void verifychangeby() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifychangeby");
           new MyProfilePage(driver).verifychangeby();
            Thread.sleep(1000);
          
           logInfo.pass("Verify change by column.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^clickonpreviewabbriviatedcv$")
public void clickonpreviewabbriviatedcv() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickonpreviewabbriviatedcv");
           new MyProfilePage(driver).clickonpreviewabbriviatedcv();
            Thread.sleep(1000);
          
           logInfo.pass("Verify preview abbriviated cv.");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^sendallchangedforapprovalall$")
public void sendallchangedforapprovalall() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"sendallchangedforapprovalall");
           new MyProfilePage(driver).sendallchangedforapprovalall();
            Thread.sleep(1000);
          
           logInfo.pass("Verify Site user 2 redirected to delegated profile screen");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^openanotheruserprofileprofileattachment$")
public void openanotheruserprofileprofileattachment() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"openanotheruserprofileprofileattachment");
           new MyProfilePage(driver).openanotheruserprofileprofileattachment();
            Thread.sleep(1000);
          
           logInfo.pass("Verify site user navigating to the profile attachment");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^opendocument$")
public void opendocument() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"opendocument");
           new MyProfilePage(driver).opendocument();
            Thread.sleep(1000);
          
           logInfo.pass("Verify document downloaded successfully");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^removeicon$")
public void removeicon() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"removeicon");
           new MyProfilePage(driver).removeicon();
            Thread.sleep(1000);
          
           logInfo.pass("Verify data remove successfully");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^savebutt$")
public void savebutt() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"savebutt");
           new MyProfilePage(driver).savebutt();
            Thread.sleep(1000);
          
           logInfo.pass("Verify data saved and ok button displayed");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^clickduetoday$")
public void clickduetoday() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickduetoday");
           new MyProfilePage(driver).clickduetoday();
            Thread.sleep(1000);
          
           logInfo.pass("Verify due today displayed");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^facilityfieldsverification$")
public void facilityfieldsverification() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"facilityfieldsverification");
           new MyProfilePage(driver).facilityfieldsverification();
            Thread.sleep(1000);
          
           logInfo.pass("Verify facility fields are displayed");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^sendmsgnotdisplayed$")
public void sendmsgnotdisplayed() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"sendmsgnotdisplayed");
           new MyProfilePage(driver).sendmsgnotdisplayed();
            Thread.sleep(1000);
          
           logInfo.pass("Verify sendmsg not displayed");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^departmenttableverification$")
public void departmenttableverification() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"departmenttableverification");
           new MyProfilePage(driver).departmenttableverification();
            Thread.sleep(1000);
          
           logInfo.pass("Verify departent fields");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^viewdepartment$")
public void viewdepartment() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"viewdepartment");
           new MyProfilePage(driver).viewdepartment();
            Thread.sleep(1000);
          
           logInfo.pass("Verify view department is displayeds");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}




@Then("^removefacility$")
public void removefacility() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"removefacility");
           new MyProfilePage(driver).removefacility();
            Thread.sleep(1000);
          
           logInfo.pass("Verify not able to remove facility");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^removedepartment12$")
public void removedepartment12() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"removedepartment12");
           new MyProfilePage(driver).removedepartment12();
            Thread.sleep(1000);
          
           logInfo.pass("Verify not able to remove department");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^clickontasktitle$")
public void clickontasktitle() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickontasktitle");
           new MyProfilePage(driver).clickontasktitle();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user able to open the my profile of delegate");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^notabletoseePIhistory$")
public void notabletoseePIhistory() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"notabletoseePIhistory");
           new MyProfilePage(driver).notabletoseePIhistory();
            Thread.sleep(1000);
          
           logInfo.pass("Verify not able to see the PI history button");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^Addfacilitytoyourprofile$")
public void Addfacilitytoyourprofile() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Addfacilitytoyourprofile");
           new MyFacilityPage(driver).Addfacilitytoyourprofile();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user able to add facility to the user profile");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^createdepartment$")
public void createdepartment() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"createdepartment");
           new MyFacilityPage(driver).createdepartment();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user able to create department");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^editdepartment$")
public void editdepartment() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"editdepartment");
           new MyFacilityPage(driver).editdepartment();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user able to edit the department");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^clickondoc$")
public void clickondoc() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickondoc");
           new MyProfilePage(driver).clickondoc();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user able to clickon the document");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^selectcountry1$")
public void selectcountry1() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"selectcountry1");
           new GeneralReportPage(driver).selectcountry1();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user able to select country 1");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^selectallcheckbox$")
public void selectallcheckbox() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"selectallcheckbox");
           new GeneralReportPage(driver).selectallcheckbox();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user able to check all the checkbox");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^select12record$")
public void select12record() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"select12record");
           new GeneralReportPage(driver).select12record();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user able to select record 1 and 2");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^select_1_5_record$")
public void select15record() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"select15record");
           new GeneralReportPage(driver).select_1_5_record();
            Thread.sleep(1000);
          
           logInfo.pass("Verify user able to select record 1 and 5");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^clickonvewselectionandverify$")
public void clickonvewselectionandverify() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickonvewselectionandverify");
           new GeneralReportPage(driver).clickonvewselectionandverify();
            Thread.sleep(1000);
          
           logInfo.pass("user able to view section and verify");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^clickoncompare$")
public void clickoncompare() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickoncompare");
           new GeneralReportPage(driver).clickoncompare();
            Thread.sleep(1000);
          
           logInfo.pass("user able to view section and verify");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^SelectAll$")
public void selectall() throws Throwable {
	  ExtentTest logInfo = null;
      try {
         
     
          logInfo = test.createNode(new GherkinKeyword("Then"),"selectall");
          new GeneralReportPage(driver).selectall();
           Thread.sleep(1000);
         
          logInfo.pass("selectall");
          logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
      } catch (AssertionError | Exception e){
          testStepHandle("FAIL",driver,logInfo,e);
      }
}


@Then("^verifytasknotificationdisplayed$")
public void verifytasknotificationdisplayed() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clickoncompare");
           new GeneralReportPage(driver).clickoncompare();
            Thread.sleep(1000);
          
           logInfo.pass("user able to view section and verify");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^verifysponsorladingpage$")
public void verifysponsorladingpage() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"verifysponsorladingpage");
           new SipApplicationLandingPage(driver).verifysponsorladingpage();
            Thread.sleep(1000);
          
           logInfo.pass("user able to navigate to sponsorlanding page");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^clcikonviewmoreandverify$")
public void clcikonviewmoreandverify() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"clcikonviewmoreandverify");
           new SipApplicationLandingPage(driver).clcikonviewmoreandverify();
            Thread.sleep(1000);
          
           logInfo.pass("user able to navigate to view more screen");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^Print$")
public void Print() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Print");
           new SipApplicationLandingPage(driver).Print();
            Thread.sleep(1000);
          
           logInfo.pass("user able to print the data");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^exportxls$")
public void exportxls() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"exportxls");
           new SipApplicationLandingPage(driver).exportxls();
            Thread.sleep(1000);
          
           logInfo.pass("user able to export in xls ");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}



@Then("^exportpdf$")
public void exportcsv() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"exportpdf");
           new SipApplicationLandingPage(driver).exportpdf();
            Thread.sleep(1000);
          
           logInfo.pass("user able to export in exportpdf ");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}


@Then("^Verify That Facility (\\d+) Is Displayed In Facility/Department Affiliations Screen$")
public void verify_That_Facility_Is_Displayed_In_Facility_Department_Affiliations_Screen(int arg1) throws Throwable {

	   ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Verify That Facility "+arg1+" Is Displayed In Facility/Department Affiliations Screen");
        new MyOrganizationPage(driver).verify_That_Facility_Is_Displayed_In_Facility_Department_Affiliations_Screen(arg1);
         Thread.sleep(1000);
       
        logInfo.pass("Verify That Facility "+arg1+" Is Displayed In Facility/Department Affiliations Screen");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Verify Facility (\\d+) with Department (\\d+) is Displayed In Facility/Department Affiliations Screen$")
public void verify_Facility_with_Department_is_Displayed_In_Facility_Department_Affiliations_Screen(int arg1, int arg2) throws Throwable {

	   ExtentTest logInfo = null;
 try {
    

     logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility "+arg1+" with Department "+arg2+" is Displayed In Facility/Department Affiliations Screen");
     new MyOrganizationPage(driver).verify_That_Facility_Department_Is_Displayed_In_Facility_Department_Affiliations_Screen(arg1,arg2);
      Thread.sleep(1000);
    
     logInfo.pass("Verify Facility "+arg1+" with Department "+arg2+" is Displayed In Facility/Department Affiliations Screen");
     logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
 } catch (AssertionError | Exception e){
     testStepHandle("FAIL",driver,logInfo,e);
 }
}

@Then("^Verify Facility (\\d+) Is Not Displayed In Facility/Department Affiliations Screen$")
public void verify_That_Facility_Is_Not_Displayed_In_Facility_Department_Affiliations_Screen(int arg1) throws Throwable {

	   ExtentTest logInfo = null;
    try {
       
   
        logInfo = test.createNode(new GherkinKeyword("Then"),"Verify That Facility "+arg1+" Is Not Displayed In Facility/Department Affiliations Screen");
        new MyOrganizationPage(driver).verify_That_Facility_Is_Not_Displayed_In_Facility_Department_Affiliations_Screen(arg1);
         Thread.sleep(1000);
       
        logInfo.pass("Verify That Facility "+arg1+" Is Not Displayed In Facility/Department Affiliations Screen");
        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
    } catch (AssertionError | Exception e){
        testStepHandle("FAIL",driver,logInfo,e);
    }
}

@Then("^Click On Remove Icon Against Facility (\\d+) Is Displayed In Facility/Department Affiliations Screen$")
public void click_On_Remove_Icon_Against_Facility_Is_Displayed_In_Facility_Department_Affiliations_Screen(int arg1) throws Throwable {

	   ExtentTest logInfo = null;
 try {
    

     logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Remove Icon Against Facility "+arg1+" Is Displayed In Facility/Department Affiliations Screen");
     new MyOrganizationPage(driver).click_On_Remove_Icon_Against_Facility_Is_Displayed_In_Facility_Department_Affiliations_Screen(arg1);
      Thread.sleep(5000);
    
     logInfo.pass("Click On Remove Icon Against Facility "+arg1+" Is Displayed In Facility/Department Affiliations Screen");
     logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
 } catch (AssertionError | Exception e){
     testStepHandle("FAIL",driver,logInfo,e);
 }
}

@Then("^Click On Confirm Button In Remove Facility/Department Affiliation PopUp$")
public void ClickOnConfirmButtonInRemoveFacilityDepartmentAffiliationPopUp() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Confirm Button In Remove Facility/Department Affiliation PopUp");
           new MyOrganizationPage(driver).ClickOnConfirmButtonInRemoveFacilityDepartmentAffiliationPopUp();
            Thread.sleep(10000);
          
           logInfo.pass("Click On Confirm Button In Remove Facility/Department Affiliation PopUp");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

@Then("^exportcsv1$")
public void exportcsv1() throws Throwable {
    
	   ExtentTest logInfo = null;
       try {
          
      
           logInfo = test.createNode(new GherkinKeyword("Then"),"exportcsv1");
           new SipApplicationLandingPage(driver).exportcsv1();
            Thread.sleep(1000);
          
           logInfo.pass("user able to export in exportcsv ");
           logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
       } catch (AssertionError | Exception e){
           testStepHandle("FAIL",driver,logInfo,e);
       }
}

		@Then("^Click On Facilities Section In My Profile Screen$")
		public void click_On_Facilities_Section_In_My_Profile_Screen() throws Throwable {
			ExtentTest logInfo = null;
		    try {
		       
		   
		        logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Facilities Section In My Profile Screen");
		        new SiteUser_UserProfile(driver).click_On_Facilities_Section_In_My_Profile_Screen();
		         Thread.sleep(10000);
		       
		        logInfo.pass("Click On Facilities Section In My Profile Screen");
		        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		    } catch (AssertionError | Exception e){
		        testStepHandle("FAIL",driver,logInfo,e);
		    }
		}
		
		@Then("^Verify Facilities Screen Displayed$")
		public void verify_Facilities_Screen_Displayed() throws Throwable {
			ExtentTest logInfo = null;
		    try {
		       
		   
		        logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facilities Screen Displayed");
		        new SiteUser_UserProfile(driver).verify_Facilities_Screen_Displayed();
		         Thread.sleep(1000);
		       
		        logInfo.pass("Verify Facilities Screen Displayed");
		        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		    } catch (AssertionError | Exception e){
		        testStepHandle("FAIL",driver,logInfo,e);
		    }
		}
		
		@Then("^Verify On Screen Text In Facilities Screen$")
		public void verify_On_Screen_Text_In_Facilities_Screen() throws Throwable {
			ExtentTest logInfo = null;
		    try {
		       
		   
		        logInfo = test.createNode(new GherkinKeyword("Then"),"Verify On Screen Text In Facilities Screen");
		        new SiteUser_UserProfile(driver).verify_On_Screen_Text_In_Facilities_Screen();
		         Thread.sleep(1000);
		       
		        logInfo.pass("Verify On Screen Text In Facilities Screen");
		        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		    } catch (AssertionError | Exception e){
		        testStepHandle("FAIL",driver,logInfo,e);
		    }
		}
		
		@Then("^Click On Facility (\\d+) And Department (\\d+) In Facilities Screen$")
		public void click_On_Facility_And_Department(int arg1, int arg2) throws Throwable {
			ExtentTest logInfo = null;
		    try {
		       
		   
		        logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Facility "+arg1+" And Department "+arg2+" In Facilities Screen");
		        new SiteUser_UserProfile(driver).click_On_Facility_And_Department(arg1,arg2);
		         Thread.sleep(1000);
		       
		        logInfo.pass("Click On Facility "+arg1+" And Department "+arg2+" In Facilities Screen");
		        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		    } catch (AssertionError | Exception e){
		        testStepHandle("FAIL",driver,logInfo,e);
		    }
		}
		
		@Then("^Select \"([^\"]*)\" From Show Rows Dropdown In Facilities Screen$")
		public void select_From_Show_Rows_Dropdown_In_Facilities_Screen(String arg1) throws Throwable {
			ExtentTest logInfo = null;
		    try {
		       
		   
		        logInfo = test.createNode(new GherkinKeyword("Then"),"Select "+arg1+" From Show Rows Dropdown In Facilities Screen");
		        new SiteUser_UserProfile(driver).select_From_Show_Rows_Dropdown_In_Facilities_Screen(arg1);
		         Thread.sleep(1000);
		       
		        logInfo.pass("Select "+arg1+" From Show Rows Dropdown In Facilities Screen");
		        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		    } catch (AssertionError | Exception e){
		        testStepHandle("FAIL",driver,logInfo,e);
		    }
		}
		
		@Then("^Click On The Facility (\\d+)$")
		public void click_On_The_Facility(int arg1) throws Throwable {
			ExtentTest logInfo = null;
		    try {
		       
		   
		        logInfo = test.createNode(new GherkinKeyword("Then"),"Click On The Facility "+arg1);
		        new SiteUser_UserProfile(driver).click_On_The_Facility(arg1);
		         Thread.sleep(1000);
		       
		        logInfo.pass("Click On The Facility "+arg1);
		        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		    } catch (AssertionError | Exception e){
		        testStepHandle("FAIL",driver,logInfo,e);
		    }
		}
		
		@Then("^Click On The Facility (\\d+) And Department (\\d+) In Facilities Screen$")
		public void click_On_The_Facility_And_Department_In_Facilities_Screen(int arg1, int arg2) throws Throwable {
			ExtentTest logInfo = null;
		    try {
		       
		   
		        logInfo = test.createNode(new GherkinKeyword("Then"),"Click On The Facility "+arg1+" And Department "+arg2+" In Facilities Screen");
		        new SiteUser_UserProfile(driver).click_On_The_Facility_And_Department_In_Facilities_Screen(arg1,arg2);
		         Thread.sleep(1000);
		       
		        logInfo.pass("Click On The Facility "+arg1+" And Department "+arg2+" In Facilities Screen");
		        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		    } catch (AssertionError | Exception e){
		        testStepHandle("FAIL",driver,logInfo,e);
		    }
		}
		
		@Then("^Verify Primary Facility Mark Is Disabled For Facility (\\d+) And Department (\\d+) In Facilities Screen$")
		public void verify_Primary_Facility_Mark_Is_Disabled_For_Facility_And_Department_In_Facilities_Screen(int arg1, int arg2) throws Throwable {
			ExtentTest logInfo = null;
		    try {
		       
		   
		        logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Primary Facility Mark Is Disabled For Facility "+arg1+" And Department "+arg2+" In Facilities Screen");
		        new SiteUser_UserProfile(driver).verify_Primary_Facility_Mark_Is_Disabled_For_Facility_And_Department_In_Facilities_Screen(arg1,arg2);
		         Thread.sleep(1000);
		       
		        logInfo.pass("Verify Primary Facility Mark Is Disabled For Facility "+arg1+" And Department "+arg2+" In Facilities Screen");
		        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		    } catch (AssertionError | Exception e){
		        testStepHandle("FAIL",driver,logInfo,e);
		    }
		}
		
		@Then("^Click On Primary Facility Mark For Facility (\\d+)$")
		public void click_On_Primary_Facility_Mark_For_Facility(int arg1) throws Throwable {
			ExtentTest logInfo = null;
		    try {
		       
		   
		        logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Primary Facility Mark For Facility "+arg1);
		        new SiteUser_UserProfile(driver).click_On_Primary_Facility_Mark_For_Facility(arg1);
		         Thread.sleep(8000);
		       
		        logInfo.pass("Click On Primary Facility Mark For Facility "+arg1);
		        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		    } catch (AssertionError | Exception e){
		        testStepHandle("FAIL",driver,logInfo,e);
		    }
		}
		
		@Then("^Verify Primary Facility Mark Is Checked For Facility (\\d+)$")
		public void verify_Primary_Facility_Mark_Is_Checked_For_Facility(int arg1) throws Throwable {
			ExtentTest logInfo = null;
		    try {
		       
		   
		        logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Primary Facility Mark Is Checked For Facility "+arg1);
		        new SiteUser_UserProfile(driver).verify_Primary_Facility_Mark_Is_Checked_For_Facility(arg1);
		         Thread.sleep(1000);
		       
		        logInfo.pass("Verify Primary Facility Mark Is Checked For Facility "+arg1);
		        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		    } catch (AssertionError | Exception e){
		        testStepHandle("FAIL",driver,logInfo,e);
		    }
		}
		
		@Then("^Click On SAVE Button In Facilities Screen$")
		public void click_On_SAVE_Button_In_Facilities_Screen() throws Throwable {
			ExtentTest logInfo = null;
		    try {
		       
		   
		        logInfo = test.createNode(new GherkinKeyword("Then"),"Click On SAVE Button In Facilities Screen");
		        new SiteUser_UserProfile(driver).click_On_SAVE_Button_In_Facilities_Screen();
		         Thread.sleep(10000);
		       
		        logInfo.pass("Click On SAVE Button In Facilities Screen");
		        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		    } catch (AssertionError | Exception e){
		        testStepHandle("FAIL",driver,logInfo,e);
		    }
		}
		
		@Then("^Click On SAVE Button In Delegator's User Profile PopUp$")
		public void click_On_SAVE_Button_In_Delegator_s_User_Profile_PopUp() throws Throwable {
			ExtentTest logInfo = null;
		    try {
		       
		   
		        logInfo = test.createNode(new GherkinKeyword("Then"),"Click On SAVE Button In Delegator's User Profile PopUp");
		        new SiteUser_UserProfile(driver).click_On_SAVE_Button_In_Delegators_User_Profile_PopUp();
		         Thread.sleep(10000);
		       
		        logInfo.pass("Click On SAVE Button In Delegator's User Profile PopUp");
		        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		    } catch (AssertionError | Exception e){
		        testStepHandle("FAIL",driver,logInfo,e);
		    }
		}
		
		@Then("^Click On Send All Changes For Approval Button$")
		public void ClickOnSendAllChangesForApprovalButton() throws Throwable {
			ExtentTest logInfo = null;
		    try {
		       
		   
		        logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Send All Changes For Approval Button");
		        new SiteUser_UserProfile(driver).ClickOnSendAllChangesForApprovalButton();
		         Thread.sleep(10000);
		       
		        logInfo.pass("Click On Send All Changes For Approval Button");
		        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		    } catch (AssertionError | Exception e){
		        testStepHandle("FAIL",driver,logInfo,e);
		    }
		}
		
		@Then("^Click On OK button In Your Changes have been sent for Approval PopUp$")
		public void click_On_OK_button_In_Your_Changes_have_been_sent_for_Approval_PopUp() throws Throwable {
			ExtentTest logInfo = null;
		    try {
		       
		   
		        logInfo = test.createNode(new GherkinKeyword("Then"),"Click On OK button In Your Changes have been sent for Approval PopUp");
		        new SiteUser_UserProfile(driver).click_On_OK_button_In_Your_Changes_have_been_sent_for_Approval_PopUp();
		         Thread.sleep(10000);
		       
		        logInfo.pass("Click On OK button In Your Changes have been sent for Approval PopUp");
		        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		    } catch (AssertionError | Exception e){
		        testStepHandle("FAIL",driver,logInfo,e);
		    }
		}
		
		
		@Then("^Click On Approve This Change Button In Facilities Screen$")
		public void click_On_Approve_This_Change_Button_In_Facilities_Screen() throws Throwable {
			ExtentTest logInfo = null;
		    try {
		       
		   
		        logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Approve This Change Button In Facilities Screen");
		        new SiteUser_UserProfile(driver).click_On_Approve_This_Change_Button_In_Facilities_Screen();
		         Thread.sleep(10000);
		       
		        logInfo.pass("Click On Approve This Change Button In Facilities Screen");
		        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		    } catch (AssertionError | Exception e){
		        testStepHandle("FAIL",driver,logInfo,e);
		    }
		}
		
		@Then("^Click On Generate SIP Abbreviated CV Button In Facilities Screen$")
		public void click_On_Generate_SIP_Abbreviated_CV_Button_In_Facilities_Screen() throws Throwable {
			ExtentTest logInfo = null;
		    try {
		       
		   
		        logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Generate SIP Abbreviated CV Button In Facilities Screen");
		        new SiteUser_UserProfile(driver).click_On_Generate_SIP_Abbreviated_CV_Button_In_Facilities_Screen();
		         Thread.sleep(10000);
		       
		        logInfo.pass("Click On Generate SIP Abbreviated CV Button In Facilities Screen");
		        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		    } catch (AssertionError | Exception e){
		        testStepHandle("FAIL",driver,logInfo,e);
		    }
		}
		
		@Then("^Click On PROCEED Button In Generate CV for Profile Owner PopUp$")
		public void click_On_PROCEED_Button_In_Generate_CV_for_Profile_Owner_PopUp() throws Throwable {
			ExtentTest logInfo = null;
		    try {
		       
		   
		        logInfo = test.createNode(new GherkinKeyword("Then"),"Click On PROCEED Button In Generate CV for Profile Owner PopUp");
		        new SiteUser_UserProfile(driver).click_On_PROCEED_Button_In_Generate_CV_for_Profile_Owner_PopUp();
		         Thread.sleep(20000);
		       
		        logInfo.pass("Click On PROCEED Button In Generate CV for Profile Owner PopUp");
		        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		    } catch (AssertionError | Exception e){
		        testStepHandle("FAIL",driver,logInfo,e);
		    }
		}
		
		@Then("^Click On OK Button In Success PopUp For Generating CV$")
		public void click_On_OK_Button_In_Success_PopUp_For_Generating_CV() throws Throwable {
			ExtentTest logInfo = null;
		    try {
		       
		   
		        logInfo = test.createNode(new GherkinKeyword("Then"),"Click On OK Button In Success PopUp For Generating CV");
		        new SiteUser_UserProfile(driver).click_On_OK_Button_In_Success_PopUp_For_Generating_CV();
		         Thread.sleep(10000);
		       
		        logInfo.pass("Click On OK Button In Success PopUp For Generating CV");
		        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		    } catch (AssertionError | Exception e){
		        testStepHandle("FAIL",driver,logInfo,e);
		    }
		}
		
		@Then("^Click On PDF Option For ABBREVIATED CV VERSION HISTORY Option$")
		public void click_On_PDF_Option_For_ABBREVIATED_CV_VERSION_HISTORY_Option() throws Throwable {
			ExtentTest logInfo = null;
		    try {
		       
		   
		        logInfo = test.createNode(new GherkinKeyword("Then"),"Click On PDF Option For ABBREVIATED CV VERSION HISTORY Option");
		        new SiteUser_UserProfile(driver).click_On_PDF_Option_For_ABBREVIATED_CV_VERSION_HISTORY_Option();
		         Thread.sleep(10000);
		       
		        logInfo.pass("Click On PDF Option For ABBREVIATED CV VERSION HISTORY Option");
		        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		    } catch (AssertionError | Exception e){
		        testStepHandle("FAIL",driver,logInfo,e);
		    }
		}
		
		@Then("^Click On OK Button In Your changes have been saved PopUp$")
		public void click_On_OK_Button_In_Your_changes_have_been_saved_PopUp() throws Throwable {
			ExtentTest logInfo = null;
		    try {
		       
		   
		        logInfo = test.createNode(new GherkinKeyword("Then"),"Click On OK Button In Your changes have been saved PopUp");
		        new SiteUser_UserProfile(driver).click_On_OK_Button_In_Your_changes_have_been_saved_PopUp();
		         Thread.sleep(10000);
		       
		        logInfo.pass("Click On OK Button In Your changes have been saved PopUp");
		        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		    } catch (AssertionError | Exception e){
		        testStepHandle("FAIL",driver,logInfo,e);
		    }
		}
		
		@Then("^Verify Facility (\\d+) Department (\\d+) Present In ABBREVIATED CV$")
		public void verify_Facility_Department_Present_In_ABBREVIATED_CV(int arg1, int arg2) throws Throwable {
			ExtentTest logInfo = null;
		    try {
		       
		   
		        logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility "+arg1+" Department "+arg2+" Present In ABBREVIATED CV");
		        new SiteUser_UserProfile(driver).verify_Facility_Department_Present_In_ABBREVIATED_CV(arg1,arg2);
		        Thread.sleep(3000);
		       
		        logInfo.pass("Verify Facility "+arg1+" Department "+arg2+" Present In ABBREVIATED CV");
		        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		    } catch (AssertionError | Exception e){
		        testStepHandle("FAIL",driver,logInfo,e);
		    }
		}
		
		@Then("^Verify Facility (\\d+) Present In ABBREVIATED CV$")
		public void verify_Facility_Present_In_ABBREVIATED_CV(int arg1) throws Throwable {
			ExtentTest logInfo = null;
		    try {
		       
		   
		        logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility "+arg1+" Present In ABBREVIATED CV");
		        new SiteUser_UserProfile(driver).verify_Facility_Present_In_ABBREVIATED_CV(arg1);
		        Thread.sleep(3000);
		       
		        logInfo.pass("Verify Facility "+arg1+" Present In ABBREVIATED CV");
		        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		    } catch (AssertionError | Exception e){
		        testStepHandle("FAIL",driver,logInfo,e);
		    }
		}
		
		@Then("^Verify Facility (\\d+) Is Not Present In ABBREVIATED CV$")
		public void verify_Facility_Is_Not_Present_In_ABBREVIATED_CV(int arg1) throws Throwable {
			ExtentTest logInfo = null;
		    try {
		       
		   
		        logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Facility "+arg1+" Present In ABBREVIATED CV");
		        new SiteUser_UserProfile(driver).verify_Facility_Is_Not_Present_In_ABBREVIATED_CV(arg1);
		        Thread.sleep(3000);
		       
		        logInfo.pass("Verify Facility "+arg1+" Present In ABBREVIATED CV");
		        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		    } catch (AssertionError | Exception e){
		        testStepHandle("FAIL",driver,logInfo,e);
		    }
		}
		
		@Then("^Verify Site User (\\d+) Is Displayed With Date role ended in SIP As Current Date$")
		public void verify_Site_User_Is_Displayed_As_Current_Date(int arg1) throws Throwable {
			ExtentTest logInfo = null;
		    try {
		    	logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" Is Displayed With Date role ended in SIP As Current Date");
		        new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).verify_Site_User_Is_Displayed_As_Current_Date(arg1);
		        Thread.sleep(1000);
		       
		        logInfo.pass("Verify Site User "+arg1+" Is Displayed With Date role ended in SIP As Current Date");
		        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		    } catch (AssertionError | Exception e){
		        testStepHandle("FAIL",driver,logInfo,e);
		    }
		
		}
		
		@Then("^Verify Site User (\\d+) Is Displayed With Date role ended in SIP As Blank$")
		public void verify_Site_User_Is_Displayed_With_Date_role_ended_in_SIP_As_Blank(int arg1) throws Throwable {
			ExtentTest logInfo = null;
		    try {
		    	logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" Is Displayed With Date role ended in SIP As Current Date");
		        new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).verify_Site_User_Is_Displayed_With_Date_role_ended_in_SIP_As_Blank(arg1);
		        Thread.sleep(1000);
		       
		        logInfo.pass("Verify Site User "+arg1+" Is Displayed With Date role ended in SIP As Current Date");
		        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		    } catch (AssertionError | Exception e){
		        testStepHandle("FAIL",driver,logInfo,e);
		    }
		
		}
		
		@Then("^Verify Site User (\\d+) Is Displayed With Date role ended in SIP As Future Date$")
		public void verify_Site_User_Is_Displayed_With_Date_role_ended_in_SIP_As_Future_Date(int arg1) throws Throwable {
			ExtentTest logInfo = null;
		    try {
		    	logInfo = test.createNode(new GherkinKeyword("Then"),"Verify Site User "+arg1+" Is Displayed With Date role ended in SIP As Future Date");
		        new SiteUser_Sponsor_CRO_ViewAllWorkspaces(driver).verify_Site_User_Is_Displayed_With_Date_role_ended_in_SIP_As_Future_Date(arg1);
		        Thread.sleep(1000);
		       
		        logInfo.pass("Verify Site User "+arg1+" Is Displayed With Date role ended in SIP As Future Date");
		        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		    } catch (AssertionError | Exception e){
		        testStepHandle("FAIL",driver,logInfo,e);
		    }
		
		}
		
		@Then("^Click On Clear All Icon In Facility Dropdown For View and Manage Delegation on behalf of Site Users Screen$")
		public void click_On_Clear_All_Icon_In_Facility_Dropdown_For_View_and_Manage_Delegation_on_behalf_of_Site_Users_Screen() throws Throwable {
			ExtentTest logInfo = null;
		    try {
		    	logInfo = test.createNode(new GherkinKeyword("Then"),"Click On Clear All Icon In Facility Dropdown For View and Manage Delegation on behalf of Site Users Screen");
		        new AdminPage(driver).click_On_Clear_All_Icon_In_Facility_Dropdown_For_View_and_Manage_Delegation_on_behalf_of_Site_Users_Screen();
		        Thread.sleep(4000);
		       
		        logInfo.pass("Click On Clear All Icon In Facility Dropdown For View and Manage Delegation on behalf of Site Users Screen");
		        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		    } catch (AssertionError | Exception e){
		        testStepHandle("FAIL",driver,logInfo,e);
		    }
		
		}
		
		@Then("^Select Facility (\\d+) From Facility Dropdown In View and Manage Delegation on behalf of Site Users Screen$")
		public void select_Facility_From_Facility_Dropdown_In_View_and_Manage_Delegation_on_behalf_of_Site_Users_Screen(int arg1) throws Throwable {
			ExtentTest logInfo = null;
		    try {
		    	logInfo = test.createNode(new GherkinKeyword("Then"),"Select Facility "+arg1+" From Facility Dropdown In View and Manage Delegation on behalf of Site Users Screen");
		        new AdminPage(driver).select_Facility_From_Facility_Dropdown_In_View_and_Manage_Delegation_on_behalf_of_Site_Users_Screen(arg1);
		        Thread.sleep(5000);
		       
		        logInfo.pass("Select Facility "+arg1+" From Facility Dropdown In View and Manage Delegation on behalf of Site Users Screen");
		        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		    } catch (AssertionError | Exception e){
		        testStepHandle("FAIL",driver,logInfo,e);
		    }
		
		}
		
		@Then("^Navigate Back To Parent Window And Close child Window$")
		public void navigate_Back_To_Parent_Window_And_Close_child_Window() throws Throwable {
			ExtentTest logInfo = null;
		    try {
		    	logInfo = test.createNode(new GherkinKeyword("Then"),"Navigate Back To Parent Window And Close child Window");
		    	Set<String> windows = driver.getWindowHandles();
		    	Iterator<String> it=windows.iterator();
		    	String parentWindow = it.next();
		    	String childWindow = it.next();
		    	driver.switchTo().window(childWindow);
		    	Thread.sleep(4000);
		        driver.close();
		        driver.switchTo().window(parentWindow);
		        Thread.sleep(2000);
		        logInfo.pass("Navigate Back To Parent Window And Close child Window");
		        logInfo.addScreenCaptureFromPath(captureSreenShots(driver));
		    } catch (AssertionError | Exception e){
		        testStepHandle("FAIL",driver,logInfo,e);
		    }
		
		}
}