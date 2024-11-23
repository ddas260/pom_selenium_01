package testpersonal.pom_selenium_01.base;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import testpersonal.pom_selenium_01.utils.BaseUrlManager;
import testpersonal.pom_selenium_01.utils.DriverManager;
import testpersonal.pom_selenium_01.utils.PropertiesManager;

public class BaseTest {
	@BeforeMethod(alwaysRun=true)
	public void launchApp() {
		String env = "";
		try {
			env = System.getProperty("env")!=null?System.getProperty("env"):PropertiesManager.getProperty("env");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String baseUrl=BaseUrlManager.getUrl(env);
		
		DriverManager.getDriver().get(baseUrl);
	}

	@AfterMethod(alwaysRun=true)
	public void closeApp() {
		DriverManager.quitDriver();
		
	}

}
