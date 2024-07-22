package script_Vtiger;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericlib.BaseClass;
import pomRepo.CampaignsPage;
import pomRepo.OrganisationPage;

public class Script6_Test extends BaseClass{

	@Test(groups = "campaigns")
	public void script6() throws EncryptedDocumentException, IOException {
		CampaignsPage cp= new CampaignsPage(driver);
		cp.getMoreOption().click();
		cp.getCampaignsLink().click();
		cp.getCreateCampaings().click();
		cp.getCampaingsName().sendKeys(um.getDataFromExcelFile("Campaings", 0, 0));
		OrganisationPage op= new OrganisationPage(driver);
		op.getSaveButton().click();
	}
}
