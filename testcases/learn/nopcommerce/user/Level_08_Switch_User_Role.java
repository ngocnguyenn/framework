package learn.nopcommerce.user;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjectsNopCommerceAdmin.AdminHomePageObject;
import pageObjectsNopCommerceAdmin.AdminLoginPageObject;
import pageObjectsNopCommerceUser.UserAddressPageObject;
import pageObjectsNopCommerceUser.UserBackInStockSubPageObject;
import pageObjectsNopCommerceUser.UserChangePasswordPageObject;
import pageObjectsNopCommerceUser.UserCustomerInforPageObject;
import pageObjectsNopCommerceUser.UserDownloadablePageObject;
import pageObjectsNopCommerceUser.UserHomePageObject;
import pageObjectsNopCommerceUser.UserLoginPageObject;
import pageObjectsNopCommerceUser.UserMyProductReviewPageObject;
import pageObjectsNopCommerceUser.UserOrdersPageObject;
import pageObjectsNopCommerceUser.UserRegisterPageObject;
import pageObjectsNopCommerceUser.UserRewardPointPageObject;

public class Level_08_Switch_User_Role extends BaseTest {
	private WebDriver driver;
    private String firstName, lastName, password, validUserEmail, adminEmail, adminPassword;
    
    private UserHomePageObject userHomePage;
    private UserRegisterPageObject userRegisterPage;
    private UserLoginPageObject userLoginPage;
    
    private AdminLoginPageObject adminLoginPage;
    private AdminHomePageObject adminHomePage;
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
    	firstName = "Automation";
    	lastName = "FC";
    	password = "12345678";
    	adminEmail = "admin@yourstore.com";
    	adminPassword = "admin";
    	validUserEmail = "automation" + getRandomNumber() + "@gmail.com";
        driver = getBrowserDriver(browserName);
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
    	userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
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
