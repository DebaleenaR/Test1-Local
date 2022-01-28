package com.testautomation.PageObjects;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testautomatiom.Listeners.ExtentReportListner;
import com.testautomation.Utility.ExcelHandler;
import com.testautomation.Utility.PropertiesFileReader;
import com.testautomation.Utility.TestDataHandler;

public class CommonClass extends ExtentReportListner {

		WebDriver driver;
		static WebDriver driver1;
		
		PropertiesFileReader obj = new PropertiesFileReader();
		Properties properties;
		WebDriverWait wait;
		TestDataHandler testData = new TestDataHandler();

		public static void highLightElement(WebDriver driver, WebElement element) throws IOException  
		{
	    	JavascriptExecutor js=(JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	    	try 
			{
			    Thread.sleep(1000);
			} 
			catch (InterruptedException e) {
			
			    System.out.println(e.getMessage());
			} 
	    	ExtentReportListner.captureSreenShots(driver);
			js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 
		}
    	
    	public static void highLightElement1(WebElement element)  {
    		
    		JavascriptExecutor js=(JavascriptExecutor)driver1;
        	
        	js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        	try 
    		{
    		    Thread.sleep(1000);
    		} 
    		catch (InterruptedException e) {
    		
    		    System.out.println(e.getMessage());
    		} 
        		
    		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 
    		
    	}
    
    	public static void scroll(WebDriver driver)throws Exception
    	{
    		JavascriptExecutor js=(JavascriptExecutor)driver;
    		js.executeScript("scroll(0,1000)");
    		Thread.sleep(4000);
    	}
    	
    	public static void scroll1(WebDriver driver)throws Exception
    	{
    		JavascriptExecutor js=(JavascriptExecutor)driver;
    		js.executeScript("scroll(0,0)");
    		Thread.sleep(4000);
    	}
    	public static void scroll2(WebDriver driver)throws Exception
    	{
    		JavascriptExecutor js=(JavascriptExecutor)driver;
    		js.executeScript("scroll(0,250)");
    		Thread.sleep(4000);
    	}
    	public static void scroll3(WebDriver driver)throws Exception
    	{
    		JavascriptExecutor js=(JavascriptExecutor)driver;
    		js.executeScript("scroll(0,500)");
    		Thread.sleep(4000);
    	}
    	public static void scroll4(WebDriver driver)throws Exception
    	{
    		JavascriptExecutor js=(JavascriptExecutor)driver;
    		js.executeScript("scroll(0,750)");
    		Thread.sleep(4000);
    	}
    	
    	public static void scroll6(WebDriver driver)throws Exception
    	{
    		JavascriptExecutor js=(JavascriptExecutor)driver;
    		js.executeScript("scroll(0,900)");
    		Thread.sleep(4000);
    	}
    	
    	public static void scroll7(WebDriver driver)throws Exception
    	{
    		JavascriptExecutor js=(JavascriptExecutor)driver;
    		js.executeScript("scroll(0,950)");
    		Thread.sleep(4000);
    	}
    	
    	public static void scroll5(WebDriver driver)throws Exception
    	{
    		JavascriptExecutor js=(JavascriptExecutor)driver;
    		js.executeScript("scroll(0,100)");
    		Thread.sleep(4000);
    	}
    	public static void switchToDefaultWindow(WebDriver driver)throws Exception
    	{
    		driver.switchTo().defaultContent();

    	}
    	public static void HorizantalScroll(WebDriver driver, Object recpientRole)throws Exception
    	{
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", recpientRole);
        Thread.sleep(2000);
    	}

    	
    	public static void SIPtoSafeDX(WebDriver driver)throws Exception
    	{
    		driver.switchTo().frame("unifiedViewContainer");

    	}
    	public static void SafeDXtoSIP(WebDriver driver)throws Exception
    	{
    		driver.switchTo().defaultContent();

    	}
    	public static void Alert(WebDriver driver)throws Exception
    	{
    		Alert alert = driver.switchTo().alert();
    		alert.accept();

    	}
    	@FindBy(how = How.ID, using = "//a[@id='sponsor-login-btn']")
    	public WebElement sponsorLoginButton;
    	
    	@FindBy(how = How.ID, using = "userid")
    	public WebElement usernameTextBox;
    	
    	@FindBy(how = How.XPATH, using = "//*[@id=\"p_p_id_TCSIPpublicLoginRegistrationPortlet_WAR_TCSIPPublicHomePortlet100_\"]/div/div[2]/a")
    	public WebElement loginButton;
    	
    	@FindBy(how = How.XPATH, using = "//select[@class='showRowsSelect']")
    	public WebElement ShowRowDropdown;
    	
    	public void ShowrowDropdownSelection(String RowAmount) throws Exception {
    		Select ShowrowDropdownOption = new Select (ShowRowDropdown);
    		ShowrowDropdownOption.selectByVisibleText(RowAmount);
    		Thread.sleep(3000);
    	}
    	@FindBy(how = How.XPATH, using = "//*[@id='notificationDropdown']//i[contains(@class,'bell')]")
    	public WebElement NotificationBellIcon;
    	
    	@FindBy(how = How.XPATH, using = "//a[text()='View more>>']")
    	public WebElement ViewMoreOption;
    	
    	public static void NavigateToChildWindow(WebDriver driver) throws Exception {
    		Set<String> windows = driver.getWindowHandles();
            Iterator<String> it=windows.iterator();
            String parentWindow = it.next();
            String childWindow = it.next();
            driver.switchTo().window(childWindow);
            Thread.sleep(2000);
    	}
    	
    	public static void NavigateToParentWindow(WebDriver driver) throws Exception {
    		Set<String> windows = driver.getWindowHandles();
            Iterator<String> it=windows.iterator();
            String parentWindow = it.next();
            String childWindow = it.next();
            driver.switchTo().window(parentWindow);
            Thread.sleep(2000);
    	}
    	
    	
    	
    	public void SiteUserNotificationNavigation() throws Exception {
    		CommonClass.scroll1(driver);
    		System.out.println("Inside method");
    		CommonClass.highLightElement(driver, NotificationBellIcon);
    		NotificationBellIcon.click();
    		Thread.sleep(500);
    		Robot r1 = new Robot();
    		r1.keyPress(KeyEvent.VK_TAB);
    		r1.keyRelease(KeyEvent.VK_TAB);
    		r1.keyPress(KeyEvent.VK_ENTER);
    		r1.keyRelease(KeyEvent.VK_ENTER);
    		//ViewMoreOption.click();
    		Thread.sleep(10000);
    	}
    	public void calendarSelect1(String datetobeselected) throws Exception
    	{
    	WebElement dateWidgetFrom = driver.findElement(By.xpath("//div[@class='k-widget k-calendar']//./tbody"));
    	List<WebElement> rows = dateWidgetFrom.findElements(By.tagName("tr"));
    	List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));



