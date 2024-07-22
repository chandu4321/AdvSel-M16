package helperAttribute;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericlib.ExcelUtil;
import genericlib.WebdriverUtil;
import pomRepo.LoginPage;

public class LearningThreadPoolSize {

	@Test(invocationCount = 3, threadPoolSize= 2)
	public void threadpoolsize() throws IOException, InterruptedException {
		WebDriver driver= new ChromeDriver();
		WebdriverUtil wb= new WebdriverUtil();
		ExcelUtil um= new ExcelUtil();
		wb.maximizeTheWindow(driver);
		driver.get(um.getDataFromPropertyFile("url"));
		LoginPage lp= new LoginPage(driver);
		lp.getUserTxtBox().sendKeys(um.getDataFromPropertyFile("username"));
		lp.getPasswordTxtBox().sendKeys(um.getDataFromPropertyFile("password"));
		lp.getLoginButton().click();
		Thread.sleep(2000);
		wb.closeBrowser(driver);
	}
}
