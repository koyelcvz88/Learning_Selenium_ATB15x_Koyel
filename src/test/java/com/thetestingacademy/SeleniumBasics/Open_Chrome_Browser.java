package com.thetestingacademy.SeleniumBasics;

import org.openqa.selenium.chrome.ChromeDriver;

public class Open_Chrome_Browser {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");
        driver.quit();
    }
}
