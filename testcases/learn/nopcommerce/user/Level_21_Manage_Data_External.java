package learn.nopcommerce.user;

import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.GlobalConstants;
import learn.nopcommerce.data.UserDataMapper;
import pageObjects.NopCommerce.User.UserHomePageObject;
import pageObjects.NopCommerce.User.UserLoginPageObject;
import pageObjects.NopCommerce.User.UserRegisterPageObject;
import reportConfigs.ExtentTestManager;

public class Level_21_Manage_Data_External extends BaseTest {
	private WebDriver driver;
    private String firstName, lastName, password, validEmail;
    UserDataMapper userData;
    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;
    private UserLoginPageObject loginPage;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName, GlobalConstants.USER_PAGE_URL);
        userData = UserDataMapper.getUserData();
        firstName = userData.getFirstName();
    	lastName = userData.getLastName();
    	password = userData.getPassWord();
    	validEmail = userData.getEmail();
        homePage = new UserHomePageObject(driver);
        registerPage = new UserRegisterPageObject(driver);
        loginPage = new UserLoginPageObject(driver);
    }

    @Test
    public void TC_01_Register_With_Valid_Infor(Method method)
    {
    	ExtentTestManager.startTest(method.getName(),"Register with valid information");
    	ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Navigate to Register page");
    	registerPage = homePage.clickToRegisterLink();
    	
    	ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Input to First name textbox");
    	registerPage.inputToFirstNameTextbox(firstName);

    	ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Input to Last name textbox");
    	registerPage.inputToLastNameTextbox(lastName);

    	ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Input to Email textbox");
    	registerPage.inputToEmailTextbox(validEmail);

    	ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Input to Password textbox");
    	registerPage.inputToPasswordTextbox(password);

    	ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Input to Confirm Password textbox");
    	registerPage.inputToConfirmPasswordTextbox(password);

    	ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Click to Register button");
    	registerPage.clickToRegisterButton();

    	ExtentTestManager.getTest().log(Status.INFO, "Register - Step 08: Verify register success is display");
    	Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
    }
    
    @Test
    public void TC_02_Login_With_Valid_Infor(Method method)
    {
    	ExtentTestManager.startTest(method.getName(),"Login with valid information");
    	ExtentTestManager.getTest().log(Status.INFO,"Login - Step 01: Navigate to Login page");
    	loginPage = homePage.clickToLoginLink();
    	
    	ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Input to Email textbox");
    	loginPage.inputToEmailTextbox(validEmail);

    	ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Input to Password textbox");
    	loginPage.inputToPasswordTextbox(password);

    	ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to Login button");
    	homePage = loginPage.clickToLoginButton();

    	ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify My Account link is display");
    	Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
    }
    
   
    @AfterClass(alwaysRun = true)
    public void afterClass()
    {
    	closeBrowserDriver();
    }
}
