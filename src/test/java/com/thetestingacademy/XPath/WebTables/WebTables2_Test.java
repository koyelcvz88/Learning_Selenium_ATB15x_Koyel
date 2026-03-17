package com.thetestingacademy.XPath.WebTables;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class WebTables2_Test {
    @Description("Verify that the user is able to view table2")
    @Test
    public void test_web_table_login() throws Exception {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/webtable1.html");
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement table = driver.findElement(By.xpath("//table[@summary=\"Sample Table\"/tbody"));
        List<WebElement> row_tables = table.findElements(By.tagName("tr"));

        for ( int i =0; i<row_tables.size(); i++) {
            List<WebElement> col_tables = row_tables.get(i).findElements(By.tagName("td"));
            for(WebElement c : col_tables) {
                System.out.println(c.getText());
            }
        }

    }
}
