/* package com.thetestingacademy.Trimont.DeletedCode;

public class Legal_Request_NewOC_REMOVED {
}
package com.thetestingacademy.Trimont;

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

public class Legal_Request_NewOC_Test extends Legal_Request_Form_Fields_Test {
    @Test
    @Owner("Koyel")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Testcase 4 - Verify user is able to Initiate a new request with New OC ")

    public void legalRequest_New_OC_Test() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        legalRequest_Form_Fields_Test();   // call TC2

        Allure.step("Entering Request Matter ", () -> {
            // Selecting Request Matter
            WebElement RequestMatter_TxtBox = driver.findElement(By.cssSelector("input.TextInput---text[type='text']"));
            System.out.println("Looking for Request Matter Text ");

            // Enter your text
            RequestMatter_TxtBox.sendKeys("New_OC_New_Legal_Request");

            System.out.println("Text entered in the textbox");
        });
    }

}


-----------------------------------------------------------------------------------------------------
package com.thetestingacademy.Trimont;

/*import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

@Epic("VenReq Automation Suite")
@Feature("Legal Request Module")
@Story("Initiate Legal Request with New OC")
public class Legal_Request_NewOC_Test extends Legal_Request_Form_Fields_Test {

    // Variables to store selections/input for summary validation
    protected String requestMatterNew;
    protected String ocFirmName;
    protected String ocJustification;
    protected String attorneyName;
    protected String phoneNumber;
    protected String emailAddress;
    protected String city;
    protected String state;

    /**
     * Reusable method for workflow runner

    @Owner("Koyel")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Testcase 4 - Verify user is able to Initiate a new request with New OC")
    public void fillNewOCRequest() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        // Fill the Legal Request Form (TC2)
        fillLegalRequestForm();

        // Enter Request Matter
        Allure.step("Entering Request Matter", () -> {
            WebElement requestMatterNewTxtBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//label[contains(text(),'Request/Matter Name')]/following::input[1]")));
            Thread.sleep(1000);
            requestMatterNewTxtBox.click();
            requestMatterNew = "New_OC_New_Legal_Request"; // store value
            requestMatterNewTxtBox.sendKeys(requestMatterNew);
            System.out.println("Request Matter entered: " + requestMatterNew);
        });

        // Enter OC Firm Name
        Allure.step("Enter OC Firm Name", () -> {
            WebElement OC_label = driver.findElement(By.xpath("//strong[normalize-space()='OC Firm Name']"));
            OC_label.click();
            Thread.sleep(500);
            actions.sendKeys(Keys.TAB).perform();
            Thread.sleep(300);
            ocFirmName = "Auto New OC Firm"; // store value
            actions.sendKeys(ocFirmName).perform();
            Thread.sleep(500);
            System.out.println("OC Firm Name entered: " + ocFirmName);
        });

        // Enter OC Justification
        Allure.step("Enter OC Justification", () -> {
            WebElement Jus_label = driver.findElement(By.xpath("//strong[normalize-space()='New Outside Counsel Justification']"));
            Jus_label.click();
            Thread.sleep(500);
            actions.sendKeys(Keys.TAB).perform();
            Thread.sleep(300);
            ocJustification = "Outside counsel engaged for due diligence on strategic real estate transactions.";
            actions.sendKeys(ocJustification).perform();
            Thread.sleep(500);
            System.out.println("OC Justification entered: " + ocJustification);
        });

        // Enter Attorney Name
        Allure.step("Enter Attorney Name", () -> {
            WebElement Att_label = driver.findElement(By.xpath("//strong[normalize-space()='Attorney Name']"));
            Att_label.click();
            Thread.sleep(500);
            actions.sendKeys(Keys.TAB).perform();
            Thread.sleep(300);
            attorneyName = "Auto New Attorney"; // store value
            actions.sendKeys(attorneyName).perform();
            Thread.sleep(500);
            System.out.println("Attorney Name entered: " + attorneyName);
        });

        // Enter Phone Number and validate
        Allure.step("Enter Phone Number and Validate", () -> {
            WebElement Ph_label = driver.findElement(By.xpath("//strong[normalize-space()='Phone']"));
            Ph_label.click();
            Thread.sleep(500);
            actions.sendKeys(Keys.TAB).perform();
            Thread.sleep(300);
            phoneNumber = "1234567890";
            actions.sendKeys(phoneNumber).perform();
            Thread.sleep(300);

            WebElement phoneField = driver.switchTo().activeElement();
            String phoneValue = phoneField.getAttribute("value").replaceAll("[^0-9]", "");
            Assert.assertTrue(phoneValue.matches("\\d{10}"), "Phone should be 10 digits. Entered: " + phoneValue);
            System.out.println("Phone validation passed: " + phoneValue);
        });

        // Enter Email and validate
        Allure.step("Enter Email and Validate", () -> {
            WebElement emailLabel = driver.findElement(By.xpath("//strong[normalize-space()='Email']"));
            emailLabel.click();
            Thread.sleep(500);
            actions.sendKeys(Keys.TAB).perform();
            Thread.sleep(300);
            emailAddress = "autouser@mail.com";
            actions.sendKeys(emailAddress).perform();
            Thread.sleep(300);

            WebElement emailField = driver.switchTo().activeElement();
            String emailValue = emailField.getAttribute("value");
            Assert.assertTrue(emailValue.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"),
                    "Email format invalid. Entered: " + emailValue);
            System.out.println("Email validation passed: " + emailValue);
        });

        // Enter City
        Allure.step("Enter City", () -> {
            WebElement addressLabel = driver.findElement(By.xpath("//strong[normalize-space()='Address']"));
            addressLabel.click();
            Thread.sleep(500);
            actions.sendKeys(Keys.TAB).perform();
            Thread.sleep(300);
            city = "Sitka";
            actions.sendKeys(city).perform();
            Thread.sleep(500);
            System.out.println("City entered: " + city);
        });

        // Select State
        Allure.step("Select State", () -> {
            WebElement addressLabel = driver.findElement(By.xpath("//strong[normalize-space()='Address']"));
            addressLabel.click();
            Thread.sleep(500);
            actions.sendKeys(Keys.TAB).perform();
            Thread.sleep(200);
            actions.sendKeys(Keys.TAB).perform();
            Thread.sleep(300);
            actions.sendKeys(Keys.SPACE).perform();
            Thread.sleep(500);
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            Thread.sleep(300);
            actions.sendKeys(Keys.ENTER).perform();
            Thread.sleep(500);
            state = "SelectedState";
            System.out.println("State selected: " + state);
        });

        // Click Submit
        Allure.step("Click Submit", () -> {
            WebElement submitBtn = driver.findElement(By.xpath("//button[.//span[text()='Submit']]"));
            submitBtn.click();
            Thread.sleep(2000);
            System.out.println("Submit button clicked successfully.");
        });
    }

    // Optional standalone @Test if needed

    @Test
    public void legalRequest_New_OC_Test_Run() throws InterruptedException {
        fillNewOCRequest();
    }

}
*/