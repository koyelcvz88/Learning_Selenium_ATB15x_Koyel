package com.thetestingacademy.Trimont.POM_Code.utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class ScreenshotUtil {

    // Primary method (NEW STANDARD)
    public static void takeScreenshot(WebDriver driver, String stepName) {
        attach(driver, stepName);
    }

    // Backward compatibility (OLD CODE SUPPORT)
    public static void capture(WebDriver driver, String stepName) {
        attach(driver, stepName);
    }

    // Core implementation to take a screenshot and attach it to Allure
    private static void attach(WebDriver driver, String stepName) {
        try {
            if (driver == null) {
                System.out.println("Driver is null, cannot take screenshot.");
                return;
            }

            // Capture screenshot as bytes
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            // Attach screenshot to Allure report
            Allure.addAttachment(stepName, new ByteArrayInputStream(screenshot));

            System.out.println("Screenshot attached for step: " + stepName);
        } catch (Exception e) {
            // Log the error and provide details
            System.out.println("Screenshot failed: " + e.getMessage());
        }
    }
}