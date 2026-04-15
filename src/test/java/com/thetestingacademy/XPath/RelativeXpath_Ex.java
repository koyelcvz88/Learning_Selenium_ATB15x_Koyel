package com.thetestingacademy.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeXpath_Ex {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");
        driver.manage().window().maximize();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
                throw new RuntimeException(e);
        }
            driver.switchTo().frame("result");
        WebElement submit = driver.findElement(By.xpath("//form[@id=\"form\"]/button"));
        submit.click();

        WebElement parent_element = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement error = driver.findElement(with(By.tagName("small")).near(parent_element));
        System.out.println(error.getText());
    }
}
