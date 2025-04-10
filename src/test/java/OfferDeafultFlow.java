
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Test.BaseComponents.BaseComponentsDemo;

public class OfferDeafultFlow extends BaseComponentsDemo

{
	public OfferDeafultFlow() {
		// Default constructor
	}

	WebDriver chromeDriver1 = InitializeChromeDriver();

//	
	// Extent Report
	private ExtentReports extent;
	private ExtentTest test;

	@Test(groups = {"OfferLevel"})
	public void TrackingChrome() throws InterruptedException {

		for (int i = 0; i < 100; i++) {
			System.out.println(i);
			chromeDriver1.get("https://secure.panoramatrack.com/tracking/85/2/");
			chromeDriver1.findElement(By.xpath("//button[text()='Add to Cart']")).click();
			Thread.sleep(3000);
			chromeDriver1.findElement(By.xpath("//a[@class='button']")).click();

		}

	}

}