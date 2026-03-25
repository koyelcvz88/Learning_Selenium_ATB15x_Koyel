package com.thetestingacademy.Exceptions;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.NoSuchElementException;

public class NoSuchElement {
   EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
         driver = new EdgeDriver(edgeOptions);
    }

    @Description ("Verify NO Such Element Exception")
    @Test
    public void test_actions() throws InterruptedException {
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();
        try {
            driver.findElement(By.id("koyel"));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        driver.get("https://google.com");
        }
    @AfterTest
    public void closeBrowser() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

}
