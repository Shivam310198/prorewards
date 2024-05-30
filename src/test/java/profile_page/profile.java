package profile_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.SessionManager;

public class profile {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*", "-window-size=384,800");

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver(options);

		// landing page
		driver.get("https://qa.prorewards.io/earn");

		String ExpectedURL = "https://qa.prorewards.io/earn";
		String ActualURL = driver.getCurrentUrl();

		if (ExpectedURL.equals(ActualURL)) {
			System.out.println("User Logged in successfully");
		} else {
			System.out.println("User login unsuccessfull");
		}

		SessionManager sessionManager = new SessionManager(driver);
		sessionManager.usePreviousLoggedInSession("prorewards");

		driver.findElement(By.xpath("//div/p[contains(text(), 'T')]")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[3]/div[2]/div/div[1]/div[2]/p")).click();

		try {
			Thread.sleep(2500);
			WebElement stats= driver.findElement(By.xpath("//div/span[contains(text(), 'My Stats')]"));
			System.out.println("Text for My Stats is= " +stats.getText());
			stats.click();
			Thread.sleep(1500);
			driver.navigate().back();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Thread.sleep(2500);
			WebElement conversion = driver
					.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[4]/div/div[2]/div[2]/div[1]"));
			new Actions(driver).scrollToElement(conversion).perform();
			Thread.sleep(1500);
			driver.findElement(By.xpath("//div/span[contains(text(), 'My Transactions')]")).click();
			Thread.sleep(1500);
			driver.navigate().back();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		try {
			Thread.sleep(2500);
			WebElement conversion = driver
					.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[4]/div/div[2]/div[2]/div[1]"));
			new Actions(driver).scrollToElement(conversion).perform();
			Thread.sleep(1500);
			driver.findElement(By.xpath("//div/span[contains(text(), 'Refer & Earn')]")).click();
			Thread.sleep(1500);
			driver.navigate().back();
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		try {
			Thread.sleep(2500);
			WebElement conversion = driver
					.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[4]/div/div[2]/div[2]/div[1]"));
			new Actions(driver).scrollToElement(conversion).perform();
			Thread.sleep(1500);
			driver.findElement(By.xpath("//div/span[contains(text(), 'Pending earnings')]")).click();
			Thread.sleep(1500);
			driver.navigate().back();
		} catch (Exception e3) {
			e3.printStackTrace();
		}

		try {
			Thread.sleep(2500);
			WebElement conversion = driver
					.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[4]/div/div[2]/div[2]/div[1]"));
			new Actions(driver).scrollToElement(conversion).perform();
			Thread.sleep(1500);
			driver.findElement(By.xpath("//div/span[contains(text(), 'Login Info')]")).click();
		} catch (Exception e4) {
			e4.printStackTrace();
		}

		try {
			Thread.sleep(2500);
			WebElement conversion = driver
					.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[4]/div/div[2]/div[2]/div[1]"));
			new Actions(driver).scrollToElement(conversion).perform();
			Thread.sleep(1500);
			driver.findElement(By.xpath("//div/span[contains(text(), 'Logout')]")).click();
		} catch (Exception e5) {
			e5.printStackTrace();
		}

		Thread.sleep(1500);
		driver.close();
	}

}