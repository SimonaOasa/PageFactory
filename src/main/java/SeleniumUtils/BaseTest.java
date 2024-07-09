package SeleniumUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

import com.google.common.io.Files;

public class BaseTest extends Driver{

	public  WebDriver driver;
	public BasePage app;
	

	@Parameters({"appUrl", "browser"})
	@BeforeClass(alwaysRun = true)
	public void setup(String url, String browser) {
		//FirefoxDriver()
		//EdgeDriver()
		//System.set.property("webdriver.chrome.driver", "path to chromedriver.exe")
		//driver = new ChromeDriver();
		driver = initDriver(browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		
		app = new BasePage(driver);
	}
	
	/*@BeforeClass(alwaysRun = true)
	public void deleteCookies() {
		driver.manage().deleteAllCookies();
	}
	*/
	@AfterClass(alwaysRun = true)
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);//bad practice
		//driver.close();//inchide tab-ul curent
		driver.quit();//inchide fereastra de browser 
		
	}
	
	@AfterMethod
	public void recordFailure(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus()) {
			TakesScreenshot obj = (TakesScreenshot) driver;
			//TakesScreenshot obj = (TakesScreenshot) driver;
			File picture = obj.getScreenshotAs(OutputType.FILE);
			//File picture = obj.getScreenshotAs(OutputType.FILE);
			String time = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			
			try {
				
				Files.copy(picture, new File("screenshots/"+result.getName()+"-"+time+".png"));
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
}
