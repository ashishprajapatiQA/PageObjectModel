package userloveAdmin.loginTestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class LoginWithValidCredential extends BaseTest {
// Here is we write the Test cases & pass value to logic layer(here all steps defined just need values) 
	@Test(priority = 0)
	public void verifyUserloginwithcorrectCredentials() throws Exception {
		// TC001
		extentTest = extent.createTest("TC-001 - verify Userlogin with correct credentials");
		extentTest.log(Status.INFO, "Start Testcase - TC-001 - verify Userlogin with correct credentials "); // report
																												// log
		String username = configProperties.getProperty("userEmailId");
		extentTest.log(Status.INFO, "User Email-id -" + username);
		String password = configProperties.getProperty("userPassword");
		extentTest.log(Status.INFO, "User Password -" + password);

		homePage.userLogin(username, password);// this pass value to logic layer page
		extentTest.log(Status.INFO, "User Login  Successfully");

		String verifyLoggedInUserEmailatProfile = homePage.verifyLoggedInUserEmailatProfile();
		String loggedinEmail = configProperties.getProperty("userEmailId");

		Boolean result = verifyLoggedInUserEmailatProfile.equals(loggedinEmail);

		extentTest.log(Status.INFO, "UserEmail is -" + loggedinEmail);
		extentTest.log(Status.INFO, "after loggedIn email is -" + verifyLoggedInUserEmailatProfile);
		extentTest.log(Status.INFO, "Matching is  -" + result);

		System.out.println("verifyLoggedInUserEmailatProfile  " + verifyLoggedInUserEmailatProfile);
		System.out.println("loggedinEmail  " + loggedinEmail);
		System.out.println("result  " + result);
		Assert.assertTrue(result);

	}

}
