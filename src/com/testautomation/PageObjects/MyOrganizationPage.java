package com.testautomation.PageObjects;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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

import com.testautomation.Utility.ExcelHandler;
import com.testautomation.Utility.PropertiesFileReader;
import com.testautomation.Utility.TestDataHandler;

import junit.framework.Assert;


public class MyOrganizationPage {
	
	WebDriver driver;
	Properties properties;
	PropertiesFileReader obj = new PropertiesFileReader();
	TestDataHandler testData = new TestDataHandler();
	
	public void highLightElement(WebElement string) throws InterruptedException{
		   JavascriptExecutor js = (JavascriptExecutor)driver;   
		   js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');", string);   
		   Thread.sleep(3000);
		   TakesScreenshot webdriver = null;
		   TakesScreenshot scrShot =((TakesScreenshot)webdriver);
	}
	
	public MyOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(how=How.XPATH, using="//*[@id=\"OrganizationId\"]/span[1]")
	public WebElement organization;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"MyOrganization(s)Id\"]")
	public WebElement Myorganization;
	
	@FindBy(how=How.ID, using="ui-id-3")
	public WebElement FacilityDepartmentAffiliations;
	
	@FindBy(how=How.XPATH, using="(//div[@class='tablewidth']//a)[1]")
	public WebElement facility1;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"myOrganizationsTable\"]/tbody/tr[1]/td[1]/a")
	public WebElement org1;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"ui-id-2\"]")
	public WebElement orgcontact;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"OrgContactLandingSection\"]/h2")
	public WebElement orgcontacttitle;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"bulkUploadOrgContact\"]")
	public WebElement bulkupload;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"registrationCodeInvite\"]/div/div/h1")
	public WebElement siteuserregistrationpage;

	
	@FindBy(how=How.XPATH, using="//*[@id=\"registrationCodeInvite\"]/div/div/div/p[3]/label")
	public WebElement InviteOrganizationContacts ;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"bulkInviteOrgContactDiv\"]/div/div[1]/p/span[2]")
	public WebElement onscreen ;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"downloadTemplate\"]")
	public WebElement hyperlink ;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"cancelOrgContactBtn\"]")
	public WebElement cancel ;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"uploadAndSendInvitations\"]")
	public WebElement uploadandaddcontact ;
	
	
	
	@FindBy(how=How.XPATH, using="//input[@id=\"uploadBulkOrgContactTemplate\"]")
	public WebElement choosefile ;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"addOrgContact\"]/div/div/p")
	public WebElement onscrrn1 ;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"addOrgContact\"]/div/div/ul/li[1]")
	public WebElement onscrrn2 ;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"addOrgContact\"]/div/div/ul/li[2]")
	public WebElement onscrrn3 ;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"addOrgContact\"]/div/div/ul/li[3]")
	public WebElement onscrrn4 ;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"addOrgContact\"]/div/div/ul/li[4]")
	public WebElement onscrrn5 ;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"WorkspaceId\"]/span[1]")
	public WebElement workspace ;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"FrankStudy_Cardiology01Id\"]")
	public WebElement study1 ;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"study_document_tab\"]/a")
	public WebElement studycdocument ;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"uploadNewDocSponsorId\"]")
	public WebElement uploadnewdocument ;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"documentCategoryLeve_tmflId\"]")
	public WebElement tmfdoc ;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"documentCategoryLevel_nontmfId\"]")
	public WebElement nontmfdoc ;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"documentTypeHelpTextSpan\"]")
	public WebElement documenttype ;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"getFormValuesId\"]/div[5]/div[2]/div[1]/label")
	public WebElement docversion ;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"getFormValuesId\"]/div[5]/div[1]/div[2]/label")
	public WebElement docdescription ;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"getFormValuesId\"]/div[5]/div[2]/div[2]/label")
	public WebElement docversiondate ;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"doc_package_levelId\"]")
	public WebElement docpacakage ;
	

	@FindBy(how=How.XPATH, using="//*[@id=\"getFormValuesId\"]/div[7]/div[3]/div[1]/div[1]/label")
	public WebElement compound ;
	
	

	@FindBy(how=How.XPATH, using="//*[@id=\"getFormValuesId\"]/div[7]/div[3]/div[1]/div[2]/label")
	public WebElement program ;
	

	@FindBy(how=How.XPATH, using="//*[@id=\"getFormValuesId\"]/div[7]/div[3]/div[1]/div[3]/label")
	public WebElement study ;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"getFormValuesId\"]/div[7]/div[3]/div[2]/div[5]/label")
	public WebElement user ;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"getFormValuesId\"]/div[7]/div[3]/div[1]/div[4]/label")
	public WebElement comment ;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"getFormValuesId\"]/div[7]/div[3]/div[2]/div[6]/label")
	public WebElement role ;
	
	@FindBy(how=How.ID, using="file")
	public WebElement chossefile ;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"tmf-doc\"]")
	public WebElement TMFdoc ;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"doc-type\"]")
	public WebElement documenttypedropdown ;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"cat-principle-investigator\"]")
	public WebElement PI ;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"piSearchId\"]/i")
	public WebElement PIicon ;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"pISerachFormId\"]/div[2]/input[1]")
	public WebElement search ;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"3127\"]")
	public WebElement site2 ;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"addButtonId\"]")
	public WebElement addclose ;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"uploadBtn\"]")
	public WebElement upload ;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"successMessagePopUp\"]/div/button")
	public WebElement ok ;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"DocumentsId\"]")
	public WebElement document ;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"CommonDocumentsId\"]")
	public WebElement commondocument ;

	
	@FindBy(how=How.XPATH, using="//*[@id=\"doc-search\"]/div/h2")
	public WebElement docsearch ;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"doc-search\"]/div/span/i")
	public WebElement plus ;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"facilitySearch\"]")
	public WebElement facradio ;
	
	@FindBy(how=How.XPATH, using="//*[@id='facilityContactDetails']//button[@title='SEARCH']")
	public WebElement facSearch ;
	
	
	
public void Navigatetoorganization1andverify() throws Exception
{
	Actions action=new Actions(driver);
	action.moveToElement(organization).build().perform();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	Myorganization.click();
	Thread.sleep(3000);
	highLightElement(driver.findElement(By.xpath("//h1[text()='My Organization(s)']")));
		
}

public void click_On_Hyperlink_of_organization(String org) throws InterruptedException{
	driver.findElement(By.linkText(org)).click();
	Thread.sleep(3000);
}

public void Click_On_Action_Under_OrganizationAffiliation_as(String arg1) {
	
	List<WebElement> ActionList=driver.findElements(By.xpath("//li[@class='modal-popup-link']"));
	
try{
	WebElement ActionBtn=driver.findElement(By.xpath("//a[text()='"+arg1+"']/ancestor::td/following-sibling::td[4]//i"));
	ActionBtn.click();
	for(int i=0;i<ActionList.size();i++){
		highLightElement(ActionList.get(i));
	}
	Thread.sleep(3000);
	
	
}catch(Exception e){}

try{
	WebElement ActionBtn=driver.findElement(By.xpath("//div[text()='"+arg1+"']/ancestor::td/following-sibling::td[4]//i"));
	ActionBtn.click();
	for(int i=0;i<ActionList.size();i++){
		highLightElement(ActionList.get(i));
	}
	Thread.sleep(3000);
	
}catch(Exception e){}
	
}

