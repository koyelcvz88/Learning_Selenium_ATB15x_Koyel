package com.thetestingacademy.Actions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class AppVWO_CompleteSignup_Task {

    @Test
    public void completeSignupFlow() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1. Open login page
        driver.get("https://app.vwo.com/#/login");

        // 2. Click FREE TRIAL button
        driver.findElement(By.linkText("Start a FREE TRIAL")).click();

        // 3. Switch to new tab
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        // 4. Enter invalid email
        WebElement email = driver.findElement(By.id("page-v1-step1-email"));
        email.sendKeys("normal@gmail.com");

        // Press ENTER to trigger validation
        email.sendKeys(org.openqa.selenium.Keys.ENTER);

        Thread.sleep(2000);

        // 5. Capture validation message
        WebElement errorMsg = driver.findElement(By.xpath("//div[contains(text(),'business domain')]"));
        System.out.println("Error Message: " + errorMsg.getText());

        Assert.assertTrue(errorMsg.isDisplayed());

        // 6. Clear email field
        email = driver.findElement(By.id("page-v1-step1-email"));
        email.clear();

        // 7. Enter valid email
        email.sendKeys("XX@tempmail.com");

        // 8. Click checkbox
        driver.findElement(By.id("page-free-trial-step1-cu-gdpr-consent-checkbox")).click();

        Thread.sleep(2000);

        // 9. Click "Create Free Trial Account" button
        driver.findElement(By.cssSelector("button[data-qa='page-su-submit']")).click();

        Thread.sleep(3000);

        // 10. Enter First Name
        driver.findElement(By.id("page-v1-fname")).sendKeys("XXX");

        // 11. Enter Last Name
        driver.findElement(By.id("page-v1-lname")).sendKeys("X");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // locate phone field
        WebElement phoneField = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("page-v1-pnumber")
                )
        );

         // click on field
        phoneField.click();

         // clear if anything prefilled
        phoneField.clear();

        // enter phone number
        phoneField.sendKeys("1234567890");

        // 12. Clicking on Create Account

        WebElement createAccountBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[normalize-space()='Create Account']")
                )
        );

        createAccountBtn.click();

        Thread.sleep(3000);

        // locate skip button
        WebElement skipBtn = driver.findElement(
                By.xpath("//button[@data-step='free-trial-thankyou']")
        );

        // click
        skipBtn.click();

        // Continue Setup click
        WebElement btn = driver.findElement(By.xpath("//button[contains(.,'Continue Setup')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
        Thread.sleep(2000);

        //Click Resend email button (Verify Account section)
        WebElement resend = driver.findElement(By.xpath("//button[@data-qa='wiyogilimo']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", resend);
        Thread.sleep(1000);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", resend);
        Thread.sleep(2000);

        // Click and expand data centre
        WebElement tile = driver.findElement(By.xpath("//div[@data-qa='sologixico']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", tile);
        Thread.sleep(2000);

        // Click Save
        WebElement saveBtn = driver.findElement(By.xpath("//button[@data-qa='boxasuraza']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveBtn);
        Thread.sleep(1000);

        saveBtn.click();
        Thread.sleep(2000);

        // Click and expand Select products
        WebElement el = driver.findElement(By.xpath("//h5[normalize-space()='Select your products']/ancestor::div[@data-qa='sologixico']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[normalize-space()='Add domain']")).click();
        Thread.sleep(2000);
        //copy
        WebElement copyButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-qa='xugejexijo']")));
        Actions GoToCopy = new Actions(driver);
        for(int i = 0; i < 7; i++){
            GoToCopy.sendKeys(Keys.TAB).perform();
        }
        GoToCopy.sendKeys(Keys.ENTER).perform();

        // Opens a new tab and automatically switches Selenium's focus to it
        driver.switchTo().newWindow(WindowType.TAB);

        // Navigate to a new URL in this new tab
        driver.get("https://www.google.com");

        //Find the actual Google Search box (its HTML name attribute is "q")
        WebElement googleSearchBox = driver.findElement(By.className("gLFyf"));

        //Use the Actions class to simulate Ctrl + V (Use Keys.COMMAND for Mac)
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL) // Hold down Ctrl
                .sendKeys("v")// Press 'v'
                .keyUp(Keys.CONTROL) // Release Ctrl
                .perform();// Execute the action

        //Verify the text!
        String pastedText = googleSearchBox.getAttribute("value");
        if(pastedText.contains("visualwebsiteoptimizer")) {
            System.out.println("Verification Passed via Actions!");
        } else {
            System.out.println("not copied or not copied not to pasted");
        }

        System.out.println("Signup flow completed successfully.");

        // driver.quit(); // optional
    }

}