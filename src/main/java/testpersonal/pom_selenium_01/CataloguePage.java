package testpersonal.pom_selenium_01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CataloguePage extends PomCommons {
	private WebDriver driver;

	public CataloguePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[class*='toast-success']")
	WebElement successBody;
	
	public String getSuccessMessage() {
		waitForElementVisibility(successBody);
		String message = successBody.getText();
		return message;
	}

}
