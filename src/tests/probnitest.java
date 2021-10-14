package tests;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class probnitest extends BasicTest{

	@Test
	
	public void dodajSliku () throws InterruptedException, IOException {
		driver.get(this.url + "/guest-user/login-form");
		Thread.sleep(2000);
		this.locationPopupPage.closeDialog();
		Thread.sleep(2000);
		this.loginPage.Login(email, password);
		this.notificationSystemPage.getMessageText();
		String messageSecond = "Login Successfull";
		
		Assert.assertEquals(this.notificationSystemPage.getMessageText(), messageSecond);
		
		driver.get(this.url + "/member/profile");
		String imgPath = new File("Img.jpg").getCanonicalPath();
		
		this.profilePage.uploadPhoto(imgPath);
	}
}
