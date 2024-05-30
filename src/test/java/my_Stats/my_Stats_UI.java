package my_Stats;
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

public class my_Stats_UI {
	

	
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
			driver.get("https://qa.prorewards.io/myStat");
			
			SessionManager sessionManager = new SessionManager(driver);
			sessionManager.usePreviousLoggedInSession("prorewards");
	    }
		
		
		@Test
		public void myStats() throws InterruptedException {
			driver.findElement(By.xpath("//div/p[contains(text(), 'T')]")).click();
			
			Thread.sleep(1500);
			driver.findElement(By.xpath("//div/span[contains(text(), 'My Stats')]")).click();
			Thread.sleep(1500);
			
			Thread.sleep(2000);
	        
			boolean graph = driver.findElement(By.xpath("//div[@class= 'lineChart_myStat']")).isDisplayed();
	        Assert.assertTrue(graph, "Element not found!");
	        
			
	        boolean spin = driver.findElement(By.xpath("//div[@class= 'left_bottom_myStat']/div[@class= 'my_stat_details']/span[contains(text(), 'Spin wheel')]")).isDisplayed();
	        Assert.assertTrue(spin, "Element not found!");
	        
	        boolean scratch = driver.findElement(By.xpath("//div[@class= 'left_bottom_myStat']/div[@class= 'my_stat_details']/span[contains(text(), 'Scratch Card')]")).isDisplayed();
	        Assert.assertTrue(scratch, "Element not found!");
	        
	        boolean inProgress = driver.findElement(By.xpath("//div[@class= 'left_bottom_myStat']/div[@class= 'my_stat_details']/span[contains(text(), 'Offers in progress')]")).isDisplayed();
	        Assert.assertTrue(inProgress, "Element not found!");
	        
	        boolean withdrawals = driver.findElement(By.xpath("//div[@class= 'right_bottom_myStat']/div[@class= 'my_stat_details']/span[contains(text(), 'Withdrawals')]")).isDisplayed();
	        Assert.assertTrue(withdrawals, "Element not found!");
	        
	        boolean referScratch = driver.findElement(By.xpath("//div[@class= 'right_bottom_myStat']/div[@class= 'my_stat_details']/span[contains(text(), 'Refer scratch card')]")).isDisplayed();
	        Assert.assertTrue(referScratch, "Element not found!");
	        
	        boolean pendingEarn = driver.findElement(By.xpath("//div[@class= 'right_bottom_myStat']/div[@class= 'my_stat_details']/span[contains(text(), 'Pending Earnings')]")).isDisplayed();
	        Assert.assertTrue(pendingEarn, "Element not found!");
			
			
		}
		
		@AfterMethod
	    public void tearDown() {
	        // Close the WebDriver instance after each test method
	        driver.quit();
	    }

	}


}


