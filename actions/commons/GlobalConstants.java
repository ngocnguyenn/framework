package commons;

import java.io.File;

import lombok.Getter;
@Getter
public class GlobalConstants {
	
	private static GlobalConstants globalConstant;
	private GlobalConstants() {
		
	}
	public synchronized static GlobalConstants getGloabalConstant() {
		if(globalConstant == null)
		{
			globalConstant = new GlobalConstants();
		}
		return globalConstant;
	}
	
	private final String projectPath = System.getProperty("user.dir");
	private final String osName = System.getProperty("os.name");
	private final String javaVersion = System.getProperty("java.version");
	private final String uploadFile = projectPath + File.separator + "uploadFiles" + File.separator;
	private final String reportingScreenshot = projectPath + File.separator + "reportNGImages" + File.separator;
	private final String downloadFile = projectPath + File.separator + "downloadFiles";
	private final String browserLog = projectPath + File.separator + "browserLogs";
	private final String dragDropHtml5 = projectPath + File.separator + "browserLogs";
	private final String autoITScript= projectPath + File.separator + "autoIT";
	
	private final String dbDevURL = "32.18.64:145";
	private final String dbDevUser = "automation";
	private final String dbDevPass = "12345678";
	private final String dbTestURL = "32.18.64:145";
	private final String dbTestUser = "automation";
	private final String dbTestPass = "12345678";
	
	private final long shortTimeout = 5;
	private final long longTimeout = 30;
	private final long retryTestFail = 3;
	
	
	private final String browserUsername = "ngcnguyn_641Sxt";
	private final String browserAccessKey = "cqcuXBox4QtDbyd3Yjut";
	private final String browserStackUrl = "http://" + browserUsername + ":" + browserAccessKey + "@hub-cloud.browserstack.com/wd/hub";
	
	private final String sauceUsername = "";
	private final String sauceAutomateKey = "";
	private final String sauceUrl = "https://" + sauceUsername + ":" + sauceAutomateKey + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
	
	private final String lambdaUsername = "";
	private final String lambdaAccessKey = "";
	private final String lambdaUrl = "https://" + lambdaUsername + ":" + lambdaAccessKey + "@hub.lambdatest.com/wd/hub";
}
