package com.thetestingacademy.SVG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Flipkart_MacMini_Task {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        // Open Flipkart
        driver.get("https://www.flipkart.com/search?q=macmini&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        List<WebElement> svgElements = driver.findElements(
                By.xpath("//*[local-name()='svg']"));
        svgElements.get(0).click();

        // Get product prices
        //List<WebElement> prices = wait.until(
                //ExpectedConditions.visibilityOfAllElementsLocatedBy(
                 //       By.xpath("//div[contains(@class,'hz3P6w')]")));
        List<WebElement> prices = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.xpath("//div[contains(text(),'₹')]")
                )
        );

        for (WebElement price : prices) {
            System.out.println(price.getText());
        }

        // Get product titles
        List<WebElement> titles = driver.findElements(
                By.xpath("//a[contains(@class,'pIpigb')]")
        );

        System.out.println("Total titles: " + titles.size());

        for (WebElement title : titles) {
            System.out.println(title.getText());
        }

        // Important: avoid index mismatch
        int size = Math.min(titles.size(), prices.size());

        int minPrice = Integer.MAX_VALUE;
        String cheapestProduct = "";

        for (int i = 0; i < size; i++) {

            String title = titles.get(i).getAttribute("title");

            String priceText = prices.get(i).getText().replaceAll("[^0-9]", "");

            // Skip if empty (safety)
            if (priceText.isEmpty()) continue;

            int price = Integer.parseInt(priceText);

            System.out.println(title + " --> ₹" + price);

            if (price < minPrice) {
                minPrice = price;
                cheapestProduct = title;
            }
        }

        System.out.println("\n🔥 Cheapest Product:");
        System.out.println(cheapestProduct);
        System.out.println("Price: ₹" + minPrice);

        driver.quit();
    }
}
