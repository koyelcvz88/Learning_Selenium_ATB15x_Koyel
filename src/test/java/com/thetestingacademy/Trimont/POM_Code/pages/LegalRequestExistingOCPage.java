package com.thetestingacademy.Trimont.POM_Code.pages;

import com.thetestingacademy.Trimont.POM_Code.utils.ScreenshotUtil;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LegalRequestExistingOCPage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    JavascriptExecutor js;

    public LegalRequestExistingOCPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        this.actions = new Actions(driver);
        this.js = (JavascriptExecutor) driver;
    }

    // Stored values for validation
    protected String requestMatterEx;
    protected String selectedOCFirm;
    protected String selectedAttorney;
    protected String isOCConflicted;


    public void fillExistingOCRequest() {

        // STEP 1: Request Matter
        Allure.step("Entering Request Matter", () -> {
            WebElement requestMatterExTxtBox = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//label[contains(text(),'Request/Matter Name')]/following::input[1]")
                    )
            );
            Thread.sleep(1000); // stabilization
            requestMatterExTxtBox.click();
            requestMatterEx = "Ex_OC_New_Legal_Request";  // store value for summary
            requestMatterExTxtBox.sendKeys(requestMatterEx);

            // Print to console
            System.out.println("Request Matter entered: " + requestMatterEx);
            // Also log in Allure
            Allure.step("Request Matter entered: " + requestMatterEx);
        });

        // STEP 2: Select OC Firm
        Allure.step("Selecting Outside Counsel Firm", () -> {
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class,'DropdownWidget---dropdown_value') and contains(., '---Select Outside Counsel Firm Name---')]")
            ));
            Thread.sleep(1000);
            dropdown.click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.attributeContains(dropdown, "aria-expanded", "true"));
            dropdown.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

            // Store the selected firm
            selectedOCFirm = "Alston & Bird";

            // Print to console
            System.out.println("Outside Counsel Firm selected: " + selectedOCFirm);
            // Also log in Allure
            Allure.step("Outside Counsel Firm selected: " + selectedOCFirm);
        });

        // STEP 3: Validate OC Firm
        Allure.step("Validate OC Firm Name", () -> {
            try {
                WebElement firmValue = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.xpath("//strong[normalize-space()='OC Firm Name']/following::em[contains(@class,'EmphasisText')][1]")
                        )
                );

                Thread.sleep(1500);

                String actualFirm = firmValue.getText().trim();

                Thread.sleep(1500);

                System.out.println("Expected Firm: " + selectedOCFirm);
                System.out.println("Actual Firm: " + actualFirm);

                Assert.assertEquals(actualFirm, selectedOCFirm,
                        "OC Firm mismatch. Expected: " + selectedOCFirm + " but found: " + actualFirm);

                Allure.step("Validation PASSED: OC Firm matches");
                ScreenshotUtil.takeScreenshot(driver, "OC Firm Validated");

            } catch (Exception e) {
                ScreenshotUtil.takeScreenshot(driver, "OC Firm Validation Failed");
                throw new RuntimeException(e);
            }
        });

        // STEP 4: Select Attorney
        Allure.step("Selecting first Contact Attorney", () -> {

            WebElement dropdown = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//div[contains(@class,'DropdownWidget---dropdown_value') and contains(., '---Select Contact Attorney---')]")
                    )
            );

            Thread.sleep(1000);
            dropdown.click();
            Thread.sleep(1000);

            // wait for dropdown open
            wait.until(ExpectedConditions.attributeContains(dropdown, "aria-expanded", "true"));
            dropdown.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

            // Store the selected Attorney
            selectedAttorney = "Elizabeth Murphy";

            // Print to Console
            System.out.println("Contact Attorney selected: " + selectedAttorney);
            // Also in Allure
            Allure.step("Contact Attorney selected: " + selectedAttorney);
        });
        // STEP 5: Validate Attorney
        Allure.step("Validate Attorney", () -> {
            try {
                Thread.sleep(1500);

                WebElement attorneyValue = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.xpath("//em[normalize-space()='" + selectedAttorney + "']")
                        )
                );

                String actualAttorney = attorneyValue.getText().trim();

                System.out.println("Expected Attorney: " + selectedAttorney);
                System.out.println("Actual Attorney: " + actualAttorney);

                Assert.assertEquals(actualAttorney, selectedAttorney,
                        "Attorney mismatch. Expected: " + selectedAttorney + " but found: " + actualAttorney);

                Allure.step("Validation PASSED: Attorney matches");
                ScreenshotUtil.takeScreenshot(driver, "Attorney Validated");

            } catch (Exception e) {
                ScreenshotUtil.takeScreenshot(driver, "Attorney Validation Failed");
                throw new RuntimeException(e);
            }
        });

        // STEP 6: OC Conflicted
        Allure.step("Selecting second option for 'Is OC Conflicted?'", () -> {
            WebElement dropdown = driver.findElement(
                    By.xpath("//div[contains(@class,'DropdownWidget---dropdown_value')][.//span[text()='---Select Yes/No---']]")
            );
            Thread.sleep(1000);
            dropdown.click();
            Thread.sleep(1000);

            actions.sendKeys(Keys.ARROW_DOWN).perform(); // first option
            Thread.sleep(300);
            actions.sendKeys(Keys.ARROW_DOWN).perform(); // second option
            Thread.sleep(300);
            actions.sendKeys(Keys.ENTER).perform(); // select
            Thread.sleep(500);

            // Store selected value
            isOCConflicted = dropdown.findElement(By.tagName("span")).getText();

            // Print to console
            System.out.println("'Is OC Conflicted?' selected value: " + isOCConflicted);
            // Also log in Allure
            Allure.step("'Is OC Conflicted?' selected value: " + isOCConflicted);
        });

        // STEP 7: Submit
        Allure.step("Click Submit button to create the Legal Request", () -> {
            WebElement submitBtn = driver.findElement(
                    By.xpath("//button[.//span[text()='Submit']]")
            );
            submitBtn.click();
            Thread.sleep(2000);

            // Print to console
            System.out.println("Submit button clicked successfully.");
            // Also log in Allure
            Allure.step("Submit button clicked successfully.");
        });

        Allure.step("Existing OC Request Completed Successfully");
        ScreenshotUtil.takeScreenshot(driver, "Existing OC Request Completed Successfully");
    }
}