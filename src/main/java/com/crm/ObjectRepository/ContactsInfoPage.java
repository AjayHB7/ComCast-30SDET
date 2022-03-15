package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage 
{
	// Step:1 Declaration - use @FindBy annotation
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement ContactsHeaderText;
	
	@FindBy(xpath="//td[@class='dvtCellInfo']//font[.='Employee']")
	private WebElement leadSourceText;
	
	// Step:2 initialization - use constructor
	public ContactsInfoPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	// Step:3 utilization - provide getters
	public WebElement getContactsHeaderText() {
		return ContactsHeaderText;
	}

	// business library
	/**
	 * his method will return the contact header text
	 * @return
	 */
	public String contactNameInfo()
	{
		return ContactsHeaderText.getText();		
	}
	
	public String leadSourceInfo()
	{
		return leadSourceText.getText();
	}
	
	
	
}
