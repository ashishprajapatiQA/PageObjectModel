package uzera.login;

import java.util.Properties;
import java.util.stream.Stream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
// import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import commonLibs.implementation.ScreenshotControl;
import commonLibs.utils.ConfigFileUtils;
import commonLibs.utils.DateUtils;
import commonLibs.utils.WaitUtils;

public class LoginPage extends BasePage {

	// configuration file data fetch
	static String configFileName;
	static Properties configProperties;
	static String currentWorkingDirectory;
	static String executionStartDate;

	// reports
//	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest extentTest;

	String reportFilename;

	ScreenshotControl screenshotControl;

	private WebDriver mydriver;
	// Logic layer - what we perform step by step

	@FindBy(xpath = "//input[@placeholder='you@company.com']")
	private WebElement email;

	@FindBy(xpath = "//input[@placeholder='Enter your password']")
	private WebElement pwd;

	@FindBy(xpath = "//button[contains(text(), 'Sign in')]")
	private WebElement userButton;

	@FindBy(xpath = "/html/body/div/div/div[1]/div[2]/button/div[2]/span[2]")
	private WebElement loggedinUserEmailatProfile;

	@FindBy(xpath = "//h1[contains(text(), 'Welcome back')]")
	private WebElement loginPageText;
	
	@FindBy(linkText = "Invalid email or password.")
	private WebElement Invalidcredential;

	@FindBy(xpath = "/html/body/div/div/div/div[2]/div[2]/div/div[1]/form/div[2]/div[2]/p")
	private WebElement noexistscredential;

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

	public LoginPage(WebDriver driver) {
		super(driver); // make it super due to BasePage class have also same parameterized constructor
						// overloaded
		PageFactory.initElements(driver, this); // static method takes the driver instance of the given class and the
												// class type, and returns a Page Object with its fields fully
												// initialized
		mydriver = driver;

	}

	public WebDriver returndriver() throws Exception {
		return mydriver;
	}

	// this is logic layer for login functionality
	// pass values to element to controls which we created to perform

	// Login page checks Pre-condition code
	public boolean isLoginPageDisplayed() throws Exception {

		WaitUtils.waitForSeconds(1);
		return elementControl.isElementVisiable(loginPageText);
	}

	// Login via valid credential code section

	public void userName(String username) throws Exception {

		WaitUtils.waitForSeconds(1);
		elementControl.setText(email, username);

	}

	public void passWord(String password) throws Exception {

		elementControl.setText(pwd, password);
		WaitUtils.waitForSeconds(2);

	}

	public void signIN() throws Exception {

		elementControl.clickElement(userButton);
		WaitUtils.waitForSeconds(10);

	}

	// Login via Invalid credential code section

	public boolean DuetoInvalidCredentialLoginWithOtpLinkcome() throws Exception {
		
	//	Invalidcredential.isDisplayed() ||
	
		return  noexistscredential.isDisplayed();
		
		
	}

}
