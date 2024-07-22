package script_Vtiger;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlib.BaseClass;
import pomRepo.HomePage;
import pomRepo.OrganisationPage;

public class Script1_Test extends BaseClass{

	@Test(groups = "organisation")
	public void script1() throws EncryptedDocumentException, IOException, InterruptedException {
		HomePage hp= new HomePage(driver);
		hp.getOrganisationLink().click();
		SoftAssert sa= new SoftAssert();
		sa.assertEquals(driver.getTitle(), "Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM", "not matching");
		Thread.sleep(4000);
		OrganisationPage op= new OrganisationPage(driver);
		op.getCreateOrganisation().click();
		sa.assertEquals(op.getCreateOrgnText().isDisplayed(), true,"create orgn text not displayed");
		int ranNum = ja.getRandonNumber();
		String data = um.getDataFromExcelFile("Organisation", 0, 0)+ranNum;
		WebElement ele = op.getOrgNameTxtBox();
		ele.sendKeys(um.getDataFromExcelFile("Organisation", 0, 0)+ranNum);
		sa.assertEquals(ele.getAttribute("value"), data,"data entered not matching");
		op.getSaveButton().click();
		sa.assertEquals(driver.getTitle(), "Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM", "not matching");
		Thread.sleep(2000);
		sa.assertAll();
	}
}
