package com.test_day6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.test_base.BaseTest;

public class Day6_MyInfoTest extends BaseTest {

    @Test(priority = 1)
    public void test1_verifyMyInfoPage() throws InterruptedException {
        // Login is already done in BaseTest - No need to login again

        // Click on My Info menu
        driver.findElement(By.xpath("//span[text()='My Info']")).click();
        Thread.sleep(4000);

        // Verify My Info page is opened
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("viewPersonalDetails"));
        System.out.println("My Info Page PASS - Page opened successfully");
    }  

    @Test(priority = 2)
    public void test2_updatePersonalDetails() throws InterruptedException {
        // No login needed - session is already active

        // Click on My Info menu
        driver.findElement(By.xpath("//span[text()='My Info']")).click();
        Thread.sleep(4000);

        // Enter Middle Name
        driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(Keys.DELETE);
        driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys("TestMiddle");
        Thread.sleep(1000);

        // Click on First Save button (Personal Details)
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
        Thread.sleep(4000);

        System.out.println("My Info Update PASS - Details updated");
    }
}