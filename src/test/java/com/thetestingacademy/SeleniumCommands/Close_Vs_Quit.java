package com.thetestingacademy.SeleniumCommands;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class Close_Vs_Quit {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        Thread.sleep(15000);
        //driver.close(); // will only close current tab - session will be always present
        driver.quit(); // closes all tabs
    }
}
