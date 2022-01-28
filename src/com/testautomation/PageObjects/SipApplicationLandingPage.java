package com.testautomation.PageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.testautomation.Utility.ExcelHandler;
import com.testautomation.Utility.PropertiesFileReader;
import com.testautomation.Utility.TestDataHandler;

import cucumber.api.java.en.Then;

public class SipApplicationLandingPage {

	WebDriver driver;
	Properties properties;
	PropertiesFileReader obj = new PropertiesFileReader();
	TestDataHandler testData = new TestDataHandler();


	public SipApplicationLandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void highLightElement(WebElement string){
		JavascriptExecutor js = (JavascriptExecutor)driver;   
		js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');", string);   

	}


	@FindBy(how=How.ID, using="sponsor-login-btn")
	public WebElement sponsorLoginButton;

	@FindBy(how=How.ID, using="userid")
	public WebElement usernameTextBox;

	@FindBy(how=How.ID, using="siteLogin")
	public WebElement siteLoginButton;

	@FindBy(how=How.XPATH, using="//input[@id='mat-input-0']")
	public WebElement emailTextBox;

	@FindBy(how=How.XPATH, using="//span[contains(text(),'NEXT')]")
	public WebElement nextButton;

	@FindBy(how=How.XPATH, using="//input[@id='mat-input-1']")
	public WebElement passwordTextBox;

	@FindBy(how=How.XPATH, using="*//div[contains(text(),'Answer security questions')]//.//preceding-sibling::div")
	public WebElement radioSecurityQuestion;

	@FindBy(how=How.XPATH, using="//input[@id='mat-input-2']")
	public WebElement ans1TextBox;

	@FindBy(how=How.XPATH, using="//input[@id='mat-input-3']")
	public WebElement ans2TextBox;


	@FindBy(how=How.XPATH, using="//a[@class='sip-btn sponsor-company-login-btn']")
	public WebElement loginButton;

	@FindBy(how=How.XPATH, using= "/html/body/form/center/table/tbody/tr/td/table/tbody/tr[3]/td[3]/input[1]")
	public WebElement siteMinderUsernameText;

	@FindBy(how=How.XPATH, using="/html/body/form/center/table/tbody/tr/td/table/tbody/tr[7]/td/input[6]")
	public WebElement loginButtonSiteminder;

	@FindBy(how=How.ID, using="Select_Member_Company")
	public WebElement companyDropdown;


	@FindBy(how=How.ID, using="p_p_id_TCSIPpublicLoginRegistrationPortlet_WAR_TCSIPPublicHomePortlet100_")
	public WebElement companylist;

	@FindBy(how=How.XPATH, using="//button[@title='OK']")
	public WebElement okButtonPopUp;


	@FindBy(how=How.XPATH, using="//i[@class='fa fa-caret-down']")
	public WebElement logoutarrow;

	@FindBy(how=How.XPATH, using="(//div[@class='profileImage'])[1]")
	public WebElement UserIcon;

	@FindBy(how=How.XPATH, using="(//a[contains(@class,'dropdown-item logout-dropdown')])[2]")
	public WebElement logout;

	@FindBy(how=How.XPATH, using="(//button[@class='btn single-btn'])[2]")
	public WebElement Yes;

	@FindBy(how=How.XPATH, using="//*[@id=\"WorkspaceId\"]")
	public WebElement workspace;

	@FindBy(how=How.XPATH, using="//*[@id=\"ViewAllWorkspacesId\"]")
	public WebElement viewallworkspace;

	@FindBy(how=How.XPATH, using="//*[@id=\"ViewPotentialSitesId\"]")
	public WebElement viewpotentialsite;

	@FindBy(how=How.XPATH, using="//*[@id=\"ViewSponsorHomepageId\"]")
	public WebElement viewsposorhomepage;

	@FindBy(how=How.XPATH, using="//*[@id=\"RecentStudyWorkspacesId\"]")
	public WebElement recentstudy;


	@FindBy(how=How.XPATH, using="//*[@id=\"DocumentsId\"]")
	public WebElement documents;

	@FindBy(how=How.XPATH, using="//*[@id=\"CommonDocumentsId\"]")
	public WebElement commondocument;

	@FindBy(how=How.XPATH, using="//*[@id=\"SponsorViewId\"]")
	public WebElement sposorview;

	@FindBy(how=How.XPATH, using="//*[@id=\"SiteViewId\"]")
	public WebElement siteview;

	@FindBy(how=How.XPATH, using="//*[@id=\"StudyofCVId\"]")
	public WebElement studyofcv;

	@FindBy(how=How.XPATH, using="//*[@id=\"study_document_tab\"]/a")
	public WebElement studydocument;

	@FindBy(how=How.XPATH, using="//*[@id=\"SafetyId\"]")
	public WebElement safety;

	@FindBy(how=How.XPATH, using="//*[@id=\"MySafetyNotificationsId\"]")
	public WebElement Mysafetynotification;

	@FindBy(how=How.XPATH, using="//*[@id=\"DistributionviaAlternativeMeansId\"]")
	public WebElement distributionviaalternativemens;


	@FindBy(how=How.ID, using="ReportsId")
	public WebElement report;


	@FindBy(how=How.ID, using="GeneralReportsId")
	public WebElement generalreport;

	@FindBy(how=How.XPATH, using="//*[@id=\"GeneralReportsId\"]")
	public WebElement generatereport;


	@FindBy(how=How.XPATH, using="	//*[@id=\"populateTable\"]/div[2]/input[1]")
	public WebElement generatereport1;

	@FindBy(how=How.ID, using="AuditTrailReportsId")
	public WebElement audittrailreport;

	@FindBy(how=How.XPATH, using="//*[@id=\"AdvancedReportsId\"]")
	public WebElement advancedreport;


	@FindBy(how=How.XPATH, using="//*[@id=\"AdminId\"]")
	public WebElement Admin;

	@FindBy(how=How.XPATH, using="//*[@id=\"RemoveSiteUserStudyAccessId\"]")
	public WebElement removesiteuser;

	@FindBy(how=How.XPATH, using="//*[@id=\"SendSiteUserRegistrationInvitationId\"]")
	public WebElement sendsiteuserregistrationinvite;

	@FindBy(how=How.XPATH, using="//*[@id=\"ViewandManageSiteUserInvitationsId\"]")
	public WebElement viewmanagesiteuserinvitaion;

	@FindBy(how=How.XPATH, using="//*[@id=\"CreateTasksNotificationsId\"]")
	public WebElement createtasknotifiaction;


	@FindBy(how=How.XPATH, using="//*[@id=\"UserAccessManagementId\"]")
	public WebElement useraccesss;

