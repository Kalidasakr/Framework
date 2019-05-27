package com.LearnAutomation.Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	
	 
	
	public static WebDriver StartApplication(WebDriver driver,String BrowserName,String AppURL)	
	{
		if(BrowserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","F:\\Datas\\Kalidas Selenium\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else
		{
			System.out.println("We do not Support this browser");
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(AppURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
		
		
	}
	
	public static void QuitBrowser(WebDriver driver)
	{
		driver.quit();
	}
	

}
