package profile_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.SessionManager;

public class my_stats {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
		
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		//landing page
		driver.get("https://qa.prorewards.io/");
		
		SessionManager sessionManager = new SessionManager(driver);
		sessionManager.usePreviousLoggedInSession("prorewards");
	
		driver.findElement(By.xpath("//div/p[contains(text(), 'T')]")).click();
		
		Thread.sleep(1500);
		driver.findElement(By.xpath("//div/span[contains(text(), 'My Stats')]")).click();
		
	}

}
