package testpersonal.pom_selenium_01.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class BrowserObjects {
	private static ChromeOptions chromeOptions = new ChromeOptions();
	private static EdgeOptions edgeOptions = new EdgeOptions();
	private static FirefoxOptions firefoxOptions = new FirefoxOptions();
	
	public static WebDriver getBrowser(String browserName) {
		WebDriver driver = null;
		if(browserName.contains("chrome")) {
			if(browserName.contains("headless")) {
				setChromeArguments("--headless");
			}
			driver = new ChromeDriver(chromeOptions);
		}
		else if(browserName.contains("edge")) {
			if(browserName.contains("headless")) {
				setEdgeArguments("--headless");
			}
			driver = new EdgeDriver(edgeOptions);
		}
		else if(browserName.contains("firefox")) {
			if(browserName.contains("headless")) {
				setFirefoxArguments("--headless");
			}
			driver = new FirefoxDriver(firefoxOptions);
		}
		else {
			throw new IllegalArgumentException("Unexpected value: " + browserName);  
		}
		return driver;
	}
	
	public static void setChromeArguments(String argument) {
		chromeOptions.addArguments(argument);
	}
	public static void setEdgeArguments(String argument) {
		edgeOptions.addArguments(argument);
	}
	public static void setFirefoxArguments(String argument) {
		firefoxOptions.addArguments(argument);
	}


}
