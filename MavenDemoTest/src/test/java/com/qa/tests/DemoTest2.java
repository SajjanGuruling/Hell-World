package com.qa.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.Test;



public class DemoTest2 {
	@Test
	public void sum()
	{
		System.out.println("Sum Method");
		int a=10;
		int b=20;
		Assert.assertEquals(30, a+b);
	}
	
	@Test
	public void sub()
	{
		System.out.println("sub Method");
		int a=10;
		int b=20;
		Assert.assertEquals(-10, a-b);
	}
	
	@Test
	public void mult()
	{
		System.out.println("Mult Method");
		int a=10;
		int b=20;
		Assert.assertEquals(200, a*b);
	}
	
	@Test
	public void divi() throws FileNotFoundException
	{
		System.out.println("Divi Method");
		int a=10;
		int b=20;
		Assert.assertEquals(2, b/a);
			}


}
