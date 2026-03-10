package com.thetestingacademy.Trimont.DeletedCode;

public class Legal_Request_Form_Fields_REMOVED {
}
 /* package com.thetestingacademy.Trimont;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.time.Duration;

@Epic("VenReq Automation Suite")
@Feature("Legal Request Module")
@Story("Initiate Legal Request")
@Listeners({io.qameta.allure.testng.AllureTestNg.class})

public class Legal_Request_Form_Fields_Test extends Legal_Request_Initiation_Test {
    @Test
    @Owner("Koyel")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Testcase 2 - Verify user is able to Enter Legal Request Form Fields ")

    public void legalRequest_Form_Fields_Test() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        initiateLegalRequest(); // calling TC1

            Allure.step("Selecting Request Type from dropdown ", () -> {
                // Selecting Request SubType

                System.out.println("Looking for Request Type Dropdown ");

                // Click the combobox to open options
                WebElement RequestTypeDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@role='combobox'][.//span[normalize-space()='---Select Request Type---']]")));
                RequestTypeDropdown.click();
                System.out.println("Request Type dropdown clicked.");

                // Press down arrow keys until 'Litigation' is highlighted and then Enter
                // Usually first option is placeholder, so one arrow down
                actions.sendKeys(Keys.ARROW_DOWN) // move from placeholder to first real option
                        .sendKeys(Keys.ENTER)      // select it
                        .perform();

                System.out.println("'Litigation' option selected via keyboard");
            });

            Allure.step("Selecting Request SubType from dropdown ", () -> {
                // Selecting Request Type

                System.out.println("Looking for Request SubType Dropdown ");

                // Click the Request Sub Type dropdown
                WebElement requestSubTypeDropdown = wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.xpath("//div[@role='combobox'][.//span[contains(text(),'Select Request Sub Type')]]")
                        )
                );

                requestSubTypeDropdown.click();
                System.out.println("Request Sub Type dropdown clicked");

                // Select the first option via keyboard (Arrow + Enter)
                requestSubTypeDropdown.sendKeys(Keys.ARROW_DOWN);
                requestSubTypeDropdown.sendKeys(Keys.ENTER);

                System.out.println("CMS option selected successfully");
            });

            Allure.step("Selecting Internal counsel from dropdown ", () -> {
                // Selecting Internal counsel

                System.out.println("Looking for Internal counsel Dropdown ");

                // Click the Internal counsel dropdown
                WebElement internalCounselDropdown = wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.xpath("//div[@role='combobox']" +
                                        "[.//span[contains(text(),'Search Internal Counsel')]]")
                        )
                );

                internalCounselDropdown.click();
                System.out.println("Internal Counsel dropdown clicked");

                // Select the first option via keyboard (Arrow + Enter)
                internalCounselDropdown.sendKeys(Keys.ARROW_DOWN);
                internalCounselDropdown.sendKeys(Keys.ENTER);

                System.out.println("Annie George option selected successfully");
            });

            Allure.step("Selecting Request Segment from dropdown ", () -> {
                // Selecting Request Segment

                System.out.println("Looking for Request Segment Dropdown ");

                // Click the Request Segment dropdown
                WebElement requestSegmentDropdown = wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.xpath("//div[@role='combobox'][.//span[contains(text(),'Select Request Segment')]]")
                        )
                );

                requestSegmentDropdown.click();
                System.out.println("Request Segment dropdown clicked");


                // Select the first option via keyboard (Arrow + Enter)
                requestSegmentDropdown.sendKeys(Keys.ARROW_DOWN);
                requestSegmentDropdown.sendKeys(Keys.ENTER);

                System.out.println("Assumptions option selected successfully");
            });

            Allure.step("Selecting OC Fees from dropdown ", () -> {
                // Selecting OC Fees

                System.out.println("Looking for OC Fees Dropdown ");

                // Click the OC Fees dropdown
                WebElement ocFeesPayerDropdown = wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.xpath("//div[@role='combobox'][.//span[contains(text(),'---Select OC Fees Payer---')]]")
                        )
                );

                ocFeesPayerDropdown.click();
                System.out.println("OC Fees Payer dropdown clicked");


                // Select the first option via keyboard (Arrow + Enter)
                ocFeesPayerDropdown.sendKeys(Keys.ARROW_DOWN);
                ocFeesPayerDropdown.sendKeys(Keys.ENTER);


                System.out.println("Trimont option selected successfully");
            });

            Allure.step("Selecting Due date from date picker ", () -> {
                // Selecting Due date

                System.out.println("Looking for Due date field ");

                //Wait for and click the calendar button to open date picker
                WebElement calendarButton = wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.cssSelector("button.DatePickerWidget---calendar_btn")
                        )
                );
                calendarButton.click();
                System.out.println("Calendar opened");

                // Step 3: Select 28th March using aria-label (most reliable)
                WebElement date28 = wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.xpath("//button[@aria-label='Select Saturday, March 28th 2026']")
                        )
                );
                date28.click();
                System.out.println("Date selected: 28 March 2026");
            });


    }
}
*/