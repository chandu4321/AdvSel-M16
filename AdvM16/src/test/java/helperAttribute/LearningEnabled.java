package helperAttribute;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericlib.ExcelUtil;
import genericlib.WebdriverUtil;

public class LearningEnabled {

	@Test(enabled = false)
	public void enabled() throws IOException, InterruptedException {
		WebDriver driver= new ChromeDriver();
		WebdriverUtil wb= new WebdriverUtil();
		ExcelUtil um= new ExcelUtil();
		wb.maximizeTheWindow(driver);
		driver.get(um.getDataFromPropertyFile("url"));
		Thread.sleep(2000);
		wb.closeBrowser(driver);
	}
}
