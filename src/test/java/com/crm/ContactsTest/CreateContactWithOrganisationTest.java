package com.crm.ContactsTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtilty;
import com.crm.GenericLibrary.Javautility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactsInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreatingNewContactsPage;
import com.crm.ObjectRepository.CreatingNewOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationsPage;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrganisationTest extends BaseClass
{
	@Test
	public void  createContactsTest() throws Throwable
	{

		//read data from excel sheet
		String lastName= elib.readDataFromExcel("contact", 4, 1)+jlib.getRandomNumber();
		String orgName= elib.readDataFromExcel("contact", 4, 2)+jlib.getRandomNumber();



		// navigate to the organization button
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganization();

		//click on create organization button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgBtn();		

		// Enter all the mandatory fields and click on save
		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
		cop.createNewOrg(orgName);

		// verification
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.orgNameInfo();
		if(actOrgName.contains(orgName))
		{
			System.out.println(actOrgName+"----> is verified");
		}else{
			System.out.println(actOrgName+"----> is invailed");
		}

		// navigate to the create link and click
		hp.clickOnContacts();

		// click on create new button
		ContactsPage cp = new ContactsPage(driver);
		cp.clickoncreatecontactsImg();

		//enter all mandatory fields and click on save
		CreatingNewContactsPage ccp = new CreatingNewContactsPage(driver);
		ccp.createNewContact(driver, lastName, orgName);

		//verification
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String header = cip.contactNameInfo();
		if(header.contains(lastName))
		{
			System.out.println(header+"----> is created");
		}else
		{
			System.out.println("contact is not created");
		}
	}

}
