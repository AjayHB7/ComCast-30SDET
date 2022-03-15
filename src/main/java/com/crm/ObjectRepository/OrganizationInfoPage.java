package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage 
{
	// Step:1 Declaration - use @FindBy annotation
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	// Step:2 initialization - use constructor
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	// Step:3 utilization - provide getters
	public WebElement getHeaderText() {
		return headerText;
	}
	
	// business Library
	/**
	 * This method will return the header text
	 * @return
	 */
	public String orgNameInfo()
	{
		String OrgInfo = headerText.getText();
		return OrgInfo;
		
	}

}
