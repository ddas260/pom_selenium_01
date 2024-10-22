package testpersonal.pom_selenium_01;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static void setDriver() {
		String browser = null;
		try {
			browser = System.getProperty("browser") != null ? System.getProperty("browser"): PropertiesManager.getProperty("browser");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebDriver dr = switch (browser) {
		case "chrome" -> new ChromeDriver();
		case "firefox" -> new FirefoxDriver();
		default -> throw new IllegalArgumentException("Unexpected value: " + browser);
		};
		driver.set(dr);
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
