import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Test.BaseComponents.BaseComponentsDemo;

public class PageLoadTime extends BaseComponentsDemo{
    public static void main(String[] args) {
        // Set the path to the WebDriver executable
       

        // Initialize WebDriver
        WebDriver chromeDriver1 = InitializeChromeDriver();

        try {
            // Navigate to the webpage
            driver.get("https://portal.panoramatrack.com");

            // Use JavascriptExecutor to get page load timing
            JavascriptExecutor js = (JavascriptExecutor) driver;

            long loadEventEnd = (Long) js.executeScript("return window.performance.timing.loadEventEnd;");
            long navigationStart = (Long) js.executeScript("return window.performance.timing.navigationStart;");

            // Calculate the total page load time
            long loadTime = loadEventEnd - navigationStart;

            System.out.println("Page Load Time: " + loadTime + " milliseconds");
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
