package userloveAdmin.smokeTestCase;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class SmokeTest extends BaseTest {
	
	

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
	
	//----------------------------SURVEY CODE------------------------------------------


	@Test(priority = 1)
	public void verifySureyPage() throws Exception {
		
		extentTest = extent.createTest("verify Survey page & Title");
		extentTest.log(Status.INFO, "Start Testcase verify Survey page & Title");

		homePage.Survey();
		
		String SurveyPageTitle = homePage.SurveyPageTitle(); 
		Boolean result = SurveyPageTitle.equals(configProperties.getProperty("SurveyPageTitle"));

		extentTest.log(Status.INFO, "Survey Page Title is - "+ SurveyPageTitle + "  & matching with expected is  -"  + result );

		Assert.assertTrue(result);

	}
	//-----------------------------------------------------------------------------------


	@Test(priority = 2)
	public void verifyChecklistPage() throws Exception {
		
		extentTest = extent.createTest("verify Checklist page & Title");
		extentTest.log(Status.INFO, "Start Testcase verify Checklist page & Title");

		homePage.Checklist();

		String ChecklistPageTitle = homePage.ChecklistPageTitle(); 
		Boolean result = ChecklistPageTitle.equals(configProperties.getProperty("ChecklistPageTitle"));

		extentTest.log(Status.INFO, "Checklist Page Title is - "+ ChecklistPageTitle + "  & matching with expected is  -"  + result );

		Assert.assertTrue(result);

	}
//
//	@Test(priority = 3)
//	public void verifyTourPage() throws Exception {
//		// TC001
//		extentTest = extent.createTest("TC-001 - verify Tour page");
//		extentTest.log(Status.INFO, "Start Testcase - TC-001 -  verify Checklist page ");
//
//		homePage.Tour();
//
//		extentTest.log(Status.INFO, "User Login  Successfully");
//
//		// Assert.assertTrue(result);
//
//	}
//
//	@Test(priority = 4)
//	public void verifyUserPage() throws Exception {
//		// TC001
//		extentTest = extent.createTest("TC-001 - verify User page");
//		extentTest.log(Status.INFO, "Start Testcase - TC-001 -  verify Checklist page ");
//
//		homePage.User();
//
//		extentTest.log(Status.INFO, "User Login  Successfully");
//
//		// Assert.assertTrue(result);
//
//	}
//
//	@Test(priority = 5)
//	public void verifyEventPage() throws Exception {
//		// TC001
//		extentTest = extent.createTest("TC-001 - verify Event page");
//		extentTest.log(Status.INFO, "Start Testcase - TC-001 -  verify Checklist page ");
//
//		homePage.Event();
//
//		extentTest.log(Status.INFO, "User Login  Successfully");
//
//		// Assert.assertTrue(result);
//
//	}
//
//	@Test(priority = 6)
//	public void verifyThemePage() throws Exception {
//		// TC001
//		extentTest = extent.createTest("TC-001 - verify Theme page");
//		extentTest.log(Status.INFO, "Start Testcase - TC-001 -  verify Checklist page ");
//
//		homePage.Theme();
//
//		extentTest.log(Status.INFO, "User Login  Successfully");
//
//		// Assert.assertTrue(result);
//
//	}
//
//	@Test(priority = 7)
//	public void verifySettingPage() throws Exception {
//		// TC001
//		extentTest = extent.createTest("TC-001 - verify Setting page");
//		extentTest.log(Status.INFO, "Start Testcase - TC-001 -  verify Checklist page ");
//
//		homePage.Setting();
//
//		extentTest.log(Status.INFO, "User Login  Successfully");
//
//		// Assert.assertTrue(result);
//
//	}
}
