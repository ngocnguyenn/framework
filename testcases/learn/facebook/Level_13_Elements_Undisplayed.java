package learn.facebook;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import pageObjects.Facebook.LoginPageObject;
import pageObjects.Facebook.PageGeneratorManager;

public class Level_13_Elements_Undisplayed extends BaseTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName, "https://vi-vn.facebook.com/");
        loginPage = PageGeneratorManager.getLoginPageObject(driver);
    }

    @Test
    public void TC_01_Verify_Element_Displayed()
    {
    	loginPage.clickToCreateNewAccountButton();
    	verifyTrue(loginPage.isEmailAddressTextboxDisplayed());
    }
    
    @Test
    public void TC_02_Verify_Element_Undisplayed_In_Dom()
    {
    	loginPage.enterToEmailTextbox("automation@gmail.com");
    	loginPage.sleepInSecond(3);
    	verifyTrue(loginPage.isConfirmEmailAddressTextboxDisplayed());
    	
    	loginPage.enterToEmailTextbox("");
    	loginPage.sleepInSecond(3);
    	verifyTrue(loginPage.isConfirmEmailAddressTextboxUnDisplayed());
    }
    @Test
    public void TC_03_Verify_Element_Undisplayed_Not_In_Dom()
    {
    	loginPage.clickCloseCreateAccountPopup();
    	loginPage.sleepInSecond(2);
    	
    	verifyTrue(loginPage.isConfirmEmailAddressTextboxUnDisplayed());
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
