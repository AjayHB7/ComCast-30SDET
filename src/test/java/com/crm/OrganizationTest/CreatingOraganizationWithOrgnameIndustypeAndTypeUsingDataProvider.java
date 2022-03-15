package com.crm.OrganizationTest;

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
import com.crm.ObjectRepository.CreatingNewOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationsPage;

public class CreatingOraganizationWithOrgnameIndustypeAndTypeUsingDataProvider extends BaseClass
{
	@Test(dataProvider="OrgIndtypeType")
	public void creatingNewOrgUsingDataProvider(String OrgName, String indusType, String type) throws Throwable
	{
		String orgName = OrgName+jlib.getRandomNumber();		
		
		Reporter.log("logged in to application",true);

		//click on organization link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganization();
		
		Reporter.log("navigated to Organization",true);

		//click on create organization look up button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgBtn();

		//create a organization by entering organization name and industry type
		CreatingNewOrganizationPage cnop= new CreatingNewOrganizationPage(driver);
		cnop.createNewOrg(orgName, indusType, type);

		Reporter.log("Organization created",true);
		
		// verification 
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actheader = oip.orgNameInfo();
		if (actheader.contains(orgName)) 
		{
			System.out.println("org is created ");
		}else{
			System.out.println("org is not created");
		}

		Reporter.log("Organization verified ",true);
		
	}

	@DataProvider(name="OrgIndtypeType")
	public Object[][] orgAndindusTypeData() throws Throwable
	{
		Object[][] data = elib.readMultipleDataFromExcel("OrgIndtypeTypemultipledata");
		return data;

	}

}
