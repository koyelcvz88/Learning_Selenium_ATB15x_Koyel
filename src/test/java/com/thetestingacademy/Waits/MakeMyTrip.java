package com.thetestingacademy.Waits;

import com.thetestingacademy.CommonToAll;
import com.thetestingacademy.WaitHelpers;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MakeMyTrip extends CommonToAll {
    @Description("Verify makemyTrip opens with modal")
    @Test
    public void test_CloseModal_MMT() {
        ChromeDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.makemytrip.com");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());

        new WaitHelpers().waitForVisibility(driver, 5, "//span[@data-cy=\"closeModal\"]");
        WebElement closeModal = driver.findElement(By.xpath("//span[@data-cy=\"closeModal\"]"));
        closeModal.click();

        closeBrowser(driver);
    }

}
