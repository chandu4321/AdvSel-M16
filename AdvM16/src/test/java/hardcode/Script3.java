package hardcode;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Script3 {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis= new FileInputStream("./src/test/resources/commondata.properties");
		Properties p= new Properties();
		p.load(fis);
		String Url = p.getProperty("url");
		String userTxtBox = p.getProperty("username");
		String pswd = p.getProperty("password");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Url);
		driver.findElement(By.name("user_name")).sendKeys(userTxtBox);
		driver.findElement(By.name("user_password")).sendKeys(pswd);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		Random random= new Random();
		int ranNum = random.nextInt(100);
		FileInputStream fis1= new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook wb= WorkbookFactory.create(fis1);
		String data = wb.getSheet("Organisation").getRow(0).getCell(0).toString()+ranNum;
		Thread.sleep(3000);
		driver.findElement(By.name("accountname")).sendKeys(data);
		WebElement dropdown = driver.findElement(By.name("industry"));
		Select sel= new Select(dropdown);
		Thread.sleep(3000);
		sel.selectByValue("Healthcare");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(2000);
		driver.quit();
		
	}
}
