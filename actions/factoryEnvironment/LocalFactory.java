package factoryEnvironment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import factoryBrowser.BrowserList;
import factoryBrowser.BrowserNotSupportedException;
import factoryBrowser.ChromeDriverManager;
import factoryBrowser.EdgeDriverManager;
import factoryBrowser.FirefoxDriverManager;
import factoryBrowser.HeadlessChromeDriverManager;
import factoryBrowser.HeadlessFirefoxDriverManager;
import factoryBrowser.OperaDriverManager;
import factoryBrowser.SafariDriverManager;

public class LocalFactory implements EnvironmentFactory{
	private  WebDriver driver;
	private String browserName;
	
	public LocalFactory(String browserName)
	{
		this.browserName = browserName;
	}
	
	public WebDriver createDriver() 
	{
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
		switch (browser) 
		{
			case FIREFOX:
				driver = new FirefoxDriverManager().getBrowserDriver();
				break;
			case CHROME:
				driver = new ChromeDriverManager().getBrowserDriver();
				break;
			case OPERA:
				driver = new OperaDriverManager().getBrowserDriver();
				break;
			case EDGE:
				driver = new EdgeDriverManager().getBrowserDriver();
				break;
			case SAFARI:
				driver = new SafariDriverManager().getBrowserDriver();
				break;
			case H_CHROME:
				driver = new HeadlessChromeDriverManager().getBrowserDriver();
				break;
			case H_FIREFOX:
				driver = new HeadlessFirefoxDriverManager().getBrowserDriver();
				break;
			default:
				throw new BrowserNotSupportedException(browserName);
		}
		return driver;
	}
}
