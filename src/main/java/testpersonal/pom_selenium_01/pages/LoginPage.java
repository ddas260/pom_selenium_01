package testpersonal.pom_selenium_01.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testpersonal.pom_selenium_01.base.PageUtils;

public class LoginPage extends PageUtils {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement emailField;
	@FindBy(id="userPassword")
	WebElement passwordField;
	@FindBy(id="login")
	WebElement loginButton;
	@FindBy(css="[class*='toast-error']")
	WebElement errorBody;
	
	public void login(String email, String password) {
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		loginButton.click();
	}
	
	public String getErrorMessage() {
		waitForElementVisibility(errorBody);
		String message = errorBody.getText();
		return message;
	}
	
	public void goToUrl(String url) {
		driver.navigate().to(url);
	}

}
