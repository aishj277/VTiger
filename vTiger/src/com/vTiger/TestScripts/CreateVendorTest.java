package com.vTiger.TestScripts;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTiger.Base.BaseClass;
import com.vTiger.Base.Utility;
import com.vTiger.ORepo.HomePage;
import com.vTiger.ORepo.SaveObj;
import com.vTiger.ORepo.VendorObj;
/**
 * 
 * @author Aishwarya
 *
 */
@Listeners(com.vTiger.Base.ListenTest.class)

public class CreateVendorTest extends BaseClass {
	Utility util=new Utility();
	
	@Test
	public void createVendor()
	{
		/*click on vendor module*/
		HomePage hp = new HomePage();
		VendorObj v = hp.vendor();
		Reporter.log("Vendor page displayed",true);
		
		/*Click on create vendor page*/
		v.vendorClick();
		Reporter.log("Create Vendor page displayed",true);

		/*Enter valid data into all the fields*/
		v.VendorPage();
		
		/*Click on save button*/
		SaveObj s=new SaveObj();
		s.saveComs();
		Reporter.log("Vendor page saved successfully",true);
	}
	

}
