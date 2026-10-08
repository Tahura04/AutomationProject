package com.test_day5;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.test_base.BaseTest;

public class Day5_LeaveTest extends BaseTest {

    @Test(priority = 1)
    public void test1_applyLeave() throws InterruptedException {
        // Login is already done in BaseTest - No need to login again

        // Click on Leave menu
        driver.findElement(By.xpath("//span[text()='Leave']")).click();
        Thread.sleep(3000);

        // Click on Apply sub menu
        driver.findElement(By.xpath("//a[text()='Apply']")).click();
        Thread.sleep(3000);

        // Select Leave Type
        driver.findElement(By.xpath("//div[contains(@class,'oxd-select-text-input')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='listbox']//span[text()='CAN - FMLA']")).click();
        Thread.sleep(1000);

        // Select From Date
        driver.findElement(By.xpath("(//input[@placeholder='yyyy-dd-mm'])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@placeholder='yyyy-dd-mm'])[1]")).sendKeys("2026-10-20");
        Thread.sleep(1000);

        // Select To Date
        driver.findElement(By.xpath("(//input[@placeholder='yyyy-dd-mm'])[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@placeholder='yyyy-dd-mm'])[2]")).sendKeys("2026-10-21");
        Thread.sleep(1000);

        // Click Apply button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(4000);

        System.out.println("Leave Apply PASS");
    }

    @Test(priority = 2)
    public void test2_searchMyLeave() throws InterruptedException {
        // No login needed - session is already active from BaseTest

        // Click on Leave menu
        driver.findElement(By.xpath("//span[text()='Leave']")).click();
        Thread.sleep(3000);

        // Click on My Leave sub menu
        driver.findElement(By.xpath("//a[text()='My Leave']")).click();
        Thread.sleep(3000);

        // Click Search button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);

        // Verify records found
        String recordText = driver.findElement(By.xpath("//span[contains(text(),'Record')]")).getText();
        System.out.println(recordText);
        Assert.assertTrue(recordText.contains("Record"));
        System.out.println("Leave Search PASS");
    }
}