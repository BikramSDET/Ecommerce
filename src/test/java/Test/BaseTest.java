package Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.util.Assert;

import Test.AbstractComponent.AbstractComponent;
import Test.BaseComponents.BaseComponentsDemo;
import Pages.CartPage;
import Pages.LoginPage;
import Pages.ProductPage;
import Pages.SignUpPage;

public class BaseTest extends BaseComponentsDemo

{
	public BaseTest() {
		// Default constructor
	}

	WebDriver driver = InitializeChromeDriver();
//	WebDriver driver = initializeDriver();
	// Extent Report
	private ExtentReports extent;
	private ExtentTest test;

	// Page Objects
	SignUpPage SignUpObj = new SignUpPage(driver);
	LoginPage LoginObj = new LoginPage(driver);
	ProductPage productObj = new ProductPage(driver);
	CartPage cartObj = new CartPage(driver);

	@Test(priority = 1)
	public void signUpTest() throws InterruptedException {
		String succesMessage = SignUpObj.SigningUp();
		assertEquals(succesMessage, "This user already exist.");
	}

	@Test(priority = 2)
	public void loginTest() throws InterruptedException {
		boolean result = LoginObj.Login();
		assertEquals(result, true);

	}

	@Test(priority = 3)
	public void selectProductAndAddToCartTest() throws InterruptedException {
		productObj.selectProduct();
		String result = productObj.addToCart();
		assertEquals(result, "Product added.");

	}

	@Test(priority = 4)
	public void VerifyCartProducts() throws InterruptedException {

		boolean result = cartObj.verifyCartDetails();
		assertEquals(result, true);
		cartObj.placeOrder();
//		cartObj.fillForm();

	}

	@Test(priority = 5)
	public void PurchaseWithoutFillingTheForm() throws InterruptedException {
		String result = cartObj.fillFormWithoutGivingData();
		assertEquals(result, "Please fill out Name and Creditcard.");

	}

	@Test(priority = 6)
	public void PurchaseAfterFillingTheForm() throws InterruptedException {
		String result = cartObj.fillFormAfterGivingData();
		assertEquals(result, "Thank you for your purchase!");

	}

	@Test(priority = 7)
	public void VerifyOrderDetails() throws InterruptedException {
		boolean result =cartObj.VerifyOrderDetails();
		assertEquals(result, true);
		
	}
	
	@AfterTest
	public void quitDriver() {
		driver.quit();
	}

}