package genericlib;
/**
 * @author Chandana N
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
/**
 * the below method is used to fetch the data from propertyfile
 * @param key
 * @return
 * @throws IOException
 */
	public String getDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis= new FileInputStream(IConstant.propertyFile);
		Properties p= new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
	
/**
 * this method is used to fetch the data from excelfile	
 * @param sheetname
 * @param rowNum
 * @param colNum
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public String getDataFromExcelFile(String sheetname,int rowNum, int colNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream(IConstant.excelFile);
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetname);
		return sheet.getRow(rowNum).getCell(colNum).toString();
	}
	
	public String getDataFromExcelDF(String sheetname,int rowNum, int colNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream(IConstant.excelFile);
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetname);
		Cell cell = sheet.getRow(rowNum).getCell(colNum);
		DataFormatter data= new DataFormatter();
		return data.formatCellValue(cell);
	}
	
	public static String getCurrentTime() {
		LocalDateTime dateTime= LocalDateTime.now();
		String date = dateTime.toString().replace(":", "-");
		return date;
	}
}
