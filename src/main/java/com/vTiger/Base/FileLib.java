package com.vTiger.Base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/** 
 * 
 * @author Aishwarya
 *
 */


public class FileLib {
	
	/*To read the data from properties file*/
	public String getPropertyValue(String key)
	
	{
		String data="";
		File fill=new File("C:\\Users\\Q1023140\\Downloads\\eclipse-workspace\\vTigerMavens\\VT.properties");
		FileInputStream ip;
		try 
		{
			ip = new FileInputStream(fill);	
			Properties prop=new Properties();
			prop.load(ip);
			data = prop.getProperty(key);
		} 
		
		catch (Exception e)
		{ 
			e.printStackTrace();
		}
		
		return data;
	}
	
	/*To read the data from Excel file*/
	public String getExcelData(String sheet, int row, int colu)
	{
		String data ="";
		FileInputStream ip;
		try {
			ip = new FileInputStream("C:\\Users\\Q1023140\\Downloads\\eclipse-workspace\\vTigerMavens\\Product details.xlsx");
			Workbook wb = WorkbookFactory.create(ip);
			Sheet sh = wb.getSheet(sheet);
			Row r = sh.getRow(row);
			Cell col = r.getCell(colu);
			data = col.getStringCellValue();
			} 
		
		catch (Exception e) 
		{	
			e.printStackTrace();
		}
			
		return data;	

}
	/**To write data to excel **/
//	public void inExcelData(String sheet, String value, int row, int colu) throws EncryptedDocumentException, IOException
//	{
//		FileInputStream ip=new FileInputStream("C:\\Users\Akshaya\eclipse-workspace\vTiger\Product details.xlsx");
//		Workbook wb = WorkbookFactory.create(ip);
//		Sheet sh = wb.getSheet(sheet);
//		Row r = sh.createRow(row);
//		 Cell col = r.createCell(colu);
//		 col.setCellValue(value);
//	}
	
}
