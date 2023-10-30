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
import pageObjects.NopCommerce.User.UserAddressPageObject;
import pageObjects.NopCommerce.User.UserBackInStockSubPageObject;
import pageObjects.NopCommerce.User.UserChangePasswordPageObject;
import pageObjects.NopCommerce.User.UserCustomerInforPageObject;
import pageObjects.NopCommerce.User.UserDownloadablePageObject;
import pageObjects.NopCommerce.User.UserHomePageObject;
import pageObjects.NopCommerce.User.UserLoginPageObject;
import pageObjects.NopCommerce.User.UserMyProductReviewPageObject;
import pageObjects.NopCommerce.User.UserOrdersPageObject;
import pageObjects.NopCommerce.User.UserRegisterPageObject;
import pageObjects.NopCommerce.User.UserRewardPointPageObject;

public class Level_07_Switch_Page_UI extends BaseTest {
	private WebDriver driver;
    private String firstName, lastName, password, validEmail;
    
    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private UserCustomerInforPageObject customerInforPage;
    private UserAddressPageObject addressPage;
    private UserBackInStockSubPageObject backInStockSubPage;
    private UserChangePasswordPageObject changePasswordPage;
    private UserDownloadablePageObject downloadablePage;
    private UserMyProductReviewPageObject myProductReviewPage;
    private UserOrdersPageObject ordersPage;
    private UserRewardPointPageObject rewardPointPage;
    @Parameters({"envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion"})
    @BeforeClass
    public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName, @Optional("chrome") String browserName, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber, @Optional("Windows") String osName, @Optional("10") String osVersion) {
        driver = getBrowserDriver(envName,serverName, browserName, ipAddress, portNumber, osName, osVersion);
    	firstName = "Automation";
    	lastName = "FC";
    	password = "12345678";
    	validEmail = "automation" + getRandomNumber() + "@gmail.com";
        homePage = new UserHomePageObject(driver);
        registerPage = new UserRegisterPageObject(driver);
        loginPage = new UserLoginPageObject(driver);
        customerInforPage = new UserCustomerInforPageObject(driver);
    }

    @Test
    public void TC_01_Register_With_Valid_Infor()
    {
    	registerPage = homePage.clickToRegisterLink();
    	registerPage.inputToFirstNameTextbox(firstName);
    	registerPage.inputToLastNameTextbox(lastName);
    	registerPage.inputToEmailTextbox(validEmail);
    	registerPage.inputToPasswordTextbox(password);
    	registerPage.inputToConfirmPasswordTextbox(password);
    	registerPage.clickToRegisterButton();
    	Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
    }
    
    @Test
    public void TC_02_Login_With_Valid_Infor()
    {
    	loginPage = homePage.clickToLoginLink();
    	loginPage.inputToEmailTextbox(validEmail);
    	loginPage.inputToPasswordTextbox(password);
    	homePage = loginPage.clickToLoginButton();
    	Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }
    
    @Test
    public void TC_03_Customer_Infor()
    {
    	customerInforPage = homePage.clickToMyAccountLink();
    	addressPage = customerInforPage.openAddressPage(driver);
    	rewardPointPage = addressPage.openRewardPointPage(driver);
    	ordersPage = rewardPointPage.openOrdersPage(driver);
    	backInStockSubPage = ordersPage.openBackInStockSubPage(driver);
    	changePasswordPage = backInStockSubPage.openChangePasswordPage(driver);
    	customerInforPage = changePasswordPage.openCustomerInforPage(driver);
    	downloadablePage = customerInforPage.openDownloadablePage(driver);
    	myProductReviewPage = downloadablePage.openMyProductReviewPage(driver);
    	ordersPage = myProductReviewPage.openOrdersPage(driver);
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
