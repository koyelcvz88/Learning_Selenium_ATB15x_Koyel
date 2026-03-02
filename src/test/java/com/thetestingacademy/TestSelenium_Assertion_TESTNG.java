package com.thetestingacademy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
public class TestSelenium_Assertion_TESTNG {
    @Test
    public void test_selenium() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com/");

        //TestNG
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com/");
        Assert.assertEquals(driver.getTitle(), "Google");

        // Assert J
        //assertThat(driver.getCurrentUrl()).isNotBlank().isNotEmpty().isNotNull().isEqualTo("Google");

        driver.quit();
    }
}
