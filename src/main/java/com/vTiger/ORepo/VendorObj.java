package com.vTiger.ORepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vTiger.Base.BaseClass;

public class VendorObj extends BaseClass{

	@FindBy(xpath = "//img[@alt='Create Vendor...']")
	private WebElement venClick;
	
	@FindBy(name="vendorname")
	private WebElement VName;

	public WebElement getVenClick() {
		return venClick;
	}

	public WebElement getVName() {
		return VName;
	}
	
	/*business logic */
	public void vendorClick()
	{
		venClick.click();
	}
	
	public void VendorPage()
	{
		VName.sendKeys(lib.getExcelData("Vendor", 1, 0));
	}
	
	public VendorObj()
	{
		PageFactory.initElements(staticDriver, this);
	}
	
}
