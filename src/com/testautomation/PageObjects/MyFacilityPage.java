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
import org.openqa.selenium.Keys;
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


public class MyFacilityPage {

	WebDriver driver;
	Properties properties;
	PropertiesFileReader obj = new PropertiesFileReader();
	TestDataHandler testData = new TestDataHandler();

	public void highLightElement(WebElement string){
		JavascriptExecutor js = (JavascriptExecutor)driver;   
		js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');", string);   

	}

	public MyFacilityPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(how=How.XPATH, using="//li[@class='active']//a[1]")
	public WebElement SearchFacilityBreadCrumb;

	@FindBy(how=How.XPATH, using="(//h2[@class='medium-header-h2'])[1]")
	public WebElement SearchFacilityHeader;


	@FindBy(how=How.XPATH, using="//input[@value='SEARCH']")
	public WebElement SearchFacilitySearchBtn;
	
	@FindBy(how=How.XPATH, using="//button[@title='SEARCH']")
	public WebElement SearchSponserFacilitySearchBtn;

	@FindBy(how=How.XPATH, using="//input[@value='CLEAR SEARCH']")
	public WebElement SearchFacilityClearBtn;
	
	@FindBy(how=How.XPATH, using="//button[@type='reset']")
	public WebElement SearchSponserFacilityClearBtn;

	@FindBy(how=How.XPATH, using="//label[@class='error']")
	public WebElement SearchFacilityERROR;

	@FindBy(how=How.ID, using="search_CountryList_Id")
	public WebElement SearchFacilityCountryField;
	 
	@FindBy(how=How.ID, using="sponsor_search_CountryList_Id")
	public WebElement SearchSponserFacilityCountryField;

	@FindBy(how=How.ID, using="search_state_Id")
	public WebElement SearchFacilityStateField;
	
	@FindBy(how=How.ID, using="cityName")
	public WebElement SearchFacilitySopnserCityField;

	@FindBy(how=How.ID, using="search_city")
	public WebElement SearchFacilityCityField;

	@FindBy(how=How.ID, using="search_facilityName")
	public WebElement SearchFacilityNameField;
	
	@FindBy(how=How.ID, using="facilityNameText")
	public WebElement SearchSponserFacilityNameField;
	
	@FindBy(how=How.XPATH, using="(//span[@class='site-sel-container tAsite-sel-container'])[1]")
	public WebElement SearchSponserDepartmentType;

	@FindBy(how=How.ID, using="search_sipFacilityId")
	public WebElement SearchSponserFacilitySIPID;
	
	@FindBy(how=How.ID, using="therapeuticAreaListArea")
	public WebElement SearchSponserTherapeuticArea;
	
	@FindBy(how=How.ID, using="subTherapeuticListLabelArea")
	public WebElement SearchSponserSubTherapeuticArea;
	
	@FindBy(how=How.XPATH, using="(//span[@class='site-sel-container tAsite-sel-container'])[4]")
	public WebElement SearchSponserPhase;
	
	@FindBy(how=How.XPATH, using="(//span[@class='site-sel-container tAsite-sel-container'])[5]")
	public WebElement SearchSponserStudyType;
	
	
	@FindBy(how=How.ID, using="addFacilityBtn")
	public WebElement AddFacilityToUser;

	@FindBy(how=How.ID, using="cancelCreateNewFacilityBtn")
	public WebElement SearchFacilityCancelbtn;
	
	

	@FindBy(how=How.XPATH, using="//i[contains(@class,'fa fa-envelope-o')]")
	public WebElement emailIcon;
	
	@FindBy(how=How.XPATH, using="//h1[text()='Add Department(s)']")
	public WebElement AddDepartmentHeader;
	
	@FindBy(how=How.XPATH, using="//button[text()='CREATE NEW DEPARTMENT']")
	public WebElement CreatDepartmentBtn;
	
	@FindBy(how=How.XPATH, using="//button[text()='NO DEPARTMENT']")
	public WebElement NODepartmentBtn;
	
	@FindBy(how=How.ID, using="addDepartmentBtn")
	public WebElement AddDepartmentBtn;
	
	@FindBy(how=How.XPATH, using="(//button[text()='I WILL MAINTAIN THE FACILITY PROFILE'])[1]")
	public WebElement I_WIL_MAINTAIN_THE_FACILITY_PROFILE;
	
	@FindBy(how=How.XPATH, using="//button[text()='I WILL CREATE/MAINTAIN THE DEPARTMENT PROFILE']")
	public WebElement I_WIL_MAINTAIN_THE_DEPARTMENT_PROFILE;
	
	@FindBy(how=How.XPATH, using="//button[text()='GO TO MY USER PROFILE']")
	public WebElement GoToMyUserProfile;
	
	@FindBy(how=How.XPATH, using="(//button[text()='I WILL ASSIGN SOMEONE ELSE'])[1]")
	public WebElement I_WIL_assign_someOneElse;
	
	@FindBy(how=How.XPATH, using="//button[text()='CONTINUE UPDATING THIS DEPARTMENT']")
	public WebElement Countinue_Updating_This_Department;
	
	@FindBy(how=How.XPATH, using="//h2[text()='Populate Department Profile']")
	public WebElement PopulatedDepartmentTitle;
	
	@FindBy(how=How.XPATH, using="//h2[text()='Facilities']")
	public WebElement FacilitiesHeader;
	
	@FindBy(how=How.XPATH, using="//tr[@id='3315']/td[3]/div[1]/a[1]")
	public WebElement FacilityHyperLink;
	
