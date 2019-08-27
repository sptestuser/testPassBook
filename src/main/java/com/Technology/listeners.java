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
		try {
		 File file= new File("low-risk.prop");
	        if(file.exists()){
	        	file.delete();
	        }
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	public void onStart(ITestContext context) {
		try {
			FileOutputStream fos = new FileOutputStream("low-risk.prop");
	        fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onFinish(ITestContext context) {
		
	}
}
