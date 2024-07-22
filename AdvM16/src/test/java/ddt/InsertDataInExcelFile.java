package ddt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertDataInExcelFile {
  
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/exceldata.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		wb.getSheet("Sheet2").createRow(0).createCell(0).setCellValue("advSelenium");
		FileOutputStream fos= new FileOutputStream("./src/test/resources/exceldata.xlsx");
		wb.write(fos);
		wb.close();
		System.out.println("data is added to excel sheet");
	}
}
