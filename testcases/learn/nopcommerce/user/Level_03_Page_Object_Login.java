package learn.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;
import pageObjectsNopCommerce.HomePageObject;
import pageObjectsNopCommerce.LoginPageObject;
import pageObjectsNopCommerce.RegisterPageObject;

public class Level_03_Page_Object_Login extends BasePage {
	private WebDriver driver;
    private String projectPath = System.getProperty("user.dir");
    private String osName = System.getProperty("os.name");

    private String firstName, lastName, password, validEmail, invalidEmail, notFoundEmail;
    
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;

    @BeforeClass
    public void beforeClass() {
    	firstName = "Automation";
    	lastName = "FC";
    	password = "12345678";
    	validEmail = "automation" + getRandomNumber() + "@gmail.com";
    	invalidEmail = "FC";
    	notFoundEmail = "automation" + getRandomNumber() + "@gmail.net";
    	 	
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new ChromeDriver();
        
        homePage = new HomePageObject(driver);
        registerPage = new RegisterPageObject(driver);
        loginPage = new LoginPageObject(driver);
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	driver.get("https://demo.nopcommerce.com/");

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
    	homePage.clickToLoginLink();

    	loginPage = new LoginPageObject(driver);
    	
    	loginPage.clickToLoginButton();
    	
    	Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(),"Please enter your email");
    }
    
    @Test
    public void Login_02_With_Invalid_Email()
    {
    	
    	homePage.clickToLoginLink();

    	loginPage = new LoginPageObject(driver);

    	loginPage.inputToEmailTextbox(invalidEmail);
    	
    	loginPage.clickToLoginButton();
    	
    	Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(),"Wrong email");
    	
    }
    
    @Test
    public void Login_03_With_Not_Found_Email()
    {
    	
    	homePage.clickToLoginLink();
    	
    	loginPage = new LoginPageObject(driver);
    	
    	loginPage.inputToEmailTextbox(notFoundEmail);
    	
    	loginPage.inputToPasswordTextbox(password);
    	  	
    	loginPage.clickToLoginButton();
    	
    	Assert.assertEquals(loginPage.getUnSuccessMessage(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
    	
    	
    }
    
    @Test
    public void Login_04_With_Valid_Email_And_Empty_Password()
    {
        homePage.clickToLoginLink();

    	loginPage = new LoginPageObject(driver);
    	
    	loginPage.inputToEmailTextbox(validEmail);
    	  	
    	loginPage.clickToLoginButton();
    	
    	Assert.assertEquals(loginPage.getUnSuccessMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");    	
    }
    
    @Test
    public void Login_05_With_Valid_Email_And_Wrong_Password()
    {
    	homePage.clickToLoginLink();
    	
    	loginPage = new LoginPageObject(driver);
    	
    	loginPage.inputToEmailTextbox(validEmail);
    	
    	loginPage.inputToPasswordTextbox("87654321");
    	  	
    	loginPage.clickToLoginButton();
    	
    	Assert.assertEquals(loginPage.getUnSuccessMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }
    @Test
    public void Login_06_With_Valid_Email_And_Valid_Password()
    {
    	homePage.clickToLoginLink();
    	
    	loginPage = new LoginPageObject(driver);
    	
    	loginPage.inputToEmailTextbox(validEmail);
    	
    	loginPage.inputToPasswordTextbox(password);
    	  	
    	loginPage.clickToLoginButton();
    	
    	homePage = new HomePageObject(driver);
    	
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
