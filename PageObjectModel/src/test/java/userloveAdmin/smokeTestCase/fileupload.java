package userloveAdmin.smokeTestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class fileupload {

	public static void main(String[] args) throws InterruptedException  {

		System.setProperty("webdriver.chrome.driver", "./browserDrivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://www.w3schools.com/howto/tryit.asp?filename=tryhow_html_file_upload_button");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/form/input[1]")).click();
		driver.quit();
	}
}