
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Test.BaseComponents.BaseComponentsDemo;

public class OfferByAffiliatesFlowFireFoxBrowser extends BaseComponentsDemo

{
	public OfferByAffiliatesFlowFireFoxBrowser() {
		// Default constructor
	}

	WebDriver firefoxDriver = InitializeChromeDriver();
//	
	// Extent Report
	private ExtentReports extent;
	private ExtentTest test;

	int baseCount = 0;
	int eventCount = 0;

	@Test
	public void TrackingFirefox() throws InterruptedException {

		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			firefoxDriver.get(
					"https://stagesecure.panoramatrack.com/tracking/821/8/?subAff=autoSubAff&sub1=autoSub1&sub2=autoSub2&sub3=autoSub3&sub4=autoSub4&sub5=autoSub5&fid=FID&fevent=FEvent");
		

				Thread.sleep(2000);
//				firefoxDriver.findElement(By.xpath("//button[text()='Add to Cart']")).click();
//				Alert alert = driver.switchTo().alert();
				//
//				// Accept the alert (click on OK)
//				alert.accept();

//				Thread.sleep(2000);
//				firefoxDriver.findElement(By.xpath("//a[@class='button']")).click();
//				Thread.sleep(3000);
			

////
//			firefoxDriver.get("https://stagesecure.panoramatrack.com/tracking/5/123/");
//
//			firefoxDriver.findElement(By.xpath("//button[text()='Add to Cart']")).click();
////			Alert alert1 = driver.switchTo().alert();
////
////			// Accept the alert (click on OK)
////			alert1.accept();
//
//			Thread.sleep(2000);
//			firefoxDriver.findElement(By.xpath("//a[@class='button']")).click();
//			Thread.sleep(2000);
//
//			firefoxDriver.get("https://stagesecure.panoramatrack.com/tracking/5/3/");
//
//			firefoxDriver.findElement(By.xpath("//button[text()='Add to Cart']")).click();
////			Alert alert2 = driver.switchTo().alert();
////
////			// Accept the alert (click on OK)
////			alert2.accept();
//
//			Thread.sleep(2000);
//			firefoxDriver.findElement(By.xpath("//a[@class='button']")).click();
//			Thread.sleep(2000);
//			
//			firefoxDriver.get("https://stagesecure.panoramatrack.com/tracking/43/123/");
//
//			firefoxDriver.findElement(By.xpath("//button[text()='Add to Cart']")).click();
//			Alert alert3 = driver.switchTo().alert();
//
//			// Accept the alert (click on OK)
//			alert3.accept();
//
//			Thread.sleep(2000);
//			firefoxDriver.findElement(By.xpath("//a[@class='button']")).click();
//			Thread.sleep(2000);
//			
//			
//			
//			firefoxDriver.get("https://stagesecure.panoramatrack.com/tracking/43/123/");
//
//			firefoxDriver.findElement(By.xpath("//button[text()='Add to Cart']")).click();
//			Alert alert4 = driver.switchTo().alert();
//
//			// Accept the alert (click on OK)
//			alert4.accept();
//
//			Thread.sleep(2000);
//			firefoxDriver.findElement(By.xpath("//a[@class='button']")).click();
//			Thread.sleep(2000);
////			firefoxDriver.get("https://stagesecure.panoramatrack.com/tracking/"+i+"/46/");
//			
//			firefoxDriver.get("https://stagesecure.panoramatrack.com/tracking/43/2/");
//
//			firefoxDriver.findElement(By.xpath("//button[text()='Add to Cart']")).click();
//			Alert alert5 = driver.switchTo().alert();
//
//			// Accept the alert (click on OK)
//			alert5.accept();
//
//			Thread.sleep(2000);
//			firefoxDriver.findElement(By.xpath("//a[@class='button']")).click();
//			Thread.sleep(2000);

//			
//			for (int j = 1; j < 50; j++) {
//				System.out.println(i+"    "+ j);
//				 try {
//			           
////						firefoxDriver.get("https://stagesecure.panoramatrack.com/tracking/5"+j+"/");
//					 firefoxDriver.get("https://stagesecure.panoramatrack.com/tracking/5/123/?subAff=qa&sub1=qa1"); 
//			            // Perform any other operations you need
//
//			        } catch (WebDriverException e) {
//			            if (e.getMessage().contains("ERR_CONNECTION_TIMED_OUT")) {
//			                System.out.println("Connection timed out. Please check your network connection or the URL.");
//			            } else {
//			                System.out.println("An unexpected WebDriver exception occurred: " + e.getMessage());
//			            }
//			        }
//			}
//			
//			 

		}

	}

}