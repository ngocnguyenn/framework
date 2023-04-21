package commons;

import org.openqa.selenium.WebDriver;

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
