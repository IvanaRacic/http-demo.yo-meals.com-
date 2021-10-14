package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

public abstract class BasicTest {
	public WebDriver driver;
	public WebDriverWait waiter;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Actions action = new Actions(driver);
	
	@BeforeMethod
	
	public void beforeMethod () {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("demo.yo-meals.com");
		String email = "customer@dummyid.com";
		String password = "12345678a";
	}
}
