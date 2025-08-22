package userloveAdmin.Smoke;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Random;

public class InjectUzeraJS {
	public static void main(String[] args) throws InterruptedException {

		for (int i = 1; i <= 5; i++) {
			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");

			WebDriver driver = new ChromeDriver(options);
			driver.get("https://test-project-rouge-one.vercel.app/"); // change URL to your site

			Thread.sleep(3000);
			// ===== Generate random data =====
			Random rand = new Random();
			String randomId = "user-" + rand.nextInt(100000);
			String randomName = "User" + rand.nextInt(1000);
			String randomEmail = "user" + rand.nextInt(10000) + "@example.com";

			// ===== Build JS string =====
			String script = "uzera(\"identify\", {" + "  id: \"" + randomId + "\"," + "  userData: {" + "    name: \""
					+ randomName + "\"," + "    email: \"" + randomEmail + "\"" + "  }" + "});"
					+ "console.log('Injected identify() for " + randomEmail + "');";

			// ===== Execute JS in browser =====
			((JavascriptExecutor) driver).executeScript(script);
			System.out.println("Run " + i + " executed with: " + randomEmail);
			Thread.sleep(3000);
			driver.quit();

		}

	}
}
