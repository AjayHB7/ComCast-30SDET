package com.crm.OrganizationTest;

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
import com.crm.ObjectRepository.CreatingNewOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWithIndustryDropdownAndTypeDropdownTest extends BaseClass
{
	@Test(groups="regressionSuite")
	public void createOrganizationWithIndustryDropdownAndTypeDropdown() throws Throwable
	{

		//read data from excel sheet
		String orgName= elib.readDataFromExcel("org", 5, 1)+ jlib.getRandomNumber();
		String indusType= elib.readDataFromExcel("org", 5, 2);
		String Type= elib.readDataFromExcel("org", 5, 3);

		// navigate to the organization button and click
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganization();		

		// click on create new organization button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgBtn();

		// create on organization choosing industry type
		CreatingNewOrganizationPage cno = new CreatingNewOrganizationPage(driver);
		cno.createNewOrg(orgName, indusType, Type);
		
		
		// verification
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String header = oip.orgNameInfo();
		if(header.contains(orgName))
		{
			System.out.println(header+"----> is created");
		}else{
			System.out.println("organization is not created");
		}
	}

}
