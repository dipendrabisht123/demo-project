package SeleniumBasics;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultiWinndow {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		handleMultiWindows();

	}
	
	@Test
	public static void handleMultiWindows() throws InterruptedException {
		WebDriverManager.chromedriver().version("2.41").setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		driver.get("https://demo.nopcommerce.com/register");
		
		String sParentHandle = driver.getWindowHandle();
		
		System.out.println("ParentHandle: " + sParentHandle);
		
		WebElement linkContact = driver.findElement(By.xpath("//a[@href='https://twitter.com/nopCommerce']"));
		
		linkContact.click();
		
		Set<String> setHandles = driver.getWindowHandles();
		
		
		/*for (String name : setHandles){
			if(!name.equalsIgnoreCase(sParentHandle)){
				driver.switchTo().window(name);
				System.out.println("Moved to child window: " + name);
				break;
			}
		}*/
		
		WebElement txtSearch = driver.findElement(By.xpath("//input[@aria-label='Search query']"));
				
		txtSearch.sendKeys("dipendraB");
		
		Thread.sleep(2000);
		
		driver.close();
		
		driver.switchTo().window(sParentHandle);
		
		driver.findElement(By.xpath("//a[@href='http://www.facebook.com/nopCommerce']")).click();
		
		
	}

}
