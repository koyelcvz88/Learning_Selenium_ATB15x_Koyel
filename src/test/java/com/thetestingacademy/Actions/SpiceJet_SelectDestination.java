package com.thetestingacademy.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SpiceJet_SelectDestination {
    @Test
    public void testSpiceJet() {
        ChromeDriver driver = new ChromeDriver();
        String URL = "https://www.spicejet.com/";
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement origin = driver.findElement(By.xpath
                ("//div[@data-testid=\"to-testID-origin\"]/div/div/input"));
        WebElement destination = driver.findElement(By.xpath
                ("//div[@data-testid=\"to-testID-destination\"]/div/div/input"));

        Actions actions = new Actions(driver);
        actions.moveToElement(origin().sendKeys("BLR"))
                .moveToElement(destination().sendKeys("DEL"))
                .build().perform();
    }

}
