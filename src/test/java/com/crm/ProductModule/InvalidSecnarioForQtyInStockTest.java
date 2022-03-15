package com.crm.ProductModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
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

public class InvalidSecnarioForQtyInStockTest 
{
	@Test
	public void invalidSecnarioForQtyInStock() throws Throwable
	{
		// read all the data from external files
		// read all the data from external files
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

		// read data from Excel file
		String productname = elib.readDataFromExcel("product", 25, 2);
		String qtyinstock = elib.readDataFromExcel("product", 25, 3);
	
		//launch the browser
		
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}else{
			System.out.println("invaild browser");
		}
		
		wlib.maximizeWindow(driver);
		wlib.waitForPageLoad(driver);
		driver.get(URL);

		// step 2 login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		//navigate to products and create a product 
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		//enter product name
		driver.findElement(By.name("productname")).sendKeys(productname);
		//enter qty in stock
		driver.findElement(By.xpath("//input[@id='qtyinstock']")).sendKeys(qtyinstock);

		//click on save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//switch to alert popup and click on okay button
		wlib.acceptAlert(driver);

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
