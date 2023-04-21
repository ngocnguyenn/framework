package learn.nopcommerce.user;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
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

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
    	firstName = "Automation";
    	lastName = "FC";
    	password = "12345678";
    	validEmail = "automation" + getRandomNumber() + "@gmail.com";
        driver = getBrowserDriver(browserName);
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