	@FindBy(how=How.XPATH, using="//*[@id=\"UserPlatformAccessManagementId\"]")
	public WebElement userplatforms;

	@FindBy(how=How.XPATH, using="//*[@id=\"ManageFDAForm1572ApplicableCountriesId\"]")
	public WebElement form1572s;

	@FindBy(how=How.XPATH, using="//*[@id=\"RemoveSiteUserStudyAccessId\"]")
	public WebElement removesiteuserss;

	@FindBy(how=How.XPATH, using="//*[@id=\"SendSiteUserRegistrationInvitationId\"]")
	public WebElement sendsiteuserregistrations;

	@FindBy(how=How.XPATH, using="//*[@id=\"ViewandManageSiteUserInvitationsId\"]")
	public WebElement viewmanagesiteuserinvitations;

	@FindBy(how=How.XPATH, using="//*[@id=\"CreateTasksNotificationsId\"]")
	public WebElement createtasknotifications;

	@FindBy(how=How.XPATH, using="//*[@id=\"DocumentRepositoryId\"]")
	public WebElement documentrepositorys;

	@FindBy(how=How.XPATH, using="//*[@id=\"ManageSponsorStudyNewsandLinksId\"]")
	public WebElement managesponsornewslinks;

	@FindBy(how=How.XPATH, using="//*[@id=\"ConfigureSystemsforSiteUserAccessId\"]")
	public WebElement configsystemforsiteuseraccesss;

	@FindBy(how=How.XPATH, using="//*[@id=\"UploadStudySiteProfileDetailsId\"]")
	public WebElement uploadstudysiteprofildetailss;

	@FindBy(how=How.XPATH, using="//*[@id=\"ViewandManageStudySite(s)Id\"]")
	public WebElement viewandmanagestudysitess;

	@FindBy(how=How.XPATH, using="//*[@id=\"jspDropDownValue\"]")
	public WebElement SelectTGTR;

	@FindBy(how=How.ID, using="selectedAuditReport")
	public WebElement auditraildropdown;

	@FindBy(how=How.XPATH, using="//*[@id=\"ExportPopupSponsorUserAccess\"]/div/h1")
	public WebElement title;

	@FindBy(how=How.XPATH, using="//*[@id=\"ExportPopupSponsorUserAccess\"]/div/div[1]")
	public WebElement onscreen;


	@FindBy(how=How.XPATH, using="//*[@id=\"ExportPopupSponsorUserAccess\"]/div/div[2]/span[1]")
	public WebElement pdf;


	@FindBy(how=How.XPATH, using="//*[@id=\"ExportPopupSponsorUserAccess\"]/div/div[2]/span[2]")
	public WebElement xls;

	@FindBy(how=How.XPATH, using="//*[@id=\"ExportPopupSponsorUserAccess\"]/div/div[2]/span[1]/input")
	public WebElement pdfselection;

	@FindBy(how=How.XPATH, using="//*[@id=\"ExportPopupSponsorUserAccess\"]/div/div[3]/input")
	public WebElement ok;

	@FindBy(how=How.XPATH, using="//span[text()='Home']")
	public WebElement home;

	@FindBy(how=How.ID, using="myTaskSTU")
	public WebElement mytask;


	@FindBy(how=How.XPATH, using="//*[@id=\"taskTypeId\"]/span")
	public WebElement tasktype;

	@FindBy(how=How.XPATH, using="//*[@id=\"taskTypeId\"]/div/div[2]/div[2]/span[1]/span")
	public WebElement chck;

	@FindBy(how=How.XPATH, using="//*[@id=\"taskTypeId\"]/div/div[1]/a[1]/i")
	public WebElement close;

	@FindBy(how=How.XPATH, using="//*[@id=\"searchTaskResult\"]")
	public WebElement search;


	@FindBy(how=How.XPATH, using="//*[@id=\"allTaskViewMoreTable\"]/tbody/tr/td[3]/div/a")
	public WebElement tasktitle;


	@FindBy(how=How.XPATH, using="//*[@id=\"taskDetailsPopup_141585\"]/div/ul/li[5]/p/a")
	public WebElement clickhere;


	@FindBy(how=How.XPATH, using="/html/body/div[6]/div[1]/button/span")
	public WebElement crossbutton;


	@FindBy(how=How.XPATH, using="//*[@id=\"Navigationmenu\"]/li[1]/a")
	public WebElement home1;


	@FindBy(how=How.XPATH, using="//*[@id=\"jspDropDownValue\"]")
	public WebElement reportdropdown;



	@FindBy(how=How.XPATH, using="//div[@id='countryDiv']//span[@class='site-sel-container tAsite-sel-container']")
	public WebElement facilitycountry;


	@FindBy(how=How.XPATH, using="//div[102]//span[1]//span[1]")
	public WebElement chq1;


	@FindBy(how=How.XPATH, using="//div[@id='countryDiv']//i[@class='fa fa-times']")
	public WebElement closebtn;


	@FindBy(how=How.XPATH, using="//*[@id=\"populateTable\"]/div[1]/div/div/div[3]/input[1]")
	public WebElement generatereports;



	@FindBy(how=How.XPATH, using="//*[@id=\"fixTable-1\"]/tbody/tr[1]/td[6]/div")
	public WebElement country3;

	@FindBy(how=How.XPATH, using="//button[@id='changedBy']//i[@class='fa fa-search']")
	public WebElement changeby;

	@FindBy(how=How.ID, using="user_firstName")
	public WebElement fname;

	@FindBy(how=How.ID, using="user_lastName")
	public WebElement lname;
	
	@FindBy(how=How.ID, using="user_email")
	public WebElement UserEmail;

	@FindBy(how=How.XPATH, using="//*[@id=\"staffSearch\"]/span")
	public WebElement search1;


	@FindBy(how=How.XPATH, using="//input[@class='form-radio-btn ui-helper-hidden-accessible']")
	public WebElement radio;

	@FindBy(how=How.XPATH, using="//*[@id=\"addUserButton\"]")
	public WebElement select;


	@FindBy(how=How.XPATH, using="(//button[@type='button']//i)[2]")
	public WebElement facilitydepartmentname;
	
	@FindBy(how=How.ID, using="search_facilityName")
	public WebElement facilitySearch;
	
	@FindBy(how=How.XPATH, using="(//span[@class='k-icon k-i-calendar'])[1]")
	public WebElement FromDate;
	
	@FindBy(how=How.XPATH, using="(//span[@class='k-icon k-i-calendar'])[2]")
	public WebElement ToDate;
	
	@FindBy(how=How.XPATH, using="(//button[@type='button']//i)[3]")
	public WebElement UserNameSearch;

