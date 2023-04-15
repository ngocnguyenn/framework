package pageObjectsNopCommerce;

import org.openqa.selenium.WebDriver;

import PageUIsNopCommerce.LoginPageUI;
import commons.BasePage;

public class LoginPageObject extends BasePage{

	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver)
	{
		this.driver = driver;
	}

	public HomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePageObject(driver);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public String getUnSuccessMessage() {
		waitForElementVisible(driver, LoginPageUI.UNSUCCESS_MESSAGE);
		return getElementText(driver, LoginPageUI.UNSUCCESS_MESSAGE);
	}
}