	@FindBy(how=How.XPATH, using="//button[text()='Enter Facility Profile Manually']")
	public WebElement EnterFacilityManuual;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"intermidiateSection\"]/div[2]/button[1]")
	public WebElement EnterDepartmentManuual;
	
	@FindBy(how=How.XPATH, using="(//span[contains(@class,'display-inline-block marLeft5')])[2]")
	public WebElement FacilityContact;
	
	
	
	
	
	

	@FindBy(how=How.XPATH, using="//p[contains(text(),'Add Facilities and affiliated Departments where')]")
	public WebElement onscreentext;



	@FindBy(how=How.XPATH, using="//div[@class='cvcolWidth']")
	public WebElement displayincv;

	@FindBy(how=How.XPATH, using="//*[@id=\"2113\"]/td[1]/div/label/span")
	public WebElement uncheckcheckbox;


	@FindBy(how=How.XPATH, using="//div[@class='starPrimaryWidth']")
	public WebElement primaryfacility;

	@FindBy(how=How.XPATH, using="//th[3]")
	public WebElement facilityname;

	@FindBy(how=How.XPATH, using="//span[@id='DEPARTMENTNAME']")
	public WebElement departmentname;

	@FindBy(how=How.XPATH, using="//div[contains(text(),'Actions')]")
	public WebElement action;


	@FindBy(how=How.XPATH, using="//*[@id=\"1581\"]/td[3]/div[1]/a")
	public WebElement facilitynam;

	@FindBy(how=How.XPATH, using="//*[@id=\"1581\"]/td[3]/div[2]")
	public WebElement facilityaddress;

	@FindBy(how=How.XPATH, using="//*[@id=\"1581\"]/td[3]/div[3]")
	public WebElement facilityID;

	@FindBy(how=How.XPATH, using="//*[@id=\"2113\"]/td[4]/div[1]/a")
	public WebElement departmentnam;

	@FindBy(how=How.XPATH, using="//*[@id=\"2113\"]/td[4]/div[2]")
	public WebElement departmentaddress;

	@FindBy(how=How.XPATH, using="//*[@id=\"2113\"]/td[4]/div[3]")
	public WebElement departmentID;


	@FindBy(how=How.ID, using="FacilityId")
	public WebElement Facility;


	@FindBy(how=How.ID, using="SearchFacilityId")
	public WebElement searchfacility;


	@FindBy(how=How.ID, using="sponsor_search_CountryList_Id")
	public WebElement countrylist;


	@FindBy(how=How.ID, using="search_state_Id")
	public WebElement state;



	@FindBy(how=How.XPATH, using="//*[@id=\"facilityList\"]/div[1]/div[3]/button[1]")
	public WebElement search;



	@FindBy(how=How.XPATH, using="//h2[contains(text(),'Select Facilities')]")
	public WebElement searchfacilitytitle;



	@FindBy(how=How.XPATH, using="//a[contains(text(),'Lung and Sleep Clinic of Alaska')]")
	public WebElement Facility1;


	@FindBy(how=How.ID, using="irbDetailsLi")
	public WebElement IRB;


	@FindBy(how=How.XPATH, using="//span[contains(text(),'Local IRB')]")
	public WebElement localIRB;

	@FindBy(how=How.XPATH, using="//label[contains(text(),'What is the average time (in days) to start a stud')]")
	public WebElement onscrn1;

	@FindBy(how=How.XPATH, using="//*[@id=\"irbDetails\"]/div[1]/div[1]/label[2]")
	public WebElement onscrn2;

	@FindBy(how=How.XPATH, using="//*[@id=\"irbDetails\"]/div[1]/div[1]/label[3]")
	public WebElement onscrn3;

	@FindBy(how=How.XPATH, using="//*[@id=\"irbDetails\"]/div[1]/div[1]/label[4]")
	public WebElement onscrn4;

	@FindBy(how=How.XPATH, using="//*[@id=\"irbDetails\"]/div[1]/div[1]/label[5]")
	public WebElement onscrn5;

	@FindBy(how=How.XPATH, using="//*[@id=\"irbDetails\"]/div[1]/div[1]/label[6]")
	public WebElement onscrn6;

	@FindBy(how=How.XPATH, using="//*[@id=\"irbDetails\"]/div[1]/div[1]/label[7]")
	public WebElement onscrn7;
	
	@FindBy(how=How.ID, using="irbGenQues1")
	public WebElement IRBAns1;
	
	@FindBy(how=How.ID, using="irbGenQuesFacPerform1")
	public WebElement IRBAns2;
	
	@FindBy(how=How.ID, using="irbGenQuesFacDedicate2")
	public WebElement IRBAns3;
	
	@FindBy(how=How.ID, using="studyActIrbApproval2")
	public WebElement IRBAns4;

	@FindBy(how=How.XPATH, using="(//input[@class='form-checkbox-btn ui-helper-hidden-accessible']/following-sibling::span)[1]")
	public WebElement IRBAns5;

	@FindBy(how=How.ID, using="irbGenQuesRegMandate1")
	public WebElement IRBAns6;
	
	@FindBy(how=How.ID, using="irbGenQuesOtherStep2")
	public WebElement IRBAns7;
	
	@FindBy(how=How.XPATH, using="//h1[text()='Success        ']")
	public WebElement successMsg;
	
	@FindBy(how=How.XPATH, using="//h2[@class='no-margin float-left']")
	public WebElement facilitynamaddress;



	@FindBy(how=How.XPATH, using="//*[@id=\"userTextLoad\"]/div[1]/h2\r\n")
	public WebElement facilitytitle;




	@FindBy(how=How.ID, using="MyFacilitiesId")
	public WebElement Myfacility;


	@FindBy(how=How.XPATH, using="//h2[contains(text(),'Facilities')]")
	public WebElement facilities;


	@FindBy(how=How.XPATH, using="//*[@id=\"2574\"]/td[3]/div[1]/a")
	public WebElement faci1;


	@FindBy(how=How.ID, using="irbDetailsLi")
	public WebElement irb;

	@FindBy(how=How.XPATH, using="//h2[@class='medium-header-h2']")
	public WebElement irbtitle;

	@FindBy(how=How.XPATH, using="//h2[@class='medium-header-h2']")
	public WebElement report;


	@FindBy(how=How.XPATH, using="//span[contains(text(),'Local IRB')]")
	public WebElement localirb;


	@FindBy(how=How.XPATH, using="//h2[@class='medium-header-h2 border-bottom']")
	public WebElement localirbtitle;

	@FindBy(how=How.XPATH, using="//input[@id='iRBAddressOne_0']")
	public WebElement streenname;

	@FindBy(how=How.ID, using="iRBAddressTwo_0")
	public WebElement building;

	@FindBy(how=How.XPATH, using="//input[@id='iRBAddressThree_0']")
	public WebElement additionaladdress;

	@FindBy(how=How.XPATH, using="//*[@id=\"search_CountryList_0\"]")
	public WebElement country;


	@FindBy(how=How.XPATH, using="//*[@id=\"search_state_Id_0\"]")
	public WebElement states;


	@FindBy(how=How.XPATH, using="//*[@id=\"iRBCity_0\"]")
	public WebElement city;


	@FindBy(how=How.XPATH, using="//*[@id=\"iRBPostalCode_0\"]")
	public WebElement zip;


	@FindBy(how=How.XPATH, using="//input[@placeholder='Optional']")
	public WebElement regno;

	@FindBy(how=How.XPATH, using="//*[@id=\"iRBRegTable_0\"]/tbody/tr/td[3]/div/i")
	public WebElement close;


	@FindBy(how=How.XPATH, using="//button[contains(text(),'Save')]")
	public WebElement save;



	@FindBy(how=How.XPATH, using="//*[@id=\"irbNmMandatoryLocalIrbPopup\"]/div[2]/div/p")
	public WebElement popuptext;

	@FindBy(how=How.XPATH, using="//*[@id=\"irbNmMandatoryLocalIrbPopup\"]/div[2]/div/div/input")
	public WebElement ok;


	@FindBy(how=How.XPATH, using="//input[@id='iRBCommitteeNm_0']")
	public WebElement cometeename;



	@FindBy(how=How.XPATH, using="//*[@id=\"modalSaveSuccessMessage\"]/div[2]/div/div[2]/p")
	public WebElement popuptext1;

	@FindBy(how=How.XPATH, using="//*[@id=\"modalSaveSuccessMessage\"]/div[2]/div/div[3]/button")
	public WebElement ok1;


	@FindBy(how=How.XPATH, using="//a[contains(text(),'Reports')]")
	public WebElement reports;

	@FindBy(how=How.ID, using="jspDropDownValue")
	public WebElement reportdropdown;


	@FindBy(how=How.XPATH, using="//*[@id=\"facilityDiv\"]/span")
	public WebElement facilitynames;



	@FindBy(how=How.XPATH, using="//*[@id=\"facilityDivDummy\"]/div[1]/span[1]/span")
	public WebElement fa1check;

	@FindBy(how=How.XPATH, using="//*[@id=\"facilityDivDummy\"]/div[2]/span[1]/span")
	public WebElement fa2check;

	@FindBy(how=How.XPATH, using="//*[@id=\"facilityDiv\"]/div/div[1]/a[1]/i")
	public WebElement close1;


	@FindBy(how=How.XPATH, using="//*[@id=\"delegTypeDiv\"]/span")
	public WebElement delegationtype;



	@FindBy(how=How.XPATH, using="//*[@id=\"delegTypeDiv\"]/div/div[2]/div[1]/span[1]/span")
	public WebElement chck1;



	@FindBy(how=How.XPATH, using="//*[@id=\"delegTypeDiv\"]/div/div[1]/a[1]/i")
	public WebElement clos;




	@FindBy(how=How.ID, using="generateCvBtnId")
	public WebElement generatereport;




	@FindBy(how=How.XPATH, using="//*[@id=\"AdminId\"]/span[1]")
	public WebElement Admin;



	@FindBy(how=How.ID, using="ManageDelegationId")
	public WebElement Managedelegation;

	@FindBy(how=How.XPATH, using="//*[@id=\"1879\"]/td[3]/div[1]/a")
	public WebElement facility1name;

	@FindBy(how=How.XPATH, using="//*[@id=\"1879\"]/td[3]/div[2]")
	public WebElement facility1address;

	@FindBy(how=How.XPATH, using="//*[@id=\"actionsMain2910\"]/button/i")
	public WebElement action1;


	@FindBy(how=How.XPATH, using="//*[@id=\"actionsMain2910\"]/div/ul/li[2]")
	public WebElement exportdepartmentprofile;



	@FindBy(how=How.XPATH, using="//*[@id=\"ExportPopupDep\"]/div[2]/div/div[1]/span[1]/a")
	public WebElement pdf;


	@FindBy(how=How.ID, using="deptExportButton")
	public WebElement export;


	@FindBy(how=How.XPATH, using="(//button[@title='Export Profile']//i)[1]")
	public WebElement ExportFacilitySearch;
	
	@FindBy(how=How.XPATH, using="(//button[@title='Export Profile']//i)[2]")
	public WebElement ExportDepartmentSearch;
	
	
	@FindBy(how=How.XPATH, using="(//a[@class='pdfIcon'])[1]")
	public WebElement ExportFacilitySearchToPDF;
	
	@FindBy(how=How.XPATH, using="(//a[@class='wordIconExport'])[2]")
	public WebElement ExportFacilitySearchToWord;
	
	@FindBy(how=How.XPATH, using="(//a[@title='PDF'])[2]")
	public WebElement ExportDepartmentSearchToPDF;
	
	
	
	@FindBy(how=How.ID, using="facExportButton")
	public WebElement ExportFacilitySearchButton;
	
	@FindBy(how=How.ID, using="deptExportButton")
	public WebElement ExportDepartmentSearchButton;
	
	@FindBy(how=How.XPATH, using="(//p[@class='popupFont'])[2]")
	public WebElement ExportFacilitySearchPopUp;
	
	@FindBy(how=How.XPATH, using="(//p[@class='popupFont'])[3]")
	public WebElement ExportDepartmentSearchPopUp;
	
	@FindBy(how=How.XPATH, using="((//label[text()='Choose Format'])[2]/following::input)[3]")
	public WebElement ExportFacilitySearchOKButton;
	
	@FindBy(how=How.XPATH, using="((//label[text()='Choose Format'])[2]/following::input)[4]")
	public WebElement ExportDepartmentSearchOKButton;
	

	@FindBy(how=How.XPATH, using="//*[@id=\"exportSentDepName\"]")
	public WebElement title;


	@FindBy(how=How.XPATH, using="//*[@id=\"deptExportReq\"]")
	public WebElement onscreen;

	@FindBy(how=How.XPATH, using="(//input[@value='OK'])[2]")
	public WebElement OKbtn;
	
	@FindBy(how=How.XPATH, using="(//button[text()='OK'])[3]")
	public WebElement OKsuccesbtn;
	
	@FindBy(how=How.XPATH, using="(//button[@id='formId_0'])[2]")
	public WebElement removeBtn;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"ExportPopupSuccessDep\"]/div[2]/div/div/button")
	public WebElement ok2;


	@FindBy(how=How.XPATH, using="//*[@id=\"Navigationmenu\"]/li[1]/a")
	public WebElement home;


	@FindBy(how=How.XPATH, using="//*[@id=\"taskResults\"]/div[2]/input")
	public WebElement Mytask;

	@FindBy(how=How.XPATH, using="//*[@id=\"received\"]/div/a/span")
	public WebElement recievedsort;


	@FindBy(how=How.XPATH, using="//*[@id=\"allTaskViewMoreTable\"]/tbody/tr[1]/td[3]/div/a")
	public WebElement tasktitle;


	@FindBy(how=How.XPATH, using="//*[@id=\"taskDetailsPopup_145092\"]/div/p[1]")
	public WebElement departmentprofileavailb;



	@FindBy(how=How.XPATH, using="//a[contains(text(),'Click here')]")
	public WebElement clickhere;



	@FindBy(how=How.XPATH, using="/html/body/div[7]/div[1]/button/span")
	public WebElement closebutt;


	@FindBy(how=How.XPATH, using="//*[@id=\"ExportPopupDep\"]/div[2]/div/div[1]/span[2]/a")
	public WebElement word;


	@FindBy(how=How.XPATH, using="//*[@id=\"facilityDiv\"]/h2")
	public WebElement facilitiestitle;



	@FindBy(how=How.XPATH, using="//*[@id=\"previewCV\"]")
	public WebElement previewcv;



	@FindBy(how=How.XPATH, using="//*[@id=\"confirm-generate-CV\"]/div[2]/div/div[2]/h1")
	public WebElement reviewcv;


	@FindBy(how=How.XPATH, using="//*[@id=\"confirm-generate-CV\"]/div[2]/div/div[2]/p")
	public WebElement onscreen1;

	@FindBy(how=How.XPATH, using="//*[@id=\"actionGenerateCvYes\"]")
	public WebElement generatesigncv;

	@FindBy(how=How.XPATH, using="//*[@id=\"actionCancel\"]")
	public WebElement cancel;


	@FindBy(how=How.ID, using="addFacilitybtn")
	public WebElement Addfacility;


	@FindBy(how=How.XPATH, using="//*[@id=\"search_CountryList_Id\"]")
	public WebElement country1;

	@FindBy(how=How.XPATH, using="//*[@id=\"search_facilityName\"]")
	public WebElement facility;


	@FindBy(how=How.ID, using="FacilityId")
	public WebElement FACILITY;

	@FindBy(how=How.XPATH, using="//*[@id=\"myFacility1\"]/div/div/div[2]/input[1]")
	public WebElement search1;



	@FindBy(how=How.XPATH, using="//*[@id=\"facilityID2912$DD125838-000$L09lcFhLeG1EOFU9$eEp1Z0prRmdOWmVERkYwYXBMYkFTZz09$Hospital Infantil Sabar\"]")
	public WebElement radio;



	@FindBy(how=How.XPATH, using="//*[@id=\"actionsMain2563\"]/button/i")
	public WebElement actionicon;


	@FindBy(how=How.XPATH, using="//*[@id=\"addFacilityBtn\"]")
	public WebElement addfacility;


	@FindBy(how=How.ID, using="generateCvBtnId")
	public WebElement generatecv;


	@FindBy(how=How.XPATH, using="//*[@id=\"search_CountryList_Id\"]")
	public WebElement countrydropdown;


	@FindBy(how=How.XPATH, using="//*[@id=\"myFacility1\"]/div/div/div[2]/input[2]")
	public WebElement clearsearch;

	@FindBy(how=How.ID, using="search_state_Id")
	public WebElement state1;

	@FindBy(how=How.ID, using="search_city")
	public WebElement city1;

	@FindBy(how=How.ID, using="search_facilityName")
	public WebElement facilityname1;

	@FindBy(how=How.XPATH, using="search_sipFacilityId")
	public WebElement sipfacid;


	@FindBy(how=How.ID, using="sponsor_search_CountryList_Id")
	public WebElement countrydropdown1;


	@FindBy(how=How.XPATH, using="//*[@id=\"search_state_Id\"]")
	public WebElement state2;


	@FindBy(how=How.XPATH, using="//*[@id=\"cityName\"]")
	public WebElement city2;

	@FindBy(how=How.XPATH, using="//*[@id=\"facilityList\"]/div[1]/div[3]/button[2]")
	public WebElement clearsearch1;



	@FindBy(how=How.XPATH, using="//*[@id=\"actionsMain2222\"]/button/i")
	public WebElement dept1;



	@FindBy(how=How.XPATH, using="//*[@id=\"actionsMain2222\"]/div/ul/li[2]")
	public WebElement assigndepartmentprofilemanager;



	@FindBy(how=How.XPATH, using="//*[@id=\"departmentChoooseFPM\"]/div[2]/div/div/button[1]")
	public WebElement Iwillmaintain;



	@FindBy(how=How.XPATH, using="//*[@id=\"actionsMain2563\"]/div/ul/li[1]")
	public WebElement adddepartment;



	@FindBy(how=How.XPATH, using="//*[@id=\"departmentresultFrm\"]/div[3]/button[2]")
	public WebElement createdepartment;


	@FindBy(how=How.XPATH, using="//input[@id='departmentName']")
	public WebElement departmentname1;



	@FindBy(how=How.XPATH, using="//select[@id='departmentType']")
	public WebElement departmenttype;


	@FindBy(how=How.ID, using="addressTwo")
	public WebElement building1;


	@FindBy(how=How.ID, using="addressThree")
	public WebElement address;


	@FindBy(how=How.ID, using="facility-save-button")
	public WebElement savebu;



	@FindBy(how=How.XPATH, using="//*[@id=\"modalPotentialDuplicateFac\"]/div[2]/div/div/button[2]")
	public WebElement iwillassignsomeoneelse;



	


	@FindBy(how=How.XPATH, using="//*[@id=\"frmContactSearch\"]/ul/li[1]/div/div[2]/div[2]/button[1]")
	public WebElement search2;

	@FindBy(how=How.XPATH, using="//*[@id=\"byFDEmailAddress\"]")
	public WebElement email;
	
	@FindBy(how=How.XPATH, using="//button[@class='primary-btn siteUserSearchResultBtn']")
	public WebElement FacilityContactSitesearch;


	@FindBy(how=How.ID, using="userID9007")
	public WebElement radio1;



	@FindBy(how=How.ID, using="btnAddrolesOpenPopup")
	public WebElement selectdeptcontact;

	@FindBy(how=How.ID, using="addDeptCancelBtn")
	public WebElement continueupdatingthedepartment;

	@FindBy(how=How.XPATH, using="//*[@id=\"intermidiateSection\"]/div[2]/button[1]")
	public WebElement entermanually;

	@FindBy(how=How.XPATH, using="//*[@id=\"intermidiateSection\"]/div[2]/button[2]")
	public WebElement AdoptFacilitybutton;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"intermidiateSection\"]/div[2]/button[3]")
	public WebElement UploadSipDepartmentbutton;
	
	@FindBy(how=How.XPATH, using="//button[@id='spfUpload']")
	public WebElement UploadSIPbutton;
	
	@FindBy(how=How.XPATH, using="(//button[contains(@class,'button-link-btn cancelBtn')])[2]")
	public WebElement CancelSIPbutton;
	
	@FindBy(how=How.XPATH, using="//input[@id='uploadFacDeptProfileForm']")
	public WebElement ChooseFilePbutton;
	

	@FindBy(how=How.XPATH, using="//*[@id=\"ipDetailsLi\"]")
	public WebElement IPandcontrolsubstance;


	@FindBy(how=How.XPATH, using="//*[@id=\"IPDetails\"]/h5[2]")
	public WebElement IPSTORAGEEQUIPMENT;

	@FindBy(how=How.XPATH, using="//*[@id=\"IPDetails\"]/h5[3]")
	public WebElement storagehandling;


	@FindBy(how=How.XPATH, using="//*[@id=\"IPDetails\"]/h5[4]")
	public WebElement ADMINISTRATIONOINVESUC;

	@FindBy(how=How.XPATH, using="//*[@id=\"IPDetails\"]/h5[5]")
	public WebElement controlsubstance;



	@FindBy(how=How.ID, using="facility-save-button")
	public WebElement savebut;


	@FindBy(how=How.XPATH, using="//*[@id=\"modalSaveSuccessMessage\"]/div[2]/div/div[3]/button")
	public WebElement okbu;


	@FindBy(how=How.XPATH, using="//*[@id=\"shippingLocCountry_1\"]")
	public WebElement countr;



	@FindBy(how=How.XPATH, using="//*[@id=\"shippingLocState_1\"]")
	public WebElement stat;



	@FindBy(how=How.XPATH, using="//*[@id=\"IPShippingRecipientEmail_1\"]")
	public WebElement email1;



	@FindBy(how=How.XPATH, using="//*[@id=\"frmShippingLocation_1\"]/ul/li[11]/div/label")
	public WebElement emailerror;



	@FindBy(how=How.XPATH, using="//*[@id=\"addShippingLocBtn\"]")
	public WebElement AddIPshippinglocation;

	@FindBy(how=How.XPATH, using="//*[@id=\"IPShippingRecipientName_1\"]")
	public WebElement iprecipientname;

	@FindBy(how=How.XPATH, using="//*[@id=\"shippingLocStreetName_1\"]")
	public WebElement streetname;

	@FindBy(how=How.XPATH, using="//*[@id=\"IPShippingRecipientCity_1\"]")
	public WebElement newcity;

	@FindBy(how=How.XPATH, using="//*[@id=\"modalSaveSuccessMessage\"]/div[2]/div/div[3]/button")
	public WebElement ok3;


	@FindBy(how=How.ID, using="btnStorageLocSave_1")
	public WebElement sve;

	@FindBy(how=How.XPATH, using="//*[@id=\"frmShippingLocation_1\"]/ul/li[1]/label")
	public WebElement ip;

	@FindBy(how=How.XPATH, using="//*[@id=\"frmShippingLocation_1\"]/ul/li[2]/label")
	public WebElement strtnam;

	@FindBy(how=How.XPATH, using="//*[@id=\"frmShippingLocation_1\"]/ul/li[3]/label")
	public WebElement build;

	@FindBy(how=How.XPATH, using="//*[@id=\"frmShippingLocation_1\"]/ul/li[4]/label")
	public WebElement addaddress;

	@FindBy(how=How.XPATH, using="//*[@id=\"frmShippingLocation_1\"]/ul/li[5]/label")
	public WebElement country2;

	@FindBy(how=How.XPATH, using="//*[@id=\"frmShippingLocation_1\"]/ul/li[6]/label")
	public WebElement state3;

	@FindBy(how=How.XPATH, using="//*[@id=\"frmShippingLocation_1\"]/ul/li[7]/label")
	public WebElement city3;

	@FindBy(how=How.XPATH, using="//*[@id=\"frmShippingLocation_1\"]/ul/li[8]/label")
	public WebElement zip2;

	@FindBy(how=How.XPATH, using="//*[@id=\"frmShippingLocation_1\"]/ul/li[9]/label")
	public WebElement phone;

	@FindBy(how=How.XPATH, using="//*[@id=\"frmShippingLocation_1\"]/ul/li[10]/label")
	public WebElement fax;

	@FindBy(how=How.XPATH, using="//*[@id=\"frmShippingLocation_1\"]/ul/li[11]/label")
	public WebElement emailid;


	@FindBy(how=How.ID, using="btnSaveShippingAddress_1")
	public WebElement savebutton;



	@FindBy(how=How.XPATH, using="//*[@id=\"modalShippingAddressNotField\"]/div[2]/div/div/button")
	public WebElement okk;

	@FindBy(how=How.XPATH, using="//*[@id=\\\"modalShippingAddressNotField\\\"]/div[2]/div/p")
	public WebElement error;


	@FindBy(how=How.ID, using="secondary-btn modal-close")
	public WebElement okkk;



	@FindBy(how=How.XPATH, using="//*[@id=\"frmShippingLocation_1\"]/span/i")
	public WebElement plus;



	@FindBy(how=How.XPATH, using="//*[@id=\"frmShippingLocation_1\"]/span")
	public WebElement minus;


	@FindBy(how=How.XPATH, using="//*[@id=\"btnShippingLocDelete_1\"]")
	public WebElement remove;


	@FindBy(how=How.XPATH, using="//*[@id=\"modalShippingLocDelete\"]/div[2]/div/p")
	public WebElement warningtext;

	@FindBy(how=How.XPATH, using="//*[@id=\"modalShippingLocDelete\"]/div[2]/div/div/button[1]")
	public WebElement okkkk;

	@FindBy(how=How.XPATH, using="//*[@id=\"modalShippingLocDelete\"]/div[2]/div/div/button[2]")
	public WebElement cancell;



	@FindBy(how=How.XPATH, using="//*[@id=\"showNextResult\"]")
	public WebElement next;


	@FindBy(how=How.XPATH, using="//*[@id=\"NoRecordPopupSiteUserDelegation\"]/div/div[2]/button")
	public WebElement Okkkkk;



	@FindBy(how=How.XPATH, using="//*[@id=\"1683\"]/td[3]/div[1]/a")
	public WebElement facilities1;



	@FindBy(how=How.XPATH, using="//*[@id=\"actionsMain1683\"]/button/i")
	public WebElement action2;

	@FindBy(how=How.XPATH, using="//*[@id=\"actionsMain1683\"]/div/ul/li[1]")
	public WebElement adddepartmet2;

	@FindBy(how=How.XPATH, using="//*[@id=\"actionsMain1683\"]/div/ul/li[2]")
	public WebElement exportfacilityprofile2;

	@FindBy(how=How.XPATH, using="//*[@id=\"actionsMain1683\"]/div/ul/li[3]")
	public WebElement removefacility2;

	@FindBy(how=How.XPATH, using="//*[@id=\"actionsMain1683\"]/div/ul/li[4]")
	public WebElement facilitymsgtofpm2;

	@FindBy(how=How.XPATH, using="//*[@id=\"departmentResults\"]/tbody/tr[1]/td[1]/span")
	public WebElement dept1checkbox;



	@FindBy(how=How.XPATH, using="//*[@id=\"addDepartmentBtn\"]")
	public WebElement adddepartmenttouserprofile;


	@FindBy(how=How.XPATH, using="//*[@id=\"1969\"]/td[3]/div[1]/a")
	public WebElement facility1;

	@FindBy(how=How.XPATH, using="//*[@id=\"breadcrumbs\"]/ul")
	public WebElement breadcrumb;

	@FindBy(how=How.XPATH, using="//*[@id=\"facilityContactLi\"]")
	public WebElement facilitycontact;



	@FindBy(how=How.XPATH, using="//*[@id=\"facilityContactDetails\"]/div[1]/div[1]/div[2]/table/tbody/tr/td[2]")
	public WebElement firstlastname;

	@FindBy(how=How.XPATH, using="//*[@id=\"actionsMain1980\"]/button/i")
	public WebElement action3;


	@FindBy(how=How.XPATH, using="//*[@id=\"actionsMain1980\"]/div/ul/li[3]")
	public WebElement removedepartment;



	@FindBy(how=How.XPATH, using="//*[@id=\"error_removeFaciPopupDivId\"]/div[2]/div/div[3]/button")
	public WebElement okbutton7;



	@FindBy(how=How.XPATH, using="//*[@id=\"facilityID275$DD189706-000$MTZVbVJJc0NXSWRUMFA3c2hJcng4Zz09$ZURtM1V6SXNaM2kyWG5HeWQrRjM3UT09$Create Facility - Sajit\"]")
	public WebElement selectradio;



	@FindBy(how=How.XPATH, using="//*[@id=\"addFacilityBtn\"]")
	public WebElement addprofiletouserprofile;



	@FindBy(how=How.XPATH, using="//*[@id=\"addDeparment\"]/div/div/div[2]/div[3]/button[3]")
	public WebElement nodepartment;




	@FindBy(how=How.XPATH, using="//*[@id=\"2720\"]/td[4]/div[1]/a")
	public WebElement deptnam;



	@FindBy(how=How.XPATH, using="//*[@id=\"userTextLoad\"]/div[1]/h2")
	public WebElement departnameaddress;
	
	@FindBy(how=How.XPATH, using="(//input[contains(@class,'secondary-btn sendForApprovalCheck')])[1]")
	public WebElement AddFacilityBtn;
	
	
	
	@FindBy(how=How.XPATH, using="//span[text()='Associated Site Users']")
	public WebElement AssociatedSiteUserAccess;
	
	@FindBy(how=How.XPATH, using="//h2[text()='Associated Site Users']")
	public WebElement AssociatedSiteUserAccessHeader;
	
	@FindBy(how=How.XPATH, using="//h3[text()=' Site User Association Requests']")
	public WebElement AssociatedSiteUserAccessTable1;
	
	@FindBy(how=How.XPATH, using="//h3[text()='  Associated/Confirmed Site Users ']")
	public WebElement AssociatedSiteUserAccessTable2;
	
	@FindBy(how=How.XPATH, using="//button[@class='primary-btn siteUserSearchResultBtn']")
	public WebElement AssociatedSiteUserAccessSearchBtn;
	
	@FindBy(how=How.XPATH, using="//div[@id='viewAssociatedDepartment']/div[2]/div[1]/div[2]/button[1]")
	public WebElement AssociatedDepartmentOK;
	
	@FindBy(how=How.XPATH, using="//input[@value='Remove User']")
	public WebElement RemoveUser;
	
	
	public void nevigatetoassociatedsiteusersection() throws Exception{
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		AssociatedSiteUserAccess.click();
		Thread.sleep(3000);
		highLightElement(AssociatedSiteUserAccessHeader);
		Thread.sleep(3000);
	}
	
	public void verifyassociatedsiteusertables() throws Exception{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", AssociatedSiteUserAccessSearchBtn);
		Thread.sleep(2000);
		highLightElement(AssociatedSiteUserAccessTable1);
		highLightElement(AssociatedSiteUserAccessTable2);
	}
	
	public void verifytable(int n) throws Exception{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(n==1){
			try{
				WebElement NoDataText=driver.findElement(By.xpath("//td[@colspan='7']"));
				highLightElement(NoDataText);
			}catch(Exception e){}
		}
		
		
		else if(n==2){
try{
	properties= obj.getProperty();
	Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
	testData.setTestDatainMap(TestDataInMap);
	Map<String,String> testDataInMap = testData.getTestDatainMap();	
	String SiteUser1Email=testDataInMap.get("SiteU1Email_ID");
	String SiteUser2Email=testDataInMap.get("SiteU2Email_ID");
	
	SiteUser1Email.trim();
	SiteUser2Email.trim();
	
WebElement SiteUser1=driver.findElement(By.xpath("//td[text()='"+SiteUser1Email+"']/preceding-sibling::td[1]"));
WebElement SiteUser2=driver.findElement(By.xpath("//td[text()='"+SiteUser2Email+"']/preceding-sibling::td[1]"));

highLightElement(SiteUser1);
highLightElement(SiteUser2);
			
}catch(Exception e){}
	
		}
	}
	
	public void viewassociateddepartment(){
		try{
			properties= obj.getProperty();
			Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
			testData.setTestDatainMap(TestDataInMap);
			Map<String,String> testDataInMap = testData.getTestDatainMap();	
			String SiteUser1Email=testDataInMap.get("SiteU1Email_ID");
			SiteUser1Email.trim();
			
		WebElement SiteUser1Action=driver.findElement(By.xpath("//td[text()='"+SiteUser1Email+"']/following-sibling::td[4]/div/button"));
		WebElement ViewDepartment=driver.findElement(By.xpath("//td[text()='"+SiteUser1Email+"']/following-sibling::td[4]/div//child::li[1]"));
		SiteUser1Action.click();
        ViewDepartment.click(); 
        
					
		}catch(Exception e){}
	}
	
	
	public void verifyremoveuserbtn(){
AssociatedDepartmentOK.click();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

try{
	properties= obj.getProperty();
	Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
	testData.setTestDatainMap(TestDataInMap);
	Map<String,String> testDataInMap = testData.getTestDatainMap();	
	String SiteUser1Email=testDataInMap.get("SiteU1Email_ID");
	SiteUser1Email.trim();
	
	WebElement SiteUser1Checkbox=driver.findElement(By.xpath("//td[text()='"+SiteUser1Email+"']/preceding-sibling::td[2]/span"));
	SiteUser1Checkbox.click();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", AssociatedSiteUserAccessTable2);
	
RemoveUser.isDisplayed();
highLightElement(RemoveUser);


			
}catch(Exception e){}
	}
	
	public void removesiteuser(){
		RemoveUser.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[contains(@class,'secondary-btn marBot10')]")).click();
	}
	
	public void Verifyonscreentext() throws Exception
	{
		System.out.println("check");

		Thread.sleep(3000);
		properties= obj.getProperty();

		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);
		Map<String,String> testDataInMap = testData.getTestDatainMap();

		String expectedOnScreenText= testDataInMap.get("OnScreenText");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");


		String actualonScreenText =driver.findElement(By.xpath("//p[contains(text(),'Add Facilities and affiliated Departments where')]")).getText();

		System.out.println(actualonScreenText);
		Thread.sleep(3000);
		System.out.println(expectedOnScreenText);
		Thread.sleep(3000);
		Assert.assertEquals(expectedOnScreenText, actualonScreenText);
		Thread.sleep(3000);


	}







	public void Verifyfacilitytable() throws Exception
	{



		Thread.sleep(3000);
		highLightElement(displayincv);

		Thread.sleep(3000);


		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);



	}



	private void Highlightelement(String string) {
		// TODO Auto-generated method stub

	}




	public void Verifyunchecked() throws Exception
	{



		Thread.sleep(3000);
		highLightElement(uncheckcheckbox);

		Thread.sleep(3000);


		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);



	}


	public void verifyfacilitycoulumn() throws Exception
	{



		Thread.sleep(3000);
		highLightElement(displayincv);
		Thread.sleep(3000);
		highLightElement(primaryfacility);
		Thread.sleep(3000);
		highLightElement(facilityname);
		Thread.sleep(3000);
		highLightElement(departmentname);
		Thread.sleep(3000);
		highLightElement(action);
		Thread.sleep(3000);


		if(displayincv.getText().contains("Display on CV?"))
		{
			System.out.println("Test pass");
		}
		else
		{
			System.out.println("Test Fail");

		}


		if(primaryfacility.getText().contains("Primary Facility"))
		{
			System.out.println("Test pass");
		}
		else
		{
			System.out.println("Test Fail");

		}

		if(facilityname.getText().contains("Facility Name and Address"))
		{
			System.out.println("Test pass");
		}
		else
		{
			System.out.println("Test Fail");

		}

		if(departmentname.getText().contains("Department Name and Address"))
		{
			System.out.println("Test pass");
		}
		else
		{
			System.out.println("Test Fail");

		}

		if(action.getText().contains("Actions"))
		{
			System.out.println("Test pass");
		}
		else
		{
			System.out.println("Test Fail");

		}


		Thread.sleep(3000);


		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);



	}


	public void Verifyfacility1() throws Exception
	{



		Thread.sleep(3000);
		highLightElement(facilitynam);
		Thread.sleep(3000);
		highLightElement(facilityaddress);
		Thread.sleep(3000);
		highLightElement(facilityID);
		Thread.sleep(3000);


		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);



	}



	public void Verifydepartmentid() throws Exception
	{



		Thread.sleep(3000);
		highLightElement(departmentnam);
		Thread.sleep(3000);
		highLightElement(departmentaddress);
		Thread.sleep(3000);
		highLightElement(departmentID);
		Thread.sleep(3000);


		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);



	}


	public void Navigatetosearchfacilityandverify() throws Exception
	{



		System.out.println("Hii");
		Thread.sleep(3000);
		Actions action=new Actions(driver);
		action.moveToElement(Facility).build().perform();
		Thread.sleep(3000);
		searchfacility.click();
		Thread.sleep(3000);
		countrylist.click();
		Thread.sleep(3000);
		countrylist.sendKeys("United States Of America");
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
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(3000); 
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(3000); 

		state.click();
		Thread.sleep(3000);
		state.sendKeys("alaska");
		Thread.sleep(3000);
		Robot robot2 = new Robot();  
		Thread.sleep(2000); 
		robot2.keyPress(KeyEvent.VK_DOWN); 	
		Thread.sleep(2000);  
		robot2.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);  
		robot2.keyPress(KeyEvent.VK_ENTER); 	
		Thread.sleep(2000);  
		robot2.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		Thread.sleep(3000); 
		js1.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000); 
		search.click();
		Thread.sleep(8000);

		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		Thread.sleep(3000); 



	}

	public void NevigateToSearchFacility() throws InterruptedException{
		System.out.println("Hii");
		Thread.sleep(3000);
		Actions action=new Actions(driver);
		action.moveToElement(Facility).build().perform();
		Thread.sleep(3000);
		searchfacility.click();
		Thread.sleep(3000);
	}
	
	public void VerifySponserSearchFacility() throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		SearchFacilityBreadCrumb.isDisplayed();
		highLightElement(SearchFacilityBreadCrumb);
        highLightElement(driver.findElement(By.xpath("//h2[text()='Search Facility']")));
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,300)");
	}
	

	public void verifyFecilitySearch() throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		SearchFacilityBreadCrumb.isDisplayed();  
		highLightElement(SearchFacilityBreadCrumb);
		Thread.sleep(3000);
		SearchFacilityHeader.isDisplayed();
		highLightElement(SearchFacilityHeader);
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(3000);
//		If GoldenFacility will Use Then
		try{
			driver.findElement(By.xpath("//span[contains(@class,'ui-checkbox ')]")).click();
		}catch(Exception e){}
		
		
		
		
		SearchFacilitySearchBtn.isEnabled();
		highLightElement(SearchFacilitySearchBtn);
		Thread.sleep(3000);
		SearchFacilityClearBtn.isEnabled();
		highLightElement(SearchFacilityClearBtn);
		Thread.sleep(3000);
		
		

	}
	public void verifyFecilitySearchForfields() throws InterruptedException{
		Thread.sleep(3000);
		SearchFacilityCountryField.isDisplayed();
		highLightElement(SearchFacilityCountryField);
		Thread.sleep(2000);
		SearchFacilityStateField.isDisplayed();
		highLightElement(SearchFacilityStateField);
		Thread.sleep(2000);
		SearchFacilityCityField.isDisplayed();
		highLightElement(SearchFacilityCityField);
		Thread.sleep(2000);
		SearchFacilityNameField.isDisplayed();
		highLightElement(SearchFacilityNameField);
		Thread.sleep(2000);
	}

	public void ClickOnSearchAndVery() throws InterruptedException{
		Thread.sleep(3000);
		SearchFacilitySearchBtn.click();
		Thread.sleep(3000);
		SearchFacilityERROR.isDisplayed();
		highLightElement(SearchFacilityERROR);
	}

	public void EnterCountryAndFacility(String arg1,String arg2) throws Exception{
		properties=obj.getProperty();
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);	
		Map<String,String> testDataInMap = testData.getTestDatainMap();

		String CountryName=testDataInMap.get(arg1);
		String FacilityName=testDataInMap.get(arg2);
		Thread.sleep(3000);
		SearchFacilityCountryField.sendKeys(CountryName);
		SearchFacilityCountryField.sendKeys(Keys.ARROW_DOWN);
