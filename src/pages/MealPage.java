package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage {
	public MealPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);

	}

	// Elements
	// nađi bolji xpath
	public WebElement getMeal() {
		return driver.findElement(By.xpath(("//*[@id='listing']/div[2]/div/div[2]/div[2]/a")));
	}

	public WebElement getFavoriteBtn() {
		return driver.findElement(By.className(("svg-icn")));
	}

	public WebElement getQuantity() {
		return driver.findElement(By.name("product_qty"));
	}

	public WebElement getAddCartBtn() {
		return driver.findElement(By.xpath("//*[contains(@class, 'js-proceedtoAddInCart')]"));
	}

	// Methods

	public void addToCart(String quantity) {
		this.getQuantity().clear();
		this.getQuantity().sendKeys(quantity);
		this.getAddCartBtn().click();

	}

	public void addToFavorites() {
		this.getFavoriteBtn().click();
	}

}
