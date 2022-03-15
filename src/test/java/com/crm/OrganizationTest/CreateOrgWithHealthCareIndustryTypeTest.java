package com.crm.OrganizationTest;

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
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreatingNewOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationsPage;
import com.crm.Products.CreateCampaignwithProductNameTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgWithHealthCareIndustryTypeTest extends BaseClass
{
	@Test
	public void createOrgWithHealthCareIndustryTypeTest() throws Throwable
	{
		// read data from Excel sheet
		String orgName = elib.readDataFromExcel("org", 3, 1)+jlib.getRandomNumber();
		String indusType = elib.readDataFromExcel("org", 3, 2);

		// navigate to the organization button and click
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganization();		

		// click on create new organization button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgBtn();

		// create on organization choosing industry type
		CreatingNewOrganizationPage cno = new CreatingNewOrganizationPage(driver);
		cno.createNewOrg(orgName, indusType);

		// verification
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String header = oip.orgNameInfo();
		if(header.contains(orgName))
		{
			System.out.println(header+"----> is created");
		}else
		{
			System.out.println("organization is not created");
		}

	}

}