//		SearchFacilityCountryField.sendKeys(Keys.ARROW_DOWN);
		SearchFacilityCountryField.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		SearchFacilityNameField.sendKeys(FacilityName);
		Thread.sleep(2000);
		SearchFacilitySearchBtn.click();
		Thread.sleep(5000);
		try{
			WebElement Facility1=driver.findElement(By.xpath("//td[text()='"+FacilityName+"']"));
		    highLightElement(Facility1);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)");
			Thread.sleep(2000);
			AddFacilityToUser.isDisplayed();
			highLightElement(AddFacilityToUser);
			SearchFacilityCancelbtn.isDisplayed();
			highLightElement(SearchFacilityCancelbtn);
			Thread.sleep(2000);
//			highLightElement(driver.findElement(By.xpath("//td[text()='"+FacilityName+"']")));
			emailIcon.isDisplayed();
			highLightElement(emailIcon);
		}catch(Exception e){
			System.out.println("No Desired Facility");
		}
		

	}
	
	public void EnterCountryAndState(String arg1,String arg2) throws Exception{
		properties=obj.getProperty();
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);	
		Map<String,String> testDataInMap = testData.getTestDatainMap();

		String CountryName=testDataInMap.get(arg1);
		String State=testDataInMap.get(arg2);
		String CityName=testDataInMap.get("City");
		
		
		Thread.sleep(3000);
		SearchFacilityCountryField.sendKeys(CountryName);
		SearchFacilityCountryField.sendKeys(Keys.ARROW_DOWN);
//		SearchFacilityCountryField.sendKeys(Keys.ARROW_DOWN);
		SearchFacilityCountryField.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		SearchFacilityStateField.sendKeys(State);
		SearchFacilityStateField.sendKeys(Keys.ARROW_DOWN);
		SearchFacilityStateField.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		
		
		
		SearchFacilitySearchBtn.click();
		Thread.sleep(5000);
		
	}
	
	
	public void EnterSiteUserCountryStateCityFacility() throws Exception{
		properties=obj.getProperty();
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);	
		Map<String,String> testDataInMap = testData.getTestDatainMap();

		String CountryName=testDataInMap.get("CountryField");
		String FacilityName=testDataInMap.get("FacilityName2");
		String CityName=testDataInMap.get("City");
		String State=testDataInMap.get("State");
		
		Thread.sleep(3000);
		SearchFacilityCountryField.sendKeys(CountryName);
		SearchFacilityCountryField.sendKeys(Keys.ARROW_DOWN);
//		SearchFacilityCountryField.sendKeys(Keys.ARROW_DOWN);
		SearchFacilityCountryField.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		
		SearchFacilityStateField.sendKeys(State);
		SearchFacilityStateField.sendKeys(Keys.ARROW_DOWN);
		SearchFacilityStateField.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		
		SearchFacilityCityField.sendKeys(CityName);
		Thread.sleep(4000);
		SearchFacilityNameField.sendKeys(FacilityName);
		Thread.sleep(4000);
		SearchFacilitySearchBtn.click();
		Thread.sleep(5000);
		WebElement Facility1=driver.findElement(By.xpath("//td[text()='"+FacilityName+"']"));
	    highLightElement(Facility1);
		
	}
	
	public void EnterSiteUserCountryStateCity() throws Exception{
		properties=obj.getProperty();
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);	
		Map<String,String> testDataInMap = testData.getTestDatainMap();

		String CountryName=testDataInMap.get("CountryField");
//		String FacilityName=testDataInMap.get("FacilityName2");
		String CityName=testDataInMap.get("City");
		String State=testDataInMap.get("State");
		
		Thread.sleep(3000);
		SearchFacilityCountryField.sendKeys(CountryName);
		SearchFacilityCountryField.sendKeys(Keys.ARROW_DOWN);
//		SearchFacilityCountryField.sendKeys(Keys.ARROW_DOWN);
		SearchFacilityCountryField.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		
		SearchFacilityStateField.sendKeys(State);
		SearchFacilityStateField.sendKeys(Keys.ARROW_DOWN);
		SearchFacilityStateField.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		
		SearchFacilityCityField.sendKeys(CityName);
		Thread.sleep(4000);
		
		SearchFacilitySearchBtn.click();
		Thread.sleep(5000);
	}
	
	public void VerifyFacilityColumnForSorting() throws InterruptedException{
	List<WebElement> facilities=driver.findElements(By.xpath("//td[@class='sorting_1']"));
	Thread.sleep(2000);
	try{
		for(int i=0;i<facilities.size();i++){
			highLightElement(facilities.get(i));
		}
	}catch(Exception e){}
	}
	
	public void VerifySponserFacilityColumnForSorting() throws InterruptedException{
		List<WebElement> facilityList=driver.findElements(By.xpath("//a[@class='float-left']"));
		Thread.sleep(2000);
		try{
			for(int i=0;i<facilityList.size();i++){
				highLightElement(facilityList.get(i));
			}
		}catch(Exception e){}
	}
	
	public void ClickOnStateSort() throws InterruptedException{
		Thread.sleep(2000);
		try{
			highLightElement(driver.findElement(By.xpath("//div[text()[normalize-space()='State/Province/Region']]/ancestor::th")));
		}catch(Exception e){}
		
		driver.findElement(By.xpath("(//i[@class='fa fa-sort'])[3]")).click();
		Thread.sleep(3000);
		try{
			highLightElement(driver.findElement(By.xpath("//table[@id='facilityResults']/tbody[1]/tr[1]/td[5]")));
		}catch(Exception e){}
	}
	public void ClickonFacilitySort() throws InterruptedException{
		Thread.sleep(2000);
		try{
			highLightElement(driver.findElement(By.xpath("//div[text()[normalize-space()='Facility Name']]/ancestor::th")));
		}catch(Exception e){}
		
		driver.findElement(By.xpath("(//i[@class='fa fa-sort'])[1]")).click();
	}
	
	public void ClickOnDepartmentSort() throws InterruptedException{
		Thread.sleep(2000);
try{
	highLightElement(driver.findElement(By.xpath("//th[text()[normalize-space()='Department Name']]")));	
		}catch(Exception e){}
		
		driver.findElement(By.xpath("(//i[@class='fa fa-sort'])[5]")).click();
	}
	
	public void ClickOnDepartmentCitySort() throws InterruptedException{
		Thread.sleep(2000);
try{
	highLightElement(driver.findElement(By.xpath("//th[text()[normalize-space()='City']]")));		
		}catch(Exception e){}
		
		driver.findElement(By.xpath("(//i[@class='fa fa-sort'])[6]")).click();
	}
	
	public void ClickOnDepartmentStateSort() throws InterruptedException{
		Thread.sleep(2000);
try{
	highLightElement(driver.findElement(By.xpath("//th[text()[normalize-space()='State/Province/Region']]")));
		}catch(Exception e){}
		
		driver.findElement(By.xpath("(//i[@class='fa fa-sort'])[7]")).click();
	}
	public void ClickonCitySort() throws InterruptedException{
		Thread.sleep(2000);
try{
	highLightElement(driver.findElement(By.xpath("//div[text()[normalize-space()='City']]/ancestor::th")));
		}catch(Exception e){}
		
		driver.findElement(By.xpath("(//i[@class='fa fa-sort'])[2]")).click();
		Thread.sleep(3000);
		try{
			highLightElement(driver.findElement(By.xpath("//table[@id='facilityResults']/tbody[1]/tr[1]/td[4]")));
		}catch(Exception e){}
	}
	
	public void ClickOnCancelButtonAfterVerifyErrorMsg() throws InterruptedException{
		Thread.sleep(2000);
		highLightElement(driver.findElement(By.xpath("//p[text()='The system was unable to find any Facilities that match your search criteria. Please refine your search criteria and try again or ']")));
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//input[contains(@class,'button-link-btn cancelBtn')])[2]")).click();
		Thread.sleep(4000);
		SearchFacilityClearBtn.click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
	}
	
	public void EnterCountryStateAndCity() throws Exception{
		properties=obj.getProperty();
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);	
		Map<String,String> testDataInMap = testData.getTestDatainMap();
		
		String Country=testDataInMap.get("CountryField");
		String States=testDataInMap.get("State");
		String City=testDataInMap.get("City");
		String facilityName=testDataInMap.get("FacilityName");
		
		SearchFacilityCountryField.sendKeys(Country);
		SearchFacilityCountryField.sendKeys(Keys.ARROW_DOWN);
		SearchFacilityCountryField.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		SearchFacilityStateField.sendKeys(States);
		SearchFacilityStateField.sendKeys(Keys.ARROW_DOWN);
		SearchFacilityStateField.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		SearchFacilityCityField.sendKeys(City);
		Thread.sleep(4000);
		SearchFacilitySearchBtn.click();
		Thread.sleep(5000);
		WebElement Facility1=driver.findElement(By.xpath("//td[text()='"+facilityName+"']"));
		highLightElement(Facility1);
	}
	
	public void EnterSponserCountryStateAndCity() throws Exception{
		properties=obj.getProperty();
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);	
		Map<String,String> testDataInMap = testData.getTestDatainMap();
		
		String Country=testDataInMap.get("CountryField");
		String States=testDataInMap.get("State");
		String City=testDataInMap.get("City");
		String facilityName=testDataInMap.get("FacilityName");
		
		SearchSponserFacilityCountryField.sendKeys(Country);
		SearchSponserFacilityCountryField.sendKeys(Keys.ARROW_DOWN);
		SearchSponserFacilityCountryField.sendKeys(Keys.ENTER);
		Thread.sleep(8000);
		SearchFacilityStateField.sendKeys(States);
		SearchFacilityStateField.sendKeys(Keys.ARROW_DOWN);
		SearchFacilityStateField.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		SearchFacilitySopnserCityField.sendKeys(City);
		Thread.sleep(4000);
		SearchSponserFacilitySearchBtn.click();
		Thread.sleep(5000);
		WebElement Facility1=driver.findElement(By.xpath("//a[text()='"+facilityName+"']"));
		highLightElement(Facility1);
		
	}
	
	public void EnterSponserCountryTA_SubTA_Phase_StydyType() throws Exception{
		properties=obj.getProperty();
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);	
		Map<String,String> testDataInMap = testData.getTestDatainMap();
		
		String Country=testDataInMap.get("CountryField");
		String TA=testDataInMap.get("TA");
