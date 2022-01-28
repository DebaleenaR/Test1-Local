package com.testautomation.PageObjects;

import java.io.BufferedInputStream;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Properties;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.util.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class SiteUser_UserProfile {

	public WebDriver driver;
	Properties properties;
	WebDriverWait wait;
	static String CVfileName="";
	
	PropertiesFileReader obj = new PropertiesFileReader();
	TestDataHandler testData = new TestDataHandler();
	
	public SiteUser_UserProfile(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver,25000);
	}
	
	
	public void click_On_SIP_User_ID_Of_Site_User_In_Delegated_Profiles_Screen(int arg1) throws Throwable {
		 properties= obj.getProperty();
		   
         Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
         testData.setTestDatainMap(TestDataInMap);
                
         Map<String,String> testDataInMap = testData.getTestDatainMap();
         String Userid = testDataInMap.get("BypassUserid"+arg1);
         String[] myArr = Userid.split("@");
         
         CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='search-table']//a[text()[normalize-space() = '"+myArr[0]+"']]")));
         driver.findElement(By.xpath("//*[@id='search-table']//a[text()[normalize-space() = '"+myArr[0]+"']]")).click();
    }
	
	@FindBy(how=How.ID, using="facilityDetails")
	public WebElement facilityDetails;
	
	public void click_On_Facilities_Section_In_My_Profile_Screen() throws Throwable {
	    CommonClass.highLightElement(driver, facilityDetails);
	    Thread.sleep(1500);
	    facilityDetails.click();
	}
	
	public void verify_Facilities_Screen_Displayed() throws Throwable {
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("//h2[text()[normalize-space() = 'Facilities']]")));
	}

	public void verify_On_Screen_Text_In_Facilities_Screen() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='facilityDiv']//li[text()[normalize-space() = 'Add Facilities and affiliated Departments where you conduct Clinical Research.']]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='facilityDiv']//li[text()[normalize-space() = \"Check the ‘Display on CV?’ box to select the records you wish to display on your Abbreviated CV. The CV is limited to 10 combined Facilities/Departments irrespective of how many you select, to limit the abbreviated CV to 2 pages.\"]]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='facilityDiv']//li[text()[normalize-space() = \"The Facility will be always displayed on the CV combined with selected Departments. No separate record for that Facility alone will be displayed if available Departments have been selected to be included in the CV.\"]]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='facilityDiv']//li[text()[normalize-space() = \"Click on the star to choose one Facility as primary. Department cannot be marked as Primary. If the sponsors are not sure which Facility to use for a survey or study, they will use the one marked primary.\"]]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='facilityDiv']//li[text()[normalize-space() = \"Use the ‘Actions’ to Add a Department, Export a Profile or Remove a Facility/Department.\"]]")));
	}
	
	public void click_On_Facility_And_Department(int arg1, int arg2) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String Facility = testDataInMap.get("Facility_"+arg1);
        String Department = testDataInMap.get("Department_"+arg2);
		
        try {
        	  CommonClass.highLightElement(driver, driver.findElement(By.xpath("//a[text()[normalize-space() = '"+Facility+"']]//..//..//..//a[text()[normalize-space() = '"+Department+"']]//..//..//../td[1]//span[contains(@class,'checked')]")));
        }
        catch(Exception e)
        {
        
        	driver.findElement(By.xpath("//a[text()[normalize-space() = '"+Facility+"']]//..//..//..//a[text()[normalize-space() = '"+Department+"']]//..//..//../td[1]//span")).click();
        	Thread.sleep(10000);
        }
	}
	
	@FindBy(how=How.ID, using="recordLimit")
	public WebElement recordLimit;
	
	public void select_From_Show_Rows_Dropdown_In_Facilities_Screen(String arg1) throws Throwable {
		CommonClass.scroll(driver);
		Thread.sleep(1500);
		Select doctype1 = new Select (recordLimit);
		doctype1.selectByVisibleText(arg1);
		Thread.sleep(3000);
	}
	
	public void click_On_The_Facility(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String Facility = testDataInMap.get("Facility_"+arg1);
        
		
        try {
        	  CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//a[text()[normalize-space() = '"+Facility+"']])[1]//..//..//../td[1]//span[contains(@class,'checked')]")));
        	  Thread.sleep(1000);
        }
        catch(Exception e) {
        	driver.findElement(By.xpath("(//a[text()[normalize-space() = '"+Facility+"']])[1]//..//..//../td[1]//span")).click();
        	Thread.sleep(10000);
        }
	}
	
	public void click_On_The_Facility_And_Department_In_Facilities_Screen(int arg1, int arg2) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String Facility = testDataInMap.get("Facility_"+arg1);
        String Department = testDataInMap.get("F"+arg1+"_Department_"+arg2);
		
        try {
        	  CommonClass.highLightElement(driver, driver.findElement(By.xpath("//a[text()[normalize-space() = '"+Facility+"']]//..//..//..//a[text()[normalize-space() = '"+Department+"']]//..//..//../td[1]//span[contains(@class,'checked')]")));
        }
        catch(Exception e)
        {
        
        	driver.findElement(By.xpath("//a[text()[normalize-space() = '"+Facility+"']]//..//..//..//a[text()[normalize-space() = '"+Department+"']]//..//..//../td[1]//span")).click();
        	Thread.sleep(10000);
        }
	}
	
	public void verify_Primary_Facility_Mark_Is_Disabled_For_Facility_And_Department_In_Facilities_Screen(int arg1, int arg2) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String Facility = testDataInMap.get("Facility_"+arg1);
        String Department = testDataInMap.get("Department_"+arg2);
		
        try {
        	  CommonClass.highLightElement(driver, driver.findElement(By.xpath("//a[text()[normalize-space() = '"+Facility+"']]//..//..//..//a[text()[normalize-space() = '"+Department+"']]//..//..//../td[2]//input[@disabled]")));
        }
        catch(Exception e)
        {
        		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//a[text()[normalize-space() = '"+Facility+"']]//..//..//..//a[text()[normalize-space() = '"+Department+"']]//..//..//../td[2]//input")));
        }
	}
	
	public void click_On_Primary_Facility_Mark_For_Facility(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String Facility = testDataInMap.get("Facility_"+arg1);
        
        try
        {
        	CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//a[text()[normalize-space() = '"+Facility+"']])[1]//..//..//../td[2]//input[@checked]")));
        }
        catch(Exception e)
        {
        	CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//a[text()[normalize-space() = '"+Facility+"']])[1]//..//..//../td[2]//input//../span[1]")));
        	Thread.sleep(1500);
        	driver.findElement(By.xpath("(//a[text()[normalize-space() = '"+Facility+"']])[1]//..//..//../td[2]//input//../span[1]")).click();
        }
        
       
	}
	
	 public void verify_Primary_Facility_Mark_Is_Checked_For_Facility(int arg1) throws Throwable {
		 properties= obj.getProperty();
		   
	        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
	        testData.setTestDatainMap(TestDataInMap);
	               
	        Map<String,String> testDataInMap = testData.getTestDatainMap();
	        String Facility = testDataInMap.get("Facility_"+arg1);
	        
	        try
	        {
	        	CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//a[text()[normalize-space() = '"+Facility+"']])[1]//..//..//../td[2]//input[@checked]")));
	        }
	        catch(Exception e)
	        {
	        	System.out.println("Not Selected");
	        }
     }
	
	 
	 @FindBy(how=How.ID, using="profile-save-button")
	 public WebElement profile_save_button;
	 
	 public void click_On_SAVE_Button_In_Facilities_Screen() throws Throwable {
	     CommonClass.scroll(driver);
	     Thread.sleep(1500);
		 CommonClass.highLightElement(driver, profile_save_button);
		 profile_save_button.click();
	}
	 
	 @FindBy(how=How.ID, using="okbutton")
	 public WebElement Delegators_User_Profile_PopUp_okbutton;
	 
	 public void click_On_SAVE_Button_In_Delegators_User_Profile_PopUp() throws Throwable {
		 CommonClass.highLightElement(driver, Delegators_User_Profile_PopUp_okbutton);
		 Delegators_User_Profile_PopUp_okbutton.click();
	 }
	 
	 @FindBy(how=How.ID, using="allChangesForApprovalBtnId")
	 public WebElement SendAllChangesForApprovalButton;
	 
	 public void ClickOnSendAllChangesForApprovalButton() throws Throwable {
		 CommonClass.highLightElement(driver, SendAllChangesForApprovalButton);
		 SendAllChangesForApprovalButton.click();
	 }
	 
	 @FindBy(how=How.XPATH, using="//*[contains(text(),'have been sent for Approval')]//..//*[@id='actionOk']")
	 public WebElement Your_Changes_have_been_sent_for_Approval_PopUp_actionOk;
	 
	 public void click_On_OK_button_In_Your_Changes_have_been_sent_for_Approval_PopUp() throws Throwable {
		 CommonClass.highLightElement(driver, Your_Changes_have_been_sent_for_Approval_PopUp_actionOk);
		 Your_Changes_have_been_sent_for_Approval_PopUp_actionOk.click();
	 }
	 
	 @FindBy(how=How.XPATH, using="//input[@Value='Approve This Change']")
	 public WebElement ApproveThisChange_Button;
	 
	 public void click_On_Approve_This_Change_Button_In_Facilities_Screen() throws Throwable {
		 CommonClass.scroll(driver);
	     Thread.sleep(1500);
	     CommonClass.highLightElement(driver, ApproveThisChange_Button);
	     ApproveThisChange_Button.click();
	}
	 
	 @FindBy(how=How.XPATH, using="//*[contains(text(),'Your changes have been saved')]//..//*[@id='approveAllOk']")
	 public WebElement approveAllOk;
	 
	 public void click_On_OK_Button_In_Your_changes_have_been_saved_PopUp() throws Throwable {
		 CommonClass.highLightElement(driver, approveAllOk);
		 approveAllOk.click();
	}
	 
	 @FindBy(how=How.XPATH, using="//*[@id='generateSip-CV-delegate']")
	 public WebElement Generate_SIP_Abbreviated_CV_Button;

	 public void click_On_Generate_SIP_Abbreviated_CV_Button_In_Facilities_Screen() throws Throwable {
		 CommonClass.highLightElement(driver, Generate_SIP_Abbreviated_CV_Button);
		 Generate_SIP_Abbreviated_CV_Button.click();
		}
	 
	 @FindBy(how=How.XPATH, using="//*[@id='proceedCVgenerate']")
	 public WebElement proceedCVgenerate_btn;
	 
	 public void click_On_PROCEED_Button_In_Generate_CV_for_Profile_Owner_PopUp() throws Throwable {
		    CommonClass.highLightElement(driver, proceedCVgenerate_btn);
		    proceedCVgenerate_btn.click();
		}
	 
	 @FindBy(how=How.XPATH, using="//p[contains(text(),'CV has been generated successfully.')]//..//*[@id='btn_ok']")
	 public WebElement CVgenerate_btn_ok;
	  
	 
	 public void click_On_OK_Button_In_Success_PopUp_For_Generating_CV() throws Throwable {
		   CommonClass.highLightElement(driver, CVgenerate_btn_ok);
		   CVgenerate_btn_ok.click();
		}
	 
	 
	 
	 public void click_On_PDF_Option_For_ABBREVIATED_CV_VERSION_HISTORY_Option() throws Throwable {
		 String filepath  = System.getProperty("user.dir")+"\\Reports\\Download";
		 System.out.println(filepath);
		 
		 File folder = new File(filepath);
		  for (File file : folder.listFiles()) {
		   if (file.getName().endsWith(".pdf")) {
		    file.delete();
		   }
		  }
		
		 WebElement wb= driver.findElement(By.xpath("//*[@id='userGenCvsRecordTr']//i[@title='PDF']"));
		 WebElement wb_FileName= driver.findElement(By.xpath("//*[@id='userGenCvsRecordTr']/td[1]"));
		 CommonClass.highLightElement(driver,wb );
		 wb.click();
		 CVfileName=wb_FileName.getText();
		 System.out.println(CVfileName);
	}
	 
	 public void verify_Facility_Department_Present_In_ABBREVIATED_CV(int arg1, int arg2) throws Throwable {
		 properties = obj.getProperty();

			Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),
					properties.getProperty("sheetName"), properties.getProperty("TestCaseId"));

			testData.setTestDatainMap(TestDataInMap);

			Map<String, String> testDataInMap = testData.getTestDatainMap();

			String FacilityName = testDataInMap.get("Facility_"+arg1);
			String DepartmentName = testDataInMap.get("Department_"+arg2);
			
			String filepath  = System.getProperty("user.dir")+"\\Reports\\Download\\"+CVfileName+".pdf";
			System.out.println(filepath);
			
			try {
			URL testurl = new URL(filepath);
			BufferedInputStream testfile = new BufferedInputStream(testurl.openStream());
			PDFParser testpdf = new PDFParser(testfile);
			testpdf.parse();
			
			String testtext = new PDFTextStripper().getText(testpdf.getPDDocument());
			System.out.println("text in the pdf file:" + testtext);
			
		if(arg1==1)
		{
			if (testtext.contains(FacilityName)) {

				System.out.println("FacilityName Matched");

			} else {

				System.out.println("FacilityName not matched");

			}
			if (testtext.contains(DepartmentName)) {

				System.out.println("DepartmentName matched");
			} else {
				System.out.println("DepartmentName Not matched");
			}
			
		}
		if(arg1>=2)
		{
				if (testtext.contains(FacilityName)) {

					System.out.println("FacilityName Matched");

				} else {

					System.out.println("FacilityName not matched");

				}
				DepartmentName = "F"+arg1+"_Department_"+arg2;
				if (testtext.contains(DepartmentName)) {

					System.out.println("FacilityName Matched");

				} else {

					System.out.println("FacilityName not matched");

				}
		}		
			
			}
			catch (MalformedURLException e) {
				System.out.println("Legal protocol could be found in a specification string or the string could not be parsed");
				//driver.quit();
			} 
			catch (Exception e) {
				driver.quit();
			}
		}
	 
	 public void verify_Facility_Present_In_ABBREVIATED_CV(int arg1) throws Throwable {
		 properties = obj.getProperty();

			Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),
					properties.getProperty("sheetName"), properties.getProperty("TestCaseId"));

			testData.setTestDatainMap(TestDataInMap);

			Map<String, String> testDataInMap = testData.getTestDatainMap();

			String FacilityName = testDataInMap.get("Facility_"+arg1);
			String filepath  = System.getProperty("user.dir")+"\\Reports\\Download\\"+CVfileName+".pdf";
			System.out.println(filepath);
			try
			{
			URL testurl = new URL(filepath);
			BufferedInputStream testfile = new BufferedInputStream(testurl.openStream());
			PDFParser testpdf = new PDFParser(testfile);
			testpdf.parse();
			
			String testtext = new PDFTextStripper().getText(testpdf.getPDDocument());
			System.out.println("text in the pdf file:" + testtext);
				if (testtext.contains(FacilityName))
				{
					System.out.println("FacilityName Matched");
				}
				else
				{
					System.out.println("FacilityName not matched");
				}
			
			}
			catch (MalformedURLException e)
			{
				System.out.println("Legal protocol could be found in a specification string or the string could not be parsed");
				//driver.quit();
			} 
			catch (Exception e)
			{
				driver.quit();
			}
		}
	 
	 public void verify_Facility_Is_Not_Present_In_ABBREVIATED_CV(int arg1) throws Throwable {
		 properties = obj.getProperty();

			Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),
					properties.getProperty("sheetName"), properties.getProperty("TestCaseId"));

			testData.setTestDatainMap(TestDataInMap);

			Map<String, String> testDataInMap = testData.getTestDatainMap();

			String FacilityName = testDataInMap.get("Facility_"+arg1);
			String filepath  = System.getProperty("user.dir")+"\\Reports\\Download\\"+CVfileName+".pdf";
			System.out.println(filepath);
			try
			{
			URL testurl = new URL(filepath);
			BufferedInputStream testfile = new BufferedInputStream(testurl.openStream());
			PDFParser testpdf = new PDFParser(testfile);
			testpdf.parse();
			
			String testtext = new PDFTextStripper().getText(testpdf.getPDDocument());
			System.out.println("text in the pdf file:" + testtext);
				if (testtext.contains(FacilityName))
				{
					System.out.println("FacilityName Matched");
					driver.quit();
				}
				else
				{
					System.out.println("FacilityName not matched");
					
				}
			
			}
			catch (MalformedURLException e)
			{
				System.out.println("Legal protocol could be found in a specification string or the string could not be parsed");
				//driver.quit();
			} 
			catch (Exception e)
			{
				driver.quit();
			}
		}
}
