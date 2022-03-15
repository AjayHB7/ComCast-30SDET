package com.crm.Products;

import java.awt.Desktop.Action;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtilty;
import com.crm.GenericLibrary.Javautility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CampaginsPage;
import com.crm.ObjectRepository.CampaignsInfoPage;
import com.crm.ObjectRepository.CreatingNewCampaignPage;
import com.crm.ObjectRepository.CreatingNewProductsPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.ProductsInfoPage;
import com.crm.ObjectRepository.ProductsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignwithProductNameTest
{
	@Test
	public void createCampaignwithProductNameTest() throws Throwable
	{
		// read all the data from external files
		ExcelFileUtilty elib = new ExcelFileUtilty();
		Javautility jlib = new Javautility();
		PropertyFileUtility plib = new PropertyFileUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		
		// read data from Property File
		String BROWSER = plib.readDataFromPropertyFile("browser");
		String URL = plib.readDataFromPropertyFile("url");
		String USERNAME = plib.readDataFromPropertyFile("username");
		String PASSWORD = plib.readDataFromPropertyFile("password");		
		
		// read from excel product
		String productName = elib.readDataFromExcel("product", 34, 2)+jlib.getRandomNumber();
		String CampaignName = elib.readDataFromExcel("product", 34, 3)+jlib.getRandomNumber();

		//launch the browser
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}else{
			System.out.println("invaild browser");
		}
		wlib.maximizeWindow(driver);
		wlib.waitForPageLoad(driver);
		driver.get(URL);

		// step 2 login to application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		//navigate to products and click 
		HomePage hp = new HomePage(driver);
		hp.clickOnProducts();
		
		//click on create a product
		ProductsPage pp = new ProductsPage(driver);
		pp.clickOnCreateProductBtn();
		
		// create a new product
		CreatingNewProductsPage cpp = new CreatingNewProductsPage(driver);
		cpp.CreateNewProduct(productName);
		
		//verification of product
		ProductsInfoPage pip = new ProductsInfoPage(driver);
		String proheader = pip.productNameInfo();
		if(proheader.contains(productName))
		{
			System.out.println(proheader+"-----> is created");
		}else{
			System.out.println("product not created");
		}

		//navigate to Campaign 
		hp.clickOnCampaigns();

		//click on create campaign button
		CampaginsPage cp = new CampaginsPage(driver);
		cp.ClickOnCreateCampaignBtn();
		
		//create a new campaign
		CreatingNewCampaignPage ccp = new CreatingNewCampaignPage(driver);
		ccp.createNewCampaign(driver, CampaignName, productName);
			
		//verification
		CampaignsInfoPage cip = new CampaignsInfoPage(driver);
		String comheader = cip.compaignsNameInfo();
	
		if(comheader.contains(CampaignName)){
			System.out.println(comheader+ "----> is created");
		}else{
			System.out.println("campaign is not created");
		}

		// logout to the application
		hp.signOutOfApp(driver);

		// close the application
		driver.close();
	}
}
