package SeleniumBasics;
import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Waits {

	public static void main(String[] args) throws InterruptedException {
//		fluentWait();
		explicitWait();
		

	}

	public static void fluentWait() {
		WebDriverManager.chromedriver().version("2.41").setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://stuntcoders.com/snippets/javascript-countdown/");

		WebElement weCountDown = driver.findElement(By.id("javascript_countdown_time"));

		FluentWait<WebElement> fWait = new FluentWait<WebElement>(weCountDown);

		fWait.withTimeout(Duration.ofSeconds(30));
		fWait.pollingEvery(Duration.ofSeconds(1));

		fWait.until(new Function<WebElement, Boolean>() {

			@Override
			public Boolean apply(WebElement we) {
				String sText = we.getText();
				System.out.println(sText);
				return sText.endsWith("01:04");
			}
		});
		
		driver.quit();
	}

	public static void explicitWait() throws InterruptedException{
		WebDriverManager.chromedriver().version("2.41").setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://demo.nopcommerce.com/register");
		
		WebElement fName = driver.findElement(By.xpath("//input[@id='FirstName']"));
		
		WebDriverWait wdWait = new WebDriverWait(driver, 20);
		
		WebElement we = wdWait.until(ExpectedConditions.visibilityOf(fName));
		we.sendKeys("Dipendra");
		
		
		if (wdWait.until(ExpectedConditions.attributeContains(By.xpath("//input[@id='FirstName']"), "name", "FirstName"))){
			System.out.println("Name is FirstName");
		}
		Thread.sleep(2000);
		driver.quit();
	}
	
	public static void fluentWait_ByClause() {
		WebDriverManager.chromedriver().version("2.41").setup();

		final WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://stuntcoders.com/snippets/javascript-countdown/");

		//WebElement weCountDown = driver.findElement(By.id("javascript_countdown_time"));
		
		FluentWait<By> fWait = new FluentWait<By>(By.id("javascript_countdown_time"));
		
		fWait.pollingEvery(Duration.ofSeconds(2));
		fWait.withTimeout(Duration.ofSeconds(20));
		
		WebElement weCountDown = fWait.until(new Function<By, WebElement>() {

			@Override
			public WebElement apply(By t) {
				// TODO Auto-generated method stub
				return driver.findElement(t);
			}
		});
	}
}
