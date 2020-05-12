package com.vTiger.TestScripts;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTiger.Base.BaseClass;
import com.vTiger.Base.FileLib;
import com.vTiger.ORepo.CampaignObj;
import com.vTiger.ORepo.HomePage;
import com.vTiger.ORepo.SaveObj;

/**
 * 
 * @author Aishwarya
 *
 */
@Listeners(com.vTiger.Base.ListenTest.class)
public class CreateCampaignTest extends BaseClass{
	FileLib lib=new FileLib();
	public CampaignObj cp;
	//HomePage hp=new HomePage();
	@Test(priority = 3)
	public void createCampaign()
	{
		HomePage hp = new HomePage();
		cp= hp.campaigns();
		Reporter.log("Campaigns Page is dispayed",true);
		cp.createCamps();
		Reporter.log("Create campaign page displayed", true);
		
		/*Enter data into create campaign page*/
		cp.createCampPage();
		
		/*Click on save button*/
		SaveObj save=new SaveObj();
		save.saveComs();
		Reporter.log("Campaign saved successfully",true);
		
	}
	
}
