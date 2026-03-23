package com.thetestingacademy.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Wait_Task_4thMar {


    public static void main(String[] args) {

        // Launch browser
        WebDriver driver = new ChromeDriver();

        // Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Open URL
            driver.get("https://app.vwo.com/#/login");

            // Maximize window
            driver.manage().window().maximize();

            // Wait for Email field and enter email
            WebElement emailInput = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("login-username"))
            );
            emailInput.sendKeys("admin@admin.com");

            // Wait for Password field and enter password
            WebElement passwordInput = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("login-password"))
            );
            passwordInput.sendKeys("admin");

            // Wait for Login button and click
            WebElement loginButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("js-login-btn"))
            );
            loginButton.click();

            // Wait for error message
            WebElement errorMsg = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.className("notification-box-description"))
            );

            String actualError = errorMsg.getText();
            String expectedError = "Your email, password, IP address or location did not match";

            // Validation
            if (actualError.contains(expectedError)) {
                Assert.assertEquals(actualError,expectedError);
                System.out.println("Message: " + actualError);
                System.out.println("✅ Test Passed: Error message is displayed correctly");
            } else {
                System.out.println("❌ Test Failed");
                System.out.println("Actual: " + actualError);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close browser
            driver.quit();
        }
    }
}
