package com.crm.PRACTICE;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectCurrentDateFromCalenderMakeMyTrip {

	public static void main(String[] args) 
	{
		
		LocalDateTime Localdate = LocalDateTime.now();
		Month Month = Localdate.getMonth();
		int year = Localdate.getYear();
		int day = Localdate.getDayOfMonth();
		
		String month = Month.toString();
		String firstletter = month.substring(0, 1);
		String remainingletter = month.substring(1, month.length());
		
		remainingletter=remainingletter.toLowerCase();
		
		month=firstletter+remainingletter;
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		
		Actions action = new Actions(driver);
		action.moveByOffset(5, 5).click().perform();
		
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
		
		String xpath = "//div[.='"+month+" "+year+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+day+"']";
		
		driver.findElement(By.xpath(xpath)).click();
		
		

	}

}
