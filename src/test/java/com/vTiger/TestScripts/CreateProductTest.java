package com.vTiger.TestScripts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTiger.Base.BaseClass;
import com.vTiger.Base.Utility;
/**
 * 
 * 
 * @author Aishwarya
 *
 */
@Listeners(com.vTiger.Base.ListenTest.class)

public class CreateProductTest extends BaseClass {
	Utility util=new Utility();
	
	@Test(priority = 2)
	public void createProduct()
	{
		/*Click on products module*/
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		Reporter.log("Product page displayed",true);

		/*Click on create product button*/
		driver.findElement(By.xpath("//img[@alt=\"Create Product...\"]")).click();
		Reporter.log("Create product page displayed",true);
		
		/*Entering data into all the fields in create product page*/
		driver.findElement(By.name("productname")).sendKeys(lib.getExcelData("Sheet1",1, 0));
		util.Selec(driver.findElement(By.name("manufacturer")), lib.getExcelData("Sheet1", 1, 1)); 
		util.Selec(driver.findElement(By.name("productcategory")), lib.getExcelData("Sheet1", 1, 2)); 
		driver.findElement(By.xpath("//img[@alt=\"Select\"]")).click();
		
		/*To switch driver control using windowhandles*/
		Set<String> id = driver.getWindowHandles();
		Iterator<String> ids = id.iterator();
		String pid = ids.next();
		String cid = ids.next();
		driver.switchTo().window(cid);
		driver.findElement(By.xpath("//a[text()='Samsung']")).click();
		driver.switchTo().window(pid);
		
		driver.findElement(By.name("unit_price")).sendKeys("");
		driver.findElement(By.name("unit_price")).sendKeys(lib.getExcelData("Sheet1", 1, 4));
		driver.findElement(By.id("qty_per_unit")).sendKeys(lib.getExcelData("Sheet1", 1, 5));
		
		/*Upload image*/
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(lib.getExcelData("Sheet1", 1, 6));
		
		driver.findElement(By.xpath("//input[@value=\"  Save  \"]")).click();
		Reporter.log("Product page saved successfully",true);

		
		
	}

}
