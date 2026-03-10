package com.thetestingacademy.Trimont.DeletedCode;

/*public class EX_OC_Summary_REMOVED {
}
 package com.thetestingacademy.Trimont;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.Assert;
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

        // 1️⃣ Locate and open EX_OC request
        Allure.step("Locate and open EX_OC request by suffix text", () -> {
            String requestSuffix = "Ex_OC_New_Legal_Request";
            boolean found = false;

            while (!found) {
                List<WebElement> links = driver.findElements(
                        By.xpath("//a[contains(@class,'LinkedItem---standalone_richtext_link')]")
                );

                for (WebElement link : links) {
                    if (link.getText().trim().endsWith(requestSuffix)) {
                        link.click();
                        found = true;
                        System.out.println("Request found and clicked: " + link.getText());
                        break;
                    }
                }

                if (!found) {
                    try {
                        WebElement nextBtn = driver.findElement(
                                By.xpath("//button[contains(@class,'Pagination---next') or contains(text(),'Next')]")
                        );
                        if (nextBtn.isEnabled()) nextBtn.click();
                        else break;
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        break;
                    }
                }
            }
            Assert.assertTrue(found, "Request not found for suffix: " + requestSuffix);
        });

        // Wait until summary page loads
        WebElement summaryPage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[contains(text(),'Legal Request Summary')]")));
        Assert.assertTrue(summaryPage.isDisplayed(), "Summary page not displayed");
        System.out.println("Summary page is displayed.");

        // 2️⃣ Validate each summary field using robust locators
        Allure.step("Validate Request Type", () -> {
            WebElement field = driver.findElement(
                    By.xpath("//span[text()='Request Type']/ancestor::div[1]//p[@data-testid='ParagraphText-paragraph']")
            );
            Assert.assertEquals(field.getText().trim(), requestType, "Request Type mismatch");
        });

        Allure.step("Validate Request SubType", () -> {
            WebElement field = driver.findElement(
                    By.xpath("//span[text()='Request Sub Type']/ancestor::div[1]//p[@data-testid='ParagraphText-paragraph']")
            );
            Assert.assertEquals(field.getText().trim(), requestSubType, "Request SubType mismatch");
        });

        Allure.step("Validate Request Matter", () -> {
            WebElement field = driver.findElement(
                    By.xpath("//span[text()='Request/Matter Name']/ancestor::div[1]//p[@data-testid='ParagraphText-paragraph']")
            );
            Assert.assertEquals(field.getText().trim(), requestMatter, "Request Matter mismatch");
        });

        Allure.step("Validate Due Date", () -> {
            WebElement field = driver.findElement(
                    By.xpath("//span[text()='Due Date']/ancestor::div[1]//p[@data-testid='ParagraphText-paragraph']")
            );
            Assert.assertEquals(field.getText().trim(), dueDate, "Due Date mismatch");
        });

        Allure.step("Validate Internal Counsel", () -> {
            WebElement field = driver.findElement(
                    By.xpath("//span[text()='Internal Counsel']/ancestor::div[1]//p[@data-testid='ParagraphText-paragraph']")
            );
            Assert.assertEquals(field.getText().trim(), internalCounsel, "Internal Counsel mismatch");
        });

        Allure.step("Validate Request Segment", () -> {
            WebElement field = driver.findElement(
                    By.xpath("//span[text()='Request Segment']/ancestor::div[1]//p[@data-testid='ParagraphText-paragraph']")
            );
            Assert.assertEquals(field.getText().trim(), requestSegment, "Request Segment mismatch");
        });

        Allure.step("Validate OC Fees Payer", () -> {
            WebElement field = driver.findElement(
                    By.xpath("//span[text()='OC Fees Payer']/ancestor::div[1]//p[@data-testid='ParagraphText-paragraph']")
            );
            Assert.assertEquals(field.getText().trim(), ocFeesPayer, "OC Fees Payer mismatch");
        });

        Allure.step("Validate Selected OC Firm", () -> {
            WebElement field = driver.findElement(
                    By.xpath("//span[text()='Outside Counsel Firm']/ancestor::div[1]//p/em")
            );
            Assert.assertEquals(field.getText().trim(), selectedOCFirm, "OC Firm mismatch");
        });

        Allure.step("Validate Selected Attorney", () -> {
            WebElement field = driver.findElement(
                    By.xpath("//span[text()='Attorney']/ancestor::div[1]//p/em")
            );
            Assert.assertEquals(field.getText().trim(), selectedAttorney, "Attorney mismatch");
        });

        Allure.step("Validate Is OC Conflicted?", () -> {
            WebElement field = driver.findElement(
                    By.xpath("//span[text()='Is OC Conflicted?']/ancestor::div[1]//p[@data-testid='ParagraphText-paragraph']")
            );
            Assert.assertEquals(field.getText().trim(), isOCConflicted, "Is OC Conflicted mismatch");
        });

        System.out.println("All summary fields validated successfully for Existing OC Legal Request.");
    }
}
package com.thetestingacademy.Trimont;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

        // ---------------- Find & click the request ID ----------------
        Allure.step("Locate and click request by Request/Matter Name", () -> {
            boolean found = false;
            String suffix = requestMatter; // e.g., "Ex_OC_New_Legal_Request"

            while (!found) {
                List<WebElement> requests = driver.findElements(
                        By.xpath("//a[contains(@class,'LinkedItem---standalone_richtext_link')]")
                );

                for (WebElement req : requests) {
                    if (req.getText().trim().endsWith(suffix)) {
                        req.click();
                        found = true;
                        System.out.println("Clicked request: " + req.getText());
                        break;
                    }
                }

                if (!found) {
                    try {
                        WebElement nextBtn = driver.findElement(
                                By.xpath("//button[contains(@class,'Pagination---next') or contains(text(),'Next')]")
                        );
                        if (nextBtn.isEnabled()) {
                            nextBtn.click();
                            Thread.sleep(1000);
                        } else {
                            throw new RuntimeException("Request not found: " + suffix);
                        }
                    } catch (Exception e) {
                        throw new RuntimeException("Request not found and Next button missing: " + suffix);
                    }
                }
            }
        });

        // ---------------- Wait for Summary Page ----------------
        WebElement summaryPage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[contains(text(),'Legal Request Summary')]")));
        Assert.assertTrue(summaryPage.isDisplayed(), "Summary page not displayed");
        System.out.println("Summary page is displayed.");

        // ---------------- Validate all fields ----------------
        Thread.sleep(2000); // wait for fields to render

        // <p> fields (Request Type, SubType, Matter, Internal Counsel, Request Segment, OC Fees Payer, Due Date)
        List<WebElement> fields = driver.findElements(By.xpath("//p[@data-testid='ParagraphText-paragraph']"));

        Allure.step("Validate Request Type", () -> Assert.assertEquals(fields.get(0).getText(), requestType));
        Allure.step("Validate Request SubType", () -> Assert.assertEquals(fields.get(1).getText(), requestSubType));
        Allure.step("Validate Request Matter", () -> Assert.assertEquals(fields.get(2).getText(), requestMatter));
        Allure.step("Validate Internal Counsel", () -> Assert.assertEquals(fields.get(3).getText(), internalCounsel));
        Allure.step("Validate Request Segment", () -> Assert.assertEquals(fields.get(4).getText(), requestSegment));
        Allure.step("Validate OC Fees Payer", () -> Assert.assertEquals(fields.get(5).getText(), ocFeesPayer));
        Allure.step("Validate Due Date", () -> Assert.assertEquals(fields.get(6).getText(), dueDate));

        // <em> fields (OC Firm, Attorney)
        List<WebElement> emFields = driver.findElements(By.xpath("//p[@data-testid='ParagraphText-paragraph']/em"));
        Allure.step("Validate OC Firm", () -> Assert.assertEquals(emFields.get(0).getText(), selectedOCFirm));
        Allure.step("Validate Attorney", () -> Assert.assertEquals(emFields.get(1).getText(), selectedAttorney));

        System.out.println("All summary fields validated successfully for Existing OC Legal Request.");
    }
}*/