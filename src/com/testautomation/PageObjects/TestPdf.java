package com.testautomation.PageObjects;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.util.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testautomation.Utility.BrowserUtility;
import com.testautomation.Utility.ExcelHandler;
import com.testautomation.Utility.PropertiesFileReader;
import com.testautomation.Utility.TestDataHandler;



public class TestPdf {
	
	WebDriver driver;
	Properties properties;
	PropertiesFileReader obj = new PropertiesFileReader();
	TestDataHandler testData = new TestDataHandler();
	
	public TestPdf(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
//	@FindBy(how=How.XPATH, using="//i[@class='fa fa-caret-down']")
//	public WebElement logoutmenu;
//	public void openBrowser_URL() throws Exception
//	{
//		Properties properties= obj.getProperty();
//		driver = BrowserUtility.OpenBrowser(driver, properties.getProperty("browser.name"), properties.getProperty("browser.baseURL"));
//		
//				
//    }
	
	
	public void readpdf() throws Exception
	{
//		URL testurl = new URL("http://www.axmag.com/download/pdfurl-guide.pdf");
		URL testurl = new URL("file:///C://Users//232256//Downloads//Safety_Acknowledgement_Status_Tracking_Report.pdf");
//		String testurl = "C:\\Automation_Projects\\docTest\\DIL2.pdf";
//		driver.get(testurl);
		BufferedInputStream testfile =new BufferedInputStream(testurl.openStream());
		PDFParser testpdf = new PDFParser(testfile);
		testpdf.parse();
		String testtext = new PDFTextStripper().getText(testpdf.getPDDocument());
				//				getText(testpdf.getDocument());
		System.out.println("text in the pdf file:" +testtext);
		
//		Assert.assertTrue(testtext.contains("Open the setting.xml, you can see it is like this"));
	}
	

	public void verifyFilter() throws Exception
	{

		URL testurl = new URL("file:///C://Users//232256//Downloads//Safety_Acknowledgement_Status_Tracking_Report.pdf");
		BufferedInputStream testfile =new BufferedInputStream(testurl.openStream());
		PDFParser testpdf = new PDFParser(testfile);
		testpdf.parse();
		String testtext = new PDFTextStripper().getText(testpdf.getPDDocument());
			System.out.println("text in the pdf file:" +testtext);
		String commatch ="Compound : "	;
		
		
		if (testtext.contains(commatch+"CCompound01_Updated,CCompound03_Update")) {
			System.out.println("comp matched");
		} else {
			
			System.out.println("comp not matched");
		}
		

	}
	
	public void returnRecord() throws Exception
	{

//		URL testurl = new URL("file:///C://Users//232256//Downloads//Document_Inventory_Report (1).pdf");
		
		URL testurl = new URL("file:///C://Users//232256//Downloads//Safety_Acknowledgement_Status_Tracking_Report (1) (1).pdf");
		
		
		BufferedInputStream testfile =new BufferedInputStream(testurl.openStream());
		PDFParser testpdf = new PDFParser(testfile);
		testpdf.parse();
		
		String testtext = new PDFTextStripper().getText(testpdf.getPDDocument());
//		System.out.println("text in the pdf file:" +testtext);
		
//			String rec1[] = testtext.split("Workflow Initiator");
			String rec1[] = testtext.split("Period Range");
		
			System.out.println("record for one data" +rec1[1]);
			
			String rec2[] = rec1[1].split("\n2 ");
		
			System.out.println("record for one data" +rec2[0]);
		
		

	}
	
	
	
	public void reportarchive () {
	
	 Path temp;
	try {
		temp = Files.move 
			        (Paths.get("C://Users//232256//Downloads//Safety_Acknowledgement_Status_Tracking_Report (1) (1).pdf"),  
			        Paths.get("C://Users//232256//Downloads//Archive//Safety_Acknowledgement_Status_Tracking_Report (1) (1).pdf"));
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		  
		    
	}
	
	public void reportarchiveandRename () throws Exception {
		
		 Path temp;
		 
		
			properties= obj.getProperty();
			String tcid = properties.getProperty("TestCaseId");
		
		 
		try {
			temp = Files.move 
				        (Paths.get("C://Users//232256//Downloads//Site_User_Safety_Notification_Access_Report.pdf"),  
				        Paths.get("C://Users//232256//Downloads//Archive//Site_User_Safety_Notification_Access_Report"+"_"+tcid+"_"+getcurrentdateandtime()+".pdf"));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			  
			    
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
	
	
	
	
	public void verifyFilterSNAccessReportandarchive() throws Exception
	{
	
//		URL Path should be fetched from data sheet and to be customized by string operation 
		URL testurl = new URL("file:///C://Users//232256//Downloads//Site_User_Safety_Notification_Access_Report.pdf");
		BufferedInputStream testfile =new BufferedInputStream(testurl.openStream());
		PDFParser testpdf = new PDFParser(testfile);
		testpdf.parse();
		
		
		properties= obj.getProperty();
		
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testDataFilePath"),properties.getProperty("sheetName"),properties.getProperty("TestCaseId"));
		testData.setTestDatainMap(TestDataInMap);
				
		Map<String,String> testDataInMap = testData.getTestDatainMap();
				
		String compound = testDataInMap.get("Compound");
		
		
		String testtext = new PDFTextStripper().getText(testpdf.getPDDocument());
		System.out.println("text in the pdf file:" +testtext);
		String commatch ="Compound : "	;
		
		
		if (testtext.contains(commatch+compound)) {
			
			System.out.println("comp matched");
		
		} else {
			
			System.out.println("comp not matched");
		}
		
		
		
		reportarchiveandRename();

	}
	
	
	public void TestreportarchiveandRename () throws Exception {
		
		 Path temp;
		 
		
			properties= obj.getProperty();
			String tcid = properties.getProperty("TestCaseId");
		
			
		 
		try {
			temp = Files.move 
				        (Paths.get("C://Users//232256//Desktop//PDFARCHIVE//New folder1//Potential Investigator Report_16-Mar-2021 16_59_37 UTC.pdf"),  
				        Paths.get(createDirectory()+"//Potential Investigator Report_16-Mar-2021 16_59_37 UTC.pdf"));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			  
			    
		}
	
	
	private static String createDirectory() 
	{
		String directoryname=null;
		
		
		try {
			
			String dirPath = "C://Users//232256//Desktop//PDFARCHIVE//";

			dirPath = dirPath + getdate()+"tc";
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
	
	
	
	

}
