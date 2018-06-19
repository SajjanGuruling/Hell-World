package com.qa.tests;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RreadAndWritePropertyFile {
	
	@Test
	@Parameters({"propFilePath","propWriteFilePath"})
	public void readProperty(String propFilePath, String propWriteFilePath) throws FileNotFoundException, IOException
	{

		FileInputStream inputStream = new FileInputStream(propFilePath);
		Properties prop = new Properties();
		prop.load(inputStream);
		
		FileOutputStream writeInputStream = new FileOutputStream(propWriteFilePath);
		Properties propWrite = new Properties();
		
		
		
		
		System.out.println("Property file read by Key values");
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
		
		
		System.out.println("Property file read by Enumeration");
		Enumeration<Object> keyVals =  prop.keys();
		while(keyVals.hasMoreElements())
		{
			String key = (String) keyVals.nextElement();
			String value=(String)prop.get(key);
			System.out.println(key+"="+value);
			
			propWrite.setProperty(key, value);
			
		}
		
		propWrite.store(writeInputStream, "writtinf key and values pair by programatically");
		
	}

}
