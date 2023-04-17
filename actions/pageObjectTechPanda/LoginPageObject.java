package pageObjectTechPanda;

import org.openqa.selenium.WebDriver;

import PageUIsTechPanda.LoginPageUI;
import commons.BasePage;

public class LoginPageObject extends BasePage{
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailAddressTextbox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendKeyToElement(driver,LoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
	}

	public void inputToPasswordTextbox(String passWord) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, passWord);
	}

	public MyDashBoardPageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getMyDashBoardPageObject(driver);
	}

	public String getErrorMessageInvalidEmail() {
		waitForElementVisible(driver, LoginPageUI.ERROR_LOGIN_MESSAGE);
		return getElementText(driver, LoginPageUI.ERROR_LOGIN_MESSAGE);
	}

}
