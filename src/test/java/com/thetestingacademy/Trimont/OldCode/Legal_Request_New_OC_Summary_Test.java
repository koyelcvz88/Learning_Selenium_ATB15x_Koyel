package com.thetestingacademy.Trimont.OldCode;

/*import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
@Story("Validate Legal Request Summary for New OC")
@Listeners({io.qameta.allure.testng.AllureTestNg.class})

public class Legal_Request_New_OC_Summary_Test extends Legal_Request_NewOC_Test {
    @Test
    @Owner("Koyel")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Testcase 6 - Validate summary page for New OC Legal Request")
    public void validateNewOCSummary() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        Allure.step("Locate and open New_OC request by suffix text", () -> {

            String requestSuffix = "New_OC_New_Legal_Request";
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

                        if (nextBtn.isEnabled()) {
                            nextBtn.click();

                            try {
                                Thread.sleep(1000);  // handle inside lambda
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        } else {
                            System.out.println("Reached last page. Request not found for suffix: " + requestSuffix);
                            break;
                        }

                    } catch (NoSuchElementException e) {
                        System.out.println("Next button not found. Request not found for suffix: " + requestSuffix);
                        break;
                    }
                }
            }

            Assert.assertTrue(found, "Request not found for suffix: " + requestSuffix);
        });
        // Wait until summary page loads (adjust locator as needed)
        /*WebElement summaryPage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[contains(text(),'Legal Request Summary')]")));
        Assert.assertTrue(summaryPage.isDisplayed(), "Summary page not displayed");
        System.out.println("Summary page is displayed.");

        // Validate common fields from TC2 (inherited)
        Allure.step("Validate Request Type", () -> {
            WebElement field = driver.findElement(By.xpath("//span[contains(text(),'Request Type')]/following-sibling::span"));
            Assert.assertEquals(field.getText(), requestType, "Request Type mismatch");
        });

        Allure.step("Validate Request SubType", () -> {
            WebElement field = driver.findElement(By.xpath("//span[contains(text(),'Request Sub Type')]/following-sibling::span"));
            Assert.assertEquals(field.getText(), requestSubType, "Request SubType mismatch");
        });

        Allure.step("Validate Internal Counsel", () -> {
            WebElement field = driver.findElement(By.xpath("//span[contains(text(),'Internal Counsel')]/following-sibling::span"));
            Assert.assertEquals(field.getText(), internalCounsel, "Internal Counsel mismatch");
        });

        Allure.step("Validate Request Segment", () -> {
            WebElement field = driver.findElement(By.xpath("//span[contains(text(),'Request Segment')]/following-sibling::span"));
            Assert.assertEquals(field.getText(), requestSegment, "Request Segment mismatch");
        });

        Allure.step("Validate OC Fees Payer", () -> {
            WebElement field = driver.findElement(By.xpath("//span[contains(text(),'OC Fees Payer')]/following-sibling::span"));
            Assert.assertEquals(field.getText(), ocFeesPayer, "OC Fees Payer mismatch");
        });

        Allure.step("Validate Due Date", () -> {
            WebElement field = driver.findElement(By.xpath("//span[contains(text(),'Due Date')]/following-sibling::span"));
            Assert.assertEquals(field.getText(), dueDate, "Due Date mismatch");
        });

        // Validate New OC specific fields
        Allure.step("Validate Request Matter", () -> {
            WebElement field = driver.findElement(By.xpath("//span[contains(text(),'Request/Matter Name')]/following-sibling::span"));
            Assert.assertEquals(field.getText(), requestMatter, "Request Matter mismatch");
        });

        Allure.step("Validate OC Firm Name", () -> {
            WebElement field = driver.findElement(By.xpath("//span[contains(text(),'OC Firm Name')]/following-sibling::span"));
            Assert.assertEquals(field.getText(), ocFirmName, "OC Firm Name mismatch");
        });

        Allure.step("Validate OC Justification", () -> {
            WebElement field = driver.findElement(By.xpath("//span[contains(text(),'New Outside Counsel Justification')]/following-sibling::span"));
            Assert.assertEquals(field.getText(), ocJustification, "OC Justification mismatch");
        });

        Allure.step("Validate Attorney Name", () -> {
            WebElement field = driver.findElement(By.xpath("//span[contains(text(),'Attorney Name')]/following-sibling::span"));
            Assert.assertEquals(field.getText(), attorneyName, "Attorney Name mismatch");
        });

        Allure.step("Validate Phone Number", () -> {
            WebElement field = driver.findElement(By.xpath("//span[contains(text(),'Phone')]/following-sibling::span"));
            Assert.assertEquals(field.getText(), phoneNumber, "Phone Number mismatch");
        });

        Allure.step("Validate Email", () -> {
            WebElement field = driver.findElement(By.xpath("//span[contains(text(),'Email')]/following-sibling::span"));
            Assert.assertEquals(field.getText(), emailAddress, "Email mismatch");
        });

        Allure.step("Validate City", () -> {
            WebElement field = driver.findElement(By.xpath("//span[contains(text(),'City')]/following-sibling::span"));
            Assert.assertEquals(field.getText(), city, "City mismatch");
        });

        Allure.step("Validate State", () -> {
            WebElement field = driver.findElement(By.xpath("//span[contains(text(),'State')]/following-sibling::span"));
            Assert.assertEquals(field.getText(), state, "State mismatch");
        });

        System.out.println("All summary fields validated successfully for New OC Legal Request.");
    }
} */