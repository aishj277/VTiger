package com.vTiger.TestScripts;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTiger.Base.BaseClass;
import com.vTiger.Base.Utility;
import com.vTiger.ORepo.LeadObj;

/**
 * 
 * @author Aishwarya
 *
 */
@Listeners(com.vTiger.Base.ListenTest.class)

public class CreateLeadTest extends BaseClass{
	Utility util=new Utility();
	LeadObj l;
	@Test(priority = 5)
	public void createLead()
	{
		/*Click on lead module*/
		l = hp.Lead();
		Reporter.log("Lead page displayed",true);

		/*Click on create lead button*/
		l.LClick();
		Reporter.log("Create Lead page displayed",true);
		
		/*Enter valid data into all the fields*/
		l.LPage();
		
		/*Click on save button*/
		
		Reporter.log("Lead page saved successfully",true);


	}

}
