package ddt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("bangalore541@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("bangalore123");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}
}
