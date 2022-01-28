package com.testautomation.PageObjects;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
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
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.testautomatiom.Listeners.ExtentReportListner;
import com.testautomation.Utility.ExcelHandler;
import com.testautomation.Utility.PropertiesFileReader;
import com.testautomation.Utility.TestDataHandler;


public class MyProfilePage extends ExtentReportListner {
	
	public WebDriver driver;
	Properties properties;
	WebDriverWait wait;
	ExtentTest logInfo = null;
	PropertiesFileReader obj = new PropertiesFileReader();
	TestDataHandler testData = new TestDataHandler();
	
	public void highLightElement(WebElement string) throws InterruptedException{
		   JavascriptExecutor js = (JavascriptExecutor)driver;   
		   js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');", string);   
		   Thread.sleep(3000);
		   TakesScreenshot webdriver = null;
		   TakesScreenshot scrShot =((TakesScreenshot)webdriver);
	}
	
	public MyProfilePage (WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver,25000);
	}
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"updatePhn\"]/i")
	public WebElement updatePhone;
	
	@FindBy(how=How.XPATH, using="//input[@id='txt_updatePhone']")
	public WebElement updatePhonefield;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"updateSponsorPhnBtn\"]")
	public WebElement savebutton;
	

	@FindBy(how=How.ID, using="regInviteOk")
	public WebElement OKbutton;
	
	@FindBy(how=How.ID, using="okbutton")
	public WebElement okb;
	
	@FindBy(how=How.ID, using="userPhnNo")
	public WebElement userPhNo;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"urgentSafetyNotificationPop\"]/div[2]/div[3]/button")
	public WebElement ok;
	
	
	@FindBy(how=How.ID, using="UserProfileId")
	public WebElement Userprofile;
	
	@FindBy(how=How.ID, using="MyProfileId")
	public WebElement MyProfile;
	
	@FindBy(how=How.XPATH, using="//i[@class='fa fa-pencil-square-o']")
	public WebElement EditPhoneNumber;
	
	
	
	@FindBy(how=How.XPATH, using="(//h1[@class='large-header-h1'])[3]")
	public WebElement PhoneNumberHeader;
	
	@FindBy(how=How.ID, using="txt_updatePhone")
	public WebElement PhoneNumberTextField;
	
	@FindBy(how=How.ID, using="userPhnNo")
	public WebElement PhoneNumberText;
	
	@FindBy(how=How.ID, using="updateSponsorPhnBtn")
	public WebElement PhoneNumberSave;
	
	@FindBy(how=How.ID, using="(//button[@id='regInviteOk'])[1]")
	public WebElement PhoneNumberPopOK;
	
	
	
	@FindBy(how=How.ID, using="ApproveRejectUpdate(s)Id")
	public WebElement approveupdate;
	
	@FindBy(how=How.ID, using="DelegatedProfilesId")
	public WebElement Delegatedprofile1;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"ui-id-42\"]")
	public WebElement Abbriviatedcvhistory;
	
	@FindBy(how=How.ID, using="PullCVId")
	public WebElement Pullcv;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"userCountryId\"]/span")
	public WebElement country;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"mCSB_4_container\"]/div[40]/span[1]/span")
	public WebElement chechbox;
	
	@FindBy(how=How.XPATH, using="//div[@id='userCountryId']//i[@class='fa fa-times']")
	public WebElement close;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"myTraining1\"]/div/div/div[2]/input[1]")
	public WebElement search;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"search-table\"]/tbody/tr[1]/td[3]/label/a")
	public WebElement Lname;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"search-table\"]/tbody/tr[1]/td[4]/label")
	public WebElement Fname;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"search-table\"]/tbody/tr[1]/td[5]/label")
	public WebElement contry;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"search-table\"]/tbody/tr[1]/td[6]/label")
	public WebElement state;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"search-table\"]/tbody/tr[1]/td[7]/label")
	public WebElement lastgeneratecv;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"cvPulledHistory\"]")
	public WebElement pullcvhistory;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"senh_2507|HENRY| SEN\"]")
	public WebElement pullcvstatus;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"search-table\"]/tbody/tr[1]/td[1]/span")
	public WebElement check;
	

	@FindBy(how=How.ID, using="PullCVId")
	public WebElement pullcv;
	

	@FindBy(how=How.XPATH, using="//*[@id=\"transCelerateId\"]")
	public WebElement sipuserid;
	

	@FindBy(how=How.XPATH, using="//*[@id=\"firstName\"]")
	public WebElement firstname;
	

	@FindBy(how=How.XPATH, using="//*[@id=\"lastName\"]")
	public WebElement lastname;
	

	@FindBy(how=How.XPATH, using="//*[@id=\"cvTitle\"]")
	public WebElement cvtitle;
	

	@FindBy(how=How.XPATH, using="//*[@id=\"addUserResult\"]/div[1]/div[1]/div/table/thead/tr/th[6]")
	public WebElement viwcv;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"addUserResult\"]/div[1]/div[1]/div/table/tbody/tr/td[1]/span")
	public WebElement check1;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"enabledDownloadBtn\"]/input")
	public WebElement downloadcv;
	
	@FindBy(how=How.XPATH, using="//a[@id='senh_2507|HENRY| SEN']")
	public WebElement yes;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"pull-cv-history\"]/div[2]/div/div[2]/div[1]/table/tbody/tr/td[4]")
	public WebElement downloadedby;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"pull-cv-history\"]/div[2]/i")
	public WebElement closebutton;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"p_p_id_TCSIPMyProfilePortlet_WAR_TCSIPMyProfilePortlet100_\"]/div/div/div/div[4]/div/div/div[2]/h2")
	public WebElement nameoftheuser;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"p_p_id_TCSIPMyProfilePortlet_WAR_TCSIPMyProfilePortlet100_\"]/div/div/div/div[4]/div/div/div[2]/div/div/p[1]")
	public WebElement citystate;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"userPhnNo\"]")
	public WebElement phone;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"p_p_id_TCSIPMyProfilePortlet_WAR_TCSIPMyProfilePortlet100_\"]/div/div/div/div[4]/div/div/div[2]/div/div/p[3]/i/span")
	public WebElement email;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"p_p_id_TCSIPMyProfilePortlet_WAR_TCSIPMyProfilePortlet100_\"]/div/div/div/div[3]/div")
	public WebElement lastmodified;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"updatePhn\"]/i")
	public WebElement editicon;
	
	@FindBy(how=How.XPATH, using="//span[@class='site-sel-container ellipsis']")
	public WebElement RoleDropDown;
	
	@FindBy(how=How.XPATH, using="//i[@class='fa fa-times']")
	public WebElement Cross;
	
	@FindBy(how=How.XPATH, using="//span[normalize-space(text())='All']/preceding-sibling::span")
	public WebElement AllStatusRoleDropDown;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"txt_updatePhone\"]")
	public WebElement phoneno;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"updatePhoneNoModal\"]/div[2]/div/div[1]/ul/li[3]/p")
	public WebElement message1;
	
	@FindBy(how=How.XPATH, using="//span[contains(text(),'Select Study(s)')]")
	public WebElement studydropdow;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"updateSponsorPhnBtn\"]")
	public WebElement savebutto;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"updatePhoneNoModal\"]/div[2]/div/div[2]/button[2]")
	public WebElement cancelbutto;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"regInviteOk\"]")
	public WebElement okbut;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"invalid_phn_alert\"]")
	public WebElement validationmsg;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"updatePhoneNoModal\"]/div[2]/i")
	public WebElement closebuttons;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"userCountryId\"]/span")
	public WebElement countrydropdown;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"mCSB_4_container\"]/div[19]/span[1]/span")
	public WebElement chck;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"userCountryId\"]/div/div[1]/a[1]/i")
	public WebElement closed;
	

	@FindBy(how=How.XPATH, using="//*[@id=\"email_pullCV\"]")
	public WebElement emailid;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"myTraining1\"]/div/div/div[2]/input[1]")
	public WebElement searchbutton;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"search-table\"]/thead/tr/th[1]/span")
	public WebElement chckbx;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"lastName\"]")
	public WebElement lname;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"firstName\"]")
	public WebElement fname;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"country\"]")
	public WebElement county;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"stateForPullCV\"]")
	public WebElement stat;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"lastGeneratedCvDate\"]")
	public WebElement lastgeneratedcv;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"stateForPullCV\"]")
	public WebElement cvpulledhistory;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"generateCvBtnId\"]")
	public WebElement Generatecv;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"confirm-generate-CV\"]/div[2]/div/div[2]/h1")
	public WebElement reviewvcv;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"confirm-generate-CV\"]/div[2]/div/div[2]/p")
	public WebElement reviewcvonscreen;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"actionGenerateCvYes\"]")
	public WebElement generateandsigncv;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"actionCancel\"]")
	public WebElement cancel;
	
	@FindBy(how=How.ID, using="DelegatedProfilesId")
	public WebElement Delegatedprofile;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"search-table\"]/tbody/tr/td[3]/a")
	public WebElement Siteuser1id;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"sipUserId\"]")
	public WebElement sipuserids;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"firstName\"]")
	public WebElement firstnam;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"lastName\"]")
	public WebElement lastnam;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"delegatedEffectiveFrom\"]")
	public WebElement delegateeffectfrom;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"profExpDetails\"]")
	public WebElement professionalexp;
	
	@FindBy(how=How.ID, using="profExpAddLink")
	public WebElement add;
	
	@FindBy(how=How.ID, using="JobTitleId")
	public WebElement jobtitle;
	
	@FindBy(how=How.ID, using="institutionFldId")
	public WebElement institutation;
	
	
	@FindBy(how=How.ID, using="yearStart")
	public WebElement yearstarted;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"addProfExpDetailsFrm\"]/div/ul/li[6]/span")
	public WebElement completedcheck;
	
	
	@FindBy(how=How.ID, using="addBtn")
	public WebElement add1;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"allChangesForApprovalBtnId\"]")
	public WebElement sendallchangedforapproval;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"allChangesForApprovalBtnId\"]")
	public WebElement sendallchangedforapprovalall;
	
	
	@FindBy(how=How.ID, using="actionOk")
	public WebElement okbutt;
	
	@FindBy(how=How.ID, using="ApproveRejectUpdate(s)Id")
	public WebElement approvereject;
	
	@FindBy(how=How.XPATH, using="//span[@id='roleLabl']//span//label[contains(text(),'Clinical Research User')]")
	public WebElement clinicalresearchuser;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"userPhotoImgId\"]")
	public WebElement profilephotoplaceholder;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"p_p_id_TCSIPMyProfilePortlet_WAR_TCSIPMyProfilePortlet100_\"]/div/div/div/div[4]/div/div/div[2]")
	public WebElement summarysection;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"ui-id-1\"]")
	public WebElement userprofilesection;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"targetAccessDetailsPopUpIds\"]/div/div[1]/h3")
	public WebElement Roletable;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"userPhotoUploadFrm\"]/div[1]/h1")
	public WebElement uploadprofilephoto;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"userPhotoUploadFrm\"]/div[1]/p")
	public WebElement onscreentext;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"fileToUpload\"]")
	public WebElement choosefile;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"photoUploadBtnId\"]")
	public WebElement upload;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"userPhotoUploadFrm\"]/div[2]/input[2]")
	public WebElement cancel1;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"tabs-1\"]/div[1]/ul/li[1]/label[1]")
	public WebElement sipuserid1;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"tabs-1\"]/div[1]/ul/li[2]/label[1]")
	public WebElement nameprefix;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"tabs-1\"]/div[1]/ul/li[3]/label[1]")
	public WebElement firstnme;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"tabs-1\"]/div[1]/ul/li[4]/label[1]")
	public WebElement middlenme;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"tabs-1\"]/div[1]/ul/li[5]/label[1]")
	public WebElement lastnme;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"tabs-1\"]/div[1]/ul/li[6]/label[1]")
	public WebElement emailidd;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"user-Role-Access-table\"]/thead/tr/th[1]")
	public WebElement roletype;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"user-Role-Access-table\"]/thead/tr/th[2]")
	public WebElement role;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"user-Role-Access-table\"]/thead/tr/th[3]")
	public WebElement countr;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"user-Role-Access-table\"]/thead/tr/th[4]")
	public WebElement studysposor;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"user-Role-Access-table\"]/thead/tr/th[5]")
	public WebElement studyid;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"user-Role-Access-table\"]/thead/tr/th[6]")
	public WebElement studysiteid;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"user-Role-Access-table\"]/thead/tr/th[7]")
	public WebElement startdate;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"user-Role-Access-table\"]/thead/tr/th[8]")
	public WebElement enddate;
	
	
	@FindBy(how=How.XPATH, using="//td[contains(text(),'Type I')]")
	public WebElement type1;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"user-Role-Access-table\"]/tbody/tr[2]/td[2]")
	public WebElement role1;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"user-Role-Access-table_length\"]/label/select")
	public WebElement tabledropdown;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"user-Role-Access-table_paginate\"]/input")
	public WebElement pagetextbox;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"user-Role-Access-table_next\"]")
	public WebElement next;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"user-Role-Access-table_last\"]")
	public WebElement last;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"user-Role-Access-table_first\"]")
	public WebElement first;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"user-Role-Access-table_previous\"]")
	public WebElement prev;
	
	@FindBy(how=How.ID, using="addDelegate")
	public WebElement delegate;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"delegateOrganization\"]")
	public WebElement orgradio;
	
	@FindBy(how=How.XPATH, using="//h2[@class='display-inline-block width95Per']")
	public WebElement searchorganization;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"myProfileOrganizationListId\"]")
	public WebElement orgname;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"delegateUser\"]")
	public WebElement sitestaffmember;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"delegateEmailId\"]")
	public WebElement delegateemail;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"delegateUserBtn\"]")
	public WebElement delegatebutton1;
	
	
	@FindBy(how=How.XPATH, using="//h2[contains(text(),'Delegate User Profile')]")
	public WebElement delegateusertitle;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"p_p_id_TCSIPMyProfilePortlet_WAR_TCSIPMyProfilePortlet100_\"]/div/div/div/div[5]/div[1]")
	public WebElement onscreen;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"p_p_id_TCSIPMyProfilePortlet_WAR_TCSIPMyProfilePortlet100_\"]/div/div/div/div[5]/div[2]/div[3]/div[1]/div/div[1]/p")
	public WebElement onscreen1;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"myProfileCountryListId\"]")
	public WebElement country1;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"StateList_wrapper\"]/span")
	public WebElement state1;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"delegateSearchBtn1\"]")
	public WebElement search1;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"myProfileClearSearchBtn\"]")
	public WebElement clearsearch;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"p_p_id_TCSIPMyProfilePortlet_WAR_TCSIPMyProfilePortlet100_\"]/div/div/div/div[5]/div[2]/div[3]/div[1]/div/div[3]/button[3]")
	public WebElement cancel2;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"myProfileOrganizationListId\"]")
	public WebElement orgnaetext;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"myProfileClearSearchBtn\"]")
	public WebElement clearsearch1;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"basicDetails\"]/h2")
	public WebElement Basicdetailstitle;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"errors_search_criteria\"]")
	public WebElement blanksearchtext;
	
	@FindBy(how=How.ID, using="myProfileCountryListId")
	public WebElement countrydrpdwn;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"StateList_wrapper\"]/div/div[1]/span[1]/span")
	public WebElement all;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"StateList_wrapper\"]/div/div[1]/a[1]/i")
	public WebElement cross;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"StateList_wrapper\"]/span")
	public WebElement statetdrpdwn;
	
	
	
	@FindBy(how=How.XPATH, using="//i[@class='fa fa-plus']")
	public WebElement plusicon;
	
	@FindBy(how=How.XPATH, using="(//i[@class='fa fa-plus'])[1]")
	public WebElement plusicon1;
	
	@FindBy(how=How.XPATH, using="(//i[@class='fa fa-plus'])[2]")
	public WebElement plusicon2;
	
	@FindBy(how=How.XPATH, using="(//i[@class='fa fa-plus'])[3]")
	public WebElement plusicon3;
	
	@FindBy(how=How.ID, using="IPShippingRecipientName_1")
	public WebElement IPRecepientVerify;
	
	
	@FindBy(how=How.XPATH, using="//i[@class='fa fa-minus']")
	public WebElement minusicon;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"filteredOrganizationTable\"]/thead/tr/th[1]")
	public WebElement Select;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"filteredOrganizationTable\"]/thead/tr/th[2]")
	public WebElement organame;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"filteredOrganizationTable\"]/thead/tr/th[3]")
	public WebElement address;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"filteredOrganizationTable\"]/thead/tr/th[2]/i")
	public WebElement sort;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"filteredOrganizationTable\"]/thead/tr/th[2]/i")
	public WebElement delegate1;
	
	
	
	@FindBy(how=How.ID, using="savePopUP")
	public WebElement save;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"alertPopup\"]")
	public WebElement alerttext;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"closeAlert\"]")
	public WebElement ok3;	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"filteredOrganizationTable\"]/thead/tr/th[2]/i")
	public WebElement cancel3;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"basicDetails\"]/div/div[1]/div[1]/ul[2]/li/label[1]")
	public WebElement fname1;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"basicDetails\"]/div/div[1]/div[1]/ul[4]/li/label[1]")
	public WebElement lname1;

	
	@FindBy(how=How.XPATH, using="//*[@id=\"basicDetails\"]/div/div[1]/div[3]/ul[1]/li[2]/label")
	public WebElement streetnam;

	
	@FindBy(how=How.XPATH, using="//*[@id=\"basicDetails\"]/div/div[1]/div[3]/ul[2]/li[2]/label")
	public WebElement zip;

	
	@FindBy(how=How.XPATH, using="//*[@id=\"basicDetails\"]/div/div[1]/div[3]/div[1]/div[1]/label")
	public WebElement country2;

	
	@FindBy(how=How.XPATH, using="//*[@id=\"basicDetails\"]/div/div[1]/div[3]/div[2]/div[1]/label")
	public WebElement state2;

	@FindBy(how=How.XPATH, using="//*[@id=\"basicDetails\"]/div/div[1]/div[3]/ul[2]/li[1]/label")
	public WebElement city;

	
	@FindBy(how=How.XPATH, using="//*[@id=\"basicDetails\"]/div/div[1]/div[4]/ul/li[1]/label")
	public WebElement mainday;

	
	@FindBy(how=How.XPATH, using="//*[@id=\"basicDetails\"]/div/div[1]/div[1]/ul[7]/li/label[1]")
	public WebElement mobilecell;

	@FindBy(how=How.XPATH, using="//*[@id=\"basicDetails\"]/div/div[1]/div[2]/ul/li[2]/label")
	public WebElement role2;

	
	@FindBy(how=How.XPATH, using="//*[@id=\"basicDetails\"]/div/div[1]/div[1]/ul[1]/li/label[1]")
	public WebElement title;

	@FindBy(how=How.XPATH, using="//*[@id=\"basicDetails\"]/div/div[1]/div[1]/ul[2]/li/label[1]")
	public WebElement fname3;

	
	@FindBy(how=How.XPATH, using="//*[@id=\"basicDetails\"]/div/div[1]/div[1]/ul[3]/li/label[1]")
	public WebElement mname3;

	
	@FindBy(how=How.XPATH, using="//*[@id=\"basicDetails\"]/div/div[1]/div[1]/ul[4]/li/label[1]")
	public WebElement lname3;

	
	@FindBy(how=How.XPATH, using="//*[@id=\"basicDetails\"]/div/div[1]/div[1]/ul[5]/li/label[1]")
	public WebElement suffix;

	
	@FindBy(how=How.XPATH, using="//*[@id=\"basicDetails\"]/div/div[1]/div[1]/ul[6]/li/label[1]")
	public WebElement initials;

	
	@FindBy(how=How.XPATH, using="//*[@id=\"basicDetails\"]/div/div[1]/div[1]/ul[7]/li/label[1]")
	public WebElement mob;

	@FindBy(how=How.XPATH, using="//*[@id=\"basicDetails\"]/div/div[1]/div[1]/ul[8]/li/label[1]")
	public WebElement email3;

	@FindBy(how=How.XPATH, using="//select[@name='filteredOrganizationTable_length']")
	public WebElement showrow;
	
	@FindBy(how=How.XPATH, using="//button[text()='Upload SIP Facility Profile Form']")
	public WebElement UploadSIPfacilityFormBtn;
	
	@FindBy(how=How.XPATH, using="(//button[@id='pdfOkBtn'])[1]")
	public WebElement DownloadSIPfacilityOKbtn;                          
	
	@FindBy(how=How.XPATH, using="//button[text()='CANCEL ']")
	public WebElement UploadSIPfacilityCancelbtn;
	
	@FindBy(how=How.ID, using="download_button")
	public WebElement DownLoadSIPfacilityFormBtn;

	@FindBy(how=How.ID, using="basEdit")
	public WebElement edit;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"FldName_0\"]")
	public WebElement editcontactfname;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"FldName_2\"]")
	public WebElement editcontactlname;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"FldName_14\"]")
	public WebElement editcontactmob;
	
	@FindBy(how=How.XPATH, using="//label[text()='First Name']/following-sibling::label")
	public WebElement VerifyFname;
	
	@FindBy(how=How.XPATH, using="(//label[contains(@class,'form-label ')])[2]")
	public WebElement VerifyLname;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"nameError\"]")
	public WebElement fnametext;
	
    @FindBy(how=How.XPATH, using="//*[@id=\"lastNameError\"]")
	public WebElement lnametext;
    
	@FindBy(how=How.XPATH, using="//*[@id=\"phFormat22\"]")
	public WebElement mobtext;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"bebtn2\"]")
	public WebElement cancel4;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"basicDetails\"]/h2")
	public WebElement basicdetail;
	
	
	@FindBy(how=How.XPATH, using="//label[contains(text(),'Investigator')]")
	public WebElement investigator;
	
	@FindBy(how=How.XPATH, using="//span[@id='roleLabl']//span//label[contains(text(),'Clinical Research User')]")
	public WebElement ClinicalResearchUser;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"FldName_4\"]")
	public WebElement jobtit;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"FldName_4_special-char-error\"]")
	public WebElement jobtittext;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"basicDetails\"]/div/div[1]/div[3]/ul[1]/li[1]/label")
	public WebElement comp;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"basicDetails\"]/div/div[1]/div[3]/ul[1]/li[2]/label")
	public WebElement strtnam;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"basicDetails\"]/div/div[1]/div[3]/ul[1]/li[3]/label")
	public WebElement building;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"basicDetails\"]/div/div[1]/div[3]/ul[1]/li[4]/label")
	public WebElement additionaladdress;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"basicDetails\"]/div/div[1]/div[3]/div[1]/div[1]/label")
	public WebElement count;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"basicDetails\"]/div/div[1]/div[3]/div[2]/div[1]/label")
	public WebElement stt;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"FldName_4_special-char-error\"]")
	public WebElement cty;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"basicDetails\"]/div/div[1]/div[3]/ul[2]/li[2]/label")
	public WebElement zp;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"FldName_6_special-char-error\"]")
	public WebElement strttext;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"FldName_7_special-char-error\"]")
	public WebElement buildtext;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"FldName_9_special-char-error\"]")
	public WebElement ctytext;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"FldName_10_special-char-error\"]")
	public WebElement zptext;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"basicDetails\"]/div/div[1]/div[4]/ul/li[1]/label")
	public WebElement mainda;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"basicDetails\"]/div/div[1]/div[4]/ul/li[3]/label")
	public WebElement eveningph;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"basicDetails\"]/div/div[1]/div[4]/ul/li[5]/label")
	public WebElement hrsph;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"basicDetails\"]/div/div[1]/div[4]/ul/li[7]/label")
	public WebElement fax;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"basicDetails\"]/div/div[1]/div[4]/ul/li[9]/label")
	public WebElement pagenumber;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"basicDetails\"]")
	public WebElement basicdetails;
	
	@FindBy(how=How.XPATH, using="//span[text()='Home']")
	public WebElement home;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"closeAlert\"]")
	public WebElement OKK;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"profile-save-button\"]")
	public WebElement savv;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"okbutton\"]")
	public WebElement okk1;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"userAttachments\"]")
	public WebElement profileattachment;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"role_clinical_user\"]")
	public WebElement cruradio;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"sponsor-downloaded\"]/tbody[2]/tr[1]/td[3]")
	public WebElement ID;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"sponsor-downloaded\"]/tbody[2]/tr[1]/td[4]/img")
	public WebElement logo;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"role1Select\"]")
	public WebElement newdropdown;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"basicDetails\"]/div/div[1]/div[2]/ul/li[2]/label")
	public WebElement roles;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"role1SelectLbl\"]")
	public WebElement subroles;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"facilityDetails\"]")
	public WebElement Facilities;
	
	@FindBy(how=How.XPATH, using="//h2[text()='Facilities']")
	public WebElement FacilitiesHeader;
	
	@FindBy(how=How.XPATH, using="//span[text()='Organization Affiliations']")
	public WebElement Orgnizationaffiliaton;
	
	@FindBy(how=How.XPATH, using="(//h2[text()='Organization Affiliations'])[1]")
	public WebElement OrgnizationaffiliatonHeader;
	
	@FindBy(how=How.ID, using="addDepartmentBtn")
	public WebElement AddDepartmentToYourUserProfile;
	
	@FindBy(how=How.XPATH, using="(//div[@class='actionsDropdown']/ul[1]/li[@title='Add Department'])[1]")
	public WebElement AddDepartmentfromAction;
	//always need to change index of this Xpth depands upon at wich pplace facility is
	
	@FindBy(how=How.XPATH, using="(//div[@class='actionsDropdown']/ul[1]/li[@title='Export Facility Profile'])[7]")
	public WebElement ExportfacilityProfilefromAction;
	//always need to change index of this Xpth depands upon at wich pplace facility is
	
	@FindBy(how=How.XPATH, using="(//li[@title='Export Department Profile'])[3]")
	public WebElement ExportDepartmentProfilefromAction;
	
	@FindBy(how=How.XPATH, using="(//button[text()='Export'])[1]")
	public WebElement ExportBtn;
	
	@FindBy(how=How.ID, using="deptExportButton")
	public WebElement ExportBtnDep;
	
	@FindBy(how=How.XPATH, using="//div[@id='ExportPopupSuccessDep']/div[2]/div[1]/div[1]/button[1]")
	public WebElement ExportOKDep;
	
	@FindBy(how=How.XPATH, using="//div[@id='ExportPopupSuccess']/div[2]/div[1]/div[1]/button[1]")
	public WebElement ExportOK;
	
	@FindBy(how=How.XPATH, using="//button[text()='CREATE NEW DEPARTMENT']")
	public WebElement CreatNewDepartment;
	
	@FindBy(how=How.ID, using="departmentName")
	public WebElement DepartmentNameField;
	
	@FindBy(how=How.ID, using="departmentType")
	public WebElement DepartmentTypeField;
	
	@FindBy(how=How.ID, using="facility-save-button")
	public WebElement DepartmentSave;
	
	@FindBy(how=How.XPATH, using="//button[text()='I WILL CREATE/MAINTAIN THE DEPARTMENT PROFILE']")
	public WebElement I_WIL_MAINTAIN_THE_department_PROFILE;
	
	@FindBy(how=How.XPATH, using="//button[text()='CONTINUE UPDATING THIS DEPARTMENT']")
	public WebElement COUNTINUE_UPDATING_DEPARTMENT;
	
	@FindBy(how=How.XPATH, using="//button[text()='Adopt Facility Profile or Department']")
	public WebElement AdoptFacilityBtn;
	
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"userCountryId\"]/span")
	public WebElement countryy;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"mCSB_4_container\"]/div[1]/span[1]/span")
	public WebElement afganistan;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"userCountryId\"]/div/div[1]/span/span")
	public WebElement check11;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"userCountryId\"]/div/div[1]/a[1]/i")
	public WebElement cross1;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"firstName_pullCV\"]")
	public WebElement fnames;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"lastName_pullCV\"]")
	public WebElement lanames;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"myTraining1\"]/div/div/div[2]/input[1]")
	public WebElement search11;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"lastName\"]")
	public WebElement lname2;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"firstName\"]")
	public WebElement fname2;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"country\"]")
	public WebElement countr2;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"stateForPullCV\"]")
	public WebElement stat2;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"lastGeneratedCvDate\"]")
	public WebElement lastgenerated;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"cvPulledHistory\"]")
	public WebElement cvpulledhisto;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"markremh_3189|Haze| Markrem\"]")
	public WebElement no;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"markremh_3189|Haze| Markrem\"]")
	public WebElement yess;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"pull-cv-history\"]/div[2]/div/div[2]/div[1]/table/tbody/tr[1]/td[2]")
	public WebElement mcname;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"ui-id-2\"]")
	public WebElement orgcontact;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"pull-cv-history\"]/div[2]/i")
	public WebElement cosebutt;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"search-table\"]/tbody/tr/td[1]/span")
	public WebElement checkbox11;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"addCloseButton\"]")
	public WebElement pullcvbutton;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"addUserResult\"]/div[1]/div[1]/div/table/tbody/tr/td[1]/span")
	public WebElement listcheck;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"enabledDownloadBtn\"]/input")
	public WebElement downloadcvs;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"urgentSafetyNotificationPop\"]/div[2]/div[3]/button")
	public WebElement okkk;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"OrganizationId\"]/span[1]")
	public WebElement organization;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"myOrganizationsTable\"]/tbody/tr[1]/td[1]/a")
	public WebElement org1;
	
	@FindBy(how=How.ID, using="MyOrganization(s)Id")
	public WebElement Myorg;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"org-contact-table\"]/tbody/tr[2]/td[1]/div")
	public WebElement siteuser1;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"org-contact-table\"]/tbody/tr[3]/td[1]/div")
	public WebElement siteuser2;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"org-contact-table\"]/tbody/tr[3]/td[3]/div")
	public WebElement rolesite2;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"org-contact-table\"]/tbody/tr[6]/td[6]/div/button[2]/i")
	public WebElement closebut;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"activeSiteStaff\"]/h1/span")
	public WebElement popupmsg;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"activeSiteStaff\"]/p")
	public WebElement onscree;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@title='Confirm']")
	public WebElement confirm;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"actionOk\"]")
	public WebElement cancell;
	
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"OrgContactLandingSection\"]/h2")
	public WebElement organizationcontacttable;
	
	
	
	

	@FindBy(how=How.XPATH, using="//*[@id=\"publicationPresentation\"]")
	public WebElement publicationpresentation;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"add1\"]")
	public WebElement addpublication;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"journalName\"]")
	public WebElement journalcitation;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"ipDatePub\"]/span/span/span/span")
	public WebElement datepublish;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"createJournalArtFrm\"]/div[2]/input[2]")
	public WebElement Add;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"duplicateRecordLabl\"]")
	public WebElement errormsg1;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"duplicateOk\"]")
	public WebElement okbutton;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"createJournalPoup\"]/div[2]/i")
	public WebElement crossbutton;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"add2\"]")
	public WebElement presentationadd;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"conferenceName\"]")
	public WebElement presentationtitle;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"conferenceLocation\"]")
	public WebElement location2;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"presentationDateStyle\"]/span/span/span/span")
	public WebElement date;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"createSpeechPoup\"]/div[2]/div/div/div[2]/div/input[2]")
	public WebElement add2;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"duplicateRecordLabl\"]")
	public WebElement errosg2;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"duplicateOk\"]")
	public WebElement ok1;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"createSpeechPoup\"]/div[2]/i")
	public WebElement close1;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"professionalExpFrm\"]/div/div[1]/p")
	public WebElement onscreenprofessional;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"profExpAddLink\"]")
	public WebElement add11;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"addProfExpDetailsFrm\"]/div/ul/li[1]/label")
	public WebElement jobtitle1;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"addProfExpDetailsFrm\"]/div/ul/li[2]/label")
	public WebElement Institution;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"addProfExpDetailsFrm\"]/div/ul/li[3]/label")
	public WebElement yearstart;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"addProfExpDetailsFrm\"]/div/ul/li[2]/label")
	public WebElement year;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"addBtn\"]")
	public WebElement Add1;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"createProfExpPoup\"]/div[2]/div/div/input[2]")
	public WebElement cancel11;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"addBtn\"]")
	public WebElement jobtitle11;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"createProfExpPoup\"]/div[2]/div/div/input[2]")
	public WebElement institution11;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"yearStart\"]")
	public WebElement yearstarted11;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"addProfExpDetailsFrm\"]/div/ul/li[6]/span")
	public WebElement checkbox;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"profExpTable\"]/tbody/tr[2]/td[4]/span[1]")
	public WebElement present;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"profile-save-button\"]")
	public WebElement save1;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"okbutton\"]")
	public WebElement okk;
	
	@FindBy(how=How.XPATH, using="(//button[text()='OK'])[3]")
	public WebElement adoptOK;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"3486\"]/i")
	public WebElement remove;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"prof-exp-nxt\"]")
	public WebElement researchexp;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"res-exp-prev\"]")
	public WebElement professionallife;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"profExpEditLink\"]")
	public WebElement edit1;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"myTaskSTU\"]")
	public WebElement Mytask;
	
	@FindBy(how=How.XPATH, using="(//a[text()='Facility Profile available for download.'])[1]")
	public WebElement FacilityProfileDownloadLink;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"received\"]/div/a/span")
	public WebElement received;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"received\"]/div/a/span")
	public WebElement tasktype;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"allTaskViewMoreTable\"]/tbody/tr[1]/td[3]/div/a")
	public WebElement tasktitle;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"tabs-1\"]/div[1]/div/div[1]/ul/li[3]")
	public WebElement education;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"taskDetailsPopup_123461\"]/div/ul/li[5]/p/a")
	public WebElement clickhere;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"educationEditLink\"]/i")
	public WebElement edit2;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"editYearCompletedId\"]")
	public WebElement yearcomplet;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"editEduDetailsFrm\"]/div[3]/input[1]")
	public WebElement save2;

	
	@FindBy(how=How.XPATH, using="//*[@id=\"profExpEditLink\"]/i")
	public WebElement editprofess;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"edityearEndFldId\"]")
	public WebElement yrcompleted;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"editProfExpDetailsFrm\"]/div[2]/input[1]")
	public WebElement save3;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"allChangesForApprovalBtnId\"]")
	public WebElement submitforapproval;
	
	
	
	@FindBy(how=How.ID, using="ApproveRejectUpdate")
	public WebElement approverejectbutt;
	
	
	
	@FindBy(how=How.ID, using="approveAllchangesBtnId")
	public WebElement approveall;
	
	@FindBy(how=How.ID, using="rejectAllchangesBtnId")
	public WebElement rejectall;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"actionOk\"]")
	public WebElement okbutto;
	
	@FindBy(how=How.ID, using="educationDetails")
	public WebElement education1;
	
	@FindBy(how=How.ID, using="profExpDetails")
	public WebElement professionalexp1;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"educationDetailsFrm\"]/div/div/div[2]/input[2]")
	public WebElement Approvethischange;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"approveAllOk\"]")
	public WebElement ok11;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"JobTitleId\"]")
	public WebElement jobtitle12;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"institutionFldId\"]")
	public WebElement institution12;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"professionalExpFrm\"]/div/div[4]/input[2]")
	public WebElement Approvethischange1;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"yearStart\"]")
	public WebElement yearstarted12;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"p_p_id_TCSIPMyProfilePortlet_WAR_TCSIPMyProfilePortlet100_\"]/div/div/div/h1")
	public WebElement profilesummary;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"addFacilityBtn\"]")
	public WebElement addfacilitytouserprofile;
	
	
	@FindBy(how=How.ID, using="userPhotoImgId")
	public WebElement placeholder;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"p_p_id_TCSIPMyProfilePortlet_WAR_TCSIPMyProfilePortlet100_\"]/div/div/div/div[4]/div/div[1]/div[2]/h2")
	public WebElement siteuser;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"p_p_id_TCSIPMyProfilePortlet_WAR_TCSIPMyProfilePortlet100_\"]/div/div/div/div[4]/div/div[1]/div[2]/div/div/p[1]")
	public WebElement citystates;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"userPhnNo\"]")
	public WebElement phone1;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"p_p_id_TCSIPMyProfilePortlet_WAR_TCSIPMyProfilePortlet100_\"]/div/div/div/div[4]/div/div[1]/div[2]/div/div/p[3]/i/span")
	public WebElement email1;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"p_p_id_TCSIPMyProfilePortlet_WAR_TCSIPMyProfilePortlet100_\"]/div/div/div/div[3]/div/span[1]")
	public WebElement lastmodiefied;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"CVfileUpload\"]")
	public WebElement profileform;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"p_p_id_TCSIPMyProfilePortlet_WAR_TCSIPMyProfilePortlet100_\"]/div/div/div/div[4]/div/div[2]/div[2]/div[1]/button")
	public WebElement addpitostudy;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"myFacility1\"]/div/div/div[2]/input[1]")
	public WebElement seach11;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"addDelegate\"]")
	public WebElement delegatebutton;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"educationContainer\"]/div[1]/h2")
	public WebElement educationtitle;
	
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"fileToUpload\"]")
	public WebElement choosefile1;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"photoUploadBtnId\"]")
	public WebElement upload1;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"photoUploadBtnId\"]")
	public WebElement cancel5;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"ui-id-1\"]/span")
	public WebElement userprofiletab;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"ui-id-42\"]")
	public WebElement abbriviatedcvtab;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"#tabs-3\"]")
	public WebElement exporteduserprofiletab;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"errorPhotoId\"]")
	public WebElement errormsg111;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"my_file\"]")
	public WebElement choosefile2;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"pdfUploadPopupOk\"]")
	public WebElement upload2;
	
	
	

	@FindBy(how=How.XPATH, using="//*[@id=\"facilityID1611$DD54486-000$YjZWem5vRTZwRkE9$VWhqZjJIM2VYcDdXalphOVhaaThUZz09$Queens Village Primary Medical Center\"]")
	public WebElement radiobutt;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"successMessagePopUp\"]/div/div[2]/button")
	public WebElement ok4;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"trainingDetailsId\"]")
	public WebElement gcp;
	
	
	
	@FindBy(how=How.XPATH, using="//i[contains(@class,'bell')]")
	public WebElement bell;
	
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"licenseDetails\"]")
	public WebElement license;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"#tabs-3\"]")
	public WebElement exporteduserprofile;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"tabs-3\"]/div/table/tbody/tr/td/span")
	public WebElement norecord;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"tabs-3\"]/div/table/tbody/tr/td/span")
	public WebElement exportuserprofile;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"exportUserProfile\"]")
	public WebElement exportuserprofilebutton;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"emailUserProfile\"]/div[2]/div/p")
	public WebElement exportonscreen;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"emailUserProfile\"]/div[2]/i")
	public WebElement closebotton;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"addFacilitybtn\"]")
	public WebElement addfacilitty;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"search_CountryList_Id\"]")
	public WebElement country11;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"search_state_Id\"]")
	public WebElement state11;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"search_city\"]")
	public WebElement city11;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"search_facilityName\"]")
	public WebElement facility11;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"educationContainer\"]/div[1]/span[1]/div/span[1]")
	public WebElement notapplicable;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"addDeparment\"]/div/div/div[2]/div[3]/button[3]")
	public WebElement Nodepartment;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"search_sipFacilityId\"]")
	public WebElement sipfacility11;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"basicDetails\"]")
	public WebElement basicdetailss;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"facilitySectionId\"]/thead/tr/th[1]/div")
	public WebElement displayoncv;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"facilitySectionId\"]/thead/tr/th[2]/div")
	public WebElement primaryfacility;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"FACILITYNAME\"]")
	public WebElement facitynameaddress;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"DEPARTMENTNAME\"]")
	public WebElement departmentname;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"facilitySectionId\"]/thead/tr/th[5]/div")
	public WebElement action;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"profile-save-button\"]")
	public WebElement save11;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"okbutton\"]")
	public WebElement okkkk;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"userAttachments\"]")
	public WebElement profileattachments;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"publicationPresentation\"]")
	public WebElement publication;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"generateCvBtnId\"]")
	public WebElement generatecv;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"taskResults\"]/div[2]/input")
	public WebElement mytask;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"allTaskViewMoreTable\"]/tbody/tr[3]/td[3]/div/a")
	public WebElement delagteclick;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"editMedicalLicensePopup\"]/div[2]/div/div[2]/div/input[1]")
	public WebElement savee;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"taskDetailsPopup_138915\"]/div/ul/li[5]/p/a")
	public WebElement clickhere1;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"speakerEngageEditLink\"]/i")
	public WebElement editbutton;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"elicenseType\"]")
	public WebElement licesetype;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"allChangesForApprovalBtnId\"]")
	public WebElement sendallaproval;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"actionOk\"]")
	public WebElement okkkkk;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"1648\"]/td[3]/div[1]/a")
	public WebElement fac1;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"2829\"]/td[3]/div[1]/a")
	public WebElement fac2;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"1648\"]/td[4]/div[1]/a")
	public WebElement dept1;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"2829\"]/td[2]/div/label/span[1]")
	public WebElement primaryfac;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"2383\"]/td[2]/div/label/span[1]")
	public WebElement primaryfac2;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"actionsMain2829\"]/button/i")
	public WebElement action1;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"actionsMain2829\"]/div/ul/li[3]")
	public WebElement removefacility;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"researchExpFrm\"]/div[1]/p[2]/span")
	public WebElement notapplicable1;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"dissociateOwnerPopup\"]/div[2]/div/div/button")
	public WebElement okbuttonn;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"totalClinicalResearchAddLink\"]")
	public WebElement add3;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"createTotalExpFrm\"]/div/div[1]/div/ul/li[1]/label")
	public WebElement thereaputicarea;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"createTotalExpFrm\"]/div/div[1]/div/ul/li[3]/label")
	public WebElement subtheraputicarea;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"createTotalExpFrm\"]/div/div[1]/div/ul/li[5]/label")
	public WebElement noofcompletedstudy;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"createTotalExpFrm\"]/div/div[1]/div/ul/li[6]/label")
	public WebElement noofongoingstudy;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"createTotalExpFrm\"]/div/div[2]/div/input[1]")
	public WebElement add4;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"createTotalExpFrm\"]/div/div[2]/div/input[2]")
	public WebElement cancel6;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"therapeuticList_Id\"]")
	public WebElement thereaputicareatext;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"subtherapeuticList_Id\"]")
	public WebElement subtheraputicareatext;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"completedTrialsId\"]")
	public WebElement noofcompletedstudytext;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"ongoingTrialsId\"]")
	public WebElement noofongoingstudytext;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"profile-save-button\"]")
	public WebElement saveee;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"okbutton\"]")
	public WebElement okkkkkk;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"res-exp-prev\"]")
	public WebElement professionalexppp;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"prof-exp-nxt\"]")
	public WebElement researchexpp;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"totalClinicalResearchEditLink\"]")
	public WebElement edittt;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"2657\"]/i")
	public WebElement removedata;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"res-exp-nxt\"]")
	public WebElement gcptraining;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"my_file\"]")
	public WebElement choosefiless;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"pdfUploadPopupOk\"]")
	public WebElement upload11;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"delegateEmailId\"]")
	public WebElement delegateemail1;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"delegateUserBtn\"]")
	public WebElement delegatebutton111;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"site_user_delegation_succes\"]")
	public WebElement okkkkkkk;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"search-table\"]/tbody/tr[1]/td[3]/a")
	public WebElement siteuser1s;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"speakerEngageEditLink\"]/i")
	public WebElement editlicense;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"elicenseIssuer\"]")
	public WebElement lisenseissuer;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"editMedicalLicensePopup\"]/div[2]/div/div[2]/div/input[1]")
	public WebElement saveeee;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"addUserResult\"]/div[1]/div[1]/div/table/tbody/tr[1]/td[1]/span")
	public WebElement chk1;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"addUserResult\"]/div[1]/div[1]/div/table/tbody/tr[2]/td[1]/span")
	public WebElement chk2;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"addUserResult\"]/div[1]/div[1]/div/table/tbody/tr[3]/td[1]/span")
	public WebElement chk3;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"enabledDownloadBtn\"]/input")
	public WebElement downloadcvss;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"search-table\"]/thead/tr/th[1]/span")
	public WebElement checkall;
		
	@FindBy(how=How.XPATH, using="//*[@id=\"addCloseButton\"]")
	public WebElement pullcvbuttons;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"transCelerateId\"]")
	public WebElement sipuseridsss;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"firstName\"]")
	public WebElement firstnames;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"lastName\"]")
	public WebElement lastnames;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"cvTitle\"]")
	public WebElement cvtitles;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"addUserResult\"]/div[1]/div[1]/div/table/thead/tr/th[6]")
	public WebElement viewcv;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"addUserResult\"]/div[1]/div[1]/div/table/thead/tr/th[1]/span")
	public WebElement  checkalll;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"enabledDownloadBtn\"]/input")
	public WebElement  downloadcvsss;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"tabs-1\"]/div[1]/div/div[1]/ul/li[1]")
	public WebElement  basicdetailsss;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"facilityDetails\"]")
	public WebElement  facilitiesss;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"educationDetails\"]")
	public WebElement  educationss;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"profExpDetails\"]")
	public WebElement  professionalexppps;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"trainingDetailsId\"]")
	public WebElement  gcptrainings;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"licenseDetails\"]")
	public WebElement  licensedetails;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"researchExp\"]")
	public WebElement  researchexpppss;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"2831\"]/td[3]/div[1]/a")
	public WebElement  firstfacility;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"2780\"]/td[3]/div[1]/a")
	public WebElement  secondfacility;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"1611\"]/td[3]/div[1]/a")
	public WebElement  thirdfacility;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"eduTable\"]/thead/tr/th[4]")
	public WebElement  yearcompleted;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"profile-save-button\"]")
	public WebElement  saves;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"okbutton\"]")
	public WebElement  okies;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"researchInterestTable\"]/thead/tr/th[1]")
	public WebElement  theraputicarea;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"researchInterestTable\"]/thead/tr/th[2]")
	public WebElement  substheraputicarea;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"view-more\"]/div[1]/div/ul/li[1]")
	public WebElement  tosearch;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"view-more\"]/div[3]/div[1]/ul/li[1]")
	public WebElement  tosearch1;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"view-more\"]/div[3]/div[1]/ul")
	public WebElement  tosearch2;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"addUserResult\"]/div[1]/div[1]/div/table/thead/tr/th[1]/span")
	public WebElement  checlboxaall;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"enabledDownloadBtn\"]/input")
	public WebElement  downloadcvsssss;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"mCSB_4_container\"]/div[236]/span[1]/span")
	public WebElement  checkboxes;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"userCountryId\"]/div/div[1]/a[1]/i")
	public WebElement  closes;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"modalpullcvSearchRes\"]/div[2]/div/div[2]/div/div/span[1]/a")
	public WebElement  singlearrow;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"modalpullcvSearchRes\"]/div[2]/div/div[2]/div/div/span[1]/a")
	public WebElement  firstarrow;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"modalpullcvSearchRes\"]/div[2]/div/div[2]/div/div/span[2]")
	public WebElement  lastarrow;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"modalpullcvSearchRes\"]/div[2]/div/div[2]/div/div/span[2]/a")
	public WebElement  prevarrorw;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"goToPage\"]")
	public WebElement  pagenumbers;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"search-table\"]/tbody/tr[1]/td[3]/label/a")
	public WebElement  lastnameclick;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"1120219\"]/span")
	public WebElement  professionallicenenumber;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"email_pullCV\"]")
	public WebElement  emailaddress;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"res-exp-nxt\"]")
	public WebElement  gcptrainingbutton;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"search-table\"]/tbody/tr[1]/td[3]/a")
	public WebElement  userdelageted;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"trainingDetailsFrm\"]/div/div[1]/h2")
	public WebElement  gcptrainingtitle;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"trainingDetailsFrm\"]/div/div[2]/div/ul/li[1]")
	public WebElement  gcpscreen1;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"trainingDetailsFrm\"]/div/div[2]/div/ul/li[2]")
	public WebElement  gcpscreen2;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"trainingDetailsFrm\"]/div/div[2]/div/ul/li[3]")
	public WebElement  gcpscreen3;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"gcpCompletedNo\"]")
	public WebElement  noradio;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"noSection\"]/button")
	public WebElement  findacourse;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"profile-save-button\"]")
	public WebElement  savvee;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"okbutton\"]")
	public WebElement  okkkki;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"notiList\"]/ul/li[4]/a")
	public WebElement  viewmore;
	

	@FindBy(how=How.ID, using="generateCvBtnId")
    public WebElement generateCVButton1;

	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"journalPresentationEditLink1\"]/i")
    public WebElement editpresentation;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"editConferenceName\"]")
    public WebElement preentationtitle;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"createSpeechPoup1\"]/div[2]/div/div/div[2]/div/input[2]")
    public WebElement presentationsave;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"download_button\"]")
    public WebElement downloadsipuserprofile;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"viewstudyhistory\"]")
    public WebElement PIstdyhistory;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"pdfOkBtn\"]")
    public WebElement okbuttonn1;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"viewstudyhistoryOK\"]")
    public WebElement ok13;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"pdfUploadPopupCancel\"]")
    public WebElement cancel13;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"addDelegate\"]")
    public WebElement delegatebutt;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"p_p_id_TCSIPMyProfilePortlet_WAR_TCSIPMyProfilePortlet100_\"]/div/div/div/div[5]/div[2]/div[1]/div/span[1]/label")
    public WebElement sitestaff;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"p_p_id_TCSIPMyProfilePortlet_WAR_TCSIPMyProfilePortlet100_\"]/div/div/div/div[5]/div[2]/div[1]/div/span[2]/label")
    public WebElement organizationd;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"delegateEmailId\"]")
    public WebElement delagtedemail;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"delegateUserBtn\"]")
    public WebElement delagete;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"site_user_delegation_succes\"]")
    public WebElement okbuttonn111;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"p_p_id_TCSIPMyProfilePortlet_WAR_TCSIPMyProfilePortlet100_\"]/div/div/div/div[4]/div/div[2]/div[3]/button")
    public WebElement undelegate;
	
	
	@FindBy(how=How.ID, using="goToApproveRejectDelegation")
    public WebElement ApproveRejectChange;
	
	@FindBy(how=How.ID, using="yesToUnDelegateBtn")
    public WebElement RemoveDelegate;
	
	@FindBy(how=How.CLASS_NAME, using="orgLabel")
    public WebElement OrganizationNameVerify;
	
	@FindBy(how=How.ID, using="rejectAllchangesBtnId")
    public WebElement RejectAllchanges;
	
	@FindBy(how=How.XPATH, using="(//input[@id='approveAllOk'])[2]")
    public WebElement RejectAllchangesOK;
	
	@FindBy(how=How.XPATH, using="(//button[contains(@class,'single-btn marLeft10')])[2]")
    public WebElement UndelegatedCancel;
	
	@FindBy(how=How.XPATH, using="//button[contains(@class,'single-btn marLeft10')]")
    public WebElement UndelegatedCancel1;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"unDelegateSuccessPopup\"]/div[2]/div/div/button")
    public WebElement okkkkkkkkkk;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"yesToUnDelegateBtn\"]")
    public WebElement removedelageted;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"delegateOrganization\"]")
    public WebElement orgradio1;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"myProfileOrganizationListId\"]")
    public WebElement orgname1;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"myProfileCountryListId\"]")
    public WebElement countrname1;
	
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"StateList_wrapper\"]/span")
    public WebElement statename1;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"delegateSearchBtn1\"]")
    public WebElement searchname1;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"filteredOrganizationTable\"]/tbody/tr/td[1]")
    public WebElement rad;
	
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"delegateOrgnBtn\"]")
    public WebElement delageorg;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"delegateUserSuccessBtn\"]")
    public WebElement okn;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"p_p_id_TCSIPMyProfilePortlet_WAR_TCSIPMyProfilePortlet100_\"]/div/div/div/div[4]/div/div[2]/div[1]/div[1]/span")
    public WebElement orgname11;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"actionsMain1581\"]/button/i")
    public WebElement action11;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"actionsMain1581\"]/div/ul/li[4]")
    public WebElement sendmsgtofpm;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"facilityConsentTextarea1\"]")
    public WebElement body;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"sendMailBtn\"]")
    public WebElement sendmsg;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"modalsendmail\"]/div[2]/div/div[3]/button[2]")
    public WebElement cancel111;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"errMsg\"]")
    public WebElement msg1;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"sucMsg\"]")
    public WebElement msg2;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"facilityDiv\"]/h2")
    public WebElement section;
	
	@FindBy(how=How.ID, using="labName_0")
    public WebElement LabName;
	
	@FindBy(how=How.ID, using="labAddressOne_0")
    public WebElement StreetName;
	
	@FindBy(how=How.ID, using="search_CountryList_0")
    public WebElement LoaclLabCountry;
	
	@FindBy(how=How.ID, using="search_state_Id_0")
    public WebElement LoaclLabStates;
	
	@FindBy(how=How.ID, using="labCity_0")
    public WebElement LoaclLabCity;
	
	@FindBy(how=How.XPATH, using="//input[contains(@class,'form-checkbox-btn localLabAccreditationNone')]/following-sibling::span[1]")
    public WebElement LoaclLabAccredetation;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"success-message-popup\"]/div[2]/div/div/button")
    public WebElement okkkkkks;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"stateTA\"]/label")
    public WebElement states;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"view-more\"]/div[1]/ul[1]/li[3]/label")
    public WebElement citis;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"view-more\"]/div[1]/ul[2]/li[1]/label")
    public WebElement programs;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"view-more\"]/div[1]/ul[2]/li[2]/label")
    public WebElement studis;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"view-more\"]/div[1]/ul/li[3]/label")
    public WebElement emails;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"view-more\"]/div[1]/ul/li[4]/label")
    public WebElement roless;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"view-more\"]/div[1]/ul/li[5]/label")
    public WebElement activations;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"markremh_3189|Haze| Markrem\"]")
    public WebElement pullcvyes;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"pull-cv-history\"]/div[2]/div/div[1]/div[1]/div[1]/p/label")
    public WebElement sipuseridssss;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"pull-cv-history\"]/div[2]/div/div[1]/div[2]/div[1]/p/label")
    public WebElement name;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"cvHistoryDownloadButton\"]")
    public WebElement downloadcv1;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"pull-cv-history\"]/div[2]/div/div[3]/input[2]")
    public WebElement cancelbutton;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"goToPage1\"]")
    public WebElement enterpage;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"alertPopup\"]/p")
    public WebElement errormsg2;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"alertPopup\"]/p")
    public WebElement errormsg3;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"closeAlert\"]/span")
    public WebElement okbutttttt;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"userGenCvsMoreTr\"]/td/a")
    public WebElement viewmores;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"mCSB_27_container\"]/div/div[1]/table/thead/tr/th[1]")
    public WebElement cvdocname;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"mCSB_27_container\"]/div/div[1]/table/thead/tr/th[2]")
    public WebElement status;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"userGenCvsRecordTr\"]/td[3]/a[1]/i")
    public WebElement word;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"userGenCvsRecordTr\"]/td[3]/a[2]/i")
    public WebElement pdf;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"userGenCvsRecordTr\"]/td[3]/a[2]/i")
    public WebElement faname;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"userGenCvsRecordTr\"]/td[3]/a[2]/i")
    public WebElement laname;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"p_p_id_TCSIPMyProfilePortlet_WAR_TCSIPMyProfilePortlet100_\"]/div/div/div/div[4]/div/div[2]/div[1]/div/i")
    public WebElement usericon;
 
	
	@FindBy(how=How.XPATH, using="//*[@id=\"myTraining1\"]/div/div/h2")
    public WebElement searchuser;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"gcpCompletedYes\"]")
    public WebElement yesradio;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"trainingDetailsFrm\"]/div/div[3]/p")
    public WebElement haveucompletd;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"gcpCompletedNo\"]")
    public WebElement noradio1;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"gcpTrainingContainer\"]/div[2]/button")
    public WebElement submittrainingcreditrequest;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"TrainingId\"]/span[2]")
    public WebElement Training;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"MyTrainingId\"]")
    public WebElement MyTraining;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"myTraining1\"]/div/div/button/i")
    public WebElement clickexpand;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"emptySearchResult\"]/p")
    public WebElement norecordfound;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"p_p_id_TCSIPMyProfilePortlet_WAR_TCSIPMyProfilePortlet100_\"]/div/div/div/div[5]/div[2]/div[2]/div[2]/button[2]")
    public WebElement cancel1111;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"site_user_delegation_succes\"]")
    public WebElement ok34;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"facilityDiv\"]/p/text()[1]")
    public WebElement onscrn1;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"facilityDiv\"]/p/text()[2]")
    public WebElement onscrn12;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"facilityDiv\"]/p/text()[3]")
    public WebElement onscrn3;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"facilityDiv\"]/p/text()[4]")
    public WebElement onscrn4;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"facilityDiv\"]/p/text()[5]")
    public WebElement onscrn5;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"1683\"]/td[1]/div/label/span")
    public WebElement checkboxdisplayoncv;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"profile-save-button\"]")
    public WebElement savebuttons;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"okbutton\"]")
    public WebElement okbuttonss;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"departmentResults\"]/tbody/tr[1]/td[1]/span")
    public WebElement dept1checkbox;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"addDepartmentBtn\"]")
    public WebElement adddepartmenttouserprofile;
	
	@FindBy(how=How.XPATH, using="//a[@id='AdminId']")
    public WebElement admin;
	
	@FindBy(how=How.XPATH, using="//a[@id='ManageDelegationId']")
    public WebElement managedelegation;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"manageDelAddDel\"]")
    public WebElement adddelegate;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"delegateOrganization\"]")
    public WebElement organizations;

	@FindBy(how=How.XPATH, using="//*[@id=\"manageDelOrgListId\"]")
    public WebElement organizationsname;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"manageDelegateSearchBtn\"]")
    public WebElement search12;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"filteredOrganizationTable\"]/tbody/tr/td[1]/input")
    public WebElement rad1;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"delegateOrgnBtn\"]")
    public WebElement delegate11;

	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"delegateUserSuccessBtn\"]")
    public WebElement okkks;
	
	@FindBy(how=How.ID, using="selectedAuditReport")
    public WebElement SelectAuditTrailReportDropdown;
	
	
	
	@FindBy(how=How.ID, using="ReportsId")
    public WebElement Report;
	
	@FindBy(how=How.ID, using="AuditTrailReportsId")
    public WebElement AuditTrailReport;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"auditPopulateTabForm\"]/div/div/div[4]/input[1]")
    public WebElement Generatereport;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"input_date1Error\"]")
    public WebElement validation1;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"input_date2Error\"]")
    public WebElement validation2;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"userIdError\"]")
    public WebElement validation3;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"auditPopulateTabForm\"]/div[1]/div/div[1]/div[1]/div[1]/div[1]/span/span/span/span")
    public WebElement fromdate;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"auditPopulateTabForm\"]/div[1]/div/div[1]/div[1]/div[1]/div[2]/span/span/span/span")
    public WebElement todate;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"FacilitySearchByButton\"]/i")
    public WebElement facilitydepat;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"countryFacilitySearch\"]")
    public WebElement country12;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"staffSearch\"]")
    public WebElement search123;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"addUserBtn\"]")
    public WebElement select;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"pavm_4186\"]")
    public WebElement radio;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"pagination_limit\"]")
    public WebElement pagination;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"userId\"]/i")
    public WebElement usernamesearch;

	
	@FindBy(how=How.XPATH, using="//*[@id=\"auditPaginationDiv\"]/div[1]/div/button[2]/i")
    public WebElement export;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"auditPaginationDiv\"]/div[1]/div/div/ul/li[1]")
    public WebElement pdfexport;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"auditPaginationDiv\"]/div[1]/div/div/ul/li[2]")
    public WebElement xlsexport;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"auditPaginationDiv\"]/div[1]/div/button[1]/i")
    public WebElement print;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"checktablenewtable\"]/table/thead/tr/th[1]/div")
    public WebElement usernam;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"checktablenewtable\"]/table/thead/tr/th[2]/div")
    public WebElement informationarea;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"checktablenewtable\"]/table/thead/tr/th[3]/div")
    public WebElement refrenceid;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"checktablenewtable\"]/table/thead/tr/th[4]/div")
    public WebElement attributename;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"checktablenewtable\"]/table/thead/tr/th[5]/div")
    public WebElement oldvalue;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"checktablenewtable\"]/table/thead/tr/th[6]/div")
    public WebElement newvalue;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"checktablenewtable\"]/table/thead/tr/th[7]/div")
    public WebElement actio;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"checktablenewtable\"]/table/thead/tr/th[8]/div")
    public WebElement changeby;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"checktablenewtable\"]/table/thead/tr/th[9]/div")
    public WebElement changeddate;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"checktablenewtable\"]/table/thead/tr/th[10]/div")
    public WebElement reasonforchange;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"checktablenewtable\"]/table/thead/tr/th[10]/div")
    public WebElement Addlicense;
	

	
	@FindBy(how=How.XPATH, using="//*[@id=\"licenseType\"]")
    public WebElement typeoflicense;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"licenseIssuer\"]")
    public WebElement licenseissuer;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"licenseNumber\"]")
    public WebElement proflicensenumber;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"issueDate\"]")
    public WebElement issuedata;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"countryList_Id\"]")
    public WebElement countryy1;
	

	@FindBy(how=How.XPATH, using="//*[@id=\"stateList_Id\"]")
    public WebElement state141;
	
	
	@FindBy(how=How.XPATH, using="//h6[text()='View more']")
    public WebElement viewmore1;
	

	@FindBy(how=How.XPATH, using="//*[@id=\"expiryDate\"]")
    public WebElement expdate;
	

	@FindBy(how=How.XPATH, using="//*[@id=\"licenseFile\"]")
    public WebElement suppdoc;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"uploadMedicalLicensePopup\"]/div[2]/div/div/input[1]")
    public WebElement upload222;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"uploadMedicalLicensePopup\"]/div[2]/div/div/input[2]")
    public WebElement cancel22;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"CVfileUpload\"]")
    public WebElement sipuserprofile;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"my_file\"]")
    public WebElement choosefile223;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"allTaskViewMoreTable\"]/tbody/tr/td[3]/div/a")
    public WebElement generate;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"taskDetailsPopup_130091\"]/div/ul/li[5]/p/a")
    public WebElement clickhare;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"emailUserProfilePopup\"]")
    public WebElement exportuserprofile1;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"exportUserProfile\"]")
    public WebElement exportuserprofile2;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"gcpTrainingContainer\"]/div[2]/div/table/thead/tr/th[1]")
    public WebElement  courseprovider;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"gcpTrainingContainer\"]/div[2]/div/table/thead/tr/th[2]")
    public WebElement coursetitle;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"gcpTrainingContainer\"]/div[2]/div/table/thead/tr/th[3]")
    public WebElement datecompleted;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"gcpTrainingContainer\"]/div[2]/div/table/thead/tr/th[4]")
    public WebElement expirationdate;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"gcpTrainingContainer\"]/div[2]/div/table/thead/tr/th[5]")
    public WebElement status1;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"gcpTrainingContainer\"]/div[2]/div/table/thead/tr/th[6]")
    public WebElement trainingcertificate;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"gcpTrainingContainer\"]/div[2]/button")
    public WebElement submittrainingcreditrequest1;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"refreshIGrid\"]/i")
    public WebElement refresh;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"gcpTrainingContainer\"]/div[2]/div/table/tbody/tr[1]/td[5]/a")
    public WebElement sentforreview;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"gcpTrainingContainer\"]/div[2]/div/table/tbody/tr[2]/td[5]/a")
    public WebElement certificatevalid;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"gcpTrainingContainer\"]/div[2]/div/table/tbody/tr[4]/td[5]/a")
    public WebElement siteactionrequired;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"fixTable-3\"]/tbody/tr[1]/td[5]/div/a")
    public WebElement clickherenotification;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"professionalExpFrm\"]/div/div[4]/input[2]")
    public WebElement approvethischange;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"approveAllOk\"]")
    public WebElement okbuttt;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"professionalExpFrm\"]/div/div[4]/input[1]")
    public WebElement rejectthischange;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"studyTypeTable\"]/thead/tr/th/div")
    public WebElement studytype;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"clinicalTrialDiv\"]/div[2]/table/thead/tr/th")
    public WebElement clinicalstudyphase;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"researchInterestTable\"]/thead/tr/th[1]")
    public WebElement thereputicarea;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"totalResearchExpDiv\"]/div[1]/h5")
    public WebElement totalclinical;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"recentResearchDiv\"]/p")
    public WebElement screentext2;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"clinicalTrialDiv\"]/div[1]/p")
    public WebElement screentext3;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"researchInterestDiv\"]/div[1]/p")
    public WebElement screentext4;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"totalResearchExpDiv\"]/div[1]/p")
    public WebElement screentext5;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"studyTypeTable\"]/tbody/tr[1]/td[1]/label")
    public WebElement academic;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"studyTypeTable\"]/tbody/tr[1]/td[2]/label")
    public WebElement goverment;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"studyTypeTable\"]/tbody/tr[1]/td[3]/label")
    public WebElement industry;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"studyTypeTable\"]/tbody/tr[1]/td[4]/label")
    public WebElement investigatorinitiated;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"studyTypeTable\"]/tbody/tr[2]/td[1]/label")
    public WebElement other;
	

	@FindBy(how=How.XPATH, using="//*[@id=\"clinicalTrialDiv\"]/div[2]/table/tbody/tr/td[1]/label")
    public WebElement phase1;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"clinicalTrialDiv\"]/div[2]/table/tbody/tr/td[2]/label")
    public WebElement phase2;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"clinicalTrialDiv\"]/div[2]/table/tbody/tr/td[3]/label")
    public WebElement phase3;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"clinicalTrialDiv\"]/div[2]/table/tbody/tr/td[4]/label")
    public WebElement phase4;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"actOk\"]")
    public WebElement ok9;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"search_course_form\"]/div[1]/h2")
	public WebElement ByTypeAndProvider;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"search_course_form\"]/div[2]/h2")
	public WebElement ByStudy;
	
	
	
	
	@FindBy(how=How.ID, using="TrainingId")
	public WebElement Trainingdropdown;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"userSelectBlock\"]/div[1]/div/div/div/div/ul")
	public WebElement SelectSomeoneelse;
	
	
	@FindBy(how=How.ID, using="SubmitAndManageCreditRequestsId")
	public WebElement SubmitManagelink;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"mainContentArea1\"]/div/div[1]/input")
	public WebElement submitnewrequestbutton;
	
	@FindBy(how=How.ID, using="actOk")
	public WebElement Okbutton;
	
	@FindBy(how=How.ID, using="forMyself")
	public WebElement MySelfbutton;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"onBehalf\"]")
	public WebElement SomeoneElseButton;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"tagstA\"]")
	public WebElement UserSelect;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"chooseUserContinueSelf\"]")
	public WebElement Selectcompletecourse;
	
	@FindBy(how=How.XPATH, using="	//*[@id=\"enterCoursePopup\"]")
	public WebElement CourseNotlisted;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"courseTitlepopup\"]/div/p")
	public WebElement OnScreenText1;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"chooseUserContinueBehalf\"]")
	public WebElement SelectCourseBehalf;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"type\"]")
	public WebElement SelectTrainingType;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"provider_list\"]")
	public WebElement TrainingProvider;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"search_course_form\"]/div[1]/div[2]/div/ul")
	public WebElement Providerdata;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"training_search\"]")
	public WebElement Searchbutton;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"manualCourseTitle\"]")
	public WebElement CourseTitle;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"training_Type\"]")
	public WebElement TrainingTypedropdown;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"training_Provider\"]")
	public WebElement NewTrainingProvider;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"continueManuallyEnteredTraining\"]")
	public WebElement SubmitCourse;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"cancelSearch\"]")
	public WebElement CancelCourse;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"SponsorName_SponsorDiv\"]")
	public WebElement SponsorCROSelect;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"Sponsordiv\"]/div/label")
	public WebElement SponsorCROlabel;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"SponsorName_SponsorDiv\"]")
	public WebElement SponsorCROdropdown;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"userDetails\"]/div/div[1]/label")
	public WebElement RequestedBy;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"requestedBy\"]")
	public WebElement RequestedByName;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"userDetails\"]/div/div[2]/label")
	public WebElement Requestedfor;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"requestedFor\"]")
	public WebElement RequestedforName;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"trainingDetails\"]/h4")
	public WebElement TrainingHeader;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"trainingDetails\"]/div[1]/div/label")
	public WebElement CourseTitle1;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"courseTitle\"]")
	public WebElement CourseTitleName;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"trainingDetails\"]/div[3]/div[1]/label")
	public WebElement SponsorCroType;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"sponsorID\"]")
	public WebElement SponsorCroName;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"trainingDetails\"]/div[2]/div[2]/label")
	public WebElement TraningProvierheading;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"trainingProviderID\"]")
	public WebElement TrainingProvidername;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"trainingDetails\"]/div[3]/div[2]/label")
	public WebElement Category;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"category\"]")
	public WebElement CategoryName;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"trainingDetails\"]/div[4]/div[1]/label")
	public WebElement StudyHeader;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"studyID\"]")
	public WebElement StudyId;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"trainingDetails\"]/div[4]/div[2]/label")
	public WebElement Completiondate;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"trainingCompletionDateID\"]")
	public WebElement TrainingCompletdate;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"fixTable-1\"]/tbody/tr[1]/td[1]/label")
	public WebElement RequestId;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"fixTable-1\"]/tbody/tr[1]/td[2]/label")
	public WebElement TrainingType;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"fixTable-1\"]/tbody/tr[1]/td[3]/label")
	public WebElement CourseTitledata;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"fixTable-1\"]/tbody/tr[1]/td[4]/label")
	public WebElement Datecompleted;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"fixTable-1\"]/tbody/tr[1]/td[5]/label")
	public WebElement TrainingProviderName;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"fixTable-1\"]/tbody/tr[1]/td[6]/label")
	public WebElement ReviewerName;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"fixTable-1\"]/tbody/tr[1]/td[7]/label")
	public WebElement RequestedDate;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"fixTable-1\"]/tbody/tr[1]/td[8]/label")
	public WebElement RequestedFor;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"fixTable-1\"]/tbody/tr[1]/td[9]/label")
	public WebElement RequestBy;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"fixTable-1\"]/tbody/tr[1]/td[11]/label")
	public WebElement TrainingStatus;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"fixTable-1\"]/tbody/tr[1]/td[12]/div/a[2]")
	public WebElement DeleteIcon;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"fixTable-1\"]/tbody/tr[1]/td[12]/div/a[1]")
	public WebElement EditIcon;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"delReq\"]/h1")
	public WebElement Editheader;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"mCSB_20_container\"]/h4")
	public WebElement EditTrainingDetailsheader;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"otherCousrseTitle\"]")
	public WebElement EditCourseTitle;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"edit_trainingProvider\"]")
	public WebElement EditTrainingProvider;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"edit_completionDate\"]")
	public WebElement EditDate;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"edit_reasonForChange\"]")
	public WebElement EditReasonofChange;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"submitDelete_edit\"]")
	public WebElement EditSubmit;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"reasonForChangeText\"]")
	public WebElement DeleteReasonofChange;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"submitDelete\"]")
	public WebElement DeleteSubmit;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"mCSB_21_dragger_vertical\"]/div")
	public WebElement DeleteScroll;

	
	
	    
	@FindBy(how=How.XPATH, using="//*[@id=\"completionDateButton\"]")
	public WebElement SelectCoursecompletiondate;
	
	@FindBy(how=How.XPATH, using="/html/body/div[4]/div/div/div[1]/a[2]")
	public WebElement SelectDatefield;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"tabs-3\"]/form/div[1]/div/span/span/span/span")
	public WebElement Datepicker;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"completionDateContinueButton\"]")
	public WebElement AddCompletionRecord;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"tabs-4\"]/form/h2")
	public WebElement Header1;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"completionRecordContinue\"]")
	public WebElement ProvideAdditionaldetails;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"tabs-5\"]/form/h2")
	public WebElement Header2;
	
	@FindBy(how=How.ID, using="addDetails")
	public WebElement CommentArea;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"additionalDetailsContinue\"]")
	public WebElement ReviewAndSubmitbutton;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"reviewSubmit\"]")
	public WebElement Submitbutton;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"show_list\"]")
	public WebElement GoToMyCreditRequest;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"new_request\"]")
	public WebElement Submitnewbutton;
	
	@FindBy(how=How.XPATH, using="/html/body/div[5]/div[1]/button/span")
	public WebElement closeicon;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"uploaddocPopUp\"]")
	public WebElement uploadnewdoc;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"fileChange\"]")
	public WebElement chosefile;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"upload-doc\"]")
	public WebElement uppload;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"delegateEmailId\"]")
	public WebElement eneterdelegateemail;

	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"proceedToDelegateBtn\"]")
	public WebElement delebutton;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"sendInvitaionAction\"]")
	public WebElement sendregisinvitae;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"regInviteOk\"]")
	public WebElement okkkkks;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"1496\"]/i")
	public WebElement cancelbutton1;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"auditTablePopulation\"]/div[3]/div/div/button[1]/i")
	public WebElement print1;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"all-reports\"]/div/span/i")
	public WebElement plus;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"auditPopulateTabForm\"]/div/div/div[4]/input[2]")
	public WebElement clearsearch11;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"fixTable-1\"]/tbody/tr[1]/td[7]")
	public WebElement createactioncolumn;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"fixTable-1\"]/thead/tr/th[8]/div")
	public WebElement changebyy;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"tnote\"]")
	public WebElement utctimetext;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"previewCV\"]")
	public WebElement previewabbriviatedcv;
	

	
	@FindBy(how=How.XPATH, using="//*[@id=\"allTaskViewMoreTable\"]/tbody/tr[1]/td[3]/div/a")
	public WebElement completeyouruserprofile;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"taskDetailsPopup_955296\"]/div/ul/li[5]/p/a")
	public WebElement clickheree;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"5294504\"]/a")
	public WebElement docname;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"userTableBody\"]/tr/td[3]/a/i")
	public WebElement removeicon;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"profile-save-button\"]")
	public WebElement save4;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"okbutton\"]")
	public WebElement okkksss;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"taskSummaryDiv\"]/div[3]/p[2]")
	public WebElement duetoday;
	
	

	@FindBy(how=How.XPATH, using="//*[@id=\"taskSummaryDiv\"]/div[3]/p[2]")
	public WebElement primaryfaci;
	

	@FindBy(how=How.XPATH, using="//*[@id=\"taskSummaryDiv\"]/div[3]/p[2]")
	public WebElement facilitynameaddress;
	

	@FindBy(how=How.XPATH, using="//*[@id=\"DEPARTMENTNAME\"]")
	public WebElement departmentnameaddress;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"DEPARTMENTNAME\"]")
	public WebElement actions;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"actionsMain3531\"]/button/i")
	public WebElement action111;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"actionsMain2720\"]/button/i")
	public WebElement action112;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"actionsMain2720\"]/div/ul/li[1]")
	public WebElement adddepartment;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"actionsMain2720\"]/div/ul/li[2]")
	public WebElement exportdepartment;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"actionsMain2720\"]/div/ul/li[3]")
	public WebElement removedepartment;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"actionsMain2720\"]/div/ul/li[4]")
	public WebElement sendmsgtpdpm;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"2720\"]/td[4]/div[1]/a")
	public WebElement viwdepartment;
	
	
	
	@FindBy(how=How.XPATH, using="///*[@id=\"actionsMain1932\"]/div/ul/li[3]")
	public WebElement removefacilitys;
	
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"actionsMain3531\"]/button/i")
	public WebElement action1112;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"actionsMain3531\"]/div/ul/li[3]")
	public WebElement removeept;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"error_removeFaciPopupDivId\"]/div[2]/div/div[3]/button")
	public WebElement okkies;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"allTaskViewMoreTable\"]/tbody/tr[2]/td[3]/div/a")
	public WebElement tasktitle1;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"taskDetailsPopup_1016709\"]/div/ul/li[5]/p/a")
	public WebElement clickhare2;
	
	
	@FindBy(how=How.XPATH, using="	//*[@id=\"1223990\"]/span\r\n")
	public WebElement doc1;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"p_p_id_TCSIPMyProfilePortlet_WAR_TCSIPMyProfilePortlet100_\"]/div/div/div/div[4]/div/div[2]/div[2]/div[1]/button")
	public WebElement askPI;
	
	@FindBy(how=How.ID, using="organization")
	public WebElement PIdropdown;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"SubmitId\"]")
	public WebElement submit;
	
	
	
	@FindBy(how=How.ID, using="IPShippingRecipientName_2")
	public WebElement ADDSHIPPINGLOCATIONTIPRecipientName;
	
	@FindBy(how=How.ID, using="IPShippingRecipientName_3")
	public WebElement ADDSHIPPINGLOCATIONTIPRecipientName3;
	
	
	@FindBy(how=How.ID, using="IPShippingRecipientFax_2")
	public WebElement ADDSHIPPINGLOCATIONTFaxNumber;
	
	@FindBy(how=How.ID, using="IPShippingRecipientFax_3")
	public WebElement ADDSHIPPINGLOCATIONTFaxNumber3;
	
	
	@FindBy(how=How.ID, using="shippingLocStreetName_2")
	public WebElement ADDSHIPPINGLOCATIONTstreetName;
	
	@FindBy(how=How.ID, using="shippingLocStreetName_3")
	public WebElement ADDSHIPPINGLOCATIONTstreetName3;
	
	
	@FindBy(how=How.ID, using="IPShippingRecipientPhone_2")
	public WebElement ADDSHIPPINGLOCATIONPhone;
	
	@FindBy(how=How.ID, using="IPShippingRecipientPhone_3")
	public WebElement ADDSHIPPINGLOCATIONPhon3;
	
	
	@FindBy(how=How.ID, using="shippingLocCountry_2")
	public WebElement ADDSHIPPINGLOCATIONCountry;
	
	@FindBy(how=How.ID, using="shippingLocCountry_3")
	public WebElement ADDSHIPPINGLOCATIONCountry3;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"frmShippingLocation_2\"]/ul/li[5]/div[1]/div/ul/li")
	public List<WebElement> ADDSHIPPINGLOCATIONCountryList;
	
	
	@FindBy(how=How.ID, using="shippingLocState_2")
	public WebElement ADDSHIPPINGLOCATIONState;
	
	@FindBy(how=How.ID, using="shippingLocState_3")
	public WebElement ADDSHIPPINGLOCATIONState3;
	
	@FindBy(how=How.XPATH, using="//button[@Id='addShippingLocBtn']")
	public WebElement ADDSHIPPINGLOCATIONButton;
	
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"frmShippingLocation_2\"]/ul/li[6]/div[1]/div/ul/li")
	public List<WebElement> ADDSHIPPINGLOCATIONStateList;
	
	@FindBy(how=How.ID, using="IPShippingRecipientCity_2")
	public WebElement ADDSHIPPINGLOCATIONCity;
	
	@FindBy(how=How.ID, using="IPShippingRecipientCity_3")
	public WebElement ADDSHIPPINGLOCATIONCity3;
	
	@FindBy(how=How.ID, using="IPShippingRecipientEmail_2")
	public WebElement ADDSHIPPINGLOCATIONEmail;
	
	@FindBy(how=How.ID, using="IPShippingRecipientEmail_3")
	public WebElement ADDSHIPPINGLOCATIONEmail3;
	
	@FindBy(how=How.XPATH, using="(//div[@class='errors_email form-error-msg']//label[1])[2]")
	public WebElement ADDSHIPPINGLOCATIONEmailError;
	
	@FindBy(how=How.XPATH, using="(//div[@class='errors_email form-error-msg']//label[1])[3]")
	public WebElement ADDSHIPPINGLOCATIONEmailError3;
	
	public void updatePhoneNumber() throws Exception 
	{
		properties= obj.getProperty();
		
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);
				
		Map<String,String> testDataInMap = testData.getTestDatainMap();
		String phNumber = testDataInMap.get("update_phone");
		
		
		wait.until(ExpectedConditions.visibilityOf(updatePhone));	
		
		updatePhone.click();
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOf(updatePhonefield));	
		updatePhonefield.clear();
		Thread.sleep(3000);
		
		updatePhonefield.sendKeys(phNumber);
		Thread.sleep(1000);
		
		savebutton.click();
		Thread.sleep(10000);
		
		OKbutton.click();
		Thread.sleep(15000);
		
		String userPhone = userPhNo.getText();
		System.out.println(userPhone);
		
		if (userPhone.contains(phNumber)) {
		
		 System.out.println("Phone Updated");
			
		} else
		{
			System.out.println("Phone Not Updated");
		}
		
		
	}
	
	




