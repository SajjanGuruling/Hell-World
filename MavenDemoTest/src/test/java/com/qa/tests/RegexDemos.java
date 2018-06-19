package com.qa.tests;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.testng.annotations.Test;

public class RegexDemos {
	
	@Test
	public void firstDemo()
	{
		Pattern p = Pattern.compile(".s");
		Matcher m = p.matcher("as");
		boolean bResult = m.matches();
		
		System.out.println("First way: "+bResult);
		
		boolean bSec=Pattern.compile(".s").matcher("as").matches();
		System.out.println("Second way: "+bSec);
		
		boolean bThird = Pattern.matches(".s", "as");
		System.out.println("Third way: "+bThird);
		
	}
	
	@Test
	public void SecondDemo()
	{
		Pattern p = Pattern.compile("[abc]");
		Matcher m = p.matcher("amma");
		System.out.println("Matching Result: "+m.matches());
		
	}

	/*Create a regular expression that accepts alpha numeric characters only. Its 
	length must be 6 characters long only.*/  
	
	@Test
	public void Demo1()
	{
		Pattern p= Pattern.compile("[a-z A-Z 0-9]{6}");
		Matcher m = p.matcher("ggsg12");
		
		
		
		System.out.println("Accepts alpha numeric characters only. Its length must be 6 characters long only: "+m.matches());
	}
	
	/*Create a regular expression that accepts 10 digit numeric characters 
	 starting with 7, 8 or 9 only.*/  
	@Test
	public void Demo2()
	{
		Pattern p= Pattern.compile("[789]?[0-9]{9}");
		Matcher m = p.matcher("7916666564");
		
		
		
		System.out.println("Accepts 10 digit numeric characters starting with 7, 8 or 9 only: "+m.matches());
	}
	
	//Java Regex Finder Example
	
	@Test
	public void demo3()
	{
		Scanner sc=new Scanner(System.in);  
        while (true) {    
            System.out.println("Enter regex pattern:");  
            Pattern pattern = Pattern.compile(sc.nextLine());    
            System.out.println("Enter text:");  
            Matcher matcher = pattern.matcher(sc.nextLine());    
            boolean found = false;    
            while (matcher.find()) {    
                System.out.println("I found the text :"+matcher.group()+" starting at index: "+    
                 matcher.start()+" and ending at index: "+matcher.end());    
                found = true;    
            }    
            if(!found){    
                System.out.println("No match found.");    
            }
            
            if(found==true)
            	break;
        }  
	}
	
	
	@Test
	public void Demo4()
	{
		Pattern p= Pattern.compile("a");
		String[] words=p.split("Bangalore is garden city, and its cool city");
		for(String word:words)
			System.out.println(word);
		
	}
	
}
