package com.testautomation.PageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.util.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.testautomation.Utility.ExcelHandler;
import com.testautomation.Utility.PropertiesFileReader;
import com.testautomation.Utility.TestDataHandler;

public class GeneralReportPage {

	WebDriver driver;
	Properties properties;
	PropertiesFileReader obj = new PropertiesFileReader();
	TestDataHandler testData = new TestDataHandler();
	static public String File_Name_To_Validate="";

	public GeneralReportPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void highLightElement(WebElement string) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');", string);

	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"ReportsId\"]/span[1]")
	public WebElement Report;

	@FindBy(how = How.XPATH, using = "//*[@id=\"GeneralReportsId\"]")
	public WebElement generalRepert;

	@FindBy(how = How.XPATH, using = "//select[@id='jspDropDownValue']")
	public WebElement ReportSelect;

	@FindBy(how = How.XPATH, using = "(//select[@id='pagination_limit'])[3]")
	public WebElement Rowselect1;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Select Compound(s)']")
	public WebElement selectComp;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Select Study ID(s)']")
	public WebElement selectStudyId;

	@FindBy(how = How.XPATH, using = "//*/span[contains(text(),'Select Safety Notification Type')]")
	public WebElement SNType;

	@FindBy(how = How.XPATH, using = "(//span[@title='Close'])[1]")
	public WebElement compclose;

	@FindBy(how = How.XPATH, using = "(//span[@title='Close'])[2]")
	public WebElement studyclose;

	@FindBy(how = How.XPATH, using = "//*[@id=\"SPACK_FROMDATE_TODATETO_DATE_CONTROL\"]")
	public WebElement toDate;

	@FindBy(how = How.XPATH, using = "//*[@id=\"SPACK_FROMDATE_TODATE_CONTROL\"]")
	public WebElement fromDate;

	@FindBy(how = How.XPATH, using = "(//span[contains(text(),'Generate Report')]//..)[1]")
	public WebElement searchbutton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"SPON_USR_ACK_STATUS1\"]/div/div/div/div[6]/div/div/div[3]/div/table")
	public WebElement reportTable;

	@FindBy(how = How.XPATH, using = "//*[@id=\"ReportsId\"]/span[2]")
	public WebElement Reportdropdown;

	@FindBy(how = How.ID, using = "GeneralReportsId")
	public WebElement Generalreport;

	@FindBy(how = How.XPATH, using = "//*[@id=\"safetyNotificationWidgets_forms_controls_MultiSelectInput___1c4cf7d5-c581-45a4-841d-477bc8ac14d2\"]/div[1]/label")
	public WebElement compound;

	@FindBy(how = How.XPATH, using = "//*[@id=\"safetyNotificationWidgets_forms_controls_MultiSelectInput___98b1043a-6a36-4c62-8ecb-5a189aea1a22\"]/div[1]/label")
	public WebElement studyid;

	@FindBy(how = How.XPATH, using = "/iframe[@id='safedNavEmbedId']")
	public CharSequence[] country;

	@FindBy(how = How.XPATH, using = "//*[@id=\"alfresco_html_Label___f7512432-54d7-4130-8a7e-88536294c978\"]/span[1]")
	public WebElement Studysiteid;

	@FindBy(how = How.XPATH, using = "//*[@id=\"documentWorkflowWidgets_forms_controls_SingleSelectWithPlaceholder___f4449359-6775-4b49-827b-91426dfe1a71\"]/div[1]/label")
	public WebElement safetynotificationtype;

	@FindBy(how = How.XPATH, using = "//*[@id=\"SPACK_FROMDATE_TODATE\"]/div[1]/label")
	public WebElement safetyfromto;

	@FindBy(how = How.XPATH, using = "//*[@id=\"selectedAuditReport\"]")
	public WebElement GeneralDropdown;

	@FindBy(how = How.XPATH, using = "//*[@id=\"selectedAuditReport\"]")
	public WebElement Safetyr;

	@FindBy(how = How.XPATH, using = "//*[@id=\"documentWorkflowWidgets_forms_controls_SingleSelectWithPlaceholder___f4449359-6775-4b49-827b-91426dfe1a71_CONTROL\"]/tbody/tr/td[1]")
	public WebElement Nafetynotificationtype;

	@FindBy(how = How.XPATH, using = "//*[@id=\"widget_SPACK_FROMDATE_TODATE_CONTROL\"]/div[1]")
	public WebElement from;

	@FindBy(how = How.XPATH, using = "//*[@id=\"widget_SPACK_FROMDATE_TODATETO_DATE_CONTROL\"]/div[1]")
	public WebElement To;

	@FindBy(how = How.XPATH, using = "//*[@id=\"uniqName_12_0_label\"]")
	public WebElement GenerateReport;

	@FindBy(how = How.XPATH, using = "//*[@id=\"SPON_USR_ACK_STATUS1\"]/div/div/div/div[6]/div/div/div[2]/div/table/tbody/tr[3]/td[1]/span")
	public WebElement No;

	@FindBy(how = How.XPATH, using = "//*[@id=\"SPON_USR_ACK_STATUS1\"]/div/div/div/div[6]/div/div/div[2]/div/table/tbody/tr[3]/td[2]/span")
	public WebElement ThereputicArea;

	@FindBy(how = How.XPATH, using = "//*[@id=\"SPON_USR_ACK_STATUS1\"]/div/div/div/div[6]/div/div/div[2]/div/table/tbody/tr[3]/td[3]/span")
	public WebElement compund;

	@FindBy(how = How.XPATH, using = "//*[@id=\"SPON_USR_ACK_STATUS1\"]/div/div/div/div[6]/div/div/div[2]/div/table/tbody/tr[3]/td[4]/span")
	public WebElement studyidd;

	@FindBy(how = How.XPATH, using = "//*[@id=\"SPON_USR_ACK_STATUS1\"]/div/div/div/div[6]/div/div/div[2]/div/table/tbody/tr[3]/td[5]/span")
	public WebElement countryy;

	@FindBy(how = How.XPATH, using = "//*[@id=\"SPON_USR_ACK_STATUS1\"]/div/div/div/div[6]/div/div/div[2]/div/table/tbody/tr[3]/td[6]/span")
	public WebElement studysiteid;

	@FindBy(how = How.XPATH, using = "//*[@id=\"SPON_USR_ACK_STATUS1\"]/div/div/div/div[6]/div/div/div[2]/div/table/tbody/tr[3]/td[7]/span")
	public WebElement documentname;

	@FindBy(how = How.XPATH, using = "//*[@id=\"SPON_USR_ACK_STATUS1\"]/div/div/div/div[6]/div/div/div[2]/div/table/tbody/tr[3]/td[8]/span")
	public WebElement acknowldgestatus;

	@FindBy(how = How.XPATH, using = "//*[@id=\"SPON_USR_ACK_STATUS1\"]/div/div/div/div[6]/div/div/div[2]/div/table/tbody/tr[3]/td[9]/span")
	public WebElement acknoledgementmode;

	@FindBy(how = How.XPATH, using = "//*[@id=\"SPON_USR_ACK_STATUS1\"]/div/div/div/div[6]/div/div/div[2]/div/table/tbody/tr[4]/td[2]/span")
	public WebElement dataacknoledge;

	@FindBy(how = How.XPATH, using = "//*[@id=\"SPON_USR_ACK_STATUS1\"]/div/div/div/div[6]/div/div/div[2]/div/table/tbody/tr[3]/td[16]/span")
	public WebElement acknowledgebysiteuserrole;

	@FindBy(how = How.XPATH, using = "//*[@id=\"SPON_USR_ACK_STATUS1\"]/div/div/div/div[6]/div/div/div[2]/div/table/tbody/tr[3]/td[17]/span")
	public WebElement acknowledgebysiteusename;

	@FindBy(how = How.XPATH, using = "//*[@id=\"SPON_USR_ACK_STATUS1\"]/div/div/div/div[6]/div/div/div[2]/div/table/tbody/tr[3]/td[18]/span")
	public WebElement facilityname;

	@FindBy(how = How.XPATH, using = "//*[@id=\"SPON_USR_ACK_STATUS1\"]/div/div/div/div[6]/div/div/div[2]/div/table/tbody/tr[3]/td[19]/span")
	public WebElement daterecievedbysitea;

	@FindBy(how = How.XPATH, using = "//*[@id=\"SPON_USR_ACK_STATUS1\"]/div/div/div/div[6]/div/div/div[2]/div/table/tbody/tr[3]/td[20]/span")
	public WebElement sposorreceivedateb;

	@FindBy(how = How.XPATH, using = "//*[@id=\"SPON_USR_ACK_STATUS1\"]/div/div/div/div[6]/div/div/div[2]/div/table/tbody/tr[3]/td[21]/span")
	public WebElement duration;

	@FindBy(how = How.XPATH, using = "//*[@id=\"SPON_USR_ACK_STATUS1\"]/div/div/div/div[6]/div/div/div[2]/div/table/tbody/tr[3]/td[22]/span")
	public WebElement safetynotificationreportdate;

	@FindBy(how = How.XPATH, using = "//*[@id=\"SPON_USR_ACK_STATUS1\"]/div/div/div/div[6]/div/div/div[2]/div/table/tbody/tr[3]/td[23]/span")
	public WebElement susarsubtype;

	@FindBy(how = How.XPATH, using = "//*[@id=\"SPON_USR_ACK_STATUS1\"]/div/div/div/div[6]/div/div/div[2]/div/table/tbody/tr[3]/td[24]")
	public WebElement initialsusar;

	@FindBy(how = How.XPATH, using = "//*[@id=\"SPON_USR_ACK_STATUS1\"]/div/div/div/div[6]/div/div/div[2]/div/table/tbody/tr[3]/td[25]/span")
	public WebElement reportingtime;

	@FindBy(how = How.XPATH, using = "//*[@id=\"SPON_USR_ACK_STATUS1\"]/div/div/div/div[6]/div/div/div[2]/div/table/tbody/tr[3]/td[25]/span")
	public WebElement manufracturerreportingtime;

	@FindBy(how = How.XPATH, using = "//*[@id=\"SPON_USR_ACK_STATUS1\"]/div/div/div/div[6]/div/div/div[2]/div/table/tbody/tr[3]/td[27]/span")
	public WebElement sposorversionnumber;

	@FindBy(how = How.ID, using = "jspDropDownValue")
	public WebElement gerenareterereportdropdown;

	@FindBy(how = How.ID, using = "generateReportSelDesc")
	public WebElement description;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Facility Country')]")
	public WebElement FacilityCountry;

	@FindBy(how = How.XPATH, using = "//*[@id=\"facilityDiv\"]/span")
	public WebElement FacilityName;

	@FindBy(how = How.ID, using = "departmentDiv")
	public WebElement DepartmentName;

	@FindBy(how = How.XPATH, using = "//*[@id=\"siteRoleDiv\"]/span")
	public WebElement SiteUserRole;

	@FindBy(how = How.XPATH, using = "//*[@id=\"siteUserDiv\"]/span")
	public WebElement SiteUser;

	@FindBy(how = How.XPATH, using = "//*[@id=\"delegTypeDiv\"]/span")
	public WebElement DelegationType;

	@FindBy(how = How.XPATH, using = "//*[@id=\"countryDiv\"]/span")
	public WebElement facilitycountrydropdown;

	@FindBy(how = How.XPATH, using = "//div[@id='facilityDiv']//span[@class='site-sel-container tAsite-sel-container']")
	public WebElement facilitynamedropdown;

	@FindBy(how = How.XPATH, using = "//*[@id=\"populateTable\"]/div/div/div/div[3]/input[1]")
	public WebElement generatereport;

	@FindBy(how = How.XPATH, using = "//*[@id=\"facilityError\"]")
	public WebElement errormsg;

	@FindBy(how = How.XPATH, using = "//*[@id=\"facilityDivDummy\"]/div[1]/span[1]/span")
	public WebElement checkbox;

	@FindBy(how = How.XPATH, using = "//*[@id=\"facilityDiv\"]/div/div[1]/a[1]/i")
	public WebElement close;

	@FindBy(how = How.XPATH, using = "//*[@id=\"departmentDiv\"]")
	public WebElement departmentname;

	@FindBy(how = How.XPATH, using = "//div[@id='siteRoleDiv']//span[@class='site-sel-container tAsite-sel-container']")
	public WebElement siteuserdropdown;

	@FindBy(how = How.XPATH, using = "//*[@id=\\\"siteRoleDiv\\\"]/div/div[1]/span[2]")
	public WebElement all;

	@FindBy(how = How.XPATH, using = "//*[@id=\"siteRoleDivvalue\"]/div[1]/span[2]")
	public WebElement clinicalresearchuser;

	@FindBy(how = How.XPATH, using = "//*[@id=\"siteRoleDivvalue\"]/div[2]/span[2]")
	public WebElement investigator;

	@FindBy(how = How.XPATH, using = "//*[@id=\"siteUserDiv\"]/span")
	public WebElement siteuserdr;

	@FindBy(how = How.XPATH, using = "//*[@id=\"mCSB_18_container\"]/div[1]/span[1]/span")
	public WebElement chq;

	@FindBy(how = How.XPATH, using = "//*[@id=\"siteUserDiv\"]/div/div[1]/a[1]/i")
	public WebElement clo;

	@FindBy(how = How.XPATH, using = "//*[@id=\"delegTypeDiv\"]/span")
	public WebElement delegationtypedropdown;

	@FindBy(how = How.XPATH, using = "//*[@id=\"delegTypeDiv\"]/div/div[1]/span[2]")
	public WebElement All;

	@FindBy(how = How.XPATH, using = "//*[@id=\"delegTypeDiv\"]/div/div[2]/div[1]/span[2]")
	public WebElement regulatorycontact;

	@FindBy(how = How.XPATH, using = "//*[@id=\"delegTypeDiv\"]/div/div[2]/div[2]/span[2]")
	public WebElement safetycontact;

	@FindBy(how = How.XPATH, using = "//*[@id=\"delegTypeDiv\"]/div/div[2]/div[3]/span[2]")
	public WebElement studysiteprofilemaintance;

	@FindBy(how = How.XPATH, using = "//*[@id=\"delegTypeDiv\"]/div/div[2]/div[4]/span[2]")
	public WebElement SURVEY;

	@FindBy(how = How.XPATH, using = "//*[@id=\"delegTypeDiv\"]/div/div[2]/div[5]/span[2]")
	public WebElement userprofile;

	@FindBy(how = How.XPATH, using = "//*[@id=\"populateTable\"]/div/div/div/div[3]/input[1]")
	public WebElement clos;

	@FindBy(how = How.XPATH, using = "//*[@id=\"populateTable\"]/div/div/div/div[3]/input[1]")
	public WebElement generaterepobutton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"populateTable\"]/div/div/div/div[3]/input[2]")
	public WebElement clearsearch;

	@FindBy(how = How.XPATH, using = "//*[@id=\"Navigationmenu\"]/li[9]/a")
	public WebElement Report1;

	@FindBy(how = How.XPATH, using = "//*[@id=\"siteRoleDiv\"]/div/div[1]/span[1]/span")
	public WebElement allcheck;

	@FindBy(how = How.XPATH, using = "//*[@id=\"siteRoleDiv\"]/div/div[1]/a[1]/i")
	public WebElement closee;

	@FindBy(how = How.XPATH, using = "//*[@id=\"generateReportSelDesc\"]")
	public WebElement desc1;

	@FindBy(how = How.XPATH, using = "//*[@id=\"therapeuticDiv\"]/span")
	public WebElement factheraputic;

	@FindBy(how = How.XPATH, using = "//*[@id=\"subTherapeuticDiv\"]")
	public WebElement facsubtheraputic;

	@FindBy(how = How.XPATH, using = "//*[@id=\"countryDiv\"]/span")
	public WebElement faccountry;

	@FindBy(how = How.XPATH, using = "//*[@id=\"facState\"]")
	public WebElement facstate;

	@FindBy(how = How.XPATH, using = "//*[@id=\"FacilityName\"]")
	public WebElement facname;

	@FindBy(how = How.XPATH, using = "//*[@id=\"department-Type\"]")
	public WebElement doctype;

	@FindBy(how = How.XPATH, using = "//*[@id=\"FacilityName\"]")
	public WebElement facilitynme;

	@FindBy(how = How.XPATH, using = "//*[@id=\"department-Type\"]")
	public WebElement drodowntype;

	@FindBy(how = How.XPATH, using = "//*[@id=\"department-Type\"]")
	public WebElement faccountrie;

	@FindBy(how = How.XPATH, using = "//*[@id=\"populateTable\"]/div/div/div/div[3]/input[1]")
	public WebElement generaterepot;

	@FindBy(how = How.XPATH, using = "//*[@id=\"countryDiv\"]/span")
	public WebElement faccountrydrop;

	@FindBy(how = How.XPATH, using = "//div[236]//span[1]//span[1]")
	public WebElement check;

	@FindBy(how = How.XPATH, using = "//*[@id=\"delegTypeDiv\"]/div/div[1]/a[1]/i")
	public WebElement closed;

	@FindBy(how = How.XPATH, using = "//label[@class='checkbox-label']")
	public WebElement showhide;

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Facility')]")
	public WebElement title;

	@FindBy(how = How.XPATH, using = "//i[@class='fa fa-print']")
	public WebElement print;

	@FindBy(how = How.XPATH, using = "//i[@class='fa fa-download']")
	public WebElement export;

	@FindBy(how = How.ID, using = "pagination_limit")
	public WebElement ShowrowDropDown;

	@FindBy(how = How.XPATH, using = "//*[@id=\"fixTable-1\"]/thead/tr/th[1]/div")
	public WebElement facilityid;

	@FindBy(how = How.XPATH, using = "//*[@id=\"fixTable-1\"]/thead/tr/th[2]/div")
	public WebElement facilitynames;

	@FindBy(how = How.XPATH, using = "//*[@id=\"fixTable-1\"]/thead/tr/th[3]/div")
	public WebElement facilityadress;

	@FindBy(how = How.XPATH, using = "//*[@id=\"fixTable-1\"]/thead/tr/th[4]/div")
	public WebElement city;

	@FindBy(how = How.XPATH, using = "//*[@id=\"fixTable-1\"]/thead/tr/th[5]/div")
	public WebElement state;

	@FindBy(how = How.XPATH, using = "//*[@id=\"fixTable-1\"]/thead/tr/th[6]/div")
	public WebElement countrys;

	@FindBy(how = How.XPATH, using = "//*[@id=\"fixTable-1\"]/thead/tr/th[7]/div")
	public WebElement zip;

	@FindBy(how = How.XPATH, using = "//*[@id=\"fixTable-1\"]/thead/tr/th[8]/div")
	public WebElement deptid;

	@FindBy(how = How.XPATH, using = "//*[@id=\"fixTable-1\"]/tbody/tr/td[1]/div")
	public WebElement uniquefacilityid;

	@FindBy(how = How.XPATH, using = "//*[@id=\"fixTable-1\"]/tbody/tr/td[1]/div")
	public WebElement uniquedepartmentid;

	@FindBy(how = How.XPATH, using = "//*[@id=\"fixTable-1\"]/tbody/tr/td[2]/div/a")
	public WebElement facilitynamehyperlink;

	@FindBy(how = How.XPATH, using = "//*[@id=\"formPlace\"]/div[1]/div[1]/div/div/ul/li[1]")
	public WebElement facilityname1;

	@FindBy(how = How.XPATH, using = "//*[@id=\"facilityContactLi\"]")
	public WebElement facilitycontact;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'HGfhjfj')]")
	public WebElement deptname;

	@FindBy(how = How.XPATH, using = "//*[@id=\"tablePopulation\"]/div[3]/div[2]/div[1]/ul/button/i")
	public WebElement PRINT;

	@FindBy(how = How.XPATH, using = "//*[@id=\"sidebar\"]//print-preview-button-strip//cr-button[2]")
	public WebElement CLOSE;

	@FindBy(how = How.XPATH, using = "//*[@id=\"tablePopulation\"]/div[3]/div[2]/div[1]/ul/span/button/i")
	public WebElement EXPORT;

	@FindBy(how = How.XPATH, using = "//*[@id=\"tablePopulation\"]/div[3]/div[2]/div[1]/ul/span/div/ul/li[1]")
	public WebElement exportpdf;

	@FindBy(how = How.XPATH, using = "//*[@id=\"tablePopulation\"]/div[3]/div[2]/div[1]/ul/span/div/ul/li[2]")
	public WebElement exportxls;

	@FindBy(how = How.XPATH, using = "//*[@id=\"tablePopulation\"]/div[3]/div[2]/div[1]/ul/span/div/ul/li[3]")
	public WebElement exportcsv;

	@FindBy(how = How.XPATH, using = "//*[@id=\"NoRecordPopupSiteUserDelegation\"]/div/div[2]/button")
	public WebElement okkk;

	@FindBy(how = How.ID, using = "GeneralReportsId")
	public WebElement generalreport;

	@FindBy(how = How.XPATH, using = "//i[@class='fa fa-search']")
	public WebElement search;

	@FindBy(how = How.XPATH, using = "//*[@id=\"countryFacilitySearch\"]")
	public WebElement country1;

	@FindBy(how = How.XPATH, using = "//*[@id=\"facSearch\"]")
	public WebElement search1;

	@FindBy(how = How.XPATH, using = "//*[@id=\"populateTable\"]/div/div/div/div[4]/input[1]")
	public WebElement genaratereport;

	@FindBy(how = How.XPATH, using = "//*[@id=\"search-table\"]/thead/tr/th[1]/span")
	public WebElement checkall;

	@FindBy(how = How.XPATH, using = "//*[@id=\"MaxFacSelectionMSGSiteUserDelegation\"]/div/div[2]/button")
	public WebElement ok;

	@FindBy(how = How.XPATH, using = "//table[@id='search-table']/tbody[1]/tr[2]/td[1]/span[1]")
	public WebElement record1;
	
	@FindBy(how = How.XPATH, using = "//table[@id='search-table']/tbody[1]/tr[1]/td[1]/span[1]")
	public WebElement record;

	@FindBy(how = How.XPATH, using = "//table[@id='search-table']/tbody[1]/tr[5]/td[1]/span[1]")
	public WebElement record4;
	
	@FindBy(how = How.XPATH, using = "//table[@id='search-table']/tbody[1]/tr[3]/td[1]/span[1]")
	public WebElement record2;

	@FindBy(how = How.ID, using = "addFacButton")
	public WebElement select;

	@FindBy(how = How.XPATH, using = "//*[@id=\"facDisplayLink\"]/a")
	public WebElement viewselection;

	@FindBy(how = How.XPATH, using = "//*[@id=\"view-select-table\"]/thead/tr/th[1]")
	public WebElement facname1;

	@FindBy(how = How.XPATH, using = "//*[@id=\"view-select-table\"]/thead/tr/th[2]")
	public WebElement deptname1;

	@FindBy(how = How.XPATH, using = "//*[@id=\"view-select-table\"]/thead/tr/th[3]")
	public WebElement depttype;

	@FindBy(how = How.XPATH, using = "//*[@id=\"view-select-table\"]/thead/tr/th[4]")
	public WebElement country2;

	@FindBy(how = How.XPATH, using = "//*[@id=\"view-select-table\"]/thead/tr/th[5]")
	public WebElement state1;

	@FindBy(how = How.XPATH, using = "//*[@id=\"view-select-table\"]/thead/tr/th[6]")
	public WebElement city1;

	@FindBy(how = How.XPATH, using = "//*[@id=\"viewSelectionPopup\"]/div[2]/button")
	public WebElement ok11;

	@FindBy(how = How.XPATH, using = "//*[@id=\"facilityCompareButton\"]")
	public WebElement compare;

	@FindBy(how = How.XPATH, using = "(//span[@class='site-sel-container tAsite-sel-container'])[1]")
	public WebElement FacilityTherapeuticArea;

	@FindBy(how = How.XPATH, using = "(//span[@class='site-sel-container tAsite-sel-container'])[2]")
	public WebElement FacilitySubTherapeuticArea;

	@FindBy(how = How.XPATH, using = "//div[@id='countryDiv']/span")
	public WebElement Facicountry;// need to change index of facility Country
									// according to requirment

	@FindBy(how = How.ID, using = "FacilityName")
	public WebElement FacilityNameInGeneralReport;

	@FindBy(how = How.ID, using = "department-Type")
	public WebElement DepartmentTypeInGeneralReport;

	@FindBy(how = How.XPATH, using = "//input[@id='facState']")
	public WebElement FacilityState_Province_Region;

	@FindBy(how = How.XPATH, using = "//*[@id=\"tablePopulation\"]/div/div[1]/h2")
	public WebElement facilitycomparison;

	public void GenerateSNAcknowledgementStatus() throws Exception {

		Actions actions = new Actions(driver);

		actions.moveToElement(Report).build().perform();
		Thread.sleep(2000);
		generalRepert.click();

		Select reportdropdown = new Select(ReportSelect);
		reportdropdown.selectByVisibleText("Safety Acknowledgement Status Tracking Report");
		Thread.sleep(5000);

		properties = obj.getProperty();

		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),
				properties.getProperty("sheetName"), properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);

		Map<String, String> testDataInMap = testData.getTestDatainMap();

		String compound1 = testDataInMap.get("CompoundSUSAR");
		String compound2 = testDataInMap.get("Compound2SUSAR");

		String study1 = testDataInMap.get("studyID");
		String study2 = testDataInMap.get("studyID2");
		String study3 = testDataInMap.get("studyID3");

		String SN = testDataInMap.get("SN_TypeSUSAR");

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"safedNavEmbedId\"]")));

		selectComp.click();
		Thread.sleep(3000);
		selectComp.sendKeys(compound1);
		Thread.sleep(4000);
		selectComp.click();
		Thread.sleep(4000);
		selectComp.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		compclose.click();
		Thread.sleep(5000);

		selectComp.click();
		Thread.sleep(3000);
		System.out.println(compound2);
		selectComp.sendKeys(compound2);
		Thread.sleep(4000);
		WebElement comp2 = driver.findElement(By.xpath("//li[@title='" + compound2 + "']"));
		comp2.click();
		Thread.sleep(4000);
		selectComp.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		compclose.click();
		Thread.sleep(4000);

		selectStudyId.click();
		Thread.sleep(3000);
		selectStudyId.sendKeys(study1);
		selectStudyId.click();
		Thread.sleep(4000);
		selectStudyId.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		studyclose.click();
		Thread.sleep(5000);

		selectStudyId.click();
		Thread.sleep(2000);
		selectStudyId.sendKeys(study2);
		selectStudyId.click();
		Thread.sleep(4000);
		selectStudyId.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		studyclose.click();
		Thread.sleep(5000);

		selectStudyId.click();
		Thread.sleep(2000);
		selectStudyId.sendKeys(study3);
		selectStudyId.click();
		Thread.sleep(4000);
		selectStudyId.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		studyclose.click();
		Thread.sleep(5000);

		SNType.click();
		Thread.sleep(3000);

		WebElement selectSN = driver.findElement(By.xpath("//td[contains(text(),'" + SN + "')]"));
		selectSN.click();
		Thread.sleep(3000);

		fromDate.click();
		Thread.sleep(2000);

		actions.sendKeys(Keys.ENTER);

		// fromDate.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		toDate.click();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ENTER);
		// toDate.sendKeys(Keys.ENTER);
		Thread.sleep(10000);

		searchbutton.click();
		Thread.sleep(60000);

		reportTable.getText();
		System.out.print(reportTable.getText());

		driver.switchTo().defaultContent();

	}

	public void RobotEnter() throws Exception {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void RobotTab() throws Exception {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	public void ClickOnprint() throws InterruptedException, Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='fa fa-print']")).click();
		Thread.sleep(6000);
		Robot robot = new Robot();

		for (int i = 0; i < 5; i++) {
			RobotTab();
		}

		Thread.sleep(6000);
		RobotEnter();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);

		RobotEnter();

		for (int i = 0; i < 6; i++) {
			RobotTab();
		}

		for (int i = 0; i < 2; i++) {
			RobotEnter();
		}

		RobotTab(); // file replace move to yes button

		RobotEnter();

		// Thread.sleep(2000);

	}

	public void VerifySNAcknowledgementStatus() throws Exception {

		Actions actions = new Actions(driver);

		actions.moveToElement(Report).build().perform();
		Thread.sleep(2000);
		generalRepert.click();

		Select reportdropdown = new Select(ReportSelect);
		reportdropdown.selectByVisibleText("Safety Acknowledgement Status Tracking Report");
		Thread.sleep(65000);

		properties = obj.getProperty();

		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),
				properties.getProperty("sheetName"), properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);

		Map<String, String> testDataInMap = testData.getTestDatainMap();

		String compound1 = testDataInMap.get("CompoundSUSAR");
		// String compound2 = testDataInMap.get("Compound2SUSAR");

		String study1 = testDataInMap.get("studyID");
		String study2 = testDataInMap.get("studyID2");
		String study3 = testDataInMap.get("studyID3");

		String site1 = testDataInMap.get("studySiteId1");
		String site2 = testDataInMap.get("studySiteId2");
		String site3 = testDataInMap.get("studySiteId3");

		String Doc = testDataInMap.get("DocNameSUSAR");

		String SN = testDataInMap.get("SN_TypeSUSAR");

		String SNfrmDate = testDataInMap.get("SN_PostFromDate");
		String SNtoDate = testDataInMap.get("SN_ToFromDate");

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"safedNavEmbedId\"]")));

		selectComp.click();
		Thread.sleep(3000);
		selectComp.sendKeys(compound1);
		Thread.sleep(4000);
		selectComp.click();
		Thread.sleep(4000);
		selectComp.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		compclose.click();
		Thread.sleep(5000);

		// selectComp.click();
		// Thread.sleep(3000);
		// System.out.println(compound2);
		// selectComp.sendKeys(compound2);
		// Thread.sleep(4000);
		// WebElement
		// comp2=driver.findElement(By.xpath("//li[@title='"+compound2+"']"));
		// comp2.click();
		// Thread.sleep(4000);
		// selectComp.sendKeys(Keys.ENTER);
		// Thread.sleep(4000);
		// compclose.click();
		// Thread.sleep(4000);

		selectStudyId.click();
		Thread.sleep(4000);
		selectStudyId.sendKeys(study1);
		Thread.sleep(2000);
		selectStudyId.click();
		Thread.sleep(4000);
		selectStudyId.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		studyclose.click();
		Thread.sleep(8000);

		selectStudyId.click();
		Thread.sleep(4000);
		selectStudyId.sendKeys(study2);
		Thread.sleep(2000);
		selectStudyId.click();
		Thread.sleep(4000);
		selectStudyId.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		studyclose.click();
		Thread.sleep(8000);

		selectStudyId.click();
		Thread.sleep(4000);
		selectStudyId.sendKeys(study3);
		Thread.sleep(2000);
		selectStudyId.click();
		Thread.sleep(4000);
		selectStudyId.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		studyclose.click();
		Thread.sleep(5000);

		SNType.click();
		Thread.sleep(3000);

		WebElement selectSN = driver.findElement(By.xpath("//td[contains(text(),'" + SN + "')]"));
		selectSN.click();
		Thread.sleep(3000);

		fromDate.sendKeys(SNfrmDate);
		Thread.sleep(4000);

		// actions.sendKeys(Keys.ENTER);
		// fromDate.sendKeys(Keys.ENTER);

		toDate.sendKeys(SNtoDate);
		Thread.sleep(5000);
		// actions.sendKeys(Keys.ENTER);
		// toDate.sendKeys(Keys.ENTER);
		// Thread.sleep(10000);

		searchbutton.click();
		Thread.sleep(60000);

		// System.out.print(reportTable.getText());

		WebElement Ack1 = driver.findElement(By.xpath("//span[contains(text(),'" + site1
				+ "')]//..//./following::td[1]//span[contains(text(),'" + Doc + "')]/following::td[1]"));
		WebElement Ack2 = driver.findElement(By.xpath("//span[contains(text(),'" + site2
				+ "')]//..//./following::td[1]//span[contains(text(),'" + Doc + "')]/following::td[1]"));
		WebElement Ack3 = driver.findElement(By.xpath("//span[contains(text(),'" + site3
				+ "')]//..//./following::td[1]//span[contains(text(),'" + Doc + "')]/following::td[1]"));

		System.out.println(Ack1.getText());

		if (Ack1.getText() == Ack2.getText() && Ack2.getText() == Ack3.getText() && Ack3.getText() == "Pending") {

			System.out.println("pass");

		} else {

			System.out.println("fail");
		}

		driver.switchTo().defaultContent();

	}

	public void Generate_Safety_Acknowledgement_Status_Tracking_Report() throws Exception

	{

		properties = obj.getProperty();

		Map<String, String> testDataInMap = testData.getTestDatainMap();
		String AuditTrailReport1 = testDataInMap.get("AuditTrailReport1");

		// Map<String,String> testDataInMap = testData.getTestDatainMap();
		String TrainingType = testDataInMap.get("TrainingType");
		String ProviderType = testDataInMap.get("Provider");
		String SelectDate = testDataInMap.get("Date");
		String Header_1 = testDataInMap.get("PageHeader");

		Reportdropdown.click();
		Thread.sleep(10000);
		Generalreport.click();
		Thread.sleep(10000);
		GeneralDropdown.click();
		Thread.sleep(10000);
		Select Report = new Select(GeneralDropdown);
		Report.selectByVisibleText("Safety Acknowledgement Status Tracking Report");
		Thread.sleep(12000);

		//

		//

	}

	public void Verify_Fields() throws Exception

	{

		properties = obj.getProperty();

		Map<String, String> testDataInMap = testData.getTestDatainMap();
		String AuditTrailReport1 = testDataInMap.get("AuditTrailReport1");

		// Map<String,String> testDataInMap = testData.getTestDatainMap();
		String TrainingType = testDataInMap.get("TrainingType");
		String ProviderType = testDataInMap.get("Provider");
		String SelectDate = testDataInMap.get("Date");
		String Header_1 = testDataInMap.get("PageHeader");

		Thread.sleep(12000);
		Highlightelement("compound");
		Thread.sleep(6000);
		Highlightelement("studyid");
		Thread.sleep(6000);
		Highlightelement("country");
		Thread.sleep(6000);
		Highlightelement("Studysiteid");
		Thread.sleep(6000);
		Highlightelement("safetynotificationtype");
		Thread.sleep(6000);
		Highlightelement("safetyfromto");
		Thread.sleep(12000);

		//

		//

	}

	private void Highlightelement(String string) {
		// TODO Auto-generated method stub

	}

	public void Enter_all_data_generate_report() throws Exception

	{

		properties = obj.getProperty();

		Map<String, String> testDataInMap = testData.getTestDatainMap();
		String AuditTrailReport1 = testDataInMap.get("AuditTrailReport1");

		// Map<String,String> testDataInMap = testData.getTestDatainMap();
		String TrainingType = testDataInMap.get("TrainingType");
		String ProviderType = testDataInMap.get("Provider");
		String SelectDate = testDataInMap.get("Date");
		String Header_1 = testDataInMap.get("PageHeader");

		Thread.sleep(8000);
		Nafetynotificationtype.click();
		Thread.sleep(6000);
		Nafetynotificationtype.click();
		Thread.sleep(10000);
		Select Report = new Select(Nafetynotificationtype);
		Report.selectByVisibleText("Suspected Unexpected Serious Adverse Reaction (SUSAR)");
		Thread.sleep(10000);
		// from.click();
		// Thread.sleep(5000);
		// Robot robot = new Robot();
		// Thread.sleep(2000);
		// robot.keyPress(KeyEvent.VK_ENTER);
		// Thread.sleep(2000);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		// Thread.sleep(12000);
		// To.click();
		// Thread.sleep(5000);
		// Robot robot1 = new Robot();
		// Thread.sleep(2000);
		// robot1.keyPress(KeyEvent.VK_ENTER);
		// Thread.sleep(2000);
		// robot1.keyRelease(KeyEvent.VK_ENTER);
		// Thread.sleep(12000);
		// GenerateReport.click();
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementById('from').value='02-Jan-2020'");
		Thread.sleep(3000);
		js.executeScript("document.getElementById('To').value='17-Jul-2020'");
		Thread.sleep(15000);
		GenerateReport.click();
		Thread.sleep(15000);
		js.executeScript("window.scrollBy(0,750)");
		Thread.sleep(5000);

		//

		//

	}

	public void Verify_No_Column() throws Exception

	{

		properties = obj.getProperty();

		Thread.sleep(8000);
		Highlightelement("NO");
		Thread.sleep(6000);

	}

	public void Verify_Thereputicarea_Column() throws Exception

	{

		properties = obj.getProperty();

		Thread.sleep(8000);
		Highlightelement("ThereputicArea");
		Thread.sleep(6000);

	}

	public void Verify_compound_Column() throws Exception

	{

		properties = obj.getProperty();

		Thread.sleep(8000);
		Highlightelement("compund");
		Thread.sleep(6000);

	}

	public void Verify_studyid_Column() throws Exception

	{

		properties = obj.getProperty();

		Thread.sleep(8000);
		Highlightelement("studyidd");
		Thread.sleep(6000);

	}

	public void Verify_country_Column() throws Exception

	{

		properties = obj.getProperty();

		Thread.sleep(8000);
		Highlightelement("countryy");
		Thread.sleep(6000);

	}

	public void Verify_studysite_Column() throws Exception

	{

		properties = obj.getProperty();

		Thread.sleep(8000);
		Highlightelement("studysiteid");
		Thread.sleep(6000);

	}

	public void Verify_documentname_Column() throws Exception

	{

		properties = obj.getProperty();

		Thread.sleep(8000);
		Highlightelement("documentname");
		Thread.sleep(6000);

	}

	public void Verify_acknowledgementstatus_Column() throws Exception

	{

		properties = obj.getProperty();

		Thread.sleep(8000);
		Highlightelement("acknowldgestatus");
		Thread.sleep(6000);

	}

	public void Verify_acknowledgementmode_Column() throws Exception

	{

		properties = obj.getProperty();

		Thread.sleep(8000);
		Highlightelement("acknoledgementmode");
		Thread.sleep(6000);

	}

	public void Verify_dataacknowledgement_Column() throws Exception

	{

		properties = obj.getProperty();

		Thread.sleep(8000);
		Highlightelement("dataacknoledge");
		Thread.sleep(6000);

	}

	public void Verify_acknowlededgebysiteuserrole_Column() throws Exception

	{

		properties = obj.getProperty();

		Thread.sleep(8000);
		Highlightelement("acknowledgebysiteuserrole");
		Thread.sleep(6000);

	}

	public void Verify_acknowlededgebysiteusername_Column() throws Exception

	{

		properties = obj.getProperty();

		Thread.sleep(8000);
		Highlightelement("acknowledgebysiteusename");
		Thread.sleep(6000);

	}

	public void Verify_facilityname_Column() throws Exception

	{

		properties = obj.getProperty();

		Thread.sleep(8000);
		Highlightelement("facilityname");
		Thread.sleep(6000);

	}

	public void Verify_daterecievedbysiteA_Column() throws Exception

	{

		properties = obj.getProperty();

		Thread.sleep(8000);
		Highlightelement("daterecievedbysitea");
		Thread.sleep(6000);

	}

	public void Verify_daterecievedbysiteB_Column() throws Exception

	{

		properties = obj.getProperty();

		Thread.sleep(8000);
		Highlightelement("sposorreceivedateb");
		Thread.sleep(6000);

	}

	public void Verify_Duration() throws Exception

	{

		properties = obj.getProperty();

		Thread.sleep(8000);
		Highlightelement("duration");
		Thread.sleep(6000);

	}

	public void Verify_safety_notification_reportdate() throws Exception

	{

		properties = obj.getProperty();

		Thread.sleep(8000);
		Highlightelement("safetynotificationreportdate");
		Thread.sleep(6000);

	}

	public void Verify_susar_subtype() throws Exception

	{

		properties = obj.getProperty();

		Thread.sleep(8000);
		Highlightelement("susarsubtype");
		Thread.sleep(6000);

	}

	public void Verify_Initial_SUSAR_distributed_outside_system() throws Exception

	{

		properties = obj.getProperty();

		Thread.sleep(8000);
		Highlightelement("initialsusar");
		Thread.sleep(6000);

	}

	public void Verify_Reporting_Timeline() throws Exception

	{

		properties = obj.getProperty();

		Thread.sleep(8000);
		Highlightelement("reportingtime");
		Thread.sleep(6000);

	}

	public void Verify_manufracture_report_number() throws Exception

	{

		properties = obj.getProperty();

		Thread.sleep(8000);
		Highlightelement("manufracturerreportingtime");
		Thread.sleep(6000);

	}

	public void Verify_sposor_version_number() throws Exception

	{

		properties = obj.getProperty();

		Thread.sleep(8000);
		Highlightelement("sposorversionnumber");
		Thread.sleep(6000);

	}

	public void Verify_fields_sortable() throws Exception

	{

		properties = obj.getProperty();

		Thread.sleep(8000);

		Thread.sleep(6000);

	}

	public void Navigatetogeneratereportandverify() throws Exception

	{

		Thread.sleep(6000);
		Report1.click();
		Thread.sleep(6000);
		Select gerenareterereportdropdown1 = new Select(gerenareterereportdropdown);
		gerenareterereportdropdown1.selectByVisibleText("Site User Delegation Details Report");
		Thread.sleep(5000);
		Highlightelement("description");
		Thread.sleep(6000);

		if (description.getText()
				.contains("DESCRIPTION: This report provides the Site User's Active Delegate assignments")) {
			System.out.println("Test pass");
		} else {
			System.out.println("Test Fail");

		}
		Thread.sleep(6000);
	}

	public void facilitydepartmentcapabilitycomparisonreport() throws Exception

	{

		// Thread.sleep(6000);
		// Report1.click();
		// Thread.sleep(6000);
		Select gerenareterereportdropdown1 = new Select(gerenareterereportdropdown);
		gerenareterereportdropdown1.selectByVisibleText("Facility/Department Capabilities Comparison Report");
		Thread.sleep(5000);

	}

	public void FacilityDepartment_Contact_Details_Report() throws InterruptedException {
		Thread.sleep(6000);
		Select gerenareterereportdropdown1 = new Select(gerenareterereportdropdown);
		gerenareterereportdropdown1.selectByVisibleText("Facility/Department Contact Details Report");
		Thread.sleep(6000);
		highLightElement(driver.findElement(By.id("generateReportSelDesc")));
		if (FacilitySubTherapeuticArea.isEnabled()) {
			System.out.println("Fail--FacilitySubTherapeuticArea is enable");
		} else {
			System.out.println("Pass--FacilitySubTherapeuticArea is Disable");
		}

		if (FacilityState_Province_Region.isEnabled()) {
			System.out.println("Fail--FacilityState_Province_Region is enable");
		} else {
			System.out.println("Pass--FacilityState_Province_Region is Disable");
		}
	}

	public void EnterDetailsUnder_FacilityDepartment_Contact_DetailsReport() throws IOException, InterruptedException {
		properties = obj.getProperty();
		String TherapeuticArea = properties.getProperty("FacilityTherapeuticArea");
		String TherapeuticSubArea = properties.getProperty("FacilitySub-TherapeuticArea");
		String country = properties.getProperty("Country");

		FacilityTherapeuticArea.sendKeys(TherapeuticArea);
		Thread.sleep(3000);
		WebElement checkselected = driver.findElement(
				By.xpath("//span[normalize-space(text())='" + TherapeuticArea + "']/preceding-sibling::span"));
		checkselected.click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//a[@href='javascript:void(0)']//i)[1]")).click();
		Thread.sleep(2000);

		FacilitySubTherapeuticArea.sendKeys(TherapeuticSubArea);
		Thread.sleep(3000);
		WebElement checkselected2 = driver.findElement(
				By.xpath("//span[normalize-space(text())='" + TherapeuticSubArea + "']/preceding-sibling::span"));
		checkselected2.click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//a[@href='javascript:void(0)']//i)[2]")).click();
		Thread.sleep(2000);

		Facicountry.sendKeys(country);
		Thread.sleep(3000);
		WebElement checkselected3 = driver
				.findElement(By.xpath("//span[normalize-space(text())='" + country + "']/preceding-sibling::span"));
		checkselected3.click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//a[@href='javascript:void(0)']//i)[3]")).click();
		Thread.sleep(3000);
		generatereport.click();
	}

	public void EnterFacilityDepartmentCountryUnder_FacilityDepartment_Contact_Details()
			throws InterruptedException, IOException {
		properties = obj.getProperty();
		String country = properties.getProperty("Country");
		String FaciName = properties.getProperty("FacilityName");
		String DepartmentType = properties.getProperty("DepartmentType");

		FacilityNameInGeneralReport.sendKeys(FaciName);
		Thread.sleep(4000);

		Select sc = new Select(DepartmentTypeInGeneralReport);
		sc.selectByVisibleText(DepartmentType);

		Thread.sleep(4000);

		Facicountry.sendKeys(country);
		Thread.sleep(3000);
		WebElement checkselected3 = driver
				.findElement(By.xpath("//span[normalize-space(text())='" + country + "']/preceding-sibling::span"));
		checkselected3.click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//a[@href='javascript:void(0)']//i)[3]")).click();
		Thread.sleep(3000);
		generatereport.click();
		Thread.sleep(5000);

		print.isDisplayed();
		highLightElement(PRINT);

		export.isDisplayed();
		highLightElement(export);

		try {
			showhide.isDisplayed();
			highLightElement(showhide);

			ShowrowDropDown.isDisplayed();
			highLightElement(ShowrowDropDown);
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println("No");
		}
		Thread.sleep(3000);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollBy(0,300)");

	}

	public void VerifydetailsReportRecordsInTabularForm() throws InterruptedException {
		Thread.sleep(3000);
		try {

			WebElement FacilityName = driver
					.findElement(By.xpath("//table[@id='fixTable-1']/tbody[1]/tr[1]/td[2]/div[1]/a[1]"));
			FacilityName.isDisplayed();
			highLightElement(FacilityName);

			WebElement FacilityAdress = driver.findElement(By.xpath("(//div[@data-char='100'])[3]"));
			FacilityAdress.isDisplayed();
			highLightElement(FacilityAdress);

			WebElement City = driver.findElement(By.xpath("(//div[@data-char='100'])[4]"));
			City.isDisplayed();
			highLightElement(City);

			WebElement State = driver.findElement(By.xpath("(//div[@data-char='100'])[5]"));
			State.isDisplayed();
			highLightElement(State);

			WebElement Country = driver.findElement(By.xpath("(//div[@data-char='100'])[6]"));
			Country.isDisplayed();
			highLightElement(Country);

			WebElement ZIPCode = driver.findElement(By.xpath("(//div[@data-char='100'])[7]"));
			ZIPCode.isDisplayed();
			highLightElement(ZIPCode);

			WebElement scrollbar = driver.findElement(By.xpath("(//div[@id='mCSB_3_dragger_horizontal']/div)[1]"));

			Actions actions = new Actions(driver);
			actions.moveToElement(scrollbar).build().perform();
			Thread.sleep(3000);
			actions.dragAndDropBy(scrollbar, 400, 0).perform();
			System.out.println("Scroll right");
			actions.dragAndDropBy(scrollbar, 200, 0).perform();
			Thread.sleep(2000);

			WebElement DepartmentName = driver.findElement(By.xpath("(//div[@data-char='100'])[9]"));
			DepartmentName.isDisplayed();
			highLightElement(DepartmentName);

			WebElement DepartmentType = driver.findElement(By.xpath("(//div[@data-char='100'])[10]"));
			DepartmentType.isDisplayed();
			highLightElement(DepartmentType);

			WebElement DepartmentAdress = driver.findElement(By.xpath("(//div[@data-char='100'])[11]"));
			DepartmentAdress.isDisplayed();
			highLightElement(DepartmentAdress);

			WebElement FacilityRole = driver.findElement(By.xpath("(//div[@data-char='100'])[12]"));
			FacilityRole.isDisplayed();
			highLightElement(FacilityRole);

			WebElement ContactName = driver.findElement(By.xpath("(//div[@data-char='100'])[13]"));
			ContactName.isDisplayed();
			highLightElement(ContactName);

			WebElement ContactEmailAdress = driver.findElement(By.xpath("(//div[@data-char='100'])[14]"));
			ContactEmailAdress.isDisplayed();
			highLightElement(ContactEmailAdress);

			WebElement MainPhone = driver.findElement(By.xpath("(//div[@data-char='100'])[15]"));
			WebElement Fax = driver.findElement(By.xpath("(//div[@data-char='100'])[16]"));

			WebElement SIPUserID = driver.findElement(By.xpath("(//div[@data-char='100'])[17]"));
			SIPUserID.isDisplayed();
			highLightElement(SIPUserID);

		} catch (Exception e) {
			System.out.println("Not verified");
		}
	}

	public void VerifyRecordsofAssociatedDepartment() throws InterruptedException {
		WebElement DepartmentType = driver.findElement(By.xpath("(//div[@data-char='100'])[27]"));
		DepartmentType.isDisplayed();
		highLightElement(DepartmentType);
		Thread.sleep(2000);
		WebElement DepartmentType3row = driver.findElement(By.xpath("(//div[@data-char='100'])[44]"));
		highLightElement(DepartmentType3row);
		Thread.sleep(2000);
		WebElement DepartmentType4row = driver.findElement(By.xpath("(//div[@data-char='100'])[61]"));
		highLightElement(DepartmentType4row);
	}

	public void VerifyRecordsofAssociatedSiteUsers() throws InterruptedException {
		WebElement ContactName2 = driver.findElement(By.xpath("(//div[@data-char='100'])[30]"));
		highLightElement(ContactName2);
		Thread.sleep(2000);
		WebElement ContactName3 = driver.findElement(By.xpath("(//div[@data-char='100'])[47]"));
		highLightElement(ContactName3);
		Thread.sleep(2000);
		WebElement ContactName4 = driver.findElement(By.xpath("(//div[@data-char='100'])[64]"));
		highLightElement(ContactName4);
	}

	public void Verifymentionedfields() throws Exception

	{

		Thread.sleep(6000);
		Highlightelement("FacilityCountry");
		Thread.sleep(6000);
		Highlightelement("FacilityName");
		Thread.sleep(6000);
		Highlightelement("DepartmentName");
		Thread.sleep(6000);
		Highlightelement("SiteUserRole");
		Thread.sleep(6000);
		Highlightelement("SiteUser");
		Thread.sleep(6000);
		Highlightelement("DelegationType");
		Thread.sleep(6000);

		if (FacilityCountry.getText().contains("Facility Country")) {
			System.out.println("Test pass");
		} else {
			System.out.println("Test Fail");

		}
		Thread.sleep(6000);

		if (FacilityName.getText().contains("Facility Name")) {
			System.out.println("Test pass");
		} else {
			System.out.println("Test Fail");

		}
		Thread.sleep(6000);

		if (DepartmentName.getText().contains("Department Name")) {
			System.out.println("Test pass");
		} else {
			System.out.println("Test Fail");

		}
		Thread.sleep(6000);

		if (SiteUserRole.getText().contains("Site User Role")) {
			System.out.println("Test pass");
		} else {
			System.out.println("Test Fail");

		}
		Thread.sleep(6000);

		if (SiteUser.getText().contains("Site User")) {
			System.out.println("Test pass");
		} else {
			System.out.println("Test Fail");

		}
		Thread.sleep(6000);

		if (DelegationType.getText().contains("Delegation Type")) {
			System.out.println("Test pass");
		} else {
			System.out.println("Test Fail");

		}
		Thread.sleep(6000);
	}

	public void verifyfacilitycountrydropdown() throws Exception

	{

		Thread.sleep(6000);
		facilitycountrydropdown.click();
		Actions action = new Actions(driver);
		List<WebElement> actualValues = driver
				.findElements(By.xpath("//div[@id='Countrydiv']//child::div[@class='children']/span[2]"));
		List<String> expectedValues = Arrays.asList("Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra",
				"Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia",
				"Austria", "Azerbaijan", "Albania", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus",
				"Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia (Plurinational State of)",
				"Bonaire, Sint Eustatius and Saba", "Bosnia and Herzegovina", "Botswana", "Bouvet Island", "Brazil",
				"British Indian Ocean Territory", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi",
				"Cabo Verde", "Cambodia", "Cameroon", "Canada", "Cayman Islands", "Central African Republic", "Chad",
				"Chile", "China", "Yemen", "Zambia", "Zimbabwe");

		for (int i = 0; i < actualValues.size(); i++) {
			boolean flag = false;
			String actualValue = actualValues.get(i).getText();

			for (int j = 0; j < expectedValues.size(); j++) {
				if (actualValue.equals(expectedValues.get(j))) {
					flag = true;
					break;
				}
			}
			action.dragAndDropBy(
					driver.findElement(
							By.xpath("//div[@id='Countrydiv']//descendant::div//*[contains(@id,'dragger_vertical')]")),
					0, 5).perform();
			Assert.assertTrue(flag);
			Thread.sleep(1000);
		}

	}

	public void verifyerrormsg() throws Exception

	{

		Thread.sleep(6000);
		facilitynamedropdown.click();
		Thread.sleep(6000);
		generatereport.click();
		Thread.sleep(6000);
		Highlightelement("errormsg");
		Thread.sleep(6000);
	}

	public void verifyfacilityname() throws Exception

	{

		Thread.sleep(6000);
		facilitynamedropdown.click();
		Thread.sleep(6000);
		facilitynamedropdown.sendKeys("Athens Primary Care");
		Thread.sleep(4000);
		checkbox.click();
		Thread.sleep(6000);
		close.click();
		Thread.sleep(6000);

	}

	public void verifydepartment() throws Exception

	{

		Thread.sleep(6000);
		Highlightelement("departmentname");
		Thread.sleep(6000);

	}

	public void verifysiteuserrole() throws Exception

	{

		Thread.sleep(6000);
		siteuserdropdown.click();
		Thread.sleep(6000);
		Highlightelement("all");
		Thread.sleep(6000);
		Highlightelement("clinicalresearchuser");
		Thread.sleep(6000);
		Highlightelement("investigator");
		Thread.sleep(6000);
		allcheck.click();
		Thread.sleep(6000);
		closee.click();
		Thread.sleep(6000);

	}

	public void verifysiteuserdropdown() throws Exception

	{

		Thread.sleep(6000);
		siteuserdropdown.click();
		Thread.sleep(6000);
		Highlightelement("siteuserdr");
		Thread.sleep(6000);
		siteuserdr.click();
		Thread.sleep(6000);
		siteuserdr.sendKeys("Jaquel, Ricky");
		Thread.sleep(6000);
		// chq.click();
		Thread.sleep(6000);
		clo.click();
		Thread.sleep(6000);

	}

	public void verifydelegationtypedropdown() throws Exception

	{

		Thread.sleep(6000);
		delegationtypedropdown.click();
		Thread.sleep(6000);
		Highlightelement("All");
		Thread.sleep(6000);
		Highlightelement("regulatorycontact");
		Thread.sleep(6000);
		Highlightelement("safetycontact");
		Thread.sleep(6000);
		Highlightelement("studysiteprofilemaintance");
		Thread.sleep(6000);
		Highlightelement("SURVEY");
		Thread.sleep(6000);
		Highlightelement("userprofile");
		Thread.sleep(6000);
		clos.click();
		Thread.sleep(6000);

	}

	public void verifybuttons() throws Exception

	{

		Thread.sleep(6000);
		Highlightelement("generaterepobutton");
		Thread.sleep(6000);
		Highlightelement("clearsearch");
		Thread.sleep(6000);

	}

	public void Navigategeneratereportandverify() throws Exception

	{

		Thread.sleep(6000);
		Report.click();
		Thread.sleep(6000);
		generalRepert.click();
		Thread.sleep(6000);
		Select reportdropdown = new Select(ReportSelect);
		reportdropdown.selectByVisibleText("Facility/Department Contact Details Report");
		Thread.sleep(5000);
		Highlightelement("desc1");
		Thread.sleep(6000);
		Highlightelement("factheraputic");
		Thread.sleep(6000);
		Highlightelement("facsubtheraputic");
		Thread.sleep(6000);
		Highlightelement("faccountry");
		Thread.sleep(6000);
		Highlightelement("facstate");
		Thread.sleep(6000);
		Highlightelement("facname");
		Thread.sleep(6000);
		Highlightelement("doctype");
		Thread.sleep(6000);

	}

	public void Verifystatedropdowndisable() throws Exception

	{
		Thread.sleep(6000);
		Highlightelement("facstate");
		Thread.sleep(6000);

		if (facstate.isEnabled()) {
			System.out.print("\nFacility State/Province/Region is enabled. Take your action.");
		} else {
			System.out.print("\nFacility State/Province/Region is disabled. Take your action.");
		}
		Thread.sleep(6000);

	}

	public void Enterdetailsgeneratereportverify() throws Exception

	{
		Thread.sleep(6000);
		facilitynme.sendKeys("AA Medical Research Center");
		Thread.sleep(6000);

		Select drodowntype1 = new Select(drodowntype);
		drodowntype1.selectByVisibleText("Anesthesiology & pain management - Obstetric, gynecological and fetal");
		Thread.sleep(5000);
		faccountrydrop.click();
		Thread.sleep(5000);
		faccountrydrop.sendKeys("United States of America");
		Thread.sleep(5000);
		check.click();
		Thread.sleep(3000);
		closed.click();
		Thread.sleep(3000);
		generaterepot.click();
		Thread.sleep(6000);
		okkk.click();

		// Highlightelement("showhide");
		// Thread.sleep(3000);
		// Highlightelement("title");
		// Thread.sleep(3000);
		// Highlightelement("print");
		// Thread.sleep(3000);
		// Highlightelement("export");
		// Thread.sleep(3000);

	}

	public void Verifyfacilitydepartmentreportclumns() throws Exception

	{
		Thread.sleep(6000);
		Highlightelement("facilityid");
		Thread.sleep(3000);
		Highlightelement("facilitynames");
		Thread.sleep(3000);
		Highlightelement("facilityadress");
		Thread.sleep(3000);
		Highlightelement("city");
		Thread.sleep(3000);
		Highlightelement("state");
		Thread.sleep(3000);
		Highlightelement("countrys");
		Thread.sleep(3000);
		Highlightelement("zip");
		Thread.sleep(3000);
		Highlightelement("deptid");
		Thread.sleep(3000);

	}

	public void Verifygeneratereport() throws Exception

	{
		Thread.sleep(6000);
		Highlightelement("uniquefacilityid");
		Thread.sleep(3000);
		Highlightelement("uniquedepartmentid");
		Thread.sleep(3000);

	}

	public void Verifynavigatedtofacilityname() throws Exception

	{
		Thread.sleep(6000);
		facilitynamehyperlink.click();
		Thread.sleep(3000);
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentid = it.next();
		String childid = it.next();
		driver.switchTo().window(childid);
		System.out.println(driver.getTitle());
		Thread.sleep(3000);

		Thread.sleep(6000);

		Highlightelement("facilityname1");
		Thread.sleep(3000);
		Highlightelement("facilitycontact");
		Thread.sleep(3000);
		driver.close();
		Thread.sleep(3000);
		driver.switchTo().window(parentid);

	}

	public void verifynavigatedtodepartmentname() throws Exception

	{

		Thread.sleep(6000);
		deptname.click();
		Thread.sleep(6000);
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
		Thread.sleep(6000);

	}

	public void print() throws Exception

	{

		Thread.sleep(6000);
		PRINT.click();
		Thread.sleep(6000);
		// CLOSE.click();
		Thread.sleep(3000);
		Robot robot1 = new Robot();
		Thread.sleep(2000);
		robot1.keyPress(KeyEvent.VK_ESCAPE);
		Thread.sleep(2000);
		robot1.keyRelease(KeyEvent.VK_ESCAPE);

		Thread.sleep(6000);

		int size = driver.getWindowHandles().size();
		System.out.println(size);

	}

	public void Export() throws Exception

	{

		Thread.sleep(6000);
		EXPORT.click();
		Highlightelement("exportpdf");
		Thread.sleep(3000);
		Highlightelement("exportxls");
		Thread.sleep(3000);
		Highlightelement("exportcsv");
		Thread.sleep(3000);

	}

	public void ExportPDF1() throws Exception

	{

		Thread.sleep(6000);
		exportpdf.click();
		Thread.sleep(8000);

	}

	public void ExportXLS() throws Exception

	{

		Thread.sleep(6000);
		export.click();
		Thread.sleep(3000);
		exportxls.click();
		Thread.sleep(8000);

	}

	public void ExportCSV() throws Exception

	{

		Thread.sleep(6000);
		EXPORT.click();
		Thread.sleep(3000);
		exportcsv.click();
		Thread.sleep(8000);

	}

	public void navigatesiteuserresitrationreport() throws Exception

	{

		Thread.sleep(6000);
		Report1.click();
		Thread.sleep(6000);
		generalreport.click();
		Thread.sleep(6000);

		Select gerenareterereportdropdown1 = new Select(gerenareterereportdropdown);
		gerenareterereportdropdown1.selectByVisibleText("Site User Registration Report");
		Thread.sleep(5000);
		genaratereport.click();
		Thread.sleep(6000);
		Thread.sleep(6000);
	}

	public void selectcountry1() throws Exception

	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions a = new Actions(driver);
		a.moveToElement(search).click().build().perform();
		Thread.sleep(3000);
		country1.sendKeys("Brazil");
		Thread.sleep(3000);
		Robot robot1 = new Robot();
		Thread.sleep(3000);
		robot1.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		robot1.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		robot1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		search1.click();
		Thread.sleep(3000);

	}

	public void selectallcheckbox() throws Exception

	{

		Thread.sleep(3000);
		Select showrowdown = new Select(Rowselect1);
		showrowdown.selectByVisibleText("20");
		Thread.sleep(5000);
		checkall.click();
		Thread.sleep(3000);
		ok.click();
		Thread.sleep(3000);
		checkall.click();
		Thread.sleep(3000);

	}

	public void select12record() throws Exception

	{

		Thread.sleep(3000);
		record1.click();
		Thread.sleep(3000);
		record2.click();
		Thread.sleep(3000);
		select.click();
		Thread.sleep(3000);

	}
	
	public void select_1_5_record() throws Exception{
		Thread.sleep(3000);
		record.click();
		Thread.sleep(3000);
		record4.click();
		Thread.sleep(3000);
		select.click();
		Thread.sleep(3000);
	}

	public void clickonvewselectionandverify() throws Exception

	{

		Thread.sleep(3000);
		viewselection.click();
		Thread.sleep(1000);
		Highlightelement("facname1");
		Thread.sleep(1000);
		Highlightelement("depttype");
		Thread.sleep(1000);
		Highlightelement("country2");
		Thread.sleep(1000);
		Highlightelement("state1");
		Thread.sleep(1000);
		Highlightelement("city1");

	}

	public void clickoncompare() throws Exception

	{

		ok11.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		compare.click();
		Thread.sleep(3000);
		Highlightelement("facilitycomparison");
		Thread.sleep(3000);

	}

	public void selectall() throws Exception {
		driver.findElement(By.xpath("//span[@class='site-sel-container tAsite-sel-container']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='siteSelectAllCheckBox ui-helper-hidden-accessible']/following-sibling::span[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='fa fa-times']")).click();
		
		
	}

	public void validatepdffile_By_Name_as(String TextData) throws Exception {
		 properties= obj.getProperty();
			
		 Map<String, String> TestDataInMap =
		 ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		 testData.setTestDatainMap(TestDataInMap);
		 Map<String,String> testDataInMap = testData.getTestDatainMap();
		 String Path = testDataInMap.get("Filepath"); 
		 String DataToBeValidate= testDataInMap.get(TextData);
		    System.out.println(TextData);
	        System.out.println(Path);
	        System.out.println(DataToBeValidate);
	        
		// URL Path should be fetched from data sheet and to be customized by
		// string operation
	        
	        
		URL testurl = new URL(Path);
		
		BufferedInputStream testfile = new BufferedInputStream(testurl.openStream());
		PDFParser testpdf = new PDFParser(testfile);
		testpdf.parse();

		
		 
		//
		// String compound = testDataInMap.get("Compound");

		String testtext = new PDFTextStripper().getText(testpdf.getPDDocument());
		System.out.println("text in the pdf file:" + testtext);
		
		 if (testtext.contains(DataToBeValidate)) {
		
		 System.out.println(TextData+" matched");
		 if(TextData.equalsIgnoreCase("FacilitySection")){
			 System.out.println("TEST FAIL");
		 }
		
		 } else {
		
			 System.out.println(TextData+" not matched");
			 if(TextData.equalsIgnoreCase("FacilitySection")){
				 System.out.println("TEST PASS");
			 }
		 }

//		 reportarchiveandRename();

	}

	public void ValidatePDFFile_By_FilePath() throws Exception {
	    properties = obj.getProperty();

	
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),
                properties.getProperty("sheetName"), properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
        Map<String, String> testDataInMap = testData.getTestDatainMap();

 

        String Path = testDataInMap.get("Filepath");
        System.out.println(Path);
       
