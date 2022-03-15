package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreatingNewCampaignPage extends WebDriverUtility
{
	// Step:1 Declaration - use @FindBy annotation
	@FindBy(name="campaignname")
	private WebElement campaignnameEdt;

	// Expected Close Date
	@FindBy(name="closingdate")
	private WebElement expclosingdateEdt;


	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(xpath="//img[@title='Select']")
	private WebElement productLookUpImg;

	@FindBy(id="search_txt")
	private WebElement searchEdt;

	@FindBy(name="search")
	private WebElement searchBtn;


	// Step:2 initialization - use constructor
	public CreatingNewCampaignPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	// Step:3 utilization - provide getters
	public WebElement getCampaignnameEdt() {
		return campaignnameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getExpClosingdateEdt() {
		return expclosingdateEdt;
	}

	public WebElement getProductLookUpImg() {
		return productLookUpImg;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	//Business Library
	/**
	 *  This method will create new Campaign using Campaign Name and expected closing date
	 * @param CampaignName
	 * @param CamExpectedCloseDate
	 */
	public void createNewCampaign(String CampaignName, String CamExpectedCloseDate)
	{
		campaignnameEdt.sendKeys(CampaignName);
		expclosingdateEdt.clear();
		expclosingdateEdt.sendKeys(CamExpectedCloseDate);
		saveBtn.click();
	}
	/**
	 * This method will create new Campaign using CampaignName and ProductName 
	 * @param driver
	 * @param CampaignName
	 * @param productName
	 */
	public void createNewCampaign(WebDriver driver, String CampaignName, String productName)
	{
		campaignnameEdt.sendKeys(CampaignName);
		productLookUpImg.click();
		switchToWindow(driver, "Products");
		searchEdt.sendKeys(productName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[.='"+productName+"']")).click();
		switchToWindow(driver, "Campaigns");
		saveBtn.click();
	}



}
