//package learn.nopcommerce.user;
//
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import commons.BasePage;
//
//public class Level_02_Register_Apply_BasePage {
//	WebDriver driver;
//    String projectPath = System.getProperty("user.dir");
//    String osName = System.getProperty("os.name");
//
//
//    BasePage basePage;
//    String email = "automation" + getRandomNumber() + "@gmail.com";
//
//    @BeforeClass
//    public void beforeClass() {
//        if (osName.contains("Windows")) {
//            System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
//        } else {
//            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//        }
//
//        driver = new ChromeDriver();
//        basePage = BasePage.getBasePageObject();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    	driver.get("https://demo.nopcommerce.com/");
//
//    }
//
//    @Test
//    public void TC_01_Register_With_Empty_Data()
//    {
//    	
//    	basePage.clickToElement(driver, "//a[@class='ico-register']");
//    	basePage.clickToElement(driver, "//button[@id='register-button']");
//
//    	Assert.assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"),"First name is required.");
//    	Assert.assertEquals(basePage.getElementText(driver, "//span[@id='LastName-error']"),"Last name is required.");
//    	Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"),"Email is required.");
//    	Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"),"Password is required.");
//    	Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"),"Password is required.");
//	
//    }
//    
//    @Test
//    public void TC_02_Register_With_Invalid_Email()
//    {
//    	
//    	basePage.clickToElement(driver, "//a[@class='ico-register']");
//
//    	basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
//    	basePage.sendKeyToElement(driver, "//input[@id='LastName']","FC");
//    	basePage.sendKeyToElement(driver, "//input[@id='Email']","Email");
//    	basePage.sendKeyToElement(driver, "//input[@id='Password']", "12345678");
//    	basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']","12345678");
//    	basePage.clickToElement(driver, "//button[@id='register-button']");
//    	
//    	Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"),"Wrong email");
//    	
//    }
//    
//    @Test
//    public void TC_03_Register_With_Valid_Email()
//    {
//    	
//    	basePage.clickToElement(driver, "//a[@class='ico-register']");
//    	
//    	basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
//    	basePage.sendKeyToElement(driver, "//input[@id='LastName']", "FC");
//    	basePage.sendKeyToElement(driver, "//input[@id='Email']", email);
//    	basePage.sendKeyToElement(driver, "//input[@id='Password']", "12345678");
//    	basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "12345678");
//    	basePage.clickToElement(driver, "//button[@id='register-button']");
//    	
//    	Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"), "Your registration completed");
//    	
//    }
//    
//    @Test
//    public void TC_04_Register_With_Existing_Email()
//    {
//    	
//    	basePage.clickToElement(driver, "//a[@class='ico-register']");
//    	
//    	basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
//    	basePage.sendKeyToElement(driver, "//input[@id='LastName']", "FC");
//    	basePage.sendKeyToElement(driver, "//input[@id='Email']", email);
//    	basePage.sendKeyToElement(driver, "//input[@id='Password']", "12345678");
//    	basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "12345678");
//    	basePage.clickToElement(driver, "//button[@id='register-button']");
//    	
//    	Assert.assertEquals(basePage.getElementText(driver, "//div[@class='message-error validation-summary-errors']"),"The specified email already exists");
//    	
//    }
//    
//    @Test
//    public void TC_05_Register_With_Password_Less_Than_6_Characters()
//    {
//    	
//    	basePage.clickToElement(driver, "//a[@class='ico-register']");
//    	
//    	basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
//    	basePage.sendKeyToElement(driver, "//input[@id='LastName']", "FC");
//    	basePage.sendKeyToElement(driver, "//input[@id='Email']", "automation@gmail.com");
//    	basePage.sendKeyToElement(driver, "//input[@id='Password']", "12345");
//    	basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "12345");
//    	basePage.clickToElement(driver, "//button[@id='register-button']");
//    	
//    	Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"),"Password must meet the following rules:\nmust have at least 6 characters");
//    	
//    }
//    @Test
//    public void TC_06_Register_With_ConfirmPassword_Not_Match()
//    {
//    	
//    	basePage.clickToElement(driver, "//a[@class='ico-register']");
//    	
//    	basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
//    	basePage.sendKeyToElement(driver, "//input[@id='LastName']", "FC");
//    	basePage.sendKeyToElement(driver, "//input[@id='Email']", "automation@gmail.com");
//    	basePage.sendKeyToElement(driver, "//input[@id='Password']", "12345678");
//    	basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "87654321");
//    	basePage.clickToElement(driver, "//button[@id='register-button']");
//    	
//    	Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"),"The password and confirmation password do not match.");    	
//    }
//    
//    
//    public int getRandomNumber()
//    {
//        Random rand = new Random();
//        return rand.nextInt(999);
//    }
//    
//    @AfterClass
//    public void afterClass()
//    {
//    	driver.close();
//    }
//}
