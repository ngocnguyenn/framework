package learn.nopcommerce.user;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.NopCommerce.Admin.AdminHomePageObject;
import pageObjects.NopCommerce.Admin.AdminLoginPageObject;
import pageObjects.NopCommerce.User.UserHomePageObject;
import pageObjects.NopCommerce.User.UserLoginPageObject;
import pageObjects.NopCommerce.User.UserRegisterPageObject;
import utilities.PropertiesConfig;

public class Level_08_Switch_User_Role extends BaseTest {
	private WebDriver driver;
    private String firstName, lastName, password, validUserEmail, adminEmail, adminPassword;
    
    private UserHomePageObject userHomePage;
    private UserRegisterPageObject userRegisterPage;
    private UserLoginPageObject userLoginPage;
    
    private AdminLoginPageObject adminLoginPage;
    private AdminHomePageObject adminHomePage;
    @Parameters({"envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion"})
    @BeforeClass
    public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName, @Optional("chrome") String browserName, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber, @Optional("Windows") String osName, @Optional("10") String osVersion) {
        driver = getBrowserDriver(envName,serverName, browserName, ipAddress, portNumber, osName, osVersion);
    	firstName = "Automation";
    	lastName = "FC";
    	password = "12345678";
    	adminEmail = "admin@yourstore.com";
    	adminPassword = "admin";
    	validUserEmail = "automation" + getRandomNumber() + "@gmail.com";
        userHomePage = new UserHomePageObject(driver);
        userRegisterPage = new UserRegisterPageObject(driver);
        userLoginPage = new UserLoginPageObject(driver);
        adminLoginPage = new AdminLoginPageObject(driver);
    }

    @Test
    public void TC_01_Register_With_Valid_Infor()
    {
    	userRegisterPage = userHomePage.clickToRegisterLink();
    	userRegisterPage.inputToFirstNameTextbox(firstName);
    	userRegisterPage.inputToLastNameTextbox(lastName);
    	userRegisterPage.inputToEmailTextbox(validUserEmail);
    	userRegisterPage.inputToPasswordTextbox(password);
    	userRegisterPage.inputToConfirmPasswordTextbox(password);
    	userRegisterPage.clickToRegisterButton();
    	Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
    }
    
    @Test
    public void TC_02_Login_With_Valid_Infor()
    {
    	userLoginPage = userHomePage.clickToLoginLink();
    	userHomePage = userLoginPage.loginAsUser(validUserEmail, password);
    	Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
    }
    
    @Test
    public void TC_03_Switch_Admin_Page()
    {
    	userHomePage.openPageUrl(driver, PropertiesConfig.getFileConfigReader().getAdminUrl());
    	adminLoginPage = PageGeneratorManager.getAdminLoginPageObject(driver);
    	adminHomePage = adminLoginPage.loginAsAdmin(adminEmail, adminPassword);
    	Assert.assertEquals(adminHomePage.getDashboardHeader(),"Dashboard");
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
