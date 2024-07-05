package SeleniumUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

import Framework.Utils.Log;

import java.time.Duration;

public class SeleniumWrappers extends BaseTest {
	
	//Webelement element = driver.findElement(locator);
	//element.clicl();
	
	public SeleniumWrappers(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getElementText(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
			return element.getText();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			throw new TestException
			("failed method <getElementText> on element " + element);
		}
	}
	
	public boolean isElementDisplayed(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
			return element.isDisplayed();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			throw new TestException
			("failed method <isElementDisplayed> on element " + element);
		}
	}
	
	public void click(WebElement element) {
		Log.info("call method <click()> on element " + element);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			Log.info("call method <wait for visibility()> on element " + element);
			wait.until(ExpectedConditions.visibilityOf(element));
			//WebElement element = driver.findElement(locator);
			element.click();
			Log.info("method method <click()> finished " + element);
		}catch(NoSuchElementException e) {
			Log.error("Error in method <click()> " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			throw new TestException("Error on click() on element " + element);
			
			
		}
		
	//	driver.findElement(locator).click();
		
		
	}
	
	public void sendKeys(WebElement element, String text ) {
		Log.info("call method <sendKeys()> on element " + element);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration. ofSeconds(5));
			Log.info("call method <wait for visibility()> on element " + element);
			wait.until(ExpectedConditions.visibilityOf(element));
			//WebElement element = driver.findElement(locator);
			
			element.clear();
			element.sendKeys(text);
			Log.info("method method <click()> finished " + element);
			
		}catch(NoSuchElementException e) {
			
			
		}
		
	}
	
	public void hoverElement(By locator) {
		
		try {
			WebElement element = driver.findElement(locator);
		    Actions action = new Actions(driver);
			action.moveToElement(element).perform();
		}catch(Exception e) {
			new TestException(e.getMessage());
			
		}
		
	}
	
	public void dragAndDrop(By locator, int x, int y) {
		try {
			Actions action = new Actions(driver);
			action
			  .moveToElement(getWebElement(locator))
			  .clickAndHold()
			  .moveByOffset(x,y)
			  .release()
			  .perform();
			
		}catch(Exception e) {
			new TestException(e.getMessage());
		}
	}
	
	public WebElement getWebElement(By locator) {
		
		return driver.findElement(locator);
	}

	public void scrollVertically(int pixels) {
		Actions action = new Actions(driver);
		action.scrollByAmount(0, pixels).perform();
		
	}
	
	public void scrollHorizontally(int pixels) {
		Actions action = new Actions(driver);
		action.scrollByAmount(pixels, 0).perform();
		
	}
}
