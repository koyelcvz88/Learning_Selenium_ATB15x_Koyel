package com.thetestingacademy.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelector_Test {
    public static void main(String[] args ) {
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://awesomeqa.com/webtable1.html");
        driver.manage().window().maximize();
        WebElement table = driver.findElement(By.cssSelector("//table[@summary=\"Sample Table\"/tbody"));
        String color = table.getAttribute("Color");
    }
}
