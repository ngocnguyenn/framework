package learn.jqueryscript;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.JQueryScript.dataTable.HomePageObject;

public class Level_10_Handle_Table_I extends BaseTest{
	private WebDriver driver;
	private HomePageObject tablePage;
	@Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
		String envName = "https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/";
		driver = getBrowserDriver(browserName, envName);
		tablePage = new HomePageObject(driver);
	}

	@Test
	public void TC_01_Pagination()
	{
		tablePage.paginationByPageNumber(driver, "10");
		Assert.assertTrue(tablePage.isPageNumberActive(driver, "10"));
		tablePage.paginationByPageNumber(driver, "2");
		Assert.assertTrue(tablePage.isPageNumberActive(driver, "2"));
		tablePage.paginationByPageNumber(driver, "8");
		Assert.assertTrue(tablePage.isPageNumberActive(driver, "8"));
		tablePage.paginationByPageNumber(driver, "3");
		Assert.assertTrue(tablePage.isPageNumberActive(driver, "3"));
		tablePage.paginationByPageNumber(driver, "5");
		Assert.assertTrue(tablePage.isPageNumberActive(driver, "5"));
		tablePage.paginationByPageNumber(driver, "6");
		Assert.assertTrue(tablePage.isPageNumberActive(driver, "6"));
	}
	@Test
	public void TC_02_Filter_By_Column()
	{
		tablePage.refreshPage(driver);
		tablePage.inputToFemalesNumberTextbox( "384187");
		tablePage.inputToCountryTextbox("Afghanistan");
		tablePage.inputToMalesNumberTextbox("407124");
		tablePage.inputToTotalNumberTextbox("791312");
	}
	
	@Test
	public void getValueAtRowAllPage()
	{
		tablePage.getValueEachRowAtAllPage();
	}
	@AfterClass
    public void afterClass()
    {
    	driver.close();
    }
}
