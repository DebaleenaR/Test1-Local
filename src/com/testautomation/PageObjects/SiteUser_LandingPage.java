package com.testautomation.PageObjects;


import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testautomation.Utility.ExcelHandler;
import com.testautomation.Utility.PropertiesFileReader;
import com.testautomation.Utility.TestDataHandler;

public class SiteUser_LandingPage {

	public WebDriver driver;
	Properties properties;
	WebDriverWait wait;
	
	PropertiesFileReader obj = new PropertiesFileReader();
	TestDataHandler testData = new TestDataHandler();
	
	public SiteUser_LandingPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver,25000);
	}
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"SponsorCROId\"]/span[1]")
	public WebElement sponsorCROMenu;
	
	@FindBy(how=How.XPATH, using="//*/a[contains(text(),'View Potential Studies')]")
	public WebElement viewPotentialStudies;
	
	@FindBy(how=How.ID, using="ViewandManageDelegationofSiteUsersId")
	public WebElement ViewandManageDelegationofSiteUsers;
	
	@FindBy(how=How.ID, using="ManageNewsLinksFAQId")
	public WebElement ManageNewsLinksFAQ;
	
		
	@FindBy(how=How.XPATH, using="//*[@id=\"Navigationmenu\"]/li[4]/ul/li[1]/a")
	public WebElement viewAllWrokspacelink;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"AdminId\"]/span[1]")
	public WebElement adminMenu;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"ManageDelegationId\"]")
	public WebElement manageDelegationLink;
	
	
	@FindBy(how=How.XPATH, using="//i[@title='Notification']")
	public WebElement notification;
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'View more>>')]")
	public WebElement viewmore;
	
	@FindBy(how=How.XPATH, using="//span[@class='menu-icon icon-home']")
	public WebElement home;
	
	@FindBy(how=How.XPATH, using="//input[@value='My Tasks']")
	public WebElement myTaskButton;
	
	@FindBy(how=How.XPATH, using="//a[@id='myTaskSTU']")
	public WebElement SiteUser_My_TaskButton;
	
	@FindBy(how=How.XPATH, using="//a[@id='SafetyId']")
	public WebElement safetyMenu;
	
	@FindBy(how=How.XPATH, using="//a[@id='MySafetyNotificationsId']")
	public WebElement mySafetyNotification;
	
	@FindBy(how=How.ID, using="ManageDelegationId")
	public WebElement ManageDelegation;
	
	@FindBy(how=How.ID, using="DelegatedProfilesId")
	public WebElement DelegatedProfiles;
	
	@FindBy(how=How.ID, using="ApproveRejectUpdate(s)Id")
	public WebElement ApproveRejectUpdate_Id;
	
	
	@FindBy(how=How.ID, using="UserProfileId")
	public WebElement UserProfile;
	
	@FindBy(how=How.ID, using="ReportsId")
	public WebElement Reports;
	
	@FindBy(how=How.ID, using="GeneralReportsId")
	public WebElement GeneralReports;
	
	
	public void navigateToPotentialStudies() throws Exception
	{
		
		Actions actions = new Actions(driver);
	     
		actions.moveToElement(sponsorCROMenu).build().perform();
   	    Thread.sleep(3000);
   	    viewPotentialStudies.click();
   	    Thread.sleep(20000);
			
	}
	
	public void navigateToViewandManageDelegationofSiteUsers() throws Exception
	{
		
		Actions actions = new Actions(driver);
	     
		actions.moveToElement(adminMenu).build().perform();
   	    Thread.sleep(3000);
   	    ViewandManageDelegationofSiteUsers.click();
   	    Thread.sleep(5000);
			
	}
	
	public void navigate_To_Admin_Manage_Delegate() throws Throwable {
		Actions actions = new Actions(driver);
	     
		actions.moveToElement(adminMenu).build().perform();
   	    Thread.sleep(3000);
   	    CommonClass.highLightElement(driver, ManageDelegation);
   	    ManageDelegation.click();
	}
	
	public void navigate_To_Admin_Manage_News_Links_FAQ() throws Throwable {
		Actions actions = new Actions(driver);
	     
		actions.moveToElement(adminMenu).build().perform();
   	    Thread.sleep(3000);
   	    CommonClass.highLightElement(driver, ManageNewsLinksFAQ);
   	    ManageNewsLinksFAQ.click();
   	    Thread.sleep(5000);
	}
	
	public void navigateToManageDelegationSiteUsers() throws Exception
	{
		
		Actions actions = new Actions(driver);
	     
		actions.moveToElement(adminMenu).build().perform();
   	    Thread.sleep(3000);
   	    ManageDelegation.click();
   	    Thread.sleep(20000);
			
	}
	
	
	
	
	public void navigatetoviewAllWorkspace() throws Exception 
	{   
		System.out.println(driver);
		Thread.sleep(5000);
		
		Actions actions = new Actions(driver);
       actions.moveToElement(sponsorCROMenu).build().perform();
    	 Thread.sleep(2000);
    	 viewAllWrokspacelink.click();
	}
	
	
	public void navigatetoManageDelegation() throws Exception 
	{   
		System.out.println(driver);
		Thread.sleep(5000);
		
		Actions actions = new Actions(driver);
		actions.moveToElement(adminMenu).build().perform();
    	Thread.sleep(2000);
    	manageDelegationLink.click();
	}
	
	
	public void viewNotification() throws Exception 
	{   
		
		Actions actions = new Actions(driver);
	    actions.moveToElement(notification).build().perform();
   	    Thread.sleep(3000);
   	    viewmore.click();
		Thread.sleep(15000);
	}
	
	
	
	public void navigatetoMySN() throws Exception 
	{   
		
		Actions actions = new Actions(driver);
	    actions.moveToElement(safetyMenu).build().perform();
   	    Thread.sleep(3000);
   	    mySafetyNotification.click();
		Thread.sleep(10000);
	}
	
	public void navigate_To_User_Profile_Delegated_Profiles() throws Throwable {
		Actions actions = new Actions(driver);
	    actions.moveToElement(UserProfile).build().perform();
   	    Thread.sleep(3000);
   	    DelegatedProfiles.click();
		Thread.sleep(10000);
	}

	public void navigate_To_User_Profile_Approve_Reject_Update() throws Throwable {
		Actions actions = new Actions(driver);
	    actions.moveToElement(UserProfile).build().perform();
   	    Thread.sleep(3000);
   	    ApproveRejectUpdate_Id.click();
		Thread.sleep(10000);
	}
	
	public void navigate_To_Reports_General_Reports() throws Throwable {
		Actions actions = new Actions(driver);
	    actions.moveToElement(Reports).build().perform();
   	    Thread.sleep(3000);
   	    CommonClass.highLightElement(driver, GeneralReports);
   	    GeneralReports.click();
		Thread.sleep(10000);
	}
	
	
}
