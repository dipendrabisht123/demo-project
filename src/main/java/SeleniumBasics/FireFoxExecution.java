package SeleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxExecution {

	public static void main(String[] args) {
		getPageTitle();

	}
	
	
	public static void getPageTitle(){
		
		System.setProperty("webdriver.gecko.driver", "A:\\STUDY\\Softwares\\Drivers\\FireFox\\geckodriver_v0.26.0_win64\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		driver.get("http://testingmasters.com/hrm");
		  
		  System.out.println(driver.getTitle());
		  
		  driver.quit();
		
	}

}
