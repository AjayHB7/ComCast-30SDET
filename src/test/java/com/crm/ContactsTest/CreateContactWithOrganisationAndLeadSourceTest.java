package com.crm.ContactsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrganisationAndLeadSourceTest extends BaseClass 
{
	@Test(groups="smokeSuite")
	public void createContactWithOrganisationAndLeadSource() throws Throwable
	{

		//read data from excel sheet
		String lastName = elib.readDataFromExcel("contact", 7, 1)+jlib.getRandomNumber();
		String orgName = elib.readDataFromExcel("contact", 7, 2)+jlib.getRandomNumber();		
		String leadSource = elib.readDataFromExcel("contact", 7, 3);		

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
		ccp.createNewContact(driver, lastName, orgName, leadSource);

		//verification
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String contactNameHeader = cip.contactNameInfo();
		if(contactNameHeader.contains(lastName))
		{
			System.out.println(contactNameHeader+" ----> is created");
		}else
		{
			System.out.println("contact is not created");
		}

		String leadSourceTxt = cip.leadSourceInfo();

		if(leadSourceTxt.equalsIgnoreCase(leadSource))
		{
			System.out.println( leadSourceTxt + "--->is created");
		}else{
			System.out.println(leadSourceTxt+"--->is created");
		} 

	}
}
