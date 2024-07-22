package hardcode;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Script4 {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis= new FileInputStream("./src/test/resources/commondata.properties");
		Properties p= new Properties();
		p.load(fis);
		String Url = p.getProperty("url");
		String userTxtBox = p.getProperty("username");
		String pswd = p.getProperty("password");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Url);
		driver.findElement(By.name("user_name")).sendKeys(userTxtBox);
		driver.findElement(By.name("user_password")).sendKeys(pswd);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		FileInputStream fis1= new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook wb= WorkbookFactory.create(fis1);
		String data = wb.getSheet("Contacts").getRow(0).getCell(0).toString();
		driver.findElement(By.name("lastname")).sendKeys(data);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		String parentId = driver.getWindowHandle();
		Set<String> ids = driver.getWindowHandles();
		ids.remove(parentId);
		for(String i:ids) {
			driver.switchTo().window(i);
			Thread.sleep(3000);
			driver.findElement(By.id("search_txt")).sendKeys("lakme");
			WebElement dropdown = driver.findElement(By.name("search_field"));
			Select sel= new Select(dropdown);
			sel.selectByVisibleText("Organization Name");
			driver.findElement(By.linkText("lakme")).click();
			Thread.sleep(2000);
		}
		driver.switchTo().window(parentId);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
}
