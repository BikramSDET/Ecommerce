package Pages;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import Test.BaseComponents.BaseComponentsDemo;

public class SignUpPage extends BaseComponentsDemo {
	public static WebDriver driver;
	

	public SignUpPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String SigningUp() throws InterruptedException {
		driver.get("https://www.demoblaze.com/index.html");
		// WebElemets related to this page
		WebElement signUpButton = driver.findElement(By.cssSelector("#signin2"));
		WebElement userNameField = driver.findElement(By.cssSelector("#sign-username"));
		WebElement passwordField = driver.findElement(By.cssSelector("#sign-password"));
		WebElement signUpButon = driver.findElement(By.xpath("//button[text()='Sign up']"));
//		waitFunctionVisibility(signUpButton);
		Thread.sleep(3000);
		signUpButton.click();
		String userName = UserData("username");
		String password = UserData("password");
		waitFunctionVisibility(driver, userNameField);
		userNameField.sendKeys(userName);
		passwordField.sendKeys(password);
		signUpButon.click();
		waitFunctionAlert();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		driver.switchTo().alert().accept();
		return alertText;
		

	}

}