//		String SubTA=testDataInMap.get("SubTA");
		String Phase=testDataInMap.get("Phase");
		String StudyType=testDataInMap.get("StudyType");
		
		SearchSponserFacilityCountryField.clear();
		Thread.sleep(1000);
		SearchSponserFacilityCountryField.sendKeys(Country);
		SearchSponserFacilityCountryField.sendKeys(Keys.ARROW_DOWN);
		SearchSponserFacilityCountryField.sendKeys(Keys.ENTER);
		Thread.sleep(8000);
		
	
		
		Actions a=new Actions(driver);
		a.moveToElement(SearchSponserTherapeuticArea).click().build().perform();
		Thread.sleep(1000);
		SearchSponserTherapeuticArea.clear();
		Thread.sleep(1000);
		SearchSponserTherapeuticArea.sendKeys(TA);
		WebElement TATypeCheck=driver.findElement(By.xpath("//label[normalize-space(text())='"+TA+"']/preceding-sibling::span"));
		TATypeCheck.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//i[@class='fa fa-times'])[2]"));
		
		Thread.sleep(3000);
		
		a.moveToElement(SearchSponserSubTherapeuticArea).click().build().perform();
		Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@class='siteSelectAllCheckBox ui-helper-hidden-accessible']/following-sibling::span)[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//i[@class='fa fa-times'])[3]"));
		
		Thread.sleep(3000);
		
		a.moveToElement(SearchSponserPhase).click().build().perform();
		Thread.sleep(1000);
		SearchSponserPhase.clear();
		Thread.sleep(1000);
		SearchSponserPhase.sendKeys(TA);
		WebElement PhaseTypeCheck=driver.findElement(By.xpath("//label[normalize-space(text())='"+Phase+"']/preceding-sibling::span"));
		PhaseTypeCheck.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//i[@class='fa fa-times'])[4]"));
		
		Thread.sleep(3000);
		
		a.moveToElement(SearchSponserStudyType).click().build().perform();
		Thread.sleep(1000);
		SearchSponserStudyType.clear();
		Thread.sleep(1000);
		SearchSponserStudyType.sendKeys(TA);
		WebElement StudyTypeCheck=driver.findElement(By.xpath("//label[normalize-space(text())='"+StudyType+"']/preceding-sibling::span"));
		StudyTypeCheck.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//i[@class='fa fa-times'])[5]"));
		Thread.sleep(3000);
		
		SearchSponserFacilitySearchBtn.click();
		Thread.sleep(5000);
	}
	
	public void EnterSponserCountryStateCityAndDepartmentType() throws Exception{
		properties=obj.getProperty();
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);	
		Map<String,String> testDataInMap = testData.getTestDatainMap();
		
		String Country=testDataInMap.get("CountryField");
		String States=testDataInMap.get("State");
		String City=testDataInMap.get("City");
		String DepartmentType=testDataInMap.get("NewDepartmentType");
		
		SearchSponserFacilityCountryField.clear();
		Thread.sleep(1000);
		SearchSponserFacilityCountryField.sendKeys(Country);
		SearchSponserFacilityCountryField.sendKeys(Keys.ARROW_DOWN);
		SearchSponserFacilityCountryField.sendKeys(Keys.ENTER);
		Thread.sleep(8000);
		SearchFacilityStateField.clear();
		Thread.sleep(1000);
		SearchFacilityStateField.sendKeys(States);
		SearchFacilityStateField.sendKeys(Keys.ARROW_DOWN);
		SearchFacilityStateField.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		SearchFacilitySopnserCityField.clear();
		Thread.sleep(1000);
		SearchFacilitySopnserCityField.sendKeys(City);
		
		Actions a=new Actions(driver);
		a.moveToElement(SearchSponserDepartmentType).click().build().perform();
		Thread.sleep(1000);
		SearchSponserDepartmentType.clear();
		Thread.sleep(1000);
		SearchSponserDepartmentType.sendKeys(DepartmentType);
		WebElement DepartmentTypeCheck=driver.findElement(By.xpath("//label[normalize-space(text())='"+DepartmentType+"']/preceding-sibling::span"));
		DepartmentTypeCheck.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//i[@class='fa fa-times']"));
		
		
		Thread.sleep(4000);
		SearchSponserFacilitySearchBtn.click();
		Thread.sleep(5000);
		
	}
	
	public void NevigateToSponserSearchFacility() throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,0)");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//i[@class='fa fa-plus']")).click();
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(4000);
		SearchSponserFacilityClearBtn.click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,300)");
		
	}
	public void EnterSponserCountryAndFacilitySearch() throws Exception{
		properties=obj.getProperty();
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);	
		Map<String,String> testDataInMap = testData.getTestDatainMap();
		
		String Country=testDataInMap.get("CountryField");
		String facilityName=testDataInMap.get("FacilityName");
		
		SearchSponserFacilityCountryField.sendKeys(Country);
		SearchSponserFacilityCountryField.sendKeys(Keys.ARROW_DOWN);
		SearchSponserFacilityCountryField.sendKeys(Keys.ENTER);
		Thread.sleep(8000);
		SearchSponserFacilityNameField.sendKeys(facilityName);
		Thread.sleep(4000);
		SearchSponserFacilitySearchBtn.click();
		Thread.sleep(5000);
		WebElement Facility1=driver.findElement(By.xpath("//a[text()='"+facilityName+"']"));
		highLightElement(Facility1);
	}
	
	public void clickonTheFacilityLink() throws Exception{
		properties=obj.getProperty();
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);	
		Map<String,String> testDataInMap = testData.getTestDatainMap();
		Thread.sleep(4000);
		String facilityName=testDataInMap.get("FacilityName");
		WebElement Facility1=driver.findElement(By.xpath("//a[text()='"+facilityName+"']"));
		Facility1.click();
		Thread.sleep(4000);
		
		
	}
	
	public void ClickOnDepartmentLink() throws Exception{
		properties=obj.getProperty();
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);	
		Map<String,String> testDataInMap = testData.getTestDatainMap();
		Thread.sleep(4000);
		
		String DepartmentName=testDataInMap.get("Facility+Department");
		WebElement Department1=driver.findElement(By.xpath("//a[text()='"+DepartmentName+"']"));
		Department1.click();
		Thread.sleep(4000);
		
	}
	
	
	public void EnterSponserCountryAndSIPID() throws Exception{
		properties=obj.getProperty();
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);	
		Map<String,String> testDataInMap = testData.getTestDatainMap();
		
		String Country=testDataInMap.get("CountryField");
		String SIPID=testDataInMap.get("SIPID");
		String facilityName=testDataInMap.get("FacilityName");
		
		SearchSponserFacilityCountryField.sendKeys(Country);
		SearchSponserFacilityCountryField.sendKeys(Keys.ARROW_DOWN);
		SearchSponserFacilityCountryField.sendKeys(Keys.ENTER);
		Thread.sleep(8000);
		SearchSponserFacilitySIPID.sendKeys(SIPID);
		Thread.sleep(4000);
		SearchSponserFacilitySearchBtn.click();
		Thread.sleep(5000);
		WebElement Facility1=driver.findElement(By.xpath("//a[text()='"+facilityName+"']"));
		highLightElement(Facility1);
		
	}
	
	public void EnterSponserCountry() throws Exception{
		properties=obj.getProperty();
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);	
		Map<String,String> testDataInMap = testData.getTestDatainMap();
		
		String Country=testDataInMap.get("CountryField");
		
		SearchSponserFacilityCountryField.sendKeys(Country);
		SearchSponserFacilityCountryField.sendKeys(Keys.ARROW_DOWN);
		SearchSponserFacilityCountryField.sendKeys(Keys.ENTER);
		Thread.sleep(8000);
		SearchSponserFacilitySearchBtn.click();
		Thread.sleep(5000);
	}
	
	public void EnterSponserCountryNew(String Country) throws Exception{
		SearchSponserFacilityCountryField.clear();
		Thread.sleep(3000);
		SearchSponserFacilityCountryField.sendKeys(Country);
		SearchSponserFacilityCountryField.sendKeys(Keys.ARROW_DOWN);
		SearchSponserFacilityCountryField.sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		SearchSponserFacilitySearchBtn.click();
		Thread.sleep(6000);
	}
	
	 public void EnterSponserCountryAndState(String Country, String States) throws Exception {
		 SearchSponserFacilityCountryField.clear();
		 Thread.sleep(3000);
		SearchSponserFacilityCountryField.sendKeys(Country);
		SearchSponserFacilityCountryField.sendKeys(Keys.ARROW_DOWN);
		SearchSponserFacilityCountryField.sendKeys(Keys.ENTER);
		Thread.sleep(8000);
		SearchFacilityStateField.clear();
		Thread.sleep(3000);
		SearchFacilityStateField.sendKeys(States);
		SearchFacilityStateField.sendKeys(Keys.ARROW_DOWN);
		SearchFacilityStateField.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		SearchSponserFacilitySearchBtn.click();
		Thread.sleep(6000);
		
	}
	
	public void EnterSponserCountryAndFacility(String Country,String facilityName) throws Exception{
		 SearchSponserFacilityCountryField.clear();
		 Thread.sleep(3000);
		SearchSponserFacilityCountryField.sendKeys(Country);
		SearchSponserFacilityCountryField.sendKeys(Keys.ARROW_DOWN);
		SearchSponserFacilityCountryField.sendKeys(Keys.ENTER);
		Thread.sleep(8000);
		
		SearchSponserFacilityNameField.clear();
		Thread.sleep(2000);
		SearchSponserFacilityNameField.sendKeys(facilityName);
		Thread.sleep(2000);
		SearchSponserFacilitySearchBtn.click();
		Thread.sleep(6000);
	}
	
	public void EnterSponserCountryAndDepartmentType(String Country,String Department) throws Exception{
		SearchSponserFacilityCountryField.clear();
		 Thread.sleep(3000);
		SearchSponserFacilityCountryField.sendKeys(Country);
		SearchSponserFacilityCountryField.sendKeys(Keys.ARROW_DOWN);
		SearchSponserFacilityCountryField.sendKeys(Keys.ENTER);
		Thread.sleep(8000);
		
		
		Actions a=new Actions(driver);
		a.moveToElement(SearchSponserDepartmentType).click().build().perform();
		Thread.sleep(1000);
		SearchSponserDepartmentType.clear();
		Thread.sleep(1000);
		SearchSponserDepartmentType.sendKeys(Department);
		WebElement DepartmentTypeCheck=driver.findElement(By.xpath("//label[normalize-space(text())='"+Department+"']/preceding-sibling::span"));
		DepartmentTypeCheck.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//i[@class='fa fa-times']"));
		
		Thread.sleep(2000);
		SearchSponserFacilitySearchBtn.click();
		Thread.sleep(6000);
	}
	
	
	public void ClickPlusIcon() throws Exception{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,0)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='fa fa-plus']")).click();
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//h2[text()='BY LOCATION']")));
		SearchSponserFacilityClearBtn.click();
		Thread.sleep(2000);
	}
	
	
	public void EnterSponserCountryStateFacilityNameAndSIPID() throws Exception{
		properties=obj.getProperty();
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);	
		Map<String,String> testDataInMap = testData.getTestDatainMap();
		
		String Country=testDataInMap.get("CountryField");
		String States=testDataInMap.get("State");
		String SIPID=testDataInMap.get("SIPID");
		String facilityName=testDataInMap.get("FacilityName");
		
		SearchSponserFacilityCountryField.sendKeys(Country);
		SearchSponserFacilityCountryField.sendKeys(Keys.ARROW_DOWN);
		SearchSponserFacilityCountryField.sendKeys(Keys.ENTER);
		Thread.sleep(8000);
		SearchFacilityStateField.sendKeys(States);
		SearchFacilityStateField.sendKeys(Keys.ARROW_DOWN);
		SearchFacilityStateField.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		SearchSponserFacilityNameField.sendKeys(facilityName);
		Thread.sleep(2000);
		SearchSponserFacilitySIPID.sendKeys(SIPID);
		Thread.sleep(2000);
		SearchSponserFacilitySearchBtn.click();
		Thread.sleep(6000);
		WebElement Facility1=driver.findElement(By.xpath("//a[text()='"+facilityName+"']"));
		highLightElement(Facility1);
		
	}
	
	
	public void EntersponserCountryFacilitynameDepartmentType() throws Exception{
		properties=obj.getProperty();
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);	
		Map<String,String> testDataInMap = testData.getTestDatainMap();
		
		String Country=testDataInMap.get("CountryField");
		String facilityName=testDataInMap.get("FacilityName");
		String DepatmentType=testDataInMap.get("NewDepartmentType");
		
		SearchSponserFacilityCountryField.sendKeys(Country);
		SearchSponserFacilityCountryField.sendKeys(Keys.ARROW_DOWN);
		SearchSponserFacilityCountryField.sendKeys(Keys.ENTER);
		Thread.sleep(8000);
		
		SearchSponserFacilityNameField.sendKeys(facilityName);
		Thread.sleep(2000);
Actions action=new Actions(driver);
action.moveToElement(SearchSponserDepartmentType).click().build().perform();
SearchSponserDepartmentType.sendKeys(DepatmentType);
Thread.sleep(2000);

