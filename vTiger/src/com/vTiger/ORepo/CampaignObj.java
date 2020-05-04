package com.vTiger.ORepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vTiger.Base.BaseClass;
import com.vTiger.Base.Utility;

public class CampaignObj extends Utility{

	 Utility util=new Utility();

	/*Identify webelement*/
	@FindBy(xpath = "//img[@alt='Create Campaign...']")
	private WebElement createCamp;
	
	@FindBy(name = "campaignname")
	private WebElement campName;
	
	@FindBy(xpath = "//select[@name='campaignstatus']")
	private WebElement campStatus;
	
	@FindBy(xpath = "//select[@name='campaigntype']")
	private WebElement campType;
	
	@FindBy(name="closingdate")
	private WebElement closeDate;
	
	/*Getter methods*/
	public WebElement getCreateCamp() {
		return createCamp;
	}

	public WebElement getCampName() {
		return campName;
	}

	public WebElement getCampStatus() {
		return campStatus;
	}

	public WebElement getCampType() {
		return campType;
	}
	
	public WebElement getCloseDate()
	{
		return closeDate;
	}
	
	
	/*Business logic*/
	
	public void createCamps()
	{
		createCamp.click();
		
	}
	public void createCampPage()
	{
		//util.timeOut(20);
		campName.sendKeys(lib.getExcelData("Campaign", 1, 0));
		util.Selec(campStatus, lib.getExcelData("Campaign", 1, 1));
		util.Selec(campType, lib.getExcelData("Campaign", 1, 2));
		closeDate.sendKeys(lib.getExcelData("Campaign", 1, 3));
		
	}

	public CampaignObj()
	{
		PageFactory.initElements(staticDriver, this);
	}

}
