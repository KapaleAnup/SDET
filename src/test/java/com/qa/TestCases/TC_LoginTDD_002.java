package com.qa.TestCases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.CommanData.BaseClass;
import com.qa.PageObject.LoginPage;
import com.qa.utilities.TestUtil;

public class TC_LoginTDD_002 extends BaseClass{
	
	
	public void LoginTDD()
	{
		
	}
	
	//@DataProvider(name="TDD")
	//public String [][] getData()
	//{
	//	String path = System.getProperty("user.dir")+"/src/test/java/com/qa/TestData/TDD.xlsx";
	//	
	//}
	
	@DataProvider
	public Iterator<Object[]> getData()
	{
		ArrayList<Object[]> testdata =  com.qa.utilities.TestUtil.getDataFromExcel();
		return testdata.iterator();
		
	}
	
	@Test(dataProvider="getData")
	public void loginData(String username, String password)
	{
		LoginPage lp = new LoginPage(driver);
		lp.SetuserName(username);
		logger.info("user name is entered");
		lp.SetPassword(password);
		logger.info("password  is entered");
		lp.ClickonLogin();
		logger.info("clicked on login button");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			logger.info("User goes to alert and accept");
			driver.switchTo().defaultContent();
			//Assert.assertTrue(false);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		else
		{
			//Assert.assertTrue(true);
			lp.clickonLogout();
			logger.info("User clicked on logout button");
			driver.switchTo().alert().accept();
			logger.info("Pop up is accepted");
		}
	
	}
	
	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
		
	}
	

}
