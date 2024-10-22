package testpersonal.pom_selenium_01;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	@BeforeMethod
	public void launchApp() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("./src/test/resources/data.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String baseUrl = prop.getProperty("baseUrl");
		prop.clear();
		DriverManager.getDriver().get(baseUrl);
	}

	@AfterMethod
	public void closeApp() {
		DriverManager.quitDriver();
		
	}

}
