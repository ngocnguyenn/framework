package reportConfigs;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import commons.GlobalConstants;

public class ExtentManager {
	public static final ExtentReports extentReports = new ExtentReports();

	public synchronized static ExtentReports createExtentReports() {
		ExtentSparkReporter reporter = new ExtentSparkReporter(GlobalConstants.getGloabalConstant().getProjectPath() + "/extentV5/ExtentReport.html");
		reporter.config().setReportName("NopCommerce HTML Report");
		reporter.config().setDocumentTitle("NopCommerce HTML Report");
		reporter.config().setTimelineEnabled(true);
		reporter.config().setEncoding("utf-8");
		reporter.config().setTheme(Theme.DARK);

		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("Learn", "Automation FC");
		extentReports.setSystemInfo("Project", "NopCommerce");
		extentReports.setSystemInfo("Team", "Basus VN");
		extentReports.setSystemInfo("JDK version", GlobalConstants.getGloabalConstant().getJavaVersion());
		return extentReports;
	}
}
