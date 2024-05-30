package store_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.SessionManager;

public class store {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*", "-window-size=384,800");

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://qa.prorewards.io/cashout");
		SessionManager sessionManager = new SessionManager(driver);
		sessionManager.usePreviousLoggedInSession("prorewards");

		// Selecting voucher to buy
		int a = 1500;
		Thread.sleep(a);
		WebElement voucher = driver
				.findElement(By.xpath("/html/body/div/div/div[1]/div/div[4]/div[2]/div[2]/div/div[2]"));
		new Actions(driver).scrollToElement(voucher).perform();
		voucher.click();

		// Selecting the amount
		Thread.sleep(2500);
		WebElement amount = driver
				.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[4]/div[3]/div[2]/div[5]/p"));//*[@id="root"]/div/div[1]/div/div[4]/div[3]/div[2]/div[5]/p
		new Actions(driver).scrollToElement(amount).perform();
		amount.click();

		// Just to scroll down
		Thread.sleep(2500);
		WebElement footer = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/h3[1]"));
		new Actions(driver).scrollToElement(footer).perform();

		// Click on Proceed to Pay
		Thread.sleep(2500);
		WebElement toPay = driver.findElement(
				By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[4]/div[8]/div[contains(text(), 'Proceed to Pay')]"));
		toPay.click();

		// Click to confirm purchase
		Thread.sleep(1500);
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[2]/h6")).click();

		// Click to open my vouchers page from the pop up comes after purchase
		Thread.sleep(10000);
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/h6[contains(text(), 'Okay')]")).click();

		// Opening the purchased voucher
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[4]/div[1]/div/div")).click();

		System.out.println("Congratulations!!! Voucher has been redeemed succesfully");
		Thread.sleep(2000);
		driver.close();

	}

}
