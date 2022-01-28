package com.testautomation.PageObjects;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testautomatiom.Listeners.ExtentReportListner;
import com.testautomation.Utility.ExcelHandler;
import com.testautomation.Utility.PropertiesFileReader;
import com.testautomation.Utility.TestDataHandler;

public class AdminPage {

	public WebDriver driver;
	Properties properties;
	WebDriverWait wait;
	
	PropertiesFileReader obj = new PropertiesFileReader();
	TestDataHandler testData = new TestDataHandler();
	static String StudyLink_subject = "";
	static String relevant_documents_description_Upload_New_Document = "";
	
	public AdminPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver,25000);
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"byFDFacName\"]/div/span")
	public WebElement byFDFacName;
	
	public void click_ViewManageDelegation_Against_site_User(int arg1) throws Exception
	{
		
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_Email = testDataInMap.get("SiteUser"+arg1+"_Email");
        System.out.println(SiteUser_Email);
        /*JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='siteAdminUserList']//div[text()[normalize-space() = '"+SiteUser_Email+"']]//..//../td//a")));
        Thread.sleep(2000);*/
        
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='siteAdminUserList']//div[text()[normalize-space() = '"+SiteUser_Email+"']]//..//../td//a")));
        driver.findElement(By.xpath("//*[@id='siteAdminUserList']//div[text()[normalize-space() = '"+SiteUser_Email+"']]//..//../td//a")).click();
	}
		

	public void verify_Manage_Delegation_On_Behalf_Of_Screen_displayed(int arg1) throws Exception
	{
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_FirstName = testDataInMap.get("SiteUser"+arg1+"_FirstName");
        String SiteUser_LastName = testDataInMap.get("SiteUser"+arg1+"_LastName");
        
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it=windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        Thread.sleep(4000);
        
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//h1[text()[normalize-space() = \"Manage Delegation on behalf of "+SiteUser_LastName+", "+SiteUser_FirstName+"\"]]")));
	}
	
	@FindBy(how=How.ID, using="manageDelAddDel")
	public WebElement AddDelegate_btn;
	
	public void VerifyAddDelegateButtonInUserProfileSection() throws Exception
	{
		CommonClass.highLightElement(driver,AddDelegate_btn);
	}
	
	
	public void ClickOnAddDelegateButtonInUserProfileSection() throws Exception
	{
		CommonClass.highLightElement(driver,AddDelegate_btn);
		AddDelegate_btn.click();
	}
	
	@FindBy(how=How.ID, using="delegateEmailId")
	public WebElement DelegateEmailId;
	
	public void enter_Email_ID_In_Enter_Delegate_E_mail_Address_of_Site_User(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_Email = testDataInMap.get("SiteUser"+arg1+"_Email");
        
        DelegateEmailId.sendKeys(SiteUser_Email);
        CommonClass.highLightElement(driver, DelegateEmailId);
	}
	
	@FindBy(how=How.ID, using="proceedToDelegateBtn")
	public WebElement DelegateBtn;
	
	
	public void click_On_Delegate_Button_In_User_Profile_Section() throws Throwable {
	   CommonClass.highLightElement(driver, DelegateBtn);
	   DelegateBtn.click();
	}
	
	@FindBy(how=How.ID, using="delegateSuccessActionOk")
	public WebElement DelegateSuccessActionOk_btn;
	
	public void ClickOnOkButtonInUserProfileDelegationCompletePopUp() throws Throwable {
		 CommonClass.highLightElement(driver, DelegateSuccessActionOk_btn);
		 DelegateSuccessActionOk_btn.click();
	}
	
	public void verify_Site_User_Displayed_In_User_Profile_Section(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_Email = testDataInMap.get("SiteUser"+arg1+"_Email");
        
        
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='userProfileDiv']//td[text()[normalize-space() = '"+SiteUser_Email+"']]")));
	}
	
	public void verify_Site_User_Displayed_In_User_Profile_Section_For_Site_User(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_Email = testDataInMap.get("SiteUser"+arg1+"_Email");
        
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='userProfileDiv']//*[text()[normalize-space() = '"+SiteUser_Email+"']]")));
	}
	
	@FindBy(how=How.ID, using="manageUndelegate")
	public WebElement ManageUndelegate_btn;
	
	public void click_On_UnDelegate_Button_In_User_Profile_Section() throws Throwable {
	    CommonClass.highLightElement(driver, ManageUndelegate_btn);
	    Thread.sleep(1000);
	    ManageUndelegate_btn.click();
	}
	
	@FindBy(how=How.ID, using="yesUndelegateBtn")
	public WebElement YesUndelegateBtn;
	
	public void click_Remove_Delegate_UnDelegate_Button_In_User_Profile_Section() throws Throwable {
	    CommonClass.highLightElement(driver, YesUndelegateBtn);
	    YesUndelegateBtn.click();
	}
	
	@FindBy(how=How.ID, using="undelegateActionOk")
	public WebElement UndelegateActionOk;
	
	
	public void click_On_OK_Button_In_User_Profile_Delegate_Removed_PopUp() throws Throwable {
		CommonClass.highLightElement(driver, UndelegateActionOk);
		UndelegateActionOk.click();
	}
	
	public void verify_Site_User_Not_Displayed_In_User_Profile_Section(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_Email = testDataInMap.get("SiteUser"+arg1+"_Email");
        
        try {
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='userProfileDiv']//td[text()[normalize-space() = '"+SiteUser_Email+"']]")));
        }
        catch(Exception e)
        {
        	CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='userProfileDiv']//table")));
        }
     }
	
	@FindBy(how=How.ID, using="delegateOrganization")
	public WebElement Orgainzation_Radio_btn;
	
	
	public void click_On_Orgainzation_Radio_btn() throws Throwable {
		CommonClass.highLightElement(driver, Orgainzation_Radio_btn);
		Orgainzation_Radio_btn.click();
	}
	
	@FindBy(how=How.ID, using="manageDelOrgListId")
	public WebElement Orgainzation_Name_Dropdown;
	
	public void select_Organization_From_Organization_Name_In_Search_Organization_Section(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String Organization_Name = testDataInMap.get("Organization_Name_"+arg1);
        
        Orgainzation_Name_Dropdown.click();
        Thread.sleep(1500);
        Orgainzation_Name_Dropdown.sendKeys(Organization_Name);
        Thread.sleep(3000);
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='orgznTA']//span[@class='label' and text()[normalize-space() = '"+Organization_Name+"']]")));
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id='orgznTA']//span[@class='label' and text()[normalize-space() = '"+Organization_Name+"']]")).click();
        
	}
	
	@FindBy(how=How.ID, using="manageDelegateSearchBtn")
	public WebElement manageDelegateSearch_Btn;
	
	
	public void Click_On_search_Button_In_Search_Organization_Section() throws Throwable {
		CommonClass.highLightElement(driver, manageDelegateSearch_Btn);
		manageDelegateSearch_Btn.click();
	}
	
	public void click_Radio_Button_Against_Organization_In_Search_Organization_Section(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String Organization_Name = testDataInMap.get("Organization_Name_"+arg1);
        
        driver.findElement(By.xpath("//td[text()[normalize-space() = '"+Organization_Name+"']]//../td/input")).click();
	}
	
	@FindBy(how=How.ID, using="delegateOrgnBtn")
	public WebElement DelegateOrgnBtn;
	
	
	public void Click_Delegate_Button_For_Organization_In_Search_Organization_Section() throws Throwable {
		CommonClass.highLightElement(driver, DelegateOrgnBtn);
		DelegateOrgnBtn.click();
	}
	
	@FindBy(how=How.ID, using="delegateUserSuccessBtn")
	public WebElement delegateUserSuccessBtn;
	
	public void Click_On_Ok_Button_In_User_Profile_Delegation_Complete_PopUp() throws Throwable {
		CommonClass.highLightElement(driver, delegateUserSuccessBtn);
		delegateUserSuccessBtn.click();
	}
	
	public void verify_Organization_Displayed_In_Delegate_User_Profile_Screen(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String Organization_Name = testDataInMap.get("Organization_Name_"+arg1);
        
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='userProfileDiv']//p[contains(text(),'Delegated to Organization:  "+Organization_Name+"')]")));
      
	}
	
	
	
	public void verify_Admin_Manage_News_Links_FAQ_Breadcrumb() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='breadcrumbs']")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='breadcrumbs']//a[text()[normalize-space() = 'Admin']]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='breadcrumbs']//a[text()[normalize-space() = 'Manage News/Links/FAQ']]")));
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='myTraining1']/div[1]/button[2]/i")
	public WebElement PrintIcon_ManageNewsLinksFAQ;
	
	public void verify_Print_Icon_In_Manage_News_Links_FAQ_Screen() throws Throwable {
	    CommonClass.highLightElement(driver, PrintIcon_ManageNewsLinksFAQ);
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='myTraining1']/div[1]/button[1]/i")
	public WebElement ExportIcon_ManageNewsLinksFAQ;
	
	public void verify_Export_Icon_In_Manage_News_Links_FAQ_Screen() throws Throwable {
		CommonClass.highLightElement(driver, ExportIcon_ManageNewsLinksFAQ);
	}
	
	@FindBy(how=How.ID, using="addNewItem")
	public WebElement AddNewItem;	
	
	public void verify_Add_News_Links_FAQ_Icon_In_Manage_News_Links_FAQ_Screen() throws Throwable {
		CommonClass.highLightElement(driver, AddNewItem);
	}
	
	@FindBy(how=How.ID, using="showHide")
	public WebElement showHide;	
	
	public void verify_Show_Hide_Column_Dropdown_In_Manage_News_Links_FAQ_Screen() throws Throwable {
		CommonClass.highLightElement(driver, showHide);
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"myTraining1\"]/div[3]")
	public WebElement Pagination_Section;	
	
	
	public void verify_Pagination_In_Manage_News_Links_FAQ_Screen() throws Throwable {
	    CommonClass.scroll(driver);
	    CommonClass.highLightElement(driver, Pagination_Section);
	}
	
	public void click_On_Add_News_Links_FAQ_Button_In_Manage_News_Links_FAQ_Screen() throws Throwable {
		CommonClass.scroll1(driver);
		CommonClass.scroll2(driver);
		AddNewItem.click();
	}
	
	public void verify_Add_News_Links_FAQ_Screen_Is_Displayed() throws Throwable {
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("//h1[text()[normalize-space() = 'Add News/Links/FAQ']]")));
	}
	
	public void verify_Admin_Manage_News_Links_FAQ_Add_News_Links_FAQ_Breadcrumb() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='breadcrumbs']")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='breadcrumbs']//a[text()[normalize-space() = 'Admin']]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='breadcrumbs']//a[text()[normalize-space() = 'Manage News/Links/FAQ']]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='breadcrumbs']//a[text()[normalize-space() = 'Add News/Links/FAQ']]")));
	}
	
	public void verify_OnScreen_Text_For_Add_News_Links_FAQ_Section() throws Throwable {
		String Ontext1="This area is for sharing general sponsor news/links and study news/links/FAQ. Essential communications should be sent through Document Exchange.";
		String Ontext2="For Study News, if you select ‘Send Notification’ checkbox, the e-mail notification will be sent as per recipients e-mail frequency. If you select ‘Send Alert’ checkbox, the e-mail notification will be sent immediately to selected recipients.";
		
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//div[text()[normalize-space() = '"+Ontext1+"']]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//div[text()[normalize-space() = '"+Ontext2+"']]")));
	}
	
	public void verify_POSTING_DETAILS_Header_In_Add_News_Links_FAQ_Screen() throws Throwable {
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("//h5[text()[normalize-space() = 'POSTING DETAILS']]")));
	}
	
	@FindBy(how=How.ID, using="contentTypeId")
	public WebElement ContentType;	
	
	@FindBy(how=How.ID, using="targetAud1")
	public WebElement SponsorUser_Radio_btn;	
	
	@FindBy(how=How.ID, using="targetAud2")
	public WebElement Site_And_Sponsor_Users_btn;	
	
	public void verify_POSTING_DETAILS_Section_In_Add_News_Links_FAQ_Screen() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//label[text()[normalize-space() = 'Content Type']]")));
		CommonClass.highLightElement(driver,ContentType);
		
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//label[text()[normalize-space() = 'Target Audience']]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//label[text()[normalize-space() = 'Sponsor Users']]")));
		CommonClass.highLightElement(driver,SponsorUser_Radio_btn);
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//label[text()[normalize-space() = 'Site and Sponsor Users']]")));
		CommonClass.highLightElement(driver,Site_And_Sponsor_Users_btn);
	}
	
	public void verify_DISPLAY_NEWS_LINKS_FAQ_TO_Header_In_Add_News_Links_FAQ_Screen() throws Throwable {
		CommonClass.scroll2(driver);
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//h5[text()[normalize-space() = 'DISPLAY NEWS/LINKS/FAQ TO']]")));
	}
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"publishNewsAndlinkFormId\"]/div/div[2]/ul")
	public WebElement DISPLAY_NEWS_LINKS_FAQ_TO_Input;
	
	public void verify_DISPLAY_NEWS_LINKS_FAQ_TO_Input_Section_In_Add_News_Links_FAQ_Screen() throws Throwable {
	    CommonClass.highLightElement(driver, DISPLAY_NEWS_LINKS_FAQ_TO_Input);
	}
	
	public void verify_Details_Header_In_Add_News_Links_FAQ_Screen() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//h5[text()[normalize-space() = 'Details']]")));
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"contentTypLinks\"]/div/div[2]/div[1]")
	public WebElement Subject_Input;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"descNoteAll\"]/div/div[2]/div[1]/p")
	public WebElement Description_Input;
	
	@FindBy(how=How.ID, using="urlId")
	public WebElement url_Id;
	
	@FindBy(how=How.ID, using="displatDateId")
	public WebElement DisplayDateId;
	
	@FindBy(how=How.ID, using="expirationDateId")
	public WebElement ExpirationDateId;
	
	@FindBy(how=How.ID, using="addNewButtonSaveId")
	public WebElement Proceed_btn;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"publishNewsAndlinkFormId\"]/div/div[3]/button[2]")
	public WebElement Cancel_btn;
		
	public void verify_Details_Section_In_Add_News_Links_FAQ_Screen() throws Throwable {
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("//label[text()[normalize-space() = 'Subject']]")));
	    CommonClass.highLightElement(driver, Subject_Input);
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("//label[text()[normalize-space() = 'Description']]")));
	    CommonClass.highLightElement(driver, Description_Input);
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='publishNewsAndlinkFormId']//label[text()[normalize-space() = 'URL']]")));
	    CommonClass.highLightElement(driver, url_Id);
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("//label[text()[normalize-space() = 'Display Date']]")));
	    CommonClass.highLightElement(driver, DisplayDateId);
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("//label[text()[normalize-space() = 'Expiration Date']]")));
	    CommonClass.highLightElement(driver, ExpirationDateId);
	    CommonClass.scroll(driver);
	    CommonClass.highLightElement(driver, Proceed_btn);
	    CommonClass.highLightElement(driver, Cancel_btn);
	}
	
	public void select_Study_Links_From_Content_Type_Dropdown() throws Throwable {
		Select doctype1 = new Select (ContentType);
		doctype1.selectByVisibleText("Study Links");
		Thread.sleep(3000);
	}
	
	public void select_Study_FAQs_From_Content_Type_Dropdown() throws Throwable {
		Select doctype1 = new Select (ContentType);
		doctype1.selectByVisibleText("Study FAQ");
		Thread.sleep(3000);
	}
	
	public void select_Sponsor_Links_From_Content_Type_Dropdown() throws Throwable {
		Select doctype1 = new Select (ContentType);
		doctype1.selectByVisibleText("Sponsor Links");
		Thread.sleep(3000);
	}
	
	public void select_Sponsor_News_From_Content_Type_Dropdown() throws Throwable {
		Select doctype1 = new Select (ContentType);
		doctype1.selectByVisibleText("Sponsor News");
		Thread.sleep(3000);
	}
	
	public void select_Study_News_From_Content_Type_Dropdown() throws Throwable {
		CommonClass.scroll1(driver);
		Select doctype1 = new Select (ContentType);
		doctype1.selectByVisibleText("Study News");
		Thread.sleep(3000);
		CommonClass.highLightElement(driver, ContentType);
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"studyCountryId\"]/span")
	public WebElement StudyCountry_DISPLAY_NEWSLINKSFAQ_TO_Section;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"editStudyCountryId\"]/span")
	public WebElement EditStudyCountryId_StudyCountry_DISPLAY_NEWSLINKSFAQ_TO_Section;
	
	
	public void verify_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section_Displayed() throws Throwable {
	    CommonClass.scroll2(driver);
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("//label[text()[normalize-space() = 'Study Country']]")));
	    CommonClass.highLightElement(driver, StudyCountry_DISPLAY_NEWSLINKSFAQ_TO_Section);
	}
	
	public void verify_Country_Displayed_Under_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String StudyCountry = testDataInMap.get("StudyCountry"+arg1);
		
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='studyCountryId']//label[text()[normalize-space() = '"+StudyCountry+"']]")));
	}
	
	public void verify_Study_Country_Displayed_Under_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section(int arg1, int arg2) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        if(arg1==1)
        {
        String StudyCountry = testDataInMap.get("StudyCountry"+arg2);
		
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='studyCountryId']//label[text()[normalize-space() = '"+StudyCountry+"']]")));
        }
        else if(arg1>1)
        {
        	String StudyCountry = testDataInMap.get("Study"+arg1+"Country"+arg2);
    		
            CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='studyCountryId']//label[text()[normalize-space() = '"+StudyCountry+"']]")));
           
        }
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='editStudyCountryId']//i[@title='Close']")
	public WebElement editStudyCountryId_StudyCountry_Close_icon;
	
	public void select_Country_Displayed_Under_The_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String StudyCountry = testDataInMap.get("StudyCountry"+arg1);
		
        EditStudyCountryId_StudyCountry_DISPLAY_NEWSLINKSFAQ_TO_Section.sendKeys(StudyCountry);
        Thread.sleep(4000);
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='editStudyCountryId']//label[text()[normalize-space() = '"+StudyCountry+"']]")));
        driver.findElement(By.xpath("//*[@id='editStudyCountryId']//label[text()[normalize-space() = '"+StudyCountry+"']]//../span/span")).click();
        Thread.sleep(10000);
        editStudyCountryId_StudyCountry_Close_icon.click();
	}
	
	public void verify_That_All_Country_Displayed_Under_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='studyCountryId']//label[text()[normalize-space() = 'All']]")));
		Thread.sleep(1000);
		if (driver.findElements(By.xpath("//*[@id='studyCountryId']//label")).size()>=250)
		{
			CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='studyCountryId']")));
		}
		else
		{
			System.out.println("All Countries Are Not Displayed");
		}
	}
	
	
	
	public void verify_Country_Set_And_Displayed_Under_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String StudyCountry = testDataInMap.get("StudyCountry"+arg1);
        StudyCountry_DISPLAY_NEWSLINKSFAQ_TO_Section.sendKeys(StudyCountry);
        Thread.sleep(1000);
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='studyCountryId']//label[text()[normalize-space() = '"+StudyCountry+"']]")));
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='studyCountryId']/div/div[1]/a[@title='Clear All']")
	public WebElement StudyCountryId_Clear_All;
	
	
	
	
	public void click_On_CLEAR_ALL_Icon_Under_Study_Country_dropdown() throws Throwable {
	    CommonClass.highLightElement(driver, StudyCountryId_Clear_All);
	    StudyCountryId_Clear_All.click();
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='editStudyCountryId']/div/div[1]/a[2]")
	public WebElement editStudyCountryId_Clear_All;
	
	public void click_On_CLEAR_ALL_Icon_Under_Study_Country_dropdown_To_Edit() throws Throwable {
		 CommonClass.highLightElement(driver, editStudyCountryId_Clear_All);
		 editStudyCountryId_Clear_All.click();
	}
	
	public void click_On_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section_Displayed() throws Throwable {
		CommonClass.highLightElement(driver, StudyCountry_DISPLAY_NEWSLINKSFAQ_TO_Section);
		StudyCountry_DISPLAY_NEWSLINKSFAQ_TO_Section.click();
	}
	
	public void click_On_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section_Displayed_For_Edit() throws Throwable {
		EditStudyCountryId_StudyCountry_DISPLAY_NEWSLINKSFAQ_TO_Section.click();
	}
	
	
	public void click_On_Checkbox_against_Send_Notification_Email_will_be_sent_as_per_users_email_preference() throws Throwable {
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id=\"publishNewsAndlinkFormId\"]//label[text()[normalize-space() = \"Send Notification. Email will be sent as per user's email preference.\"]]//../span")));
	    driver.findElement(By.xpath("//*[@id=\"publishNewsAndlinkFormId\"]//label[text()[normalize-space() = \"Send Notification. Email will be sent as per user's email preference.\"]]//../span")).click();
	}
	
	
	@FindBy(how=How.XPATH, using="//*[@id='studyCountryId']//i[@title='Close']")
	public WebElement StudyCountry_Close_icon;
	
	public void click_On_Close_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section_Displayed() throws Throwable {
		CommonClass.highLightElement(driver, StudyCountry_Close_icon);
		StudyCountry_Close_icon.click();
	}
	
	public void select_Country_Displayed_Under_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section_For_Study_FAQs(int arg1) throws Throwable {
		CommonClass.highLightElement(driver, StudyCountry_DISPLAY_NEWSLINKSFAQ_TO_Section);
		StudyCountry_DISPLAY_NEWSLINKSFAQ_TO_Section.click();
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String StudyCountry = testDataInMap.get("StudyCountry"+arg1);
        
        StudyCountry_DISPLAY_NEWSLINKSFAQ_TO_Section.sendKeys(StudyCountry);
        Thread.sleep(3000);
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='studyCountryId']//label[text()[normalize-space() = '"+StudyCountry+"']]")));
        driver.findElement(By.xpath("//*[@id='studyCountryId']//label[text()[normalize-space() = '"+StudyCountry+"']]//../span/span")).click();
        Thread.sleep(1000);
        CommonClass.highLightElement(driver, StudyCountry_Close_icon);
		StudyCountry_Close_icon.click();
	}
	
	
	public void verify_Country_Not_Displayed_Under_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String StudyCountry = testDataInMap.get("StudyCountry"+arg1);
		
        try {
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='studyCountryId']//label[text()[normalize-space() = '"+StudyCountry+"']]")));
        System.out.println(StudyCountry+" Is Displayed");
        driver.quit();
        }
        catch(Exception e)
        {
        	System.out.println(StudyCountry+" Is Not Displayed");
        }
	}
	
	public void select_Site_and_Sponsor_User_Radio_Button_Under_POSTING_DETAILS_Section() throws Throwable {
	    CommonClass.scroll1(driver);
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//label[text()[normalize-space() = 'Site and Sponsor Users']]")));
		Site_And_Sponsor_Users_btn.click();
	}
	
	public void select_Sponsor_User_Radio_Button_Under_POSTING_DETAILS_Section() throws Throwable {
		CommonClass.scroll1(driver);
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//label[text()[normalize-space() = 'Sponsor Users']]")));
		SponsorUser_Radio_btn.click();
	}
	
	@FindBy(how=How.XPATH, using="//div[contains(@class,'roleForSponsorClassByStudyType')]/span")
	public WebElement SponsorUserRole_POSTINGDETAILS;
		
	public void verify_Sponsor_User_Role_Dropdown_Displayed_Under_POSTING_DETAILS_Section() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//div[@class='sponsorUserRoleSectionByStudyType']/label[text()[normalize-space() = 'Sponsor User Role']]")));
		CommonClass.highLightElement(driver, SponsorUserRole_POSTINGDETAILS);
	}
	
	@FindBy(how=How.XPATH, using="//div[contains(@class,'roleForSiteClass')]/span")
	public WebElement SiteUserRole_POSTINGDETAILS;
	
	public void verify_Site_User_Role_Dropdown_Displayed_Under_POSTING_DETAILS_Section() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//div[@class='siteUserRoleSection']/label[text()[normalize-space() = 'Site User Role']]")));
		CommonClass.highLightElement(driver, SiteUserRole_POSTINGDETAILS);
	}
	
	
	@FindBy(how=How.XPATH, using="//div[contains(@class,'roleForSponsorClassByStudyType')]//a[text()[normalize-space() = 'Clear All']]")
	public WebElement SponosorRole_ClearAll;
	
	@FindBy(how=How.XPATH, using="//div[contains(@class,'roleForSponsorClassByStudyType')]//a/i[@title='Close']")
	public WebElement SponosorRole_Close;
	
	public void click_On_Clear_All_Option_From_Sponsor_User_Role_Dropdown() throws Throwable {
		SponsorUserRole_POSTINGDETAILS.click();
		Thread.sleep(1500);
		SponosorRole_ClearAll.click();
		Thread.sleep(1000);
		SponosorRole_Close.click();
	}
	
	public void verify_Role_From_Sponsor_User_Role_Dropdown(String Sponsor_Role) throws Throwable {
		driver.findElement(By.xpath("(//div[contains(@class,'roleForSponsorClass')]/span)[1]")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//div[contains(@class,'roleForSponsorClass')]/span)[1]")).sendKeys(Sponsor_Role);
		Thread.sleep(1500);

		WebElement webelmt2=driver.findElement(By.xpath("(//*[@id=\"publishNewsAndlinkFormId\"]//label[text()[normalize-space() = '"+Sponsor_Role+"']])[1]"));
		CommonClass.highLightElement(driver, webelmt2);
		
		driver.findElement(By.xpath("(//*[@id='publishNewsAndlinkFormId']//i[@title='Close'])[1]")).click();
	}
	
	public void verify_Role_From_Sponsor_User_Role_Dropdown_For_Study_News_Links(String Sponsor_Role) throws Throwable {
		SponsorUserRole_POSTINGDETAILS.click();
		Thread.sleep(1500);
		SponsorUserRole_POSTINGDETAILS.sendKeys(Sponsor_Role);
		Thread.sleep(1500);
		WebElement webelmt=driver.findElement(By.xpath("//div[contains(@class,'roleForSponsorClassByStudyType')]//label[text()[normalize-space() = '"+Sponsor_Role+"']]"));
		CommonClass.highLightElement(driver, webelmt);
		SponosorRole_Close.click();
	}
	
	public void select_Role_From_Sponsor_User_Role_Dropdown(String Sponsor_Role) throws Throwable {
		SponsorUserRole_POSTINGDETAILS.click();
		Thread.sleep(1500);
		SponsorUserRole_POSTINGDETAILS.sendKeys(Sponsor_Role);
		Thread.sleep(1500);
		driver.findElement(By.xpath("//div[contains(@class,'roleForSponsorClassByStudyType')]//label[text()[normalize-space() = '"+Sponsor_Role+"']]//../span/span")).click();
		SponosorRole_Close.click();
	}
	
	@FindBy(how=How.XPATH, using="//div[contains(@class,'roleForSiteClass')]//a[text()[normalize-space() = 'Clear All']]")
	public WebElement SiteRole_ClearAll;
	
	@FindBy(how=How.XPATH, using="//div[contains(@class,'roleForSiteClass')]//a/i[@title='Close']")
	public WebElement SiteRole_Close;
	
	public void click_On_Clear_All_Option_From_Site_User_Role_Dropdown() throws Throwable {
		SiteUserRole_POSTINGDETAILS.click();
		Thread.sleep(1500);
		SiteRole_ClearAll.click();
		Thread.sleep(1000);
		SiteRole_Close.click();
	}
	
	public void verify_Role_From_Site_User_Role_Dropdown(String SiteUser_role) throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//div[contains(@class,'roleForLinkSiteClass')]/span")));
		driver.findElement(By.xpath("//div[contains(@class,'roleForLinkSiteClass')]/span")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//div[contains(@class,'roleForLinkSiteClass')]/span")).sendKeys(SiteUser_role);
		Thread.sleep(1500);
				
		WebElement webelmt2 =	driver.findElement(By.xpath("//div[contains(@class,'roleForLinkSiteClass')]//label[text()[normalize-space() = '"+SiteUser_role+"']]"));
				
		CommonClass.highLightElement(driver, webelmt2);
		
		driver.findElement(By.xpath("//div[contains(@class,'roleForLinkSiteClass')]//i[@title='Close']")).click();
	}
	
	public void verify_Role_From_Site_User_Role_Dropdown_For_Study_News_Links(String SiteUser_role) throws Throwable {
		SiteUserRole_POSTINGDETAILS.click();
		Thread.sleep(1500);
		SiteUserRole_POSTINGDETAILS.sendKeys(SiteUser_role);
		Thread.sleep(1500);
		WebElement webelmt1 =driver.findElement(By.xpath("//div[contains(@class,'roleForSiteClass')]//label[text()[normalize-space() = '"+SiteUser_role+"']]"));
		
		CommonClass.highLightElement(driver, webelmt1);
		SiteRole_Close.click();
	}
	
	public void select_Role_From_Site_User_Role_Dropdown(String SiteUser_role) throws Throwable {
		SiteUserRole_POSTINGDETAILS.click();
		Thread.sleep(1500);
		SiteUserRole_POSTINGDETAILS.sendKeys(SiteUser_role);
		Thread.sleep(1500);
		driver.findElement(By.xpath("//div[contains(@class,'roleForSiteClass')]//label[text()[normalize-space() = '"+SiteUser_role+"']]//../span/span")).click();
		SiteRole_Close.click();
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='compoundId']/span")
	public WebElement CompoundId_DISPLAY_NEWSLINKSFAQ_TO;
	
	public void verify_Compound_Dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section_Is_Visible() throws Throwable {
	    CommonClass.scroll2(driver);
	    if(CompoundId_DISPLAY_NEWSLINKSFAQ_TO.isDisplayed()) {
	    CommonClass.highLightElement(driver, CompoundId_DISPLAY_NEWSLINKSFAQ_TO);}
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='progId']/span")
	public WebElement ProgId_DISPLAY_NEWSLINKSFAQ_TO;
	
	public void verify_Program_Dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section_Is_Visible() throws Throwable {
	    CommonClass.scroll2(driver);
	    if(ProgId_DISPLAY_NEWSLINKSFAQ_TO.isDisplayed()) {
	    CommonClass.highLightElement(driver, ProgId_DISPLAY_NEWSLINKSFAQ_TO);}
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='studyID']/span")
	public WebElement StudyID_DISPLAY_NEWSLINKSFAQ_TO;
	
	public void verify_Study_ID_Dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section_Is_Visible() throws Throwable {
		CommonClass.scroll2(driver);
	    if(StudyID_DISPLAY_NEWSLINKSFAQ_TO.isDisplayed()) {
	    CommonClass.highLightElement(driver, StudyID_DISPLAY_NEWSLINKSFAQ_TO);}
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='compoundId']//a[text()[normalize-space() = 'Clear All']]")
	public WebElement CompoundId_ClearAll;
	
	@FindBy(how=How.XPATH, using="//*[@id='compoundId']//a/i[@title='Close']")
	public WebElement CompoundId_Close;
	
	
	public void select_Compound_For_StudyId_In_Compound_Dropdown(int arg1, int arg2) throws Throwable {
		 properties= obj.getProperty();
		   
         Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
         testData.setTestDatainMap(TestDataInMap);
                
         Map<String,String> testDataInMap = testData.getTestDatainMap();
         String StudyID_Compound = testDataInMap.get("StudyID"+arg2+"_Compound"+arg1);
         CompoundId_DISPLAY_NEWSLINKSFAQ_TO.click();
         Thread.sleep(1500);
         CompoundId_ClearAll.click();
         Thread.sleep(2000);
         driver.findElement(By.xpath("//*[@id='compoundId']//label[text()[normalize-space() = '"+StudyID_Compound+"']]//../span/span")).click();
         Thread.sleep(2000);
         CompoundId_Close.click();

	}
	
	@FindBy(how=How.XPATH, using="//*[@id='progId']//a[text()[normalize-space() = 'Clear All']]")
	public WebElement ProgId_ClearAll;
	
	@FindBy(how=How.XPATH, using="//*[@id='progId']//a/i[@title='Close']")
	public WebElement ProgId_Close;
	
	public void select_Program_For_StudyId_In_Compound_Dropdown(int arg1, int arg2) throws Throwable {
		 properties= obj.getProperty();
		   
         Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
         testData.setTestDatainMap(TestDataInMap);
                
         Map<String,String> testDataInMap = testData.getTestDatainMap();
         String StudyID_Program = testDataInMap.get("StudyID"+arg2+"_Program"+arg1);
         
         ProgId_DISPLAY_NEWSLINKSFAQ_TO.click();
         Thread.sleep(1500);
         ProgId_ClearAll.click();
         Thread.sleep(2000);
         ProgId_DISPLAY_NEWSLINKSFAQ_TO.sendKeys(StudyID_Program);
         Thread.sleep(3000);
         driver.findElement(By.xpath("//*[@id='progId']//label[text()[normalize-space() = '"+StudyID_Program+"']]//../span/span")).click();
         Thread.sleep(2000);
         ProgId_Close.click();
	}

	@FindBy(how=How.XPATH, using="//*[@id='studyID']//a[text()[normalize-space() = 'Clear All']]")
	public WebElement StudyID_ClearAll;
	
	@FindBy(how=How.XPATH, using="//*[@id='studyID']//a/i[@title='Close']")
	public WebElement StudyID_Close;
	
	
	public void select_Study_ID_From_Study_ID_Dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String StudyID = testDataInMap.get("studyID"+arg1);
        
        CommonClass.highLightElement(driver, StudyID_DISPLAY_NEWSLINKSFAQ_TO);
        StudyID_DISPLAY_NEWSLINKSFAQ_TO.click();
        Thread.sleep(1500);
        StudyID_ClearAll.click();
        Thread.sleep(2000);
        StudyID_DISPLAY_NEWSLINKSFAQ_TO.sendKeys(StudyID);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='studyID']//label[text()= '"+StudyID+"']//../span/span")).click();
        Thread.sleep(2000);
        StudyID_Close.click();
	}
	
	public void select_Country_Displayed_Under_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String StudyCountry = testDataInMap.get("StudyCountry"+arg1);
		
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='studyCountryId']//label[text()[normalize-space() = '"+StudyCountry+"']]")));
        driver.findElement(By.xpath("//*[@id='studyCountryId']//label[text()[normalize-space() = '"+StudyCountry+"']]//../span/span")).click();
	}
	
	public void select_Study_Country_Displayed_Under_Study_Country_dropdown_Under_DISPLAY_NEWS_LINKS_FAQ_TO_Section(int arg1, int arg2) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        if(arg1==1)
        {
        String StudyCountry = testDataInMap.get("StudyCountry"+arg1);
		
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='studyCountryId']//label[text()[normalize-space() = '"+StudyCountry+"']]")));
        driver.findElement(By.xpath("//*[@id='studyCountryId']//label[text()[normalize-space() = '"+StudyCountry+"']]//../span/span")).click();
        }
        else if(arg1>1)
        {
        	String StudyCountry = testDataInMap.get("Study"+arg1+"Country"+arg2);
    		
            CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='studyCountryId']//label[text()[normalize-space() = '"+StudyCountry+"']]")));
            driver.findElement(By.xpath("//*[@id='studyCountryId']//label[text()[normalize-space() = '"+StudyCountry+"']]//../span/span")).click();
           
        }
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"contentTypLinks\"]/div/div[2]/div[1]/p")
	public WebElement Subject_Textbox_Details_Section;
	
	public void enter_Text_In_Subject_Textbox_Under_DETAILS_Section() throws Throwable {
		CommonClass.scroll(driver);
		Subject_Textbox_Details_Section.click();
		Thread.sleep(1500);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
		java.util.Date date=new java.util.Date();  
		String str = dateFormat.format(date);
		str = str.replace(" ", "").replaceAll("/","").replaceAll(":", "");
		Subject_Textbox_Details_Section.sendKeys("Subject For Automation "+str);
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='contentTypNews']/div/div[2]/div[1]/p")
	public WebElement Subject_Textbox_ContentTypNews;
	
	public void enter_Text_In_Subject_Textbox_Under_DETAILS_Section_For_Study_News() throws Throwable {
		CommonClass.scroll(driver);
		CommonClass.highLightElement(driver, Subject_Textbox_ContentTypNews);
		Subject_Textbox_ContentTypNews.click();
		Thread.sleep(1500);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
		java.util.Date date=new java.util.Date();  
		String str = dateFormat.format(date);
		str = str.replace(" ", "").replaceAll("/","").replaceAll(":", "");
		Subject_Textbox_ContentTypNews.sendKeys("Subject For Automation "+str);
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='displatDateId']//../span/span")
	public WebElement DisplayDate_Details_Section;
	
	public void select_Display_Date_In_Expiration_Date_Under_DETAILS_Section() throws Throwable {
		DisplayDate_Details_Section.click();
		Thread.sleep(3000);
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		r1.keyRelease(KeyEvent.VK_ENTER);
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='expirationDateId']//../span/span")
	public WebElement ExpirationDate_Details_Section;
	
	public void select_Current_Date_In_Expiration_Date_Under_DETAILS_Section() throws Throwable {
		ExpirationDate_Details_Section.click();
		Thread.sleep(1000);
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='descNoteAll']/div/div[2]/div[1]/p")
	public WebElement Description_Details_Section_StudyNews;
	
	
	public void enter_Description_In_Subject_Textbox_Under_DETAILS_Section_For_Study_News() throws Throwable {
	    CommonClass.highLightElement(driver, Description_Details_Section_StudyNews);
	    Description_Details_Section_StudyNews.click();
	    Thread.sleep(1500);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
		java.util.Date date=new java.util.Date();  
		String str = dateFormat.format(date);
		str = str.replace(" ", "").replaceAll("/","").replaceAll(":", "");
		Description_Details_Section_StudyNews.sendKeys("Description For Automation "+str);
	}
	
	public void enter_URL_In_URL_TextBox_Under_DETAILS_Section() throws Throwable {
		url_Id.sendKeys("https://www.google.com");
	}
		
	public void click_On_PROCEED_Button_Under_DETAILS_Section() throws Throwable {
		Proceed_btn.click();
	}
	
	public void verify_Country_Displayed_In_Study_Link_PopUp(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String StudyCountry = testDataInMap.get("StudyCountry"+arg1);
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//h2[text()[normalize-space() = 'Study Country']]//../p[contains(text(),'"+StudyCountry+"')]")));
		
		StudyLink_subject=driver.findElement(By.xpath("//*[@id='publishReviewPopup']//label[text()[normalize-space() = 'Subject']]//../div/span")).getText();
		System.out.println(StudyLink_subject);
	}
	
	public void verify_Study_Country_Displayed_In_Study_Link_PopUp(int arg1, int arg2) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        if(arg1==1)
        {
        String StudyCountry = testDataInMap.get("StudyCountry"+arg1);
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//h2[text()[normalize-space() = 'Study Country']]//../p[contains(text(),'"+StudyCountry+"')]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='publishReviewPopup']//label[text()[normalize-space() = 'Subject']]//../div/span")));
		
		StudyLink_subject=driver.findElement(By.xpath("//*[@id='publishReviewPopup']//label[text()[normalize-space() = 'Subject']]//../div/span")).getText();
		System.out.println(StudyLink_subject);
        }
        else if (arg1>1)
        {
        	String StudyCountry = testDataInMap.get("Study"+arg1+"Country"+arg2);
    		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//h2[text()[normalize-space() = 'Study Country']]//../p[contains(text(),'"+StudyCountry+"')]")));
    		
    		StudyLink_subject=driver.findElement(By.xpath("//*[@id='publishReviewPopup']//label[text()[normalize-space() = 'Subject']]//../div/span")).getText();
    		System.out.println(StudyLink_subject);
        }
	}
	
	@FindBy(how=How.ID, using="publishNewsButtonId")
	public WebElement PublishNews_Button;
	
	public void click_On_Publish_Button_In_Study_Link_PopUp() throws Throwable {
	    CommonClass.highLightElement(driver, PublishNews_Button);
	    Thread.sleep(1800);
	    PublishNews_Button.click();
	}
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id='addNewLinkSuccessPopup']//button[@value='OK']")
	public WebElement AddNewLink_SuccessPopup;

	public void verify_News_Link_FAQ_has_been_successfully_published_PopUp() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='addNewLinkSuccessPopup']/p[text()[normalize-space() = 'News/Link/FAQ has been successfully published.']]")));
		CommonClass.highLightElement(driver, AddNewLink_SuccessPopup);
	}
	
	public void verify_News_Link_FAQ_has_been_successfully_Updated_PopUp() throws Throwable {
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='addNewLinkSuccessPopup']/p[text()[normalize-space() = 'News/Link/FAQ has been successfully updated.']]")));
	    CommonClass.highLightElement(driver, AddNewLink_SuccessPopup);
	}
	
	public void click_On_OK_Button_In_News_Link_FAQ_has_been_successfully_published_PopUp() throws Throwable {
		CommonClass.highLightElement(driver, AddNewLink_SuccessPopup);
	    AddNewLink_SuccessPopup.click();
	}
	
	@FindBy(how=How.XPATH, using="//div[contains(@class,'contentTypeSelectionClass')]/span")
	public WebElement ContentType_Manage_News_Links_FAQ_Screen;
	
	
	public void select_Study_Links_From_Content_Type_Dropdown_Under_Manage_News_Links_FAQ_Screen() throws Throwable {
		ContentType_Manage_News_Links_FAQ_Screen.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='contentTypeHiddenId']//..//a[text()[normalize-space() = 'Clear All']]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"contentTypeHiddenId\"]//..//label[text()[normalize-space() = 'Study Links']]//../span/span")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='contentTypeHiddenId']//..//i[@title='Close']")).click();
	}
	
	public void select_Study_News_From_Content_Type_Dropdown_Under_Manage_News_Links_FAQ_Screen() throws Throwable {
		ContentType_Manage_News_Links_FAQ_Screen.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='contentTypeHiddenId']//..//a[text()[normalize-space() = 'Clear All']]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='contentTypeHiddenId']//..//label[text()[normalize-space() = 'Study News']]//../span/span")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='contentTypeHiddenId']//..//i[@title='Close']")).click();
	}
	
	public void select_Study_FAQs_From_Content_Type_Dropdown_Under_Manage_News_Links_FAQ_Screen() throws Throwable {
		ContentType_Manage_News_Links_FAQ_Screen.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='contentTypeHiddenId']//..//a[text()[normalize-space() = 'Clear All']]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"contentTypeHiddenId\"]//..//label[text()[normalize-space() = 'Study FAQ']]//../span/span")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='contentTypeHiddenId']//..//i[@title='Close']")).click();
	}
	
	@FindBy(how=How.ID, using="searchManageSponsorStudyNewsBtn")
	public WebElement searchManageSponsorStudyNews_Btn;
	
	public void click_On_SEARCH_Button_Under_Manage_News_Links_FAQ_Screen() throws Throwable {
	    CommonClass.highLightElement(driver, searchManageSponsorStudyNews_Btn);
	    searchManageSponsorStudyNews_Btn.click();
	}
	
	@FindBy(how=How.ID, using="viewlimitoption")
	public WebElement viewlimitoption;
	
	
	public void select_From_Show_Row_Under_Manage_News_Links_FAQ_Screen(int arg1) throws Throwable {
		Select doctype1 = new Select (viewlimitoption);
		doctype1.selectByVisibleText(String.valueOf(arg1));
		Thread.sleep(3000);
	}
	
	
	public void verify_Newly_Created_Study_Link_Displayed_Under_Manage_News_Links_FAQ_Table() throws Throwable {
		try {
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("//p[text()[normalize-space() = '"+StudyLink_subject+"']]")));
		}
		catch(Exception e)
		{
			System.out.println("Object Not Present In Manage_News_Links_FAQ_Table");
		}
	}
	
	public void verify_Newly_Created_Study_News_Displayed_Under_Manage_News_Links_FAQ_Table() throws Throwable {
		try {
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("//p[text()[normalize-space() = '"+StudyLink_subject+"']]")));
		}
		catch(Exception e)
		{
			System.out.println("Object Not Present In Manage_News_Links_FAQ_Table");
		}
	}
	
	public void verify_Newly_Created_Study_News_Not_Displayed_Under_Manage_News_Links_FAQ_Table() throws Throwable {
		try {
		    CommonClass.highLightElement(driver, driver.findElement(By.xpath("//p[text()[normalize-space() = '"+StudyLink_subject+"']]")));
			}
			catch(Exception e)
			{
				System.out.println("Object Not Present In Manage_News_Links_FAQ_Table");
				ExtentReportListner.captureSreenShots(driver);
			}
	}
	
	public void verify_Columns_Of_Manage_News_Links_FAQ_Table() throws Throwable {
		 CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='manageSponsorStudyNewsLinksTable']//*[@id='subject']")));
		 CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='manageSponsorStudyNewsLinksTable']//*[@id='contentType']")));
		 CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='manageSponsorStudyNewsLinksTable']//*[@id='targetAudience']")));
		 CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='manageSponsorStudyNewsLinksTable']//*[@id='studyId']")));
		 CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='manageSponsorStudyNewsLinksTable']//*[@id='displayDate']")));
		 CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='manageSponsorStudyNewsLinksTable']//*[@id='expirationDate']")));
		 CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='manageSponsorStudyNewsLinksTable']//*[@id='postedBy']")));
		 CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='manageSponsorStudyNewsLinksTable']//*[@id='postedDate']")));
		 CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='manageSponsorStudyNewsLinksTable']//*[@id='modifiedBy']")));
		 CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='manageSponsorStudyNewsLinksTable']//*[@id='modifiedDate']")));
		 CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='manageSponsorStudyNewsLinksTable']//*[@id='actions']")));
	}
	
	@FindBy(how=How.ID, using="showHide")
	public WebElement showHide_Dropdown;
	
	@FindBy(how=How.XPATH, using="//*[@id='showHide']//..//a[text()[normalize-space() = 'Clear All']]")
	public WebElement showHide_Dropdown_ClearAll;
	
	public void select_Option_From_Show_Hide_Columns_Dropdown(String arg1) throws Throwable {
		CommonClass.scroll1(driver);
		showHide_Dropdown.click();
		Thread.sleep(3000);
		showHide_Dropdown_ClearAll.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='showHide']//..//span[text()[normalize-space() = '"+arg1+"']]//../span/span")).click();
		Thread.sleep(2500);
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_ESCAPE);
		r1.keyRelease(KeyEvent.VK_ESCAPE);
	}
	
	public void verify_Country_Displayed_Under_Study_Country_Column_For_Newly_Created_Study_Link(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String StudyCountry = testDataInMap.get("StudyCountry"+arg1);
		
		try {
		    CommonClass.highLightElement(driver, driver.findElement(By.xpath("//p[text()[normalize-space() = '"+StudyLink_subject+"']]")));
		    CommonClass.highLightElement(driver, driver.findElement(By.xpath("//p[text()[normalize-space() = '"+StudyLink_subject+"']]//..//..//../td/div[text()[normalize-space() = '"+StudyCountry+"']]")));
		}
			catch(Exception e)
			{
				System.out.println("Object Not Present In Manage_News_Links_FAQ_Table");
			}
	}
	
	public void verify_Country_Displayed_Under_Study_Country_Column_For_Newly_Created_Study_News(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String StudyCountry = testDataInMap.get("StudyCountry"+arg1);
		
		try {
		    CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//p[text()[normalize-space() = '"+StudyLink_subject+"']])[1]")));
		    CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//p[text()[normalize-space() = '"+StudyLink_subject+"']]//..//..//../td/div[contains(text(),'"+StudyCountry+"')])[1]")));
		}
			catch(Exception e)
			{
				System.out.println("Object Not Present In Manage_News_Links_FAQ_Table");
			}
	}
	
	@FindBy(how=How.ID, using="viewlimitoption")
	public WebElement viewlimitoption_Dropdown;
	
	public void verify_Newly_Created_Study_Link_Displayed_Under_Study_Links() throws Throwable {
		try {
			System.out.println(StudyLink_subject);
			CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[text()[normalize-space() = '"+StudyLink_subject+"']]")));
		}
		catch(Exception e)
	    {
	    	CommonClass.scroll(driver);
	    	CommonClass.highLightElement(driver, driver.findElement(By.xpath("//a[text()[normalize-space() = 'View All Study News']]")));
	    	driver.findElement(By.xpath("//a[text()[normalize-space() = 'View All Study News']]")).click();
	    	Thread.sleep(10000);
	    	
		    	Set<String> windows = driver.getWindowHandles();
		        Iterator<String> it=windows.iterator();
		        String parentWindow = it.next();
		        String childWindow = it.next();
		        driver.switchTo().window(childWindow);
		        Thread.sleep(4000);
		        
	        CommonClass.scroll(driver);
	        Select doctype1 = new Select (viewlimitoption_Dropdown);
	        doctype1.selectByVisibleText("50");
	        Thread.sleep(10000);
	        CommonClass.scroll1(driver);
	        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[text()[normalize-space() = '"+StudyLink_subject+"']]")));
	        Thread.sleep(5000);
	        driver.switchTo().window(parentWindow);
	    }
	}
	
	public void verify_Newly_Created_Study_Link_Not_Displayed_Under_Study_News() throws Throwable {
		int flag=0;
		try {
			System.out.println(StudyLink_subject);
			CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[text()[normalize-space() = '"+StudyLink_subject+"']]")));
			flag = 1;
		}
		catch(Exception e)
	    {
			try
			{
				CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='noMatchDiv']")));
				flag=0;
			}
			catch(Exception e1)
			{
		    	CommonClass.scroll(driver);
		    	CommonClass.highLightElement(driver, driver.findElement(By.xpath("//a[text()[normalize-space() = 'View All Study News']]")));
		    	driver.findElement(By.xpath("//a[text()[normalize-space() = 'View All Study News']]")).click();
		    	Thread.sleep(10000);
		    	
			    	Set<String> windows = driver.getWindowHandles();
			        Iterator<String> it=windows.iterator();
			        String parentWindow = it.next();
			        String childWindow = it.next();
			        driver.switchTo().window(childWindow);
			        Thread.sleep(4000);
			        
		        CommonClass.scroll(driver);
		        Select doctype1 = new Select (viewlimitoption_Dropdown);
		        doctype1.selectByVisibleText("50");
		        Thread.sleep(10000);
		        CommonClass.scroll1(driver);
		        try
		        {
			        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[text()[normalize-space() = '"+StudyLink_subject+"']]")));
			        Thread.sleep(5000);
			        flag = 1;
		        }
		        catch(Exception e2)
		        {
		        	ExtentReportListner.captureSreenShots(driver);
		        }
		        driver.switchTo().window(parentWindow);
		        
			}
	    }
		
		if(flag>=1)
		{
			driver.quit();
		}
	}
	
	public void verify_Newly_Created_Study_Link_Not_Displayed_Under_Study_Links() throws Throwable {
	    try {
	    	CommonClass.highLightElement(driver, driver.findElement(By.xpath("//p[text()[normalize-space() = '"+StudyLink_subject+"']]")));
	    }
	    catch(Exception e)
	    {
	    	System.out.println("Study Link Not Displayed");
	    }
	}
	
	@FindBy(how=How.ID, using="uploadNewDocBtn")
	public WebElement UploadNewDocBtn_DETAILS_OF_THE_FAQ_Section;
	
	public void click_On_Upload_New_Document_Button_Under_DETAILS_OF_THE_FAQ_Section() throws Throwable {
	    CommonClass.scroll(driver);
	    CommonClass.highLightElement(driver, UploadNewDocBtn_DETAILS_OF_THE_FAQ_Section);
	    UploadNewDocBtn_DETAILS_OF_THE_FAQ_Section.click();
	}
	
	@FindBy(how=How.ID, using="fileToUpload")
	public WebElement fileToUpload_Upload_New_Document_DETAILS_OF_THE_FAQ_Section;
	
	public void upload_New_Document_From_Local_Machine() throws Throwable {
		String downloadFilepath = System.getProperty("user.dir")+"\\Reports\\DocumentForUpload\\DOC 1.pdf";
		fileToUpload_Upload_New_Document_DETAILS_OF_THE_FAQ_Section.sendKeys(downloadFilepath);
		CommonClass.highLightElement(driver, fileToUpload_Upload_New_Document_DETAILS_OF_THE_FAQ_Section);
	}
	
	@FindBy(how=How.ID, using="relevant_documents_description")
	public WebElement relevant_documents_description_Upload_New_Document_DETAILS_OF_THE_FAQ_Section;
	
	//relevant_documents_description_Upload_New_Document
	public void set_Document_Description_In_Upload_New_Document_PopUp() throws Throwable {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
		java.util.Date date=new java.util.Date();  
		String str = dateFormat.format(date);
		str = str.replace(" ", "").replaceAll("/","").replaceAll(":", "");
		relevant_documents_description_Upload_New_Document_DETAILS_OF_THE_FAQ_Section.sendKeys("Document Description "+str);
		Thread.sleep(1500);
		CommonClass.highLightElement(driver, relevant_documents_description_Upload_New_Document_DETAILS_OF_THE_FAQ_Section);
	}
	
	@FindBy(how=How.ID, using="upload_study_faq_button")
	public WebElement upload_study_faq_button;
	
	public void click_On_Upload_Button_In_Upload_New_Document_PopUp() throws Throwable {
	    CommonClass.highLightElement(driver, upload_study_faq_button);
	    upload_study_faq_button.click();
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='displatDateFaqId']//../span/span")
	public WebElement DisplatDateFaqId;
		
	public void select_Display_Date_In_Display_Date_Under_DETAILS_OF_THE_FAQ_Section() throws Throwable {
		DisplatDateFaqId.click();
		Thread.sleep(2000);
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='expirationDateFaqId']//../span/span")
	public WebElement ExpirationDateFaqId;
	
	public void select_Current_Date_In_Expiration_Date_Under_DETAILS_OF_THE_FAQ_Section() throws Throwable {
		ExpirationDateFaqId.click();
		Thread.sleep(2000);
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void verify_Country_Displayed_Under_Study_Country_In_Study_FAQs_PopUp(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String StudyCountry = testDataInMap.get("StudyCountry"+arg1);
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//h2[text()[normalize-space() = 'Study Country']]//../p[text()[normalize-space() = '"+StudyCountry+"']]")));
		relevant_documents_description_Upload_New_Document=driver.findElement(By.xpath("//*[@id='publishReviewPopup']//label[text()[normalize-space() = 'Description']]//../div/span")).getText();
		System.out.println(relevant_documents_description_Upload_New_Document);
	}
	
	public void verify_Newly_Created_Study_FAQs_Displayed_Under_Manage_News_Links_FAQ_Table_For_Study(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String StudyID = testDataInMap.get("studyID"+arg1);
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//*[@id='manageSponsorStudyNewsLinksTable']//td/div[text()[normalize-space() = '"+StudyID+"']])[1]")));
        Thread.sleep(1000);
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//*[@id='manageSponsorStudyNewsLinksTable']//td/div[text()[normalize-space() = '"+StudyID+"']]//..//../td[2]/div)[1]")));
    	
	}
	
	public void verify_Newly_Created_FAQs_Displayed_Under_Study_FAQ() throws Throwable {
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("//h2[text()[normalize-space() = 'Study FAQ']]")));
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//a[text()[normalize-space() = 'DOC 1.pdf']])[1]")));
	}
	
	public void verify_Study_Country_is_required_Error_Message() throws Throwable {
	    CommonClass.scroll1(driver);
	    Thread.sleep(1000);
	    CommonClass.scroll3(driver);
	    Thread.sleep(1000);
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("//div[@id='studyCountryId_mandatory_Error' and text()[normalize-space() = 'Study Country is required']]")));
	}
	
	public void verify_View_and_Manage_Delegation_on_behalf_of_Site_Users_Screen_Displayed() throws Throwable {
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("//h2[text()[normalize-space() = 'View and Manage Delegation on behalf of Site Users (Investigators/CRU)']]")));
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='siteAdminUserList_length']//select[@name='siteAdminUserList_length']")
	public WebElement Show_Dropdown_In_View_and_Manage_Delegation_on_behalf_of_Site_Users_Screen;
	
	public void select_From_Show_Dropdown_In_View_and_Manage_Delegation_on_behalf_of_Site_Users_Screen(String arg1) throws Throwable {
		CommonClass.scroll(driver);
		Select doctype1 = new Select (Show_Dropdown_In_View_and_Manage_Delegation_on_behalf_of_Site_Users_Screen);
		doctype1.selectByVisibleText(arg1);
		Thread.sleep(3000);
	}	
	
	public void verify_Site_User_Displayed_In_View_and_Manage_Delegation_of_Site_Users_Screen(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_FirstName = testDataInMap.get("SiteUser"+arg1+"_FirstName").trim();
        String SiteUser_LastName = testDataInMap.get("SiteUser"+arg1+"_LastName").trim();
        CommonClass.scroll4(driver);
        Thread.sleep(1500);
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='siteAdminUserList']//div[text()[normalize-space() = \""+SiteUser_LastName+", "+SiteUser_FirstName+"\"]]")));
        CommonClass.scroll1(driver);
	}
	
	public void verify_Site_User_Not_Displayed_In_View_and_Manage_Delegation_of_Site_Users_Screen(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_FirstName = testDataInMap.get("SiteUser"+arg1+"_FirstName");
        String SiteUser_LastName = testDataInMap.get("SiteUser"+arg1+"_LastName");
        CommonClass.scroll4(driver);
        Thread.sleep(1500);
        try {
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='siteAdminUserList']//div[text()[normalize-space() = '"+SiteUser_LastName+", "+SiteUser_FirstName+"']]")));
        
        }
        catch(Exception e) {
        	ExtentReportListner.captureSreenShots(driver);
        	CommonClass.scroll1(driver);
        }
	}
	
	
	@FindBy(how=How.ID, using="userProfileId")
	public WebElement UserProfileId;
	
	
	public void verify_User_Profile_Section_Displayed_Under_Manage_Delegation_on_behalf_of_Site_User_Screen() throws Throwable {
		try {
			CommonClass.highLightElement(driver, UserProfileId);
		}
		catch(Exception e) {
		Set<String> windows = driver.getWindowHandles();
        Iterator<String> it=windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        Thread.sleep(4000);
        CommonClass.highLightElement(driver, UserProfileId);
		}
	}
	
	@FindBy(how=How.ID, using="surveyDetailsId")
	public WebElement SurveyDetailsId;
	
	public void verify_Survey_Section_Displayed_Under_Manage_Delegation_on_behalf_of_Site_User_Screen() throws Throwable {
		try {
			CommonClass.highLightElement(driver, SurveyDetailsId);
		}
		catch(Exception e) {
		Set<String> windows = driver.getWindowHandles();
        Iterator<String> it=windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        Thread.sleep(4000);
        CommonClass.highLightElement(driver, SurveyDetailsId);
		}
	}
	
	@FindBy(how=How.ID, using="studySiteId")
	public WebElement StudySiteId;
	
	public void verify_Study_Site_Profile_Maintenance_Section_Displayed_Under_Manage_Delegation_on_behalf_of_Site_User_Screen() throws Throwable {
		try {
			CommonClass.highLightElement(driver, StudySiteId);
		}
		catch(Exception e) {
		Set<String> windows = driver.getWindowHandles();
        Iterator<String> it=windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        Thread.sleep(4000);
        CommonClass.highLightElement(driver, StudySiteId);
		}
	}
	
	@FindBy(how=How.ID, using="safetyDocContactId")
	public WebElement SafetyDocContactId;
	
	public void verify_Safety_Contact_Regulatory_Contact_PI_Delegate_Section_Displayed_Under_Manage_Delegation_on_behalf_of_Site_User_Screen() throws Throwable {
		try {
			CommonClass.highLightElement(driver, SafetyDocContactId);
		}
		catch(Exception e) {
		Set<String> windows = driver.getWindowHandles();
        Iterator<String> it=windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        Thread.sleep(4000);
        CommonClass.highLightElement(driver, SafetyDocContactId);
		}
	}
	
	public void click_On_Safety_Contact_Regulatory_Contact_PI_Delegate_Under_Manage_Delegation_on_behalf_of_Site_User_Screen() throws Throwable {
		verify_Safety_Contact_Regulatory_Contact_PI_Delegate_Section_Displayed_Under_Manage_Delegation_on_behalf_of_Site_User_Screen();
		SafetyDocContactId.click();
	}
	
	@FindBy(how=How.XPATH, using="//a[text()[normalize-space() = 'DELEGATED TO ME']]")
	public WebElement DELEGATE_TO_ME_Tab;
	
	public void click_On_Study_Site_Profile_Maintenance_Section_Displayed_Under_Manage_Delegation_on_behalf_of_Site_User_Screen() throws Throwable {
	    CommonClass.highLightElement(driver, StudySiteId);
	    StudySiteId.click();
	}
	
	public void verify_Site_User_With_Facility_Displayed_Under_STUDY_SITE_MAINTENANCE_DELEGATES_In_Delegate_Study_Sites_Screen(int arg1, int arg2) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_Email = testDataInMap.get("SiteUser"+arg1+"_Email");
        String Facility = testDataInMap.get("Facility_"+arg2);
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='centralDelegatesTable']//div[text()[normalize-space() = '"+Facility+"']]")));
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='centralDelegatesTable']//div[text()[normalize-space() = '"+Facility+"']]//..//..//div[text()[normalize-space() = '"+SiteUser_Email+"']]")));
	}
	
	public void verify_Site_User_With_Facility_Not_Displayed_Under_STUDY_SITE_MAINTENANCE_DELEGATES_In_Delegate_Study_Sites_Screen(int arg1, int arg2) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_Email = testDataInMap.get("SiteUser"+arg1+"_Email");
        String Facility = testDataInMap.get("Facility_"+arg2);
        try {
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='centralDelegatesTable']//div[text()[normalize-space() = '"+Facility+"']]")));
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='centralDelegatesTable']//div[text()[normalize-space() = '"+Facility+"']]//..//..//div[text()[normalize-space() = '"+SiteUser_Email+"']]")));
        }
        catch(Exception e)
        {
        	CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='centralDelegatesTable_wrapper']/div/div[1]/div")));
        }
	}
	
	
	public void click_On_Remove_Button_Against_Site_User_With_Facility_Under_STUDY_SITE_MAINTENANCE_DELEGATES_In_Delegate_Study_Sites_Screen(int arg1, int arg2) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_Email = testDataInMap.get("SiteUser"+arg1+"_Email");
        String Facility = testDataInMap.get("Facility_"+arg2);
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='centralDelegatesTable']//div[text()[normalize-space() = '"+Facility+"']]")));
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='centralDelegatesTable']//div[text()[normalize-space() = '"+Facility+"']]//..//..//div[text()[normalize-space() = '"+SiteUser_Email+"']]")));
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='centralDelegatesTable']//div[text()[normalize-space() = '"+Facility+"']]//..//..//div[text()[normalize-space() = '"+SiteUser_Email+"']]//..//..//div[@title='Remove Delegate']")));
        driver.findElement(By.xpath("//*[@id='centralDelegatesTable']//div[text()[normalize-space() = '"+Facility+"']]//..//..//div[text()[normalize-space() = '"+SiteUser_Email+"']]//..//..//div[@title='Remove Delegate']")).click();
	}
	
	
	@FindBy(how=How.XPATH, using="//*[@id='modalRemoveDelegateConfirm']//button[@type='button' and text()='Yes']")
	public WebElement RemoveDelegate_ConfirmButton;
	
	
	
	public void verify_No_Delegate_Message_Displayed_Under_STUDY_SITE_MAINTENANCE_DELEGATES_In_Delegate_Study_Sites_Screen() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='centralDelegatesTable']//td[text()[normalize-space() = 'No Delegate']]")));
	}
	
	public void verify_CURRENT_STUDY_SITE_DELEGATES_Table_In_Delegate_Study_Sites_Screen() throws Throwable {
		CommonClass.scroll3(driver);
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='myDelegates']//th[text()[normalize-space() = 'Sponsor/CRO']]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='myDelegates']//th[text()[normalize-space() = 'Study ID']]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='myDelegates']//th[text()[normalize-space() = 'Study Site ID']]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='myDelegates']//th[text()[normalize-space() = 'Delegate Name']]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='myDelegates']//th[text()[normalize-space() = 'Start Date']]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='myDelegates']//th[text()[normalize-space() = 'End Date']]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='myDelegates']//th[text()[normalize-space() = 'Notes']]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='myDelegates']//th[text()[normalize-space() = 'Actions']]")));
	}
	
	public void verify_Site_User_With_Facility_and_Department_Not_Displayed_Under_STUDY_SITE_MAINTENANCE_DELEGATES_In_Delegate_Study_Sites_Screen(int arg1, int arg2, int arg3) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_Email = testDataInMap.get("SiteUser"+arg1+"_Email");
        String Facility = testDataInMap.get("Facility_"+arg2);
        String Department="";
        
        if(arg2==1)
        {
        	Department= testDataInMap.get("Department_"+arg3);
        }
        else if(arg2>1)
        {
        	Department = testDataInMap.get("F"+arg2+"_Department_"+arg3);
        }
        try {
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='centralDelegatesTable']//div[text()[normalize-space() = '"+Facility+" ("+Department+")']]")));
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='centralDelegatesTable']//div[text()[normalize-space() = '"+Facility+" ("+Department+")']]//..//..//div[text()[normalize-space() = '"+SiteUser_Email+"']]")));
        driver.quit();
        }
        catch(Exception e)
        {
        	ExtentReportListner.captureSreenShots(driver);
        }
	}
	
	public void verify_Site_User_With_Facility_and_Department_Displayed_Under_STUDY_SITE_MAINTENANCE_DELEGATES_In_Delegate_Study_Sites_Screen(int arg1, int arg2, int arg3) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_Email = testDataInMap.get("SiteUser"+arg1+"_Email");
        String Facility = testDataInMap.get("Facility_"+arg2);
        String Department="";
        
        if(arg2==1)
        {
        	Department= testDataInMap.get("Department_"+arg3);
        }
        else if(arg2>1)
        {
        	Department = testDataInMap.get("F"+arg2+"_Department_"+arg3);
        }
        try {
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='centralDelegatesTable']//div[text()[normalize-space() = '"+Facility+" ("+Department+")']]")));
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='centralDelegatesTable']//div[text()[normalize-space() = '"+Facility+" ("+Department+")']]//..//..//div[text()[normalize-space() = '"+SiteUser_Email+"']]")));
        }
        catch(Exception e)
        {
        	ExtentReportListner.captureSreenShots(driver);
        }
	}
	
	@FindBy(how=How.ID, using="addCentralDelegateStudySiteBtn")
	public WebElement AddCentralDelegateStudySiteBtn;
	
	
	public void click_On_Add_Delegate_Button_Under_STUDY_SITE_MAINTENANCE_DELEGATES_In_Delegate_Study_Sites_Screen() throws Throwable {
	    CommonClass.highLightElement(driver, AddCentralDelegateStudySiteBtn);
	    Thread.sleep(1000);
	    AddCentralDelegateStudySiteBtn.click();
	}
	
	@FindBy(how=How.ID, using="byFDFirstName")
	public WebElement byFDFirstName;
	
	public void set_Site_User_First_Name_In_First_Name_TextBox_In_By_Facility_Department_Section(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        
        String SiteUser_FirstName = testDataInMap.get("SiteUser"+arg1+"_FirstName");
        
        byFDFirstName.sendKeys(SiteUser_FirstName);
	}
	
	@FindBy(how=How.ID, using="byFDLastName")
	public WebElement byFDLastName;
	
	public void set_Site_User_Last_Name_In_Last_Name_TextBox_In_By_Facility_Department_Section(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        
        String SiteUser_LastName = testDataInMap.get("SiteUser"+arg1+"_LastName");
        
        byFDLastName.sendKeys(SiteUser_LastName);
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='studySites']//button[@title='SEARCH' and text()='SEARCH']")
	public WebElement SiteUserSearchBtn;	
	
	@FindBy(how=How.XPATH, using="//*[@id='byFDFacName']/div/span")
	public WebElement FacilityName_Search_Study_Site_Maintenance_Delegate_Section;
	
	
	public void verify_Site_User_Displayed_Under_Search_Study_Site_Maintenance_Delegate_Table(int arg1) throws Throwable {
		properties= obj.getProperty();
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        
        String SiteUser_Email = testDataInMap.get("SiteUser"+arg1+"_Email");
        
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='facilityContactResult']//td[text()[normalize-space() = '"+SiteUser_Email+"']]")));
	}
	
	public void select_Site_User_Displayed_Under_Search_Study_Site_Maintenance_Delegate_Table(int arg1) throws Throwable {
		properties= obj.getProperty();
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        
        String SiteUser_Email = testDataInMap.get("SiteUser"+arg1+"_Email");
       
        CommonClass.highLightElement(driver,  driver.findElement(By.xpath("//*[@id='facilityContactResult']//td[text()[normalize-space() = '"+SiteUser_Email+"']]//../td//input[@type='radio']")));
        driver.findElement(By.xpath("//*[@id='facilityContactResult']//td[text()[normalize-space() = '"+SiteUser_Email+"']]//../td//input[@type='radio']")).click();
	
	}
	
	@FindBy(how=How.XPATH, using="//h2[text()[normalize-space() = 'Search Study Site Maintenance Delegate']]//../span/i")
	public WebElement SearchStudySiteMaintenanceDelegate_ExpandBtn;
	
	@FindBy(how=How.XPATH, using="//*[@id='studySites']//button[text()[normalize-space() = 'CLEAR SEARCH']]")
	public WebElement SearchStudySiteMaintenanceDelegate_ClearSearchBtn;
	
	@FindBy(how=How.XPATH, using="//button[@title=\"SELECT STUDY DELEGATE\"]")
	public WebElement SELECTSTUDYDELEGATEBtn;
	
	public void click_On_Facility_Dropdown_Under_Search_Study_Site_Maintenance_Delegate_Section_For_Manage_Delegation_on_behalf_of_Screen() throws Throwable {
	   CommonClass.highLightElement(driver, FacilityName_Search_Study_Site_Maintenance_Delegate_Section);
	   Thread.sleep(1500);
	   FacilityName_Search_Study_Site_Maintenance_Delegate_Section.click();
	}
	
	public void select_Facility_In_Add_Facilities_Departments_for_PopUp(int arg1) throws Throwable {
		properties= obj.getProperty();
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        
        String Facility = testDataInMap.get("Facility_"+arg1);
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='facilityDeptTableBody']//label[text()[normalize-space() = '"+Facility+"']]//..//../td/label[not(node())]//..//../td//span[contains(@class,'checkbox')]")));
        driver.findElement(By.xpath("//*[@id='facilityDeptTableBody']//label[text()[normalize-space() = '"+Facility+"']]//..//../td/label[not(node())]//..//../td//span[contains(@class,'checkbox')]")).click();
	}
	
	public void verify_Facility_In_Add_Facilities_Departments_for_PopUp(int arg1) throws Throwable {
		properties= obj.getProperty();
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        
        String Facility = testDataInMap.get("Facility_"+arg1);
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='facilityDeptTableBody']//label[text()[normalize-space() = '"+Facility+"']]//..//../td/label[not(node())]//..//../td//span[contains(@class,'checkbox')]")));
    }
	public void verify_Facility_In_Add_Facilities_Departments_for_PopUp_Not_Displayed(int arg1) throws Throwable {
		properties= obj.getProperty();
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        
        String Facility = testDataInMap.get("Facility_"+arg1);
        try {
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='facilityDeptTableBody']//label[text()[normalize-space() = '"+Facility+"']]//..//../td/label[not(node())]//..//../td//span[contains(@class,'checkbox')]")));
        }
        catch(Exception e)
        {
        	System.out.println(Facility+" Not Displayed");
        }
	} 
        
	
	public void verify_Facility_Displayed_Under_Facility_Dropdown_Under_Search_Study_Site_Maintenance_Delegate_Section(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String Facility = testDataInMap.get("Facility_"+arg1);
        
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//label[text()[normalize-space() = '"+Facility+"'] and @title='"+Facility+"']")));
	}
	
	public void verify_Facility_Not_Displayed_Under_Facility_Dropdown_Under_Search_Study_Site_Maintenance_Delegate_Section(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String Facility = testDataInMap.get("Facility_"+arg1);
        try {
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//label[text()[normalize-space() = '"+Facility+"'] and @title='"+Facility+"']")));
        }
        catch(Exception e)
        {
        	ExtentReportListner.captureSreenShots(driver);
        }
	}
	
	public void close_Facility_Dropdown_Under_Search_Study_Site_Maintenance_Delegate_Section() throws Throwable {
		try {
		 driver.findElement(By.xpath("//*[@id='byFDFacName']//a[@class='closeMulti']/i[@title='Close']")).click();
		}
		catch(Exception e) {
			ExtentReportListner.captureSreenShots(driver);
		}
	}
	
	public void select_Facility_Displayed_Under_Facility_Dropdown_Under_Search_Study_Site_Maintenance_Delegate_Section(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String Facility = testDataInMap.get("Facility_"+arg1);
        
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//label[text()[normalize-space() = '"+Facility+"'] and @title='"+Facility+"']//../span/span")));
        driver.findElement(By.xpath("//label[text()[normalize-space() = '"+Facility+"'] and @title='"+Facility+"']//../span/span")).click();
        Thread.sleep(10000);
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='byFDDepName']/div/span")
	public WebElement DepartmentName_Search_Study_Site_Maintenance_Delegate_Section;
	
	public void click_On_Department_Dropdown_Under_Search_Study_Site_Maintenance_Delegate_Section_For_Manage_Delegation_on_behalf_of_Screen() throws Throwable {
	    CommonClass.highLightElement(driver, DepartmentName_Search_Study_Site_Maintenance_Delegate_Section);
	    if(DepartmentName_Search_Study_Site_Maintenance_Delegate_Section.isEnabled())
	    {
	    	DepartmentName_Search_Study_Site_Maintenance_Delegate_Section.click();
	    }
	}
	
	public void verify_Facility_Department_Not_Displayed_Under_Facility_Dropdown_Under_Search_Study_Site_Maintenance_Delegate_Section(int arg1, int arg2) throws Throwable {
		String Department="";
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        if(arg1==1)
        {
        	Department = testDataInMap.get("Department_"+arg2);
        }
        else if(arg1>1)
        {
        	Department = testDataInMap.get("F"+arg1+"_Department_"+arg2);
        }
        
		if(DepartmentName_Search_Study_Site_Maintenance_Delegate_Section.isEnabled())
	    {
			try {
				CommonClass.highLightElement(driver, driver.findElement(By.xpath("//label[text()[normalize-space() = '"+Department+"']")));
			}
			catch(Exception e)
			{
				ExtentReportListner.captureSreenShots(driver);
			}
	    }
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='studySites']//button[@title='SEARCH']")
	public WebElement studySites_Search_btn;
	
	
	public void click_On_SEARCH_Button_Under_Search_Study_Site_Maintenance_Delegate_Section() throws Throwable {
	    CommonClass.highLightElement(driver, studySites_Search_btn);
	    Thread.sleep(1000);
	    studySites_Search_btn.click();
	}
	
	public void verify_Site_User_Is_Displayed_In_Search_Study_Site_Maintenance_Delegate_Table(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_Email = testDataInMap.get("SiteUser"+arg1+"_Email");
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='facilityContactResult']//td[text()[normalize-space() = '"+SiteUser_Email+"']]")));
        
	}
	
	public void verify_Site_User_Is_Not_Displayed_In_Search_Study_Site_Maintenance_Delegate_Table(int arg1) throws Throwable {
	    try {
	    	verify_Site_User_Is_Displayed_In_Search_Study_Site_Maintenance_Delegate_Table(arg1);
	    }
	    catch(Exception e)
	    {
	    	CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id=\"facilityContactResult\"]")));
	    }
	}
	
	public void select_Site_User_Is_Displayed_In_Search_Study_Site_Maintenance_Delegate_Table(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_Email = testDataInMap.get("SiteUser"+arg1+"_Email");
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='facilityContactResult']//td[text()[normalize-space() = '"+SiteUser_Email+"']]")));
	
        driver.findElement(By.xpath("//*[@id='facilityContactResult']//td[text()[normalize-space() = '"+SiteUser_Email+"']]//../td/label/input")).click();
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='studySites']//button[@title='SELECT STUDY DELEGATE']")
	public WebElement SELECT_STUDY_DELEGATE_Button_Manage_Delegation_on_behalf_of_Screen;
	
	public void click_On_SELECT_STUDY_DELEGATE_Button_In_Manage_Delegation_on_behalf_of_Screen() throws Throwable {
	    CommonClass.highLightElement(driver, SELECT_STUDY_DELEGATE_Button_Manage_Delegation_on_behalf_of_Screen);
	    Thread.sleep(1500);
	    SELECT_STUDY_DELEGATE_Button_Manage_Delegation_on_behalf_of_Screen.click();
	}
	
	public void verify_Add_Facilities_Departments_for_Site_User_PopUp_Displayed(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_FirstName = testDataInMap.get("SiteUser"+arg1+"_FirstName");
        String SiteUser_LastName = testDataInMap.get("SiteUser"+arg1+"_LastName");
               
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='addDelegateFacDeptFormId']/h1[text()[normalize-space() = 'Add Facilities/Departments for:']]")));
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='addDelegateFacDeptFormId']//span[text()[normalize-space() = '"+SiteUser_LastName+", "+SiteUser_FirstName+"']]")));
    }
	
	public void verify_Facility_Is_displayed_In_Add_Facilities_Departments_for_Site_User_PopUp_Displayed(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String Facility = testDataInMap.get("Facility_"+arg1);
        
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='facilityDeptTableBody']//label[text()[normalize-space() = '"+Facility+"']]")));
	}
	
	public void verify_Facility_Not_displayed_In_Add_Facilities_Departments_for_Site_User_PopUp_Displayed(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String Facility = testDataInMap.get("Facility_"+arg1);
        
        try {
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='facilityDeptTableBody']//label[text()[normalize-space() = '"+Facility+"']]")));
        }
        catch(Exception e)
        {
			ExtentReportListner.captureSreenShots(driver);
        }
	}
	
	public void select_Facility_In_Add_Facilities_Departments_for_Site_User_PopUp_Displayed(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String Facility = testDataInMap.get("Facility_"+arg1);
        
        driver.findElement(By.xpath("//*[@id='facilityDeptTableBody']//label[text()[normalize-space() = '"+Facility+"']]//..//../td[1]//span")).click();
        Thread.sleep(1500);
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='facilityDeptTableBody']//label[text()[normalize-space() = '"+Facility+"']]//..//../td[1]//span")));
	}
	
	@FindBy(how=How.ID, using="assignFacDeptDelegateSave")
	public WebElement AssignFacDeptDelegateSave;
	
	public void click_On_SAVE_button_In_Add_Facilities_Departments_for_Site_User_PopUp() throws Throwable {
	    CommonClass.highLightElement(driver, AssignFacDeptDelegateSave);
	    AssignFacDeptDelegateSave.click();
	}
	
	public void verify_Site_User_Is_Added_With_Facility_In_STUDY_SITE_MAINTENANCE_DELEGATES_Table(int arg1, int arg2) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SU_Email = testDataInMap.get("SiteUser"+arg2+"_Email");
        String Facility = testDataInMap.get("Facility_"+arg1);
        
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("")));
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("")));
	}
	
	public void verify_Site_User_For_Study_Is_Displayed_In_CURRENT_STUDY_SITE_DELEGATES_Table(int arg1, int arg2) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_FirstName = testDataInMap.get("SiteUser"+arg1+"_FirstName");
        String SiteUser_LastName = testDataInMap.get("SiteUser"+arg1+"_LastName");
        String studyID = testDataInMap.get("studyID"+arg2);
        
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='myDelegates']//div[text()[normalize-space() = '"+studyID+"']]//..//..//div[contains(text(),'"+SiteUser_LastName+", "+SiteUser_FirstName+"')]")));
        
	}
	
	public void verify_Site_User_For_Study_Is_Not_Displayed_In_CURRENT_STUDY_SITE_DELEGATES_Table(int arg1, int arg2) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_FirstName = testDataInMap.get("SiteUser"+arg1+"_FirstName");
        String SiteUser_LastName = testDataInMap.get("SiteUser"+arg1+"_LastName");
        String studyID = testDataInMap.get("studyID"+arg2);
        
        try {
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='myDelegates']//div[text()[normalize-space() = '"+studyID+"']]//..//..//div[contains(text(),'"+SiteUser_LastName+", "+SiteUser_FirstName+"')]")));
        driver.quit();
        }
        catch(Exception e)
        {
        	CommonClass.highLightElement(driver,driver.findElement(By.xpath("//*[@id='myDelegates']")));
        }
	}
	
	public void verify_Site_User_For_Study_Has_End_Date_As_Blank_In_CURRENT_STUDY_SITE_DELEGATES_Table(int arg1, int arg2) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_FirstName = testDataInMap.get("SiteUser"+arg1+"_FirstName");
        String SiteUser_LastName = testDataInMap.get("SiteUser"+arg1+"_LastName");
        String studyID = testDataInMap.get("studyID"+arg2);
        
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='myDelegates']//div[text()[normalize-space() = '"+studyID+"']]//..//..//div[contains(text(),'"+SiteUser_LastName+", "+SiteUser_FirstName+"')]")));
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='myDelegates']//div[text()[normalize-space() = '"+studyID+"']]//..//..//div[contains(text(),'"+SiteUser_LastName+", "+SiteUser_FirstName+"')]//..//../td[6]/div[not(node())]")));
	}
	
	public void verify_Site_User_For_Study_Has_Start_Date_As_Past_Date_In_CURRENT_STUDY_SITE_DELEGATES_Table(int arg1, int arg2) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_FirstName = testDataInMap.get("SiteUser"+arg1+"_FirstName");
        String SiteUser_LastName = testDataInMap.get("SiteUser"+arg1+"_LastName");
        String studyID = testDataInMap.get("studyID"+arg2);
        
        String StartDate=driver.findElement(By.xpath("//*[@id='myDelegates']//div[text()[normalize-space() = '"+studyID+"']]//..//..//div[contains(text(),'"+SiteUser_LastName+", "+SiteUser_FirstName+"')]//..//../td[5]/div")).getText();
        
        Date startdate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).parse(StartDate);
        System.out.println("Application End Date :"+StartDate);
        
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		java.util.Date date=new java.util.Date();  
		String CurrentDate = dateFormat.format(date);
		System.out.println("Today's Date :"+CurrentDate);
			
		System.out.println("Date Compare Value" + startdate.compareTo(date));
		 if (startdate.compareTo(date) > 0) 
		 {
           System.out.println("START DATE is Future Date");
           driver.quit();
		 } else if (startdate.compareTo(date) < 0) 
		 {
             System.out.println("START DATE is PAST Date");
             CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='myDelegates']//div[text()[normalize-space() = '"+studyID+"']]//..//..//div[contains(text(),'"+SiteUser_LastName+", "+SiteUser_FirstName+"')]//..//../td[5]/div")));
		 }
		 else if (startdate.compareTo(date) == 0) {
        System.out.println("START DATE is CURRENT DATE");
        driver.quit();
		} 
		 else {
        System.out.println("Something weird happened...");
        driver.quit();
    }
		
	}
	
	public void verify_Site_User_For_Study_Has_Start_Date_As_Future_Date_In_CURRENT_STUDY_SITE_DELEGATES_Table(int arg1, int arg2) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_FirstName = testDataInMap.get("SiteUser"+arg1+"_FirstName");
        String SiteUser_LastName = testDataInMap.get("SiteUser"+arg1+"_LastName");
        String studyID = testDataInMap.get("studyID"+arg2);
        
        String StartDate=driver.findElement(By.xpath("//*[@id='myDelegates']//div[text()[normalize-space() = '"+studyID+"']]//..//..//div[contains(text(),'"+SiteUser_LastName+", "+SiteUser_FirstName+"')]//..//../td[5]/div")).getText();
        
        Date startdate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).parse(StartDate);
        System.out.println("Application End Date :"+StartDate);
        
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		java.util.Date date=new java.util.Date();  
		String CurrentDate = dateFormat.format(date);
		System.out.println("Today's Date :"+CurrentDate);
		
		System.out.println("Date Compare Value" + startdate.compareTo(date));
		 if (startdate.compareTo(date) > 0) 
		 {
           System.out.println("START DATE Is A Future Date");
           CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='myDelegates']//div[text()[normalize-space() = '"+studyID+"']]//..//..//div[contains(text(),'"+SiteUser_LastName+", "+SiteUser_FirstName+"')]//..//../td[5]/div")));
  		 
		 } else if (startdate.compareTo(date) < 0) 
		 {
             System.out.println("START DATE Is A Past Date");
             driver.quit();
         }
		 else if (startdate.compareTo(date) == 0) {
		      System.out.println("START DATE Is Current Date");
		      driver.quit();
		} 
		 else {
        System.out.println("Something weird happened...");
        driver.quit();
    }
	}
	
	public void verify_Site_User_For_Study_Has_Start_Date_As_Current_Date_In_CURRENT_STUDY_SITE_DELEGATES_Table(int arg1, int arg2) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_FirstName = testDataInMap.get("SiteUser"+arg1+"_FirstName");
        String SiteUser_LastName = testDataInMap.get("SiteUser"+arg1+"_LastName");
        String studyID = testDataInMap.get("studyID"+arg2);
        
        String StartDate=driver.findElement(By.xpath("//*[@id='myDelegates']//div[text()[normalize-space() = '"+studyID+"']]//..//..//div[contains(text(),'"+SiteUser_LastName+", "+SiteUser_FirstName+"')]//..//../td[5]/div")).getText();
        System.out.println("Application End Date :"+StartDate);
        
        
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		java.util.Date date=new java.util.Date();  
		String CurrentDate = dateFormat.format(date);
		System.out.println("Today's Date :"+ CurrentDate);
		
		System.out.println("Compare Value " + StartDate.compareTo(CurrentDate));
		
		if (StartDate.compareTo(CurrentDate) > 0) 
		 {
           System.out.println("START DATE Is A Past Date");
           driver.quit();
		 } else if (StartDate.compareTo(CurrentDate) < 0) 
		 {
             System.out.println("START DATE Is A Future Date");
             driver.quit();
		 }
		 else if (StartDate.compareTo(CurrentDate) == 0) {
	        System.out.println("START DATE Is Current Date");
	        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='myDelegates']//div[text()[normalize-space() = '"+studyID+"']]//..//..//div[contains(text(),'"+SiteUser_LastName+", "+SiteUser_FirstName+"')]//..//../td[5]/div")));
		 } 
		 else {
        System.out.println("Something weird happened...");
        driver.quit();
    }
	}
	
	public void verify_Site_User_For_Study_Has_End_Date_As_Future_Date_In_CURRENT_STUDY_SITE_DELEGATES_Table(int arg1, int arg2) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_FirstName = testDataInMap.get("SiteUser"+arg1+"_FirstName");
        String SiteUser_LastName = testDataInMap.get("SiteUser"+arg1+"_LastName");
        String studyID = testDataInMap.get("studyID"+arg2);
        
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='myDelegates']//div[text()[normalize-space() = '"+studyID+"']]//..//..//div[contains(text(),'"+SiteUser_LastName+", "+SiteUser_FirstName+"')]//..//../td[6]/div")));
        String StartDate=driver.findElement(By.xpath("//*[@id='myDelegates']//div[text()[normalize-space() = '"+studyID+"']]//..//..//div[contains(text(),'"+SiteUser_LastName+", "+SiteUser_FirstName+"')]//..//../td[6]/div")).getText();
        
        Date startdate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).parse(StartDate);
        System.out.println("Application End Date :"+StartDate);
        
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		java.util.Date date=new java.util.Date();  
		String CurrentDate = dateFormat.format(date);
		
		 if (startdate.compareTo(date) > 0) 
		 {
          System.out.println("END DATE Is A Past Date");
		 } 
		 else if (startdate.compareTo(date) < 0) 
		 {
            System.out.println("END DATE Is A Future Date");
            CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='myDelegates']//div[text()[normalize-space() = '"+studyID+"']]//..//..//div[contains(text(),'"+SiteUser_LastName+", "+SiteUser_FirstName+"')]//..//../td[6]/div")));
		 }
		 else if (startdate.compareTo(date) == 0) 
		 {
			 System.out.println("END DATE Is Current Date");
		 } 
		 else 
		 {
			 System.out.println("Something weird happened...");
			 driver.quit();
		 }
	}
	
	public void click_Edit_Under_Site_User_For_Study_Is_Displayed_In_CURRENT_STUDY_SITE_DELEGATES_Table(int arg1, int arg2) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_FirstName = testDataInMap.get("SiteUser"+arg1+"_FirstName");
        String SiteUser_LastName = testDataInMap.get("SiteUser"+arg1+"_LastName");
        String studyID = testDataInMap.get("studyID"+arg2);
        
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='myDelegates']//div[text()[normalize-space() = '"+studyID+"']]//..//..//div[contains(text(),'"+SiteUser_LastName+", "+SiteUser_FirstName+"')]//..//../td[8]//button[@title='Edit']/i")));
		driver.findElement(By.xpath("//*[@id='myDelegates']//div[text()[normalize-space() = '"+studyID+"']]//..//..//div[contains(text(),'"+SiteUser_LastName+", "+SiteUser_FirstName+"')]//..//../td[8]//button[@title='Edit']/i")).click();
	}

	public void verify_And_Click_On_DatePicker_of_End_Date_In_CURRENT_STUDY_SITE_DELEGATES_Table_For_Site_User_For_Study(int arg1, int arg2) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_FirstName = testDataInMap.get("SiteUser"+arg1+"_FirstName");
        String SiteUser_LastName = testDataInMap.get("SiteUser"+arg1+"_LastName");
        String studyID = testDataInMap.get("studyID"+arg2);
        
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='myDelegates']//div[text()[normalize-space() = '"+studyID+"']]//..//..//div[contains(text(),'"+SiteUser_LastName+", "+SiteUser_FirstName+"')]//..//../td[6]//input[@name='currentStudyEndDate']")));
		driver.findElement(By.xpath("//*[@id='myDelegates']//div[text()[normalize-space() = '"+studyID+"']]//..//..//div[contains(text(),'"+SiteUser_LastName+", "+SiteUser_FirstName+"')]//..//../td[6]//input[@name='currentStudyEndDate']//../span/span")).click();
		
	}
	
	public void select_Current_Date_End_Date_In_CURRENT_STUDY_SITE_DELEGATES_Table_For_Site_User_For_Study() throws Throwable {
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void select_Future_Date_In_End_Date_In_CURRENT_STUDY_SITE_DELEGATES_Table_For_Site_User_For_Study() throws Throwable {
		Robot r1 = new Robot();
		for(int i=1;i<5;i++)
		{
		r1.keyPress(KeyEvent.VK_RIGHT);
		r1.keyRelease(KeyEvent.VK_RIGHT);
		Thread.sleep(500);
		}
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	public void click_Save_For_Site_User_For_Study_Is_Displayed_In_CURRENT_STUDY_SITE_DELEGATES_Table(int arg1, int arg2) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_FirstName = testDataInMap.get("SiteUser"+arg1+"_FirstName");
        String SiteUser_LastName = testDataInMap.get("SiteUser"+arg1+"_LastName");
        String studyID = testDataInMap.get("studyID"+arg2);
        
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='myDelegates']//div[text()[normalize-space() = '"+studyID+"']]//..//..//div[contains(text(),'"+SiteUser_LastName+", "+SiteUser_FirstName+"')]//..//../td[8]//i")));
		driver.findElement(By.xpath("//*[@id='myDelegates']//div[text()[normalize-space() = '"+studyID+"']]//..//..//div[contains(text(),'"+SiteUser_LastName+", "+SiteUser_FirstName+"')]//..//../td[8]//i")).click();
	}
	
	@FindBy(how=How.ID, using="endStudySiteDelegationModalSave")
	public WebElement endStudySiteDelegationModalSave;
	
	@FindBy(how=How.ID, using="endStudySiteDelegationModalCancel")
	public WebElement endStudySiteDelegationModalCancel;
	
	
	public void verify_End_Study_Site_Delegation_PopUp() throws Throwable {
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='endStudySiteDelegationModalForm']//h1[text()[normalize-space() = 'End Study Site Delegation']]")));
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='endStudySiteDelegationModalForm']//label[text()[normalize-space() = 'If this individual is assigned to other roles on the study that you wish to end, you should make these changes from the Study Site Profile.']]")));
	    CommonClass.highLightElement(driver, endStudySiteDelegationModalSave);
	    CommonClass.highLightElement(driver, endStudySiteDelegationModalCancel);
	}
	
	public void click_On_END_THIS_STUDY_SITE_DELEGATION_Button_In_End_Study_Site_Delegation_PopUp() throws Throwable {
		 CommonClass.highLightElement(driver, endStudySiteDelegationModalSave);
		 endStudySiteDelegationModalSave.click();
	}
	
	@FindBy(how=How.XPATH, using="//input[@id='fromDateId']//../span/span")
	public WebElement From_DateId;
	
	@FindBy(how=How.XPATH, using="//input[@id='toDateId']//../span/span")
	public WebElement To_DateId;
	
	public void click_Expiration_Date_Range_Manage_News_Links_FAQ_As_Current_Date() throws Throwable {
		From_DateId.click();
		Thread.sleep(3000);
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(5000);
		To_DateId.click();
		Thread.sleep(3000);
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void verify_Newly_Created_Study_News_Displayed_Under_Subject_Document_Column() throws Throwable {
	  CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='manageSponsorStudyNewsLinksTable']//p[text()[normalize-space() = '"+StudyLink_subject+"']]")));
	}
	
	public void scroll_ManageSponsorStudyNewsLinksTable_To_View_Actions_Dropdown() throws Throwable {
	    driver.findElement(By.xpath("(//*[@id='actions'])[1]")).click();
	}
	
	public void click_On_Edit_Button_Against_Newly_Created_Study_News_Displayed_Under_Actions_Column() throws Throwable {
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='manageSponsorStudyNewsLinksTable']//p[text()[normalize-space() = '"+StudyLink_subject+"']]//..//..//../td[18]//a[@title='Edit']")));
	    driver.findElement(By.xpath("//*[@id='manageSponsorStudyNewsLinksTable']//p[text()[normalize-space() = '"+StudyLink_subject+"']]//..//..//../td[18]//a[@title='Edit']")).click();
	}
	
	public void verify_Study_Displayed_In_Study_Link_PopUp(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String Study = testDataInMap.get("studyID"+arg1);
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='publishReviewPopup']//p[contains(text(), '"+Study+"')]")));
		
		StudyLink_subject=driver.findElement(By.xpath("//*[@id='publishReviewPopup']//label[text()[normalize-space() = 'Subject']]//../div/span")).getText();
		System.out.println(StudyLink_subject);
	}
	
	public void verify_User_Navigated_To_Manage_News_Links_FAQ_Screen() throws Throwable {
	   CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='myTraining1']/h1[text()[normalize-space() = 'Manage News/Links/FAQ']]")));
	}
	
	
	public void verify_Content_Type_Dropdown_In_Manage_News_Links_FAQ_section() throws Throwable {
		CommonClass.scroll1(driver);
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='manageNewsLinkSearchId']//label[text()[normalize-space() = 'Content Type']]")));
	    CommonClass.highLightElement(driver, ContentType_Manage_News_Links_FAQ_Screen);
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"targetAudienceSelectionId\"]/span")
	public WebElement TargetAudienceSelectionId;
	
	@FindBy(how=How.XPATH, using="//*[@id='targetAudienceSelectionId']//i[@title='Close']")
	public WebElement TargetAudienceSelectionId_Closeicon;
	
	public void verify_Target_Audience_Dropdown_In_Manage_News_Links_FAQ_section() throws Throwable {
		 CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='manageNewsLinkSearchId']//label[text()[normalize-space() = 'Target Audience']]")));
		 CommonClass.highLightElement(driver, TargetAudienceSelectionId);
		 TargetAudienceSelectionId.click();
		 Thread.sleep(1500);
		 CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='targetAudienceSelectionId']/div/div[1]/label[contains(@class,'checked')]")));
		 Thread.sleep(1000);
		 CommonClass.highLightElement(driver, TargetAudienceSelectionId_Closeicon);
		 TargetAudienceSelectionId_Closeicon.click();
	}
	
	public void verify_All_Option_Of_Target_Audience_In_Manage_News_Links_FAQ_section() throws Throwable {
		TargetAudienceSelectionId.click();
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='targetAudienceSelectionId']//label[text()[normalize-space() = 'Sponsor Users']]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='targetAudienceSelectionId']//label[text()[normalize-space() = 'Site and Sponsor Users']]")));
		TargetAudienceSelectionId_Closeicon.click();
	}
	
	
	public void verify_Expiration_Date_Range_In_Manage_News_Links_FAQ_section() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='manageNewsLinkSearchId']//label[text()[normalize-space() = 'Expiration Date Range']]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='manageNewsLinkSearchId']//input[@id='fromDateId']")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='manageNewsLinkSearchId']//input[@id='toDateId']")));
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='compoundId']/span")
	public WebElement CompoundId;
	
	@FindBy(how=How.XPATH, using="//*[@id='compoundId']//i[@title='Close']")
	public WebElement CompoundId_CloseIcon;
	
	public void verify_Compound_In_Manage_News_Links_FAQ_section() throws Throwable {
		  CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='manageNewsLinkSearchId']//label[text()[normalize-space() = 'Compound']]")));
		  CommonClass.highLightElement(driver, CompoundId);
		  CompoundId.click();
		  Thread.sleep(1500);
		  CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='compoundId']/div/div[1]/span/span[contains(@class,'checked')]")));
		  Thread.sleep(1500);
		  CompoundId_CloseIcon.click();
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"progId\"]/span")
	public WebElement ProgId;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"progId\"]//i[@title=\"Close\"]")
	public WebElement ProgId_CloseIcon;
	
	public void verify_Program_In_Manage_News_Links_FAQ_section() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='manageNewsLinkSearchId']//label[text()[normalize-space() = 'Program']]")));
		  CommonClass.highLightElement(driver, ProgId);
		  ProgId.click();
		  Thread.sleep(1500);
		  CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='progId']/div/div[1]/span/span[contains(@class,'checked')]")));
		  Thread.sleep(1500);
		  ProgId_CloseIcon.click();
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"studyID\"]/span")
	public WebElement StudyID;
	
	@FindBy(how=How.XPATH, using="//*[@id='studyID']//i[@title='Close']")
	public WebElement StudyID_CloseIcon;
	
	public void verify_Study_ID_Dropdown_In_Manage_News_Links_FAQ_section() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='manageNewsLinkSearchId']//label[text()[normalize-space() = 'Study ID']]")));
		CommonClass.highLightElement(driver, StudyID);
		StudyID.click();
		Thread.sleep(1500);
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='studyID']/div/div[1]/span/span[contains(@class,'checked')]")));
		Thread.sleep(1500);
		StudyID_CloseIcon.click();
	}
	
	public void verify_All_Options_Of_Content_Type_Dropdown_In_Manage_News_Links_FAQ_section() throws Throwable {
	    /*int ContentTypeOption_Count=driver.findElements(By.xpath("//*[@id='contentTypeHiddenId']//..//div[@class='chk tAchk']//label")).size();
	    String[] ar = new String[ContentTypeOption_Count+1] ;
	    
	    for (int i=1;i<=ContentTypeOption_Count;i++)
	    {
	    	WebElement wb=driver.findElement(By.xpath("(//*[@id='contentTypeHiddenId']//..//div[@class='chk tAchk']//label)["+i+"]"));
	    	ar[i]=wb.getText();
	    }
	    boolean contains = Arrays.stream(ar).anyMatch("Sponsor Links"::equals);
	    for (int i=1;i<=ContentTypeOption_Count;i++)
		System.out.println(ar[i]);
		System.out.println(contains);*/
		ContentType_Manage_News_Links_FAQ_Screen.click();
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='manageNewsLinkSearchId']//label[text()[normalize-space() = 'Sponsor Links']]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='manageNewsLinkSearchId']//label[text()[normalize-space() = 'Sponsor News']]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='manageNewsLinkSearchId']//label[text()[normalize-space() = 'Study Links']]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='manageNewsLinkSearchId']//label[text()[normalize-space() = 'Study News']]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='manageNewsLinkSearchId']//label[text()[normalize-space() = 'Study FAQ']]")));
		driver.findElement(By.xpath("//*[@id='manageNewsLinkSearchId']//i[@title='Close']")).click();
	}
	
	public void verify_Manage_News_Links_FAQ_Link_Screen_Is_Displayed() throws Throwable {
	   CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='myTraining1']/h1[text()[normalize-space() = 'Manage News/Links/FAQ']]")));
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='facilityIds']/span")
	public WebElement FacilityIds_ViewandManageDelegationonbehalfofSiteUsers;
	
	@FindBy(how=How.XPATH, using="//*[@id='facilityIds']//a[@title=\"Clear All\"]")
	public WebElement FacilityIds_ClearAlIcon_ViewandManageDelegationonbehalfofSiteUsers;
	
	@FindBy(how=How.XPATH, using="//*[@id='facilityIds']//i[@title='Close']")
	public WebElement FacilityIds_CloseIcon_ViewandManageDelegationonbehalfofSiteUsers;
	
	
	
	public void click_On_Clear_All_Icon_In_Facility_Dropdown_For_View_and_Manage_Delegation_on_behalf_of_Site_Users_Screen() throws Throwable {
		 CommonClass.highLightElement(driver, FacilityIds_ViewandManageDelegationonbehalfofSiteUsers);
		 FacilityIds_ViewandManageDelegationonbehalfofSiteUsers.click();
		 Thread.sleep(2000);
		 CommonClass.highLightElement(driver, FacilityIds_ClearAlIcon_ViewandManageDelegationonbehalfofSiteUsers);
		 FacilityIds_ClearAlIcon_ViewandManageDelegationonbehalfofSiteUsers.click();
		 Thread.sleep(3000);
		 CommonClass.highLightElement(driver, FacilityIds_CloseIcon_ViewandManageDelegationonbehalfofSiteUsers);
		 FacilityIds_CloseIcon_ViewandManageDelegationonbehalfofSiteUsers.click();
	}
	
	public void select_Facility_From_Facility_Dropdown_In_View_and_Manage_Delegation_on_behalf_of_Site_Users_Screen(int arg1) throws Throwable {
		FacilityIds_ViewandManageDelegationonbehalfofSiteUsers.click();
		Thread.sleep(1500);
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String Facility = testDataInMap.get("Facility_"+arg1);
        
        FacilityIds_ViewandManageDelegationonbehalfofSiteUsers.sendKeys(Facility);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='facilityIds']//label[text()[normalize-space() = '"+Facility+"']]//../span/span")).click();
        Thread.sleep(4000);
        CommonClass.highLightElement(driver, FacilityIds_CloseIcon_ViewandManageDelegationonbehalfofSiteUsers);
        FacilityIds_CloseIcon_ViewandManageDelegationonbehalfofSiteUsers.click();
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"siteAdminUserList_length\"]/label/select")
	public WebElement Show_Rows_Dropdown_In_View_and_Manage_Delegation_Screen;
	
	public void select_From_Show_Rows_Dropdown_In_View_and_Manage_Delegation_Screen(int arg1) throws Throwable {
	    String row_value=String.valueOf(arg1);
	    CommonClass.scroll(driver);
	    Select doctype1 = new Select (Show_Rows_Dropdown_In_View_and_Manage_Delegation_Screen);
	    doctype1.selectByVisibleText(row_value);
	    Thread.sleep(3000);
	    CommonClass.scroll1(driver);
	}
	
	public void verify_Facility_Is_Displayed_In_Facility_Name_Dropdown_In_Search_Study_Site_Maintenance_Delegate_Screen(int arg1) throws Throwable {
		Thread.sleep(1500);
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String Facility = testDataInMap.get("Facility_"+arg1);
        
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//label[text()[normalize-space() = '"+Facility+"']]")));
	}
	
	public void verify_Site_User_For_Facility_Is_Displayed_Under_DELEGATE_FOR_CURRENT_AND_FUTURE_STUDIES_FACILITY_Table_As_Active(int arg1, int arg2) throws Throwable {
	    Thread.sleep(1500);
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUserFN = testDataInMap.get("SiteUser"+arg1+"_FirstName");
        String SiteUserLN = testDataInMap.get("SiteUser"+arg1+"_LastName");
        String Facility = testDataInMap.get("Facility_"+arg2);
        
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id=\"tblDelegatedFacDelegates\"]/tbody/tr/td[text()[normalize-space() = 'Active']]//../td[contains(text(),\""+Facility+"\")]//../td[text()[normalize-space() = \""+SiteUserFN+"\"]]")));
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id=\"tblDelegatedFacDelegates\"]/tbody/tr/td[text()[normalize-space() = 'Active']]//../td[contains(text(),\""+Facility+"\")]//../td[text()[normalize-space() = \""+SiteUserLN+"\"]]")));
    	
	}
	
	public void verify_Site_User_From_Facility_Associated_with_Department_Displayed_as(int arg1, int arg2, int arg3, String arg4) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUserEmail = testDataInMap.get("SiteUser"+arg1+"_Email");
        String Facility = testDataInMap.get("Facility_"+arg2);
        String Department =null;
        
        if (arg2==1)
        {
        	Department=testDataInMap.get("Department_"+arg3);
        }
        else
        {
        	Department=testDataInMap.get("F"+arg2+"_Department_"+arg3);
        }
        
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id=\"safetyDocumentContactTable\"]//td[text()[normalize-space() = \""+Facility+" ("+Department+")\"]]//../td[text()[normalize-space() = '"+SiteUserEmail+"']]//../td[text()[normalize-space() = \""+arg4+"\"]]")));
        
	}
	
	public void verify_SAFETY_CONTACT_AND_REGULATORY_CONTACT_PI_DELEGATE_Table_Columns() throws Throwable {
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//div[text()[normalize-space() = 'Delegate for Facility/ Department']])[1]")));
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//div[text()[normalize-space() = 'Role']])[1]")));
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//div[text()[normalize-space() = 'Delegate Name']])[1]")));
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//div[text()[normalize-space() = 'Email Address']])[1]")));
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//div[text()[normalize-space() = 'Phone Number']])[1]")));
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//div[text()[normalize-space() = 'Effective Date']])[1]")));
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//div[text()[normalize-space() = 'Remove Delegate']])[1]")));
	}
	
	public void click_On_Remove_For_Site_User_From_Facility_Associated_with_Department_Displayed_as(int arg1, int arg2, int arg3, String arg4) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUserEmail = testDataInMap.get("SiteUser"+arg1+"_Email");
        String Facility = testDataInMap.get("Facility_"+arg2);
        String Department =null;
        
        if (arg2==1)
        {
        	Department=testDataInMap.get("Department_"+arg3);
        }
        else
        {
        	Department=testDataInMap.get("F"+arg2+"_Department_"+arg3);
        }
        
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id=\"safetyDocumentContactTable\"]//td[text()[normalize-space() = \""+Facility+" ("+Department+")\"]]//../td[text()[normalize-space() = '"+SiteUserEmail+"']]//../td[text()[normalize-space() = \""+arg4+"\"]]//..//div[@title=\"Remove Delegate\"]//i")));
        driver.findElement(By.xpath("//*[@id=\"safetyDocumentContactTable\"]//td[text()[normalize-space() = \""+Facility+" ("+Department+")\"]]//../td[text()[normalize-space() = '"+SiteUserEmail+"']]//../td[text()[normalize-space() = \""+arg4+"\"]]//..//div[@title=\"Remove Delegate\"]//i")).click();
	}

	@FindBy(how=How.XPATH, using="//*[@id=\"modalRemoveDelegateConfirmation\"]//button[text()[normalize-space() = 'Yes']]")
	public WebElement ModalRemoveDelegateConfirmation_Yes;
	
	
	public void verify_Site_User_From_Facility_Associated_with_Department_Not_Displayed_as(int arg1, int arg2, int arg3, String arg4) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUserEmail = testDataInMap.get("SiteUser"+arg1+"_Email");
        String Facility = testDataInMap.get("Facility_"+arg2);
        String Department =null;
        
        if (arg2==1)
        {
        	Department=testDataInMap.get("Department_"+arg3);
        }
        else
        {
        	Department=testDataInMap.get("F"+arg2+"_Department_"+arg3);
        }
        try {
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id=\"safetyDocumentContactTable\"]//td[text()[normalize-space() = \""+Facility+" ("+Department+")\"]]//../td[text()[normalize-space() = '"+SiteUserEmail+"']]//../td[text()[normalize-space() = \""+arg4+"\"]]//..//div[@title=\"Remove Delegate\"]//i")));
        driver.findElement(By.xpath("//*[@id=\"safetyDocumentContactTable\"]//td[text()[normalize-space() = \""+Facility+" ("+Department+")\"]]//../td[text()[normalize-space() = '"+SiteUserEmail+"']]//../td[text()[normalize-space() = \""+arg4+"\"]]//..//div[@title=\"Remove Delegate\"]//i")).click();
        }
        catch(Exception e)
        {
        	
        }
	}
	
	public void verify_Study_Site_Profile_Maintenance_Tab_Not_Displayed() throws Throwable {
	    try
	    {
	    	CommonClass.highLightElement(driver, StudySiteId);
	    }
	    catch(Exception e)
	    {
	    	CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id=\"tabs\"]/ul")));
	    }
	}
	
	public void verify_Safety_Contact_Regulatory_Contact_PI_Delegate_Not_Displayed() throws Throwable {
		try {
			CommonClass.highLightElement(driver, SafetyDocContactId);
		}
		 catch(Exception e)
	    {
	    	CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id=\"tabs\"]/ul")));
	    }
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"facilityContactResult_length\"]/label/select")
	public WebElement facilityContactResult_length_row;
	
	public void select_From_Show_Rows_In_Search_Study_Site_Maintenance_Delegate_Table(int arg1) throws Throwable {
			Select doctype1 = new Select (facilityContactResult_length_row);
			doctype1.selectByVisibleText(String.valueOf(arg1));
			Thread.sleep(3000);
	}

}
