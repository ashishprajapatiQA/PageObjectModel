package userloveAdmin.loginTestCase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class LoginWithValidCredential extends BaseTest {
// Here is we write the Test cases & pass value to logic layer(here all steps defined just need values) 
	@Test
	public void verifyUserloginwithcorrectCredentials() throws Exception {
		// TC001 

		logger.info("Url is opened -verifyUserloginwithcorrectCredentials");
		
		extentTest = extent.createTest("TC-001 - verify Userlogin with correct credentials");
		extentTest.log(Status.INFO, "Start Testcase - TC-001 - verify Userlogin with correct credentials "); // report
																												// log
		String username = configProperties.getProperty("userEmailId");
		extentTest.log(Status.INFO, "User Email-id -" + username);
		String password = configProperties.getProperty("userPassword");
		extentTest.log(Status.INFO, "User Password -" + password);

		homePage.userLogin(username, password);// this pass value to logic layer page
		extentTest.log(Status.INFO, "User Login  Successfully");

		WebDriver driver = homePage.returndriver();
		
		extentTest.log(Status.INFO, "driver.getTitle();" + driver.getTitle());		

		Boolean result = driver.getPageSource().contains(configProperties.getProperty("afterloginprofiletext"));		
		Assert.assertTrue(result);

	}

}
