package uzera.loginTestCase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commonLibs.utils.WaitUtils;

public class LoginWithValidCredential extends BaseTest {

	public void takeScreenshot(String customName) throws Exception {
		String screenshotPath = String.format("%s/screenshot/%s-%s.jpeg", BaseTest.currentWorkingDirectory, customName,
				BaseTest.executionStartDate);
		screenshotControl.captureAndSaveScreenshot(screenshotPath);
		extentTest.addScreenCaptureFromPath(screenshotPath);
	}

	@Test(priority = 1,groups = { "smoke" })
	public void testLoginPageDisplayed() throws Exception {
		extentTest = extent.createTest("check preconditions");
		boolean isDisplayed = homePage.isLoginPageDisplayed();
		Assert.assertTrue(isDisplayed, "Login page is displayed");
		if (isDisplayed) {
			extentTest.log(Status.INFO, "Login Page is displayed  -" + isDisplayed);
	
		} else {

			extentTest.log(Status.FAIL, "Login Page is not displayed" + isDisplayed);
		}
	}
	
	
	
	@Test(priority = 2, groups = { "smoke" })
	public void verifyUserloginwithINVALIDCredentials() throws Exception {
		
		logger.info("Url is opened -verifyUserloginwithINVALIDCredentials");
		
		extentTest = extent.createTest("TC-002 - verify Userlogin with Invalid credentials");
		extentTest.log(Status.INFO, "Verify Userlogin with Invalid credentials "); // report
																												// log
		String username = "Test@gmail.com";
		extentTest.log(Status.INFO, "User Email-id -" + username);

		String password = "Test@12345";

		extentTest.log(Status.INFO, "User Password -" + password);

		homePage.userName(username);// this pass value to logic layer page
		takeScreenshot("Invalid-UserName");
		homePage.passWord(password);// this pass value to logic layer page
		takeScreenshot("Invalid-Password");
		homePage.signIN();// this pass value to logic layer page

		Boolean result = homePage.DuetoInvalidCredentialLoginWithOtpLinkcome();
		
		Assert.assertTrue(result);
		
		logger.info("INVALID" + result);

		if (result) {
				extentTest.log(Status.INFO, "Invalid credential rejected - User remained on login page" + result);
		}else {
			extentTest.log(Status.INFO, "Invalid credential rejected not working - User not remained on login page" + result);
		}

	}
	
	
	

	// Here is we write the Test cases & pass value to logic layer(here all steps
	// defined just need values)
	@Test(priority = 3, groups = { "smoke" })
	public void verifyUserloginwithcorrectCredentials() throws Exception {
		// TC001

		WebDriver driver = homePage.returndriver();
		
		driver.navigate().refresh();
		
		 WaitUtils.waitForSeconds(2);
		logger.info("Url is opened -verifyUserloginwithcorrectCredentials");

		extentTest = extent.createTest("verify Userlogin with correct credentials");

		String username = configProperties.getProperty("userEmailId");
		String password = configProperties.getProperty("userPassword");
		extentTest.log(Status.INFO, "User Email-id -" + username + " User Password -" + password);

	
		homePage.userName(username);// this pass value to logic layer page
		takeScreenshot("UserName");
		homePage.passWord(password);// this pass value to logic layer page
		takeScreenshot("Password");
		homePage.signIN();// this pass value to logic layer page

		takeScreenshot("SignIn Click");

		

		Boolean result = driver.getPageSource().contains(configProperties.getProperty("afterloginprofiletext"));
		Assert.assertTrue(result);
		
		
		if (result) {
			extentTest.log(Status.PASS, "User Login Successfully");
		} else {
			extentTest.log(Status.FAIL, "User Login  Failed");
		}

	}
	
	
	

}
