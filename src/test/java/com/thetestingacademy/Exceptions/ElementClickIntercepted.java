package com.thetestingacademy.Exceptions;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ElementClickIntercepted {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
    }

    @Description("Verify ElementClickIntercepted Exception")
    @Test
    public void test_actions() {
        try {
            driver.get("https://google.com");
            driver.manage().window().maximize();


            // Inject a button and an overlay that blocks it
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(
                    "let btn = document.createElement('button');" +
                            "btn.id='test-btn'; btn.innerText='Click Me';" +
                            "btn.style.position='absolute'; btn.style.top='200px'; btn.style.left='200px';" +
                            "document.body.appendChild(btn);" +
                            "let overlay = document.createElement('div');" +
                            "overlay.style.width='100%'; overlay.style.height='100%';" +
                            "overlay.style.position='absolute'; overlay.style.top='0'; overlay.style.left='0';" +
                            "overlay.style.background='rgba(0,0,0,0.5)'; overlay.id='overlay';" +
                            "document.body.appendChild(overlay);"
            );


            // Wait until the search box is visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("test-btn")));

            // Attempt to click the button (will throw ElementClickInterceptedException)
            WebElement button = driver.findElement(By.id("test-btn"));
            button.click();

        } catch (ElementClickInterceptedException e) {
            System.out.println("ElementClickInterceptedException caught!");
            System.out.println(e);
        }
        System.out.println("End of the Program");
    }
    @AfterTest
    public void closeBrowser() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

}
