package userloveAdmin.Smoke;

import java.sql.Driver;
import java.time.Duration;
import java.util.Properties;

import javax.swing.text.Document;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import commonLibs.implementation.ScreenshotControl;
import commonLibs.utils.WaitUtils;

public class Smoke extends BasePage {

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

	private WebDriver myVariable;
	boolean elementVisiables;
	// Logic layer - what we perform step by step

	@FindBy(xpath = "/html/body/div/div/div/div[2]/div/div[2]/form/div[1]/div/div/input")
	private WebElement email;

	@FindBy(xpath = "/html/body/div/div/div/div[2]/div/div[2]/form/div[2]/div/div/input")
	private WebElement pwd;

	@FindBy(xpath = "/html/body/div/div/div/div[2]/div/div[2]/form/button")
	private WebElement userButton;

	@FindBy(xpath = "/html/body/div/div/div[1]/div[2]/button/div[2]/span[2]")
	private WebElement loggedinUserEmailatProfile;

	@FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div[2]/div[1]")
	private WebElement l;

	@FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div[1]/div/div[1]/div/div[1]")

	private WebElement DashboardLabel;

	@FindBy(xpath = "/html/body/div/div/div[2]/div[1]/div/div/div[1]/a[4]")
	private WebElement SurveyPageLink;

	@FindBy(xpath = "/html/body/div/div/div[2]/div[1]/div/div/div[1]/a[3]")
	private WebElement ChecklistPageLink;

	@FindBy(xpath = "/html/body/div/div/div[2]/div[1]/div/div/div[1]/a[2]")
	private WebElement TourPageLink;

	@FindBy(xpath = "/html/body/div/div/div[2]/div[1]/div/div/div[1]/a[5]")
	private WebElement UserPageLink;

	@FindBy(xpath = "/html/body/div/div/div[2]/div[1]/div/div/div[1]/a[6]")
	private WebElement EventPageLink;

	@FindBy(xpath = "/html/body/div/div/div[2]/div[1]/div/div/div[1]/a[7]")
	private WebElement ThemePageLink;

	@FindBy(xpath = "/html/body/div/div/div[2]/div[1]/div/div/div[2]/a")
	private WebElement SettingPageLink;

	@FindBy(xpath = "/html/body/div[1]/div/div[1]/div[2]/button[2]/div[2]")
	private WebElement ProfileLink;

	@FindBy(xpath = "/html/body/div[2]/div[3]/div/button/span[1]")
	private WebElement LogoutLink;

	// --------------------------create
	// survey-----------------------------------------
	@FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[1]/button")
	private WebElement createsurveybtn;

	@FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[1]/div/div[4]/p[2]")
	private WebElement addscratchbtn;

	@FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[1]/div/div[1]/div[1]/div/div/input")
	private WebElement surveynametextbox;

	@FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[1]/div/div[3]/button")
	private WebElement addQuestionbutton;

	@FindBy(xpath = "/html/body/div[2]/div[3]/div[1]")
	private WebElement surveytemplate1;

	@FindBy(xpath = "/html/body/div[2]/div[3]/div[2]")
	private WebElement surveytemplate2;

	@FindBy(xpath = "/html/body/div[2]/div[3]/div[3]")
	private WebElement surveytemplate3;

	@FindBy(xpath = "/html/body/div[2]/div[3]/div[4]")
	private WebElement surveytemplate4;

	@FindBy(xpath = "/html/body/div[2]/div[3]/div[5]")
	private WebElement surveytemplate5;

	@FindBy(xpath = "/html/body/div[2]/div[3]/div[6]")
	private WebElement surveytemplate6;

	@FindBy(xpath = "/html/body/div[2]/div[3]/div[7]")
	private WebElement surveytemplate7;

	@FindBy(xpath = "/html/body/div[2]/div[3]/div[8]")
	private WebElement surveytemplate8;

	@FindBy(xpath = "/html/body/div[2]/div[3]/div[9]")
	private WebElement surveytemplate9;
	
	@FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[1]/div/div[2]/div[9]/div/div/div/div/div/div/div/div/div[3]/div/div[3]/div[1]/div[1]/div/input")
	private WebElement Targeturl;

	@FindBy(xpath = "/html/body/div[2]/div[3]/div[10]")
	private WebElement surveytemplate10;

	@FindBy(xpath = "/html/body/div[2]/div[3]/div[11]")
	private WebElement surveytemplate11;

	@FindBy(xpath = "/html/body/div[2]/div[3]/div[12]")
	private WebElement surveytemplate12;

	
	@FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[2]/div/div/div[3]/button")
	private WebElement continueBTN;
	
	
	public Smoke(WebDriver driver) {
		super(driver); // make it super due to BasePage class have also same parameterized constructor
						// overloaded
		PageFactory.initElements(driver, this); // static method takes the driver instance of the given class and the
												// class type, and returns a Page Object with its fields fully
												// initialized
		myVariable = driver;

	}

	public void userLogin(String username, String password) throws Exception {
		// this is logic layer for login functionality
		// pass values to element to controls which we created to perform

		WaitUtils.waitForSeconds(1);
		elementControl.setText(email, username);
		elementControl.setText(pwd, password);
		WaitUtils.waitForSeconds(2);

		elementControl.clickElement(userButton);
		WaitUtils.waitForSeconds(8);

		elementVisiables = elementControl.isElementVisiable(DashboardLabel);
		System.out.println("elementVisiables" + elementVisiables);

		if (elementVisiables = true) {
			javascriptControl.scrollToElement(l);
			WaitUtils.waitForSeconds(3);

		}

		System.out.println("page getCurrentUrl" + myVariable.getTitle()); // Userlove | Dashboard

	}

