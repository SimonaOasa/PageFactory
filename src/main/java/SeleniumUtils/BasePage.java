package SeleniumUtils;

import org.openqa.selenium.WebDriver;

import PageObject.ContactPage;
import PageObject.MenuPage;
import PageObject.MyAccountPage;

public class BasePage extends SeleniumWrappers{

	public BasePage(WebDriver driver) {
		super(driver);
	}
	
	public MenuPage menuPage = new MenuPage(driver);
	public MyAccountPage myAccPage = new MyAccountPage(driver);
	public ContactPage contactPage = new ContactPage(driver);
}