package com.thetestingacademy.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FlightBooking_Task {

    @Test
    public void test_Flight_Booking() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);

            System.out.println("Opening Booking.com...");
            driver.get("https://www.booking.com");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // Wait for page body to ensure page loaded
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
            Thread.sleep(3000);

            // 🔹 Handle popup if visible
                WebElement closeModal = wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.xpath("//button[contains(@aria-label,'close') or contains(@aria-label,'Dismiss')]")
                        )
                );
                closeModal.click();
                System.out.println("Popup closed");
            // 🔹 Click Flights tab
                WebElement flightsTab = wait.until(
                        ExpectedConditions.elementToBeClickable(By.id("flights")));
                flightsTab.click();
                System.out.println("Flights tab clicked");
                Thread.sleep(3000); // allow Flights section to render

            // 🔹 Click "Going to" span using normalize-space
            WebElement goingToSpan = wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.xpath("//span[normalize-space(text())='Going to']")));

                Thread.sleep(5000); // moderate wait
                goingToSpan.click();
                System.out.println("Clicked 'Going to' span");

                // Wait for input inside the container
                WebElement destinationInput = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.xpath("//input[@data-ui-name='input_text_autocomplete']")));
                destinationInput.click();
                System.out.println("Clicked 'Destination'");
        // Actions chain
        Actions actions = new Actions(driver);
        actions
                .sendKeys(destinationInput, "DELHI") // type destination
                .pause(Duration.ofSeconds(2))        // moderate wait for suggestions
                .sendKeys(Keys.TAB)                  // focus moves to first suggestion
                .sendKeys(Keys.ENTER)                // selects it
                .build()
                .perform();

        System.out.println("Destination selected using Actions + TAB + ENTER");

                /*wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                        "//button[.//span[]text()='Search']]"))).click();

                // Check flights page
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                        "//span[normalize-space()='Trending']")));
                Assert.assertTrue(driver.getCurrentUrl().contains("fly-anywhere"));
            Thread.sleep(5000); // pause to observe behavior

            System.out.println("Test complete."); */
            // driver.quit(); // Keep browser open for further automation
        }
}