package SeleniumBasics;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAlerts {

	public static void main(String[] args) throws InterruptedException {
		handleJSAlerts();
		

	}
	
	public static void handleJSAlerts() throws InterruptedException{
		
		WebDriverManager.chromedriver().version("2.41").setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		
		alert.accept();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		Thread.sleep(1000);
		System.out.println(alert.getText());
		
		alert.dismiss();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Thread.sleep(1000);
		alert.sendKeys("Hello world");
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(1000);
		
		System.out.println(driver.findElement(By.cssSelector("p#result")).getText());
		
	}

}
