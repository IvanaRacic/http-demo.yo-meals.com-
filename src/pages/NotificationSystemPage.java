package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSystemPage extends BasicPage {
	public NotificationSystemPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		this.driver = driver;
		this.js = js;
		this.waiter = new WebDriverWait(driver, 20);
	}

	public WebElement getMessage() {
		return driver.findElement(By.xpath("//*[contains(@class, 'alert--success') or "
				+ "contains(@class, 'alert--danger')][contains(@style,'display: block')]"));
	}

	// Methods

	public String getMessageText() {
		return this.getMessage().getText();
	}

	public void waitMessageToDisappear() {
		this.waiter.until(ExpectedConditions.attributeToBe(By.xpath("//*[contains(@class, 'system_message')]"), "style",
				"display:none"));
	}

}
