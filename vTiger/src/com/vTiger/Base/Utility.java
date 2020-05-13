package com.vTiger.Base;



import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * 
 * @author Aishwarya
 *
 */
public class Utility extends BaseClass
{
	public void Selec(WebElement ele, String value) 
	{
	
	Select sel=new Select(ele);
	sel.selectByValue(value);
	}
	
	public void act(WebElement ele)
	{
		Actions act=new Actions(driver);
		act.moveToElement(ele);
		act.perform();
	}
	
	public void timeOut (int n)
	
	{
		driver.manage().timeouts().implicitlyWait(n, TimeUnit.SECONDS);
	}

	
}
