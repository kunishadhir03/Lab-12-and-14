package Labs ;

import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

class ExcelUtility {
	
	public static Object[][] getTestData() throws Exception{
		
		FileInputStream file = new FileInputStream("C:\\Training\\Java\\Sep2026\\TestData\\TestDetails.xlsx");
		
		Workbook workbook = new XSSFWorkbook(file);
		
		Sheet sheet = workbook.getSheet("TestDetails");
		
		int rows = sheet.getLastRowNum();
		
		int cols = sheet.getRow(0).getLastCellNum();
		
		Object [][] data = new Object[rows][cols];
		
		DataFormatter formatter = new DataFormatter();
		
		for(int i = 1 ; i <= rows ; i++) {
			
			Row row = sheet.getRow(i);
			
			for(int j = 0 ; j < cols ; j++) {
				
				Cell cell = row.getCell(j);
				
				data[i-1][j] = formatter.formatCellValue(cell);
			}
		}
		
		workbook.close();
		
		return data ; 
	}
}

public class Lab14TestNG {
	
	WebDriver driver ;
	
	@BeforeMethod
	
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://tutorialsninja.com/demo/");
	}
	
	@DataProvider(name = "RegisterData")
	
	public Object[][] getData() throws Exception {
		
		return ExcelUtility.getTestData();
	}
	
	@Test(dataProvider = "RegisterData")
	public void registerUser(String firstName , String lastName , String email , String telephone , String password , String confirmPassword) {
		
		Assert.assertEquals(driver.getTitle(), "Your Store");
		
		Reporter.log("Title Verified" , true);
		
		driver.findElement(By.linkText("My Account")).click();
		
		driver.findElement(By.linkText("Register")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//h1[text()= 'Register Account']")).isDisplayed());
		
		Reporter.log("Register Page Opened" , true);
		
		String uniqueEmail = email + System.currentTimeMillis() + "@test.com";
		
		driver.findElement(By.id("input-firstname")).sendKeys(firstName);
		
		driver.findElement(By.id("input-lastname")).sendKeys(lastName);
		
		driver.findElement(By.id("input-email")).sendKeys(uniqueEmail);
		
		driver.findElement(By.id("input-telephone")).sendKeys(telephone);
		
		driver.findElement(By.id("input-password")).sendKeys(password);
		
		driver.findElement(By.id("input-confirm")).sendKeys(confirmPassword);
		
		driver.findElement(By.name("agree")).click();
		
		driver.findElement(By.xpath("//input[@value = 'Continue']")).click();
		
		String successMessage = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		
		System.out.println("Success Message : " + successMessage);
		
		Assert.assertEquals(successMessage, "Your Account Has Been Created!");
		
		Reporter.log("Account created successfully" , true);
		
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}
}