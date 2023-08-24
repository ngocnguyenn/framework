package pageObjects.SauceDemo.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIsSauceDemo.UserProductPageUI;

public class UserProductPageObject extends BasePage{
	WebDriver driver;
	public UserProductPageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	public void selectItemInSortDropDownByValue(String value) {
		waitForElementClickable(driver, UserProductPageUI.SORT_DROPDOWN);
		selectItemInDefaultDropDown(driver, UserProductPageUI.SORT_DROPDOWN, value);
	}
	public boolean isProductNameSortByAscending() {
		ArrayList<String> productList = new ArrayList<String>();
		
		List<WebElement> productNameList = getElements(driver, UserProductPageUI.PRODUCT_NAME);
		
		for (WebElement productName : productNameList)
		{
			productList.add(productName.getText());
		}
		ArrayList<String> sortedList = new ArrayList<String>();
		for (String product1 : productList)
		{
			sortedList.add(product1);
		}
		Collections.sort(sortedList);
		return sortedList.equals(productList);
	}
	public boolean isProductNameSortByDescending() {
		ArrayList<String> productList = new ArrayList<String>();
		
		List<WebElement> productNameList = getElements(driver, UserProductPageUI.PRODUCT_NAME);
		
		for (WebElement productName : productNameList)
		{
			productList.add(productName.getText());
		}
		ArrayList<String> sortedList = new ArrayList<String>();
		for (String product1 : productList)
		{
			sortedList.add(product1);
		}
		Collections.sort(sortedList);
		Collections.reverse(sortedList);
		return sortedList.equals(productList);
	}
	
}