WebElement CheckDepatmenType=driver.findElement(By.xpath("//label[text()=' "+DepatmentType+"']/preceding-sibling::span"));
CheckDepatmenType.click();
Thread.sleep(1000);
driver.findElement(By.xpath("(//i[@class='fa fa-times'])[1]")).click();
Thread.sleep(2000);

		SearchSponserFacilitySearchBtn.click();
		Thread.sleep(6000);
		
		WebElement Facility1=driver.findElement(By.xpath("//a[text()='"+facilityName+"']"));
		highLightElement(Facility1);
	}
	
	
	public void VerifyFacilitySearch() throws InterruptedException{
		Thread.sleep(2000);
		try{
			for(int i=1;i<6;i++){
				highLightElement(driver.findElement(By.xpath("(//td[@class='sorting_1']/following-sibling::td)["+i+"]")));
				Thread.sleep(2000);
			}
			
		}catch(Exception e){}
	}
	
	public void RemoveOneIPshippingLocation() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[contains(@class,'float-right r2toggleDefaultPlusIcon')])[1]")).click();
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		//revome
		driver.findElement(By.id("btnShippingLocDelete_1")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[text()='OK'])[3]")).click();
		Thread.sleep(5000);
		
		
	}
	
	public void SaveAndVerify() throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,1800)");
		//save the change
		Thread.sleep(3000);
		driver.findElement(By.id("facility-save-button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='modal-controls text-align-center']//button[1]")).click();
	}
	
	public void ClickOnViewDepartmentAndVerify() throws Exception{
		properties=obj.getProperty();
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);	
		Map<String,String> testDataInMap = testData.getTestDatainMap();
		String DepartmentName=testDataInMap.get("NewDepartmentName");
		Thread.sleep(2000);
		try{
			
			driver.findElement(By.xpath("(//i[contains(@class,'fa fa-binoculars')])[1]")).click();
			Thread.sleep(4000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,150)");
			
			//Verify
			WebElement Department1=driver.findElement(By.xpath("//a[text()='"+DepartmentName+"']"));
			highLightElement(Department1);
			Thread.sleep(2000);
			for(int i=3;i<7;i++){
				highLightElement(driver.findElement(By.xpath("//table[@id='departmentResults']/tbody[1]/tr[1]/td["+i+"]")));
				Thread.sleep(2000);
			}
			
			
		}catch(Exception e){}
	}
	
	public void CheckFacilityClickOnViewDepartment(String fac) throws Exception{
		properties=obj.getProperty();
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);	
		Map<String,String> testDataInMap = testData.getTestDatainMap();
		
		String facilityname=testDataInMap.get(fac);
		facilityname.trim();
		
		try{
			WebElement facilityCheck=driver.findElement(By.xpath("//a[text()='"+facilityname+"']/ancestor::td/preceding-sibling::td//span"));
			facilityCheck.click();
		}catch(Exception e){}
		Thread.sleep(4000);
		try{
			WebElement ViewDepartment=driver.findElement(By.xpath("//a[text()='"+facilityname+"']/ancestor::td/following-sibling::td[5]/div/i"));
			ViewDepartment.click();
		}catch(Exception e){}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
	}
	
	public void CheckFacility(String fac) throws Exception{
		properties=obj.getProperty();
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);	
		Map<String,String> testDataInMap = testData.getTestDatainMap();
		
		String facilityname=testDataInMap.get(fac);
		facilityname.trim();
		
		try{
			WebElement facilityCheck=driver.findElement(By.xpath("//a[text()='"+facilityname+"']/ancestor::td/preceding-sibling::td//span"));
			facilityCheck.click();
		}catch(Exception e){}
		Thread.sleep(4000);
	}

	public void ClickOnFacilityHyperlinkOnSearch(String Fac) throws Exception{
		properties=obj.getProperty();
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);	
		Map<String,String> testDataInMap = testData.getTestDatainMap();
		
		String facilityname1=testDataInMap.get(Fac);
	
		facilityname1.trim();
		
		
	
			WebElement facilityhyper1=driver.findElement(By.linkText(facilityname1));
			facilityhyper1.click();
		
		
	}
	
	public void NevigateBackToSearchfacility() throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		SearchFacilityCancelbtn.click();
		Thread.sleep(4000);
		SearchFacilityClearBtn.click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,200)");

	}

	public void selectFacilityCheckBoxAndAdd(String arg) throws Exception{
		properties=obj.getProperty();
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);	
		Map<String,String> testDataInMap = testData.getTestDatainMap();
		String FacilityName=testDataInMap.get(arg);
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[text()='"+FacilityName+"']/preceding-sibling::td/input")).isDisplayed();
		driver.findElement(By.xpath("//td[text()='"+FacilityName+"']/preceding-sibling::td/input")).click();
		Thread.sleep(4000);
		AddFacilityToUser.click();
		Thread.sleep(2000);
	}
	
	public void SelectDepartmentCheckBoxAndAdd(String Department) throws Exception{
		properties=obj.getProperty();
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);	
		Map<String,String> testDataInMap = testData.getTestDatainMap();
		String department=testDataInMap.get(Department);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[text()='"+department+"']/preceding-sibling::td/label/input/following-sibling::span")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("addDepartmentBtn")).click();
		Thread.sleep(2000);
	}
	
	
	
	
	public void ClickOnApproveTheChange() throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,1000)");
		Thread.sleep(4000);
		try{
			driver.findElement(By.xpath("//input[@value='Approve This Change']")).click();
		}catch(Exception e){}
		Thread.sleep(4000);
		//ClickSendAffiliation
		try{
			driver.findElement(By.xpath("(//button[@id='approveFacilitySection'])[1]")).click();
		}catch(Exception e){}
		
	}
	
	public void ClickOnOk() throws InterruptedException{
		Thread.sleep(2000);
		try{
			driver.findElement(By.xpath("(//input[@id='approveAllOk'])[2]")).click();
		}catch(Exception e){}
	}
	public void ClickOnOkForFacilityAlreadyAdded() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[text()='OK '])[2]")).click();
		
	}
	
	public void VerifyAddDepartment() throws InterruptedException{
		
		try{
			Thread.sleep(2000);
			AddDepartmentHeader.isDisplayed();
			highLightElement(AddDepartmentHeader);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,100)");
			Thread.sleep(2000);
			AddDepartmentBtn.isDisplayed();
			highLightElement(AddDepartmentBtn);
	        CreatDepartmentBtn.isDisplayed();
	        highLightElement(CreatDepartmentBtn);
	        NODepartmentBtn.isDisplayed();
	        highLightElement(NODepartmentBtn);
		}catch(Exception e){System.out.println("error");}
		
	}
	public void ClickOnCreatNewDepartment() throws InterruptedException{
		Thread.sleep(5000);
		highLightElement(CreatDepartmentBtn);
		CreatDepartmentBtn.click();
		Thread.sleep(5000);
	}
	
	public void EnterDepartmentTypeAndNameUnderCreatNewDepartment() throws Exception{
		properties=obj.getProperty();
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);	
		Map<String,String> testDataInMap = testData.getTestDatainMap();
		String NewDepartmentName=testDataInMap.get("NewDepartmentName");
		String NewDepartmentType=testDataInMap.get("NewDepartmentType");
		Thread.sleep(5000);
		
		System.out.println(NewDepartmentName);
		System.out.println(NewDepartmentType);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(5000);
		
		departmentname1.sendKeys(NewDepartmentName);
		Thread.sleep(8000);
		
		Select departmenttype1 = new Select (departmenttype);
		departmenttype1.selectByVisibleText(NewDepartmentType);
		Thread.sleep(8000);
		
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(5000);
		savebu.click();
		Thread.sleep(6000);
	}
	
	public void ClickI_WIL_MAINTAIN_THE_DEPARTMENT_PROFILE() throws InterruptedException{
		Thread.sleep(4000);
		I_WIL_MAINTAIN_THE_DEPARTMENT_PROFILE.click();
		
	}
	
	public void go_To_myUserProfile(){
		GoToMyUserProfile.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", facilities);
	}
	
	
	public void ClickOnIwillAssignSomeOneElse() throws InterruptedException{
		Thread.sleep(4000);
		I_WIL_assign_someOneElse.click();
		
	}
	public void ClickOnCountinue_Updates() throws InterruptedException{
		Thread.sleep(3000);
		Countinue_Updating_This_Department.click();
		Thread.sleep(3000);
		PopulatedDepartmentTitle.isDisplayed();
		highLightElement(PopulatedDepartmentTitle);
	}
	
	public void EnterDepartmentManually() throws InterruptedException{
		EnterDepartmentManuual.click();
		Thread.sleep(3000);
		
	}
	
	@FindBy(how=How.ID, using="byFDLastName")
	public WebElement LastName;
	
	@FindBy(how=How.ID, using="byFDFirstName")
	public WebElement firstName;
	
	public void EnterEmailAddressToSearch(String email) throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		String Email=email;
		driver.findElement(By.xpath("//*[@id=\"byFDEmailAddress\"]")).sendKeys(Email);
		Thread.sleep(3000);
		try{
			if(LastName.isEnabled()){
				System.out.println(" Test Fail");
			}
			else {
				System.out.println("Test Pass");
			}
			
		}catch(Exception e){
		System.out.println("error");
		}
		
		try{
			if(firstName.isEnabled()){
				System.out.println(" Test Fail");
			}
			else {
				System.out.println("Test Pass");
			}
			
		}catch(Exception e){
		System.out.println("error");
		}

	}
	
	public void NevigateToFacilityContact() throws InterruptedException{
		Thread.sleep(3000);
		FacilityContact.click();
		Thread.sleep(3000);
	}
	
	public void add_Site_User_as(String SiteUser){
		email.sendKeys(SiteUser);
		FacilityContactSitesearch.click();
		
	}
	
	public void VerifyFacilityContactFPM() throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
		Thread.sleep(2000);
		highLightElement(driver.findElement(By.xpath("(//td[@scope='col']//div)[2]")));
	}
	
	public void EditStateProvinceRegion() throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
		Thread.sleep(4000);
		//edit StateProvinceRegion
		WebElement State=driver.findElement(By.id("State_list_id"));
		State.clear();
		Thread.sleep(4000);
		State.sendKeys("Rondônia");//if country is brazil
		State.sendKeys(Keys.ARROW_DOWN);
		State.sendKeys(Keys.ENTER);
		
		Thread.sleep(4000);
		
		//SaveIt
		driver.findElement(By.id("facility-save-button")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//div[@class='modal-controls text-align-center']//button[1]")).click();
		Thread.sleep(2000);
		highLightElement(driver.findElement(By.xpath("//input[@id='inst-name']")));
	}	
	public void ClickOnaddDepatmentContact() throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()[normalize-space()='Add Department Contact']]")).click();
	}
	
	public void ClickOnAddFacilityContact() throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,600)");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()[normalize-space()='Add Facility Contact']]")).click();
	}
	
	
	
	public void SelectFacilityandsearch(String facility) throws Exception{
		properties=obj.getProperty();
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);	
		Map<String,String> testDataInMap = testData.getTestDatainMap();
		String facDep=testDataInMap.get(facility);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//span[@class='site-sel-container tAsite-sel-container'])[1]")).click();
		Thread.sleep(3000);
		WebElement checkselected = driver
				.findElement(By.xpath("//label[text()='"+facDep+"']/preceding-sibling::span"));

		checkselected.click();
	}
	
	
	@FindBy(how=How.XPATH, using="//input[contains(@class,'selectFacBtn form-radio-btn')]")
	public WebElement SiteUserCheckbox;
	
	@FindBy(how=How.XPATH, using="//button[contains(@class,'primary-btn modal-popup-link')]")
	public WebElement SelectFacilityContactbtn;
	
	@FindBy(how=How.XPATH, using="(//input[@class='form-checkbox-btn ui-helper-hidden-accessible']/following-sibling::span)[5]")
	public WebElement SelectFPM;
	
	public void select_contact_type_as_FPM() throws InterruptedException{
		SiteUserCheckbox.click();
		SelectFacilityContactbtn.click();
		Thread.sleep(2000);
		SelectFPM.click();
		
	}
	
	@FindBy(how=How.XPATH, using="//button[text()='CLEAR SEARCH']")
	public WebElement ClearSearch;
	
	public void ClickOnClearSearch() throws InterruptedException{
		ClearSearch.click();
		Thread.sleep(3000);
	}
	
	public void ClickOnDepartmentContactSearch() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='SEARCH']")).click();
		Thread.sleep(3000);
	}
	
public void SelectRoleFromFacilityContact() throws InterruptedException{
	Thread.sleep(3000);
	WebElement scrollbar = null;
	//Vertical Scroll 1
			try{
				Thread.sleep(3000);
				
				 scrollbar=driver.findElement(By.xpath("(//div[contains(@style,'line-height')])[1]"));
				Thread.sleep(2000);
			}catch(Exception e){
				System.out.println("ScrollError");
			}
			
			//Vertical Scroll 2
					try{
						Thread.sleep(3000);
						
						 scrollbar=driver.findElement(By.xpath("(//div[contains(@style,'line-height')])[2]"));
						Thread.sleep(2000);
					}catch(Exception e){
						System.out.println("ScrollError");
					}
					
					//Vertical Scroll3
					try{
						Thread.sleep(3000);
						
						 scrollbar=driver.findElement(By.xpath("(//div[contains(@style,'line-height')])[3]"));
						Thread.sleep(2000);
					}catch(Exception e){
						System.out.println("ScrollError");
					}
	
					Actions actions = new Actions(driver);
					  actions.moveToElement(scrollbar).build().perform();
					  Thread.sleep(3000);
					  actions.dragAndDropBy(scrollbar, 0, 200).perform();
					  
					  
					  //Regulatory Contact
					  try{
							Thread.sleep(3000);
							driver.findElement(By.xpath("(//input[@class='form-checkbox-btn ui-helper-hidden-accessible']/following-sibling::span)[8]")).click();
							
						}catch(Exception e){
							System.out.println("ScrollError");
						}
					  
}

public void SelectSaveUnderFacilityContact() throws InterruptedException{
	driver.findElement(By.xpath("//button[@title='Save']")).click();
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", FacilityContact);
}
	
	public void ClickOnRadiobuttonAndSelectDepartmentContact() throws InterruptedException{
		Thread.sleep(3000);
		//Select Radio
		driver.findElement(By.xpath("//input[contains(@class,'selectFacBtn form-radio-btn')]")).click();
		Thread.sleep(3000);
		
		//SelectDepartment
		driver.findElement(By.xpath("//button[contains(@class,'primary-btn modal-popup-link')]")).click();
		Thread.sleep(3000);
	}
	
	public void ClickOnRadiobuttonAndSelectFacilityContact() throws InterruptedException{
		Thread.sleep(3000);
		//Select Radio
		driver.findElement(By.xpath("(//input[contains(@class,'selectFacBtn form-radio-btn')])[2]")).click();
		Thread.sleep(3000);
		
		//SelectDepartment
		driver.findElement(By.xpath("//button[contains(@class,'primary-btn modal-popup-link')]")).click();
		Thread.sleep(3000);
	}
	
	public void SelectSiteUserForDepartmentContact(String role) throws InterruptedException{
		Thread.sleep(3000);
		//Select Radio
		driver.findElement(By.xpath("//input[contains(@class,'selectFacBtn form-radio-btn')]")).click();
		Thread.sleep(3000);
		
		//SelectDepartment
		driver.findElement(By.xpath("//button[contains(@class,'primary-btn modal-popup-link')]")).click();
		Thread.sleep(3000);
		try{
			if(role.equalsIgnoreCase("Budget/Financial Contact")){
				driver.findElement(By.xpath("(//input[@class='form-checkbox-btn ui-helper-hidden-accessible']/following-sibling::span)[1]")).click();
			}
		}catch(Exception e){System.out.println("Error");}
		Thread.sleep(3000);
		
		WebElement scrollbar = null;
		//Vertical Scroll 1
				try{
					Thread.sleep(3000);
					
					 scrollbar=driver.findElement(By.xpath("(//div[contains(@style,'line-height')])[1]"));
					Thread.sleep(2000);
				}catch(Exception e){
					System.out.println("ScrollError");
				}
				
				//Vertical Scroll 2
						try{
							Thread.sleep(3000);
							
							 scrollbar=driver.findElement(By.xpath("(//div[contains(@style,'line-height')])[2]"));
							Thread.sleep(2000);
						}catch(Exception e){
							System.out.println("ScrollError");
						}
		
       Actions actions = new Actions(driver);
		  actions.moveToElement(scrollbar).build().perform();
		  Thread.sleep(3000);
		  actions.dragAndDropBy(scrollbar, 0, 150).perform();
		
		try{
			if(role.equalsIgnoreCase("Department Profile Manager")){
				
				driver.findElement(By.xpath("(//input[@class='form-checkbox-btn ui-helper-hidden-accessible']/following-sibling::span)[5]")).click();
			}
		}catch(Exception e){
			System.out.println("Error");}
		Thread.sleep(3000);
		//Save
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		Thread.sleep(10000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
		
	}
	
	public void ClickOnEditOfSiteUser(String Email) throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
		Thread.sleep(3000);
		
		try{ 
			
			WebElement EditUser=driver.findElement(By.xpath("//a[text()='"+Email+"']//parent::div//parent::td/following-sibling::td[2]/div/i[1]"));
			Thread.sleep(3000);
			EditUser.click();
		
		}catch(Exception e){
			System.out.println("Error1");
		}
		
		
		
		WebElement scrollbar = null;
		//Vertical Scroll 1
		try{
			Thread.sleep(3000);
			
			 scrollbar=driver.findElement(By.xpath("(//div[contains(@style,'line-height')])[1]"));
			Thread.sleep(2000);
		}catch(Exception e){
			System.out.println("ScrollError");
		}
		
		//Vertical Scroll 2
				try{
					Thread.sleep(3000);
					
					 scrollbar=driver.findElement(By.xpath("(//div[contains(@style,'line-height')])[2]"));
					Thread.sleep(2000);
				}catch(Exception e){
					System.out.println("ScrollError");
				}
		 
       Actions actions = new Actions(driver);
		  actions.moveToElement(scrollbar).build().perform();
		  Thread.sleep(3000);
		  actions.dragAndDropBy(scrollbar, 0, 150).perform();  
		
		
	}
	
	public void VerifyFacilityDepartmentContact(String email) throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(3000);
     try{ 
			
			WebElement User=driver.findElement(By.xpath("//a[text()='"+email+"']//parent::div"));
			Thread.sleep(3000);
			if(User.isDisplayed()){
			highLightElement(User);
			}
		}catch(Exception e){
			System.out.println("No such Contact Present");
		}
	}
	
	public void ClickOnFlagOfSiteUserThree() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='ui-radio'])[3]")).click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
	}
	
	public void ClickOnCancelUnderEditDepartmentRole() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='CANCEL']")).click();
		Thread.sleep(3000);
	}
	
	public void selectDPMrole() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@class='form-checkbox-btn ui-helper-hidden-accessible']/following-sibling::span)[5]")).click();
		Thread.sleep(3000);
	}
	
	public void SelectBudgetFinancialContact() throws InterruptedException{
		WebElement scrollbar = null;
		//Vertical Scroll 1
		try{
			Thread.sleep(3000);
			
			 scrollbar=driver.findElement(By.xpath("(//div[contains(@style,'line-height')])[1]"));
			Thread.sleep(2000);
		}catch(Exception e){
			System.out.println("ScrollError");
		}
		
		//Vertical Scroll 2
				try{
					Thread.sleep(3000);
					
					 scrollbar=driver.findElement(By.xpath("(//div[contains(@style,'line-height')])[2]"));
					Thread.sleep(2000);
				}catch(Exception e){
					System.out.println("ScrollError");
				}
				 Actions actions = new Actions(driver);
				  actions.moveToElement(scrollbar).build().perform();
				  Thread.sleep(3000);
				  actions.dragAndDropBy(scrollbar, 0, -150).perform();  
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//input[@class='form-checkbox-btn ui-helper-hidden-accessible']/following-sibling::span)[1]")).click();
		Thread.sleep(3000);
	}
	
	public void DeselectDPMroleAndSelectContractManager() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@class='form-checkbox-btn ui-helper-hidden-accessible']/following-sibling::span)[5]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@class='form-checkbox-btn ui-helper-hidden-accessible']/following-sibling::span)[3]")).click();
	}
	
	public void ClickonSaveUnderEditDepartmentRole() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
	}
	public void ClickOnSendRegistrationInvite() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@id='closeRegSIP'])[1]")).click();
		Thread.sleep(4000);
		highLightElement(driver.findElement(By.xpath("//h1[text()='Registration Invite Sent']")));
	}
	
	public void ClickOKForConfirmation() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='modalSendRegConfirmation']/div[2]/div[1]/div[1]/button[1]")).click();
		Thread.sleep(3000);
	}
	
	public void ClicKOKonWarning() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[@class='popupFont']/following-sibling::button[1]")).click();
		Thread.sleep(5000);
	}
	
	public void ClicKOK() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@class='secondary-btn modal-close'])[3]")).click();
		Thread.sleep(10000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
	}
	
