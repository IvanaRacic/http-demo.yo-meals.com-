package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasicPage {
	protected WebDriver driver;
	protected WebDriverWait waiter;
	protected JavascriptExecutor js;

	public BasicPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {

		this.driver = driver;
		this.waiter = waiter;
		this.js = js;
	}

	// Actions action = new Actions(driver);
}
