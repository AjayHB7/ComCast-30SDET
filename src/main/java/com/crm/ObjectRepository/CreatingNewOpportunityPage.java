package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreatingNewOpportunityPage  extends WebDriverUtility
{
	// Step:1 Declaration - use @FindBy annotation
	
	// Opportunity Name	
	@FindBy(name="potentialname")
	private WebElement oppNameEdt;
	
	// Related To
	@FindBy(name="related_to_type")
	private WebElement relatedToDropDown;
	
	@FindBy(xpath="//input[@id='related_to_display']/following-sibling::img[@title='Select']")
	private WebElement relatedToLookUpBtn;
	
	@FindBy(name="search_text")
	private WebElement relatedToPopSearchEdt;
	
	@FindBy(name="search")
	private WebElement relatedToPopSearchBtn;
		
	@FindBy(xpath="//input[@id='related_to_display']/following-sibling::input[@title='Clear']")
	private WebElement relatedToClearBtn;
	
	// Type
	@FindBy(name="opportunity_type")
	private WebElement typeDropDown;
	
	// Lead Source
	@FindBy(name="leadsource")
	private WebElement leadsourceDropDown;
	
	// Assigned To
	@FindBy(xpath="//input[@name='assigntype' and @value='U']")
	private WebElement assignedToUserCkBx;
	
	@FindBy(xpath="//input[@name='assigntype' and @value='T']")
	private WebElement assignedToGroupCkBx;
	
	@FindBy(name="assigned_user_id")
	private WebElement assignedToDropDown;
	
	// Campaign Source 
	@FindBy(xpath="//input[@name='campaignname']/following-sibling::img[@title='Select']")
	private WebElement campaignSourceLookUpBtn;
	
	@FindBy(name="search_text")
	private WebElement campaignSourcePopSearchEdt;
	
	@FindBy(name="search")
	private WebElement campaignSourcePopSearchBtn;
	
	@FindBy(xpath="//input[@name='campaignname']/following-sibling::input[@title='Clear']")
	private WebElement campaignSourceClearBtn;
	
	// Opportunity No
	@FindBy(id="potential_no")
	private WebElement OpportunityNoEdt;
	
	// Amount	
	@FindBy(name="amount")
	private WebElement amountEdt;
	
	// Expected Close Date
	@FindBy(name="closingdate")
	private WebElement closingdateEdt;
	
	@FindBy(id="jscal_trigger_closingdate")
	private WebElement closingdatePopBtn;
	
	// Next Step
	@FindBy(name="nextstep")
	private WebElement nextstepEdt;
	
	// Sales Stage sales_stage
	@FindBy(name="sales_stage")
	private WebElement salesStageDropDown;
	
	// Probability 
	@FindBy(name="probability")
	private WebElement probabilityEdt;
	
	// save
	@FindBy(xpath="(//input[@class='crmbutton small save'])[1]")
	private WebElement saveBtn;
	
	// Step:2 initialization - use constructor
	public CreatingNewOpportunityPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	// Step:3 utilization - provide getters
	public WebElement getOppNameEdt() {
		return oppNameEdt;
	}

	public WebElement getRelatedToDropDown() {
		return relatedToDropDown;
	}

	public WebElement getRelatedToLookUpBtn() {
		return relatedToLookUpBtn;
	}

	public WebElement getRelatedToClearBtn() {
		return relatedToClearBtn;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getLeadsourceDropDown() {
		return leadsourceDropDown;
	}

	public WebElement getAssignedToUserCkBx() {
		return assignedToUserCkBx;
	}

	public WebElement getAssignedToGroupCkBx() {
		return assignedToGroupCkBx;
	}

	public WebElement getAssignedToDropDown() {
		return assignedToDropDown;
	}

	public WebElement getCampaignSourceLookUpBtn() {
		return campaignSourceLookUpBtn;
	}

	public WebElement getCampaignSourcePopSearchEdt() {
		return campaignSourcePopSearchEdt;
	}

	public WebElement getCampaignSourcePopSearchBtn() {
		return campaignSourcePopSearchBtn;
	}

	public WebElement getCampaignSourceClearBtn() {
		return campaignSourceClearBtn;
	}

	public WebElement getOpportunityNoEdt() {
		return OpportunityNoEdt;
	}

	public WebElement getAmountEdt() {
		return amountEdt;
	}

	public WebElement getClosingdateEdt() {
		return closingdateEdt;
	}

	public WebElement getClosingdatePopBtn() {
		return closingdatePopBtn;
	}

	public WebElement getNextstepEdt() {
		return nextstepEdt;
	}

	public WebElement getSalesStageDropDown() {
		return salesStageDropDown;
	}

	public WebElement getProbabilityEdt() {
		return probabilityEdt;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	// business library

	/**
	 * This method will create a new opportunities using opportunity name,relatedTo,contact name,campaign name, expected close date
	 * @param driver
	 * @param oppName
	 * @param relatedTo
	 * @param conName
	 * @param CampaignName
	 * @param OppExpectedCloseDate
	 */
	public void createNewOpportunities(WebDriver driver,String oppName, String relatedTo, String conName, String CampaignName,String OppExpectedCloseDate)
	{
		oppNameEdt.sendKeys(oppName);
		select(relatedToDropDown, relatedTo);
		relatedToLookUpBtn.click();
		switchToWindow(driver, "Contacts");
		relatedToPopSearchEdt.sendKeys(conName);
		relatedToPopSearchBtn.click();
		driver.findElement(By.xpath("//a[.=' "+conName+"']")).click();
		switchToWindow(driver, "Potentials");
		campaignSourceLookUpBtn.click();
		switchToWindow(driver, "Campaigns");
		campaignSourcePopSearchEdt.sendKeys(CampaignName);
		campaignSourcePopSearchBtn.click();
		driver.findElement(By.partialLinkText(CampaignName)).click();
		switchToWindow(driver, "Potentials");
		closingdateEdt.clear();
		closingdateEdt.sendKeys(OppExpectedCloseDate);
		saveBtn.click();
	}
	
	
	
	
	
	
	
	
	

}
