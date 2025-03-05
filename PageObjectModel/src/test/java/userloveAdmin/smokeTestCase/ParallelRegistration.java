package userloveAdmin.smokeTestCase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParallelRegistration {

	private static final String REGISTRATION_URL = "https://userlove.dev/register";

	public static void main(String[] args) {
		// Initialize the user data
		List<UserData> users = new ArrayList<>();

		users.add(new UserData("Aaaa", "ashishprajapati+801@gainserv.com", "Test@123", "comu801"));
		users.add(new UserData("bbbb", "ashishprajapati+802@gainserv.com", "Test@123", "comu802"));
		users.add(new UserData("cccc", "ashishprajapati+803@gainserv.com", "Test@123", "comu803"));
		users.add(new UserData("usdd", "ashishprajapati+804@gainserv.com", "Test@123", "comu804"));
		users.add(new UserData("useeg", "ashishprajapati+805@gainserv.com", "Test@123", "comu805"));
		users.add(new UserData("usffg", "ashishprajapati+806@gainserv.com", "Test@123", "comu806"));
		users.add(new UserData("usggg", "ashishprajapati+807@gainserv.com", "Test@123", "comu807"));
		users.add(new UserData("ushhg", "ashishprajapati+808@gainserv.com", "Test@123", "comu808"));
		users.add(new UserData("usiig", "ashishprajapati+809@gainserv.com", "Test@123", "comu809"));
		users.add(new UserData("usjjg", "ashishprajapati+810@gainserv.com", "Test@123", "comu810"));
		// Register multiple users in parallel
		registerMultipleUsers(users);
	}

	public static void performRegistration(UserData userData) {
		System.setProperty("webdriver.chrome.driver", "./browserDrivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(options);
		// driver.manage().window().maximize();

		try {
			// Open the registration page
			driver.get(REGISTRATION_URL);

			// Wait for the page and network activity to be fully loaded
			//waitForCompletePageLoad(driver);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[2]/form/div[1]/div/div/input")));

			TimeUnit.SECONDS.sleep(3);

			// Fill the registration form (update the locators as per your form structure)
			driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[2]/form/div[1]/div/div/input"))
					.sendKeys(userData.getUsername());
			driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[2]/form/div[2]/div/div/input"))
					.sendKeys(userData.getEmail());
			driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[2]/form/div[3]/div/div/input"))
					.sendKeys(userData.getPassword());

			// Submit the form for next step
			driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[2]/form/button")).click();
			TimeUnit.SECONDS.sleep(10);
			driver.findElement(By.xpath("//*[@id=\":r0:\"]")).sendKeys(userData.getCompany());
			driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/div[2]/form/button")).click();

			TimeUnit.SECONDS.sleep(10);

			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div[2]/form/input[1]"))
					.sendKeys("1");
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div[2]/form/input[2]"))
					.sendKeys("1");
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div[2]/form/input[3]"))
					.sendKeys("1");
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div[2]/form/input[4]"))
					.sendKeys("1");
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div[2]/form/input[5]"))
					.sendKeys("1");
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div[2]/form/input[6]"))
					.sendKeys("1");

			TimeUnit.SECONDS.sleep(2);
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div[2]/button")).click();

			// Simulate waiting for confirmation (customize or replace with WebDriver wait
			// as needed)
			TimeUnit.SECONDS.sleep(10);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}

	public static void registerMultipleUsers(List<UserData> userDataList) {
		// Create a thread pool for parallel execution
		ExecutorService executorService = Executors.newFixedThreadPool(userDataList.size());

		for (UserData user : userDataList) {
			executorService.execute(() -> performRegistration(user));
		}

		// Shutdown the executor and wait for all threads to finish
		executorService.shutdown();
		try {
			executorService.awaitTermination(10, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Method to wait until the page is fully loaded, including network activity
	public static void waitForCompletePageLoad(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Adjust timeout as needed

		// Wait for document.readyState to be 'complete'
		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
				.equals("complete"));

		// Optionally, you can also wait for all network activity to be finished
		wait.until(webDriver -> {
			return ((JavascriptExecutor) webDriver).executeScript(
					"return (window.performance.getEntriesByType('resource').filter(r => r.initiatorType === 'xmlhttprequest').length == 0 && "
							+ "window.performance.getEntriesByType('navigation')[0].responseEnd < performance.now())")
					.equals(true);
		});
	}

}

// Class to store user data
class UserData {
	private String username;
	private String email;
	private String password;
	private String company;

	public UserData(String username, String email, String password, String company) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.company = company;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getCompany() {
		return company;
	}
}
