package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadDataFromExcelSheetTest 
{
	@Test
	public void readDataFromExcelSheet() throws EncryptedDocumentException, IOException
	{
		//step 1 load excel sheet
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		// get sheet
		Sheet st = wb.getSheet("Sheet1");
		// get row
		Row ro = st.getRow(1);
		//get cell
		Cell ce = ro.getCell(1);
		//get cell value
		String value = ce.getStringCellValue();
		// print cell value
		System.out.println(value);
		
		
		
				
	}

}