public void NavigateAbbrieviatedCV() throws Exception 
{
	Thread.sleep(3000);
	ok.click();
	Thread.sleep(3000);
	Userprofile.click();
	Thread.sleep(3000);
	MyProfile.click();
	Thread.sleep(6000);
	Abbriviatedcvhistory.click();
	Thread.sleep(6000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,1000)");
	Highlightelement("sposor");
	Thread.sleep(3000);
	Highlightelement("logo");
	Thread.sleep(3000);
}






private void Highlightelement(String string) {
	// TODO Auto-generated method stub
	
}





public void Navigateandverify_pullcv() throws Exception 
{
	Thread.sleep(3000);
	Userprofile.click();
	Thread.sleep(3000);
	Pullcv.click();
	Thread.sleep(3000);
	country.click();
	Thread.sleep(3000);
	country.sendKeys("Canada");
	Thread.sleep(3000);
	chechbox.click();
	Thread.sleep(3000);
	close.click();
	Thread.sleep(5000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1000)");
	search.click();
	Thread.sleep(8000);
	Highlightelement("Lname");
	Thread.sleep(3000);
	Highlightelement("Fname");
	Thread.sleep(3000);
	Highlightelement("contry");
	Thread.sleep(3000);
	Highlightelement("state");
	Thread.sleep(3000);
	Highlightelement("lastgeneratecv");
	Thread.sleep(3000);
	Highlightelement("pullcvhistory");
	Thread.sleep(3000);
}