public void RemoveSiteUserFromeDepartmentContact(String Email) throws InterruptedException{
	Thread.sleep(3000);
	WebElement CrosstheUser=driver.findElement(By.xpath("//a[text()='"+Email+"']//parent::div//parent::td/following-sibling::td[2]/div/i[2]"));
	Thread.sleep(3000);
	CrosstheUser.click();
	highLightElement(driver.findElement(By.id("messageDelete")));
}
	
	public void VerifyTherapeuticAreasAndClickDepartmentContact() throws InterruptedException{
		highLightElement(driver.findElement(By.xpath("//h2[@class='medium-header-h2 border-bottom']")));
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(3000);
		
		//DepartmentContactbtn
		driver.findElement(By.xpath("//button[@class='button-link-btn prevArrowBtn']")).click();
	}
	
	public void VerifySendRegistrationInvite() throws InterruptedException{
		Thread.sleep(3000);
		highLightElement(driver.findElement(By.xpath("(//button[@id='closeRegSIP'])[1]")));
	}
	
	public void ClickOnCancelNewRegistration() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@id='closeRegSIP'])[2]")).click();
	}
	
	public void ClickOnCancelFordepartmentContact() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[text()='CANCEL'])[1]")).click();
	}
	
	public void ClickOnIWillMaintainTheFacilityProfile() throws Exception{
		properties=obj.getProperty();
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);	
		Map<String,String> testDataInMap = testData.getTestDatainMap();
		String FacilityName=testDataInMap.get("FacilityName");
		
		
		Thread.sleep(2000);
		I_WIL_MAINTAIN_THE_FACILITY_PROFILE.click();
		Thread.sleep(10000);
		FacilitiesHeader.isDisplayed();
		highLightElement(FacilitiesHeader);
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		highLightElement(driver.findElement(By.xpath("//td[@class='globalcountry width270']/div/a[text()='"+FacilityName+"']")));
		Thread.sleep(6000);
	}
	public void ClickOnHyperLink() throws Exception{
		properties=obj.getProperty();
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);	
		Map<String,String> testDataInMap = testData.getTestDatainMap();
		Thread.sleep(2000);
		String FacilityName=testDataInMap.get("FacilityName2");
		driver.findElement(By.linkText(FacilityName)).click();
		Thread.sleep(8000);
	}
	
	public void ClickOn_EnterFacilityProfileManuallyAndVerifyPage() throws InterruptedException{
		EnterFacilityManuual.click();
		Thread.sleep(8000);
		FacilityContact.isDisplayed();
		highLightElement(FacilityContact);
	}



	public void NavigatetoIRBLocalIRBandverify() throws Exception
	{


		System.out.println("check1");
		Thread.sleep(3000);

		Thread.sleep(3000);
		String currentwindow = driver.getWindowHandle();
		System.out.println(currentwindow);
		Facility1.click();
		Thread.sleep(6000);


		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentid = it.next();
		String childid = it.next();
		driver.switchTo().window(childid);
		System.out.println(driver.getTitle());
		Thread.sleep(3000);

		Thread.sleep(6000);
		highLightElement(facilitynamaddress);
		Thread.sleep(3000);
		highLightElement(IRB);
		IRB.click();
		Thread.sleep(5000);
		Thread.sleep(5000);

		highLightElement(onscrn1);
		Thread.sleep(3000);
		highLightElement(onscrn2);
		Thread.sleep(3000);
		highLightElement(onscrn3);
		Thread.sleep(3000);
		highLightElement(onscrn4);
		Thread.sleep(3000);
		highLightElement(onscrn5);
		Thread.sleep(3000);
		highLightElement(onscrn6);
		Thread.sleep(3000);
		highLightElement(onscrn7);
		Thread.sleep(3000);

		if(onscrn1.getText().contains("What is the average time (in days) to start a study once you have received the regulatory package?"))
		{
			System.out.println("Test pass");
		}
		else
		{
			System.out.println("Test Fail");

		}
		if(onscrn2.getText().contains("Does your Facility perform IRB/ERB/Ethics Committee submissions?"))
		{
			System.out.println("Test pass");
		}
		else
		{
			System.out.println("Test Fail");

		}
		if(onscrn3.getText().contains("Does your Facility have a dedicated department or group to perform IRB/ERB/Ethics Committee submissions?"))
		{
			System.out.println("Test pass");
		}
		else
		{
			System.out.println("Test Fail");

		}
		if(onscrn4.getText().contains("Is your Facility able to initiate study activities prior to IRB/ERB/Ethics Committee protocol approval?"))
		{
			System.out.println("Test pass");
		}
		else
		{
			System.out.println("Test Fail");

		}
		if(onscrn5.getText().contains("What types of IRB/ERB/Ethics Committee does your Facility use? (Select all that apply)"))
		{
			System.out.println("Test pass");
		}
		else
		{
			System.out.println("Test Fail");

		}

		if(onscrn6.getText().contains("Does your institution and/or local regulation mandate the distribution of safety reports [e.g., Development Safety Update Report (DSUR), suspected unexpected serious adverse reaction (SUSAR)] to a local Review only IRB/ERB/Ethics Committee?"))
		{
			System.out.println("Test pass");
		}
		else
		{
			System.out.println("Test Fail");

		}
		if(onscrn7.getText().contains("Are there any other steps that the Sponsor should be aware of for your IRB/ERB/Ethics committee review and submission?"))
		{
			System.out.println("Test pass");
		}
		else
		{
			System.out.println("Test Fail");

		}

		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);


	}



	public void NavigatetoMyfacility() throws Exception
	{


		Thread.sleep(3000);
		Actions action=new Actions(driver);
		action.moveToElement(Facility).build().perform();
		Thread.sleep(3000);
		Myfacility.click();
		Thread.sleep(3000);
		facilities.isDisplayed();
		highLightElement(facilities);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", facilities);
		
		

	}
	
	public void ClickOnAddFacilityandVerify() throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(3000);
		AddFacilityBtn.click();
		Thread.sleep(3000);
	}


	public void verifyfacility1() throws Exception
	{


		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		facilities1.isDisplayed();
		Thread.sleep(3000);


	}



	public void NavigatetoIRBERB() throws Exception
	{


		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(5000);
		irb.click();
		Thread.sleep(7000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,-1000)");
		Thread.sleep(3000);
		
		highLightElement(onscrn1);
		Thread.sleep(3000);
		IRBAns1.click();
		Thread.sleep(2000);
		highLightElement(onscrn2);
		Thread.sleep(3000);
		IRBAns2.click();
		highLightElement(onscrn3);
		Thread.sleep(3000);
		IRBAns3.click();
		js.executeScript("window.scrollBy(0,200)");
		highLightElement(onscrn4);
		Thread.sleep(3000);
		IRBAns4.click();
		highLightElement(onscrn5);
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(3000);
		IRBAns5.click();
		highLightElement(onscrn6);
		
		Thread.sleep(3000);
		IRBAns6.click();
		highLightElement(onscrn7);
		Thread.sleep(3000);
		IRBAns7.click();
		Thread.sleep(3000);
		js.executeScript("window.scrollTo(0,50)");
		
		

//		Thread.sleep(3000);
//		localirb.click();
//		Thread.sleep(3000);
//
//		Thread.sleep(3000);

	}
	
	public void NevigateToLocalIRB() throws InterruptedException{
		Thread.sleep(3000);
		localirb.click();
		Thread.sleep(3000);
		localirbtitle.isDisplayed();
		highLightElement(localirbtitle);
		
	}
	public void EnterLocalIRBdetailsWithoutName() throws InterruptedException{
		Thread.sleep(3000);
		streenname.sendKeys("11 lower street");
		Thread.sleep(3000);
		try{
			driver.findElement(By.xpath("//div[@class='pac-container hdpi']//button[1]")).click();
		}catch(Exception e){
			System.out.println("No");
		}
		Thread.sleep(8000);
		country.sendKeys("Afghanistan");
		country.sendKeys(Keys.ARROW_DOWN);
		country.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		states.sendKeys("Badakhshān");
		states.sendKeys(Keys.ARROW_DOWN);
		states.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		city.sendKeys("Newcity");
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='irbMeetingFreq1_0']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='irbReviewSubmission1_0']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@id='formId_0'])[1]")).click();
		Thread.sleep(4000);
		highLightElement(driver.findElement(By.xpath("(//h1[text()='Enter Mandatory Fields'])[1]")));
	}
	public void EnterLocalIRBdetailsWithName() throws InterruptedException{
		OKbtn.click();
		Thread.sleep(4000);
        removeBtn.click();
        Thread.sleep(6000);
        cometeename.sendKeys("FCKiet");
        Thread.sleep(2000);
        streenname.sendKeys("11 lower street");
		Thread.sleep(3000);
		try{
			driver.findElement(By.xpath("//div[@class='pac-container hdpi']//button[1]")).click();
		}catch(Exception e){
			System.out.println("No");
		}
		Thread.sleep(8000);
		country.sendKeys("Afghanistan");
		country.sendKeys(Keys.ARROW_DOWN);
		country.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		states.sendKeys("Badakhshān");
		states.sendKeys(Keys.ARROW_DOWN);
		states.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		city.sendKeys("Newcity");
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='irbMeetingFreq1_0']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='irbReviewSubmission1_0']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@id='formId_0'])[1]")).click();
		Thread.sleep(4000);
		highLightElement(successMsg);
	}
	
	public void ReturntoPreviousPage(){
		OKsuccesbtn.click();
	}


	public void Enterrestinfo() throws Exception
	{


		Thread.sleep(3000);
		streenname.sendKeys("11 lower street");
		Thread.sleep(3000);
		Robot robot3 = new Robot();  
		Thread.sleep(2000); 
		robot3.keyPress(KeyEvent.VK_DOWN); 	
		Thread.sleep(2000);  
		robot3.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);  
		robot3.keyPress(KeyEvent.VK_ENTER); 	
		Thread.sleep(2000);  
		robot3.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(10000);

		building.sendKeys("12 th");
		Thread.sleep(3000);
		/*additionaladdress.sendKeys("130 abc road");
	Thread.sleep(3000);
	country.sendKeys("Afghanistan");
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

    states.sendKeys("Badakhshān");
    Thread.sleep(5000);
    Robot robot2 = new Robot();  
    Thread.sleep(2000); 
    robot2.keyPress(KeyEvent.VK_DOWN); 	
    Thread.sleep(2000);  
    robot2.keyRelease(KeyEvent.VK_DOWN);
    Thread.sleep(2000);  
    robot2.keyPress(KeyEvent.VK_ENTER); 	
    Thread.sleep(2000);  
    robot2.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(5000);
    JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,250)");
	Thread.sleep(2000); 
    city.sendKeys("Newcity");
    Thread.sleep(2000); 
    zip.sendKeys("736764764");

		 */


	}


	public void Enterregistrationnamesave() throws Exception
	{

		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,250)");
		Thread.sleep(3000);
		regno.sendKeys("R123444");
		Thread.sleep(3000);
		close.click();
		Thread.sleep(3000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,600)");
		Thread.sleep(3000);
		save.click();
		Thread.sleep(3000);
		highLightElement(popuptext);
		Thread.sleep(3000);
		ok.click();
		Thread.sleep(3000);


	}


	public void Enternameandsave() throws Exception
	{

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-1000)");
		Thread.sleep(3000);
		cometeename.sendKeys("Committee 1");
		Thread.sleep(3000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,600)");
		Thread.sleep(3000);

		save.click();
		Thread.sleep(3000);
		//highLightElement(popuptext1);
		Thread.sleep(3000);
		//ok1.click();
		Thread.sleep(10000);


	}


	public void Generatereportverify() throws Exception
	{
		Thread.sleep(3000);
		reports.click();
		Thread.sleep(10000);
		Select reportdropdown2 = new Select (reportdropdown);
		reportdropdown2.selectByVisibleText("Site User Delegation Details Report");
		Thread.sleep(7000);
		facilitynames.click();
		Thread.sleep(5000);
		fa1check.click();
		Thread.sleep(3000);
		fa2check.click();
		Thread.sleep(3000);
		close1.click();
		Thread.sleep(3000);
		delegationtype.sendKeys("Regulatory Contact (PI Delegate)");
		Thread.sleep(3000);
		chck1.click();
		Thread.sleep(3000);
		clos.click();
		Thread.sleep(3000);
		generatereport.click();
		Thread.sleep(6000);
		Okkkkk.click();


	}


	public void removeedelegation() throws Exception
	{

		Thread.sleep(6000);
		Admin.click();
		Thread.sleep(6000);
		Managedelegation.click();
		Thread.sleep(6000);



	}




	public void Generatereportverify1() throws Exception
	{
		reports.click();
		Thread.sleep(7000);
		Select reportdropdown2 = new Select (reportdropdown);
		reportdropdown2.selectByVisibleText("Site User Delegation Details Report");
		Thread.sleep(7000);
		facilitynames.click();
		Thread.sleep(5000);
		fa1check.click();
		Thread.sleep(3000);
		fa2check.click();
		Thread.sleep(3000);
		close1.click();
		Thread.sleep(3000);
		delegationtype.sendKeys("Regulatory Contact (PI Delegate)");
		Thread.sleep(3000);
		chck1.click();
		Thread.sleep(3000);
		clos.click();
		Thread.sleep(3000);
		generatereport.click();
		Thread.sleep(6000);
		Okkkkk.click();

	}





	public void Navigatetomyfacilityandverify() throws Exception
	{

		Thread.sleep(6000);
		Facility.click();
		Thread.sleep(6000);
		Myfacility.click();
		Thread.sleep(6000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(6000);
		highLightElement(facility1name);
		Thread.sleep(6000);
		highLightElement(facility1address);	
		Thread.sleep(6000);
	}

	public void PDFExport() throws Exception
	{

		Thread.sleep(6000);
		action1.click();
		Thread.sleep(6000);
		exportdepartmentprofile.click();
		Thread.sleep(6000);
		pdf.click();
		Thread.sleep(6000);
		export.click();
		Thread.sleep(6000);
		highLightElement(title);
		Thread.sleep(6000);
		highLightElement(onscreen);	
		Thread.sleep(6000);
		highLightElement(ok2);	
		Thread.sleep(6000);
		if(title.getText().contains("Export Department 001 Profile"))
		{
			System.out.println("Test pass");
		}
		else
		{
			System.out.println("Test Fail");

		}
		if(onscreen.getText().contains("Department 001 profile export request received. A task shall be assigned once the department profile export is available and you may download the same from the task."))
		{
			System.out.println("Test pass");
		}
		else
		{
			System.out.println("Test Fail");

		}
		ok2.click();

		Thread.sleep(6000);	
	}

	public void verifytaskreceived() throws Exception
	{
		home.click();
		//Thread.sleep(90000);
		Thread.sleep(6000);
		Mytask.click();
		Thread.sleep(6000);	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(6000);	
		recievedsort.click();
		Thread.sleep(6000);	
		tasktitle.click();
		Thread.sleep(6000);	


	}


	public void Clickondepartmentprofle() throws Exception
	{

		Thread.sleep(4000);
		clickhere.click();
		Thread.sleep(8000);	
		closebutt.click();
		Thread.sleep(4000);

	}



	public void docExport() throws Exception
	{

		Thread.sleep(6000);
		action1.click();
		Thread.sleep(6000);
		exportdepartmentprofile.click();
		Thread.sleep(6000);
		word.click();
		Thread.sleep(6000);
		export.click();
		Thread.sleep(6000);
		highLightElement(title);
		Thread.sleep(6000);
		highLightElement(onscreen);	
		Thread.sleep(6000);
		highLightElement(ok2);	
		Thread.sleep(6000);
		if(title.getText().contains("Export Department 001 Profile"))
		{
			System.out.println("Test pass");
		}
		else
		{
			System.out.println("Test Fail");

		}
		if(onscreen.getText().contains("Department 001 profile export request received. A task shall be assigned once the department profile export is available and you may download the same from the task."))
		{
			System.out.println("Test pass");
		}
		else
		{
			System.out.println("Test Fail");

		}
		ok2.click();

		Thread.sleep(6000);	
	}


	public void verifytaskreceived1() throws Exception
	{
		home.click();
		//Thread.sleep(90000);
		//Thread.sleep(15*60*1000);
		Thread.sleep(6000);	
		Mytask.click();
		Thread.sleep(6000);	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(6000);	
		recievedsort.click();
		Thread.sleep(6000);	
		tasktitle.click();
		Thread.sleep(6000);	
		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
	}


	public void NavigattoFacilities() throws Exception
	{

		Thread.sleep(6000);	
		Facility.click();
		Thread.sleep(6000);	
		Myfacility.click();
		Thread.sleep(6000);	
		highLightElement(facilitiestitle);
		Thread.sleep(6000);
		if(facilitiestitle.getText().contains("Facilities"))
		{
			System.out.println("Test pass");
		}
		else
		{
			System.out.println("Test Fail");

		}
		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	}

	public void Previewabbriviatedcv() throws Exception
	{

		Thread.sleep(6000);	
		previewcv.click();
		Thread.sleep(10000);	

		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentid = it.next();
		String childid = it.next();
		driver.switchTo().window(childid);
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.close();
		Thread.sleep(3000);
		driver.switchTo().window(parentid);
		Thread.sleep(3000);

		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	}


	public void Generatecv() throws Exception
	{

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");

		Thread.sleep(6000);	
		highLightElement(generatecv);
		generatecv.click();
		Thread.sleep(3000);
		highLightElement(reviewcv);
		Thread.sleep(6000);
		highLightElement(onscreen1);
		Thread.sleep(6000);
		highLightElement(generatesigncv);
		Thread.sleep(6000);
		highLightElement(cancel);
		Thread.sleep(6000);
		Thread.sleep(3000);


		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
	}


	public void Verifycvgenerated() throws Exception
	{

		Thread.sleep(6000);	
		generatereport.click();
		Thread.sleep(3000);
		highLightElement(reviewcv);
		Thread.sleep(6000);
		highLightElement(onscreen1);
		Thread.sleep(6000);
		highLightElement(generatesigncv);
		Thread.sleep(6000);
		highLightElement(cancel);
		Thread.sleep(6000);

		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);


	}

	public void VerifyFacilityIdAndDepartmentId() throws Exception{
		properties=obj.getProperty();
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);	
		Map<String,String> testDataInMap = testData.getTestDatainMap();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,10000)");
		String FacilityID=testDataInMap.get("SIPID");
		String DepartmentID=testDataInMap.get("SIPID-D");
		Thread.sleep(3000);
		try{
			highLightElement(driver.findElement(By.xpath("//div[text()='  "+FacilityID+"']")));
			Thread.sleep(2000);
			highLightElement(driver.findElement(By.xpath("//div[text()=' "+DepartmentID+"']")));
		}catch(Exception e){}
	}
	
	public void VerifyFacility2IdAndDepartment2Id(int n) throws Exception{
		properties=obj.getProperty();
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);	
		Map<String,String> testDataInMap = testData.getTestDatainMap();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,6000)");
		
		String FacilityID=testDataInMap.get("SIPID2");
		String DepartmentID=testDataInMap.get("SIPID-D2");
		Thread.sleep(4000);
		try{
			highLightElement(driver.findElement(By.xpath("//div[text()='"+FacilityID+"']")));
			Thread.sleep(2000);
			highLightElement(driver.findElement(By.xpath("//div[text()='"+DepartmentID+"']")));
		}catch(Exception e){}
	}
	
	public void ClickOnAddfacility() throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,10000)");
		Thread.sleep(3000);
		Addfacility.click();
		Thread.sleep(3000);
	}
	
	public void Addfacility() throws Exception
	{

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(3000);
		Addfacility.click();
		Thread.sleep(3000);
		country1.sendKeys("brazil");
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
		facility.sendKeys("fa");
		Thread.sleep(5000);
		search1.click();
		Thread.sleep(5000);
		radio.click();
		Thread.sleep(5000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,850)");
		Thread.sleep(5000);
		addfacility.click();
		Thread.sleep(10000);

		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
	}

	public void Navigatetosearchfacility() throws Exception
	{

		Thread.sleep(6000);	
		Facility.click();
		Thread.sleep(6000);
		searchfacility.click();
		Thread.sleep(6000);


		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	}

	public void Entercountry1andverify() throws Exception
	{

		Thread.sleep(6000);	
		countrydropdown.click();
		Thread.sleep(6000);
		countrydropdown.sendKeys("Afghanistan");
		Thread.sleep(6000);
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
		highLightElement(state1);
		Thread.sleep(5000);
		highLightElement(city1);
		Thread.sleep(5000);
		highLightElement(facilityname1);
		Thread.sleep(5000);
		//highLightElement(sipfacid);
		Thread.sleep(5000);
		clearsearch.click();
		Thread.sleep(5000);

		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);


	}
	public void Entercountry2andverify() throws Exception
	{

		Thread.sleep(6000);	
		countrydropdown.click();
		Thread.sleep(6000);
		countrydropdown.sendKeys("Albania");
		Thread.sleep(6000);
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
		highLightElement(state1);
		Thread.sleep(5000);
		highLightElement(city1);
		Thread.sleep(5000);
		highLightElement(facilityname1);
		Thread.sleep(5000);
		//highLightElement(sipfacid);
		Thread.sleep(5000);
		clearsearch.click();
		Thread.sleep(5000);


		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
	}

	public void Entercountry3andverify() throws Exception
	{

		Thread.sleep(6000);	
		countrydropdown.click();
		Thread.sleep(6000);
		countrydropdown.sendKeys("United States of America");
		Thread.sleep(6000);
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
		highLightElement(state1);
		Thread.sleep(5000);
		highLightElement(city1);
		Thread.sleep(5000);
		highLightElement(facilityname1);
		Thread.sleep(5000);
		// highLightElement(sipfacid);
		Thread.sleep(5000);
		clearsearch.click();
		Thread.sleep(5000);

		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	}

	public void Entercountry4andverify() throws Exception
	{

		Thread.sleep(6000);	
		countrydropdown.click();
		Thread.sleep(6000);
		countrydropdown.sendKeys("Australia");
		Thread.sleep(6000);
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
		highLightElement(state1);
		Thread.sleep(5000);
		highLightElement(city1);
		Thread.sleep(5000);
		highLightElement(facilityname1);
		Thread.sleep(5000);
		//highLightElement(sipfacid);
		Thread.sleep(5000);
		clearsearch.click();
		Thread.sleep(5000);


		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);


	}

	public void sponEntercountry1andverify() throws Exception
	{

		Thread.sleep(6000);	
		countrydropdown1.click();
		Thread.sleep(6000);
		countrydropdown1.sendKeys("Afghanistan");
		Thread.sleep(6000);
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
		highLightElement(state2);
		Thread.sleep(5000);
		highLightElement(city2);
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(5000);
		clearsearch1.click();
		Thread.sleep(5000);

		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
	}

	public void sponEntercountry2andverify() throws Exception
	{

		Thread.sleep(6000);	
		countrydropdown1.click();
		Thread.sleep(6000);
		countrydropdown1.sendKeys("Albania");
		Thread.sleep(6000);
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
		highLightElement(state2);
		Thread.sleep(5000);
		highLightElement(city2);
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(5000);
		clearsearch1.click();
		Thread.sleep(5000);

		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
	}

	public void sponEntercountry3andverify() throws Exception
	{

		Thread.sleep(6000);	
		countrydropdown1.click();
		Thread.sleep(6000);
		countrydropdown1.sendKeys("United States of America");
		Thread.sleep(6000);
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
		highLightElement(state2);
		Thread.sleep(5000);
		highLightElement(city2);
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(5000);
		clearsearch1.click();
		Thread.sleep(5000);

		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
	}

	public void sponEntercountry4andverify() throws Exception
	{

		Thread.sleep(6000);	
		countrydropdown1.click();
		Thread.sleep(6000);
		countrydropdown1.sendKeys("Australia");
		Thread.sleep(6000);
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
		highLightElement(state2);
		Thread.sleep(5000);
		highLightElement(city2);
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(5000);
		clearsearch1.click();
		Thread.sleep(5000);

		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
	}

	public void Navigatetofacilityandverifydepartment1() throws Exception
	{

		Thread.sleep(6000);	
		FACILITY.click();
		Thread.sleep(3000);
		Myfacility.click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		//next.click();
		//Thread.sleep(3000);
		//JavascriptExecutor js1 = (JavascriptExecutor) driver;
		//js1.executeScript("window.scrollBy(0,200)");

		//highLightElement(dept1);
		Thread.sleep(3000);

		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	}


	public void Verifypopulateddepartmentprofile() throws Exception
	{
		//OnScreentext
		highLightElement(driver.findElement(By.xpath("(//h2[text()='Populate Department Profile']/following-sibling::p)[1]")));
		Thread.sleep(2000);	
		//Warning
		highLightElement(driver.findElement(By.xpath("//i[contains(@class,'vertical-align-top marRight5')]")));
		Thread.sleep(2000);	
      //Breadcrumb
		highLightElement(driver.findElement(By.xpath("(//li[@class='first']//a)[2]")));
        highLightElement(driver.findElement(By.xpath("//li[@class='active']//a[1]")));
        
        //Buttons
        highLightElement(entermanually);
        highLightElement(AdoptFacilitybutton);
        highLightElement(UploadSipDepartmentbutton);
        Thread.sleep(4000);	
        //Left sections
        highLightElement(driver.findElement(By.xpath("//span[contains(@class,'display-inline-block marLeft5')]")));

	}

