package commonLibs.implementation;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import commonLibs.contracts.IDriver;
import io.github.bonigarcia.wdm.WebDriverManager;



public class CommonDriver implements IDriver {

	
	private static WebDriver driver;
	private int pageloadTimeout;
	private int elementDetectionTimeout;
	private String currentWorkingDirectory;

	public CommonDriver(String browserType) throws Exception {
        // TODO Auto-generated constructor stub
        pageloadTimeout = 60;
        elementDetectionTimeout = 10;
        currentWorkingDirectory = System.getProperty("user.dir");

        if (browserType.equalsIgnoreCase("chrome")) {
//            System.setProperty("webdriver.chrome.driver", currentWorkingDirectory + "/browserDrivers/chromedriver.exe"); // windows setting - call driver manually
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--remote-allow-origins=*");

            // driver = new ChromeDriver(options); // windows setting - call driver manually

            WebDriverManager.chromedriver().setup(); // Mac - no driver needed using this
            driver = new ChromeDriver();

        } else if (browserType.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.chrome.driver", currentWorkingDirectory + "/browserDrivers/msedgedriver.exe");
            driver = new EdgeDriver();
        } else {
            System.out.println("\n*****************Invalid Browser Type*****************");
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void setPageloadTimeout(int pageloadTimeout) {
		this.pageloadTimeout = pageloadTimeout;
	}

	public void setElementDetectionTimeout(int elementDetectionTimeout) throws Exception {
		this.elementDetectionTimeout = elementDetectionTimeout;
	}

	public void navigateToFirstUrl(String url) throws Exception {
        // TODO Auto-generated method stub

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageloadTimeout));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(elementDetectionTimeout));

        url = url.trim();
        driver.get(url);
    }

	public String getTitle() throws Exception {
		// TODO Auto-generated method stub
		String title = driver.getTitle();
		return title;
	}

	public String getCurrentUrl() throws Exception {
		// TODO Auto-generated method stub
		return driver.getCurrentUrl();
	}

	public String getPageSource() throws Exception {
		// TODO Auto-generated method stub
		return driver.getPageSource();
	}

	public void navigateToUrl(String url) throws Exception {
		// TODO Auto-generated method stub
		url = url.trim();
		driver.navigate().to(url);
	}

	public void navigateForward() throws Exception {
		// TODO Auto-generated method stub
		driver.navigate().forward();
	}

	public void navigateBackward() throws Exception {
		// TODO Auto-generated method stub
		driver.navigate().back();
	}

	public void refresh() throws Exception {
		// TODO Auto-generated method stub
		driver.navigate().refresh();
	}

	public void closeBrowser() throws Exception {
		// TODO Auto-generated method stub
		if (driver != null) {
			driver.close();
		}

	}

	public void closeAllBrowser() throws Exception {
		// TODO Auto-generated method stub
		if (driver != null) {
			driver.quit();
		}
	}
}
