package com.project.suitea;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.project.BaseClass.BaseTest;

public class LoginTest extends BaseTest
{
  @Test
  public void login() 
  {
	  System.out.println("login Test...");
  }
 

  @AfterTest
  public void afterTest() {
	  System.out.println("After Test....");
  }

}
