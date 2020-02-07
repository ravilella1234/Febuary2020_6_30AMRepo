package com.project.suitea;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.project.BaseClass.BaseTest;
import com.project.Driver.DriverScript;
import com.project.utils.DataUtils;

public class LoginTest extends BaseTest
{
  @Test(dataProvider = "getData")
  public void login(Hashtable<String, String> data) 
  {
	  if(data.get("Runmode").equals("N"))
		  throw new SkipException("RunMode is set to No");
	  
	  System.out.println("login Test...");
	  ds=new DriverScript();
	  ds.executeKeywords(xls, testName, data);
  }
  
  @DataProvider
  public Object[][] getData()
  {
	  System.out.println("iam inside Data Provider...");
	  
	  //String testName="LoginTest";
	  String sheetName="Data";
	return DataUtils.getTestData(xls, sheetName, testName);
	  
  }
 

  @AfterTest
  public void afterTest() {
	  System.out.println("After Test....");
  }

}
