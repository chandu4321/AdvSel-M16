package testNgTopic;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderProgram {

	@DataProvider
	public String[][] testData(){
		String[][] data= new String[2][3];
		data[0][0] = "bhagyashree";
		data[0][1] = "A+";
		data[0][2] = "bhagyashree@gmail.com";
		
		data[1][0] = "anurag";
		data[1][1] = "O+";
		data[1][2] = "anurag@gmail.com";
		
		return data;
	}
	
	@Test(dataProvider = "testData")
	public void details(String name, String bloodGroup, String email) {
		Reporter.log(name,true);
		Reporter.log(bloodGroup,true);
		Reporter.log(email,true);
	}
}
