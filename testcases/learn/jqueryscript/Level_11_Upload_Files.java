package learn.jqueryscript;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.JQueryScript.uploadFiles.HomePageObject;

public class Level_11_Upload_Files extends BaseTest{
	private WebDriver driver;
	private HomePageObject homePage;

	String beachFileName = "beach.jpg";
	String computerFileName = "computer.jpg";
	String vietnamFileName = "vietnam.jpg";
	String[] multipleFileNames = {beachFileName, computerFileName, vietnamFileName};
	
	@Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = new HomePageObject(driver);
	}

	@Test
	public void TC_01_Upload_One_File_Per_Time()
	{
		homePage.uploadMultipleFiles(driver, beachFileName);
		Assert.assertTrue(homePage.isFileLoadedByName(beachFileName));
		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isFileLinkUploaded(beachFileName));
		Assert.assertTrue(homePage.isFileImageUploaded(beachFileName));
	}
	@Test
	public void TC_02_Upload_Multiple_File_Per_Time()
	{
		homePage.refreshPage(driver);
		homePage.uploadMultipleFiles(driver, multipleFileNames);
		
		Assert.assertTrue(homePage.isFileLoadedByName(beachFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(computerFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(vietnamFileName));
		
		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isFileLinkUploaded(beachFileName));
		Assert.assertTrue(homePage.isFileLinkUploaded(computerFileName));
		Assert.assertTrue(homePage.isFileLinkUploaded(vietnamFileName));

		Assert.assertTrue(homePage.isFileImageUploaded(beachFileName));
		Assert.assertTrue(homePage.isFileImageUploaded(computerFileName));
		Assert.assertTrue(homePage.isFileImageUploaded(vietnamFileName));
	}
	@AfterClass
    public void afterClass()
    {
    	driver.close();
    }
}
