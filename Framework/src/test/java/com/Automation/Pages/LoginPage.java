package com.Automation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(name="user_name") WebElement UserName;
	@FindBy(name="user_password") WebElement PassWord;
	@FindBy(name="Login") WebElement Login;
	
	public void LoginToCRm(String TypeUname,String TypePass)
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		
		}
		
		UserName.sendKeys(TypeUname);
		PassWord.sendKeys(TypePass);
		Login.click();
	}
}
