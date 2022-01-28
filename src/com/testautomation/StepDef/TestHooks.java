package com.testautomation.StepDef;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;
import java.util.Properties;

import com.testautomation.Utility.PropertiesFileReader;

import cucumber.api.Scenario;
import cucumber.api.java.*;

public class TestHooks {
	
//	Properties properties;
	PropertiesFileReader obj = new PropertiesFileReader();

	@Before
	public void beforeScenario(Scenario scenario) throws IOException 
	{
//		System.out.println("Started Execution Scenario "+scenario.getSourceTagNames());
		Collection<String> Tcname = scenario.getSourceTagNames();
		String ScenarioName = scenario.getName();
		
		System.out.println("Tcname"+Tcname);
		
		Optional<String> firstElement = Tcname.stream().findFirst();
		System.out.println("firstElement"+firstElement);
		
		String tc = Tcname.toString();
    	String[] tc1 = tc.split("@");
    	
    	String tc2 = tc1[1];
    	String tc3[] = tc2.split("]");
    	String tc4 = tc3[0];
		String Tcid = tc4;
    	
		System.out.println("Tcid"+Tcid);
		
//		String Tcname = 
//		Properties properties= obj.getProperty();
		obj.propertieswrite("TestCaseId",Tcid);
		obj.propertieswrite("ScenarioName",ScenarioName);
		
//		properties.setProperty("TestCaseId", Tcname);
	}
	
	



	@After
	public void afterScenario(Scenario scenario) 
	{
		System.out.println("Finished Execution Scenario "+scenario.getName());
	}
	
	
}
