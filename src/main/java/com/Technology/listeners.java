package com.Technology;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listeners implements ITestListener {
	Base baseClass=new Base();

	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Listners Passed");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Listners Failed");
		baseClass.getScrnShot();	
	}
	
	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}
}