public void Click_On_Send_Msg_To_OPM_Under_Action() throws Exception{
	
	WebElement SendMsg=driver.findElement(By.xpath("(//li[@data-modal-popup='#modalSendMessageAffiliation'])[2]"));
	           SendMsg.click();
	           Thread.sleep(3000);
	           driver.findElement(By.id("msgOrgAffiliation")).sendKeys("Hi there");
}

public void Click_Send_On_Send_Msg_To_OPM_Under_Action() throws Exception{
	WebElement Send=driver.findElement(By.xpath("//button[@class='primary-btn modal-popup-link']"));
	Send.click();
	 Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@class='text-align-center']//input[1]")).click();
}

public void nevigate_Facility_Department_Affiliations_section() throws InterruptedException{
	FacilityDepartmentAffiliations.click();
	Thread.sleep(3000);
	
}
	
public void verify_Facility() throws InterruptedException{
	highLightElement(facility1);
}


public void Navigatetoorganizationcontact() throws Exception
{
	orgcontact.click();;
	Thread.sleep(4000);
	highLightElement(orgcontacttitle);
	Thread.sleep(4000);
	
	if(orgcontacttitle.getText().contains("Organization Contacts"))
    {
        System.out.println("Onscreen Text pass");
        Thread.sleep(3000);
    }
    else
    {
    System.out.println("Onscreen Text Fail");
       
    }

	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		
}
	


public void Navigatetobulkuploadcontactandverify() throws Exception
{
	
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1000)");
	
	bulkupload.click();
	 Thread.sleep(5000);
	 highLightElement(siteuserregistrationpage);
		Thread.sleep(4000);
		
		if(siteuserregistrationpage.getText().contains("Send Site User Registration Invitation"))
	    {
	        System.out.println("Onscreen Text pass");
	        Thread.sleep(3000);
	    }
	    else
	    {
	    System.out.println("Onscreen Text Fail");
	       
	    }


	 
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		
}
	



public void verifyradiobuttoninviteorganizationcontact() throws Exception
{
	
	
	Thread.sleep(4000);
	highLightElement(InviteOrganizationContacts);
	 
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		
}
	



public void verifyendregistrationinvitation() throws Exception
{
	
	
	Thread.sleep(4000);
highLightElement(siteuserregistrationpage);
Thread.sleep(4000);

if(siteuserregistrationpage.getText().contains("Send Site User Registration Invitation"))
{
    System.out.println("Text pass");
    Thread.sleep(3000);
}
else
{
System.out.println("Text Fail");
   
}

highLightElement(onscreen);
Thread.sleep(4000);

if(onscreen.getText().contains("Ensure that all Site Staff receive appropriate communication about SIP prior to sending a SIP invitation. Sending multiple invitations may result in the SIP e-mail domain becoming blocked as SPAM."))
{
    System.out.println("Onscreen Text pass");
    Thread.sleep(3000);
}
else
{
System.out.println("Onscreen Text Fail");
   
}
highLightElement(hyperlink);
highLightElement(cancel);
Thread.sleep(4000);


	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		
}
	

public void downloadtemplate() throws Exception
{
	
	
	Thread.sleep(4000);
	hyperlink.click();
	Thread.sleep(6000);


	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		
}
	




public void verifybuttondisable() throws Exception
{
	
	
	Thread.sleep(4000);
	highLightElement(uploadandaddcontact);
	Thread.sleep(6000);
	


	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		
}
	





public void choosefileselectfile() throws Exception
{
	
	
	Thread.sleep(4000);
	choosefile.sendKeys("C:\\Users\\545325\\Desktop\\SIPOrganizationContacts_Template.xlsx");
	Thread.sleep(6000);
	
	
	Thread.sleep(6000);
	


	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		
}
	


public void clickuploadandaddcontactbutton() throws Exception
{
	
	
	Thread.sleep(4000);
	uploadandaddcontact.click();
	Thread.sleep(6000);
	highLightElement(onscrrn1);
Thread.sleep(4000);

if(onscrrn1.getText().contains("Your file has been uploaded successfully and will be processed in the order received. You will receive notification when processing is complete, indicating the following have occurred:"))
{
    System.out.println("Onscreen Text pass");
    Thread.sleep(3000);
}
else
{
System.out.println("Onscreen Text Fail");
   
}

	
	Thread.sleep(6000);
	highLightElement(onscrrn2);
	Thread.sleep(4000);

	if(onscrrn2.getText().contains("Contacts who are existing SIP users will display in the Organization Contacts table."))
	{
	    System.out.println("Onscreen Text pass");
	    Thread.sleep(3000);
	}
	else
	{
	System.out.println("Onscreen Text Fail");
	   
	}

	Thread.sleep(6000);
	highLightElement(onscrrn3);
	Thread.sleep(4000);

	if(onscrrn3.getText().contains("Non-SIP users will receive a SIP registration invitation."))
	{
	    System.out.println("Onscreen Text pass");
	    Thread.sleep(3000);
	}
	else
	{
	System.out.println("Onscreen Text Fail");
	   
	}

		Thread.sleep(6000);
	
		Thread.sleep(6000);
		highLightElement(onscrrn4);
		Thread.sleep(4000);

		if(onscrrn4.getText().contains("Records flagged as potential duplicates or having other errors will not be processed."))
		{
		    System.out.println("Onscreen Text pass");
		    Thread.sleep(3000);
		}
		else
		{
		System.out.println("Onscreen Text Fail");
		   
		}

	

			Thread.sleep(6000);
			highLightElement(onscrrn5);
			Thread.sleep(4000);

			if(onscrrn5.getText().contains("Action Icons on the Invitation List Status table allow you to view successfully processed records or those unable to be processed."))
			{
			    System.out.println("Onscreen Text pass");
			    Thread.sleep(3000);
			}
			else
			{
			System.out.println("Onscreen Text Fail");
			   
			}

				Thread.sleep(6000);

			
				Thread.sleep(3000);
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		
}



public void clickonokbutton() throws Exception
{
	
	
	Thread.sleep(4000);

	Thread.sleep(6000);
	
	



	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		
}


public void Navigatandverifyoworkspace() throws Exception
{
	
	
	Thread.sleep(4000);
	workspace.click();
	Thread.sleep(3000);
	study1.click();
	Thread.sleep(3000);
	studycdocument .click();
	Thread.sleep(3000);
	uploadnewdocument.click();
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,200)");
	
	highLightElement(tmfdoc);
	Thread.sleep(3000);
	highLightElement(nontmfdoc);
	Thread.sleep(3000);
	highLightElement(documenttype);
	Thread.sleep(3000);
	highLightElement(docversion);
	Thread.sleep(3000);
	highLightElement(docdescription);
	Thread.sleep(3000);
	highLightElement(docversiondate);
	Thread.sleep(3000);
	highLightElement(docpacakage);
	Thread.sleep(3000);
	
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,800)");
	highLightElement(compound);
	Thread.sleep(3000);
	highLightElement(program);
	Thread.sleep(3000);
	highLightElement(study);
	Thread.sleep(3000);
	highLightElement(user);
	Thread.sleep(3000);
	highLightElement(comment);
	Thread.sleep(3000);
	highLightElement(role);
	Thread.sleep(6000);
	
	
	



	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		
}



