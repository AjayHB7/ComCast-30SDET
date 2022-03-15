package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class ContactsPage extends WebDriverUtility
{
	// Step:1 Declaration - use @FindBy annotation
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactLookUpImg;
	
	@FindBy(xpath="//img[@title='Search in Contacts...']")
	private WebElement srchInContactsBtn;
	
	// Step:2 initialization - use constructor
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	// Step:3 utilization - provide getters
	public WebElement getCreateContactBtn() {
		return createContactLookUpImg;
	}

	public WebElement getSrchInContactsBtn() {
		return srchInContactsBtn;
	}
	
	// business library
	/**
	 * This method will click on create contact button
	 */
	public void clickoncreatecontactsImg()
	{
		createContactLookUpImg.click();
	}
	
}
