package SeleniumUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver {

	//public WebDriver driver;
	
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public WebDriver initDriver(String browser) {

        if(browser.equalsIgnoreCase("chrome")) {
        	
        	driver.set(new ChromeDriver(getChromeOptions()));
        	driver.get();
        	
        }else if(browser.equalsIgnoreCase("firefox")) {
        	
        	driver.set(new FirefoxDriver(getFirefoxOptions())); 
        	driver.get();
        	
        }else if(browser.equalsIgnoreCase("edge")) {
        	
        	driver.set(new EdgeDriver(getEdgeOptions()));
        	driver.get();
        }
		
		
		
		return driver.get();
		
				
	}
	
	public static FirefoxOptions getFirefoxOptions() {
		/*FirefoxBinary binary = new FirefoxBinary();
		binary.addCommandLineOptions("--headless");
		FirefoxOptions option =  new FirefoxOptions();
		option.setBinary(binary); */
		
		FirefoxOptions option = new FirefoxOptions();
		option.addArguments("--headless");
		
		return option;
		
	}
	
	public static ChromeOptions getChromeOptions() {
		/*FirefoxBinary binary = new FirefoxBinary();
		binary.addCommandLineOptions("--headless");
		FirefoxOptions option =  new FirefoxOptions();
		option.setBinary(binary); */
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--window-size=1920,1080");
		option.addArguments("--headless");
		
		return option;
		
	}
	
	public static EdgeOptions getEdgeOptions() {
		/*FirefoxBinary binary = new FirefoxBinary();
		binary.addCommandLineOptions("--headless");
		FirefoxOptions option =  new FirefoxOptions();
		option.setBinary(binary); */
		
		EdgeOptions option = new EdgeOptions();
		option.addArguments("--window-size=1920,1080");
		option.addArguments("--headless");
		
		return option;
		
	}
	
}
