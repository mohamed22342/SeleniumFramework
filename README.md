# SWAGLABS
##### This repository  includes automated tests for the [Swag Labs](https://www.saucedemo.com) Website
### Packages
The project uses the following packages:
* Selenium WebDriver 4.1.2
* ChromeDriver 98.0.4758.102
* Java JDK 8 or higher
* Apache Maven 3.5.0
## Languages and Frameworks
The project uses the following languages and frameworks:
* Java 8 as the programming language
* Working with Maven framework
* Selenium WebDriver as the web browser automation framework
* WebDriverManager as the Selenium binaries management

## Features

* ##### Add chromedriver.exe in folder in project
* #####  Maven dependencies pom.xml needed
 <dependencies>
*  <dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.1.2</version>
</dependency>

<dependency>
 *   <groupId>br.com.objectos</groupId>
    <artifactId>assertion</artifactId>
    <version>0.9.0</version>
    <scope>test</scope>
</dependency>
* <dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>1.7.36</version>
</dependency>
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-simple</artifactId>
    <version>1.7.36</version>
</dependency>

  </dependencies>

* #### Import 
* import static org.testng.Assert.assertTrue;
* import static org.testng.AssertJUnit.assertEquals;
* import static org.testng.AssertJUnit.assertFalse;
* import org.openqa.selenium.By;
* import org.openqa.selenium.WebDriver;
* import org.openqa.selenium.WebElement;
* import org.openqa.selenium.chrome.ChromeDriver;
* import org.openqa.selenium.support.ui.Select;

##### First open [Swag Labs](https://www.saucedemo.com) Website
 login with  ` username` and `password`.
 Need to find elements to both fields username,password to send key and then click to button login
 From inspect turn to find id first to both fields using WebElement.
 
 ```sh
     WebElement username= driver.findElement(By.id("user-name"));
	 WebElement password = driver.findElement(By.id("password"));

```
Then clear fileds with method `.clear()` to make sure that send data in empty fields.
Send key with method `.sendkeys()`.
 ```sh
username.sendKeys("standard_user");
password.sendKeys("secret_sauce");
```
After used methods to clear and to send data to full fields to login into website, need to click to button login to go to website. 
Using else WebElement to find element button to click on it.
```sh
		WebElement element = driver.findElement(By.id("login-button"));
````
After received element for button use method `.submit()  ` to send data and login in website.


### Want To Selected Lowest Price and add it to cart

After we have logged in, the home page appears.
Find filter in home page contains optionList
* Name(A to Z)
* Name (Z to A)
* Price(Low to High)
* Price (High to Low)

Then tried filter that do this function for sorting.
After making sure the filter is working as it should, get element form this to select from filter third option `Price(Low to High)`.
```sh
WebElement OptioList = driver.findElement(By.cssSelector("select.product_sort_container"));
 ```
Filter will sorted items form lowest to highest.
Using method `Select` to select third option from filter and sorted items from lowest to highest
```sh
  Select selectlist = new Select(OptioList);
```
When using method select should to make sure that filter not allowed double selection using assertion for this  `assertFalse(selectlist.isMultiple());`

Want to select third option from filter, still using assertion but this time from assert types is assertEquals then get value from this option from inspect to select this option by using `selectByValue`

```sh
		assertEquals(4, selectlist.getOptions().size());
		selectlist.selectByValue("lohi");
```
After select this option items sorted from lowest to highest then select lowest item by using Webelement and get `id` from button add to cart to added item to cart 
```sh
		WebElement lowest= driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
		lowest.click();
```
Then wanted to click to cart to continue procces to checkout, else using WebElement to get `id` to click to this cart to continue process.

```sh
	driver.findElement(By.id("shopping_cart_container")).click();
```
After click to cart , in page your cart see that our item selected and price then click to checkout to continue process, that need to get element for this button to click on it.
```sh
   		driver.findElement(By.id("checkout")).click();
```
In Information page, see three required fields need to add data to continue process .
The fields will be dealt with as was done with the registration form, that wanted to find element to this fileds from inspect...
```sh
	WebElement Firstname= driver.findElement(By.id("first-name"));
	WebElement lastname =driver.findElement(By.id("last-name"));
	WebElement Zip = driver.findElement(By.id("postal-code"));
```
After get element for three fileds using method `.clear();` to make sure that fileds empty to send data, then send data to this fileds using method `.sendkeys();`
Everything is ready to send the data to this fileds
```sh
		Firstname.sendKeys("Mohamed");
		lastname.sendKeys("Maged");
		Zip.sendKeys("11728");
````
After add data in fields, wanted to  click button Continue to send to next page, after recived element about `id` for button Continue and use method `.click` sent to next page.

After click the continue button, I will be sent to the OverView page 
This page describe item from type,price,quantity,tax that addition to invoice,shipping and payment information.
This steps Overview order, wanted to go to next step then wanted to get element for button Finish using WebElement `id` and method `.click()`.
```sh
		driver.findElement(By.id("finish")).click();
```
Click to button Finish to end this process
Wanted to assert completion order, that using method `asssertion` to check this and make sure that process be finish.
Using first thing assert to header tittle, that tittle here was COMPLETE, this first validation want to check for it.
Used type from assertion that `assertTrue`, this means that send valid message wanted to appear when this process end, before used assertTrue create obeject from type `String` to put header message that appear and compare between it and expected message.
Then retrieve message and print it after comparison.
```sh
    String managerID = header.getText();
    assertTrue(managerID.equals("CHECKOUT: COMPLETE!"));
    System.out.println(managerID);
```

Make sure that process already finish second validation message,that appear in half screen.
Get firstly element to this text using find element with className.
` WebElement EndMSG = driver.findElement(By.className("complete-text"))`
Using else assertion type for this `assertTrue ` that also get valid message to make sure that process end, order will be requested, before it also created object and do same thing with this assertion.
```sh
Sring text= validMSG.getText();
assertTrue(text.equals("THANK YOU FOR YOUR ORDER"));
```     
  then print message after comparison expected and actual.
  ``` sh
        System.out.println(validMSG.getText());
 ```
Then Want to go back home page, using WebElement to find element `id` to click to there button BACK HOME 
```sh
 WebElement back= driver.findElement(By.id("back-to-products"));
 back.click();
 ```
Then click to button BACK HOME.
