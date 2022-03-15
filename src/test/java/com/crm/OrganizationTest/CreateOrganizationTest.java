package com.crm.OrganizationTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.google.common.annotations.VisibleForTesting;
import com.mysql.jdbc.Driver;

public class CreateOrganizationTest extends BaseClass
{
	@Test
	public void createOrganizationTest()
	{
		String orgname = "allstates"+jlib.getRandomNumber();
		// step 3 navigate to organization link
		driver.findElement(By.linkText("Oganization")).click();

		// step 4 click on create organization link
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		// step 5 create organization with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys(orgname);

		//step 6 click on save button
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	}

}