	@FindBy(how=How.XPATH, using="//*[@id=\"countryFacilitySearch\"]")
	public WebElement country;
	
	@FindBy(how=How.XPATH, using="//input[@id='facilityState']")
	public WebElement StateProvince;
	
	@FindBy(how=How.XPATH, using="//input[@id='search_city']")
	public WebElement City;
	

	@FindBy(how=How.XPATH, using="//*[@id=\"facSearch\"]/span")
	public WebElement search2;


	@FindBy(how=How.XPATH, using="(//input[@name='selectFacilityRow'])[3]") //May change index According to the Facility
	public WebElement radio1;
	


	@FindBy(how=How.XPATH, using="//*[@id=\"addFacButton\"]")
	public WebElement select1;



	@FindBy(how=How.XPATH, using="//*[@id=\"facilityDepartmentSection\"]")
	public WebElement facilitydepartmentselection;

	@FindBy(how=How.XPATH, using="//input[@class='primary-btn-blue']")
	public WebElement Generatereport;



	@FindBy(how=How.XPATH, using="//*[@id=\"auditTablePopulation\"]/div[3]/div/div/button[2]/i")
	public WebElement export;

	@FindBy(how=How.XPATH, using="//*[@id=\"auditTablePopulation\"]/div[3]/div/div/div/ul/li[2]")
	public WebElement XLS;

	@FindBy(how=How.XPATH, using="//*[@id=\"auditTablePopulation\"]/div[3]/div/div/div/ul/li[1]")
	public WebElement PDF;
	
	


	@FindBy(how=How.ID, using="FacilityId")
	public WebElement Facility;

	@FindBy(how=How.ID, using="MyFacilitiesId")
	public WebElement MyFacility;

	@FindBy(how=How.XPATH, using="//*[@id=\"2885\"]/td[1]/div/label/span")
	public WebElement F1D12;

	@FindBy(how=How.XPATH, using="//*[@id=\"2884\"]/td[1]/div/label/span")
	public WebElement F1D14;


	@FindBy(how=How.XPATH, using="//*[@id=\"1954\"]/td[1]/div/label/span")
	public WebElement F1;


	@FindBy(how=How.XPATH, using="//*[@id=\"previewCV\"]")
	public WebElement previewcv;

	@FindBy(how=How.XPATH, using="//*[@id=\"p_p_id_TCSIPTaskPortlet_WAR_TCSIPTaskPortlet100_\"]/div/div/div/div/h1")
	public WebElement allsponsornews;



	@FindBy(how=How.XPATH, using="//*[@id=\"p_p_id_TCSIPTaskPortlet_WAR_TCSIPTaskPortlet100_\"]/div/div/div/div/div/div[3]/a")
	public WebElement viewmore;



	@FindBy(how=How.XPATH, using=" //*[@id=\"printAllNews\"]/i")
	public WebElement print;



	@FindBy(how=How.XPATH, using="//*[@id=\"allNewsListResults\"]/div/div/div[1]/button/i")
	public WebElement export1;

	@FindBy(how=How.ID, using="showMoreLink")
	public WebElement ViewAllTask;


	@FindBy(how=How.XPATH, using="//*[@id=\"allNewsListResults\"]/div/div/div[1]/div/ul/li[2]")
	public WebElement excel;

	@FindBy(how=How.XPATH, using="//*[@id=\"allNewsListResults\"]/div/div/div[1]/div/ul/li[1]")
	public WebElement pdf1;

	@FindBy(how=How.XPATH, using="//*[@id=\"allNewsListResults\"]/div/div/div[1]/div/ul/li[3]")
	public WebElement csv1;
	
	@FindBy(how=How.XPATH, using="//span[@role='textbox']")
	public WebElement SearchBY;
	
	

	
	

	public void NavigateToHomePageProperLogin() throws Exception
	{

		System.out.println("properLoginhome");
		sponsorLoginButton.click();
		Thread.sleep(3000);

		properties= obj.getProperty();
		//        String Sponsorcompany = properties.getProperty("sponsor.company");
		//        System.out.println(Sponsorcompany);
		//        String Username = properties.getProperty("loginProper.username");

		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);

		Map<String,String> testDataInMap = testData.getTestDatainMap();
		String Sponsorcompany = testDataInMap.get("sponsorCompany");
		String Username = testDataInMap.get("usernameProperlogin");