	public String verifyLoggedInUserEmailatProfile() throws Exception {
		WaitUtils.waitForSeconds(1);
		return loggedinUserEmailatProfile.getText();
	}

//----------------------------SURVEY CODE------------------------------------------

	public void Survey() throws Exception {

		elementControl.clickElement(SurveyPageLink);
		WaitUtils.waitForSeconds(3);
		javascriptControl.scrollToElement(l);
		WaitUtils.waitForSeconds(1);

	}

	public String SurveyPageTitle() throws Exception {
		return myVariable.getTitle();
	}

	public void CreateSuvey() throws Exception {
		WaitUtils.waitForSeconds(1);
		elementControl.clickElement(createsurveybtn);
		WaitUtils.waitForSeconds(5);
		elementControl.clickElement(addscratchbtn);
		WaitUtils.waitForSeconds(2);
		surveynametextbox.clear();

		WaitUtils.waitForSeconds(2);
		surveynametextbox.sendKeys(Keys.CONTROL, "a");
		elementControl.setText(surveynametextbox, "Survey 12 template");
		WaitUtils.waitForSeconds(1);
		elementControl.clickElement(addQuestionbutton);
		elementControl.clickElement(surveytemplate1);
		WaitUtils.waitForSeconds(1);
		elementControl.clickElement(addQuestionbutton);
		elementControl.clickElement(surveytemplate2);
		WaitUtils.waitForSeconds(1);
		elementControl.clickElement(addQuestionbutton);
		elementControl.clickElement(surveytemplate3);
		WaitUtils.waitForSeconds(1);
		elementControl.clickElement(addQuestionbutton);
		elementControl.clickElement(surveytemplate4);
		WaitUtils.waitForSeconds(1);
		elementControl.clickElement(addQuestionbutton);
		elementControl.clickElement(surveytemplate5);
		WaitUtils.waitForSeconds(1);
		elementControl.clickElement(addQuestionbutton);
		elementControl.clickElement(surveytemplate6);
		WaitUtils.waitForSeconds(1);
		elementControl.clickElement(addQuestionbutton);
		elementControl.clickElement(surveytemplate7);
		WaitUtils.waitForSeconds(1);
		elementControl.clickElement(addQuestionbutton);
		elementControl.clickElement(surveytemplate8);
		WaitUtils.waitForSeconds(1);
		elementControl.clickElement(addQuestionbutton);
		elementControl.clickElement(surveytemplate9);
		WaitUtils.waitForSeconds(1);
		elementControl.setText(Targeturl, "https://www.userlove.io");
		WaitUtils.waitForSeconds(1);
		elementControl.clickElement(addQuestionbutton);
		elementControl.clickElement(surveytemplate10);
		WaitUtils.waitForSeconds(1);
		elementControl.clickElement(addQuestionbutton);
		elementControl.clickElement(surveytemplate11);
		WaitUtils.waitForSeconds(1);
		elementControl.clickElement(addQuestionbutton);
		elementControl.clickElement(surveytemplate12);
		WaitUtils.waitForSeconds(5);
		
		elementControl.clickElement(continueBTN);

		WaitUtils.waitForSeconds(5);
	}

//---------------------------------------------------------------------------------

	public void Checklist() throws Exception {

		elementControl.clickElement(ChecklistPageLink);
		WaitUtils.waitForSeconds(8);
		javascriptControl.scrollToElement(l);
		WaitUtils.waitForSeconds(1);
	}

	public String ChecklistPageTitle() throws Exception {
		return myVariable.getTitle();
	}

	// ---------------------------Tour------------------------------------------------

	public void Tour() throws Exception {

		elementControl.clickElement(TourPageLink);
		WaitUtils.waitForSeconds(8);
		javascriptControl.scrollToElement(l);
		WaitUtils.waitForSeconds(1);

	}

	public String TourPageTitle() throws Exception {
		return myVariable.getTitle();
	}

	// -----------------------------------------------------------------------------------

	public void User() throws Exception {
		elementControl.clickElement(UserPageLink);
		WaitUtils.waitForSeconds(8);
		javascriptControl.scrollToElement(l);
		WaitUtils.waitForSeconds(1);

	}

	public String UsersPageTitle() throws Exception {
		return myVariable.getTitle();
	}

	// ---------------Events--------------------------------------------------------------
	public void Event() throws Exception {
		elementControl.clickElement(EventPageLink);
		WaitUtils.waitForSeconds(8);
		javascriptControl.scrollToElement(l);
		WaitUtils.waitForSeconds(1);

	}

	public String EventsPageTitle() throws Exception {
		return myVariable.getTitle();
	}

	// ------------------------------------------------------------------------------------

	public void Theme() throws Exception {
		elementControl.clickElement(ThemePageLink);
		WaitUtils.waitForSeconds(10);

	}

	public String ThemePageTitle() throws Exception {
		return myVariable.getTitle();
	}

	public void Setting() throws Exception {
		elementControl.clickElement(SettingPageLink);
		WaitUtils.waitForSeconds(8);

	}

	public String ProfilePageTitle() throws Exception {
		return myVariable.getTitle();
	}

	public void Logout() throws Exception {
		elementControl.clickElement(ProfileLink);
		WaitUtils.waitForSeconds(3);
		elementControl.clickElement(LogoutLink);
		WaitUtils.waitForSeconds(10);

	}

}
