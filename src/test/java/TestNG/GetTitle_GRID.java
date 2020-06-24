package TestNG;

import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;

public class GetTitle_GRID {
	
static WebDriver driver;
	
	/*@BeforeTest
	public void beforeTest() {
		try {
			

			DesiredCapabilities capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.WIN10);
			cap

			String nodeURL = "http://192.168.1.5:5555/wd/hub";
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
  public void getTitle() {
	  DesiredCapabilities capability = DesiredCapabilities.firefox();
		capability.setBrowserName("firefox");
		capability.setPlatform(Platform.WINDOWS);
		

		//String nodeURL = "http://192.168.1.5:5555/wd/hub";
		String nodeURL = "http://192.168.1.2:10291/wd/hub";
		try {
			driver = new RemoteWebDriver(new URL(nodeURL), capability);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
	  driver.get("http://testingmasters.com/hrm");
	  
	  System.out.println(driver.getTitle());
	  
	  driver.quit();
	  
  }
  
  
  
 

}
