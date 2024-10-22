package testpersonal.pom_selenium_01;

import java.util.List;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath="//div[contains(@class,'mb-3')]")
	List<WebElement> cardBody;
	
	public String getSuccessMessage() {
		waitForElementVisibility(successBody);
		String message = successBody.getText();
		return message;
	}
	
	public List<WebElement> getProductList() {
		waitForAllElementsVisibility(cardBody);
		return cardBody;
	}
	
	public WebElement getProductByName(String productName) {
		WebElement productEle = getProductList().stream().filter(product->product.findElement(By.xpath("//h5/b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		return productEle;
	}
	
	
	
	

}
