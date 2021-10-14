package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage {
	public ProfilePage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);

	}

	// Elements

	public WebElement getFirstName() {
		return driver.findElement(By.name("user_first_name"));
	}

	public WebElement getLastName() {
		return driver.findElement(By.name("user_last_name"));
	}

	public WebElement getEmail() {
		return driver.findElement(By.name("user_email"));
	}

	public WebElement getAddress() {
		return driver.findElement(By.name("user_address"));
	}

	public WebElement getPhoneNumber() {
		return driver.findElement(By.name("user_phone"));
	}

	public WebElement getZipCode() {
		return driver.findElement(By.name("user_zip"));
	}

	public Select selectCountry() {
		WebElement country = this.driver.findElement(By.name("user_country_id"));

		Select select = new Select(country);
		return select;
	}

	public Select selectState() {
		WebElement state = this.driver.findElement(By.name("user_state_id"));

		Select select = new Select(state);
		return select;
	}

	public Select selectCity() {
		WebElement city = this.driver.findElement(By.name("user_city"));

		Select select = new Select(city);
		return select;
	}

	public WebElement getSaveBtn() {
		return driver.findElement(By.xpath(("//*[@type='submit'][1]")));
	}

	public WebElement getImg() {
		return driver.findElement(By.xpath((("//*[@class='avatar']"))));
	}

	public WebElement getUpload() {
		return driver.findElement(By.xpath("//*[@title='Upload']"));
	}

	public WebElement getRemove() {
		return driver.findElement(By.xpath("//*[@title='Remove']"));
	}

	public WebElement getUploadElement() {
		return driver.findElement(By.xpath("//input[@type='file']"));
	}

	// Methods

	public void uploadPhoto(String img) {
		js.executeScript("arguments[0].click();", this.getUpload());
		this.getUploadElement().sendKeys(img);

	}

	public void removePhoto() {
		js.executeScript("arguments[0].click();", this.getRemove());
	}

	public void setInfoChange(String firstName, String lastName, String email, String address, String phoneNumber,
			String zipCode, String country, String state, String city) {
		this.getFirstName().clear();
		this.getFirstName().sendKeys(firstName);
		this.getLastName().clear();
		this.getLastName().sendKeys(lastName);
		this.getEmail().clear();
		this.getEmail().sendKeys(email);
		this.getAddress().clear();
		this.getAddress().sendKeys(address);
		this.getPhoneNumber().clear();
		this.getPhoneNumber().sendKeys(phoneNumber);
		this.getZipCode().clear();
		this.getZipCode().sendKeys(zipCode);
		// ako ti ne bude radio select, vjerovatno je jer targetira id, ili index, a ne
		// text, pa promijeni visibile by
		this.selectCountry().selectByVisibleText(country);
		this.selectState().selectByVisibleText(state);
		this.selectCity().selectByVisibleText(city);
		this.getSaveBtn().click();
	}

}
