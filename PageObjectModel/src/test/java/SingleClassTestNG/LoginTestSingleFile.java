package SingleClassTestNG;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoginTestSingleFile {

	// Single-file TestNG + Selenium + ExtentReports with screenshots (success &
	// failure)
	// How to run (Maven):
	// 1) Add dependencies in your pom.xml:
	//	    - org.seleniumhq.selenium:selenium-java
	//	    - io.github.bonigarcia:webdrivermanager
	//	    - org.testng:testng (scope test)
	//	    - com.aventstack:extentreports
	// 2) Run: mvn -Dbrowser=chrome test
	//
	// Note: Replace the demo URL and locators with your application's login page.

	// Extent
	private static ExtentReports extent;
	private static ExtentTest test;

	// WebDriver
	private WebDriver driver;

	// Config-like fields (inline for single-file demo)
	private final String baseUrl = "https://the-internet.herokuapp.com/login"; // replace with your app URL
	private final String screenshotDir = System.getProperty("user.dir")+"/target/screenshots";
	private final String reportPath = "target/ExtentReport.html";

	// Simple timestamp helper
	private static String ts() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS"));
	}

	// Ensure dirs exist
	private static void ensureDir(String dir) {
		File f = new File(dir);
		if (!f.exists())
			f.mkdirs();
	}

	// Screenshot capture
	private String captureScreenshot(String name) {
		try {
			ensureDir(screenshotDir);
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String path = screenshotDir + "/" + name + "_" + ts() + ".png";
			Files.copy(src.toPath(), new File(path).toPath());
			return path;
		} catch (IOException e) {
			throw new RuntimeException("Screenshot capture failed: " + e.getMessage(), e);
		}
	}

	// Extent init/flush
	@BeforeSuite(alwaysRun = true)
	public void startSuite() {
		ensureDir("target");
		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
		extent = new ExtentReports();

		
		String customCSS = 
			    /* 4 columns with taller images */
			    ".test-contents > .row.mb-3 { " +
			    "   display: inline-block !important; " +
			    "   width: 23% !important; " +
			    "   margin: 5px 1% !important; " +
			    "   vertical-align: top !important; " +
			    "} " +
			    ".test-contents > .row.mb-3 .col-md-3 { " +
			    "   max-width: 100% !important; " +
			    "   width: 100% !important; " +
			    "   flex: none !important; " +
			    "   padding: 0 !important; " +
			    "} " +
			    ".test-contents > .row.mb-3 img { " +
			    "   width: 100% !important; " +
			    "   height: 180px !important; " +
			    "   object-fit: inherit !important; " +
			    "   border-radius: 4px !important; " +
			    "   box-shadow: 0 2px 5px rgba(0,0,0,0.15) !important; " +
			    "}" +
			    ".detail-body img { " +
			    "   padding: 0.5rem  !important; " +
			    "}";
			spark.config().setCss(customCSS);
		extent.attachReporter(spark);
	}

	@AfterSuite(alwaysRun = true)
	public void endSuite() {
		if (extent != null)
			extent.flush();
		System.out.println("Extent report generated at: " + reportPath);
	}

	// WebDriver setup/teardown
	@Parameters({ "browser" })
	@BeforeClass(alwaysRun = true)
	public void setUp(@Optional("chrome") String browser) {
		// Only Chrome for this single-file demo; add branches for other browsers if
		// needed
		if (!"chrome".equalsIgnoreCase(browser)) {
			throw new IllegalArgumentException("Only 'chrome' supported in single-file demo. Received: " + browser);
		}
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-dev-shm-usage", "--no-sandbox");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	// Per-test Extent start/stop and screenshot handling
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Object[] data, java.lang.reflect.Method method) {
		String testName = method.getName();
		test = extent.createTest(testName);
		test.info("Starting test: " + testName);
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		if (result.getStatus() == ITestResult.SUCCESS) {
			String path = captureScreenshot(methodName + "_success");
			test.pass("Test passed").addScreenCaptureFromPath(path);
		} else if (result.getStatus() == ITestResult.FAILURE) {
			String path = captureScreenshot(methodName + "_failure");
			test.fail(result.getThrowable());
			test.addScreenCaptureFromPath(path);
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.skip("Test skipped");
		}
	}

	// Example: Positive login test
	@Test
	public void loginSuccess() {
		test.info("Navigating to: " + baseUrl);
		driver.get(baseUrl);
		test.info("Opened login page");

		// Demo app locators (replace with your app's)
		By username = By.id("username");
		By password = By.id("password");
		By submit = By.cssSelector("button[type='submit']");
		By successBanner = By.id("flash");

		stepScreenshot("login_page_open");

		type(username, "tomsmith", "Enter username");
		type(password, "SuperSecretPassword!", "Enter password");
		click(submit, "Click Login");

		// Assertion
		String banner = driver.findElement(successBanner).getText();
		test.info("Success banner: " + banner);
		stepScreenshot("post_login");

		Assert.assertTrue(banner.contains("You logged into a secure area!"), "Expected success message after login");
	}

	// Example: Negative login test
	@Test
	public void loginFailure() {
		test.info("Navigating to: " + baseUrl);
		driver.get(baseUrl);
		stepScreenshot("login_page_open");

		By username = By.id("username");
		By password = By.id("password");
		By submit = By.cssSelector("button[type='submit']");
		By errorBanner = By.id("flash");

		type(username, "invalid_user", "Enter invalid username");
		type(password, "invalid_pass", "Enter invalid password");
		click(submit, "Click Login");

		String banner = driver.findElement(errorBanner).getText();
		test.info("Error banner: " + banner);
		stepScreenshot("post_login_error");

		Assert.assertTrue(banner.contains("Your username is invalid!"), "Expected invalid username message");
	}

	// Helper: type + log + step screenshot
	private void type(By locator, String value, String label) {
		WebElement el = waitVisible(locator);
		el.clear();
		el.sendKeys(value);
		test.info(label + ": " + value);
		stepScreenshot(label.replace(" ", "_").toLowerCase());
	}

	// Helper: click + log + step screenshot
	private void click(By locator, String label) {
		WebElement el = waitClickable(locator);
		el.click();
		test.info(label);
		stepScreenshot(label.replace(" ", "_").toLowerCase());
	}

	// Simple explicit waits implemented inline for single-file
	private WebElement waitVisible(By locator) {
		int retries = 30; // ~3s with 100ms polling
		int sleepMs = 100;
		for (int i = 0; i < retries; i++) {
			try {
				WebElement el = driver.findElement(locator);
				if (el.isDisplayed())
					return el;
			} catch (NoSuchElementException ignored) {
			}
			sleep(sleepMs);
		}
		String msg = "Element not visible: " + locator;
		test.warning(msg);
		throw new RuntimeException(msg);
	}

	private WebElement waitClickable(By locator) {
		int retries = 30;
		int sleepMs = 100;
		for (int i = 0; i < retries; i++) {
			try {
				WebElement el = driver.findElement(locator);
				if (el.isDisplayed() && el.isEnabled())
					return el;
			} catch (NoSuchElementException ignored) {
			}
			sleep(sleepMs);
		}
		String msg = "Element not clickable: " + locator;
		test.warning(msg);
		throw new RuntimeException(msg);
	}

	private void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ignored) {
		}
	}

	private void stepScreenshot(String name) {
		String path = captureScreenshot(name);
		test.info("Step screenshot: " + name).addScreenCaptureFromPath(path);
	}

}
