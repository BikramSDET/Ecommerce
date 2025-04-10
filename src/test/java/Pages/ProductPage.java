package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Test.BaseComponents.BaseComponentsDemo;

public class ProductPage extends BaseComponentsDemo {
	public static WebDriver driver;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void selectProduct() throws InterruptedException {
		driver.get("https://www.demoblaze.com/index.html");
		// webElements
//		String categoryNameEle= "//a[text()='"+UserData("category")+"']";
		String productNameEle = "//a[text()='" + UserData("firstproduct") + "']";
		System.out.println(productNameEle);
		WebElement categoryEle = driver.findElement(By.xpath("//a[text()='" + UserData("firstcategory") + "']"));
		waitFunctionVisibility(driver, categoryEle);
		categoryEle.click();
		Thread.sleep(3000);
		WebElement productEle = driver.findElement(By.xpath(productNameEle));
		productEle.click();
		addToCart();
		driver.get("https://www.demoblaze.com/index.html");
		// webElements
//		String categoryNameEle= "//a[text()='"+UserData("category")+"']";
		productNameEle = "//a[text()='" + UserData("secondproduct") + "']";
		System.out.println(productNameEle);
		categoryEle = driver.findElement(By.xpath("//a[text()='" + UserData("secondcategory") + "']"));
		waitFunctionVisibility(driver, categoryEle);
		categoryEle.click();
		Thread.sleep(3000);
		productEle = driver.findElement(By.xpath(productNameEle));
		productEle.click();

	}

	public String addToCart() throws InterruptedException {
		Thread.sleep(2000);
		WebElement cartButton = driver.findElement(By.xpath("//a[text()='Add to cart']"));
		waitFunctionVisibility(driver, cartButton);
		cartButton.click();
		waitFunctionAlert();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		driver.switchTo().alert().accept();
		return alertText;

	}

}
