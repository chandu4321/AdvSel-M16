package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {

	public OrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCreateOrganisation() {
		return createOrganisation;
	}

	public WebElement getOrgNameTxtBox() {
		return orgNameTxtBox;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrganisation;
	
	@FindBy(name = "accountname")
	private WebElement orgNameTxtBox;
	
	@FindBy(name = "industry")
	private WebElement industryDropdown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(id = "phone")
	private WebElement phoneTxtBox;
	
	@FindBy(id = "email1")
	private WebElement emailTxtBox;

	public WebElement getPhoneTxtBox() {
		return phoneTxtBox;
	}

	public WebElement getEmailTxtBox() {
		return emailTxtBox;
	}
	
	@FindBy(xpath = "//span[text()='Creating New Organization']")
	private WebElement createOrgnText;

	public WebElement getCreateOrgnText() {
		return createOrgnText;
	}
	
}
