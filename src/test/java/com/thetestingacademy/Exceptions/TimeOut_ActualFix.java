package com.thetestingacademy.Exceptions;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TimeOut_ActualFix {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
        driver.manage().window().maximize();
    }

    @Description("Demonstrate TimeoutException and recovery")
    @Test
    public void testTimeoutException() {
        try {
            driver.get("https://www.google.com");

            // 1️⃣ Attempt to find a non-existing element to trigger TimeoutException
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nonExistingId")));

        } catch (TimeoutException e) {
            System.out.println("⚠️ TimeoutException caught!");
            System.out.println("Message: " + e.getMessage());
        }

        // 2️⃣ Recovery: Find a valid element and perform a search
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement searchBox = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.name("q"))
            );

            searchBox.sendKeys("POM Framework" + Keys.ENTER);
            System.out.println("✅ Successfully performed search after handling TimeoutException.");
        } catch (Exception e) {
            System.out.println("❌ Failed to recover: " + e.getMessage());
        }

        System.out.println("End of Program");
    }

    @AfterTest
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}