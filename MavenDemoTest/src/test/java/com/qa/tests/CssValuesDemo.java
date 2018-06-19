package com.qa.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.gson.annotations.Until;

public class CssValuesDemo {
	
	@Test
	public void verifyBacjgroundColor()
	{
		System.setProperty("webdriver.chrome.driver", "E:/06062018/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.google.co.in/");
		
		String beforeBtnColor = driver.findElement(By.xpath("//input[@value='Google Search']")).getCssValue("color");
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//input[@value='Google Search']"))).perform();;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Google Search']")));
		
		String afterBtnColor = driver.findElement(By.xpath("//input[@value='Google Search']")).getCssValue("color");
		
		System.out.println("Before Color: "+beforeBtnColor);
		System.out.println("After Color :"+afterBtnColor);
		
		if(beforeBtnColor.equals(afterBtnColor))
		{
			System.out.println("Search Button Color has not changed");
		}
		else
		{
			System.out.println("Search Button color has changed");
		}
		
		driver.quit();
		
		
	}

}
