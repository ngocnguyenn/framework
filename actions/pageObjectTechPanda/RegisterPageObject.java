package pageObjectTechPanda;

import org.openqa.selenium.WebDriver;

import PageUIsTechPanda.RegisterPageUI;
import commons.BasePage;

public class RegisterPageObject extends BasePage {

	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public MyDashBoardPageObject clickToRegisterButton() {
		waitForElementClickable(driver,RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		return PageGeneratorManager.getMyDashBoardPageObject(driver);
	}

	public String getErrorMessageAtFirstName() {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtLastName() {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtEmailAddress() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ADDRESS_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EMAIL_ADDRESS_ERROR_MESSAGE);
	}

	public String getErrorMessageAtPassword() {
		waitForElementVisible(driver, RegisterPageUI.PASS_WORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.PASS_WORD_ERROR_MESSAGE);
	}

	public String getErrorMessageAtConfirmPassword() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
		
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
		
	}

	public void inputToEmailAddressTextbox(String emailAddress) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
		
	}

	public void inputToPasswordTextbox(String passWord) {
		waitForElementVisible(driver, RegisterPageUI.PASS_WORD_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.PASS_WORD_TEXTBOX, passWord);
	}

	public void inputToConfirmPassword(String confirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}

}
