package commons;



import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageUIsJQueryScript.BasePageUI;

public class BasePage {
	public static BasePage getBasePageObject()
	{
		return new BasePage();
	}
	
	public void openPageUrl(WebDriver driver, String pageUrl)
	{
		driver.get(pageUrl);
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
	
	public void refreshPage (WebDriver driver)
	{
		driver.navigate().refresh();
	}
	public Set<Cookie> getAllCookies(WebDriver driver)
	{
		return driver.manage().getCookies();
	}
	public void setCookies (WebDriver driver, Set<Cookie> cookies) {
		for (Cookie cookie: cookies)
		{
			driver.manage().addCookie(cookie);
		}
		sleepInSecond(3);
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
	
	private By getByXpath(String locator)
	{
		return By.xpath(locator);
	}
	
	private By getByLocator(String locatorType)
	{
		By by = null;
		if (locatorType.startsWith("id=") || locatorType.startsWith("Id=") || locatorType.startsWith("ID="))
		{
			by = By.id(locatorType.substring(3));
		} else if (locatorType.startsWith("class=") || locatorType.startsWith("Class=") || locatorType.startsWith("CLASS="))
		{
			by = By.className(locatorType.substring(6));
		} else if (locatorType.startsWith("name=") || locatorType.startsWith("Name=") || locatorType.startsWith("NAME="))
		{
			by = By.name(locatorType.substring(5));
		} else if (locatorType.startsWith("xpath=")|| locatorType.startsWith("Xpath=") || locatorType.startsWith("XPATH="))
		{
			by = By.xpath(locatorType.substring(6));
		} else if (locatorType.startsWith("css=") || locatorType.startsWith("Css=") || locatorType.startsWith("CSS="))
		{
			by = By.cssSelector(locatorType.substring(4));
		} else
			throw new RuntimeException("Locator type is not supported");
		return by;
	}
	
	private WebElement getElement (WebDriver driver, String locatorType)
	{
		return driver.findElement(getByLocator(locatorType));
	}
	
	public List<WebElement> getElements (WebDriver driver, String locatorType)
	{
		return driver.findElements(getByLocator(locatorType));
	}
	
	protected void clickToElement(WebDriver driver, String locatorType)
	{
		getElement(driver, locatorType).click();
	}
	
	protected void clickToElement(WebDriver driver, String locatorType, String...dynamicValues)
	{
		locatorType = String.format(locatorType,(Object[]) dynamicValues);
		getElement(driver, locatorType).click();
	}
	
	protected void sendKeyToElement (WebDriver driver, String locatorType, String textValue)
	{
		getElement(driver, locatorType).clear();
		getElement(driver, locatorType).sendKeys(textValue);
	}
	protected void sendKeyToElement (WebDriver driver, String locatorType, String textValue, String...dynamicValues)
	{
		locatorType = String.format(locatorType, (Object[]) dynamicValues);
		getElement(driver, locatorType).clear();
		getElement(driver, locatorType).sendKeys(textValue);
	}
	
	protected String getElementText(WebDriver driver, String locatorType)
	{
		return getElement(driver, locatorType).getText();
	}
	protected String getElementText(WebDriver driver, String locatorType, String...dynamicValues)
	{
		locatorType = String.format(locatorType, (Object[])dynamicValues);
		return getElement(driver, locatorType).getText();
	}
	
	protected void selectItemInDefaultDropDown (WebDriver driver, String locatorType, String textItem)
	{
		Select select = new Select(getElement(driver, locatorType));
		select.selectByValue(textItem);
	}
	
	protected void selectItemInDefaultDropDown (WebDriver driver, String locatorType, String textItem, String...dynamicValues)
	{
		locatorType = String.format(locatorType,(Object[]) dynamicValues);
		Select select = new Select(getElement(driver, locatorType));
		select.selectByValue(textItem);
	}
	
	protected String getSelectedItemDefaultDropDown(WebDriver driver, String locatorType)
	{
		Select select = new Select(getElement(driver, locatorType));
		return select.getFirstSelectedOption().getText();
	}
	protected String getSelectedItemDefaultDropDown(WebDriver driver, String locatorType, String...dynamicValues)
	{
		locatorType = String.format(locatorType, (Object[]) dynamicValues);
		Select select = new Select(getElement(driver, locatorType));
		return select.getFirstSelectedOption().getText();
	}
	
	protected Boolean isDropDownMultiple(WebDriver driver, String locatorType)
	{
		Select select = new Select(getElement(driver, locatorType));
		return select.isMultiple();
	}
	
	protected void selectIteminCustomDropdown(WebDriver driver, String parentXpath, String childXpath, String expectedTextItem)
    {
        
        getElement(driver, parentXpath).click();
        sleepInSecond(2);
        
        WebDriverWait explicitWait = new WebDriverWait(driver, 30);
        

        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childXpath)));

