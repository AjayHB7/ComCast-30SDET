package com.crm.ContactsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtilty;
import com.crm.GenericLibrary.Javautility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactsInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreatingNewContactsPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactsUsingDataProvider extends BaseClass
{
	// step 1 read all necessary data from external files

	@Test(dataProvider="lastname",groups="smokeSuite")
	public void  createContactsUsingDataProvider(String LastName) throws Throwable
	{
		String lastname = LastName+jlib.getRandomNumber();

		// navigate to the create link
		HomePage hp = new HomePage(driver);
		hp.clickOnContacts();

		Reporter.log("navigated to Contacts",true);

		//click on create new contact button
		ContactsPage cp = new ContactsPage(driver);
		cp.clickoncreatecontactsImg();
		
		

		//enter all mandatory fields and click on save
		CreatingNewContactsPage ccp = new CreatingNewContactsPage(driver);
		ccp.createNewContact(lastname);

		Reporter.log("Contacts created",true);
		

		// verification
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String actheader = cip.contactNameInfo();
		if(actheader.contains(lastname))
		{
			System.out.println(actheader+"---->contact is created");
		}else{
			System.out.println(lastname+"---->contact is not created");
		}

		Reporter.log("Contact verified ",true);

	}

	@DataProvider(name="lastname")
	public Object[][] lastnameData() throws Throwable
	{
		Object[][] data =elib.readMultipleDataFromExcel("ContactsMultipledata");
		return data;
	}

}
