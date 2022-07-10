package com.crm.PRACTICE;

import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SummerDresses {


	@Test
	public void test1()
	{
		WebDriverUtility wlib = new WebDriverUtility();

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("http://automationpractice.com/index.php");



		WebElement womenbtn = driver.findElement(By.xpath("//a[@title='Women']"));

		wlib.mouseHover(driver, womenbtn);

		driver.findElement(By.xpath("//a[@title='Summer Dresses']")).click();

		WebElement sc =driver.findElement(By.xpath("//span[@id='layered_price_range']"));

		WebElement src = driver.findElement(By.xpath("//a[@class='ui-slider-handle ui-state-default ui-corner-all' and @style='left: 100%;']"));

		wlib.scrollAction(driver, sc);
		
		Actions action = new Actions(driver);	
		
		float i = 0 ;
		WebElement dst ;
		
		
		for(;;){
			try {
				dst = driver.findElement(By.xpath("//div[@class='ui-slider-range ui-widget-header ui-corner-all' and @style='left: 0%; width: 90%;']"));
				break;
			} catch (Exception e) {
				action.clickAndHold(src).moveByOffset((int) i, 0).perform();;
//			i = i-0.1f  ;
				i--;
			}
		}
		
		System.out.println("scrolled till and element is found ");
		
	}

}
