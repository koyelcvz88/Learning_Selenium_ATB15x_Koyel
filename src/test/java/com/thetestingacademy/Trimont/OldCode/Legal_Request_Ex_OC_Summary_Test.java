package com.thetestingacademy.Trimont.OldCode;

/*import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

@Epic("VenReq Automation Suite")
@Feature("Legal Request Module")
@Story("Validate Legal Request Summary for Existing OC")
@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class Legal_Request_Ex_OC_Summary_Test extends Legal_Request_ExistingOC_Test {

    @Test
    @Owner("Koyel")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Testcase 5 - Validate summary page for Existing OC Legal Request")
    public void validateExistingOCSummary() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        Actions actions = new Actions(driver);

        String requestSuffix = "Ex_OC_New_Legal_Request";

        // Wait for the table container to load (adjust if needed)
        WebElement tableContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(.,'MY LEGAL MATTER REQUESTS')]")));

        // Find all rows in the table
        List<WebElement> rows = tableContainer.findElements(By.xpath(".//div[@role='row']"));

        WebElement matchingRow = null;
        for (WebElement row : rows) {
            try {
                // Find the first cell in the row - request cell (ID + name)
                WebElement requestCell = row.findElement(By.xpath("./div[@role='cell'][1]"));
                String cellText = requestCell.getText().trim();

                // Check if the request name (2nd line) ends with requestSuffix
                // cellText might be like "LMR00425 | \nEx_OC_New_Legal_Request"
                String[] lines = cellText.split("\\r?\\n");
                if (lines.length > 1 && lines[1].trim().equals(requestSuffix)) {
                    matchingRow = row;
                    break;
                }
            } catch (Exception e) {
                // Skip any rows that don't fit expected structure
            }
        }

        Assert.assertNotNull(matchingRow, "No matching request row found with suffix: " + requestSuffix);

        // Click the request cell link or the first clickable element inside matchingRow
        try {
            WebElement clickableLink = matchingRow.findElement(By.xpath(".//a"));
            actions.moveToElement(clickableLink).click().perform();
        } catch (Exception e) {
            // fallback: click the entire row if no <a> link found
            actions.moveToElement(matchingRow).click().perform();
        }

        System.out.println("Clicked on the matching request row with suffix: " + requestSuffix);

        // Wait for summary page to load
        WebElement summaryPage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[contains(text(),'Legal Request Summary')]")));
        Assert.assertTrue(summaryPage.isDisplayed(), "Summary page is not displayed");
        System.out.println("Summary page is displayed.");

        Thread.sleep(2000); // Allow summary fields to render

        // Validate summary fields as before
        List<WebElement> fields = driver.findElements(By.xpath("//p[@data-testid='ParagraphText-paragraph']"));

        Allure.step("Validate Request Type", () -> Assert.assertEquals(fields.get(0).getText(), requestType, "Request Type mismatch"));
        Allure.step("Validate Request SubType", () -> Assert.assertEquals(fields.get(1).getText(), requestSubType, "Request SubType mismatch"));
        Allure.step("Validate Request Matter", () -> Assert.assertEquals(fields.get(2).getText(), requestMatter, "Request Matter mismatch"));
        Allure.step("Validate Internal Counsel", () -> Assert.assertEquals(fields.get(3).getText(), internalCounsel, "Internal Counsel mismatch"));
        Allure.step("Validate Request Segment", () -> Assert.assertEquals(fields.get(4).getText(), requestSegment, "Request Segment mismatch"));
        Allure.step("Validate OC Fees Payer", () -> Assert.assertEquals(fields.get(5).getText(), ocFeesPayer, "OC Fees Payer mismatch"));
        Allure.step("Validate Due Date", () -> Assert.assertEquals(fields.get(6).getText(), dueDate, "Due Date mismatch"));

        List<WebElement> emFields = driver.findElements(By.xpath("//p[@data-testid='ParagraphText-paragraph']/em"));
        Allure.step("Validate OC Firm", () -> Assert.assertEquals(emFields.get(0).getText(), selectedOCFirm, "OC Firm mismatch"));
        Allure.step("Validate Attorney", () -> Assert.assertEquals(emFields.get(1).getText(), selectedAttorney, "Attorney mismatch"));

        System.out.println("All summary fields validated successfully for Existing OC Legal Request.");
    }
} */