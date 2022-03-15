package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyFilePractice 
{
	@Test
	public void propertyFilePractice() throws IOException
	{
		//read data from property file
		FileInputStream fin = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pro = new Properties();
		pro.load(fin);
	    String BROWSER = pro.getProperty("browser");
	    String URL = pro.getProperty("url");
	    String USERNAME = pro.getProperty("username");
	    String PASSWORD = pro.getProperty("password");
	    
	    //Print the values from property file- verification
	    System.out.println(BROWSER);
	    System.out.println(URL);
	    System.out.println(USERNAME);
	    System.out.println(PASSWORD);
	    
	}

}
