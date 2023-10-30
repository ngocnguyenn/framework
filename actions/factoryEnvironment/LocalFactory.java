package factoryEnvironment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import commons.BrowserList;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalFactory {
	private  WebDriver driver;
	private String browserName;
	
	public LocalFactory(String browserName)
	{
		this.browserName = browserName;
	}
	
	public WebDriver createDriver() {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		if(browserList == BrowserList.FIREFOX)
		{
			WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
		} else if(browserList == BrowserList.H_FIREFOX)
		{
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
            driver = new FirefoxDriver(options);
		} else if(browserList == BrowserList.CHROME)
		{
			WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
		} else if(browserList == BrowserList.H_CHROME)
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
            driver = new ChromeDriver(options);
		} else if(browserList == BrowserList.OPERA)
		{
			WebDriverManager.operadriver().setup();
            driver = new ChromeDriver();
		} else if (browserList == BrowserList.EDGE)
		{
			WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
		} else {
			throw new RuntimeException ("Browser name invalid.");
		}
		
       
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	//driver.get(envUrl);
		return driver;
	}
}
