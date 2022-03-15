package com.crm.ProductModule;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
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

public class DelectTheExistingCustomizedFilterTest extends BaseClass
{
	@Test
	public void editingCustomViewTest() throws Throwable
	{
		boolean flag = false;

		// read data from Excel file
		String filtername = elib.readDataFromExcel("product", 7, 2);

		// navigate to the products link
		driver.findElement(By.linkText("Products")).click();

		// select from the drop down
		WebElement ele1 = driver.findElement(By.name("viewname"));
		wlib.select(ele1, filtername);

		// click on delete link
		driver.findElement(By.xpath("//a[.='Delete']")).click();

		//accept the alert popup
		wlib.acceptAlert(driver);

		// verification
		WebElement ele2 = driver.findElement(By.name("viewname"));
		Select sel1 = new Select(ele2);

		List<WebElement> options = sel1.getOptions();

		for (WebElement webele : options)
		{
			String text = webele.getText();
			if(text.equals(filtername))
			{
				flag = true;
				System.out.println("filter is not deleted");
				break;
			}
		}
		if(flag==false)
		{
			System.out.println("filter is deleted");

		}	
	}
}
