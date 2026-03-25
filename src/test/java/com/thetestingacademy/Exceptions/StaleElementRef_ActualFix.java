package com.thetestingacademy.Exceptions;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

import java.time.Duration;

public class StaleElementRef_ActualFix {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
    }

    @Description("Verify State Element Reference Exception")
    @Test
    public void test_actions() {
        try {
            driver.get("https://google.com");
            driver.manage().window().maximize();

            // Wait until the search box is visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement search_inputbox = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath
                            ("//textarea[@id='APjFqb'] | //input[@name='q']")));

            // Cause the element to go stale by refreshing the page
            driver.navigate().refresh();
            // HTML page DOM is not refreshed
            // Driver will think that, element may or may not available now
            // I have found the element before refresh

            // Refresh, navigte other page, change in DOM elements ( Ajax Calls )

            // refind element
            search_inputbox = driver.findElement(By.xpath("//textarea[@id='APjFqb'] | //input[@name='q']"));

            // Trying to interact with the old element triggers StaleElementReferenceException
            search_inputbox.sendKeys("Selenium Courses" + Keys.ENTER);
        } catch (StaleElementReferenceException e) {
            System.out.println(e.getMessage());
        }

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
