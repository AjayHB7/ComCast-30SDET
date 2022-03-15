package com.crm.ProductModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtilty;
import com.crm.GenericLibrary.Javautility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ApproveTheExistingCustomizedFilterTest extends BaseClass
{
	@Test
	public void approveTheExistingCustomizedFilter() throws Throwable
	{
		
		// read data from Excel file
		String filtername = elib.readDataFromExcel("product", 10, 2);
		


		// navigate to the products link
		driver.findElement(By.linkText("Products")).click();

		// select the dropdown
		WebElement ele1 = driver.findElement(By.id("viewname"));
		wlib.select(ele1, filtername);

		// click on approve link
		driver.findElement(By.xpath("//a[.='Approve']")).click();

		// logout to the application
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.waitForElementToBeVisible(driver, ele);
		wlib.mouseHover(driver, ele);

		



	}

}
