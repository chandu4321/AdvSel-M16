package helperAttribute;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericlib.ExcelUtil;
import genericlib.WebdriverUtil;
import pomRepo.LoginPage;

public class LearningInvocationCount {

	@Test(invocationCount = 3)
	public void script() throws IOException {
		WebDriver driver= new ChromeDriver();
		WebdriverUtil wb= new WebdriverUtil();
		ExcelUtil um= new ExcelUtil();
		wb.maximizeTheWindow(driver);
		driver.get(um.getDataFromPropertyFile("url"));
		LoginPage lp= new LoginPage(driver);
		lp.getUserTxtBox().sendKeys(um.getDataFromPropertyFile("username"));
		lp.getPasswordTxtBox().sendKeys(um.getDataFromPropertyFile("password"));
		lp.getLoginButton().click();
	}
	
//	@Test(priority = 1,invocationCount = 2)
//	public void script1(){
//		Reporter.log("testng",true);
//		}
}
