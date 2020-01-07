package com.selenium.automation.supporters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelReader1 {
	private String Filepath;
	private FileInputStream fip;
	private Workbook workbook;
	private Sheet sheet;
	private Row row;
	private Cell cell;
	private String cellValue;
	//private File file;
	
	//Excel sheet is a place where we can maintain the test data in the form of rows and columns
	//this excel file contains multiple sheets in order to differentiate the test data.
	//In order to perform read & write operations on excel, we have one API called 'Apache POI API'.
	//this API is from org.apache organization
	public ExcelReader1(String Filepath) throws FileNotFoundException {
		 this.Filepath = Filepath;
		 /*file = new File(Filepath);
		 fip = new FileInputStream(file);*/
		 fip = new FileInputStream(Filepath);//to specify a location of a file java provided predefined class called file, fileinputstream from java.io
		 try {
			 //In order to create workbook apache poi API provided one predefined class called workbookfactory
			 //this class has 1 non static() called create() to create workbook.
			workbook = WorkbookFactory.create(fip);		
		} catch (IOException e) {
			e.printStackTrace();
		}		 
	}
	
	public Sheet getSheetFromWorkbook(int index) {
		//to get sheet we hv predefined () called getsheet() in workbook Interface
		sheet = workbook.getSheetAt(index);
		return sheet;		
	}
	
	public Sheet getSheetFromWorkbook(String sheetName) {
		sheet = workbook.getSheet(sheetName);
		return sheet;
	}
	
	public String getSingleCellData(String sheetName, int rowNum, int cellNum) {
		Sheet sheet = null;
		sheet = getSheetFromWorkbook(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		String data = "";
		if(cell.getCellType() == CellType.NUMERIC) {
			cellValue = cell.getNumericCellValue()+"";
		}else if(cell.getCellType() == CellType.STRING) {
			cellValue = cell.getStringCellValue();
		}else if(cell.getCellType() == CellType.BOOLEAN) {
			cellValue = cell.getBooleanCellValue()+"";
		}
		Optional<String> opt = Optional.ofNullable(cellValue);
		if(opt.isPresent()) {
			data=cellValue;
		}else {
			System.out.println("The value is null");
		}
		return data;
	}
	
	public List<String> getSingleRowData(String sheetName,int rowNum) {
		List<String> rowData = new ArrayList<String>();
		sheet = getSheetFromWorkbook(sheetName);
		row = sheet.getRow(rowNum);
		for(int i=0;i<row.getLastCellNum();i++) {
			cell = row.getCell(i);
			if(cell.getCellType() == CellType.NUMERIC) {
				cellValue = cell.getNumericCellValue()+"";
				rowData.add(cellValue);
			}else if(cell.getCellType() == CellType.STRING) {
				cellValue = cell.getStringCellValue();
				rowData.add(cellValue);
			}
		}
		return rowData;
	}
	
	public List<String> getSingleColumnData(String sheetName, int Colnum) {
		List<String> columnData = new ArrayList<String>();
		sheet = getSheetFromWorkbook(sheetName);		
		for(int i=0;i<=sheet.getLastRowNum();i++) {	//for getLastRowNum 
			row = sheet.getRow(i);
			cell = row.getCell(Colnum);
			if(cell.getCellType() == CellType.STRING) {
				cellValue = cell.getStringCellValue();	
				columnData.add(cellValue);
			}else if(cell.getCellType() == CellType.NUMERIC) {
				cellValue = cell.getNumericCellValue()+"";
				columnData.add(cellValue);
			}		
		}
		return columnData;
	}
	
	public List<String> getExcelData(String sheetName) {
		List<String> excelData = new ArrayList<String>();
		sheet = getSheetFromWorkbook(sheetName);
		for(int i=0;i<=sheet.getLastRowNum();i++) {
			row = sheet.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++) {
				cell = row.getCell(j);
				if(cell.getCellType() == CellType.NUMERIC) {
					cellValue = cell.getNumericCellValue()+"";
					excelData.add(cellValue);
				}else if(cell.getCellType() == CellType.STRING) {
					cellValue = cell.getStringCellValue();
					excelData.add(cellValue);
				}
			}
		}
		return excelData;
	}
	
	public int getWholeData(String sheetName) {
		List<String> wholeData = getExcelData(sheetName);
		int a = wholeData.size();
		return a;
	}
	
	public Set<String> getTotalUniqueSheetData(String sheetName) {
		List<String> data = getExcelData(sheetName);
		Set<String> uniqueData = new LinkedHashSet<String>(data);
		return uniqueData;
	}
	
	/*public static void main(String[] args) throws FileNotFoundException {
		ExcelReader1 excelReader = new ExcelReader1("D:\\Automation\\FramesworksPractice\\TestData\\Data.xlsx");
		;
		//System.out.println(excelReader.getSingleRowData("second", 3));
		System.out.println(excelReader.getSingleColumnData("second", 2));
		//System.out.println(excelReader.getExcelData("second"));
		System.out.println(excelReader.getWholeData("second"));
		//System.out.println(excelReader.getTotalUniqueSheetData("second"));
	}*/
}
