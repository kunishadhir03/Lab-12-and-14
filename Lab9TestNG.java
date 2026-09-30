package Labs;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Lab9TestNG {
	
	WebDriver driver ;
	
	public void launchBrowser(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")){
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("edge")){
			
			WebDriverManager.edgedriver().setup();
			
			driver = new EdgeDriver();
			
		}
		
		driver.manage().window().maximize();
		
		driver.get("https://tutorialsninja.com/demo/");
	}
  @Test
  public void chromeRegistrationTest() {
	  
	  launchBrowser("chrome");
	  
	  registerUser();
  }
  
  @Test
  
  public void edgeRegistrationTest() {
	  
	  launchBrowser("edge");
	  
	  registerUser();
  }
  
  public void registerUser() {
	  
	  // Verify home page
	  
	  //Assert.assertEquals("Your Store", driver.getTitle());
	  
	  Assert.assertEquals(driver.getTitle(), "Your Store");
	  
	  // My Account
	  
	  driver.findElement(By.linkText("My Account")).click();
	  
	  // Register
	  driver.findElement(By.linkText("Register")).click();
	  
	  // Verify Register Page
	  
	  Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Register Account']")).isDisplayed());
	  
	  // Dynamic Email
	  
	  String email = "kunisha" + System.currentTimeMillis() + "@test.com" ; 
	  
	  // Registration Details
	  
	  driver.findElement(By.id("input-firstname")).sendKeys("Kunisha");
	  
	  driver.findElement(By.id("input-lastname")).sendKeys("Dhir");
	  
	  driver.findElement(By.id("input-email")).sendKeys(email);
	  
	  driver.findElement(By.id("input-telephone")).sendKeys("9876543210");
	  
	  driver.findElement(By.id("input-password")).sendKeys("Test123");
	  
	  driver.findElement(By.id("input-confirm")).sendKeys("Test123");
	  
	  // Newsletter
	  
//	  driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']")).click();
	  
	  // Privacy Policy
	  
	  driver.findElement(By.name("agree")).click();
	  
	  // Continue
	  
	  driver.findElement(By.xpath("//input[@value='Continue']")).click();
	  
	  System.out.println("Current URL = " + driver.getCurrentUrl());

	  System.out.println("Page Title = " + driver.getTitle());

	  // Print field-level errors
	  driver.findElements(By.xpath("//div[contains(@class,'text-danger')]"))
	        .forEach(e -> System.out.println("Field Error: " + e.getText()));

	  // Print top warning message
	  if(driver.findElements(
	          By.xpath("//div[contains(@class,'alert-danger')]"))
	          .size() > 0) {

	      System.out.println(
	          driver.findElement(
	                  By.xpath("//div[contains(@class,'alert-danger')]"))
	                  .getText());
	  }
	  
	  // Verify Success Message
	  
	  //Assert.assertEquals("Your Account Has Been Created!", successMessage);
	  
	  String pageTitle = driver.getTitle();

	  System.out.println("Page Title = " + pageTitle);

	  Assert.assertEquals(
	          pageTitle,
	          "Your Account Has Been Created!");
	  System.out.println("Registration Successful on " + driver.getClass().getSimpleName());
  }
 

  @AfterMethod
  public void tearDown() {
	  
	  if(driver != null) {
		  
		  driver.quit();
	  }
  }

}
