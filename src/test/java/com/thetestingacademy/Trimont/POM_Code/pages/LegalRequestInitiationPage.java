package com.thetestingacademy.Trimont.POM_Code.pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.thetestingacademy.Trimont.POM_Code.utils.ScreenshotUtil; // Assuming ScreenshotUtil is created

import java.time.Duration;

public class LegalRequestInitiationPage {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public LegalRequestInitiationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        this.js = (JavascriptExecutor) driver;
    }

    // Locators
    private By initiateBtn =
            By.xpath("//button[.//span[text()='Initiate Legal Request']]");

    private By formHeader =
            By.xpath("//span[contains(text(),'Initiate Legal Matter Request')]");

    // Actions
    public void clickInitiateLegalRequest() {

        // Log the step and take a screenshot if needed
        Allure.step("Locate Initiate Legal Request button", () -> {
            System.out.println("Looking for Initiate Legal Request button...");
            ScreenshotUtil.takeScreenshot(driver, "InitiateLegalRequestButtonLocated");
        });

        // Wait until the button is visible
        WebElement btn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(initiateBtn)
        );

        // Scroll to the button
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", btn);

        // Wait until button is clickable
        wait.until(ExpectedConditions.elementToBeClickable(btn));

        // Log the step and take a screenshot after the button is ready
        Allure.step("Initiate button found and ready to click", () -> {
            System.out.println("Button found. Clicking now.");
            ScreenshotUtil.takeScreenshot(driver, "InitiateLegalRequestButtonReady");
        });

        // Try clicking the button, fallback to JS click if necessary
        try {
            btn.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", btn);
        }

        // Wait for the form header to be visible
        WebElement header = wait.until(
                ExpectedConditions.visibilityOfElementLocated(formHeader)
        );

        // Log the step and take a screenshot after the form is loaded
        Allure.step("Form loaded successfully", () -> {
            System.out.println("Form loaded: " + header.getText());
            ScreenshotUtil.takeScreenshot(driver, "InitiateLegalRequestFormLoaded");
        });
    }
}