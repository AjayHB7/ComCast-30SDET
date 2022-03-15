package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitesPage 
{
	// Step:1 Declaration - use @FindBy annotation
	@FindBy(xpath="//img[@alt='Create Opportunity...']")
	private WebElement opportunitesLookUpImg;
	
	
	// Step:2 initialization - use constructor
	public OpportunitesPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);		
	}

	// Step:3 utilization - provide getters
	public WebElement getOpportunitesLookUpImg() {
		return opportunitesLookUpImg;
	}
	
	// business library
	/**
	 * This method will click on create opportunities button
	 */
	public void clickOnCreateNewOpportunites()
	{
		opportunitesLookUpImg.click();
	}
	
	
	
	
	
	
	
}
