package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaginsPage 
{
	// Step:1 Declaration - use @FindBy annotation
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement CreateCompaignsLookUpImg;

	// Step:2 initialization - use constructor
	public CampaginsPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	// Step:3 utilization - provide getters
	
	public WebElement getCreateCompaignsLookUpImg() {
		return CreateCompaignsLookUpImg;
	}
	
	
	//Business Library
	/**
	 * This method will click on create campaign button
	 */
	public void ClickOnCreateCampaignBtn()
	{
		CreateCompaignsLookUpImg.click();
	}

	
	
	
	
}