		companylist.click();
		Thread.sleep(3000);
		Select companydropdown = new Select (companyDropdown);
		companydropdown.selectByVisibleText(Sponsorcompany);
		Thread.sleep(3000);
		loginButton.click();
		Thread.sleep(5000);
		siteMinderUsernameText.sendKeys(Username);
		Thread.sleep(2000);
		loginButtonSiteminder.click();
		Thread.sleep(5000);
		System.out.println("test 1");
	}
	public void ByPasslogin(String Username) throws Exception
	{

		Thread.sleep(2000);
		sponsorLoginButton.click();
		Thread.sleep(2000);
		usernameTextBox.sendKeys(Username);
		Thread.sleep(1000);
		loginButton.click();
		Thread.sleep(30000);
	}

	public void NavigateToHomePageProperLogin1() throws Exception
	{

		System.out.println("properLoginhome");
		sponsorLoginButton.click();
		Thread.sleep(3000);

		properties= obj.getProperty();
		//		String Sponsorcompany = properties.getProperty("sponsor.company");
		//		System.out.println(Sponsorcompany);
		//		String Username = properties.getProperty("loginProper.username");

		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);

		Map<String,String> testDataInMap = testData.getTestDatainMap();
		String Sponsorcompany = testDataInMap.get("sponsorCompany1");
		String Username = testDataInMap.get("usernameProperlogin1");


		companylist.click();
		Thread.sleep(3000);
		Select companydropdown = new Select (companyDropdown);
		companydropdown.selectByVisibleText(Sponsorcompany);
		Thread.sleep(3000);
		loginButton.click();
		Thread.sleep(5000);
		siteMinderUsernameText.sendKeys(Username);
		Thread.sleep(2000);
		loginButtonSiteminder.click();
		Thread.sleep(5000);
	}



	public void NavigateToHomePage(String user) throws Exception
	{

		System.out.println("properLogin User");
		sponsorLoginButton.click();
		Thread.sleep(3000);

		properties= obj.getProperty();
		//		String Sponsorcompany = properties.getProperty("sponsor.company");
		//		System.out.println(Sponsorcompany);
		//		String Username = properties.getProperty("loginProper.username");

		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);

		Map<String,String> testDataInMap = testData.getTestDatainMap();
		String Sponsorcompany = testDataInMap.get("sponsorCompany");
		String Username = user;
		System.out.println(Username);

		companylist.click();
		Thread.sleep(3000);
		Select companydropdown = new Select (companyDropdown);
		companydropdown.selectByVisibleText(Sponsorcompany);
		Thread.sleep(3000);
		loginButton.click();
		Thread.sleep(5000);
		siteMinderUsernameText.sendKeys(Username);
		Thread.sleep(2000);
		loginButtonSiteminder.click();
		Thread.sleep(20000);

	}




	public void NavigateToHomePageSite(String user,String password,String ans1,String ans2) throws Exception
	{

		siteLoginButton.click();
		Thread.sleep(8000);

		properties= obj.getProperty();

		String Username = user;
		String Password = password;
		String Answer1 = ans1;
		String Answer2 = ans2;


		emailTextBox.sendKeys(Username);
		nextButton.click();
		Thread.sleep(6000);

		passwordTextBox.sendKeys(Password);
		nextButton.click();
		Thread.sleep(20000);

		radioSecurityQuestion.click();
		nextButton.click();
		Thread.sleep(25000);

		ans1TextBox.sendKeys(Answer1);
		Thread.sleep(5000);
		ans2TextBox.sendKeys(Answer2);
		Thread.sleep(5000);

		nextButton.click();
		Thread.sleep(40000);

		System.out.println("logged in");


		try{  

			okButtonPopUp.click();

		}

		catch(Exception e){

			System.out.print("No Alert");

		}


	}





	public void logout() throws Exception
	{

		Thread.sleep(8000);
		logoutarrow.click();
		Thread.sleep(12000);
		logout.click();
		Thread.sleep(12000);
		Yes.click();
		Thread.sleep(12000);
		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	}

	public void logoutFromSIP() throws Exception{
		
		try{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,0)");
			Thread.sleep(2000);
			CommonClass.highLightElement(driver, UserIcon);
			UserIcon.click();
			Thread.sleep(4000);
			CommonClass.highLightElement(driver, logout);
			logout.click();
			Thread.sleep(8000);
			CommonClass.highLightElement(driver, Yes);
			Yes.click();
		}catch(Exception e){
			CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='profileDropdown']/div/img")));
			Thread.sleep(500);
			driver.findElement(By.xpath("//*[@id='profileDropdown']/div/img")).click();
			Thread.sleep(2000);
			CommonClass.highLightElement(driver, logout);
			logout.click();
			Thread.sleep(8000);
			CommonClass.highLightElement(driver, Yes);
			Yes.click();
		}
		
	}
	
	public void switch_To_Parent_Window_And_Logout_from_SipApplication() throws Throwable {
		Set<String> windows = driver.getWindowHandles();
        Iterator<String> it=windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(parentWindow);
        Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,0)");
		Thread.sleep(2000);
		try 
		{
			CommonClass.highLightElement(driver, UserIcon);
		UserIcon.click();
		Thread.sleep(4000);
		CommonClass.highLightElement(driver, logout);
		logout.click();
		Thread.sleep(8000);
		CommonClass.highLightElement(driver, Yes);
		Yes.click();
		}
		catch(Exception e)
		{
			CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='profileDropdown']/div/img")));
			Thread.sleep(500);
			driver.findElement(By.xpath("//*[@id='profileDropdown']/div/img")).click();
			Thread.sleep(2000);
			CommonClass.highLightElement(driver, logout);
			logout.click();
			Thread.sleep(8000);
			CommonClass.highLightElement(driver, Yes);
			Yes.click();
		}
	}
	
	

	public void Verify_Workspace_tab() throws Exception
	{
		Thread.sleep(5000);
		workspace.click();
		Thread.sleep(5000);
		Highlightelement("viewallworkspace");
		Thread.sleep(5000);
		Highlightelement("viewallexternalworkspace");
		Thread.sleep(5000);
		Highlightelement("viewsposorhomepage");
		Thread.sleep(5000);
		Highlightelement("recentstudy");
		Thread.sleep(5000);
		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	}
	private void Highlightelement(String string) {
		// TODO Auto-generated method stub

	}


	public void Clickandverify_Potentialsites() throws Exception 
	{
		Thread.sleep(3000);
		viewpotentialsite.click();
		Thread.sleep(3000);

		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	}





	public void Clickandverify_Documents() throws Exception 
	{
		Thread.sleep(3000);
		documents.click();
		Thread.sleep(3000);
		Highlightelement("commondocument");
		Thread.sleep(5000);
		Highlightelement("sposorview");
		Thread.sleep(5000);
		Highlightelement("siteview");
		Thread.sleep(5000);



		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	}

	public void Clickandverify_studydocument() throws Exception 
	{
		Thread.sleep(3000);
		workspace.click();
		Thread.sleep(3000);
		studyofcv.click();
		Thread.sleep(5000);
		studydocument.click();
		Thread.sleep(8000);



		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	}


	public void Navigate_Document_safetydocument() throws Exception 
	{
		Thread.sleep(3000);
		safety.click();
		Highlightelement("Mysafetynotification");
		Thread.sleep(5000);
		Highlightelement("distributionviaalternativemens");
		Thread.sleep(5000);



		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	}

	public void Navigate_reports() throws Exception 
	{
		
		
		Actions action=new Actions(driver);
		action.moveToElement(report).build().perform();
		Highlightelement("generalreport");
		Thread.sleep(5000);
		generalreport.click();

		

	}


	public void Navigate_Adminmenu() throws Exception 
	{
		Thread.sleep(3000);
		Admin.click();
		Highlightelement("removesiteuser");
		Thread.sleep(5000);
		Highlightelement("sendsiteuserregistrationinvite");
		Thread.sleep(5000);
		Highlightelement("viewmanagesiteuserinvitaion");
		Thread.sleep(5000);
		Highlightelement("createtasknotifiaction");
		Thread.sleep(5000);

		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	}

	public void Verify_Workspace_tab1() throws Exception
	{
		Thread.sleep(5000);
		workspace.click();
		Highlightelement("createstudyworkspace");
		Thread.sleep(5000);
		Highlightelement("viewallworkspace");
		Thread.sleep(5000);
		Highlightelement("viewallexternalworkspace");
		Thread.sleep(5000);
		Highlightelement("viewsposorhomepage");
		Thread.sleep(5000);
		Highlightelement("recentstudy");
		Thread.sleep(5000);
		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	}

	public void Clickandverify_documentmenu() throws Exception
	{
		Thread.sleep(5000);
		Thread.sleep(3000);
		documents.click();
		Thread.sleep(3000);
		Highlightelement("commondocument");
		Thread.sleep(5000);
		Highlightelement("sposorview");
		Thread.sleep(5000);
		Highlightelement("siteview");
		Thread.sleep(5000);
	}



	public void Clickandverify_adminmenu() throws Exception
	{
		Thread.sleep(3000);
		Admin.click();
		Highlightelement("useraccesss");
		Thread.sleep(5000);
		Highlightelement("userplatforms");
		Thread.sleep(5000);
		Highlightelement("form1572s");
		Thread.sleep(5000);
		Highlightelement("removesiteuserss");
		Thread.sleep(5000);
		Highlightelement("sendsiteuserregistrations");
		Thread.sleep(5000);
		Highlightelement("viewmanagesiteuserinvitations");
		Thread.sleep(5000);
		Highlightelement("createtasknotifications");
		Thread.sleep(5000);
		Highlightelement("documentrepositorys");
		Thread.sleep(5000);
		Highlightelement("managesponsornewslinks");
		Thread.sleep(5000);
		Highlightelement("configsystemforsiteuseraccesss");
		Thread.sleep(5000);
		Highlightelement("uploadstudysiteprofildetailss");
		Thread.sleep(5000);
		Highlightelement("viewandmanagestudysites");
		Thread.sleep(5000);

	}




	public void Navigateandverifytosposoraccessrepor() throws Exception
	{


		home.click();
		Thread.sleep(6000);
		report.click();

		Thread.sleep(6000);
		generalreport.click();

		//SelectReportTypedropdwon.click();

		Select SelectTGTR1 = new Select (SelectTGTR);
		SelectTGTR1.selectByVisibleText("Sponsor User Access Report");


		Thread.sleep(5000);
		generatereport1.click();
		Thread.sleep(5000);

		if(title.getText().contains("Generate and Download the Report"))
		{
			System.out.println("Test pass");
		}
		else
		{
			System.out.println("Test Fail");

		}

		if(onscreen.getText().contains("The Sponsor User Access Report cannot be displayed instantly. A task will be assigned once the report is available. Select the format in which you wish to see the report."))
		{
			System.out.println("Test pass");
		}
		else
		{
			System.out.println("Test Fail");

		}
		if(pdf.getText().contains("PDF"))
		{
			System.out.println("Test pass");
		}
		else
		{
			System.out.println("Test Fail");

		}
		if(xls.getText().contains("XLS"))
		{
			System.out.println("Test pass");
		}
		else
		{
			System.out.println("Test Fail");

		}
		pdfselection.click();
		Thread.sleep(3000);
		ok.click();
		Thread.sleep(8000);

	}



	public void Mytaskandverify() throws Exception
	{



		Thread.sleep(5000);
		home1.click();
		Thread.sleep(5000);
		mytask.click();
		Thread.sleep(5000);
		tasktype.click();
		Thread.sleep(5000);
		tasktype.sendKeys("Other Tasks");
		Thread.sleep(5000);
		chck.click();
		Thread.sleep(5000);
		close.click();
		Thread.sleep(5000);
		search.click();
		Thread.sleep(8000);


		if(tasktitle.getText().contains("Sponsor User Access Report ready for download"))
		{
			System.out.println("Test pass");
		}
		else
		{
			System.out.println("Test Fail");

		}

		Thread.sleep(8000);

	}
	
	public void NavigateToMyTaskPage(String TaskTitle) throws Exception{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		mytask.click();
		try{
			Thread.sleep(5000);
			WebElement tasktitle=driver.findElement(By.xpath("(//a[contains(text(),"+TaskTitle+")])[1]"));
			
			if(tasktitle.getText().contains(TaskTitle)){
				System.out.println("Test pass");
			}
			else {
				System.out.println("Test Fail");
			}
			Thread.sleep(8000);
			
		}catch(Exception e){}		
		
		
	}
	
	public void ClickOnUserProfileTaskTitle(String TaskTitle) throws Exception{
		Thread.sleep(5000);
		WebElement tasktitle=driver.findElement(By.xpath("(//a[contains(text(),"+TaskTitle+")])[1]"));
		tasktitle.click();
		Thread.sleep(5000);
	}
	
	public void ClickOnRelaseTask(){
		WebElement ReleaseBtn=driver.findElement(By.id("userProfRelBtn"));
		ReleaseBtn.click();
		
		try{
			Thread.sleep(2000);
			highLightElement(driver.findElement(By.xpath("(//p[@class='popupFont'])[1]")));
		}catch(Exception e){}
		
	}
	
	public void ClickOnRelaseOK(){
		try{
			highLightElement(driver.findElement(By.xpath("(//input[@id='relTaskOkBtn'])[1]")));
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@id='relTaskOkBtn'])[1]")).click();
		}catch(Exception e){}
	}
	
	public void ClickOnTaskTitle(String TaskTitle) throws Exception{
		WebElement tasktitle=driver.findElement(By.xpath("(//a[text()='"+TaskTitle+"'][1])"));
		Thread.sleep(5000);
		tasktitle.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//p[contains(@class,'no-margin-top display-inline-block')]//a[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(@class,'ui-button-icon-primary ui-icon-closethick')]")).click();
	}




	public void verifydownloadsposoraccessreport() throws Exception
	{



		Thread.sleep(5000);
		tasktitle.click();
		Thread.sleep(4000);
		clickhere.click();
		Thread.sleep(8000);
		crossbutton.click();
		Thread.sleep(4000);

	}



	public void NavigateandverifyFacilitycontactdetailreport() throws Exception
	{



		Thread.sleep(5000);
		report.click();
		Thread.sleep(4000);
		generalreport.click();
		Thread.sleep(8000);
		Select reportdropdown1 = new Select (reportdropdown);
		reportdropdown1.selectByVisibleText("Facility/Department Contact Details Report");
		Thread.sleep(5000);
		facilitycountry.click();
		Thread.sleep(5000);





	}




	public void Generatereportandverify() throws Exception
	{



		facilitycountry.sendKeys("India");
		Thread.sleep(4000);
		chq1.click();
		Thread.sleep(4000);
		closebtn.click();
		Thread.sleep(4000);
		generatereports.click();
		Thread.sleep(8000);
		Highlightelement("country3");
		Thread.sleep(4000);

		if(country3.getText().contains("India"))
		{
			System.out.println("Test pass");
		}
		else
		{
			System.out.println("Test Fail");

		}






	}


