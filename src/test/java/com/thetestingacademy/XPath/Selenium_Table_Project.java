package com.thetestingacademy.XPath;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})


public class Selenium_Table_Project {
    @Owner("Koyel")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that the user is able to login & find terminated employee")
    @Test

    public void test_OHRM_term() throws InterruptedException {
        Allure.step("OrangeHRM test to login & delete terminated employee in Allure");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(5000);

        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement button = driver.findElement(By.xpath("//button"));

        username.sendKeys("admin");
        password.sendKeys("Hacker@4321");
        button.click();
        Thread.sleep(5000);

        // Finding terminated employee in PIM
        String term_Emp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//div[contains(text(),'Terminated')]"))).getText();

        System.out.println("Found Terminated Employee");

        // Delete Icon
        WebElement delIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                (".oxd-icon-button.oxd-table-cell-action-space")));

        System.out.println(delIcon.isDisplayed());

        // Click delete icon
        WebElement delBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//i[contains(@class,'bi-trash')]/parent::button")));

        delBtn.click();

        driver.quit();
    }
}
