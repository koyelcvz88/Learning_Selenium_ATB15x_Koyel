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

public class Flipkart_MacMini_Dummy {
    /*public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        // Open Flipkart
        driver.get("https://www.flipkart.com/search?q=macmini&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Enter search text
         WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("q"))
        );
         //searchBox.sendKeys("Mac Mini");

        // Click search button using SVG XPath
        WebElement searchBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[.//*[name()='svg']]")
                )
        );
        searchBtn.click(); */

        /* try {
            // Close login popup (if appears)
            /* try {
                WebElement closeBtn = wait.until(
                        ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='✕']"))
                );
                closeBtn.click();
                } catch (Exception e) {
                System.out.println("Login popup not displayed");
            }



            // Wait for products to load
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@class='_4rR01T'] | //a[@class='s1Q9rs']")
            ));

            // Get product titles
            List<WebElement> titles = driver.findElements(
                    By.xpath("//div[@class='_4rR01T'] | //a[@class='s1Q9rs']")
            );


        // Get product prices
        List<WebElement> prices = driver.findElements(
                By.xpath("//div[@class='_30jeq3 _1_WHN1']")
        );

        List<Integer> priceList = new ArrayList<>();

        System.out.println("----- Product List -----");

        for (int i = 0; i < prices.size(); i++) {
            String title = titles.get(i).getText();
            String priceText = prices.get(i).getText().replaceAll("[^0-9]", "");
            int price = Integer.parseInt(priceText);
                priceList.add(price);

                System.out.println(title + " --> ₹" + price);
            }

            // Find cheapest product
            int minPrice = priceList.get(0);
            int index = 0;

            for (int i = 1; i < priceList.size(); i++) {

                if (priceList.get(i) < minPrice) {
                    minPrice = priceList.get(i);
                    index = i;
                }
            }

            System.out.println("\n✅ Cheapest Product:");
            System.out.println(titles.get(index).getText());
            System.out.println("Price: ₹" + minPrice);

        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            driver.quit();
        }
    } */
}







