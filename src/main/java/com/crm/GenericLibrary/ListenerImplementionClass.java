package com.crm.GenericLibrary;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenerImplementionClass implements ITestListener
{

	public void onFinish(ITestContext context) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	/**
	 * This method gets executed on failure of the test script and it will take screenshot of that moment of failure
	 */
	public void onTestFailure(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		Reporter.log(MethodName+"---testscript execution failed",true);
		
		// step 1 configure screenshot name
		String screenshotname= MethodName+" "+new Javautility().getSystemDateInFormat();
		System.out.println(screenshotname);
		
		//Step 2 using screenshot method name from webdriver utility
		try {
			new WebDriverUtility().getScreenShot(BaseClass.sdriver, screenshotname);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		Reporter.log(MethodName+"---testscript execution skipped",true);
	}

	public void onTestStart(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		Reporter.log(MethodName+"---testscript execution started",true);
		
	}

	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		Reporter.log(MethodName+"---testscript execution successfull-PASS",true);
	}

	
}
