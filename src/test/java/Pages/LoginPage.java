package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Test.BaseComponents.BaseComponentsDemo;

public class LoginPage extends BaseComponentsDemo {
	public static WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean Login() throws InterruptedException {
		driver.get("https://www.demoblaze.com/index.html");
		WebElement loginButtonele = driver.findElement(By.cssSelector("#login2"));
		WebElement usernameFieldele = driver.findElement(By.cssSelector("#loginusername"));
		WebElement passwordFieldele = driver.findElement(By.cssSelector("#loginpassword"));
		loginButtonele.click();
		waitFunctionVisibility(driver, usernameFieldele);
		usernameFieldele.sendKeys(UserData("username"));
		passwordFieldele.sendKeys(UserData("password"));
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		Thread.sleep(3000);
		String username =driver.findElement(By.xpath("//li[@class='nav-item']/a[@id='nameofuser']")).getText();
		String usernameAfterSplit = username.split(" ")[1];
//		System.out.println(usernameAfterSplit);
//		System.out.println("name we got "+usernameAfterSplit  + "  name from properties file " + UserData("username") );
		if(usernameAfterSplit.equals(UserData("username"))) {
			System.out.println(true);
			return true;
		}
		else
		{
			System.out.println(false);
			return false;
		}
		
	}

}
