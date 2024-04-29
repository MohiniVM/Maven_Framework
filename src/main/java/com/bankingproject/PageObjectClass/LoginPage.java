package com.bankingproject.PageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass{

	WebDriver ldriver;
	
	@FindBy(xpath= "//input[@name='username']")
	WebElement userID;
	
	@FindBy(xpath= "//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath= "//button[@type='submit']")
	WebElement login;
	
	@FindBy(xpath = "//p[text()='Forgot your password? ']")
	WebElement forgetPass;
	

	public LoginPage (WebDriver rdriver)
	{
	ldriver = rdriver;
	PageFactory.initElements(rdriver, this);
	}
	
	public void SetUserName()
	{
		userID.sendKeys(Username);
	}
	public void SetPassword()
	{
		password.sendKeys(Password);
	}
	public void ClickLoginButton() 
	{
		login.click();
	}
	
	
	
}
