package pageObjectsNopCommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	public static HomePageObject getHomePageObject(WebDriver driver)
	{
		return new HomePageObject(driver);
	}
	public static LoginPageObject getLoginPageObject(WebDriver driver)
	{
		return new LoginPageObject(driver);
	}
	public static RegisterPageObject getRegisterPageObject(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	public static AddressPageObject getAddressPageObject(WebDriver driver) {
		return new AddressPageObject(driver);
	}
	public static OrdersPageObject getOrdersPageObject(WebDriver driver) {
		return new OrdersPageObject(driver);
	}
	public static DownloadablePageObject getDownloadablePageObject(WebDriver driver) {
		return new DownloadablePageObject(driver);
	}
	public static BackInStockSubPageObject getBackInStockSubPageObject(WebDriver driver) {
		return new BackInStockSubPageObject(driver);
	}
	public static RewardPointPageObject getRewardPointPageObject(WebDriver driver) {
		return new RewardPointPageObject(driver);
	}
	public static ChangePasswordPageObject getOpenChangePasswordPageObject(WebDriver driver) {
		return new ChangePasswordPageObject(driver);
	}
	public static MyProductReviewPageObject getMyProductReviewPageObject(WebDriver driver) {
		return new MyProductReviewPageObject(driver);
	}
	public static CustomerInforPageObject getCustomerInforPageObject(WebDriver driver) {
		return new CustomerInforPageObject(driver);
	}
}
