package com.crm.PRACTICE;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class CheckOnCkBx extends BaseClass
{
	@Test(enabled = false)
	public void checkallCkBxInOrg() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganization();
		
		List<WebElement> els = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
		

		for (WebElement wbel : els) {
			wbel.click();
			Thread.sleep(1000);
		}
		
	}
	
	
	
	@Test(enabled=false)
	public void checklastCkBxInContacts()
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnContacts();
		
		List<WebElement> ele = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
		
	    ArrayList<WebElement> eles = new ArrayList<WebElement>(ele);
	    int size = eles.size()-1;
	    eles.get(size).click();	    
		
	}
	
	
	@Test(enabled=false)
	public void allTheLastNameInContacts()
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnContacts();
		
		List<WebElement> eles = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[4]/a[@title='Contacts']"));
		
		for (WebElement ele : eles) {
			String lastname = ele.getText();
			System.out.println(lastname);
		}
		
	}
	
	@Test(enabled = true)
	public void deleteFifthContactInContacts()
	{
		
		HomePage hp = new HomePage(driver);
		hp.clickOnContacts();
		
		int i = 4;
		
		List<WebElement> CBX = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
		
		ArrayList<WebElement> CBXs = new ArrayList<WebElement>(CBX);
		
		CBXs.get(i).click();
		
		List<WebElement> Del = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[10]/a[.='del']"));
		ArrayList<WebElement> dels = new ArrayList<WebElement>(Del);
		
		dels.get(i).click();
		
		wlib.acceptAlert(driver);
	}
	

}
