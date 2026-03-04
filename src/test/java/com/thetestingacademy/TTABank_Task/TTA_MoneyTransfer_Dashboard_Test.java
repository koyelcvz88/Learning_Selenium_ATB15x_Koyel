package com.thetestingacademy.TTABank_Task;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TTA_MoneyTransfer_Dashboard_Test {
    @Description("Verify that the user is able to create account to TTABank & transfer funds")
    @Test
    public void test_TTA_signup() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://tta-bank-digital-973242068062.us-west1.run.app/");
        driver.manage().window().maximize();
        Thread.sleep(5000);

        // signup
        // <button class="font-medium text-blue-600 hover:text-blue-500 focus:outline-none">Sign Up</button>
        WebElement signupbtn = driver.findElement(By.xpath("//button[normalize-space()='Sign Up']"));
        signupbtn.click();
        Thread.sleep(3000);

        // <input class="block w-full rounded-lg border border-slate-300 bg-slate-50 p-3 pl-10 text-slate-900
        // placeholder-slate-400 focus:border-blue-500 focus:ring-blue-500 sm:text-sm" placeholder="John Doe"
        // type="text" value="">
        WebElement FullName = driver.findElement(By.xpath("//input[@type='text']"));

        // <input class="block w-full rounded-lg border border-slate-300 bg-slate-50 p-3 pl-10 text-slate-900
        // placeholder-slate-400 focus:border-blue-500 focus:ring-blue-500 sm:text-sm" placeholder="you@example.com"
        // type="email" value="">
        WebElement emailId = driver.findElement(By.xpath("//input[@type='email']"));

        // <input class="block w-full rounded-lg border border-slate-300 bg-slate-50 p-3 pl-10 text-slate-900
        // placeholder-slate-400 focus:border-blue-500 focus:ring-blue-500 sm:text-sm" placeholder="••••••••"
        // type="password" value="">
        WebElement Password = driver.findElement(By.xpath("//input[@type='password']"));

        FullName.sendKeys("Koyel");
        emailId.sendKeys("koyel@testmail.com");
        Password.sendKeys("Koyel@123");

        // <button type="submit" class="flex w-full justify-center rounded-lg bg-blue-600 px-4 py-3 text-sm font-semibold
        // text-white shadow-md transition-colors hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-500
        // focus:ring-offset-2 disabled:opacity-70">Create Account</button>

        WebElement CreateAccbtn = driver.findElement(By.xpath("//button[@type='submit']"));
        CreateAccbtn.click();
        Thread.sleep(3000);

        // Transfer Funds
        // <button class="flex w-full items-center gap-3 rounded-lg px-3 py-3 text-sm font-medium
        // transition-colors text-slate-300 hover:bg-slate-800 hover:text-white">
        // <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
        // fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
        // class="lucide lucide-arrow-right-left h-5 w-5" aria-hidden="true"><path d="m16 3 4 4-4 4"></path>
        // <path d="M20 7H4"></path><path d="m8 21-4-4 4-4"></path><path d="M4 17h16"></path>
        // </svg>Transfer Funds</button>

        WebElement TransFndbtn = driver.findElement(By.xpath("//button[normalize-space()='Transfer Funds']"));
        TransFndbtn.click();
        Thread.sleep(3000);

       // <input class="block w-full rounded-lg border border-slate-300 bg-white p-3 pl-8 text-slate-900
        // focus:border-blue-500 focus:ring-blue-500" placeholder="0.00" type="number" value="">
        WebElement Amount_Input = driver.findElement(By.xpath("//input[@type='number']"));
        Amount_Input.sendKeys("5000");

        // <button class="w-full rounded-lg bg-blue-600 py-3 font-semibold text-white transition-colors
        // hover:bg-blue-700 disabled:opacity-50 disabled:cursor-not-allowed">Continue</button>
        WebElement Continuebtn = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
        Continuebtn.click();
        Thread.sleep(3000);

        // <button class="w-1/2 rounded-lg bg-blue-600 py-3 font-semibold text-white hover:bg-blue-700">
        // Confirm Transfer</button>
        WebElement ConfirmTransbtn = driver.findElement(By.xpath("//button[normalize-space()='Confirm Transfer']"));
        ConfirmTransbtn.click();
        Thread.sleep(3000);

        // Dashboard
        // <button class="flex w-full items-center gap-3 rounded-lg px-3 py-3 text-sm font-medium transition-colors
        // bg-blue-600 text-white shadow-md"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
        // viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
        // stroke-linejoin="round" class="lucide lucide-layout-dashboard h-5 w-5" aria-hidden="true">
        // <rect width="7" height="9" x="3" y="3" rx="1"></rect><rect width="7" height="5" x="14" y="3"
        // rx="1"></rect><rect width="7" height="9" x="14" y="12" rx="1"></rect><rect width="7" height="5"
        // x="3" y="16" rx="1"></rect></svg>Dashboard</button>
        WebElement Dashboardbtn = driver.findElement(By.xpath("//button[normalize-space()='Dashboard']"));
        Dashboardbtn.click();
        Thread.sleep(3000);

        //<h3 class="mt-2 text-3xl font-bold">$45,000.00</h3>
        String TotalBal = driver.findElement(By.xpath("//h3[contains(text(),'$')]")).getText();

        Assert.assertEquals(TotalBal, "$45,000.00");
        Thread.sleep(5000);
        System.out.println("Total balance is $45000.00");

        driver.quit();
    }
}
