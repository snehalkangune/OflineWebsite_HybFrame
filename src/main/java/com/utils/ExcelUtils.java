package com.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class ExcelUtils {
	WebDriver driver = null;
	FileInputStream fis = null;
	FileOutputStream fos = null;
	Workbook wb = null;

	public static void readExcel(String filePath, String sheet) throws Exception {
		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		int rows = sh.getLastRowNum();
		for (int i = 0; i <= rows; i++) {
			int col = sh.getRow(i).getLastCellNum();
			System.out.println("no. of cols in row:" + i + " are " + col);
			for (int j = 0; j <= col; j++) {
				Cell c = sh.getRow(i).getCell(j);
				String data = df.formatCellValue(c);
				System.out.print(data + " ");
			}
			System.out.println();
		}
	}

	public void writeExcel(String filePath, String sheet, int row, int col, String result) {
		try {
			fis = new FileInputStream(filePath);
			wb = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Sheet sh = wb.getSheet(sheet);
		Cell c = sh.getRow(row).createCell(col);
		c.setCellValue(result);
		try {
			fos = new FileOutputStream(filePath);
			wb.write(fos);
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
