package Labs;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab7 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://letcode.in/alert");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Simple Alert
        driver.findElement(By.id("accept")).click();

        Alert simpleAlert = wait.until(
                ExpectedConditions.alertIsPresent());

        System.out.println("Simple Alert Message : " + simpleAlert.getText());

        simpleAlert.accept();

        // Confirmation Alert
        driver.findElement(By.id("confirm")).click();

        Alert confirmAlert = wait.until(
                ExpectedConditions.alertIsPresent());

        System.out.println("Confirm Alert Message : " + confirmAlert.getText());

        confirmAlert.accept();

        // Prompt Alert
        driver.findElement(By.id("prompt")).click();

        Alert promptAlert = wait.until(
                ExpectedConditions.alertIsPresent());

        System.out.println("Prompt Alert Message : " + promptAlert.getText());

        promptAlert.sendKeys("Kunisha");

        promptAlert.accept();

        driver.quit();
    }
}