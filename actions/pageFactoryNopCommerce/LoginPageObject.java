package pageFactoryNopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageUIsNopCommerceUser.UserLoginPageUI;

public class LoginPageObject extends BasePageFactory{

	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//pageUI
	@FindBy (how = How.ID, using = "Email")
	private WebElement emailTextbox;
	
	@FindBy (how = How.ID, using = "Password")
	private WebElement passwordTextbox;
	
	@FindBy (how = How.XPATH, using = "//button[contains(@class,'login-button')]")
	private WebElement loginButton;
	
	@FindBy (how = How.ID, using = "Email-error")
	private WebElement emailErrorMessage;
	
	@FindBy (how = How.XPATH, using = "//div[contains(@class,'message-error')]")
	private WebElement unsuccessMessage;
	
	//pageObject
	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, emailTextbox);
		sendKeyToElement(driver, emailTextbox, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendKeyToElement(driver, passwordTextbox, password);
	}

	public String getUnSuccessMessage() {
		waitForElementVisible(driver, unsuccessMessage);
		return getElementText(driver, unsuccessMessage);
	}
}
