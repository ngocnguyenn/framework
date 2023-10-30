package learn.nopcommerce.common;

import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.NopCommerce.User.UserHomePageObject;
import pageObjects.NopCommerce.User.UserRegisterPageObject;

public class Common_01_Register_To_System extends BaseTest{
	private WebDriver driver;
    private String firstName, lastName; 
    public static String PASSWORD, EMAIL;
    
    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;

    @Parameters({"envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion"})
    @BeforeClass
    public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName, @Optional("chrome") String browserName, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber, @Optional("Windows") String osName, @Optional("10") String osVersion) {
        driver = getBrowserDriver(envName,serverName, browserName, ipAddress, portNumber, osName, osVersion);
        firstName = "Automation";
       	lastName = "FC";
       	PASSWORD = "12345678";
       	EMAIL = "automation" + getRandomNumber() + "@gmail.com";
        homePage = new UserHomePageObject(driver);
        registerPage = new UserRegisterPageObject(driver);
    	registerPage = homePage.clickToRegisterLink();
    	
    	log.info("Register - Step 01: Navigate to Register page");
    	registerPage = homePage.clickToRegisterLink();
    	
    	log.info("Register - Step 02: Input to First name textbox");
    	registerPage.inputToFirstNameTextbox(firstName);

    	log.info("Register - Step 03: Input to Last name textbox");
    	registerPage.inputToLastNameTextbox(lastName);

    	log.info("Register - Step 04: Input to Email textbox");
    	registerPage.inputToEmailTextbox(EMAIL);

    	log.info("Register - Step 05: Input to Password textbox");
    	registerPage.inputToPasswordTextbox(PASSWORD);

    	log.info("Register - Step 06: Input to Confirm Password textbox");
    	registerPage.inputToConfirmPasswordTextbox(PASSWORD);

    	log.info("Register - Step 07: Click to Register button");
    	registerPage.clickToRegisterButton();

    	log.info("Register - Step 08: Verify register success is display");
    	Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
    	driver.close();
    }
   
}