public void NavigateToAuditTrail() throws Exception{
    Thread.sleep(2000);
	Actions action=new Actions(driver);
	action.moveToElement(report).build().perform();

	
	audittrailreport.click();

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

	public void Navigateandverifyfacilitydepartmentaudittrailreport() throws Exception
	{    Thread.sleep(2000);
	Actions action=new Actions(driver);
	action.moveToElement(report).build().perform();

	
	audittrailreport.click();

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	Select auditraildropdown1 = new Select (auditraildropdown);
	auditraildropdown1.selectByVisibleText("Facility / Department Profile Audit Trail Report");
//	Thread.sleep(6000);
	highLightElement(driver.findElement(By.xpath("//h2[text()='Facility / Department Profile Audit Trail Report']")));


	}
	
	public void NevigateToGeneralReport() throws InterruptedException{
		
		  Thread.sleep(6000);
			Actions action=new Actions(driver);
			action.moveToElement(report).build().perform();
		Thread.sleep(6000);
		generalreport.click();
		Thread.sleep(2000);
		highLightElement(driver.findElement(By.xpath("//h1[text()='General Reports']")));
	}
	
	public void NevigateToGeneralReportForSiteUser() throws InterruptedException{
		Thread.sleep(5000);
		report.click();
		Thread.sleep(4000);
//		generalreport.click();
//		Thread.sleep(8000);
//		Select reportdropdown1 = new Select (reportdropdown);
//		reportdropdown1.selectByVisibleText("Facility/Department Contact Details Report");
//		Thread.sleep(5000);
	}
	
	
	
	public void SelectUserAndFacilityUnderAuditTrail() throws InterruptedException{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,0)");
		
		Thread.sleep(6000);
		Select auditraildropdown1 = new Select (auditraildropdown);
		auditraildropdown1.selectByVisibleText("User and Facility Documents Audit Trail Report");
		Thread.sleep(6000);
		highLightElement(driver.findElement(By.xpath("//h2[text()='User and Facility Documents Audit Trail Report']")));

	}




