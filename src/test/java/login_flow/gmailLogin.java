package login_flow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class gmailLogin {
	public static void main(String[] args) throws InterruptedException {
		
		
		Proxy proxy = new Proxy();
		proxy.setAutodetect(false);
		proxy.setHttpProxy("localhost:8888"); 
//		proxy.setSslProxy("localhost:8888");

	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("'--remote-allow-origins=*','--disable-web-security', '--user-data-dir', '--allow-running-insecure-content");
		
		options.setCapability("proxy", proxy);

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver(options);
//		driver.manage().window().maximize();
		driver.manage().window().setSize((new Dimension(1050, 700)));

//		driver.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);		//landing page
		driver.get("https://qa.prorewards.io/login");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div[2]/div[1]/div/div[4]")).click();
		Thread.sleep(2000);
		Set<String> windowID = driver.getWindowHandles();
		List<String> windowlist = new ArrayList<String>(windowID);
		System.out.println(windowlist);
		String pWindow = windowlist.get(0);
		String cWindow = windowlist.get(1);
		System.out.println(cWindow);
		Thread.sleep(2000);
		driver.switchTo().window(cWindow);
		Thread.sleep(5000);
		WebElement email_phone = driver.findElement(By.xpath("//input[@id='identifierId']"));
		email_phone.sendKeys("shantanu.socialpi.test123@gmail.com");
		driver.findElement(By.id("identifierNext")).click();
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		Thread.sleep(9000);
		
		password.sendKeys("your_password");
		driver.findElement(By.id("passwordNext")).click(); 
		System.out.println(driver.getTitle());
	}

}
