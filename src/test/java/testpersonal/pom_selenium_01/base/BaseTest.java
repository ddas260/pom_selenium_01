package testpersonal.pom_selenium_01;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import testpersonal.pom_selenium_01.utils.DriverManager;
import testpersonal.pom_selenium_01.utils.PropertiesManager;

public class BaseTest {
	@BeforeMethod(alwaysRun=true)
	public void launchApp() {
		String baseUrl=null;
		try {
			baseUrl = PropertiesManager.getProperty("baseUrl");
		} catch (IOException e) {
			e.printStackTrace();
		}
		DriverManager.getDriver().get(baseUrl);
	}

	@AfterMethod(alwaysRun=true)
	public void closeApp() {
		DriverManager.quitDriver();
		
	}

}
