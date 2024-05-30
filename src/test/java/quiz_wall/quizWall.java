package quiz_wall;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.SessionManager;

public class quizWall {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*", "-window-size=384,800");

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver(options);

		// landing page
		driver.get("https://qa.prorewards.io/earn");

		SessionManager sessionManager = new SessionManager(driver);
		sessionManager.usePreviousLoggedInSession("prorewards");

		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[4]/div[1]/div[3]/div[3]/img")).click();
		Thread.sleep(2000);

		Set<String> windowID = driver.getWindowHandles();
		List<String> windowlist = new ArrayList<String>(windowID);

		String pWindow = windowlist.get(0);
		String cWindow = windowlist.get(1);

		driver.switchTo().window(cWindow);
		String actTitle = driver.getTitle();
		String expTitle = "Quiz Wall";

		if (actTitle.equals(expTitle)) {
			System.out.println("Quiz Wall was opened successfully");
		} else {
			System.out.println("Quiz Wall was not opened");
		};

		Thread.sleep(3000);
		WebElement time = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div[2]/div[1]/div[2]/h5"));
		String qTime = time.getText();
		System.out.println("Word is = "+qTime);
		String arr[] = qTime.split(" ");

		String firstWord = arr[0]; 
		System.out.println("Time is = " +firstWord);
		int tTime = Integer. parseInt(firstWord);
		
		int actTime = (tTime * 60 * 1000)+5000;
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div[2]/div[3]/img")).click();
		Thread.sleep(3000);
		Thread.sleep(actTime);

		driver.switchTo().window(pWindow);

		driver.findElement(By.xpath("//div/p[contains(text(), 'T')]")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[3]/div[2]/div/div[1]/div[2]/p")).click();

		Thread.sleep(2500);
		WebElement conversion = driver
				.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[4]/div/div[2]/div[2]/div[1]"));
		new Actions(driver).scrollToElement(conversion).perform();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//div/span[contains(text(), 'My Transactions')]")).click();
		Thread.sleep(1500);
		WebElement earnedBy = driver
				.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[4]/div[2]/div[1]/h4[2]"));
		String text = earnedBy.getText();
//			System.out.println(text);
		String arr2[] = text.split(": ");
		String actOfferName = arr2[1];
//			System.out.println(actOfferName);
		String expOfferName = "QuizWall";

//			if (actOfferName.equals(expOfferName)) {
//				System.out.println("Quiz wall callback result is Positive!!! :)");
//			} else {
//				System.out.println("Quiz wall callback result is Negative :(");
//
//			}

		String currentMonth = new SimpleDateFormat("MMMM").format(new Date());
		String currentDate1 = new SimpleDateFormat("dd").format(new Date());
		String currentYear = new SimpleDateFormat("YY").format(new Date());
		String currentHour = new SimpleDateFormat("hh").format(new Date());
		String currentMinute = new SimpleDateFormat("mm").format(new Date());
//		System.out.println(currentDate1);
//		System.out.println(currentMonth);
//		System.out.println(currentYear);
		String expHour = currentHour;
		String expMinute = currentMinute;
		String expMonth = currentMonth;
		String dDate = currentDate1;
		int tDate = Integer.parseInt(dDate);
		String expYear = currentYear;
		String expDate;

		if (tDate == 1 || tDate == 21 || tDate == 31) {
			expDate = dDate + "st";

		} else if (tDate == 2 || tDate == 22) {
			expDate = dDate + "nd";
		} else if (tDate == 3 || tDate == 23) {
			expDate = dDate + "rd";
		} else {
			expDate = dDate + "th";
		}

		WebElement callBackTime = driver
				.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[4]/div[2]/div[1]/h4[1]/span"));
		String date = callBackTime.getText();
		String arr3[] = date.split(" ");

		String actMonth = arr3[0];
		String actDate = arr3[1];
		String actYear = arr3[2];
		String aTime = arr3[3];
		String arr4[] = aTime.split(":");
		String actHour = arr4[0];
		String actMinute = arr4[1];

		if (actOfferName.equals(expOfferName) && actMonth.equals(expMonth) && actDate.equals(expDate)
				&& actYear.equals(expYear) && actHour.equals(expHour)) {

			System.out.println("Quiz Wall callback is new");
			WebElement coins = driver
					.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[4]/div[2]/div[1]/h4[1]/div"));
			System.out.println("Coins earned = " + coins.getText());
		} else {
			System.out.println("There is no CallBack from QuizWall");
		}

		Thread.sleep(2000);
		driver.quit();

	}

}
