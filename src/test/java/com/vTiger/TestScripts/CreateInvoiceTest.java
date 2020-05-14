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

@Listeners(com.vTiger.Base.ListenTest.class)
public class CreateInvoiceTest extends BaseClass {
	Utility util =new Utility();
	
	@Test
	public void createInvoice()
	{
		/*Click on Invoice module*/
		driver.findElement(By.xpath("//a[text()='More']")).click();
		driver.findElement(By.name("Invoice")).click();
		Reporter.log("Invoice page displayed",true);
		
		/*Click on create new Invoice*/
		driver.findElement(By.xpath("//img[@alt=\"Create Invoice...\"]")).click();
		Reporter.log("Create Invoice page displayed",true);
		
		/*Enter Subject name from excel*/
		driver.findElement(By.name("subject")).sendKeys(lib.getExcelData("Invoice", 1, 0));
		
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
		
		/*Select the status */
		util.Selec(driver.findElement(By.name("invoicestatus")), lib.getExcelData("Invoice", 1, 1));		
		
		/* Copy Billing Address */
		driver.findElement(By.name("bill_street")).sendKeys(lib.getExcelData("Invoice", 1, 3));
		driver.findElement(By.name("bill_country")).sendKeys(lib.getExcelData("Invoice", 1, 5));
		driver.findElement(By.xpath("//input[@onclick=\"return copyAddressRight(EditView)\"]")).click();
		
		
		/*Select Product from product pop up window*/
		driver.findElement(By.xpath("//img[@title=\"Products\"]")).click();
		Set<String> id1 = driver.getWindowHandles();
		Iterator<String> ids1 = id1.iterator();
		String pids = ids1.next();
		String cids = ids1.next();
		driver.switchTo().window(cids);
		driver.findElement(By.xpath("//a[text()=\"Speakers\"]")).click();
		driver.switchTo().window(pids);
		
		/*Enter quantity*/
		driver.findElement(By.xpath("//input[@name=\"qty1\"]")).sendKeys(lib.getExcelData("Invoice", 1, 6));		
		
	
		/*Click on save button*/
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		Reporter.log("Invoice page saved successfully",true);

	}

}
