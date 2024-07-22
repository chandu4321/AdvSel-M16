package helperAttribute;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class LearningDependOnMethod {

	@Test(priority = 1)
	public void login() {
		int i=1/0;
		Reporter.log("user has login the appln",true);
	}
	
	@Test(dependsOnMethods = "login",priority = 2)
	public void addCart() {
		Reporter.log("user has added a product to cart",true);
	}
	
	@Test(dependsOnMethods = "login",priority = 3)
	public void logout() {
		Reporter.log("user has logout the appln",true);
	}
}
