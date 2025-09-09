package userloveAdmin.Smoke;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Random;

public class IdentifySite {

    public static void main(String[] args) throws InterruptedException {
        String url = "https://uzera.netlify.app/";  // Change to your site URL
        Random rand = new Random();

        // Repeat 10 times
        for (int i = 1; i <= 30; i++) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            
            
            
            WebDriver driver = new ChromeDriver(options);

            driver.get(url);
            JavascriptExecutor js = (JavascriptExecutor) driver;

            long scrollHeight = (Long) js.executeScript("return document.body.scrollHeight");
            long pos = 0;

 			


 			// ===== Login flow =====
            try {
                // Click login button (adjust selector for your website)
                WebElement loginBtn = driver.findElement(By.xpath("//*[@id='loginBtn']")); 
                loginBtn.click();

                Thread.sleep(2000);

                // Generate random email and password
                String email = "testuser" + rand.nextInt(10000) + "@example.com";
                String password = "Pass@" + rand.nextInt(100000);

                // Enter email (adjust locator)
                WebElement emailField = driver.findElement(By.xpath("//*[@id='loginEmail']"));
                emailField.sendKeys(email);

                // Enter password (adjust locator)
                WebElement passwordField = driver.findElement(By.xpath("//*[@id='loginPassword']"));
                passwordField.sendKeys(password);

                // Click submit (adjust locator)
                WebElement submitBtn = driver.findElement(By.xpath("//*[@id='loginForm']/button"));
                submitBtn.click();

                System.out.println("Login attempted with: " + email + " / " + password);
            } catch (Exception e) {
                System.out.println("Login elements not found! Please adjust locators.");
            }


			// Random scroll like human
            while (pos < scrollHeight - 400) {
                pos += 200 + rand.nextInt(300); // random step
                js.executeScript("window.scrollTo(0, arguments[0]);", pos);
                Thread.sleep(200 + rand.nextInt(400)); // random delay

                // sometimes scroll up a little
                if (rand.nextInt(10) > 7) {
                    pos -= 150;
                    if (pos < 0) pos = 0;
                    js.executeScript("window.scrollTo(0, arguments[0]);", pos);
                    Thread.sleep(200 + rand.nextInt(400));
                }
            }

            // Wait at bottom
            Thread.sleep(2000);
         
                      
            driver.quit();
            System.out.println("Run " + i + " completed.");
        }
    }
}
