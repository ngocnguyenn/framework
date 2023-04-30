package learn.jqueryscript;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjectsJQueryScript.TablePageObject;

public class Level_11_Handle_Table_II extends BaseTest{
	private WebDriver driver;
	private TablePageObject tablePage;
	@Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
		String envName = "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/";
		driver = getBrowserDriver(browserName, envName);
		tablePage = new TablePageObject(driver);
	}

	@Test
	public void TC_01_Add_Data_In_Table()
	{
		tablePage.inputToCompanyTextbox("Super", "1");
		tablePage.inputToContactPersonTextbox("Junior", "1");
		tablePage.selectValueAtCountryDropDown("Hong Kong", "1");
		tablePage.checkAtNPOCheckbox("1");
		tablePage.inputToOrderPlacedTextbox("10", "1");
		tablePage.selectMemberSinceDatetimePicker("03/19/1996", "1");
		
		tablePage.inputToCompanyTextbox("Super2", "2");
		tablePage.inputToContactPersonTextbox("Junior2", "2");
		tablePage.selectValueAtCountryDropDown("Germany", "2");
		tablePage.checkAtNPOCheckbox("2");
		tablePage.inputToOrderPlacedTextbox("11", "2");
		tablePage.selectMemberSinceDatetimePicker("11/06/2005", "2");
		
		tablePage.inputToCompanyTextbox("Super3", "3");
		tablePage.inputToContactPersonTextbox("Junior3", "3");
		tablePage.selectValueAtCountryDropDown("Malaysia", "3");
		tablePage.checkAtNPOCheckbox("3");
		tablePage.inputToOrderPlacedTextbox("1", "3");
		tablePage.selectMemberSinceDatetimePicker("11/06/2006", "3");
	}
	@Test
	public void TC_02_Click_Button()
	{
		tablePage.inserRowAbove("2");
		tablePage.removeCurrentRow("1");
		tablePage.moveUp("2");
		tablePage.moveDown("3");
	}
	@AfterClass
    public void afterClass()
    {
    	driver.close();
    }
}