public void Verify_PullCVhistory() throws Exception 
{
	Thread.sleep(3000);
   Highlightelement("pullcvstatus");	
   Thread.sleep(3000);
}

public void Verify_PullCVhistory1() throws Exception 
{
	Thread.sleep(3000);
   Highlightelement("pullcvstatus");	
   Thread.sleep(3000);
   yes.click();
   Thread.sleep(6000);
   Highlightelement("downloadedby");  
   Thread.sleep(3000);
   closebutton.click();
   Thread.sleep(3000);
}


public void Verify_PullCv_table() throws Exception 
{
	Thread.sleep(3000);
	check.click();
	Thread.sleep(3000);
	pullcv.click();
	Thread.sleep(3000);
	Highlightelement("sipuserid");
	Thread.sleep(3000);
	Highlightelement("firstname");
	Thread.sleep(3000);
	Highlightelement("lastname");
	Thread.sleep(3000);
	Highlightelement("cvtitle");
   Thread.sleep(3000);
   Highlightelement("viwcv");
   Thread.sleep(3000);
}







public void Verify_doanload_generatedcv() throws Exception 
{
	Thread.sleep(3000);
	check1.click();
	Thread.sleep(3000);
	downloadcv.click();
	Thread.sleep(7000);
	
}

public void HoverOverUserProfile() throws InterruptedException{
	Actions action=new Actions(driver);
	action.moveToElement(Userprofile).build().perform();
	Thread.sleep(3000);
}

public void Click_On_Edit_PhoneNumber() throws InterruptedException{
	EditPhoneNumber.click();
	Thread.sleep(3000);

try{
	highLightElement(PhoneNumberHeader);
}catch(Exception e){}
	
}

public void UpdatePhoneNumber() throws Exception{
//	+3558789890(orignal number)
	PhoneNumberTextField.clear();
	PhoneNumberTextField.sendKeys("9987685674");
	Thread.sleep(3000);
	PhoneNumberSave.click();
	Thread.sleep(3000);
	
	try{
		PhoneNumberPopOK.click();
		Thread.sleep(6000);
	}catch(Exception e){}
	
}

public void Navigateuserprofile_MyProfile_Validate() throws Exception 
{
	Actions action=new Actions(driver);
	action.moveToElement(Userprofile).build().perform();
	Thread.sleep(3000);
	MyProfile.click();
	Thread.sleep(8000);
	Highlightelement("nameoftheuser");
	Thread.sleep(3000);
	Highlightelement("citystate");
	Thread.sleep(3000);
	Highlightelement("phone");
   Thread.sleep(3000);
   Highlightelement("editicon");
   Thread.sleep(3000);
   Highlightelement("email");
   Thread.sleep(3000);
   Highlightelement("lastmodified");
   Thread.sleep(3000);
	
	
}



public void click_On_Role_Status_DropDown() throws InterruptedException{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//label[text()='Email ID']")));
	Thread.sleep(3000);
	Actions action=new Actions(driver);
	action.moveToElement(RoleDropDown).click().build().perform();
	Thread.sleep(3000);
}

public void SelectAllStatusUnderRoleDrowpDown(){
	AllStatusRoleDropDown.click();
}

public void VerifyRolesInTable()throws Exception{
	List<WebElement> ListOfSponser=driver.findElements(By.xpath("//td[@class='sorting_3']"));
	
	for(int i=0;i<ListOfSponser.size();i++){
		highLightElement(ListOfSponser.get(i));
	}
}

public void VerifyEndDateColumnInTable()throws Exception{
List<WebElement> ListOfEndDatedBy=driver.findElements(By.xpath("//td[@class='sorting_1']/following-sibling::td"));
	
	for(int i=0;i<ListOfEndDatedBy.size();i++){
		highLightElement(ListOfEndDatedBy.get(i));
	}
}

public void VerifyStatusColumnInTable() throws Exception{
List<WebElement> ListOfStatus=driver.findElements(By.xpath("//td[@class='sorting_1']"));
	
	for(int i=0;i<ListOfStatus.size();i++){
		highLightElement(ListOfStatus.get(i));
	}
}

public void ClickCross() throws Exception{
	Thread.sleep(5000);
	Cross.click();
}

public void SelectRoleStatus(String status){
	WebElement RoleStatus=driver.findElement(By.xpath("//label[normalize-space(text())='"+status+"']/preceding-sibling::span"));
	RoleStatus.click();
}



public void CLick_edit_verify_fields() throws Exception 
{
	Thread.sleep(3000);
	editicon.click();
   Thread.sleep(3000);
   Highlightelement("phoneno");
   Thread.sleep(3000);
   Highlightelement("message1");
   Thread.sleep(3000);
   Highlightelement("studydropdow");
   Thread.sleep(3000);
   Highlightelement("savebutto");
   Thread.sleep(3000);
   Highlightelement("cancelbutto");
   Thread.sleep(3000);
	
}

public void Enterphonenumber_save() throws Exception 
{
	Thread.sleep(3000);
	phoneno.clear();
   Thread.sleep(3000);
   phoneno.sendKeys("755778857855");
   Thread.sleep(3000);
}




public void Selectstudydropdownandverify() throws Exception 
{
	Thread.sleep(3000);
	Highlightelement("studydropdow");
   Thread.sleep(3000);
   savebutto.click();
   Thread.sleep(6000);
   Highlightelement("sposor");
   Thread.sleep(3000);
   okbut.click();
   Thread.sleep(3000);
   
}




public void Enterinvalidphonenumber_save() throws Exception 
{
	Thread.sleep(3000);
	phoneno.clear();
   Thread.sleep(3000);
   phoneno.sendKeys("kjhjksdsj");
   Thread.sleep(3000);
   savebutto.click();
   Thread.sleep(6000);
   Highlightelement("validationmsg");
   if(validationmsg.getText().contains("Enter valid characters. Only numeric digits, space, () - + . ext, EXT are allowed."))
   {
       System.out.println("Test pass");
   }
   else
   {
   System.out.println("Test Fail");
      
   }
}



public void closeandverify() throws Exception 
{
	Thread.sleep(3000);
	closebuttons.click();
   Thread.sleep(3000);
   
}



public void Editandverifys() throws Exception 
{
	Thread.sleep(3000);
	editicon.click();
	Thread.sleep(3000);
	closebuttons.click();
	Thread.sleep(3000);   
  
	
}

public void Okandnavigatetobasicdetails() throws Exception 
{
	Thread.sleep(3000);
	
	
	
}

public void Pullcv_countryverifycation() throws Exception 
{
	Thread.sleep(3000);
	Userprofile.click();
	Thread.sleep(3000);
	pullcv.click();
	Thread.sleep(3000);
	countrydropdown.click();
	Thread.sleep(3000);
	
	
	
	
	
}


public void selectcountryandverify() throws Exception 
{

	Thread.sleep(3000);
	countrydropdown.sendKeys("Barbados");
	Thread.sleep(3000);
	chck.click();
	Thread.sleep(3000);
	closed.click();
	Thread.sleep(3000);
	emailid.sendKeys("kr1398967+3@gmail.com");
	Thread.sleep(3000);
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,1000)");
	 Thread.sleep(3000);
	 searchbutton.click();
	 Thread.sleep(8000);
	 Highlightelement("chckbx");
	 Thread.sleep(3000);
	 Highlightelement("lname");
	 Thread.sleep(3000);
	 Highlightelement("fname");
	 Thread.sleep(3000);
	 Highlightelement("county");
	 Thread.sleep(3000);
	 Highlightelement("stat");
	 Thread.sleep(3000);
	 Highlightelement("lastgeneratedcv");
	 Thread.sleep(3000);
	 Highlightelement("cvpulledhistory");
	 Thread.sleep(3000);
	 
	 if(lname.getText().contains("Last Name"))
     {
         System.out.println("Test pass");
     }
     else
     {
     System.out.println("Test Fail");
        
     }
	 if(fname.getText().contains("First Name"))
     {
         System.out.println("Test pass");
     }
     else
     {
     System.out.println("Test Fail");
        
     }
	 
	 if(county.getText().contains("Country"))
     {
         System.out.println("Test pass");
     }
     else
     {
     System.out.println("Test Fail");
        
     }
	 if(stat.getText().contains("State"))
     {
         System.out.println("Test pass");
     }
     else
     {
     System.out.println("Test Fail");
        
     }
	 if(lastgeneratedcv.getText().contains("Last Generated CV Date"))
     {
         System.out.println("Test pass");
     }
     else
     {
     System.out.println("Test Fail");
        
     }
	 if(cvpulledhistory.getText().contains("CV Pulled History"))
     {
         System.out.println("Test pass");
     }
     else
     {
     System.out.println("Test Fail");
        
     }
	 
	 
	 
	 
	
	
}


public void Generatecvbutton() throws Exception 
{
	
	Thread.sleep(3000);
	Generatecv.click();
	Thread.sleep(3000);
	if(reviewvcv.getText().contains("Review CV Prior To Signing"))
    {
        System.out.println("Test pass");
    }
    else
    {
    System.out.println("Test Fail");
       
    }
	if(reviewcvonscreen.getText().contains("Review your Abbreviated CV prior to signing to ensure that the critical information is included."))
    {
        System.out.println("Test pass");
    }
    else
    {
    System.out.println("Test Fail");
       
    }
	if(generateandsigncv.getText().contains("Generate and Sign CV"))
    {
        System.out.println("Test pass");
    }
    else
    {
    System.out.println("Test Fail");
       
    }
	 
	if(cancel.getText().contains("Cancel"))
    {
        System.out.println("Test pass");
    }
    else
    {
    System.out.println("Test Fail");
       
    }
	Thread.sleep(3000);
	 
	
	
	
	
}


public void Userabletoesign() throws Exception 
{
	Thread.sleep(3000);
	generateandsigncv.click();
	Thread.sleep(8000);
	
	
	
	
	
	
}


public void Navigatedtodelegatedprofile() throws Exception 
{
	Thread.sleep(3000);
	Userprofile.click();
	Thread.sleep(5000);
	Delegatedprofile.click();
	Thread.sleep(3000);
	Highlightelement("Siteuser1id");
	Thread.sleep(3000);
	
	
	
	
}


public void Verifysiteuser1details() throws Exception 
{
	Thread.sleep(3000);
	Highlightelement("sipuserids");
	Thread.sleep(3000);
	Highlightelement("firstnam");
	Thread.sleep(3000);
	Highlightelement("lastnam");
	Thread.sleep(3000);
	Highlightelement("delegateeffectfrom");
	Thread.sleep(3000);
	
	if(sipuserids.getText().contains("SIP User ID"))
    {
        System.out.println("Test pass");
    }
    else
    {
    System.out.println("Test Fail");
       
    }
	if(firstnam.getText().contains("First Name"))
    {
        System.out.println("Test pass");
    }
    else
    {
    System.out.println("Test Fail");
       
    }
	
	if(lastnam.getText().contains("Last Name"))
    {
        System.out.println("Test pass");
    }
    else
    {
    System.out.println("Test Fail");
       
    }
	
	if(delegateeffectfrom.getText().contains("Delegate Effective From"))
    {
        System.out.println("Test pass");
    }
    else
    {
    System.out.println("Test Fail");
       
    }
	
	
	
	
	
}



public void Verifybasicdetail() throws Exception 
{
	Thread.sleep(3000);
	
	Siteuser1id.click();
	Thread.sleep(8000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,500)");
	
}


public void Updateprofessionalexpandsendallchangesforapproval() throws Exception 
{
	
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,500)");
	System.out.println("Check");
	Thread.sleep(3000);
	professionalexp.click();
	Thread.sleep(8000);
	add.click();
	Thread.sleep(3000);
	jobtitle.sendKeys("QA Lead");
	Thread.sleep(3000);
	institutation.sendKeys("ABC");
	Thread.sleep(3000);
	yearstarted.sendKeys("2009");
	Thread.sleep(3000);
	completedcheck.click();
	Thread.sleep(3000);
	add1.click();
	Thread.sleep(7000);
	sendallchangedforapproval.click();
	Thread.sleep(3000);
	//okbutt.click();
	Thread.sleep(15000);
	
	
	
	
	
	
}


public void Navigatedtoapproverejectupdate() throws Exception 
{
	Thread.sleep(3000);
	
	Userprofile.click();
	Thread.sleep(8000);
	approvereject.click();
	Thread.sleep(6000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,500)");
	Thread.sleep(6000);
	Highlightelement("clinicalresearchuser");
	Thread.sleep(6000);
	if(clinicalresearchuser.getText().contains("Clinical Research User"))
    {
        System.out.println("Test pass");
    }
    else
    {
    System.out.println("Test Fail");
       
    }
	
	
}


public void Verifysubmenus() throws Exception 
{
	Thread.sleep(3000);
	Userprofile.click();
	Thread.sleep(3000);
	Highlightelement("MyProfile");
	Thread.sleep(3000);
	Highlightelement("pullcv");
	Thread.sleep(3000);
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
     
	
}



public void Navigatetomyprofileandverify() throws Exception 
{
	Thread.sleep(3000);
	Userprofile.click();
	Thread.sleep(3000);
	MyProfile.click();
	Thread.sleep(5000);
	highLightElement(profilephotoplaceholder);
	Thread.sleep(3000);
	highLightElement(summarysection);
	Thread.sleep(3000);
	highLightElement(userprofilesection);
	Thread.sleep(3000);
	highLightElement(Roletable);
	Thread.sleep(3000);
	highLightElement(lastmodified);
	Thread.sleep(3000);
	if(userprofilesection.getText().contains("User Profile"))
    {
        System.out.println("Test pass");
    }
    else
    {
    System.out.println("Test Fail");
       
    }
	Thread.sleep(3000);
	if(Roletable.getText().contains("Role"))
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

public void clickonprofileplaceholderverify() throws Exception 
{
	Thread.sleep(3000);
	profilephotoplaceholder.click();
	Thread.sleep(3000);
	highLightElement(uploadprofilephoto);
	Thread.sleep(3000);
	highLightElement(onscreentext);
	Thread.sleep(3000);
	highLightElement(choosefile);
	Thread.sleep(3000);
	highLightElement(upload);
	Thread.sleep(3000);
	highLightElement(cancel1);
	Thread.sleep(3000);
	if(uploadprofilephoto.getText().contains("Upload Profile Photo"))
    {
        System.out.println("Test pass");
    }
    else
    {
    System.out.println("Test Fail");
       
    }
	Thread.sleep(3000);
	if(onscreentext.getText().contains("Please make sure the photograph is in .jpg, .gif, .png, or .bmp formats. The photograph should not be more than 100W x110H pixels in dimension"))
    {
        System.out.println("Test pass");
    }
    else
    {
    System.out.println("Test Fail");
       
    }
	Thread.sleep(3000);
	if(choosefile.getText().contains("Choose File"))
    {
        System.out.println("Test pass");
    }
    else
    {
    System.out.println("Test Fail");
       
    }
	Thread.sleep(3000);
	if(upload.getText().contains("Upload"))
    {
        System.out.println("Test pass");
    }
    else
    {
    System.out.println("Test Fail");
       
    }
	Thread.sleep(3000);
	if(cancel1.getText().contains("Cancel"))
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


public void selectexceedingimageverify() throws Exception 
{
     
	Thread.sleep(3000);
choosefile.sendKeys("\"C:\\Users\\545325\\Desktop\\big image.png\"");
	Thread.sleep(3000);
	upload.click();
	Thread.sleep(3000);
	
	

		
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
     
	
}

public void selectexceedingimageverify255() throws Exception 
{
     
	Thread.sleep(3000);
choosefile.sendKeys("\"C:\\Users\\545325\\Desktop\\big image.png\"");
	Thread.sleep(3000);
	upload.click();
	Thread.sleep(3000);
	
	

		
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
     
	
}

public void selectexceedingimageverify256() throws Exception 
{
     
	Thread.sleep(3000);
choosefile.sendKeys("\"C:\\Users\\545325\\Desktop\\big image.png\"");
	Thread.sleep(3000);
	upload.click();
	Thread.sleep(3000);
	
	

		
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
     
	
}



public void clickprofileplaceholderandverify() throws Exception 
{
     // choosefile.sendKeys("\"C:\\Users\\545325\\Desktop\\up image\\user_male_portrait.png\"");
	Thread.sleep(3000);
	//upload.click();
	Thread.sleep(3000);
	
	cancel1.click();            
	Thread.sleep(3000);
	// \\remove after getting the proper image
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,850)");
	Thread.sleep(3000);
	
	Thread.sleep(3000);
	highLightElement(sipuserid1);
	Thread.sleep(3000);
	highLightElement(nameprefix);
	Thread.sleep(3000);
	highLightElement(firstnme);
	Thread.sleep(3000);
	highLightElement(middlenme);
	Thread.sleep(3000);
	highLightElement(lastnme);
	Thread.sleep(3000);
	highLightElement(emailidd);
	Thread.sleep(3000);
	highLightElement(roletype);
	Thread.sleep(3000);
	highLightElement(role);
	Thread.sleep(3000);
	highLightElement(countr);
	Thread.sleep(3000);
	highLightElement(studysposor);
	Thread.sleep(3000);
	highLightElement(studyid);
	Thread.sleep(3000);
	highLightElement(studysiteid);
	Thread.sleep(3000);
	highLightElement(startdate);
	Thread.sleep(3000);
	highLightElement(enddate);
	Thread.sleep(3000);
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
     
	
}


public void verifyroleassignedtocro1() throws Exception 
{

	Thread.sleep(3000);
	highLightElement(type1);
	Thread.sleep(3000);
	highLightElement(role1);
	Thread.sleep(3000);

	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
     
	
}

public void verifyshowrowdropdown() throws Exception 
{

	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(3000);

	 Select tabledropdown1 = new Select (tabledropdown);
	 tabledropdown1.selectByVisibleText("10");
	    Thread.sleep(7000);
	    
	    Select tabledropdown2 = new Select (tabledropdown);
		 tabledropdown2.selectByVisibleText("20");
		    Thread.sleep(7000);
		    
		    Select tabledropdown3 = new Select (tabledropdown);
			 tabledropdown3.selectByVisibleText("30");
			    Thread.sleep(7000);
			    
			    Select tabledropdown4 = new Select (tabledropdown);
				 tabledropdown4.selectByVisibleText("40");
				    Thread.sleep(7000);
				    Select tabledropdown5 = new Select (tabledropdown);
					 tabledropdown5.selectByVisibleText("50");
					    Thread.sleep(7000);
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}



public void verifystandardpagination() throws Exception 
{

	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(3000);
	highLightElement(tabledropdown);
	Thread.sleep(3000);
	highLightElement(pagetextbox);
	Thread.sleep(3000);
	highLightElement(next);
	Thread.sleep(3000);
	highLightElement(last);
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}

public void enterpagenumberverify() throws Exception 
{

	Thread.sleep(3000);
	
	pagetextbox.sendKeys("45");
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



public void verifypages() throws Exception 
{

	Thread.sleep(3000);
	highLightElement(first);
	Thread.sleep(3000);
	highLightElement(prev);
	Thread.sleep(3000);
	highLightElement(next);
	Thread.sleep(3000);
	highLightElement(last);
	Thread.sleep(3000);
   
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}



public void Navigatetomyprofileandverifies() throws Exception 
{

	Thread.sleep(3000);
	Userprofile.click();
	Thread.sleep(3000);
	MyProfile.click();
	Thread.sleep(3000);
	delegate.click();
	Thread.sleep(3000);
	orgradio.click();
	Thread.sleep(3000);
	orgradio.isSelected();
	Thread.sleep(3000);
	highLightElement(searchorganization);
	Thread.sleep(3000);
	highLightElement(orgname);
    Thread.sleep(3000);
   
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
}
public void NevigateToMyProfileAndFacilitiesAndVerify() throws InterruptedException{
	Actions action=new Actions(driver);
	action.moveToElement(Userprofile).build().perform();
	Thread.sleep(3000);
	MyProfile.click();
	Thread.sleep(5000);
	Facilities.click();
	Thread.sleep(8000);
	FacilitiesHeader.isDisplayed();
	highLightElement(FacilitiesHeader);
}

public void NevigateToMyProfile() throws Exception{
	Actions action=new Actions(driver);
	action.moveToElement(Userprofile).build().perform();
	Thread.sleep(3000);
	MyProfile.click();
	Thread.sleep(5000);
}

public void Click_On_Edit_Button_To_Update_Name() throws Exception{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,200)");
	edit.click();
	Thread.sleep(3000);
	
	editcontactfname.clear();
	editcontactfname.sendKeys("ReneNew");
	Thread.sleep(1000);
	
	editcontactlname.clear();
	editcontactlname.sendKeys("KasperNew");
	
	Thread.sleep(2000);
}

public void Click_On_Save() throws Exception{
	save.click();
	Thread.sleep(4000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,200)");
}

public void VerifyName() throws Exception{
	highLightElement(VerifyFname);
	highLightElement(VerifyLname);
}

public void HoverOverFacilityActionbtn(String Fc) throws Exception{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,400)");
	Thread.sleep(3000);
	Actions action=new Actions(driver);
	properties=obj.getProperty();
	Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
	testData.setTestDatainMap(TestDataInMap);	
	Map<String,String> testDataInMap = testData.getTestDatainMap();
	
	
	String facilityName=testDataInMap.get(Fc);
	Thread.sleep(3000);
	try{
		if(Fc.equalsIgnoreCase("FacilityName")){
			WebElement ActionBtn=driver.findElement(By.xpath("//td[@class='globalcountry width270']/div/a[text()='"+facilityName+"']//parent::div//parent::td/following-sibling::td[2]/div"));
			action.moveToElement(ActionBtn).build().perform();
			Thread.sleep(3000);
			highLightElement(ActionBtn);
		}
	}catch(Exception e){
		System.out.println("Not FacilityName");
	}
	Thread.sleep(2000);
	try{
		if(Fc.equalsIgnoreCase("Facility+Department")){
			WebElement ActionBtn=driver.findElement(By.xpath("//td[@class='globalcountry width270']/div/a[text()='"+facilityName+"']//parent::div//parent::td/following-sibling::td[1]/div"));
			action.moveToElement(ActionBtn).build().perform();
			Thread.sleep(3000);
			highLightElement(ActionBtn);
		}
	}catch(Exception e){
		System.out.println("Not Facility+Department");
		
	}
	
}

public void ClickOnActionWithFacility(String Fc) throws Exception{
	Actions action=new Actions(driver);
	properties=obj.getProperty();
	Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
	testData.setTestDatainMap(TestDataInMap);	
	Map<String,String> testDataInMap = testData.getTestDatainMap();
	
//	JavascriptExecutor js = (JavascriptExecutor) driver;
//	js.executeScript("window.scrollBy(0,200)");
	
	String facilityName=testDataInMap.get(Fc);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	try{
		if(Fc.equalsIgnoreCase("FacilityName")){
			WebElement ActionBtn=driver.findElement(By.xpath("(//td[@class='globalcountry width270']/div/a[text()='"+facilityName+"']//parent::div//parent::td/following-sibling::td[2]/div)[1]"));
			action.moveToElement(ActionBtn).click().build().perform();
			Thread.sleep(3000);
			highLightElement(ActionBtn);
		}
	}catch(Exception e){
		System.out.println("Not FacilityName");
	}
	Thread.sleep(2000);
	try{
		if(Fc.equalsIgnoreCase("Facility+Department")){
			WebElement ActionBtn=driver.findElement(By.xpath("(//td[@class='globalcountry width270']/div/a[text()='"+facilityName+"']//parent::div//parent::td/following-sibling::td[1]/div)[1]"));
			action.moveToElement(ActionBtn).click().build().perform();
			Thread.sleep(3000);
			highLightElement(ActionBtn);
		}
	}catch(Exception e){
		System.out.println("Not Facility+Department");
		
	}
}

public void AddDepartmentFromAction() throws InterruptedException{
	Thread.sleep(2000);
	AddDepartmentfromAction.click();   //always need to change index of this Xpth depands upon at wich place facility is
	Thread.sleep(3000);
	CreatNewDepartment.click();
	Thread.sleep(8000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,250)");
	DepartmentNameField.sendKeys("Deepee");
	Thread.sleep(4000);
	Select sc=new Select(DepartmentTypeField);
	sc.selectByVisibleText("Infectious Disease");
	js.executeScript("window.scrollBy(0,300)");
	DepartmentSave.click();
	Thread.sleep(5000);
	I_WIL_MAINTAIN_THE_department_PROFILE.click();
	Thread.sleep(5000);
	COUNTINUE_UPDATING_DEPARTMENT.click();
	
}

@FindBy(how=How.XPATH, using="//h1[text()='Add Department(s)']")
public WebElement AddDepartmentHeader;

@FindBy(how=How.XPATH, using="(//th[@colspan='1'])[2]")
public WebElement AddDepartmentName;

@FindBy(how=How.XPATH, using="(//th[@colspan='1'])[7]")
public WebElement AddDepartmentDPMContact;

@FindBy(how=How.XPATH, using="//input[@type='button' and @value='Send Message']")
public WebElement SendMessageDPMContact;

@FindBy(how=How.XPATH, using="//textarea[@id='facilityConsentTextarea1']")
public WebElement WriteMessageDPMContact;

public void AddDepartmentFromActionOnly() throws InterruptedException{
	JavascriptExecutor js = (JavascriptExecutor) driver;
//	js.executeScript("arguments[0].scrollIntoView();", FacilitiesHeader);
	Thread.sleep(2000);
	AddDepartmentfromAction.click();   //always need to change index of this Xpth depands upon at wich place facility is
	Thread.sleep(5000);
	
	AddDepartmentHeader.isDisplayed();
	highLightElement(AddDepartmentHeader);
}



public void Verify_AddDepartment_Page() throws Exception{
	highLightElement(AddDepartmentName);
	highLightElement(AddDepartmentDPMContact);
}

public void Click_on_Contact_DPM_link_of_Department(String Dep) throws Exception{
	WebElement DPMContactLink=driver.findElement(By.xpath("(//td[contains(text(),"+Dep+")])[15]/a"));//variable element
	DPMContactLink.click();
	Thread.sleep(2000);
	
}

public void Click_on_SendMessage() throws Exception{
	SendMessageDPMContact.click();
	Thread.sleep(2000);
	try{
		highLightElement(driver.findElement(By.id("errMsg")));
	}catch(Exception e){
		
	}
}

public void Write_Message() throws Exception{
	Thread.sleep(2000);
	WriteMessageDPMContact.sendKeys("Hi For Affiliations Site User 5");
}

public void Verify_SendMessage_PopUp() throws Exception{
	
	try{
		highLightElement(driver.findElement(By.xpath("//p[text()='Your message has been sent successfully.']")));
		Thread.sleep(2000);
	}catch(Exception e){}
	Thread.sleep(2000);
}

public void ClickOKSendMessage_PopUp() throws Exception{
	driver.findElement(By.xpath("//input[@class='secondary-btn modal-close']")).click();
	Thread.sleep(2000);
}

public void AddExisting_Department(String arg1) throws Exception{
	WebElement ExistingDepartment=driver.findElement(By.xpath("(//td[contains(text(),"+arg1+")])[1]/span"));
	ExistingDepartment.click();
	Thread.sleep(2000);
	AddDepartmentToYourUserProfile.click();
	
}

public void ExportFacilityProfilePDF() throws InterruptedException{
	Thread.sleep(2000);
	ExportfacilityProfilefromAction.click();
	//always need to change index of this Xpth depands upon at wich pplace facility is
	Thread.sleep(4000);
	driver.findElement(By.xpath("(//i[contains(@class,'fa fa-file-pdf-o')])[1]")).click(); //click on pdf
	Thread.sleep(4000);
	ExportBtn.click();
	highLightElement(driver.findElement(By.id("facExportReq")));
	
}

public void ExportDepartmentProfilePDF() throws Exception{
	Thread.sleep(2000);
	ExportDepartmentProfilefromAction.click();
	//always need to change index of this Xpth depands upon at wich pplace facility is
	Thread.sleep(4000);
	driver.findElement(By.xpath("(//a[@title='PDF'])[2]")).click(); //click on pdf
	Thread.sleep(4000);
	ExportBtnDep.click();
	highLightElement(driver.findElement(By.id("facExportReq")));
}

public void ExportFacilityProfileDOC() throws InterruptedException{
	Thread.sleep(2000);
	ExportfacilityProfilefromAction.click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("//i[contains(@class,'fa fa-file-word-o')]")).click(); //click on DocWord
	Thread.sleep(4000);
	ExportBtn.click();
	highLightElement(driver.findElement(By.id("facExportReq")));
}

public void ClickOnExportOK() throws InterruptedException{
	Thread.sleep(8000);
	ExportOK.click();
	Thread.sleep(4000);
}

public void ClickOnExportDepOK() throws Exception{
	Thread.sleep(8000);
	ExportOKDep.click();
	Thread.sleep(2000);
}
   public void ClickAdoptProfileAndVerify() throws Exception{
	   properties=obj.getProperty();
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);	
		Map<String,String> testDataInMap = testData.getTestDatainMap();
		String facility=testDataInMap.get("FacilityName");
		Thread.sleep(3000);
	   
	   AdoptFacilityBtn.click();
	   Thread.sleep(5000);
	   WebElement AdoptCheckbox=driver.findElement(By.xpath("//td[@class='sorting_1']/a[text()='"+facility+"']//parent::td/preceding-sibling::td/label"));
	   AdoptCheckbox.click();
	   Thread.sleep(5000);
	   driver.findElement(By.xpath("//button[@title='ADOPT PROFILE']")).click();
	   Thread.sleep(5000);
	   highLightElement(driver.findElement(By.xpath("(//h1[text()='Adoption of existing Profile for Department'])[1]")));
	   Thread.sleep(3000);
	   adoptOK.click();
	   Thread.sleep(3000);
	   JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,0)");
		Thread.sleep(3000);
		bell.click();
		Thread.sleep(3000);
      
   }
   
   public void ClickAdoptFacilityAndDepartment() throws InterruptedException{
	   AdoptFacilityBtn.click();
	   Thread.sleep(5000);
	   highLightElement(driver.findElement(By.xpath("//h2[text()='Adopt Existing Profile']")));
	   highLightElement(driver.findElement(By.xpath("//h2[text()='Adopt Existing Profile']/following-sibling::p")));
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,100)");
	   
   }
   
   public void SelectAdoptfacilityAndClickAdoptprofile(String Fc) throws Exception{
	   properties=obj.getProperty();
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);	
		Map<String,String> testDataInMap = testData.getTestDatainMap();
		String facility=testDataInMap.get(Fc);
	
		Thread.sleep(5000);
		   WebElement AdoptCheckbox=driver.findElement(By.xpath("//td[@class='sorting_1']/a[text()='"+facility+"']//parent::td/preceding-sibling::td/label"));
		   AdoptCheckbox.click();
		   Thread.sleep(5000);
		   driver.findElement(By.xpath("//button[@title='ADOPT PROFILE']")).click();
		   Thread.sleep(5000);
		   highLightElement(driver.findElement(By.xpath("(//h1[text()='Adoption of existing Profile for Department'])[1]")));
		   Thread.sleep(3000);
   }
   
   public void ClickOk() throws InterruptedException{
	   adoptOK.click();
	   Thread.sleep(3000);
   }
   
   
   public void NevigateToConsentTraining() throws InterruptedException{
	  //nevigate to consentTraing
	   driver.findElement(By.xpath("//span[text()='Consent & Training']")).click();
	   Thread.sleep(5000);
	   JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		WebElement Language=driver.findElement(By.xpath("//span[@class='site-sel-container tAsite-sel-container']"));
		Actions action=new Actions(driver);
		action.moveToElement(Language).build().perform();
		
		highLightElement(Language);
		Thread.sleep(5000);
   }
   
   public void NevigateToConsentTrainingOnly() throws InterruptedException{
//	   highLightElement(driver.findElement(By.xpath("//h2[@class='no-margin float-left']")));
	   JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,350)");
	   Thread.sleep(5000);
	   driver.findElement(By.xpath("//span[text()='Consent & Training']")).click();
	   Thread.sleep(5000);
   }
   
   @FindBy(how=How.ID, using="irbDetailsLi")
	public WebElement irb;
   
   @FindBy(how=How.ID, using="facilityContactLi")
  	public WebElement DepartmentContact;
   
   @FindBy(how=How.ID, using="therapeuticAreaDetailsLi")
 	public WebElement TherapeuticAreas;
   
   @FindBy(how=How.ID, using="labDetailsLi")
	public WebElement LocalLab;
   
   @FindBy(how=How.ID, using="equipmentDetailsLi")
	public WebElement DepartmentEquipment;
   
   @FindBy(how=How.ID, using="ipDetailsLi")
	public WebElement InvestigationalProduct;
   
   
   @FindBy(how=How.ID, using="btnShippingLocDelete_1")
  	public WebElement RemoveShippingAddress;
   
   @FindBy(how=How.ID, using="btnShippingLocDelete_2")
 	public WebElement RemoveShippingAddres2;
   
   @FindBy(how=How.ID, using="btnShippingLocDelete_3")
 	public WebElement RemoveShippingAddress3;
   
   @FindBy(how=How.ID, using="btnSaveShippingAddress_1")
	public WebElement SaveShippingAddress;
   
   @FindBy(how=How.ID, using="btnSaveShippingAddress_2")
	public WebElement SaveShippingAddress2;
   
   @FindBy(how=How.ID, using="btnSaveShippingAddress_3")
	public WebElement SaveShippingAddress3;
   
   @FindBy(how=How.XPATH, using="//h2[text()='Investigational Product (IP) & Controlled Substances']")
 	public WebElement InvestigationalProductHeader;
   
   @FindBy(how=How.XPATH, using="//form[@id='IPControlSubDetails']/div[2]/table[1]/tbody[1]/tr[10]/td[1]/div[1]")
	public WebElement IPIndicator;
   
   @FindBy(how=How.ID, using="additionalIPCapabilities")
	public WebElement AdditionalIPCapabilities;
   
   @FindBy(how=How.ID, using="closeAlert")
  	public WebElement CloseAlertForSpecialCharacter;
   
   @FindBy(how=How.ID, using="btnStorageLocSave_1")
  	public WebElement SaveIPStorageLocation;
   
   @FindBy(how=How.XPATH, using="//button[contains(text(),'Investigational Product (IP)')]")
  	public WebElement InvestigationalProductButton;
   
   @FindBy(how=How.ID, using="sourceDocumentLi")
	public WebElement SourceDocumentation;
   
   @FindBy(how=How.ID, using="additionalLocationLi")
  	public WebElement AdditionalLocation;
   
   @FindBy(how=How.ID, using="attachmentDetailsLi")
 	public WebElement AdditionalInformation;
   
   @FindBy(how=How.ID, using="orgAffiliationLi")
	public WebElement OrganizationAffiliations;
   
	@FindBy(how=How.XPATH, using="//*[@id=\"facilityContactLi\"]")
	public WebElement facilitycontact;
   
	
	public void Change_The_Primary_DPM(String email) throws Exception{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//li[text()='Clinical Research Manager is added as the study site staff for the study sites associated to this Facility and its Departments.']")));
		Thread.sleep(3000);
		WebElement PrimaryDPMStar=driver.findElement(By.xpath("//a[text()='"+email+"']/ancestor::td/preceding-sibling::td[2]//span"));
		PrimaryDPMStar.click();
		Thread.sleep(15000);
			js.executeScript("window.scrollBy(0,500)");
	}
	
	public void NevigateTofacilitycontact() throws Exception 
	{



		Thread.sleep(3000);
		facilitycontact.click();
		Thread.sleep(3000);
		





	}

	
   public void NevigateToDepartmentContact() throws InterruptedException{
	   highLightElement(DepartmentContact);
	   Thread.sleep(3000);
	   DepartmentContact.click();
	   Thread.sleep(5000);
   }
   
   
   
   public void NevigateToTherapeuticAreasPatientPopulation() throws InterruptedException{
	   highLightElement(TherapeuticAreas);
	   Thread.sleep(3000);
	   TherapeuticAreas.click();
	   Thread.sleep(8000);
   }
   
   public void NevigateToIRBEthics() throws InterruptedException{
	   JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,150)");
	   highLightElement(irb);
	   Thread.sleep(3000);
	   irb.click();
	   Thread.sleep(8000);
   }
   
   public void ThenVerifyIRBEthics() throws InterruptedException{
	   highLightElement(driver.findElement(By.xpath("//h2[@class='medium-header-h2']")));
	   Thread.sleep(3000);
   }
   public void VerifyConsentTraining() throws InterruptedException{
	   highLightElement(driver.findElement(By.xpath("//h2[@class='no-margin float-left']")));
	   Thread.sleep(3000);
   }
   
   public void NevigateToLocalLab() throws InterruptedException{
	   JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,250)");
	   highLightElement(LocalLab);
	   Thread.sleep(3000);
	   LocalLab.click();
	   Thread.sleep(8000);
   }
   
   public void ClickOnYesUnderLocalLab() throws InterruptedException{
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//input[@id='isFacUseLocalLabYes']")).click();
	   Thread.sleep(2000);
   }
   
