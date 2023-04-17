package pageObjectTechPanda;

import org.openqa.selenium.WebDriver;


public class PageGeneratorManager 
{
	public static RegisterPageObject getRegisterPageObject(WebDriver driver)
	{
		return new RegisterPageObject(driver);
	}

	public static MyDashBoardPageObject getMyDashBoardPageObject(WebDriver driver) {
		return new MyDashBoardPageObject(driver);
	}

	public static LoginPageObject getLoginPageObject(WebDriver driver) {
		return new LoginPageObject(driver);
	}
}
