package com.vTiger.Base;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenTest implements ITestListener
{
	
	@Override
	public void onTestFailure(ITestResult result)
	
	{
		String methodname = result.getMethod().getMethodName();
		Date d=new Date();
		String time = d.toString();
		String[]dates=time.split(" ");
		String day = dates[2];
		String month = dates[1];
		String year = dates[5];
		String timeWs = dates[3];
		String dateWT = day.concat(month).concat(year).concat(timeWs).replace(":", "-");
		
		EventFiringWebDriver efwd=new EventFiringWebDriver(BaseClass.staticDriver);
		 File src = efwd.getScreenshotAs(OutputType.FILE);
		 File dst = new File("./Screenshot/screenshot"+methodname+dateWT+".png");
		try 
		{
			FileUtils.copyFile(src, dst);
		} 
		
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
