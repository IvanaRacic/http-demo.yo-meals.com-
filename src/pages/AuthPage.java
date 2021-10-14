package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage extends BasicPage {

	public AuthPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);

	}

	// Elements

	public WebElement getUser() {
		return driver.findElement(By.xpath("//*[contains (@class, 'accounts-popup')]/ul/li/a"));
	}

	public WebElement getMyAccount() {
		return driver.findElement(By.xpath(("//*[@class='my-account-dropdown']/ul/li[1]")));
	}

	public WebElement getLogoutBtn() {
		return driver.findElement(By.xpath(("//*[@class='my-account-dropdown']/ul/li[2]")));
	}

	// Methods
	// možda će morati select zbog dropdown-a
	public void logout() {
		this.getUser().click();
		this.getLogoutBtn().click();
	}

}
