package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	protected WebDriver driver;
	
    //private String projectPath = System.getProperty("user.dir");
	protected WebDriver getBrowserDriver(String browserName)
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
    	driver.get("http://live.techpanda.org/");
		return driver;
		
		}
	/*private String getEnviromentUrl(String envName)
	{
		String envUrl = null;
		EnviromentList envList = EnviromentList.valueOf(envName.toUpperCase());
		if (envList == EnviromentList.DEV)
		{
			envUrl = "https://demo.nopcommerce.com/";
		} else if (envList == EnviromentList.TEST)
		{
			envUrl = "https://demo.nopcommerce.com/";
		}
		return envUrl;
	}*/
}
