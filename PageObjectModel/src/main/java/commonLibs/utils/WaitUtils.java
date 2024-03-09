package commonLibs.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	public static void waitForSeconds(int timeOutSeconds) throws Exception{
		Thread.sleep(timeOutSeconds * 1000);
	}
	
	public static void waitTillAlertIsPresent(WebDriver driver, Duration timeoutInseconds) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInseconds);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public static void waitTillElementVisiable(WebDriver driver, WebElement element, Duration timeoutInSeconds)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitTillElementClickable(WebDriver driver, WebElement element, Duration timeoutInSeconds)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static void waitTillElementSelectable(WebDriver driver, WebElement element, Duration timeoutInSeconds)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
}
