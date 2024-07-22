package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getUserTxtBox() {
		return userTxtBox;
	}

	public WebElement getPasswordTxtBox() {
		return passwordTxtBox;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	@FindBy(name = "user_name")
	private WebElement userTxtBox;
	
	@FindBy(name = "user_password")
	private WebElement passwordTxtBox;
	
	@FindBy(id = "submitButton")
	private WebElement loginButton;
	
	@FindBy(xpath = "//div[text()='Powered by vtiger CRM - 5.4.0']")
	private WebElement text;

	public WebElement getText() {
		return text;
	}
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminButton;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutButton;

	public WebElement getAdminButton() {
		return adminButton;
	}

	public WebElement getSignOutButton() {
		return signOutButton;
	}
}
