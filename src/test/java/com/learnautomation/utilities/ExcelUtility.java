package com.learnautomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.qameta.allure.Step;

public class ExcelUtility {
	 static String TEST_DATA_SHEET = "C:\\Users\\sumit\\eclipse-workspace\\UIFramework\\TestData\\DataSheet.xlsx";
	 static XSSFWorkbook book;
	
   public ExcelUtility() {
		try {
			
			File src= new File(TEST_DATA_SHEET);
			FileInputStream ip = new FileInputStream(src);
			
			book= new XSSFWorkbook(ip);
			
			//String value=book.getSheet(TEST_DATA_SHEET).getRow(0).getCell(0).getStringCellValue();
			//book = WorkbookFactory.create(ip);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		}
		
   
		
		public static String datavalueInString(String sheetname,int row,int col) {
			String value12=book.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
			return value12;		
		}
		
		@Step
		public static int datavalueInInt(String sheetname,int row,int col) {
			double value12=book.getSheet(sheetname).getRow(row).getCell(col).getNumericCellValue();
			int i=(int)value12;
			System.out.println(i);
			return i;
				
		}
		
}
		

				

	


