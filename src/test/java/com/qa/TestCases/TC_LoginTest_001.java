package com.qa.TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.CommanData.BaseClass;
import com.qa.PageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException
	{
		
		LoginPage lp = new LoginPage(driver);
		
		lp.SetuserName(username);
		logger.info("User name is entered");
		lp.SetPassword(password);
		logger.info("password is entered");
		lp.ClickonLogin();
		logger.info("Click on login button");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			logger.info("Login test passed");
			AssertJUnit.assertTrue(true);
			
			driver.switchTo().alert().dismiss();
		}
		
		else
		{
			logger.info("Login test failed");
			AssertJUnit.assertTrue(false);
			captureScreen(driver,"loginTest");
		}
		
		
	}
	
	
	

}
