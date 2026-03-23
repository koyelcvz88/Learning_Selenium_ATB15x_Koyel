package com.thetestingacademy.Waits;

import com.thetestingacademy.CommonToAll;
import com.thetestingacademy.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.function.Function;

public class FluentWait_Ex extends CommonToAll {
    public static void main(String[] args){
        ChromeDriver driver = new ChromeDriver();
        driver.navigate().to("https://app.vwo.com");
        System.out.println(driver.getTitle());

        Assert.assertEquals(driver.getTitle(), "Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com");

        WebElement email_input_box = driver.findElement(By.id("login-username")); // id locator
        email_input_box.sendKeys("admin@admin.com");

        WebElement password_input_box = driver.findElement(By.name("password")); // name locator
        password_input_box.sendKeys("wrongpass@321");

        WebElement button_submit = driver.findElement(By.id("js-login-btn")); // id locator
        button_submit.click();

       /* FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchFieldError.class);

        WebElement error_message = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement((By.className("notification-box-description")));
            }
        });
        //new WaitHelpers().checkVisibilityByFluentWait(driver,10,2); */


    }
}
