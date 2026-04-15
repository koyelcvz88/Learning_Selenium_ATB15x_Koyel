package com.thetestingacademy.Trimont.POM_Code.utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class AllureUtils {

    public static void attachScreenshot(WebDriver driver, String name) {

        try {
            if (driver == null) {
                System.out.println("Driver is null, screenshot skipped");
                return;
            }

            byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);

            Allure.addAttachment(
                    name,
                    new ByteArrayInputStream(screenshot)
            );

        } catch (Exception e) {
            System.out.println("Failed to attach screenshot: " + e.getMessage());
        }
    }
}