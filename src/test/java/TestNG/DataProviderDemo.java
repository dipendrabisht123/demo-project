package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderDemo extends TestBase{
	
	
  @Test(dataProvider = "getCredentialsAsDP")
  public void f(String sName, String sPWD) {
	  WebDriverManager.chromedriver().version("2.41").setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://testingmasters.com/hrm");

		WebElement txtUserName = driver.findElement(By.id("txtUsername"));

		WebElement txtPWD = driver.findElement(By.name("txtPassword"));

		WebElement btnLogin = driver.findElement(By.id("btnLogin"));

		txtUserName.sendKeys(sName);
		
		txtPWD.sendKeys(sPWD);

		btnLogin.click();
		
		
		
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "Admin", "admin123" },
      new Object[] { "user02", "TM1234" },
    };
  }
  
  
}
