package Labs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab6 {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://tutorialsninja.com/demo/");
		
		// Login
		
		driver.findElement(By.xpath("//span[text() = 'My Account']")).click();
		
		driver.findElement(By.linkText("Login")).click();
		
		driver.findElement(By.id("input-email")).sendKeys("kunisha1790676721257@test.com");
		
		driver.findElement(By.id("input-password")).sendKeys("Test123");
		
		driver.findElement(By.xpath("//input[@value = 'Login']")).click();
		
		// Components -> Monitors
		
		driver.findElement(By.linkText("Components")).click();
		
		driver.findElement(By.linkText("Monitors (2)")).click();
		
		// Show 25
		
		Select showDropdown = new Select(driver.findElement(By.id("input-limit")));
		
		showDropdown.selectByVisibleText("25");
		
		// Add first monitor to cart
		
		driver.findElement(By.xpath("(//span[text() = 'Add to Cart'])[1]")).click();
		
		// Open first monitor
		
		driver.findElement(By.linkText("Apple Cinema 30\"")).click();
		
		// Specification tab
		
		driver.findElement(By.linkText("Specification")).click();
		
		if(driver.findElement(
		        By.xpath("//li[@class='active']/a[text()='Specification']"))
		        .isDisplayed()) {

		    System.out.println("Specification tab is active");
		}
		
		// Verify specification tab
		
		if(driver.findElement(By.linkText("Specification")).isDisplayed()) {
			
			System.out.println("Specification tab is verified");
		}
		
		// Add to Wish List
		
		driver.findElement(By.xpath("//button[@data-original-title = 'Add to Wish List']")).click();
		
		// Verify Success Message 
		
		String wishListMsg = driver.findElement(By.xpath("//div[contains(@class, 'alert-success')]")).getText();
		
		if(wishListMsg.contains("Success: You have added Apple Cinema 30")) {
			
			System.out.println("Wish List message is verified");
		}
		
		// Search Mobile 
		
		WebElement searchBox = driver.findElement(By.name("search"));
		
		searchBox.clear();
		
		searchBox.sendKeys("Mobile");
		
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		
		// Search in Product Description
		
		//driver.findElement(By.linkText("description")).click();
		
		driver.findElement(By.name("description")).click();
        
		driver.findElement(By.id("button-search")).click();
		
		//HTC Touch HD
		
		driver.findElement(By.linkText("HTC Touch HD")).click();
		
		// Quantity
		WebElement qty = driver.findElement(By.id("input-quantity"));
		
		qty.clear();
		qty.sendKeys("3");
		
		// Add to Cart
		
		driver.findElement(By.id("button-cart")).click();
		
		// Verify Cart Success Message
		
		//String cartMsg = driver.findElement(By.xpath("//button[contains(@class,'btn btn-primary btn-lg btn-block')]")).getText();
		
		String cartMsg =
				driver.findElement(
				    By.xpath("//div[contains(@class,'alert-success')]"))
				    .getText();

		System.out.println(cartMsg);
		
		if(cartMsg.contains("Success: You have added HTC Touch HD to your shopping cart")) {
			
			System.out.println("Cart Success Message is verified");
		}
			
			// View Cart
			
			//driver.findElement(By.xpath("//span[text()= 'Shopping Cart']")).click();
			
			driver.findElement(By.linkText("Shopping Cart")).click();
			
			
			// Verify Product
			
			//String productName = driver.findElement(By.xpath("//td[@class = 'text-left']/a")).getText();
			if(driver.getPageSource().contains("HTC Touch HD")) {

			    System.out.println("Product present in cart");
			}
			
//			if(productName.equals("HTC Touch HD")) {
//				
//				System.out.println("Product present in cart");
//			}
				
				// Checkout
				
				driver.findElement(By.linkText("Checkout")).click();
				
			    //My Account
				
				driver.findElement(By.xpath("//span[text()='My Account']")).click();
				
				// Logout
				
				driver.findElement(By.linkText("Logout")).click();
				
				// Verify Logout Heading
				
				String logoutHeading = driver.findElement(By.xpath("//div[@id= 'content']/h1")).getText();
				
				if(logoutHeading.equals("Account Logout")) {
					
					System.out.println("Logout Successful");
				}
				// Continue
				
				driver.findElement(By.linkText("Continue")).click();
				
		        driver.quit();
	}

}
