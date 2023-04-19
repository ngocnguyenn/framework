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

import PageUIsNopCommerce.BasePageUI;
import pageObjectsNopCommerce.AddressPageObject;
import pageObjectsNopCommerce.BackInStockSubPageObject;
import pageObjectsNopCommerce.DownloadablePageObject;
import pageObjectsNopCommerce.MyProductReviewPageObject;
import pageObjectsNopCommerce.ChangePasswordPageObject;
import pageObjectsNopCommerce.CustomerInforPageObject;
import pageObjectsNopCommerce.OrdersPageObject;
import pageObjectsNopCommerce.PageGeneratorManager;
import pageObjectsNopCommerce.RewardPointPageObject;

public class BasePage {
	public static BasePage getBasePageObject()
	{
		return new BasePage();
	}
	public CustomerInforPageObject openCustomerInforPage(WebDriver driver)
	{
		waitForElementClickable(driver,BasePageUI.CUSTOMER_INFOR_LINK);
		clickToElement(driver,BasePageUI.CUSTOMER_INFOR_LINK);
		return PageGeneratorManager.getCustomerInforPageObject(driver);
	}
	public AddressPageObject openAddressPage(WebDriver driver)
	{
		waitForElementClickable(driver,BasePageUI.ADDRESS_LINK);
		clickToElement(driver, BasePageUI.ADDRESS_LINK);
		return PageGeneratorManager.getAddressPageObject(driver);
	}
	public OrdersPageObject openOrdersPage(WebDriver driver)
	{
		waitForElementClickable(driver,BasePageUI.ORDERS_LINK);
		clickToElement(driver, BasePageUI.ORDERS_LINK);
		return PageGeneratorManager.getOrdersPageObject(driver);
	}
	public DownloadablePageObject openDownloadablePage(WebDriver driver)
	{
		waitForElementClickable(driver,BasePageUI.DOWNLOADABLE_PRODUCT_LINK);
		clickToElement(driver, BasePageUI.DOWNLOADABLE_PRODUCT_LINK);
		return PageGeneratorManager.getDownloadablePageObject(driver);
	}
	public BackInStockSubPageObject openBackInStockSubPage(WebDriver driver)
	{
		waitForElementClickable(driver,BasePageUI.BACKINSTOCKSUB_LINK);
		clickToElement(driver, BasePageUI.BACKINSTOCKSUB_LINK);
		return PageGeneratorManager.getBackInStockSubPageObject(driver);
	}
	public RewardPointPageObject openRewardPointPage(WebDriver driver)
	{
		waitForElementClickable(driver,BasePageUI.REWARD_POINT_LINK);
		clickToElement(driver, BasePageUI.REWARD_POINT_LINK);
		return PageGeneratorManager.getRewardPointPageObject(driver);
	}
	public ChangePasswordPageObject openChangePasswordPage(WebDriver driver)
	{
		waitForElementClickable(driver,BasePageUI.CHANGE_PASSWORD_LINK);
		clickToElement(driver, BasePageUI.CHANGE_PASSWORD_LINK);
		return PageGeneratorManager.getOpenChangePasswordPageObject(driver);
	}
	public MyProductReviewPageObject openMyProductReviewPage(WebDriver driver)
	{
		waitForElementClickable(driver,BasePageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, BasePageUI.MY_PRODUCT_REVIEW_LINK);
		return PageGeneratorManager.getMyProductReviewPageObject(driver);
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
	
	private By getByXpath(String locator)
	{
		return By.xpath(locator);
	}
	
	private WebElement getElement (WebDriver driver, String xpathLocator)
	{
		return driver.findElement(getByXpath(xpathLocator));
	}
	
	private List<WebElement> getElements (WebDriver driver, String xpathLocator)
	{
		return driver.findElements(getByXpath(xpathLocator));
	}
	
	protected void clickToElement(WebDriver driver, String xpathLocator)
	{
		getElement(driver, xpathLocator).click();
	}
	
	protected void sendKeyToElement (WebDriver driver, String xpathLocator, String textValue)
	{
		getElement(driver, xpathLocator).clear();
		getElement(driver, xpathLocator).sendKeys(textValue);
	}
	
	protected String getElementText(WebDriver driver, String xpathLocator)
	{
		return getElement(driver, xpathLocator).getText();
	}
	
	protected void selectItemInDefaultDropDown (WebDriver driver, String xpathLocator, String textItem)
	{
		Select select = new Select(getElement(driver, xpathLocator));
		select.selectByValue(textItem);
	}
	
	protected String getSelectedItemDefaultDropDown(WebDriver driver, String xpathLocator)
	{
		Select select = new Select(getElement(driver, xpathLocator));
		return select.getFirstSelectedOption().getText();
	}
	
	protected Boolean isDropDownMultiple(WebDriver driver, String xpathLocator)
	{
		Select select = new Select(getElement(driver, xpathLocator));
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
	
	
	protected String getElementAttribute(WebDriver driver, String xpathLocator, String attributeName)
	{
		return getElement(driver, xpathLocator).getAttribute(attributeName);
	}
	
	protected String getElementCssValue(WebDriver driver, String xpathLocator, String propertyName)
	{
		return getElement(driver, xpathLocator).getCssValue(propertyName);
	}
	protected String getHexaColorFromRGBA (String rgbaValue)
	{
		return Color.fromString(rgbaValue).asHex();
	}
	protected int getElementSize(WebDriver driver, String xpathLocator)
	{
		return getElements(driver, xpathLocator).size();
	}
	
	protected void checkToDefaultCheckboxRadio(WebDriver driver, String xpathLocator)
	{
		WebElement element = getElement(driver, xpathLocator);
		if (!element.isSelected())
		{
			element.click();
		}
	}
	protected void uncheckToDefaultCheckbox(WebDriver driver, String xpathLocator)
	{
		WebElement element = getElement(driver, xpathLocator);
		if (element.isSelected())
		{
			element.click();
		}
	}
	protected Boolean isElementDisplayed(WebDriver driver, String xpathLocator)
	{
		return getElement(driver, xpathLocator).isDisplayed();
	}
	protected Boolean isElementEnabled(WebDriver driver, String xpathLocator)
	{
		return getElement(driver, xpathLocator).isEnabled();
	}
	protected Boolean isElementSelected(WebDriver driver, String xpathLocator)
	{
		return getElement(driver, xpathLocator).isSelected();
	}
	protected void switchToFrameIframe(WebDriver driver, String xpathLocator)
	{
		driver.switchTo().frame(getElement(driver, xpathLocator));
	}
	protected void switchToDefaultContent(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	protected void hoverMouseToElement (WebDriver driver, String xpathLocator)
	{
		Actions action = new Actions(driver);
		action.moveToElement(getElement(driver, xpathLocator)).perform();
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

    protected void hightlightElement(WebDriver driver, String xpathLocator) {
        WebElement element = getElement(driver, xpathLocator);
        String originalStyle = getElementAttribute(driver, xpathLocator, "style");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    protected void clickToElementByJS(WebDriver driver, String xpathLocator) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getElement(driver, xpathLocator));
    }

    protected void scrollToElementOnTop(WebDriver driver, String xpathLocator) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, xpathLocator));
    }

