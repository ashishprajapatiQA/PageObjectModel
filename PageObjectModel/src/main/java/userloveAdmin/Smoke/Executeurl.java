package userloveAdmin.Smoke;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Executeurl {
	public static void main(String[] args) throws InterruptedException {
		String url = "https://uzera.netlify.app/"; // Change your URL here
		// String url = "https://test-project-rouge-one.vercel.app/"; // Change your URL

		// Repeat 10 times
		for (int i = 1; i <= 300; i++) {
			// Setup ChromeDriver
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();

			options.addArguments("--start-maximized");

			WebDriver driver = new ChromeDriver(options);

			driver.get(url);

			Thread.sleep(1000);

			// Smooth scroll step by step
			JavascriptExecutor js = (JavascriptExecutor) driver;
			long scrollHeight = (Long) js.executeScript("return document.body.scrollHeight");

			for (int pos = 0; pos < scrollHeight; pos += 250) { // scroll 250px each step
				js.executeScript("window.scrollTo(0, arguments[0]);", pos);
				Thread.sleep(200); // delay between scrolls for smooth effect
			}

			// Wait 3 seconds at bottom
			Thread.sleep(6000);

			driver.quit();
			System.out.println("Run " + i + " completed.");

			// Odd/even logic
			if (i % 2 == 0) {
				// even → open url1
			} else {
				// odd → open url2
			}

		}
	}
}
