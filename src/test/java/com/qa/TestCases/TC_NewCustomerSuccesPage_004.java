package com.qa.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.qa.CommanData.BaseClass;
import com.qa.PageObject.AddCustomerPage;
import com.qa.PageObject.AddCustomerSuccessPage;
import com.qa.PageObject.LoginPage;

public class TC_NewCustomerSuccesPage_004 extends BaseClass{
	
	LoginPage lp;
	AddCustomerPage ac;
	AddCustomerSuccessPage sp;
	TC_AddCustomerTest_003 t3;
	
	@Test
	public void validateSuccessPage()
	{
		lp =new LoginPage(driver);
		ac= new AddCustomerPage(driver);
		sp = new AddCustomerSuccessPage(driver);
		
		lp.SetuserName(username);
		lp.SetPassword(password);
		lp.ClickonLogin();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		try {
			t3.AddnewCustomerPageTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String id = sp.getcustomerid();
		System.out.println("Customer id is :"+ id);
		
		
		
		
		
	}

}
