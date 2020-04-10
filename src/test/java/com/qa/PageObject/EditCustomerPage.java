package com.qa.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.CommanData.BaseClass;

public class EditCustomerPage extends BaseClass {
	
	@FindBy(xpath="//a[contains(text(),'Edit Customer')]")
	public WebElement EditCustomertab;
	
	@FindBy(xpath="//input[@name='cusid']")
	public WebElement custid;
	
	@FindBy(xpath="//input[@value='Submit']")
	public WebElement btnSubmitEdit;
	
	
	public EditCustomerPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void EditCustomer() {
		EditCustomertab.click();
		
	}
	public String getEditCustomerID() {
		String Ecustid= custid.getText();
		return Ecustid;
	}
	
	public void EditCustidSubmit() {
		btnSubmitEdit.click();
	}

}
