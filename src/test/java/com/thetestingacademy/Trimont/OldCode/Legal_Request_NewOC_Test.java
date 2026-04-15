/* package com.thetestingacademy.Trimont.OldCode;

import com.thetestingacademy.Trimont.OldCode.Legal_Request_Form_Fields_Test;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import java.time.Duration;

@Epic("VenReq Automation Suite")
@Feature("Legal Request Module")
@Story("Initiate Legal Request with New OC")
public class Legal_Request_NewOC_Test extends Legal_Request_Form_Fields_Test {

    protected String requestMatterNew;
    protected String selectedOCFirmNew;
    protected String ocFirmName;
    protected String ocJustification;
    protected String attorneyName;
    protected String phoneNumber;
    protected String emailAddress;
    protected String city;
    protected String state;

    @Owner("Koyel")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Testcase 4 - Verify user can Initiate request with NEW OC")
    public void fillNewOCRequest() throws InterruptedException {

        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Fill the entire Legal Request Form using TC2 reusable method
        fillLegalRequestForm();

        // -------- Request/Matter --------
        Allure.step("Entering Request/Matter Name", () -> {
            WebElement requestMatterNewTxtBox = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//label[contains(text(),'Request/Matter Name')]/following::input[1]")
                    )
            );
            Thread.sleep(1000); // stabilization
            requestMatterNewTxtBox.click();
            requestMatterNew = "New_OC_New_Legal_Request";
            //actions.click(requestMatterField).sendKeys(requestMatterNew).perform();
            requestMatterNewTxtBox.sendKeys(requestMatterNew);

            // Print to console
            System.out.println("Request Matter entered: " + requestMatterNew);
            // Also log in Allure
            Allure.step("Request Matter entered: " + requestMatterNew);
        });

        // -------- Outside Counsel Dropdown --------
        Allure.step("Selecting Outside Counsel Firm dropdown", () -> {

            WebElement dropdown2 = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class,'DropdownWidget---dropdown_value') and contains(., '---Select Outside Counsel Firm Name---')]")
            ));
            Thread.sleep(1000);
            dropdown2.click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.attributeContains(dropdown2, "aria-expanded", "true"));
            dropdown2.sendKeys(Keys.END, Keys.ENTER);

            // Store the selected firm
            selectedOCFirmNew = "Request New";

            // Print to console
            System.out.println("Outside Counsel Firm selected: " + selectedOCFirmNew);
            // Also log in Allure
            Allure.step("Outside Counsel Firm selected: " + selectedOCFirmNew);

             /*WebElement dropdown = wait.until(
                                ExpectedConditions.visibilityOfElementLocated(
                                        By.xpath("//span[normalize-space()='---Select Outside Counsel Firm Name---']")
                                )
                        );

                        // scroll to dropdown
                        js.executeScript("arguments[0].scrollIntoView({block:'center'});", dropdown);

                        // wait until clickable
                        wait.until(ExpectedConditions.elementToBeClickable(dropdown));

                        try {
                                dropdown.click();
                        } catch (Exception e) {
                                System.out.println("Normal click intercepted, using JS click fallback.");
                                js.executeScript("arguments[0].click();", dropdown);
                        }

            //System.out.println("Outside Counsel dropdown expanded");

        });
        // -------- OC Firm Name --------
        Allure.step("Entering OC Firm Name", () -> {
            WebElement firmField = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//strong[normalize-space()='OC Firm Name']")
                    )
            );
            //js.executeScript("arguments[0].scrollIntoView(true);", firmField);
            Thread.sleep(1000);
            actions.click(firmField).sendKeys(Keys.TAB).sendKeys("Auto New OC Firm").perform();
            Thread.sleep(1000);
            ocFirmName = "Auto New OC Firm";
            //actions.click(firmField).sendKeys(Keys.CONTROL + "a").sendKeys(Keys.DELETE)
            //.sendKeys(ocFirmName).perform();

            // Print to console
            System.out.println("OC Firm Name entered: " + ocFirmName);
            // Also log in Allure
            Allure.step("OC Firm Name entered: " + ocFirmName);
        });

        // -------- Justification --------
        Allure.step("Entering OC Justification", () -> {
            WebElement jusLabel = driver.findElement(
                    By.xpath("//strong[normalize-space()='New Outside Counsel Justification']")
            );
            Thread.sleep(1000);
            actions.click(jusLabel).sendKeys(Keys.TAB).sendKeys("Outside counsel engaged for strategic legal support.").perform();
            Thread.sleep(1000);
            ocJustification = "Outside counsel engaged for strategic legal support.";

            // Print to console
            System.out.println("Justification entered: " + ocJustification);
            // Also log in Allure
            Allure.step("Justification entered: " + ocJustification);
        });

        // -------- Attorney Name --------
        Allure.step("Entering Attorney Name", () -> {
            WebElement attLabel = driver.findElement(
                    By.xpath("//strong[normalize-space()='Attorney Name']")
            );
            Thread.sleep(1000);
            actions.click(attLabel).sendKeys(Keys.TAB).sendKeys("Auto Attorney").perform();
            Thread.sleep(1000);
            attorneyName = "Auto Attorney";

            // Print to console
            System.out.println("Attorney Name entered:" + attorneyName);
            // Also log in Allure
            Allure.step("Attorney Name entered: " + attorneyName);
        });

        // -------- Phone Entry --------
        Allure.step("Entering Phone", () -> {
            WebElement phLabel = driver.findElement(
                    By.xpath("//strong[normalize-space()='Phone']")
            );
            Thread.sleep(1000);
            actions.click(phLabel).sendKeys(Keys.TAB).sendKeys("1234567890").perform();
            Thread.sleep(1000);
            phoneNumber = "1234567890";

            // Print to console
            System.out.println("Phone entered: " + phoneNumber);
            // Also log in Allure
            Allure.step("Phone entered: " + phoneNumber);
        });

        // -------- Phone Validation --------
        Allure.step("Validating Phone", () -> {
            WebElement phoneField = driver.switchTo().activeElement();
            String phoneValue = phoneField.getAttribute("value").replaceAll("[^0-9]", "");
            Thread.sleep(1000);
            Assert.assertTrue(phoneValue.matches("\\d{10}"));

            // Print to console
            System.out.println("Phone validated successfully" + phoneValue);
            // Also log in Allure
            Allure.step("Phone validated successfully: " + phoneValue);
        });

        // -------- Email Entry --------
        Allure.step("Entering Email", () -> {
            WebElement emailLabel = driver.findElement(
                    By.xpath("//strong[normalize-space()='Email']")
            );
            Thread.sleep(1000);
            actions.click(emailLabel).sendKeys(Keys.TAB).sendKeys("autouser@mail.com").perform();
            Thread.sleep(1000);
            emailAddress = "autouser@mail.com";

            // Print to console
            System.out.println("Email entered: " + emailAddress);
            // Also log in Allure
            Allure.step("Email entered: " + emailAddress);
        });

        // -------- Email Validation --------
        Allure.step("Validating Email", () -> {
            WebElement emailField = driver.switchTo().activeElement();
            String emailValue = emailField.getAttribute("value");
            Thread.sleep(1000);
            Assert.assertTrue(emailValue.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"));

            // Print to console
            System.out.println("Email validated successfully" +emailValue);
            // Also log in Allure
            Allure.step("Email validated successfully: " + emailValue);
        });

        // -------- City --------
        Allure.step("Entering City", () -> {
            //WebElement CityLabel = driver.findElement(
            //By.xpath("//strong[normalize-space()='Address']")
            //);
            WebElement CityLabel = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("(//strong[normalize-space()='Address']/following::input)[1]")
                    )
            );
            Thread.sleep(1000);
            //actions.click(CityLabel).sendKeys(Keys.TAB).sendKeys("Sitka").perform();
            CityLabel.clear();
            CityLabel.sendKeys("Sitka");
            Thread.sleep(1000);
            city = "Sitka";

            // Print to console
            System.out.println("City entered: " + city);
            // Also log in Allure
            Allure.step("City entered: " + city);
        });

        // -------- State --------
        Allure.step("Selecting State", () -> {
            //WebElement StateLabel = driver.findElement(
            //By.xpath("//strong[normalize-space()='Address']")
            // );
            //WebElement StateLabel = wait.until(
            //ExpectedConditions.elementToBeClickable(
            //By.xpath("(//strong[normalize-space()='Address']/following::input)[2]")
            // )
            // );

            WebElement StateLabel = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("(//strong[normalize-space()='Address']/following::div[contains(@class,'DropdownWidget---dropdown_value')])[1]")
                    )
            );
            Thread.sleep(1000);
            //actions.click(StateLabel).sendKeys(Keys.TAB).sendKeys("AL").perform();
            //actions.click(addressLabel).sendKeys(Keys.ARROW_DOWN, Keys.ENTER).perform();
            StateLabel.click();
            StateLabel.sendKeys("AL");
            StateLabel.sendKeys(Keys.ENTER);
            Thread.sleep(1000);
            state = "AL";

            // Print to console
            System.out.println("State selected: " + state);
            // Also log in Allure
            Allure.step("State selected: " + state);
        });

        // -------- Submit --------
        Allure.step("Submitting Legal Request", () -> {
            WebElement submitBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[.//span[text()='Submit']]")
                    )
            );
            //js.executeScript("arguments[0].scrollIntoView(true);", submitBtn);
            submitBtn.click();
            Thread.sleep(2000);

            // Print to console
            System.out.println("Submit clicked successfully");
            // Also log in Allure
            Allure.step("Submit clicked successfully");
        });

    }
    @Test
    public void legalRequest_New_OC_Test_Run() throws InterruptedException {
        fillNewOCRequest();
    }
} */