public void ClickOnUploadSIPDocument() throws InterruptedException{
	 Thread.sleep(2000);	
	UploadSipDepartmentbutton.click();
	Thread.sleep(6000);
	try{
		highLightElement(driver.findElement(By.xpath("//h2[text()='Upload SIP Department Profile Form']")));
		highLightElement(driver.findElement(By.xpath("(//h2[text()='Upload SIP Department Profile Form']/following-sibling::p)[1]")));
		highLightElement(driver.findElement(By.xpath("(//h2[text()='Upload SIP Department Profile Form']/following-sibling::p)[2]")));
		Thread.sleep(2000);
		highLightElement(ChooseFilePbutton);
		highLightElement(CancelSIPbutton);
		highLightElement(UploadSIPbutton);
	}catch(Exception e){System.out.println("verivication error");}
	
}

public void ClickOnDownloadLink() throws InterruptedException{
	Thread.sleep(2000);
	try{
		
		driver.findElement(By.id("download_button")).click();
	}catch(Exception e){System.out.println("no link");}
	driver.findElement(By.id("download_button")).click();
	
}

public void BrowseFileandVerifyUploadButton(String DocPath) throws Exception{
	properties=obj.getProperty();
	Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
	testData.setTestDatainMap(TestDataInMap);	
	Map<String,String> testDataInMap = testData.getTestDatainMap();
	Thread.sleep(2000);
	String DocumentPath=testDataInMap.get(DocPath);
	
	
	ChooseFilePbutton.sendKeys(DocumentPath);
	Thread.sleep(2000);
	try{
		if(UploadSIPbutton.isEnabled()){
			System.out.println("Test Pass");
		}
		else{
			System.out.println("Test Fail");
		}
	}catch(Exception e){System.out.println("No such element");}
	
	highLightElement(ChooseFilePbutton);
	
}

public void ClickOnUploadButtonandVerify() throws InterruptedException{
	UploadSIPbutton.click();
	Thread.sleep(8000);
	
	try{
		driver.findElement(By.xpath("//button[@id='uploadDocConfrmRedrtToUserProfile']")).click();
	}catch(Exception e){}
	try{
		highLightElement(driver.findElement(By.xpath("(//h1[@class='large-header-h1'])[2]")));
	}catch(Exception e){System.out.println("No error mesg");}
	
	try{
		highLightElement(driver.findElement(By.xpath("(//h1[@class='large-header-h1'])[3]")));
	}catch(Exception e){System.out.println("No error mesg");}
	
	try{
		highLightElement(driver.findElement(By.xpath("(//h1[@class='large-header-h1'])[4]")));
	}catch(Exception e){System.out.println("No error mesg");}
	
	try{
		highLightElement(driver.findElement(By.xpath("(//h1[@class='large-header-h1'])[5]")));
	}catch(Exception e){System.out.println("No error mesg");}
	
	try{
		highLightElement(driver.findElement(By.xpath("(//h1[@class='large-header-h1'])[1]")));
	}catch(Exception e){System.out.println("No error mesg");}
	
	


}

public void ClickOKOnErrormsg() throws InterruptedException{
	Thread.sleep(4000);
	
	try{
		driver.findElement(By.xpath("(//button[@id='uploadDocConfrmRedrtToUserProfile'])[2]")).click();
	}catch(Exception e){System.out.println("error");}
	
	try{
		driver.findElement(By.xpath("(//button[@id='uploadDocConfrmRedrtToUserProfile'])[3]")).click();
	}catch(Exception e){System.out.println("error");}
	
	try{
		driver.findElement(By.xpath("(//button[@id='uploadDocConfrmRedrtToUserProfile'])[1]")).click();
	}catch(Exception e){System.out.println("error");}
}

