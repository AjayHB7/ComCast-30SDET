package com.crm.PRACTICE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LogInToAppUsingPOM 
{
	@Test
	public void pacticeLogIn()
	{
		WebDriverManager.chromedriver().setup();
		WebDriverUtility wlib = new WebDriverUtility();
		WebDriver driver = new ChromeDriver();
		wlib.maximizeWindow(driver);
		wlib.waitForPageLoad(driver);
		driver.get("http://localhost:8888/");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp("admin", "admin");
		
		HomePage hp =new HomePage(driver);
		hp.clickOnContacts();
		hp.signOutOfApp(driver);
		
	
		
		
	}

}
