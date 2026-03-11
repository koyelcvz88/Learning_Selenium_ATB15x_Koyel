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
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

@Epic("VenReq Automation Suite")
@Feature("Legal Request Module")
@Story("Fill Legal Request Form")
public class Legal_Request_Form_Fields_Test extends Legal_Request_Initiation_Test {

    private WebDriverWait wait;
    private Actions actions;

    // Variables to store selected data for validation later
    protected String requestType;
    protected String requestSubType;
    protected String internalCounsel;
    protected String requestSegment;
    protected String ocFeesPayer;
    protected String dueDate;

    // Initialize wait and actions
    private void initUtils() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        actions = new Actions(driver);
    }

    /**
     * Public method to fill the entire Legal Request Form
     * Can be called from workflow runner
     */
    @Owner("Koyel")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Testcase 2 - Verify user is able to Enter Legal Request Form Fields")
    public void fillLegalRequestForm() throws InterruptedException {
        initUtils();

        // Call TC1 logic to open the form
        initiateLegalRequest();

        selectRequestType();
        Thread.sleep(2000);

        selectRequestSubType();
        Thread.sleep(2000);

        selectInternalCounsel();
        Thread.sleep(2000);

        selectRequestSegment();
        Thread.sleep(2000);

        selectOCFeesPayer();
        Thread.sleep(2000);

        selectDueDate();
        Thread.sleep(2000);
    }
    // ------------------- Individual Steps -------------------

    public void selectRequestType() {
        Allure.step("Selecting Request Type from dropdown", () -> {
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@role='combobox'][.//span[normalize-space()='---Select Request Type---']]")));
            dropdown.click();
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
            requestType = "Litigation";

            // Print to console
            System.out.println("'" + requestType + "' option selected.");
            // Also log in Allure
            Allure.step("'" + requestType + "' option selected.");
        });
    }

    public void selectRequestSubType() {
        Allure.step("Selecting Request SubType from dropdown", () -> {
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@role='combobox'][.//span[contains(text(),'Select Request Sub Type')]]")));
            dropdown.click();
            dropdown.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
            requestSubType = "CMS";

            // Print to console
            System.out.println(requestSubType + " option selected.");
            // Also log in Allure
            Allure.step(requestSubType + " option selected.");
        });
    }

    public void selectInternalCounsel() {
        Allure.step("Selecting Internal Counsel from dropdown", () -> {
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@role='combobox'][.//span[contains(text(),'Search Internal Counsel')]]")));
            dropdown.click();
            dropdown.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
            internalCounsel = "Annie George";

            // Print to console
            System.out.println(internalCounsel + " option selected.");
            // Also log in Allure
            Allure.step(internalCounsel + " option selected.");
        });
    }

    public void selectRequestSegment() {
        Allure.step("Selecting Request Segment from dropdown", () -> {
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@role='combobox'][.//span[contains(text(),'Select Request Segment')]]")));
            dropdown.click();
            dropdown.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
            requestSegment = "Assumptions";

            // Print to console
            System.out.println(requestSegment + " option selected.");
            // Also log in Allure
            Allure.step(requestSegment + " option selected.");
        });
    }

    public void selectOCFeesPayer() {
        Allure.step("Selecting OC Fees Payer", () -> {
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@role='combobox'][.//span[contains(text(),'---Select OC Fees Payer---')]]")));
            dropdown.click();
            dropdown.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
            ocFeesPayer = "Trimont";

            // Print to console
            System.out.println(ocFeesPayer + " option selected.");
            // Also log in Allure
            Allure.step(ocFeesPayer + " option selected.");
        });
    }

    public void selectDueDate() {
        Allure.step("Selecting Due Date", () -> {

            // Open the calendar
            WebElement calendarBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("button.DatePickerWidget---calendar_btn")));
            calendarBtn.click();

            // Get today's date
            LocalDate today = LocalDate.now();
            String dayOfWeek = today.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH); // e.g., "Saturday"
            int dayOfMonth = today.getDayOfMonth(); // e.g., 28
            String month = today.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH); // e.g., "March"
            int year = today.getYear(); // e.g., 2026

            // Construct the aria-label exactly as in your date button
            String ariaLabel = String.format("Select %s, %s %dth %d", dayOfWeek, month, dayOfMonth, year);

            // Locate the date button dynamically
            WebElement todayDateBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[@aria-label='" + ariaLabel + "']")));
            todayDateBtn.click();

            dueDate = String.format("%d %s %d", dayOfMonth, month, year);

            // Print to console
            System.out.println("Date selected today: " + dueDate);
            // Also log in Allure
            Allure.step("Date selected today: " + dueDate);
        });
    }

    /* public void selectDueDate() {
        Allure.step("Selecting Due Date", () -> {
            WebElement calendarBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("button.DatePickerWidget---calendar_btn")));
            calendarBtn.click();

            WebElement date28 = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[@aria-label='Select Saturday, March 28th 2026']")));
            date28.click();
            dueDate = "28 March 2026";
            System.out.println("Date selected: " + dueDate);
        });
    } */

    // Optional @Test if I want to run TC2 standalone

   /* @Test
    public void legalRequest_Form_Fields_Test_Run() throws InterruptedException {
        fillLegalRequestForm();
    } */

}