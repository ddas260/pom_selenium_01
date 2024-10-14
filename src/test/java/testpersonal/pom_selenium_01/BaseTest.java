package testpersonal.pom_selenium_01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	WebDriver driver;
	private static Properties prop; 
	public void initializeDriver() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream("./src/test/resources/data.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String browser = System.getProperty("browser")!= null? System.getProperty("browser"):prop.getProperty("browser");
		
		driver = switch(browser) {
		case "chrome" -> new ChromeDriver();
		case "firefox" -> new FirefoxDriver();
		default -> throw new IllegalArgumentException("Unexpected value: " + browser);
		};
		
		driver.manage().window().setSize(new Dimension(1440, 900));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	
	
	@BeforeMethod
	public void launchApp() {
		initializeDriver();
		String baseUrl = prop.getProperty("baseUrl");
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void closeApp() {
		driver.close();
	}
	
	
	
	
	

}
