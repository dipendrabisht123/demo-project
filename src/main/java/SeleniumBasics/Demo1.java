package SeleniumBasics;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Sleeper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo1 {

	public static void main(String[] args) {
		
		nestedFrames();
	}

	
	public static void multipleWindows(){
		WebDriverManager.chromedriver().version("2.41").setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("file:///A:/STUDY/Codes/WebDevelopment/FirstHTML/index.html");
		
		String sParentHandle = driver.getWindowHandle();
		
		System.out.println("ParentHandle: "+sParentHandle);
		
		driver.findElement(By.linkText("Contact Me")).click();
		
		Set<String> handles = driver.getWindowHandles();
		
		Iterator it = handles.iterator();
		
		while (it.hasNext()){
			String sHandle = (String) it.next();
			System.out.println("Current Handle: "+sHandle);
			if (!sHandle.equalsIgnoreCase(sParentHandle)){
				driver.switchTo().window(sHandle);
				
				System.out.println("Name: "+driver.findElement(By.tagName("h3")).getText());
				driver.close();
				driver.switchTo().window(sParentHandle);
				driver.close();
			}
			
		}
		
		
	}
	public static void nestedFrames(){
		WebDriverManager.chromedriver().version("2.41").setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/nested_frames");
		
		List<WebElement> listFrames = driver.findElements(By.tagName("frame"));
		
		driver.switchTo().frame(0);
		
		driver.switchTo().frame("frame-left");
		System.out.println(driver.findElement(By.tagName("body")).getText());
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(1);
		
		System.out.println(driver.findElement(By.tagName("body")).getText());
		
		driver.switchTo().defaultContent();
		
		driver.quit();
	}
	
//	
}
