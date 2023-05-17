package pageObjects.NopCommerce.Admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIsNopCommerceAdmin.AdminHomePageUI;

public class AdminHomePageObject extends BasePage{

	WebDriver driver;
	public AdminHomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public String getDashboardHeader() {
		waitForElementVisible(driver, AdminHomePageUI.DASHBOARD_HEADER);
		return getElementText(driver, AdminHomePageUI.DASHBOARD_HEADER);
	}

}
