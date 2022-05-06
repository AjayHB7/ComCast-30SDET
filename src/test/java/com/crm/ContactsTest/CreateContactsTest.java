package com.crm.ContactsTest;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtilty;
import com.crm.GenericLibrary.JDBCUtilty;
import com.crm.GenericLibrary.Javautility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreatingNewContactsPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.reactivex.rxjava3.functions.Action;

@Listeners(com.crm.GenericLibrary.ListenerImplementionClass.class)

public class CreateContactsTest extends BaseClass
{
	@Test
	public void  createContactsTest() throws Throwable
	{	
		
		//read data from excel sheet
		String lastname = elib.readDataFromExcel("contact", 1, 1)+jlib.getRandomNumber();

		// navigate to the create link
		HomePage hp = new HomePage(driver);
		hp.clickOnContacts();

		//click on create new contact button
		ContactsPage cp = new ContactsPage(driver);
		cp.clickoncreatecontactsImg();
		
		
		//enter all mandatory fields and click on save
		CreatingNewContactsPage ccp = new CreatingNewContactsPage(driver);
		ccp.createNewContact(lastname);
	}

}
