package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LocationPopupPage;
import pages.LoginPage;
import pages.NotificationSystemPage;
import pages.ProfilePage;

public class ProfileTest extends BasicTest{
	private WebDriver driver;
	private ProfilePage profilePage;
	private LoginPage loginPage;
	private NotificationSystemPage notificationSystemPage;
	private LocationPopupPage locationPopupPage;
	
	
	
	
	@BeforeMethod
	public void beforeMethod () {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		profilePage = new ProfilePage (driver, js);
		loginPage = new LoginPage (driver);
		notificationSystemPage = new NotificationSystemPage (driver, js, waiter);
		locationPopupPage = new LocationPopupPage (driver, js);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.yo-meals.com/guest-user/login-form");
		//String email = "customer@dummyid.com";
		//String password = "12345678a";
	}
	
	@Test
	
	public void Login () {
		
		this.locationPopupPage.getCloseBtn().click();
	}
	
	
	
}
