package userloveAdmin.Smoke;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenrateDynamicResponce {

	public static void CompleteAllResponse() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.manage().window().maximize();

		// Visit the URL
		driver.get("https://test-project-rouge-one.vercel.app/");
		Thread.sleep(5000);

		// ========================================Product
		// tour========================================

		WebElement iframe = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("ul-product-tour-580fcd04-ff7f-4fed-b87f-c6af9ac6f8ba")));
		// Switch to iframe
		driver.switchTo().frame(iframe);

		// Click first button inside modal
		WebElement firstButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
				"#modal-body-main > div.modal-body > div:nth-child(2) > div:nth-child(5) > button:nth-child(1)")));
		firstButton.click();
		Thread.sleep(5000);

		// Switch back and again into iframe
		driver.switchTo().defaultContent();
		driver.switchTo().frame("ul-product-tour-580fcd04-ff7f-4fed-b87f-c6af9ac6f8ba");

		// Click tooltip button
		WebElement tooltipBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
				"#main-tooltip-body > div.gs-tooltip-modal-content > div.tooltip-body > div > div:nth-child(3) > button:nth-child(2)")));
		tooltipBtn.click();
		Thread.sleep(5000);

		// Switch back and into beacon iframe
		driver.switchTo().defaultContent();
		driver.switchTo().frame("ul-beacon-step-86e3f042-a2c1-4731-814b-5c001ac3402f");

		WebElement span = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("span")));
		span.click();

		// Switch back and again into product-tour iframe
		driver.switchTo().defaultContent();
		driver.switchTo().frame("ul-product-tour-580fcd04-ff7f-4fed-b87f-c6af9ac6f8ba");

		WebElement tooltipBtn2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
				"#main-tooltip-body > div.gs-tooltip-modal-content > div.tooltip-body > div > div:nth-child(3) > button:nth-child(2)")));
		tooltipBtn2.click();
		Thread.sleep(5000);

		// =================================== Checklist
		// =======================================================
		driver.switchTo().defaultContent(); // always reset before switching iframe
		driver.switchTo().frame("ul-checklist-7ce498d5-5efb-48bd-924b-b9f27457161d");
		String mainWindow = driver.getWindowHandle();
		// First checklist item
		WebElement item1 = wait.until(
				ExpectedConditions.elementToBeClickable(By.id("checklist_item_deda44ae-9b9d-4ed1-9a04-12486f8d6050")));
		// Remove target attribute so it doesn’t open new tab
		js.executeScript("arguments[0].removeAttribute('target')", item1);
		item1.click();

		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindow)) {
				driver.switchTo().window(handle); // switched to new tab
				// driver.close(); // close new tab
				driver.switchTo().window(mainWindow); // back to main window
			}
		}
		Thread.sleep(5000);

		driver.switchTo().defaultContent();
		driver.switchTo().frame("ul-checklist-7ce498d5-5efb-48bd-924b-b9f27457161d");

		// Second checklist item
		WebElement item2 = wait.until(
				ExpectedConditions.elementToBeClickable(By.id("checklist_item_ff36bdb4-41c7-4d7c-b678-805c823d23f9")));
		js.executeScript("arguments[0].removeAttribute('target')", item2);
		item2.click();

		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindow)) {
				driver.switchTo().window(handle); // switched to new tab
				// driver.close(); // close new tab
				driver.switchTo().window(mainWindow); // back to main window
			}
		}
		Thread.sleep(5000);

		driver.switchTo().defaultContent();
		driver.switchTo().frame("ul-checklist-7ce498d5-5efb-48bd-924b-b9f27457161d");

		// Third checklist item
		WebElement item3 = wait.until(
				ExpectedConditions.elementToBeClickable(By.id("checklist_item_900ab3fe-c245-4b2a-9823-20070ce4e428")));
		js.executeScript("arguments[0].removeAttribute('target')", item3);
		item3.click();

		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindow)) {
				driver.switchTo().window(handle); // switched to new tab
				// driver.close(); // close new tab
				driver.switchTo().window(mainWindow); // back to main window
			}
		}
		Thread.sleep(5000);

		driver.switchTo().defaultContent();

		// =================================== Survey
		// =============================================
		driver.get("https://test-project-rouge-one.vercel.app/about.html");
		Thread.sleep(9000);
		driver.switchTo().frame("ul-nps-00dd194c-57ed-498a-9832-733f2a1dd2ad");
		// List of NPS score selectors
		String[] ids = {
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(1) > div.count-div.ul-nps-score-button",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(2) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(3) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(4) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(5) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(6) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(7) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(8) > div.count-div.ul-nps-score-button",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(9) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(10) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(11) > div.count-div.ul-nps-score-button" };

		// Pick random index
		int randomIndex = (int) (Math.random() * ids.length);
		String randomSelector = ids[randomIndex];
		System.out.println("🎯 Clicking: " + randomIndex + " : random element: " + randomSelector);

		// Switch to iframe

		// Click random NPS score
		WebElement npsBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(randomSelector)));
		npsBtn.click();
		Thread.sleep(5000);

		// Switch to iframe
		driver.switchTo().defaultContent();
		driver.switchTo().frame("ul-nps-00dd194c-57ed-498a-9832-733f2a1dd2ad");
		// Like/Dislike
		String[] likeIDs = { "#like", "#dislike" };
		int randomLikeIndex = (int) (Math.random() * likeIDs.length);
		String randomLikeSelector = likeIDs[randomLikeIndex];
		System.out.println("🎯 Clicking like: " + randomLikeIndex + " : " + randomLikeSelector);

		WebElement likeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(randomLikeSelector)));
		likeBtn.click();
		Thread.sleep(2000);

		// Random string for textarea
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 150; i++) {
			sb.append(chars.charAt((int) (Math.random() * chars.length())));
		}
		String text150 = sb.toString();

		// Enter text into textarea
		WebElement textarea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("textarea")));
		textarea.sendKeys(text150);
		Thread.sleep(2000);

		// Click continue button
		WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("continue-button")));
		continueBtn.click();
		Thread.sleep(5000);

		// Switch to iframe
		driver.switchTo().defaultContent();
		driver.switchTo().frame("ul-nps-00dd194c-57ed-498a-9832-733f2a1dd2ad");

		// CSAT (emoji rating)
		String[] csat = {
				"#nps-container > div:nth-child(2) > div.template-preview-emoji--count > div:nth-child(1) > svg",
				"#nps-container > div:nth-child(2) > div.template-preview-emoji--count > div:nth-child(2) > svg",
				"#nps-container > div:nth-child(2) > div.template-preview-emoji--count > div:nth-child(3) > svg",
				"#nps-container > div:nth-child(2) > div.template-preview-emoji--count > div:nth-child(4) > svg",
				"#nps-container > div:nth-child(2) > div.template-preview-emoji--count > div:nth-child(5) > svg" };
		int randomCSATIndex = (int) (Math.random() * csat.length);
		String randomCSATSelector = csat[randomCSATIndex];
		System.out.println("🎯 Clicking CSAT: " + randomCSATIndex + " : " + randomCSATSelector);

		WebElement csatBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(randomCSATSelector)));
		csatBtn.click();
		Thread.sleep(5000);

		// Switch to iframe
		driver.switchTo().defaultContent();
		driver.switchTo().frame("ul-nps-00dd194c-57ed-498a-9832-733f2a1dd2ad");

		// CES (effort score)
		String[] ces = { "#nps-container > div:nth-child(2) > div.template-preview-emoji--count > div:nth-child(1)",
				"#nps-container > div:nth-child(2) > div.template-preview-emoji--count > div:nth-child(2)",
				"#nps-container > div:nth-child(2) > div.template-preview-emoji--count > div:nth-child(3)",
				"#nps-container > div:nth-child(2) > div.template-preview-emoji--count > div:nth-child(4)",
				"#nps-container > div:nth-child(2) > div.template-preview-emoji--count > div:nth-child(5)" };
		int randomCESIndex = (int) (Math.random() * ces.length);
		String randomCESSelector = ces[randomCESIndex];
		System.out.println("🎯 Clicking CES: " + randomCESIndex + " : " + randomCESSelector);

		WebElement cesBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(randomCESSelector)));
		cesBtn.click();
		Thread.sleep(5000);

		driver.switchTo().defaultContent();

		driver.quit();

	}

	public static void DismissResponse() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.manage().window().maximize();

		driver.get("https://test-project-rouge-one.vercel.app/");
		Thread.sleep(5000);

		WebElement iframe = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("ul-product-tour-580fcd04-ff7f-4fed-b87f-c6af9ac6f8ba")));
		// Switch to iframe
		driver.switchTo().frame(iframe);

		// Click first button inside iframe
		WebElement firstBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"#modal-body-main > div.modal-body > div:nth-child(2) > div:nth-child(5) > button:nth-child(1)")));
		firstBtn.click();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		driver.switchTo().frame("ul-product-tour-580fcd04-ff7f-4fed-b87f-c6af9ac6f8ba");
		// Close button
		WebElement closeBtn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ul-product-tour-close-btn")));
		closeBtn.click();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		driver.switchTo().frame("ul-product-tour-580fcd04-ff7f-4fed-b87f-c6af9ac6f8ba");
		// Dismiss button
		WebElement dismissBtn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#dismiss-button")));
		dismissBtn.click();

		Thread.sleep(5000);
		// Switch back to main page
		driver.switchTo().defaultContent();

		// checklList

		// Switch to checklist iframe
		driver.switchTo().frame("ul-checklist-7ce498d5-5efb-48bd-924b-b9f27457161d");
		String mainWindow = driver.getWindowHandle();

		// Click first checklist item (remove target=_blank)
		WebElement firstItem = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("#checklist_item_deda44ae-9b9d-4ed1-9a04-12486f8d6050")));
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('target');", firstItem);
		firstItem.click();

		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindow)) {
				driver.switchTo().window(handle); // switched to new tab
				// driver.close(); // close new tab
				driver.switchTo().window(mainWindow); // back to main window
			}
		}
		Thread.sleep(5000);

		driver.switchTo().defaultContent();
		driver.switchTo().frame("ul-checklist-7ce498d5-5efb-48bd-924b-b9f27457161d");

		// Click second checklist item (remove target=_blank)
		WebElement secondItem = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("#checklist_item_ff36bdb4-41c7-4d7c-b678-805c823d23f9")));
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('target');", secondItem);
		secondItem.click();

		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindow)) {
				driver.switchTo().window(handle); // switched to new tab
				// driver.close(); // close new tab
				driver.switchTo().window(mainWindow); // back to main window
			}
		}
		Thread.sleep(5000);

		driver.switchTo().defaultContent();
		driver.switchTo().frame("ul-checklist-7ce498d5-5efb-48bd-924b-b9f27457161d");

		// Click dismiss button
		WebElement dismissChecklistBtn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#checklist-dismiss-button")));
		dismissChecklistBtn.click();

		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("ul-checklist-7ce498d5-5efb-48bd-924b-b9f27457161d");
		// Click confirm button
		WebElement confirmBtn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#gs-checklist-confirm-btn")));
		confirmBtn.click();

		Thread.sleep(5000);

		// Switch back to main content if needed
		driver.switchTo().defaultContent();

		// =================================== Survey
		// ===========================================

		driver.get("https://test-project-rouge-one.vercel.app/about.html");
		Thread.sleep(9000);
		driver.switchTo().frame("ul-nps-00dd194c-57ed-498a-9832-733f2a1dd2ad");
		// List of NPS score selectors
		String[] ids = {
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(1) > div.count-div.ul-nps-score-button",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(2) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(3) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(4) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(5) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(6) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(7) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(8) > div.count-div.ul-nps-score-button",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(9) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(10) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(11) > div.count-div.ul-nps-score-button" };

		// Pick random index
		int randomIndex = (int) (Math.random() * ids.length);
		String randomSelector = ids[randomIndex];
		System.out.println("🎯 Clicking: " + randomIndex + " : random element: " + randomSelector);

		// Switch to iframe
		driver.switchTo().defaultContent();
		driver.switchTo().frame("ul-nps-00dd194c-57ed-498a-9832-733f2a1dd2ad");

		// Click random NPS score
		WebElement npsBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(randomSelector)));
		npsBtn.click();
		Thread.sleep(5000);

		// Switch to iframe
		driver.switchTo().defaultContent();
		driver.switchTo().frame("ul-nps-00dd194c-57ed-498a-9832-733f2a1dd2ad");

		// Like/Dislike
		String[] likeIDs = { "#like", "#dislike" };
		int randomLikeIndex = (int) (Math.random() * likeIDs.length);
		String randomLikeSelector = likeIDs[randomLikeIndex];
		System.out.println("🎯 Clicking like: " + randomLikeIndex + " : " + randomLikeSelector);

		WebElement likeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(randomLikeSelector)));
		likeBtn.click();
		Thread.sleep(2000);

		// Random string for textarea
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 150; i++) {
			sb.append(chars.charAt((int) (Math.random() * chars.length())));
		}
		String text150 = sb.toString();

		// Enter text into textarea
		WebElement textarea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("textarea")));
		textarea.sendKeys(text150);
		Thread.sleep(2000);

		// Click continue button
		WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("continue-button")));
		continueBtn.click();
		Thread.sleep(5000);

		// Switch to iframe
		driver.switchTo().defaultContent();
		driver.switchTo().frame("ul-nps-00dd194c-57ed-498a-9832-733f2a1dd2ad");

		// === Step 5: Click dismiss button ===
		WebElement dismissSurveyBtn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ul-nps-custom-dismiss")));
		dismissSurveyBtn.click();

		Thread.sleep(1000);

		// Switch back to main content
		driver.switchTo().defaultContent();

		driver.quit();

	}

	public static void CompleteAllResponseIDENTIFY() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.manage().window().maximize();

		// Visit the URL
		driver.get("https://test-project-rouge-one.vercel.app/");
		Thread.sleep(5000);
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
		System.out.println("Run executed with: " + randomEmail);
		Thread.sleep(3000);

		// ========================================Product
		// tour========================================

		WebElement iframe = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("ul-product-tour-580fcd04-ff7f-4fed-b87f-c6af9ac6f8ba")));
		// Switch to iframe
		driver.switchTo().frame(iframe);

		// Click first button inside modal
		WebElement firstButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
				"#modal-body-main > div.modal-body > div:nth-child(2) > div:nth-child(5) > button:nth-child(1)")));
		firstButton.click();
		Thread.sleep(5000);

		// Switch back and again into iframe
		driver.switchTo().defaultContent();
		driver.switchTo().frame("ul-product-tour-580fcd04-ff7f-4fed-b87f-c6af9ac6f8ba");

		// Click tooltip button
		WebElement tooltipBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
				"#main-tooltip-body > div.gs-tooltip-modal-content > div.tooltip-body > div > div:nth-child(3) > button:nth-child(2)")));
		tooltipBtn.click();
		Thread.sleep(5000);

		// Switch back and into beacon iframe
		driver.switchTo().defaultContent();
		driver.switchTo().frame("ul-beacon-step-86e3f042-a2c1-4731-814b-5c001ac3402f");

		WebElement span = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("span")));
		span.click();

		// Switch back and again into product-tour iframe
		driver.switchTo().defaultContent();
		driver.switchTo().frame("ul-product-tour-580fcd04-ff7f-4fed-b87f-c6af9ac6f8ba");

		WebElement tooltipBtn2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
				"#main-tooltip-body > div.gs-tooltip-modal-content > div.tooltip-body > div > div:nth-child(3) > button:nth-child(2)")));
		tooltipBtn2.click();
		Thread.sleep(5000);

		// =================================== Checklist
		// =======================================================
		driver.switchTo().defaultContent(); // always reset before switching iframe
		driver.switchTo().frame("ul-checklist-7ce498d5-5efb-48bd-924b-b9f27457161d");

		String mainWindow = driver.getWindowHandle();

		// First checklist item
		WebElement item1 = wait.until(
				ExpectedConditions.elementToBeClickable(By.id("checklist_item_deda44ae-9b9d-4ed1-9a04-12486f8d6050")));
		// Remove target attribute so it doesn’t open new tab
		js.executeScript("arguments[0].removeAttribute('target')", item1);
		item1.click();
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindow)) {
				driver.switchTo().window(handle); // switched to new tab
				// driver.close(); // close new tab
				driver.switchTo().window(mainWindow); // back to main window
			}
		}
		Thread.sleep(5000);

		driver.switchTo().defaultContent();
		driver.switchTo().frame("ul-checklist-7ce498d5-5efb-48bd-924b-b9f27457161d");

		// Second checklist item
		WebElement item2 = wait.until(
				ExpectedConditions.elementToBeClickable(By.id("checklist_item_ff36bdb4-41c7-4d7c-b678-805c823d23f9")));
		js.executeScript("arguments[0].removeAttribute('target')", item2);
		item2.click();
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindow)) {
				driver.switchTo().window(handle); // switched to new tab
				// driver.close(); // close new tab
				driver.switchTo().window(mainWindow); // back to main window
			}
		}
		Thread.sleep(5000);

		driver.switchTo().defaultContent();
		driver.switchTo().frame("ul-checklist-7ce498d5-5efb-48bd-924b-b9f27457161d");

		// Third checklist item
		WebElement item3 = wait.until(
				ExpectedConditions.elementToBeClickable(By.id("checklist_item_900ab3fe-c245-4b2a-9823-20070ce4e428")));
		js.executeScript("arguments[0].removeAttribute('target')", item3);
		item3.click();

		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindow)) {
				driver.switchTo().window(handle); // switched to new tab
				// driver.close(); // close new tab
				driver.switchTo().window(mainWindow); // back to main window
			}
		}
		Thread.sleep(5000);

		driver.switchTo().defaultContent();

		// =================================== Survey
		// =============================================
		driver.get("https://test-project-rouge-one.vercel.app/about.html");
		Thread.sleep(9000);

		driver.switchTo().frame("ul-nps-00dd194c-57ed-498a-9832-733f2a1dd2ad");
		// List of NPS score selectors
		String[] ids = {
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(1) > div.count-div.ul-nps-score-button",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(2) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(3) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(4) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(5) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(6) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(7) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(8) > div.count-div.ul-nps-score-button",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(9) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(10) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(11) > div.count-div.ul-nps-score-button" };

		// Pick random index
		int randomIndex = (int) (Math.random() * ids.length);
		String randomSelector = ids[randomIndex];
		System.out.println("🎯 Clicking: " + randomIndex + " : random element: " + randomSelector);

		// Click random NPS score
		WebElement npsBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(randomSelector)));
		npsBtn.click();
		Thread.sleep(5000);

		// Switch to iframe
		driver.switchTo().defaultContent();
		driver.switchTo().frame("ul-nps-00dd194c-57ed-498a-9832-733f2a1dd2ad");

		// Like/Dislike
		String[] likeIDs = { "#like", "#dislike" };
		int randomLikeIndex = (int) (Math.random() * likeIDs.length);
		String randomLikeSelector = likeIDs[randomLikeIndex];
		System.out.println("🎯 Clicking like: " + randomLikeIndex + " : " + randomLikeSelector);

		WebElement likeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(randomLikeSelector)));
		likeBtn.click();
		Thread.sleep(2000);

		// Random string for textarea
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 150; i++) {
			sb.append(chars.charAt((int) (Math.random() * chars.length())));
		}
		String text150 = sb.toString();

		// Enter text into textarea
		WebElement textarea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("textarea")));
		textarea.sendKeys(text150);
		Thread.sleep(2000);

		// Click continue button
		WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("continue-button")));
		continueBtn.click();
		Thread.sleep(5000);

		// Switch to iframe
		driver.switchTo().defaultContent();
		driver.switchTo().frame("ul-nps-00dd194c-57ed-498a-9832-733f2a1dd2ad");

		// CSAT (emoji rating)
		String[] csat = {
				"#nps-container > div:nth-child(2) > div.template-preview-emoji--count > div:nth-child(1) > svg",
				"#nps-container > div:nth-child(2) > div.template-preview-emoji--count > div:nth-child(2) > svg",
				"#nps-container > div:nth-child(2) > div.template-preview-emoji--count > div:nth-child(3) > svg",
				"#nps-container > div:nth-child(2) > div.template-preview-emoji--count > div:nth-child(4) > svg",
				"#nps-container > div:nth-child(2) > div.template-preview-emoji--count > div:nth-child(5) > svg" };
		int randomCSATIndex = (int) (Math.random() * csat.length);
		String randomCSATSelector = csat[randomCSATIndex];
		System.out.println("🎯 Clicking CSAT: " + randomCSATIndex + " : " + randomCSATSelector);

		WebElement csatBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(randomCSATSelector)));
		csatBtn.click();
		Thread.sleep(5000);

		// Switch to iframe
		driver.switchTo().defaultContent();
		driver.switchTo().frame("ul-nps-00dd194c-57ed-498a-9832-733f2a1dd2ad");

		// CES (effort score)
		String[] ces = { "#nps-container > div:nth-child(2) > div.template-preview-emoji--count > div:nth-child(1)",
				"#nps-container > div:nth-child(2) > div.template-preview-emoji--count > div:nth-child(2)",
				"#nps-container > div:nth-child(2) > div.template-preview-emoji--count > div:nth-child(3)",
				"#nps-container > div:nth-child(2) > div.template-preview-emoji--count > div:nth-child(4)",
				"#nps-container > div:nth-child(2) > div.template-preview-emoji--count > div:nth-child(5)" };
		int randomCESIndex = (int) (Math.random() * ces.length);
		String randomCESSelector = ces[randomCESIndex];
		System.out.println("🎯 Clicking CES: " + randomCESIndex + " : " + randomCESSelector);

		WebElement cesBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(randomCESSelector)));
		cesBtn.click();
		Thread.sleep(5000);

		driver.switchTo().defaultContent();

		driver.quit();
	}

	public static void DismissResponseIDENTIFY() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.manage().window().maximize();

		driver.get("https://test-project-rouge-one.vercel.app/");
		Thread.sleep(5000);

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
		System.out.println("Run executed with: " + randomEmail);
		Thread.sleep(3000);

		WebElement iframe = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("ul-product-tour-580fcd04-ff7f-4fed-b87f-c6af9ac6f8ba")));
		// Switch to iframe
		driver.switchTo().frame(iframe);

		// Click first button inside iframe
		WebElement firstBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"#modal-body-main > div.modal-body > div:nth-child(2) > div:nth-child(5) > button:nth-child(1)")));
		firstBtn.click();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		driver.switchTo().frame("ul-product-tour-580fcd04-ff7f-4fed-b87f-c6af9ac6f8ba");
		// Close button
		WebElement closeBtn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ul-product-tour-close-btn")));
		closeBtn.click();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		driver.switchTo().frame("ul-product-tour-580fcd04-ff7f-4fed-b87f-c6af9ac6f8ba");
		// Dismiss button
		WebElement dismissBtn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#dismiss-button")));
		dismissBtn.click();

		Thread.sleep(5000);
		// Switch back to main page
		driver.switchTo().defaultContent();

		// checklList

		// Switch to checklist iframe
		driver.switchTo().frame("ul-checklist-7ce498d5-5efb-48bd-924b-b9f27457161d");
		String mainWindow = driver.getWindowHandle();
		// Click first checklist item (remove target=_blank)
		WebElement firstItem = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("#checklist_item_deda44ae-9b9d-4ed1-9a04-12486f8d6050")));
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('target');", firstItem);
		firstItem.click();

		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindow)) {
				driver.switchTo().window(handle); // switched to new tab
				// driver.close(); // close new tab
				driver.switchTo().window(mainWindow); // back to main window
			}
		}
		Thread.sleep(5000);

		driver.switchTo().defaultContent();
		driver.switchTo().frame("ul-checklist-7ce498d5-5efb-48bd-924b-b9f27457161d");

		// Click second checklist item (remove target=_blank)
		WebElement secondItem = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("#checklist_item_ff36bdb4-41c7-4d7c-b678-805c823d23f9")));
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('target');", secondItem);
		secondItem.click();
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindow)) {
				driver.switchTo().window(handle); // switched to new tab
				// driver.close(); // close new tab
				driver.switchTo().window(mainWindow); // back to main window
			}
		}
		Thread.sleep(5000);

		driver.switchTo().defaultContent();
		driver.switchTo().frame("ul-checklist-7ce498d5-5efb-48bd-924b-b9f27457161d");

		// Click dismiss button
		WebElement dismissChecklistBtn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#checklist-dismiss-button")));
		dismissChecklistBtn.click();

		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("ul-checklist-7ce498d5-5efb-48bd-924b-b9f27457161d");
		// Click confirm button
		WebElement confirmBtn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#gs-checklist-confirm-btn")));
		confirmBtn.click();

		Thread.sleep(5000);

		// Switch back to main content if needed
		driver.switchTo().defaultContent();

		// =================================== Survey
		// ===========================================

		driver.get("https://test-project-rouge-one.vercel.app/about.html");
		Thread.sleep(9000);
		driver.switchTo().frame("ul-nps-00dd194c-57ed-498a-9832-733f2a1dd2ad");
		// List of NPS score selectors
		String[] ids = {
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(1) > div.count-div.ul-nps-score-button",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(2) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(3) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(4) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(5) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(6) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(7) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(8) > div.count-div.ul-nps-score-button",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(9) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(10) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(11) > div.count-div.ul-nps-score-button" };

		// Pick random index
		int randomIndex = (int) (Math.random() * ids.length);
		String randomSelector = ids[randomIndex];
		System.out.println("🎯 Clicking: " + randomIndex + " : random element: " + randomSelector);

		// Switch to iframe
		driver.switchTo().defaultContent();
		driver.switchTo().frame("ul-nps-00dd194c-57ed-498a-9832-733f2a1dd2ad");

		// Click random NPS score
		WebElement npsBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(randomSelector)));
		npsBtn.click();
		Thread.sleep(5000);

		// Switch to iframe
		driver.switchTo().defaultContent();
		driver.switchTo().frame("ul-nps-00dd194c-57ed-498a-9832-733f2a1dd2ad");

		// Like/Dislike
		String[] likeIDs = { "#like", "#dislike" };
		int randomLikeIndex = (int) (Math.random() * likeIDs.length);
		String randomLikeSelector = likeIDs[randomLikeIndex];
		System.out.println("🎯 Clicking like: " + randomLikeIndex + " : " + randomLikeSelector);

		WebElement likeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(randomLikeSelector)));
		likeBtn.click();
		Thread.sleep(2000);

		// Random string for textarea
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 150; i++) {
			sb.append(chars.charAt((int) (Math.random() * chars.length())));
		}
		String text150 = sb.toString();

		// Enter text into textarea
		WebElement textarea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("textarea")));
		textarea.sendKeys(text150);
		Thread.sleep(2000);

		// Click continue button
		WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("continue-button")));
		continueBtn.click();
		Thread.sleep(5000);

		// Switch to iframe
		driver.switchTo().defaultContent();
		driver.switchTo().frame("ul-nps-00dd194c-57ed-498a-9832-733f2a1dd2ad");

		// === Step 5: Click dismiss button ===
		WebElement dismissSurveyBtn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ul-nps-custom-dismiss")));
		dismissSurveyBtn.click();

		Thread.sleep(1000);

		// Switch back to main content
		driver.switchTo().defaultContent();

		driver.quit();

	}

	public static void PartialTour() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://test-project-rouge-one.vercel.app/");
		Thread.sleep(5000);

		WebElement iframe = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("ul-product-tour-580fcd04-ff7f-4fed-b87f-c6af9ac6f8ba")));
		// Switch to iframe
		driver.switchTo().frame(iframe);

		// Click first button inside modal
		WebElement firstBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"#modal-body-main > div.modal-body > div:nth-child(2) > div:nth-child(5) > button:nth-child(1)")));
		firstBtn.click();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);

		driver.switchTo().frame("ul-product-tour-580fcd04-ff7f-4fed-b87f-c6af9ac6f8ba");
		// Click second button in tooltip modal
		WebElement secondBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"#main-tooltip-body > div.gs-tooltip-modal-content > div.tooltip-body > div > div:nth-child(3) > button:nth-child(2)")));
		secondBtn.click();

		Thread.sleep(5000);

		// Switch back to main content
		driver.switchTo().defaultContent();
		driver.quit();
	}

	public static void ChecklistPartial() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://test-project-rouge-one.vercel.app/");
		Thread.sleep(5000);

		WebElement iframe = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("ul-product-tour-580fcd04-ff7f-4fed-b87f-c6af9ac6f8ba")));
		// Switch to iframe
		driver.switchTo().frame(iframe);

		// Click first button inside modal
		WebElement firstBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"#modal-body-main > div.modal-body > div:nth-child(2) > div:nth-child(5) > button:nth-child(1)")));
		firstBtn.click();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);

		driver.switchTo().frame("ul-product-tour-580fcd04-ff7f-4fed-b87f-c6af9ac6f8ba");
		// Click second button in tooltip modal
		WebElement secondBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"#main-tooltip-body > div.gs-tooltip-modal-content > div.tooltip-body > div > div:nth-child(3) > button:nth-child(2)")));
		secondBtn.click();

		Thread.sleep(5000);

		// Switch back to main content
		driver.switchTo().defaultContent();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.switchTo().frame("ul-checklist-7ce498d5-5efb-48bd-924b-b9f27457161d");

		// First checklist item
		WebElement item1 = wait.until(
				ExpectedConditions.elementToBeClickable(By.id("checklist_item_deda44ae-9b9d-4ed1-9a04-12486f8d6050")));
		// Remove target attribute so it doesn’t open new tab
		js.executeScript("arguments[0].removeAttribute('target')", item1);
		item1.click();
		String mainWindow = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindow)) {
				driver.switchTo().window(handle); // switched to new tab
				// driver.close(); // close new tab
				driver.switchTo().window(mainWindow); // back to main window
			}
		}
		Thread.sleep(5000);

		driver.switchTo().defaultContent();
		driver.quit();

	}

	public static void SurveyPartial() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://test-project-rouge-one.vercel.app/");
		Thread.sleep(5000);

		WebElement iframe = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("ul-product-tour-580fcd04-ff7f-4fed-b87f-c6af9ac6f8ba")));
		// Switch to iframe
		driver.switchTo().frame(iframe);

		// Click first button inside modal
		WebElement firstBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"#modal-body-main > div.modal-body > div:nth-child(2) > div:nth-child(5) > button:nth-child(1)")));
		firstBtn.click();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);

		driver.switchTo().frame("ul-product-tour-580fcd04-ff7f-4fed-b87f-c6af9ac6f8ba");
		// Click second button in tooltip modal
		WebElement secondBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"#main-tooltip-body > div.gs-tooltip-modal-content > div.tooltip-body > div > div:nth-child(3) > button:nth-child(2)")));
		secondBtn.click();

		Thread.sleep(5000);

		// Switch back to main content
		driver.switchTo().defaultContent();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.switchTo().frame("ul-checklist-7ce498d5-5efb-48bd-924b-b9f27457161d");

		// First checklist item
		WebElement item1 = wait.until(
				ExpectedConditions.elementToBeClickable(By.id("checklist_item_deda44ae-9b9d-4ed1-9a04-12486f8d6050")));
		// Remove target attribute so it doesn’t open new tab
		js.executeScript("arguments[0].removeAttribute('target')", item1);
		item1.click();
		String mainWindow = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindow)) {
				driver.switchTo().window(handle); // switched to new tab
				// driver.close(); // close new tab
				driver.switchTo().window(mainWindow); // back to main window
			}
		}
		Thread.sleep(5000);

		driver.switchTo().defaultContent();

		// =================================== Survey
		// =============================================
		driver.get("https://test-project-rouge-one.vercel.app/about.html");
		Thread.sleep(9000);

		// List of NPS score selectors
		String[] ids = {
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(1) > div.count-div.ul-nps-score-button",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(2) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(3) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(4) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(5) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(6) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(7) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(8) > div.count-div.ul-nps-score-button",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(9) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(10) > div",
				"#nps-container > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(11) > div.count-div.ul-nps-score-button" };

		// Pick random index
		int randomIndex = (int) (Math.random() * ids.length);
		String randomSelector = ids[randomIndex];
		System.out.println("🎯 Clicking: " + randomIndex + " : random element: " + randomSelector);

		// Switch to iframe
		driver.switchTo().defaultContent();
		driver.switchTo().frame("ul-nps-00dd194c-57ed-498a-9832-733f2a1dd2ad");

		// Click random NPS score
		WebElement npsBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(randomSelector)));
		npsBtn.click();
		Thread.sleep(2000);

		driver.quit();

	}

	public static void DemoX() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.manage().window().maximize();

		// Visit the URL
		driver.get("https://app.uzera.com/demoX/JS0A9XT00U/5ff617ab-0699-448f-aa58-9b245e26047b/share");
		Thread.sleep(5000);

		// Generate random name & email
		String randomName = "User" + new Random().nextInt(10000);
		String randomEmail = "user" + new Random().nextInt(10000) + "@example.com";

		// Fill name field
		WebElement nameField = driver.findElement(By.cssSelector("#\\:r3\\:"));
		nameField.sendKeys(randomName);
		Thread.sleep(2000);
		// Fill email field
		WebElement emailField = driver.findElement(By.cssSelector("#\\:r5\\:"));
		emailField.sendKeys(randomEmail);
		Thread.sleep(2000);
		// Click continue button
		WebElement continueBtn = driver.findElement(
				By.cssSelector("#ul-demox-embed > div > div > div > div > div > div.MuiBox-root.css-1js65af > "
						+ "div > div.MuiBox-root.css-15qx0d1 > div > div > div.MuiStack-root.css-gfhfdc > button"));
		continueBtn.click();
		Thread.sleep(4000);
		WebElement hotspotBtn1 = driver.findElement(By.cssSelector(
				"#ul-demox-embed > div > div > div > div > div > div.MuiBox-root.css-1js65af > div.MuiBox-root.css-3al35z > div.DemoxScript_gs-tooltip-Wrapper__lxSIu.DemoxScript_animation-view__sKxhM.MuiBox-root.css-1c17an7 > div > svg > circle:nth-child(4)"));
		hotspotBtn1.click();
		Thread.sleep(2000);
		WebElement hotspotBtn2 = driver.findElement(By.cssSelector(
				"#ul-demox-embed > div > div > div > div > div > div.MuiBox-root.css-1js65af > div > div.DemoxScript_gs-tooltip-Wrapper__lxSIu.DemoxScript_animation-view__sKxhM.MuiBox-root.css-13nqpia > div > svg > circle:nth-child(4)"));
		hotspotBtn2.click();
		Thread.sleep(2000);
		WebElement hotspotBtn3 = driver.findElement(By.cssSelector(
				"#ul-demox-embed > div > div > div > div > div > div.MuiBox-root.css-1js65af > div > div.DemoxScript_gs-tooltip-Wrapper__lxSIu.DemoxScript_animation-view__sKxhM.MuiBox-root.css-19gib1h > div > svg > circle:nth-child(4)"));
		hotspotBtn3.click();
		Thread.sleep(2000);
		WebElement hotspotBtn4 = driver.findElement(By.cssSelector(
				"#ul-demox-embed > div > div > div > div > div > div.MuiBox-root.css-1js65af > div > div.DemoxScript_gs-tooltip-Wrapper__lxSIu.DemoxScript_animation-view__sKxhM.MuiBox-root.css-1rgqi1r > div > svg > circle:nth-child(4)"));
		hotspotBtn4.click();
		Thread.sleep(2000);

		driver.quit();
	}

	public static void ShareableSurvey() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.manage().window().maximize();

		// Visit the URL
		driver.get("https://feedback.uzera.com/feedback/JS0A9XT00U/0863baf8-d0c9-40b6-a0a7-9d888340c225");
		Thread.sleep(5000);

		// List of NPS score selectors
		String[] ids = {
				"#root > div > div > div > div.Survey_question-area__5f\\+qv > div > div.Survey_score-wrapper__ua7BA > div > button:nth-child(1)",
				"#root > div > div > div > div.Survey_question-area__5f\\+qv > div > div.Survey_score-wrapper__ua7BA > div > button:nth-child(2)",
				"#root > div > div > div > div.Survey_question-area__5f\\+qv > div > div.Survey_score-wrapper__ua7BA > div > button:nth-child(3)",
				"#root > div > div > div > div.Survey_question-area__5f\\+qv > div > div.Survey_score-wrapper__ua7BA > div > button:nth-child(4)",
				"#root > div > div > div > div.Survey_question-area__5f\\+qv > div > div.Survey_score-wrapper__ua7BA > div > button:nth-child(5)",
				"#root > div > div > div > div.Survey_question-area__5f\\+qv > div > div.Survey_score-wrapper__ua7BA > div > button:nth-child(6)",
				"#root > div > div > div > div.Survey_question-area__5f\\+qv > div > div.Survey_score-wrapper__ua7BA > div > button:nth-child(7)",
				"#root > div > div > div > div.Survey_question-area__5f\\+qv > div > div.Survey_score-wrapper__ua7BA > div > button:nth-child(8)",
				"#root > div > div > div > div.Survey_question-area__5f\\+qv > div > div.Survey_score-wrapper__ua7BA > div > button:nth-child(9)",
				"#root > div > div > div > div.Survey_question-area__5f\\+qv > div > div.Survey_score-wrapper__ua7BA > div > button:nth-child(10)",
				"#root > div > div > div > div.Survey_question-area__5f\\+qv > div > div.Survey_score-wrapper__ua7BA > div > button:nth-child(11)" };

		// Pick random index
		int randomIndex = (int) (Math.random() * ids.length);
		String randomSelector = ids[randomIndex];
		System.out.println("🎯 NPS Clicking: " + randomIndex + " : random element: " + randomSelector);

		// Click random NPS score
		WebElement npsBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(randomSelector)));
		npsBtn.click();
		Thread.sleep(5000);

		// List of yes no questions selectors
		String[] yesnoids = {
				"#root > div > div > div > div.Survey_question-area__5f\\+qv > div > div.Survey_score-wrapper__ua7BA > div > button.MuiButtonBase-root.MuiButton-root.MuiButton-text.MuiButton-textPrimary.MuiButton-sizeMedium.MuiButton-textSizeMedium.MuiButton-colorPrimary.MuiButton-root.MuiButton-text.MuiButton-textPrimary.MuiButton-sizeMedium.MuiButton-textSizeMedium.MuiButton-colorPrimary.gs-secondary-button.Survey_no-button__4CZPt.Survey_highlight-button__V4IcQ.undefined.css-1ujsas3",
				"#root > div > div > div > div.Survey_question-area__5f\\+qv > div > div.Survey_score-wrapper__ua7BA > div > button:nth-child(1)" };

		// Pick random index
		int randomYESNOIndex = (int) (Math.random() * yesnoids.length);
		String randomYESNOSelector = yesnoids[randomYESNOIndex];
		System.out.println("🎯 YesNo Clicking: " + randomYESNOIndex + " : random element: " + randomYESNOSelector);

		// Click random NPS score
		WebElement YESNOBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(randomYESNOSelector)));
		YESNOBtn.click();
		Thread.sleep(5000);

		// List of CSAT questions selectors
		String[] CSATIDS = {
				"#root > div > div > div > div.Survey_question-area__5f\\+qv > div > div.Survey_score-wrapper__ua7BA > div > div:nth-child(1) > svg",
				"#root > div > div > div > div.Survey_question-area__5f\\+qv > div > div.Survey_score-wrapper__ua7BA > div > div:nth-child(2) > svg",
				"#root > div > div > div > div.Survey_question-area__5f\\+qv > div > div.Survey_score-wrapper__ua7BA > div > div:nth-child(3) > svg",
				"#root > div > div > div > div.Survey_question-area__5f\\+qv > div > div.Survey_score-wrapper__ua7BA > div > div:nth-child(4) > svg",
				"#root > div > div > div > div.Survey_question-area__5f\\+qv > div > div.Survey_score-wrapper__ua7BA > div > div:nth-child(5) > svg" };

		// Pick random index
		int randomCSATIndex = (int) (Math.random() * CSATIDS.length);
		String randomCSATSelector = CSATIDS[randomCSATIndex];
		System.out.println("🎯 CSAT Clicking: " + randomCSATIndex + " : random element: " + randomCSATSelector);

		// Click random NPS score
		WebElement CSATBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(randomCSATSelector)));
		CSATBtn.click();
		Thread.sleep(5000);

		// List of CES selectors
		String[] CESIDS = {
				"#root > div > div > div > div.Survey_question-area__5f\\+qv > div > div.Survey_score-wrapper__ua7BA > div > div:nth-child(1)",
				"#root > div > div > div > div.Survey_question-area__5f\\+qv > div > div.Survey_score-wrapper__ua7BA > div > div:nth-child(2)",
				"#root > div > div > div > div.Survey_question-area__5f\\+qv > div > div.Survey_score-wrapper__ua7BA > div > div:nth-child(3)",
				"#root > div > div > div > div.Survey_question-area__5f\\+qv > div > div.Survey_score-wrapper__ua7BA > div > div:nth-child(4)",
				"#root > div > div > div > div.Survey_question-area__5f\\+qv > div > div.Survey_score-wrapper__ua7BA > div > div:nth-child(5)" };

		// Pick random index
		int randomCESIndex = (int) (Math.random() * CESIDS.length);
		String randomCESSelector = CESIDS[randomCESIndex];
		System.out.println("🎯 CES Clicking: " + randomCESIndex + " : random element: " + randomCESSelector);

		// Click random NPS score
		WebElement CESBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(randomCESSelector)));
		CESBtn.click();
		Thread.sleep(3000);

		driver.quit();

	}

	public static void main(String[] args) throws InterruptedException {
		try {
			for (int i = 1; i <= 1; i++) {
				CompleteAllResponse();
				DismissResponse();
				CompleteAllResponseIDENTIFY();
				DismissResponseIDENTIFY();
				PartialTour();
				ChecklistPartial();
				SurveyPartial();
				DemoX();
				ShareableSurvey();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getLocalizedMessage());
		} finally {
			System.out.println("🎯 ALL ok ");
		}

	}

}
