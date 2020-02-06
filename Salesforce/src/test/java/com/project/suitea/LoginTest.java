package com.project.suitea;

import java.util.Hashtable;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.project.BaseClass.BaseTest;
import com.project.utils.DataUtils;

public class LoginTest extends BaseTest
{
  @Test(dataProvider = "getData")
  public void login(Hashtable<String, String> data) 
  {
	  System.out.println("login Test...");
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
