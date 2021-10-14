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
		
		//String message = "The Following Errors Occurred: Please Select Location";
			//	+ "Please Select Location";
		  //(this.notificationSystemPage.getMessageText(), firstMessage);
		  
		  //public boolean contains ("The Following Errors")
	}
}
