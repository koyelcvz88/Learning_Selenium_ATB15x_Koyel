package com.thetestingacademy.XPath.WebTables;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})


public class Selenium_Table_Project2 {
    @Owner("Koyel")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that the user is able to add 5 employees & find Legal dept employee")
    @Test

    public void test_OHRM_legal() throws InterruptedException {
        Allure.step("OrangeHRM test to add employees and delete Legal department employee in Allure");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/webtables");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(5000);

        //add elements
        String data = "";
        String dynamic_xpath = "";
        String[][] employees = {
                {"Arya", "Stark", "arya.stark@test.com", "21", "52000" , "Security"},
                {"Robb", "Stark", "Robb.stark@test.com", "22", "53000" , "Finance"},
                {"Bran", "Stark", "Bran.stark@test.com", "23", "54000" , "Legal Department"},
                {"Sansa", "Stark", "Sansa.stark@test.com", "24", "55000" , "Management"},
                {"Ned", "Stark", "Ned.stark@test.com", "45", "88000" , "Administration"},
        };
        Thread.sleep(5000);

        // printing added employees
        String first_part = "//table[@class='striped -highlight table table-striped table-bordered table-hover']/tbody/tr[";
        String second_part = "]/td[";
        String third_part = "]";

        Integer row = driver.findElements(By.xpath("//table[@class='striped -highlight table table-striped table-bordered table-hover']/tbody/tr")).size();
        Integer col = driver.findElements(By.xpath("//table[@class='striped -highlight table table-striped table-bordered table-hover']/tbody/tr[1]/td")).size();

        // print
        for (int i=1; i<=row; i++) {
            for(int j=1; j<=col; j++) {
                dynamic_xpath = first_part + i +second_part + j + third_part;
                data = driver.findElement(By.xpath(dynamic_xpath)).getText();
                System.out.println(data);
            }
        }
        //finding element with Legal dept
        for (int i=1; i<=row; i++) {
            boolean isDone = false; // stopping whole process
            for(int j=1; j<=col; j++) {
                dynamic_xpath = first_part + i +second_part + j + third_part;
                data = driver.findElement(By.xpath(dynamic_xpath)).getText();
                if (data.contains("Legal Department")) {
                    String salaryLoc = dynamic_xpath + "preceding-sibling::td[1]";
                    String salaryLocTxt = driver.findElement(By.xpath(salaryLoc)).getText();
                    System.out.println("-----");
                    System.out.println("Legal Department Salary is :" + salaryLocTxt + " /- ");

                    // editing name and salary
                }
            }
        }


        //driver.quit(); //
    }
}

