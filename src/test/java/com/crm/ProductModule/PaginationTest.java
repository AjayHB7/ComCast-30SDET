package com.crm.ProductModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.Format;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.RichTextString;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PaginationTest 
{
	@Test
	public void paginationTest() throws Throwable
	{
		// step 1 read all necessary data from external files
		// read data from properties file

		FileInputStream fin = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pro = new Properties();
		pro.load(fin);
		String BROWSER = pro.getProperty("browser");
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");

		//read data from excel sheet
		FileInputStream finn = new FileInputStream(".\\src\\test\\resources\\test data.xlsx");
		Workbook wb = WorkbookFactory.create(finn);
		Sheet sheet = wb.getSheet("product");
		Row ro = sheet.getRow(16);
		Cell c1 = ro.getCell(2);
		String filtername = c1.getStringCellValue();
		Cell c2 = ro.getCell(4);
		//String pagenumber = c2.getStringCellValue();
		//String pagenumber1 = pagenumber.toString();

		double pagenum = c2.getNumericCellValue();
		int pagenumb=(int)pagenum;

		//launch the browser
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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);

		// step 2 login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// navigate to the products link
		driver.findElement(By.linkText("Products")).click();

		// select the dropdown
		WebElement ele1 = driver.findElement(By.id("viewname"));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(filtername);

		// enter the page number
		driver.findElement(By.xpath("(//input[@name='pagenum'])[1]")).clear();
		driver.findElement(By.xpath("(//input[@name='pagenum'])[1]")).sendKeys(""+pagenumb+"");

		//click on next button
		driver.findElement(By.xpath("(//img[@src='themes/images/next_disabled.gif'])[1]")).click();
		
		// logout to the application
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ele));
		Actions act1 = new Actions(driver);
		act1.moveToElement(ele).perform();

		//click on signout button
		driver.findElement(By.linkText("Sign Out"));


		// close the application
		driver.close();
	}

}
