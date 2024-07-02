package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumUtils.SeleniumWrappers;

public class MenuPage extends SeleniumWrappers{

	public MenuPage(WebDriver driver) {
	
	  super(driver);
	  PageFactory.initElements(driver, this);
}


  //public By myAccountLink = 
	@FindBy(linkText = "My account")
  public WebElement myAccountLink;
		  
  @FindBy(linkText= "CONTACT")	
  public WebElement contactPageLink;
  
}
