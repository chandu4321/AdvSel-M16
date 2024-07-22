package testNgTopic;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericlib.ExcelUtil;
import genericlib.WebdriverUtil;
import pomRepo.HomePage;
import pomRepo.LoginPage;
import pomRepo.OrganisationPage;

public class MultipleDataProvider {

	@DataProvider
	public String[][] testData() throws EncryptedDocumentException, IOException{
		FileInputStream fis= new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		int rol = sheet.getPhysicalNumberOfRows();
		int col = sheet.getRow(0).getPhysicalNumberOfCells();
		String[][] data= new String[rol][col];
		for(int i=0;i<rol;i++) {
			for(int j=0;j<col;j++) {
				data[i][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		return data;
	}
	@Test(dataProvider = "testData")
	public void details(String[] testData) throws IOException, InterruptedException {
		WebDriver driver= new ChromeDriver();
		WebdriverUtil wb= new WebdriverUtil();
		ExcelUtil um= new ExcelUtil();
		wb.maximizeTheWindow(driver);
		driver.get(um.getDataFromPropertyFile("url"));
		LoginPage lp= new LoginPage(driver);
		lp.getUserTxtBox().sendKeys(um.getDataFromPropertyFile("username"));
		lp.getPasswordTxtBox().sendKeys(um.getDataFromPropertyFile("password"));
		lp.getLoginButton().click();
		HomePage hp= new HomePage(driver);
		hp.getOrganisationLink().click();
		OrganisationPage op= new OrganisationPage(driver);
		op.getCreateOrganisation().click();
		Thread.sleep(2000);
		op.getOrgNameTxtBox().sendKeys(testData[0]);
		Thread.sleep(2000);
		op.getPhoneTxtBox().sendKeys(testData[1]);
		Thread.sleep(2000);
		op.getEmailTxtBox().sendKeys(testData[2]);
	}
}
