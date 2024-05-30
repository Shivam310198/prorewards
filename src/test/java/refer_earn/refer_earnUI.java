package refer_earn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.SessionManager;

public class refer_earnUI {
	
	public class test {
		private WebDriver driver;
		
		@BeforeMethod
	    public void setUp() {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			
			WebDriverManager.chromedriver().setup();
			
			
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			//landing page
			driver.get("https://qa.prorewards.io/");
			
			SessionManager sessionManager = new SessionManager(driver);
			sessionManager.usePreviousLoggedInSession("prorewards");
		}
		
		
		
		@Test
		public void referEarn() throws InterruptedException {
			driver.get("https://qa.prorewards.io/earnAndRefer");
			Thread.sleep(2500);
			boolean svg =  driver.findElement(By.xpath("//div[@class= 'refer_main_image']/svg")).isDisplayed();
			Assert.assertTrue(svg, "Element not found!");
			
		}
		
//		@AfterMethod
//	    public void tearDown() {
//	        // Close the WebDriver instance after each test method
//	        driver.quit();
//	    }
	}

}
