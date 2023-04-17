package pageObjectTechPanda;

import org.openqa.selenium.WebDriver;

import PageUIsTechPanda.HomePageUI;
import commons.BasePage;

public class HomePageObject extends BasePage{
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAccountMenu() {
		waitForElementClickable(driver, HomePageUI.ACCOUNT_MENU);
		clickToElement(driver, HomePageUI.ACCOUNT_MENU);
	}

	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPageObject(driver);
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPageObject(driver);
	}

}
