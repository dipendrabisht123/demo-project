package JavaScriptExecution;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptActions {

	static JavascriptExecutor js;
	static WebDriver driver ;
	
	public static void main(String[] args) throws InterruptedException {
//		launchBrowser();
		js_Scroll();
	}

	public static void launchBrowser() throws InterruptedException {

		WebDriverManager.chromedriver().version("2.41").setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		js = (JavascriptExecutor) driver;

//		driver.get("http://testingmasters.com/hrm");
		js.executeScript("window.location = 'http://testingmasters.com/hrm'");
		
		WebElement txtUserName = driver.findElement(By.id("txtUsername"));
		WebElement txtUserName_js = (WebElement) js.executeScript("return document.getElementById('txtUsername');");

		WebElement txtPWD = driver.findElement(By.name("txtPassword"));

		WebElement btnLogin = driver.findElement(By.id("btnLogin"));

		txtUserName_js.sendKeys("user02");
		Thread.sleep(1000);

		txtPWD.sendKeys("TM1234");
		Thread.sleep(1000);

		btnLogin.click();
		Thread.sleep(2000);
		
		int i = 10;
		List<WebElement> listWelcome = driver.findElements(By.id("welcome"));

		if (listWelcome.size() > 0) {
			System.out.println("User loged in successfully !!");
		} else {
			System.out.println("Login failed !!");
		}

		driver.close();
		driver.quit();

	}
	
	public static void js_Scroll() throws InterruptedException {
		WebDriverManager.chromedriver().version("2.41").setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		js = (JavascriptExecutor) driver;
		
		driver.get("https://demo.nopcommerce.com/register");
		js.executeScript("window.location = 'https://demo.nopcommerce.com/register';");
		
		// Scroll down
		js.executeScript("window.scrollBy(0, 1600);");
		Thread.sleep(2000);
		
		// Scroll up
		js.executeScript("window.scrollBy(0, -1600);");
		
		Thread.sleep(2000);
		
		WebElement txtCompany = driver.findElement(By.xpath("//input[@id='Company']"));
		// Scroll into view
		js.executeScript("arguments[0].scrollIntoView();", txtCompany);
		Thread.sleep(2000);
		
		// Scroll up
		js.executeScript("window.scrollBy(0, -150);");
		Thread.sleep(2000);
		
		// type value into a text box
		js.executeScript("arguments[0].value='AutomateAnything'", txtCompany);
		Thread.sleep(2000);
		
		WebElement ddDay = driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
		js.executeScript("arguments[0].scrollIntoView();", ddDay);
		js.executeScript("window.scrollBy(0, -50);");
		Thread.sleep(2000);
		js.executeScript("arguments[0].selectedIndex = '3';", ddDay);
		Thread.sleep(2000);
		
		WebElement btnRegister = driver.findElement(By.xpath("//input[@name='register-button']"));
		js.executeScript("arguments[0].click();", btnRegister);
		
		
		
	}
}
