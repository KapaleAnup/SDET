package com.qa.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.CommanData.BaseClass;

public class AddCustomerPage extends BaseClass{

	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement NewCustomerbtn;
	
	@FindBy(name="name")
	@CacheLookup
	WebElement txtname;
	
	@FindBy(xpath="//input[@value='m']")
	@CacheLookup
	WebElement rediogender;
	
	@FindBy(xpath="//input[@id='dob']")
	@CacheLookup
	WebElement dobfield;
	
	@FindBy(xpath="//textarea[@name='addr']")
	@CacheLookup
	WebElement txtAddress;
	
	@FindBy(xpath="//input[@name='city']")
	@CacheLookup
	WebElement txtcity;
	
	@FindBy(xpath="//input[@name='state']")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(xpath="//input[@name='pinno']")
	@CacheLookup
	WebElement txtpincode;
	
	@FindBy(xpath="//input[@name='telephoneno']")
	@CacheLookup
	WebElement txtmobile;
	
	@FindBy(xpath="//input[@name='emailid']")
	@CacheLookup
	WebElement txtemail;
	
	@FindBy(xpath="//input[@name='password']")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@value='Submit']")
	@CacheLookup
	WebElement submitbtn;
	
	@FindBy(xpath="//input[@value='Reset']")
	@CacheLookup
	WebElement resetbtn;
	
	public AddCustomerPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnAddNewCustomer()
	{
		NewCustomerbtn.click();
	}
	
	public void CustomerName(String cname)
	{
		txtname.sendKeys(cname);
	}
	public void selectgender(String cgender)
	{
		rediogender.isSelected();
		rediogender.click();
	}
	
	public void CustomerDOB(String mm, String dd, String yy)
	{
		dobfield.sendKeys(mm);
		dobfield.sendKeys(dd);
		dobfield.sendKeys(yy);
	}
	public void CustomerAddress(String add)
	{
		txtAddress.sendKeys(add);
	}
	public void CustomerCity(String ccity)
	{
		txtcity.sendKeys(ccity);
	}
	public void CustomerState(String cState)
	{
		txtState.sendKeys(cState);
	}
	public void CustomerPin(String cPin)
	{
		txtpincode.sendKeys(String.valueOf(cPin));
	}
	public void CustomerMobile(String cmobile)
	{
		txtmobile.sendKeys(cmobile);
	}
	public void CustomerEmail(String cemail)
	{
		txtemail.sendKeys(cemail);
	}
	public void CustomerPassword(String cpwd)
	{
		txtpassword.sendKeys(cpwd);
	}
	public void clickonSubmit()
	{
		submitbtn.click();
		
	}
}
