package com.testautomation.PageObjects;


import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
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

public class SipSponsorLandingPage {
	
	public WebDriver driver;
	Properties properties;
	WebDriverWait wait;
	PropertiesFileReader obj = new PropertiesFileReader();
	TestDataHandler testData = new TestDataHandler();
	
	public void highLightElement(WebElement string) throws InterruptedException{
		   JavascriptExecutor js = (JavascriptExecutor)driver;   
		   js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');", string);   
		   Thread.sleep(3000);
		   TakesScreenshot webdriver = null;
		   TakesScreenshot scrShot =((TakesScreenshot)webdriver);
	}
	
	public SipSponsorLandingPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver,25000);
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"FacilityId\"]/span[1]")
	public WebElement facilityMenu;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"SearchFacilityId\"]")
	public WebElement searchfacilityLink;
	
	
	@FindBy(how=How.ID, using="WorkspaceId")
	public WebElement wrokspaceMenu;
	
	@FindBy(how=How.ID, using="CreateStudyWorkspace(s)Id")
	public WebElement createStudyWrokspacelink;
	
	@FindBy(how=How.ID, using="ViewAllWorkspacesId")
	public WebElement viewAllWrokspacelink;
	
	@FindBy(how=How.XPATH, using="//*[@id='ViewAllExternalWorkspacesId']")
	public WebElement viewAllExternalWrokspacelink;
	
	@FindBy(how=How.XPATH, using="//a[@id='UserProfileId']")
	public WebElement userProfileMenu;
	
	@FindBy(how=How.XPATH, using="//a[@id='MyProfileId']")
	public WebElement myprofileLink;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"SafetyId\"]/span[1]")
	public WebElement SafetyMenu;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"MySafetyNotificationsId\"]")
	public WebElement MySafetyNotification;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"DistributeUploadSafetyNotificationsId\"]")
	public WebElement DistributeUploadSafetyNotifications;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"UploadSafetyNotificationsId\"]")
	public WebElement UploadSafetyNotifications;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"BulkUploadSafetyNotificationsId\"]")
	public WebElement BulkUploadSafetyNotifications;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"Set-UpSafetyDistributionRulesId\"]")
	public WebElement SetUpSafetyDistributionRules;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"DistributionviaAlternativeMeansId\"]")
	public WebElement DistributionviaAlternativeMeans;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"SetUpTaskNotificationTemplatesId\"]")
	public WebElement SetUpTaskNotificationTemplates;
	
	@FindBy(how=How.XPATH, using="//a[@id='ReportsId']")
	public WebElement reports;
	
	@FindBy(how=How.XPATH, using="//a[@id='GeneralReportsId']")
	public WebElement generalreport;
	
	@FindBy(how=How.XPATH, using="//select[@id='jspDropDownValue']")
	public WebElement reportselctdropdown;
	
	
	
	public void navigatetoFacilitySearch() throws Exception 
	{
		Actions actions = new Actions(driver);
     
		 actions.moveToElement(facilityMenu).build().perform();
    	 Thread.sleep(5000);
    	 searchfacilityLink.click();
	}
	
	
	public void navigatetocreateStudyWorkspace() throws Exception 
	{   
		System.out.println(driver);
		
		Actions actions = new Actions(driver);
     
		 actions.moveToElement(wrokspaceMenu).build().perform();
    	 Thread.sleep(5000);
    	 createStudyWrokspacelink.click();
	}
	
	public void clickOnfavouriteStudy() throws Exception 
	{
		properties= obj.getProperty();
		
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);
				
		Map<String,String> testDataInMap = testData.getTestDatainMap();
		String studyID = testDataInMap.get("studyID");
		//String studyID = properties.getProperty("study.id");
		//System.out.println(studyID);
		Thread.sleep(5000);
		WebElement favStudyWrokspacelink=driver.findElement(By.xpath("//*[@id='tabs-1']//a[contains(text(),'"+studyID+"')]"));
		favStudyWrokspacelink.click();
		
		
	 }
	
	public void navigatetoviewAllWorkspace() throws Exception 
	{   
		System.out.println(driver);
		Thread.sleep(5000);
		
		Actions actions = new Actions(driver);
        actions.moveToElement(wrokspaceMenu).build().perform();
    	 Thread.sleep(2000);
    	 viewAllWrokspacelink.click();
	}
	
	
	public void navigatetoviewAllExternalWorkspace() throws Exception 
	{   
		System.out.println(driver);
		
		Actions actions = new Actions(driver);
     
		 actions.moveToElement(wrokspaceMenu).build().perform();
    	 Thread.sleep(5000);
    	 viewAllExternalWrokspacelink.click();
	}
	
	
	public void navigatetoMyProfile() throws Exception 
	{   
		System.out.println(driver);
		
		Actions actions = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(userProfileMenu));
		 actions.moveToElement(userProfileMenu).build().perform();
    	 Thread.sleep(3000);
    	 myprofileLink.click();
    	 Thread.sleep(15000);
	}
	
	
	
	
	public void navigatetoMySafetyNotification() throws Exception 
	{   
			
		Actions actions = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(SafetyMenu));
		 actions.moveToElement(SafetyMenu).build().perform();
    	 Thread.sleep(3000);
    	 MySafetyNotification.click();
    	 Thread.sleep(15000);
	}
	
	
	
	public void navigatetoDistributeUploadSafetyNotifications() throws Exception 
	{   
			
		Actions actions = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(SafetyMenu));
		 actions.moveToElement(SafetyMenu).build().perform();
    	 Thread.sleep(3000);
    	 DistributeUploadSafetyNotifications.click();
    	 Thread.sleep(15000);
	}
	
	
	
	public void navigatetoUploadSafetyNotifications() throws Exception 
	{   
			
		Actions actions = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(SafetyMenu));
		 actions.moveToElement(SafetyMenu).build().perform();
    	 Thread.sleep(3000);
    	 UploadSafetyNotifications.click();
    	 Thread.sleep(15000);
	}
	
	
	public void navigatetoBulkUploadSafetyNotifications() throws Exception 
	{   
			
		Actions actions = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(SafetyMenu));
		 actions.moveToElement(SafetyMenu).build().perform();
    	 Thread.sleep(3000);
    	 BulkUploadSafetyNotifications.click();
    	 Thread.sleep(15000);
	}
	
	
	
	public void navigatetoSetUpSafetyDistributionRules() throws Exception 
	{   
			
		Actions actions = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(SafetyMenu));
		 actions.moveToElement(SafetyMenu).build().perform();
    	 Thread.sleep(3000);
    	 SetUpSafetyDistributionRules.click();
    	 Thread.sleep(15000);
	}
	
	
	
	public void navigatetoSetUpTaskNotificationTemplates() throws Exception 
	{   
			
		Actions actions = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(SafetyMenu));
		 actions.moveToElement(SafetyMenu).build().perform();
    	 Thread.sleep(3000);
    	 SetUpTaskNotificationTemplates.click();
    	 Thread.sleep(15000);
	}
	
	
	
	public void navigatetoDistributionviaAlternativeMeans() throws Exception 
	{   
			
		Actions actions = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(SafetyMenu));
		 actions.moveToElement(SafetyMenu).build().perform();
    	 Thread.sleep(3000);
    	 DistributionviaAlternativeMeans.click();
    	 Thread.sleep(15000);
	}
	
	@FindBy(how=How.ID, using="site-login-btn")
	public WebElement SiteUserlogin_btn;
	
	@FindBy(how=How.XPATH, using="//input[@id='mat-input-0']")
	public WebElement EmailTextBox;
	
	@FindBy(how=How.XPATH, using="//button[@type='submit']")
	public WebElement Sumbit_Button;
	
	@FindBy(how=How.XPATH, using="//input[@id='mat-input-1']")
	public WebElement passwordTextBox;
	
	@FindBy(how=How.XPATH, using="//span[contains(text(),'NEXT')]")
	public WebElement nextButton;
	
	//@FindBy(how=How.XPATH, using="(//span[contains(text(),'Answer security questions')]//.//preceding-sibling::span)[1]")
	//public WebElement radioSecurityQuestion;
	@FindBy(how=How.XPATH, using="//span[contains(text(),'Answer security questions')]//.//preceding-sibling::span")
	public WebElement radioSecurityQuestion;

	
	@FindBy(how=How.XPATH, using="//input[@id='mat-input-2']")
	public WebElement ans1TextBox;
	
	@FindBy(how=How.XPATH, using="//input[@id='mat-input-3']")
	public WebElement ans2TextBox;
	
	
	public void Enter_Application_With_Proper_Login_Siteuser(int arg1) throws Exception 
	{ 
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String SiteUserEmail = testDataInMap.get("SiteUser"+arg1+"_Email");
        String Password = testDataInMap.get("Password_"+arg1);
        String Question1 = testDataInMap.get("Question1_SiteUser_"+arg1);
        String Question2 = testDataInMap.get("Question2_SiteUser_"+arg1);
		
        SiteUserlogin_btn.click();
        
        Thread.sleep(5000);
        
        EmailTextBox.sendKeys(SiteUserEmail);
        Thread.sleep(1000);
        Sumbit_Button.click();
        
        
        Thread.sleep(5000);
        
        passwordTextBox.sendKeys(Password);
        
        Thread.sleep(1000);
        
        nextButton.click();
        Thread.sleep(5000);
        
        radioSecurityQuestion.click();
        Thread.sleep(1000);
        nextButton.click();
        Thread.sleep(5000);
        
        ans1TextBox.sendKeys(Question1);
        Thread.sleep(500);
        ans2TextBox.sendKeys(Question2);
        Thread.sleep(500);
        nextButton.click();
        Thread.sleep(3000);
	}
	
	@FindBy(how=How.ID, using="sponsor-login-btn")
	public WebElement sponsorLoginButton;

	@FindBy(how=How.ID, using="Select_Member_Company")
	public WebElement companyDropdown;

	@FindBy(how=How.XPATH, using="//button[contains(@class,'btn dropdown-toggle')]")
	public WebElement companylist;

	@FindBy(how=How.XPATH, using="//a[@class='sip-btn sponsor-company-login-btn']")
	public WebElement loginButton;

	@FindBy(how=How.XPATH, using= "/html/body/form/center/table/tbody/tr/td/table/tbody/tr[3]/td[3]/input[1]")
	public WebElement siteMinderUsernameText;

	@FindBy(how=How.XPATH, using= "//input[@type='password']")
	public WebElement siteMinderPassword;

	@FindBy(how=How.XPATH, using="/html/body/form/center/table/tbody/tr/td/table/tbody/tr[7]/td/input[6]")
	public WebElement loginButtonSiteminder;

	 
	public void Enter_to_the_application_with_newbypass_with_Id_and_pass_and_Company(int User) throws Exception{

	sponsorLoginButton.click();
	Thread.sleep(3000);
	companylist.click();
	Thread.sleep(3000);
	Select companydropdown = new Select (companyDropdown);
	companydropdown.selectByVisibleText("Site User");
	Thread.sleep(3000);
	loginButton.click();
	Thread.sleep(5000);
	
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    String SiteUser = testDataInMap.get("BypassUserid"+User);
    
	siteMinderUsernameText.sendKeys(SiteUser);
	Thread.sleep(1500);
	siteMinderPassword.sendKeys("password");

	Thread.sleep(2000);
	loginButtonSiteminder.click();
	Thread.sleep(5000);

	}
	
	public void Enter_to_the_application_Sponsor_bypass(int User) throws Exception{
		String Sponsor ="";
		properties= obj.getProperty();
		   
	    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
	    testData.setTestDatainMap(TestDataInMap);
	           
	    Map<String,String> testDataInMap = testData.getTestDatainMap();
	    String SponsorUser = testDataInMap.get("usernameProperlogin"+User);
	    if(User==1)
	    {
	    	Sponsor = testDataInMap.get("sponsorCompany");
	    }
	    else
	    {
	    	Sponsor = testDataInMap.get("sponsorCompany"+User);
	    }
		sponsorLoginButton.click();
		Thread.sleep(3000);
		companylist.click();
		Thread.sleep(3000);
		Select companydropdown = new Select (companyDropdown);
		companydropdown.selectByVisibleText(Sponsor);
		Thread.sleep(3000);
		loginButton.click();
		Thread.sleep(5000);
		
		String[] arrOfStr = SponsorUser.split("@", 2);
	    
		siteMinderUsernameText.sendKeys(arrOfStr[0]);
		Thread.sleep(1500);
		siteMinderPassword.sendKeys("SIPonmymind@7890");

		Thread.sleep(2000);
		loginButtonSiteminder.click();
		Thread.sleep(5000);

		}
	
	public void ClickOkOnUrgentTasksActionRequiredPopUp() throws Exception 
	{
		try {
		highLightElement(driver.findElement(By.xpath("//*[@id='urgentSafetyNotificationPop']//h3[text()[normalize-space() = 'Urgent Tasks - Action Required!']]")));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@title='OK']")).click();
		Thread.sleep(3000);
		highLightElement(driver.findElement(By.xpath("(//img[@alt='logo'])[1]")));
		}
		catch(Exception e)
		{
			highLightElement(driver.findElement(By.xpath("(//img[@alt='logo'])[1]")));
			Thread.sleep(1000);
		}
	}
	
	
	public void verify_Sponsor_Logo_Is_Displayed() throws Throwable {
		
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String sponsorCompany = testDataInMap.get("sponsorCompany");
        
		 CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//img[@alt='logo' and contains(@src,'"+(sponsorCompany.toLowerCase()).trim()+"')])[1]")));
	}
	
	
	@FindBy(how=How.XPATH, using="//span[@title='Search By']")
	public WebElement Search_By_Dropdown;
	
	@FindBy(how=How.XPATH, using="//*[@role='listbox']/li[text()[normalize-space() = 'Facility/Department']]")
	public WebElement Facility_Department_Option;
	
	@FindBy(how=How.XPATH, using="//*[@role='listbox']/li[text()[normalize-space() = 'Principal Investigator']]")
	public WebElement Principal_Investigator_Option;
	
	@FindBy(how=How.XPATH, using="//*[@role='listbox']/li[text()[normalize-space() = 'User/Facility']]")
	public WebElement User_Facility_Option;
	
	
	public void verify_SEARCH_BY_Dropdown_Is_Displayed_With_Option() throws Throwable {
	    CommonClass.highLightElement(driver, Search_By_Dropdown);
	    Thread.sleep(1000);
	    Search_By_Dropdown.click();
	    Thread.sleep(1000);
	    CommonClass.highLightElement(driver, Facility_Department_Option);

	    CommonClass.highLightElement(driver, Principal_Investigator_Option);

	    CommonClass.highLightElement(driver, User_Facility_Option);
	
	}
	
	public void click_On_Facility_Department_Option_From_SEARCH_BY_Dropdown() throws Throwable {
		Facility_Department_Option.click();
	}
	
	public void verify_Facility_Department_Search_Screen_Is_Displayed() throws Throwable {
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("//h2[text()[normalize-space() = 'Facility/Department Search']]")));
	}
	
	public void click_On_SEARCH_BY_Dropdown() throws Throwable {
		CommonClass.highLightElement(driver, Search_By_Dropdown);
	    Thread.sleep(1000);
	    Search_By_Dropdown.click();
	}
	
	public void click_On_PRINCIPAL_INVESTIGATOR_Option_From_SEARCH_BY_Dropdown() throws Throwable {
		Principal_Investigator_Option.click();
	}

	public void verify_PRINCIPAL_INVESTIGATOR_Screen_Is_Displayed() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//h2[text()[normalize-space() = 'Search Principal Investigator']]")));
	}
	
	public void click_On_User_Facility_Option_From_SEARCH_BY_Dropdown() throws Throwable {
		User_Facility_Option.click();
	}
	
	public void verify_User_Facility_Search_Screen_Is_Displayed() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//h2[text()[normalize-space() = 'User/Facility Search']]")));
	}
	
	@FindBy(how=How.XPATH, using="(//img[@alt='logo'])[1]")
	public WebElement SIP_LOGO;
	
	public void click_On_SIP_Logo() throws Throwable {
		CommonClass.scroll1(driver);
	    CommonClass.highLightElement(driver, SIP_LOGO);
	    SIP_LOGO.click();
	}
	
	public void verify_VIEW_ALL_Options_Under_RECENT_STUDIES_Section() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//h4[text()[normalize-space() = 'Recent Studies']]")));
		Thread.sleep(1500);
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//h4[text()[normalize-space() = 'Recent Studies']]//..//u[text()[normalize-space() = 'View All>>']]")));
	}
	
	public void verify_SET_FAVOURITES_Options_Under_FAVORITES_Section() throws Throwable {
		CommonClass.scroll3(driver);
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//h4[text()[normalize-space() = 'Favorites']]")));
		Thread.sleep(1500);
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//h4[text()[normalize-space() = 'Favorites']]//..//u[text()[normalize-space() = 'Set Favorites >>']]")));
	}
	
	public void verify_Favourite_Studies_Under_FAVORITES_Section() throws Throwable {
		for(int i=1;i<=5;i++)
		{
			CommonClass.highLightElement(driver, driver.findElement(By.xpath("//h4[text()[normalize-space() = 'Favorites']]//..//ul/li["+i+"]/a")));
		}
	}
	
	public void click_On_SET_FAVOURITES_Options_Under_FAVORITES_Section() throws Throwable {
		driver.findElement(By.xpath("//h4[text()[normalize-space() = 'Favorites']]//..//u[text()[normalize-space() = 'Set Favorites >>']]")).click();
	}
	
	public void verify_View_All_Workspaces_Screen_Is_Displayed() throws Throwable {
		try
		{
			CommonClass.highLightElement(driver, driver.findElement(By.xpath("//h1[text()[normalize-space() = 'View All Workspaces']]")));
		}
		catch(Exception e)
		{
			Set<String> windows = driver.getWindowHandles();
	        Iterator<String> it=windows.iterator();
	        String parentWindow = it.next();
	        String childWindow = it.next();
	        driver.switchTo().window(childWindow);
	        Thread.sleep(4000);
	        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//h1[text()[normalize-space() = 'View All Workspaces']]")));
			driver.close();
	        Thread.sleep(1000);
			driver.switchTo().window(parentWindow);
		}
		
	}
	
	public void verify_Favourite_Marked_Studies_Are_Displayed() throws Throwable {
		for(int i=1;i<=5;i++)
		{
			CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//*[@title='Click here to remove this study as a Favorite.']/label/span)["+i+"]")));
		}
	}
	
	public void verify_Recently_Viewed_Studies_Displayed_Under_RECENT_STUDIES_Section() throws Throwable {
		for(int i=1;i<=5;i++)
		{
			CommonClass.highLightElement(driver, driver.findElement(By.xpath("//h4[text()[normalize-space() = 'Recent Studies']]//..//ul/li["+i+"]/a")));
		}
	}
	
	public void click_On_VIEW_ALL_Options_Under_RECENT_STUDIES_Section() throws Throwable {
		driver.findElement(By.xpath("//h4[text()[normalize-space() = 'Recent Studies']]//..//u[text()[normalize-space() = 'View All>>']]")).click();
	}
	
	public void verify_LINKS_Section_In_Sponaor_Home_Screen() throws Throwable {
		CommonClass.scroll3(driver);
		Thread.sleep(1000);
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//h4[text()[normalize-space() = 'Links']]")));
	}
	
	public void verify_Links_Under_LINKS_Section_In_Sponsor_Home_Screen() throws Throwable {
		try {
		int linkCount=driver.findElements(By.xpath("//h4[text()[normalize-space() = 'Links']]//..//ul//a")).size();
		for(int i=1;i<=linkCount;i++)
		{
			CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//h4[text()[normalize-space() = 'Links']]//..//ul//a)["+i+"]")));
		}
		}
		catch(Exception e)
		{
			System.out.println("No Links Present");
		}
		
	}
	
	public void click_On_Any_Links_Under_LINKS_Section_In_Sponsor_Home_Screen() throws Throwable {
		try {
				CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//h4[text()[normalize-space() = 'Links']]//..//ul//a)[1]")));
				driver.findElement(By.xpath("(//h4[text()[normalize-space() = 'Links']]//..//ul//a)[1]")).click();
			}
			catch(Exception e)
			{
				System.out.println("No Links Present");
			}
	}
	
	public void verify_Link_URL_Is_Displayed() throws Throwable {
		try {
			Set<String> windows = driver.getWindowHandles();
	        Iterator<String> it=windows.iterator();
	        String parentWindow = it.next();
	        String childWindow = it.next();
	        driver.switchTo().window(childWindow);
	        Thread.sleep(4000);
	        ExtentReportListner.captureSreenShots(driver);
	        Thread.sleep(2000);
	        driver.switchTo().window(parentWindow);
		}
		catch(Exception e)
		{
			System.out.println("No Links Present");
		}
	}
	
	@FindBy(how=How.ID, using="SponsorCROId")
	public WebElement SPONSOR_CRO;
	
	@FindBy(how=How.ID, using="ViewAllWorkspacesId")
	public WebElement ViewAllWorkspaces;
	
		
	public void site_User_Navigate_To_View_All_Workspaces() throws Throwable {
		Actions actions = new Actions(driver);
	    actions.moveToElement(SPONSOR_CRO).build().perform();
   	 	Thread.sleep(2000);
   	 	ViewAllWorkspaces.click();
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='viewAllworkspacesSponsorForm']/div/span/i")
	public WebElement SearchWorkspaces_Expand;
	
	@FindBy(how=How.ID, using="studyId")
	public WebElement StudyId_TextBox;
	
	@FindBy(how=How.ID, using="searchAllWorkspacesBtn")
	public WebElement searchAllWorkspacesBtn;
	
	
	public void site_User_Navigate_To_Study(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String studyID = testDataInMap.get("studyID"+arg1);
        try {
        	CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='sponsorStudiesTable']//a[text()[normalize-space() = '"+studyID+"']]")));
            driver.findElement(By.xpath("//*[@id='sponsorStudiesTable']//a[text()[normalize-space() = '"+studyID+"']]")).click();
        }
        catch (Exception e)
        {
        SearchWorkspaces_Expand.click();
        Thread.sleep(4000);
        StudyId_TextBox.sendKeys(studyID);
        Thread.sleep(2500);
        searchAllWorkspacesBtn.click();
        Thread.sleep(10000);
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='sponsorStudiesTable']//a[text()[normalize-space() = '"+studyID+"']]")));
        driver.findElement(By.xpath("//*[@id='sponsorStudiesTable']//a[text()[normalize-space() = '"+studyID+"']]")).click();
        }
	}
	
	@FindBy(how=How.ID, using="WorkspaceId")
	public WebElement Workspace;
	
	@FindBy(how=How.ID, using="ViewAllWorkspacesId")
	public WebElement ViewAllWorkspaces_Sponsor;
	
	
	public void sponsor_User_Navigate_To_View_All_Workspaces() throws Throwable {
		Actions actions = new Actions(driver);
	    actions.moveToElement(Workspace).build().perform();
   	 	Thread.sleep(2000);
   	 	ViewAllWorkspaces_Sponsor.click();
	}
	
	
	public void sponsor_User_Navigate_To_Study(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String studyID = testDataInMap.get("studyID"+arg1);
        
        SearchWorkspaces_Expand.click();
        Thread.sleep(4000);
        StudyId_TextBox.sendKeys(studyID);
        Thread.sleep(2500);
        searchAllWorkspacesBtn.click();
        Thread.sleep(10000);
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='sponsorStudiesTable']//a[text()[normalize-space() = '"+studyID+"']]")));
        driver.findElement(By.xpath("//*[@id='sponsorStudiesTable']//a[text()[normalize-space() = '"+studyID+"']]")).click();
	}
}
