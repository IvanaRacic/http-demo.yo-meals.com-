package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocationPopupPage extends BasicPage {

	public LocationPopupPage(WebDriver driver, JavascriptExecutor js) {
		this.driver = driver;
		this.js = js;
	}

	// Elements

	public WebElement getLocation() {
		return driver.findElement(By.className("location-selector"));
	}

	public WebElement getCloseBtn() {
		return driver.findElement(By.xpath("//*[contains(@class, 'close-btn-white')]"));
	}

	public WebElement getKeyword() {
		return driver.findElement(By.xpath("//*[@id='locality_keyword']"));
	}

	public WebElement getLocationItem(String LocationName) {
		return driver.findElement(By.xpath("//li/a[contains(text(), '\" + locationName + \"')]/.."));
	}

	public WebElement getLocationInput() {
		return driver.findElement(By.xpath("//*[@id='location_id']"));
	}

	public WebElement getSubmit() {
		return driver.findElement(By.xpath("//*[@name='btn_submit']"));
	}

	// Methods

	public void openPopUpDialog() {
		this.getLocation().click();
	}

	public void setLocation(String locationName) {
		this.getKeyword().click();
		String dataValue = this.getLocationItem(locationName).getAttribute("data-value");

		js.executeScript("arguments[0].value=arguments[1]", this.getLocationInput(), dataValue);

		js.executeScript("arguments[0].click();", this.getSubmit());
		this.getCloseBtn().click();
	}
}
