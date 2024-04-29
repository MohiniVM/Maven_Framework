package com.bankingproject.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro = new Properties();

	public  ReadConfig() 
	{
		File src = new File("C:\\Users\\lilad\\eclipse-workspace\\Framework_design\\Configuration\\Config.properties");
	try {
		FileInputStream file = new FileInputStream(src);
		
	    pro = new Properties();
		pro.load(file);
	}catch(Exception e)
	{
		System.out.println("Exception is"+ e.getMessage());
	}
	}
	
	public String getApplicationURL()
	{
	String url = pro.getProperty("baseURL");
	return url;
	}
	public String getUsername() 
	{
		String username = pro.getProperty("username");
		return username;
	}
	public String getPassword()
	{
		String password = pro.getProperty("password");
		return password;
	}
	
	
	
	
}