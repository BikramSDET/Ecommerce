package Pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Test.BaseComponents.BaseComponentsDemo;

public class CartPage extends BaseComponentsDemo {
	public static WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Global variables
	int totalSumOnSuccess;
	int totalSumOncart;

	public boolean verifyCartDetails() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Cart']")).click();
		Thread.sleep(3000);
		WebElement firstProduct = driver.findElement(By.xpath("//td[text()='" + UserData("firstproduct") + "']"));
		System.out.println(firstProduct.getText());
		WebElement secondProduct = driver.findElement(By.xpath("//td[text()='" + UserData("secondproduct") + "']"));
		System.out.println(firstProduct.getText());
		System.out.println(secondProduct.getText());
		List<WebElement> totalPriceElements = driver.findElements(By.xpath("//h3[@id='totalp']"));
		for (WebElement element : totalPriceElements) {
			// Extract text content
			String text = element.getText();
			// Extract integer value from the text
			int price = Integer.parseInt(text.replaceAll("[^0-9]", ""));
			// Add the integer value to the sum
			totalSumOncart += price;
			
		}
		
		
		System.out.println("Total sum: " + totalSumOncart);
		if (firstProduct.isDisplayed() && secondProduct.isDisplayed()) {
			System.out.println("Element is present on the webpage.");
			return true;
		} else {
			System.out.println("Element is not present on the webpage.");
			return false;
		}

	}

	public void placeOrder() {
		driver.findElement(By.xpath("//button[contains(text(),'Place')]")).click();
	}

	public String fillFormWithoutGivingData() {

		waitFunctionVisibility(driver, driver.findElement(By.xpath("//input[@id='name']")));
		driver.findElement(By.xpath("//button[contains(text(),'Purchase')]")).click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		driver.switchTo().alert().accept();
		return alertText;
	}

	public String fillFormAfterGivingData() {
		waitFunctionClickable(driver.findElement(By.xpath("//input[@id='name']")));
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(UserData("name"));
		driver.findElement(By.xpath("//input[@id='country']")).sendKeys(UserData("country"));
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys(UserData("city"));
		driver.findElement(By.xpath("//input[@id='card']")).sendKeys(UserData("creditcard"));
		driver.findElement(By.xpath("//input[@id='month']")).sendKeys(UserData("month"));
		driver.findElement(By.xpath("//input[@id='year']")).sendKeys(UserData("year"));
		driver.findElement(By.xpath("//button[contains(text(),'Purchase')]")).click();
		waitFunctionVisibility(driver, driver.findElement(By.xpath("//h2[contains(text(),'Thank you')]")));
		String thankYouMessage = driver.findElement(By.xpath("//h2[contains(text(),'Thank you')]")).getText();
		return thankYouMessage;

	}

	public boolean VerifyOrderDetails() {
		String input = driver.findElement(By.xpath("//p[contains(text(),'Id')]")).getText();
		System.out.println(input);
		String[] lines = input.split("\n");
		// Initialize amount variable
		int amount = 0;
		// Iterate through each line
		for (String line : lines) {
			// Check if the line contains "Amount: "
			if (line.contains("Amount: ")) {
				// Split the line by whitespace
				String[] parts = line.split("\\s+");
				// Extract the amount value (assuming it's always the second part)
				amount = Integer.parseInt(parts[1]);
				// Break the loop as we've found the amount
				break;
			}
		}
		// Print the amount value
		System.out.println("Amount found on success  "+ amount + "amount on cart   "+totalSumOncart);
		if(amount==totalSumOncart) {
			return true;
			
		}
		return false;
		
	}

}
