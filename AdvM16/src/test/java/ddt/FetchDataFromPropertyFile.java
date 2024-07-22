package ddt;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		//1)create fileinputstream object:
		FileInputStream fis= new FileInputStream("./src/test/resources/prop.properties");
		
		//2)create property file object:
		Properties p= new Properties();
		
		//3)load your data:
		p.load(fis);
		
		//4)fetch data:
		System.out.println(p.getProperty("url"));
		System.out.println(p.getProperty("username"));
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		String Url = p.getProperty("url");
		driver.get(Url);
	}
}
