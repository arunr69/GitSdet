package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetTheDataFromExcelSheetTest {

	public static void main (String[]args) throws Throwable, Throwable {
		//Java object representation for physical excel sheet
		FileInputStream fis = new FileInputStream("./src/test/resources/VtigerTestData.xlsx");
		//
		Workbook workbook = WorkbookFactory.create(fis);
		//Crete the workbook for physical excel sheet
		Sheet sheet = workbook.getSheet("Sheet1");
		//get the control of sheet
		Row row = sheet.getRow(1);
		//get the control of row
		Cell cell = row.getCell(2);
		//fetch the data excel
		String Orgname = cell.getStringCellValue();
		System.out.println(Orgname);
		//close the workbook
		workbook.close();
		
		
	}
}
