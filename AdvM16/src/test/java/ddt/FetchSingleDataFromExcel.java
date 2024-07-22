package ddt;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FetchSingleDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//1)create fileinputstream object:
		FileInputStream fis= new FileInputStream("./src/test/resources/exceldata.xlsx");
		
		//2)workbook object:
		Workbook wb= WorkbookFactory.create(fis);
		
//		System.out.println(wb.getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue());
//		System.out.println(wb.getSheet("Sheet1").getRow(3).getCell(1).getNumericCellValue());
//		System.out.println(wb.getSheet("Sheet1").getRow(5).getCell(2).getBooleanCellValue());
		
		Cell cell1 = wb.getSheet("Sheet1").getRow(0).getCell(0);
		Cell cell2 = wb.getSheet("Sheet1").getRow(3).getCell(1);
		Cell cell3 = wb.getSheet("Sheet1").getRow(5).getCell(2);
		
		DataFormatter formatter= new DataFormatter();
		System.out.println(formatter.formatCellValue(cell1));
		System.out.println(formatter.formatCellValue(cell2));
		System.out.println(formatter.formatCellValue(cell3));
	}
}
