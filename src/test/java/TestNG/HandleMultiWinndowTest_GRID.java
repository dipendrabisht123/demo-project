package TestNG;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;

public class HandleMultiWinndowTest_GRID extends TestBase {

	static WebDriver driver;

	/*@BeforeTest
	public void beforeTest() {
		try {
			String nodeURL = "http://192.168.1.5:5555/wd/hub";

			DesiredCapabilities capability = DesiredCapabilities.chrome();
			capability.setBrowserName("chrome");
			capability.setPlatform(Platform.WIN10);

			driver = new RemoteWebDriver(new URL(nodeURL), capability);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		} catch (MalformedURLException e) {
			System.out.println("Before test exception: " + e.getMessage());
		}
	}*/

	@Test
	public void handleMultiWindows() {
		// WebDriverManager.chromedriver().version("2.41").setup();
		// driver = new ChromeDriver();

//		String nodeURL = "http://192.168.1.5:5555/wd/hub";
		String nodeURL = "http://192.168.1.2:10291/wd/hub";
		
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setBrowserName("chrome");
		capability.setPlatform(Platform.WIN10);

		try {
			driver = new RemoteWebDriver(new URL(nodeURL), capability);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/register");

		String sParentHandle = driver.getWindowHandle();

		System.out.println("ParentHandle: " + sParentHandle);

		WebElement linkContact = driver.findElement(By.xpath("//a[@href='https://twitter.com/nopCommerce']"));

		linkContact.click();

		Set<String> setHandles = driver.getWindowHandles();

		for (String name : setHandles) {
			if (!name.equalsIgnoreCase(sParentHandle)) {
				driver.switchTo().window(name);
				System.out.println("Moved to child window: " + name);
				break;
			}
		}
		WebDriverWait wait = new WebDriverWait(driver, 60);

		WebElement txtSearch = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Search query']")));

		txtSearch.sendKeys("dipendraB");

		driver.close();

		driver.switchTo().window(sParentHandle);
		
		driver.quit();

	}
}
