package pageFactoryNopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory {

	private WebDriver driver;
	
	public RegisterPageObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//pageUI
	@FindBy (id = "FirstName")
	private WebElement firstNameTextbox;
	
	@FindBy (id = "LastName")
	private WebElement lastNameTextbox;
	
	@FindBy (id = "Email")
	private WebElement emailTextbox;
	
	@FindBy (id = "Password")
	private WebElement passWordTextbox;
	
	@FindBy (id = "ConfirmPassword")
	private WebElement confirmPasswordTextbox;
	
	@FindBy (how = How.XPATH, using = "//button[@id='register-button']")
	private WebElement registerButton;
	
	@FindBy (how = How.XPATH, using = "//span[@id='FirstName-error']")
	private WebElement firstNameErrorMessage;
	
	@FindBy (how = How.XPATH, using = "//span[@id='LastName-error']")
	private WebElement lastNameErrorMessage;
	
	@FindBy (how = How.XPATH, using = "//span[@id='Email-error']")
	private WebElement emailErrorMessage;
	
	@FindBy (how = How.XPATH, using = "//span[@id='Password-error']")
	private WebElement passwordErrorMessage;
	
	@FindBy (how = How.XPATH, using = "//span[@id='ConfirmPassword-error']")
	private WebElement confirmPasswordErrorMessage;
	
	@FindBy (how = How.XPATH, using = "//div[@class='result']")
	private WebElement registerSuccessMessage;
	
	@FindBy (how = How.XPATH, using = "//a[@class = 'ico-logout']")
	private WebElement logoutLink;
	
	@FindBy (how = How.XPATH, using = "//div[@class='message-error validation-summary-errors']")
	private WebElement existingEmailErrorMessage;
	
	
	//pageObject
	
	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
		
	}

	public String getErrorMessageAtFirstNameTextbox() {
		waitForElementVisible(driver, firstNameErrorMessage);
		return getElementText(driver, firstNameErrorMessage);
	}

	public String getErrorMessageAtLastNameTextbox() {
		waitForElementVisible(driver, lastNameErrorMessage);
		return getElementText(driver, lastNameErrorMessage);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, passwordErrorMessage);
		return getElementText(driver, passwordErrorMessage);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, confirmPasswordErrorMessage);
		return getElementText(driver, confirmPasswordErrorMessage);
	}

	public void inputToFirstNameTextbox(String firstname) {
		waitForElementVisible(driver, firstNameTextbox);
		sendKeyToElement(driver, firstNameTextbox,firstname);
	}

	public void inputToLastNameTextbox(String lastname) {
		waitForElementVisible(driver, lastNameTextbox);
		sendKeyToElement(driver, lastNameTextbox,lastname);
		
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, emailTextbox);
		sendKeyToElement(driver, emailTextbox,email);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passWordTextbox);
		sendKeyToElement(driver, passWordTextbox,password);
		
	}

	public void inputToConfirmPasswordTextbox(String confirmpassword) {
		waitForElementVisible(driver, confirmPasswordTextbox);
		sendKeyToElement(driver, confirmPasswordTextbox,confirmpassword);
		
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, registerSuccessMessage);
		return getElementText(driver, registerSuccessMessage);
	}
	
	public void clickToLogoutLink()
	{
		waitForElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);
	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, existingEmailErrorMessage);
		return getElementText(driver, existingEmailErrorMessage);
	}

	
}
