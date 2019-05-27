package com.Learnutomation.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Automation.Pages.BaseClass;
import com.Automation.Pages.LoginPage;
import com.LearnAutomation.Utilities.BrowserFactory;
import com.LearnAutomation.Utilities.ExcelDataProvider;
import com.LearnAutomation.Utilities.Helper;

public class LoginTestCRM extends BaseClass {

	@Test
	public void LoginAPP()
	{
	
		logger=report.createTest("Login to Vtiger");
				
		LoginPage LP=PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting appln");
		
		LP.LoginToCRm(excel.getStringData("LoginSheet", 0, 0), excel.getStringData("LoginSheet", 0, 1));
		
		logger.pass("Login Done Sucesfully");
		
	}

}
