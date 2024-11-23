package testpersonal.pom_selenium_01.tests;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import testpersonal.pom_selenium_01.base.BaseTest;
import testpersonal.pom_selenium_01.pages.CataloguePage;
import testpersonal.pom_selenium_01.pages.LoginPage;
import testpersonal.pom_selenium_01.utils.DriverManager;
import testpersonal.pom_selenium_01.utils.json_reader.JsonReader;
import testpersonal.pom_selenium_01.utils.json_reader.user_data_objects.User;
import testpersonal.pom_selenium_01.utils.json_reader.user_data_objects.UserData;

public class LoginTests extends BaseTest{
	@Test(dataProvider="correctDataSet", groups= {"positive_test"})
	public void successfulLoginTest(String[] data) {
		LoginPage loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.login(data[0], data[1]);
		CataloguePage cataloguePage = new CataloguePage(DriverManager.getDriver());
		Assert.assertEquals("Login Successfully", cataloguePage.getSuccessMessage());
	}
	
	@Test(dataProvider="incorrectDataSet", groups= {"negative_test"})
	public void unsuccessfulLoginTest(String[] data) {
		LoginPage loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.login(data[0],data[1]);
		Assert.assertEquals("Incorrect email or password.", loginPage.getErrorMessage());
	}
	
	@DataProvider(name="correctDataSet")
	public Object[][] getCorrectData(){
		UserData userData = null;
		try {
			userData = JsonReader.getValue("./src/test/resources/valid_users.json", UserData.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Object[][] obj = new Object[userData.getUsers().size()][2];
		int size = 0;
		for(User user:userData.getUsers()) {
			obj[size][0]=user.getEmail();
			obj[size][1]=user.getPassword();
			size++;
		}
		return obj;
	}
	
	@DataProvider(name="incorrectDataSet")
	public Object[][] getIncorrectData(){
		ObjectMapper objMap = new ObjectMapper();
		File file = new File("./src/test/resources/invalid_users.json");
		UserData userData = null;
		try {
			userData = objMap.readValue(file,UserData.class);
		} catch (StreamReadException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Object[][] obj = new Object[userData.getUsers().size()][2];
		int size = 0;
		for(User user:userData.getUsers()) {
			obj[size][0]=user.getEmail();
			obj[size][1]=user.getPassword();
			size++;
		}
		return obj;
	}

}
