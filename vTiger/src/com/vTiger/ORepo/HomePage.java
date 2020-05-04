package com.vTiger.ORepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vTiger.Base.BaseClass;

public class HomePage{
	
	
	/*Identify webelement*/
	@FindBy(xpath="//img[contains(@src,'user.PNG')]")
	private WebElement userImg;
	
	@FindBy(xpath="//a[contains(@href,'Logout')]")
	private WebElement signOut;
	
	/*Identifying more webelement*/
	@FindBy(xpath="//a[text()='More']")
	private WebElement More;
	
	/*Identify campaign webelement*/
	@FindBy(name = "Campaigns")
	private WebElement camp;
	
	@FindBy(name = "Vendors")
	private WebElement Vendors;
	
	/*Getter methods*/
	
	public WebElement getMore() 
	{
		return More;
	}

	public WebElement getCamp() {
		return camp;
	}

	public WebElement getUserImg() {
		return userImg;
	}

	public WebElement getSignOut() {
		return signOut;
	}	
	
	public WebElement getVendors()
	{
		return Vendors;
	}
	
	/*Business Logic*/
	public void LogOut()
	{
		userImg.click();
		signOut.click();
	
	}
	public CampaignObj campaigns()
	{
		More.click();
		camp.click();
		return new CampaignObj();
	}
	
	public VendorObj vendor()
	{
		More.click();
		Vendors.click();
		return new VendorObj();
	}
	

	public HomePage()
	{
		PageFactory.initElements(BaseClass.staticDriver,this);
	}
}
