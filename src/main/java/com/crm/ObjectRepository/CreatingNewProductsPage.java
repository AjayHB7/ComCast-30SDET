package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreatingNewProductsPage extends WebDriverUtility
{

	// Step:1 Declaration - use @FindBy annotation
	@FindBy(name="productname")
	private WebElement productNameEtd;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	// Step:2 initialization - use constructor
	public CreatingNewProductsPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	// Step:3 utilization - provide getters

	public WebElement getProductNameEtd() {
		return productNameEtd;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Library
	/**
	 * This method will create a new product using Product Name
	 * @param ProductName
	 */
	public void CreateNewProduct(String ProductName)
	{
		productNameEtd.sendKeys(ProductName);
		saveBtn.click();
	}
	
	
}
