package learn.nopcommerce.user;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.NopCommerce.User.UserHomePageObject;
import pageObjects.NopCommerce.User.UserLoginPageObject;
import pageObjects.NopCommerce.User.UserRegisterPageObject;

public class Level_14_Log_ReportNG extends BaseTest {
	private WebDriver driver;
    private String firstName, lastName, password, validEmail;
    
    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;
    private UserLoginPageObject loginPage;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName, GlobalConstants.USER_PAGE_URL);
        firstName = "Automation";
    	lastName = "FC";
    	password = "12345678";
    	validEmail = "automation" + getRandomNumber() + "@gmail.com";
        homePage = new UserHomePageObject(driver);
        registerPage = new UserRegisterPageObject(driver);
        loginPage = new UserLoginPageObject(driver);
    }

    @Test
    public void TC_01_Register_With_Valid_Infor()
    {
    	log.info("Register - Step 01: Navigate to Register page");
    	registerPage = homePage.clickToRegisterLink();
    	
    	log.info("Register - Step 02: Input to First name textbox");
    	registerPage.inputToFirstNameTextbox(firstName);

    	log.info("Register - Step 03: Input to Last name textbox");
    	registerPage.inputToLastNameTextbox(lastName);

    	log.info("Register - Step 04: Input to Email textbox");
    	registerPage.inputToEmailTextbox(validEmail);

    	log.info("Register - Step 05: Input to Password textbox");
    	registerPage.inputToPasswordTextbox(password);

    	log.info("Register - Step 06: Input to Confirm Password textbox");
    	registerPage.inputToConfirmPasswordTextbox(password);

    	log.info("Register - Step 07: Click to Register button");
    	registerPage.clickToRegisterButton();

    	log.info("Register - Step 08: Verify register success is display");
    	verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
    }
    
    @Test
    public void TC_02_Login_With_Valid_Infor()
    {
    	log.info("Login - Step 01: Navigate to Login page");
    	loginPage = homePage.clickToLoginLink();
    	
    	log.info("Login - Step 02: Input to Email textbox");
    	loginPage.inputToEmailTextbox(validEmail);

    	log.info("Login - Step 03: Input to Password textbox");
    	loginPage.inputToPasswordTextbox(password);

    	log.info("Login - Step 04: Click to Login button");
    	homePage = loginPage.clickToLoginButton();

    	log.info("Login - Step 05: Verify My Account link is display");
    	verifyTrue(homePage.isMyAccountLinkDisplayed());
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
