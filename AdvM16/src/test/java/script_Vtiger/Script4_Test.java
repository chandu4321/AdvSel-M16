package script_Vtiger;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericlib.BaseClass;
import pomRepo.ContactsPage;
import pomRepo.HomePage;
import pomRepo.OrganisationPage;

public class Script4_Test extends BaseClass{

	@Test(groups = "contacts")
	public void script4() throws EncryptedDocumentException, IOException {
		HomePage hp= new HomePage(driver);
		hp.getContactsLink().click();
		ContactsPage cp= new ContactsPage(driver);
		cp.getCreateContact().click();
		cp.getLastNameTxtBox().sendKeys(um.getDataFromExcelFile("Contacts", 0, 0));
		OrganisationPage op= new OrganisationPage(driver);
		op.getSaveButton().click();
	}
}
