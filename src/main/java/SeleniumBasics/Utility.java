package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

	
	public static WebElement waitForElementTobeVisible(WebDriver driver, By by){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
}
