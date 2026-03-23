package com.thetestingacademy.Waits;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

/*public class ImplicitWait_Test {
    @Description("Verify Ebay Print the pricess (iMac)")
    @Test
    public void test_verify_print_imac_price() {
        EdgeDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.of(20)); // global wait for all
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();

        WebElement email_input_box = driver.findElement(By.id("login-username")); // id locator
        email_input_box.sendKeys("admin@admin.com");

        WebElement password_input_box = driver.findElement(By.name("password")); // name locator
        password_input_box.sendKeys("wrongpass@123");

        WebElement button_submit = driver.findElement(By.id("js-login-btn")); // id locator
        button_submit.click();
    }
} */
