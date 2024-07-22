package hardcode;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Script2 {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis= new FileInputStream("./src/test/resources/commondata.properties");
		Properties p= new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String userTextBox = p.getProperty("username");
		String pswd = p.getProperty("password");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(userTextBox);
		driver.findElement(By.name("user_password")).sendKeys(pswd);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		Random random= new Random();
		int ranNum = random.nextInt(100);
		FileInputStream fis1= new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook wb= WorkbookFactory.create(fis1);
		String data = wb.getSheet("Organisation").getRow(0).getCell(0).toString()+ranNum;
		driver.findElement(By.name("accountname")).sendKeys(data);
		Thread.sleep(2000);
		driver.findElement(By.id("phone")).sendKeys("9876543769");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(2000);
		driver.quit();
	}
}