//	public void Filldataandgeneratereport() throws Exception
//	{
//
//		properties= obj.getProperty();
//
//		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
//		testData.setTestDatainMap(TestDataInMap);
//
//		JavascriptExecutor js = ((JavascriptExecutor) driver);
//		js.executeScript("window.scrollBy(0,250)");
//		js.executeScript("document.getElementById('ActivationDateRangeFrom').value='28-Oct-2017'");
//		Thread.sleep(3000);
//		js.executeScript("document.getElementById('ActivationDateRangeTo').value='27-Jul-2020'");
//
//		Thread.sleep(10000);
//		changeby.click();
//		Thread.sleep(3000);
//		fname.sendKeys("810Site");
//		Thread.sleep(3000);
//		lname.sendKeys("User810");
//		Thread.sleep(3000);
//		search1.click();
//		Thread.sleep(3000);
//		radio.click();
//		Thread.sleep(3000);
//		select.click();
//		Thread.sleep(3000);
//		facilitydepartmentname.click();
//		Thread.sleep(3000);
//		country.sendKeys("United States Of America");
//		Thread.sleep(3000);
//		Robot robot = new Robot();  
//		Thread.sleep(2000); 
//		robot.keyPress(KeyEvent.VK_DOWN);  
//		Thread.sleep(2000);
//		robot.keyRelease(KeyEvent.VK_DOWN);
//		Thread.sleep(2000);	
//		robot.keyPress(KeyEvent.VK_ENTER);	
//		Thread.sleep(2000);	
//		robot.keyRelease(KeyEvent.VK_ENTER);
//		Thread.sleep(2000);	
//		search2.click();
//		Thread.sleep(2000);	
//		radio1.click();
//		Thread.sleep(2000);	
//		select1.click();
//		Thread.sleep(3000);
//		Select facilitydepartmentselection1 = new Select (facilitydepartmentselection);
//		facilitydepartmentselection1.selectByVisibleText("Additional Information & Attachments");
//		Thread.sleep(3000);
//		Generatereport.click();
//		Thread.sleep(6000);
//
//
//		Thread.sleep(5000);
//		TakesScreenshot webdriver = null;
//		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
//	}
	
	public void FillDatesAndgenerateReportAs(String D1,String D2) throws Exception{
		 properties=obj.getProperty();
			Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
			testData.setTestDatainMap(TestDataInMap);	
			Map<String,String> testDataInMap = testData.getTestDatainMap();
			
			String date1=testDataInMap.get(D1);
			String date2=testDataInMap.get(D2);
			
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,250)");
		try{
			if(D1.equals("Date1") && D2.equals("Date2")){
			
				js.executeScript("document.getElementById('ActivationDateRangeFrom').value='12-Jun-2019'");
				Thread.sleep(3000);
				js.executeScript("document.getElementById('ActivationDateRangeTo').value='24-May-2021'");
				
			}
			}catch(Exception e){
				System.out.println("NO");
			}
		try{
			if(D1.equals("Date3") && D2.equals("Date4")){
			
				js.executeScript("document.getElementById('ActivationDateRangeFrom').value='1-Jun-2020'");
				Thread.sleep(3000);
				js.executeScript("document.getElementById('ActivationDateRangeTo').value='24-May-2021'");
				
			}
			}catch(Exception e){
				System.out.println("NO");
			}
		
		Thread.sleep(10000);
		changeby.click();
		Thread.sleep(3000);
		fname.sendKeys("Andrina");
		Thread.sleep(3000);
		lname.sendKeys("Tucker");
		Thread.sleep(3000);
		search1.click();
		Thread.sleep(3000);
		radio.click();
		Thread.sleep(6000);
		select.click();
		Thread.sleep(4000);
		facilitydepartmentname.click();
		Thread.sleep(3000);
		country.sendKeys("United States Of America");
		Thread.sleep(3000);
		Robot robot = new Robot();  
		Thread.sleep(2000); 
		robot.keyPress(KeyEvent.VK_DOWN);  
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);	
		robot.keyPress(KeyEvent.VK_ENTER);	
		Thread.sleep(2000);	
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(4000);	
		search2.click();
		Thread.sleep(2000);	
		radio1.click();
		Thread.sleep(6000);	
		select1.click();
		Thread.sleep(3000);
		
		try{
			if(facilitydepartmentselection.isEnabled()){
			Select facilitydepartmentselection1 = new Select (facilitydepartmentselection);
			facilitydepartmentselection1.selectByVisibleText("Local Lab");
			}
		}catch(Exception e){
			System.out.println("No");
		}
		
		try{
			if(UserNameSearch.isEnabled()){
				UserNameSearch.click();
				Thread.sleep(3000);
				fname.sendKeys("Roky");
				Thread.sleep(3000);
				lname.sendKeys("Roy");
				Thread.sleep(3000);
				search1.click();
				Thread.sleep(3000);;
				radio.click();
				Thread.sleep(3000);
				select.click();
				Thread.sleep(3000);
			}
			
			
		}catch(Exception e){
			System.out.println("No");
		}
		
		Thread.sleep(3000);
		Generatereport.click();
		Thread.sleep(6000);
	}
	
