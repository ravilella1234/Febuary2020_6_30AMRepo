package com.project.BaseClass;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.BeforeTest;

public class BaseTest 
{
	public String projectPath=System.getProperty("user.dir"); 
	FileInputStream fis;
	Properties envprop;
	Properties prop;
	
	
	 @BeforeTest
	  public void init() throws Exception 
	 {
		 System.out.println("Before Test.....");
		 
		 fis=new FileInputStream(projectPath+"//src//test//resources//environment.properties");
		 envprop=new Properties();
		 envprop.load(fis);
		 String e = envprop.getProperty("env");
		 System.out.println(e);
		 
		 fis=new FileInputStream(projectPath+"//src//test//resources//"+e+".properties");
		 prop=new Properties();
		 prop.load(fis);
		 String url = prop.getProperty("zohourl");
		 System.out.println(url);
	 }

}
