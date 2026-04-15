package com.thetestingacademy.DataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenParallelTest_Ex {

    @DataProvider(name = "LoginData" , parallel = true) // by default parallel = false

    // If TC are dependent dont use parallel

    public Object[][] getData() {
        return new Object[][] {
                new Object[]{"admin@gmail.com", "pass123"},
                new Object[]{"admin123@gmail.com", "pass123"},
                new Object[]{"admin123@gmail.com", "pass124"}
        };
    }

    @Test(dataProvider = "LoginData")
    public void loginTest(String email, String password) {
        System.out.println(email + " | " + password);
    }
}