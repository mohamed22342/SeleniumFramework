package com.google.seleniumm.test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class DemoProject {

	public static void main(String[] args) throws InterruptedException {

		// LOGIN STEP
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir" )+
				"\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.saucedemo.com");
		driver.manage().window().maximize();
		WebElement username= driver.findElement(By.id("user-name"));
		username.clear();
		username.sendKeys("standard_user");
		WebElement password = driver.findElement(By.id("password"));
		password.clear();
		password.sendKeys("secret_sauce");
		WebElement element = driver.findElement(By.id("login-button"));
		element.submit();

		// SELECT FROM FILTER PRICE (LOW TO HIGH)
		WebElement OptioList = driver.findElement(By.cssSelector("select.product_sort_container"));
		Select selectlist = new Select(OptioList);
		//do not allow multiple selection
		assertFalse(selectlist.isMultiple());
		assertEquals(4, selectlist.getOptions().size());
		selectlist.selectByValue("lohi");

		// SELECT LOWEST ITEM AFTER FILTER
		// Lowest item
		WebElement lowest= driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
		lowest.click();
		driver.findElement(By.className("shopping_cart_link")).click();
		driver.findElement(By.id("checkout")).click();

		// Add required data
		WebElement Firstname= driver.findElement(By.id("first-name"));
		Firstname.clear();
		Firstname.sendKeys("Mohamed");
		WebElement lastname =driver.findElement(By.id("last-name"));
		lastname.clear();
		lastname.sendKeys("Maged");
		WebElement Zip = driver.findElement(By.id("postal-code"));
		Zip.clear();
		Zip.sendKeys("11728");

		// Complete checkout process
		WebElement checkout= driver.findElement(By.id("continue"));
		checkout.click();
		driver.findElement(By.id("finish")).click();

		// Assert on completion of order FROM HEADER
		WebElement header = driver.findElement(By.className("title"));
		String managerID = header.getText();
		assertTrue(managerID.equals("CHECKOUT: COMPLETE!"));
		System.out.println(managerID);

		WebElement validMSG = driver.findElement(By.className("complete-header"));
		String text= validMSG.getText();
		assertTrue(text.equals("THANK YOU FOR YOUR ORDER"));
		System.out.println(validMSG.getText());

		WebElement EndMSG = driver.findElement(By.className("complete-text"));
		String End =EndMSG.getText();
		assertTrue(End.equals("Your order has been dispatched, and will arrive just as fast as the pony can get there!"));
		System.out.println(EndMSG.getText());

		//BACK TO HOME PAGE
		WebElement back= driver.findElement(By.id("back-to-products"));
		back.click();
	}
 }
