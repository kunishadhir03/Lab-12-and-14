package Labs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab5 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://tutorialsninja.com/demo/");

		// Part 1

		String title = driver.getTitle();

		if (title.equals("Your Store")) {

			System.out.println("Title is matching.");
		}

		else {

			System.out.println("Title is not matching.");
		}

		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();

		if (driver.findElement(By.xpath("//h1[text() = 'Register Account']")).isDisplayed()) {

			System.out.println("Register Account heading is displaying.");
		}

		else {

			System.out.println("Register Account heading is not displayed.");
		}

		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		String warningMessage = driver.findElement(By.xpath("//div[@class= 'alert alert-danger alert-dismissible']"))
				.getText();

		if (warningMessage.equals("Warning: You must agree to the Privacy Policy!")) {

			System.out.println("Warning is displayed.");
		}

		else {

			System.out.println("Warning message is not displayed.");
		}

		System.out.println("----------------------------");

		// First Name Validation
		driver.findElement(By.id("input-firstname")).sendKeys("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFG");

		driver.findElement(By.xpath("//input[@value = 'Continue']")).click();

		System.out.println(driver
				.findElement(By.xpath("//div[contains(text() , 'First Name must be between 1 and 32 characters!')]"))
				.getText());

		driver.findElement(By.id("input-firstname")).clear();

		driver.findElement(By.id("input-firstname")).sendKeys("kunisha");

		// Last Name validation
		driver.findElement(By.id("input-lastname")).sendKeys("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFG");

		driver.findElement(By.xpath("//input[@value = 'Continue']")).click();

		System.out.println(driver
				.findElement(By.xpath("//div[contains(text() , 'Last Name must be between 1 and 32 characters!')]"))
				.getText());

		driver.findElement(By.id("input-lastname")).clear();

		driver.findElement(By.id("input-lastname")).sendKeys("dhir");

		// Email
		String email = "kunisha" + System.currentTimeMillis() + "@test.com";

		System.out.println(email);

		driver.findElement(By.id("input-email")).sendKeys(email);

		// Telephone
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");

		System.out.println("------------------------------");

		// Password Validation

		driver.findElement(By.id("input-password")).sendKeys("ABCDEFGHIJKLMNOPQRSTUVWXYZ");

		driver.findElement(By.id("input-confirm")).sendKeys("ABCDEFGHIJKLMNOPQRSTUVWXYZ");

		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		for (WebElement e : driver.findElements(By.xpath("//div[contains(@class,'text-danger')]"))) {

			System.out.println(e.getText());
		}

		System.out.println("Validation Messages:");

		System.out.println(driver.findElements(By.id("input-password")).size());

		// driver.findElement(By.id("input-password")).clear();

		if (driver.findElements(By.id("input-password")).size() > 0) {

			driver.findElement(By.id("input-password")).clear();

			driver.findElement(By.id("input-password")).sendKeys("Test123");

			driver.findElement(By.id("input-confirm")).clear();

			driver.findElement(By.id("input-confirm")).sendKeys("Test123");
		}

		else {

			System.out.println("Password field not present on page.");
		}

		System.out.println("-----------------------");
		
		driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']")).click();

		driver.findElement(By.name("agree")).click();

		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		for(WebElement error :
	        driver.findElements(
	                By.xpath("//div[contains(@class,'text-danger')]"))) {

	    System.out.println("Error : " + error.getText());
	}
		
		String successMessage =
		        driver.findElement(By.xpath("//div[@id='content']/h1"))
		              .getText();

		System.out.println("Heading = " + successMessage);

	}

}
