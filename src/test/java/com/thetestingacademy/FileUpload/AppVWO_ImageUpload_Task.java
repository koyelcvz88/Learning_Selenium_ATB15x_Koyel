package com.thetestingacademy.FileUpload;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class AppVWO_ImageUpload_Task {
    @Test
    public void imgUpload() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1. Open login page
        driver.get("https://app.vwo.com/#/login");

        // 2. Enter email
        driver.findElement(By.id("login-username")).sendKeys("aookkys31@inboxs.space");
        Thread.sleep(2000);

        // 3. Enter password
        driver.findElement(By.id("login-password")).sendKeys("Appvwo123");
        Thread.sleep(2000);

        // 4. Click SignIn
        driver.findElement(By.id("js-login-btn")).click();
        Thread.sleep(2000);

        // 5. Click and expand user image
        driver.findElement(By.xpath("//img[@data-qa='user-image']")).click();
        Thread.sleep(3000);

        // 6. Click on Settings option
        WebElement settings = driver.findElement(
                By.xpath("//a[contains(@href,'settings/accounts/general')]")
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", settings);

        Thread.sleep(1000);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", settings);

        Thread.sleep(4000);

        // Validate if Settings url is clicked
        String Settings_currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + Settings_currentUrl);

        if (!Settings_currentUrl.contains("settings/accounts/general")) {
            throw new RuntimeException("❌ Settings page NOT opened - click failed");
        }

        System.out.println("✅ Settings page opened successfully");

        // ---------------- CLICK PROFILE DETAILS ----------------
        WebElement profileDetails = driver.findElement(
                By.xpath("//a[contains(@href,'profile-details')]")
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", profileDetails);

        Thread.sleep(1000);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", profileDetails);

        Thread.sleep(4000);

        // ---------------- VALIDATION ----------------
        String Profile_currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + Profile_currentUrl);

        if (!Profile_currentUrl.contains("profile-details")) {
            throw new RuntimeException("❌ Profile Details NOT opened");
        }

        System.out.println("✅ Profile Details opened successfully");

        // Upload Profile Picture
        WebElement uploadFileInput = driver.findElement(By.id("profile-picture-upload"));

        String user_dir_path = System.getProperty("user.dir");
        System.out.println(user_dir_path);

        uploadFileInput.sendKeys(
                user_dir_path + "/src/test/java/com/thetestingacademy/FileUpload/cartoon_girl.png"
        );

        Thread.sleep(2000);

        // ---------------- CLICK UPLOAD BUTTON ----------------
        WebElement uploadBtn = driver.findElement(
                By.xpath("//button[contains(@class,'btn--primary') and contains(.,'Upload image')]")
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", uploadBtn);

        Thread.sleep(4000);

        System.out.println("✅ File uploaded successfully");
    }
}