        for (WebElement item: allItems)
        {
            if (item.getText().trim().equals(expectedTextItem))
            {
            	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            	jsExecutor.executeScript("argument[0].scrollIntoView(true);", item);
            	sleepInSecond(1);
                item.click();
                break;
            }
        }

    }
	
	
	protected String getElementAttribute(WebDriver driver, String locatorType, String attributeName)
	{
		return getElement(driver, locatorType).getAttribute(attributeName);
	}
	protected String getElementAttribute(WebDriver driver, String locatorType, String attributeName, String...dynamicValues)
	{
		locatorType = String.format(locatorType, (Object[]) dynamicValues);
		return getElement(driver, locatorType).getAttribute(attributeName);
	}
	
	protected String getElementCssValue(WebDriver driver, String locatorType, String propertyName)
	{
		return getElement(driver, locatorType).getCssValue(propertyName);
	}
	protected String getHexaColorFromRGBA (String rgbaValue)
	{
		return Color.fromString(rgbaValue).asHex();
	}
	protected int getElementSize(WebDriver driver, String locatorType)
	{
		return getElements(driver, locatorType).size();
	}
	protected int getElementSize(WebDriver driver, String locatorType, String...dynamicValues)
	{
		locatorType = String.format(locatorType,(Object[]) dynamicValues);
		return getElements(driver, locatorType).size();
	}
	
	protected void checkToDefaultCheckboxRadio(WebDriver driver, String locatorType)
	{
		WebElement element = getElement(driver, locatorType);
		if (!element.isSelected())
		{
			element.click();
		}
	}
	protected void checkToDefaultCheckboxRadio(WebDriver driver, String locatorType, String...dynamicValues)
	{
		locatorType = String.format(locatorType,(Object[]) dynamicValues);
		WebElement element = getElement(driver, locatorType);
		if (!element.isSelected())
		{
			element.click();
		}
	}
	protected void uncheckToDefaultCheckbox(WebDriver driver, String locatorType)
	{
		WebElement element = getElement(driver, locatorType);
		if (element.isSelected())
		{
			element.click();
		}
	}
	protected Boolean isElementDisplayed(WebDriver driver, String locatorType)
	{
		return getElement(driver, locatorType).isDisplayed();
	}
	public boolean isElementUndisplayed(WebDriver driver, String locatorType) {
		overrideGlobalTimeout(driver, GlobalConstants.getGloabalConstant().getShortTimeout());
		List<WebElement> elements = getElements(driver, locatorType);
		overrideGlobalTimeout(driver, GlobalConstants.getGloabalConstant().getLongTimeout());
		if(elements.size()==0)
		{
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed())
		{
			return true;
		} else return false;
	}
	public boolean isElementUndisplayed(WebDriver driver, String locatorType, String...dynamicValues) {
		locatorType = String.format(locatorType,(Object[]) dynamicValues);
		overrideGlobalTimeout(driver, GlobalConstants.getGloabalConstant().getShortTimeout());
		List<WebElement> elements = getElements(driver, locatorType);
		overrideGlobalTimeout(driver, GlobalConstants.getGloabalConstant().getLongTimeout());
		if(elements.size()==0)
		{
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed())
		{
			return true;
		} else return false;
	}
	protected Boolean isElementDisplayed(WebDriver driver, String locatorType, String...dynamicValues)
	{
		locatorType = String.format(locatorType,(Object[]) dynamicValues);
		return getElement(driver, locatorType).isDisplayed();
	}
	protected Boolean isElementEnabled(WebDriver driver, String locatorType)
	{
		return getElement(driver, locatorType).isEnabled();
	}
	protected Boolean isElementSelected(WebDriver driver, String locatorType)
	{
		return getElement(driver, locatorType).isSelected();
	}
	protected void switchToFrameIframe(WebDriver driver, String locatorType)
	{
		driver.switchTo().frame(getElement(driver, locatorType));
	}
	protected void switchToDefaultContent(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	protected void hoverMouseToElement (WebDriver driver, String locatorType)
	{
		Actions action = new Actions(driver);
		action.moveToElement(getElement(driver, locatorType)).perform();
	}
	protected void pressKeyToElement (WebDriver driver, String locatorType, Keys key)
	{
		Actions action = new Actions(driver);
		action.sendKeys(getElement(driver, locatorType),key).perform();
	}
	protected void pressKeyToElement (WebDriver driver, String locatorType, Keys key, String...dynamicValues)
	{
		Actions action = new Actions(driver);
		locatorType = String.format(locatorType,(Object[]) dynamicValues);
		action.sendKeys(getElement(driver, locatorType),key).perform();
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

    protected void hightlightElement(WebDriver driver, String locatorType) {
        WebElement element = getElement(driver, locatorType);
        String originalStyle = getElementAttribute(driver, locatorType, "style");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }
    protected void hightlightElement(WebDriver driver, String locatorType, String...dynamicValues) 
    {
    	locatorType = String.format(locatorType,(Object[]) dynamicValues);
        WebElement element = getElement(driver, locatorType);
        String originalStyle = getElementAttribute(driver, locatorType, "style");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    protected void clickToElementByJS(WebDriver driver, String locatorType) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getElement(driver, locatorType));
    }
    protected void clickToElementByJS(WebDriver driver, String locatorType, String...dynamicValues) 
    {
    	locatorType = String.format(locatorType,(Object[]) dynamicValues);
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getElement(driver, locatorType));
    }

    protected void scrollToElementOnTop(WebDriver driver, String locatorType) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locatorType));
    }

    protected void scrollToElementOnDown(WebDriver driver, String locatorType) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement(driver, locatorType));
    }

    protected void sendkeyToElementByJS(WebDriver driver, String locatorType, String value) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locatorType));
    }

    protected void removeAttributeInDOM(WebDriver driver, String locatorType, String attributeRemove) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locatorType));
    }

    protected String getElementValidationMessage(WebDriver driver, String locatorType) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, locatorType));
    }

    protected boolean isImageLoaded(WebDriver driver, String locatorType) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        boolean status = (boolean) jsExecutor.executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
                getElement(driver, locatorType));
        return status;
    }
    protected boolean isImageLoaded(WebDriver driver, String locatorType, String...dynamicValues) 
    {
    	locatorType = String.format(locatorType,(Object[]) dynamicValues);
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        boolean status = (boolean) jsExecutor.executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
                getElement(driver, locatorType));
        return status;
    }
    public void overrideGlobalTimeout(WebDriver driver, long timeOut)
    {
    	driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
    }
    protected void waitForElementUndisplayed(WebDriver driver, String locatorType)
    {
    	WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
    	overrideGlobalTimeout(driver, GlobalConstants.getGloabalConstant().getShortTimeout());
    	explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
    	overrideGlobalTimeout(driver, GlobalConstants.getGloabalConstant().getLongTimeout());
    }
    protected void waitForElementVisible(WebDriver driver, String locatorType)
    {
    	WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
    	explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
    }
    protected void waitForElementVisible(WebDriver driver, String locatorType, String...dynamicValues)
    {
    	locatorType = String.format(locatorType,(Object[]) dynamicValues);
    	WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
    	explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
    }

    protected void waitForAllElementVisible(WebDriver driver, String locatorType)
    {
    	WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
    	explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
    }
    protected void waitForElementInVisible(WebDriver driver, String locatorType)
    {
    	WebDriverWait explicitWait = new WebDriverWait(driver,longTimeOut);
    	explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
    }
    protected void waitForElementInVisible(WebDriver driver, String locatorType, String...dynamicValues)
    {
    	locatorType = String.format(locatorType, (Object[])dynamicValues);
    	WebDriverWait explicitWait = new WebDriverWait(driver,longTimeOut);
    	explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
    }

    protected void waitForAllElementInVisible(WebDriver driver, String locatorType)
    {
    	WebDriverWait explicitWait = new WebDriverWait(driver,longTimeOut);
    	explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getElements(driver, locatorType)));
    }
    protected void waitForElementClickable(WebDriver driver, String locatorType)
    {
    	WebDriverWait explicitWait = new WebDriverWait(driver,longTimeOut);
    	explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
    }
    protected void waitForElementClickable(WebDriver driver, String locatorType, String...dynamicValues)
    {
    	locatorType = String.format(locatorType, (Object[])dynamicValues);
    	WebDriverWait explicitWait = new WebDriverWait(driver,longTimeOut);
    	explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
    }

    public void uploadMultipleFiles(WebDriver driver, String...fileNames)
    {
    	String filePath = GlobalConstants.getGloabalConstant().getUploadFile();
    	String fullFileName = "";
    	for (String file:fileNames)
    	{
    		fullFileName = fullFileName + filePath + file + "\n";
    	}
    	fullFileName = fullFileName.trim();
    	getElement(driver, BasePageUI.UPLOAD_FILE).sendKeys(fullFileName);
    }
    public void sleepInSecond(long timeInSecond)
    {
        try{
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    private long longTimeOut = GlobalConstants.getGloabalConstant().getLongTimeout();
}