public void ScrolldownToClickonButton(){
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0,1500)");
}

public void ScrollUpToClickonButton(){
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0,-1500)");
}

public void ScrolldownForVerify() throws InterruptedException{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0,800)");
	Thread.sleep(2000);
}

public void ScrollUpForVerify() throws InterruptedException{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0,-800)");
	Thread.sleep(2000);
}

public void VerifyvalidationMessage(){
	try{
		WebElement Leavebutton=driver.findElement(By.xpath("(//input[@value='LEAVE'])[3]"));
		WebElement StayButton=driver.findElement(By.xpath("(//input[@value='STAY'])[3]"));
		WebElement ValidationMsg=driver.findElement(By.xpath("(//p[@class='popupFont'])[3]"));
		if(ValidationMsg.isDisplayed()){
			highLightElement(ValidationMsg);
			highLightElement(Leavebutton);
			highLightElement(StayButton);
			System.out.println("Test Pass");
		}
	}catch(Exception e){
		System.out.println("No msg");
	}
}

@FindBy(how=How.XPATH, using="(//i[contains(@class,'fa fa-times')])[3]")
public WebElement Xbutton;

@FindBy(how=How.XPATH, using="(//input[@value='STAY'])[3]")
public WebElement Staybutton;

@FindBy(how=How.XPATH, using="(//input[@value='LEAVE'])[3]")
public WebElement Leavebutton;

public void ClickOnX() throws InterruptedException{
	 Thread.sleep(2000);
	 Xbutton.click();
	 Thread.sleep(2000);
}

public void ClickOnSaty() throws InterruptedException{
	 Thread.sleep(2000);
	 Staybutton.click();
}

public void ClickOnLeave() throws InterruptedException{
	Thread.sleep(2000);
	Leavebutton.click();
}

public void NevigteToIRBEthicsCommitteAndverify() throws InterruptedException{
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[contains(text(),'IRB/ERB/Ethics Committe')]")).click();
	Thread.sleep(2000);
	
	//Verify in future
}

public void NevigateToConsentTraingAndverify() throws InterruptedException{
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollTo(0,1500)");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[contains(text(),'Consent & Trainin')]")).click();
	Thread.sleep(2000);
	//Verify in future
}

public void EnterLocalLabFewMendatoryFields() throws InterruptedException{
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollTo(0,150)");
	Thread.sleep(2000);
	LabName.sendKeys("qwerty");
}

public void EnterLocalLabMendatoryFields() throws InterruptedException{
	Thread.sleep(2000);
	LabName.clear();
	LabName.sendKeys("Lab1");
	Thread.sleep(2000);
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,200)");
	StreetName.sendKeys("BestTown");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@class='pac-container hdpi']//button[1]")).click();
	
	Thread.sleep(2000);
	LoaclLabCountry.sendKeys("Brazil");
	Thread.sleep(2000);
	LoaclLabCountry.sendKeys(Keys.ARROW_DOWN);
	LoaclLabCountry.sendKeys(Keys.ENTER);
	Thread.sleep(6000);
	LoaclLabStates.sendKeys("São Paulo");
	Thread.sleep(2000);
	LoaclLabStates.sendKeys(Keys.ARROW_DOWN);
	LoaclLabStates.sendKeys(Keys.ENTER);
	Thread.sleep(4000);
	LoaclLabCity.sendKeys("Sao Paulo");
	 js.executeScript("window.scrollBy(0,200)");
	Thread.sleep(2000);
	LoaclLabAccredetation.click();
	Thread.sleep(2000);
	js.executeScript("window.scrollBy(0,-200)");
}

   
   public void NevigateToInvestigationalProduct() throws InterruptedException{
	   JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", LocalLab);
	   highLightElement(InvestigationalProduct);
	   Thread.sleep(3000);
	   InvestigationalProduct.click();
	   Thread.sleep(8000);
   }
   
public void Click_On_PlusTcon_To_Verify_Name() throws Exception{
	plusicon1.click();
	Thread.sleep(1000);
	IPRecepientVerify.isDisplayed();
}

public void Click_On_PlusTcon_To_Verify_Details(int n) throws Exception{
	if(n==3){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollTo(0,100)");
		plusicon3.click();
		Thread.sleep(1000);
		
		try{
			
			 js.executeScript("window.scrollBy(0,300)");
			ADDSHIPPINGLOCATIONTIPRecipientName3.isDisplayed();
			highLightElement(ADDSHIPPINGLOCATIONTIPRecipientName3);

			ADDSHIPPINGLOCATIONCountry3.isDisplayed();
			highLightElement(ADDSHIPPINGLOCATIONCountry3);
			
			ADDSHIPPINGLOCATIONCountry3.isDisplayed();
			highLightElement(ADDSHIPPINGLOCATIONCountry3);
			
			ADDSHIPPINGLOCATIONState3.isDisplayed();
			highLightElement(ADDSHIPPINGLOCATIONState3);
			
			ADDSHIPPINGLOCATIONCity3.isDisplayed();
			highLightElement(ADDSHIPPINGLOCATIONCity3);
			
			
			
		}catch(Exception e){}	
	}
	
	else if(n==2){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollTo(0,0)");
		plusicon2.click();
		Thread.sleep(1000);
		
		try{
			 js.executeScript("window.scrollBy(0,300)");
			ADDSHIPPINGLOCATIONTIPRecipientName.isDisplayed();
			highLightElement(ADDSHIPPINGLOCATIONTIPRecipientName);

			ADDSHIPPINGLOCATIONCountry.isDisplayed();
			highLightElement(ADDSHIPPINGLOCATIONCountry);
			
			ADDSHIPPINGLOCATIONCountry.isDisplayed();
			highLightElement(ADDSHIPPINGLOCATIONCountry);
			
			ADDSHIPPINGLOCATIONState.isDisplayed();
			highLightElement(ADDSHIPPINGLOCATIONState);
			
			ADDSHIPPINGLOCATIONCity.isDisplayed();
			highLightElement(ADDSHIPPINGLOCATIONCity);
			
			
			
		}catch(Exception e){}	
	}
	
	else if(n==1){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollTo(0,0)");
		plusicon1.click();
		Thread.sleep(1000);
		
		
	}
	
}
   
   
public void save_Shipping_Address() throws Exception{
	
	try{
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ADDSHIPPINGLOCATIONTIPRecipientName);
		Thread.sleep(3000);
		SaveShippingAddress2.click();
	}catch(Exception e){}
	
	
	
	
	
	try{
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ADDSHIPPINGLOCATIONTIPRecipientName3);
		Thread.sleep(3000);
		SaveShippingAddress3.click();
	}catch(Exception e){}
	
//	
	try{
		highLightElement(driver.findElement(By.xpath("(//h1[text()='Enter Mandatory Fields'])[1]")));
		highLightElement(driver.findElement(By.xpath("//div[@id='modalShippingAddressNotField']/div[2]/div[1]/div[1]/button[1]")));
	}catch(Exception e){}
	
	
	try{
		highLightElement(driver.findElement(By.xpath("//div[@class='modal-controls text-align-center']//button[1]")));
	}catch(Exception e){}
	
}

public void click_OK_for_Shipping_Address_PopUp(){
	
//	Mandatory
	try{
		driver.findElement(By.xpath("//div[@id='modalShippingAddressNotField']/div[2]/div[1]/div[1]/button[1]")).click();
		Thread.sleep(2000);
		highLightElement(InvestigationalProductHeader);
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//h5[text()='Add shipping Location']")));
	}catch(Exception e){
		
	}
	
	
//	Save Succes
	try{
		driver.findElement(By.xpath("//div[@class='modal-controls text-align-center']//button[1]")).click();
		Thread.sleep(2000);
		highLightElement(InvestigationalProductHeader);
		Thread.sleep(2000);
	}catch(Exception e){
		
	}
	
//	Duplicate
	
	try{
		driver.findElement(By.xpath("//div[@id='modalShippingLocDuplicate']/div[2]/div[1]/div[1]/button[1]")).click();
		Thread.sleep(2000);
		highLightElement(InvestigationalProductHeader);
		Thread.sleep(2000);
	}catch(Exception e){
		
	}
}

public void save_Investigational_Product_Storage_Location() throws Exception{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", SaveShippingAddress);
	SaveIPStorageLocation.click();
	highLightElement(driver.findElement(By.xpath("//div[@id='modalStorageAddressNotField']/div[2]/div[1]/div[1]/button[1]")));
	
	
}

public void click_OK_for_Product_Storage_Location_PopUp(){
	try{
		driver.findElement(By.xpath("//div[@id='modalStorageAddressNotField']/div[2]/div[1]/div[1]/button[1]")).click();
		Thread.sleep(2000);
		highLightElement(InvestigationalProductHeader);
	}catch(Exception e){
		
	}
}

public void enter_Invalid_Special_Character_In_Describe_additional_Investigational_Product_Storage_Field(){
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", IPIndicator);
	AdditionalIPCapabilities.sendKeys("@$");
	js.executeScript("arguments[0].scrollIntoView();", DepartmentSave);
	DepartmentSave.click();
}


public void Click_OK_For_Special_Character_PopUp(){

	try {
		CloseAlertForSpecialCharacter.click();
		Thread.sleep(2000);
		highLightElement(InvestigationalProductHeader);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public void ClickOnInvestigationalProduct() throws InterruptedException{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0,1800)");
	Thread.sleep(3000);
	InvestigationalProductButton.click();
}

public void ClickOnFacilityEquipment() throws InterruptedException{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0,1800)");
	Thread.sleep(5000);
	driver.findElement(By.xpath("//button[contains(@title,' Equipment')]")).click();
	
	
}
   public void NevigateToSourceDocumentation() throws InterruptedException{
	   JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,550)");
	   highLightElement(SourceDocumentation);
	   Thread.sleep(3000);
	   SourceDocumentation.click();
	   Thread.sleep(8000);
   }
   
   public void NevigateToAdditionalLocations() throws InterruptedException{
	   JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,550)");
	   highLightElement(AdditionalLocation);
	   Thread.sleep(3000);
	   AdditionalLocation.click();
	   Thread.sleep(8000);
   }
   
   public void NevigateToAdditionalInformation() throws InterruptedException{
	   JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,550)");
	   highLightElement(AdditionalInformation);
	   Thread.sleep(3000);
	   AdditionalInformation.click();
	   Thread.sleep(8000);
   }
   
   public void OrganizationAffiliations() throws InterruptedException{
	   highLightElement(OrganizationAffiliations);
	   Thread.sleep(3000);
	   OrganizationAffiliations.click();
	   Thread.sleep(8000);
   }
   
public void Verify_All_Section_Of_Facility_Department(){
	try{
		Thread.sleep(3000);
		highLightElement(DepartmentContact);
		 highLightElement(TherapeuticAreas);
		highLightElement(irb);
	    highLightElement(driver.findElement(By.xpath("//h2[@class='no-margin float-left']")));
		 highLightElement(LocalLab);
		 highLightElement(DepartmentEquipment);
		highLightElement(InvestigationalProduct);
		highLightElement(SourceDocumentation);
		 highLightElement(AdditionalInformation);
		 highLightElement(AdditionalLocation);
		highLightElement(OrganizationAffiliations);
	}catch(Exception e){}
	
}
   
   public void AnswerAllConsentTrainingQuestion() throws InterruptedException{
 //Consent Answer
	   
	   //Does your Facility have a written SOP/Policy/Procedure for: Informed Consent?
	   driver.findElement(By.xpath("(//input[@name='writtenSOPPolicy'])[2]")).click();
	   Thread.sleep(2000);
	   
       //Does your Facility have a written SOP/Policy/Procedure for: Minor Assent for Pediatric Populations?
	   driver.findElement(By.xpath("(//input[@name='minoAssentPediatricPopulations'])[2]")).click();
	   Thread.sleep(2000);
	   
	   //Does your Facility have a written SOP/Policy/Procedure for: Other Vulnerable Populations?
	   driver.findElement(By.xpath("(//input[@name='otherVulnerablePopulations'])[2]")).click();
	   Thread.sleep(2000);
	   
	   JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
	  
	   
	   //If located in the US, has your Facility used or are you able to use the informed consent short form?
	   driver.findElement(By.xpath("(//input[@name='shortFormConsent'])[2]")).click();
	   Thread.sleep(4000);
	   js.executeScript("window.scrollBy(0,200)");
	   //Training
	   
	   //Does your Facility have a training program for the research staff?
	   driver.findElement(By.xpath("(//input[@name='trainingProgram'])[2]")).click();
	   Thread.sleep(4000);
	   
	   //Does the course content include GCP?
	   driver.findElement(By.xpath("(//input[@name='courseContentGCP'])[2]")).click();
	   Thread.sleep(4000);
	   
	   //Does your Facility use an external program to conduct research training?
	    driver.findElement(By.xpath("(//input[@name='externalProgramToConductResearch'])[2]")).click();
	    Thread.sleep(4000);
	    
	    //Do you have a process or program in place to retrain research staff when a protocol is amended?
	    driver.findElement(By.xpath("(//input[@name='programProvisioned'])[2]")).click();
	    Thread.sleep(4000);
	    
	   //"Does the study staff that prepares IATA for shipping dangerous goods..." is required
	    driver.findElement(By.xpath("//input[@id='consentTrainingRadioBtn101']")).click();
	    Thread.sleep(4000);
   }
   
   public void select3Language() throws InterruptedException{
	   JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,200)");
		 Thread.sleep(2000);
	   //Will your Facility require language translations for consents?
	   driver.findElement(By.xpath("(//input[@name='requireLanguageTranslation'])[1]")).click();
	   Thread.sleep(2000);
	   WebElement Language=driver.findElement(By.xpath("//span[@class='site-sel-container tAsite-sel-container']"));
	   Language.sendKeys("Chinese");
	   Thread.sleep(2000);
	   WebElement checkselected1 = driver
				.findElement(By.xpath("//label[text()='Chinese']/preceding-sibling::span"));
	   checkselected1.click();
	   Thread.sleep(4000);
	   
	   
	   Language.sendKeys("Hindi");
	   Thread.sleep(2000);
	   WebElement checkselected2 = driver
				.findElement(By.xpath("//label[text()='Hindi']/preceding-sibling::span"));
	   checkselected2.click();
	   Thread.sleep(4000);
	   
	   
	   Language.sendKeys("Arabic");
	   Thread.sleep(2000);
	   WebElement checkselected3 = driver
				.findElement(By.xpath("//label[text()='Arabic']/preceding-sibling::span"));
	   checkselected3.click();
	   Thread.sleep(4000);
	   driver.findElement(By.xpath("//i[@class='fa fa-times']")).click();
	   Thread.sleep(4000);
	   Actions action=new Actions(driver);
	   action.moveToElement(Language).build().perform();
	   highLightElement(Language);
   }
   
   public void NevigateToFacilityEquipmentOnly() throws InterruptedException{
	   JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,400)");
	   Thread.sleep(5000);
	   try{
		   driver.findElement(By.xpath("//span[text()='Facility & Equipment']")).click();
		   Thread.sleep(5000);  
	   }catch(Exception e){
		   System.out.println("No facility Section");
	   }
	   
	   try{
		   driver.findElement(By.xpath("//span[text()='Department & Equipment']")).click();
		   Thread.sleep(5000);  
	   }catch(Exception e){
		   System.out.println("No Department Section");
	   }
	   
   }
   
   public void AnswerAllFacilityEquipmentquestion() throws InterruptedException{
 //FACILITY CAPABILITIES
	   
	   //Can your Facility support patient visits on weekends?
	   driver.findElement(By.xpath("(//input[@name='OpenOnWeekEnds'])[1]")).click();
	   Thread.sleep(2000);
	   
	   
	   //Can your Facility support in-patient admissions for research studies?
	   driver.findElement(By.xpath("(//input[@name='AdmitResearchSubjects'])[1]")).click();
	   Thread.sleep(2000);
	   
	   
	   //Does your study staff have sufficient English knowledge to understand communications in English?
	   driver.findElement(By.xpath("(//input[@name='HasEnglishKnowledge'])[1]")).click();
	   Thread.sleep(2000);
	   
	   //Does your Facility have access to translator and translation support for trial conduct (e.g. consent, trial specific instruction)?
	   driver.findElement(By.xpath("(//input[@name='IsTranslationSupportPresent'])[2]")).click();
	   Thread.sleep(2000);
	   
	   
	   //Does the Facility have storage space for Study-Related materials (e.g. Lab Kits, Patient Materials, etc.)?
	   driver.findElement(By.xpath("(//input[@name='StorageSpaceForStudyAvail'])[2]")).click();
	   Thread.sleep(2000);
	   
	   //Does your Facility have the ability to collect and store PK/PD specimens?
	   driver.findElement(By.xpath("(//input[@name='PkpdCapable'])[2]")).click();
	   Thread.sleep(2000);
	   
	   
	   //Does your Facility typically allow the collection of Pharmacogenomic (PGX) samples for research purposes?
	   driver.findElement(By.xpath("(//input[@name='PgxSampleAllowed'])[2]")).click();
	   Thread.sleep(4000);
	   
 //EQUIPMENT
	   JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
		Thread.sleep(4000);
		//Identify the Diagnostic Equipment available at or near the Facility to support Research studies?
		 driver.findElement(By.xpath("(//input[@class='form-checkbox-btn ui-helper-hidden-accessible']/following-sibling::span)[1]")).click();
		   Thread.sleep(4000);
		   js.executeScript("window.scrollBy(0,200)");
		   Thread.sleep(4000);
		   
//GENERAL EQUIPMENT
		   //Does your Facility have an SOP or process that ensures routine calibration and maintenance of general equipment? Examples of general equipment include: scale, pulse oximeter, stadiometer, sphygmomanometer, etc.
		   driver.findElement(By.xpath("(//input[@name='SOPAvailable'])[2]")).click();
		   Thread.sleep(2000);
		   
		   //Does your Facility have the necessary equipment to treat medical emergencies (i.e. code cart)?
		   driver.findElement(By.xpath("(//input[@name='EquipmentForMedicalEmergency'])[2]")).click();
		   Thread.sleep(2000);
		   
		   
		   //Identify the equipment available at the Facility to support Research studies?
		   driver.findElement(By.xpath("//input[@id='identifyEquipCheck1']/following-sibling::span[1]")).click();
		   Thread.sleep(2000);
		   
		   js.executeScript("window.scrollBy(0,400)");
		   
//COMPUTER CAPABILITIES	
		   //Does your Facility have computers which are dedicated to research studies?
		   driver.findElement(By.xpath("(//input[@name='DedicatedComputer'])[2]")).click();
		   Thread.sleep(2000);
		   
		   WebElement ComputerType=driver.findElement(By.xpath("(//span[@class='site-sel-container tAsite-sel-container'])[1]"));
		   WebElement Internet=driver.findElement(By.xpath("(//span[@class='site-sel-container tAsite-sel-container'])[2]"));
		   
		   
		   //What type of computer operating system(s) does your institution use to support studies?
//		   ComputerType.sendKeys("Apple/Mac (OS X Snow Leopard, Mountain Lion, El Capitan, etc.)");
		   ComputerType.click();
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("//label[text()=' Apple/Mac (OS X Snow Leopard, Mountain Lion, El Capitan, etc.)']/preceding-sibling::span")).click();
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("(//i[@class='fa fa-times'])[1]")).click();
		   

   }
   
   public void SelectYesForQuestionPKPD() throws InterruptedException{
	 //Does your Facility have the ability to collect and store PK/PD specimens?
	   driver.findElement(By.xpath("(//input[@name='PkpdCapable'])[1]")).click();
	   Thread.sleep(2000);
   }
   
   public void SelectThreeInternet() throws InterruptedException{
//	   JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,1100)");
	   Thread.sleep(5000);
	   WebElement Internet=driver.findElement(By.xpath("(//span[@class='site-sel-container tAsite-sel-container'])[2]"));
	   System.out.println("Sadiq");
	   //What type of internet access does your Facility have?
	   Internet.click();
//	   Internet.sendKeys("Cable or DSL");
	   Thread.sleep(5000);
	   WebElement checkselected1 = driver
				.findElement(By.xpath("//label[text()=' Cable or DSL']/preceding-sibling::span"));
	   checkselected1.click();
	   Thread.sleep(2000);
	   
//	   Internet.sendKeys("Dial-Up");
	   WebElement checkselected2 = driver
				.findElement(By.xpath("//label[text()=' Dial-Up']/preceding-sibling::span"));
	   checkselected2.click();
	   Thread.sleep(2000);
	   
//       Internet.sendKeys("Wi-Fi");
       WebElement checkselected3 = driver
				.findElement(By.xpath("//label[text()=' Wi-Fi']/preceding-sibling::span"));
	   checkselected3.click();
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("(//i[@class='fa fa-times'])[2]")).click();
	   Thread.sleep(2000);
	   
	   Actions action=new Actions(driver);
		action.moveToElement(Internet).build().perform();
		highLightElement(Internet);
		Thread.sleep(5000);
	     
   }
   
public void VerifySubSectionFacilityCapability() throws Exception{

		
		
		highLightElement(driver.findElement(By.xpath("//h5[text()='FACILITY CAPABILITIES']")));//Header
		
		highLightElement(driver.findElement(By.xpath("(//div[@class='tablewidth'])[2]")));//Q1
		highLightElement(driver.findElement(By.xpath("(//div[@class='tablewidth'])[3]")));//Q2
		highLightElement(driver.findElement(By.xpath("(//div[@class='tablewidth'])[4]")));//Q3
		highLightElement(driver.findElement(By.xpath("(//div[@class='tablewidth'])[5]")));//Q4
		highLightElement(driver.findElement(By.xpath("(//div[@class='tablewidth'])[7]")));//Q5
		highLightElement(driver.findElement(By.xpath("(//div[@class='tablewidth'])[8]")));//Q6
		highLightElement(driver.findElement(By.xpath("//div[text()[normalize-space()='Does your Facility typically allow the collection of Pharmacogenomic (PGX) samples for research purposes?']]")));//Q7
}

public void VerifySubsectionEquipment() throws Exception{
	 JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,500)");
		
		highLightElement(driver.findElement(By.xpath("//h5[text()='EQUIPMENT']")));//Header
		
		
		for(int i=1;i<14;i++){
			highLightElement(driver.findElement(By.xpath("(//td[@class='identifyDiagonosticEquipment3']//div)["+i+"]")));
		}
		
//		highLightElement(driver.findElement(By.xpath("(//td[@class='identifyDiagonosticEquipment3']//div)[1]")));
//		highLightElement(driver.findElement(By.xpath("(//td[@class='identifyDiagonosticEquipment3']//div)[2]")));
//		highLightElement(driver.findElement(By.xpath("(//td[@class='identifyDiagonosticEquipment3']//div)[3]")));
//		highLightElement(driver.findElement(By.xpath("(//td[@class='identifyDiagonosticEquipment3']//div)[4]")));
//		highLightElement(driver.findElement(By.xpath("(//td[@class='identifyDiagonosticEquipment3']//div)[5]")));
//		highLightElement(driver.findElement(By.xpath("(//td[@class='identifyDiagonosticEquipment3']//div)[6]")));
//		highLightElement(driver.findElement(By.xpath("(//td[@class='identifyDiagonosticEquipment3']//div)[7]")));
//		highLightElement(driver.findElement(By.xpath("(//td[@class='identifyDiagonosticEquipment3']//div)[8]")));
//		highLightElement(driver.findElement(By.xpath("(//td[@class='identifyDiagonosticEquipment3']//div)[9]")));
//		highLightElement(driver.findElement(By.xpath("(//td[@class='identifyDiagonosticEquipment3']//div)[10]")));
//		highLightElement(driver.findElement(By.xpath("(//td[@class='identifyDiagonosticEquipment3']//div)[11]")));
//		highLightElement(driver.findElement(By.xpath("(//td[@class='identifyDiagonosticEquipment3']//div)[12]")));
//		highLightElement(driver.findElement(By.xpath("(//td[@class='identifyDiagonosticEquipment3']//div)[13]")));
		
}

public void VerifySubsectionGeneralEquipment() throws InterruptedException{
	 JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,1000)");
		Thread.sleep(5000);
		highLightElement(driver.findElement(By.xpath("//h5[text()='GENERAL EQUIPMENT']")));//Header
		
		highLightElement(driver.findElement(By.xpath("(//td[@class='generalEquipmentCol1']//div)[1]")));
		highLightElement(driver.findElement(By.xpath("(//td[@class='generalEquipmentCol1']//div)[3]")));
		
		try{
			for(int i=1;i<7;i++){
				highLightElement(driver.findElement(By.xpath("(//label[@class='ui-checkbox '])["+i+"]")));
			}	
		}catch(Exception e){}
		
		
}
public void VerifySubsectionComputerCapabilities()throws Exception{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0,1300)");
	
	highLightElement(driver.findElement(By.xpath("//h5[text()='COMPUTER CAPABILITIES']")));//Header
	
	highLightElement(driver.findElement(By.xpath("//div[text()[normalize-space()='Does your Facility have computers which are dedicated to research studies?']]")));
	highLightElement(driver.findElement(By.xpath("//div[@id='facilityEquipmentNext']/div[5]/table[1]/tbody[1]/tr[2]/td[1]/div[1]")));
	highLightElement(driver.findElement(By.xpath("//div[text()[normalize-space()='What type of internet access does your Facility have?']]")));
	highLightElement(driver.findElement(By.xpath("//div[@id='facilityEquipmentNext']/div[5]/table[1]/tbody[1]/tr[6]/td[1]/div[1]")));
	highLightElement(driver.findElement(By.xpath("//div[text()[normalize-space()='Does the Facility have access to local IT support?']]")));
	
}
   
   public void NevigateToFacilityEquipment() throws InterruptedException{
	   //Nevigate to facilitiEquipment
	   driver.findElement(By.xpath("//span[text()='Facility & Equipment']")).click();
	   Thread.sleep(5000);
	   JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,1000)");
		WebElement Internet=driver.findElement(By.xpath("(//span[@class='site-sel-container tAsite-sel-container'])[2]"));
		Actions action=new Actions(driver);
		action.moveToElement(Internet).build().perform();
		highLightElement(Internet);
		Thread.sleep(5000);
   }
   



public void ClickOnFacilityHyperLink(String fc) throws Exception{
	properties=obj.getProperty();
	Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
	testData.setTestDatainMap(TestDataInMap);	
	Map<String,String> testDataInMap = testData.getTestDatainMap();
	String facDep=testDataInMap.get(fc);
	Thread.sleep(3000);
	
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0,550)");
	WebElement Hyperlink=driver.findElement(By.xpath("//td[@class='globalcountry width270']/div/a[text()='"+facDep+"']"));
	highLightElement(Hyperlink);
	Thread.sleep(2000);
	Hyperlink.click();
	Thread.sleep(5000);
	
}

public void Clickhyperlink_as(String arg) throws InterruptedException{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//h2[contains(@class,'instruction-text display-inline-block')]")));
	Thread.sleep(2000);
	WebElement HyperLink=driver.findElement(By.xpath("//a[text()='DS_ORG 1']"));
	HyperLink.click();
	Thread.sleep(10000);
}

public void verify_Affiliation_Status(){
	
	try{
		int i=3;
		while(i<15){
			highLightElement(driver.findElement(By.xpath("(//tr[@role='row']//td)["+i+"]")));
			i=i+5;
		}
	}catch(Exception e){}
	
}

public void HoverOverTheHyperLink(String FD) throws Exception{
	properties=obj.getProperty();
	Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
	testData.setTestDatainMap(TestDataInMap);	
	Map<String,String> testDataInMap = testData.getTestDatainMap();
	String facDep=testDataInMap.get(FD);
	Thread.sleep(3000);
	
	try{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,550)");
		Thread.sleep(3000);
		WebElement Hyperlink=driver.findElement(By.xpath("(//td[@class='globalcountry width270']/div/a[text()='"+facDep+"'])[1]"));
		highLightElement(Hyperlink);
		Thread.sleep(2000);
	}catch(Exception e){
		System.out.println("No such Facility Or Department Present");
	}
	
}

public void ClickOnUploadFacilityProfile() throws InterruptedException{
	Thread.sleep(3000);
	UploadSIPfacilityFormBtn.click();
	Thread.sleep(3000);
	DownLoadSIPfacilityFormBtn.click();
	Thread.sleep(3000);
	try{
		DownloadSIPfacilityOKbtn.click();
		Thread.sleep(8000);
//		UploadSIPfacilityCancelbtn.click();
		
	}catch(Exception e){
		System.out.println("No Ok btn");
	}
	
}

public void SwitchTabAndClickOnOrganizationAffiliations() throws InterruptedException, IOException{
	Thread.sleep(2000);
	 ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
     //switch to new tab
	 WebDriver NewDrivder=driver;
	
     NewDrivder.switchTo().window(newTb.get(1));
     Thread.sleep(3000);
     highLightElement(driver.findElement(By.xpath("//h2[@class='no-margin float-left']")));
     Thread.sleep(3000);
     JavascriptExecutor js = (JavascriptExecutor) driver;
 	js.executeScript("window.scrollTo(0,450)");
 	Thread.sleep(3000);
 	Orgnizationaffiliaton.click();
 	Thread.sleep(5000);
 	highLightElement(OrgnizationaffiliatonHeader);
 	Thread.sleep(5000);
 	js.executeScript("window.scrollTo(0,300)");
 	Thread.sleep(3000);
 	try{
 		WebElement OrganizationActionBtn=driver.findElement(By.xpath("(//i[@class='fa fa-cogs'])[1]"));
 		highLightElement(OrganizationActionBtn);
 	}catch(Exception e){
 		System.out.println("No Organization");
 	}
 	
 	Thread.sleep(3000);
 	//Organizantion Hover is pending
 	
 	NewDrivder.close();
    driver.switchTo().window(newTb.get(0));
    Thread.sleep(3000);
     System.out.println("Page title of parent window: " + driver.getTitle());
     Thread.sleep(3000);

}

public void switchTab() throws InterruptedException{
	Thread.sleep(2000);
	 ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
	 System.out.println(driver.getWindowHandle());
    //switch to new tab
    driver.switchTo().window(newTb.get(1));
    Thread.sleep(2000);
}

public void SwitchToParantTab() throws Exception{
	Thread.sleep(2000);
	 ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
	 Thread.sleep(2000);
	 System.out.println(newTb.get(0));
	 WebDriver newDriver=driver;
	 newDriver.close();
	 driver.switchTo().window(newTb.get(0));
   Thread.sleep(4000);
}


public void SwitchTabAndCloseNewTab() throws InterruptedException{
	Thread.sleep(2000);
	 ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
   //switch to new tab
	   driver.switchTo().window(newTb.get(1));
	   Thread.sleep(2000);
	 WebDriver newDriver=driver;
	 newDriver.close();
	 driver.switchTo().window(newTb.get(0));
   Thread.sleep(4000);
}

public void switchtab_verify_closenewtab() throws Exception{
	Thread.sleep(2000);
	 ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
  //switch to new tab
	   driver.switchTo().window(newTb.get(1));
	   Thread.sleep(4000);
//	   Add methods
	   
	   try{
		   NevigateToDepartmentContact();
		   ScrolldownForVerify();
		   ScrollUpForVerify();
		   AdditionScreenShot("Section1");
	   }catch(Exception e){}
	  
	   
	   try{
		   NevigateTofacilitycontact();
		   ScrolldownForVerify();
		   ScrollUpForVerify();
		   AdditionScreenShot("Section1");
	   }catch(Exception e){}
	   
	   NevigateToTherapeuticAreasPatientPopulation();
	   ScrolldownForVerify();
	   ScrollUpForVerify();
	   AdditionScreenShot("Section2");
	   
	   NevigateToIRBEthics();
	   ScrolldownForVerify();
	   ScrollUpForVerify();
	   AdditionScreenShot("Section3");
	   
	   NevigateToLocalLab();
	   ScrolldownForVerify();
	   ScrollUpForVerify();
	   AdditionScreenShot("Section4");
	   
	   NevigateToConsentTrainingOnly();
	   ScrolldownForVerify();
	   ScrollUpForVerify();
	   AdditionScreenShot("Section5");
	   
	   NevigateToFacilityEquipmentOnly();
	   ScrolldownForVerify();
	   ScrollUpForVerify();
	   AdditionScreenShot("Section6");
	   
	   NevigateToInvestigationalProduct();
	   ScrolldownForVerify();
	   ScrollUpForVerify();
	   AdditionScreenShot("Section7");
	   
	   NevigateToSourceDocumentation();
	   ScrolldownForVerify();
	   ScrollUpForVerify();
	   AdditionScreenShot("Section8");
	   
	   NevigateToAdditionalLocations();
	   ScrolldownForVerify();
	   ScrollUpForVerify();
	   AdditionScreenShot("Section9");
	   
	   NevigateToAdditionalInformation();
	   ScrolldownForVerify();
	   ScrollUpForVerify();
	   AdditionScreenShot("Section10");
	   
	   OrganizationAffiliations();
	   ScrolldownForVerify();
	   ScrollUpForVerify();
	   AdditionScreenShot("Section11");
	   
	   
	   
	   
	 WebDriver newDriver=driver;
	 newDriver.close();
	 driver.switchTo().window(newTb.get(0));
  Thread.sleep(4000);
}

public void clickondepartment(int n){
	WebElement DepatmentName=driver.findElement(By.xpath("//table[@id='departmentResults']/tbody[1]/tr["+n+"]/td[2]/a"));
	DepatmentName.click();
}

public void AdditionScreenShot(String FacDepSection){




TakesScreenshot ts = (TakesScreenshot)driver;
File file = ts.getScreenshotAs(OutputType.FILE);
try {
	FileUtils.copyFile(file,new File ("./ScreenShot_Folder/"+FacDepSection+".png"));
} catch (IOException e) {
	e.printStackTrace();
}
	
	
}

public void Selectsitestaffandverify() throws Exception 
{

	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(4000);
	sitestaffmember.click();
	Thread.sleep(4000);
	highLightElement(delegateemail);
    Thread.sleep(3000);
    highLightElement(delegatebutton);
    Thread.sleep(3000);
   
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}

public void selectorgradioandverify() throws Exception 
{

	orgradio.click();
	Thread.sleep(3000);
	orgradio.isSelected();
	Thread.sleep(3000);
	highLightElement(searchorganization);
	Thread.sleep(3000);
	highLightElement(orgname);
    Thread.sleep(3000);
    highLightElement(delegateusertitle);
    Thread.sleep(3000);
    highLightElement(onscreen);
    Thread.sleep(3000);
    highLightElement(onscreen1);
    Thread.sleep(3000);
    highLightElement(country1);
    Thread.sleep(3000);
    Thread.sleep(3000);
    highLightElement(state1);
    Thread.sleep(3000);
    highLightElement(search1);
    Thread.sleep(3000);
    highLightElement(clearsearch);
    Thread.sleep(3000);
    highLightElement(cancel2);
    Thread.sleep(3000);
    if(onscreen.getText().contains("You can delegate maintenance of your User Profile to any Site Staff Member or to an Organization. You are required to approve/reject any changes made by your delegate. All Organizations that have established Organization Contacts in SIP to support this service are available for selection."))
    {
        System.out.println("Test pass");
    }
    else
    {
    System.out.println("Test Fail");
       
    }
    Thread.sleep(3000);
    
    if(onscreen1.getText().contains("Not finding the Organization you were looking for? Contact Helpdesk to request addition of the Organization."))
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

public void org1andverify() throws Exception 
{

	Thread.sleep(3000);
	orgnaetext.sendKeys("DS_ORG 4");
	
    Thread.sleep(3000);
   
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}



public void selectanyvalueverify() throws Exception 
{

	Thread.sleep(3000);
	clearsearch1.click();
    Thread.sleep(3000);
    orgnaetext.sendKeys("DS_ORG 1");
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
    clearsearch1.click();
    Thread.sleep(5000);
        
    
    
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}

public void clickcancelandverify() throws Exception 
{

	Thread.sleep(3000);
	cancel2.click();
    Thread.sleep(3000);
    JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,500)");
	Thread.sleep(3000);
	if(Basicdetailstitle.getText().contains("Basic Details"))
    {
        System.out.println("Test pass");
    }
    else
    {
    System.out.println("Test Fail");
       
    }
	Thread.sleep(6000);
	
    
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}

public void clickdelegateandverify() throws Exception 
{

	Thread.sleep(3000);
    JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,-1000)");
	Thread.sleep(3000);
	delegate.click();
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(3000);
	orgradio.click();
	Thread.sleep(6000);
	search1.click();
	Thread.sleep(6000);
	highLightElement(blanksearchtext);
	Thread.sleep(6000);
	if(blanksearchtext.getText().contains("Either Organization Name or Country is required to search.\r\n" + 
			""))
    {
        System.out.println("Test pass");
    }
    else
    {
    System.out.println("Test Fail");
       
    }
	Thread.sleep(6000);
	
    
	
	
    
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}



