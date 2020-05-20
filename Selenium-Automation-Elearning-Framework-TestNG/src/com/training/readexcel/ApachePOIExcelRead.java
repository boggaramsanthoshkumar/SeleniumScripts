package com.training.readexcel;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 * @author Naveen
 * @see this class will take the records from excel sheet, and return it as list
 *      of list of object, and can be generic, can given any records until it
 *      exists. Test it with main method provided, and the path is hard coded,
 *      participatns are asked to refractor this path in the property file and
 *      access.
 */
public class ApachePOIExcelRead {
	public static List<List<Object>> getExcelContent(String fileName) {
		
		List<List<Object>> list = new ArrayList<List<Object>>();
		
		try {
			System.out.println("File Name Got " + fileName);
			FileInputStream file = new FileInputStream(new File(fileName));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);
			
				
			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			 			 
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				// Skipping first record
				List<Object> tempList = new ArrayList<Object>();
				
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					
					// Check the cell type and format accordingly
					switch (cell.getCellType()) {

					case Cell.CELL_TYPE_NUMERIC:
							tempList.add(((Double) cell.getNumericCellValue()).toString()); 
						break;
					case Cell.CELL_TYPE_STRING:
							tempList.add(cell.getStringCellValue());
						break;
					}
					 
				}
				
				list.add(tempList);
				
				}
			
			
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public static List<List<Object>> getExcelContent(String fileName, String sheetName) {
		
		List<List<Object>> list = new ArrayList<List<Object>>();
		
		try {
			System.out.println("File Name Got " + fileName);
			FileInputStream file = new FileInputStream(new File(fileName));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			//XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			
				
			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			 			 
			while (rowIterator.hasNext()) {
				
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				// Skipping first record
				List<Object> tempList = new ArrayList<Object>();
				
				//skipping first row/header
				if(row.getRowNum()==0 || row.getRowNum()==0)
				{
				       continue; //just skip the rows if row number is 0 or 1
				}
				
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					
					// Check the cell type and format accordingly
					switch (cell.getCellType()) {

					case Cell.CELL_TYPE_NUMERIC:
							//tempList.add(((Double) cell.getNumericCellValue()).toString()); 
							tempList.add(NumberToTextConverter.toText(cell.getNumericCellValue()));
						break;
					case Cell.CELL_TYPE_STRING:
							tempList.add(cell.getStringCellValue());
						break;
					}
					 
				}
				
				list.add(tempList);
				
				}
			
			
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public static void main(String[] args) {
//		String fileName = "C:\\Users\\SanthoshKumarBoggara\\git\\repository\\git3\\Selenium-Automation-Elearning-Framework-TestNG\\documents\\DataSheet.xlsx";
//			for(List<Object> temp : getExcelContent(fileName)){
//					System.out.println("From the main()"+temp.get(0) + "," + temp.get(1));
//			}
		}

	}
