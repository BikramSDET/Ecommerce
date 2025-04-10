import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Test.BaseComponents.BaseComponentsDemo;

public class OfferByAffiliatesFlowChromeBrowser extends BaseComponentsDemo {

    static WebDriver firefoxDriver = InitializeChromeDriver();
    
    // Extent Report
    private ExtentReports extent;
    private ExtentTest test;

    @Test
    public void TrackingFirefox() throws InterruptedException {

        for (int i = 1; i < 10; i++) {
            System.out.println(i);
//            firefoxDriver.get("https://stagesecure.panoramatrack.com/tracking/43/123/");

            try {
//            	firefoxDriver.get("https://stagesecure.panoramatrack.com/tracking/"+i+"/123/");
//                firefoxDriver.findElement(By.xpath("//button[text()='Add to Cart']")).click();
//                Alert alert = firefoxDriver.switchTo().alert();
//                alert.accept();
//                Thread.sleep(2000);
//                firefoxDriver.findElement(By.xpath("//a[@class='button']")).click();
//                Thread.sleep(2000);
                firefoxDriver.get("https://stagesecure.panoramatrack.com/tracking/5/"+i+"/");
                if (firefoxDriver.findElement(By.xpath("//h1[text()='Oops! Looks like something is wrong']")).isDisplayed()) {
                    System.out.println("Error");
                } else {
                   
                    firefoxDriver.findElement(By.xpath("//button[text()='Add to Cart']")).click();
                    Alert alert2 = firefoxDriver.switchTo().alert();
                    alert2.accept();
                    Thread.sleep(2000);
                    firefoxDriver.findElement(By.xpath("//a[@class='button']")).click();
                    Thread.sleep(2000);
                }

            } catch (NoSuchElementException e) {
                // Print the error message if the exception occurs
                System.out.println("Error: Element not found.");
            } catch (Exception e) {
                // Print any other exceptions that may occur
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }
}