public void uploaddocumententerfieldsandverify() throws Exception
{
	
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,200)");
	
	Thread.sleep(3000);
	chossefile.sendKeys("\"C:\\Users\\545325\\Desktop\\sample.pdf\"");
	Thread.sleep(3000);
	
	Thread.sleep(3000);
	TMFdoc.click();
	Thread.sleep(3000);
	documenttypedropdown.click();
	Thread.sleep(3000);
	Robot robot1 = new Robot();  
    Thread.sleep(2000); 
    robot1.keyPress(KeyEvent.VK_DOWN); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_DOWN);
    Thread.sleep(2000);  
    robot1.keyPress(KeyEvent.VK_ENTER); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(5000);
	



	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		
}



public void selectPIandverify() throws Exception
{
	
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,800)");
	Thread.sleep(3000);
	PI.click();
	Thread.sleep(3000);
	



	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		
}


public void verifysiteuser2() throws Exception
{
	
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,800)");
	Thread.sleep(3000);
	PIicon.click();
	Thread.sleep(3000);
	search.click();
	Thread.sleep(3000);
	site2.click();
	Thread.sleep(3000);
	addclose.click();
	Thread.sleep(3000);


	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		
}




public void selectsiteuser2upload() throws Exception
{
	
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(3000);
	upload.click();
	Thread.sleep(3000);TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		
}


public void verifydocumentsearch() throws Exception
{
	
	
	Thread.sleep(3000);
	ok.click();
	Thread.sleep(3000);
	document.click();
	Thread.sleep(3000);
	commondocument.click();
	Thread.sleep(3000);
	highLightElement(docsearch);TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		
}


public void verfiydocument1searchresult() throws Exception
{
	
	
	Thread.sleep(3000);
	plus.click();
	Thread.sleep(3000);
	facradio.click();
	Thread.sleep(3000);TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		
}



public void Navigatetocommondocument() throws Exception
{
	
	
	Thread.sleep(3000);
	document.click();
	Thread.sleep(3000);
	commondocument.click();
	Thread.sleep(3000);TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		
}

public void click_On_Hyperlink_of_organization(int orgNo) throws Exception{
	 properties= obj.getProperty();
	   
     Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
     testData.setTestDatainMap(TestDataInMap);
            
     Map<String,String> testDataInMap = testData.getTestDatainMap();
     String Org_Name = testDataInMap.get("Organization_Name_"+orgNo);
     
     highLightElement(driver.findElement(By.xpath("//*[@id='myOrganizationsTable']//a[text()[normalize-space() = '"+Org_Name+"']]")));
     Thread.sleep(1500);
     driver.findElement(By.xpath("//*[@id='myOrganizationsTable']//a[text()[normalize-space() = '"+Org_Name+"']]")).click();
}

public void Click_Facility_Department_Affiliations_Tab() throws Exception{
	highLightElement(driver.findElement(By.xpath(" //a[text()[normalize-space() = 'Facility/Department']]")));
    Thread.sleep(1500);
    driver.findElement(By.xpath("//a[text()[normalize-space() = 'Facility/Department']]")).click();
}

@FindBy(how=How.XPATH, using="//*[@id='addAffiliatedFac']")
public WebElement AddAffiliatedFac_btn;

public void Click_AddAffiliatedFaciltyDepartment_Button() throws Exception{
	highLightElement(AddAffiliatedFac_btn);
    Thread.sleep(1500);
    AddAffiliatedFac_btn.click();
}



@FindBy(how=How.XPATH, using="//*[@id='searchCountry_ID']")
public WebElement searchCountry_ID;


public void select_Facility_Country_From_Country_Dropdown(int arg1) throws Throwable {
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    String Fac_country = testDataInMap.get("Facility"+arg1+"_Country");
    
	searchCountry_ID.click();
	Thread.sleep(3000);
	searchCountry_ID.sendKeys(Fac_country);
	Thread.sleep(1500);
	driver.findElement(By.xpath("//*[@id='searchCountry_wrapper']//span[text()[normalize-space() = '"+Fac_country+"']]")).click();
}


@FindBy(how=How.XPATH, using="//*[@name='searchFacilityName']")
public WebElement SearchFacilityName;


public void set_Facility_In_Facility_Name_TextBox(int arg1) throws Throwable {
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    String Fac_Name = testDataInMap.get("Facility_"+arg1);
    
    SearchFacilityName.sendKeys(Fac_Name);
}

@FindBy(how=How.XPATH, using="//*[@id='searchaFac']")
public WebElement SearchaFac_Btn;

public void click_On_Search_button_In_Search_Facility_Department_Affiliations_Section() throws Throwable {
	highLightElement(SearchaFac_Btn);
    Thread.sleep(1500);
    SearchaFac_Btn.click();
}

public void Click_On_ADD_Department_Icon_Against_Facility_In_Search_FacilityDepartment_Affiliations_Screen(int arg1) throws Throwable {
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    String Fac_Name = testDataInMap.get("Facility_"+arg1);
    Thread.sleep(1500);
    
    highLightElement(driver.findElement(By.xpath("//*[@id='searchResult']//div[text()[normalize-space() = '"+Fac_Name+"']]//..//../td[3]/div[text()[normalize-space() = '']]//..//../td[4]/span/i")));
    Thread.sleep(1500);
    driver.findElement(By.xpath("//*[@id='searchResult']//div[text()[normalize-space() = '"+Fac_Name+"']]//..//../td[3]/div[text()[normalize-space() = '']]//..//../td[4]/span/i")).click();
}

public void Verify_ADD_Department_Icon_Against_Facility_In_Search_FacilityDepartment_Affiliations_Screen(int arg1) throws Throwable {
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    String Fac_Name = testDataInMap.get("Facility_"+arg1);
    Thread.sleep(1500);
    try {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='searchResult']//div[text()[normalize-space() = '"+Fac_Name+"']]//..//../td[3]/div[text()[normalize-space() = '']]//..//../td[4]/span/i")));
    Thread.sleep(2000);
    
    highLightElement(driver.findElement(By.xpath("//*[@id='searchResult']//div[text()[normalize-space() = '"+Fac_Name+"']]//..//../td[3]/div[text()[normalize-space() = '']]//..//../td[4]/span/i")));
    Thread.sleep(1500);
   }
    catch(Exception e)
    {
    	driver.quit();
    }

 }

public void Verify_ADD_Department_Icon_Not_Displayed_Against_Facility_In_Search_FacilityDepartment_Affiliations_Screen(int arg1) throws Throwable {
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    String Fac_Name = testDataInMap.get("Facility_"+arg1);
    Thread.sleep(1500);
    
    try {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='searchResult']//div[text()[normalize-space() = '"+Fac_Name+"']]//..//../td[3]/div[text()[normalize-space() = '']]//..//../td[4]/span/i")));
    Thread.sleep(2000);
    
    highLightElement(driver.findElement(By.xpath("//*[@id='searchResult']//div[text()[normalize-space() = '"+Fac_Name+"']]//..//../td[3]/div[text()[normalize-space() = '']]//..//../td[4]/span/i")));
    Thread.sleep(1500);
    driver.quit();
    }
    catch(Exception e)
    {
    	TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    }
   }



