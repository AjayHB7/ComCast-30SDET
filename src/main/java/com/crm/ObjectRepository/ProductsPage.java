package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class ProductsPage extends WebDriverUtility
{

	// Step:1 Declaration - use @FindBy annotation
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement productLookUpImg;
	
	// Step:2 initialization - use constructor
	public ProductsPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	// Step:3 utilization - provide getters
	public WebElement getProductLookUpImg() {
		return productLookUpImg;
	}
	
	// Business Library
	/**
	 * This method will click on create Product button
	 */
	public void clickOnCreateProductBtn()
	{
		productLookUpImg.click();
	}
	
}
