package com.thetestingacademy.XPath.Dropdown_RadioBox_CheckBox_Alerts;

import com.thetestingacademy.CommonToAll;
import com.thetestingacademy.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropdownEx_Test extends CommonToAll {
    @Test
    public void test_select() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement element = driver.findElement(By.id("dropdown"));
        Select select = new Select(element);
        select.selectByVisibleText("Option 2");
        select.selectByIndex(0);
        WaitHelpers.waitJVM(4000);
        closeBrowser(driver);


    }

}
