package com.LearnAutomation.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	//Provided DAta 
	public ExcelDataProvider()
	{
		File src=new File("F:\\KalidasWorkspace\\Framework\\ TestData\\Data.xlsx");
		
	
			try {
				FileInputStream Fis=new FileInputStream(src);
				
				wb=new XSSFWorkbook(Fis);
			} catch (IOException e) {
				System.out.println("Unable to Excel File"+e.getMessage());
			}
	}
	
	public String getStringData(int SheetIndex, int Row, int Column)
	{
		return wb.getSheetAt(SheetIndex).getRow(Row).getCell(Column).getStringCellValue();
	}
	
	public String getStringData(String SheetName, int Row, int Column)
	{
		return wb.getSheet(SheetName).getRow(Row).getCell(Column).getStringCellValue();
	}
	
	public double getNumericData(String SheetName, int Row, int Column)
	{
		return wb.getSheet(SheetName).getRow(Row).getCell(Column).getNumericCellValue();
	}

}
