package com.thetestingacademy.XPath.Dropdown_RadioBox_CheckBox_Alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.thetestingacademy.CommonToAll;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.thetestingacademy.WaitHelpers.waitForAlert;
import static com.thetestingacademy.WaitHelpers.waitJVM;

public class AlertsEx_Test extends CommonToAll {
    @Test
    public void testAlerts() {
        ChromeDriver driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
        WebElement elementConfirm = driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]"));
        WebElement elementPrompt = driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]"));

        element.click();
        //elementConfirm.click();
        //elementPrompt.click();

        waitForAlert(driver,5);

        Alert alert= driver.switchTo().alert();
        alert.sendKeys("Koyel");
        alert.accept();

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result, "You successfully clicked an alert");
        Assert.assertEquals(result, "You clicked OK");
        Assert.assertEquals(result, "You entered Koyel");

        waitJVM(5000);
        closeBrowser(driver);
    }
}
