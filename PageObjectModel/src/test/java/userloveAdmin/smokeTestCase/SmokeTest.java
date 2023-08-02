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
		String loggedinEmail = configProperties.getProperty("afterloginprofiletext");

		Boolean result = verifyLoggedInUserEmailatProfile.equals(loggedinEmail);

		extentTest.log(Status.INFO, "UserEmail is -" + loggedinEmail);
		extentTest.log(Status.INFO, "after loggedIn profile text/email is -" + verifyLoggedInUserEmailatProfile);
		extentTest.log(Status.INFO, "Matching is  -" + result);

		System.out.println("verifyLoggedInUserEmailatProfile  " + verifyLoggedInUserEmailatProfile);
		System.out.println("loggedinEmail  " + loggedinEmail);
		System.out.println("result  " + result);
		Assert.assertTrue(result);

	}

	// ----------------------------SURVEY
	// CODE------------------------------------------

	@Test(priority = 1)
	public void verifySureyPage() throws Exception {

		extentTest = extent.createTest("verify Survey page & Title");
		extentTest.log(Status.INFO, "Start Testcase verify Survey page & Title");

		homePage.Survey();

		String SurveyPageTitle = homePage.SurveyPageTitle();
		Boolean result = SurveyPageTitle.equals(configProperties.getProperty("SurveyPageTitle"));

		extentTest.log(Status.INFO,
				"Survey Page Title is - " + SurveyPageTitle + "  & matching with expected is  -" + result);

		Assert.assertTrue(result);

	}
	// -----------------------------------------------------------------------------------

//	@Test(priority = 2)
//	public void verifyChecklistPage() throws Exception {
//
//		extentTest = extent.createTest("verify Checklist page & Title");
//		extentTest.log(Status.INFO, "Start Testcase verify Checklist page & Title");
//
//		homePage.Checklist();
//
//		String ChecklistPageTitle = homePage.ChecklistPageTitle();
//		Boolean result = ChecklistPageTitle.equals(configProperties.getProperty("ChecklistPageTitle"));
//
//		extentTest.log(Status.INFO,
//				"Checklist Page Title is - " + ChecklistPageTitle + "  & matching with expected is  -" + result);
//
//		Assert.assertTrue(result);
//
//	}
//
//	@Test(priority = 3)
//	public void verifyTourPage() throws Exception {
//		extentTest = extent.createTest("verify Tour page & Title");
//		extentTest.log(Status.INFO, "Start Testcase verify Tour page & Title");
//
//		homePage.Tour();
//
//		String TourPageTitle = homePage.TourPageTitle();
//		Boolean result = TourPageTitle.equals(configProperties.getProperty("TourPageTitle"));
//
//		extentTest.log(Status.INFO,
//				"Tour Page Title is - " + TourPageTitle + "  & matching with expected is  -" + result);
//
//		Assert.assertTrue(result);
//	}
//
//	@Test(priority = 4)
//	public void verifyUserPage() throws Exception {
//
//		extentTest = extent.createTest("verify Users page & Title");
//		extentTest.log(Status.INFO, "Start Testcase verify Users page & Title");
//
//		homePage.User();
//
//		String UsersPageTitle = homePage.UsersPageTitle();
//		Boolean result = UsersPageTitle.equals(configProperties.getProperty("UsersPageTitle"));
//
//		extentTest.log(Status.INFO,
//				"Users Page Title is - " + UsersPageTitle + "  & matching with expected is  -" + result);
//
//		Assert.assertTrue(result);
//
//	}
//
//	@Test(priority = 5)
//	public void verifyEventPage() throws Exception {
//		extentTest = extent.createTest("verify Event page & Title");
//		extentTest.log(Status.INFO, "Start Testcase verify Event page & Title");
//
//		homePage.Event();
//
//		String EventsPageTitle = homePage.EventsPageTitle();
//		Boolean result = EventsPageTitle.equals(configProperties.getProperty("EventsPageTitle"));
//
//		extentTest.log(Status.INFO,
//				"Users Page Title is - " + EventsPageTitle + "  & matching with expected is  -" + result);
//
//		Assert.assertTrue(result);
//
//	}
//
//	@Test(priority = 6)
//	public void verifyThemePage() throws Exception {
//		extentTest = extent.createTest("verify Theme page & Title");
//		extentTest.log(Status.INFO, "Start Testcase verify Theme page & Title");
//
//		homePage.Theme();
//
//		String ThemePageTitle = homePage.ThemePageTitle();
//		Boolean result = ThemePageTitle.equals(configProperties.getProperty("ThemePageTitle"));
//
//		extentTest.log(Status.INFO,
//				"Theme Page Title is - " + ThemePageTitle + "  & matching with expected is  -" + result);
//
//		Assert.assertTrue(result);
//
//	}
//
//	@Test(priority = 7)
//	public void verifySettingPage() throws Exception {
//		extentTest = extent.createTest("verify Setting/Profile page & Title");
//		extentTest.log(Status.INFO, "Start Testcase verify profile page & Title");
//
//		homePage.Setting();
//
//		String ProfilePageTitle = homePage.ProfilePageTitle();
//		Boolean result = ProfilePageTitle.equals(configProperties.getProperty("ProfilePageTitle"));
//
//		extentTest.log(Status.INFO,
//				"Theme Profile Title is - " + ProfilePageTitle + "  & matching with expected is  -" + result);
//
//		Assert.assertTrue(result);
//
//	}
	@Test(priority = 7)
	public void verifySettingPage() throws Exception {
		extentTest = extent.createTest("verify Logout");
		extentTest.log(Status.INFO, "Start Testcase verify Logout");

		homePage.Logout();	

	}
}
