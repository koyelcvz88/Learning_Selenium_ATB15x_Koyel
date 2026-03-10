package com.thetestingacademy.Trimont;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

@Epic("VenReq Automation Suite")
@Feature("Legal Request Module")
@Story("Initiate Legal Request with Existing OC")
public class Legal_Request_ExistingOC_Test extends Legal_Request_Form_Fields_Test {

    // Variables to store selections for summary validation
    protected String requestMatterEx;
    protected String selectedOCFirm;
    protected String selectedAttorney;
    protected String isOCConflicted;

    /**
     * Reusable method for workflow runner
     */
    @Owner("Koyel")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Testcase 3 - Verify user is able to Initiate a new request with Existing OC")
    public void fillExistingOCRequest() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        // Fill the entire Legal Request Form using TC2 reusable method
        fillLegalRequestForm();

        // Enter Request Matter
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
            System.out.println("Request Matter entered: " + requestMatterEx);
        });

        // Select Outside Counsel Firm
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
            System.out.println("Outside Counsel Firm selected: " + selectedOCFirm);
        });

        // Select first Contact Attorney
        Allure.step("Selecting first Contact Attorney", () -> {
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class,'DropdownWidget---dropdown_value') and contains(@class,'DropdownWidget---placeholder')]")
            ));
            Thread.sleep(1000);
            dropdown.click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.attributeToBe(dropdown, "aria-expanded", "true"));
            dropdown.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

            // Store selected attorney
            selectedAttorney = "Elizabeth Murphy";
            System.out.println("Contact Attorney selected: " + selectedAttorney);
        });

        // Select 'Is OC Conflicted?'
        Allure.step("Selecting second option for 'Is OC Conflicted?'", () -> {
            WebElement dropdown = driver.findElement(
                    By.xpath("//div[contains(@class,'DropdownWidget---dropdown_value')][.//span[text()='---Select Yes/No---']]")
            );
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
            System.out.println("'Is OC Conflicted?' selected value: " + isOCConflicted);
        });

        // Click Submit button
        Allure.step("Click Submit button to create the Legal Request", () -> {
            WebElement submitBtn = driver.findElement(
                    By.xpath("//button[.//span[text()='Submit']]")
            );
            submitBtn.click();
            Thread.sleep(2000);
            System.out.println("Submit button clicked successfully.");
        });
    }

    // Optional standalone @Test if needed

    @Test
    public void legalRequest_Existing_OC_Test_Run() throws InterruptedException {
        fillExistingOCRequest();
    }

}