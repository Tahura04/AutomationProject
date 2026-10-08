package com.test_day3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.test_base.BaseTest;

public class Day3_AdminTest extends BaseTest {

    // Unique user name will be generated every time
    String newUsername = "testUser" + System.currentTimeMillis() / 1000;

    @Test(priority = 1)
    public void test1_addUser() throws InterruptedException {
        // Login is already done in BaseTest - No need to call doLogin()
        System.out.println("Creating User: " + newUsername);

        // 1. Click on Admin menu
        driver.findElement(By.xpath("//span[text()='Admin']")).click();
        Thread.sleep(3000);

        // 2. Click on Add button
        driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
        Thread.sleep(3000);

        // 3. Select User Role - ESS
        driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='listbox']//span[text()='ESS']")).click();
        Thread.sleep(1000);

        // 4. Enter Employee Name - type 'a' and select first
        driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("a");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        // 5. Select Status - Enabled
        driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='listbox']//span[text()='Enabled']")).click();
        Thread.sleep(1000);

        // 6. Enter Username and Password
        driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(newUsername);
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("Admin@123");
        driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Admin@123");
        Thread.sleep(2000);

        // 7. Click Save
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(5000);

        // Verify user is added
        Assert.assertTrue(driver.getCurrentUrl().contains("viewSystemUsers"));
        System.out.println("Add User PASS - User Created: " + newUsername);
    }

    @Test(priority = 2)
    public void test2_searchAndDeleteUser() throws InterruptedException {
        // No login needed again - already logged in

        // 1. Click on Admin menu
        driver.findElement(By.xpath("//span[text()='Admin']")).click();
        Thread.sleep(3000);

        // 2. Search for the user created
        driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(newUsername);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);

        // 3. Click on Delete icon
        driver.findElement(By.xpath("//button[i[@class='oxd-icon bi-trash']]")).click();
        Thread.sleep(2000);

        // 4. Confirm Delete
        driver.findElement(By.xpath("//button[normalize-space()='Yes, Delete']")).click();
        Thread.sleep(3000);

        System.out.println("Delete User PASS - User Deleted: " + newUsername);
    }
}