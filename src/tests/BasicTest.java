package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import pages.AuthPage;
import pages.BasicPage;
import pages.CartSummaryPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSystemPage;
import pages.ProfilePage;

public abstract class BasicTest {
	protected WebDriver driver;
	protected WebDriverWait waiter;
	protected JavascriptExecutor js;
	protected String email = "customer@dummyid.com";
	protected String password = "12345678a";
	protected String url = "http://demo.yo-meals.com";
	protected ProfilePage profilePage;
	protected LoginPage loginPage;
	protected NotificationSystemPage notificationSystemPage;
	protected LocationPopupPage locationPopupPage;
	protected BasicPage basicPage;
	protected AuthPage authPage;
	protected CartSummaryPage cartSummaryPage;
	protected MealPage mealPage;
	
	
	
	


	//Actions action = new Actions(driver);
	
	@BeforeMethod
	
	public void beforeMethod () {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.yo-meals.com");
		profilePage = new ProfilePage (driver, waiter, js);
		loginPage = new LoginPage (driver, waiter, js);
		notificationSystemPage = new NotificationSystemPage (driver, waiter, js);
		locationPopupPage = new LocationPopupPage (driver, waiter, js);
		authPage = new AuthPage (driver, waiter, js);
		cartSummaryPage = new CartSummaryPage (driver, waiter, js);
		mealPage = new MealPage (driver, waiter, js);
		
	}
	
}
