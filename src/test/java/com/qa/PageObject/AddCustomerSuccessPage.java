package com.qa.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.CommanData.BaseClass;

public class AddCustomerSuccessPage extends BaseClass {

	
	private static final String String = null;


	public AddCustomerSuccessPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[contains(text(),'Customer ID')]")
	WebElement txtcustomerid;
	
	@FindBy(xpath="//tbody//tr[14]//td[1]")
	WebElement continuebtn;
	
	@FindBy(xpath="//td[contains(text(),'Customer Name')]")
	WebElement txtCustomername;
	
	@FindBy(xpath="//td[contains(text(),'Gender')]")
	WebElement txtCustomergender;
	
	@FindBy(xpath="//td[contains(text(),'Birthdate')]")
	WebElement txtCustomerdob;
	
	@FindBy(xpath="//td[contains(text(),'Address')]")
	WebElement txtCustomeradd;
	
	@FindBy(xpath="//td[contains(text(),'City')]]")
	WebElement txtCustomercity;
	
	@FindBy(xpath="//td[contains(text(),'State')]")
	WebElement txtCustomerstate;
	
	@FindBy(xpath="//td[contains(text(),'Pin')]")
	WebElement txtCustomerpin;
	
	@FindBy(xpath="//td[contains(text(),'Mobile No.')]")
	WebElement txtCustomermobile;
	
	@FindBy(xpath="//td[contains(text(),'Email')]]")
	WebElement txtCustomeremail;
	
	
	public String getcustomerid()
	{
		String custid= txtcustomerid.getText();;
		return custid;
	}
	
	
	public void getCustomerName()
	{
		txtCustomername.getText();
	}
	
	public void getCustomerGender()
	{
		txtCustomergender.getText();
	}
	
	public void getCusotmerBirthdate()
	{
		txtCustomerdob.getText();
	}
	
	public void getCustomerAddress()
	{
		txtCustomeradd.getText();
	}
	
	public void getCustomerCity()
	{
		txtCustomercity.getText();
	}
	
	public void getCustomerState()
	{
		txtCustomerstate.getText();
	}
	
	public void getCustomerPin()
	{
		txtCustomerpin.getText();
	}
	
	public void getCustomerMobileNumber()
	{
		txtCustomermobile.getText();
	}
	
	public void getCustomerEmail()
	{
		txtCustomeremail.getText();
	}
	
	public void ClickonContinueButton()
	{
		continuebtn.click();
	}
	
	
	
}
