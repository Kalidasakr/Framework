package com.Automation.Pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.internal.annotations.ITest;

import com.LearnAutomation.Utilities.BrowserFactory;
import com.LearnAutomation.Utilities.ConfigDataProvider;
import com.LearnAutomation.Utilities.ExcelDataProvider;
import com.LearnAutomation.Utilities.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	
	@BeforeSuite
	public void SetupSuite()
	{
		
		excel=new ExcelDataProvider();
		config=new ConfigDataProvider();
		
		ExtentHtmlReporter extend=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/"+ Helper.getCurrentDateTime() +".html"));
		report=new ExtentReports();
		report.attachReporter(extend);
	}


	@BeforeClass
	public void Setup()
	{
		driver=BrowserFactory.StartApplication(driver, config.getBrowser(), config.getURL());
	}
	
	@AfterClass
	public void tearDown() throws Exception
	{
		
		BrowserFactory.QuitBrowser(driver);	
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
		
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenShot(driver)).build());
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
		
			logger.fail("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenShot(driver)).build());
			
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
		
			logger.fail("Test Skippped", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenShot(driver)).build());
			
		}
		report.flush();
	}
}
