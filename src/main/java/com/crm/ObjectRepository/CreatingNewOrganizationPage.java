package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreatingNewOrganizationPage extends WebDriverUtility
{
	// Step:1 Declaration - use @FindBy annotation

	//  Organization Name 
	@FindBy(name="accountname")
	private WebElement orgNameEdt;

	// Industry
	@FindBy(name="industry")
	private WebElement industryDropDown;

	// Type
	@FindBy(name="accounttype")
	private WebElement typeDropDown;

	// Save button
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	// Website
	// Ticker Symbol
	// Member Of
	// Employees
	// Other Email
	// Email Opt Out
	// Assigned To
	// Organization No
	// Phone
	// Fax
	// Other Phone
	// Email
	// Ownership
	// Rating
	// SIC Code
	// Annual Revenue
	// Annual Revenue

	
	
	// Step:2 initialization - use constructor
	public CreatingNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	// Step:3 utilization - provide getters

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}


	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}


	public WebElement getTypeDropDown() {
		return typeDropDown;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}


	//Business Library
	
	/**
	 * This method will create new organization using orgName
	 * @param orgName
	 */
	public void createNewOrg(String orgName)
	{
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}

	/**
	 * This method will create new organization using orgName and industry type
	 * @param orgName
	 * @param indusType
	 */
	public void createNewOrg(String orgName, String indusType)
	{
		orgNameEdt.sendKeys(orgName);
		select(industryDropDown, indusType);
		saveBtn.click();		
	}

	/**
	 * This method will create new organization using orgName, industry type, account type
	 * @param orgName
	 * @param indusType
	 * @param type
	 */
	public void createNewOrg(String orgName, String indusType, String type)
	{
		orgNameEdt.sendKeys(orgName);
		select(industryDropDown, indusType);
		select(typeDropDown, type);
		saveBtn.click();		
	}
}
