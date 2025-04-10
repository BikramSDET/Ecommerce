
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Test.BaseComponents.BaseComponentsDemo;

public class FullScrub extends BaseComponentsDemo

{
	public FullScrub() {
		// Default constructor
	}

	WebDriver chromeDriver1 = InitializeChromeDriver();

//	
	// Extent Report
	private ExtentReports extent;
	private ExtentTest test;

	@Test(groups = {"AffiliateLevel"})
	public void TrackingChrome() throws InterruptedException {

		for (int i = 1; i < 100; i++) {
			System.out.println(i);
			chromeDriver1.get("https://stagesecure.panoramatrack.com/tracking/90/64/");
			chromeDriver1.findElement(By.xpath("//button[text()='Add to Cart']")).click();
			Thread.sleep(5000);
			chromeDriver1.findElement(By.xpath("//a[@class='button']")).click();
		
		
			
		}
		
		
		

	}
//	public static void playSound(String soundFilePath) {
//        try {
//            File soundFile = new File(soundFilePath);
//            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
//            Clip clip = AudioSystem.getClip();
//            clip.open(audioIn);
//            clip.start();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//	public static boolean search(int[] arr, int target) {
//        for (int num : arr) {
//            if (num == target) {
//                return true;
//            }
//        }
//        return false;
//    }

}