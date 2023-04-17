package techpanda.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjectTechPanda.HomePageObject;
import pageObjectTechPanda.LoginPageObject;
import pageObjectTechPanda.MyDashBoardPageObject;
import pageObjectTechPanda.RegisterPageObject;

public class Login extends BaseTest{
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private MyDashBoardPageObject dashboardPage;

	private String firstName, lastName, emailAddress, passWord, confirmPassword;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName)
	{
		driver = getBrowserDriver(browserName);
		firstName = "Automation";
		lastName = "FC";
    	emailAddress = "automation" + getRandomNumber() + "@gmail.com";
    	passWord = "12345678";
    	confirmPassword = "12345678";
    	
    	homePage = new HomePageObject(driver);
		homePage.clickToAccountMenu();
		registerPage = homePage.clickToRegisterLink();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailAddressTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(passWord);
		registerPage.inputToConfirmPassword(confirmPassword);
		dashboardPage = registerPage.clickToRegisterButton();
		dashboardPage.clickToMyAccountLabel();
		dashboardPage.clickToLogoutLink();
	}
	
	@Test
	public void Login_01_With_Invalid_Email()
	{
    	homePage = new HomePageObject(driver);
		homePage.clickToAccountMenu();
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailAddressTextbox("automation@gmail.com");
		loginPage.inputToPasswordTextbox(passWord);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageInvalidEmail(), "Invalid login or password.");
		
	}
	@Test
	public void Login_02_With_Valid_Account()
	{
		homePage = new HomePageObject(driver);
		homePage.clickToAccountMenu();
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailAddressTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(passWord);
		dashboardPage = loginPage.clickToLoginButton();
		Assert.assertEquals(dashboardPage.getInformationAtDashboard(),"Hello, " + firstName + " " + lastName + "!");
	}
	
	public int getRandomNumber()
    {
        Random rand = new Random();
        return rand.nextInt(99999);
    }
	@AfterClass
	public void afterClass()
	{
		driver.close();
	}

}
