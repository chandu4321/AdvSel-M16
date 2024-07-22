package ddt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertDataUsingMap {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream("./src/test/resources/exceldata.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet6");
		LinkedHashMap<String, String>map= new LinkedHashMap<String, String>();
		map.put("Anusiya", "t");
		map.put("bhagya", "shree");
		map.put("rikesh", "srivastava");
		int row=0;
		for(Entry<String, String>m:map.entrySet()) {
			Row rowNum = sheet.createRow(row++);
			rowNum.createCell(0).setCellValue((String)m.getKey());
			rowNum.createCell(1).setCellValue((String)m.getValue());
		}
		FileOutputStream fos= new FileOutputStream("./src/test/resources/exceldata.xlsx");
		wb.write(fos);
		wb.close();
		System.out.println("data is added");
	}
}
