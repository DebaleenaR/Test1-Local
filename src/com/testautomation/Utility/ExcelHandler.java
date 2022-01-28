package com.testautomation.Utility;

import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelHandler {
	
	static Properties properties;
	static PropertiesFileReader obj = new PropertiesFileReader();
	
	public static Map<String, String> getTestDataInMap (String testDataFile,String sheetName,String TestCaseId) throws Exception
	
	{
		Map<String, String> TestDataInMap = new TreeMap<String, String>();
		String query = null;
		query = String.format("SELECT * FROM %s WHERE RUN = 'Yes' and TestCaseId = '%s'",
		sheetName,TestCaseId);
		
		
		Fillo fillo = new Fillo();
		Connection conn = null;
		Recordset recordset = null;
		try
		
		{
			conn= fillo.getConnection(testDataFile);
			recordset = conn.executeQuery(query);
			while(recordset.next()) 
			{
				for(String field:recordset.getFieldNames())
				{
					TestDataInMap.put(field, recordset.getField(field));
				}
			}
			
		}
		
		catch (FilloException e)
		{
			e.printStackTrace();
			throw new Exception ("Testdata not found...");
			
		}
		
		conn.close();
		return TestDataInMap;
		
	}
	
	
	public  static void setTestdata (String fieldId,String value) throws Exception
	
	{
		
	 	properties= obj.getProperty();
	    String testDataFile = properties.getProperty("testDataFilePath");
	    String sheetName = properties.getProperty("sheetName");
	    String TestcaseId = properties.getProperty("TestCaseId");
	    System.out.println(testDataFile);
	   
	    String query1 = "UPDATE "+sheetName+" Set "+fieldId+" ='"+value+"' WHERE Run = 'Yes' and TestCaseId = '"+TestcaseId+"'";
	    System.out.println(query1);
		
		Fillo fillo = new Fillo();
		Connection conn = null;
		
		try
		
		{
			conn= fillo.getConnection(testDataFile);
			conn.executeUpdate(query1);
						
		}
		
		catch (FilloException e)
		{
			e.printStackTrace();
			throw new Exception ("Testdata not updated...");
			
		}
		
		conn.close();
		
		
	}
	

}
