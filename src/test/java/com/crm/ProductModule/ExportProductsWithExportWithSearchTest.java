package com.crm.ProductModule;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtilty;
import com.crm.GenericLibrary.Javautility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExportProductsWithExportWithSearchTest 
{
	@Test
	public void exportProductsWithExportWithSearch() throws Throwable
	{
		//read are the nesseccary data from external files
		// read data from properties file
		Javautility jlib = new Javautility();
		PropertyFileUtility plib = new PropertyFileUtility();
		ExcelFileUtilty elib = new ExcelFileUtilty();
		WebDriverUtility wlib = new WebDriverUtility();

		// read data from property file
		String BROWSER = plib.readDataFromPropertyFile("browser");
		String URL = plib.readDataFromPropertyFile("url");
		String USERNAME = plib.readDataFromPropertyFile("username");
		String PASSWORD = plib.readDataFromPropertyFile("password");

		//launch the browser and get the url
		
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		
		WebDriver driver = null;
		if(BROWSER.equalsIgnoreCase("chrome")){
			driver= new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox")){
			driver= new FirefoxDriver();
		}else{
			System.out.println("invalid browser");
		}
		wlib.maximizeWindow(driver);
		wlib.waitForPageLoad(driver);
		driver.get(URL);

		// step 2 login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// navigate to the products link
		driver.findElement(By.linkText("Products")).click();

		// click on export product look up button
		driver.findElement(By.xpath("//img[@title='Export Products']")).click();
		
		//click on radio button and click export products
		driver.findElement(By.xpath("//input[@value='includesearch']")).click();
		driver.findElement(By.name("Export")).click();

		//click ok button on file download popup by using Robot class
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		// logout to the application
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.waitForElementToBeVisible(driver, ele);
		wlib.mouseHover(driver, ele);

		//click on signout button
		driver.findElement(By.linkText("Sign Out"));


		// close the application
		driver.close();

	}

}
