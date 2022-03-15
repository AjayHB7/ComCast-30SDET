package com.crm.PRACTICE;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.Javautility;
import com.crm.GenericLibrary.PropertyFileUtility;

public class PracticeGenericUtils
{
	@Test
	public void practice() throws Throwable
	{
		//print random number
		Javautility jLib = new Javautility();
		int random = jLib.getRandomNumber();
		System.out.println(random);

		//print system date
		String date = jLib.getSystemDate();
		System.out.println(date);

		//print system date in format
		String dateformat = jLib.getSystemDateInFormat();
		System.out.println(dateformat);
		

		//read data from property file
		PropertyFileUtility pro = new PropertyFileUtility();
		String BROWSER = pro.readDataFromPropertyFile("browser");
		String URL = pro.readDataFromPropertyFile("url");
		String USERNAME = pro.readDataFromPropertyFile("username");
		String PASSWORD = pro.readDataFromPropertyFile("password");

		//print data from property file
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);

	}


}
