package Labs;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class Lab12TestNG {
	
	WebDriver driver ;
	
    @BeforeMethod
    public void setup() {
    	
    	    WebDriverManager.chromedriver().setup();
    	    
    	    driver = new ChromeDriver();
    	    
    	    driver.manage().window().maximize();
    	    
    	    driver.get(PropertyReader.prop.getProperty("url"));
	  
    }
 
 @Test
  public void registerUser() {
	 
	 driver.findElement(By.linkText(
			 PropertyReader.prop.getProperty("myAccount"))).click();
	 
	 driver.findElement(By.linkText(
			 PropertyReader.prop.getProperty("register"))).click();
	 
	 Assert.assertTrue(
			 
			 driver.findElement(By.xpath(PropertyReader.prop.getProperty("registerHeading"))).isDisplayed());
	 
	 Reporter.log("Register Page Opened" , true);
	 
	 String email = "kunisha" + System.currentTimeMillis() + "@test.com" ;
	 
	 driver.findElement(By.id(PropertyReader.prop.getProperty("firstName"))).sendKeys("Kunisha");
	 
	 driver.findElement(By.id(PropertyReader.prop.getProperty("lastName"))).sendKeys("Dhir");
	 
	 driver.findElement(By.id(PropertyReader.prop.getProperty("email"))).sendKeys(email);
	 
	 driver.findElement(By.id(PropertyReader.prop.getProperty("telephone"))).sendKeys("9876543210");
	 
	 driver.findElement(By.id(PropertyReader.prop.getProperty("password"))).sendKeys("Test123");
	 
	 driver.findElement(By.id(PropertyReader.prop.getProperty("confirm"))).sendKeys("Test123");
	 
	 driver.findElement(By.name(PropertyReader.prop.getProperty("agree"))).click();
	 
	 driver.findElement(By.xpath(PropertyReader.prop.getProperty("continueButton"))).click();
	 
	 System.out.println("Current URL :" + driver.getCurrentUrl());
	 
	 System.out.println("Page Title : " + driver.getTitle());
	 
	 List<WebElement> errors = driver.findElements(By.xpath(PropertyReader.prop.getProperty("errorMessage")));
	 
	 for(WebElement error : errors) {
		 
		 System.out.println("Error : " + error.getText());
	 }
	 
	 if(driver.findElements(By.xpath(PropertyReader.prop.getProperty("warningMessage"))).size() > 0) {
		 
		 System.out.println(
				 driver.findElement(By.xpath(PropertyReader.prop.getProperty("warningMessage"))).getText());
	 }
	 
	 if(driver.findElements(By.xpath(PropertyReader.prop.getProperty("successMessage"))).size() > 0) {
		 
		 String successMessage = driver.findElement(By.xpath(PropertyReader.prop.getProperty("successMessage"))).getText();
		 
		 System.out.println(successMessage);
		 
		 Assert.assertEquals(successMessage , "Your Account Has Been Created!");
		 
		 Reporter.log("Account created successfully" , true);
		 
		 
	 }
	 

	 }
 

  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }

}
