package com.crm.OpportunitiesModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
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
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;

public class AdvancedSearchTC36Test extends BaseClass
{
	@Test
	public void advancedSearchTC36() throws Throwable
	{
		
		// read from excel sheet
		FileInputStream finn = new FileInputStream(".\\src\\test\\resources\\test data.xlsx");
		Workbook wb = WorkbookFactory.create(finn);
		Sheet st = wb.getSheet("Opportunities");
		Cell c1 = st.getRow(1).getCell(2);
		String oppname = c1.getStringCellValue();

		Cell c2 = st.getRow(1).getCell(3);
		String relatedto = c2.getStringCellValue();

		Cell c3 = st.getRow(1).getCell(4);
		String conname = c3.getStringCellValue();

		Cell c4 = st.getRow(1).getCell(5);
		String salestage = c4.getStringCellValue();

		Cell c5 = st.getRow(1).getCell(6);
		String advseroption = c5.getStringCellValue();
		
		Cell c6 = st.getRow(1).getCell(7);
		String startswith = c6.getStringCellValue();

		
		// click on opportunities link
		driver.findElement(By.linkText("Opportunities")).click();

		//click on create new opportunities button
		driver.findElement(By.xpath("//img[@alt='Create Opportunity...']")).click();

		//enter all mandatory fields and click on save button
		driver.findElement(By.name("potentialname")).sendKeys(oppname);
		WebElement ele1 = driver.findElement(By.id("related_to_type"));
		Select rsel = new Select(ele1);
		rsel.selectByVisibleText(relatedto);

		driver.findElement(By.xpath("//input[@id='related_to_display']/following-sibling::img[@title='Select']")).click();

		String pid = driver.getWindowHandle();

		Set<String> alids = driver.getWindowHandles();
		for (String alid : alids) 
		{
			if(!(alid==pid))
			{
				driver.switchTo().window(alid);
			}
		}
		// search for a contact name
		driver.findElement(By.id("search_txt")).sendKeys(conname);
		driver.findElement(By.name("search")).click();

		// select a contact
		driver.findElement(By.linkText(conname)).click();

		//switch back to parent window
		driver.switchTo().window(pid);

		//click on save button
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//verification
		String verifioppname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		if(verifioppname.contains(oppname))
		{
			System.out.println("opportunities is created");
		}else{
			System.out.println("opportunities is not created");
		}

		// click on opportunities link
		driver.findElement(By.linkText("Opportunities")).click();

		//click on advanced search
		driver.findElement(By.linkText("Go to Advanced Search")).click();

		//select from dropdown 
		WebElement ddele = driver.findElement(By.id("fcol0"));
		Select seldd= new Select(ddele);
		seldd.selectByVisibleText(advseroption);

		//select from dropdown 
		WebElement ddele2 = driver.findElement(By.id("fop0"));
		Select seldd2= new Select(ddele2);
		seldd2.selectByVisibleText(startswith);

		
		driver.findElement(By.id("fval0")).sendKeys(oppname);
		//can't interact with the element
		// click on search button
		WebElement searchnow = driver.findElement(By.xpath("//table[@class='searchUIAdv3 small']//input[@value=' Search Now ']"));
		System.out.println(searchnow.getText());
		searchnow.click(); 
		
		//verifying if the data is displayed 
		WebElement ele3 = driver.findElement(By.linkText("vjhvj"));
		if(ele3.isDisplayed()){
			System.out.println("data is displayed");
		}else {
			System.out.println("data is not displayed");
		}
	
	}

}
