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

public class TimeOut {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
    }

    @Description("Verify Timeout Exception")
    @Test
    public void test_actions() {
        try {
            driver.get("https://google.com");
            driver.manage().window().maximize();
            // Wait until the search box is visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            //wait.until(
                    //ExpectedConditions.visibilityOfElementLocated(By.xpath
                            //("//textarea[@id='abc'] | //input[@name='q']"))); // wrong xpath

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("nonExistingId"))); // wrong xpath

            //WebElement search_inputbox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
            driver.navigate().refresh();

            //search_inputbox.sendKeys("POM Framework" + Keys.ENTER);
        } catch (TimeoutException e) {
            System.out.println("TimeoutException caught!");
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
