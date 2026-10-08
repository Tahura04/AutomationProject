package com.test_day2;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.test_base.BaseTest;

public class Day2_LoginTest extends BaseTest {

    @Test
    public void test1_validLogin_success() throws InterruptedException {
        Thread.sleep(3000); // Page load wait
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("dashboard"), "Dashboard should open");
        System.out.println("Valid PASS - " + url);
    }

    @Test
    public void test2_invalidLogin_fail() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.name("username")).sendKeys("wrongUser");
        driver.findElement(By.name("password")).sendKeys("wrongPass");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        String error = driver.findElement(By.xpath("//p[text()='Invalid credentials']")).getText();
        Assert.assertEquals(error, "Invalid credentials");
        System.out.println("Invalid PASS - Error: " + error);
    }

    @Test
    public void test3_emptyField_showsError() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);
        String req = driver.findElement(By.xpath("//span[text()='Required']")).getText();
        Assert.assertEquals(req, "Required");
        System.out.println("Empty PASS - Required error shown");
    }
}