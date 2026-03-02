package com.thetestingacademy.SeleniumCommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Navigation {
    @Test
    public void test_selenium() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com/");

        // navigation commands
        driver.navigate().to("https://bing.com"); // without http wont work
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
    }

}
