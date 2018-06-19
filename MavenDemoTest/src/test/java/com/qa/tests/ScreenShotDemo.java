package com.qa.tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class ScreenShotDemo {
	
	@Test
	public void takeScreenShots() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "E:/06062018/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in/");
		
		TakesScreenshot tc =(TakesScreenshot)driver;
		File Source = tc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Source, new File("./ScreenShots/google.png"));
		System.out.println("Taken screen shot");
		
		driver.quit();
		
	}

}
