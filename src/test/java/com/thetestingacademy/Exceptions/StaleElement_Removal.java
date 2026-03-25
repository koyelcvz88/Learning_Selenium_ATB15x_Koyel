package com.thetestingacademy.Exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElement_Removal {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");

        WebElement element = driver.findElement(By.id("login-username"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].parentNode.removeChild(arguments[0]);" , element);
        element.click();
    }
}
