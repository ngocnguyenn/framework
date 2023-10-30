package commons;

import java.io.File;

public class GlobalConstants {
	public static final String USER_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com/";
	
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String JAVA_VERSION = System.getProperty("java.version");
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String REPORTING_SCREENSHOT = PROJECT_PATH + File.separator + "reportNGImages" + File.separator;
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs";
	public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "browserLogs";
	public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator + "autoIT";
	
	public static final String DB_DEV_URL = "32.18.64:145";
	public static final String DB_DEV_USER = "automation";
	public static final String DB_DEV_PASS = "12345678";
	public static final String DB_TEST_URL = "32.18.64:145";
	public static final String DB_TEST_USER = "automation";
	public static final String DB_TEST_PASS = "12345678";
	
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;
	public static final long RETRY_TEST_FAIL = 3;
	
	
	public static final String BROWSER_USERNAME = "ngcnguyn_641Sxt";
	public static final String BROWSER_ACCESS_KEY = "cqcuXBox4QtDbyd3Yjut";
	public static final String BROWSER_STACK_URL = "http://" + BROWSER_USERNAME + ":" + BROWSER_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	public static final String SAUCE_USERNAME = "";
	public static final String SAUCE_AUTOMATE_KEY = "";
	public static final String SAUCE_URL = "https://" + SAUCE_USERNAME + ":" + SAUCE_AUTOMATE_KEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
	
	public static final String LAMBDA_USERNAME = "";
	public static final String LAMBDA_ACCESS_KEY = "";
	public static final String LAMBDA_URL = "https://" + LAMBDA_USERNAME + ":" + LAMBDA_ACCESS_KEY + "@hub.lambdatest.com/wd/hub";
}
