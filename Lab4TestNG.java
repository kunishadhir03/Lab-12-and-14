package Labs;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class Lab4TestNG {
	
	WebDriver driver ;
  @BeforeMethod
  public void setup() {
	  
	  WebDriverManager.chromedriver().setup();
	  
	  driver = new ChromeDriver();
	  
	  driver.get("https://tutorialsninja.com/demo/");
  }
  
  @Test
  public void registerUser() {
	  
	  driver.findElement(By.linkText("My Account")).click();
	  
	  driver.findElement(By.linkText("Register")).click();
	  
	  Assert.assertTrue(
			  driver.findElement(
					  By.xpath("//h1[text()= 'Register Account']")).isDisplayed());
	  
	  Reporter.log("Register Page Opened" , true);
	  
	  String email = "kunisha" + System.currentTimeMillis() + "@test.com";
	  
	  driver.findElement(By.id("input-firstname")).sendKeys("Kunisha");
	  
	  driver.findElement(By.id("input-lastname")).sendKeys("Dhir");
	  
	  driver.findElement(By.id("input-email")).sendKeys(email);
	  
	  driver.findElement(By.id("input-telephone")).sendKeys("9876543210");
	  
	  driver.findElement(By.id("input-password")).sendKeys("Test123");
	  
	  driver.findElement(By.id("input-confirm")).sendKeys("Test123");
	  
	  driver.findElement(By.name("agree")).click();
	  
	  driver.findElement(By.xpath("//input[@value='Continue']")).click();
	  
	  
	  
	  //String successMessage = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
//	  
//	  Assert.assertEquals(successMessage , "Your Account Has Been Created!");
//	  
//	  Reporter.log("Account created successfully" , true);
	  
	  System.out.println("Current URL: " + driver.getCurrentUrl());
	  
	  System.out.println("Page Title: " + driver.getTitle());
	  
	  for(WebElement error :
		  driver.findElements(
		  By.xpath("//div[contains(@class,'text-danger')]"))) {
		  System.out.println("Error: " + error.getText());
		  }
	  
	  if(driver.findElements(
			  By.xpath("//div[contains(@class,'alert-danger')]")).size() > 0) {
			  System.out.println(
			  driver.findElement(
			  By.xpath("//div[contains(@class,'alert-danger')]"))
			  .getText());
			  }
	  
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }

}
