package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage 
{
	// Step:1 Declaration - use @FindBy annotation
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement CreateOrgLookUpBtn;
	
	// Step:2 initialization - use constructor
	public OrganizationsPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	// Step:3 utilization - provide getters
	public WebElement getCreateOrgBtn() {
		return CreateOrgLookUpBtn;
	}
	
	// business library
	/**
	 * This method will return the header text
	 */
	public void clickOnCreateOrgBtn()
	{
		CreateOrgLookUpBtn.click();
	}
	
	
	

}