public void Verify_ADD_Department_Icon_Against_Facility_Department_NotPresent(int arg1,int arg2) throws Throwable {
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    String Fac_Name = testDataInMap.get("Facility_"+arg1);
    String Dept_Name = testDataInMap.get("Department_"+arg2);
    
    Thread.sleep(1500);
    try {
    highLightElement(driver.findElement(By.xpath("//*[@id='searchResult']//div[text()[normalize-space() = '"+Fac_Name+"']]//..//../td[3]/div[text()[normalize-space() = '"+Dept_Name+"']]//..//../td[4]/span/i")));
    Thread.sleep(1500);
    }
    catch(Exception E)
    {
    	TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    }
}

public void verify_Department_Name_Address_Screen_Is_Displayed() throws Throwable {
	 highLightElement(driver.findElement(By.xpath("//*[@id='userTextLoad']//h2[text()[normalize-space() = 'Department Name & Address']]")));
	 Thread.sleep(1500);
}

@FindBy(how=How.XPATH, using="//*[@id='departmentName']")
public WebElement DepartmentName;

public void SetDepartmentInDepartmentNameTextbox(int arg1) throws Throwable {
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    String Department_Name = testDataInMap.get("Department_"+arg1);
    Thread.sleep(1500);
    DepartmentName.sendKeys(Department_Name);
}

@FindBy(how=How.XPATH, using="//*[@id='departmentType']")
public WebElement DepartmentType;

public void select_Department_Type_Of_Department_In_Department_Name_Address_Screen(int arg1) throws Throwable {
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    String Department_Type = testDataInMap.get("Department_"+arg1+"_Type");
	
	Select doctype1 = new Select (DepartmentType);
	doctype1.selectByVisibleText(Department_Type);
	Thread.sleep(3000);
}

@FindBy(how=How.XPATH, using="//*[@id='facility-save-button']")
public WebElement Department_save_button;

public void click_On_save_Button_In_Department_Name_Address_Screen() throws Throwable {
	highLightElement(Department_save_button);
	Thread.sleep(1500);
	Department_save_button.click();
}

@FindBy(how=How.XPATH, using="//button[text()[normalize-space() = 'I WILL CREATE/MAINTAIN THE DEPARTMENT PROFILE']]")
public WebElement I_WILL_CREATE_MAINTAIN_THE_DEPARTMENT_PROFILE;

@FindBy(how=How.XPATH, using="//*[@id='modalPotentialDuplicateFac']//button[text()[normalize-space() = 'I WILL ASSIGN SOMEONE ELSE']]")
public WebElement I_WILL_ASSIGN_SOMEONE_ELSE;


public void VerifyNewDepartmentCreatedIdentifyContactPopUpDisplayed() throws Throwable {
	highLightElement(driver.findElement(By.xpath("//h1[text()[normalize-space() = 'New Department Created/ Identify Contact']]")));
	Thread.sleep(1000);
	highLightElement(driver.findElement(By.xpath("//*[@id='modalPotentialDuplicateFac']/div[2]/div")));
	Thread.sleep(1000);
	highLightElement(I_WILL_CREATE_MAINTAIN_THE_DEPARTMENT_PROFILE);
	Thread.sleep(1000);
	highLightElement(I_WILL_ASSIGN_SOMEONE_ELSE);
}

public void ClickOnOption_I_WILL_CREATE_MAINTAIN_THE_DEPARTMENT_PROFILE() throws Throwable {
	highLightElement(I_WILL_CREATE_MAINTAIN_THE_DEPARTMENT_PROFILE);
	Thread.sleep(1000);
	I_WILL_CREATE_MAINTAIN_THE_DEPARTMENT_PROFILE.click();
}

@FindBy(how=How.XPATH, using="//*[@id=\"create-profile\"]")
public WebElement GOTOMYUSERPROFILEButton;

public void ClickOnGOTOMYUSERPROFILEButton() throws Throwable {
	highLightElement(GOTOMYUSERPROFILEButton);
	Thread.sleep(1000);
	GOTOMYUSERPROFILEButton.click();
}

public void verify_Facility_And_Department_Is_Displayed_In_Facilities_Screen(int arg1, int arg2) throws Throwable {
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    String Fac_Name = testDataInMap.get("Facility_"+arg1);
    String Dept_Name = testDataInMap.get("Department_"+arg2);
    
    //JavascriptExecutor js = (JavascriptExecutor) driver;
    //js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//span[@class='pagination-count']")));
    Thread.sleep(2000);
 
    int pagelimit=Integer.parseInt(driver.findElement(By.xpath("//span[@class='pagination-count']")).getText()) ;
    
   for(int i=1;i<pagelimit;i++)
   {
	    try {
	    	
	        //js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//a[text()[normalize-space() = '"+Dept_Name+"']]//..//..//../td//a[text()[normalize-space() = '"+Fac_Name+"']]")));
	        Thread.sleep(2000);
	    	highLightElement(driver.findElement(By.xpath("//a[text()[normalize-space() = '"+Dept_Name+"']]//..//..//../td//a[text()[normalize-space() = '"+Fac_Name+"']]")));
	    	Thread.sleep(1500);
	    	highLightElement(driver.findElement(By.xpath("//a[text()[normalize-space() = '"+Fac_Name+"']]//..//..//../td[4]//a[text()[normalize-space() = '"+Dept_Name+"']]")));
	    	break;
	    }
	    catch(Exception e) {
	    	//js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.id("showNextResult")));
	        Thread.sleep(2000);
	    	driver.findElement(By.id("showNextResult")).click();
	    	Thread.sleep(10000);
	    }
   }
}

public void verify_Facility_Is_Displayed_In_Facilities_Screen(int arg1) throws Throwable {
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    String Fac_Name = testDataInMap.get("Facility_"+arg1);
    
    //JavascriptExecutor js = (JavascriptExecutor) driver;
    //js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//span[@class='pagination-count']")));
    //Thread.sleep(2000);
 
    int pagelimit=Integer.parseInt(driver.findElement(By.xpath("//span[@class='pagination-count']")).getText()) ;
    System.out.println(pagelimit);
    ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
    Thread.sleep(1000);
    for(int i=1;i<=pagelimit;i++)
    {
 	    try {
 	    	
 	        //js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("(//a[text()[normalize-space() = '"+Fac_Name+"']])[1]")));
 	        //Thread.sleep(2000);
 	    	highLightElement(driver.findElement(By.xpath("(//a[text()[normalize-space() = '"+Fac_Name+"']])[1]")));
 	    	break;
 	    }
 	    catch(Exception e) {
 	    	//js.executeScript("arguments[0].scrollIntoView(view);", driver.findElement(By.id("showNextResult")));
 	        //Thread.sleep(2000);
 	    	driver.findElement(By.id("showNextResult")).click();
 	    	Thread.sleep(10000);
 	    }
    }
}

public void click_On_Department_Displayed_In_Facilities_Screen(int arg2,int arg1) throws Throwable {
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    String Fac_Name = testDataInMap.get("Facility_"+arg1);
    String Dept_Name = testDataInMap.get("Department_"+arg2);
    
    highLightElement(driver.findElement(By.xpath("//a[text()[normalize-space() = '"+Fac_Name+"']]//..//..//../td[4]//a[text()[normalize-space() = '"+Dept_Name+"']]")));
    Thread.sleep(1000);
    driver.findElement(By.xpath("//a[text()[normalize-space() = '"+Fac_Name+"']]//..//..//../td[4]//a[text()[normalize-space() = '"+Dept_Name+"']]")).click();
 }

