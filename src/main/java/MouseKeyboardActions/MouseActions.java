package MouseKeyboardActions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import SeleniumBasics.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseActions {
	static WebDriver driver;
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().version("2.41").setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
//		mouseMultipleActions();
		dragDrop();
	}
	
	public static void login(){
		
		

		driver.get("http://testingmasters.com/hrm");

		WebElement txtUserName = driver.findElement(By.id("txtUsername"));

		WebElement txtPWD = driver.findElement(By.name("txtPassword"));

		WebElement btnLogin = driver.findElement(By.id("btnLogin"));

		txtUserName.sendKeys("user02");

		txtPWD.sendKeys("TM1234");

		btnLogin.click();
		
		WebElement welcome = Utility.waitForElementTobeVisible(driver, By.id("welcome"));
	}
	
	public static void mouseMove(){
		
		login();
		
		Actions action = new Actions(driver);
		
		action.moveToElement(Utility.waitForElementTobeVisible(driver, By.xpath("//a[b[text()='Leave']]"))).perform();
		
		
		action.click(Utility.waitForElementTobeVisible(driver, By.xpath("//a[text()='Apply']"))).perform();
		
		
		
	}
	
	public static void mouseMultipleActions(){
		try {
			mouseMove();
			
			WebElement comments = Utility.waitForElementTobeVisible(driver, By.cssSelector("textarea#applyleave_txtComment"));
			
//		comments.sendKeys("Test Comments");
			
			Actions action = new Actions(driver);
			
			action.sendKeys(comments, "Test Comments").perform();
			Thread.sleep(3000);
			
			action.click(comments).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).sendKeys("Hi there").keyUp(Keys.SHIFT).build().perform();
			WebElement btnApply = Utility.waitForElementTobeVisible(driver, By.xpath("//input[@value='Apply']"));
			
			action.click(btnApply).perform();
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	public static void dragDrop(){
		driver.get("https://jqueryui.com/droppable/");
		
		
		
		Actions act = new Actions(driver);
		
		driver.switchTo().frame(0);
		WebElement dragable = Utility.waitForElementTobeVisible(driver, By.id("draggable"));
		WebElement droppable = Utility.waitForElementTobeVisible(driver, By.id("droppable"));
		act.dragAndDrop(dragable, droppable).build().perform();
	}
	
	
}
