package com.thetestingacademy.Exceptions;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class InvalidSelector {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
    }

    @Description("Verify Invalid Selector Exception")
    @Test
    public void test_actions() {
        try {
            driver.get("https://google.com");
            driver.manage().window().maximize();

            // Wait until the search box is visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                    ("//button[@type='button'[100]"))); // invalid syntax

            // Attempt to click the button (will throw ElementClickInterceptedException)
            WebElement button = driver.findElement(By.xpath("//button[@type='button'[100]"));
            button.click();

        } catch (InvalidSelectorException e) {
            System.out.println("InvalidSelectorException caught!");
            System.out.println(e);
        }
        System.out.println("End of the Program");
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
