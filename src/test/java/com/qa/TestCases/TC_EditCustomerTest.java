package com.qa.TestCases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.qa.CommanData.BaseClass;
import com.qa.PageObject.AddCustomerPage;
import com.qa.PageObject.AddCustomerSuccessPage;
import com.qa.PageObject.EditCustomerPage;
import com.qa.PageObject.LoginPage;

public class TC_EditCustomerTest extends BaseClass {
	
	
	LoginPage lp;
	AddCustomerPage ac;
	AddCustomerSuccessPage sp;
	TC_AddCustomerTest_003 t3;
	

	EditCustomerPage ep;
	
	
	@Test
	public void ClickonEditCustomerTab() {
		
		lp =new LoginPage(driver);
		ac= new AddCustomerPage(driver);
		sp = new AddCustomerSuccessPage(driver);
		ep = new EditCustomerPage();
		
		lp.SetuserName(username);
		lp.SetPassword(password);
		lp.ClickonLogin();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		ep.EditCustomer();
	}
	
	@Test
	public void getEditCustomerId() {
		ep.getEditCustomerID();
	}
	
	@Test
	public void clickonSubmitbutton() {
		ep.EditCustidSubmit();
		logger.info("The Edited cutomer id has been submitted");
	}

}
