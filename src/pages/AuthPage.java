package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthPage extends BasicPage {

	public AuthPage (WebDriver driver) {
		this.driver = driver;
		}
	
	
	//Elements
	
	public WebElement getUser () {
		return driver.findElement(By.xpath("//*[contains (@class, 'accounts-popup')]/ul/li/a")); 
	}
	
	public WebElement getMyAccount () {
	return driver.findElement(By.xpath(("//*[@class='my-account-dropdown']/ul/li[1]")));
	}
	
	public WebElement getLogoutBtn () {
		return driver.findElement(By.xpath(("//*[@class='my-account-dropdown']/ul/li[2]")));
	}
	
	//Methods
	
	public void logout () {
		this.getLogoutBtn().click();
	}
	
}
