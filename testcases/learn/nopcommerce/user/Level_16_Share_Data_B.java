package learn.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import commons.GlobalConstants;
import learn.nopcommerce.common.Common_01_Register_Cookie;
import pageObjects.NopCommerce.User.UserHomePageObject;
import pageObjects.NopCommerce.User.UserLoginPageObject;

public class Level_16_Share_Data_B extends BaseTest {
	private WebDriver driver;
    
    private UserHomePageObject homePage;
    private UserLoginPageObject loginPage;

    @Parameters({"envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion"})
    @BeforeClass
    public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName, @Optional("chrome") String browserName, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber, @Optional("Windows") String osName, @Optional("10") String osVersion) {
        driver = getBrowserDriver(envName,serverName, browserName, ipAddress, portNumber, osName, osVersion);
        homePage = new UserHomePageObject(driver);
        loginPage = new UserLoginPageObject(driver);

    	log.info("Login - Step 01: Navigate to Login page");
    	loginPage = homePage.clickToLoginLink();
    	
    	log.info("Login - Step 02: Set Cookie and reload page");
    	loginPage.setCookies(driver, Common_01_Register_Cookie.loggedCookie);
    	loginPage.refreshPage(driver);

    	log.info("Login - Step 05: Verify My Account link is display");
    	Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }

    @Test
    public void TC_01_Search_Data()
    {
    	log.info("Login - Step 05: Verify My Account link is display");
    	Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }
    
    @AfterClass
    public void afterClass()
    {
    	driver.close();
    }
}
