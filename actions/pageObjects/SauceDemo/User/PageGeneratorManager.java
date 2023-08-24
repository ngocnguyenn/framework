package pageObjects.SauceDemo.User;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	public static UserProductPageObject getUserProductPageObject(WebDriver driver)
	{
		return new UserProductPageObject(driver);
	
}
