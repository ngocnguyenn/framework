package pageObjectsJQueryScript.uploadFiles;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIsJQueryScript.HomePageUIuploadFiles;

public class HomePageObject extends BasePage{
	WebDriver driver;
	public HomePageObject (WebDriver driver)
	{
		this.driver = driver;
	}
	public boolean isFileLoadedByName(String fileNames) {
		waitForElementVisible(driver, HomePageUIuploadFiles.FILE_NAME_LOADED, fileNames);
		return isElementDisplayed(driver, HomePageUIuploadFiles.FILE_NAME_LOADED, fileNames);
	}
	public void clickToStartButton() {
		List<WebElement> startButtons = getElements(driver, HomePageUIuploadFiles.START_BUTTON);
		for (WebElement startButton : startButtons)
		{
			startButton.click();
			sleepInSecond(2);
		}
	}
	public boolean isFileLinkUploaded(String fileNames) {
		waitForElementVisible(driver, HomePageUIuploadFiles.FILE_NAME_UPLOADED_LINK, fileNames);
		return isElementDisplayed(driver, HomePageUIuploadFiles.FILE_NAME_UPLOADED_LINK, fileNames);
	}
	public boolean isFileImageUploaded(String fileNames) {
		waitForElementVisible(driver, HomePageUIuploadFiles.FILE_NAME_UPLOADED_IMAGE, fileNames);
		return isImageLoaded(driver, HomePageUIuploadFiles.FILE_NAME_UPLOADED_IMAGE, fileNames);
	}
}
