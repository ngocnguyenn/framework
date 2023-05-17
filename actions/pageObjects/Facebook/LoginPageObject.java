package pageObjects.Facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIsFacebook.LoginPageUI;

public class LoginPageObject extends BasePage{
	WebDriver driver;
	public LoginPageObject (WebDriver driver){
		this.driver = driver;
	}
	public void clickToCreateNewAccountButton() {
		waitForElementClickable(driver,LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver,LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
	}
	public boolean isEmailAddressTextboxDisplayed() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		return isElementDisplayed(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
	}
	public boolean isConfirmEmailAddressTextboxDisplayed() {
		waitForElementVisible(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
		return isElementDisplayed(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
	}
	public void enterToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
	}
	public void clickCloseCreateAccountPopup() {
		waitForElementClickable(driver, LoginPageUI.CLOSE_CREATE_ACCOUNT_POPUP_BUTTON);
		clickToElement(driver, LoginPageUI.CLOSE_CREATE_ACCOUNT_POPUP_BUTTON);
	}
	public boolean isConfirmEmailAddressTextboxUnDisplayed() {
		return isElementUndisplayed(driver,LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
	}
}