public void selectcountry1andverify() throws Exception 
{
	Thread.sleep(4000);
	countrydrpdwn.sendKeys("India");
	Thread.sleep(4000);
	Robot robot1 = new Robot();  
    Thread.sleep(2000); 
    robot1.keyPress(KeyEvent.VK_DOWN); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_DOWN);
    Thread.sleep(2000); 
    robot1.keyPress(KeyEvent.VK_DOWN); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_DOWN);
    Thread.sleep(2000); 
    robot1.keyPress(KeyEvent.VK_ENTER); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(5000);
    statetdrpdwn.click();
    Thread.sleep(5000);
    all.click();
    Thread.sleep(5000);
    cross.click();
    Thread.sleep(5000);
      
    
	
    
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}



public void entervalidsearchcriteria() throws Exception 
{
	Thread.sleep(4000);
	orgname.sendKeys("DS_ORG 1");
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
    search1.click();
    Thread.sleep(5000);
  
	
    
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}


public void clickonplusiconandverify() throws Exception 
{
	Thread.sleep(4000);
	plusicon.click();
	Thread.sleep(5000);
  highLightElement(orgname);
  Thread.sleep(5000);
    
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}



public void clickonminusiconandverify() throws Exception 
{
	Thread.sleep(4000);
	minusicon.click();
	Thread.sleep(5000);
  highLightElement(Select);
  Thread.sleep(5000);
  highLightElement(organame);
  Thread.sleep(5000);
  highLightElement(address);
  Thread.sleep(5000);
  
  if(Select.getText().contains("Select"))
  {
      System.out.println("Test pass");
  }
  else
  {
  System.out.println("Test Fail");
     
  }
  
  if(organame.getText().contains("Organization Name"))
  {
      System.out.println("Test pass");
  }
  else
  {
  System.out.println("Test Fail");
     
  }
  
  if(address.getText().contains("Adress"))
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

public void organizationnamesortable() throws Exception 
{
	Thread.sleep(4000);
	sort.click();
	Thread.sleep(5000);
    
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}


public void verifybelowdetails() throws Exception 
{
	Thread.sleep(4000);
	highLightElement(onscreen);
	Thread.sleep(5000);
	highLightElement(onscreen1);
	Thread.sleep(5000);
	highLightElement(delegate1);
	Thread.sleep(5000);
	highLightElement(cancel3);
	Thread.sleep(5000);
	
	if(onscreen.getText().contains("You can delegate maintenance of your User Profile to any Site Staff Member or to an Organization. You are required to approve/reject any changes made by your delegate. All Organizations that have established Organization Contacts in SIP to support this service are available for selection."))
	  {
	      System.out.println("Test pass");
	  }
	  else
	  {
	  System.out.println("Test Fail");
	     
	  }

	
	if(onscreen1.getText().contains("Not finding the Organization you were looking for? Contact Helpdesk to request addition of the Organization."))
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


public void verifypagination() throws Exception 
{
	Thread.sleep(4000);
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(4000);
	Select showrow1 = new Select (showrow);
	showrow1.selectByVisibleText("10");
	    
	    Select showrow2 = new Select (showrow);
	    showrow2.selectByVisibleText("20");
		    Thread.sleep(7000);
		    
		    Select showrow3 = new Select (showrow);
		    showrow3.selectByVisibleText("30");
			    Thread.sleep(7000);
			    
			    Select showrow4 = new Select (showrow);
			    showrow4.selectByVisibleText("40");
				    Thread.sleep(7000);
				    Select showrow5 = new Select (showrow);
				    showrow5.selectByVisibleText("50");
					    Thread.sleep(7000);


    
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}





public void Navigatemyprofileandverify() throws Exception 
{
	Thread.sleep(4000);
	Userprofile.click();
	Thread.sleep(3000);
	MyProfile.click();
	Thread.sleep(6000);
	Thread.sleep(6000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,200)");
	Thread.sleep(5000);
	highLightElement(fname1);
	Thread.sleep(5000);
	highLightElement(lname1);
	Thread.sleep(5000);
	highLightElement(mobilecell);
	Thread.sleep(5000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,500)");
	Thread.sleep(5000);
	highLightElement(role2);
	Thread.sleep(5000);
	highLightElement(streetnam);
	Thread.sleep(5000);
	highLightElement(role2);
	Thread.sleep(5000);
	highLightElement(streetnam);
	Thread.sleep(5000);
	highLightElement(zip);
	Thread.sleep(5000);
	highLightElement(country2);
	Thread.sleep(5000);
	highLightElement(state2);
	Thread.sleep(5000);
	highLightElement(city);
	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	js2.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(5000);
	highLightElement(mainday);
	Thread.sleep(5000);
	
	JavascriptExecutor js3 = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,200)");
	
	
    
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}

public void Verifybasicdetails() throws Exception 
{
	Thread.sleep(6000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,200)");
	Thread.sleep(5000);
	highLightElement(title);
	Thread.sleep(5000);
	highLightElement(fname3);
	Thread.sleep(5000);
	highLightElement(mname3);
	Thread.sleep(5000);
	highLightElement(lname3);
	Thread.sleep(5000);
	highLightElement(suffix);
	Thread.sleep(5000);
	highLightElement(initials);
	Thread.sleep(5000);
	highLightElement(mob);
	Thread.sleep(5000);
	highLightElement(email3);
	Thread.sleep(5000);
	
	
	
	
	
    
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}


public void Verifyerrormsgs() throws Exception 
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();",edit);
	

	Thread.sleep(2000);
	edit.click();
	Thread.sleep(5000);
	editcontactfname.clear();
	Thread.sleep(5000);
	editcontactlname.clear();
	Thread.sleep(5000);
	editcontactmob.clear();
	Thread.sleep(5000);
    highLightElement(fnametext);
	Thread.sleep(5000);
	highLightElement(lnametext);
	Thread.sleep(5000);
	highLightElement(mobtext);
	Thread.sleep(5000);
	
	 if(fnametext.getText().contains("First Name is required"))
     {
         System.out.println("Test pass");
     }
     else
     {
     System.out.println("Test Fail");
        
     }
	 
	 if(lnametext.getText().contains("Last Name is required"))
     {
         System.out.println("Test pass");
     }
     else
     {
     System.out.println("Test Fail");
        
     }
	 
	 if(mobtext.getText().contains("Mobile/Cell Phone Contact is required"))
     {
         System.out.println("Test pass");
     }
     else
     {
     System.out.println("Test Fail");
        
     }
	
	Thread.sleep(5000);
	
	
	
	
	
    
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}


public void enterinvaliddataandsave() throws Exception 
{
	Thread.sleep(6000);


editcontactfname.sendKeys("^");
	Thread.sleep(5000);
	editcontactlname.sendKeys("^");
	Thread.sleep(5000);
	
	
	 if(editcontactfname.getText().contains("Only following characters are accepted: a-zA-Z0-9,.# () ?: ; / space ' _-ISO 8859-1, ISO 8859-15 version of UTF-8 character set"))
     {
         System.out.println("Test pass");
     }
     else
     {
     System.out.println("Test Fail");
        
     }
	 
	 if(editcontactlname.getText().contains("Only following characters are accepted: a-zA-Z0-9,.# () ?: ; / space ' _-ISO 8859-1, ISO 8859-15 version of UTF-8 character set"))
     {
         System.out.println("Test pass");
     }
     else
     {
     System.out.println("Test Fail");
        
     }
	 
	
	Thread.sleep(5000);
    save.click();
	Thread.sleep(3000);
	highLightElement(alerttext);
	Thread.sleep(3000);
	ok3.click();
	Thread.sleep(3000);
	
	
	
    
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}


public void enterdatacombinationofalphabet() throws Exception 
{
	
	Thread.sleep(5000);
	editcontactmob.clear();
	Thread.sleep(5000);
	editcontactmob.sendKeys("A653653");
	Thread.sleep(5000);
	save.click();
	Thread.sleep(5000);
	
	 if(mobtext.getText().contains("Enter valid characters. Only numeric digits, space, () - + . ext, EXT are allowed."))
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


public void clickcancels() throws Exception 
{
	
	Thread.sleep(5000);
	
	cancel4.click();
	Thread.sleep(5000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,200)");
	
	 if (basicdetail.getText().contains("Basic Details"))
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

public void Verifyroles() throws Exception 
{
	


	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,500)");
	
	  Thread.sleep(3000);
	  highLightElement(investigator);
	  Thread.sleep(3000);
	  highLightElement(ClinicalResearchUser);
	
	
	
    
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}


public void Enterinvaliddata() throws Exception 
{
	


	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,500)");
	
	  Thread.sleep(3000);
	  jobtit.sendKeys("^");
	  Thread.sleep(3000);
	  

		 if (jobtittext.getText().contains("Only following characters are accepted: a-zA-Z0-9,.# () ?: ; / space ' _-ISO 8859-1, ISO 8859-15 version of UTF-8 character set"))
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


public void Verifyprimarybusinessaddress() throws Exception 
{
	


	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,600)");
	
	  Thread.sleep(3000);
	  Thread.sleep(3000);
	  highLightElement(comp);
	  Thread.sleep(3000);
	  highLightElement(strtnam);
	  Thread.sleep(3000);
	  highLightElement(building);
	  Thread.sleep(3000);
	  highLightElement(additionaladdress);
	  highLightElement(count);
	  Thread.sleep(3000);
	  highLightElement(stt);
	  Thread.sleep(3000);
	  highLightElement(cty);
	  Thread.sleep(3000);
	  highLightElement(zp);
	  Thread.sleep(3000);
	  
    
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}


public void enterinvaliddataandverifyerror() throws Exception 
{
	


	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,600)");
	
	  
	
	Thread.sleep(3000);
	strtnam.clear();
	Thread.sleep(3000);
	strtnam.sendKeys("^");
	Thread.sleep(3000);
	building.clear();
	Thread.sleep(3000);
	building.sendKeys("^");
	Thread.sleep(3000);
	cty.clear();
	Thread.sleep(3000);
	cty.sendKeys("^");
	Thread.sleep(3000);
	zp.clear();
	Thread.sleep(3000);
	zp.sendKeys("^");
	Thread.sleep(3000);
	
	 if (strttext.getText().contains("Only following characters are accepted: a-zA-Z0-9,.# () ?: ; / space ' _-ISO 8859-1, ISO 8859-15 version of UTF-8 character set"))
     {
         System.out.println("Test pass");
     }
     else
     {
     System.out.println("Test Fail");
        
     }
	 Thread.sleep(3000);
	

	 if (buildtext.getText().contains("Only following characters are accepted: a-zA-Z0-9,.# () ?: ; / space ' _-ISO 8859-1, ISO 8859-15 version of UTF-8 character set"))
     {
         System.out.println("Test pass");
     }
     else
     {
     System.out.println("Test Fail");
        
     }
	 Thread.sleep(3000);
	

	 if (ctytext.getText().contains("Only following characters are accepted: a-zA-Z0-9,.# () ?: ; / space ' _-ISO 8859-1, ISO 8859-15 version of UTF-8 character set"))
     {
         System.out.println("Test pass");
     }
     else
     {
     System.out.println("Test Fail");
        
     }
	 Thread.sleep(3000);
	 
	 if (zptext.getText().contains("Only following characters are accepted: a-zA-Z0-9,.# () ?: ; / space ' _-ISO 8859-1, ISO 8859-15 version of UTF-8 character set"))
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



public void Verifyothercontactdetails() throws Exception 
{
	


	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1000)");
	
	  
	
	Thread.sleep(3000);
	highLightElement(mainda);
	  Thread.sleep(3000);
	  highLightElement(eveningph);
	  Thread.sleep(3000);
	  highLightElement(hrsph);
	  Thread.sleep(3000);
	  highLightElement(fax);
	  Thread.sleep(3000);
	  highLightElement(pagenumber);
	  Thread.sleep(3000);
	

	  
    
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}

public void updateallfields() throws Exception 
{
	


	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,200)");
	
	  
	
	Thread.sleep(3000);
	
	basicdetails.click();
	  Thread.sleep(3000);
	

	  
    
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}

public void clickonhome() throws Exception 
{

	Thread.sleep(3000);
	
	  home.click();
	  Thread.sleep(5000);
}




public void enterdatainbasicdetails() throws Exception 
{
	
	basicdetails.click();
    Thread.sleep(3000);
	OKK.click();
    Thread.sleep(3000);
    
    JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,200)");
	Thread.sleep(3000);
    jobtit.clear();
    Thread.sleep(3000);
    jobtit.sendKeys("QA");
    Thread.sleep(3000);
    comp.clear();
    Thread.sleep(3000);
    comp.sendKeys("Google");
    Thread.sleep(3000);
    strtnam.clear();
    Thread.sleep(3000);
    strtnam.sendKeys("Jalan ABC");
    Thread.sleep(3000);
    building.clear();
    Thread.sleep(3000);
    building.sendKeys("Matrix tower");
    Thread.sleep(3000);
    cty.clear();
    Thread.sleep(3000);
    cty.sendKeys("Newcity");
    Thread.sleep(3000);
    zp.clear();
    Thread.sleep(3000);
    zp.sendKeys("67567");	   
    Thread.sleep(3000);   
    JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(3000); 
	savv.click();
	Thread.sleep(3000); 
	okk1.click();
	Thread.sleep(3000);
  
    JavascriptExecutor js2 = (JavascriptExecutor) driver;
	js2.executeScript("window.scrollBy(0,400)");
	Thread.sleep(3000);
	profileattachment.click();
	Thread.sleep(3000);
	
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}

public void Verifytworaio() throws Exception 
{
	
	Thread.sleep(3000);   
    JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,200)");
	
	basicdetails.click();
    Thread.sleep(3000);
    
    highLightElement(investigator);
	  Thread.sleep(3000);
	  highLightElement(ClinicalResearchUser);
	  Thread.sleep(3000);
	  
		
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}




public void Verifydropdownvalue() throws Exception 
{
	
	Thread.sleep(3000);   
	cruradio.click();
	Thread.sleep(3000); 
	highLightElement(newdropdown);
	Thread.sleep(3000);
	  
		
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}


public void Verifydropdownvalues() throws Exception 
{
	
	
	Thread.sleep(3000); 
	  
	Select newdropdown1 = new Select (newdropdown);
	newdropdown1.selectByVisibleText("Budget/Financial Contact");
	    Thread.sleep(7000);
	    
	Select newdropdown2 = new Select (newdropdown);
	 newdropdown2.selectByVisibleText("Laboratory Contact");
		  Thread.sleep(7000);
		    
	Select newdropdown3 = new Select (newdropdown);
	  newdropdown3.selectByVisibleText("Legal Contact");
       Thread.sleep(7000);
			    
   Select newdropdown4 = new Select (newdropdown);
   newdropdown4.selectByVisibleText("National Coordinating Investigator");
	Thread.sleep(7000);
				    
	Select newdropdown5 = new Select (newdropdown);
	 newdropdown5.selectByVisibleText("Nurse");
	 Thread.sleep(7000);
	 
	 Select newdropdown6 = new Select (newdropdown);
	 newdropdown6.selectByVisibleText("Other");
	 Thread.sleep(7000);
	 
	 Select newdropdown7 = new Select (newdropdown);
	newdropdown7.selectByVisibleText("Pharmacy Staff");
	Thread.sleep(7000);
	
	Select newdropdown8 = new Select (newdropdown);
	newdropdown8.selectByVisibleText("Recruitment/Retention Contact");
	    Thread.sleep(7000);
	    
	Select newdropdown9 = new Select (newdropdown);
	 newdropdown9.selectByVisibleText("Regulatory Contact");
		  Thread.sleep(7000);
		    
	Select newdropdown10 = new Select (newdropdown);
	  newdropdown10.selectByVisibleText("Safety Contact");
       Thread.sleep(7000);
			    
   Select newdropdown11 = new Select (newdropdown);
   newdropdown11.selectByVisibleText("Site Administrator");
	Thread.sleep(7000);
				    
	Select newdropdown12 = new Select (newdropdown);
	 newdropdown12.selectByVisibleText("Site Data Manager");
	 Thread.sleep(7000);
	 
	 Select newdropdown13 = new Select (newdropdown);
	 newdropdown13.selectByVisibleText("Study Coordinator");
	 Thread.sleep(7000);
	 							    
							    

		
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}



public void Verifyfacilitysection() throws Exception 
{
	
	
	Thread.sleep(3000); 
	Facilities.click();
	Thread.sleep(7000);
	highLightElement(onscrn1);
    Thread.sleep(3000);
    highLightElement(onscrn3);
    Thread.sleep(3000);
    highLightElement(onscrn4);
    Thread.sleep(3000);
	
	 							    
							    

		
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}

public void Verifybasics() throws Exception 
{
	
	
	Thread.sleep(3000); 
	basicdetails.click();
    Thread.sleep(3000);
    highLightElement(roles);
    Thread.sleep(3000);
    highLightElement(subroles);
    Thread.sleep(3000);
    
    
	
	 							    
							    

		
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}

public void selectrolesave() throws Exception 
{
	
	Thread.sleep(3000);   
    JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,200)");
	Thread.sleep(3000);
	Select newdropdown1 = new Select (newdropdown);
	newdropdown1.selectByVisibleText("Budget/Financial Contact");
	    Thread.sleep(7000);
	    
	    JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
	    savv.click();
	    Thread.sleep(3000);
	    highLightElement(okb);
	    Thread.sleep(3000);
    
    
	
	 							    
							  
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}

public void clickokandverifysubrole() throws Exception 
{
	
	Thread.sleep(3000);   
	okb.click();
	Thread.sleep(3000);
    
    
	
	 							    
							  
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}


public void Navigateandverifytouserprofileabbriviatedcv() throws Exception 
{
	
	Thread.sleep(3000);  
	Userprofile.click();
	Thread.sleep(3000);
	MyProfile.click();
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,250)");
	Thread.sleep(3000);
	Abbriviatedcvhistory.click();
	Thread.sleep(3000);
	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	js2.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(3000);
	Highlightelement("ID");
	Thread.sleep(3000);
	Highlightelement("logo");
	Thread.sleep(3000);
	Highlightelement("word");
	Thread.sleep(3000);
	Highlightelement("pdf");
	Thread.sleep(3000);
	word.click();
	Thread.sleep(5000);
	pdf.click();
	Thread.sleep(5000);
	
    
    
	
	 							    
							  
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}




public void Navigateandverifypullcv() throws Exception 
{
	
	Thread.sleep(3000);  
	Userprofile.click();
	Thread.sleep(3000);
	pullcv.click();
	Thread.sleep(3000);
	countryy.click();
	Thread.sleep(3000);
	afganistan.click();
	Thread.sleep(3000);
	cross1.click();
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,200)");
	fnames.sendKeys("Haze");
	Thread.sleep(3000);
	lanames.sendKeys("Markrem");
	Thread.sleep(3000);
	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	js2.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(3000);
	search11.click();
	Thread.sleep(3000);
	Highlightelement("lname2");
	Thread.sleep(3000);
	Highlightelement("fname2");
	Thread.sleep(3000);
	Highlightelement("countr2");
	Thread.sleep(3000);
	Highlightelement("stat2");
	Thread.sleep(3000);
	Highlightelement("lastgenerated");
	Thread.sleep(3000);
	Highlightelement("cvpulledhisto");
	Thread.sleep(3000);
	
	
	 							    
							  
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}


public void Verifypullcvhistoryno() throws Exception 
{
	
	Thread.sleep(3000);  
	Highlightelement("no");
	
	
    
    
	
	 							    
							  
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}



public void Verifycheckboxpullcv() throws Exception 
{
	
	Thread.sleep(3000);  
	checkbox11.click();
	Thread.sleep(3000);
	Highlightelement("lname2");
	Thread.sleep(3000);
	Highlightelement("fname2");
	Thread.sleep(3000);
	Highlightelement("countr2");
	Thread.sleep(3000);
	Highlightelement("stat2");
	Thread.sleep(3000);
	Highlightelement("lastgenerated");
	Thread.sleep(3000);
	Highlightelement("cvpulledhisto");
	Thread.sleep(3000);
	
    
    
	
	 							    
							  
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}


public void Verifydownloadgeneratedcv() throws Exception 
{
	
	Thread.sleep(3000);  
	pullcvbutton.click();
	Thread.sleep(6000); 
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,800)");
	listcheck.click();
	Thread.sleep(3000);
	downloadcvs.click();
	Thread.sleep(6000);
	 							    
							  
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}


public void clickok() throws Exception 
{
	
	Thread.sleep(3000);  
	okkk.click();
	Thread.sleep(2000); 
	 							    
							  
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}


public void Navigateandverifytouserprofileabbriviatedcv1() throws Exception 
{
	
	Thread.sleep(3000);  
	Userprofile.click();
	Thread.sleep(3000);
	MyProfile.click();
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,250)");
	Thread.sleep(3000);
	Abbriviatedcvhistory.click();
	Thread.sleep(3000);
	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	js2.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(3000);
	Highlightelement("ID");
	Thread.sleep(3000);
	Highlightelement("logo");
	Thread.sleep(3000);
	
	 							    
							  
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}





public void verifypullhistory() throws Exception 
{
	
	Thread.sleep(3000);  
	yess.click();
	Thread.sleep(3000);
	Highlightelement("mcname");
	Thread.sleep(3000);
	cosebutt.click();
	Thread.sleep(3000);
	
	 							    
							  
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}


public void NavigateandverifyMyorganization() throws Exception 
{
	
	Thread.sleep(3000);  
	
	
	Thread.sleep(3000);
	organization.click();
	Thread.sleep(3000);
	Myorg.click();
	Thread.sleep(3000);
	org1.click();
	Thread.sleep(3000);
	Highlightelement("orgcontact");
	Thread.sleep(3000);
	 							    
							  
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}



public void clickandverifyorganizationcontact() throws Exception 
{
	
	Thread.sleep(3000);  
	
	
	Thread.sleep(3000);
	orgcontact.click();
	Thread.sleep(3000);
	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	js2.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(3000);
	Highlightelement("siteuser1");
	Thread.sleep(3000);
	
	
	 							    
							  
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}


public void verifyorganizationcontactintable() throws Exception 
{
	
	Thread.sleep(3000);  
	Highlightelement("siteuser2");
	Thread.sleep(3000);
	Highlightelement("rolesite2");
	Thread.sleep(3000);
	
	
	 							    
							  
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}



public void clickandverifyremoveicon() throws Exception 
{
	
	Thread.sleep(3000);  
	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	js2.executeScript("window.scrollBy(0,500)");
	Thread.sleep(3000);
	closebut.click();
	Thread.sleep(3000);
	Highlightelement("popupmsg");
	Thread.sleep(3000);
	Highlightelement("onscree");
	Thread.sleep(3000);
	Highlightelement("confirm");
	Thread.sleep(3000);
	Highlightelement("cancell");
	Thread.sleep(3000);
	
	
	 							    
							  
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}



public void clickandverifyokbutton() throws Exception 
{
	
	Thread.sleep(3000);  
	confirm.click();
	Thread.sleep(3000);
	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	js2.executeScript("window.scrollBy(0,200)");
	Highlightelement("organizationcontacttable");
	Thread.sleep(3000);
	 							    
							  
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}



public void verifyroleintable() throws Exception 
{
	
	Thread.sleep(3000); 
	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	js2.executeScript("window.scrollBy(0,500)");
	

	Highlightelement("siteuser2");
	Thread.sleep(3000);
	Highlightelement("rolesite2");
	Thread.sleep(3000);
	 							    
							  
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    
     
	
}



public void Navigatetopublicationpresentation() throws InterruptedException {
	Userprofile.click();
	Thread.sleep(3000);
	MyProfile.click();
	Thread.sleep(3000);
	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	js2.executeScript("window.scrollBy(0,500)");
	Thread.sleep(3000);
	publicationpresentation.click();
	Thread.sleep(5000);
	
							  
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}


public void verifyaddrecordpublication() throws InterruptedException, AWTException {
	Thread.sleep(3000);
	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	js2.executeScript("window.scrollBy(0,800)");
	Thread.sleep(3000);
	addpublication.click();
	Thread.sleep(3000);
	
	journalcitation.sendKeys("Journal1");
	Thread.sleep(3000);
	datepublish.click();
	Thread.sleep(3000);
	
	Robot robot4 = new Robot();  
    Thread.sleep(2000); 
    robot4.keyPress(KeyEvent.VK_DOWN); 	
    Thread.sleep(2000);  
    robot4.keyRelease(KeyEvent.VK_DOWN);
    Thread.sleep(2000);  
    robot4.keyPress(KeyEvent.VK_ENTER); 	
    Thread.sleep(2000);  
    robot4.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(5000);
    Add.click();
    Thread.sleep(5000);
	
							  
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}


public void verifyerrormsg1() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	js2.executeScript("window.scrollBy(0,800)");
	Thread.sleep(3000);
	addpublication.click();
	Thread.sleep(3000);
	
	journalcitation.sendKeys("Journal1");
	Thread.sleep(3000);
	datepublish.click();
	Thread.sleep(3000);
	
	Robot robot4 = new Robot();  
    Thread.sleep(2000); 
    robot4.keyPress(KeyEvent.VK_DOWN); 	
    Thread.sleep(2000);  
    robot4.keyRelease(KeyEvent.VK_DOWN);
    Thread.sleep(2000);  
    robot4.keyPress(KeyEvent.VK_ENTER); 	
    Thread.sleep(2000);  
    robot4.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(5000);
    Add.click();
    Thread.sleep(5000);
    Highlightelement("errormsg1");
    Thread.sleep(5000);
    Highlightelement("okbutton");
    Thread.sleep(5000);
    
    
    
    
    
	
	
							  
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}



public void verifypublicationpopup() throws InterruptedException {
	
	Thread.sleep(3000);
	okbutton.click();
	Thread.sleep(3000);
	
    
    
    
    
    
	
	
							  
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}



public void presentationsubsection() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	crossbutton.click();
	Thread.sleep(3000);
	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	js2.executeScript("window.scrollBy(0,800)");
	Thread.sleep(3000);
	presentationadd.click();
	Thread.sleep(3000);
	presentationtitle.sendKeys("Presentation Title");
	Thread.sleep(3000);
	location2.sendKeys("London");
	Thread.sleep(3000);
	date.click();
	Thread.sleep(3000);
	Robot robot5 = new Robot();  
    Thread.sleep(2000); 
    robot5.keyPress(KeyEvent.VK_DOWN); 	
    Thread.sleep(2000);  
    robot5.keyRelease(KeyEvent.VK_DOWN);
    Thread.sleep(2000);  
    robot5.keyPress(KeyEvent.VK_ENTER); 	
    Thread.sleep(2000);  
    robot5.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(5000);
    add2.click();
    Thread.sleep(5000);
    
    
    
    
	
	
							  
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}




public void verifyerrormsg2() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	crossbutton.click();
	Thread.sleep(3000);
	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	js2.executeScript("window.scrollBy(0,800)");
	Thread.sleep(3000);
	presentationadd.click();
	Thread.sleep(3000);
	presentationtitle.sendKeys("Presentation Title");
	Thread.sleep(3000);
	location2.sendKeys("London");
	Thread.sleep(3000);
	date.click();
	Thread.sleep(3000);
	Robot robot5 = new Robot();  
    Thread.sleep(2000); 
    robot5.keyPress(KeyEvent.VK_DOWN); 	
    Thread.sleep(2000);  
    robot5.keyRelease(KeyEvent.VK_DOWN);
    Thread.sleep(2000);  
    robot5.keyPress(KeyEvent.VK_ENTER); 	
    Thread.sleep(2000);  
    robot5.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(5000);
    add2.click();
    Thread.sleep(5000);
    Highlightelement("errosg2");
    Thread.sleep(5000);
    Highlightelement("ok1");
    Thread.sleep(5000);
    
    
    
	
	
							  
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}


public void verifypresentationpopup() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	ok1.click();
	Thread.sleep(3000);
	close1.click();
	Thread.sleep(3000);
    
    
	
	
							  
	TakesScreenshot webdriver = null;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}


public void Verifyprofessionalexpsection() throws InterruptedException {
	
	
	
	Thread.sleep(3000);
	Userprofile.click();
	Thread.sleep(3000);
	MyProfile.click();
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,500)");
	professionalexp.click();
	Thread.sleep(3000);
	Highlightelement("onscreenprofessional");
	Thread.sleep(3000);
	
	if(onscreenprofessional.getText().contains("Provide your current and previous relevant positions including academic appointments or check not applicable"))
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



public void Verifyaddprofessionalexp() throws InterruptedException {
	
	
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,500)");
	Thread.sleep(3000);
	
	add11.click();
	Thread.sleep(3000);
	Highlightelement("jobtitle1");
	Thread.sleep(3000);
	Highlightelement("Institution");
	Thread.sleep(3000);
	Highlightelement("yearstart");
	Thread.sleep(3000);
	Highlightelement("year");
	Thread.sleep(3000);
	Highlightelement("Add1");
	Thread.sleep(3000);
	Highlightelement("cancel11");
	Thread.sleep(3000);
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}


public void Verifyclickingcurrentposition() throws InterruptedException {
	
	
	

	
	
	Thread.sleep(3000);
	jobtitle12.sendKeys("Test Lead");
	Thread.sleep(3000);
	institution12.sendKeys("ABC");
	Thread.sleep(3000);
	yearstarted12.sendKeys("2009");
	Thread.sleep(3000);
	checkbox.click();
	Thread.sleep(3000);
	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}


public void verifyperviousenterdrecord() throws InterruptedException {
	
	
	

	
	
	Thread.sleep(3000);
	Add1.click();
	Thread.sleep(5000);
	
	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}



public void verifyyearcompletedfielddisplayed() throws InterruptedException {
	
	
	

	
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,500)");
	Thread.sleep(3000);
	Highlightelement("present");
	Thread.sleep(5000);
	
	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}



public void Verifyprofessionalsectioncompleted() throws InterruptedException {
	
	
	

	
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,500)");
	Thread.sleep(3000);
	okk.click();
	Thread.sleep(5000);
	
	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
}


public void verifyrecord2() throws InterruptedException {
	
	
	

	
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,500)");
	Thread.sleep(3000);
	Add1.click();
	Thread.sleep(5000);
	
	Thread.sleep(3000);
	jobtitle11.sendKeys("Test Lead1");
	Thread.sleep(3000);
	institution11.sendKeys("ABC1");
	Thread.sleep(3000);
	yearstarted11.sendKeys("2010");
	Thread.sleep(3000);
	checkbox.click();
	Thread.sleep(3000);
	Add1.click();
	Thread.sleep(3000);
	okk.click();
	Thread.sleep(3000);
	
	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}




public void verifyyearcompletedblank() throws InterruptedException {
	
	
	

	
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,500)");
	Thread.sleep(3000);
	Highlightelement("present");
	Thread.sleep(3000);
	Highlightelement("remove");
	Thread.sleep(3000);
	
	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}



public void verifyprofessionscreenwitheditandremove() throws InterruptedException {
	
	
	

	
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,500)");
	Thread.sleep(3000);
	Add1.click();
	Thread.sleep(5000);
	
	Thread.sleep(3000);
	jobtitle11.sendKeys("Test Lead2");
	Thread.sleep(3000);
	institution11.sendKeys("ABC2");
	Thread.sleep(3000);
	yearstarted11.sendKeys("2011");
	Thread.sleep(3000);
	checkbox.click();
	Thread.sleep(3000);
	Add1.click();
	Thread.sleep(3000);
	okk.click();
	Thread.sleep(3000);
	
	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}




public void verifyrecord3() throws InterruptedException {
	
	
	

	
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,500)");
	Thread.sleep(3000);
	Highlightelement("present");
	Thread.sleep(3000);
	Highlightelement("remove");
	Thread.sleep(3000);
	
	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}




public void verifyresearchexp() throws InterruptedException {
	
	
	

	
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,500)");
	Thread.sleep(3000);
	researchexp.click();
	Thread.sleep(3000);
	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	js2.executeScript("window.scrollBy(0,500)");
	Thread.sleep(3000);
	professionallife.click();
	Thread.sleep(3000);
	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}




public void verifyeditremoveicons() throws InterruptedException {
	
	
	

	
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,500)");
	Thread.sleep(3000);
	Highlightelement("remove");
	Thread.sleep(3000);
	Highlightelement("edit1");
	Thread.sleep(3000);
	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}





public void clickonmytaskandverify() throws InterruptedException {
	
	
	
	Thread.sleep(3000);
	home.click();
	Thread.sleep(3000);
	Mytask.click();
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,800)");
	Thread.sleep(3000);
	received.click();
	Thread.sleep(3000);
	Highlightelement("tasktype");
	Thread.sleep(3000);
	Highlightelement("tasktitle");
	Thread.sleep(3000);
	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}

public void clickonmytaskSiteUser() throws InterruptedException{
	Mytask.click();
	Thread.sleep(5000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,800)");
	Thread.sleep(5000);
	highLightElement(FacilityProfileDownloadLink);
}

public void ClickTheLinkForDownload() throws InterruptedException{
	
	try{
		Thread.sleep(5000);
		FacilityProfileDownloadLink.click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Click here")).click();// click on 
		Thread.sleep(8000);
		driver.findElement(By.xpath("//span[contains(@class,'ui-button-icon-primary ui-icon-closethick')]")).click();
		Thread.sleep(5000);
	}catch(Exception e){
		
	}
	
}




public void verifysendforapprovalenable() throws InterruptedException {
	
	
	

	JavascriptExecutor js6 = (JavascriptExecutor) driver;
	js6.executeScript("window.scrollBy(0,800)");
	Thread.sleep(3000);
	tasktitle.click();
	Thread.sleep(3000);
	clickhere.click();
	Thread.sleep(6000);
	JavascriptExecutor js7 = (JavascriptExecutor) driver;
	js7.executeScript("window.scrollBy(0,500)");
	Thread.sleep(3000);
	education.click();
	Thread.sleep(3000);
	edit2.click();
	Thread.sleep(3000);
	yearcomplet.sendKeys("2020");
	Thread.sleep(3000);
	save2.click();
	Thread.sleep(5000);
	professionalexp.click();
	Thread.sleep(3000);
	editprofess.click();
	Thread.sleep(3000);
	yrcompleted.click();
	Thread.sleep(3000);
	save3.click();
	Thread.sleep(3000);
	JavascriptExecutor js8 = (JavascriptExecutor) driver;
	js8.executeScript("window.scrollBy(0,800)");
	Thread.sleep(3000);
	Highlightelement("submitforapproval");
	Thread.sleep(3000);
	
	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}

public void ClickOnSendAllChangesForApprovelButton() throws InterruptedException{
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollTo(0,550)");
	Thread.sleep(4000);
	driver.findElement(By.id("allChangesForApprovalBtnId")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("//div[@id='allchangesForApproval']/div[2]/div[1]/div[1]/input[1]")).click();
}




public void verifyredirecttotodelegatedprofile() throws InterruptedException {
	
	
	


	Thread.sleep(3000);
	submitforapproval.click();
	Thread.sleep(3000);
	okbutto.click();
	Thread.sleep(3000);
	
	
	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}

public void clickonmytaskandverify1() throws InterruptedException {
	
	
	

	
	Thread.sleep(3000);
	Mytask.click();
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,800)");
	Thread.sleep(3000);
	received.click();
	Thread.sleep(3000);
	Highlightelement("tasktype");
	Thread.sleep(3000);
	Highlightelement("tasktitle");
	Thread.sleep(3000);
	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}






public void verifyapproverejectbuttons() throws InterruptedException {
	
	
	

	
	Thread.sleep(3000);
	Userprofile.click();
	Thread.sleep(3000);
	approverejectbutt.click();
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,600)");
	
	Thread.sleep(3000);
	Highlightelement("approveall");
	Thread.sleep(3000);
	Highlightelement("rejectall");
	Thread.sleep(3000);
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}





public void verifynavigateeachsections() throws InterruptedException {
	
	
	

	
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,600)");
	Thread.sleep(3000);
	education1.click();
	Thread.sleep(3000);
	Approvethischange.click();
	Thread.sleep(3000);
	ok11.click();
	Thread.sleep(3000);
	professionalexp1.click();
	Thread.sleep(3000);
	Approvethischange1.click();
	Thread.sleep(3000);
	ok11.click();
	Thread.sleep(3000);
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}



public void profiledelegationtaskstill() throws InterruptedException {
	
	Thread.sleep(3000);
	Mytask.click();
	Thread.sleep(3000);
	
	
	

	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}








public void verifyuserprofilemenu() throws InterruptedException {
	
	Thread.sleep(3000);
	Userprofile.click();
	Thread.sleep(3000);
	Highlightelement("MyProfile");
	Thread.sleep(3000);
	Highlightelement("Delegatedprofile1");
	Thread.sleep(3000);
	Highlightelement("approveupdate");
	Thread.sleep(3000);
	
	

	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}






public void verifyprofilesummary() throws InterruptedException {
	
	Thread.sleep(3000);
	Userprofile.click();
	Thread.sleep(3000);
	MyProfile.click();
	Thread.sleep(3000);
	Highlightelement("profilesummary");
	Thread.sleep(3000);
	
	
	

	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}




public void verifymentionedtab() throws InterruptedException {
	
	
	Thread.sleep(3000);
	Highlightelement("userprofiletab");
	Thread.sleep(3000);
	Highlightelement("abbriviatedcvtab");
	Thread.sleep(3000);
	Highlightelement("exporteduserprofiletab");
	Thread.sleep(3000);
	

	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}





public void verifyfollowingattribute() throws InterruptedException {
	
	
	Thread.sleep(3000);
	Highlightelement("placeholder");
	Thread.sleep(3000);
	Highlightelement("siteuser");
	Thread.sleep(3000);
	Highlightelement("citystates");
	Thread.sleep(3000);
	Highlightelement("phone1");
	Thread.sleep(3000);
	Highlightelement("email1");
	Thread.sleep(3000);
	Highlightelement("lastmodiefied");
	Thread.sleep(3000);
	Highlightelement("profileform");
	Thread.sleep(3000);
	Highlightelement("addpitostudy");
	Thread.sleep(3000);
	Highlightelement("delegatebutton");
	Thread.sleep(3000);
	

	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}



public void verifyprofilephoto() throws InterruptedException {
	
	
	Thread.sleep(3000);
	placeholder.click();
	Thread.sleep(3000);
	Highlightelement("choosefile1");
	Thread.sleep(3000);
	Highlightelement("upload1");
	Thread.sleep(3000);
	Highlightelement("cancel5");
	Thread.sleep(3000);
	

	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}




public void verifyuserprofilesummarysection() throws InterruptedException {
	
	
	Thread.sleep(3000);
	cancel5.click();;
	Thread.sleep(3000);
	Highlightelement("profilesummary");
	Thread.sleep(3000);

	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}



public void verifyerrormsg12() throws InterruptedException {
	
	
	Thread.sleep(3000);
	placeholder.click();
	Thread.sleep(3000);
 choosefile1.sendKeys("\"C:\\Users\\545325\\Desktop\\file_example_MP4_480_1_5MG.mp4\"");
	Thread.sleep(3000);
	upload1.click();
	Thread.sleep(3000);
	Highlightelement("errormsg111");
	Thread.sleep(3000);
	
	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}









