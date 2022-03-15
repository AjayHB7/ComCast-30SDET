package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	// Step:1 Declaration - use @FindBy annotation
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passWordEtd;
	
	@FindBy(id="submitButton")
	private WebElement submitBtn;
	
	// Step:2 initialization - use constructor
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	// Step:3 utilization - provide getters
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPassWordEtd() {
		return passWordEtd;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	
	}
	
	// business Library
	public void loginToApp(String userName, String passWord)
	{
		userNameEdt.sendKeys(userName);
		passWordEtd.sendKeys(passWord);
		submitBtn.click();
	}
	
	
	
	
	
	
}
