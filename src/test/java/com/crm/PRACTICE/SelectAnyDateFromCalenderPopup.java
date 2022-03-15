package com.crm.PRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectAnyDateFromCalenderPopup {

	public static void main(String[] args) 
	{
		String monthandyear = "June 2022";
		int date = 29;

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");

		Actions action = new Actions(driver);
		action.moveByOffset(5, 5).click().perform();

		driver.findElement(By.xpath("//div[@class='sc-bkkeKt gAqCbJ fswFld ']/span[.='Departure']")).click();

		String xpath = "//div[text()='"+monthandyear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";

		
		for(;;){

			try {
				driver.findElement(By.xpath(xpath)).click();
				break;
				
			} catch (Exception e) {
				
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();

			}

		}
		driver.findElement(By.xpath("//span[text()='Done']")).click();

		action.moveByOffset(5, 5).click().perform();
	}
}