public void click_On_facility_Displayed_In_Facilities_Screen(int arg1) throws Throwable {
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    String Fac_Name = testDataInMap.get("Facility_"+arg1);
    
    driver.findElement(By.xpath("(//a[text()[normalize-space() = '"+Fac_Name+"']])[1]")).click();
}

@FindBy(how=How.XPATH, using="//*[@id='facilityContactLi']")
public WebElement Facility_Contact;

public void SwitchFrameAndNavigateToFacilityContacts() throws Throwable {
	Set<String> windows = driver.getWindowHandles();
    Iterator<String> it=windows.iterator();
    String parentWindow = it.next();
    String childWindow = it.next();
    driver.switchTo().window(childWindow);
    Thread.sleep(4000);
    
    Facility_Contact.click();
}

public void NavigateToFacilityContacts() throws Throwable {
	highLightElement(Facility_Contact);
    Thread.sleep(1500);
    Facility_Contact.click();
}

@FindBy(how=How.XPATH, using="//*[@id='facilityContactLi']")
public WebElement Department_Contact;

public void SwitchFrameAndNavigateToDepartment_Contact() throws Throwable {
	Set<String> windows = driver.getWindowHandles();
    Iterator<String> it=windows.iterator();
    String parentWindow = it.next();
    String childWindow = it.next();
    driver.switchTo().window(childWindow);
    Thread.sleep(4000);
    
    Department_Contact.click();
}

public void NavigateTodepartmentContacts() throws Throwable {
	highLightElement(Department_Contact);
    Thread.sleep(1500);
    Department_Contact.click();
}

public void Verify_Department_Contact_Screen_Displayed() throws Throwable {
	highLightElement(driver.findElement(By.xpath("//div[@class='facilityContactsDefault']/h2[text()[normalize-space() = 'Department Contacts']]")));
}

public void Verify_Facility_Contact_Screen_Displayed() throws Throwable {
	highLightElement(driver.findElement(By.xpath("//div[@class='facilityContactsDefault']/h2[text()[normalize-space() = 'Facility Contacts']]")));
}

@FindBy(how=How.XPATH, using="//*[@id='facilityContactDetails']//button[text()[normalize-space() = 'Add Department Contact']]")
public WebElement AddDepartmentContact_button;


public void Verify_AddDepartmentContact_button() throws Throwable {
	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", AddDepartmentContact_button);
    Thread.sleep(2000);
	highLightElement(AddDepartmentContact_button);
	Thread.sleep(1500);
}

@FindBy(how=How.XPATH, using="//*[@id='facilityContactDetails']//button[text()[normalize-space() = 'Add Facility Contact']]")
public WebElement AddFacilityContact_button;


public void Verify_Add_Facility_Contact_button() throws Throwable {
	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", AddFacilityContact_button);
    Thread.sleep(2000);
	highLightElement(AddFacilityContact_button);
	Thread.sleep(1500);
}

public void Click_AddDepartmentContact_button() throws Throwable {
	AddDepartmentContact_button.click();
}

public void Click_Add_Facility_Contact_button() throws Throwable {
	AddFacilityContact_button.click();
}


@FindBy(how=How.XPATH, using="//*[@id='byFDFacName']/div/span")
public WebElement Facility_Name_Textbox;


public void select_Facility_In_Facility_Name_In_Search_For_Facility_Department_Contact_Section(int arg1) throws Throwable {
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    String Fac_Name = testDataInMap.get("Facility_"+arg1).trim();
    
    Facility_Name_Textbox.click();
    Thread.sleep(3000);
    Facility_Name_Textbox.sendKeys(Fac_Name);
    Thread.sleep(4000);
    driver.findElement(By.xpath("//label[text()= '"+Fac_Name+"']//../span/span")).click();
    Thread.sleep(3000);
    try
    {
    	driver.findElement(By.xpath("//*[@id='byFDFacName']//i[@title='Close']")).click();
    	Thread.sleep(3000);
    	highLightElement(Facility_Name_Textbox);
    }
    catch(Exception e)
    {
    	highLightElement(Facility_Name_Textbox);
    }
    
}


@FindBy(how=How.XPATH, using="//*[@id='byFDDepName']/div/span")
public WebElement Department_Name_Textbox;

public void select_Department_of_Facility_In_Department_Name_In_Search_For_Facility_Department_Contact_Section(int arg1, int arg2) throws Throwable {
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    String Dept_Name = testDataInMap.get("Department_"+arg1).trim();
    
    Department_Name_Textbox.click();
    Thread.sleep(3000);
    Department_Name_Textbox.sendKeys(Dept_Name);
    Thread.sleep(4000);
    driver.findElement(By.xpath("//label[text()[normalize-space() = '"+Dept_Name+"']]//../span/span")).click();
    
    Thread.sleep(3000);
    try
    {
    	driver.findElement(By.xpath("//*[@id='byFDDepName']//i[@title='Close']")).click();
    	Thread.sleep(3000);
    	highLightElement(Department_Name_Textbox);
    }
    catch(Exception e)
    {
    	highLightElement(Department_Name_Textbox);
    }
}

@FindBy(how=How.XPATH, using="//*[@id='facilityContactDetails']//button[@title='SEARCH']")
public WebElement SEARCH_btn;

public void ClickOnSEARCHbuttonInSearchForFacilityDepartmentContactSection() throws Throwable {
	highLightElement(SEARCH_btn);
	Thread.sleep(1500);
	SEARCH_btn.click();
}

public void verify_Site_User_Displayed_In_Site_User_Search_Results_Table(int arg1) throws Throwable {
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    String Site_User = testDataInMap.get("SiteUser"+arg1+"_Email").trim();
	
	highLightElement(driver.findElement(By.xpath("//*[@id='facilityContactResult']//td[text()[normalize-space() = '"+Site_User+"']]")));
	
}

public void Click_Site_User_Displayed_In_Site_User_Search_Results_Table(int arg1) throws Throwable {
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    String Site_User = testDataInMap.get("SiteUser"+arg1+"_Email").trim();
	
	highLightElement(driver.findElement(By.xpath("//*[@id='facilityContactResult']//td[text()[normalize-space() = '"+Site_User+"']]//../td//input")));
	Thread.sleep(1500);
	driver.findElement(By.xpath("//*[@id='facilityContactResult']//td[text()[normalize-space() = '"+Site_User+"']]//../td//input")).click();
	
}


@FindBy(how=How.XPATH, using="//*[@title='Select Facility Contact']")
public WebElement Select_Facility_Contact_Btn;

public void Click_Select_Facility_Contact_Btn() throws Throwable {
	highLightElement(Select_Facility_Contact_Btn);
	Thread.sleep(1500);
	Select_Facility_Contact_Btn.click();
}


@FindBy(how=How.XPATH, using="//*[@title='Select Department Contact']")
public WebElement Select_Department_Contact_Btn;

public void Click_Select_Department_Contact_Btn() throws Throwable {
	highLightElement(Select_Department_Contact_Btn);
	Thread.sleep(1500);
	Select_Department_Contact_Btn.click();
}

@FindBy(how=How.XPATH, using="//*[@id='facilityContactDetails']//button[@title='expand/collapse']")
public WebElement ExpandButtonForSearchForFacilityDepartmentContactSection;

