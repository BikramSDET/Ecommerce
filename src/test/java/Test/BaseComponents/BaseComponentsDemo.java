package Test.BaseComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseComponentsDemo {
	public static WebDriver driver;
	Properties prop = new Properties();

	public static WebDriver InitializeChromeDriver() {

		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

		// Disable cookies
		options.addArguments("--disable-cookies");
//	    options.addArguments("headless");
		driver = new ChromeDriver(options);
		// Create ChromeOptions instance

		driver.manage().window().maximize();
		return driver;

	}

	public static WebDriver InitializeSafariDriver() {

//		WebDriverManager.chromedriver().setup();
//	
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		driver = new ChromeDriver(options);
		driver = new SafariDriver();
		driver.manage().window().maximize();
		return driver;

	}

	public static WebDriver InitializeFirefoxDriver() {
 
		FirefoxOptions options = new FirefoxOptions();
		options.addPreference("dom.webnotifications.enabled", false);
		driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
		return driver;

	}
	
	
	 public static WebDriver initializeDriver() {
	        if (System.getProperty("browser") != null && System.getProperty("browser").equalsIgnoreCase("chrome")) {
	            ChromeOptions chromeOptions = new ChromeOptions();
	            if (System.getProperty("selenium.grid.enabled") != null && System.getProperty("selenium.grid.enabled").equalsIgnoreCase("true")) {
	                try {
	                    return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
	                } catch (MalformedURLException e) {
	                    e.printStackTrace();
	                    return null; // Or handle the exception according to your requirement
	                }
	            } else {
	                // Run locally if Selenium Grid is not enabled
	                return new ChromeDriver(chromeOptions);
	            }
	        } else {
	            System.out.println("System property 'browser' is not set to 'chrome'. Unable to initialize WebDriver.");
	            return null;
	        }
	    }


	public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException {
		String jsonContent = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;

	}

	public String screenShot(String testCaseName, WebDriver driver) throws IOException {
	    if (driver != null) {
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        File destination = new File(
	                "/Users/codeclouds-bikram/Documents/Ecommerce-Automation/reports/" + testCaseName + ".png");
	        FileUtils.copyFile(source, destination);
	        return "/Users/codeclouds-bikram/Documents/Ecommerce-Automation/reports/" + testCaseName + ".png";
	    } else {
	        System.out.println("WebDriver is not initialized. Cannot take screenshot.");
	        return null;
	    }
	}


	public static void waitFunctionVisibility(WebDriver driver, WebElement element) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOf(element));
	}


	public static void waitFunctionInVisibility(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public static void waitFunctionEnabledOrDisabled(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitFunctionAlert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.alertIsPresent());

	}

	public void waitFunctionClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void waitFunctionPresence(By element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(element));

	}

	public String UserData(String propertyName) {
		Properties properties = new Properties();
		try {
			FileInputStream fileInputStream = new FileInputStream(
					"/Users/codeclouds-bikram/Desktop/AutomationMac/src/test/java/Test/resources/Globaldata.properties");
			properties.load(fileInputStream);
			fileInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(propertyName);

	}

}