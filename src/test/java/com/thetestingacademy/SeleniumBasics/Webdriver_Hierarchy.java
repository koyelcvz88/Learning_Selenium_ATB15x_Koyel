package com.thetestingacademy.SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Webdriver_Hierarchy {
    public static void main(String[] args) {
        // when we want to run on Chrome / Edge ?
        ChromeDriver driver = new ChromeDriver();
        // When we run on Chrome then change to Edge
        WebDriver driver1 = new ChromeDriver();
        // when we want to run on multiple machine , aws etc
        RemoteWebDriver driver2 = new FirefoxDriver();
    }
}