public void GenerateReport() throws InterruptedException{
	Generatereport.click();
	Thread.sleep(6000);
}
	

public void FillDetailsForFacilityDepartmentAuditTrail(String FacDep) throws InterruptedException, Exception{
	
	properties=obj.getProperty();
	Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
	testData.setTestDatainMap(TestDataInMap);	
	Map<String,String> testDataInMap = testData.getTestDatainMap();
	String FacilityName=testDataInMap.get("FacilityName");
	String DepartmentName=testDataInMap.get("Facility+Department");

	
	if(FacDep.equals("FacilityName")){
//		Date
		Robot robot = new Robot(); 
		FromDate.click();
		robot.keyPress(KeyEvent.VK_ENTER);	
		Thread.sleep(2000);	
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);	
	    ToDate.click();
	    robot.keyPress(KeyEvent.VK_ENTER);	
		Thread.sleep(2000);	
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,200)");
		
		
//		Facility
		Thread.sleep(2000);
		facilitydepartmentname.click();
		Thread.sleep(3000);
	    facilitySearch.sendKeys(FacilityName);
		country.sendKeys("United States of America");
		
		Thread.sleep(1000); 
		robot.keyPress(KeyEvent.VK_DOWN);  
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(3000);	
		robot.keyPress(KeyEvent.VK_ENTER);	
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(3000);	
		search2.click();
		Thread.sleep(2000);	
		WebElement DepartmentFacilityRadio=driver.findElement(By.xpath("//table[@id='search-table']/tbody[1]/tr[1]/td[1]/input[1]"));
		DepartmentFacilityRadio.click();
		
		Thread.sleep(2000);
		select1.click();
		Thread.sleep(2000);
		
		
//		FacilitySections
		try{
			if(facilitydepartmentselection.isEnabled()){
			Select facilitydepartmentselection1 = new Select (facilitydepartmentselection);
			facilitydepartmentselection1.selectByVisibleText("Investigational Product (IP) & Controlled Substances");
			}
		}catch(Exception e){
			System.out.println("No");
		}
	}
	
	else if(FacDep.equals("Facility+Department")){
//		Date
		Robot robot = new Robot(); 
		FromDate.click();
		robot.keyPress(KeyEvent.VK_ENTER);	
		Thread.sleep(2000);	
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);	
	    ToDate.click();
	    robot.keyPress(KeyEvent.VK_ENTER);	
		Thread.sleep(2000);	
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,200)");
		
		
//		Facility
		Thread.sleep(2000);
		facilitydepartmentname.click();
		Thread.sleep(3000);
	    facilitySearch.sendKeys(FacilityName);
		country.sendKeys("Brazil");
		
		Thread.sleep(1000); 
		robot.keyPress(KeyEvent.VK_DOWN);  
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(3000);	
		robot.keyPress(KeyEvent.VK_ENTER);	
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(3000);	
		search2.click();
		Thread.sleep(2000);	
		WebElement DepartmentFacilityRadio=driver.findElement(By.xpath("(//a[text()=' "+FacilityName+"']/ancestor::td/preceding-sibling::td/input)[1]"));
		DepartmentFacilityRadio.click();
		
		Thread.sleep(2000);
		select1.click();
		Thread.sleep(2000);
		
		
//		FacilitySections
		try{
			if(facilitydepartmentselection.isEnabled()){
			Select facilitydepartmentselection1 = new Select (facilitydepartmentselection);
			facilitydepartmentselection1.selectByVisibleText("Investigational Product (IP) & Controlled Substances");
			}
		}catch(Exception e){
			System.out.println("No");
		}
	}
	

	
	
//	GenerateReprot
}

	public void FillDetailsUnderAuditTrail() throws Exception{
		 properties=obj.getProperty();
			Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
			testData.setTestDatainMap(TestDataInMap);	
			Map<String,String> testDataInMap = testData.getTestDatainMap();
			
			String Country=testDataInMap.get("CountryField");
			String FacilityName=testDataInMap.get("FacilityName");
			String UserName=testDataInMap.get("UserEmail");
			
		Robot robot = new Robot();  
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,250)");
		
//		Dates
		FromDate.click();
		robot.keyPress(KeyEvent.VK_LEFT);
		robot.keyRelease(KeyEvent.VK_LEFT);
		Thread.sleep(2000);	
		robot.keyPress(KeyEvent.VK_ENTER);	
		Thread.sleep(2000);	
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);	
		
		ToDate.click();
		robot.keyPress(KeyEvent.VK_ENTER);	
		Thread.sleep(2000);	
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		
//		UserName ChangeBy
		
		Thread.sleep(10000);
		changeby.click();
		Thread.sleep(3000);
		UserEmail.sendKeys(UserName);
		Thread.sleep(3000);
		search1.click();
		Thread.sleep(3000);
		radio.click();
		Thread.sleep(6000);
		select.click();
		Thread.sleep(4000);
		
//	FacilityName	
		Thread.sleep(4000);
		facilitydepartmentname.click();
		Thread.sleep(2000);
		facilitySearch.sendKeys(FacilityName);
		Thread.sleep(1000);
		country.sendKeys(Country);
		
		Thread.sleep(2000); 
		robot.keyPress(KeyEvent.VK_DOWN);  
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(1000);	
		robot.keyPress(KeyEvent.VK_ENTER);	
		Thread.sleep(1000);	
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);	
		
		search2.click();
		Thread.sleep(4000);	
		
