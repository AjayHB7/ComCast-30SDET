package com.crm.PRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDateFromCalenderMakeMyTrip 
{
	public static void main(String[] args)
	{
		String monthandyear = "March 2022";
		int date = 10;

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		
		Actions action = new Actions(driver);
		action.moveByOffset(5, 5).click().perform();
		
		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
		
		String xpath = "//div[.='"+monthandyear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date+"']";
		
		driver.findElement(By.xpath(xpath)).click();
		
				
	}

}
