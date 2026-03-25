package com.thetestingacademy.Exceptions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class NoSuchFrame {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://app.vwo.com");

            try {
                driver.switchTo().frame(1);
            } catch (NoSuchFrameException e) {
                System.out.println("Frame not found. Switching to default content.");
                System.out.println("Exception message: " + e.getMessage());
                e.printStackTrace();
                driver.switchTo().defaultContent();
            }

        } finally {
            driver.quit();
        }
    }
}