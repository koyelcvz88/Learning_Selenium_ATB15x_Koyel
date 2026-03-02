package com.thetestingacademy.Locators;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})

public class Logging_A_Bug_Test {
    @Owner("Koyel")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("https://bugzz.atlassian.net/browse/VWO-20")
    @Description("Verify that the error message comes with invalid email on signup")
    @Test
    public void vwo_free_trail_error_verify() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        /*driver.get("https://app.vwo.com");
        driver.manage().window().maximize();

        WebElement a_tag_partial_match = driver.findElement(By.partialLinkText("Start a free trial"));
        a_tag_partial_match.click();

        Thread.sleep(5000);

        Assert.assertTrue(driver.getCurrentUrl().contains("free-trial")); */

        driver.get("https://vwo.com/free-trial");
        driver.manage().window().maximize();

        WebElement email = driver.findElement(By.id("page-v1-step1-email"));
        email.sendKeys("abc");

        WebElement checkbox_policy = driver.findElement(By.name("gdpr_consent_checkbox"));
        checkbox_policy.click();

        Thread.sleep(5000);

        WebElement button_create_account = driver.findElement(By.tagName("button"));
        button_create_account.click();

        WebElement error_message = driver.findElement(By.className("invalid-reason"));
        Assert.assertEquals(error_message.getText(), "The email address you entered is incorrect.");


    }
}
