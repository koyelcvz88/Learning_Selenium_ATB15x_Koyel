package com.thetestingacademy.Exceptions;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StaleElementRef {
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
            WebElement search_inputbox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
            driver.navigate().refresh();
            // HTML page DOM is not refreshed
            // Driver will think that, element may or may not available now
            // I have found the element before refresh

            // Refresh, navigte other page, change in DOM elements ( Ajax Calls )
            search_inputbox.sendKeys("Selenium Courses" + Keys.ENTER);
        } catch (StaleElementReferenceException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Handled exception not fixed so that other code can run");
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
