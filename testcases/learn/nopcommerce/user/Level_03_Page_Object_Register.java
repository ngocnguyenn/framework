package learn.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;
import pageObjectsNopCommerceUser.UserHomePageObject;
import pageObjectsNopCommerceUser.UserRegisterPageObject;

public class Level_03_Page_Object_Register extends BasePage {
	private WebDriver driver;
    private String projectPath = System.getProperty("user.dir");
    private String osName = System.getProperty("os.name");

    private String firstName, lastName, passWord, emailAddress;
    
    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;

    @BeforeClass
    public void beforeClass() {
    	firstName = "Automation";
    	lastName = "FC";
    	passWord = "12345678";
    	emailAddress = "automation" + getRandomNumber() + "@gmail.com";
    	
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new ChromeDriver();
        
        homePage = new UserHomePageObject(driver);
        registerPage = new UserRegisterPageObject(driver);
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	driver.get("https://demo.nopcommerce.com/");

    }

    @Test
    public void Register_01_With_Empty_Data()
    {
    	//waitForElementClickable(driver, "//a[@class='ico-register']");
    	//clickToElement(driver, "//a[@class='ico-register']");
    	homePage.clickToRegisterLink();
    	
    	//waitForElementClickable(driver, "//button[@id='register-button']");
    	//clickToElement(driver, "//button[@id='register-button']");
    	registerPage.clickToRegisterButton();
    	
    	//Assert.assertEquals(getElementText(driver, "//span[@id='FirstName-error']"),"First name is required.");
    	//Assert.assertEquals(getElementText(driver, "//span[@id='LastName-error']"),"Last name is required.");
    	//Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"),"Email is required.");
    	//Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"),"Password is required.");
    	//Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"),"Password is required.");
    	
    	Assert.assertEquals(registerPage.getErrorMessageAtFirstNameTextbox(),"First name is required.");
    	Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextbox(),"Last name is required.");
    	Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(),"Email is required.");
    	Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),"Password is required.");
    	Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(),"Password is required.");
	
    }
    
    @Test
    public void Register_02_With_Invalid_Email()
    {
    	//waitForElementClickable(driver, "//a[@class='ico-register']");
    	//clickToElement(driver, "//a[@class='ico-register']");
    	homePage.clickToRegisterLink();

    	
    	//sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
    	registerPage.inputToFirstNameTextbox(firstName);
    	
    	//sendKeyToElement(driver, "//input[@id='LastName']","FC");
    	registerPage.inputToLastNameTextbox(lastName);
    	
    	//sendKeyToElement(driver, "//input[@id='Email']","Email");
    	registerPage.inputToEmailTextbox("Email");
    	
    	//sendKeyToElement(driver, "//input[@id='Password']", "12345678");
    	registerPage.inputToPasswordTextbox(passWord);
    	
    	//sendKeyToElement(driver, "//input[@id='ConfirmPassword']","12345678");
    	registerPage.inputToConfirmPasswordTextbox(passWord);
    	
    	
    	//clickToElement(driver, "//button[@id='register-button']");
    	registerPage.clickToRegisterButton();
    	
    	Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(),"Wrong email");
    	
    }
    
    @Test
    public void Register_03_With_Valid_Email()
    {
    	//waitForElementClickable(driver, "//a[@class='ico-register']");
    	//clickToElement(driver, "//a[@class='ico-register']");
    	homePage.clickToRegisterLink();
    	
    	//sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
    	registerPage.inputToFirstNameTextbox(firstName);
    	
    	//sendKeyToElement(driver, "//input[@id='LastName']", "FC");
    	registerPage.inputToLastNameTextbox(lastName);
    	
    	//sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
    	registerPage.inputToEmailTextbox(emailAddress);
    	
    	//sendKeyToElement(driver, "//input[@id='Password']", "12345678");
    	registerPage.inputToPasswordTextbox(passWord);
    	
    	//sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "12345678");
    	registerPage.inputToConfirmPasswordTextbox(passWord);
    	
    	//clickToElement(driver, "//button[@id='register-button']");
    	registerPage.clickToRegisterButton();
    	
    	
    	Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
    	
    	//registerPage.clickToLogoutLink();
    	
    }
    
    @Test
    public void Register_04_With_Existing_Email()
    {
    	//waitForElementClickable(driver, "//a[@class='ico-register']");
    	//clickToElement(driver, "//a[@class='ico-register']");
    	homePage.clickToRegisterLink();
    	
    	//sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
    	registerPage.inputToFirstNameTextbox(firstName);
    	
    	//sendKeyToElement(driver, "//input[@id='LastName']", "FC");
    	registerPage.inputToLastNameTextbox(lastName);
    	
    	//sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
    	registerPage.inputToEmailTextbox(emailAddress);
    	
    	//sendKeyToElement(driver, "//input[@id='Password']", "12345678");
    	registerPage.inputToPasswordTextbox(passWord);
    	
    	//sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "12345678");
    	registerPage.inputToConfirmPasswordTextbox(passWord);
    	
    	//clickToElement(driver, "//button[@id='register-button']");
    	registerPage.clickToRegisterButton();
    	
    	Assert.assertEquals(registerPage.getErrorExistingEmailMessage(),"The specified email already exists");
    	
    }
    
    @Test
    public void Register_05_With_Password_Less_Than_6_Characters()
    {
    	//waitForElementClickable(driver, "//a[@class='ico-register']");
    	//clickToElement(driver, "//a[@class='ico-register']");
    	homePage.clickToRegisterLink();
    	
    	//sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
    	registerPage.inputToFirstNameTextbox(firstName);
    	
    	//sendKeyToElement(driver, "//input[@id='LastName']", "FC");
    	registerPage.inputToLastNameTextbox(lastName);
    	
    	//sendKeyToElement(driver, "//input[@id='Email']", "automation@gmail.com");
    	registerPage.inputToEmailTextbox("automation@gmail.com");
    	
    	//sendKeyToElement(driver, "//input[@id='Password']", "12345");
    	registerPage.inputToPasswordTextbox("12345");
    	
    	//sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "12345");
    	registerPage.inputToConfirmPasswordTextbox("12345");
    	
    	//clickToElement(driver, "//button[@id='register-button']");
    	registerPage.clickToRegisterButton();
    	
    	Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),"Password must meet the following rules:\nmust have at least 6 characters");
    	
    }
    @Test
    public void Register_06_With_ConfirmPassword_Not_Match()
    {
    	//waitForElementClickable(driver, "//a[@class='ico-register']");
    	//clickToElement(driver, "//a[@class='ico-register']");
    	homePage.clickToRegisterLink();
    	
    	//sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
    	registerPage.inputToFirstNameTextbox(firstName);
    	
    	//sendKeyToElement(driver, "//input[@id='LastName']", "FC");
    	registerPage.inputToLastNameTextbox(lastName);
    	
    	//sendKeyToElement(driver, "//input[@id='Email']", "automation@gmail.com");
    	registerPage.inputToEmailTextbox("automation@gmail.com");
    	
    	//sendKeyToElement(driver, "//input[@id='Password']", "12345678");
    	registerPage.inputToPasswordTextbox(passWord);
    	
    	//sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "87654321");
    	registerPage.inputToConfirmPasswordTextbox("87654321");
    	
    	//clickToElement(driver, "//button[@id='register-button']");
    	registerPage.clickToRegisterButton();
    	
    	Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(),"The password and confirmation password do not match.");    	
    }
    
    
    public int getRandomNumber()
    {
        Random rand = new Random();
        return rand.nextInt(999);
    }
    
    @AfterClass
    public void afterClass()
    {
    	driver.close();
    }
}
