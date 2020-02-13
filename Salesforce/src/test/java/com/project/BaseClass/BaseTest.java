package com.project.BaseClass;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import com.project.Driver.DriverScript;
import com.project.utils.ExcelAPI;

public class BaseTest 
{
	public String projectPath=System.getProperty("user.dir"); 
	FileInputStream fis;
	Properties envprop;
	Properties prop;
	public ExcelAPI xls;
	public String testName;
	public DriverScript ds;
	
	
	 @BeforeTest
	  public void init() throws Exception 
	 {
		 System.out.println("Before Test.....");
		 
		 //TO get the Package Name
		String pack = this.getClass().getPackage().getName();
		System.out.println(pack);
		 
		 String arr[]=this.getClass().getPackage().getName().split("\\.");
		 String suiteName = arr[arr.length-1];
		 System.out.println(suiteName);
		
		//To get the Current Test Name
		 testName = this.getClass().getSimpleName();
		 System.out.println(testName);
		 
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
		 
		 //inilize the xls File
		 //how do i know which excel file to load dynamically
		 xls=new ExcelAPI(prop.getProperty(suiteName+"_xls"));
		 
		 
		 //Inilize  DriverScript Class
		 ds=new DriverScript();
		 ds.setEnvprop(envprop);
		 ds.setProp(prop);
	 }
	 
	 @AfterMethod
	 public void quit()
	 {
		 if(ds!=null)
		 ds.quit();
	 }
	 

}
