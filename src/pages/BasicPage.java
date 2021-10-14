package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasicPage {
	public WebDriver driver;
	public WebDriverWait waiter;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Actions action = new Actions(driver);
}
