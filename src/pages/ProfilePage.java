package pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.glass.ui.Robot;

public class ProfilePage extends BasicPage {
	public ProfilePage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);

	}
	
	 Actions action = new Actions(driver);
	
	// Elements

	public WebElement getFirstName() {
		return driver.findElement(By.name("user_first_name"));
	}

	public WebElement getLastName() {
		return driver.findElement(By.name("user_last_name"));
	}

	//public WebElement getEmail() {
		//return driver.findElement(By.name("user_email"));
	//}

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
//nađi bolji xpath
	public WebElement getSaveBtn() {
		return driver.findElement(By.xpath("//*[@id='profileInfoFrm']/div[5]/div/fieldset/input"));
	}
	

	public WebElement getImg() {
		return driver.findElement(By.xpath((("//*[@class='avatar']"))));
	}

	public WebElement getUpload() {
		return driver.findElement(By.xpath("//*[@title='Uplaod']"));
	}

	public WebElement getRemove() {
		return driver.findElement(By.xpath("//*[@title='Remove']"));
	}

	public WebElement getUploadElement() {
		return driver.findElement(By.xpath("//input[@type='file']"));
	}

	
	//public WebElement getUploadugme () {
		//return this.driver.findElement(By.xpath("//*[@class='hover-elemnts']/a[1]/i"));
	//}
	// Methods

	public void uploadPhoto(String img) {
		action.moveToElement(this.getImg());
		js.executeScript("arguments[0].click();", this.getUpload());
		this.getUploadElement().sendKeys(img);

	}

	public void removePhoto() {
		js.executeScript("arguments[0].click();", this.getRemove());
	}

	
	
	public void setInfoChange(String firstName, String lastName, String address, String phoneNumber,
			String zipCode, String country, String state, String city) throws InterruptedException {
		this.getFirstName().clear();
		this.getFirstName().sendKeys(firstName);
		this.getLastName().clear();
		this.getLastName().sendKeys(lastName);
		this.getAddress().clear();
		this.getAddress().sendKeys(address);
		this.getPhoneNumber().clear();
		this.getPhoneNumber().sendKeys(phoneNumber);
		this.getZipCode().clear();
		this.getZipCode().sendKeys(zipCode);
		this.selectCountry().selectByVisibleText(country);
		this.selectState().selectByVisibleText(state);
		this.selectCity().selectByVisibleText(city);
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.name("user_zip"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
		
		this.getSaveBtn().click();
	}
	public static void scrollToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
}
