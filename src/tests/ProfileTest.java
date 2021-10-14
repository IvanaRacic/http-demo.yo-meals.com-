package tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.BasicPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.NotificationSystemPage;
import pages.ProfilePage;

public class ProfileTest extends BasicTest{

	
	
	
	@Test
	
	public void Login () throws InterruptedException, IOException {
		driver.get(this.url + "/guest-user/login-form");
		Thread.sleep(2000);
		this.locationPopupPage.closeDialog();
		Thread.sleep(2000);
		this.loginPage.Login(email, password);
		this.notificationSystemPage.getMessageText();
		String message = "Login Successfull";
		
		Assert.assertEquals(this.notificationSystemPage.getMessageText(), message);
		
		driver.get(this.url + "/member/profile");
		String firstName = "Johnny";
		String lastName = "Depp";
		
		String address = "ulica Desanke Maksimovic";
		String phoneNumber = "087456123";
		String zipCode = "52000";
		String country = "United States";
		String state = "Alaska";
		String city = "Nome";
		
		String messageSetUp = "Setup Successful";
		this.profilePage.setInfoChange(firstName, lastName, address, phoneNumber, zipCode, country, state, city);
		
		Assert.assertEquals(this.notificationSystemPage.getMessageText(), messageSetUp);
		
		this.authPage.logout();
		String messageLogout = "Logout Successfull!";
		
		Assert.assertEquals(this.notificationSystemPage.getMessageText(), messageLogout);
		
		//driver.get(this.url + "/guest-user/login-form");
		//Thread.sleep(2000);
		//this.locationPopupPage.closeDialog();
		//Thread.sleep(2000);
		//this.loginPage.Login(email, password);
		//this.notificationSystemPage.getMessageText();
		String messageSecond = "Login Successfull";
		
		Assert.assertEquals(this.notificationSystemPage.getMessageText(), messageSecond);
		driver.get(this.url + "/member/profile");
		String imgPath = new File("Img.jpg").getCanonicalPath();
		
		this.profilePage.uploadPhoto(imgPath);
		
	}
	
	
	
}