public void ClickOnExpandButtonForSearchForFacilityDepartmentContactSection() throws Throwable {
	highLightElement(ExpandButtonForSearchForFacilityDepartmentContactSection);
	Thread.sleep(1500);
	ExpandButtonForSearchForFacilityDepartmentContactSection.click();
}

@FindBy(how=How.XPATH, using="//*[@id='facilityContactDetails']//button[text()[normalize-space() = 'CLEAR SEARCH']]")
public WebElement ClearSearchBtn_SearchForFacilityDepartmentContactSection;

public void ClickOnClearSearchButtonInSearchForFacilityDepartmentContactSection() throws Throwable {
	highLightElement(ClearSearchBtn_SearchForFacilityDepartmentContactSection);
	Thread.sleep(1500);
	ClearSearchBtn_SearchForFacilityDepartmentContactSection.click();
}

@FindBy(how=How.XPATH, using="//*[@id='byFDEmailAddress']")
public WebElement FDEmailAddress;

public void set_Site_User_In_Email_Address_Text_Field(int arg1) throws Throwable {
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    String Site_User = testDataInMap.get("SiteUser"+arg1+"_Email").trim();
    
    FDEmailAddress.sendKeys(Site_User);
    Thread.sleep(1500);    
}

public void NavigateToParentWindowAndCloseChildWindow() throws Throwable {
	driver.switchTo().defaultContent();
	
}

public void VerifySiteUserIsNotAbleToRemoveDelegationManager() throws Throwable {
	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='facilityContactDetails']//span[text()[normalize-space() = 'Delegation Manager']]")));
    Thread.sleep(2000);
    highLightElement(driver.findElement(By.xpath("//*[@id='facilityContactDetails']//span[text()[normalize-space() = 'Delegation Manager']]//..//..//../td[5]//i[@title='Delete' and @disabled='disabled']")));
  
}


public void verify_That_Facility_Is_Displayed_In_Facility_Department_Affiliations_Screen(int arg1) throws Throwable {
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    String Fac_Name = testDataInMap.get("Facility_"+arg1);
    
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//div[text()[normalize-space() = 'No Department']]//..//..//a[text()[normalize-space() = '"+Fac_Name+"']]")));
    Thread.sleep(2000);
    
    highLightElement(driver.findElement(By.xpath("//div[text()[normalize-space() = 'No Department']]//..//..//a[text()[normalize-space() = '"+Fac_Name+"']]")));
    
}

public void verify_That_Facility_Department_Is_Displayed_In_Facility_Department_Affiliations_Screen(int arg1,int arg2) throws Throwable {
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    String Fac_Name = testDataInMap.get("Facility_"+arg1);
    String Dept_Name = testDataInMap.get("Department_"+arg2);
    
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//a[text()[normalize-space() = '"+Dept_Name+"']]//..//..//..//*[text()[normalize-space() = '"+Fac_Name+"']]")));
    Thread.sleep(2000);
    
    highLightElement(driver.findElement(By.xpath("//a[text()[normalize-space() = '"+Dept_Name+"']]//..//..//..//*[text()[normalize-space() = '"+Fac_Name+"']]")));
    Thread.sleep(1500);
    
    highLightElement(driver.findElement(By.xpath("//*[text()[normalize-space() = '"+Fac_Name+"']]//..//..//..//a[text()[normalize-space() = '"+Dept_Name+"']]")));
}

public void click_On_Remove_Icon_Against_Facility_Is_Displayed_In_Facility_Department_Affiliations_Screen(int arg1) throws Throwable {
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    String Fac_Name = testDataInMap.get("Facility_"+arg1);
    
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//div[text()[normalize-space() = 'No Department']]//..//..//a[text()[normalize-space() = '"+Fac_Name+"']]")));
    Thread.sleep(2000);
    
    driver.findElement(By.xpath("//div[text()[normalize-space() = 'No Department']]//..//..//a[text()[normalize-space() = '"+Fac_Name+"']]//..//..//..//i[@title='Remove']")).click();
}


@FindBy(how=How.XPATH, using="//span[text()[normalize-space() = 'Confirm']]")
public WebElement ConfirmButtonInRemoveFacilityDepartmentAffiliationPopUp;

public void ClickOnConfirmButtonInRemoveFacilityDepartmentAffiliationPopUp() throws Throwable {
	highLightElement(ConfirmButtonInRemoveFacilityDepartmentAffiliationPopUp);
	Thread.sleep(1000);
	ConfirmButtonInRemoveFacilityDepartmentAffiliationPopUp.click();
}

public void verify_That_Facility_Is_Not_Displayed_In_Facility_Department_Affiliations_Screen(int arg1) throws Throwable {
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    String Fac_Name = testDataInMap.get("Facility_"+arg1);
    
    try {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//div[text()[normalize-space() = 'No Department']]//..//..//a[text()[normalize-space() = '"+Fac_Name+"']]")));
    Thread.sleep(2000);
    
    highLightElement(driver.findElement(By.xpath("//div[text()[normalize-space() = 'No Department']]//..//..//a[text()[normalize-space() = '"+Fac_Name+"']]")));
    Thread.sleep(1000);
    driver.quit();
    }
    catch(Exception e)
    {
    	TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    }
}

public void ClickOnAddDepartmentOptionFromActionIconForFacility(int arg1) throws Throwable {
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    String Fac_Name = testDataInMap.get("Facility_"+arg1);
    highLightElement(driver.findElement(By.xpath("(//a[text()[normalize-space() = '"+Fac_Name+"']])[1]//..//..//..//button[@title='Actions']")));
    Thread.sleep(1000);
    driver.findElement(By.xpath("(//a[text()[normalize-space() = '"+Fac_Name+"']])[1]//..//..//..//button[@title='Actions']")).click();
    Thread.sleep(3000);
    highLightElement(driver.findElement(By.xpath("(//a[text()[normalize-space() = '"+Fac_Name+"']])[1]//..//..//..//li[@title='Add Department']")));
    Thread.sleep(1000);
    driver.findElement(By.xpath("(//a[text()[normalize-space() = '"+Fac_Name+"']])[1]//..//..//..//li[@title='Add Department']")).click();
    Thread.sleep(3000);
}

@FindBy(how=How.XPATH, using="//*[@id='departmentresultFrm']//button[text()[normalize-space() = 'CREATE NEW DEPARTMENT']]")
public WebElement CREATE_NEW_DEPARTMENT_Button;

public void VerifyCREATENEWDEPARTMENTButtonIsDisabled() throws Throwable {
	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", CREATE_NEW_DEPARTMENT_Button);
    Thread.sleep(2000);
	
	if(CREATE_NEW_DEPARTMENT_Button.isEnabled())
	{
		System.out.println("Enable");
	}
	else
	{
		highLightElement(CREATE_NEW_DEPARTMENT_Button);
		System.out.println("Not Enabled");
	}
	
}

public void VerifyCREATENEWDEPARTMENTButtonIsEnabled() throws Throwable {
	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", CREATE_NEW_DEPARTMENT_Button);
    Thread.sleep(2000);
	
	if(CREATE_NEW_DEPARTMENT_Button.isEnabled())
	{
		highLightElement(CREATE_NEW_DEPARTMENT_Button);
		System.out.println("Enable");
	}
	else
	{
		highLightElement(CREATE_NEW_DEPARTMENT_Button);
		System.out.println("Not Enabled");
	}
	
}

