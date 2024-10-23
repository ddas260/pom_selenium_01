package testpersonal.pom_selenium_01;

import org.testng.Assert;
import org.testng.annotations.Test;

import testpersonal.pom_selenium_01.pages.CataloguePage;
import testpersonal.pom_selenium_01.pages.LoginPage;
import testpersonal.pom_selenium_01.utils.DriverManager;

public class LoginTests extends BaseTest{
	@Test
	public void successfulLoginTest() {
		LoginPage loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.login("dibyajyoti@gmail.com", "Ddas@1234");
		CataloguePage cataloguePage = new CataloguePage(DriverManager.getDriver());
		Assert.assertEquals("Login Successfully", cataloguePage.getSuccessMessage());
	}
	
	@Test
	public void unsuccessfulLoginTest() {
		LoginPage loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.login("dibyajyoti@gmail.com", "Ddas@234");
		Assert.assertEquals("Incorrect email or password.", loginPage.getErrorMessage());
	}

}
