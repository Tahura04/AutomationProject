package com.test_base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHelper {
    WebDriver driver;
    public LoginHelper(WebDriver driver) { this.driver = driver; } // Constructor to initialize driver

    // This method performs login action - reusable for all tests
    public void login(String user, String pass) throws InterruptedException {
        Thread.sleep(1000); // Small wait
        driver.findElement(By.cssSelector("//input[@name='username']")).sendKeys(user); // Entering user name
        driver.findElement(By.cssSelector("//input[@name='password']")).sendKeys(pass); // Entering password
        driver.findElement(By.cssSelector("//button[@type='submit']")).click(); // Clicking login button
        Thread.sleep(2000); // Waiting for dash board to load
    }
}