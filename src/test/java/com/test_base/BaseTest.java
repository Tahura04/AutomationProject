
package com.test_base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.time.Duration;

public class BaseTest {

    public WebDriver driver; // WebDriver instance for browser control

    @BeforeClass // This will run only ONE time for all tests in a class
    public void setup() throws InterruptedException {
        // Launching Chrome Browser
        driver = new ChromeDriver();

        // Maximizing browser window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Opening OrangeHRM URL
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Waiting for page to load
        Thread.sleep(2000);

        // Login Once - For all tests
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(4000);
        System.out.println("Login Done - One Time Only");
    }

    @AfterClass // This will run after all tests are finished
    public void tearDown() {
        // Closing browser after all tests
        if (driver != null) {
            driver.quit();
        }
    }
}