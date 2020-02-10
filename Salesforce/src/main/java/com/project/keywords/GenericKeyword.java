package com.project.keywords;

import java.util.Hashtable;
import java.util.Properties;

public class GenericKeyword 
{
	
	Properties envprop;
	Properties prop;
	public String objectKey;
	public String dataKey;
	public Hashtable<String, String> data;
	
	

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
		System.out.println("Opening Browser :- " + data.get(dataKey));
	}
	
	public void navigate()
	{
		System.out.println("Navigate to url :- "+ prop.getProperty(objectKey));
	}
	
	public void click()
	{
		System.out.println("clicking :- " + envprop.getProperty(objectKey));
	}
	
	public void type()
	{
		System.out.println("Typing :- " + envprop.getProperty(objectKey) + "Data ---" + data.get(dataKey) );
	}
}
