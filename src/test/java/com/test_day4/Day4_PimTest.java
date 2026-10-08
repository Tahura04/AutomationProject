package com.test_day4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.test_base.BaseTest;

public class Day4_PimTest extends BaseTest {

    String firstName = "Test" + System.currentTimeMillis() / 1000;
    String lastName = "User";

    @Test(priority = 1)
    public void test1_addEmployee() throws InterruptedException {
        // 1. PIM Menu
        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        Thread.sleep(3000);

        // 2. Add Button
        driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
        Thread.sleep(3000);

        // 3. FirstName + LastName
        driver.findElement(By.name("firstName")).sendKeys(firstName);
        driver.findElement(By.name("lastName")).sendKeys(lastName);
        Thread.sleep(2000);

        // 4. Save
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(5000);

        Assert.assertTrue(driver.getCurrentUrl().contains("viewPersonalDetails"));
        System.out.println("PIM Add PASS: " + firstName + " " + lastName);
    }

    @Test(priority = 2)
    public void test2_searchEmployee() throws InterruptedException {
        // 1. PIM Menu
        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        Thread.sleep(3000);

        // 2. Search Name
        driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[1]")).sendKeys(firstName);
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[1]")).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[1]")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        // 3. Search Button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);

        String record = driver.findElement(By.xpath("//span[contains(text(),'Record')]")).getText();
        System.out.println(record);
        System.out.println("PIM Search PASS: " + firstName);
    }
}