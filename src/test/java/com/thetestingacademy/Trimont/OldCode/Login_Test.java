package com.thetestingacademy.Trimont.OldCode;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class Login_Test {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeClass(alwaysRun = true)
    @Description("Setup WebDriver and perform login before tests")
    public void setUpAndLogin() throws InterruptedException {
        Allure.step("Initializing WebDriver and opening login page", () -> {
            driver = new EdgeDriver();
            driver.get("https://trimont-test.appiancloud.com/suite/portal/login.jsp");
            driver.manage().window().maximize();
            Thread.sleep(5000); // Wait for page to load
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        });

        Allure.step("Entering username", () -> {
            WebElement username = driver.findElement(By.id("un"));
            username.sendKeys("AM_CMSTest");
        });

        Allure.step("Entering password", () -> {
            WebElement password = driver.findElement(By.id("pw"));
            password.sendKeys("Maantic@2026");
        });

        Allure.step("Clicking on Signin button", () -> {
            WebElement signin_btn = driver.findElement(By.id("jsLoginButton"));
            signin_btn.click();
        });

        Allure.step("Verifying if Hello username banner is valid", () -> {
            WebElement banner = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//span[@class='SizedText---large SizedText---predefined']")
                    )
            );
            String bannerText = banner.getText();
            // Log the banner text directly in Allure
            Allure.step("Banner Text: " + bannerText);
            // Print to console
            System.out.println("Banner Text: " + bannerText);
            Thread.sleep(2000);
            //Assert.assertEquals(bannerText, "Hello, AM_CMS!");
            // Assertion with try-catch to log success/failure
            try {
                Assert.assertEquals(bannerText, "Hello, AM_CMS!");
                // Runs only if assertion passes
                System.out.println("Validation PASSED: Banner text is correct.");
                Allure.step("Validation PASSED: Banner text is correct.");
            } catch (AssertionError e) {
                // Runs if assertion fails
                System.out.println("Validation FAILED: Banner text is incorrect.");
                Allure.step("Validation FAILED: Banner text is incorrect.");
                throw e; // re-throw to make the test fail
            }
        });
    }

    @AfterClass(alwaysRun = true)
    @Description("Quit WebDriver after tests")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed.");
        }
    }
}