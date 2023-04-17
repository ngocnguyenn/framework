package pageObjectsNopCommerce;

import org.openqa.selenium.WebDriver;

import PageUIsNopCommerce.HomePageUI;
import commons.BasePage;

public class HomePageObject extends BasePage{

	//global
	private WebDriver driver;

	public HomePageObject(WebDriver driver)
	{
		//local
		this.driver = driver;
	}
	
	public void clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPageObject(driver);
		
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

}
