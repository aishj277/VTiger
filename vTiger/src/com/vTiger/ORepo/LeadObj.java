package com.vTiger.ORepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vTiger.Base.BaseClass;
import com.vTiger.Base.Utility;

import bsh.util.Util;

public class LeadObj extends BaseClass{

	/*Identify webelement*/
	@FindBy(xpath="//img[@alt=\"Create Lead...\"]")
	private WebElement LeadClick;
	
	@FindBy(name="salutationtype")
	private WebElement LName;
	
	@FindBy(name="firstname")
	private WebElement LFName;
	
	@FindBy(name="lastname")
	private WebElement LLName;
	
	@FindBy(name="company")
	private WebElement LCompany;
	
	@FindBy(name="mobile")
	private WebElement LMobile;
	
	@FindBy(name="leadsource")
	private WebElement LSource;
	
	/*Getter method*/
	public WebElement getLeadClick() {
		return LeadClick;
	}

	public WebElement getLName() {
		return LName;
	}

	public WebElement getLFName() {
		return LFName;
	}

	public WebElement getLLName() {
		return LLName;
	}

	public WebElement getLCompany() {
		return LCompany;
	}

	public WebElement getLMobile() {
		return LMobile;
	}

	public WebElement getLSource() {
		return LSource;
	}

	public WebElement getLStatus() {
		return LStatus;
	}

	@FindBy(name="leadstatus")
	private WebElement LStatus;
	
	/*Business logic */
	public void LClick()
	{
		LeadClick.click();
	}
	
	public void LPage()
	{
		Utility util=new Utility();
		util.Selec(LName, lib.getExcelData("Lead", 1, 0));
		LFName.sendKeys(lib.getExcelData("Lead", 1, 1));
		LLName.sendKeys(lib.getExcelData("Lead", 1, 2));
		LCompany.sendKeys(lib.getExcelData("Lead", 1, 3));
		LMobile.sendKeys(lib.getExcelData("Lead", 1, 4));
		util.Selec(LSource, lib.getExcelData("Lead", 1, 5));
		util.Selec(LStatus, lib.getExcelData("Lead", 1, 6));


	}
	
	/*Constructor*/
	public LeadObj()
	{
		PageFactory.initElements(staticDriver, LeadObj.class);
	}
}
