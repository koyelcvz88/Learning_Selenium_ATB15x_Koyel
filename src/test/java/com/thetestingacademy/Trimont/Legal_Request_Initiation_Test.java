package com.thetestingacademy.Trimont;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

@Epic("VenReq Automation Suite")
@Feature("Legal Request Module")
@Story("Initiate Legal Request")
public class Legal_Request_Initiation_Test extends Login_Test {


    /**
     * Reusable method to initiate a legal request
     */
    @Owner("Koyel")
    @Severity(SeverityLevel.CRITICAL)
    //@Test
    @Description("Testcase 1 - Verify user is able to Login & Initiate Legal Request")
    public void initiateLegalRequest() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        Allure.step("Click on Initiate Legal Request", () -> {

            System.out.println("Looking for Initiate Legal Request button...");

            // Wait until button is visible
            WebElement initiateBtn = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//button[.//span[text()='Initiate Legal Request']]")
                    )
            );

            // Scroll to button (prevents overlay issues)
            js.executeScript("arguments[0].scrollIntoView({block:'center'});", initiateBtn);

            // Wait until clickable
            wait.until(ExpectedConditions.elementToBeClickable(initiateBtn));

            // Print to console
            System.out.println("Button found. Clicking now.");
            // Also log in Allure
            Allure.step("Button found. Clicking now.");

            try {
                initiateBtn.click();
            } catch (Exception e) {
                System.out.println("Normal click intercepted, using JS click fallback.");
                js.executeScript("arguments[0].click();", initiateBtn);
            }

            // Wait for the form header
            WebElement legalRequestFormHeader = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//span[contains(text(),'Initiate Legal Matter Request')]")
                    )
            );

            // Print to console
            System.out.println("Initiate Legal Request clicked, form loaded: "
                    + legalRequestFormHeader.getText());
            // Also log in Allure
            Allure.step("Initiate Legal Request clicked, form loaded: " );
        });
    }

}
