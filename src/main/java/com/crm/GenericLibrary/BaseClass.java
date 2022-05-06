package com.crm.GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	// create object of all utilities
	public JDBCUtilty jdbclib = new JDBCUtilty();
	public ExcelFileUtilty elib = new ExcelFileUtilty();
	public Javautility jlib = new Javautility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public PropertyFileUtility plib = new PropertyFileUtility();
	
	public WebDriver driver;
	public static WebDriver sdriver;

	@BeforeSuite(groups={"smokeSuite","regressionSuite"})
	public void connectDataBase()
	{
		//jdbclib.connectToDB();
		Reporter.log("====db connection successful====",true);
	}

	@BeforeClass(groups={"smokeSuite","regressionSuite"})
	//@Parameters("browser")
	//@BeforeTest
	public void launchTheBrowser() throws Throwable
	{
		//read data from property
		String BROWSER = plib.readDataFromPropertyFile("browser");
		String URL = plib.readDataFromPropertyFile("url");

		// create run time polymorphism
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			Reporter.log("====chrome browser====",true);
		}else if(BROWSER.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			Reporter.log("====firefox browser====",true);
		}else{
			Reporter.log("====invaild browser====",true);
		}

		sdriver=driver;
		wlib.maximizeWindow(driver);
		wlib.waitForPageLoad(driver);
		driver.get(URL);

		Reporter.log("====browser launch successful===",true);

	}
	
	@BeforeMethod(groups={"smokeSuite","regressionSuite"})
	public void login() throws Throwable
	{
		String USERNAME = plib.readDataFromPropertyFile("username");
		String PASSWORD = plib.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		Reporter.log("====login sucessfull====",true);

	}
	
	@AfterMethod(groups={"smokeSuite","regressionSuite"})
	public void logout()
	{
		HomePage hp = new HomePage(driver);
		hp.signOutOfApp(driver);
		Reporter.log("====logout sucessfull====",true);
		
	}
	
	@AfterClass(groups={"smokeSuite","regressionSuite"})
	//@AfterTest
	public void closeBrowser()
	{
		driver.quit();
		Reporter.log("====browser close successfull====",true);
	}
	
	@AfterSuite(groups={"smokeSuite","regressionSuite"})
	public void closeDb()
	{
		//jdbclib.closeDB();
		Reporter.log("====Database close successfull====",true);
	}


}