    protected void scrollToElementOnDown(WebDriver driver, String xpathLocator) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement(driver, xpathLocator));
    }

    protected void sendkeyToElementByJS(WebDriver driver, String xpathLocator, String value) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, xpathLocator));
    }

    protected void removeAttributeInDOM(WebDriver driver, String xpathLocator, String attributeRemove) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, xpathLocator));
    }

    protected String getElementValidationMessage(WebDriver driver, String xpathLocator) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, xpathLocator));
    }

    protected boolean isImageLoaded(WebDriver driver, String xpathLocator) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        boolean status = (boolean) jsExecutor.executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
                getElement(driver, xpathLocator));
        return status;
    }
    
    protected void waitForElementVisible(WebDriver driver, String xpathLocator)
    {
    	WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
    	explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
    }

    protected void waitForAllElementVisible(WebDriver driver, String xpathLocator)
    {
    	WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
    	explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
    }
    protected void waitForElementInVisible(WebDriver driver, String xpathLocator)
    {
    	WebDriverWait explicitWait = new WebDriverWait(driver,longTimeOut);
    	explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
    }

    protected void waitForAllElementInVisible(WebDriver driver, String xpathLocator)
    {
    	WebDriverWait explicitWait = new WebDriverWait(driver,longTimeOut);
    	explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getElements(driver, xpathLocator)));
    }
    protected void waitForElementClickable(WebDriver driver, String xpathLocator)
    {
    	WebDriverWait explicitWait = new WebDriverWait(driver,longTimeOut);
    	explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
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
    private long longTimeOut = 30;
}

