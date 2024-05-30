package login_flow;

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
	
	
	@Test(enabled = false)
	void demoTest() throws InterruptedException {
		
		
		//Login button
		driver.findElement(By.xpath("//div[@class= 'get_start_mobile']")).click();
		Thread.sleep(5000);
		
		//Mobile number input field
		driver.findElement(By.xpath("//input[@class= 'PhoneInputInput']")).sendKeys("1234567890");
		
		//Submit button
		driver.findElement(By.xpath("//div[@class= 'submitButton']")).click();
		Thread.sleep(5000);
		
		//Okay button on pop up
		driver.findElement(By.xpath("//h6[@class= 'okayButton_v1']")).click();
		Thread.sleep(5000);
		
		//OTP input field
		driver.findElement(By.xpath("//input[@aria-label= 'Please enter OTP character 1']")).sendKeys("1");
		driver.findElement(By.xpath("//input[@aria-label= 'Please enter OTP character 2']")).sendKeys("2");
		driver.findElement(By.xpath("//input[@aria-label= 'Please enter OTP character 3']")).sendKeys("3");
		driver.findElement(By.xpath("//input[@aria-label= 'Please enter OTP character 4']")).sendKeys("4");
		driver.findElement(By.xpath("//input[@aria-label= 'Please enter OTP character 5']")).sendKeys("5");
		driver.findElement(By.xpath("//input[@aria-label= 'Please enter OTP character 6']")).sendKeys("6");
		
		//Wait for google captcha
		Thread.sleep(20000);
		
		//OTP submit button
		driver.findElement(By.xpath("//div[@class= 'submitButton']")).click();
		Thread.sleep(5000);
		
		
		String ExpectedURL = "https://qa.prorewards.io/earn#no-back-button";
		String ActualURL = driver.getCurrentUrl();
		
		Thread.sleep(1500);
		Assert.assertEquals(ActualURL, ExpectedURL);
		
		Thread.sleep(2000);
	}
	
	@Test
    public void testElementPresence() throws InterruptedException {
		Thread.sleep(2000);
        // Check if a certain element is present on the webpage
        boolean isElementPresent = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div[4]/div[1]/div/div[2]/a")).isDisplayed();
        // Assert that the element is present
        Assert.assertTrue(isElementPresent, "Element not found!");
    }
	
	@AfterMethod
    public void tearDown() {
        // Close the WebDriver instance after each test method
        driver.quit();
    }

}
