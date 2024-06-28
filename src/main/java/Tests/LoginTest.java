package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Framework.Utils.PropertiesFileProcessor;
import PageObject.MenuPage;
import PageObject.MyAccountPage;
import SeleniumUtils.BaseTest;

public class LoginTest extends BaseTest {
	
	String USER = PropertiesFileProcessor.readPropertiesFile("user", "credentials.properties");
	String PASS = PropertiesFileProcessor.readPropertiesFile("pass", "credentials.properties");

	
	@Test
	public void loginTest() {
		
		MenuPage menuPage = new MenuPage(driver);
		menuPage.click(menuPage.myAccountLink);
		
		MyAccountPage myAccPage = new MyAccountPage(driver);
		myAccPage.loginInApp(USER, PASS);
	}
}
