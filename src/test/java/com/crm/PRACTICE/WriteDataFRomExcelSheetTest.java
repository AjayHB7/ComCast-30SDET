package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class WriteDataFRomExcelSheetTest
{
	@Test
	public void readDataFromExcelSheet() throws EncryptedDocumentException, IOException
	{
		//open file in read mode
		FileInputStream fin = new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
		
		Workbook wb = WorkbookFactory.create(fin);
		
		Sheet st = wb.getSheet("Sheet1");
		//get row
		Row ro = st.getRow(0);
		// create a cell to write the data
		Cell co = ro.createCell(3);
		// write the data
		co.setCellValue("hdfc");
		// open file in write mode
		FileOutputStream fout = new FileOutputStream(".\\src\\test\\resources\\Data.xlsx");
		wb.write(fout);
		
		
		
		
		
		
	}

}
