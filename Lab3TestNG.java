package Labs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab3TestNG {
	
	WebDriver driver ;
	
	@BeforeMethod
	
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://tutorialsninja.com/demo/");
		
		Reporter.log("Browser launched" , true);
	}
	
	@Test
	
	public void verifyTitle() {
		
		String actualTitle = driver.getTitle();
		
		Reporter.log("Title : " + actualTitle , true);
		
		Assert.assertEquals(actualTitle, "Your Store");
		
		Reporter.log("Title verification passed" , true);
	}
	
	@AfterMethod
	
	public void tearDown() {
		
		driver.quit();
		
		Reporter.log("Browser closed" , true);
	}
	
}
