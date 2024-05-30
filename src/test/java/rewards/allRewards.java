package rewards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.SessionManager;

public class allRewards {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*", "-window-size=384,800");

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://qa.prorewards.io");
		SessionManager sessionManager = new SessionManager(driver);
		sessionManager.usePreviousLoggedInSession("prorewards");

		Thread.sleep(2000);
		WebElement daily = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[4]/div[27]/div[1]/img"));
		new Actions(driver).scrollToElement(daily).perform();
		Thread.sleep(1000);

		WebElement days = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[4]/div[24]/div/h5"));
		String earnPage = days.getText();

		Thread.sleep(1000);
		days.click();
		Thread.sleep(1500);

		WebElement dailyPage = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[2]/div[1]/div[2]/h5"));
		String dPage = dailyPage.getText();

		if (dPage.equals(earnPage)) {
			System.out.println("Days count on inside and outside of daily login is equal");
		} else {
			System.out.println("Days count on inside and outside of daily login is not equal");
		}

		WebElement day1 = driver
				.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[2]/div[2]/div/div[1]/div[3]"));
		String day1Status = day1.getText();

		WebElement day2 = driver
				.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[2]/div[2]/div/div[2]/div[3]"));
		String day2Status = day2.getText();

		WebElement day3 = driver
				.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[2]/div[2]/div/div[3]/div[3]"));
		String day3Status = day3.getText();

		WebElement day4 = driver
				.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[2]/div[2]/div/div[4]/div[3]"));
		String day4Status = day4.getText();

		WebElement day5 = driver
				.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[2]/div[2]/div/div[5]/div[3]"));
		String day5Status = day5.getText();

		WebElement day6 = driver
				.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[2]/div[2]/div/div[6]/div[3]"));
		String day6Status = day6.getText();

		WebElement day7 = driver
				.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[2]/div[2]/div/div[7]/div[3]"));
		String day7Status = day7.getText();

		String expText = "Claimed";
		String day = null;

		Thread.sleep(2000);
		if (day1Status.equals(expText) && !day2Status.equals(expText)) {
			WebElement day11 = driver
					.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[2]/div[2]/div/div[1]/div[1]"));
			day = day11.getText();
			System.out.println("You are at " + day);
		}

		else if (day2Status.equals(expText) && !day3Status.equals(expText)) {
			WebElement day12 = driver
					.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[2]/div[2]/div/div[2]/div[1]"));
			day = day12.getText();
			System.out.println("You are at " + day);

		}

		else if (day3Status == "Claimed" && !day4Status.equals(expText)) {
			WebElement day13 = driver
					.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[2]/div[2]/div/div[3]/div[1]"));
			day = day13.getText();
			System.out.println("You are at " + day);

		}

		else if (day4Status.equals(expText) && !day5Status.equals(expText)) {

			WebElement day14 = driver
					.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[2]/div[2]/div/div[4]/div[1]"));
			day = day14.getText();
			System.out.println("You are at " + day);

		}

		else if (day5Status.equals(expText) && !day6Status.equals(expText)) {
			WebElement day15 = driver
					.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[2]/div[2]/div/div[5]/div[1]"));
			day = day15.getText();
			System.out.println("You are at " + day);
		}

		else if (day6Status.equals(expText) && !day7Status.equals(expText)) {
			WebElement day16 = driver
					.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[2]/div[2]/div/div[6]/div[1]"));
			day = day16.getText();
			System.out.println("You are at " + day);

		}

		else if (day7Status.equals(expText)) {
			WebElement day17 = driver
					.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[2]/div[2]/div/div[7]/div[1]"));
			day = day17.getText();
			System.out.println("You are at " + day);

		}

		else {
			System.out.println("Error");
		}

	
		String arr[] = dPage.split(" / ");
		String firstWord = arr[0];
		
		String arr1[] = earnPage.split(" / ");
		String firstWordE = arr1[0];
		
		if (firstWord.equals(day) || firstWordE.equals(day)) {
			if (firstWord.equals(day) && firstWordE.equals(day)) {

				System.out.println("Days in cards matches days at above in the page and at earn page");
			} else if (firstWordE.equals(day)) {
				System.out.println("Days in cards matches days at earn page");
			} else if (firstWord.equals(day)) {
				System.out.println("Days in cards matches days at above in the page");
			} else {
				System.out.println("No Matches");
			}
		}

		driver.close();
	}

}
