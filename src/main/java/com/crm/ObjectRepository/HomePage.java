package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class HomePage extends WebDriverUtility
{

	// Step:1 Declaration - use @FindBy annotation
	@FindBy(linkText="Calendar")
	private WebElement CalendarLnk;
	
	@FindBy(linkText="Leads")
	private WebElement LeadsLnk;
	
	@FindBy(linkText="Organizations")
	private WebElement OrganizationsLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsLnk;

	@FindBy(linkText="Opportunities")
	private WebElement OpportunitiesLnk;
	
	@FindBy(linkText="Products")
	private WebElement ProductsLnk;
	
	@FindBy(linkText="Documents")
	private WebElement DocumentsLnk;
	
	@FindBy(linkText="Email")
	private WebElement EmailLnk;
	
	@FindBy(linkText="Trouble Tickets")
	private WebElement TroubleTicketsLnk;
	
	@FindBy(linkText="Dashboard")
	private WebElement DashboardLnk;
	
	@FindBy(linkText="More")
	private WebElement MoreLnk;
	
	@FindBy(linkText="Campaigns")
	private WebElement CampaignsLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorimg;
	 	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLnk;
	
	// Step:2 initialization - use constructor
	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	// Step:3 utilization - provide getters
	public WebElement getCalendarLnk() {
		return CalendarLnk;
	}

	public WebElement getLeadsLnk() {
		return LeadsLnk;
	}

	public WebElement getOrganizationsLnk() {
		return OrganizationsLnk;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return OpportunitiesLnk;
	}

	public WebElement getProductsLnk() {
		return ProductsLnk;
	}

	public WebElement getDocumentsLnk() {
		return DocumentsLnk;
	}

	public WebElement getEmailLnk() {
		return EmailLnk;
	}

	public WebElement getTroubleTicketsLnk() {
		return TroubleTicketsLnk;
	}

	public WebElement getDashboardLnk() {
		return DashboardLnk;
	}

	public WebElement getMoreLnk() {
		return MoreLnk;
	}
	
	public WebElement getCampaignsLnk() {
		return CampaignsLnk;
	}

	public WebElement getAdministratorimg() {
		return administratorimg;
	}

	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}
	
	// business Library
	public void clickOnContacts()
	{
		ContactsLnk.click();
	}
	
	public void clickOnLeads()
	{
		LeadsLnk.click();
	}
	
	public void clickOnOrganization()
	{
		OrganizationsLnk.click();
	}
	
	public void clickOnOpportunities()
	{
		OpportunitiesLnk.click();
	}
	
	public void clickOnProducts()
	{
		ProductsLnk.click();
	}
	
	public void clickOnMore()
	{
		MoreLnk.click();
	}
	
	public void clickOnCampaigns()
	{
		clickOnMore();
		CampaignsLnk.click();
	}
	
	public void signOutOfApp(WebDriver driver)
	{
		mouseHover(driver, administratorimg);
		SignOutLnk.click();
	}
	
	
	
}
