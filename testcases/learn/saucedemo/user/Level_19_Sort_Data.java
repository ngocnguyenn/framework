package learn.saucedemo.user;

import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import pageObjects.SauceDemo.User.UserLoginPageObject;
import pageObjects.SauceDemo.User.UserProductPageObject;
import reportConfigs.ExtentTestManager;

public class Level_19_Sort_Data extends BaseTest {
	private WebDriver driver;
    private UserLoginPageObject loginPage;
    private UserProductPageObject productPage;
    String username, password;

    @Parameters({"browser", "pageUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String sauceUrl) {
        driver = getBrowserDriver(browserName, sauceUrl);
        loginPage = new UserLoginPageObject(driver);
        username = "standard_user";
        password = "secret_sauce";

    	loginPage.inputToUserNameTextbox(username);
    	loginPage.inputToPasswordTextbox(password);
    	productPage = loginPage.clickToLoginButton();
    }

    @Test
    public void TC_01_Sort_Name_By_Ascending(Method method)
    {
    	ExtentTestManager.startTest(method.getName(),"Sort product name by ascending");
    	ExtentTestManager.getTest().log(Status.INFO, "Sort by ascending - Step 01: Select Items Name (A to Z)");
    	productPage.selectItemInSortDropDownByValue("Name (Z to A)");
    	ExtentTestManager.getTest().log(Status.INFO, "Sort by ascending - Step 02: Verify product sort by ascending");
    	Assert.assertTrue(productPage.isProductNameSortByAscending());
    }
    
    @Test
    public void TC_02_Sort_Name_By_Descending(Method method)
    {
    	ExtentTestManager.startTest(method.getName(),"Sort product name by descending");
    	ExtentTestManager.getTest().log(Status.INFO, "Sort by descending - Step 01: Select Items Name (Z to A)");
    	productPage.selectItemInSortDropDownByValue("Name (Z to A)");
    	ExtentTestManager.getTest().log(Status.INFO, "Sort by descending - Step 02: Verify product sort by descending");
    	productPage.isProductNameSortByDescending();
    }
    
   
    @AfterClass(alwaysRun = true)
    public void afterClass()
    {
    	closeBrowserDriver();
    }
}
