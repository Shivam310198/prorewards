package login_flow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.SessionManager;

public class login {
	public static void main(String[] args) throws InterruptedException, IOException {
		
	

//	public class vv {
		WebDriver driver;

//		@BeforeMethod
//		public void setup() {

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver(options);
//		driver.manage().window().maximize();
			driver.manage().window().setSize((new Dimension(1050, 700)));

//		driver.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);		//landing page
			driver.get("https://qa.prorewards.io/login");
//		}

//		@Test
//		public void mobLogin() throws IOException, InterruptedException {

			// Login button
//			driver.findElement(By.xpath("//div[@class= 'get_start_mobile']")).click();
//			Thread.sleep(5000);

			// Mobile number input field
			Thread.sleep(1500);
			driver.findElement(By.xpath("//input[@class= 'PhoneInputInput']")).sendKeys("9310328351");

			// Submit button
			Thread.sleep(1500);
			driver.findElement(By.xpath("//div[@class= 'submitButton']")).click();
			Thread.sleep(1500);

			// Okay button on pop up
			driver.findElement(By.xpath("//h6[@class= 'okayButton_v1']")).click();
			Thread.sleep(1500);

			// OTP input field
			driver.findElement(By.xpath("//input[@aria-label= 'Please enter OTP character 1']")).sendKeys("1");
			driver.findElement(By.xpath("//input[@aria-label= 'Please enter OTP character 2']")).sendKeys("2");
			driver.findElement(By.xpath("//input[@aria-label= 'Please enter OTP character 3']")).sendKeys("3");
			driver.findElement(By.xpath("//input[@aria-label= 'Please enter OTP character 4']")).sendKeys("4");
			driver.findElement(By.xpath("//input[@aria-label= 'Please enter OTP character 5']")).sendKeys("5");
			driver.findElement(By.xpath("//input[@aria-label= 'Please enter OTP character 6']")).sendKeys("6");

			// Wait for google captcha
			Thread.sleep(10000);

			// OTP submit button
			driver.findElement(By.xpath("//div[@class= 'submitButton']")).click();
			Thread.sleep(2000);

			String ExpectedURL = "https://qa.prorewards.io/earn#no-back-button";
			String ActualURL = driver.getCurrentUrl();

			if (ExpectedURL.equals(ActualURL)) {
				System.out.println("User Logged in successfully");
			} else {
				System.err.println("User login unsuccessfull");
			}

			SessionManager sessionManager = new SessionManager(driver);
			sessionManager.storeSessionFile("prorewards", "9310328353");

			try {
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/p")).click();
				Thread.sleep(3000);
			} catch (Exception e) {
				// TODO: handle exception
			}
//		}

//		@AfterMethod
//		public void teardown() throws InterruptedException {

			Thread.sleep(1500);
			driver.close();

//		}

	}
}
