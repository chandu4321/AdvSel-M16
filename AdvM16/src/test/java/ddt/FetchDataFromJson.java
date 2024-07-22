package ddt;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FetchDataFromJson {

	public static void main(String[] args) throws IOException {
		File file= new File("./src/test/resources/jsonFile.json");
		ObjectMapper jsonPath= new ObjectMapper();
		JsonNode data = jsonPath.readTree(file);
		System.out.println(data.get("url").asText());
		System.out.println(data.get("username").asText());
		String Url = data.get("url").asText();
		WebDriver driver= new ChromeDriver();
		driver.get(Url);
	}
}
