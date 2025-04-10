
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Test.BaseComponents.BaseComponentsDemo;

public class DeviceScrub extends BaseComponentsDemo

{
	public DeviceScrub() {
		// Default constructor
	}

	WebDriver chromeDriver1 = InitializeChromeDriver();

//	
	// Extent Report
	private ExtentReports extent;
	private ExtentTest test;

	@Test(groups = { "AffiliateLevel" })
	public void TrackingChrome() throws InterruptedException {
		int[] Basepositions = { 4,6,34,21,2 };
		int[] EventPosition = {2,8 };

		for (int i = 1; i < 51; i++) {
			System.out.println(i);
			chromeDriver1.get("https://secure.panoramatrack.com/tracking/3/1/");
			chromeDriver1.findElement(By.xpath("//button[text()='Add to Cart']")).click();
			Thread.sleep(5000);
			chromeDriver1.findElement(By.xpath("//a[@class='button']")).click();
			Thread.sleep(5000);
			
			int target = i;
			boolean foundBase = search(Basepositions, target);
			boolean foundEvent = search(EventPosition, target);
			if (foundBase) {
				System.out.println("We Are at Position  " + i);
				System.out.println("Base Scrubbed please check the report manually and verify");
				playSound("/Users/codeclouds-bikram/Downloads/CantinaBand3.wav");
				Thread.sleep(10000);

			}
			if (foundEvent) {
				System.out.println("We Are at Position  " + i);
				System.out.println("Event Scrubbed please check the report manually and verify");
				playSound("/Users/codeclouds-bikram/Downloads/CantinaBand3.wav");
				Thread.sleep(10000);

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