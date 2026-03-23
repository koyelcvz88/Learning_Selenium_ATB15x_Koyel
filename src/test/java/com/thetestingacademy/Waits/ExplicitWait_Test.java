package com.thetestingacademy.Waits;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWait_Test {
    @Description("Verify MakemyTrip opens with modal")
    @Test
    public void testCloseModal() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.makemytrip.com/");
        System.out.println(driver.getTitle());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//span[@data-cy='closeModal']")));
        WebElement closeModal = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
        closeModal.click();

        Thread.sleep(10000);

        /*try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new InterruptedException(e);
        } */
    }
}
