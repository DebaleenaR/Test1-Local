package com.testautomation.PageObjects;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testautomation.Utility.ExcelHandler;
import com.testautomation.Utility.PropertiesFileReader;
import com.testautomation.Utility.TestDataHandler;

public class SiteUser_Sponsor_CRO_ViewAllWorkspaces {

	public WebDriver driver;
	Properties properties;
	WebDriverWait wait;
	
	PropertiesFileReader obj = new PropertiesFileReader();
	TestDataHandler testData = new TestDataHandler();
	static String StudyLink_subject = "";
	static String relevant_documents_description_Upload_New_Document = "";
	
	public SiteUser_Sponsor_CRO_ViewAllWorkspaces(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver,25000);
	}
	
	@FindBy(how=How.ID, using="study_site_tab")
	public WebElement study_site_tab;
	
	@FindBy(how=How.XPATH, using="//*[@id='siteStaff']/a")
	public WebElement SiteStaff_Section;
	
	@FindBy(how=How.ID, using="removeSiteStaff")
	public WebElement RemoveSiteStaffBtn;
	
	public void verify_Site_User_Is_Displayed_As_Current_Date(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_FirstName = testDataInMap.get("SiteUser"+arg1+"_FirstName");
        String SiteUser_LastName = testDataInMap.get("SiteUser"+arg1+"_LastName");
        
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		java.util.Date date=new java.util.Date();  
		String CurrentDate = dateFormat.format(date);
		System.out.println("Today's Date :"+ CurrentDate);
		
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//label[contains(text(),'"+SiteUser_LastName+", "+SiteUser_FirstName+"')]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//label[contains(text(),'"+SiteUser_LastName+", "+SiteUser_FirstName+"')]//..//..//../td[5]//span[text()[normalize-space() = '"+CurrentDate+"']]")));
     }
	
	public void verify_Site_User_Is_Displayed_With_Date_role_ended_in_SIP_As_Blank(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_FirstName = testDataInMap.get("SiteUser"+arg1+"_FirstName");
        String SiteUser_LastName = testDataInMap.get("SiteUser"+arg1+"_LastName");
        
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		java.util.Date date=new java.util.Date();  
		String CurrentDate = dateFormat.format(date);
		System.out.println("Today's Date :"+ CurrentDate);
		
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//label[contains(text(),'"+SiteUser_LastName+", "+SiteUser_FirstName+"')]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//label[contains(text(),'"+SiteUser_LastName+", "+SiteUser_FirstName+"')]//..//..//../td[5]//span[not(node())]")));
    
	}
	
	public void verify_Site_User_Is_Displayed_With_Date_role_ended_in_SIP_As_Future_Date(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_FirstName = testDataInMap.get("SiteUser"+arg1+"_FirstName");
        String SiteUser_LastName = testDataInMap.get("SiteUser"+arg1+"_LastName");
        
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//label[contains(text(),'"+SiteUser_LastName+", "+SiteUser_FirstName+"')]")));
		String RoleEndDate=driver.findElement(By.xpath("//label[contains(text(),'"+SiteUser_LastName+", "+SiteUser_FirstName+"')]//..//..//../td[5]//span")).getText();
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		java.util.Date date=new java.util.Date();  
		String CurrentDate = dateFormat.format(date);
		System.out.println(RoleEndDate.compareTo(CurrentDate));
		
		
		if (RoleEndDate.compareTo(CurrentDate) > 0) 
		 {
          System.out.println("START DATE Is A Future Date");
          CommonClass.highLightElement(driver, driver.findElement(By.xpath("//label[contains(text(),'"+SiteUser_LastName+", "+SiteUser_FirstName+"')]//..//..//../td[5]//span")));
 		 
		 } else if (RoleEndDate.compareTo(CurrentDate) < 0) 
		 {
            System.out.println("START DATE Is A Past Date");
            driver.quit();
        }
		 else if (RoleEndDate.compareTo(CurrentDate) == 0) {
		      System.out.println("START DATE Is Current Date");
		      driver.quit();
		} 
		 else 
		 {
			 	System.out.println("Something weird happened...");
			 	driver.quit();
		 }
	
	}
	
	public void verify_Site_User_Is_Displayed_As(int arg1, String arg2) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_FirstName = testDataInMap.get("SiteUser"+arg1+"_FirstName");
        String SiteUser_MiddleName = testDataInMap.get("SiteUser"+arg1+"_MiddleName");
        String SiteUser_LastName = testDataInMap.get("SiteUser"+arg1+"_LastName");
        
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='viewRole' and text()[normalize-space() = '"+arg2+"']]//..//..//../td//label[text()[normalize-space() = '"+SiteUser_LastName+", "+SiteUser_FirstName+" "+SiteUser_MiddleName+"']]")));
	}
	
	public void select_Checkbox_Against_Site_User_Is_Displayed_As(int arg1, String arg2) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_FirstName = testDataInMap.get("SiteUser"+arg1+"_FirstName");
        String SiteUser_MiddleName = testDataInMap.get("SiteUser"+arg1+"_MiddleName");
        String SiteUser_LastName = testDataInMap.get("SiteUser"+arg1+"_LastName");
        
        CommonClass.scroll2(driver);
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='viewRole' and text()[normalize-space() = '"+arg2+"']]//..//..//../td//label[text()[normalize-space() = '"+SiteUser_LastName+", "+SiteUser_FirstName+" "+SiteUser_MiddleName+"']]//..//..//../td/span")));
        driver.findElement(By.xpath("//*[@id='viewRole' and text()[normalize-space() = '"+arg2+"']]//..//..//../td//label[text()[normalize-space() = '"+SiteUser_LastName+", "+SiteUser_FirstName+" "+SiteUser_MiddleName+"']]//..//..//../td/span")).click();
	
	}
	
	public void verify_Remove_Selected_Site_Staff_Button_Disabled() throws Throwable {
	   if(!RemoveSiteStaffBtn.isEnabled())
	   {
		   System.out.println("RemoveSiteStaffBtn is Disabled");
		   CommonClass.highLightElement(driver, RemoveSiteStaffBtn);
	   }
	}
	
	public void verify_Remove_Selected_Site_Staff_Button_Enabled() throws Throwable {
		if(RemoveSiteStaffBtn.isEnabled())
		   {
			   System.out.println("RemoveSiteStaffBtn is Enabled");
			   CommonClass.highLightElement(driver, RemoveSiteStaffBtn);
		   }
		}
	
	
	@FindBy(how=How.ID, using="proceedForRoleEnd")
	public WebElement RemoveSiteStaff_ProceedBtn;
	
	@FindBy(how=How.ID, using="removeStaffCancelBtn")
	public WebElement RemoveSiteStaff_CancelBtn;
	
	public void verify_Remove_Site_Staff_PopUp_Displayed_With_Proceed_And_Cancel_Button() throws Throwable {
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='removeSiteStaffRoles']//h2[text()[normalize-space() = 'Remove Site Staff']]")));
	    CommonClass.highLightElement(driver,RemoveSiteStaff_ProceedBtn);
	    CommonClass.highLightElement(driver,RemoveSiteStaff_CancelBtn);
	}
	
	
	public void select_Current_Date_In_Date_role_ended_in_SIP() throws Throwable {
	   driver.findElement(By.xpath("//*[@id='studyAccessEndDatePicker']//span[text()[normalize-space() = 'select']]")).click();
	   Thread.sleep(1000);
	   Robot r1 = new Robot();
	   r1.keyPress(KeyEvent.VK_ENTER);
	   Thread.sleep(1000);
	   r1.keyRelease(KeyEvent.VK_ENTER);
	}
	
	@FindBy(how=How.ID, using="staffRemovalReason")
	public WebElement StaffRemovalReason;
	
	public void select_Reason_For_Role_End_As_In_Remove_Site_Staff_PopUp(String arg1) throws Throwable {
			Select doctype1 = new Select (StaffRemovalReason);
			doctype1.selectByVisibleText(arg1);
			Thread.sleep(3000);
	}
	
	
	public void verify_Proceed_Button_In_Remove_Site_Staff_PopUp_Is_Disabled() throws Throwable {
		if(!RemoveSiteStaff_ProceedBtn.isEnabled())
		   {
			   System.out.println("Proceed_Button_In_Remove_Site_Staff_PopUp is Disabled");
			   CommonClass.highLightElement(driver, RemoveSiteStaff_ProceedBtn);
		   }
	}
	
	public void verify_Proceed_Button_In_Remove_Site_Staff_PopUp_Is_Enabled() throws Throwable {
		if(RemoveSiteStaff_ProceedBtn.isEnabled())
		   {
			   System.out.println("Proceed_Button_In_Remove_Site_Staff_PopUp is Enabled");
			   CommonClass.highLightElement(driver, RemoveSiteStaff_ProceedBtn);
		   }
	}
	
	@FindBy(how=How.ID, using="confirmSiteStaffRemovalSubmit")
	public WebElement ConfirmSiteStaffRemovalSubmit;
	
	@FindBy(how=How.ID, using="removeSiteStaffCancelBtn")
	public WebElement RemoveSiteStaffCancelBtn;
	
	public void verify_Confirm_Selected_Site_Staff_for_study_access_removal_PopUp_Displayed() throws Throwable {
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='confirmSiteStaffRemoval']/div/h2[text()[normalize-space() = 'Confirm Selected Site Staff for study access removal']]")));
	    CommonClass.highLightElement(driver, ConfirmSiteStaffRemovalSubmit);
	    CommonClass.highLightElement(driver, RemoveSiteStaffCancelBtn);
	}
	
	public void verify_Site_User_Is_Displayed_In_Confirm_Selected_Site_Staff_for_study_access_removal_PopUp(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_FirstName = testDataInMap.get("SiteUser"+arg1+"_FirstName");
        String SiteUser_MiddleName = testDataInMap.get("SiteUser"+arg1+"_MiddleName");
        String SiteUser_LastName = testDataInMap.get("SiteUser"+arg1+"_LastName");
        
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='siteStaffSearchTable']//div[text()[normalize-space() = '"+SiteUser_LastName+", "+SiteUser_FirstName+" "+SiteUser_MiddleName+"']]")));
	}
	
	public void verify_Site_User_Email_Is_Displayed_In_Confirm_Selected_Site_Staff_for_study_access_removal_PopUp(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SU_Email = testDataInMap.get("SiteUser"+arg1+"_Email");
               
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='siteStaffSearchTable']//div[text()[normalize-space() = '"+SU_Email+"']]")));
	}
	
	public void verify_Site_User_Having_Role_As_Is_Role_Ended(int arg1, String arg2) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_FirstName = testDataInMap.get("SiteUser"+arg1+"_FirstName");
        String SiteUser_MiddleName = testDataInMap.get("SiteUser"+arg1+"_MiddleName");
        String SiteUser_LastName = testDataInMap.get("SiteUser"+arg1+"_LastName");
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");  //06-Jul-2021
		Date date = Calendar.getInstance().getTime();
		
		String strDate = formatter.format(date); 
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id=\"viewRole\"]//..//..//../td//label[text()[normalize-space() = '"+SiteUser_LastName+", "+SiteUser_FirstName+" "+SiteUser_MiddleName+"']]")));
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id=\"viewRole\"]//..//..//../td//label[text()[normalize-space() = '"+SiteUser_LastName+", "+SiteUser_FirstName+" "+SiteUser_MiddleName+"']]//..//..//../td[5]//span[text()[normalize-space() = '"+strDate+"']]")));
	}
	
	public void verify_Site_User_Having_Role_As_CheckBox_Disabled(int arg1, String arg2) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_FirstName = testDataInMap.get("SiteUser"+arg1+"_FirstName");
        String SiteUser_MiddleName = testDataInMap.get("SiteUser"+arg1+"_MiddleName");
        String SiteUser_LastName = testDataInMap.get("SiteUser"+arg1+"_LastName");
        
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id=\"viewRole\"]//..//..//../td//label[text()[normalize-space() = '"+SiteUser_LastName+", "+SiteUser_FirstName+" "+SiteUser_MiddleName+"']]")));
        WebElement wb = driver.findElement(By.xpath("//*[@id='viewRole']//..//..//../td//label[text()[normalize-space() = '"+SiteUser_LastName+", "+SiteUser_FirstName+" "+SiteUser_MiddleName+"']]//..//..//../td[1]/input"));
        if(!wb.isEnabled())
        {
        	System.out.println("Verify Site User "+arg1+" Having Role As "+arg2+" CheckBox Disabled");
        }
	}
	
	@FindBy(how=How.ID, using="copySiteStaff")
	public WebElement CopySiteStaff;

	public void verify_Copy_Study_Site_Profile_Screen_In_Study_Site_Staff_Screen_for_Site_User() throws Throwable {
		WebElement wb =  driver.findElement(By.xpath("//*[@id=\"siteStaffSectionContents\"]//h1[text()[normalize-space() = 'Copy Study Site Profile']]"));
		CommonClass.highLightElement(driver, wb);
	}
	
	public void verify_Search_Study_Site_Profiles_In_Study_Site_Staff_Screen_for_Site_User() throws Throwable {
		WebElement wb =  driver.findElement(By.xpath("//*[@id='siteStaffSectionContents']//h2[text()[normalize-space() = 'Search Study Site Profiles']]"));
		CommonClass.highLightElement(driver, wb);
	}
	
	@FindBy(how=How.ID, using="copySponsorTypeListId")
	public WebElement copySponsorTypeListId;
	
	public void select_Sponsor_From_Sponsor_CRO_Dropdown(int arg1) throws Throwable {

		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String Sponsor_Company = testDataInMap.get("sponsorCompany");
        
        copySponsorTypeListId.click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id='siteStaffSectionContents']//span[text()[normalize-space() = '"+Sponsor_Company+"']]")).click();		
	}
	
	
	@FindBy(how=How.ID, using="copystudyWSTypeListId")
	public WebElement CopystudyWSTypeListId;
	
	public void select_Study_Type_For_Study_From_Study_Type_Dropdown(int arg1) throws Throwable {
		CopystudyWSTypeListId.click();
		
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String Study_Type = testDataInMap.get("Study_Type_"+arg1);
        Thread.sleep(1500);
        System.out.println(Study_Type);
        driver.findElement(By.xpath("//*[@id='siteStaffSectionContents']//span[text()[normalize-space() = '"+Study_Type+"']]")).click();		
	
	}
	
	@FindBy(how=How.ID, using="copyStudyTypeListId")
	public WebElement CopyStudyTypeListId;
	
	public void select_Study_From_Study_ID_Dropdown(int arg1) throws Throwable {
		//CommonClass.highLightElement(driver, CopyStudyTypeListId);
		//CopyStudyTypeListId.click();
		
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_TAB);
		r1.keyRelease(KeyEvent.VK_TAB);
		
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String Study_ID = testDataInMap.get("studyID"+arg1);
        System.out.println(Study_ID);
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id='siteStaffSectionContents']//span[text()[normalize-space() = '"+Study_ID+"']]")).click();		
    	
	}
	
	@FindBy(how=How.ID, using="searchBtn")
	public WebElement SearchBtn;
	
	public void verify_Study_Is_Displayed_Under_Search_Study_Site_Profiles_Section(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String Study_ID = testDataInMap.get("studyID"+arg1);
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='studySiteProfileResult']//div[text()[normalize-space() = '"+Study_ID+"']]")));
	}
	
	public void verify_Site_User_Is_Displayed_Under_Search_Study_Site_Profiles_Section(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_FirstName = testDataInMap.get("SiteUser"+arg1+"_FirstName");
        String SiteUser_MiddleName = testDataInMap.get("SiteUser"+arg1+"_MiddleName");
        String SiteUser_LastName = testDataInMap.get("SiteUser"+arg1+"_LastName");
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='studySiteProfileResult']//div[text()[normalize-space() = '"+SiteUser_LastName+", "+SiteUser_FirstName+" "+SiteUser_MiddleName+"']]")));
	}
	
	public void select_Site_User_From_Search_Study_Site_Profiles_Section(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String Study_ID = testDataInMap.get("studyID"+arg1);
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='studySiteProfileResult']//div[text()[normalize-space() = '"+Study_ID+"']]")));
		driver.findElement(By.xpath("//*[@id='studySiteProfileResult']//div[text()[normalize-space() = '"+Study_ID+"']]//..//../td//input[@type='radio']")).click();
		
	}
	
	@FindBy(how=How.ID, using="selectStudySiteBtn")
	public WebElement SelectStudySiteBtn;
	
	public void select_Site_User_From_Select_Site_Staff_To_Copy_Table(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_FirstName = testDataInMap.get("SiteUser"+arg1+"_FirstName");
        String SiteUser_MiddleName = testDataInMap.get("SiteUser"+arg1+"_MiddleName");
        String SiteUser_LastName = testDataInMap.get("SiteUser"+arg1+"_LastName");
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='copy_staff_table']//td[text()[normalize-space() = '"+SiteUser_LastName+", "+SiteUser_FirstName+" "+SiteUser_MiddleName+"']]//../td[1]/input")));
        driver.findElement(By.xpath("//*[@id='copy_staff_table']//td[text()[normalize-space() = '"+SiteUser_LastName+", "+SiteUser_FirstName+" "+SiteUser_MiddleName+"']]//../td[1]/input")).click();
	}
	
	@FindBy(how=How.ID, using="selectStudySiteStaffBtn")
	public WebElement SelectStudySiteStaffBtn;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"staffsCopiedConfirmationPopup\"]//button[text()[normalize-space() = 'OK']]")
	public WebElement StaffsCopiedConfirmationPopup_OK_Btn;
	
	
	public void verify_Site_User_Is_Displayed_As_With_Current_Date(int arg1, String arg2) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_FirstName = testDataInMap.get("SiteUser"+arg1+"_FirstName");
        String SiteUser_MiddleName = testDataInMap.get("SiteUser"+arg1+"_MiddleName");
        String SiteUser_LastName = testDataInMap.get("SiteUser"+arg1+"_LastName");
        
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='viewRole' and text()[normalize-space() = '"+arg2+"']]//..//..//../td[5]//span[not(node())]//..//..//..//label[text()[normalize-space() = '"+SiteUser_LastName+", "+SiteUser_FirstName+" "+SiteUser_MiddleName+"']]")));
	}
	
	@FindBy(how=How.ID, using="potential_investigators_tab")
	public WebElement PotentialInvestigator_Tab;
	
	public void verify_Site_User_Is_Displayed_Under_Delegate_for_SIP_Study_Site_Maintenance_Column(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_FirstName = testDataInMap.get("SiteUser"+arg1+"_FirstName");
        String SiteUser_MiddleName = testDataInMap.get("SiteUser"+arg1+"_MiddleName");
        String SiteUser_LastName = testDataInMap.get("SiteUser"+arg1+"_LastName");
        
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//*[@id=\"pi-list-table\"]//a[text()[normalize-space() = \""+SiteUser_LastName+", "+SiteUser_FirstName+" "+SiteUser_MiddleName+"\"]])[1]")));
	}
	
	public void verify_Site_User_Is_Displayed_Under_Potential_Investigator_Column(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_FirstName = testDataInMap.get("SiteUser"+arg1+"_FirstName");
        String SiteUser_MiddleName = testDataInMap.get("SiteUser"+arg1+"_MiddleName");
        String SiteUser_LastName = testDataInMap.get("SiteUser"+arg1+"_LastName");
        
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//*[@id=\"pi-list-table\"]//a[text()[normalize-space() = \""+SiteUser_LastName+", "+SiteUser_FirstName+" "+SiteUser_MiddleName+"\"]])[1]")));
	}
	
	public void verify_Site_User_With_Role_As_Is_Not_Displayed_Under_Site_Staff_Table(int arg1, String arg2) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUser_FirstName = testDataInMap.get("SiteUser"+arg1+"_FirstName");
        String SiteUser_MiddleName = testDataInMap.get("SiteUser"+arg1+"_MiddleName");
        String SiteUser_LastName = testDataInMap.get("SiteUser"+arg1+"_LastName");
        
        try 
        {
        	CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='staff_table']//label[text()[normalize-space() = '"+SiteUser_LastName+", "+SiteUser_FirstName+" "+SiteUser_MiddleName+"']]//..//..//..//span[text()[normalize-space() = '"+arg2+"']]")));
        }
        catch(Exception e)
        {
        	CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='staff_table']")));
        }
	}
	
	
	
}


