package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains generic methods to read and write data into excel sheet
 * @author AJAY
 *
 */
public class ExcelFileUtilty 

{
	/**
	 * This method will read data from excel sheet when user enter 
	 * sheet name , row number, cell number
	 * @param SheetName
	 * @param rowno
	 * @param cellno
	 * @return
	 * @throws Throwable
	 * @throws Throwable
	 */
	public String readDataFromExcel(String SheetName, int rowno, int cellno) throws Throwable, Throwable
	{
		FileInputStream fin = new FileInputStream(iPathConstants.ExcelName);
		Workbook wb = WorkbookFactory.create(fin);
		Sheet st = wb.getSheet(SheetName);
		Row ro = st.getRow(rowno);
		Cell cell = ro.getCell(cellno);
		String value = cell.getStringCellValue();
		return value;

	}


	/**
	 * This method will write data to excel sheet when user enter 
	 * sheet name , row number, cell number
	 * @param SheetName
	 * @param rowno
	 * @param cellno
	 * @param value
	 * @throws Throwable
	 */
	public void writeDataFromExcel(String SheetName, int rowno, int cellno, String value) throws Throwable
	{
		FileInputStream fin = new FileInputStream(iPathConstants.ExcelName);
		Workbook wb = WorkbookFactory.create(fin);
		Sheet st = wb.getSheet(SheetName);
		Row ro = st.getRow(rowno);
		Cell cell = ro.createCell(cellno);
		cell.setCellValue(value);
	}

	/**
	 * This method will return last Rownumber of the sheet when user enters SheetName
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	public int getLastRowNumber(String SheetName) throws Throwable
	{
		FileInputStream fin = new FileInputStream(iPathConstants.ExcelName);
		Workbook wb = WorkbookFactory.create(fin);
		Sheet st = wb.getSheet(SheetName);
		int rownum = st.getLastRowNum();
		return rownum;

	}

	/**
	 * This method will return last cell number of the row when user enters SheetName and row number
	 * @param SheetName
	 * @param rowno
	 * @return
	 * @throws Throwable
	 */
	public int getLastCellNumber(String SheetName, int rowno) throws Throwable
	{
		FileInputStream fin = new FileInputStream(iPathConstants.ExcelName);
		Workbook wb = WorkbookFactory.create(fin);
		Sheet st = wb.getSheet(SheetName);
		Row ro = st.getRow(rowno);
		int cellnumber = ro.getLastCellNum();
		return cellnumber;

	}
	/**
	 * This method will read multiple data from excel sheet with the help of sheetname
	 * and return 2  dimensional object[][]
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	public Object[][] readMultipleDataFromExcel(String SheetName) throws Throwable
	{
		FileInputStream fin = new FileInputStream(iPathConstants.ExcelName);
		Workbook wb = WorkbookFactory.create(fin);
		Sheet sheet = wb.getSheet(SheetName);
		int lastrownum = sheet.getLastRowNum();
		int lastcellnum = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[lastrownum][lastcellnum];

		for (int i = 0; i < lastrownum; i++) 
		{
			for (int j = 0; j < lastcellnum ; j++) 
			{
				data[i][j] = sheet.getRow(i+1).getCell(j).getStringCellValue();

			}
		}
		return data;

	}

}
