package userloveAdmin.login;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import commonLibs.implementation.ScreenshotControl;
import commonLibs.utils.WaitUtils;

public class LoginPage extends BasePage {

	// configuration file data fetch
	static String configFileName;
	static Properties configProperties;
	static String currentWorkingDirectory;
	static String executionStartDate;

	// reports
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest extentTest;

	String reportFilename;

	ScreenshotControl screenshotControl;
	
	private WebDriver mydriver;
	// Logic layer - what we perform step by step

	@FindBy(xpath = "/html/body/div/div/div/div[2]/div/div[2]/form/div[1]/div/div/input")
	private WebElement email;

	@FindBy(xpath = "/html/body/div/div/div/div[2]/div/div[2]/form/div[2]/div/div/input")
	private WebElement pwd;

	@FindBy(xpath = "/html/body/div/div/div/div[2]/div/div[2]/form/button")
	private WebElement userButton;

	@FindBy(xpath = "/html/body/div/div/div[1]/div[2]/button/div[2]/span[2]")
	private WebElement loggedinUserEmailatProfile;

	@FindBy(xpath = "/html/body/div/div/div/div[2]/div/div[2]/form/div[3]/p")
	private WebElement ForgotPassLink;

	public LoginPage(WebDriver driver) {
		super(driver); // make it super due to BasePage class have also same parameterized constructor
						// overloaded
		PageFactory.initElements(driver, this); // static method takes the driver instance of the given class and the
												// class type, and returns a Page Object with its fields fully
												// initialized
		mydriver = driver;
	}

	public void userLogin(String username, String password) throws Exception {
		// this is logic layer for login functionality
		// pass values to element to controls which we created to perform

		WaitUtils.waitForSeconds(1);
		elementControl.setText(email, username);
		elementControl.setText(pwd, password);
		WaitUtils.waitForSeconds(2);

		elementControl.clickElement(userButton);
		WaitUtils.waitForSeconds(10);

	}

	public String verifyLoggedInUserEmailatProfile() throws Exception {
		WaitUtils.waitTillElementVisiable(mydriver,loggedinUserEmailatProfile,Duration.ofMillis(10000));
		WaitUtils.waitForSeconds(2);
		return loggedinUserEmailatProfile.getText();
	}

	public boolean DuetoInvalidCredentialForgottpwdLinkcome() throws Exception {
		boolean isElementTrue = ForgotPassLink.isDisplayed() && ForgotPassLink.isEnabled();
		return isElementTrue;
	}

}
