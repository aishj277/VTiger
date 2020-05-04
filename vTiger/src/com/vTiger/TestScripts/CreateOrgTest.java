package com.vTiger.TestScripts;

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

public class CreateOrgTest extends BaseClass {
	Utility util=new Utility();
	@Test
	public void CreateOrg()
	{
		int n=0;
		/*Click on Org module*/
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		Reporter.log("Organization page displayed",true);
		
		/*Click on create org button*/
		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
		Reporter.log("Create Organization page displayed",true);

		/*Enter valid data into all the fields*/
		driver.findElement(By.name("accountname")).sendKeys(lib.getExcelData("Org", 1, n));
		driver.findElement(By.name("website")).sendKeys(lib.getExcelData("Org", 1, 1));
		driver.findElement(By.name("phone")).sendKeys(lib.getExcelData("Org", 1, 2));
		util.Selec(driver.findElement(By.name("industry")), lib.getExcelData("Org", 1, 3));
		util.Selec(driver.findElement(By.name("accounttype")), lib.getExcelData("Org", 1, 4));
		
		/*Click on save button*/
		driver.findElement(By.xpath("//input[@value=\"  Save  \"]")).click();
		
		/*Switch to alert window*/
		Alert a1 = driver.switchTo().alert();
		a1.accept();
		try
		{
			System.out.println("try block");
			
			n++;
			driver.findElement(By.name("accountname")).sendKeys(lib.getExcelData("Org", 1, n));
			driver.findElement(By.xpath("//input[@value=\"  Save  \"]")).click();


			
		}
		catch(Exception e)
		{
			
		}

}
}

