package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsInfoPage 
{
	//span[@class='lvtHeaderText']
	// Step:1 Declaration - use @FindBy annotation
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement HeaderText;
	
	// Step:2 initialization - use constructor
	public ProductsInfoPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	// Step:3 utilization - provide getters
	public WebElement getHeaderText() {
		return HeaderText;
	}
	
	// business Library
	/**
	 * This method will return the product header text
	 * @return
	 */
	public String productNameInfo()
	{
		return HeaderText.getText();
		
	}
	
	
	
	
	

}
