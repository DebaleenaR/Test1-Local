package com.testautomatiom.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;

public class ITestListenerImpl extends ExtentReportListner implements ITestListener
{
	private static ExtentReports extent;
	
	public void onFinish(ITestContext result) {
		// TODO Auto-generated method stub
		System.out.println("Execution Finished....Report generated..");
		extent.flush();
	}

	public void onStart(ITestContext result) {
		// TODO Auto-generated method stub
		System.out.println("Execution Started....");
		extent= setup();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Failed");
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Skipped");
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Started....");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(" Test Passed");
		
	}

}
