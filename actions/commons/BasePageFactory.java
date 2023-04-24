package commons;


import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {
	public static BasePageFactory getBasePageObject()
	{
		return new BasePageFactory();
	}
	
	protected void openPageUrl(WebDriver driver, String pageUrl)
	{
		driver.get("pageUrl");
	}

	protected String getTitle(WebDriver driver )
	{
		return driver.getTitle();
	}
	
	protected String getCurrentUrl (WebDriver driver)
	{
		return driver.getCurrentUrl();
	}
	protected String getPageSource (WebDriver driver)
	{
		return driver.getPageSource();
	}
	
	protected void backToPage (WebDriver driver)
	{
		driver.navigate().back();
	}
	protected void forwardToPage (WebDriver driver)
	{
		driver.navigate().forward();
	}
	
	protected void refreshPage (WebDriver driver)
	{
		driver.navigate().refresh();
	}
	
	protected Alert waitAlertPresence(WebDriver driver)
	{
		WebDriverWait explicitWait = new WebDriverWait (driver, 30);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	
	protected void acceptAlert(WebDriver driver)
	{
		Alert alert = waitAlertPresence(driver);
		alert.accept();
	}
	
	protected void cancelAlert(WebDriver driver)
	{
		waitAlertPresence(driver).dismiss();
	}
	
	protected String getAlertText(WebDriver driver)
	{
		return waitAlertPresence(driver).getText();
	}
	
	protected void sendkeyToAlert (WebDriver driver, String textValue)
	{
		waitAlertPresence(driver).sendKeys(textValue);
	}
	
	protected void closeAllWindowWithoutCurrentID(WebDriver driver, String parentID)
	{
		Set <String> allWindows = driver.getWindowHandles();
		for (String ID: allWindows)
		{
			if(!ID.equals(parentID))
			{
				driver.switchTo().window(ID);
				driver.close();
				driver.switchTo().window(parentID);
			}
		}
	}
	
	protected void switchToWindowByTitle(WebDriver driver, String expectedTitle)
	{
		Set<String> allWindows = driver.getWindowHandles();
		for (String ID: allWindows)
		{
			driver.switchTo().window(ID);
			String getTitle = driver.getTitle();
			if (getTitle.equals(expectedTitle))
			{
				break;
			}
		}
	}
	
	protected void switchToWindowByID (WebDriver driver, String currentID)
	{
		Set<String> allWindows = driver.getWindowHandles();
		for (String ID: allWindows)
		{
			if(!ID.equals(currentID))
			{
				driver.switchTo().window(ID);
				break;
			}
		}
	}
	
	/*private By getByXpath(String locator)
	{
		return By.xpath(locator);
	}
	
	private WebElement getElement (WebDriver driver, WebElement element)
	{
		return driver.findElement(getByXpath(xpathLocator));
	}
	
	private List<WebElement> getElements (WebDriver driver, WebElement element)
	{
		return driver.findElements(getByXpath(xpathLocator));
	}
	*/
	protected void clickToElement(WebDriver driver, WebElement element)
	{
		element.click();
	}
	
	protected void sendKeyToElement (WebDriver driver, WebElement element, String textValue)
	{
		element.clear();
		element.sendKeys(textValue);
	}
	
	protected String getElementText(WebDriver driver, WebElement element)
	{
		return element.getText();
	}
	
	protected void selectItemInDefaultDropDown (WebDriver driver, WebElement element, String textItem)
	{
		Select select = new Select(element);
		select.selectByValue(textItem);
	}
	
	protected String getSelectedItemDefaultDropDown(WebDriver driver, WebElement element)
	{
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}
	
	protected Boolean isDropDownMultiple(WebDriver driver, WebElement element)
	{
		Select select = new Select(element);
		return select.isMultiple();
	}
	
	protected Boolean isElementDisplayed(WebDriver driver, WebElement element)
	{
		return element.isDisplayed();
	}
	protected Boolean isElementEnabled(WebDriver driver, WebElement element)
	{
		return element.isEnabled();
	}
	protected Boolean isElementSelected(WebDriver driver, WebElement element)
	{
		return element.isSelected();
	}
	protected void switchToFrameIframe(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	protected void switchToDefaultContent(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	protected void hoverMouseToElement (WebDriver driver, WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	protected Object executeForBrowser(WebDriver driver, String javaScript) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return jsExecutor.executeScript(javaScript);
    }

    protected String getInnerText(WebDriver driver) 
    {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
    }

    protected boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }

    protected void scrollToBottomPage(WebDriver driver) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    protected void navigateToUrlByJS(WebDriver driver, String url) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.location = '" + url + "'");
    }

    protected void clickToElementByJS(WebDriver driver, WebElement element) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    protected void scrollToElementOnTop(WebDriver driver, WebElement element) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void scrollToElementOnDown(WebDriver driver, WebElement element) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(false);", element);
    }

    protected void sendkeyToElementByJS(WebDriver driver, WebElement element, String value) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
    }

    protected void removeAttributeInDOM(WebDriver driver, WebElement element, String attributeRemove) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
    }

    protected String getElementValidationMessage(WebDriver driver, WebElement element) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", element);
    }

    protected boolean isImageLoaded(WebDriver driver, WebElement element) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        boolean status = (boolean) jsExecutor.executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
                element);
        return status;
    }
    
    protected void waitForElementVisible(WebDriver driver, WebElement element)
    {
    	WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
    	explicitWait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForAllElementVisible(WebDriver driver, WebElement element)
    {
    	WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
    	explicitWait.until(ExpectedConditions.visibilityOfAllElements(element));
    }
    protected void waitForElementInVisible(WebDriver driver, WebElement element)
    {
    	WebDriverWait explicitWait = new WebDriverWait(driver,longTimeOut);
    	explicitWait.until(ExpectedConditions.invisibilityOf(element));
    }

    protected void waitForAllElementInVisible(WebDriver driver, WebElement element)
    {
    	WebDriverWait explicitWait = new WebDriverWait(driver,longTimeOut);
    	explicitWait.until(ExpectedConditions.invisibilityOfAllElements(element));
    }
    protected void waitForElementClickable(WebDriver driver, WebElement element)
    {
    	WebDriverWait explicitWait = new WebDriverWait(driver,longTimeOut);
    	explicitWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void sleepInSecond(long timeInSecond)
    {
        try{
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    private long longTimeOut = GlobalConstants.LONG_TIMEOUT;
}