    	String dateselect = datetobeselected;
    	String[] dateselect1 = dateselect.split("-");
    	String day = dateselect1[0];
    	String month = dateselect1[1];
    	String year = dateselect1[2];

    	Thread.sleep(3000);
    	for (WebElement cell: columns) {

    	if (cell.getText().equals(month)) {
    	cell.click();

    	WebElement dateWidgetFrom1 = driver.findElement(By.xpath("//div[@class='k-widget k-calendar']//./tbody"));
    	List<WebElement> rows1 = dateWidgetFrom1.findElements(By.tagName("tr"));
    	List<WebElement> columns1 = dateWidgetFrom1.findElements(By.tagName("td"));

    	for (WebElement cell1: columns1) {
    	Thread.sleep(3000);
    	if (cell1.getText().equals(day)) {
    	System.out.println(day);
    	cell1.click();
    	break;
    	}

    	}
    	break;
    	}
    	}
    	}
    	public void calendarSelect3(String datetobeselected) throws Exception
        {
           
            WebElement dateWidgetFrom = driver.findElement(By.xpath("//div[@class='k-widget k-calendar']//./tbody"));
           
            List<WebElement> rows = dateWidgetFrom.findElements(By.tagName("tr"));
            List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
           
           
            String dateselect = datetobeselected;
            String[] dateselect1 = dateselect.split("-");
           
           
            String month = dateselect1[0];
            String year = dateselect1[1];
           
           
//            int d1=Integer.parseInt(day);
//            day=String.valueOf(d1);
           
           
            System.out.println(month);
//            System.out.println(day);
            System.out.println(year);
           
            Thread.sleep(1000);
           
           
           
       
           
            for (WebElement cell2: columns) {
           
                System.out.println(cell2.getText());
           
           
                 if (cell2.getText().equals(year)) {
                       
                        System.out.println(year);
                        cell2.click();
                     
                     
                        WebElement dateWidgetFrom2 = driver.findElement(By.xpath("//div[@class='k-widget k-calendar']//./tbody"));
                     
                          List<WebElement> rows2 = dateWidgetFrom2.findElements(By.tagName("tr"));
                          List<WebElement> columns2 = dateWidgetFrom2.findElements(By.tagName("td"));
           
               
           
                          for (WebElement cell: columns2) {
                
                              System.out.println(cell.getText());
                      
                              if (cell.getText().equals(month)) {
                   
                                  System.out.println(month);
                                  cell.click();
                                          
                                   System.out.println("date selected");
                                  break;
                  
                                 }      
                       
                               
                        }
               
                      break;   
                    }
           
               
     }
       
       
           
    }
    	
    	
  

}
