package com.vTiger.ORepo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vTiger.Base.BaseClass;

public class Login extends BaseClass{

		//FileLib lib=new FileLib();
	
		/*Identify webelement*/
		@FindBy(name="user_name")
		private WebElement userNameTF;
		
		@FindBy(name="user_password")
		private WebElement userPwdTF;
		
		@FindBy(xpath = "//input[@id=\"submitButton\"]")
		private WebElement LoginTF;

		/*Getters*/
		public WebElement getUserNameTF() {
			return userNameTF;
		}

		public WebElement getUserPwdTF() {
			return userPwdTF;
		}

		public WebElement getLoginTF() {
			return LoginTF;
		}
		
		/*business logic*/
		public HomePage userPwd()
		{
			userNameTF.sendKeys(lib.getPropertyValue("username"));
			userPwdTF.sendKeys(lib.getPropertyValue("password"));
			LoginTF.click();
			return new HomePage();
		}
		
		/*Constructor*/
	public  Login()
	
	{
		 PageFactory.initElements(staticDriver, this);
	}

}
