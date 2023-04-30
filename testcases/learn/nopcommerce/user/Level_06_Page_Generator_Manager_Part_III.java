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
import pageObjectsNopCommerceUser.UserHomePageObject;
import pageObjectsNopCommerceUser.UserLoginPageObject;
import pageObjectsNopCommerceUser.UserRegisterPageObject;

public class Level_06_Page_Generator_Manager_Part_III extends BaseTest {
	private WebDriver driver;
    private String firstName, lastName, password, validEmail, invalidEmail, notFoundEmail;
    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;
    private UserLoginPageObject loginPage;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
    	firstName = "Automation";
    	lastName = "FC";
    	password = "12345678";
    	validEmail = "automation" + getRandomNumber() + "@gmail.com";
    	invalidEmail = "FC";
    	notFoundEmail = "automation" + getRandomNumber() + "@gmail.net";
        driver = getBrowserDriver(browserName, GlobalConstants.USER_PAGE_URL);
        homePage = new UserHomePageObject(driver);
        registerPage = new UserRegisterPageObject(driver);
        loginPage = new UserLoginPageObject(driver);
    	homePage.clickToRegisterLink();
    	registerPage.inputToFirstNameTextbox(firstName);
    	registerPage.inputToLastNameTextbox(lastName);
    	registerPage.inputToEmailTextbox(validEmail);
    	registerPage.inputToPasswordTextbox(password);
    	registerPage.inputToConfirmPasswordTextbox(password);
    	registerPage.clickToRegisterButton();
    	Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
    }

    @Test
    public void Login_01_With_Empty_Data()
    {
    	loginPage = homePage.clickToLoginLink();
    	loginPage.clickToLoginButton();
    	Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(),"Please enter your email");
    }
    
    @Test
    public void Login_02_With_Invalid_Email()
    {
    	loginPage = homePage.clickToLoginLink();
    	loginPage.inputToEmailTextbox(invalidEmail);
    	loginPage.clickToLoginButton();
    	Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(),"Wrong email");
    }
    
    @Test
    public void Login_03_With_Not_Found_Email()
    {
    	loginPage = homePage.clickToLoginLink();
    	loginPage.inputToEmailTextbox(notFoundEmail);
    	loginPage.inputToPasswordTextbox(password);
    	loginPage.clickToLoginButton();
    	Assert.assertEquals(loginPage.getUnSuccessMessage(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
    }
    
    @Test
    public void Login_04_With_Valid_Email_And_Empty_Password()
    {
        loginPage = homePage.clickToLoginLink();
    	loginPage.inputToEmailTextbox(validEmail);
    	loginPage.clickToLoginButton();
    	Assert.assertEquals(loginPage.getUnSuccessMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");    	
    }
    
    @Test
    public void Login_05_With_Valid_Email_And_Wrong_Password()
    {
    	loginPage = homePage.clickToLoginLink();
    	loginPage.inputToEmailTextbox(validEmail);
    	loginPage.inputToPasswordTextbox("87654321");
    	loginPage.clickToLoginButton();
    	Assert.assertEquals(loginPage.getUnSuccessMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }
    @Test
    public void Login_06_With_Valid_Email_And_Valid_Password()
    {
    	loginPage = homePage.clickToLoginLink();
    	loginPage.inputToEmailTextbox(validEmail);
    	loginPage.inputToPasswordTextbox(password);
    	homePage = loginPage.clickToLoginButton();
    	Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
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
