package learn.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Level_01_Register_DRY {
	WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    String email = "automation" + getRandomNumber() + "@gmail.com";

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void TC_01_Register_With_Empty_Data()
    {
    	driver.get("https://demo.nopcommerce.com/");
    	driver.findElement(By.xpath("//a[@class='ico-register']")).click();
    	driver.findElement(By.xpath("//button[@id='register-button']")).click();
    	
    	Assert.assertEquals(driver.findElement(By.xpath("//span[@id='FirstName-error']")).getText(),"First name is required.");
    	Assert.assertEquals(driver.findElement(By.xpath("//span[@id='LastName-error']")).getText(),"Last name is required.");
    	Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Email-error']")).getText(),"Email is required.");
    	Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Password-error']")).getText(),"Password is required.");
    	Assert.assertEquals(driver.findElement(By.xpath("//span[@id='ConfirmPassword-error']")).getText(),"Password is required.");
	
    }
    
    @Test
    public void TC_02_Register_With_Invalid_Email()
    {
    	driver.get("https://demo.nopcommerce.com/");
    	driver.findElement(By.xpath("//a[@class='ico-register']")).click();
    	
    	driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Automation");
    	driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("FC");
    	driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("Email");
    	driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("12345678");
    	driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("12345678");
    	driver.findElement(By.xpath("//button[@id='register-button']")).click();
    	
    	Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Email-error']")).getText(),"Wrong email");
    	
    }
    
    @Test
    public void TC_03_Register_With_Valid_Email()
    {
    	driver.get("https://demo.nopcommerce.com/");
    	driver.findElement(By.xpath("//a[@class='ico-register']")).click();
    	
    	driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Automation");
    	driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("FC");
    	driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
    	driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("12345678");
    	driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("12345678");
    	driver.findElement(By.xpath("//button[@id='register-button']")).click();
    	
    	Assert.assertEquals(driver.findElement(By.xpath("//div[@class='result']")).getText(),"Your registration completed");
    	
    }
    
    @Test
    public void TC_04_Register_With_Existing_Email()
    {
    	driver.get("https://demo.nopcommerce.com/");
    	driver.findElement(By.xpath("//a[@class='ico-register']")).click();
    	
    	driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Automation");
    	driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("FC");
    	driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
    	driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("12345678");
    	driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("12345678");
    	driver.findElement(By.xpath("//button[@id='register-button']")).click();
    	
    	Assert.assertEquals(driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText(),"The specified email already exists");
    	
    }
    
    @Test
    public void TC_05_Register_With_Password_Less_Than_6_Characters()
    {
    	driver.get("https://demo.nopcommerce.com/");
    	driver.findElement(By.xpath("//a[@class='ico-register']")).click();
    	
    	driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Automation");
    	driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("FC");
    	driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("automation@gmail.com");
    	driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("12345");
    	driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("12345");
    	driver.findElement(By.xpath("//button[@id='register-button']")).click();
    	
    	Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Password-error']")).getText(),"Password must meet the following rules:\nmust have at least 6 characters");
    	
    }
    @Test
    public void TC_06_Register_With_ConfirmPassword_Not_Match()
    {
    	driver.get("https://demo.nopcommerce.com/");
    	driver.findElement(By.xpath("//a[@class='ico-register']")).click();
    	
    	driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Automation");
    	driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("FC");
    	driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("automation@gmail.com");
    	driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("12345678");
    	driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("87654321");
    	driver.findElement(By.xpath("//button[@id='register-button']")).click();
    	
    	Assert.assertEquals(driver.findElement(By.xpath("//span[@id='ConfirmPassword-error']")).getText(),"The password and confirmation password do not match.");    	
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
