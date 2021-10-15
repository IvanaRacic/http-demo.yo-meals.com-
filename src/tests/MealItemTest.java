package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MealItemTest extends BasicTest{

	
	@Test
	
	public void addMeal () throws InterruptedException {
		driver.get(this.url + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		Thread.sleep(2000);
		this.locationPopupPage.closeDialog();
		Thread.sleep(2000);
		String quantity = "2";
		this.mealPage.addToCart(quantity);
		
		String message = "The Following Errors Occurred: Please Select Location";
		
		Assert.assertEquals(true, message.contains("The Following Errors Occurred"));
		Assert.assertEquals(true, message.contains("Please Select Location"));
		
		Thread.sleep(4000);
		
		String locationName = "City Center - Albany";
		String messageMealAdded = "Meal Added To Cart";
		this.locationPopupPage.openPopUpDialog();
		this.locationPopupPage.setLocation(locationName);
		Thread.sleep(4000);
		
		this.mealPage.addToCart(quantity);
		
		Assert.assertEquals(this.notificationSystemPage.getMessageText(), messageMealAdded);
	}
	
	@Test
	
	public void addMealToFavorite () throws InterruptedException {
		driver.get(this.url + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		this.locationPopupPage.closeDialog();
		Thread.sleep(2000);
		this.mealPage.addToFavorites();
		
		String messageLogin = "Please login first!";
		Assert.assertEquals(this.notificationSystemPage.getMessageText(), messageLogin);
		
		driver.get(url + "/guest-user/login-form");
		this.loginPage.Login(email, password);
		
		driver.get(url + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		Thread.sleep(2000);
		this.mealPage.addToFavorites();
		String messageaddFavorite = "Product has been added to your favorites.";
		Assert.assertEquals(this.notificationSystemPage.getMessageText(), messageaddFavorite);
		
	}
}
