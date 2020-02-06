package com.project.suitea;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.project.BaseClass.BaseTest;
import com.project.utils.DataUtils;

public class TestA extends BaseTest
{
  @Test(dataProvider = "getData")
  public void f(Hashtable<String, String> data) 
  {
	  System.out.println("iam test B");
  }
  
  @DataProvider
  public Object[][] getData()
  {
	  System.out.println("iam inside Data Provider...");
	  
	  //String testName="LoginTest";
	  String sheetName="Data";
	return DataUtils.getTestData(xls, sheetName, testName);
	  
  }
}
