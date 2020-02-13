package com.project.Driver;

import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Properties;

import com.project.keywords.AppKeyword;
import com.project.utils.Constants;
import com.project.utils.ExcelAPI;

public class DriverScript 
{
	
	
	Properties envprop;
	Properties prop;
	AppKeyword app;
	
	public Properties getEnvprop() {
		return envprop;
	}

	public void setEnvprop(Properties envprop) {
		this.envprop = envprop;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public void quit()
	{
		if(app!=null)
		app.quit();
	}


	public void executeKeywords(ExcelAPI xls,String testName,Hashtable<String, String> testData)
	{
		int rows = xls.getRowCount(Constants.KEYWORDS_SHEET);
		System.out.println("Rows :" + rows);
		
		app=new AppKeyword();
		//send the prop  & envprop to keyword class
		app.setEnvprop(envprop);
		app.setProp(prop);
		app.setData(testData);
		for(int rNum=1;rNum<rows;rNum++)
		{
			String tcid = xls.getCellData(Constants.KEYWORDS_SHEET, Constants.TCID_COL, rNum);
			if(tcid.equals(testName))
			{
				String keyword = xls.getCellData(Constants.KEYWORDS_SHEET, Constants.KEYWORD_COL, rNum);
				String objectKey = xls.getCellData(Constants.KEYWORDS_SHEET, Constants.OBJECT_COL, rNum);
				String dataKey = xls.getCellData(Constants.KEYWORDS_SHEET,Constants.DATA_COL, rNum);
				String data = testData.get(dataKey);
				//System.out.println(tcid +"----"+keyword + "----" + envprop.getProperty(objectKey) +"----" + data);
				
				app.setDataKey(dataKey);
				app.setObjectKey(objectKey);
				
				
				/*if(keyword.equals("openBrowser"))
					app.openBrowser();
				else if(keyword.equals("navigate"))
					app.navigate();
				else if(keyword.equals("click"))
					app.click();
				else if(keyword.equals("type"))
					app.type();
				else if(keyword.equals("validateLogin"))
					app.validateLogin();
				else if(keyword.equals("validateTitle"))
					app.validateTitle();*/
				
				Method method;
				try 
				{
					method=app.getClass().getMethod(keyword);
					method.invoke(app);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				} 
				
			}
			
		}
		
	}

}
