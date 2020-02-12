package com.project.keywords;

import java.util.Hashtable;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GenericKeyword 
{
	
	Properties envprop;
	Properties prop;
	public String objectKey;
	public String dataKey;
	public Hashtable<String, String> data;
	public WebDriver driver;
	
	

	public void setEnvprop(Properties envprop) {
		this.envprop = envprop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public void setObjectKey(String objectKey) {
		this.objectKey = objectKey;
	}

	public void setDataKey(String dataKey) {
		this.dataKey = dataKey;
	}

	public void setData(Hashtable<String, String> data) {
		this.data = data;
	}
	

	public void openBrowser()
	{
		String browser=data.get(dataKey);
		System.out.println("Opening Browser :- " +browser);
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\drive\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
	}
	
	public void navigate()
	{
		System.out.println("Navigate to url :- "+ prop.getProperty(objectKey));
		driver.get(prop.getProperty(objectKey));
	}
	
	public void click()
	{
		System.out.println("clicking :- " + envprop.getProperty(objectKey));
		driver.findElement(By.xpath(envprop.getProperty(objectKey))).click();
	}
	
	public void type()
	{
		System.out.println("Typing :- " + envprop.getProperty(objectKey) + "Data ---" + data.get(dataKey) );
		driver.findElement(By.xpath(envprop.getProperty(objectKey))).sendKeys(data.get(dataKey));
	}
}
