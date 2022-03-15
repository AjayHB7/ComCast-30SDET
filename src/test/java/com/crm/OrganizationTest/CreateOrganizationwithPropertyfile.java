package com.crm.OrganizationTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;

public class CreateOrganizationwithPropertyfile extends BaseClass
{
	@Test
	public void createorganizationwithpropertyfile() throws IOException
	{		
		//step 4 navigate to the organization
		driver.findElement(By.linkText("Organizations")).click();
		
		//step 5 click on create organization
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		// step 6 create organization by entering all mandatory fields
		driver.findElement(By.name("accountname")).sendKeys("neworg1");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
	}
}
