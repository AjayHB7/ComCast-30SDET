package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreatingNewContactsPage  extends WebDriverUtility
{
	// Step:1 Declaration - use @FindBy annotation

	// last Name
	@FindBy(name="lastname")
	private WebElement lastNameEdt;

	// Organization Name
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement orgNameLookUpImg;

	@FindBy(name="search_text")
	private WebElement orgNamePopupSearchEdt;

	@FindBy(name="search")
	private WebElement orgNamePopupsearchBtn;

	@FindBy(xpath="//input[@name='account_name']/following-sibling::input[@type='image']")
	private WebElement orgNameClearBtn;

	// Lead Source
	@FindBy(name="leadsource")
	private WebElement leadSourceDropDown;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	// Title
	@FindBy(name="title")
	private WebElement titleEdt;

	// Department
	@FindBy(id="department")
	private WebElement departmentEdt;

	// Email
	@FindBy(name="email")
	private WebElement emailEdt;

	// Assistant
	@FindBy(name="assistant")
	private WebElement assistantEdt;

	// Assistant Phone
	@FindBy(name="assistantphone")
	private WebElement assistantPhoneEdt;

	// Email Opt Out
	@FindBy(name="emailoptout")
	private WebElement emailoptoutCkBx;

	// Reference
	@FindBy(name="reference")
	private WebElement referenceCkBx;

	// Notify Owner
	@FindBy(name="notify_owner")
	private WebElement notifyownerCkBx;

	// Contact Id
	@FindBy(name="contact_no")
	private WebElement contactIdEdt;

	// Office Phone
	@FindBy(name="phone")
	private WebElement officePhoneEdt;

	// Mobile
	@FindBy(name="mobile")
	private WebElement mobileEdt;

	// Home Phone
	@FindBy(name="homephone")
	private WebElement homePhoneEdt;

	// Other Phone
	@FindBy(name="otherphone")
	private WebElement otherPhoneEdt;

	// Fax
	@FindBy(name="fax")
	private WebElement faxEdt;

	// Birthdate
	@FindBy(name="birthday")
	private WebElement birthdayEdt;

	@FindBy(xpath="//img[@id='jscal_trigger_birthday']")
	private WebElement birthdayPopBtn;

	// Reports To
	@FindBy(name="contact_name")
	private WebElement ReportsToEdt;

	@FindBy(xpath="//input[@name='contact_name']/following-sibling::img[@title='Select']")
	private WebElement ReportsToLookUpBtn;

	@FindBy(xpath="//input[@name='contact_name']/following-sibling::input[@type='image']")
	private WebElement ReportsToClearBtn;

	// Secondary Email 
	@FindBy(id="secondaryemail")
	private WebElement secondaryemailEdt;

	// Do Not Call
	@FindBy(name="donotcall")
	private WebElement donotcallCkBx;

	// Assigned To
	@FindBy(xpath="//input[@name='assigntype' and @value='U']")
	private WebElement userRadioBtn;

	@FindBy(xpath="//input[@name='assigntype' and @value='T']")
	private WebElement groupRadioBtn;

	@FindBy(name="assigned_user_id")
	private WebElement assignedToDropDown;

	// Step:2 initialization - use constructor
	public CreatingNewContactsPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	// Step:3 utilization - provide getters

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getOrgNameLookUpImg() {
		return orgNameLookUpImg;
	}

	public WebElement getOrgNamePopupSearchEdt() {
		return orgNamePopupSearchEdt;
	}

	public WebElement getOrgNamePopupsearchBtn() {
		return orgNamePopupsearchBtn;
	}

	public WebElement getOrgNameClearBtn() {
		return orgNameClearBtn;
	}

	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getTitleEdt() {
		return titleEdt;
	}

	public WebElement getDepartmentEdt() {
		return departmentEdt;
	}

	public WebElement getEmailEdt() {
		return emailEdt;
	}

	public WebElement getAssistantEdt() {
		return assistantEdt;
	}

	public WebElement getAssistantPhoneEdt() {
		return assistantPhoneEdt;
	}

	public WebElement getEmailoptoutCkBx() {
		return emailoptoutCkBx;
	}

	public WebElement getReferenceCkBx() {
		return referenceCkBx;
	}

	public WebElement getNotifyownerCkBx() {
		return notifyownerCkBx;
	}

	public WebElement getContactIdEdt() {
		return contactIdEdt;
	}

	public WebElement getOfficePhoneEdt() {
		return officePhoneEdt;
	}

	public WebElement getMobileEdt() {
		return mobileEdt;
	}

	public WebElement getHomePhoneEdt() {
		return homePhoneEdt;
	}

	public WebElement getOtherPhoneEdt() {
		return otherPhoneEdt;
	}

	public WebElement getFaxEdt() {
		return faxEdt;
	}

	public WebElement getBirthdayEdt() {
		return birthdayEdt;
	}

	public WebElement getBirthdayPopBtn() {
		return birthdayPopBtn;
	}

	public WebElement getReportsToEdt() {
		return ReportsToEdt;
	}

	public WebElement getReportsToLookUpBtn() {
		return ReportsToLookUpBtn;
	}

	public WebElement getReportsToClearBtn() {
		return ReportsToClearBtn;
	}

	public WebElement getSecondaryemailEdt() {
		return secondaryemailEdt;
	}

	public WebElement getDonotcallCkBx() {
		return donotcallCkBx;
	}

	public WebElement getUserRadioBtn() {
		return userRadioBtn;
	}

	public WebElement getGroupRadioBtn() {
		return groupRadioBtn;
	}

	public WebElement getAssignedToDropDown() {
		return assignedToDropDown;
	}


	// business library
	/**
	 * This method will create new organization using lastName
	 * @param lastName
	 */
	public void createNewContact(String lastName)
	{
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}

	/**
	 * This method will create new organization using lastName and orgName
	 * @param driver
	 * @param lastName
	 * @param orgName
	 */
	public void createNewContact(WebDriver driver, String lastName, String orgName)
	{
		lastNameEdt.sendKeys(lastName);
		orgNameLookUpImg.click();
		switchToWindow(driver, "Accounts");
		orgNamePopupSearchEdt.sendKeys(orgName);
		orgNamePopupsearchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver, "Contacts");
		saveBtn.click();		
	}	
	
	/**
	 * This method will create new organization using lastName,orgName and leadSource
	 * @param driver
	 * @param lastName
	 * @param orgName
	 * @param LeadSource
	 */
	public void createNewContact(WebDriver driver, String lastName, String orgName,String LeadSource)
	{
		lastNameEdt.sendKeys(lastName);
		orgNameLookUpImg.click();
		select(leadSourceDropDown, LeadSource);
		switchToWindow(driver, "Accounts");
		orgNamePopupSearchEdt.sendKeys(orgName);
		orgNamePopupsearchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver, "Contacts");
		saveBtn.click();		
	}
}
