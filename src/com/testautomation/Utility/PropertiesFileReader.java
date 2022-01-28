package com.testautomation.Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;

public class PropertiesFileReader {
	
	public Properties getProperty() throws IOException
	{
		FileInputStream inputStream = null;
		
		Properties properties = new Properties();
		
		try {
			properties.load(new FileInputStream("resources/input-config.properties"));
					
							
				
		} catch (Exception e)
			{
				System.out.println("Exception :"+ e);
			}
		return properties;
	}
	
	
	
	public void propertieswrite(String key,String value) throws IOException
	{
//		OutputStream outputStream = null;
		FileOutputStream outputStream = null;
		
		Properties properties = new Properties();
		
		
		try {
			properties.load(new FileInputStream("resources/input-config.properties"));
					
							
				
		} catch (Exception e)
			{
				System.out.println("Exception :"+ e);
			}
		
		
		properties.setProperty(key, value);
		
		
		 try {
			 
			 properties.store(new FileOutputStream("resources/input-config.properties"), null);
         } 
		 
		 catch (IOException e) {
           
			 System.out.println(e);
         }
		
		
		
//		try {
//			outputStream = (new FileOutputStream("resources/input-config.properties"));
//					
//			propertieswrite(key, value);
//			propertieswrite.store(outputStream, null);
////			saveProperties(propertieswrite);
//			
//		} catch (Exception e)
//			{
//				System.out.println("Exception :"+ e);
//			}
//		return properties;
	}



//	private void propertieswrite(String key, String value) {
//		// TODO Auto-generated method stub
//		
//	}
	
	
	
		
}
