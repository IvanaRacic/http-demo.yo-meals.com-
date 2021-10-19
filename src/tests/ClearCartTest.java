package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ClearCartTest extends BasicTest{

	
	@Test
	
	public void clearCart() throws InterruptedException, IOException {
		driver.get(this.url + "/meals");
		String locationName = "City Center - Albany";
		this.locationPopupPage.setLocation(locationName);
		
		SoftAssert sa = new SoftAssert();
		File file = new File("data/Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheetMeals = wb.getSheet("meals");
		
		String message = "Meal Added To Cart";
		
		for (int i = 1; i <= sheetMeals.getLastRowNum(); i++) {
			
			String url = sheetMeals.getRow(i).getCell(0).getStringCellValue();
			driver.get(url);
			String quantity = "2";
			this.mealPage.addToCart(quantity);
			
			sa.assertEquals(this.notificationSystemPage.getMessageText(), message, "Error: Unexpected Add To Cart Message");
			
			
			}
		String messageClearCart ="All meals removed from Cart successfully";
		this.cartSummaryPage.clearAll();
		
		Assert.assertEquals(this.notificationSystemPage.getMessageText(), messageClearCart, "Error: Unexpected Remove From Cart Message");
		
	
	}
}
