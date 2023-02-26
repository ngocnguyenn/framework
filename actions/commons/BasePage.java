package commons;



import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	public void openPageUrl(WebDriver driver, String pageUrl)
	{
		driver.get("pageUrl");
	}

	public String getTitle(WebDriver driver )
	{
		return driver.getTitle();
	}
	
	public String getCurrentUrl (WebDriver driver)
	{
		return driver.getCurrentUrl();
	}
	public String getPageSource (WebDriver driver)
	{
		return driver.getPageSource();
	}
	
	public void backToPage (WebDriver driver)
	{
		driver.navigate().back();
	}
	public void forwardToPage (WebDriver driver)
	{
		driver.navigate().forward();
	}
	
	public void refreshPage (WebDriver driver)
	{
		driver.navigate().refresh();
	}
	
	public Alert waitAlertPresence(WebDriver driver)
	{
		WebDriverWait explicitWait = new WebDriverWait (driver, 30);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void acceptAlert(WebDriver driver)
	{
		Alert alert = waitAlertPresence(driver);
		alert.accept();
	}
	
	public void cancelAlert(WebDriver driver)
	{
		waitAlertPresence(driver).dismiss();
	}
	
	public String getAlertText(WebDriver driver)
	{
		return waitAlertPresence(driver).getText();
	}
	
	public void sendkeyToAlert (WebDriver driver, String textValue)
	{
		waitAlertPresence(driver).sendKeys(textValue);
	}
	
	public void closeAllWindowWithoutCurrentID(WebDriver driver, String parentID)
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
	
	public void switchToWindowByTitle(WebDriver driver, String expectedTitle)
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
	
	public void switchToWindowByID (WebDriver driver, String currentID)
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
	
	public By getByXpath(String locator)
	{
		return By.xpath(locator);
	}
	
	public WebElement getElement (WebDriver driver, String xpathLocator)
	{
		return driver.findElement(getByXpath(xpathLocator));
	}
	
	public List<WebElement> getElements (WebDriver driver, String xpathLocator)
	{
		return driver.findElements(getByXpath(xpathLocator));
	}
	
	public void clickToElement(WebDriver driver, String xpathLocator)
	{
		getElement(driver, xpathLocator).click();
	}
	
	public void sendKeyToElement (WebDriver driver, String xpathLocator, String textValue)
	{
		getElement(driver, xpathLocator).clear();
		getElement(driver, xpathLocator).sendKeys(textValue);
	}
	
	public String getElementText(WebDriver driver, String xpathLocator)
	{
		return getElement(driver, xpathLocator).getText();
	}
	
	public void selectItemInDefaultDropDown (WebDriver driver, String xpathLocator, String textItem)
	{
		Select select = new Select(getElement(driver, xpathLocator));
		select.selectByValue(textItem);
	}
	
	public String getSelectedItemDefaultDropDown(WebDriver driver, String xpathLocator)
	{
		Select select = new Select(getElement(driver, xpathLocator));
		return select.getFirstSelectedOption().getText();
	}
	
	public Boolean isDropDownMultiple(WebDriver driver, String xpathLocator)
	{
		Select select = new Select(getElement(driver, xpathLocator));
		return select.isMultiple();
	}
	
	public void selectIteminCustomDropdown(WebDriver driver, String parentXpath, String childXpath, String expectedTextItem)
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
	
	
	public String getElementAttribute(WebDriver driver, String xpathLocator, String attributeName)
	{
		return getElement(driver, xpathLocator).getAttribute(attributeName);
	}
	
	public String getElementCssValue(WebDriver driver, String xpathLocator, String propertyName)
	{
		return getElement(driver, xpathLocator).getCssValue(propertyName);
	}
	public String getHexaColorFromRGBA (String rgbaValue)
	{
		return Color.fromString(rgbaValue).asHex();
	}
	public int getElementSize(WebDriver driver, String xpathLocator)
	{
		return getElements(driver, xpathLocator).size();
	}
	
	public void checkToDefaultCheckboxRadio(WebDriver driver, String xpathLocator)
	{
		WebElement element = getElement(driver, xpathLocator);
		if (!element.isSelected())
		{
			element.click();
		}
	}
	public void uncheckToDefaultCheckbox(WebDriver driver, String xpathLocator)
	{
		WebElement element = getElement(driver, xpathLocator);
		if (element.isSelected())
		{
			element.click();
		}
	}
	public Boolean isElementDisplayed(WebDriver driver, String xpathLocator)
	{
		return getElement(driver, xpathLocator).isDisplayed();
	}
	public Boolean isElementEnabled(WebDriver driver, String xpathLocator)
	{
		return getElement(driver, xpathLocator).isEnabled();
	}
	public Boolean isElementSelected(WebDriver driver, String xpathLocator)
	{
		return getElement(driver, xpathLocator).isSelected();
	}
	public void switchToFrameIframe(WebDriver driver, String xpathLocator)
	{
		driver.switchTo().frame(getElement(driver, xpathLocator));
	}
	public void switchToDefaultContent(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	public void hoverMouseToElement (WebDriver driver, String xpathLocator)
	{
		Actions action = new Actions(driver);
		action.moveToElement(getElement(driver, xpathLocator)).perform();
	}
	
	public Object executeForBrowser(WebDriver driver, String javaScript) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return jsExecutor.executeScript(javaScript);
    }

    public String getInnerText(WebDriver driver) 
    {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
    }

    public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage(WebDriver driver) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void navigateToUrlByJS(WebDriver driver, String url) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.location = '" + url + "'");
    }

    public void hightlightElement(WebDriver driver, String xpathLocator) {
        WebElement element = getElement(driver, xpathLocator);
        String originalStyle = getElementAttribute(driver, xpathLocator, "style");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String xpathLocator) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getElement(driver, xpathLocator));
    }

    public void scrollToElementOnTop(WebDriver driver, String xpathLocator) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, xpathLocator));
    }

    public void scrollToElementOnDown(WebDriver driver, String xpathLocator) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement(driver, xpathLocator));
    }

    public void sendkeyToElementByJS(WebDriver driver, String xpathLocator, String value) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, xpathLocator));
    }

    public void removeAttributeInDOM(WebDriver driver, String xpathLocator, String attributeRemove) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, xpathLocator));
    }

    public String getElementValidationMessage(WebDriver driver, String xpathLocator) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, xpathLocator));
    }

    public boolean isImageLoaded(WebDriver driver, String xpathLocator) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        boolean status = (boolean) jsExecutor.executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
                getElement(driver, xpathLocator));
        return status;
    }
    
    public void waitForElementVisible(WebDriver driver, String xpathLocator)
    {
    	WebDriverWait explicitWait = new WebDriverWait(driver,30);
    	explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
    }

    public void waitForAllElementVisible(WebDriver driver, String xpathLocator)
    {
    	WebDriverWait explicitWait = new WebDriverWait(driver,30);
    	explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
    }
    public void waitForElementInVisible(WebDriver driver, String xpathLocator)
    {
    	WebDriverWait explicitWait = new WebDriverWait(driver,30);
    	explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
    }

    public void waitForAllElementInVisible(WebDriver driver, String xpathLocator)
    {
    	WebDriverWait explicitWait = new WebDriverWait(driver,30);
    	explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getElements(driver, xpathLocator)));
    }
    public void waitForElementClickable(WebDriver driver, String xpathLocator)
    {
    	WebDriverWait explicitWait = new WebDriverWait(driver,30);
    	explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
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
}

