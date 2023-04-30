package pageUIsJQueryScript;

public class TablePageUI {

	public static final String PAGINATION_BY_PAGE_NUMBER_LINK = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String PAGINATION_PAGE_ACTIVED_BY_NUMBER_LINK = "xpath=//li[@class='qgrd-pagination-page']/a[@class='qgrd-pagination-page-link active' and text() = '%s']";
	public static final String DYNAMIC_TEXTBOX = "xpath=//div[@class='qgrd-header-text' and text() = '%s']/parent::div/following-sibling::input";
	public static final String ALL_ROW_EACH_PAGE = "xpath=//tbody/tr";
	public static final String TOTAL_PAGINATION = "css=ul[class='qgrd-pagination-ul']>li[class='qgrd-pagination-page']";
	public static final String PAGINATION_BY_PAGE_INDEX = "xpath=//ul[@class='qgrd-pagination-ul']/li[@class='qgrd-pagination-page'][%s]/a";
	public static final String TEXTBOX_BY_INDEX_ROW_AND_COMLUMN = "xpath=//td[@id='tblAppendGrid_$rowNum_%s']//following-sibling::td[%s]/input";
	public static final String COUNTRY_DROPDOWN = "xpath=//td[@id='tblAppendGrid_$rowNum_%s']//following-sibling::td[%s]//select";
	public static final String NPO_CHECKBOX = "xpath=//td[@id='tblAppendGrid_$rowNum_%s']//following-sibling::td[%s]//input";
	public static final String BUTTON_BY_FUNCTION_AND_INDEX_ROW = "xpath=//button[@id='tblAppendGrid_$%s_%s']";
}
