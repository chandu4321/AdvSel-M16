package script_Vtiger;

import org.testng.annotations.Test;

import genericlib.BaseClass;
import pomRepo.HomePage;
import pomRepo.OrganisationPage;

public class Script3_Test extends BaseClass{

	@Test(groups = "organisation")
	public void script3() {
		HomePage hp= new HomePage(driver);
		hp.getOrganisationLink().click();
	}
}
