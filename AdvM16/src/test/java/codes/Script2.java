package codes;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericlib.ExcelUtil;
import genericlib.JavaUtil;
import genericlib.WebdriverUtil;

public class Script2 {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver= new ChromeDriver();
		WebdriverUtil wb= new WebdriverUtil();
		wb.maximizeTheWindow(driver);
		wb.implicitlyWait(driver);
		ExcelUtil um= new ExcelUtil();
		driver.get(um.getDataFromPropertyFile("url"));
		driver.findElement(By.name("user_name")).sendKeys(um.getDataFromPropertyFile("username"));
		driver.findElement(By.name("user_password")).sendKeys(um.getDataFromPropertyFile("password"));
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		Thread.sleep(3000);
		JavaUtil ja= new JavaUtil();
		int ranNum = ja.getRandonNumber();
		driver.findElement(By.name("accountname")).sendKeys(um.getDataFromExcelFile("Organisation", 0, 0)+ranNum);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(2000);
		wb.closeBrowser(driver);
	}
}
