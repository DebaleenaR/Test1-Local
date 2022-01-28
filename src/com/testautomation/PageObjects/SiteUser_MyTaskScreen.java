package com.testautomation.PageObjects;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testautomation.Utility.PropertiesFileReader;
import com.testautomation.Utility.TestDataHandler;

public class SiteUser_MyTaskScreen {

	public WebDriver driver;
	Properties properties;
	WebDriverWait wait;
	
	PropertiesFileReader obj = new PropertiesFileReader();
	TestDataHandler testData = new TestDataHandler();
	
	public SiteUser_MyTaskScreen(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver,25000);
	}
	
	@FindBy(how=How.XPATH, using="//*/a[contains(text(),'View Potential Studies')]")
	public WebElement viewPotentialStudies;
	
	@FindBy(how=How.ID, using="showHide")
	public WebElement showHide_MyTask_SiteUser;
	
	
	public void select_Task_Description_Option_From_Show_Hide_Dropdown_In_My_Task_Screen() throws Throwable {
		showHide_MyTask_SiteUser.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Task Description']//../span/span")).click();
		Thread.sleep(1500);
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_ESCAPE);
		r1.keyRelease(KeyEvent.VK_ESCAPE);
	}
	
	public void sort_Task_Received_Date_In_Ascending_Order() throws Throwable {
	    driver.findElement(By.xpath("(//*[@id='received']/div/a[@title='Sort']/span)[1]")).click();
	}
	
	public void verify_User_Profile_Management_Tasks_For_Organization_Association_Task() throws Throwable {
	    CommonClass.highLightElement(driver, driver.findElement(By.xpath("(//*[@id='allTaskViewMoreTable']/tbody/tr/td[contains(text(),'has delegated their User Profile to your Organization. Please claim the pending task to assign yourself as delegate')])[1]//../td[3]//a")));
	}
	
	public void click_On_User_Profile_Management_Tasks_For_Organization_Association_Task() throws Throwable {
		 driver.findElement(By.xpath("(//*[@id='allTaskViewMoreTable']/tbody/tr/td[contains(text(),'has delegated their User Profile to your Organization. Please claim the pending task to assign yourself as delegate')])[1]//../td[3]//a")).click();
	}
	
	
	public void click_On_Accept_Task_Button_In_User_Profile_Task_PopUp() throws Throwable {
		CommonClass.highLightElement(driver, driver.findElement(By.xpath("//*[@id='userProClaimDiv']/input[@id='userProfClaimBtn']")));
		driver.findElement(By.xpath("//*[@id='userProClaimDiv']/input[@id='userProfClaimBtn']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@title=\"Close\"]/span")).click();
	}

}
