package pageObjects.SauceDemo.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIsSauceDemo.UserLoginPageUI;

public class UserLoginPageObject extends BasePage{
private WebDriver driver;
	
	public UserLoginPageObject(WebDriver driver)
	{
		this.driver = driver;
	}

	public void inputToUserNameTextbox(String username) {
		waitForElementVisible(driver, UserLoginPageUI.USERNAME_TEXTBOX);
		sendKeyToElement(driver, UserLoginPageUI.USERNAME_TEXTBOX, username);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public UserProductPageObject clickToLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserProductPageObject(driver);
	}
}
