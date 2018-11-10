package com.qa.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.CommanData.BaseClass;
import com.qa.PageObject.AddCustomerPage;
import com.qa.PageObject.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	
	@Test
	public void AddnewCustomerPageTest() throws IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.SetuserName(username);
		lp.SetPassword(password);
		lp.ClickonLogin();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("Provide customer details ......");
		addcust.ClickOnAddNewCustomer();
		addcust.CustomerName("Test");
		addcust.selectgender("male");
		addcust.CustomerDOB("08","11","1990");
		addcust.CustomerAddress("Mumbai");
		addcust.CustomerCity("Mumbai");
		addcust.CustomerState("Maharashtra");
		addcust.CustomerPin("5880808");
		addcust.CustomerMobile("6666666666");
		
		String email = randomstring()+"@gmail.com";
		addcust.CustomerEmail(email);
		System.out.println(email);
		
		addcust.CustomerPassword("wefwrtwr3");
		addcust.clickonSubmit();
		
		boolean flag = driver.getPageSource().contains("");
		if(flag==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver, "AddNewCustomerTest");
			Assert.assertTrue(false);
		}
		
	}
	
}
