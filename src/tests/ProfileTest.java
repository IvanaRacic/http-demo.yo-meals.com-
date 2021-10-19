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

public class ProfileTest extends BasicTest {

	@Test (priority = 1)

	public void editProfile() throws InterruptedException, IOException {
		driver.get(this.url + "/guest-user/login-form");
		Thread.sleep(2000);
		this.locationPopupPage.closeDialog();
		Thread.sleep(2000);
		this.loginPage.Login(email, password);
		this.notificationSystemPage.getMessageText();
		String message = "Login Successfull";

		Assert.assertEquals(this.notificationSystemPage.getMessageText(), message, "Error: Unexpected Login Message");

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

		Assert.assertEquals(this.notificationSystemPage.getMessageText(), messageSetUp,
				"Error: Unexpected SetUp Message");

		this.authPage.logout();
		String messageLogout = "Logout Successfull!";

		Assert.assertEquals(this.notificationSystemPage.getMessageText(), messageLogout,
				"Error: Unexpected Logout Message");
	}

	@Test (priority = 4)

	public void changeProfileImage() throws IOException, InterruptedException {

		driver.get(this.url + "/guest-user/login-form");
		Thread.sleep(2000);
		this.locationPopupPage.closeDialog();
		Thread.sleep(2000);
		this.loginPage.Login(email, password);
		this.notificationSystemPage.getMessageText();
		String messageSecond = "Login Successfull";

		Assert.assertEquals(this.notificationSystemPage.getMessageText(), messageSecond,
				"Error: Unexpected Login Message");
		driver.get(this.url + "/member/profile");

		String img = new File("img/Img.jpg").getCanonicalPath();
		Thread.sleep(3000);
		this.profilePage.clickUpload();
		this.profilePage.uploadPhoto(img);

		String messagePhotoUploaded = "Profile Image Uploaded Successfully";
		Assert.assertEquals(this.notificationSystemPage.getMessageText(), messagePhotoUploaded,
				"Error: Unexpected Photo Upload Message");

		Thread.sleep(3000);
		this.profilePage.removePhoto();
		String removedPhoto = "Profile Image Deleted Successfully";
		Thread.sleep(3000);
		this.authPage.logout();
		String messageLogout = "Logout Successfull!";

		Assert.assertEquals(this.notificationSystemPage.getMessageText(), messageLogout,
				"Error: Unexpected Logout Message");
	}

}
