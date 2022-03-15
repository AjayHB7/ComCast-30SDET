package com.crm.OpportunitiesModule;

import java.sql.DriverManager;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtilty;
import com.crm.GenericLibrary.Javautility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CampaginsPage;
import com.crm.ObjectRepository.CampaignsInfoPage;
import com.crm.ObjectRepository.ContactsInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreatingNewCampaignPage;
import com.crm.ObjectRepository.CreatingNewContactsPage;
import com.crm.ObjectRepository.CreatingNewOpportunityPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OpportunitesPage;
import com.crm.ObjectRepository.OpportunitiesInfoPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOpportunitiesWithContactsAndCampaignTest extends BaseClass
{
	@Test(groups="regressionSuite",retryAnalyzer=com.crm.GenericLibrary.RetryAnalyserImplemention.class)
	public void createOpportunitiesWithContactsAndCampaign() throws Throwable
	{
		// read data Excel file
		String LastName = elib.readDataFromExcel("Opportunities", 4, 2)+jlib.getRandomNumber();
		String CampaignName = elib.readDataFromExcel("Opportunities", 4, 3)+jlib.getRandomNumber();
		String CamExpectedCloseDate = elib.readDataFromExcel("Opportunities", 4, 4);
		String OppName = elib.readDataFromExcel("Opportunities", 4, 5)+jlib.getRandomNumber();
		String RelatedTo = elib.readDataFromExcel("Opportunities", 4, 6);
		String OppExpectedCloseDate = elib.readDataFromExcel("Opportunities", 4, 8);

		/**create a contact **/

		// navigate to the create link
		HomePage hp = new HomePage(driver);
		hp.clickOnContacts();
		String actHeadercon = driver.findElement(By.linkText("Contacts")).getText();
		
		Assert.assertEquals(actHeadercon, "Contacts");
		Reporter.log(actHeadercon+"------>verified",true);

		//click on create new contact button
		ContactsPage conp = new ContactsPage(driver);
		conp.clickoncreatecontactsImg();

		//enter all mandatory fields and click on save
		CreatingNewContactsPage cconp= new CreatingNewContactsPage(driver);
		cconp.createNewContact(LastName);

		// verification for contacts
		ContactsInfoPage conip= new ContactsInfoPage(driver);
		String vercontacts = conip.contactNameInfo();
		Assert.assertTrue(vercontacts.contains(LastName));
		Reporter.log(vercontacts+"-->verified",true);

		/**create a campaign**/

		// navigate to campaign 
		hp.clickOnCampaigns();
		String actHeadercam = driver.findElement(By.linkText("Campaigns")).getText();
		Assert.assertEquals(actHeadercam, "Campaigns");
		Reporter.log(actHeadercam+"----->verified",true);

		CampaginsPage camp= new CampaginsPage(driver);
		camp.ClickOnCreateCampaignBtn();



		// enter all the mandatory field
		CreatingNewCampaignPage ccamp= new CreatingNewCampaignPage(driver);
		ccamp.createNewCampaign(CampaignName, CamExpectedCloseDate);

		// verification for campaign
		CampaignsInfoPage camip= new CampaignsInfoPage(driver);
		String vercampaign = camip.compaignsNameInfo();
		Assert.assertTrue(vercampaign.contains(CampaignName));
		Reporter.log(vercampaign+"-->verified",true);




		/**create opportunities **/

		// click on opportunities link
		hp.clickOnOpportunities();
		String actHeader = driver.findElement(By.linkText("Opportunities")).getText();
		Assert.assertEquals(actHeader, "Opportunities");

		Reporter.log(actHeader+"----->verified",true);

		//click on create new opportunities button
		OpportunitesPage op = new OpportunitesPage(driver);
		op.clickOnCreateNewOpportunites();

		String actHeadernewopp= driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		Assert.assertEquals(actHeadernewopp, "Creating New Opportunity");
		Reporter.log(actHeadernewopp+"----->verified",true);

		// enter the value for required fields and save 
		CreatingNewOpportunityPage cop = new CreatingNewOpportunityPage(driver);

		cop.createNewOpportunities(driver, OppName, RelatedTo, LastName, CampaignName, OppExpectedCloseDate);


		// verification of Opportunities
		OpportunitiesInfoPage oip = new OpportunitiesInfoPage(driver);
		String veropportunities = oip.opportunitiesNameInfo();
		Assert.assertTrue(veropportunities.contains(OppName));
		Reporter.log(veropportunities+"-->verified",true);
	}

}
