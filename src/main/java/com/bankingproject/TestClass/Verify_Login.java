package com.bankingproject.TestClass;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.bankingproject.PageObjectClass.BaseClass;
import com.bankingproject.PageObjectClass.LoginPage;

public class Verify_Login extends BaseClass
{
	@Test
	public void loginTest() throws InterruptedException, IOException
{  try {
	LoginPage login = new LoginPage(driver);
	test = extent.createTest("verify login test");
	driver.get(BaseURL);
    test.log(Status.PASS, "Base URL enter successfully");
	
	Thread.sleep(2000);
	login.SetUserName();
	test.log(Status.PASS, "username entered successfully");
	
	Thread.sleep(2000);
	login.SetPassword();
	test.log(Status.PASS, "password entered successfully");

	
	Thread.sleep(2000);
	login.ClickLoginButton();
	test.log(Status.PASS, "button click successfully");

	Thread.sleep(2000);

	String ExpectedTitle = "OrangeHRM";
	String ActualTitle = driver.getTitle();
	
	
	if(driver.getTitle().equals(ExpectedTitle))
	{
		test.log(Status.PASS, "title verify and login successfully");

	}
	else
	{
		test.log(Status.FAIL, "login failed");
		String ScreenshotPath = BaseClass.captureScreen();
		test.addScreenCaptureFromPath(ScreenshotPath);
	}
	}catch(Exception e)
{
		test.log(Status.FAIL, "Login failed");
		String Screenshotpath = BaseClass.captureScreen();
		test.addScreenCaptureFromPath(Screenshotpath);
}
	}
}
