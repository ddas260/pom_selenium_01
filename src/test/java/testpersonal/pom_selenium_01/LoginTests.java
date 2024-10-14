package testpersonal.pom_selenium_01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{
	@Test
	public void successfulLoginTest() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("dibyajyoti@gmail.com", "Ddas@1234");
		CataloguePage cataloguePage = new CataloguePage(driver);
		Assert.assertEquals("Login Successfully", cataloguePage.getSuccessMessage());
	}
	
	@Test
	public void unsuccessfulLoginTest() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("dibyajyoti@gmail.com", "Ddas@234");
		Assert.assertEquals("Incorrect email or password.", loginPage.getErrorMessage());
	}

}
