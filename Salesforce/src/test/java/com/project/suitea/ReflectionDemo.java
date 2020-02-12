package com.project.suitea;

import java.lang.reflect.Method;

public class ReflectionDemo 
{
	
	public static void sampleTest()
	{
		System.out.println("iam Sample Test.....");
	}
	
	public static void sampleTest1()
	{
		System.out.println("iam Sample Test1.....");
	}

	public static void main(String[] args) throws Exception, SecurityException 
	{
		String str="sampleTest1";
		
		
		if(str.equals("sampleTest1"))
			sampleTest1();
		
		ReflectionDemo api=new ReflectionDemo();
		Method method = api.getClass().getMethod(str);
		method.invoke(method);

	}
	
	

}
