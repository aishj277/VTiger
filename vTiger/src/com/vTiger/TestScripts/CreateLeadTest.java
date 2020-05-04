package com.vTiger.TestScripts;

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

public class CreateLeadTest extends BaseClass{
	Utility util=new Utility();
	
	@Test
	public void createLead()
	{
		/*Click on lead module*/
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		Reporter.log("Lead page displayed",true);

		/*Click on create lead button*/
		driver.findElement(By.xpath("//img[@alt=\"Create Lead...\"]")).click();
		Reporter.log("Create Lead page displayed",true);
		
		/*Enter valid data into all the fields*/
		util.Selec(driver.findElement(By.name("salutationtype")), lib.getExcelData("Lead", 1, 0));
		driver.findElement(By.name("firstname")).sendKeys(lib.getExcelData("Lead", 1, 1));
		driver.findElement(By.name("lastname")).sendKeys(lib.getExcelData("Lead", 1, 2));
		driver.findElement(By.name("company")).sendKeys(lib.getExcelData("Lead", 1, 3));
		driver.findElement(By.name("mobile")).sendKeys(lib.getExcelData("Lead", 1, 4));
		util.Selec(driver.findElement(By.name("leadsource")), lib.getExcelData("Lead", 1, 5));
		util.Selec(driver.findElement(By.name("leadstatus")), lib.getExcelData("Lead", 1, 6));
		
		/*Click on save button*/
		driver.findElement(By.xpath("//input[@value=\"  Save  \"]")).click();
		Reporter.log("Lead page saved successfully",true);


	}

}
