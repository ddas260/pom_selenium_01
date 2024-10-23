package testpersonal.pom_selenium_01.base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtils {
	private WebDriver driver;
	public PageUtils(WebDriver driver) {
		this.driver = driver;
	}
	public void waitForElementVisibility(WebElement ele) throws TimeoutException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	public void waitForAllElementsVisibility(List<WebElement> ele) throws TimeoutException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElements(ele));
	}
	public void waitForElementInvisibility(WebElement ele) throws TimeoutException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}

}