public void uploadimage() throws InterruptedException {
	
	
	Thread.sleep(3000);
	 choosefile1.sendKeys("\"C:\\Users\\545325\\Desktop\\user_male_portrait.png\"");
		Thread.sleep(3000);
		upload1.click();
		Thread.sleep(7000);
		
	
	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}





public void verifysipuserprofile() throws InterruptedException {
	
	
	Thread.sleep(3000);
	Userprofile.click();
    Thread.sleep(3000);
	MyProfile.click();
	Thread.sleep(3000);
	Highlightelement("profileform");
	Thread.sleep(3000);
	
		
	
	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}



public void Verifysuccessulmsg() throws InterruptedException {
	
	
	Thread.sleep(3000);
	profileform.click();
    Thread.sleep(3000);
    choosefile2.sendKeys("\"C:\\Users\\545325\\Desktop\\SIP User Profile Form (16).pdf\"");
    Thread.sleep(3000);
    upload2.click();
    Thread.sleep(8000);
    ok4.click();
    Thread.sleep(5000);
	
	
		
	
	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}



public void verifyupdates() throws InterruptedException {
	
	
	Thread.sleep(3000);
	
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,500)");
	Thread.sleep(3000);
	gcp.click();
	Thread.sleep(5000);
	license.click();
	Thread.sleep(5000);
	
		
	
	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}



public void Verifynonotification() throws InterruptedException {
	
	
	Thread.sleep(3000);
	home.click();
	Thread.sleep(3000);
	ok.click();
	Thread.sleep(3000);
	bell.click();
	Thread.sleep(3000);
	
	
		
	
	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}




public void verifytablenorecord() throws InterruptedException {
	
	
	Thread.sleep(3000);
	Userprofile.click();
	Thread.sleep(3000);
	MyProfile.click();
	Thread.sleep(3000);
	exporteduserprofile.click();
	Thread.sleep(3000);
	Highlightelement("norecord");
	Thread.sleep(3000);
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}

	


public void verifyexportprofile() throws InterruptedException {
	
	
	Thread.sleep(3000);
	Userprofile.click();
	Thread.sleep(3000);
	MyProfile.click();
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,500)");
	Thread.sleep(3000);
	Highlightelement("exportuserprofile");
	Thread.sleep(3000);
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}

	


public void clickandverifyexportprofile() throws InterruptedException {
	
	
	Thread.sleep(3000);
	exportuserprofile.click();
	Thread.sleep(5000);
	Highlightelement("exportuserprofilebutton");
	Thread.sleep(3000);
	Highlightelement("exportonscreen");
	Thread.sleep(3000);
	Highlightelement("closebotton");
	Thread.sleep(3000);
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}

	



public void clickexport() throws InterruptedException {
	
	
	Thread.sleep(3000);
	exportuserprofilebutton.click();
	Thread.sleep(3000);
	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}

	




public void verifyeducationsectiondisplayed() throws InterruptedException {
	
	
	Thread.sleep(3000);
	Userprofile.click();
	Thread.sleep(3000);
	MyProfile.click();
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,500)");
	Thread.sleep(3000);
	education.click();
	Thread.sleep(3000);
	Highlightelement("educationtitle");
	Thread.sleep(3000);
	
	
	
	
	
	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
}

	

public void verifyfacilitysection() throws InterruptedException {
	
	Thread.sleep(3000);
	Facilities.click();
	Thread.sleep(3000);
	
	
	
	
	
	
	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
	
}

	

public void verifysearchfacilityscreen() throws InterruptedException {
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,800)");
	Thread.sleep(3000);
	addfacilitty.click();
	Thread.sleep(3000);
	Thread.sleep(3000);
	Highlightelement("country11");
	Thread.sleep(3000);
	Highlightelement("state11");
	Thread.sleep(3000);
	Highlightelement("city11");
	Thread.sleep(3000);
	Highlightelement("facility11");
	Thread.sleep(3000);
	Highlightelement("sipfacility11");
	Thread.sleep(3000);
	
	
	
	
	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
	
}

	


public void verifysearchresult() throws InterruptedException, AWTException {
	
	country11.click();
	Thread.sleep(3000);
	Robot robot2 = new Robot();  
    Thread.sleep(2000); 
    robot2.keyPress(KeyEvent.VK_DOWN); 	
    Thread.sleep(2000);  
    robot2.keyRelease(KeyEvent.VK_DOWN);
    Thread.sleep(2000);  
    robot2.keyPress(KeyEvent.VK_DOWN); 	
    Thread.sleep(2000);  
    robot2.keyRelease(KeyEvent.VK_DOWN);
    Thread.sleep(2000);  
    robot2.keyPress(KeyEvent.VK_ENTER); 	
    Thread.sleep(2000);  
    robot2.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(5000);
    facility11.sendKeys("Queens Village Primary Medical Center");
	Thread.sleep(3000);
	seach11.click();
	Thread.sleep(3000);
	
	
	
	
	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
	
}

	


public void verifymarkedascompleted() throws InterruptedException, AWTException {
	
	
	
	Thread.sleep(3000);
	radiobutt.click();
	Thread.sleep(3000);
	addfacilitytouserprofile.click();
	Thread.sleep(3000);
	Nodepartment.click();
	Thread.sleep(5000);
	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
	
}

	



public void verifybasicdetailsection() throws InterruptedException, AWTException {
	
	
	
	//Thread.sleep(3000);
	//radiobutt.click();
	Thread.sleep(3000);
	//addfacilitytouserprofile.click();
	Thread.sleep(3000);
	//Nodepartment.click();
	//Thread.sleep(5000);
	basicdetailss.click();
	Thread.sleep(5000);
	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
	
}

	




public void  verifygeneratecv() throws InterruptedException, AWTException {
	
	
	
	Thread.sleep(3000);
	Userprofile.click();
	
	Thread.sleep(3000);
	MyProfile.click();
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,500)");
	Thread.sleep(3000);
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
	
}

	

public void  verifyleftpanelincomplete() throws InterruptedException, AWTException {
	
	
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,250)");
	Thread.sleep(3000);
	education.click();
	Thread.sleep(6000);
	professionalexp.click();
	Thread.sleep(6000);
	researchexp.click();
	Thread.sleep(6000);
	gcp.click();
	Thread.sleep(6000);
	license.click();
	
	
	
	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
	
}

	


public void  verifyfacilitymentionedfields() throws InterruptedException, AWTException {
	
	
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,250)");
	Thread.sleep(3000);
	Facilities.click();
	Thread.sleep(6000);
	Highlightelement("displayoncv");
	Thread.sleep(3000);
	Highlightelement("primaryfacility");
	Thread.sleep(3000);
	Highlightelement("facitynameaddress");
	Thread.sleep(3000);
	Highlightelement("departmentname");
	Thread.sleep(3000);
	Highlightelement("action");
	Thread.sleep(3000);
	
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
	
}

	


public void  verifyeducationdetails() throws InterruptedException, AWTException {
	
	
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,250)");
	Thread.sleep(3000);
	education.click();
	Thread.sleep(3000);
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
	
}

	



public void  verifynotapplicableineducation() throws InterruptedException, AWTException {
	
	
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,250)");
	Thread.sleep(3000);
	Highlightelement("notapplicable");
	Thread.sleep(3000);
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
	
}

	




public void  verifynotapplicableinmedical() throws InterruptedException, AWTException {
	
	
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,250)");
	notapplicable.click();
	Thread.sleep(3000);
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
	
}

	


public void  verifynotapplicableprofessionalexp() throws InterruptedException, AWTException {
	
	
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	professionalexp.click();
	js1.executeScript("window.scrollBy(0,250)");
	Thread.sleep(3000);
	Highlightelement("notapplicable");
	Thread.sleep(3000);
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
	
}



public void  verifyresearchexp1() throws InterruptedException, AWTException {
	
	
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	professionalexp.click();
	js1.executeScript("window.scrollBy(0,250)");
	Thread.sleep(3000);
	Highlightelement("notapplicable");
	Thread.sleep(3000);
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
	
}

	
public void  verifynotdisappear() throws InterruptedException, AWTException {
	
	
	
	Thread.sleep(3000);
	
	Thread.sleep(3000);
	
	
	  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
	
	
}



public void  verifyresearchgreentick() throws InterruptedException, AWTException {



Thread.sleep(3000);
researchexp.click();
Thread.sleep(3000);


  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);



}


public void  verifygcpgreentick() throws InterruptedException, AWTException {



JavascriptExecutor js1 = (JavascriptExecutor) driver;
js1.executeScript("window.scrollBy(0,800)");
Thread.sleep(3000);
gcp.click();
Thread.sleep(3000);
Highlightelement("courseprovider");
Thread.sleep(3000);
Highlightelement("coursetitle");
Thread.sleep(3000);
Highlightelement("datecompleted");
Thread.sleep(3000);
Highlightelement("expirationdate");
Thread.sleep(3000);
Highlightelement("status1");
Thread.sleep(3000);
Highlightelement("trainingcertificate");
Thread.sleep(3000);



  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);



}


public void  verifyliceseddetails() throws InterruptedException, AWTException {



Thread.sleep(3000);
license.click();
Thread.sleep(3000);


  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);



}



public void  verifylicesedetailspopup() throws InterruptedException, AWTException {



	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,800)");
Thread.sleep(3000);
license.click();
Thread.sleep(7000);
save11.click();
Thread.sleep(3000);
okkkk.click();
Thread.sleep(3000);


  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);



}


public void  verifygeneratecvenable() throws InterruptedException, AWTException {



	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,700)");
Thread.sleep(3000);
Highlightelement("generatecv");
Thread.sleep(3000);


  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);



}




public void  verifyprofileattchement() throws InterruptedException, AWTException {



	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,1000)");
Thread.sleep(3000);

profileattachments.click();
Thread.sleep(3000);


  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);



}



public void  verifypublicationpresentation() throws InterruptedException, AWTException {



	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,1000)");
Thread.sleep(3000);

publication.click();
Thread.sleep(3000);


  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);



}


public void  verifypreviewcvnotdisplayed() throws InterruptedException, AWTException {



	
Thread.sleep(3000);
mytask.click();
Thread.sleep(3000);
JavascriptExecutor js1 = (JavascriptExecutor) driver;
js1.executeScript("window.scrollBy(0,1000)");
Thread.sleep(3000);
delagteclick.click();
Thread.sleep(3000);
clickhere1.click();
Thread.sleep(6000);
JavascriptExecutor js2 = (JavascriptExecutor) driver;
js2.executeScript("window.scrollBy(0,500)");
Thread.sleep(3000);
  
TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);



}

public void  Navigateanderfyfacility() throws InterruptedException, AWTException {



	
Thread.sleep(3000);
JavascriptExecutor js2 = (JavascriptExecutor) driver;
js2.executeScript("window.scrollBy(0,200)");
Thread.sleep(3000);
Facilities.click();
Thread.sleep(3000);


TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);



}



public void  Navigateandverifyeducation() throws InterruptedException, AWTException {



	
Thread.sleep(3000);
JavascriptExecutor js2 = (JavascriptExecutor) driver;
js2.executeScript("window.scrollBy(0,200)");
Thread.sleep(3000);
education.click();
Thread.sleep(3000);


TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);



}


public void  Navigateandverifyprofessional() throws InterruptedException, AWTException {



	
Thread.sleep(3000);
JavascriptExecutor js2 = (JavascriptExecutor) driver;
js2.executeScript("window.scrollBy(0,200)");
Thread.sleep(3000);
professionalexp.click();
Thread.sleep(3000);


TakesScreenshot webdriver = null;
TakesScreenshot scrShot =((TakesScreenshot)webdriver);



}



public void Navigateandverifyreseach1() throws InterruptedException {
	
	Thread.sleep(3000);
	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	js2.executeScript("window.scrollBy(0,200)");
	Thread.sleep(3000);
	researchexp.click();
	Thread.sleep(3000);



	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);


	
}


public void Addlicenseanddenforapproval() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	js2.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(3000);
	researchexp.click();
	Thread.sleep(3000);
	editbutton.click();
	Thread.sleep(3000);
	licesetype.click();
	Thread.sleep(3000);
	Robot robot4 = new Robot();  
    Thread.sleep(2000); 
    robot4.keyPress(KeyEvent.VK_DOWN); 	
    Thread.sleep(2000);  
    robot4.keyRelease(KeyEvent.VK_DOWN);
    Thread.sleep(2000);  
    robot4.keyPress(KeyEvent.VK_ENTER); 	
    Thread.sleep(2000);  
    robot4.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(5000);
    savee.click();
    Thread.sleep(5000);
    
    JavascriptExecutor js3 = (JavascriptExecutor) driver;
	js3.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(5000);
	sendallaproval.click();
	Thread.sleep(5000);

	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);


	
}




public void navigatetoapprovereject() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	Userprofile.click();
	Thread.sleep(3000);
	approvereject.click();
	Thread.sleep(3000);
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);


	
}


public void Verifyapproverejectfields() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	Facilities.click();
	Thread.sleep(3000);
	education.click();
	Thread.sleep(3000);
	professionalexp.click();
	Thread.sleep(3000);
	researchexp.click();
	Thread.sleep(3000);
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);


	
}



public void approveall() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	approveall.click();
	Thread.sleep(3000);
	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);


	
}


public void verifyfacilitysectionn() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	Userprofile.click();
	Thread.sleep(3000);
	MyProfile.click();
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,200)");
	Facilities.click();
	Thread.sleep(3000);
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);


	
}


public void verifyfacilities() throws InterruptedException {
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,600)");
	Thread.sleep(3000);
	Highlightelement("fac1");
	Thread.sleep(3000);
	Highlightelement("fac2");
	Thread.sleep(3000);
	Highlightelement("dept1");
	Thread.sleep(3000);
	

	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}



public void verifyprimaryfacility() throws InterruptedException {
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,700)");
	Thread.sleep(3000);
	primaryfac.click();
	Thread.sleep(3000);
	

	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}



public void verifyfacility1primary() throws InterruptedException {
	
	Thread.sleep(3000);
	Userprofile.click();
	Thread.sleep(3000);
	MyProfile.click();
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,200)");
	Facilities.click();
	Thread.sleep(3000);
	

	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifyfacility2primary() throws InterruptedException {
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,700)");
	primaryfac2.click();
	Thread.sleep(3000);
	

	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifynotabletodisassoiate() throws InterruptedException {
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,800)");
	action1.click();
	Thread.sleep(3000);
	removefacility.click();
	Thread.sleep(3000);
	

	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verfiynotabletodisassociatefac2() throws InterruptedException {
	
	Thread.sleep(3000);
	okbuttonn.click();
	Thread.sleep(3000);
	

	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void Navigatetomyprofileverifynotapplicable() throws InterruptedException {
	
	Thread.sleep(3000);
	Userprofile.click();
	Thread.sleep(3000);
	MyProfile.click();
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,500)");
	Thread.sleep(3000);
	researchexp.click();
	Thread.sleep(3000);
	Highlightelement("notapplicable1");
	Thread.sleep(3000);
	

	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}



public void verifypopup1mentionedfields() throws InterruptedException {
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,500)");
	Thread.sleep(3000);
	add3.click();
	Thread.sleep(3000);
	Highlightelement("thereaputicarea");
	Thread.sleep(3000);
	Highlightelement("subtheraputicarea");
	Thread.sleep(3000);
	Highlightelement("noofcompletedstudy");
	Thread.sleep(3000);
	Highlightelement("noofongoingstudy");
	Thread.sleep(3000);
	Highlightelement("add4");
	Thread.sleep(3000);
	Highlightelement("cancel6");
	Thread.sleep(3000);
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifyresearchexpsection() throws InterruptedException {
	
	Thread.sleep(3000);
	cancel6.click();
	Thread.sleep(3000);
	Highlightelement("thereaputicarea");

	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}

public void verifyRecord1addedintototalclinicalexp() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(3000);
	add3.click();
	Thread.sleep(3000);
	thereaputicareatext.click();
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
    subtheraputicareatext.click();
    Robot robot3 = new Robot();  
    Thread.sleep(2000); 
    robot3.keyPress(KeyEvent.VK_DOWN); 	
    Thread.sleep(2000);  
    robot3.keyRelease(KeyEvent.VK_DOWN);
    Thread.sleep(2000);  
    robot3.keyPress(KeyEvent.VK_ENTER); 	
    Thread.sleep(2000);  
    robot3.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(5000);
    noofcompletedstudytext.sendKeys("554");
    Thread.sleep(5000);
    noofongoingstudytext.sendKeys("224");
    Thread.sleep(5000);
    add4.click();
    Thread.sleep(5000);
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifymsg1withokbutton() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(3000);
	saveee.click();
	Thread.sleep(3000);
	okkkkkk.click();
	Thread.sleep(3000);
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifyrecord2clinicalresearchexp() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(3000);
	add3.click();
	Thread.sleep(3000);
	thereaputicareatext.click();
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
    subtheraputicareatext.click();
    Robot robot3 = new Robot();  
    Thread.sleep(2000); 
    robot3.keyPress(KeyEvent.VK_DOWN); 	
    Thread.sleep(2000);  
    robot3.keyRelease(KeyEvent.VK_DOWN);
    Thread.sleep(2000);  
    robot3.keyPress(KeyEvent.VK_ENTER); 	
    Thread.sleep(2000);  
    robot3.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(5000);
    noofcompletedstudytext.sendKeys("77575");
    Thread.sleep(5000);
    noofongoingstudytext.sendKeys("1122");
    Thread.sleep(5000);
    add4.click();
    Thread.sleep(5000);

	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}



public void verifytotalclinicalresearchexp() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(3000);
	professionalexppp.click();
	Thread.sleep(5000);
	researchexpp.click();
	Thread.sleep(5000);
	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	js2.executeScript("window.scrollBy(0,1000)");
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifypopupsaveandcancel() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(3000);
	edittt.click();
	Thread.sleep(3000);
	Highlightelement("add4");
	Thread.sleep(3000);
	Highlightelement("cancel6");
	Thread.sleep(3000);
	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}



public void verifymsg1withokbutton1() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(3000);
	edittt.click();
	Thread.sleep(3000);
	thereaputicareatext.click();
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
    subtheraputicareatext.click();
    Robot robot3 = new Robot();  
    Thread.sleep(2000); 
    robot3.keyPress(KeyEvent.VK_DOWN); 	
    Thread.sleep(2000);  
    robot3.keyRelease(KeyEvent.VK_DOWN);
    Thread.sleep(2000);  
    robot3.keyPress(KeyEvent.VK_ENTER); 	
    Thread.sleep(2000);  
    robot3.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(5000);
    noofcompletedstudytext.sendKeys("55444");
    Thread.sleep(5000);
    noofongoingstudytext.sendKeys("98888");
    Thread.sleep(5000);
    add4.click();
    Thread.sleep(5000);
    saveee.click();
	Thread.sleep(3000);
	okkkkkk.click();
	Thread.sleep(3000);
	

	
	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}




public void verifyrecord2totalclinalexp() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(3000);
	Thread.sleep(5000);
    saveee.click();
	Thread.sleep(3000);
	okkkkkk.click();
	Thread.sleep(3000);
	
	
	

	
	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifyreord2removed() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(3000);
    saveee.click();
	Thread.sleep(3000);
	okkkkkk.click();
	Thread.sleep(3000);
	removedata.click();
	Thread.sleep(3000);
	
	
	

	
	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}





public void verifymessage2withokbutton() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(3000);
    saveee.click();
	Thread.sleep(3000);
	okkkkkk.click();
	Thread.sleep(3000);
	
	
	
	

	
	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void navigatetogcp() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(3000);
	gcptraining.click();
	Thread.sleep(7000);
	
	
	
	
	

	
	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifybasicdetailssection() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	Userprofile.click();
    Thread.sleep(7000);
	MyProfile.click();
	Thread.sleep(7000);
	Highlightelement("Basicdetailstitle");
	Thread.sleep(7000);
	
	
	
	

	
	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}





public void navigateandverifyeachsection() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	education.click();
	Thread.sleep(3000);
	professionalexp1.click();
	Thread.sleep(3000);
	researchexpp.click();
	Thread.sleep(3000);
	
	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}

public void verifybasicdetailsupdate() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	basicdetail.click();
    Thread.sleep(3000);
	
	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}



public void verifyoverwritten() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	Facilities.click();
    Thread.sleep(3000);
    gcp.click();
    Thread.sleep(3000);
    license.click();
    Thread.sleep(3000);
    profileattachments.click();
    Thread.sleep(3000);
	
	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifypublicationpresentationoverwritten() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	Highlightelement("publicationpresentation");
	Thread.sleep(3000);
	
	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifysiteuser1delattetosite2() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	delegate.click();
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(3000);
	delegateemail1.sendKeys("meera1@yopmail.com");
	Thread.sleep(3000);
	delegatebutton111.click();
	Thread.sleep(5000);
	okkkkkkk.click();
	Thread.sleep(3000);
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void navigatetodelegatedprofiles() throws InterruptedException, AWTException {
	Actions action=new Actions(driver);
	Thread.sleep(3000);
	action.moveToElement(Userprofile).build().perform();
//	Userprofile.click();
	Thread.sleep(3000);
	Delegatedprofile1.click();
	Thread.sleep(3000);
	highLightElement(siteuser1s);


}

public void NevigateToApproveRejectUpdates() throws InterruptedException{
	Actions action=new Actions(driver);
	Thread.sleep(3000);
	action.moveToElement(Userprofile).build().perform();
	Thread.sleep(3000);
	approveupdate.click();
	
}
public void ClickOnSiteUserHyperlink() throws InterruptedException{
	Thread.sleep(5000);
	siteuser1s.click();
	Thread.sleep(7000);
	
}



public void navigatedtositeuser1() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	Userprofile.click();
	Thread.sleep(3000);
	Delegatedprofile1.click();;
	Thread.sleep(5000);
	siteuser1s.click();
	Thread.sleep(7000);
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void Licensedetail() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,500)");
	Thread.sleep(3000);
	license.click();
	Thread.sleep(5000);
	editlicense.click();
	Thread.sleep(3000);
	lisenseissuer.clear();
	Thread.sleep(3000);
	lisenseissuer.sendKeys("L58585858");
	Thread.sleep(5000);
	saveeee.click();
	Thread.sleep(3000);
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void clickonokbuttonwithconfirmation() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,500)");
	Thread.sleep(3000);
	license.click();
	Thread.sleep(5000);
	editlicense.click();
	Thread.sleep(3000);
	lisenseissuer.clear();
	Thread.sleep(3000);
	lisenseissuer.sendKeys("L58585858");
	Thread.sleep(5000);
	saveeee.click();
	Thread.sleep(3000);
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifypullcvsearchscreen() throws InterruptedException, AWTException {
	
	
	Thread.sleep(3000);
	Userprofile.click();
	Thread.sleep(3000);
	Pullcv.click();
	Thread.sleep(3000);
	country.click();
	Thread.sleep(3000);
	country.sendKeys("united states of America");
	Thread.sleep(3000);
	chechbox.click();
	Thread.sleep(3000);
	close.click();
	Thread.sleep(3000);
	search.click();
	Thread.sleep(3000);
	Highlightelement("Lname");
	Thread.sleep(3000);
	Highlightelement("Fname");
	Thread.sleep(3000);
	Highlightelement("contry");
	Thread.sleep(3000);
	Highlightelement("state");
	Thread.sleep(3000);
	Highlightelement("lastgeneratecv");
	Thread.sleep(3000);
	Highlightelement("pullcvhistory");
	Thread.sleep(3000);
	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}



