package com.crm.GenericLibrary;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplemention implements IRetryAnalyzer
{
	int count = 0;
	int retrycount = 3;

	public boolean retry(ITestResult arg0) {
		while(count<retrycount)
		{
			count++;
			return true;
		}
		return false;
	}

}
