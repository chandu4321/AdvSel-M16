package ddt;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/exceldata.xlsx");
		
		XSSFWorkbook xs= new XSSFWorkbook(fis);
		
		System.out.println(xs.getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue());
	}
}
