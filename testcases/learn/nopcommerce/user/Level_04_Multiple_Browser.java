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
import pageObjects.NopCommerce.User.UserHomePageObject;
import pageObjects.NopCommerce.User.UserRegisterPageObject;

public class Level_04_Multiple_Browser extends BaseTest {

	private WebDriver driver;
    private String firstName, lastName, passWord, emailAddress;
    
    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
    	driver = getBrowserDriver(browserName, GlobalConstants.USER_PAGE_URL);
    	homePage = new UserHomePageObject(driver);
        registerPage = new UserRegisterPageObject(driver);

    	firstName = "Automation";
    	lastName = "FC";
    	passWord = "12345678";
    	emailAddress = "automation" + getRandomNumber() + "@gmail.com";
    }

    @Test
    public void Register_01_With_Empty_Data()
    {
    	homePage.clickToRegisterLink();
    	registerPage.clickToRegisterButton();
    	
    	Assert.assertEquals(registerPage.getErrorMessageAtFirstNameTextbox(),"First name is required.");
    	Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextbox(),"Last name is required.");
    	Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(),"Email is required.");
    	Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),"Password is required.");
    	Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(),"Password is required.");
	
    }
    
    @Test
    public void Register_02_With_Invalid_Email()
    {
    	homePage.clickToRegisterLink();
    	registerPage.inputToFirstNameTextbox(firstName);
    	registerPage.inputToLastNameTextbox(lastName);
    	registerPage.inputToEmailTextbox("Email");
    	registerPage.inputToPasswordTextbox(passWord);
    	registerPage.inputToConfirmPasswordTextbox(passWord);
    	registerPage.clickToRegisterButton();
    	
    	Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(),"Wrong email");
    	
    }
    
    @Test
    public void Register_03_With_Valid_Email()
    {
    	homePage.clickToRegisterLink();
    	registerPage.inputToFirstNameTextbox(firstName);
    	registerPage.inputToLastNameTextbox(lastName);
    	registerPage.inputToEmailTextbox(emailAddress);
    	registerPage.inputToPasswordTextbox(passWord);
    	registerPage.inputToConfirmPasswordTextbox(passWord);
    	registerPage.clickToRegisterButton();
    	Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
    }
    
    @Test
    public void Register_04_With_Existing_Email()
    {
    	homePage.clickToRegisterLink();
    	registerPage.inputToFirstNameTextbox(firstName);
    	registerPage.inputToLastNameTextbox(lastName);
    	registerPage.inputToEmailTextbox(emailAddress);
    	registerPage.inputToPasswordTextbox(passWord);
    	registerPage.inputToConfirmPasswordTextbox(passWord);
    	registerPage.clickToRegisterButton();
    	Assert.assertEquals(registerPage.getErrorExistingEmailMessage(),"The specified email already exists");
    	
    }
    
    @Test
    public void Register_05_With_Password_Less_Than_6_Characters()
    {
    	homePage.clickToRegisterLink();
    	registerPage.inputToFirstNameTextbox(firstName);
    	registerPage.inputToLastNameTextbox(lastName);
    	registerPage.inputToEmailTextbox("automation@gmail.com");
    	registerPage.inputToPasswordTextbox("12345");
    	registerPage.inputToConfirmPasswordTextbox("12345");
    	registerPage.clickToRegisterButton();
    	
    	Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),"Password must meet the following rules:\nmust have at least 6 characters");
    	
    }
    @Test
    public void Register_06_With_ConfirmPassword_Not_Match()
    {
    	homePage.clickToRegisterLink();
    	registerPage.inputToFirstNameTextbox(firstName);
    	registerPage.inputToLastNameTextbox(lastName);
    	registerPage.inputToEmailTextbox("automation@gmail.com");
    	registerPage.inputToPasswordTextbox(passWord);
    	registerPage.inputToConfirmPasswordTextbox("87654321");
    	registerPage.clickToRegisterButton();
    	
    	Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(),"The password and confirmation password do not match.");    	
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
