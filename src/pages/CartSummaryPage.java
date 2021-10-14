package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartSummaryPage extends BasicPage{
	public CartSummaryPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);

	}
	
	//Elements
	
	public WebElement getClearBtn () {
		return driver.findElement(By.xpath("//*[contains(@class, 'btn--third')]"));
	}
	
	//Method
	
	public void clearAll() {
		this.getClearBtn().click();
	}
}
