package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.NopCommerce.Admin.AdminHomePageObject;
import pageObjects.NopCommerce.Admin.AdminLoginPageObject;
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

public class PageGeneratorManager {

	public static UserHomePageObject getUserHomePageObject(WebDriver driver)
	{
		return new UserHomePageObject(driver);
	}
	public static UserLoginPageObject getUserLoginPageObject(WebDriver driver)
	{
		return new UserLoginPageObject(driver);
	}
	public static UserRegisterPageObject getUserRegisterPageObject(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}
	public static UserAddressPageObject getUserAddressPageObject(WebDriver driver) {
		return new UserAddressPageObject(driver);
	}
	public static UserOrdersPageObject getUserOrderPageObject(WebDriver driver) {
		return new UserOrdersPageObject(driver);
	}
	public static UserDownloadablePageObject getUserDownloadablePageObject(WebDriver driver) {
		return new UserDownloadablePageObject(driver);
	}
	public static UserBackInStockSubPageObject getUserBackInStockSubPageObject(WebDriver driver) {
		return new UserBackInStockSubPageObject(driver);
	}
	public static UserRewardPointPageObject getUserRewardPointPageObject(WebDriver driver) {
		return new UserRewardPointPageObject(driver);
	}
	public static UserChangePasswordPageObject getUserChangePasswordPageObject(WebDriver driver) {
		return new UserChangePasswordPageObject(driver);
	}
	public static UserMyProductReviewPageObject getUserMyProductReviewPageObject(WebDriver driver) {
		return new UserMyProductReviewPageObject(driver);
	}
	public static UserCustomerInforPageObject getUserCustomerInforPageObject(WebDriver driver) {
		return new UserCustomerInforPageObject(driver);
	}
	public static AdminLoginPageObject getAdminLoginPageObject(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	public static AdminHomePageObject getAdminHomePageObject(WebDriver driver) {
		return new AdminHomePageObject(driver);
	}
}
