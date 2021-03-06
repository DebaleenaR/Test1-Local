package com.testautomatiom.Listeners;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;
import com.testautomation.Utility.BrowserUtility;
import com.testautomation.Utility.PropertiesFileReader;

import java.util.Properties;
import cucumber.api.java.it.Date;
import java.util.*;

public class ExtentReportListner {
	private static final String ScreenshotImageFormat = null;
	public static ExtentHtmlReporter report = null;
	public static ExtentReports extent = null;
	public static ExtentTest test = null;
	static PropertiesFileReader obj = new PropertiesFileReader();
	
	public static ExtentReports setup() {

		//String reportLocation = "./Reports/Extent_Report.html";
	
		String reportLocation = "./Reports/"+gettestname()+"_"+getcurrentdateandtime()+"Extent_Report.html";
		String newdirPath = createDirectory();
//		newdirPath = newdirPath.replace("./", "/");
//		System.out.println(newdirPath);
		
		String reportLocation1 = createDirectory()+"/"+gettestname()+"_"+getcurrentdateandtime()+"Extent_Report.html";
		
		
		String reportLocation2 = createDirectory()+"/"+"SummrayReport_"+getcurrentdateandtime()+"Extent_Report.html";
		
		
//		System.out.println("reportLocation:"+reportLocation);
		//System.out.println(reportLocation1);
		
		
		report = new ExtentHtmlReporter (reportLocation2);
		report.config().setDocumentTitle("Automation Test Report");
		report.config().setReportName("Automation Test Report");
		report.config().setTheme(Theme.STANDARD);
		System.out.println("Extent Report location initialized...");
		report.start();
		
		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Application", "SIP");
		extent.setSystemInfo("OS:", System.getProperty("os.name"));
		extent.setSystemInfo("User Name:", System.getProperty("user.name"));
		System.out.println("System info set in Extent Report");
		
		return extent;
	
	}
	
	public static void testStepHandle(String teststatus,WebDriver driver,ExtentTest extenttest,Throwable throwable) {
	switch (teststatus){
	case "FAIL":
		extenttest.fail(MarkupHelper.createLabel("Test Case is Failed.", ExtentColor.RED));
		extenttest.error(throwable.fillInStackTrace());
		
		if (driver!=null) {
			driver.quit();
		}
		break;
	
	case "PASS":
		extenttest.pass(MarkupHelper.createLabel("Test Case is Passed.", ExtentColor.GREEN));
		break;
	
	default:
		break;
		}
		
	}
	

	public static String captureSreenShots(WebDriver driver) throws IOException 
	{

		
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
	
	//	String dest ="./Reports/Screenshots/"+gettestname()+getcurrentdateandtime()+".png";
		
//		System.out.println("dirUSER"+System.getProperty("user.dir"));
	
		//	String dest =System.getProperty("user.dir")+"/Reports/Screenshots/"+gettestname()+getcurrentdateandtime()+".png";
		
	//	String dest =System.getProperty("user.dir")+"/Reports/Screenshots/"+gettestname()+getcurrentdateandtime()+".png";
		
		String dest =System.getProperty("user.dir")+createScreenShotDirectory()+"/"+gettestname()+getcurrentdateandtime()+".png";
	//	String dest ="C:\\Users\\232256\\Desktop\\R&D\\NewWorkSpace_toUpload\\SeleniumCucumberBDDFramework\\Reports\\Screenshots\\"+gettestname()+getcurrentdateandtime()+".png";

		
		if(dest.indexOf("screenshots") != -1)
		{
			dest = dest.substring(dest.indexOf("screenshots"));
			System.out.println("destination:"+dest);
		}
		
		System.out.println("destination:"+dest);
		//dest = dest.replace(".","");
		File target = new File(dest);
		
		String newtarget = dest.replace("C:\\Selenium Projects\\FP_UP_General_Study\\SeleniumCucumberBDDFramework\\SeleniumCucumberBDDFramework", "..");
		
	    System.out.println("newtarget:"+ newtarget);
	    String newtarget10 = newtarget.replace(".../Reports", "");
	    String newtarget11 = newtarget10.replace("/", "\\");
//	    String newtarget12 = newtarget11.replace("...", "..");
	    
	    System.out.println("newtarget12:"+ newtarget11);
	    
				
		String newtarget1 = newtarget.replace("/", "\\");
		System.out.println("newtarget1:"+ newtarget1);
		
		
		Files.copy(src, target);
				
//		String newtarget2 = newtarget1.replace("...", "..");
		
		
//		System.out.println("return target"+newtarget2);
		//System.out.println("return target3"+newtarget3);
	
		return newtarget11;
		
		
	} 	

	
	
	private static String getcurrentdateandtime() 
	{
		String str = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
//			Date date;
//			date = new Date(); 
			java.util.Date date=new java.util.Date();  
			//Date date = new Date();
			str = dateFormat.format(date);
			str = str.replace(" ", "").replaceAll("/","").replaceAll(":", "");
			} catch (Exception e) {
				
			}
		 return str;
		
	}
	
	
	
	private static String getdate() 
	{
		String strdate = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//			Date date;
//			date = new Date(); 
			java.util.Date date=new java.util.Date();  
			//Date date = new Date();
			strdate = dateFormat.format(date);
			strdate = strdate.replace(" ", "").replaceAll("/","");
			} catch (Exception e) {
				
			}
		 return strdate;
		
	}
	
	
	private static String gettestname() 
	{
		String testcasename=null;
		
		
		try {
			Properties properties= obj.getProperty();
			String testname = properties.getProperty("TestCaseId");
			testcasename=testname;
			
		} catch (Exception e) {
				
			}
		 return testcasename;
		
	}
	
	
	private static String createDirectory() 
	{
		String directoryname=null;
		
		
		try {
			
			String dirPath = "./Reports/";
//			dirPath = dirPath + getdate()+"_"+gettestname();
			dirPath = dirPath + getdate()+"_SummaryReport";
			File file = new File(dirPath);
			
			
			boolean exists = file.exists();
			
			
			
			if(exists){
		         System.out.println("Directory already exist.");
//		         System.out.println("createDirectory:"+dirPath);
		      }else{
		    	  
		    	  boolean bool = file.mkdir();
		         System.out.println("Directory created successfully");
		      }
			
			directoryname= dirPath;
			
		} catch (Exception e) {
				
			}
		 return directoryname;
		
	}
	
	
	
	private static String createScreenShotDirectory() 
	{
		String screndirectoryname=null;
		
		
		try {
			
			String dirPath = createDirectory()+"/";
//			System.out.println(dirPath);
			dirPath = dirPath +"Screenshots";
			File file = new File(dirPath);
			
			boolean exists = file.exists();
			
			
			if(exists){
		         System.out.println("ScreenShot Directory exists");
//		         System.out.println("createScreenShotDirectory:"+dirPath);
		      }else{
		    	  boolean bool = file.mkdir();
		         System.out.println("ScreenShot Directory created successfully");
		      }
			
			
			screndirectoryname= dirPath;
			
		} catch (Exception e) {
				
			}
		 return screndirectoryname;
		
	}
	
	
	
	

}