public void ClickOnCancelOfSIPdocument() throws InterruptedException{
	Thread.sleep(2000);
	CancelSIPbutton.click();
	Thread.sleep(4000);
}


	public void Navigateandverifysameasshipping() throws Exception
	{

		Thread.sleep(6000);	
		FACILITY.click();
		Thread.sleep(3000);
		Myfacility.click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		//next.click();
		Thread.sleep(3000);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,600)");
		Thread.sleep(3000);
		actionicon.click();
		Thread.sleep(3000);
		adddepartment.click();
		Thread.sleep(7000);
		createdepartment.click();
		Thread.sleep(5000);
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,800)");
		Thread.sleep(5000);
		departmentname1.sendKeys("utyryryyt");
		Thread.sleep(5000);
		Select departmenttype1 = new Select (departmenttype);
		departmenttype1.selectByVisibleText("Cardiology - Cardiac Cath Lab");
		Thread.sleep(5000);
		building1.sendKeys("7686868");
		Thread.sleep(5000);
		address.sendKeys("2324999");
		Thread.sleep(5000);
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(5000);
		savebu.click();
		Thread.sleep(6000);

		iwillassignsomeoneelse.click();
		Thread.sleep(5000);
		email.sendKeys("abc123sand@yopmail.com");
		Thread.sleep(5000);
		search2.click();
		Thread.sleep(5000);
		radio1.click();
		Thread.sleep(5000);
		selectdeptcontact.click();
		Thread.sleep(5000);
		continueupdatingthedepartment.click();
		Thread.sleep(5000);
		entermanually.click();
		Thread.sleep(5000);
		IPandcontrolsubstance.click();
		Thread.sleep(7000);
		JavascriptExecutor js4= (JavascriptExecutor) driver;
		js4.executeScript("window.scrollBy(0,500)");
		Thread.sleep(5000);
		highLightElement(IPSTORAGEEQUIPMENT);
		Thread.sleep(5000);
		highLightElement(storagehandling);
		Thread.sleep(5000);
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		js5.executeScript("window.scrollBy(0,800)");    
		highLightElement(ADMINISTRATIONOINVESUC);
		Thread.sleep(5000);
		highLightElement(controlsubstance);
		Thread.sleep(5000);

		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);


	}



	public void clicksaveandverify() throws Exception
	{

		Thread.sleep(6000);	
		savebut.click();
		Thread.sleep(6000);

		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
	}



	public void clickokandverify() throws Exception
	{

		Thread.sleep(6000);	
		okbu.click();
		Thread.sleep(6000);




		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	}


	public void clickoncountrydropdownandverify() throws Exception
	{

		Thread.sleep(4000);	
		countr.sendKeys("United States of America");
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


	public void selectcountrystateandverify() throws Exception
	{

		Thread.sleep(4000);	
		stat.sendKeys("Alabama");
		Thread.sleep(3000);	
		Robot robot2 = new Robot();  
		Thread.sleep(2000); 
		robot2.keyPress(KeyEvent.VK_DOWN); 	
		Thread.sleep(2000);  
		robot2.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);  
		robot2.keyPress(KeyEvent.VK_ENTER); 	
		Thread.sleep(2000);  
		robot2.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);



		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);




	}

	public void selectstateinvalidemailandverify() throws Exception
	{

		Thread.sleep(4000);	
		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		js4.executeScript("window.scrollBy(0,200)");
		Thread.sleep(3000);
		email1.sendKeys("ab@@gmail.com");
		Thread.sleep(3000);
		highLightElement(emailerror);

		if(emailerror.getText().contains("Valid Email Address is required"))
		{
			System.out.println("Test pass");
		}
		else
		{
			System.out.println("Test Fail");

		}





		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);



	}


	public void entervalidemailandverify() throws Exception
	{

		Thread.sleep(4000);	
		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		js4.executeScript("window.scrollBy(0,200)");
		Thread.sleep(3000);
		email1.clear();
		Thread.sleep(3000);
		email1.sendKeys("ab@gmail.com");
		Thread.sleep(3000);
		highLightElement(AddIPshippinglocation);
		Thread.sleep(3000);

		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);






	}

	public void enterdataremainingfieldandsave() throws Exception
	{

		Thread.sleep(4000);	
		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		js4.executeScript("window.scrollBy(0,200)");
		Thread.sleep(3000);
		iprecipientname.sendKeys("Ip444555");
		Thread.sleep(3000);
		streetname.sendKeys("567778");
		Thread.sleep(3000);
		newcity.sendKeys("Newcity");
		Thread.sleep(3000);
		sve.click();
		Thread.sleep(5000);
		ok3.click();
		Thread.sleep(3000);




		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);


	}





	public void addipshippingandverify() throws Exception
	{

		Thread.sleep(4000);	
		//AddIPshippinglocation.click();
		plus.click();
		Thread.sleep(3000);
		highLightElement(ip);
		Thread.sleep(3000);
		highLightElement(strtnam);
		Thread.sleep(3000);
		highLightElement(build);
		Thread.sleep(3000);
		highLightElement(addaddress);
		Thread.sleep(3000);
		highLightElement(country2);
		Thread.sleep(3000);
		highLightElement(state3);
		Thread.sleep(3000);
		highLightElement(city3);
		Thread.sleep(3000);
		highLightElement(zip2);
		Thread.sleep(3000);
		highLightElement(phone);
		Thread.sleep(3000);
		highLightElement(fax);
		Thread.sleep(3000);
		highLightElement(emailid);
		Thread.sleep(3000); 

		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	}



	public void donotenterandsave() throws Exception
	{

		Thread.sleep(4000);	
		//AddIPshippinglocation.click();
		Thread.sleep(3000);
		savebutton.click();
		Thread.sleep(3000); 
		highLightElement(error);
		Thread.sleep(3000); 

		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);



	}



	public void clickokcountryverify() throws Exception
	{

		Thread.sleep(4000);	
		okk.click();
		Thread.sleep(3000); 

		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);



	}


	public void enteripshippinglocationsaveduplicatewarning() throws Exception
	{

		Thread.sleep(4000);	
		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		js4.executeScript("window.scrollBy(0,200)");
		Thread.sleep(3000);
		email1.clear();
		Thread.sleep(3000);
		email1.sendKeys("ab@gmail.com");
		Thread.sleep(3000);
		highLightElement(AddIPshippinglocation);
		Thread.sleep(3000);
		iprecipientname.sendKeys("IP3223");
		Thread.sleep(3000);
		streetname.sendKeys("145 ttg");
		Thread.sleep(3000);
		newcity.sendKeys("newcity");
		Thread.sleep(3000);
		sve.click();
		Thread.sleep(6000);
		okkk.click();

		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);



	}

	public void clickoksaveverify() throws Exception
	{

		Thread.sleep(4000);	
		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		js4.executeScript("window.scrollBy(0,200)");
		Thread.sleep(3000);
		plus.click();


		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	}

	public void verifyalldataunderproductshippingdetail() throws Exception
	{


		Thread.sleep(3000);
		highLightElement(ip);
		Thread.sleep(3000);
		highLightElement(strtnam);
		Thread.sleep(3000);
		highLightElement(build);
		Thread.sleep(3000);
		highLightElement(addaddress);
		Thread.sleep(3000);
		highLightElement(country2);
		Thread.sleep(3000);
		highLightElement(state3);
		Thread.sleep(3000);
		highLightElement(city3);
		Thread.sleep(3000);
		highLightElement(zip2);
		Thread.sleep(3000);
		highLightElement(phone);
		Thread.sleep(3000);
		highLightElement(fax);
		Thread.sleep(3000);
		highLightElement(emailid);
		Thread.sleep(3000); 
		minus.click();
		Thread.sleep(3000); 
		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	}



	public void verifyplusicon() throws Exception
	{


		Thread.sleep(3000);
		highLightElement(plus);
		Thread.sleep(3000);


		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	}



	public void clickonplusiconandverifies() throws Exception
	{


		Thread.sleep(3000);
		plus.click();
		Thread.sleep(5000);
		highLightElement(ip);
		Thread.sleep(3000);
		highLightElement(strtnam);
		Thread.sleep(3000);
		highLightElement(build);
		Thread.sleep(3000);
		highLightElement(addaddress);
		Thread.sleep(3000);
		highLightElement(country2);
		Thread.sleep(3000);
		highLightElement(state3);
		Thread.sleep(3000);
		highLightElement(city3);
		Thread.sleep(3000);
		highLightElement(zip2);
		Thread.sleep(3000);
		highLightElement(phone);
		Thread.sleep(3000);
		highLightElement(fax);
		Thread.sleep(3000);
		highLightElement(emailid);
		Thread.sleep(3000); 


		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	}



	public void clickonremoveverifypopup() throws Exception
	{
		Thread.sleep(4000);	
		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		js4.executeScript("window.scrollBy(0,300)");

		Thread.sleep(3000);
		remove.click();
		Thread.sleep(3000); 

		highLightElement(warningtext);
		Thread.sleep(3000);
		highLightElement(okkkk);
		Thread.sleep(3000);
		highLightElement(cancell);
		Thread.sleep(3000);


		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	}



	public void clickcancelbuttonandverify() throws Exception
	{

		Thread.sleep(3000);
		cancell.click();
		Thread.sleep(3000);

		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	}

	public void expandseconipshippinglacationandverify() throws Exception
	{

		Thread.sleep(5000);
		highLightElement(ip);
		Thread.sleep(3000);
		highLightElement(strtnam);
		Thread.sleep(3000);
		highLightElement(build);
		Thread.sleep(3000);
		highLightElement(addaddress);
		Thread.sleep(3000);
		highLightElement(country2);
		Thread.sleep(3000);
		highLightElement(state3);
		Thread.sleep(3000);
		highLightElement(city3);
		Thread.sleep(3000);
		highLightElement(zip2);
		Thread.sleep(3000);
		highLightElement(phone);
		Thread.sleep(3000);
		highLightElement(fax);
		Thread.sleep(3000);
		highLightElement(emailid);
		Thread.sleep(3000); 



		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	}


	public void clickonrevoveandverifywarning() throws Exception
	{
		Thread.sleep(4000);	
		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		js4.executeScript("window.scrollBy(0,300)");

		Thread.sleep(3000);
		remove.click();
		Thread.sleep(3000); 

		highLightElement(warningtext);
		Thread.sleep(3000);
		highLightElement(okkkk);
		Thread.sleep(3000);
		highLightElement(cancell);
		Thread.sleep(3000);
		okkkk.click();
		Thread.sleep(3000);

		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	}

	public void addiplocation2andverify() throws Exception
	{
		Thread.sleep(4000);	
		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		js4.executeScript("window.scrollBy(0,200)");

		Thread.sleep(4000);	
		countr.sendKeys("United States of America");
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
		stat.sendKeys("Alabama");
		Thread.sleep(3000);	
		Robot robot2 = new Robot();  
		Thread.sleep(2000); 
		robot2.keyPress(KeyEvent.VK_DOWN); 	
		Thread.sleep(2000);  
		robot2.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);  
		robot2.keyPress(KeyEvent.VK_ENTER); 	
		Thread.sleep(2000);  
		robot2.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		email1.clear();
		Thread.sleep(3000);
		email1.sendKeys("ab@gmail.com");
		Thread.sleep(3000);
		highLightElement(AddIPshippinglocation);
		Thread.sleep(3000);
		iprecipientname.sendKeys("IP3223");
		Thread.sleep(3000);
		streetname.sendKeys("145 ttg");
		Thread.sleep(3000);
		newcity.sendKeys("newcity");
		Thread.sleep(3000);
		sve.click();
		Thread.sleep(3000);
		ok3.click();
		Thread.sleep(3000);




		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	}




	public void clickactionandverify() throws Exception
	{

		Thread.sleep(5000);
		action2.click();
		Thread.sleep(3000);
		highLightElement(adddepartmet2);
		Thread.sleep(3000);
		highLightElement(exportfacilityprofile2);
		Thread.sleep(3000);
		highLightElement(removefacility2);
		Thread.sleep(3000);
		highLightElement(facilitymsgtofpm2);
		Thread.sleep(3000);



		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	}


	public void clickadddepartment() throws Exception
	{

		Thread.sleep(5000);
		action2.click();
		Thread.sleep(3000);
		adddepartmet2.click();;
		Thread.sleep(7000);



		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	}


	public void clickcancelandnavigate() throws Exception
	{

		Thread.sleep(3000);
		Facility.click();
		Thread.sleep(3000);
		Myfacility.click();
		Thread.sleep(3000);
		facilities.isDisplayed();
		Thread.sleep(3000);



		TakesScreenshot webdriver = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);


	}

	public void adddepartmenttouserprofile() throws Exception 
	{
		Thread.sleep(3000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,800)");
		dept1checkbox.click();
		Thread.sleep(5000);
		adddepartmenttouserprofile.click();
		Thread.sleep(7000);

	}



	public void exportfacility() throws Exception 
	{
		Thread.sleep(3000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,800)");
		Thread.sleep(3000);
		action2.click();
		Thread.sleep(3000);
		exportfacilityprofile2.click();
		Thread.sleep(3000);

	}

	public void verifybreadcrumb() throws Exception 
	{



		Thread.sleep(3000);
		facility1.click();
		Thread.sleep(6000);
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentid = it.next();
		String childid = it.next();
		driver.switchTo().window(childid);
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		highLightElement(breadcrumb);

		Thread.sleep(3000);





	}

	public void verifyfacilitycontact() throws Exception 
	{



		Thread.sleep(3000);
		facilitycontact.click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(3000);
		highLightElement(firstlastname);
		Thread.sleep(3000);






	}



	public void removedepartment() throws Exception 
	{



		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		action3.click();
		Thread.sleep(3000);
		removedepartment.click();
		Thread.sleep(5000);
		okbutton7.click();
		Thread.sleep(5000);





	}


	public void removedepartment1() throws Exception 
	{



		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,900)");
		Thread.sleep(3000);
		action3.click();
		Thread.sleep(3000);
		removedepartment.click();
		Thread.sleep(5000);
		highLightElement(remove);
		Thread.sleep(3000);
		highLightElement(cancell);
		Thread.sleep(3000);
		remove.click();
		Thread.sleep(3000);
		okkkk.click();
		Thread.sleep(5000);





	}



	public void Addfacilitytoyourprofile() throws Exception 
	{



		Thread.sleep(3000);
		selectradio.click();
		Thread.sleep(3000);
		addprofiletouserprofile.click();
		Thread.sleep(5000);





	}

	public void createdepartment() throws Exception 
	{




		Thread.sleep(7000);
		createdepartment.click();
		Thread.sleep(5000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,800)");
		Thread.sleep(5000);
		departmentname1.sendKeys("utyryryyt");
		Thread.sleep(5000);
		Select departmenttype1 = new Select (departmenttype);
		departmenttype1.selectByVisibleText("Cardiology - Cardiac Cath Lab");
		Thread.sleep(5000);
		building1.sendKeys("7686868");
		Thread.sleep(5000);
		address.sendKeys("2324999");
		Thread.sleep(5000);
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(5000);
		savebu.click();
		Thread.sleep(6000);






	}


	public void editdepartment() throws Exception 
	{




		Thread.sleep(7000);
		deptnam.click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		Thread.sleep(4000);
		highLightElement(departnameaddress);
		Thread.sleep(6000);






	}

	public void Edit_Building_Address_By_Special_Character() throws InterruptedException {
		Thread.sleep(2000);
		building1.clear();
		building1.sendKeys("@876");
		savebu.click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='modal-controls text-align-center']//button[1]")).click();
		Thread.sleep(2000);
	}

	public void ExportFacilitySearchIntoPDF() throws Exception {
		ExportFacilitySearch.click();
		Thread.sleep(2000);
		ExportFacilitySearchToPDF.isDisplayed();
		highLightElement(ExportFacilitySearchToPDF);
	}
	
	public void ClickExportFacilitySearchPDF() throws Exception{
		ExportFacilitySearchToPDF.click();
		Thread.sleep(2000);
		ExportFacilitySearchButton.click();
		Thread.sleep(5000);
		ExportFacilitySearchPopUp.isDisplayed();
		highLightElement(ExportFacilitySearchPopUp);
		
	}
	
	public void ClickExportFacilitySearchOK(){
		ExportFacilitySearchOKButton.click();
	}

	
	
	public void ExportDepartmentSearchIntoPDF() throws Exception {
		ExportDepartmentSearch.click();
		Thread.sleep(2000);
		ExportDepartmentSearchToPDF.isDisplayed();
		highLightElement(ExportDepartmentSearchToPDF);
	}
	
	public void ExportDepartmentSearchIntoWord() throws Exception {
		ExportDepartmentSearch.click();
		Thread.sleep(2000);
		ExportFacilitySearchToWord.isDisplayed();
		highLightElement(ExportDepartmentSearchToPDF);
	}
	
	
	
	public void ClickExportDepartmentSearchPDF() throws Exception{
		ExportFacilitySearchToWord.click();
		Thread.sleep(2000);
		ExportDepartmentSearchButton.click();
		Thread.sleep(5000);
		ExportDepartmentSearchPopUp.isDisplayed();
		highLightElement(ExportDepartmentSearchPopUp);
		
	}
	
	
	
	public void ClickExportDepartmentSearchOK(){
		ExportDepartmentSearchOKButton.click();
	}

	@FindBy(how=How.XPATH, using="//h2[@class='no-margin float-left']")
	public WebElement DepartmentAdressHeader;
	
	@FindBy(how=How.ID, using="inst-name")
	public WebElement FacilityName;
	
	@FindBy(how=How.XPATH, using="(//label[text()='SIP Facility ID  ']/following::input)[1]")
	public WebElement SIPFacilityID;
	
	@FindBy(how=How.ID, using="researchFacilityType")
	public WebElement FacilityType;
	
	
	@FindBy(how=How.XPATH, using="//input[@id='departmentName']")
	public WebElement departmentName;

	@FindBy(how=How.XPATH, using="(//label[text()='SIP Facility ID  ']/following::input)[4]")
	public WebElement SIPDepartmentID;

	@FindBy(how=How.XPATH, using="//select[@id='departmentType']")
	public WebElement departmentType;

	@FindBy(how=How.ID, using="addressOne")
	public WebElement Street;

	@FindBy(how=How.ID, using="addressTwo")
	public WebElement BuildingFloor;


	@FindBy(how=How.ID, using="addressThree")
	public WebElement AdditionalAddress;
	
	@FindBy(how=How.XPATH, using="(//input[contains(@class,'answer mandatory')])[1]")
	public WebElement Country;
	
	@FindBy(how=How.XPATH, using="(//input[contains(@class,'answer mandatory')])[2]")
	public WebElement State;
	
	@FindBy(how=How.ID, using="City")
	public WebElement City;
	
	@FindBy(how=How.ID, using="Postal-Code")
	public WebElement PostalCode;
	
	public void Verify_Facility_Department_Fields() throws Exception {
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", DepartmentAdressHeader);
		Thread.sleep(2000);
		if(FacilityName.isDisplayed()){
			System.out.println("Test Pass");
		}
		
		else {
			System.out.println("Test Fail");
		}
		
//		2
		if(SIPFacilityID.isDisplayed()){
			System.out.println("Test Pass");
		}
		
		else {
			System.out.println("Test Fail");
		}
		
//		3
		if(FacilityType.isDisplayed()){
			System.out.println("Test Pass");
		}
		
		else {
			System.out.println("Test Fail");
		}
//		4
		if(departmentName.isDisplayed()){
			System.out.println("Test Pass");
		}
		
		else {
			System.out.println("Test Fail");
		}
//		5
		if(SIPDepartmentID.isDisplayed()){
			System.out.println("Test Pass");
		}
		
		else {
			System.out.println("Test Fail");
		}
//		6
		if(departmentType.isDisplayed()){
			System.out.println("Test Pass");
		}
		
		else {
			System.out.println("Test Fail");
		}
//		7
		if(Street.isDisplayed()){
			System.out.println("Test Pass");
		}
		
		else {
			System.out.println("Test Fail");
		}
//		8
		if(BuildingFloor.isDisplayed()){
			System.out.println("Test Pass");
		}
		
		else {
			System.out.println("Test Fail");
		}
//		9
		if(AdditionalAddress.isDisplayed()){
			System.out.println("Test Pass");
		}
		
		else {
			System.out.println("Test Fail");
		}
//		10
		if(Country.isDisplayed()){
			System.out.println("Test Pass");
		}
		
		else {
			System.out.println("Test Fail");
		}
//		11
		if(State.isDisplayed()){
			System.out.println("Test Pass");
		}
		
		else {
			System.out.println("Test Fail");
		}
//		12
		if(City.isDisplayed()){
			System.out.println("Test Pass");
		}
		
		else {
			System.out.println("Test Fail");
		}
		
//		13
		if(PostalCode.isDisplayed()){
			System.out.println("Test Pass");
		}
		
		else {
			System.out.println("Test Fail");
		}
			
		
	}
//AAPRI Department
	public void Update_Department_Detailst() throws Exception {
		Robot robot1 = new Robot();  
		Thread.sleep(2000); 
//		departmentName.clear();
//		departmentName.sendKeys("AAPRI Department");
//		Thread.sleep(2000);
		
		Street.clear();
		Street.sendKeys("Street 432");
		Thread.sleep(2000);
		
		Country.clear();
		Country.sendKeys("Brazil");
		
		robot1.keyPress(KeyEvent.VK_DOWN); 	
		Thread.sleep(2000);  
		robot1.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);  
		robot1.keyPress(KeyEvent.VK_ENTER); 	
		Thread.sleep(2000);  
		robot1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		
		
		State.clear();
		State.sendKeys("Bahia");
		robot1.keyPress(KeyEvent.VK_DOWN); 	
		Thread.sleep(2000);  
		robot1.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);  
		robot1.keyPress(KeyEvent.VK_ENTER); 	
		Thread.sleep(2000);  
		robot1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		
		City.clear();
		City.sendKeys("Valoria");
	}

	
	
}