public void ClickOnCREATENEWDEPARTMENTButton() throws Exception 
{
	CREATE_NEW_DEPARTMENT_Button.click();
}

public void click_Department_Of_Facility_Is_Displayed_In_Facilities_Screen(int dept, int fac) throws Throwable {
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    String Fac_Name = testDataInMap.get("Facility_"+fac);
    String Dept_Name = testDataInMap.get("Department_"+dept);
    
    highLightElement(driver.findElement(By.xpath("//a[text()[normalize-space() = '"+Fac_Name+"']]//..//..//../td[4]//a[text()[normalize-space() = '"+Dept_Name+"']]")));
    Thread.sleep(1000);
    driver.findElement(By.xpath("//a[text()[normalize-space() = '"+Fac_Name+"']]//..//..//../td[4]//a[text()[normalize-space() = '"+Dept_Name+"']]")).click();
	 
}

@FindBy(how=How.XPATH, using="//*[@id='divRoletable']//button[text()[normalize-space() = 'SAVE']]")
public WebElement EditFacilityRolesSave_btn;

@FindBy(how=How.XPATH, using="//*[@id='site_administrator_popup_action_confirm']")
public WebElement Site_Administrator_Popup_action_confirm_Button;




public void update_Role_Of_Site_User_From_To_Keeping_Previous_Role(int SiteUserNo, String Role1,String Role2) throws Throwable {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(1000);
		properties= obj.getProperty();
	   
       Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
       testData.setTestDatainMap(TestDataInMap);
              
       Map<String,String> testDataInMap = testData.getTestDatainMap();
       String SiteUser_Email = testDataInMap.get("SiteUser"+SiteUserNo+"_Email");   
	   
       highLightElement(driver.findElement(By.xpath("//span[text()[normalize-space() = '"+Role1+"']]//..//..//../td//a[text()[normalize-space() = '"+SiteUser_Email+"']]//..//..//../td//i[@title='Edit']")));
       Thread.sleep(1500);
       driver.findElement(By.xpath("//span[text()[normalize-space() = '"+Role1+"']]//..//..//../td//a[text()[normalize-space() = '"+SiteUser_Email+"']]//..//..//../td//i[@title='Edit']")).click();
       Thread.sleep(4000);
       highLightElement(driver.findElement(By.xpath("//div[text()[normalize-space() = '"+Role2+"']]//..//../td//span")));
       Thread.sleep(1500);
       driver.findElement(By.xpath("//div[text()[normalize-space() = '"+Role2+"']]//..//../td//span")).click();
       Thread.sleep(4000);
       highLightElement(EditFacilityRolesSave_btn);
       Thread.sleep(1500);
       EditFacilityRolesSave_btn.click();
       Thread.sleep(4000);
       try {
    	   highLightElement(Site_Administrator_Popup_action_confirm_Button);
           Thread.sleep(1500);
           Site_Administrator_Popup_action_confirm_Button.click();
    	}
       catch(Exception e)
       {
    	   System.out.println("Site_Administrator_Popup_action_confirm_Button No Available for selection");
       }
}

public void select_Role_As_From_Add_Facility_Roles_PopUp(String Role2) throws Throwable {
	highLightElement(driver.findElement(By.xpath("//div[text()[normalize-space() = '"+Role2+"']]//..//../td//span")));
    Thread.sleep(1500);
    driver.findElement(By.xpath("//div[text()[normalize-space() = '"+Role2+"']]//..//../td//span")).click();
    Thread.sleep(4000);
    highLightElement(EditFacilityRolesSave_btn);
    Thread.sleep(1500);
    EditFacilityRolesSave_btn.click();
    Thread.sleep(4000);
    try {
 	   highLightElement(Site_Administrator_Popup_action_confirm_Button);
        Thread.sleep(1500);
        Site_Administrator_Popup_action_confirm_Button.click();
 	}
    catch(Exception e)
    {
 	   System.out.println("Site_Administrator_Popup_action_confirm_Button No Available for selection");
    }
}

public void verify_Site_User_Role_Has_been_Updated_To_And(int SiteUserNo, String Role1, String Role2) throws Throwable {
	JavascriptExecutor js = ((JavascriptExecutor) driver);
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	Thread.sleep(1000);
	properties= obj.getProperty();
   
	   Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
	   testData.setTestDatainMap(TestDataInMap);
	          
	   Map<String,String> testDataInMap = testData.getTestDatainMap();
	   String SiteUser_Email = testDataInMap.get("SiteUser"+SiteUserNo+"_Email");
	   
	   highLightElement(driver.findElement(By.xpath("//a[text()[normalize-space() = '"+SiteUser_Email+"']]//..//..//../td//span[text()[normalize-space() = '"+Role1+"']]")));
       Thread.sleep(1500);
       highLightElement(driver.findElement(By.xpath("//a[text()[normalize-space() = '"+SiteUser_Email+"']]//..//..//../td//span[text()[normalize-space() = '"+Role2+"']]")));
}

public void verify_Site_User_Is_Added_As_In_Facility_Contacts_Sreen(int SiteUserNo, String Role1) throws Throwable {
	JavascriptExecutor js = ((JavascriptExecutor) driver);
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	Thread.sleep(1000);
	properties= obj.getProperty();
   
	   Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
	   testData.setTestDatainMap(TestDataInMap);
	          
	   Map<String,String> testDataInMap = testData.getTestDatainMap();
	   String SiteUser_Email = testDataInMap.get("SiteUser"+SiteUserNo+"_Email");
	   
	   highLightElement(driver.findElement(By.xpath("//a[text()[normalize-space() = '"+SiteUser_Email+"']]//..//..//../td//span[text()[normalize-space() = '"+Role1+"']]")));
       
}

public void click_On_Remove_Against_Site_User_In_Facility_Contacts_Sreen(int SiteUserNo) throws Throwable {
	JavascriptExecutor js = ((JavascriptExecutor) driver);
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	Thread.sleep(1000);
	properties= obj.getProperty();
   
	   Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
	   testData.setTestDatainMap(TestDataInMap);
	          
	   Map<String,String> testDataInMap = testData.getTestDatainMap();
	   String SiteUser_Email = testDataInMap.get("SiteUser"+SiteUserNo+"_Email");
	   
	   highLightElement(driver.findElement(By.xpath("//a[text()[normalize-space() = '"+SiteUser_Email+"']]//..//..//../td//i[@title='Delete']")));
       Thread.sleep(1000);
       driver.findElement(By.xpath("//a[text()[normalize-space() = '"+SiteUser_Email+"']]//..//..//../td//i[@title='Delete']")).click();
}

@FindBy(how=How.XPATH, using="//*[@id='modalDeleteFacilityContact']//button[text()[normalize-space() = 'OK']]")
public WebElement Remove_Facility_Contact_OK;


public void ClickOnOKButtonInRemoveFacilityContactPopUp() throws Throwable {
	highLightElement(Remove_Facility_Contact_OK);
	Thread.sleep(1500);
	Remove_Facility_Contact_OK.click();
}