//		radio1.click();//May change index According to the Facility or department
//		Thread.sleep(6000);	
		
		
		
		WebElement FacilityRadio=driver.findElement(By.xpath("(//a[text()=' "+FacilityName+"']/ancestor::td/preceding-sibling::td/input)[4]"));
		FacilityRadio.click();
		
		Thread.sleep(3000);
		select1.click();
		Thread.sleep(3000);
		
		try{
			if(UserNameSearch.isEnabled()){
				UserNameSearch.click();
				Thread.sleep(3000);
				UserEmail.sendKeys(UserName);
				Thread.sleep(3000);
				search1.click();
				Thread.sleep(3000);;
				radio.click();
				Thread.sleep(3000);
				select.click();
				Thread.sleep(3000);
			}
			
			
		}catch(Exception e){
			System.out.println("No");
		}
		
	
		
	}

	public void clickOnAddButtonForSponser() throws InterruptedException{
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,0)");
        Thread.sleep(3000);
		driver.findElement(By.xpath("(//i[@class='fa fa-plus'])[1]")).click();
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@class,'clear-search-btn-adm button-link-btn')]")).click();
	}
	
	public void clickOnAddButtonForSite() throws InterruptedException{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,0)");
        Thread.sleep(3000);
		driver.findElement(By.xpath("(//i[@class='fa fa-plus'])[1]")).click();
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='button-link-btn cancelBtn']")).click();
	}


	public void Exportasxls() throws Exception
	{

		export.click();
		Thread.sleep(5000);

		XLS.click();
		Thread.sleep(8000);
	




	}


	public void ExportPDF() throws Exception
	{

		export.click();
		Thread.sleep(5000);

		PDF.click();
		Thread.sleep(8000);
		

	}
	
	public void ExportPDFInGeneralReport() throws InterruptedException{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//i[@class='fa fa-download']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//li[@title='PDF']")).click();
		Thread.sleep(8000);
		
		
	}



	public void Navigatetofacilities() throws Exception
	{

		System.out.println("Hii");
		Thread.sleep(3000);
		Actions action=new Actions(driver);
		action.moveToElement(Facility).build().perform();;


		//	Facility.click();
		Thread.sleep(3000);
		MyFacility.click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(3000);

		Highlightelement("F1D12");
		//	Thread.sleep(3000);
		//	Highlightelement("F1D14");
		//	Thread.sleep(3000);
		//	
		//	TakesScreenshot webdriver = null;
		//	TakesScreenshot scrShot =((TakesScreenshot)webdriver);



	}




	public void clickprimarychechbox() throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-500)");
		//Highlightelement("F1");
		Thread.sleep(5000);
		F1.click();
		Thread.sleep(10000);



		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);


	}



	public void Previewcvbutton() throws Exception
	{

		Thread.sleep(5000);

		previewcv.click();
		Thread.sleep(9000);

		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);


	}



	public void Navigatetofacilitys() throws Exception
	{



		Thread.sleep(3000);
		Facility.click();
		Thread.sleep(3000);
		MyFacility.click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(3000);


		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);



	}



	public void NavigateToHomePageBypass(String user) throws Exception
	{
		//System.out.println("test1");
		//    properties= obj.getProperty();
		//   
		//    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		//    testData.setTestDatainMap(TestDataInMap);
		//   
		//    Map<String,String> testDataInMap = testData.getTestDatainMap();
		//    String username = properties.getProperty("usernameByPassLogin");

		//String username = properties.getProperty("application.username");
		sponsorLoginButton.click();
		Thread.sleep(2000);
		String username = user;
		//String username ="franklinsponsoradmin1001@franklin-member-id0";
		usernameTextBox.sendKeys(username);
		Thread.sleep(5000);
		loginButton.click();

		Thread.sleep(15000);

		try{

			okButtonPopUp.click();

		}

		catch(Exception e){

			System.out.print("No Alert");

		}



	}


	public void verifysponsorladingpage() throws Exception
	{



		Thread.sleep(3000);
		workspace.click();
		Thread.sleep(3000);
		viewsposorhomepage.click();
		Thread.sleep(3000);
		Highlightelement("allsponsornews");
		Thread.sleep(3000);


		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);



	}


	public void clcikonviewmoreandverify() throws Exception
	{



		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		viewmore.click();
		Thread.sleep(5000);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		Thread.sleep(4000);



		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);



	}


	public void Print() throws Exception
	{



		Thread.sleep(3000);
		print.click();
		Thread.sleep(7000);



		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	}



	public void exportxls() throws Exception
	{



		Thread.sleep(3000);
		export1.click();
		Thread.sleep(7000);
		excel.click();
		Thread.sleep(7000);



		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	}


	public void exportpdf() throws Exception
	{



		Thread.sleep(3000);
		export1.click();
		Thread.sleep(7000);
		pdf1.click();
		Thread.sleep(7000);



		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	}


	public void exportcsv1() throws Exception
	{



		Thread.sleep(3000);
		export1.click();
		Thread.sleep(7000);
		csv1.click();
		Thread.sleep(7000);



		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	}

	public void ClickOnViewAllTask() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ViewAllTask);
		Thread.sleep(2000);
		ViewAllTask.click();
		
	}

	public void Select_FacilityDepartment_From_SearchBy() throws Exception {
		Actions action=new Actions(driver);
		action.moveToElement(SearchBY).click().build().perform();
		Robot robot = new Robot();  
		Thread.sleep(2000); 
		robot.keyPress(KeyEvent.VK_DOWN);  
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);	
		robot.keyPress(KeyEvent.VK_ENTER);	
		Thread.sleep(2000);	
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);	
	}
	
	@FindBy(how=How.ID, using="site-login-btn")
	public WebElement siteLoginButton_new;

	@FindBy(how=How.XPATH, using="//input[@id='mat-input-0']")
	public WebElement emailTextBox_new;
		
	@FindBy(how=How.XPATH, using="//span[contains(text(),'NEXT')]")
	public WebElement nextButton_new;
	
	@FindBy(how=How.XPATH, using="//input[@id='mat-input-1']")
	public WebElement passwordTextBox_new;
	
	@FindBy(how=How.XPATH, using="//span[contains(text(),'Answer security questions')]//.//preceding-sibling::span")
	public WebElement radioSecurityQuestion_new;
	
	@FindBy(how=How.XPATH, using="//input[@id='mat-input-2']")
	public WebElement ans1TextBox_new;
	
	@FindBy(how=How.XPATH, using="//input[@id='mat-input-3']")
	public WebElement ans2TextBox_new;

	
	public void NavigateToHomePageSiteUser(int i) throws Exception {

		siteLoginButton_new.click();
		Thread.sleep(8000);

		properties = obj.getProperty();

		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),
				properties.getProperty("sheetName"), properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);
		
		Map<String, String> testDataInMap = testData.getTestDatainMap();
		String Username = testDataInMap.get("SiteUser"+i+"_Email");
		String Password = "";
		if(i==1)
		{
			Password = testDataInMap.get("Password_"+i);
		}
		else
		{
			Password = testDataInMap.get("Password_1_SiteUser_"+i);
		}
		String Answer1 = testDataInMap.get("Question1_SiteUser_"+i);
		String Answer2 = testDataInMap.get("Question2_SiteUser_"+i);

		emailTextBox_new.sendKeys(Username);
		nextButton_new.click();
		Thread.sleep(6000);

		passwordTextBox_new.sendKeys(Password);
		nextButton_new.click();
		Thread.sleep(10000);

		radioSecurityQuestion_new.click();
		nextButton_new.click();
		Thread.sleep(10000);

		ans1TextBox_new.sendKeys(Answer1);
		Thread.sleep(5000);
		ans2TextBox_new.sendKeys(Answer2);
		Thread.sleep(5000);

		nextButton_new.click();
		Thread.sleep(5000);

		System.out.println("Site user "+i+" logged in successfully");
	}
}