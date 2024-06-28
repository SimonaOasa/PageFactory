package SeleniumUtils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	public static WebDriver driver;
	public BasePage app;
	
	@BeforeMethod(alwaysRun = true)
	public void setup() {
		//FirefoxDriver()
		//EdgeDriver()
		//System.set.property("webdriver.chrome.driver", "path to chromedriver.exe")
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://keybooks.ro/");
		
		app = new BasePage();
	}
	
	/*@BeforeClass(alwaysRun = true)
	public void deleteCookies() {
		driver.manage().deleteAllCookies();
	}
	*/
	@AfterMethod(alwaysRun = true)
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);//bad practice
		//driver.close();//inchide tab-ul curent
		driver.quit();//inchide fereastra de browser 
		
	}
	
}
