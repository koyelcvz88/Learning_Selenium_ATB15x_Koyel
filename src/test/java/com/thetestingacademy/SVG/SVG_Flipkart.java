package com.thetestingacademy.SVG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SVG_Flipkart {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com");
        driver.manage().window().maximize();
        driver.findElement(By.name("q")).sendKeys("AC");
        WebElement search = driver.findElement(By.xpath
                ("//*local-name()='svg']/*[local-name()='g' and @fill-rule=\"evenodd\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(search).click().perform();
    }
}
