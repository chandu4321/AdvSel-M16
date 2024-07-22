package script_Vtiger;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericlib.BaseClass;
import pomRepo.OrganisationPage;
import pomRepo.ProductPage;

public class Script5_Test extends BaseClass{

	@Test(groups = "product")
	public void script5() throws EncryptedDocumentException, IOException {
		ProductPage pp= new ProductPage(driver);
		pp.getProductLink().click();
		pp.getCreateProduct().click();
		pp.getProductName().sendKeys(um.getDataFromExcelFile("Product", 0, 0));
		OrganisationPage op= new OrganisationPage(driver);
		op.getSaveButton().click();
		
	}
}
