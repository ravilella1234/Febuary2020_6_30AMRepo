package com.project.Driver;

import java.util.Hashtable;

import com.project.utils.ExcelAPI;

public class DriverScript 
{
	public void executeKeywords(ExcelAPI xls,String testName,Hashtable<String, String> testData)
	{
		int rows = xls.getRowCount("Keywords");
		System.out.println("Rows :" + rows);
		
		for(int rNum=1;rNum<rows;rNum++)
		{
			String tcid = xls.getCellData("Keywords", "TCID", rNum);
			if(tcid.equals(testName))
			{
				String keyword = xls.getCellData("Keywords", "Keyword", rNum);
				String objectKey = xls.getCellData("Keywords", "Object", rNum);
				String dataKey = xls.getCellData("Keywords", "Data", rNum);
				String data = testData.get(dataKey);
				
				System.out.println(tcid +"----"+keyword + "----" + objectKey +"----" + data);
			}
			
		}
		
	}

}
