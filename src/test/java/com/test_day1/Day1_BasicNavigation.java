package com.test_day1;
import com.test_base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day1_BasicNavigation extends BaseTest {
    @Test
    public void test1_LoginPageTitle() {
        // Verifying Login text is displayed on login page
        String title = driver.findElement(By.cssSelector("//h5[text()='Login']")).getText();
        Assert.assertEquals(title, "Login"); // Assertion - expected vs actual
        System.out.println("Day1 PASS - Login Page Open");
    }
    @Test
    public void test2_LogoDisplayed() {
        // Checking if company logo is visible on page
        boolean logo = driver.findElement(By.cssSelector("//img[@alt='company-branding']")).isDisplayed();
        Assert.assertTrue(logo); // True if logo is displayed
        System.out.println("Day1 PASS - Logo Displayed");
    }
}