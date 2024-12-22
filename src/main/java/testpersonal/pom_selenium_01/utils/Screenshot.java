package testpersonal.pom_selenium_01.utils;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Screenshot {
	public static void takeFullPage(WebDriver driver, String path) {
		File source =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		source.renameTo(new File(path));
	}
	
	public static void takeElement(WebElement element, String path) {
		File source = element.getScreenshotAs(OutputType.FILE);
		source.renameTo(new File(path));
	}

}