//            URL Path should be fetched from data sheet and to be customized by string operation

        URL testurl = new URL(Path);

        BufferedInputStream testfile = new BufferedInputStream(testurl.openStream());

        PDFParser testpdf = new PDFParser(testfile);

        testpdf.parse();

 

        

 

        String testtext = new PDFTextStripper().getText(testpdf.getPDDocument());

        System.out.println("text in the pdf file:" + testtext);

  
//        if (testtext.contains("")) {
//
// 
//
//            System.out.println("New value matched");
//
// 
//
//        } else {
//
// 
//
//            System.out.println("New value not matched");
//
// 
//
//        }
	}
	
	@FindBy(how = How.ID, using = "jspDropDownValue")
	public WebElement jspDropDownValue;
	
	public void select_Option_From_General_Reports_Dropdown(String arg1) throws Throwable {
	  	Select doctype1 = new Select (jspDropDownValue);
		doctype1.selectByVisibleText(arg1);
		Thread.sleep(3000);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@value='Generate Report']")
	public WebElement GENERATE_REPORTS_BUTTON;
	
	public void click_On_GENERATE_REPORTS_Button() throws Throwable {
	    CommonClass.highLightElement(driver, GENERATE_REPORTS_BUTTON);
	    GENERATE_REPORTS_BUTTON.click();
	}
	
	public void verify_Organization_Contact_Details_Report_Generated() throws Throwable {
		 CommonClass.highLightElement(driver, driver.findElement(By.xpath("//caption[text()[normalize-space() = 'Report']]/ancestor::table")));
	}
	
	public void verify_Organization_Contact_Details_Report_Table_Headers() throws Throwable {
		CommonClass.scroll2(driver);
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='fixTable-1']//*[text()[normalize-space() = 'Organization Name']]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='fixTable-1']//*[text()[normalize-space() = 'Organization Country']]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='fixTable-1']//*[text()[normalize-space() = 'Organization Address']]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='fixTable-1']//*[text()[normalize-space() = 'Organization Contact name']]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='fixTable-1']//*[text()[normalize-space() = 'Organization Contact E-mail Address']]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='fixTable-1']//*[text()[normalize-space() = 'Organization Contact Role']]")));
		WebElement scroll = driver.findElement(By.xpath("//*[@class='mCSB_draggerContainer']/div[contains(@id,'_dragger_horizontal')]/div[1]"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(scroll, 800, 0).build().perform();
		Thread.sleep(1500);
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='fixTable-1']//*[text()[normalize-space() = 'Organization Service']]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='fixTable-1']//*[text()[normalize-space() = 'Phone no.']]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='fixTable-1']//*[text()[normalize-space() = 'SIP User ID']]")));
		CommonClass.scroll1(driver);
		
	}
	
	@FindBy(how = How.XPATH, using = "//button[contains(@class,'modalExportDropdownBtn')]/i")
	public WebElement ExportDropdown_Btn;
	
	public void click_On_Export_Icon_For_Organization_Contact_Details_Report() throws Throwable {
	    CommonClass.highLightElement(driver, ExportDropdown_Btn);
	    ExportDropdown_Btn.click();
	}
	
	@FindBy(how = How.XPATH, using = "//li[@title='PDF']")
	public WebElement PDF_Option_OCDR;
	
	public void verify_Export_As_PDF_option_Under_Export_Icon_In_Organization_Contact_Details_Report_Screen() throws Throwable {
		CommonClass.highLightElement(driver, PDF_Option_OCDR);
	}
	
	public void click_On_Export_As_PDF_option_Under_Export_Icon_In_Organization_Contact_Details_Report_Screen() throws Throwable {
		PDF_Option_OCDR.click();
	}
	
	@FindBy(how = How.XPATH, using = "//li[@title='XLS']")
	public WebElement XLS_Option_OCDR;
	
	public void verify_Export_As_XLS_option_Under_Export_Icon_In_Organization_Contact_Details_Report_Screen() throws Throwable {
		CommonClass.highLightElement(driver, XLS_Option_OCDR);
	}
	
	public void click_On_Export_As_XLS_option_Under_Export_Icon_In_Organization_Contact_Details_Report_Screen() throws Throwable {
		XLS_Option_OCDR.click();
	}
	
	@FindBy(how = How.XPATH, using = "//li[@title='CSV']")
	public WebElement CSV_Option_OCDR;
		
	public void verify_Export_As_CSV_option_Under_Export_Icon_In_Organization_Contact_Details_Report_Screen() throws Throwable {
		CommonClass.highLightElement(driver, CSV_Option_OCDR);
	}
	
	public void click_On_Export_As_CSV_option_Under_Export_Icon_In_Organization_Contact_Details_Report_Screen() throws Throwable {
		CSV_Option_OCDR.click();
	}
	
	public void verify_Organization_Contact_Details_Report_For_PDF_Extension() throws Throwable {
		
		String downloadFilepath = System.getProperty("user.dir")+"\\Reports\\Download";
		File[] files = new File(downloadFilepath).listFiles();
		
		String File_Name_To_Validate =files[0].getName();
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		java.util.Date date=new java.util.Date();  
		String str = dateFormat.format(date);
		
		if(File_Name_To_Validate.endsWith(".pdf") && File_Name_To_Validate.contains("Organization Contact Details Report") && File_Name_To_Validate.contains(str))
		{
			System.out.println("Valid File : "+File_Name_To_Validate);
		}
		else 
		{
			System.out.println("Invalid File Name: "+File_Name_To_Validate);
		}
	}
	
	public void verify_Organization_Contact_Details_Report_For_XLSX_Extension() throws Throwable {
		String downloadFilepath = System.getProperty("user.dir")+"\\Reports\\Download";
		File[] files = new File(downloadFilepath).listFiles();
		
		String File_Name_To_Validate =files[1].getName();
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		java.util.Date date=new java.util.Date();  
		String str = dateFormat.format(date);
		
		if(File_Name_To_Validate.endsWith(".xlsx") && File_Name_To_Validate.contains("Organization Contact Details Report") && File_Name_To_Validate.contains(str))
		{
			System.out.println("Valid File : "+File_Name_To_Validate);
		}
		else 
		{
			System.out.println("Invalid File Name: "+File_Name_To_Validate);
		}
	}
	
	public void verify_Organization_Contact_Details_Report_For_CSV_Extension() throws Throwable {
		String downloadFilepath = System.getProperty("user.dir")+"\\Reports\\Download";
		File[] files = new File(downloadFilepath).listFiles();
		
		String File_Name_To_Validate =files[2].getName();
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		java.util.Date date=new java.util.Date();  
		String str = dateFormat.format(date);
		
		if(File_Name_To_Validate.endsWith(".csv") && File_Name_To_Validate.contains("Organization Contact Details Report") && File_Name_To_Validate.contains(str))
		{
			System.out.println("Valid File : "+File_Name_To_Validate);
		}
		else 
		{
			System.out.println("Invalid File Name: "+File_Name_To_Validate);
		}
	}
	
	public void verify_Onscreen_For_Facility_Department_Contact_Details_Report() throws Throwable {
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='generateReportSelDesc' and text()[normalize-space() = 'DESCRIPTION: Facility / Department Details and contact information']]")));
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"therapeuticDiv\"]/span")
	public WebElement Fac_therapeuticDiv;
	
	public void verify_Facility_Therapeutic_Area_Field_Displayed() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='populateTable']//label[text()[normalize-space() = 'Facility Therapeutic Area']]")));
		CommonClass.highLightElement(driver, Fac_therapeuticDiv);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"subTherapeuticDiv\"]/span")
	public WebElement Fac_subTherapeuticDiv;
	
	public void verify_Facility_Sub_Therapeutic_Area_Field_Displayed() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='populateTable']//label[text()[normalize-space() = 'Facility Sub-Therapeutic Area']]")));
		CommonClass.highLightElement(driver, Fac_subTherapeuticDiv);
	}
	
	public void verify_Facility_Sub_Therapeutic_Area_Field_Is_Disabled() throws Throwable {
	   if(driver.findElement(By.xpath("//*[@id='subTherapeuticDiv']/span[contains(@class,'disabled')]")).isDisplayed())
	      System.out.println("Facility Sub-Therapeutic Area Field Disabled");
	   else
		   System.out.println("Facility Sub Therapeutic Area Field Enabled");
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"countryDiv\"]/span")
	public WebElement Fac_countryDiv;
	
	@FindBy(how = How.XPATH, using = "//*[@id='countryDiv']//a[@title='Close']/i")
	public WebElement Fac_countryDiv_Close_button;
	
	public void verify_Facility_Country_Field_Displayed() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='populateTable']//label[text()[normalize-space() = 'Facility Country']]")));
		CommonClass.highLightElement(driver, Fac_countryDiv);
	}
	
	public void verify_All_Countries_Displayed_Under_Facility_Country_Field() throws Throwable {
		Fac_countryDiv.click();
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='countryDiv']//span[text()[normalize-space() = 'All']]")));
		
		{if(driver.findElements(By.xpath("//*[@id='mCSB_2_container']/div")).size()==249)
		System.out.println("All Countries Are Displayed");
		else
		System.out.println("All Countries Are Not Displayed");
		}
		Fac_countryDiv_Close_button.click();
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"facState\"]")
	public WebElement Fac_facState;
	
	public void verify_Facility_State_Province_Region_Field_Displayed() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='populateTable']//label[text()[normalize-space() = 'Facility State/Province/Region']]")));
		CommonClass.highLightElement(driver, Fac_facState);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"FacilityName\"]")
	public WebElement fac_FacilityName;
	
	public void verify_Facility_Name_Field_Displayed() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='populateTable']//label[text()[normalize-space() = 'Facility Name']]")));
		CommonClass.highLightElement(driver, Fac_facState);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"department-Type\"]")
	public WebElement fac_departmentType;
	
	public void verify_Department_Type_Field_Displayed() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='populateTable']//label[text()[normalize-space() = 'Department Type']]")));
		CommonClass.highLightElement(driver, fac_departmentType);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"populateTable\"]//input[@value=\"Generate Report\"]")
	public WebElement Generate_Report_Btn_Facility_Department_Contact_Details;
	
	public void verify_Generate_Reports_Button_Under_Facility_Department_Contact_Details_Section() throws Throwable {
		CommonClass.highLightElement(driver, Generate_Report_Btn_Facility_Department_Contact_Details);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"populateTable\"]//input[@value=\"Clear Search\"]")
	public WebElement Cancel_Btn_Facility_Department_Contact_Details;
	
	public void verify_Cancel_Button_Under_Facility_Department_Contact_Details_Section() throws Throwable {
		CommonClass.highLightElement(driver, Cancel_Btn_Facility_Department_Contact_Details);
	}
	
	public void verify_Facility_State_Province_Region_Field_Disabled() throws Throwable {
		if(!Fac_facState.isEnabled())
		      System.out.println("Facility_State_Province_Region_Field_Disabled");
		   else
			   System.out.println("Facility_State_Province_Region_Field_Enabled");
	}
	
	public void set_Facility_In_Facility_Name_Field_Under_Facility_Department_Contact_Details_Section(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String facility = testDataInMap.get("Facility_"+arg1);
        fac_FacilityName.sendKeys(facility);
	}

	public void select_Department_Type_For_Department_For_Facility(int arg1, int arg2, int arg3) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        if(arg3==1)
        {
        String Dtype = testDataInMap.get("Department_"+arg1+"_Type").trim();
        
        Select doctype1 = new Select (fac_departmentType);
        doctype1.selectByVisibleText(Dtype);
        Thread.sleep(3000);
        }
	}
	public void select_Facility_Country_From_Facility_Country_Dropdown(int arg1) throws Throwable {
	    properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        
        String F_Country = testDataInMap.get("Facility"+arg1+"_Country").trim();
        Fac_countryDiv.click();
        Thread.sleep(1500);
        Fac_countryDiv.sendKeys(F_Country);
        Thread.sleep(3500);
        driver.findElement(By.xpath("//span[text()[normalize-space() = '"+F_Country+"']]//../span/span")).click();
        Thread.sleep(3500);
        Fac_countryDiv_Close_button.click();
	}
	public void select_Country_As_From_Facility_Country_Dropdown(String F_Country) throws Throwable {
		Fac_countryDiv.click();
        Thread.sleep(1500);
        Fac_countryDiv.sendKeys(F_Country);
        Thread.sleep(3500);
        driver.findElement(By.xpath("//span[text()[normalize-space() = '"+F_Country+"']]//../span/span")).click();
        Thread.sleep(3500);
        Fac_countryDiv_Close_button.click();
	}
	
	public void click_On_GENERATE_REPORTS_button_For_Facility_Department_Contact_Details_Report() throws Throwable {
		Generate_Report_Btn_Facility_Department_Contact_Details.click();
	}

	public void verify_Facility_Department_Contact_Details_Report_Is_Displayed_In_A_Tabular_Format() throws Throwable {
		CommonClass.scroll2(driver);
		Thread.sleep(1000);
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id=\"fixTable-1\"]")));
	}
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='paginationSection']//label[text()[normalize-space() = 'Show / Hide Column']]")
	public WebElement Show_Hide_Column_Facility_Department_Contact_Details_Report;
	
	public void verify_Show_Hide_Column_Dropdown_For_Facility_Department_Contact_Details_Report() throws Throwable {
		 CommonClass.highLightElement(driver, Show_Hide_Column_Facility_Department_Contact_Details_Report);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='paginationSection']/div[2]/div[1]/ul/button/i")
	public WebElement PrintIcon_Facility_Department_Contact_Details_Report;
	
	public void verify_Print_Button_For_Facility_Department_Contact_Details_Report() throws Throwable {
		CommonClass.highLightElement(driver, PrintIcon_Facility_Department_Contact_Details_Report);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='paginationSection']/div[2]/div[1]/ul/span/button/i")
	public WebElement ExportIcon_Facility_Department_Contact_Details_Report;
	
	public void verify_Export_Button_For_Facility_Department_Contact_Details_Report() throws Throwable {
		CommonClass.highLightElement(driver, ExportIcon_Facility_Department_Contact_Details_Report);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='paginationSection']/div[2]/div[2]/div/p")
	public WebElement Pagination_Section_For_Facility_Department_Contact_Details_Report;
	
	public void verify_Pagination_Section_For_Facility_Department_Contact_Details_Report() throws Throwable {
		CommonClass.highLightElement(driver, Pagination_Section_For_Facility_Department_Contact_Details_Report);
	}
	
	public void verify_Total_Record_Count_Displayed_For_Facility_Department_Contact_Details_Report() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id=\"paginationSection\"]/div[2]/div[2]/div/p/span[2]")));
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='checktablenewtable']//*[contains(@id,'_dragger_vertical')]")
	public WebElement Vertical_Scroll_Bar_For_Facility_Department_Contact_Details_Report;
	
	public void verify_Vertical_Scroll_Bar_For_Facility_Department_Contact_Details_Report() throws Throwable {
		CommonClass.highLightElement(driver, Vertical_Scroll_Bar_For_Facility_Department_Contact_Details_Report);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='checktablenewtable']//*[contains(@id,'_dragger_horizontal')]")
	public WebElement Horizantal_Scroll_Bar_For_Facility_Department_Contact_Details_Report;
	
	public void verify_Horizantal_Scroll_Bar_For_Facility_Department_Contact_Details_Report() throws Throwable {
		CommonClass.highLightElement(driver, Horizantal_Scroll_Bar_For_Facility_Department_Contact_Details_Report);
	}
	
	public void verify_Facility_Name_Column_Is_Displayed_For_Facility_Department_Contact_Details_Report() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='fixTable-1']//div[text()[normalize-space() = 'Facility Name']]")));
	}
	
	public void verify_Facility_Name_Column_Is_Sortable_For_Facility_Department_Contact_Details_Report() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//*[@id='FACILITYNAME']/span)[1]")));
	}

	public void verify_All_Facilities_Under_Facility_Name_Column_Is_Hyperlinked_For_Facility_Department_Contact_Details_Report() throws Throwable {
		int Count = driver.findElements(By.xpath("//*[@id='fixTable-1']//tr/td[2]/div/a[@href]")).size();
		for (int i = 1;i <= Count; i++)
		{
			CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='fixTable-1']//tr["+i+"]/td[2]/div/a[@href]")));
			Thread.sleep(250);
		}
	}
	
	public void verify_Facility_Address_Columns_Are_Displayed_For_Facility_Department_Contact_Details_Report() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='fixTable-1']//div[text()[normalize-space() = 'Facility Address']]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='fixTable-1']//div[text()[normalize-space() = 'City']]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='fixTable-1']//div[text()[normalize-space() = 'State/Province/Region']]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='fixTable-1']//div[text()[normalize-space() = 'Country']]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='fixTable-1']//div[text()[normalize-space() = 'Zip/Postal Code']]")));
	}
	
	public void verify_Facility_Address_Columns_Are_Sortable_For_Facility_Department_Contact_Details_Report() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//*[@id='FACILITYADDRESS']/span)[1]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//*[@id='CITY']/span)[1]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//*[@id='STATENAME']/span)[1]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//*[@id='COUNTRYNAME']/span)[1]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//*[@id='FACILITY_POSTALCODE']/span)[1]")));
	}
	
	public void verify_Verify_Department_Name_Column_Is_Displayed_For_Facility_Department_Contact_Details_Report() throws Throwable {
		Actions action = new Actions(driver);
		action.dragAndDropBy(Horizantal_Scroll_Bar_For_Facility_Department_Contact_Details_Report, 580, 0).build().perform();
		Thread.sleep(1000);
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='fixTable-1']//div[text()[normalize-space() = 'Department Name']]")));
	}
	
	
	public void verify_Department_Name_Column_Is_Sortable_For_Facility_Department_Contact_Details_Report() throws Throwable {
	   CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//*[@id=\"DEPARTMENTNAME\"]/span)[1]")));
	}
	
	public void verify_All_Department_Under_Department_Name_Column_Is_Hyperlinked_For_Facility_Department_Contact_Details_Report() throws Throwable {
		int Count = driver.findElements(By.xpath("//*[@id='fixTable-1']//tr/td[9]/div/a")).size();
		for (int i = 1;i <= Count; i++)
		{
			CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='fixTable-1']//tr["+i+"]/td[9]/div/a[@href]")));
			Thread.sleep(250);
		}
	}
	
	public void verify_Department_Type_Column_Is_Displayed_For_Facility_Department_Contact_Details_Report() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='fixTable-1']//div[text()[normalize-space() = 'Department Type']]")));
	}
	public void verify_Department_Type_Column_Is_Sortable_For_Facility_Department_Contact_Details_Report() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//*[@id=\"DEPARTMENTTYPENAME\"]/span)[1]")));
	}
	
	public void verify_Department_Address_Columns_Displayed_For_Facility_Department_Contact_Details_Report() throws Throwable {
	   CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='fixTable-1']//div[text()[normalize-space() = 'Department Address']]")));
	}

	public void verify_Department_Address_Column_Is_Sortable_For_Facility_Department_Contact_Details_Report() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//*[@id=\"DEPTADDRESS\"]/span)[1]")));
	}
	
	public void verify_Facility_Department_Role_Column_Displayed_For_Facility_Department_Contact_Details_Report() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='fixTable-1']//div[text()[normalize-space() = 'Facility/Department Role']]")));
	}
	
	public void verify_Facility_Department_Role_Column_Is_Sortable_For_Facility_Department_Contact_Details_Report() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//*[@id=\"FACILITY_DEPART_ROLE\"]/span)[1]")));
	}
	
	public void verify_Contact_Name_Column_Displayed_For_Facility_Department_Contact_Details_Report() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='fixTable-1']//div[text()[normalize-space() = 'Contact Name']]")));
	}
	
	public void verify_Contact_Name_Column_Is_Sortable_For_Facility_Department_Contact_Details_Report() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//*[@id=\"CONTACT_NAME\"]/span)[1]")));
	}
	
	public void verify_Contact_Email_Address_Column_Displayed_For_Facility_Department_Contact_Details_Report() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='fixTable-1']//div[text()[normalize-space() = 'Contact Email Address']]")));
	}
	
	public void verify_Contact_Email_Address_Column_Is_Sortable_For_Facility_Department_Contact_Details_Report() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//*[@id=\"USER_EMAIL\"]/span)[1]")));
	}
	
	public void verify_Main_Daytime_Phone_Column_Displayed_For_Facility_Department_Contact_Details_Report() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='fixTable-1']//div[text()[normalize-space() = 'Main/Daytime Phone']]")));
	}
	
	public void verify_Main_Daytime_Phone_Column_Is_Sortable_For_Facility_Department_Contact_Details_Report() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//*[@id=\"USER_PHONE\"]/span)[1]")));
	}
	
	public void verify_Fax_Number_Column_Displayed_For_Facility_Department_Contact_Details_Report() throws Throwable {
		Actions action = new Actions(driver);
		action.dragAndDropBy(Horizantal_Scroll_Bar_For_Facility_Department_Contact_Details_Report, 100, 0).build().perform();
		Thread.sleep(1000);
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='fixTable-1']//div[text()[normalize-space() = 'Fax Number']]")));
	}
	
	public void verify_Fax_Number_Column_Is_Sortable_For_Facility_Department_Contact_Details_Report() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//*[@id=\"USER_FAX\"]/span)[1]")));
	}
	
	public void verify_SIP_User_ID_Column_Displayed_For_Facility_Department_Contact_Details_Report() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='fixTable-1']//div[text()[normalize-space() = 'SIP User ID']]")));
	}

	public void verify_SIP_User_ID_Column_Is_Sortable_For_Facility_Department_Contact_Details_Report() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//*[@id=\"SIP_USER_ID\"]/span)[1]")));
	}
	
	public void verify_Department_Type_Is_Under_Department_Type_Column_For_Facility_Department_Contact_Details_Report(int arg1) throws Throwable {
		properties= obj.getProperty();
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String D_Type = testDataInMap.get("Department_"+arg1+"_Type");
        int count = driver.findElements(By.xpath("//*[@id='fixTable-1']//tr/td[10]/div")).size();
        for (int i=1;i<=count;i++)
        {
        	CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='fixTable-1']//tr["+i+"]/td[10]/div[text()[normalize-space() = '"+D_Type+"']]")));
			Thread.sleep(250);
        }
        
	}
	
	public void click_On_Facility_Displayed_Inder_Facility_Name_Column_For_Facility_Department_Contact_Details_Report(int arg1) throws Throwable {
		
		properties= obj.getProperty();
		
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String Fac = testDataInMap.get("Facility_"+arg1).trim();
        System.out.println(Fac);
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='fixTable-1']//tr[1]//a[text()[normalize-space() = '"+Fac+"']]")));
        driver.findElement(By.xpath("//*[@id='fixTable-1']//tr[1]//a[text()[normalize-space() = '"+Fac+"']]")).click();
	}
	
	public void verify_Facility_Name_Address_Screen_Displayed_With_Facility_As_Header(int arg1) throws Throwable {
		Set<String> windows = driver.getWindowHandles();
        Iterator<String> it=windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        Thread.sleep(4000);
        properties= obj.getProperty();
		
		   
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        String Fac = testDataInMap.get("Facility_"+arg1).trim();

	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("//h2[text()[normalize-space() = 'Facility Name & Address']]")));
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("//h1[text()[normalize-space() = '"+Fac+"']]")));
	    driver.close();
	    driver.switchTo().window(parentWindow);
	}
	
	public void click_On_Department_Of_Facility_Under_Facility_Name_Column_For_Facility_Department_Contact_Details_Report(int arg1, int arg2) throws Throwable {
		 properties= obj.getProperty();
			
		   
	        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
	        testData.setTestDatainMap(TestDataInMap);
	               
	        Map<String,String> testDataInMap = testData.getTestDatainMap();
	        String department = null ;
	        if (arg2==1)
	        {
	        	department= testDataInMap.get("Department_"+arg1).trim();
	        }
	        else if(arg2>=2)
	        {
	        	department = testDataInMap.get("F"+arg2+"_Department_"+arg1).trim();
	        }
	        Actions action = new Actions(driver);
			action.dragAndDropBy(Horizantal_Scroll_Bar_For_Facility_Department_Contact_Details_Report, 500, 0).build().perform();
			Thread.sleep(1000);
			CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='fixTable-1']//tr[1]/td[9]/div/a[text()[normalize-space() = '"+department+"']]")));
			driver.findElement(By.xpath("//*[@id='fixTable-1']//tr[1]/td[9]/div/a[text()[normalize-space() = '"+department+"']]")).click();
	}
	
	public void verify_Department_Name_Address_Screen_Displayed_With_Department_of_Facility_As_Header(int arg1, int arg2) throws Throwable {
		String department = null ;
		Set<String> windows = driver.getWindowHandles();
        Iterator<String> it=windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        Thread.sleep(4000);
        
        properties= obj.getProperty();
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
               
        Map<String,String> testDataInMap = testData.getTestDatainMap();
        if (arg2==1)
        {
        	department= testDataInMap.get("Department_"+arg1).trim();
        }
        else if(arg2>=2)
        {
        	department = testDataInMap.get("F"+arg2+"_Department_"+arg1).trim();
        }
        System.out.println(department);
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//h1[text()[normalize-space() = '"+department+"']]")));
        CommonClass.highLightElement(driver, driver.findElement(By.xpath("//h2[text()[normalize-space() = 'Department Name & Address']]")));
        driver.close();
	    driver.switchTo().window(parentWindow);        
	}
	
	
	public void verify_Option_For_Show_Rows_Dropdown(int arg1, int arg2, int arg3, int arg4, int arg5) throws Throwable {
		Select doctype1 = new Select (driver.findElement(By.xpath("//*[@id=\"pagination_limit\"]")));
		doctype1.selectByVisibleText(Integer.toString(arg1));
		Thread.sleep(5000);
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id=\"pagination_limit\"]")));
		doctype1.selectByVisibleText(Integer.toString(arg2));
		Thread.sleep(5000);
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id=\"pagination_limit\"]")));
		doctype1.selectByVisibleText(Integer.toString(arg3));
		Thread.sleep(5000);
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id=\"pagination_limit\"]")));
		doctype1.selectByVisibleText(Integer.toString(arg4));
		Thread.sleep(5000);
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id=\"pagination_limit\"]")));
		doctype1.selectByVisibleText(Integer.toString(arg5));
		Thread.sleep(5000);
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id=\"pagination_limit\"]")));
	}
	
	public void click_Expand_General_Reports_Section_For_Facility_Department_Contact_Details_Report() throws Throwable {
		CommonClass.scroll1(driver);
		Thread.sleep(1500);
	    driver.findElement(By.xpath("//*[@id='all-reports']/div/span[2]/i")).click();
	 	}
	
	
	public void click_On_CLEAR_SEARCH_Button_For_Facility_Department_Contact_Details_Report() throws Throwable {
		verify_Cancel_Button_Under_Facility_Department_Contact_Details_Section();
		Cancel_Btn_Facility_Department_Contact_Details.click();
	}
	
	public void click_On_Export_Button_For_Facility_Department_Contact_Details_Report() throws Throwable {
		verify_Export_Button_For_Facility_Department_Contact_Details_Report();
		ExportIcon_Facility_Department_Contact_Details_Report.click();
	}
	
	public void verify_Option_Is_Displayed_For_Facility_Department_Contact_Details_Report(String arg1) throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='paginationSection']//li[text()[normalize-space() = '"+arg1+"']]")));
	}
	
	public void click_On_Option_Is_Displayed_For_Facility_Department_Contact_Details_Report(String arg1) throws Throwable {
		driver.findElement(By.xpath("//*[@id='paginationSection']//li[text()[normalize-space() = '"+arg1+"']]")).click();
	}
	
	public void verify_Facility_Department_Contact_Details_Report_For_PDF_Extension() throws Throwable {
		
		String downloadFilepath = System.getProperty("user.dir")+"\\Reports\\Download";
		File[] files = new File(downloadFilepath).listFiles();
		
		String File_Name_To_Validate =files[0].getName();
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		java.util.Date date=new java.util.Date();  
		String str = dateFormat.format(date);
		
		if(File_Name_To_Validate.endsWith(".pdf") && File_Name_To_Validate.contains("Facility_Department Contact Details Report") && File_Name_To_Validate.contains(str))
		{
			System.out.println("Valid File : "+File_Name_To_Validate);
		}
		else 
		{
			System.out.println("Invalid File Name: "+File_Name_To_Validate);
		}
	}
	
	public void verify_Facility_Department_Contact_Details_Report_For_XLS_Extension() throws Throwable {
		String downloadFilepath = System.getProperty("user.dir")+"\\Reports\\Download";
		File[] files = new File(downloadFilepath).listFiles();
		
		String File_Name_To_Validate =files[0].getName();
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		java.util.Date date=new java.util.Date();  
		String str = dateFormat.format(date);
		
		if(File_Name_To_Validate.endsWith(".xlsx") && File_Name_To_Validate.contains("Facility_Department Contact Details Report") && File_Name_To_Validate.contains(str))
		{
			System.out.println("Valid File : "+File_Name_To_Validate);
		}
		else 
		{
			System.out.println("Invalid File Name: "+File_Name_To_Validate);
		}
	}
	
	public void verify_Facility_Department_Contact_Details_Report_For_CSV_Extension() throws Throwable {
		String downloadFilepath = System.getProperty("user.dir")+"\\Reports\\Download";
		File[] files = new File(downloadFilepath).listFiles();
		
		String File_Name_To_Validate =files[2].getName();
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		java.util.Date date=new java.util.Date();  
		String str = dateFormat.format(date);
		
		if(File_Name_To_Validate.endsWith(".csv") && File_Name_To_Validate.contains("Facility_Department Contact Details Report") && File_Name_To_Validate.contains(str))
		{
			System.out.println("Valid File : "+File_Name_To_Validate);
		}
		else 
		{
			System.out.println("Invalid File Name: "+File_Name_To_Validate);
		}
	}
	
}