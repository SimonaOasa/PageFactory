package Tests;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Framework.Utils.PropertiesFileProcessor;
import PageObject.MenuPage;
import PageObject.MyAccountPage;
import SeleniumUtils.BaseTest;

public class LoginTest extends BaseTest {
	
	String USER = PropertiesFileProcessor.readPropertiesFile("user", "credentials.properties");
	String PASS = PropertiesFileProcessor.readPropertiesFile("pass", "credentials.properties");

	
	@Test(priority=1)
	public void loginTest() {
		
		//MenuPage menuPage = new MenuPage(driver);
		app.click(app.menuPage.myAccountLink);
		
		//MyAccountPage myAccPage = new MyAccountPage(driver);
		app.myAccPage.loginInApp(USER, PASS);
		
		assertTrue(app.myAccPage.myAccountContent.isDisplayed());
		
		assertTrue(app.myAccPage.isElementDisplayed(app.myAccPage.myAccountContent));
		
		app.click(app.myAccPage.logoutBtn);
		
	}
	
	@Test(priority=2)
	public void InvalidloginTest() {
		
		//MenuPage menuPage = new MenuPage(driver);
		app.click(app.menuPage.myAccountLink);
		
		//MyAccountPage myAccPage = new MyAccountPage(driver);
		app.myAccPage.loginInApp("test", PASS);
		
		assertTrue(app.myAccPage.myAccountContent.isDisplayed());
		
		assertTrue(app.myAccPage.isElementDisplayed(app.myAccPage.myAccountContent));
		
		
		
	}
}
