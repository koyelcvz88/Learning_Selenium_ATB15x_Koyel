package com.thetestingacademy.Exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementNotInteractable {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();


        driver.get("data:text/html,<input type='text' id='test' style='display:none'>");

        WebElement element = driver.findElement(By.id("test"));

        try {
            element.click();
        } catch (ElementNotInteractableException e) {
            System.out.println("Printing Exception Message...");
            System.out.println(e.getMessage());
        }

            /*} catch (NoSuchElementException e) {
                System.out.println("Element not found!");
                System.out.println(e.getMessage());
            } */

         finally {
                    driver.quit();
                }
    }
}