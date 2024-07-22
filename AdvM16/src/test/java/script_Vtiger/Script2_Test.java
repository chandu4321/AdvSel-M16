package script_Vtiger;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericlib.BaseClass;
import pomRepo.HomePage;
import pomRepo.OrganisationPage;

public class Script2_Test extends BaseClass{

	@Test(groups = "organisation")
	public void script2() throws EncryptedDocumentException, IOException, InterruptedException {
		HomePage hp= new HomePage(driver);
		hp.getOrganisationLink().click();
		test.log(Status.INFO, "user clicked on organisation link");
		OrganisationPage op= new OrganisationPage(driver);
		op.getCreateOrganisation().click();
		test.log(Status.INFO, "user clicked on create organisation link");
		int ranNum = ja.getRandonNumber();
		op.getOrgNameTxtBox().sendKeys(um.getDataFromExcelFile("Organisation", 0, 0)+ranNum);
		test.log(Status.INFO, "user entered data into organisation textbox");
		wb.selectDropdownByValue(op.getIndustryDropdown(), "Healthcare");
		test.log(Status.INFO, "user clicked on healthcare option in IndustryDropdown");
		Thread.sleep(2000);
		op.getSaveButton().click();
		test.log(Status.INFO, "user clicked on save button");
		Thread.sleep(2000);
		
	}
}
