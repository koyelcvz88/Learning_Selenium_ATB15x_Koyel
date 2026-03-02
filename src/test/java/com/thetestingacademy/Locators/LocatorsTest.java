package com.thetestingacademy.Locators;

import io.qameta.allure.Allure;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class LocatorsTest {
        @Test
        public void test_app_vwo_com() throws InterruptedException{

            // Force an Allure step
            Allure.step("Starting test in Allure");

            System.out.println("Test running");
            ChromeDriver driver = new ChromeDriver();
            driver.get("https://app.vwo.com");
            driver.manage().window().maximize();

            WebElement email_input_box = driver.findElement(By.id("login-username")); // id locator
            email_input_box.sendKeys("admin@admin.com");

            WebElement password_input_box = driver.findElement(By.name("password")); // name locator
            password_input_box.sendKeys("wrongpass@123");

            WebElement button_submit = driver.findElement(By.id("js-login-btn")); // id locator
            button_submit.click();

            // wait
            Thread.sleep(5000);

            // verify error message
            WebElement error_message = driver.findElement(By.className("notification-box-description"));
            System.out.println(error_message.getText());

            // Assert message
            //Assert.assertEquals(error_message.getText(),"Your email, password, IP address or Location did not match");
            driver.quit();

            Allure.step("Test completed in Allure");
        }
}

