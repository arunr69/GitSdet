package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetFirstAndSecondColumnDataTest {
	public static void main (String[]args) throws EncryptedDocumentException, IOException {
		//
		FileInputStream fis = new FileInputStream("./src/test/resources/VtigerTestData.xlsx");
		//
		Workbook workbook = WorkbookFactory.create(fis);
		//
		Sheet sheet = workbook.getSheet("Sheet1");
		//
		
	    int rownum = sheet.getLastRowNum();
	     
	    for(int i = 1;i<=rownum;i++) {
	    	Row row1 = sheet.getRow(i);
	    	String firstcolumnData = row1.getCell(0).getStringCellValue();
	    	String secondColumnData = row1.getCell(1).getStringCellValue();
	    	System.out.println(firstcolumnData + " " + secondColumnData);
	    }
	    workbook.close();
	    	
	    
	    
		
		
	}
	
	}
	


