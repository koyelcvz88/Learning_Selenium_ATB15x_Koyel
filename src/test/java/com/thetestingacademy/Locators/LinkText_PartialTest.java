package com.thetestingacademy.Locators;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.qameta.allure.testng.AllureTestNg;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})

public class LinkText_PartialTest {
    @Description("Verify that the create account Negative TC")
    @Test
    public void test_login_vwo_com() throws InterruptedException {
        Allure.step("Starting free trial test in Allure");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();

        // link text inspect
        // <a class="btn btn--link btn--primary Fw(medium)" target="_blank" rel="noreferrer" data-qa="bericafeqo"
        // vwo-html-translate="login:startFreeTrial">Start a free trial</a>"Start a free trial"

        Thread.sleep(5000);
        WebElement a_Tag_full_match = driver.findElement(By.linkText("Start a free trial"));
        Thread.sleep(5000);
        a_Tag_full_match.click();
        WebElement a_tag_partial_match = driver.findElement(By.partialLinkText("trial"));

        driver.quit();
    }
}
