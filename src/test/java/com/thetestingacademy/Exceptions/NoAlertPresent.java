package com.thetestingacademy.Exceptions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class NoAlertPresent {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://app.vwo.com");

            try {
                Alert alert = driver.switchTo().alert();
                alert.accept();
            } catch (NoAlertPresentException e) {
                System.out.println("No alert found. Continuing execution...");
            }

        } finally {
            driver.quit();
        }
    }
}