package com.thetestingacademy.XPath;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})

public class OrangeHRM_Test {
    @Owner("Koyel")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that the user is able to login to OrangeHRM")
    @Test
    public void test_OHRM_login() throws InterruptedException {
        Allure.step("Starting OrangeHRM test in Allure");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement button = driver.findElement(By.xpath("//button"));

        username.sendKeys("admin");
        password.sendKeys("Hacker@4321");
        button.click();
        Thread.sleep(5000);

        WebElement h6 = driver.findElement(By.xpath("//span[@class=\"oxd-topbar-header-breadcrumb\"]/h6"));

        Assert.assertEquals(h6.getText(), "PIM");

        //driver.quit();
    }
}
