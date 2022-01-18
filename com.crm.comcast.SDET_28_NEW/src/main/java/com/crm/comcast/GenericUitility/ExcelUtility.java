package com.crm.comcast.GenericUitility;

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
/**
 * 
 * @author Arun R
 *
 */
public class ExcelUtility {
	/**
	 * This method will return string value from excel sheet
	 * @param sheetname
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * throws Throwable
	 * @throws Throwable 
	 */
	public String getStringCellData(String sheetname, int rowNo, int cellNo) throws Throwable {
		
		FileInputStream file = new FileInputStream(IpathConstants.EXCEL_FILEPATH);
		
		  Workbook workbook = WorkbookFactory.create(file);
		  
		  Sheet sheet = workbook.getSheet("Sheet1");
		  
		  Row row = sheet.getRow(rowNo);
		  
		  Cell cell = row.getCell(cellNo);
		  
		  return cell.getStringCellValue();
		  
	}
	/**
	 * This method to write data into excel sheet
	 * @param sheetname
	 * @param rowNo
	 * @param cellNo
	 * @param values
	 * @throws Throwable 
	 */
	
	public void WriteDataintoExcel(String sheetname,int rowNo,int cellNo,String values) throws Throwable {
		FileInputStream readfile = new FileInputStream(IpathConstants.EXCEL_FILEPATH);
		Workbook workbook = WorkbookFactory.create(readfile);
		workbook.createSheet(sheetname).createRow(rowNo).createCell(cellNo).setCellValue(values);
		FileOutputStream writefile = new FileOutputStream(IpathConstants.EXCEL_FILEPATH);
	    workbook.write(writefile);
	 	}

/**
 * This method will return multiple data from excel sheet
 * @param sheetname
 * @return
 * @throws Throwable 
 * @throws  
 */

      public Object[][] getMultipleData(String sheetname) throws  Throwable{
      FileInputStream file = new FileInputStream(IpathConstants.EXCEL_FILEPATH);	
      Workbook workbook = WorkbookFactory.create(file);
      Sheet sheet = workbook.getSheet(sheetname);
      int rowNo = sheet.getLastRowNum();
      short Cellno = sheet.getRow(0).getLastCellNum();
      Object[][] data = new Object[rowNo][Cellno];
      for(int i=0; i<rowNo; i++) {
    	  for(int j=0; j<Cellno; j++) {
		data[i][j]=sheet.getRow(i).getCell(j).toString();
    	  
      }
    	  
      }
      return data;
}
      /**
       * This method will return numeric value
       * @param sheetname
       * @param rowNo
       * @param cellNo
       * @return
     * @throws Throwable 
       */

public double getNumericalData(String sheetname,int rowNo,int cellNo) throws Throwable {
	FileInputStream file = new FileInputStream(IpathConstants.EXCEL_FILEPATH);
	Workbook workbook = WorkbookFactory.create(file);
	return workbook.getSheet(sheetname).getRow(rowNo).getCell(cellNo).getNumericCellValue();

	
}
}




      
      













