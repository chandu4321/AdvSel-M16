package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement organisationLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText = "Products")
	private WebElement productsLink;

	public WebElement getOrganisationLink() {
		return organisationLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}
	
}
