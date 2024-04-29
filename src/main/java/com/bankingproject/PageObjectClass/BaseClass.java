package com.bankingproject.PageObjectClass;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.bankingproject.Utilities.ReadConfig;

public class BaseClass 
{ 
	public static WebDriver  driver;
	static Random ran = new Random();
	static int newint = ran.nextInt(100);
	
	ReadConfig readconfig = new ReadConfig();
	
	public String BaseURL = readconfig.getApplicationURL();
	public String Username = readconfig.getUsername();
	public String Password = readconfig.getPassword();
		
	public static ExtentSparkReporter sparkreporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	@BeforeSuite
	public void setReport()
	{
		
	 sparkreporter = new ExtentSparkReporter("C:\\Users\\lilad\\eclipse-workspace\\Framework_design\\report\\htmlreport"+newint+".html");
	 extent= new ExtentReports();

	 extent.attachReporter(sparkreporter);
	 extent.setSystemInfo("Operating system", "windows");
	 extent.setSystemInfo("Environment", "QA");
	 sparkreporter.config().setReportName("Integration test execution");
	 sparkreporter.config().setDocumentTitle("Qa Automation test report");
	 sparkreporter.config().setTheme(Theme.STANDARD);
	
	}
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String str) throws IOException 
	{
		if(str.equals("Chrome"))
		{	
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver123\\chromedriver-win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(BaseURL);
		
		}
		else if(str.equals("Edge"))
		{
			System.setProperty("webdriver.edge.driver", "D:\\chromedriver123\\chromedriver-win32\\chromedriver.exe");
			
			driver = new EdgeDriver();
			
			driver.get(BaseURL);
		}else if(str.equals("ie"))
		{
            System.setProperty("webdriver.ie.driver", "D:\\chromedriver123\\chromedriver-win32\\chromedriver.exe");
			
			driver = new InternetExplorerDriver();
			
			driver.get(BaseURL);
		}
	}
		public static String captureScreen() throws IOException
		{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String dest= "C:\\Users\\lilad\\eclipse-workspace\\Framework_design\\Screenshots\\html"+newint+".png";
		
		FileUtils.copyFile(source, new File (dest));
		return dest;
		}


	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
	
	@AfterSuite
	public void endReport() 
	{
		extent.flush();
	}
	
}