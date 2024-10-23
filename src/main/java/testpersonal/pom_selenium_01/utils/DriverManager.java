package testpersonal.pom_selenium_01.utils;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class DriverManager {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static void setDriver() {
		String browser = null;
		try {
			browser = System.getProperty("browser") != null ? System.getProperty("browser"): PropertiesManager.getProperty("browser");
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.set(BrowserObjects.getBrowser(browser));
		driver.get().manage().window().setSize(new Dimension(1440, 900));
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	public static WebDriver getDriver() {
		if (driver.get() == null) {
			setDriver();
		}
		return driver.get();
	}

	public static void quitDriver() {
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove();
		}
	}

}