public void verifylastgeneratedcvdate() throws InterruptedException, AWTException {
	
	
	Thread.sleep(3000);
	Highlightelement("lastgeneratecv");
	Thread.sleep(3000);
	
	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verify10recordsinsearchresult() throws InterruptedException, AWTException {
	
	
	Thread.sleep(3000);
	checkall.click();
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(3000);
	pullcvbuttons.click();
	Thread.sleep(5000);
	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verify10recordsinmentionedformat() throws InterruptedException, AWTException {
	
	
	Thread.sleep(3000);
	checkall.click();
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(3000);
	pullcvbuttons.click();
	Thread.sleep(5000);
	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	js2.executeScript("window.scrollBy(0,800)");
	Thread.sleep(3000);
	Highlightelement("sipuseridsss");
	Thread.sleep(3000);
	Highlightelement("firstnames");
	Thread.sleep(3000);
	Highlightelement("lastnames");
	Thread.sleep(3000);
	Highlightelement("cvtitles");
	Thread.sleep(3000);
	Highlightelement("viewcv");
	Thread.sleep(3000);
	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}



public void verifywordpdf() throws InterruptedException, AWTException {
	
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,200)");
	Thread.sleep(3000);
	checkall.click();
	Thread.sleep(3000);
	chk1.click();
	Thread.sleep(3000);
	chk2.click();
	Thread.sleep(3000);
	chk3.click();
	downloadcvss.click();
	Thread.sleep(5000);
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void downloadzip() throws InterruptedException, AWTException {
	
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,200)");
	Thread.sleep(3000);
	checkall.click();
	Thread.sleep(3000);
	pullcvbuttons.click();
	Thread.sleep(3000);
	JavascriptExecutor js3 = (JavascriptExecutor) driver;
	js3.executeScript("window.scrollBy(0,800)");
	Thread.sleep(3000);
	downloadcvss.click();
	Thread.sleep(3000);
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifysections() throws InterruptedException, AWTException {
	
	
	Userprofile.click();
	Thread.sleep(3000);
	MyProfile.click();
	Thread.sleep(3000);
	Highlightelement("basicdetailsss");
	Thread.sleep(3000);
	Highlightelement("facilitiesss");
	Thread.sleep(3000);
	Highlightelement("educationss");
	Thread.sleep(3000);
	Highlightelement("professionalexppps");
	Thread.sleep(3000);
	Highlightelement("gcptrainings");
	Thread.sleep(3000);
	Highlightelement("licensedetails");
	Thread.sleep(3000);
	Highlightelement("researchexpppss");
	Thread.sleep(3000);
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}



public void verifyfacilitysections() throws InterruptedException, AWTException {
	
	JavascriptExecutor js3 = (JavascriptExecutor) driver;
	js3.executeScript("window.scrollBy(0,300)");

	Thread.sleep(4000);
	facilitiesss.click();
	Thread.sleep(3000);
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifyfirstfaciloty() throws InterruptedException, AWTException {
	
	

	Thread.sleep(3000);
	facilitiesss.click();
	Thread.sleep(3000);
	Highlightelement("firstfacility");
	Thread.sleep(3000);
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}




public void verifysecondfacility() throws InterruptedException, AWTException {
	
	

	Thread.sleep(3000);
	facilitiesss.click();
	Thread.sleep(3000);
	Highlightelement("secondfacility");
	Thread.sleep(3000);
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}

public void verifythirdfacility() throws InterruptedException, AWTException {
	
	

	Thread.sleep(3000);
	facilitiesss.click();
	Thread.sleep(3000);
	Highlightelement("thirdfacility");
	Thread.sleep(3000);
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}
public void verifyeducationyearcompletedcolumn() throws InterruptedException, AWTException {
	
	
	Thread.sleep(3000);
	JavascriptExecutor js3 = (JavascriptExecutor) driver;
	js3.executeScript("window.scrollBy(0,200)");
	Thread.sleep(3000);
	education.click();
	Thread.sleep(3000);
	Highlightelement("yearcompleted");
	Thread.sleep(3000);
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifyaddcompleted() throws InterruptedException, AWTException {
	
	
	Thread.sleep(3000);
	saves.click();
	Thread.sleep(3000);
	okies.click();
	Thread.sleep(3000);
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifyprofessionalexpyearstrted() throws InterruptedException, AWTException {
	
	
	Thread.sleep(3000);
	professionalexp.click();
	Thread.sleep(3000);
	Highlightelement("yearcompleted");
	Thread.sleep(3000);
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifyaddprofessionalexpyearstrted() throws InterruptedException, AWTException {
	
	
	Thread.sleep(3000);
	saves.click();
	Thread.sleep(3000);
	okies.click();
	Thread.sleep(3000);
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifyresearchexp2() throws InterruptedException, AWTException {
	
	
	Thread.sleep(3000);
	saves.click();
	Thread.sleep(3000);
	okies.click();
	Thread.sleep(3000);
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifyaddtheraputic() throws InterruptedException, AWTException {
	
	JavascriptExecutor js3 = (JavascriptExecutor) driver;
	js3.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(3000);
	Highlightelement("theraputicarea");
	Thread.sleep(3000);

	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifysubtheraputicarea() throws InterruptedException, AWTException {
	
	JavascriptExecutor js3 = (JavascriptExecutor) driver;
	js3.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(3000);
	Highlightelement("substheraputicarea");
	Thread.sleep(3000);

	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void saveandverify() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	saves.click();
	Thread.sleep(3000);
	okies.click();
	Thread.sleep(3000);

	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifygcp() throws InterruptedException, AWTException {
	
	
	gcp.click();
	Thread.sleep(3000);
	

	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifygcpdatecompleted() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	saves.click();
	Thread.sleep(3000);
	okies.click();
	Thread.sleep(3000);

	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}

public void verifylicensedetailissuedate() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	licensedetails.click();
	Thread.sleep(3000);
	

	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifylicesedetailssorting() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	saves.click();
	Thread.sleep(3000);
	okies.click();
	

	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifyprofileattahments() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	profileattachment.click();
	Thread.sleep(3000);
	
	

	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifysorteddocumentname() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	saves.click();
	Thread.sleep(3000);
	okies.click();
	
	

	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}

public void verifypublicatonpresentationsort() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	publicationpresentation.click();
	Thread.sleep(3000);
	
	
	

	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifypublicationsort() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	publicationpresentation.click();
	Thread.sleep(3000);
	
	
	

	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void savepublicationandpresentation() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	saves.click();
	Thread.sleep(3000);
	okies.click();
	
	
	

	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}




public void verifyplaceholdertext() throws InterruptedException, AWTException {
	
	Thread.sleep(3000);
	Userprofile.click();
	Thread.sleep(3000);
	Pullcv.click();
	Thread.sleep(3000);
	Thread.sleep(3000);
	Highlightelement("tosearch");
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,500)");
	Thread.sleep(3000);
	Highlightelement("substheraputicarea");
	Thread.sleep(3000);
	Thread.sleep(3000);
	Highlightelement("substheraputicarea");
	Thread.sleep(3000);
	

	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}



public void selectallacheckboxdownloadcvenable() throws InterruptedException, AWTException {
	
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,800)");
	Thread.sleep(3000);
	checlboxaall.click();
	Thread.sleep(3000);
	Highlightelement("downloadcvsssss");
	Thread.sleep(3000);
	
	Thread.sleep(3000);
	

	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void novaluesaredisplayedinlist() throws InterruptedException, AWTException {
	
	
	Thread.sleep(3000);
	Userprofile.click();
	Thread.sleep(3000);
	Pullcv.click();
	Thread.sleep(3000);
	country.sendKeys("'");
	Thread.sleep(3000);
	

	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void searchscreendisplayed() throws InterruptedException, AWTException {
	
	
	Thread.sleep(3000);
	Userprofile.click();
	Thread.sleep(3000);
	Pullcv.click();
	Thread.sleep(3000);
	country.click();
	Thread.sleep(3000);
	country.sendKeys("United States of America");
	Thread.sleep(3000);
	checkboxes.click();
	Thread.sleep(3000);
	closes.click();
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(3000);
	search.click();
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}

public void verify2ndpage() throws InterruptedException, AWTException {
	
	
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(3000);
	singlearrow.click();
	Thread.sleep(3000);
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void noprevpaginationdisplayed() throws InterruptedException, AWTException {
	
	
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(3000);
	firstarrow.click();
	Thread.sleep(3000);
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void Verifylastpage() throws InterruptedException, AWTException {
	
	
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(3000);
	lastarrow.click();
	Thread.sleep(3000);
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifyprevpage() throws InterruptedException, AWTException {
	
	
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(3000);
	prevarrorw.click();
	Thread.sleep(3000);
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}

public void verrifyenteredpageno() throws InterruptedException, AWTException {
	
	
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(3000);
	pagenumbers.sendKeys("7");
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


public void clickonlastnameandverify() throws InterruptedException, AWTException {
	
	
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(3000);
	lastnameclick.click();
	Thread.sleep(3000);
	Highlightelement("basicdetail");
	Thread.sleep(3000);
	Highlightelement("Facilities");
	Thread.sleep(3000);
	Highlightelement("education1");
	Thread.sleep(3000);
	Highlightelement("professionalexp1");
	Thread.sleep(3000);
	Highlightelement("researchexpp");
	Thread.sleep(3000);
	Highlightelement("gcp");
	Thread.sleep(3000);
	Highlightelement("license");
	Thread.sleep(3000);
	Highlightelement("profileattachments");
	Thread.sleep(3000);
	Highlightelement("publicationpresentation");
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}




public void abbrivatedcvhistory() throws InterruptedException, AWTException {
	
	
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,200)");
	Thread.sleep(3000);
	Abbriviatedcvhistory.click();
	Thread.sleep(3000);
	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	js2.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(3000);
	word.click();
	Thread.sleep(7000);
	pdf.click();
	Thread.sleep(7000);
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void navigateandverifyeachsection1() throws InterruptedException, AWTException {
	
	
	
	Thread.sleep(3000);
	basicdetail.click();
	Thread.sleep(3000);
	Facilities.click();
	Thread.sleep(3000);
	education1.click();
	Thread.sleep(3000);
	professionalexp1.click();
	Thread.sleep(3000);
	researchexpp.click();
	Thread.sleep(3000);
	gcp.click();
	Thread.sleep(3000);
	license.click();
	Thread.sleep(3000);
	profileattachments.click();
	Thread.sleep(3000);
	publicationpresentation.click();
	Thread.sleep(3000);
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifylicense() throws InterruptedException, AWTException {
	
	
	
	
	Thread.sleep(3000);
	license.click();
	Thread.sleep(3000);
	Highlightelement("professionallicenenumber");
    Thread.sleep(3000);
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void profileatachment() throws InterruptedException, AWTException {
	
	
	
	
	Thread.sleep(3000);
	profileattachments.click();
	Thread.sleep(3000);
	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}



public void uploadprofileattachment() throws InterruptedException, AWTException {
	
	
	
	
	Thread.sleep(3000);
	uploadnewdoc.click();
	Thread.sleep(3000);
	chosefile.sendKeys("\"C:\\Users\\545325\\Desktop\\Player Results Information.pdf\"");
	Thread.sleep(3000);
	uppload.click();
	Thread.sleep(3000);
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}

public void uploadprofileattachment255() throws InterruptedException, AWTException {
	
	
	
	
	Thread.sleep(3000);
	uploadnewdoc.click();
	Thread.sleep(3000);
	chosefile.sendKeys("\"C:\\Users\\545325\\Desktop\\Player Results Information.pdf\"");
	Thread.sleep(3000);
	uppload.click();
	Thread.sleep(3000);
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}

public void uploadprofileattachment256() throws InterruptedException, AWTException {
	
	
	
	
	Thread.sleep(3000);
	uploadnewdoc.click();
	Thread.sleep(3000);
	chosefile.sendKeys("\"C:\\Users\\545325\\Desktop\\Player Results Information.pdf\"");
	Thread.sleep(3000);
	uppload.click();
	Thread.sleep(3000);
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}

public void verifyPIstudyhistorynotdiaplayed() throws InterruptedException, AWTException {
	
	
	
	
	Thread.sleep(3000);
	Userprofile.click();
	Thread.sleep(3000);
	MyProfile.click();
	Thread.sleep(3000);
	basicdetail.click();
	Thread.sleep(3000);
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifyPIstudyhistorynotdiaplayed1() throws InterruptedException, AWTException {
	
	
	
	
	Thread.sleep(3000);
	Userprofile.click();
	Thread.sleep(3000);
	MyProfile.click();
	Thread.sleep(3000);
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifypullcvsearchresult() throws InterruptedException, AWTException {
	
	
	
	
	Thread.sleep(3000);
	Userprofile.click();
	Thread.sleep(3000);
	pullcv.click();
	Thread.sleep(5000);
	country.click();
	Thread.sleep(5000);
	checkall.click();
	Thread.sleep(5000);
	close.click();
	Thread.sleep(5000);
	emailaddress.sendKeys("meera1@yopmail.com");
	Thread.sleep(5000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(5000);
	search.click();
	Thread.sleep(5000);
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void clickverifylastname() throws InterruptedException, AWTException {
	
	
	
	
	Thread.sleep(3000);
	lastnameclick.click();
	Thread.sleep(5000);
	Highlightelement("basicdetail");
	Thread.sleep(5000);
    basicdetail.click();
    Thread.sleep(5000);
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifygcpsection() throws InterruptedException, AWTException {
	
	
	
	
	Thread.sleep(3000);
	Userprofile.click();
	Thread.sleep(5000);
	MyProfile.click();
	Thread.sleep(5000);
    basicdetail.click();
    Thread.sleep(5000);
    JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,200)");
    Thread.sleep(5000);
    researchexp.click();
    Thread.sleep(5000);
    JavascriptExecutor js2 = (JavascriptExecutor) driver;
	js2.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(5000);
	gcptrainingbutton.click();
	Thread.sleep(5000);
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}




public void verifygcponscreenwithyesno() throws InterruptedException, AWTException {
	
	
	
	
	Thread.sleep(3000);
	Highlightelement("gcpscreen1");
	Thread.sleep(3000);
	Highlightelement("gcpscreen2");
	Thread.sleep(3000);
	Highlightelement("gcpscreen3");
	Thread.sleep(5000);
	


	if(gcpscreen1.getText().contains("After your request for GCP Mutually Recognized Training credit is reviewed by one sponsor, your GCP training will be visible to all participating Sponsors in SIP"))
	     {
	         System.out.println("Onscreen Text pass");
	         Thread.sleep(3000);
	     }
	     else
	     {
	     System.out.println("Onscreen Text Fail");
	        
	     }
	
	if(gcpscreen2.getText().contains("Depending on your role GCP training may not be required"))
    {
        System.out.println("Onscreen Text pass");
        Thread.sleep(3000);
    }
    else
    {
    System.out.println("Onscreen Text Fail");
       
    }
	
	if(gcpscreen3.getText().contains("Maintaining a current GCP certificate (dated within three years) is recommended. To complete GCP Training now, click on the \"Find A Course\" button and search for \"GCP\""))
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


public void verifyradio() throws InterruptedException, AWTException {
	
	
	
	
	Thread.sleep(3000);
	Highlightelement("noradio");
	Thread.sleep(3000);
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}

public void selectradiono() throws InterruptedException, AWTException {
	
	
	
	
	Thread.sleep(3000);
	noradio.click();
	Thread.sleep(3000);
	Highlightelement("findacourse");
	Thread.sleep(3000);
	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifynotifications() throws InterruptedException, AWTException {
	
	
	
	
	Thread.sleep(3000);
	savvee.click();
	Thread.sleep(3000);
	okkkki.click();
	Thread.sleep(3000);
	home.click();
	Thread.sleep(3000);
	bell.click();
	Thread.sleep(3000);
	viewmore.click();
	Thread.sleep(3000);
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void navgatetomyprofile() throws InterruptedException, AWTException {
	
	
	
	
	Thread.sleep(3000);
	Userprofile.click();
	Thread.sleep(3000);
	MyProfile.click();
	Thread.sleep(3000);
	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	js2.executeScript("window.scrollBy(0,800)");
	Thread.sleep(3000);
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void generateCVButton1() throws Exception {
	
	
	
	
	
        Thread.sleep(4000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        generateCVButton1.click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//input[@value='GENERATE CV']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//input[@value='Generate and Sign CV']")).click();
        Thread.sleep(4000);
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it=windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        Thread.sleep(4000);
        driver.findElement(By.xpath("//form[@id='esignForm']//div/a")).click();
        Thread.sleep(4000);
        properties= obj.getProperty();
        
        Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
        testData.setTestDatainMap(TestDataInMap);
        
        String username = TestDataInMap.get("Site User 1 User ID");
        String password = "Password9$";
        driver.findElement(By.name("esignForm:userId")).sendKeys(username);
        driver.findElement(By.name("esignForm:pwd")).sendKeys(password);
        driver.findElement(By.name("esignForm:Login")).click();
        Thread.sleep(8000);
        driver.switchTo().window(parentWindow);
        Thread.sleep(4000);
        driver.findElement(By.id("approveAllOk")).click();
        Thread.sleep(4000);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(4000);
        WebElement wordFile =driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]/a/i[@title='Word']"));
        WebElement PDFFile= driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]/a/i[@title='PDF']"));
        highLightElement(wordFile);
        highLightElement(PDFFile);
        Assert.assertTrue(wordFile.isDisplayed());
        Assert.assertTrue(PDFFile.isDisplayed());
 }
 

	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);




public void verifymentionedtabsdisplayed() throws InterruptedException, AWTException {
	
	
	
	
	Thread.sleep(3000);
	Userprofile.click();
	Thread.sleep(3000);
	MyProfile.click();
	Thread.sleep(3000);
	highLightElement(userprofiletab);
	Thread.sleep(3000);
	highLightElement(Abbriviatedcvhistory);
	Thread.sleep(3000);
	highLightElement(exporteduserprofiletab);
	Thread.sleep(3000);
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void Navigatetoeducation() throws InterruptedException, AWTException {
	
	
	
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,300)");
	Thread.sleep(3000);
	education.click();
	Thread.sleep(3000);
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void NavigatetoProfessionalexp() throws InterruptedException, AWTException {
	
	
	
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,300)");
	Thread.sleep(3000);
	professionalexp.click();
	Thread.sleep(3000);
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void Navigatetoreseachexp() throws InterruptedException, AWTException {
	
	
	
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,300)");
	Thread.sleep(3000);
	researchexp.click();
	Thread.sleep(3000);
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void Navigatetolicensedetail() throws InterruptedException, AWTException {
	
	
	
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,300)");
	Thread.sleep(3000);
	license.click();
	Thread.sleep(3000);

	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}



public void Navigatetoprofileattachment() throws InterruptedException, AWTException {
	
	
	
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,300)");
	
	Thread.sleep(3000);
	profileattachment.click();
	Thread.sleep(3000);

	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void Navigattopublicationpresentation() throws InterruptedException, AWTException {
	
	
	
	
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,300)");
	Thread.sleep(3000);
	publicationpresentation.click();
	Thread.sleep(3000);
	editpresentation.click();
	Thread.sleep(3000);	
	preentationtitle.sendKeys("Hgjkgjgdjgajagdj");
	Thread.sleep(5000);
	presentationsave.click();
	Thread.sleep(5000);
	sendallchangedforapproval.click();
	Thread.sleep(5000);
	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}



public void delegateduser() throws InterruptedException, AWTException {
	
	
	
	
	Thread.sleep(3000);
	userdelageted.click();
	Thread.sleep(5000);
	
	
	
	

	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void userprofilemyprofile() throws InterruptedException, AWTException {
	
	
	
	
	Thread.sleep(3000);
	Userprofile.click();
	Thread.sleep(5000);
	MyProfile.click();
	Thread.sleep(5000);
	
	
	

	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void downloadprofiletemplate() throws InterruptedException, AWTException {
	
	
	
	
	Thread.sleep(3000);
	downloadsipuserprofile.click();
	Thread.sleep(5000);
	okbuttonn1.click();
	Thread.sleep(5000);
	
	
	

	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}



public void verifybasicdetailPIhistory() throws InterruptedException, AWTException {
	
	
	
	
	Thread.sleep(3000);
	basicdetail.click();
	Thread.sleep(5000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,800)");
	Thread.sleep(5000);
	highLightElement(PIstdyhistory);
	Thread.sleep(5000);
	
	
	

	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifyokcancel() throws InterruptedException, AWTException {
	
	
	
	

	Thread.sleep(5000);
	PIstdyhistory.click();
	Thread.sleep(5000);
	highLightElement(ok13);
	Thread.sleep(5000);
	highLightElement(cancel13);
	Thread.sleep(5000);
	
	

	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void navigatetobasicdetailss() throws InterruptedException, AWTException {
	
	
	
	

	Thread.sleep(5000);
	cancel13.click();
	Thread.sleep(5000);
	
	
	

	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifyhistoricalstudyinfo() throws InterruptedException, AWTException {
	
	
	
	

	Thread.sleep(5000);
	PIstdyhistory.click();
	Thread.sleep(5000);
	ok13.click();
	Thread.sleep(5000);
	
	

	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void clickmyprofile() throws InterruptedException, AWTException {
	
	
	
	

	Thread.sleep(5000);
	Userprofile.click();
	Thread.sleep(5000);
	MyProfile.click();
	Thread.sleep(5000);
	
  

	

	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifymentionscreendisplayed() throws InterruptedException, AWTException {
	
	
	
	

	Thread.sleep(5000);
	delegatebutt.click();
	Thread.sleep(5000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,800)");
	Thread.sleep(5000);
	highLightElement(sitestaff);
	Thread.sleep(5000);
	highLightElement(organizationd);
	Thread.sleep(5000);
	highLightElement(cancel1111);
	Thread.sleep(5000);
	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifyemailwithdelegate() throws InterruptedException, AWTException {
	
	
	
	

	Thread.sleep(5000);
	
	highLightElement(delagtedemail);
	Thread.sleep(5000);
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void delagetesuccessfull() throws InterruptedException, AWTException {
	
	
	
	

	Thread.sleep(5000);
	delagtedemail.sendKeys("meera1@yopmail.com");
	Thread.sleep(5000);
	delagete.click();
	Thread.sleep(5000);
	okbuttonn111.click();
	Thread.sleep(5000);
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}



public void undelagetdsucceful() throws InterruptedException, AWTException {
	
	
	
	

	Thread.sleep(5000);
	undelegate.click();
	Thread.sleep(5000);
	removedelageted.click();
	Thread.sleep(5000);
	okkkkkkkkkk.click();
	Thread.sleep(5000);
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}

public void ClickOnUndelegateButton() throws Exception{
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,100)");
	undelegate.click();
	Thread.sleep(5000);
	
//	VarifyPopUp
	try{
		highLightElement(driver.findElement(By.xpath("//h2[contains(@class,'display-inline-block marTop10')]")));
		highLightElement(driver.findElement(By.xpath("//p[text()='There are pending User Profile changes made by your current Delegate that require your review. Please click Approve/Reject Changes before removing this Delegate']")));
	    highLightElement(ApproveRejectChange);
     	highLightElement(UndelegatedCancel);
	}catch(Exception e){}
	
	try{
		highLightElement(driver.findElement(By.xpath("//h1[@class='display-inline-block']")));
		highLightElement(driver.findElement(By.xpath("//p[text()='Are you sure you want to remove the Delegate for maintenance of your User Profile?']")));
	    highLightElement(RemoveDelegate);
     	highLightElement(UndelegatedCancel1);
	}catch(Exception e){}
}

public void ClickOnUnDelegateCancel() throws Exception{
	Thread.sleep(2000);
	UndelegatedCancel.click();
}

public void ClickOnUnDelegateCancelFirst() throws Exception{
	Thread.sleep(2000);
	UndelegatedCancel1.click();
}

public void ClickOnUndelegatedApproveRejectChange() throws Exception{
	ApproveRejectChange.click();
	Thread.sleep(10000);
}

public void RemoveDelegate() throws Exception{
	RemoveDelegate.click();
	Thread.sleep(2000);
	
	try{
		highLightElement(driver.findElement(By.xpath("//button[contains(@class,'single-btn undelegateActionOk')]")));
	}catch(Exception e){}
}

public void RemoveDelegateOK() throws Exception{
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[contains(@class,'single-btn undelegateActionOk')]")).click();
	Thread.sleep(10000);
}

public void VerifyOrganizationName(){
	try{
		OrganizationNameVerify.isDisplayed();
	}catch(Exception e){System.out.println("Orgnaization not present");}
}

public void ClickOnRejectAll() throws Exception{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", Facilities);
	Thread.sleep(2000);
	RejectAllchanges.click();
	Thread.sleep(5000);
	try{
		RejectAllchangesOK.click();
		Thread.sleep(5000);
	}catch(Exception e){}
}
public void verifyorganzation() throws InterruptedException, AWTException {
	
	
	
	

	Thread.sleep(5000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,800)");
	Thread.sleep(5000);
	orgradio1.click();
	Thread.sleep(5000);
	highLightElement(orgname1);
	Thread.sleep(5000);
	highLightElement(countrname1);
	Thread.sleep(5000);
	highLightElement(statename1);
	Thread.sleep(5000);
	highLightElement(searchname1);
	Thread.sleep(5000);
	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifysearchreult() throws InterruptedException, AWTException {
	
	
	
	

	Thread.sleep(5000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,800)");
	orgname1.click();
	Thread.sleep(5000);
	Robot robot1 = new Robot();  
    Thread.sleep(2000); 
    robot1.keyPress(KeyEvent.VK_DOWN); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_DOWN);
    Thread.sleep(2000);  
    robot1.keyPress(KeyEvent.VK_DOWN); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_DOWN);
    Thread.sleep(2000);
    robot1.keyPress(KeyEvent.VK_ENTER); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(5000);
    searchname1.click();
    Thread.sleep(5000);
	
	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}



public void organizationdelagettion() throws InterruptedException, AWTException {
	
	
	
	

	Thread.sleep(5000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,800)");
	 Thread.sleep(5000);
	 rad.click();
	 Thread.sleep(5000);
	 delageorg.click();
	 Thread.sleep(5000);
	 okn.click();
	 Thread.sleep(5000);
	
	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifydelegatedtome() throws InterruptedException, AWTException {
	
	
	
	

	Thread.sleep(5000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,200)");
	 Thread.sleep(5000);
	 highLightElement(orgname11);
	 Thread.sleep(5000);
	
	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}

public void clickmsgtodpm() throws InterruptedException, AWTException {
	
	
	
	

	Thread.sleep(5000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,200)");
	 Thread.sleep(5000);
	 action11.click();
	 Thread.sleep(5000);
	 sendmsgtofpm.click();
	 Thread.sleep(5000);
	 highLightElement(body);
	 Thread.sleep(5000);
	 highLightElement(sendmsg);
	 Thread.sleep(5000);
	 highLightElement(cancel111);
	 Thread.sleep(5000);
	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifymsg1() throws InterruptedException, AWTException {
	
	
	
	

	Thread.sleep(5000);
	 sendmsg.click();
	 Thread.sleep(5000);
	 highLightElement(msg1);
	 Thread.sleep(5000);
	 
	 if(msg1.getText().contains("Please enter a message"))
     {
         System.out.println("msg1 Text pass");
         Thread.sleep(3000);
     }
     else
     {
     System.out.println("msg1 Text Fail");
        
     }

	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifymsg2() throws InterruptedException, AWTException {
	
	
	
	

	Thread.sleep(5000);
	body.sendKeys("hfhfhgdfadhga");
	 Thread.sleep(5000);
	 sendmsg.click();
	 Thread.sleep(5000);
	 
	 if(msg2.getText().contains("Your message has been sent successfully"))
     {
         System.out.println("msg1 Text pass");
         Thread.sleep(3000);
     }
     else
     {
     System.out.println("msg1 Text Fail");
        
     }

	
	
	
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}



public void verifynagatetofacilityscreen() throws InterruptedException, AWTException {
	
	
	
	

	Thread.sleep(5000);
	okkkkkks.click();
	Thread.sleep(5000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,200)");
	Thread.sleep(5000);
	
	 if(section.getText().contains("Facilities"))
     {
         System.out.println("section Text pass");
         Thread.sleep(3000);
     }
     else
     {
     System.out.println("section Text Fail");
        
     }
	
	 Thread.sleep(5000);
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifyprofileoptions() throws InterruptedException, AWTException {
	
	
	
	

	Thread.sleep(5000);
	Userprofile.click();
	Thread.sleep(5000);
	highLightElement(MyProfile);
	Thread.sleep(5000);
    highLightElement(Pullcv);
	Thread.sleep(5000);
	
	 Thread.sleep(5000);
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void verifypullcvfields() throws InterruptedException, AWTException {
	
	
	
	

	Thread.sleep(5000);
	Pullcv.click();
	Thread.sleep(5000);
	highLightElement(country);
	Thread.sleep(5000);
    highLightElement(Lname);
	Thread.sleep(5000);
	highLightElement(Fname);
	Thread.sleep(5000);
    highLightElement(state);
	Thread.sleep(5000);
	highLightElement(citis);
	Thread.sleep(5000);
    highLightElement(programs);
	Thread.sleep(5000);
	highLightElement(studis);
	Thread.sleep(5000);
    highLightElement(emails);
	Thread.sleep(5000);
	highLightElement(roless);
	Thread.sleep(5000);
	highLightElement(activations);
	Thread.sleep(5000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,800)");
	Thread.sleep(5000);
	highLightElement(thereaputicarea);
	Thread.sleep(5000);
	highLightElement(subtheraputicarea);
	Thread.sleep(5000);
	highLightElement(noofcompletedstudy);
	Thread.sleep(5000);
	highLightElement(noofongoingstudy);
	Thread.sleep(5000);
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}




public void verifypullcvtable() throws InterruptedException, AWTException {
	
	
	
	

	Thread.sleep(5000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,200)");
	Thread.sleep(5000);
	highLightElement(Lname);
	Thread.sleep(5000);
	highLightElement(Fname);
	Thread.sleep(5000);
	highLightElement(contry);
	Thread.sleep(5000);
	highLightElement(state);
	Thread.sleep(5000);
	highLightElement(lastgeneratecv);
	Thread.sleep(5000);
	highLightElement(pullcvhistory);
	
	
	 Thread.sleep(5000);
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}



public void clickonpullcvyes() throws InterruptedException, AWTException {
	
	
	
	

	Thread.sleep(5000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,200)");
	Thread.sleep(5000);
	highLightElement(pullcvyes);
	Thread.sleep(5000);
	highLightElement(sipuseridssss);
	Thread.sleep(5000);
	highLightElement(name);
	Thread.sleep(5000);
	highLightElement(downloadcv1);
	Thread.sleep(5000);
	highLightElement(cancelbutton);
	Thread.sleep(5000);
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void enterpagezero() throws InterruptedException, AWTException {
	
	
	
	

	Thread.sleep(5000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,200)");
	enterpage.sendKeys("0");
	Thread.sleep(5000);
	Robot robot1 = new Robot();  
    Thread.sleep(2000); 
    robot1.keyPress(KeyEvent.VK_ENTER); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(5000);
    highLightElement(errormsg2);
    Thread.sleep(5000);
    
    if(errormsg2.getText().contains("Please enter valid Page number from 1 to 1"))
    {
        System.out.println("errormsg2 Text pass");
        Thread.sleep(3000);
    }
    else
    {
    System.out.println("errormsg2 Text Fail");
       
    }
	
	Thread.sleep(5000);
	okbutttttt.click();
	Thread.sleep(5000);
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void enterpagemorethan() throws InterruptedException, AWTException {
	
	
	
	

	Thread.sleep(5000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,200)");
	enterpage.sendKeys("10");
	Thread.sleep(5000);
	Robot robot1 = new Robot();  
    Thread.sleep(2000); 
    robot1.keyPress(KeyEvent.VK_ENTER); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(5000);
    highLightElement(errormsg3);
    Thread.sleep(5000);
    
    if(errormsg3.getText().contains("Please enter valid Page number from 1 to 1"))
    {
        System.out.println("errormsg3 Text pass");
        Thread.sleep(3000);
    }
    else
    {
    System.out.println("errormsg3 Text Fail");
       
    }
	
	Thread.sleep(5000);
	okbutttttt.click();
	Thread.sleep(5000);
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}



public void enterpagedecimal() throws InterruptedException, AWTException {
	
	
	
	

	Thread.sleep(5000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,200)");
	enterpage.sendKeys("1.5");
	Thread.sleep(5000);
	Robot robot1 = new Robot();  
    Thread.sleep(2000); 
    robot1.keyPress(KeyEvent.VK_ENTER); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(5000);
    highLightElement(errormsg3);
    Thread.sleep(5000);
    
    if(errormsg3.getText().contains("Please enter valid Page number from 1 to 1"))
    {
        System.out.println("errormsg3 Text pass");
        Thread.sleep(3000);
    }
    else
    {
    System.out.println("errormsg3 Text Fail");
       
    }
	
	Thread.sleep(5000);
	okbutttttt.click();
	Thread.sleep(5000);
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}




public void clickoncancelbutton() throws InterruptedException, AWTException {
	
	
	
	

	Thread.sleep(5000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,200)");
	cancelbutton.click();
	Thread.sleep(5000);
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}


public void clickonbell() throws InterruptedException, AWTException {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0,0)");

	Thread.sleep(5000);
	bell.click();
	Thread.sleep(5000);
	Robot robot1 = new Robot();  
    Thread.sleep(3000); 
    robot1.keyPress(KeyEvent.VK_TAB); 	
    Thread.sleep(3000);  
    robot1.keyRelease(KeyEvent.VK_TAB);
    Thread.sleep(3000);  
    viewmore1.click();
    Thread.sleep(3000);
	
	
    
	js.executeScript("window.scrollBy(0,200)");
	Thread.sleep(5000);
	
	try{
//		Notification  recieve
	}catch(Exception e){}
	
	TakesScreenshot webdriver = null;
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);

}
public void VerifyNotification() throws InterruptedException{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,200)");
	Thread.sleep(3000);
	List<WebElement> Notifications=driver.findElements(By.xpath("//td[@class='notificationMsg']//div"));
	for(int i=0; i<2; i++){
		highLightElement(Notifications.get(i));
		Thread.sleep(3000);
	}
}

public void navgateabbriviatedcv() throws Exception 
{
	Thread.sleep(3000);
	Userprofile.click();
	Thread.sleep(5000);
	MyProfile.click();
	Thread.sleep(5000);
	Abbriviatedcvhistory.click();
	Thread.sleep(5000);
	
   Thread.sleep(3000);
	
	
}


public void verifysposordownloadcv() throws Exception 
{
	Thread.sleep(3000);
	viewmores.click();
	Thread.sleep(3000);
	highLightElement(cvdocname);
	Thread.sleep(3000);
	highLightElement(status);
	Thread.sleep(5000);
	
   
	
	
}


public void Verifyundelegatedbuttondisplayed() throws Exception 
{
	Thread.sleep(3000);
	Userprofile.click();
	Thread.sleep(3000);
	MyProfile.click();
	Thread.sleep(3000);
	highLightElement(undelegate);
	Thread.sleep(5000);
	highLightElement(faname);
	Thread.sleep(5000);
	highLightElement(laname);
	Thread.sleep(5000);
	highLightElement(usericon);
	Thread.sleep(5000);
	
	
	
   
	
	
}




public void verifysearchscreenresult() throws Exception 
{
	Thread.sleep(3000);
	cancelbutton.click();
	Thread.sleep(3000);
	highLightElement(searchuser);
	Thread.sleep(3000);
	
   
	
	
}


public void yesradioselected() throws Exception 
{
	Thread.sleep(3000);
	highLightElement(haveucompletd);
	Thread.sleep(3000);
	highLightElement(yesradio);
	Thread.sleep(3000);
	yesradio.click();
	Thread.sleep(3000);
   
	
	
}

public void noradioselected() throws Exception 
{
	Thread.sleep(3000);
	highLightElement(haveucompletd);
	Thread.sleep(3000);
	highLightElement(noradio1);
	Thread.sleep(3000);
	noradio1.click();
	Thread.sleep(3000);
   
	
	
}



public void verifysubmittrainingcreditrequest() throws Exception 
{
	Thread.sleep(3000);
	highLightElement(submittrainingcreditrequest);
	Thread.sleep(3000);
   
	
	
}

public void clickontraing() throws Exception 
{
	Thread.sleep(3000);
	Training.click();
	Thread.sleep(3000);
	MyTraining.click();
	Thread.sleep(3000);
	
	
}

public void clickandverifyexpand() throws Exception 
{
	Thread.sleep(3000);
	clickexpand.click();
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,800)");
	Thread.sleep(3000);
	highLightElement(search);
	Thread.sleep(3000);
	
	
	
	
	
}


public void email2norecord() throws Exception 
{
	Thread.sleep(3000);
	clickexpand.click();
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,800)");
	Thread.sleep(3000);
	highLightElement(search);
	Thread.sleep(3000);
	emailaddress.clear();
	Thread.sleep(3000);
	emailaddress.sendKeys("ab@yopmail.com");
	Thread.sleep(5000);
	JavascriptExecutor js3 = (JavascriptExecutor) driver;
	js3.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(5000);
	search.click();
	Thread.sleep(5000);
	highLightElement(norecordfound);
	Thread.sleep(5000);
	if(norecordfound.getText().contains("No record found."))
    {
        System.out.println("Text pass");
        Thread.sleep(3000);
    }
    else
    {
    System.out.println("Text Fail");
       
    }
	
	
	
	
	
	
}



public void email3norecord() throws Exception 
{
	Thread.sleep(3000);
	clickexpand.click();
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,800)");
	Thread.sleep(3000);
	highLightElement(search);
	Thread.sleep(3000);
	emailaddress.clear();
	Thread.sleep(3000);
	emailaddress.sendKeys("ab1@yopmail.com");
	Thread.sleep(5000);
	JavascriptExecutor js3 = (JavascriptExecutor) driver;
	js3.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(5000);
	search.click();
	Thread.sleep(5000);
	highLightElement(norecordfound);
	Thread.sleep(5000);
	if(norecordfound.getText().contains("No record found."))
    {
        System.out.println("Text pass");
        Thread.sleep(3000);
    }
    else
    {
    System.out.println("Text Fail");
       
    }
	
	
	
	
	
	
}




public void email4norecord() throws Exception 
{
	Thread.sleep(3000);
	clickexpand.click();
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,800)");
	Thread.sleep(3000);
	highLightElement(search);
	Thread.sleep(3000);
	emailaddress.clear();
	Thread.sleep(3000);
	emailaddress.sendKeys("ab2@yopmail.com");
	Thread.sleep(5000);
	JavascriptExecutor js3 = (JavascriptExecutor) driver;
	js3.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(5000);
	search.click();
	Thread.sleep(5000);
	highLightElement(norecordfound);
	Thread.sleep(5000);
	if(norecordfound.getText().contains("No record found."))
    {
        System.out.println("Text pass");
        Thread.sleep(3000);
    }
    else
    {
    System.out.println("Text Fail");
       
    }
	
	
	
	
	
	
}



public void enterproperemailanddelegate() throws Exception 
{
	Thread.sleep(3000);
	delegateemail.sendKeys("meera1@yopmail.com");
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,800)");
	Thread.sleep(3000);
	delegatebutton.click();
	Thread.sleep(5000);
	ok34.click();
	Thread.sleep(3000);
	
	
	
	
	
}



public void clickdisplayoncv() throws Exception 
{
	Thread.sleep(3000);
	delegateemail.sendKeys("meera1@yopmail.com");
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,800)");
	Thread.sleep(3000);
	delegatebutton.click();
	Thread.sleep(5000);
	ok34.click();
	Thread.sleep(3000);
	
	
	
	
	
}



public void clickdisplayoncv1() throws Exception 
{
	Thread.sleep(3000);
	checkboxdisplayoncv.click();
	Thread.sleep(5000);
	
	
	
	
	
}



public void clickpublicationsave() throws Exception 
{
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,1000)");
	savebuttons.click();
	Thread.sleep(5000);
	okbuttonss.click();
	Thread.sleep(5000);
	
	
	
	
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





public void verifymanagedelegationpage() throws Exception 
{
	Actions a=new Actions(driver);
	a.moveToElement(admin).build().perform();
	
	Thread.sleep(5000);
	managedelegation.click();
	Thread.sleep(7000);
	
	
	
	
}



public void verifyuserabletodelegate() throws Exception 
{
	Thread.sleep(3000);
	adddelegate.click();
	Thread.sleep(3000);
	organizations.click();
	Thread.sleep(3000);
	organizationsname.click();
	Thread.sleep(3000);
	Robot robot1 = new Robot();  
    Thread.sleep(2000); 
    robot1.keyPress(KeyEvent.VK_DOWN); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_DOWN);
    Thread.sleep(2000);  
    robot1.keyPress(KeyEvent.VK_DOWN); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_DOWN);
    Thread.sleep(2000); 
    robot1.keyPress(KeyEvent.VK_ENTER); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(3000);
    search12.click();
    Thread.sleep(3000);
    rad1.click();
    Thread.sleep(3000);
    delegate11.click();
    Thread.sleep(3000);
    okkks.click();
    Thread.sleep(3000);
    
    
    
	
	
}






public void pooltaskwillnotrecieve() throws Exception 
{
	Thread.sleep(3000);
	home.click();
	Thread.sleep(3000);
	Mytask.click();
	Thread.sleep(3000);
		
	
}




public void pooltaskwillrecieve() throws Exception 
{
	Thread.sleep(3000);
	home.click();
	Thread.sleep(3000);
	Mytask.click();
	Thread.sleep(3000);
		
	
}




public void selectuserprofileauditrailreport() throws Exception 
{
	
	Report.click();
	Thread.sleep(2000);
	AuditTrailReport.click();
    Thread.sleep(2000);
	SelectAuditTrailReportDropdown.click();
        Thread.sleep(2000);
       
        Select Report = new Select(SelectAuditTrailReportDropdown);
        Report.selectByVisibleText("User Profile Audit Trail Report");
        Thread.sleep(15000);
}
		
	

public void selectuserfacilitydocumentauditrailreport() throws Exception 
{
	
	Report.click();
	Thread.sleep(2000);
	AuditTrailReport.click();
    Thread.sleep(2000);
	SelectAuditTrailReportDropdown.click();
        Thread.sleep(2000);
       
        Select Report = new Select(SelectAuditTrailReportDropdown);
        Report.selectByVisibleText("User and Facility Documents Audit Trail Report");
        Thread.sleep(15000);
}
		


public void verifyreportfields() throws Exception 
{
	
	
	Thread.sleep(2000);
	Generatereport.click();
	Thread.sleep(6000);
	Highlightelement("validation1");
	Thread.sleep(3000);
	Highlightelement("validation2");
	Thread.sleep(3000);
	Highlightelement("validation3");
	Thread.sleep(3000);
	
	
        
}
		
	




		
	


public void generatereport() throws Exception 
{
	
	
	Thread.sleep(2000);
	fromdate.click();
	Thread.sleep(2000);
	Robot robot1 = new Robot();  
    Thread.sleep(2000);  
    robot1.keyPress(KeyEvent.VK_ENTER); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(2000);
    todate.click();
    Thread.sleep(2000);
	Robot robot2 = new Robot();  
    Thread.sleep(2000);  
    robot2.keyPress(KeyEvent.VK_ENTER); 	
    Thread.sleep(2000);  
    robot2.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(3000);
	usernamesearch.click();
	Thread.sleep(6000);
	search123.click();
	Thread.sleep(6000);
	radio.click();
	Thread.sleep(3000);
	select.click();
	Thread.sleep(6000);
	Generatereport.click();
	Thread.sleep(8000);
	
	
        
}
		
	




public void verifypagination1() throws Exception 
{
	
	
	Thread.sleep(2000);
	pagination.click();
    Thread.sleep(2000);
   
    Select Report = new Select(pagination);
    Report.selectByVisibleText("10");
    Thread.sleep(8000);
    Report.selectByVisibleText("20");
    Thread.sleep(8000);
    Report.selectByVisibleText("30");
    Thread.sleep(8000);
    Report.selectByVisibleText("40");
    Thread.sleep(8000);
    Report.selectByVisibleText("50");
    Thread.sleep(8000);
	
	
	
	
	
        
}
		
	


public void verifyexport() throws Exception 
{
	
	
	Thread.sleep(2000);
	export.click();
    Thread.sleep(2000);
    pdfexport.click();
    Thread.sleep(7000);
    xlsexport.click();
    Thread.sleep(7000);
    
    
	
	
	
	
	
        
}
		
	



public void verifyprint() throws Exception 
{
	
	
	Thread.sleep(2000);
	print.click();
    Thread.sleep(10000);
   
    
    
	
	
	
	
	
        
}
		
	


public void reportcolumnverification() throws Exception 
{
	
	
	Highlightelement("usernam");
	Thread.sleep(3000);
	Highlightelement("informationarea");
	Thread.sleep(3000);
	Highlightelement("refrenceid");
	Thread.sleep(3000);
	Highlightelement("attributename");
	Thread.sleep(3000);
	Highlightelement("oldvalue");
	Thread.sleep(3000);
	Highlightelement("newvalue");
	Thread.sleep(3000);	
	Highlightelement("actio");
	Thread.sleep(3000);
	Highlightelement("changeby");
	Thread.sleep(3000);
	Highlightelement("changeddate");
	Thread.sleep(3000);
	Highlightelement("reasonforchange");
	Thread.sleep(3000);
	
   
    
    
	
	
	
	
	
        
}
		
	



public void Addlicenseanduploaddoc() throws Exception 
{
	
	Thread.sleep(3000);
	Addlicense.click();
	Thread.sleep(3000);
	Highlightelement("typeoflicense");
	Thread.sleep(3000);
	Highlightelement("licenseissuer");
	Thread.sleep(3000);
	Highlightelement("proflicensenumber");
	Thread.sleep(3000);
	Highlightelement("issuedata");
	Thread.sleep(3000);
	Highlightelement("countryy1");
	Thread.sleep(3000);
	Highlightelement("state141");
	Thread.sleep(3000);
	Highlightelement("expdate");
	Thread.sleep(3000);
	Highlightelement("suppdoc");
	Thread.sleep(3000);
	upload222.click();
	Thread.sleep(3000);
	Highlightelement("upload222");
	Thread.sleep(3000);
	Highlightelement("cancel22");
	Thread.sleep(3000);
	
	
	
   
    
    
	
	
	
	
	
        
}
		
	

public void clickoncancel() throws Exception 
{
	
	Thread.sleep(3000);
	cancel22.click();
	Thread.sleep(3000);
	
	
   
    
    

	
        
}
		
	



public void filldetailandupload() throws Exception 
{
	
	Thread.sleep(3000);
	typeoflicense.click();
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
    licenseissuer.sendKeys("L7757557");
    Thread.sleep(2000);  
    proflicensenumber.sendKeys("P686868686");
    Thread.sleep(2000);  
    issuedata.click();
    Thread.sleep(2000);  
    robot1.keyPress(KeyEvent.VK_ENTER); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(2000); 
    countryy1.click();
    Thread.sleep(2000); 
    robot1.keyPress(KeyEvent.VK_DOWN); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_DOWN);
    Thread.sleep(2000);  
    robot1.keyPress(KeyEvent.VK_ENTER); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(2000); 
    state141.click();
    Thread.sleep(2000);
    robot1.keyPress(KeyEvent.VK_DOWN); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_DOWN);
    Thread.sleep(2000);  
    robot1.keyPress(KeyEvent.VK_ENTER); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(2000); 
    expdate.click();
    Thread.sleep(2000);  
    robot1.keyPress(KeyEvent.VK_ENTER); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(2000); 
    suppdoc.sendKeys("\"C:\\Users\\545325\\Desktop\\Shared Investigator Platform Reports.pdf\"");
    Thread.sleep(5000);
    upload222.click();
    Thread.sleep(10000);
    
        
}
		
public void filldetailandupload255() throws Exception 
{
	
	Thread.sleep(3000);
	typeoflicense.click();
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
    licenseissuer.sendKeys("L7757557");
    Thread.sleep(2000);  
    proflicensenumber.sendKeys("P686868686");
    Thread.sleep(2000);  
    issuedata.click();
    Thread.sleep(2000);  
    robot1.keyPress(KeyEvent.VK_ENTER); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(2000); 
    countryy1.click();
    Thread.sleep(2000); 
    robot1.keyPress(KeyEvent.VK_DOWN); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_DOWN);
    Thread.sleep(2000);  
    robot1.keyPress(KeyEvent.VK_ENTER); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(2000); 
    state141.click();
    Thread.sleep(2000);
    robot1.keyPress(KeyEvent.VK_DOWN); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_DOWN);
    Thread.sleep(2000);  
    robot1.keyPress(KeyEvent.VK_ENTER); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(2000); 
    expdate.click();
    Thread.sleep(2000);  
    robot1.keyPress(KeyEvent.VK_ENTER); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(2000); 
    suppdoc.sendKeys("\"C:\\Users\\545325\\Desktop\\Shared Investigator Platform Reports.pdf\"");
    Thread.sleep(5000);
    upload222.click();
    Thread.sleep(10000);
    
        
}
public void filldetailandupload256() throws Exception 
{
	
	Thread.sleep(3000);
	typeoflicense.click();
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
    licenseissuer.sendKeys("L7757557");
    Thread.sleep(2000);  
    proflicensenumber.sendKeys("P686868686");
    Thread.sleep(2000);  
    issuedata.click();
    Thread.sleep(2000);  
    robot1.keyPress(KeyEvent.VK_ENTER); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(2000); 
    countryy1.click();
    Thread.sleep(2000); 
    robot1.keyPress(KeyEvent.VK_DOWN); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_DOWN);
    Thread.sleep(2000);  
    robot1.keyPress(KeyEvent.VK_ENTER); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(2000); 
    state141.click();
    Thread.sleep(2000);
    robot1.keyPress(KeyEvent.VK_DOWN); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_DOWN);
    Thread.sleep(2000);  
    robot1.keyPress(KeyEvent.VK_ENTER); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(2000); 
    expdate.click();
    Thread.sleep(2000);  
    robot1.keyPress(KeyEvent.VK_ENTER); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(2000); 
    suppdoc.sendKeys("\"C:\\Users\\545325\\Desktop\\Shared Investigator Platform Reports.pdf\"");
    Thread.sleep(5000);
    upload222.click();
    Thread.sleep(10000);
    
        
}
	


public void navigatsipuserprofileform() throws Exception 
{
	
	Thread.sleep(3000);
	sipuserprofile.click();
	Thread.sleep(3000);
	   
    
        
}
		
	


public void uploaddownloadedcv() throws Exception 
{
	
	Thread.sleep(3000);
	choosefile223.sendKeys("\"C:\\Users\\545325\\Downloads\\SIP User Profile Form (27).pdf\"");
	Thread.sleep(3000);
	upload222.click();
    Thread.sleep(10000);
	
	   
    
        
}
public void uploaddownloadedcv255() throws Exception 
{
	
	Thread.sleep(3000);
	choosefile223.sendKeys("\"C:\\Users\\545325\\Downloads\\SIP User Profile Form (27).pdf\"");
	Thread.sleep(3000);
	upload222.click();
    Thread.sleep(10000);
	
	   
    
        
}		
public void uploaddownloadedcv256() throws Exception 
{
	
	Thread.sleep(3000);
	choosefile223.sendKeys("\"C:\\Users\\545325\\Downloads\\SIP User Profile Form (27).pdf\"");
	Thread.sleep(3000);
	upload222.click();
    Thread.sleep(10000);
	
	   
    
        
}	



public void navigatetoexportcv() throws Exception 
{
	
	Thread.sleep(3000);
	generate.click();
	Thread.sleep(3000);
	clickhare.click();
	Thread.sleep(3000);
	exportuserprofile1.click();
	Thread.sleep(3000);
	exportuserprofile2.click();
	Thread.sleep(3000);
	
	
	
	
	
	   
    
        
}
		
	



public void refreshexport() throws Exception 
{
	
	Thread.sleep(54000);
	refresh.click();
	Thread.sleep(3000);
	pdf.click();
	Thread.sleep(3000);
	word.click();
	Thread.sleep(3000);
	
	
   
    
        
}
		
	



public void verifysumbittrainingrequestdiaplayed() throws Exception 
{
	
	
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,900)");
	Thread.sleep(3000);
	Highlightelement("submittrainingcreditrequest1");
	Thread.sleep(3000);
	
	
   
    
        
}
		
	



public void verifystatus() throws Exception 
{
	
	
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,500)");
	Thread.sleep(3000);
	Highlightelement("sentforreview");
	Thread.sleep(3000);
	Highlightelement("certificatevalid");
	Thread.sleep(3000);
	Highlightelement("siteactionrequired");
	Thread.sleep(3000);
	
	
   
    
        
}
		
	


public void clickanaccept() throws Exception 
{
	
	
	
	Thread.sleep(3000);
	clickherenotification.click();
	Thread.sleep(6000);
JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,500)");
	Thread.sleep(3000);
	professionalexp.click();
	Thread.sleep(3000);
	approvethischange.click();
	Thread.sleep(3000);
	okbuttt.click();
	Thread.sleep(3000);
	
	
	
    
        
}
		


public void clickanareject() throws Exception 
{
	
	
	
	Thread.sleep(3000);
	clickherenotification.click();
	Thread.sleep(6000);
JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,500)");
	Thread.sleep(3000);
	professionalexp.click();
	Thread.sleep(3000);
	rejectthischange.click();
	Thread.sleep(3000);
	okbuttt.click();
	Thread.sleep(3000);
	
	
	
    
        
}
		
	
		



public void verifyresearchsubsections() throws Exception 
{
	
	
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,500)");
	researchexp.click();
	Thread.sleep(3000);
	Highlightelement("studytype");
	Thread.sleep(3000);
	Highlightelement("clinicalstudyphase");
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,850)");
	Thread.sleep(3000);
	Highlightelement("thereputicarea");
	Thread.sleep(3000);
	Highlightelement("totalclinical");
	Thread.sleep(3000);
	
	
	
	
    
        
}
		
	
		


public void verifyscreentext2() throws Exception 
{
	
	
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,500)");
	researchexp.click();
	Thread.sleep(3000);
	Highlightelement("screentext2");
	Thread.sleep(3000);
	if(screentext2.getText().contains("Select all types of studies which you have experience conducting"))
    {
        System.out.println("Onscreen Text pass");
        Thread.sleep(3000);
    }
    else
    {
    System.out.println("Onscreen Text Fail");
       
    }
	
		
	
    
        
}
		
	

public void verifyscreentext3() throws Exception 
{
	
	
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,500)");
	researchexp.click();
	Thread.sleep(3000);
	Highlightelement("screentext3");
	Thread.sleep(3000);
	if(screentext3.getText().contains("Select all phases for which you have experience"))
    {
        System.out.println("Onscreen Text pass");
        Thread.sleep(3000);
    }
    else
    {
    System.out.println("Onscreen Text Fail");
       
    }
	
	
}
public void verifyscreentext4() throws Exception 
{
	
	
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,850)");
	researchexp.click();
	Thread.sleep(3000);
	Highlightelement("screentext4");
	Thread.sleep(3000);
	if(screentext4.getText().contains("Identify the Therapeutic Area(s) in which you have expertise"))
    {
        System.out.println("Onscreen Text pass");
        Thread.sleep(3000);
    }
    else
    {
    System.out.println("Onscreen Text Fail");
       
    }
	
	
        
}
		
	
		
public void verifyscreentext5() throws Exception 
{
	
	
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,850)");
	researchexp.click();
	Thread.sleep(3000);
	Highlightelement("screentext5");
	Thread.sleep(3000);
	if(screentext5.getText().contains("Provide your completed and on-going studies by Therapeutic Area"))
    {
        System.out.println("Onscreen Text pass");
        Thread.sleep(3000);
    }
    else
    {
    System.out.println("Onscreen Text Fail");
       
    }
	
	
        
}
		
	
		


public void studytypeverification() throws Exception 
{
	
	
	
	Thread.sleep(3000);
	Highlightelement("academic");
	Thread.sleep(3000);
	Highlightelement("goverment");
	Thread.sleep(3000);
	Highlightelement("industry");
	Thread.sleep(3000);
	Highlightelement("nvestigatorinitiated");
	Thread.sleep(3000);
	Highlightelement("other");
	Thread.sleep(3000);
	
		
        
}
		
	
		


public void othercheckbox() throws Exception 
{
	
	
	
	Thread.sleep(3000);
	other.click();
	Thread.sleep(3000);
	
		
        
}
		
	
		



public void phaseverification() throws Exception 
{
	
	
	
	Thread.sleep(3000);
	Highlightelement("phase1");
	Thread.sleep(3000);
	Highlightelement("phase2");
	Thread.sleep(3000);
	Highlightelement("phase3");
	Thread.sleep(3000);
	Highlightelement("phase4");
	Thread.sleep(3000);
	
	
		
}


public void clickonsubmitcreditrequest() throws Exception 
{
	
	
	
	Thread.sleep(3000);
	submittrainingcreditrequest.click();
    Thread.sleep(3000);
	Set<String> windows = driver.getWindowHandles();
    Iterator<String> it=windows.iterator();
    String parentWindow = it.next();
    String childWindow = it.next();
    driver.switchTo().window(childWindow);
    ok9.click();
    Thread.sleep(4000);
    
	
	
		
}

public void AddCompletionDate(String TrainingType, String ProviderType, String CourseName) throws Exception 
{

	properties= obj.getProperty();

	Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
	testData.setTestDatainMap(TestDataInMap);
			
	Map<String,String> testDataInMap = testData.getTestDatainMap();
	String SelectDate = testDataInMap.get("Date");
	
	
	
	Thread.sleep(1000);
	SelectTrainingType.click();
	Select SelectTraining = new Select(SelectTrainingType);
	SelectTraining.selectByVisibleText(TrainingType);
	Thread.sleep(10000);
	TrainingProvider.click();
	Thread.sleep(1000);
	TrainingProvider.sendKeys(ProviderType);
	Thread.sleep(5000);
	Providerdata.click();
	Thread.sleep(5000);
	Searchbutton.click();
	Thread.sleep(10000);
	WebElement Courseraidobutton=driver.findElement(By.xpath("//td[contains(text(),'"+CourseName+"')]//..//input"));
	Courseraidobutton.click();
	Thread.sleep(2000);
	SelectCoursecompletiondate.click();
	Thread.sleep(8000);
	Datepicker.click();
	Thread.sleep(3000);
	SelectDatefield.click();
	Thread.sleep(8000);
	AddCompletionRecord.click();
	Thread.sleep(8000);

}



public void AddCompletionPage() throws Exception 
{

	properties= obj.getProperty();
	Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
	testData.setTestDatainMap(TestDataInMap);
	Map<String,String> testDataInMap = testData.getTestDatainMap();

	String Header_1 = testDataInMap.get("PageHeader1");
	Assert.assertEquals(Header_1, Header_1);
	System.out.print(Header_1);
	Thread.sleep(2000);
	}


public void ChooseFileold() throws Exception 
{

properties= obj.getProperty();
Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
testData.setTestDatainMap(TestDataInMap);
Map<String,String> testDataInMap = testData.getTestDatainMap();

String Header_2 = testDataInMap.get("PageHeader2");

Thread.sleep(3000);
WebElement chooseFile = driver.findElement(By.xpath("//*[@id=\"completionRecordFile\"]/input"));
chooseFile.sendKeys("\"C:\\Users\\545325\\Desktop\\Player Results Information.pdf\"");
Thread.sleep(4000);
ProvideAdditionaldetails.click();
Thread.sleep(8000);
Header2.isDisplayed();
System.out.print(Header_2);			

}


public void ReviewAndSubmit() throws Exception 
{
	
	properties= obj.getProperty();
	Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
	testData.setTestDatainMap(TestDataInMap);
	Map<String,String> testDataInMap = testData.getTestDatainMap();
	
	String Comment =testDataInMap.get("Comment1");
	
	Thread.sleep(4000);
	CommentArea.click();
	Thread.sleep(2000);
	CommentArea.sendKeys(Comment);
	Thread.sleep(2000);
	ReviewAndSubmitbutton.isEnabled();
	Thread.sleep(2000);
	ReviewAndSubmitbutton.click();
	Thread.sleep(8000);				
}


public void SubmitCredits() throws Exception 
{
		
	Thread.sleep(2000);
	Submitbutton.click();
	Thread.sleep(20000);
	}



public void GoToMyCreditPage() throws Exception 
{
			
	
	properties= obj.getProperty();
	Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
	testData.setTestDatainMap(TestDataInMap);
	Map<String,String> testDataInMap = testData.getTestDatainMap();
	
	String CourseName =testDataInMap.get("CourseName");
	
		Thread.sleep(2000);
		GoToMyCreditRequest.isEnabled();
		Thread.sleep(2000);
		GoToMyCreditRequest.click();
		
		WebElement RequestID = driver.findElement(By.xpath("//label[contains(text(),'"+CourseName+"')]//..//..//label[a]"));
		
		RequestID.click();
		Thread.sleep(5000);
		
}

public void Close() throws Exception 
{

	closeicon.click();
	Thread.sleep(2000);
}


public void SelectSomeoneElse() throws Exception 

{

Thread.sleep(5000);	
submitnewrequestbutton.click();
Thread.sleep(10000);
Okbutton.isEnabled();
Thread.sleep(5000);	
Okbutton.click();
System.out.println("CLickable");
Thread.sleep(8000);
SomeoneElseButton.click();
Thread.sleep(6000);
UserSelect.click();


}


public void CourseNotListedbutton() throws Exception 

{
	
	properties= obj.getProperty();
	Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
	testData.setTestDatainMap(TestDataInMap);
	Map<String,String> testDataInMap = testData.getTestDatainMap();
	
	String SiteUsername =testDataInMap.get("UserID");
	String TrainingType = testDataInMap.get("TrainingType");
	String ProviderType = testDataInMap.get("Provider");
	String SelectDate = testDataInMap.get("Date");
	String CourseName1 = testDataInMap.get("CourseName1");
	
	Thread.sleep(3000);
	UserSelect.sendKeys(SiteUsername);
	Thread.sleep(3000);
	SelectSomeoneelse.click();
	Thread.sleep(5000);
	SelectCourseBehalf.click();
	Thread.sleep(7000);
	Thread.sleep(1000);
	SelectTrainingType.click();
	Select SelectTraining = new Select(SelectTrainingType);
	SelectTraining.selectByVisibleText(TrainingType);
	Thread.sleep(10000);
	TrainingProvider.click();
	Thread.sleep(1000);
	TrainingProvider.sendKeys(ProviderType);
	Providerdata.click();
	Thread.sleep(5000);
	Searchbutton.click();
	Thread.sleep(10000);
	CourseNotlisted.isEnabled();
}


public void CourseNotListedpopup() throws Exception 

{
	
	properties= obj.getProperty();
	Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
	testData.setTestDatainMap(TestDataInMap);
	Map<String,String> testDataInMap = testData.getTestDatainMap();
	
	String Onscreentext =testDataInMap.get("protocolTitle");
	CourseNotlisted.click();
	Thread.sleep(5000);
	
   
        if (OnScreenText1.getText().contains(Onscreentext)) {
           
        	System.out.println("OnScreentext is displayed");	
        }
       
        else {
           
        	System.out.println("Text message is not as per expected");
           
        }
   
     
   

}
	

public void EnterCourseNotListedPage() throws Exception 

{
	properties= obj.getProperty();
	Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
	testData.setTestDatainMap(TestDataInMap);
	Map<String,String> testDataInMap = testData.getTestDatainMap();
	
	String Title =testDataInMap.get("CourseName");

	
	
	highLightElement(CourseTitle); 
	Thread.sleep(1500);
	highLightElement(TrainingTypedropdown);
	Thread.sleep(1500);
	highLightElement(NewTrainingProvider);
	Thread.sleep(1500);
	Boolean checkSaveIsEnabled = SubmitCourse.isEnabled();

	if (checkSaveIsEnabled == false) {
	System.out.println("Submit button is not enabled");
	}
	
	Thread.sleep(1500);
	CancelCourse.isEnabled();
}


 
public void TrainingTypeStudyNotPresent() throws Exception 

{
	TrainingTypedropdown.click();
	String[] exp = {"Study"};
	
	WebElement dropdown = driver.findElement(By.id("training_Type"));  
	 Select select = new Select(dropdown);  

	 List<WebElement> options = select.getOptions();  
	 for(WebElement we:options)  
	 {  
	  boolean match = false;
	  for (int i=0; i<exp.length; i++){
	      if (we.getText().equals(exp[i]))
	    		  {
	        match = true;
	      }
	    }
	  System.out.println("Study is not present in the dropdown");
	
	 }
	 TrainingTypedropdown.click();
	 Thread.sleep(4000);
	 
}

public void TrainingTypeCROPresent() throws Exception 

{
	
	Thread.sleep(2000);	
	 
	 String[] exp1 = {"CRO"};
		
		WebElement dropdown1 = driver.findElement(By.id("training_Type"));  
		 Select select1 = new Select(dropdown1);  

		 List<WebElement> options1 = select1.getOptions();  
		 for(WebElement we:options1)  
		 {  
		  boolean match = true;
		  for (int i=0; i<exp1.length; i++){
		      if (we.getText().equals(exp1[i]))
		    		  {
		        match = true;
		      }
		    }
		  System.out.println("CRO is present");
		 }  
		 
	
	
	
	
}


public void TrainingTypeSelet() throws Exception 

{
	properties= obj.getProperty();
	Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
	testData.setTestDatainMap(TestDataInMap);
	Map<String,String> testDataInMap = testData.getTestDatainMap();
	

	String Type = testDataInMap.get("TrainingType_1");
	
	TrainingTypedropdown.click();
	Thread.sleep(4000);
	Select SelectTraining = new Select(TrainingTypedropdown);
	SelectTraining.selectByVisibleText(Type);
	Thread.sleep(8000);
	

}

public void SponsorCROSelect() throws Exception 

{
	highLightElement(SponsorCROlabel);
	SponsorCROSelect.click();
	Thread.sleep(4000);
	

}


public void CRODisplay() throws Exception 

{
	properties= obj.getProperty();
	Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
	testData.setTestDatainMap(TestDataInMap);
	Map<String,String> testDataInMap = testData.getTestDatainMap();
	

	String Cro = testDataInMap.get("sponsorCompany");
	
	SponsorCROdropdown.click();
	Select SelectTraining = new Select(SponsorCROdropdown);
	SelectTraining.selectByVisibleText(Cro);
	Thread.sleep(4000);

}


public void SubmitCourses() throws Exception 

{
	properties= obj.getProperty();
	Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
	testData.setTestDatainMap(TestDataInMap);
	Map<String,String> testDataInMap = testData.getTestDatainMap();
	
	String CoursesTitle = testDataInMap.get("CourseName1");
	String TrainingProvider = testDataInMap.get("Provider_1");
	
	CourseTitle.sendKeys(CoursesTitle); 
	Thread.sleep(2500);
	NewTrainingProvider.sendKeys(TrainingProvider);
	Thread.sleep(1500);
	SubmitCourse.isEnabled();
	Thread.sleep(2000);
	SubmitCourse.click();
	Thread.sleep(10000);

}


public void AddCompletionDateUpdate() throws Exception 

{
	
	properties= obj.getProperty();
	Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
	testData.setTestDatainMap(TestDataInMap);
	Map<String,String> testDataInMap = testData.getTestDatainMap();
	
	String SelectDate = testDataInMap.get("Date");
	Datepicker.click();
	Thread.sleep(3000);
	SelectDatefield.click();
	
	Thread.sleep(8000);
	AddCompletionRecord.click();
	Thread.sleep(8000);
}

public void ChooseFileUpdated() throws Exception 

{
	Thread.sleep(3000);
	WebElement chooseFile = driver.findElement(By.xpath("//*[@id=\"completionRecordFile\"]/input"));
	chooseFile.sendKeys("\"C:\\Users\\545325\\Desktop\\Player Results Information.pdf\"");
	Thread.sleep(4000);
}

public void ReviewandSubmitScreenVerification() throws Exception 

{
	Thread.sleep(5000);
	RequestedBy.getText();
	highLightElement(RequestedBy);
	Thread.sleep(1000);
	highLightElement(RequestedByName);
	Thread.sleep(1000);
	Thread.sleep(1000);
	highLightElement(Requestedfor);
	Thread.sleep(1000);
	highLightElement(RequestedforName);
	Thread.sleep(1000);
	highLightElement(TrainingHeader);
	Thread.sleep(1000);
	highLightElement(CourseTitle1);
	Thread.sleep(1000);
	highLightElement(CourseTitleName);
	Thread.sleep(1000);
	highLightElement(SponsorCroType);
	Thread.sleep(1000);
	highLightElement(SponsorCroName);
	Thread.sleep(1000);
	highLightElement(TraningProvierheading);
	Thread.sleep(1000);
	highLightElement(TrainingProvidername);
	Thread.sleep(1000);
	highLightElement(Category);
	Thread.sleep(1000);
	highLightElement(StudyHeader);
	Thread.sleep(1000);
	highLightElement(StudyId);
	Thread.sleep(1000);
	highLightElement(Completiondate);
	Thread.sleep(3000);
	highLightElement(TrainingCompletdate);
	Thread.sleep(4000);
	
}




public void VerifytheRequestDisplayed() throws Exception 

{
	highLightElement(RequestId);
	Thread.sleep(2000);
	highLightElement(TrainingType);
	Thread.sleep(2000);
	highLightElement(CourseTitledata);
	Thread.sleep(2000);
	highLightElement(Datecompleted);
	Thread.sleep(2000);
	highLightElement(TrainingProviderName);
	Thread.sleep(2000);
	highLightElement(ReviewerName);
	Thread.sleep(2000);
	highLightElement(RequestedDate);
	Thread.sleep(2000);
	highLightElement(RequestedFor);
	Thread.sleep(2000);
	highLightElement(RequestBy);
	Thread.sleep(2000);
	highLightElement(TrainingStatus);
	Thread.sleep(2000);
	
	
	
}



public void verificationsent() throws Exception 

{
	Thread.sleep(3000);
	admin.click();
	Thread.sleep(5000);
	managedelegation.click();
	Thread.sleep(7000);
	adddelegate.click();
	Thread.sleep(3000);
	eneterdelegateemail.sendKeys("ab@_gmail.com");
	Thread.sleep(3000);
	delebutton.click();
	Thread.sleep(3000);
	sendregisinvitae.click();
	Thread.sleep(3000);
	okkkkks.click();
	Thread.sleep(3000);
	
}



public void verificationsent1() throws Exception 

{
	Thread.sleep(3000);
	admin.click();
	Thread.sleep(5000);
	managedelegation.click();
	Thread.sleep(7000);
	adddelegate.click();
	Thread.sleep(3000);
	eneterdelegateemail.sendKeys("ab@..gmail.com");
	Thread.sleep(3000);
	delebutton.click();
	Thread.sleep(3000);
	sendregisinvitae.click();
	Thread.sleep(3000);
	okkkkks.click();
	Thread.sleep(3000);
	
}



public void deleted1recordeducation() throws Exception 

{
	Thread.sleep(3000);
	cancelbutton1.click();
	Thread.sleep(3000);
	
}





public void clickonprint() throws Exception 

{
	Thread.sleep(3000);
	print1.click();
	Thread.sleep(3000);
	
}


public void clearsearchreport() throws Exception 

{
	Thread.sleep(3000);
	plus.click();
	Thread.sleep(3000);
	clearsearch11.click();
	Thread.sleep(3000);
	
	
}



public void changedatetimestamp() throws Exception 

{
	Thread.sleep(3000);
	createactioncolumn.click();
	Thread.sleep(3000);
	Robot robot1 = new Robot();  
    Thread.sleep(2000); 
    robot1.keyPress(KeyEvent.VK_RIGHT); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_RIGHT);
    Thread.sleep(2000);  
    robot1.keyPress(KeyEvent.VK_RIGHT); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_RIGHT);
    Thread.sleep(5000);
    robot1.keyPress(KeyEvent.VK_RIGHT); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_RIGHT);
    Thread.sleep(2000); 
    robot1.keyPress(KeyEvent.VK_RIGHT); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_RIGHT);
    robot1.keyPress(KeyEvent.VK_RIGHT); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_RIGHT);
    robot1.keyPress(KeyEvent.VK_RIGHT); 	
    Thread.sleep(2000);  
    robot1.keyRelease(KeyEvent.VK_RIGHT);
    Thread.sleep(3000);
	
	
}



public void checkutctime() throws Exception 

{
	Thread.sleep(3000);
	Highlightelement("utctimetext");
	Thread.sleep(3000);
	
	
}



public void verifychangeby() throws Exception 

{
	Thread.sleep(3000);
	Highlightelement("changebyy");
	Thread.sleep(3000);
	
	
}



public void clickonpreviewabbriviatedcv() throws Exception 

{
	Thread.sleep(3000);
	Userprofile.click();
	Thread.sleep(3000);
	MyProfile.click();
	Thread.sleep(3000);
	previewabbriviatedcv.click();
	Thread.sleep(3000);
	
	
}




public void sendallchangedforapprovalall() throws Exception 

{
	Thread.sleep(3000);
	sendallchangedforapprovalall.click();
	Thread.sleep(3000);
	okbutt.click();
	Thread.sleep(3000);
	
	
}



public void openanotheruserprofileprofileattachment() throws Exception 

{
	Thread.sleep(3000);
	completeyouruserprofile.click();
	Thread.sleep(5000);
	clickheree.click();
	Thread.sleep(5000);
	profileattachment.click();
	Thread.sleep(5000);
	uploadnewdoc.click();
	Thread.sleep(5000);
	chosefile.sendKeys("\"C:\\Users\\545325\\Desktop\\sample file\\depositphotos_128731134-stock-photo-100-number-with-targets-and.jpg\"");
	Thread.sleep(5000);
	uppload.click();
	Thread.sleep(5000);
	uploadnewdoc.click();
	Thread.sleep(5000);
	chosefile.sendKeys("\"C:\\Users\\545325\\Desktop\\sample file\\Facility Profile abhisikta.zip\"");
	Thread.sleep(5000);
	uppload.click();
	Thread.sleep(5000);
	uploadnewdoc.click();
	Thread.sleep(5000);
	chosefile.sendKeys("\"C:\\Users\\545325\\Desktop\\sample file\\HSBC CardNet nov 2019.pdf\"");
	Thread.sleep(5000);
	uppload.click();
	Thread.sleep(5000);
	uploadnewdoc.click();
	Thread.sleep(5000);
	chosefile.sendKeys("\"C:\\Users\\545325\\Desktop\\sample file\\Mandatory SIP-Training Courses_Anirban.xlsx\"");
	Thread.sleep(5000);
	uppload.click();
	Thread.sleep(5000);
	uploadnewdoc.click();
	Thread.sleep(5000);
	chosefile.sendKeys("\"C:\\Users\\545325\\Desktop\\sample file\\STEP_793695_Step.docx\"");
	Thread.sleep(5000);
	uppload.click();
	Thread.sleep(5000);
	uploadnewdoc.click();
	Thread.sleep(5000);
	chosefile.sendKeys("\"C:\\Users\\545325\\Desktop\\sample file\\val data.txt\"");
	Thread.sleep(5000);
	uppload.click();
	Thread.sleep(5000);
	uploadnewdoc.click();
	Thread.sleep(5000);
	chosefile.sendKeys("\"C:\\Users\\545325\\Desktop\\sample file\\valid img.jpg.png\"");
	Thread.sleep(5000);
	uppload.click();
	Thread.sleep(5000);
	uploadnewdoc.click();
	Thread.sleep(5000);
	
	
	
}



public void opendocument() throws Exception 

{
	Thread.sleep(3000);
	docname.click();
	Thread.sleep(3000);
	
	
	
}


public void removeicon() throws Exception 

{
	Thread.sleep(3000);
	removeicon.click();
	Thread.sleep(3000);
	
	
	
}


public void savebutt() throws Exception 

{
	Thread.sleep(3000);
	save4.click();
	Thread.sleep(3000);
	okkksss.click();
	Thread.sleep(3000);
	
	
}


public void clickduetoday() throws Exception 

{
	Thread.sleep(3000);
	Highlightelement("duetoday");
	Thread.sleep(3000);
	
	
}


public void facilityfieldsverification() throws Exception 

{
	Thread.sleep(3000);
	Highlightelement("primaryfaci");
	Thread.sleep(3000);
	Highlightelement("facilitynameaddress");
	Thread.sleep(3000);
	Highlightelement("departmentnameaddress");
	Thread.sleep(3000);
	Highlightelement("actions");
	Thread.sleep(3000);
	
}


public void sendmsgnotdisplayed() throws Exception 

{
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,600)");
	Thread.sleep(3000);
	action111.click();
	Thread.sleep(5000);
	
}


