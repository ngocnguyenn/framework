package commons;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	protected WebDriver driver;
	protected final Log log;

	// Constructor
	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}
	
    //private String projectPath = System.getProperty("user.dir");
	protected WebDriver getBrowserDriver(String browserName, String envName)
	{
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		if(browserList == BrowserList.FIREFOX)
		{
            //System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
		} else if(browserList == BrowserList.H_FIREFOX)
		{
			//System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
            driver = new FirefoxDriver(options);
		} else if(browserList == BrowserList.CHROME)
		{
			//System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
		} else if(browserList == BrowserList.H_CHROME)
		{
			//System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
            driver = new ChromeDriver(options);
		} else if(browserList == BrowserList.OPERA)
		{
			//System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver.exe");
			WebDriverManager.operadriver().setup();
            driver = new ChromeDriver();
		} else if (browserList == BrowserList.EDGE)
		{
			//System.setProperty("webdriver.edge.driver", projectPath + "/browserDrivers/msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
		} else {
			throw new RuntimeException ("Browser name invalid.");
		}
		
       
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	driver.get(getEnviromentUrl(envName));
		return driver;
	}
	protected WebDriver getBrowserDriver_By_Url(String browserName, String envUrl)
	{
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		if(browserList == BrowserList.FIREFOX)
		{
            //System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
		} else if(browserList == BrowserList.H_FIREFOX)
		{
			//System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
            driver = new FirefoxDriver(options);
		} else if(browserList == BrowserList.CHROME)
		{
			//System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
		} else if(browserList == BrowserList.H_CHROME)
		{
			//System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
            driver = new ChromeDriver(options);
		} else if(browserList == BrowserList.OPERA)
		{
			//System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver.exe");
			WebDriverManager.operadriver().setup();
            driver = new ChromeDriver();
		} else if (browserList == BrowserList.EDGE)
		{
			//System.setProperty("webdriver.edge.driver", projectPath + "/browserDrivers/msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
		} else {
			throw new RuntimeException ("Browser name invalid.");
		}
		
       
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	driver.get(envUrl);
		return driver;
	}
	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				System.out.println(" -------------------------- PASSED -------------------------- ");
			} else {
				System.out.println(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				System.out.println(" -------------------------- PASSED -------------------------- ");
			} else {
				System.out.println(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			System.out.println(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			System.out.println(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	public WebDriver getDriver() {
		return this.driver;
	}
	
	public int getRandomNumber()
	{
		Random rand = new Random();
	    return rand.nextInt(999);
	}
	protected void closeBrowserDriver() {
		String cmd = null;
		try {
			String osName = GlobalConstants.OS_NAME;
			log.info("OS name = " + osName);

			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			String browserDriverName = null;

			if (driverInstanceName.contains("chrome")) {
				browserDriverName = "chromedriver";
			} else if (driverInstanceName.contains("internetexplorer")) {
				browserDriverName = "IEDriverServer";
			} else if (driverInstanceName.contains("firefox")) {
				browserDriverName = "geckodriver";
			} else if (driverInstanceName.contains("edge")) {
				browserDriverName = "msedgedriver";
			} else if (driverInstanceName.contains("opera")) {
				browserDriverName = "operadriver";
			} else {
				browserDriverName = "safaridriver";
			}

			if (osName.contains("window")) {
				cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
			} else {
				cmd = "pkill " + browserDriverName;
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private String getEnviromentUrl(String envName)
	{
		String envUrl = null;
		EnvironmentList envList = EnvironmentList.valueOf(envName.toUpperCase());
		if (envList == EnvironmentList.DEV)
		{
			envUrl = "https://demo.nopcommerce.com/";
		} else if (envList == EnvironmentList.TEST)
		{
			envUrl = "https://demo.nopcommerce.com/";
		}
		return envUrl;
	}
}
