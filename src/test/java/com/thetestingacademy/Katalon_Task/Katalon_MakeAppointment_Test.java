package com.thetestingacademy.Katalon_Task;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})

public class Katalon_MakeAppointment_Test {
    @Description("Testcase - Verify that the user is able to login and make Appointment")
    @Test
    public void test_appoint_cura_hero() throws InterruptedException {
        Allure.step("Starting appointment test in Allure");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);

        // make appointment button
        // <a id="btn-make-appointment" href="./profile.php#login"
        // class="btn btn-dark btn-lg">Make Appointment</a>

        WebElement appoint_btn = driver.findElement(By.id("btn-make-appointment"));
        appoint_btn.click();

        Thread.sleep(5000);

        // username textfield
        // <input type="text" class="form-control" id="txt-username" name="username"
        // placeholder="Username" value="" autocomplete="off">

        WebElement username = driver.findElement(By.id("txt-username"));
        username.sendKeys("John Doe");

        // password textfield
        // <input type="password" class="form-control" id="txt-password" name="password"
        // placeholder="Password" value="" autocomplete="off">

        WebElement password = driver.findElement(By.id("txt-password"));
        password.sendKeys("ThisIsNotAPassword");

        // Login button
        // <button id="btn-login" type="submit" class="btn btn-default">Login</button>

        WebElement login_btn = driver.findElement(By.id("btn-login"));
        login_btn.click();

        Thread.sleep(10000);

        // verify if url and make appointment header is present
        Allure.step("Verify user is redirected to appointment page");

        String expectedURL = "https://katalon-demo-cura.herokuapp.com/#appointment";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL, expectedURL, "URL mismatch after login");
        Assert.assertTrue(driver.getCurrentUrl().contains("appointment"));
        WebElement headerText = driver.findElement(By.tagName("h2"));
        System.out.println(headerText.getText());
        Assert.assertEquals(headerText.getText(), "Make Appointment");

    driver.quit();

    }

}
