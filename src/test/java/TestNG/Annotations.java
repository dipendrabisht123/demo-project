package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Annotations {

	WebDriver driver;
	SoftAssert sa = new SoftAssert();

	
	@Test(groups={"Regression"})
	public void Test1() {

		System.out.println("Test1");
		/*WebDriverManager.chromedriver().version("2.41").setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();*/
		
		driver.get("http://testingmasters.com/hrm");
		String sTitle = driver.getTitle();
		sa.assertEquals(sTitle, "OrangeHRM", "Actual title is "+ sTitle);
		
		String sURL = driver.getCurrentUrl();
		sa.assertEquals(sURL, "http://testingmasters.com/hrm/symfony/web/index.php/auth/login", "Actual URL is "+ sURL);
		
		sa.assertAll();
		
	}

	
	
	@Test(groups={"module2", "smoke"})
	public void Test4() {
		
		System.out.println("Test4");

		driver.get("https://www.yatra.com/");
		
	}
	
	@Test(groups={"module2", "smoke"})
	public void Test6() {
		
		System.out.println("Test6");

		driver.get("https://www.yatra.com/");
	}
	
	
	@Parameters({"classLevel"})
	@Test (groups={"module1"})
	public void Test5(String param) {

		System.out.println("Test5");
		System.out.println(param);

		driver.get("http://testingmasters.com/hrm");
		String sTitle = driver.getTitle();
		sa.assertEquals(sTitle, "testingmasters", "Actual title is "+ sTitle);
		
		String sURL = driver.getCurrentUrl();
		sa.assertEquals(sURL, "http://testingmasters.com/hrm", "Actual URL is "+ sURL);
		
		sa.assertAll();
		
	}

//	
//	
	@Parameters({"name", "id"})
	@Test( alwaysRun=true) //, dependsOnMethods={"Test3"}
	public void Test2(String name, int id) {

		System.out.println("Test2");
		System.out.println("name: "+name);
		System.out.println("id: "+id);
//		throw new SkipException("Skipping Test2");
		
		driver.get("http://www.google.com/");
		
	}

	@Parameters({"Emp_Name", "Emp_ID"})
	@Test (enabled=true ) //dependsOnGroups={"module1"}
	public void Test3(String name, int id) {
		//Assert.assertTrue(false);
		System.out.println("Test3");
		System.out.println("Emp_Name: "+name);
		System.out.println("Emp_ID: "+id);

		driver.get("https://www.makemytrip.com/");
		
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest");
		
	}

	@AfterTest
	public void afterTest() {
		System.out.println("afterTest");
		
	}

	@BeforeSuite (alwaysRun=true)
	public void beforeSuite() {
		System.out.println("beforeSuite");
		WebDriverManager.chromedriver().version("2.41").setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterSuite (alwaysRun=true)
	public void afterSuite() {
		System.out.println("afterSuite");
		driver.quit();
	}
	
	@BeforeMethod
	public void beforeMethod() {

		System.out.println("beforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("afterClass");
	}

	

}
