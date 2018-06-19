package com.qa.tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.net.URL;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class FindBrokenLinks {
	
	@Test
	public void BrokenLinksOfGoogle()
	{
		String hoemPage="http://www.zlti.com";
		String url="";
		HttpURLConnection huc= null;
		int respCode=200;
		
		
		System.setProperty("webdriver.chrome.driver", "E:/06062018/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("http://www.zlti.com");
		
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		Iterator<WebElement> itr = links.iterator();
		int BrokenLinkCount=0;
		int validLinkCount=0;
		while(itr.hasNext())
		{
			url=itr.next().getAttribute("href");
			//System.out.println(url);
			
			
			if(url==null || url.isEmpty())
			{
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue;
			}
			
			if(!url.startsWith(hoemPage))
			{
				 System.out.println("URL belongs to another domain, skipping it.");
	             continue;
			}
			
			
			try {
				
				URL url1 = new URL(hoemPage);
				
				huc=(HttpURLConnection) url1.openConnection();
				huc.setRequestMethod("HEAD");
				huc.connect();
				respCode = huc.getResponseCode();
				if(respCode>=400)
				{
					System.out.println(url+" is a broken link");
					++BrokenLinkCount;
				}
				
				else{
                    System.out.println(url+" is a valid link");
                    ++validLinkCount;
                }
				
			}
			
			catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
			
		}
		
		
		
		}
		
		System.out.println("Broken Links Count: "+BrokenLinkCount);
		System.out.println("Valid Links Count: "+validLinkCount);
		
		driver.quit();

	}
	
	
	
}
