package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasicPage {
	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}
	// Elements

	public WebElement getEmail() {
		return driver.findElement(By.name("username"));
	}

	public WebElement getPassword() {
		return driver.findElement(By.name("password"));
	}

	// public WebElement getRememberMe () {
	// return driver.findElement(By.name("remember_me"));
	// }

	public WebElement getLoginBtn() {
		return driver.findElement(By.name("btn_submit"));
	}

	// Methods

	public void Login(String email, String password) {
		this.getEmail().clear();
		this.getEmail().sendKeys(email);
		this.getPassword().clear();
		this.getPassword().sendKeys(password);
		this.getLoginBtn().click();
	}
}
