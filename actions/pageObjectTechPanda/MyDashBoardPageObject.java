package pageObjectTechPanda;

import org.openqa.selenium.WebDriver;

import PageUIsTechPanda.MyDashBoardUI;
import commons.BasePage;

public class MyDashBoardPageObject extends BasePage{ 
	WebDriver driver;

	public MyDashBoardPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getSuccessMessageRegister() {
		waitForElementVisible(driver, MyDashBoardUI.SUCCESSFUL_REGISTER_MESSAGE);
		return getElementText(driver, MyDashBoardUI.SUCCESSFUL_REGISTER_MESSAGE);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, MyDashBoardUI.LOGOUT_LINK);
		clickToElement(driver, MyDashBoardUI.LOGOUT_LINK);
	}

	public String getInformationAtDashboard() {
		waitForElementVisible(driver, MyDashBoardUI.INFORMATION_ACCOUNT);
		return getElementText(driver, MyDashBoardUI.INFORMATION_ACCOUNT);
	}

	public void clickToMyAccountLabel() {
		waitForElementVisible(driver, MyDashBoardUI.MY_ACCOUNT_LABEL);
		clickToElement(driver, MyDashBoardUI.MY_ACCOUNT_LABEL);
	}

}
