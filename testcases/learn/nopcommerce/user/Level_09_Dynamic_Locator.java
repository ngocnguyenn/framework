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

public class Level_09_Dynamic_Locator extends BaseTest {
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
        driver = getBrowserDriver(browserName, GlobalConstants.USER_PAGE_URL);
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
    public void TC_03_Dynamic_Page_01()
    {
    	customerInforPage = homePage.clickToMyAccountLink();
    	addressPage = (UserAddressPageObject) customerInforPage.openPageAtMyAccountByPageName_I(driver, "Addresses");
    	rewardPointPage = (UserRewardPointPageObject) addressPage.openPageAtMyAccountByPageName_I(driver, "Reward points");;
    	ordersPage = (UserOrdersPageObject) rewardPointPage.openPageAtMyAccountByPageName_I(driver, "Orders");
    	backInStockSubPage = (UserBackInStockSubPageObject) ordersPage.openPageAtMyAccountByPageName_I(driver, "Back in stock subscriptions");
    	changePasswordPage = (UserChangePasswordPageObject) backInStockSubPage.openPageAtMyAccountByPageName_I(driver, "Change password");
    	customerInforPage = (UserCustomerInforPageObject) changePasswordPage.openPageAtMyAccountByPageName_I(driver, "Customer info");
    	downloadablePage = (UserDownloadablePageObject) customerInforPage.openPageAtMyAccountByPageName_I(driver, "Downloadable products");
    	myProductReviewPage = (UserMyProductReviewPageObject) downloadablePage.openPageAtMyAccountByPageName_I(driver, "My product reviews");
    	ordersPage = (UserOrdersPageObject) myProductReviewPage.openPageAtMyAccountByPageName_I(driver, "Orders");
    }
    @Test
    public void TC_03_Dynamic_Page_02()
    {
    	customerInforPage = homePage.clickToMyAccountLink();
    	customerInforPage.openPageAtMyAccountByPageName_II(driver, "My product reviews");
    	myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPageObject(driver);
    	myProductReviewPage.openPageAtMyAccountByPageName_II(driver, "Addresses");
    	addressPage = PageGeneratorManager.getUserAddressPageObject(driver);
    	addressPage.openPageAtMyAccountByPageName_II(driver, "Reward points");
    	rewardPointPage = PageGeneratorManager.getUserRewardPointPageObject(driver);
    	rewardPointPage.openPageAtMyAccountByPageName_II(driver, "Orders");
    	ordersPage = PageGeneratorManager.getUserOrderPageObject(driver);
    	ordersPage.openPageAtMyAccountByPageName_II(driver, "Back in stock subscriptions");
    	backInStockSubPage = PageGeneratorManager.getUserBackInStockSubPageObject(driver);
    	backInStockSubPage.openPageAtMyAccountByPageName_II(driver, "Change password");
    	changePasswordPage = PageGeneratorManager.getUserChangePasswordPageObject(driver);
    	changePasswordPage.openPageAtMyAccountByPageName_II(driver, "Customer info");
    	customerInforPage = PageGeneratorManager.getUserCustomerInforPageObject(driver);
    	customerInforPage.openPageAtMyAccountByPageName_II(driver, "Downloadable products");
    	downloadablePage = PageGeneratorManager.getUserDownloadablePageObject(driver);
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
