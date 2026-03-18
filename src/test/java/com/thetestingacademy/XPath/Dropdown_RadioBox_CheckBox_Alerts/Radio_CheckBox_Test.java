package com.thetestingacademy.XPath.Dropdown_RadioBox_CheckBox_Alerts;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Radio_CheckBox_Test {
    @Description("Verify Radiobox and Checkbox")
    @Test
    public void test_HTMLTags() {
        ChromeDriver driver = new ChromeDriver();
        driver.navigate().to("https://awesomeqa.com/practice.html");

        WebElement firstname = driver.findElement(By.xpath("//input[@name=\"firstname\"]"));
        firstname.sendKeys("the testing academy");

        // Radio Box
        WebElement radiobox = driver.findElement(By.id("sex-1"));
        radiobox.click();

        //Checkbox
        driver.findElement(By.id("tool-1")).click();
    }
}
