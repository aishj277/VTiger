package com.vTiger.ORepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vTiger.Base.BaseClass;

public class SaveObj extends BaseClass{

	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveCom;
	
	public WebElement getsaveCom()
	{
		return saveCom;
	}
	
	public void saveComs()
	{
		saveCom.click();
	}
	
	public SaveObj()
	{
		PageFactory.initElements(staticDriver, this);
	}
	
}
