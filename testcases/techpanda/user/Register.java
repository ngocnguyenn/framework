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
import pageObjectTechPanda.MyDashBoardPageObject;
import pageObjectTechPanda.RegisterPageObject;

public class Register extends BaseTest{
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
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
	}
	
	@Test
	public void Register_01_With_Empty_Data()
	{
		homePage = new HomePageObject(driver);
		homePage.clickToAccountMenu();
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getErrorMessageAtFirstName(),"This is a required field.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastName(),"This is a required field.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailAddress(),"This is a required field.");
		Assert.assertEquals(registerPage.getErrorMessageAtPassword(),"This is a required field.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPassword(),"This is a required field.");
	}
	@Test
	public void Register_02_Successful()
	{
		homePage = new HomePageObject(driver);
		homePage.clickToAccountMenu();
		registerPage = homePage.clickToRegisterLink();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailAddressTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(passWord);
		registerPage.inputToConfirmPassword(confirmPassword);
		dashboardPage = registerPage.clickToRegisterButton();
		Assert.assertEquals(dashboardPage.getSuccessMessageRegister(),"Thank you for registering with Main Website Store.");
		
	}
	
	@AfterClass
    public void afterClass()
    {
    	driver.close();
    }
	
	public int getRandomNumber()
    {
        Random rand = new Random();
        return rand.nextInt(99999);
    }
}
