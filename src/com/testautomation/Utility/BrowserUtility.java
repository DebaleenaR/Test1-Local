package com.testautomation.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserUtility 
{
	public static WebDriver OpenBrowser(WebDriver driver, String browserName, String url) throws InterruptedException
	{
		System.out.print(browserName);
		
		if (browserName.equals("Chrome"))
		{
			
			
			String chromeDriverPath = "C:\\ChromeDriver\\91_version\\chromedriver.exe";
			String downloadFilepath = System.getProperty("user.dir")+"\\Reports\\Download";
			File[] files = new File(downloadFilepath).listFiles();
			for(File file: files) 
			    if (!file.isDirectory()) 
			        file.delete();
			System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\91_version\\chromedriver.exe");
	
			
			Map<String, Object> prefs = new HashMap<String, Object>();
	        prefs.put("download.default_directory" , downloadFilepath);
	        Thread.sleep(1000);
	        ChromeOptions options = new ChromeOptions();
	        options.setExperimentalOption("prefs", prefs);
	        driver= new ChromeDriver(options);
	        			
			driver.manage().deleteAllCookies();  
	        driver.get("chrome://settings/clearBrowserData");
	        driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
	        Thread.sleep(8000);
	        
	        driver.manage().window().maximize();
			driver.get(url);
	        Thread.sleep(5000);
	        return driver;

	        
		} else if (browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","C:\\\\ChromeDriver\\\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);            		
	        Thread.sleep(5000);
	        return driver;
		}
		return null;
	}
	
	

}
