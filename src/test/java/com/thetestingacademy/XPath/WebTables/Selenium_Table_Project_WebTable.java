package com.thetestingacademy.XPath.WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class Selenium_Table_Project_WebTable {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://demoqa.com/webtables"); // replace with your table URL
        driver.manage().window().maximize();

        // Employee data exactly as provided
        List<Map<String, String>> employees = new ArrayList<>();

        Map<String, String> emp1 = new HashMap<>();
        emp1.put("firstName", "Arya");
        emp1.put("lastName", "Stark");
        emp1.put("email", "arya@test.com");
        emp1.put("age", "22");
        emp1.put("salary", "50000");
        emp1.put("department", "Security");
        employees.add(emp1);

        Map<String, String> emp2 = new HashMap<>();
        emp2.put("firstName", "Sansa");
        emp2.put("lastName", "Stark");
        emp2.put("email", "sansa@test.com");
        emp2.put("age", "25");
        emp2.put("salary", "60000");
        emp2.put("department", "Legal");
        employees.add(emp2);

        Map<String, String> emp3 = new HashMap<>();
        emp3.put("firstName", "Jon");
        emp3.put("lastName", "Snow");
        emp3.put("email", "jon@test.com");
        emp3.put("age", "28");
        emp3.put("salary", "55000");
        emp3.put("department", "IT");
        employees.add(emp3);

        Map<String, String> emp4 = new HashMap<>();
        emp4.put("firstName", "Tyrion");
        emp4.put("lastName", "Lannister");
        emp4.put("email", "tyrion@test.com");
        emp4.put("age", "32");
        emp4.put("salary", "70000");
        emp4.put("department", "Legal Department"); // exact match target
        employees.add(emp4);

        Map<String, String> emp5 = new HashMap<>();
        emp5.put("firstName", "Cersei");
        emp5.put("lastName", "Lannister");
        emp5.put("email", "cersei@test.com");
        emp5.put("age", "35");
        emp5.put("salary", "75000");
        emp5.put("department", "HR");
        employees.add(emp5);

        // Add all employees to the table
        for (Map<String, String> emp : employees) {
            driver.findElement(By.id("addNewRecordButton")).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName"))).sendKeys(emp.get("firstName"));
            driver.findElement(By.id("lastName")).sendKeys(emp.get("lastName"));
            driver.findElement(By.id("userEmail")).sendKeys(emp.get("email"));
            driver.findElement(By.id("age")).sendKeys(emp.get("age"));
            driver.findElement(By.id("salary")).sendKeys(emp.get("salary"));
            driver.findElement(By.id("department")).sendKeys(emp.get("department"));

            driver.findElement(By.id("submit")).click();
            Thread.sleep(500); // brief pause to allow row to appear
        }

        // Wait until table rows are visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr")));

        // Find employees with exact department = "Legal Department"
        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

        boolean legalDeptFound = false;
        List<WebElement> legalRows = new ArrayList<>();

        // Collecting Legal Dept rows
        for (WebElement row : rows) {
            String department = row.findElement(By.xpath("./td[6]")).getText(); // Department column
            if (department.equals("Legal Department")) { // exact match
                String firstName = row.findElement(By.xpath("./td[1]")).getText();
                String lastName = row.findElement(By.xpath("./td[2]")).getText();
                System.out.println("Legal Dept Employee: " + firstName + " " + lastName);
                legalRows.add(row); // add matching rows for deletion
                legalDeptFound = true;
            }
        }

        if (!legalDeptFound) {
            System.out.println("No Legal Department employee found!");
        }

        // ====== DELETE BLOCK (after Legal Dept found) ======
        /*for (WebElement legalRow : legalRows) {
            try {
                WebElement deleteBtn = legalRow.findElement(By.xpath(".//span[@title='Delete']"));
                deleteBtn.click();
                System.out.println("Deleted Legal Department Employee!");
                Thread.sleep(500); // brief pause to ensure deletion is processed
            } catch (Exception e) {
                System.out.println("Delete button not found for employee in Legal Department.");
            }
        } */
        for (WebElement legalRow : legalRows) {
            try {
                // Get employee name from the row
                String firstName = legalRow.findElement(By.xpath("./td[1]")).getText();
                String lastName = legalRow.findElement(By.xpath("./td[2]")).getText();

                // Locate delete button using the employee's first and last name
                WebElement deleteBtn = driver.findElement(By.xpath(
                        "//table/tbody/tr[td[1]='" + firstName + "' and td[2]='" + lastName + "']//span[@title='Delete']"
                ));
                deleteBtn.click();
                System.out.println("Deleted Legal Department Employee: " + firstName + " " + lastName);
                Thread.sleep(500); // brief pause to ensure deletion is processed
            } catch (Exception e) {
                System.out.println("Delete button not found for employee in Legal Department.");
            }
        }
// ====== END FIXED DELETE BLOCK ======
        // ====== END DELETE BLOCK ======

        //driver.quit();
    }
}