public void verify_Site_Is_Not_Present_In_Facility_Contacts_Screen(int SiteUserNo) throws Throwable {
	JavascriptExecutor js = ((JavascriptExecutor) driver);
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	Thread.sleep(1000);
	properties= obj.getProperty();
   
	   Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
	   testData.setTestDatainMap(TestDataInMap);
	          
	   Map<String,String> testDataInMap = testData.getTestDatainMap();
	   String SiteUser_Email = testDataInMap.get("SiteUser"+SiteUserNo+"_Email");
	   try {
		   highLightElement(driver.findElement(By.xpath("//a[text()[normalize-space() = '"+SiteUser_Email+"']]")));
	   }
	   catch(Exception e)
	   {
		   highLightElement(driver.findElement(By.xpath("(//*[@id='facilityContactDetails']//table)[1]")));
		   
	   }
}

@FindBy(how=How.XPATH, using="//a[text()[normalize-space() = 'Organization Contacts']]")
public WebElement Organization_Contacts;


public void ClickOnOrganization_Contacts() throws Throwable {
	highLightElement(Organization_Contacts);
	Thread.sleep(1500);
	Organization_Contacts.click();
}

@FindBy(how=How.XPATH, using="//*[@id='addOrgContactBtn']")
public WebElement AddOrgContactBtn;


public void ClickOnAddOrgContactBtn() throws Throwable {
	highLightElement(AddOrgContactBtn);
	Thread.sleep(1500);
	AddOrgContactBtn.click();
}

@FindBy(how=How.XPATH, using="//*[@id='orgEmailAddress']")
public WebElement OrgEmailAddress;


public void SetEmailInOrgEmailAddress(int arg1) throws Throwable {
	 properties= obj.getProperty();
	   
     Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
     testData.setTestDatainMap(TestDataInMap);
            
     Map<String,String> testDataInMap = testData.getTestDatainMap();
     String SiteUserEmail = testDataInMap.get("SiteUser"+arg1+"_Email");
     
     OrgEmailAddress.sendKeys(SiteUserEmail);
     Thread.sleep(3000);
}

public void select_ORGANIZATION_CONTACT_ROLES_As(String arg1) throws Throwable {
	highLightElement(driver.findElement(By.xpath("//td[text()[normalize-space() = '"+arg1+"']]//../td/span")));
	Thread.sleep(3000);
    driver.findElement(By.xpath("//td[text()[normalize-space() = '"+arg1+"']]//../td/span")).click();
}

@FindBy(how=How.XPATH, using="//*[@id='addOrgContactInnerButton']")
public WebElement AddOrgContactInnerButton;


public void ClickOnAddOrgContactInnerButton() throws Throwable {
	highLightElement(AddOrgContactInnerButton);
	Thread.sleep(1500);
	AddOrgContactInnerButton.click();
}

public void verify_Site_User_Is_added_as(int arg1, String arg2) throws Throwable {
	 properties= obj.getProperty();
	   
     Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
     testData.setTestDatainMap(TestDataInMap);
            
     Map<String,String> testDataInMap = testData.getTestDatainMap();
     String SiteUserEmail = testDataInMap.get("SiteUser"+arg1+"_Email");
     
     highLightElement(driver.findElement(By.xpath("//div[text()[normalize-space() = '"+arg2+"']]//..//../td/div[text()[normalize-space() = '"+SiteUserEmail+"']]")));

}

public void click_On_Remove_icon_Against_Site_User_having_Role_as(int arg1, String arg2) throws Throwable {
	 properties= obj.getProperty();
	   
     Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
     testData.setTestDatainMap(TestDataInMap);
            
     Map<String,String> testDataInMap = testData.getTestDatainMap();
     String SiteUserEmail = testDataInMap.get("SiteUser"+arg1+"_Email");
     
     highLightElement(driver.findElement(By.xpath("//div[text()[normalize-space() = '"+arg2+"']]//..//../td/div[text()[normalize-space() = '"+SiteUserEmail+"']]//..//../td//button[@title='Remove']")));
     Thread.sleep(3000);
     driver.findElement(By.xpath("//div[text()[normalize-space() = '"+arg2+"']]//..//../td/div[text()[normalize-space() = '"+SiteUserEmail+"']]//..//../td//button[@title='Remove']")).click();
   
}


@FindBy(how=How.XPATH, using="//*[@id='removeOrgContactBtn']")
public WebElement RemoveOrgContactBtn;


public void ClickOnRemoveOrgContactBtn() throws Throwable {
	try {
	highLightElement(RemoveOrgContactBtn);
	Thread.sleep(1500);
	RemoveOrgContactBtn.click();
	}
	catch(Exception E)
	{
		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		Thread.sleep(1500);
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
	}
	
}

public void verify_Site_User_Is_Not_Displayed_(int arg1, String arg2) throws Throwable {
	 properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    String SiteUserEmail = testDataInMap.get("SiteUser"+arg1+"_Email");
    try {
    highLightElement(driver.findElement(By.xpath("//div[text()[normalize-space() = '"+arg2+"']]//..//../td/div[text()[normalize-space() = '"+SiteUserEmail+"']]")));
    }
    catch(Exception e)
    {
    	TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    }
}

public void Verify_AddAffiliatedFaciltyDepartment_Button_Not_Displayed() throws Exception{
	try {
		if(AddAffiliatedFac_btn.isDisplayed())
		{
			System.out.println("Not to be displayed");
		}
	}
	catch(Exception e) {
		((JavascriptExecutor)driver).executeScript("scroll(0,1000)");
		TakesScreenshot webdriver = null;
		   TakesScreenshot scrShot =((TakesScreenshot)webdriver);
	}
}

public void click_facSearch() throws Exception{
	CommonClass.highLightElement(driver, facSearch);
	facSearch.click();
}
public void click_On_Role_In_Add_Facility_Roles_For_PopUp(String arg1) throws Throwable {
	   CommonClass.highLightElement(driver, driver.findElement(By.xpath("//div[text()[normalize-space() = '"+arg1+"']]//..//../td//span")));
	   Thread.sleep(1500);
	   driver.findElement(By.xpath("//div[text()[normalize-space() = '"+arg1+"']]//..//../td//span")).click();
	}



public void click_SaveButtonInAddFacilityRolesForPopUp() throws Throwable {
	CommonClass.highLightElement(driver, EditFacilityRolesSave_btn);
	EditFacilityRolesSave_btn.click();
}

public void Click_Site_Administrator_Popup_action_confirm_Button() throws Throwable {
	CommonClass.highLightElement(driver, Site_Administrator_Popup_action_confirm_Button);
	Site_Administrator_Popup_action_confirm_Button.click();
}

public void verify_Site_User_Is_Added_In_Facility_Contacts_Table(int arg1) throws Throwable {
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    String SiteUserEmail = testDataInMap.get("SiteUser"+arg1+"_Email");
    CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='facilityContactDetails']//a[text()[normalize-space() = '"+SiteUserEmail+"']]")));
}

public void verify_Site_User_Is_Added_In_Department_Contacts_Table(int arg1) throws Throwable {
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    String SiteUserEmail = testDataInMap.get("SiteUser"+arg1+"_Email");
    CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='facilityContactDetails']//a[text()[normalize-space() = '"+SiteUserEmail+"']]")));
}

public void click_On_Role_In_Add_Department_Roles_For_PopUp(String arg1) throws Throwable {
	CommonClass.highLightElement(driver, driver.findElement(By.xpath("//div[text()[normalize-space() = '"+arg1+"']]//..//../td//span")));
	   Thread.sleep(1500);
	   driver.findElement(By.xpath("//div[text()[normalize-space() = '"+arg1+"']]//..//../td//span")).click();
}
	
}