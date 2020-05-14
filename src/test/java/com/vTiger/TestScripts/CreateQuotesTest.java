package com.vTiger.TestScripts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTiger.Base.BaseClass;
import com.vTiger.Base.Utility;

/**
 * 
 * @author Aishwarya
 *
 */
@Listeners(com.vTiger.Base.ListenTest.class)

public class CreateQuotesTest extends BaseClass {
	Utility util=new Utility();
	
	@Test
	public void createQuote()
	{
		/*Click on Quotes module*/
		driver.findElement(By.xpath("//a[text()='More']")).click();
		driver.findElement(By.name("Quotes")).click();
		Reporter.log("Quotes page displayed",true);
		
		/*Click on create new quote*/
		driver.findElement(By.xpath("//img[@alt=\"Create Quote...\"]")).click();
		Reporter.log("Create Quotes page displayed",true);
		
		/*Enter Subject name from excel*/
		driver.findElement(By.name("subject")).sendKeys(lib.getExcelData("Quote", 1, 0));
		
		/*Select quotestage from drop down */
		util.Selec(driver.findElement(By.name("quotestage")), lib.getExcelData("Quote", 1, 1));
		
		/* Select Organization from organization pop up*/
		driver.findElement(By.xpath("(//img[@alt=\"Select\"])[3]")).click();
		Set<String> id = driver.getWindowHandles();
		Iterator<String> ids = id.iterator();
		String pid = ids.next();
		String cid = ids.next();
		driver.switchTo().window(cid);
		driver.findElement(By.xpath("//a[text()=\"Samsung23121\"]")).click();
		Alert a1 = driver.switchTo().alert();
		a1.accept();
		driver.switchTo().window(pid);
		Reporter.log("Select Organization from organization pop up",true);
		
		/* Copy Billing Address */
		driver.findElement(By.name("bill_street")).sendKeys(lib.getExcelData("Quote", 1, 2));
		driver.findElement(By.name("bill_country")).sendKeys(lib.getExcelData("Quote", 1, 4));
		driver.findElement(By.xpath("//input[@onclick=\"return copyAddressRight(EditView)\"]")).click();
		Reporter.log("Copy Billing Address",true);
		
		/*Select Product from product pop up window*/
		driver.findElement(By.xpath("//img[@title=\"Products\"]")).click();
		Set<String> id1 = driver.getWindowHandles();
		Iterator<String> ids1 = id1.iterator();
		String pids = ids1.next();
		String cids = ids1.next();
		driver.switchTo().window(cids);
		driver.findElement(By.xpath("//a[text()=\"Speakers\"]")).click();
		driver.switchTo().window(pids);
		Reporter.log("Select Product from product pop up window",true);
		
		/*Enter quantity*/
		driver.findElement(By.xpath("//input[@name=\"qty1\"]")).sendKeys(lib.getExcelData("Quote", 1, 5));
		
	
		/*Click on save button*/
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		Reporter.log("Product saved successfully",true);

	}

}
