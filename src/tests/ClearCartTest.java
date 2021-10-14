package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ClearCartTest extends BasicTest{

	
	@Test
	
	public void clearAll() throws InterruptedException {
		driver.get(this.url + "/meals");
		String locationName = "City Center - Albany";
		this.locationPopupPage.setLocation(locationName);
		//driver.findElement(By.xpath("//*[@id='frm_fat_id_frmSetLocation']/span/input)")).click();
	}
}
