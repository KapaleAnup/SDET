package com.qa.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public static WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='uid']")
	WebElement txtusername;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@value='LOGIN']")
	WebElement loginbtn;
	
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	WebElement logutbtn;
	
	
	public void SetuserName(String uname)
	{
		txtusername.sendKeys(uname);
	}
	
	public void SetPassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	
	public void ClickonLogin()
	{
		loginbtn.click();
	}
	
	public void clickonLogout()
	{
		logutbtn.click();
	}
}
