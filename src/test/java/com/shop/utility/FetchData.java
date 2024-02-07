package com.shop.utility;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FetchData {

	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;

	public FetchData(String sheetPath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(sheetPath);
			sheet = workbook.getSheet(sheetName);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static int getNumberOfRows() {
		int rowCount = 0;
		rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println(rowCount);
		return rowCount;
	}

	public static int getNumberOfColumns() {
		int columnCount = 0;
		columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println(columnCount);
		return columnCount;
	}

	public static String getStringData(int rowNum, int colNum) {
		String cellData = "";
		cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		return cellData;
	}

	public static int getNumericData(int rowNum, int colNum) {
		int numericData = 0;
		sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		return numericData;
	}
}
