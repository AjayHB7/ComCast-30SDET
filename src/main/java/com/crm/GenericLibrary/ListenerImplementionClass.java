package com.crm.GenericLibrary;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementionClass implements ITestListener
{
	ExtentReports report;
	ExtentTest test;

	// suite level
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./ExtentReports/Report"+new Javautility().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("SDET-30 Execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Selenium Execution Report");

		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Browser", "Chrome");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Base-url", "http://localhost:8888");
		report.setSystemInfo("Reporter Name", "AjayKumar");

	}

	// suite level
	public void onFinish(ITestContext context) {
		report.flush();
	}


	public void onTestStart(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		Reporter.log(MethodName+"---testscript execution started",true);
		test = report.createTest(MethodName);

	}

	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		Reporter.log(MethodName+"---testscript execution successfull-PASS",true);
		test.log(Status.PASS, MethodName+"-------->passed");
	}



	/**
	 * This method gets executed on failure of the test script and it will take screenshot of that moment of failure
	 */
	public void onTestFailure(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		Reporter.log(MethodName+"---testscript execution failed",true);
		String path = null;
		// step 1 configure screenshot name
		String screenshotname= MethodName+" "+new Javautility().getSystemDateInFormat();
		System.out.println(screenshotname);

		//Step 2 using screenshot method name from webdriver utility
		try {
			path = new WebDriverUtility().getScreenShot(BaseClass.sdriver, screenshotname);


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.FAIL, result.getThrowable());
		test.addScreenCaptureFromPath(path);

	}

	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		Reporter.log(MethodName+"---testscript execution skipped",true);

		// It will capture the exception and log it in the report
		test.log(Status.SKIP, result.getThrowable());

	}










	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

}