public void departmenttableverification() throws Exception 

{
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,300)");
	Thread.sleep(3000);
	action112.click();
	Thread.sleep(5000);
	Highlightelement("adddepartment");
	Thread.sleep(3000);
	Highlightelement("exportdepartment");
	Thread.sleep(3000);
	Highlightelement("removedepartment");
	Thread.sleep(3000);
	Highlightelement("sendmsgtpdpm");
	Thread.sleep(5000);
	
}


public void viewdepartment() throws Exception 

{
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,300)");
	Thread.sleep(3000);
	Highlightelement("viwdepartment");
	Thread.sleep(3000);
	
	
}


public void removefacility() throws Exception 

{
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,300)");
	Thread.sleep(3000);
	action.click();
	Thread.sleep(3000);
	removefacilitys.click();
	Thread.sleep(3000);
	okkies.click();
	Thread.sleep(3000);
}


public void removedepartment12() throws Exception 

{
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,300)");
	Thread.sleep(3000);
	action1112.click();
	Thread.sleep(3000);
	removeept.click();
	Thread.sleep(3000);
	okkies.click();
	Thread.sleep(3000);
}


public void clickontasktitle() throws Exception 

{
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(3000);
	tasktitle1.click();
	Thread.sleep(3000);
	clickhare2.click();
	Thread.sleep(3000);
	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	js2.executeScript("window.scrollBy(0,500)");
	Thread.sleep(3000);
	ExtentReportListner.captureSreenShots(driver);
	Thread.sleep(3000);
}


public void notabletoseePIhistory() throws Exception 

{
	
	Thread.sleep(3000);
	JavascriptExecutor js3 = (JavascriptExecutor) driver;
	js3.executeScript("window.scrollBy(0,500)");
	Thread.sleep(3000);
	ExtentReportListner.captureSreenShots(driver);
	Thread.sleep(3000);
}


public void clickondoc() throws Exception 

{
	
	Thread.sleep(3000);
	JavascriptExecutor js3 = (JavascriptExecutor) driver;
	js3.executeScript("window.scrollBy(0,500)");
	Thread.sleep(3000);
	doc1.click();
	Thread.sleep(3000);
}


public void PIselectionandsubmit() throws Exception 

{
	
	Thread.sleep(3000);
	JavascriptExecutor js3 = (JavascriptExecutor) driver;
	js3.executeScript("window.scrollBy(0,300)");
	Thread.sleep(3000);
	askPI.click();
	Thread.sleep(8000);
    PIdropdown.click();
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
    Thread.sleep(3000);
	submit.click();
	Thread.sleep(3000);
}


public void clcikonviewmoreandverify() throws Exception 

{
	
	Thread.sleep(3000);
	
	
	
	Thread.sleep(3000);
}
public void verifyuploadform() {
	// TODO Auto-generated method stub
	
}

public void Click_On_ADDSHIPPINGLOCATIONButton() throws Exception{
	ADDSHIPPINGLOCATIONButton.click();
	Thread.sleep(2000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", LocalLab);
}

public void Click_On_Country_DropDown_Under_INVESTIGATIONAL_PRODUCT_SHIPPING_DETAILS() throws Exception {
	
	try{
		ADDSHIPPINGLOCATIONCountry.sendKeys("United");
		Thread.sleep(2000);
	}catch(Exception e){}
	
	
	try{
		ADDSHIPPINGLOCATIONCountry3.sendKeys("United");
		Thread.sleep(2000);
	}catch(Exception e){}

}

public void Select_Country_Under_INVESTIGATIONAL_PRODUCT_SHIPPING_DETAILS() throws Exception{
	properties=obj.getProperty();
	Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
	testData.setTestDatainMap(TestDataInMap);	
	Map<String,String> testDataInMap = testData.getTestDatainMap();
	String Country=testDataInMap.get("CountryField");
	Thread.sleep(3000);
	
	
	try{
		ADDSHIPPINGLOCATIONCountry.clear();
		ADDSHIPPINGLOCATIONCountry.sendKeys(Country);
		ADDSHIPPINGLOCATIONCountry.sendKeys(Keys.ARROW_DOWN);
		ADDSHIPPINGLOCATIONCountry.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}catch(Exception e){}

	
	try{
		ADDSHIPPINGLOCATIONCountry3.clear();
		ADDSHIPPINGLOCATIONCountry3.sendKeys(Country);
		ADDSHIPPINGLOCATIONCountry3.sendKeys(Keys.ARROW_DOWN);
		ADDSHIPPINGLOCATIONCountry3.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}catch(Exception e){}
	
}

public void Click_On_State_DropDown_Under_INVESTIGATIONAL_PRODUCT_SHIPPING_DETAILS() throws Exception{
	
	try{
		ADDSHIPPINGLOCATIONState.sendKeys("F");
		Thread.sleep(2000);
	}catch(Exception e){}
	
	try{
		ADDSHIPPINGLOCATIONState3.sendKeys("F");
		Thread.sleep(2000);
	}catch(Exception e){}
	

}


public void Select_State_Under_INVESTIGATIONAL_PRODUCT_SHIPPING_DETAILS() throws Exception{
	properties=obj.getProperty();
	Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
	testData.setTestDatainMap(TestDataInMap);	
	Map<String,String> testDataInMap = testData.getTestDatainMap();
	String State=testDataInMap.get("State");
	Thread.sleep(3000);
	
	try{
		ADDSHIPPINGLOCATIONState.clear();
		ADDSHIPPINGLOCATIONState.sendKeys(State);
		ADDSHIPPINGLOCATIONState.sendKeys(Keys.ARROW_DOWN);
		ADDSHIPPINGLOCATIONState.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}catch(Exception e){}
	
	try{
		ADDSHIPPINGLOCATIONState3.clear();
		ADDSHIPPINGLOCATIONState3.sendKeys(State);
		ADDSHIPPINGLOCATIONState3.sendKeys(Keys.ARROW_DOWN);
		ADDSHIPPINGLOCATIONState3.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}catch(Exception e){}
	
	
}
public void Enter_Invalid_Email() {
	try{
		ADDSHIPPINGLOCATIONEmail.sendKeys("9190982345");
	}catch(Exception e){}
	
	try{
		highLightElement(ADDSHIPPINGLOCATIONEmailError);
	}catch(Exception e){}
	
	
	
	try{
		ADDSHIPPINGLOCATIONEmail3.sendKeys("9190982345");
	}catch(Exception e){}
	
	try{
		highLightElement(ADDSHIPPINGLOCATIONEmailError3);
	}catch(Exception e){}
	
}
public void Enter_Valid_Email() {
	try{
		ADDSHIPPINGLOCATIONEmail.clear();
		ADDSHIPPINGLOCATIONEmail.sendKeys("dsadiq.777@gmail.com");
		
	}catch(Exception e){}
	
	try{
		ADDSHIPPINGLOCATIONEmail3.clear();
		ADDSHIPPINGLOCATIONEmail3.sendKeys("dsadiq.777@gmail.com");
		
	}catch(Exception e){}


}
public void Enter_Data_in_Remaining_Fields() throws Exception {
	try{
		ADDSHIPPINGLOCATIONTstreetName.sendKeys("CityStreet 465");
		Thread.sleep(1000);
		ADDSHIPPINGLOCATIONCity.sendKeys("Hawai");
		Thread.sleep(1000);
		ADDSHIPPINGLOCATIONPhone.sendKeys("98497765436");
		Thread.sleep(1000);
		ADDSHIPPINGLOCATIONTFaxNumber.sendKeys("556675");
	}catch(Exception e){}
	
	
	try{
		ADDSHIPPINGLOCATIONTstreetName3.sendKeys("CityStreet 465");
		Thread.sleep(1000);
		ADDSHIPPINGLOCATIONCity3.sendKeys("Hawai");
		Thread.sleep(1000);
		ADDSHIPPINGLOCATIONPhon3.sendKeys("98497765436");
		Thread.sleep(1000);
		ADDSHIPPINGLOCATIONTFaxNumber3.sendKeys("556675");
	}catch(Exception e){}
	
}
	

public void Verify_Add_Shipping_Location_Button_is_disable() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", ADDSHIPPINGLOCATIONState);

try{
	if(!ADDSHIPPINGLOCATIONButton.isEnabled()){
		System.out.println("Test Pass");
	}
	
	
}catch(Exception e){
	
		System.out.println("Test Fail");
}

	
}

public void EnterIPRecipientName(String arg1){
	try{
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollTo(0,100)");
		ADDSHIPPINGLOCATIONTIPRecipientName.clear();
		ADDSHIPPINGLOCATIONTIPRecipientName.sendKeys(arg1);
	}catch(Exception e){}
	
	
	try{
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollTo(0,100)");
		ADDSHIPPINGLOCATIONTIPRecipientName3.clear();
		ADDSHIPPINGLOCATIONTIPRecipientName3.sendKeys(arg1);
	}catch(Exception e){}
	
}
public void ClickOnRemoveShippingAddress(int n) {
	WebElement RemoveBtn=driver.findElement(By.id("btnShippingLocDelete_"+n+""));
	RemoveBtn.click();
	
	
}
public void ClickOnCancelOfRemoveShippingAddress(int n) {
	WebElement CancelBtn=driver.findElement(By.xpath("(//button[text()='Cancel'])["+n+"]"));
	CancelBtn.click();
	
}
public void ClickOnOKOfRemoveShippingAddress(int n) {
	WebElement OkBtn=driver.findElement(By.xpath("(//button[text()='OK'])["+n+"]"));
	OkBtn.click();
}

@FindBy(how=How.XPATH, using="//i[contains(@class,'bell')]")
public WebElement Site_User_Bell;

@FindBy(how=How.XPATH, using="//*[@id='notifList']//h6[text()[normalize-space() = 'View more']]")
public WebElement View_More;


public void NavigateToNotification()throws Exception{
	highLightElement(Site_User_Bell);
	Thread.sleep(500);
	Site_User_Bell.click();
	Thread.sleep(500);
	View_More.click();
}

public void verify_Facility_Profile_Management_Notifications_In_Notification_Screen(int fac,int dept) throws Throwable {
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    String Fac_Name = testDataInMap.get("Facility_"+fac);
    String Dept_Name = testDataInMap.get("Department_"+dept);
	
    highLightElement(driver.findElement(By.xpath("//tbody/tr/td[4]/div[contains(text(),'Complete Department Profile for') and contains(text(),'"+Fac_Name+"') and contains(text(),'"+Dept_Name+"')]")));
	
}

public void verify_Facility_Profile_Management_Notifications_In_Notification_Screen(int fac) throws Throwable {
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    String Fac_Name = testDataInMap.get("Facility_"+fac);
	
    highLightElement(driver.findElement(By.xpath("//tbody/tr/td[4]/div[contains(text(),'Complete Department Profile for') and contains(text(),'"+Fac_Name+"')]")));
	
}

public void verify_Facility_Profile_Management_Notifications_Not_Displayed_In_Notification_Screen(int fac) throws Throwable {
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    String Fac_Name = testDataInMap.get("Facility_"+fac);
	
    try {
    highLightElement(driver.findElement(By.xpath("//tbody/tr/td[4]/div[contains(text(),'Complete Department Profile for') and contains(text(),'"+Fac_Name+"')]")));
    driver.quit();
    }
    catch(Exception e)
    {
    	 TakesScreenshot webdriver = null;
		 TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    }
}

public void verify_Facility_Profile_Management_Notifications_Assignment_Of_Facility_Role(int fac) throws Throwable {
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    String Fac_Name = testDataInMap.get("Facility_"+fac);
    
    WebElement wb=driver.findElement(By.xpath("(//div[contains(text(),'has assigned you to the following role(s) for the Facility:') and contains(text(),'"+Fac_Name+"') and contains(.,'This assignment will allow you to view critical Facility information.') and contains(.,'Delegation Manager')])[1]"));
    CommonClass.highLightElement(driver, wb);
}

public void verify_Facility_Profile_Management_Notifications_Assignment_Of_Department_Role(int fac,int dept) throws Throwable {
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    String Fac_Name = testDataInMap.get("Facility_"+fac);
    String Department_Name = testDataInMap.get("Department_"+dept);
    
    
    WebElement wb=driver.findElement(By.xpath("(//div[contains(text(),'has assigned you to the following role(s) for the "+Department_Name+"') and contains(text(),'"+Fac_Name+"') and contains(.,'This assignment will allow you to view critical Department information.') and contains(.,'Delegation Manager')])[1]"));
    CommonClass.highLightElement(driver, wb);
}

public void verify_Facility_Profile_Management_Notifications_Assignment_Of_Facility_Role_Not_Displayed(int fac) throws Throwable {
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    String Fac_Name = testDataInMap.get("Facility_"+fac);
    try {
    WebElement wb=driver.findElement(By.xpath("(//div[contains(text(),'has assigned you to the following role(s) for the Facility:') and contains(text(),'"+Fac_Name+"') and contains(.,'This assignment will allow you to view critical Facility information.') and contains(.,'Delegation Manager')])[1]"));
    CommonClass.highLightElement(driver, wb);
    }
    catch(Exception e)
    {
    	
    }
}

public void verify_Study_New_Notification_Is_Displayed_For_Study(int arg1) throws Throwable {
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    String StudyID = testDataInMap.get("studyID"+arg1);
	String sponsorCompany=testDataInMap.get("sponsorCompany");
	
	DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
	java.util.Date date=new java.util.Date();  
	String CurrentDate = dateFormat.format(date);
	System.out.println(CurrentDate);
	
	CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//*[@id='fixTable-3']//td[3]/div[text()[normalize-space() = '"+CurrentDate+"']])[1]")));	
	CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//*[@id='fixTable-3']//div[text()[normalize-space() = '"+sponsorCompany+" has published Study News']])[1]")));
	CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//*[@id='fixTable-3']//td[3]/div[text()[normalize-space() = '"+CurrentDate+"']]//..//..//..//td[5]//div[contains(text(), '"+sponsorCompany+" has published Study News')]//../*[contains(text()[2],'"+StudyID+"')])[1]")));
}

public void verify_Study_New_Notification_Is_Not_Displayed_For_Study(int arg1) throws Throwable {
	
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    
    DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
	java.util.Date date=new java.util.Date();  
	String CurrentDate = dateFormat.format(date);
	System.out.println(CurrentDate);
    String StudyID = testDataInMap.get("studyID"+arg1);
	String sponsorCompany=testDataInMap.get("sponsorCompany");
	try {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//*[@id='fixTable-3']//td[3]/div[text()[normalize-space() = '"+CurrentDate+"']])[1]")));	
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//*[@id='fixTable-3']//div[text()[normalize-space() = '"+sponsorCompany+" has published Study News']])[1]")));
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//*[@id='fixTable-3']//td[3]/div[text()[normalize-space() = '"+CurrentDate+"']]//..//..//..//td[5]//div[contains(text(), '"+sponsorCompany+" has published Study News')]//../div[contains(text()[2],'"+StudyID+"])[1]")));
	}
	catch(Exception e)
	{
		ExtentReportListner.captureSreenShots(driver);
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//*[@id='fixTable-3'])[1]")));
	}
}

public void verify_Site_User_Site_Role_Removed_From_Study_By_Delegation_Manager_Notification(int SiteUser, int StudyID) throws Throwable {
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    
    String Study_ID = testDataInMap.get("studyID"+StudyID);
    String SiteUser_FirstName = testDataInMap.get("SiteUser"+SiteUser+"_FirstName");
    String SiteUser_MiddleName = testDataInMap.get("SiteUser"+SiteUser+"_MiddleName");
    String SiteUser_LastName = testDataInMap.get("SiteUser"+SiteUser+"_LastName");
    CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//*[@id=\"fixTable-3\"]/tbody/tr/td[5]/div[contains(text(),\""+SiteUser_FirstName+" "+SiteUser_LastName+" has been removed as a Safety Contact from SIP study workspace "+Study_ID+" :\")])[1]")));	
}
    

public void verify_Site_User_Site_Role_Removed_From_Study_By_Delegation_Manager_Notification2(int SiteUser, int StudyID) throws Throwable {
	properties= obj.getProperty();
	   
    Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
    testData.setTestDatainMap(TestDataInMap);
           
    Map<String,String> testDataInMap = testData.getTestDatainMap();
    
    String Study_ID = testDataInMap.get("studyID"+StudyID);
    String SiteUser_FirstName = testDataInMap.get("SiteUser"+SiteUser+"_FirstName");
    String SiteUser_MiddleName = testDataInMap.get("SiteUser"+SiteUser+"_MiddleName");
    String SiteUser_LastName = testDataInMap.get("SiteUser"+SiteUser+"_LastName");
    
    
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//*[@id=\"fixTable-3\"]/tbody/tr/td[5]/div[contains(text(),\""+SiteUser_FirstName+" "+SiteUser_LastName+" has been removed as a Regulatory Contact (PI Delegate) from SIP study workspace "+Study_ID+" :\")])[1]")));	
    
	
}


}