package userloveAdmin.loginTestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class LoginWithINVALIDCredential extends BaseTest {
// Here is we write the Test cases & pass value to logic layer(here all steps defined just need values) 
	@Test(priority = 0)
	public void verifyUserloginwithINVALIDCredentials() throws Exception {
		// TC00
		extentTest = extent.createTest("TC-00 - verify Userlogin with Invalid credentials");
		extentTest.log(Status.INFO, "Start Testcase - TC-00 - verify Userlogin with Invalid credentials "); // report
																												// log
		String username = configProperties.getProperty("InvaliduserEmailId");
		extentTest.log(Status.INFO, "User Email-id -" + username);
		String password = configProperties.getProperty("InvaliduserPassword");
		extentTest.log(Status.INFO, "User Password -" + password);

		homePage.userLogin(username, password);// this pass value to logic layer page

		Boolean result = homePage.DuetoInvalidCredentialForgottpwdLinkcome();
		System.out.println("result " + result);
		if (result = true) {
			extentTest.log(Status.INFO, "UserEmail is -" + username);
			extentTest.log(Status.INFO, "password is -" + password);
			extentTest.log(Status.INFO, "Matching is  -" + result);

			extentTest.log(Status.INFO, "User Login via Invalid credential Successfully ");
		}

		Assert.assertTrue(result);

	}

}
