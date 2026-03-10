package com.thetestingacademy.Trimont.DeletedCode;

public class Legal_Request_ExistingOC_REMOVED {
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

public class Legal_Request_ExistingOC_Test extends Legal_Request_Form_Fields_Test {
    @Test
    @Owner("Koyel")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Testcase 3 - Verify user is able to Initiate a new request with Existing OC ")

    public void legalRequest_Existing_OC_Test() throws InterruptedException  {
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        fillLegalRequestForm();  // Call a reusable method in TC2 instead of the @Test method

        Allure.step("Entering Request Matter ", () -> {
            // Selecting Request Matter
            WebElement requestMatterTxtBox = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector("input.TextInput---text[type='text']")
                    )
            );
            WebElement requestMatterTxtBox = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.cssSelector("input.TextInput---text[type='text']")
                    )
            );
            WebElement requestMatterTxtBox = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//input[contains(@class,'TextInput---text')]")
                    )
            );
            wait.until(ExpectedConditions.elementToBeClickable(requestMatterTxtBox));

            System.out.println("Looking for Request Matter Text ");

            // Enter your text
            requestMatterTxtBox.click();          // ensure focus
            requestMatterTxtBox.clear();          // clear if any pre-filled text
            requestMatterTxtBox.sendKeys("Ex_OC_New_Legal_Request");

            System.out.println("Text entered in the textbox");
        });
    }

    // Reusable method to call TC2
    public void fillLegalRequestForm() throws InterruptedException {
        legalRequest_Form_Fields_Test(); // or move all TC2 steps here as a reusable method
    }

}
*/