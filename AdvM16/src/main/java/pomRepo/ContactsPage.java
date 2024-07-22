package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createContact;
	
	@FindBy(name = "lastname")
	private WebElement lastNameTxtBox;

	public WebElement getCreateContact() {
		return createContact;
	}

	public WebElement getLastNameTxtBox() {
		return lastNameTxtBox;
	}
	
}
