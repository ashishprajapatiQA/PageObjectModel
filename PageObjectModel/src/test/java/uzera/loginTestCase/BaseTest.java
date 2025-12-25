package uzera.loginTestCase;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
 //import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import commonLibs.implementation.CommonDriver;
import commonLibs.implementation.ScreenshotControl;
import commonLibs.utils.ConfigFileUtils;
import commonLibs.utils.DateUtils;
import uzera.login.LoginPage;

public class BaseTest {

	// Initialize home page like basic thing driver, url,browser type , open/close
	// (everytimee je basic details repeat/reuse/required karvani hoy te )
	// browser

	CommonDriver cmnDriver;
	String browserType;
	String baseUrl;
	LoginPage homePage;
	private WebDriver driver;

	// configuration file data fetch
	static String configFileName;
	static Properties configProperties;
	static String currentWorkingDirectory;
	static String executionStartDate;

	int pageloadtimeout;
	int elementDetectionTimeout;

	// reports
	// public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest extentTest;

	String reportFilename;

	String screenshotFilename;
	ScreenshotControl screenshotControl;
	
	public static Logger logger;
	
	

	static {

		try {
			// configuration file access code
			currentWorkingDirectory = System.getProperty("user.dir");
			executionStartDate = DateUtils.getCurrentDateAndTime();
			configFileName = String.format("%s/config/config.properties", currentWorkingDirectory);
			configProperties = ConfigFileUtils.readProperties(configFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@BeforeSuite
	public void preSetup() {

		initializeReports();

	}

	@BeforeClass
	public void setup() throws Exception {

		invokeBrowser();
		getDriverInstance();
		initializeApplicationPages();
		initializeScreenshotVariable();

	}

	@AfterClass
	public void cleanUp() throws Exception {
		closeAllBrowserInstances();

	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception {
		String testcaseName = result.getName();

		String screenShoFilename = String.format("%s/screenshot/%s-%s.jpeg", currentWorkingDirectory, testcaseName,
				executionStartDate);

		if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, "Test case pass " + testcaseName);
			screenshotControl.captureAndSaveScreenshot(screenShoFilename);
			extentTest.addScreenCaptureFromPath(screenShoFilename);

		} else if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(Status.FAIL, "Test case fail " + testcaseName);
			screenshotControl.captureAndSaveScreenshot(screenShoFilename);
			extentTest.addScreenCaptureFromPath(screenShoFilename);

		} else {
			extentTest.log(Status.SKIP, "Test case skipped " + testcaseName);
			screenshotControl.captureAndSaveScreenshot(screenShoFilename);
			extentTest.addScreenCaptureFromPath(screenShoFilename);

		}
	}

	@AfterSuite
	public void postCleanUp() {
		extent.flush();
	}

	private void initializeReports() {
		// TODO Auto-generated method stub
		// report code
		reportFilename = String.format("%s/reports/UserLoveAdminLogin-%s.html", currentWorkingDirectory,
				executionStartDate);
		//htmlReporter = new ExtentHtmlReporter(reportFilename);
		ExtentSparkReporter spark = new ExtentSparkReporter(reportFilename);
		extent = new ExtentReports();
		// extent.attachReporter(htmlReporter);
		extent.attachReporter(spark);

	}

	private void invokeBrowser() throws Exception {

		logger = Logger.getLogger("Userlove");
		PropertyConfigurator.configure("log4J.properties");
		
		
		browserType = configProperties.getProperty("browserType");
		cmnDriver = new CommonDriver(browserType);

		pageloadtimeout = Integer.parseInt(configProperties.getProperty("pageloadTimeout"));
		elementDetectionTimeout = Integer.parseInt(configProperties.getProperty("elementDetectionTimeout"));

		cmnDriver.setPageloadTimeout(pageloadtimeout);
		cmnDriver.setElementDetectionTimeout(elementDetectionTimeout);

		baseUrl = configProperties.getProperty("baseUrl");

		cmnDriver.navigateToUrl(baseUrl);
	}

	private void getDriverInstance() throws Exception {
		driver = cmnDriver.getDriver();
		

	}

	private void initializeApplicationPages() {

		homePage = new LoginPage(driver);
	}

	private void initializeScreenshotVariable() {
		screenshotControl = new ScreenshotControl(driver); // we need driver instance for it so we declare here

	}

	private void closeAllBrowserInstances() throws Exception {
		cmnDriver.closeAllBrowser();

	}
}
