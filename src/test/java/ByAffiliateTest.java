
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Test.BaseComponents.BaseComponentsDemo;

public class ByAffiliateTest extends BaseComponentsDemo

{
	public ByAffiliateTest() {
		// Default constructor
	}

	WebDriver chromeDriver1 = InitializeFirefoxDriver();

	
//	
	// Extent Report
	private ExtentReports extent;
	private ExtentTest test;
	int basecounter = 0;
	int eventcounter = 0;
	String grossClicksByPosition;
	int counter = 0;
	String baseCounterString;
	String eventConterString;
	int skipcount = 0;
	int skipCounterBase = 0;
	int skipCounterEvent = 0;
	int loop;
	int[] Basepositions = { 10,50};
	int[] EventPosition = { 1,2,3,4,5,6,7,45};
	
	
	@Test(priority = 1)
	public void login() throws InterruptedException {
		driver.get("https://staging.panoramatrack.com/reporting/offer/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			System.out.println("No notification popup detected.");
		}
		driver.findElement(By.cssSelector("input[id=':r0:']")).sendKeys("team@codeclouds.biz");
		driver.findElement(By.cssSelector("button[type='Submit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[id='auth-login-password']")).sendKeys("Qwer!12345");
		driver.findElement(By.cssSelector("button[type='Submit']")).click();
		((JavascriptExecutor) driver).executeScript("window.open();");
	}

	@Test(priority = 2)
	public void TrackingChrome() throws InterruptedException {

		for (int i = 0; i < 2; i++)
			systematicScrub();

	}
	

	public void systematicScrub() throws InterruptedException {

		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		String oldTabId = tabs.get(0);
		String newTabId = tabs.get(1);

		for (loop = 1; loop < 50; loop++) {
			counter = counter + 1;
			chromeDriver1.switchTo().window(newTabId);
			System.out.println(loop);
			chromeDriver1.get("https://stagesecure.panoramatrack.com/tracking/90/2/");
			chromeDriver1.findElement(By.xpath("//button[text()='Add to Cart']")).click();
			Thread.sleep(5000);
			chromeDriver1.findElement(By.xpath("//a[@class='button']")).click();
			int target = loop;
			boolean foundBase = search(Basepositions, target);
			boolean foundEvent = search(EventPosition, target);

			if (foundBase && skipCounterBase >= skipcount) {
				basecounter = basecounter + 1;
				System.out.println("Position is " + loop);
				System.out.println("Base Scrubbed please check the report manually and verify");
//				playSound("/Users/codeclouds-bikram/Downloads/CantinaBand3.wav");
				System.out.println("Base Counter   " + basecounter);
//				Thread.sleep(10000);
				chromeDriver1.switchTo().window(oldTabId);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[text()='Filter']")).click();
				Thread.sleep(5000);
				String grossClicks = driver
						.findElement(By.xpath("//p[contains(text(), 'Gross clicks')]/following-sibling::h3")).getText();
//				System.out.println("Gross clicks in string " + grossClicks);
				String totalSales = driver
						.findElement(By.xpath("//p[contains(text(), 'Total sales')]/following-sibling::h3")).getText();
//				System.out.println("Gross clicks in string " + totalSales);
				int totalSalesInt = Integer.parseInt(totalSales);
				//
				grossClicksByPosition = Integer.toString(counter);
				String paidSalesBase = driver
						.findElement(By.xpath("//p[contains(text(), 'Paid sales')]/following-sibling::h3")).getText();
//				System.out.println("routedSalesBase in string " + routedSalesBase);
				String routedSalesBase = driver
						.findElement(By.xpath("(//p[contains(text(), 'Routed sales')]/following-sibling::h3)[1]"))
						.getText();
				int paidSalesInt = Integer.parseInt(paidSalesBase);
				System.out.println("Routed Sales Integer " + paidSalesInt);
				int actualRoutedSales = totalSalesInt - paidSalesInt;
				System.out.println("Actual ROuted Sales  " + actualRoutedSales);
				String actualRoutedSalesString = Integer.toString(actualRoutedSales);
				baseCounterString = Integer.toString(basecounter);
				System.out.println(
						"Routed Base Sales is " + routedSalesBase + "and routedCounter is " + baseCounterString);

//				assertEquals(routedSalesBase, baseCounterString);
//				assertEquals(grossClicks, grossClicksByPosition);
//				assertEquals(totalSales, grossClicksByPosition);
//				assertEquals(routedSalesBase, actualRoutedSalesString);

			} else if (foundBase) {
				skipCounterBase = skipCounterBase + 1;
			}
			
			

			if (foundEvent && skipCounterEvent >= skipcount) {
				eventcounter = eventcounter + 1;
				System.out.println("Position is " + loop);
				System.out.println("Event Scrubbed please check the report manually and verify");
//				playSound("/Users/codeclouds-bikram/Downloads/CantinaBand3.wav");
				System.out.println("Event  counter   " + eventcounter);
//				Thread.sleep(10000);
				chromeDriver1.switchTo().window(oldTabId);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[text()='Filter']")).click();
				Thread.sleep(5000);	
				String routedEventsString = driver.findElement(By.xpath("//p[contains(text(), 'Routed Events')]/following-sibling::h3/a")).getText();
				eventConterString = Integer.toString(eventcounter);
//				assertEquals(routedEventsString, eventConterString);

			} 
			else if (foundEvent) {
				skipCounterEvent = skipCounterEvent + 1;

			}
		}

	}
	
	
	

	public static void playSound(String soundFilePath) {
		try {
			File soundFile = new File(soundFilePath);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			Clip clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean search(int[] arr, int target) {
		for (int num : arr) {
			if (num == target) {
				return true;
			}
		}
		return false;
	}

}