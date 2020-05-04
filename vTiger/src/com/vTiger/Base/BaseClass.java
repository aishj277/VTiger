package com.vTiger.Base;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.vTiger.ORepo.HomePage;
import com.vTiger.ORepo.Login;


/**
 * 
 * @author Aishwarya
 *
 */

public class BaseClass{
	
	 public FileLib lib=new FileLib();
	 public WebDriver driver=null;
	 public static WebDriver staticDriver=null;
	 //public  HomePage hp = new HomePage();

	// @Parameters("browser")
	 @BeforeClass
	//public void configB(String browserName)
	 public void configB()
	{
		if(lib.getPropertyValue("browser").equals("chrome"))
		{
			driver = new ChromeDriver();
			staticDriver=driver;
			Reporter.log("Chrome browser launched successfully");
		}
		else if(lib.getPropertyValue("browser").equals("firefox"))
		{
			driver =new FirefoxDriver();
			Reporter.log("Firefox browser launched successfully");
			staticDriver=driver;

		}
		
		driver.manage().window().maximize();
		driver.get(lib.getPropertyValue("url"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	/*login to the vTiger application*/
	 @BeforeMethod
	 public void configLogin()
	 {
		Login l =new Login();	
		l.userPwd();
	 }
	 
	 /*log out from the vTiger application*/
	 @AfterMethod
	 public void configLogOut()
	 {
		 HomePage hp = new HomePage();
		hp.LogOut();
	 }
	 
	 /*To close the browser*/
	 
	 @AfterClass
	 public void configClose()
	 {
		 driver.quit();
	 }
}
